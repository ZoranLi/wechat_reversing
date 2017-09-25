package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.tencent.mm.s.a.d;

public abstract class MMTintStatusBarActivity extends MMActivity {
    private int nuN = 0;
    private FrameLayout uVg = null;

    static /* synthetic */ boolean a(MMTintStatusBarActivity mMTintStatusBarActivity, WindowInsets windowInsets) {
        if (windowInsets == null || mMTintStatusBarActivity.uVg == null) {
            return false;
        }
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        if (systemWindowInsetTop <= 0) {
            return false;
        }
        View childAt = mMTintStatusBarActivity.uVg.getChildAt(1);
        if (childAt.getLayoutParams() == null || !(childAt.getLayoutParams() instanceof MarginLayoutParams)) {
            return false;
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
        if (marginLayoutParams.topMargin != systemWindowInsetTop) {
            marginLayoutParams.topMargin = systemWindowInsetTop;
            childAt.setLayoutParams(marginLayoutParams);
        }
        View childAt2 = mMTintStatusBarActivity.uVg.getChildAt(0);
        LayoutParams layoutParams = childAt2.getLayoutParams();
        if (layoutParams == null) {
            return false;
        }
        if (layoutParams.height != systemWindowInsetTop) {
            layoutParams.height = systemWindowInsetTop;
            childAt2.setLayoutParams(layoutParams);
        }
        int statusBarColor = mMTintStatusBarActivity.getStatusBarColor();
        if (statusBarColor != mMTintStatusBarActivity.nuN) {
            mMTintStatusBarActivity.getWindow().setStatusBarColor(0);
            mMTintStatusBarActivity.uVg.getChildAt(0).setBackgroundColor(statusBarColor);
            mMTintStatusBarActivity.nuN = statusBarColor;
        }
        return true;
    }

    public void SC() {
        super.SC();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT < 21 || this.uVg == null) {
            getWindow().getDecorView().setFitsSystemWindows(true);
        } else {
            ((ViewGroup) getWindow().getDecorView()).getChildAt(0).setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
                final /* synthetic */ MMTintStatusBarActivity uVh;

                {
                    this.uVh = r1;
                }

                @TargetApi(20)
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    MMTintStatusBarActivity.a(this.uVh, windowInsets);
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
        }
    }

    protected final void bQo() {
        super.bQo();
        if (this.uUD != null && this.uUD.getChildCount() > 0) {
            View childAt = this.uUD.getChildAt(0);
            this.uUD.removeView(childAt);
            View view = new View(this);
            this.uVg = new FrameLayout(this);
            this.uVg.addView(view, new FrameLayout.LayoutParams(-1, 0));
            this.uVg.addView(childAt, new FrameLayout.LayoutParams(-1, -1));
            this.uUD.addView(this.uVg);
            this.uUD.Ih = this.uVg;
        }
    }

    public int getStatusBarColor() {
        return getResources().getColor(d.aVV);
    }
}
