package com.nccsoft.photosocial.views.flowlayout;

class LayoutContext {
    FlowLayoutOptions layoutOptions;
    int currentLineItemCount;

    static LayoutContext clone(LayoutContext layoutContext) {
        LayoutContext resultContext = new LayoutContext();
        resultContext.currentLineItemCount = layoutContext.currentLineItemCount;
        resultContext.layoutOptions = FlowLayoutOptions.clone(layoutContext.layoutOptions);
        return resultContext;
    }

    static LayoutContext fromLayoutOptions(FlowLayoutOptions layoutOptions) {
        LayoutContext layoutContext = new LayoutContext();
        layoutContext.layoutOptions = layoutOptions;
        return layoutContext;
    }
}
