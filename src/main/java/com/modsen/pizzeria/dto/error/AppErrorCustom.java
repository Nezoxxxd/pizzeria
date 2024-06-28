package com.modsen.pizzeria.dto.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import java.util.Map;
import java.time.LocalDateTime;

@Builder
public record AppErrorCustom(

        @Schema(description = "HTTP status code", example = "400")
        int status,

        @Schema(description = "Error message", example = "Bad Request")
        String message,

        @Schema(description = "Timestamp of the error", example = "2024-06-28T08:26:53.025Z")
        LocalDateTime timestamp,

        Map<String, String> errors

) {}
