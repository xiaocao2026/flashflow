package com.flashflow.common.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ErrorCodeTest {

    @Test
    void successCodeIsZero() {
        assertEquals(0, ErrorCode.SUCCESS.getCode());
        assertEquals("success", ErrorCode.SUCCESS.getMessage());
    }

    @Test
    void codesAreUnique() {
        long distinctCount = java.util.Arrays.stream(ErrorCode.values())
                .map(ErrorCode::getCode)
                .distinct()
                .count();

        assertEquals(ErrorCode.values().length, distinctCount);
    }

    @Test
    void businessErrorUsesNonHttpRange() {
        assertTrue(ErrorCode.BUSINESS_ERROR.getCode() >= 1000);
    }
}
