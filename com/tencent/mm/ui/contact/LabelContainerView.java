package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.base.MMTagPanelScrollView;

public class LabelContainerView extends MMTagPanelScrollView {
    boolean vXW = false;
    boolean vXX = true;
    boolean vXY = false;
    float vXZ;
    float vYa;
    float vYb;
    float vYc;
    public a vYd;
    boolean wL = true;
    float wQ;
    float wR;
    float wS;
    float wT;
    private int wz;

    public interface a {
        void aoG();

        void aoH();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bYa();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bYa();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.vXX = true;
                this.vYa = f2;
                this.vXZ = f2;
                this.vYc = f3;
                this.vYb = f3;
                this.vXY = true;
                break;
            case 1:
            case 3:
                this.vXX = true;
                this.vXY = false;
                break;
            case 2:
                int i2 = (int) (f2 - this.vXZ);
                actionIndex = (int) (f3 - this.vYb);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.wz) {
                    this.vXX = false;
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void bYa() {
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.wz = scaledTouchSlop * scaledTouchSlop;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        int action = motionEvent.getAction();
        boolean z = (action & 255) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.wL = true;
                this.wQ = f2;
                this.wS = f2;
                this.wR = f3;
                this.wT = f3;
                this.vXW = true;
                break;
            case 1:
            case 3:
                if ((this.wL || !this.vXW) && this.vYd != null) {
                    this.vYd.aoG();
                }
                this.wL = true;
                this.vXW = false;
                break;
            case 2:
                if (!this.vXW) {
                    this.wL = true;
                    this.wQ = f2;
                    this.wS = f2;
                    this.wR = f3;
                    this.wT = f3;
                    this.vXW = true;
                }
                if (this.vYd != null) {
                    this.vYd.aoH();
                }
                int i2 = (int) (f2 - this.wS);
                actionIndex = (int) (f3 - this.wT);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.wz) {
                    this.wL = false;
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
