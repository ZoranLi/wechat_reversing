package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public final class a {
    View qlX;
    int qlY;
    LayoutParams qlZ = ((LayoutParams) this.qlX.getLayoutParams());

    public a(Activity activity) {
        this.qlX = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.qlX.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ a qma;

            {
                this.qma = r1;
            }

            public final void onGlobalLayout() {
                a aVar = this.qma;
                Rect rect = new Rect();
                aVar.qlX.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom - rect.top;
                if (i != aVar.qlY) {
                    int height = aVar.qlX.getRootView().getHeight();
                    int i2 = height - i;
                    if (i2 > height / 4) {
                        aVar.qlZ.height = height - i2;
                    } else {
                        aVar.qlZ.height = height;
                    }
                    aVar.qlX.requestLayout();
                    aVar.qlY = i;
                }
            }
        });
    }
}
