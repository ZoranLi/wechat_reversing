package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.w;

public class MMAutoSizeTextView extends TextView {
    private float mGK;
    private Paint nt;
    private float viB;
    private float viC;

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMAutoSizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        setSingleLine();
        setEllipsize(TruncateAt.END);
        this.viB = (float) a.fromDPToPix(getContext(), 8);
        this.viC = (float) a.fromDPToPix(getContext(), 22);
        this.nt = new Paint();
        this.nt.set(getPaint());
        bRN();
    }

    private void cL(String str, int i) {
        w.i("MicroMsg.MMAutoSizeTextView", "autoAdjustTextSize[text=%s, viewWidth=%d]", new Object[]{str, Integer.valueOf(i)});
        if (i > 0) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            bRN();
            float f = this.mGK;
            this.nt.setTextSize(f);
            while (f > this.viB && this.nt.measureText(str) > ((float) paddingLeft)) {
                f -= 1.0f;
                if (f <= this.viB) {
                    f = this.viB;
                    break;
                }
                this.nt.setTextSize(f);
            }
            w.i("MicroMsg.MMAutoSizeTextView", "try size[%f], maxSize[%f], measureTextSize[%f], availableWidth[%d]", new Object[]{Float.valueOf(f), Float.valueOf(this.mGK), Float.valueOf(this.nt.measureText(str)), Integer.valueOf(paddingLeft)});
            setTextSize(0, f);
        }
    }

    private void bRN() {
        this.mGK = getTextSize();
        if (this.mGK <= this.viB) {
            this.mGK = this.viC;
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        w.w("MicroMsg.MMAutoSizeTextView", "on text changed");
        super.onTextChanged(charSequence, i, i2, i3);
        cL(charSequence.toString(), getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        w.w("MicroMsg.MMAutoSizeTextView", "on size changed");
        if (i != i3) {
            cL(getText().toString(), i);
        }
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMAutoSizeTextView", th, "", new Object[0]);
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
