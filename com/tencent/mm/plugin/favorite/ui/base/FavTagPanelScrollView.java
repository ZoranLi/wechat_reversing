package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

public class FavTagPanelScrollView extends ScrollView {
    private Runnable lKg = new Runnable(this) {
        final /* synthetic */ FavTagPanelScrollView lKj;

        {
            this.lKj = r1;
        }

        public final void run() {
            this.lKj.fullScroll(130);
        }
    };
    private a lKh = new a();
    private int lKi = 0;

    private static class a implements Runnable {
        public FavTagPanel lKk;

        public final void run() {
            if (this.lKk != null) {
                this.lKk.bSw();
            }
            this.lKk = null;
        }
    }

    public FavTagPanelScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavTagPanelScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getChildCount() > 0 && (getChildAt(0) instanceof FavTagPanel)) {
            FavTagPanel favTagPanel = (FavTagPanel) getChildAt(0);
            boolean bSv = favTagPanel.bSv();
            if (favTagPanel.vgK.size() == 2) {
                this.lKi = favTagPanel.getMeasuredHeight() + getResources().getDimensionPixelOffset(R.f.aXT);
            }
            if (favTagPanel.vgK.size() >= 2) {
                int size = MeasureSpec.getSize(i);
                w.d("MicroMsg.FavTagPanelScrollView", "height %d", new Object[]{Integer.valueOf(Math.max(favTagPanel.zK(2), this.lKi))});
                setMeasuredDimension(size, r3);
                removeCallbacks(this.lKg);
                post(this.lKg);
                if (bSv) {
                    this.lKh.lKk = favTagPanel;
                    removeCallbacks(this.lKh);
                    post(this.lKh);
                }
            }
        }
    }
}
