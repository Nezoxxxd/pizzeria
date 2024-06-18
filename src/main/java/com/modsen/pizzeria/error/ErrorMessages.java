package com.modsen.pizzeria.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorMessages {
    public static final String RESOURCE_NOT_FOUND_MESSAGE = "%s with id %d does not exist";
    public static final String DUPLICATE_RESOURCE_MESSAGE = "%s with this %s already exists";

    public static final String COMPLETED_OR_CANCELLED_STATUS_MESSAGE = "Cannot change status from COMPLETED or CANCELLED";
    public static final String FROM_PENDING_TO_PROCESSING_STATUS_MESSAGE = "Can only change status from PENDING to PROCESSING";
    public static final String FROM_PROCESSING_TO_COMPLETED_OR_CANCELLED_STATUS_MESSAGE = "Can only change status from PROCESSING to COMPLETED or CANCELLED";
}
