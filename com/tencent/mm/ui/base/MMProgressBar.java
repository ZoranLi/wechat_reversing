package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aj;

public class MMProgressBar extends LinearLayout {
    private int max = 100;
    private aj obY = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ MMProgressBar vlm;

        {
            this.vlm = r1;
        }

        public final boolean oQ() {
            int a = this.vlm.vlj - this.vlm.vli;
            if (a > 0) {
                int i = (int) (((double) a) * 0.6d);
                MMProgressBar mMProgressBar = this.vlm;
                int b = this.vlm.vli;
                if (i <= 0) {
                    i = 1;
                }
                mMProgressBar.vli = i + b;
                MMProgressBar.b(this.vlm, this.vlm.vli);
                long c = (long) (((this.vlm.max - a) * 40) / this.vlm.max);
                this.vlm.obY.v(c, c);
            }
            return false;
        }
    }, false);
    private TextView pvu;
    private int vli = 0;
    private int vlj = 0;
    private TextView vlk;
    public a vll;

    public interface a {
        void uF(int i);
    }

    static /* synthetic */ void b(MMProgressBar mMProgressBar, int i) {
        TextView textView = mMProgressBar.vlk;
        int width = (mMProgressBar.getWidth() * mMProgressBar.vli) / mMProgressBar.max;
        if (width < b.a(mMProgressBar.getContext(), 20.0f)) {
            width = b.a(mMProgressBar.getContext(), 20.0f);
        }
        textView.setWidth(width);
        if (mMProgressBar.vll != null) {
            mMProgressBar.vll.uF(i);
        }
    }

    public MMProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(getContext(), h.heC, this);
        this.vlk = (TextView) findViewById(g.hcG);
        this.pvu = (TextView) findViewById(g.hcH);
    }

    public final void setProgress(int i) {
        if (i > this.max) {
            i = this.max;
        }
        this.vlj = i;
        if (this.obY.bJq()) {
            kN(true);
        }
    }

    public final void kN(boolean z) {
        if (z) {
            this.obY.v(40, 40);
        } else {
            this.obY.KH();
        }
    }
}
