package com.modsen.pizzeria.dto.error;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class AppErrorCustom {
    private int status;
    private Map<String, String> errors;
    private LocalDateTime timestamp;
}