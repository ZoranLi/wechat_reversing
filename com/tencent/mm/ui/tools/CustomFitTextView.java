package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public class CustomFitTextView extends TextView {
    public int maxLines;
    private Paint wlR;
    private String wlS;
    private Rect wlT = new Rect();
    private LinkedList<String> wlU = new LinkedList();
    public int wlV;
    private Drawable wlW;
    public boolean wlX;
    private boolean wlY = true;
    private int wlZ = 0;

    public CustomFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void c(String str, int i, boolean z, int i2) {
        b(str, i, z, i2, getCurrentTextColor());
    }

    public final void b(String str, int i, boolean z, int i2, int i3) {
        this.maxLines = i;
        this.wlS = str;
        if (this.wlS == null) {
            w.w("MicroMsg.CustomFitTextView", "ori text is null");
            this.wlS = "";
        }
        if (this.maxLines <= 0) {
            w.w("MicroMsg.CustomFitTextView", "maxLines is invalid");
            this.maxLines = 2;
        }
        this.wlZ = getResources().getDimensionPixelSize(e.aWA);
        this.wlX = z;
        this.wlV = i2;
        if (this.wlX) {
            this.wlW = getResources().getDrawable(this.wlV);
        }
        this.wlR = new Paint();
        this.wlR.set(getPaint());
        this.wlR.setAntiAlias(true);
        this.wlR.setColor(i3);
        cW(this.wlS, getWidth());
        setHeight(Math.max(bZI(), a.fromDPToPix(getContext(), 32)));
    }

    private int bZI() {
        FontMetrics fontMetrics = getPaint().getFontMetrics();
        return ((int) ((((fontMetrics.leading + (fontMetrics.bottom - fontMetrics.top)) * ((float) this.wlU.size())) + ((float) getPaddingTop())) + ((float) getPaddingBottom()))) + (Math.max(0, this.wlU.size() - 1) * this.wlZ);
    }

    private boolean cW(String str, int i) {
        if (!this.wlY || i <= 0 || str == null || "".equals(str)) {
            return false;
        }
        int ceil;
        this.wlU.clear();
        int i2 = 0;
        int length = str.length();
        int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
        int intrinsicWidth = this.wlX ? this.wlW.getIntrinsicWidth() : 0;
        float measureText = ((float) intrinsicWidth) + getPaint().measureText(str, 0, length);
        int i3 = this.maxLines;
        if (Float.compare(measureText, (float) (this.maxLines * paddingLeft)) < 0) {
            ceil = (int) Math.ceil((double) (measureText / ((float) paddingLeft)));
        } else {
            ceil = i3;
        }
        for (int i4 = 0; i4 < ceil; i4++) {
            if (i4 == ceil - 1) {
                Um(str.substring(i2, c(str, i2, length, intrinsicWidth, paddingLeft)).trim());
            } else {
                i3 = c(str, i2, length, 0, paddingLeft);
                Um(str.substring(i2, i3).trim());
                if (i3 >= length) {
                    w.w("MicroMsg.CustomFitTextView", "not match last line, but match text length end");
                    break;
                }
                i2 = i3;
            }
        }
        return true;
    }

    private void Um(String str) {
        if (this.wlU != null && str != null && !"".equals(str)) {
            this.wlU.add(str);
        }
    }

    private int c(String str, int i, int i2, int i3, int i4) {
        if (i2 <= i) {
            return i + 1;
        }
        if (getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            return i2;
        }
        int length = str.length();
        while (getPaint().measureText(str, i, i2) + ((float) i3) > ((float) i4)) {
            i2 = (i2 + i) >> 1;
        }
        while (i2 <= length && getPaint().measureText(str, i, i2) + ((float) i3) < ((float) i4)) {
            i2++;
        }
        int min = Math.min(length, i2) - 1;
        length = min;
        while (length >= 0 && bg.j(str.charAt(length))) {
            length--;
        }
        if (length < 0 || length == min) {
            return i2 - 1;
        }
        return length + 1;
    }

    protected void onDraw(Canvas canvas) {
        if (this.wlY && this.wlS != null && !"".equals(this.wlS) && this.wlU.size() != 0) {
            FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f = fontMetrics.descent - fontMetrics.ascent;
            float paddingLeft = (float) getPaddingLeft();
            float paddingTop = (float) getPaddingTop();
            Iterator it = this.wlU.iterator();
            float f2 = paddingTop;
            while (it.hasNext()) {
                float f3 = (fontMetrics.leading + f) + f2;
                canvas.drawText((String) it.next(), paddingLeft, f3, this.wlR);
                f2 = f3;
            }
            if (this.wlX) {
                getPaint().getTextBounds((String) this.wlU.getLast(), 0, ((String) this.wlU.getLast()).length(), this.wlT);
                int paddingLeft2 = getPaddingLeft() + this.wlT.right;
                int i = (int) ((f2 - f) - fontMetrics.leading);
                this.wlW.setBounds(paddingLeft2, i, this.wlW.getIntrinsicWidth() + paddingLeft2, this.wlW.getIntrinsicHeight() + i);
                this.wlW.draw(canvas);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = (i == i3 && i2 == i4) ? false : true;
        this.wlY = z;
        if (this.wlY) {
            cW(this.wlS, i);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = MeasureSpec.getSize(i);
        int fromDPToPix = a.fromDPToPix(getContext(), 32);
        if (cW(this.wlS, size)) {
            fromDPToPix = Math.max(bZI(), fromDPToPix);
        }
        setMeasuredDimension(size, fromDPToPix);
    }
}
