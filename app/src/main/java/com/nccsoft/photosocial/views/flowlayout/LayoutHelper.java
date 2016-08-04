package com.nccsoft.photosocial.views.flowlayout;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;

class LayoutHelper {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;

    LayoutHelper(RecyclerView.LayoutManager layoutManager, RecyclerView recyclerView) {
        this.layoutManager = layoutManager;
        this.recyclerView = recyclerView;
    }

    private int leftVisibleEdge() {
        return recyclerView.getPaddingLeft();
    }

    private int rightVisibleEdge() {
        return layoutManager.getWidth() - layoutManager.getPaddingRight();
    }

    int visibleAreaWidth() {
        return rightVisibleEdge() - leftVisibleEdge();
    }

    private int topVisibleEdge() {
        return layoutManager.getPaddingTop();
    }

    public int bottomVisibleEdge() {
        return layoutManager.getHeight() - layoutManager.getPaddingBottom();
    }

    static boolean hasItemsPerLineLimit(FlowLayoutOptions layoutOptions) {
        return layoutOptions.itemsPerLine > 0;
    }

    static boolean shouldStartNewline(int x, int childWidth, int leftEdge, int rightEdge, LayoutContext layoutContext) {
        if (hasItemsPerLineLimit(layoutContext.layoutOptions) && layoutContext.currentLineItemCount == layoutContext.layoutOptions.itemsPerLine) {
            return true;
        }
        switch (layoutContext.layoutOptions.alignment) {
            case RIGHT:
                return x - childWidth < leftEdge;
            case LEFT:
            default:
                return x + childWidth > rightEdge;
        }
    }

    Point layoutStartPoint(LayoutContext layoutContext) {
        switch (layoutContext.layoutOptions.alignment) {
            case RIGHT:
                return new Point(rightVisibleEdge(), topVisibleEdge());
            default:
                return new Point(leftVisibleEdge(), topVisibleEdge());
        }
    }
}
