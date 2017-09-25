package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.sdk.platformtools.w;

public abstract class b extends i {
    public b(Context context, c cVar, ViewGroup viewGroup) {
        super(context, cVar, viewGroup);
    }

    protected final void a(LinearLayout linearLayout) {
        c cVar = (c) this.qib;
        if (linearLayout != null) {
            int i = (int) cVar.qfe;
            int i2 = (int) cVar.qff;
            if (Double.compare(cVar.qfe, cVar.qff) != 0) {
                if (i == 0 && cVar.qfe != 0.0d) {
                    i = 1;
                }
                if (i2 == 0 && cVar.qff != 0.0d) {
                    i2 = 1;
                }
            } else if (i == 0) {
                i2 = 1;
                i = 1;
            }
            w.i("AdLandingBorderedComp", "border width top %d,bottom %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            View linearLayout2 = new LinearLayout(linearLayout.getContext());
            linearLayout2.setBackgroundColor(cVar.qfg);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
            layoutParams.gravity = 48;
            linearLayout.addView(linearLayout2, 0, layoutParams);
            linearLayout2 = new LinearLayout(linearLayout.getContext());
            linearLayout2.setBackgroundColor(cVar.qfg);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i2);
            layoutParams2.gravity = 80;
            linearLayout.addView(linearLayout2, layoutParams2);
        }
    }
}
