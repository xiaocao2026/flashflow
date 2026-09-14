package com.flashflow.common.exception;

/**
 * Common error codes shared across services.
 * Business-specific codes should be added when corresponding features are implemented.
 */
public enum ErrorCode {

    SUCCESS(0, "success"),
    BAD_REQUEST(400, "Bad request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not found"),
    INTERNAL_ERROR(500, "Internal server error"),
    BUSINESS_ERROR(1000, "Business error");

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
