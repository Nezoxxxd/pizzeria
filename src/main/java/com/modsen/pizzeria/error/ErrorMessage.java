package com.modsen.pizzeria.error;

public class ErrorMessage {
    public static final String RESOURCE_NOT_FOUND = "%s with id %d does not exist";
    public static final String DUPLICATE_RESOURCE = "%s with this %s already exists";
    public static final String INVALID_DATA = "Invalid %s";

    public static final String COMPLETED_OR_CANCELLED_STATUS = "Cannot change status from COMPLETED or CANCELLED";
    public static final String FROM_PENDING_TO_PROCESSING_STATUS = "Can only change status from PENDING to PROCESSING";
    public static final String FROM_PROCESSING_TO_COMPLETED_OR_CANCELLED_STATUS = "Can only change status from PROCESSING to COMPLETED or CANCELLED";
}
