package com.modsen.pizzeria.dto.error;

import lombok.Builder;
import java.util.Map;
import java.time.LocalDateTime;

@Builder
public record AppErrorCustom(int status, String message, LocalDateTime timestamp, Map<String, String> errors) {
}