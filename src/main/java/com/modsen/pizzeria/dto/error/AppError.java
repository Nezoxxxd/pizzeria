package com.modsen.pizzeria.dto.error;

import java.time.LocalDateTime;

public record AppError(int status, String message, LocalDateTime timestamp) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int status;
        private String message;
        private LocalDateTime timestamp;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public AppError build() {
            if (this.timestamp == null) {
                this.timestamp = LocalDateTime.now();
            }
            return new AppError(this.status, this.message, this.timestamp);
        }
    }
}
