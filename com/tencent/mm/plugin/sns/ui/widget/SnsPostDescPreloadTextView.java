package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.c;
import com.tencent.mm.kiss.widget.textview.d;
import com.tencent.mm.kiss.widget.textview.f;

public class SnsPostDescPreloadTextView extends PLTextView {
    private static int hitCount = 0;
    private static int missCount = 0;
    public int qPA = 0;
    private boolean qPz = false;

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsPostDescPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final a vZ() {
        this.qPz = true;
        return c.blK().blJ();
    }

    public final void setMaxLines(int i) {
        boolean z = true;
        if (getText() == null) {
            super.setMaxLines(i);
        }
        if (i <= 6) {
            if (this.qPz) {
                b(c.blK().blL());
                this.qPz = false;
            }
            z = false;
        } else {
            if (!this.qPz) {
                b(c.blK().blJ());
                this.qPz = true;
            }
            z = false;
        }
        if (z) {
            f a = c.hag.a(vY(), getText());
            if (a == null) {
                int blM = this.qPA > 0 ? this.qPA : c.blK().blM();
                if (blM > 0) {
                    a = d.a(getText(), blM, vY()).vW();
                }
            }
            if (a != null) {
                b(a);
            }
        }
    }

    protected final void p(CharSequence charSequence) {
        super.p(charSequence);
        hitCount++;
    }

    protected final void o(CharSequence charSequence) {
        if (charSequence != null) {
            setText(d.a(getContext(), charSequence.toString(), vY().hbf), true);
        }
        missCount++;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
