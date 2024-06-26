package com.modsen.pizzeria.auth;

import com.modsen.pizzeria.domain.RoleName;
import com.modsen.pizzeria.domain.User;
import com.modsen.pizzeria.error.ErrorMessages;
import com.modsen.pizzeria.exception.AccessDeniedException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static com.modsen.pizzeria.domain.RoleName.ADMIN;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckEmailMatchAspect {

    private final UserRepository userRepository;

    @Pointcut("@annotation(com.modsen.pizzeria.auth.EmailMatchOrAdminAccess)")
    public void checkEmailMatch() {
    }

    @Before("checkEmailMatch() && args(userId,..)")
    public void before(JoinPoint joinPoint, Long userId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        var userAuthorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();
        User userToOperate = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE, "User", userId)));

        if (!currentUserEmail.equals(userToOperate.getEmail()) && !userAuthorities.contains("ROLE_" + ADMIN.name())) {
            throw new AccessDeniedException(ErrorMessages.PERFORMING_ERROR_MESSAGE);
        }
    }
}
