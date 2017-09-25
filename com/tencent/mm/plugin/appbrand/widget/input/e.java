package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.p.b;
import com.tencent.mm.plugin.appbrand.g.r;
import com.tencent.mm.plugin.appbrand.g.t;
import com.tencent.mm.plugin.appbrand.widget.a.f;
import com.tencent.mm.sdk.platformtools.w;

@SuppressLint({"ViewConstructor"})
public final class e extends FrameLayout implements b, t {
    private final m iNv;
    public final f jsD;
    private final AbsoluteLayout jsE;
    private final float jsF;

    private final class a extends AbsoluteLayout implements com.tencent.mm.plugin.appbrand.widget.a.e {
        final /* synthetic */ e jsG;

        public a(e eVar, Context context) {
            this.jsG = eVar;
            super(context);
        }

        public final boolean Yh() {
            if (getChildCount() <= 0) {
                return false;
            }
            for (int i = 0; i <= getChildCount(); i++) {
                if (com.tencent.mm.plugin.appbrand.widget.a.a.bJ(getChildAt(i))) {
                    return true;
                }
            }
            return false;
        }

        public final boolean w(MotionEvent motionEvent) {
            if (motionEvent == null || motionEvent.getActionMasked() != 0) {
                return false;
            }
            f fVar = this.jsG.jsD;
            if (motionEvent != null && motionEvent.getActionMasked() == 0 && fVar.jrS != null && motionEvent.getDownTime() == fVar.jrS.jrT && motionEvent.getEventTime() == fVar.jrS.jrU) {
                return true;
            }
            return false;
        }
    }

    public e(Context context, m mVar) {
        super(context);
        super.setId(R.h.bpl);
        this.iNv = mVar;
        this.jsF = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        this.jsE = new a(this, context);
        this.jsD = new f(this.jsE);
        addView(this.jsE);
    }

    public final void setId(int i) {
    }

    public final <Input extends View & y> boolean a(r rVar, Input input, int i, int i2, int i3, int i4) {
        return a(rVar, input, i, i2, i3, i4, true);
    }

    private <Input extends View & y> boolean a(r rVar, Input input, int i, int i2, int i3, int i4, boolean z) {
        if (rVar == null || rVar.getView() == null || input == null) {
            return false;
        }
        l(rVar);
        if (((y) input).Zp()) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
            layoutParams.leftMargin = i3 - rVar.getScrollX();
            layoutParams.topMargin = i4 - rVar.getScrollY();
            layoutParams.bottomMargin = 0;
            layoutParams.rightMargin = 0;
            addView(input, layoutParams);
            if (z) {
                ((y) input).m(this.iNv);
            }
            return true;
        }
        this.jsE.addView(input, new AbsoluteLayout.LayoutParams(i, i2, i3, i4));
        if (z) {
            ((y) input).m(this.iNv);
        }
        return true;
    }

    private void l(r rVar) {
        AbsoluteLayout absoluteLayout = (AbsoluteLayout) rVar.getView();
        if (!(this.jsE.getWidth() == absoluteLayout.getWidth() && this.jsE.getHeight() == absoluteLayout.getHeight())) {
            LayoutParams layoutParams = this.jsE.getLayoutParams();
            layoutParams.width = absoluteLayout.getWidth();
            layoutParams.height = absoluteLayout.getHeight();
            this.jsE.setLayoutParams(layoutParams);
        }
        if (this.jsE.getScrollX() != absoluteLayout.getScrollX() || this.jsE.getScrollY() != absoluteLayout.getScrollY()) {
            this.jsE.scrollTo(absoluteLayout.getScrollX(), absoluteLayout.getScrollY());
        }
    }

    public final <Input extends View & y> boolean b(r rVar, Input input, int i, int i2, int i3, int i4) {
        if (rVar == null || rVar.getView() == null || input == null) {
            return false;
        }
        boolean z;
        if (input != null) {
            if (bL(input)) {
                z = true;
            } else if (this.jsE != null) {
                for (int i5 = 0; i5 < this.jsE.getChildCount(); i5++) {
                    if (input == this.jsE.getChildAt(i5)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                return false;
            }
            l(rVar);
            if (!bL(input)) {
                if (((y) input).Zp()) {
                    removeView(input);
                    a(rVar, input, i, i2, i3, i4, false);
                } else if (input.getLayoutParams() != null) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) input.getLayoutParams();
                    layoutParams.leftMargin = i3 - rVar.getScrollX();
                    layoutParams.topMargin = i4 - rVar.getScrollY();
                    layoutParams.width = i;
                    layoutParams.height = i2;
                    input.setLayoutParams(layoutParams);
                }
                return true;
            } else if (input.getLayoutParams() == null && (input.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)) {
                if (!(input.getWidth() == i && input.getHeight() == i2 && input.getLeft() == i3 && input.getTop() == i4)) {
                    AbsoluteLayout.LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) input.getLayoutParams();
                    layoutParams2.x = i3;
                    layoutParams2.y = i4;
                    layoutParams2.width = i;
                    layoutParams2.height = i2;
                    input.setLayoutParams(layoutParams2);
                }
                return true;
            }
        }
        z = false;
        if (z) {
            return false;
        }
        l(rVar);
        if (!bL(input)) {
            return input.getLayoutParams() == null ? false : false;
        } else {
            if (((y) input).Zp()) {
                removeView(input);
                a(rVar, input, i, i2, i3, i4, false);
            } else if (input.getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) input.getLayoutParams();
                layoutParams3.leftMargin = i3 - rVar.getScrollX();
                layoutParams3.topMargin = i4 - rVar.getScrollY();
                layoutParams3.width = i;
                layoutParams3.height = i2;
                input.setLayoutParams(layoutParams3);
            }
            return true;
        }
    }

    private <Input extends View & y> boolean bL(Input input) {
        for (int i = 1; i < getChildCount(); i++) {
            if (input == getChildAt(i)) {
                return true;
            }
        }
        return false;
    }

    public final <Input extends View & y> void bM(Input input) {
        if (input != null) {
            input.setVisibility(8);
            this.jsE.removeView(input);
            removeView(input);
            ((y) input).n(this.iNv);
        }
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        w.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (this.jsE != null) {
            LayoutParams layoutParams = this.jsE.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LayoutParams(view.getWidth(), view.getHeight());
                this.jsE.setLayoutParams(layoutParams);
            }
            if (!(view.getWidth() == layoutParams.width && view.getHeight() == layoutParams.height)) {
                layoutParams.width = view.getWidth();
                layoutParams.height = view.getHeight();
                this.jsE.setLayoutParams(layoutParams);
            }
            this.jsE.scrollTo(i, i2);
        }
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void id(int i) {
        setTranslationY((float) i);
    }
}
