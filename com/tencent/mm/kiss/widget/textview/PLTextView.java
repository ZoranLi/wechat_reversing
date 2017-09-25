package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class PLTextView extends StaticTextView {
    private static long hai = 0;
    private static int haj = 0;
    private static long hak = -2147483648L;
    private static long hal = 0;
    private static int ham = 0;
    private static long han = -2147483648L;
    private static long hao = 0;
    private static int hap = 0;
    private static long haq = -2147483648L;
    private static boolean har = false;

    public PLTextView(Context context) {
        super(context);
    }

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(CharSequence charSequence) {
        long j = 0;
        if (!bg.J(charSequence)) {
            long currentTimeMillis;
            boolean z;
            if (h.DEBUG) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                currentTimeMillis = 0;
            }
            if (wc() != null && wc().haI) {
                c.hag.a(vY(), wc());
            }
            f a = c.hag.a(vY(), charSequence);
            if (a != null) {
                p(charSequence);
                b(a);
                z = true;
            } else {
                o(charSequence);
                z = false;
            }
            if (h.DEBUG) {
                j = System.currentTimeMillis();
                w.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[]{Double.valueOf(((double) (j - currentTimeMillis)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z)});
            }
            if (har) {
                currentTimeMillis = j - currentTimeMillis;
                hai += currentTimeMillis;
                haj++;
                if (currentTimeMillis > hak) {
                    hak = currentTimeMillis;
                }
            }
        } else if (h.DEBUG) {
            w.d("MicroMsg.PLTextView", "set null text");
        }
    }

    public void onMeasure(int i, int i2) {
        long j = 0;
        if (har) {
            j = System.currentTimeMillis();
        }
        super.onMeasure(i, i2);
        if (har) {
            j = System.currentTimeMillis() - j;
            hal += j;
            ham++;
            if (j > han) {
                han = j;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        if (har) {
            j = System.currentTimeMillis();
        }
        super.onDraw(canvas);
        if (har) {
            j = System.currentTimeMillis() - j;
            hao += j;
            hap++;
            if (j > haq) {
                haq = j;
            }
        }
    }

    public void o(CharSequence charSequence) {
        super.setText(charSequence, false);
    }

    public void p(CharSequence charSequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (wc() != null) {
            wc().haI = false;
        }
    }
}
