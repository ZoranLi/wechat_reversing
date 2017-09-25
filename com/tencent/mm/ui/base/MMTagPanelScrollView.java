package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.s.a.e;
import com.tencent.mm.sdk.platformtools.w;

public class MMTagPanelScrollView extends ScrollView {
    private Runnable lKg = new Runnable(this) {
        final /* synthetic */ MMTagPanelScrollView vne;

        {
            this.vne = r1;
        }

        public final void run() {
            this.vne.scrollTo(0, this.vne.getBottom());
        }
    };
    private int lKi = 0;
    private a vnc = new a();
    public int vnd = 2;

    private static class a implements Runnable {
        public MMTagPanel vnf;

        public final void run() {
            if (this.vnf != null) {
                this.vnf.bSw();
            }
            this.vnf = null;
        }
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof MMTagPanel)) {
            MMTagPanel mMTagPanel = (MMTagPanel) getChildAt(0);
            boolean bSv = mMTagPanel.bSv();
            if (mMTagPanel.vgK.size() == this.vnd) {
                this.lKi = mMTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(e.aXT);
            }
            if (mMTagPanel.vgK.size() >= this.vnd) {
                int size = MeasureSpec.getSize(i);
                w.d("MicroMsg.FavTagPanelScrollView", "height %d", Integer.valueOf(Math.max(mMTagPanel.zK(this.vnd), this.lKi)));
                setMeasuredDimension(size, r3);
                if (bSv) {
                    this.vnc.vnf = mMTagPanel;
                    removeCallbacks(this.vnc);
                    post(this.vnc);
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        scrollBy(0, i4);
    }
}
