package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;

public class SysTextView extends TextView implements a {
    private static boolean hba = false;
    private static Field hbb = null;
    public g haM = new g(this, new a());

    public SysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        super.setText(" ", BufferType.SPANNABLE);
        this.haM.haO = new a();
        this.haM.haO.textColor = super.getTextColors().getDefaultColor();
        this.haM.haO.haA = super.getEllipsize();
        this.haM.haO.gravity = super.getGravity();
        this.haM.haO.hbf = super.getTextSize();
        if (!hba) {
            try {
                if (hbb == null) {
                    Field declaredField = TextView.class.getDeclaredField("mSingleLine");
                    hbb = declaredField;
                    declaredField.setAccessible(true);
                }
                if (hbb.getBoolean(this)) {
                    this.haM.haO.maxLines = 1;
                }
            } catch (Exception e) {
                w.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", e.getMessage());
                hba = true;
            }
        }
    }

    protected final f wc() {
        if (this.haM == null) {
            return null;
        }
        return this.haM.wc();
    }

    public final a vY() {
        if (this.haM == null) {
            return null;
        }
        return this.haM.haO;
    }

    public void setSingleLine(boolean z) {
        if (this.haM != null) {
            this.haM.setSingleLine(z);
        }
    }

    public void setLines(int i) {
        if (this.haM != null) {
            this.haM.setLines(i);
        }
    }

    public boolean onPreDraw() {
        return true;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        q(charSequence);
    }

    public final void q(CharSequence charSequence) {
        if (this.haM == null) {
            super.setText("");
        } else {
            this.haM.setText(charSequence, false);
        }
    }

    public void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        if (this.haM != null) {
            this.haM.setTextSize(i, f);
        }
    }

    public void setTextColor(int i) {
        if (this.haM != null) {
            this.haM.setTextColor(i);
        }
    }

    public void setGravity(int i) {
        if (this.haM != null) {
            this.haM.setGravity(i);
        }
    }

    public void setMaxLines(int i) {
        if (this.haM != null) {
            this.haM.setMaxLines(i);
        }
    }

    public void setMinLines(int i) {
        if (this.haM != null) {
            g gVar = this.haM;
            if (gVar.haO.minLines != i) {
                gVar.haO.minLines = i;
                gVar.wd();
                gVar.haX.requestLayout();
                gVar.haX.invalidate();
            }
        }
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (this.haM != null) {
            this.haM.wd();
        }
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.haM != null) {
            this.haM.wd();
        }
        super.setPadding(i, i2, i3, i4);
    }

    public CharSequence getText() {
        if (this.haM == null) {
            return null;
        }
        return this.haM.getText();
    }

    public float getTextSize() {
        if (this.haM == null) {
            return 0.0f;
        }
        return this.haM.getTextSize();
    }

    public int getLineCount() {
        if (this.haM == null) {
            return 0;
        }
        return this.haM.getLineCount();
    }

    public int getLineHeight() {
        if (this.haM == null) {
            return 0;
        }
        return this.haM.getLineHeight();
    }

    public int getSelectionStart() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionStart(getText());
    }

    public int getSelectionEnd() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionEnd(getText());
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        if (this.haM != null) {
            this.haM.haU = z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.haM.wb() == null) {
            return false;
        }
        boolean q = this.haM.q(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (q) {
            return true;
        }
        return onTouchEvent;
    }

    public boolean performClick() {
        if (this.haM != null && this.haM.performClick()) {
            return super.performClick();
        }
        return false;
    }

    protected void onDraw(Canvas canvas) {
        try {
            if (this.haM != null) {
                this.haM.onDraw(canvas);
            }
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
        }
    }

    public final int vT() {
        if (this.haM == null) {
            return 0;
        }
        return this.haM.haR;
    }

    public final int vU() {
        if (this.haM == null) {
            return 0;
        }
        return this.haM.haS;
    }

    protected void onMeasure(int i, int i2) {
        try {
            Point aG = this.haM.aG(i, i2);
            if (aG != null) {
                setMeasuredDimension(aG.x, aG.y);
            } else {
                super.onMeasure(i, i2);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SysPLTextView", e, "onMeasure error: %s", e.getMessage());
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.SysPLTextView", e2, "", new Object[0]);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onProvideStructure(ViewStructure viewStructure) {
        try {
            super.onProvideStructure(viewStructure);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SysPLTextView", e, "onProvideStructure error: %s", e.getMessage());
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            return -1;
        }
    }
}
