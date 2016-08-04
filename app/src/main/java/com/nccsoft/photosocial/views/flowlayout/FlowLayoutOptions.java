package com.nccsoft.photosocial.views.flowlayout;


class FlowLayoutOptions {
    static final int ITEM_PER_LINE_NO_LIMIT = 0;
    Alignment alignment = Alignment.LEFT;
    int itemsPerLine = ITEM_PER_LINE_NO_LIMIT;

    static FlowLayoutOptions clone(FlowLayoutOptions layoutOptions) {
        FlowLayoutOptions result = new FlowLayoutOptions();
        result.alignment = layoutOptions.alignment;
        result.itemsPerLine = layoutOptions.itemsPerLine;
        return result;
    }
}
