package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;

public class AppBrandDotPercentIndicator extends LinearLayout {
    LayoutInflater Du;
    int iVO;

    public AppBrandDotPercentIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandDotPercentIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.Du = LayoutInflater.from(context);
    }

    public final void K(float f) {
        float f2 = 1.0f;
        float f3 = 0.0f;
        if (f >= 0.0f) {
            f3 = f;
        }
        if (f3 <= 1.0f) {
            f2 = f3;
        }
        w.v("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[]{Float.valueOf(f2), Integer.valueOf((int) Math.rint((double) (((float) this.iVO) * f2)))});
        int i = 0;
        while (i < r3 && i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.g.bca);
            i++;
        }
        while (i < getChildCount()) {
            ((ImageView) getChildAt(i)).setImageResource(R.g.bbZ);
            i++;
        }
    }
}
