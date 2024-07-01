package com.modsen.pizzeria.aspect;

import com.modsen.pizzeria.domain.Order;
import com.modsen.pizzeria.exception.AccessDeniedException;
import com.modsen.pizzeria.exception.ResourceNotFoundException;
import com.modsen.pizzeria.repository.OrderRepository;
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
import static com.modsen.pizzeria.error.ErrorMessages.ACCESS_DENIED_ERROR_MESSAGE;
import static com.modsen.pizzeria.error.ErrorMessages.RESOURCE_NOT_FOUND_MESSAGE;

@Aspect
@Component
@RequiredArgsConstructor
public class CheckOrderOwnerAspect {

    private final OrderRepository orderRepository;

    @Pointcut("@annotation(com.modsen.pizzeria.aspect.annotation.OrderOwnerOrAdminAccess)")
    public void checkOrderOwner() {
    }

    @Before("checkOrderOwner() && args(orderId,..)")
    public void before(JoinPoint joinPoint, Long orderId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();

        var userAuthorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(RESOURCE_NOT_FOUND_MESSAGE, "Order", orderId)
                ));

        if (!currentUserEmail.equals(order.getUser().getEmail())
                && !userAuthorities.contains("ROLE_" + ADMIN.name())) {
            throw new AccessDeniedException(ACCESS_DENIED_ERROR_MESSAGE);
        }
    }
}
