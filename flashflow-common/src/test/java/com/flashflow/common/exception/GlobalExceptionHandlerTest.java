package com.flashflow.common.exception;

import com.flashflow.common.result.ApiResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handleBusinessExceptionReturnsFailResponse() {
        BusinessException ex = new BusinessException(ErrorCode.BAD_REQUEST, "invalid arg");

        ApiResponse<Void> response = handler.handleBusinessException(ex);

        assertEquals(ErrorCode.BAD_REQUEST.getCode(), response.getCode());
        assertEquals("invalid arg", response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void handleExceptionReturnsInternalError() {
        ApiResponse<Void> response = handler.handleException(new RuntimeException("boom"));

        assertEquals(ErrorCode.INTERNAL_ERROR.getCode(), response.getCode());
        assertEquals(ErrorCode.INTERNAL_ERROR.getMessage(), response.getMessage());
        assertNull(response.getData());
    }
}
