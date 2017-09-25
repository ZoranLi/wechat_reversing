package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.ViewPager.h;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b.a;
import java.io.Serializable;

public class DummyViewPager extends AdLandingViewPager implements Serializable {
    protected int qls;

    public DummyViewPager(Context context, AttributeSet attributeSet) {
        int i = 0;
        super(context, attributeSet);
        f aVar = new a();
        if (VERSION.SDK_INT >= 11) {
            if (1 != (this.ze != null ? 1 : 0)) {
                i = 1;
            }
            this.ze = aVar;
            if (VERSION.SDK_INT >= 7) {
                if (this.qlm == null) {
                    try {
                        this.qlm = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                    } catch (NoSuchMethodException e) {
                    }
                }
                try {
                    if (this.qlm != null) {
                        this.qlm.invoke(this, new Object[]{Boolean.valueOf(true)});
                    }
                } catch (Exception e2) {
                }
            }
            this.zf = 1;
            if (i != 0) {
                populate();
            }
        }
        this.zb = new h(this) {
            final /* synthetic */ DummyViewPager qlt;

            {
                this.qlt = r1;
            }

            public final void W(int i) {
                super.W(i);
                if (i == 0) {
                    this.qlt.qls = this.qlt.getScrollX();
                }
            }
        };
    }

    public final int bgK() {
        return this.qls;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
