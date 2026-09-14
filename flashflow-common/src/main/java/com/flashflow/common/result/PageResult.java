package com.flashflow.common.result;

import java.util.Collections;
import java.util.List;

/**
 * Paginated query result wrapper.
 */
public class PageResult<T> {

    private final List<T> records;
    private final long total;
    private final long page;
    private final long size;

    private PageResult(List<T> records, long total, long page, long size) {
        this.records = records == null ? List.of() : List.copyOf(records);
        this.total = total;
        this.page = page;
        this.size = size;
    }

    public static <T> PageResult<T> of(List<T> records, long total, long page, long size) {
        return new PageResult<>(records, total, page, size);
    }

    public static <T> PageResult<T> empty(long page, long size) {
        return new PageResult<>(Collections.emptyList(), 0L, page, size);
    }

    public List<T> getRecords() {
        return records;
    }

    public long getTotal() {
        return total;
    }

    public long getPage() {
        return page;
    }

    public long getSize() {
        return size;
    }
}
