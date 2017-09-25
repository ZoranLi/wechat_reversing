package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import java.util.HashSet;
import java.util.Set;

public class AdlandingDummyViewPager extends DummyViewPager {
    private a qlp = new a(this);
    public Set<e> qlq = new HashSet();

    private class a implements e {
        final /* synthetic */ AdlandingDummyViewPager qlr;

        public a(AdlandingDummyViewPager adlandingDummyViewPager) {
            this.qlr = adlandingDummyViewPager;
        }

        public final void a(int i, float f, int i2) {
            for (e a : this.qlr.qlq) {
                a.a(i, f, i2);
            }
        }

        public final void V(int i) {
            for (e V : this.qlr.qlq) {
                V.V(i);
            }
        }

        public final void W(int i) {
            if (i == 0) {
                this.qlr.qls = this.qlr.getScrollX();
            }
            for (e W : this.qlr.qlq) {
                W.W(i);
            }
        }
    }

    public AdlandingDummyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
