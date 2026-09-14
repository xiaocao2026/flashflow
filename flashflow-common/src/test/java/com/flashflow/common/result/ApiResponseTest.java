package com.flashflow.common.result;

import com.flashflow.common.exception.ErrorCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ApiResponseTest {

    @Test
    void successWithoutData() {
        ApiResponse<Void> response = ApiResponse.success();

        assertEquals(ErrorCode.SUCCESS.getCode(), response.getCode());
        assertEquals(ErrorCode.SUCCESS.getMessage(), response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void successWithData() {
        ApiResponse<String> response = ApiResponse.success("ok");

        assertEquals(ErrorCode.SUCCESS.getCode(), response.getCode());
        assertEquals("ok", response.getData());
    }

    @Test
    void failWithErrorCode() {
        ApiResponse<Void> response = ApiResponse.fail(ErrorCode.NOT_FOUND);

        assertEquals(ErrorCode.NOT_FOUND.getCode(), response.getCode());
        assertEquals(ErrorCode.NOT_FOUND.getMessage(), response.getMessage());
        assertNull(response.getData());
    }

    @Test
    void failWithCodeAndMessage() {
        ApiResponse<Void> response = ApiResponse.fail(1001, "custom");

        assertEquals(1001, response.getCode());
        assertEquals("custom", response.getMessage());
        assertNull(response.getData());
    }
}
