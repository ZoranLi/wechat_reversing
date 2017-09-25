package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.mogic.WxViewPager;

public class CustomViewPager extends WxViewPager {
    public boolean DC = true;

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.DC) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.DC) {
            try {
                z = super.onTouchEvent(motionEvent);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CustomViewPager", e, "get a Exception", new Object[z]);
            }
        }
        return z;
    }
}
