package com.modsen.pizzeria.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AppError {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
