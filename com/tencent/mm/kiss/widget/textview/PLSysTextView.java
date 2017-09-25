package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class PLSysTextView extends SysTextView {
    public PLSysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLSysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        if (!bg.J(charSequence)) {
            boolean z;
            long j = 0;
            if (h.DEBUG) {
                j = System.currentTimeMillis();
            }
            if (wc() != null && wc().haI) {
                c.hag.a(vY(), wc());
            }
            f a = c.hag.a(vY(), charSequence);
            if (a != null) {
                if (this.haM != null) {
                    this.haM.b(a);
                }
                z = true;
            } else {
                super.q(charSequence);
                z = false;
            }
            if (h.DEBUG) {
                w.d("MicroMsg.PLSysTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s", new Object[]{Double.valueOf(((double) (System.currentTimeMillis() - j)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence});
            }
        } else if (h.DEBUG) {
            w.d("MicroMsg.PLSysTextView", "set null text");
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (wc() != null) {
            wc().haI = false;
        }
    }

    public boolean onPreDraw() {
        return true;
    }
}
