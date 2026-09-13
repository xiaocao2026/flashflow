package com.flashflow.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlashFlowTest {

    @Test
    void nameIsFlashFlow() {
        assertEquals("FlashFlow", FlashFlow.NAME);
    }
}
