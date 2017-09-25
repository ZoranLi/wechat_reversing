package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class CustomerScrollView extends ScrollView {
    private float wEU;
    private float wEV;
    private float wEW;
    private float wEX;

    public CustomerScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomerScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.wEV = 0.0f;
                this.wEU = 0.0f;
                this.wEW = motionEvent.getX();
                this.wEX = motionEvent.getY();
                break;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.wEU += Math.abs(x - this.wEW);
                this.wEV += Math.abs(y - this.wEX);
                this.wEW = x;
                this.wEX = y;
                if (this.wEU > this.wEV) {
                    return false;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
