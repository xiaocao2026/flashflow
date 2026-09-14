package com.flashflow.common.result;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PageResultTest {

    @Test
    void ofCopiesRecordsAndKeepsPagingMeta() {
        PageResult<String> page = PageResult.of(List.of("a", "b"), 10L, 1L, 2L);

        assertEquals(List.of("a", "b"), page.getRecords());
        assertEquals(10L, page.getTotal());
        assertEquals(1L, page.getPage());
        assertEquals(2L, page.getSize());
    }

    @Test
    void ofTreatsNullRecordsAsEmpty() {
        PageResult<String> page = PageResult.of(null, 0L, 1L, 10L);

        assertTrue(page.getRecords().isEmpty());
        assertEquals(0L, page.getTotal());
    }

    @Test
    void emptyCreatesZeroTotalPage() {
        PageResult<String> page = PageResult.empty(2L, 20L);

        assertTrue(page.getRecords().isEmpty());
        assertEquals(0L, page.getTotal());
        assertEquals(2L, page.getPage());
        assertEquals(20L, page.getSize());
    }

    @Test
    void recordsAreUnmodifiable() {
        PageResult<String> page = PageResult.of(List.of("a"), 1L, 1L, 1L);

        assertThrows(UnsupportedOperationException.class, () -> page.getRecords().add("b"));
    }
}
