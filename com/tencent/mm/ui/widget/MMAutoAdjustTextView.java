package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.bm.a.c;
import com.tencent.mm.bm.a.j;

public class MMAutoAdjustTextView extends TextView {
    private float hbf;
    private Paint nt;
    private float omC;
    private float wuB;
    private boolean wuC = true;

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context.obtainStyledAttributes(attributeSet, j.fqE));
        init();
    }

    public MMAutoAdjustTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context.obtainStyledAttributes(attributeSet, j.fqE));
        init();
    }

    private void init() {
        this.wuB = (float) a.T(getContext(), c.aXW);
        this.hbf = getTextSize();
        this.omC = a.dI(getContext());
        this.nt = new Paint();
        this.nt.set(getPaint());
    }

    private void b(TypedArray typedArray) {
        if (typedArray != null) {
            this.wuC = typedArray.getBoolean(j.wBm, true);
            typedArray.recycle();
        }
    }

    private void Cq(int i) {
        if (i > 0) {
            measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
            float measuredWidth = (float) getMeasuredWidth();
            while (measuredWidth > ((float) i)) {
                this.hbf -= a.getDensity(getContext());
                setTextSize(0, this.hbf * this.omC);
                measure(0, MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                measuredWidth = (float) getMeasuredWidth();
            }
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        charSequence.toString();
        Cq(getWidth());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            getText().toString();
            Cq(i);
        }
    }
}
