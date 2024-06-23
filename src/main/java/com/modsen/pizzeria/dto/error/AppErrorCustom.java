package com.modsen.pizzeria.dto.error;

import java.time.LocalDateTime;
import java.util.Map;

public record AppErrorCustom(int status, Map<String, String> message, LocalDateTime timestamp) {

    public static class Builder {
        private int status;
        private Map<String, String> message;
        private LocalDateTime timestamp;

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder message(Map<String, String> message) {
            this.message = message;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public AppErrorCustom build() {
            if (this.timestamp == null) {
                this.timestamp = LocalDateTime.now();
            }
            return new AppErrorCustom(this.status, this.message, this.timestamp);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}