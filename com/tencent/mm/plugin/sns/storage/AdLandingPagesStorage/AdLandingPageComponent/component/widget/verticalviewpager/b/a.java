package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b;

import android.support.v4.view.ViewPager.f;
import android.view.View;

public final class a implements f {
    public final void h(View view, float f) {
        float f2 = 0.0f;
        if (0.0f <= f && f <= 1.0f) {
            f2 = 1.0f - f;
        } else if (-1.0f < f && f < 0.0f) {
            f2 = f + 1.0f;
        }
        view.setAlpha(f2);
        view.setTranslationX(((float) view.getWidth()) * (-f));
        view.setTranslationY(((float) view.getHeight()) * f);
    }
}
