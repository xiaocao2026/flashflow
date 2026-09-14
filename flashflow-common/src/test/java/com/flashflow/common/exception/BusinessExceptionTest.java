package com.flashflow.common.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class BusinessExceptionTest {

    @Test
    void fromErrorCodeUsesDefaultMessage() {
        BusinessException ex = new BusinessException(ErrorCode.NOT_FOUND);

        assertEquals(ErrorCode.NOT_FOUND.getCode(), ex.getCode());
        assertEquals(ErrorCode.NOT_FOUND.getMessage(), ex.getMessage());
        assertInstanceOf(RuntimeException.class, ex);
    }

    @Test
    void fromErrorCodeWithCustomMessage() {
        BusinessException ex = new BusinessException(ErrorCode.BUSINESS_ERROR, "stock insufficient");

        assertEquals(ErrorCode.BUSINESS_ERROR.getCode(), ex.getCode());
        assertEquals("stock insufficient", ex.getMessage());
    }

    @Test
    void fromRawCodeAndMessage() {
        BusinessException ex = new BusinessException(2001, "custom failure");

        assertEquals(2001, ex.getCode());
        assertEquals("custom failure", ex.getMessage());
    }
}
