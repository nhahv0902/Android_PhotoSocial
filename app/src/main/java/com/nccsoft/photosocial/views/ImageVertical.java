package com.nccsoft.photosocial.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Nhahv on 8/3/2016.
 * <></>
 */

public class ImageVertical extends ImageView {

    private float whRatio = 0;

    public ImageVertical(Context context) {
        super(context);
    }

    public ImageVertical(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageVertical(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setRatio(float ratio) {
        whRatio = ratio;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (whRatio != 0) {
            int height = getMeasuredHeight();
            int width = (int) (height / whRatio);
            setMeasuredDimension(width, height);
        }
    }
}
