package com.modsen.pizzeria.dto.error;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class AppError {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}