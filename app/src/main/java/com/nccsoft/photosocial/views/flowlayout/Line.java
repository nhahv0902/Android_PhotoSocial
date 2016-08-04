package com.nccsoft.photosocial.views.flowlayout;


class Line {

    int itemCount;
    int totalWidth;
    int maxHeight;
    int maxHeightIndex;

    static final Line EMPTY_LINE = new Line();

    Line() {
        itemCount = 0;
        totalWidth = 0;
        maxHeight = 0;
        maxHeightIndex = -1;

    }

    public Line clone() {
        Line clone = new Line();
        clone.itemCount = itemCount;
        clone.totalWidth = totalWidth;
        clone.maxHeight = maxHeight;
        clone.maxHeightIndex = maxHeightIndex;
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return itemCount == line.itemCount
                && totalWidth == line.totalWidth
                && maxHeight == line.maxHeight
                && maxHeightIndex == line.maxHeightIndex;
    }

    @Override
    public int hashCode() {
        int result = itemCount;
        result = 31 * result + totalWidth;
        result = 31 * result + maxHeight;
        result = 31 * result + maxHeightIndex;
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "itemCount=" + itemCount +
                ", totalWidth=" + totalWidth +
                ", maxHeight=" + maxHeight +
                ", maxHeightIndex=" + maxHeightIndex +
                '}';
    }
}
