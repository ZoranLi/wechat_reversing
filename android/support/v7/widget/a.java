package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v7.a.a.g;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class a extends ViewGroup {
    protected int RA;
    protected ai RB;
    private boolean RC;
    private boolean RD;
    protected final a Rw = new a(this);
    protected final Context Rx;
    protected ActionMenuView Ry;
    protected ActionMenuPresenter Rz;

    protected class a implements am {
        private boolean RE = false;
        int RF;
        final /* synthetic */ a RG;

        protected a(a aVar) {
            this.RG = aVar;
        }

        public final a a(ai aiVar, int i) {
            this.RG.RB = aiVar;
            this.RF = i;
            return this;
        }

        public final void p(View view) {
            super.setVisibility(0);
            this.RE = false;
        }

        public final void q(View view) {
            if (!this.RE) {
                this.RG.RB = null;
                super.setVisibility(this.RF);
            }
        }

        public final void as(View view) {
            this.RE = true;
        }
    }

    a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.Rx = context;
        } else {
            this.Rx = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, k.aV, android.support.v7.a.a.a.actionBarStyle, 0);
        ay(obtainStyledAttributes.getLayoutDimension(k.Lg, 0));
        obtainStyledAttributes.recycle();
        if (this.Rz != null) {
            ActionMenuPresenter actionMenuPresenter = this.Rz;
            if (!actionMenuPresenter.SH) {
                actionMenuPresenter.SG = actionMenuPresenter.mContext.getResources().getInteger(g.Ky);
            }
            if (actionMenuPresenter.dW != null) {
                actionMenuPresenter.dW.h(true);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 0) {
            this.RC = false;
        }
        if (!this.RC) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (d == 0 && !onTouchEvent) {
                this.RC = true;
            }
        }
        if (d == 1 || d == 3) {
            this.RC = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (d == 9) {
            this.RD = false;
        }
        if (!this.RD) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (d == 9 && !onHoverEvent) {
                this.RD = true;
            }
        }
        if (d == 10 || d == 3) {
            this.RD = false;
        }
        return true;
    }

    public void ay(int i) {
        this.RA = i;
        requestLayout();
    }

    public ai c(int i, long j) {
        if (this.RB != null) {
            this.RB.cancel();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                z.d(this, 0.0f);
            }
            ai p = z.V(this).p(1.0f);
            p.c(j);
            p.a(this.Rw.a(p, i));
            return p;
        }
        p = z.V(this).p(0.0f);
        p.c(j);
        p.a(this.Rw.a(p, i));
        return p;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.RB != null) {
                this.RB.cancel();
            }
            super.setVisibility(i);
        }
    }

    public boolean showOverflowMenu() {
        if (this.Rz != null) {
            return this.Rz.showOverflowMenu();
        }
        return false;
    }

    protected static int g(View view, int i, int i2) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) + 0);
    }

    protected static int c(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
