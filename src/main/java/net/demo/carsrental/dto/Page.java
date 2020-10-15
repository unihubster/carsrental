package net.demo.carsrental.dto;

public class Page {
    private final long cursor;
    private final int pageSize;

    public Page(long cursor, int pageSize) {
        this.cursor = cursor;
        this.pageSize = pageSize;
    }

    public long getCursor() {
        return cursor;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "cursor=" + cursor +
                ", pageSize=" + pageSize +
                '}';
    }
}
