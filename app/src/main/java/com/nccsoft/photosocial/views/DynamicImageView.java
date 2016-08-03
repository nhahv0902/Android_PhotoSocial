package com.nccsoft.photosocial.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Nhahv on 8/3/2016.
 * <></>
 */

public class DynamicImageView extends ImageView {

    private float whRatio = 0;

    public DynamicImageView(Context context) {
        super(context);
    }

    public DynamicImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRatio(float ratio) {
        whRatio = ratio;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (whRatio != 0) {
            int width = getMeasuredWidth();
            int height = (int) (whRatio * width);
            setMeasuredDimension(width, height);
        }
    }
}
