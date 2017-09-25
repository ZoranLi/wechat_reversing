package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.w;

public class ChatFooterBottom extends FrameLayout {
    boolean fXD = false;

    public ChatFooterBottom(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatFooterBottom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        w.d("MicroMsg.ChatFooterBottom", "jacks onMeasure  width:%d, height:%d, isHide: %B", Integer.valueOf(MeasureSpec.getSize(i)), Integer.valueOf(MeasureSpec.getSize(i2)), Boolean.valueOf(this.fXD));
        if (this.fXD) {
            setVisibility(8);
            i = MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w.d("MicroMsg.ChatFooterBottom", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        w.d("MicroMsg.ChatFooterBottom", "jacks onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.fXD = false;
        }
        super.setVisibility(i);
    }
}
