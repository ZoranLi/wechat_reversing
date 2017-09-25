package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.e;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class CollapsingToolbarLayout extends FrameLayout {
    private ap eD;
    private View gA;
    private View gB;
    private int gC;
    private int gD;
    private int gE;
    private int gF;
    private final Rect gG;
    private final f gH;
    private boolean gI;
    private boolean gJ;
    private Drawable gK;
    private Drawable gL;
    int gM;
    boolean gN;
    u gO;
    private android.support.design.widget.AppBarLayout.a gP;
    private int gQ;
    private boolean gx;
    private int gy;
    private Toolbar gz;

    public static class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int gS = 0;
        float gT = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bq);
            this.gS = obtainStyledAttributes.getInt(i.br, 0);
            this.gT = obtainStyledAttributes.getFloat(i.bt, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class a implements android.support.design.widget.AppBarLayout.a {
        final /* synthetic */ CollapsingToolbarLayout gR;

        public a(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.gR = collapsingToolbarLayout;
        }

        public final void a(AppBarLayout appBarLayout, int i) {
            int systemWindowInsetTop;
            int i2 = 255;
            int i3 = 1;
            int i4 = 0;
            this.gR.gQ = i;
            if (this.gR.eD != null) {
                systemWindowInsetTop = this.gR.eD.getSystemWindowInsetTop();
            } else {
                systemWindowInsetTop = 0;
            }
            int F = appBarLayout.F();
            int childCount = this.gR.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.gR.getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                z l = CollapsingToolbarLayout.k(childAt);
                switch (layoutParams.gS) {
                    case 1:
                        if ((this.gR.getHeight() - systemWindowInsetTop) + i < childAt.getHeight()) {
                            break;
                        }
                        l.f(-i);
                        break;
                    case 2:
                        l.f(Math.round(layoutParams.gT * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
            if (!(this.gR.gK == null && this.gR.gL == null)) {
                View view = this.gR;
                boolean z = this.gR.getHeight() + i < (z.U(this.gR) * 2) + systemWindowInsetTop;
                if (!z.aj(view) || view.isInEditMode()) {
                    i3 = 0;
                }
                if (view.gN != z) {
                    if (i3 != 0) {
                        if (z) {
                            i4 = 255;
                        }
                        view.P();
                        if (view.gO == null) {
                            Interpolator interpolator;
                            view.gO = aa.av();
                            view.gO.setDuration(600);
                            u uVar = view.gO;
                            if (i4 > view.gM) {
                                interpolator = a.eu;
                            } else {
                                interpolator = a.ev;
                            }
                            uVar.setInterpolator(interpolator);
                            view.gO.a(new c(view) {
                                final /* synthetic */ CollapsingToolbarLayout gR;

                                {
                                    this.gR = r1;
                                }

                                public final void a(u uVar) {
                                    this.gR.r(uVar.ll.aw());
                                }
                            });
                        } else if (view.gO.ll.isRunning()) {
                            view.gO.ll.cancel();
                        }
                        view.gO.e(view.gM, i4);
                        view.gO.ll.start();
                    } else {
                        if (!z) {
                            i2 = 0;
                        }
                        view.r(i2);
                    }
                    view.gN = z;
                }
            }
            if (this.gR.gL != null && systemWindowInsetTop > 0) {
                z.F(this.gR);
            }
            this.gR.gH.e(((float) Math.abs(i)) / ((float) ((this.gR.getHeight() - z.U(this.gR)) - systemWindowInsetTop)));
            if (Math.abs(i) == F) {
                z.g((View) appBarLayout, appBarLayout.eB);
            } else {
                z.g((View) appBarLayout, 0.0f);
            }
        }
    }

    static /* synthetic */ ap a(CollapsingToolbarLayout collapsingToolbarLayout, ap apVar) {
        if (collapsingToolbarLayout.eD != apVar) {
            collapsingToolbarLayout.eD = apVar;
            collapsingToolbarLayout.requestLayout();
        }
        return apVar.ca();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return Q();
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m3generateDefaultLayoutParams() {
        return Q();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        Drawable drawable = null;
        super(context, attributeSet, i);
        this.gx = true;
        this.gG = new Rect();
        t.g(context);
        this.gH = new f(this);
        this.gH.a(a.ew);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bu, i, h.aO);
        this.gH.m(obtainStyledAttributes.getInt(i.by, 8388691));
        this.gH.n(obtainStyledAttributes.getInt(i.bv, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i.bz, 0);
        this.gF = dimensionPixelSize;
        this.gE = dimensionPixelSize;
        this.gD = dimensionPixelSize;
        this.gC = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(i.bC)) {
            this.gC = obtainStyledAttributes.getDimensionPixelSize(i.bC, 0);
        }
        if (obtainStyledAttributes.hasValue(i.bB)) {
            this.gE = obtainStyledAttributes.getDimensionPixelSize(i.bB, 0);
        }
        if (obtainStyledAttributes.hasValue(i.bD)) {
            this.gD = obtainStyledAttributes.getDimensionPixelSize(i.bD, 0);
        }
        if (obtainStyledAttributes.hasValue(i.bA)) {
            this.gF = obtainStyledAttributes.getDimensionPixelSize(i.bA, 0);
        }
        this.gI = obtainStyledAttributes.getBoolean(i.bH, true);
        this.gH.setText(obtainStyledAttributes.getText(i.bG));
        this.gH.p(h.aK);
        this.gH.o(h.aJ);
        if (obtainStyledAttributes.hasValue(i.bE)) {
            this.gH.p(obtainStyledAttributes.getResourceId(i.bE, 0));
        }
        if (obtainStyledAttributes.hasValue(i.bw)) {
            this.gH.o(obtainStyledAttributes.getResourceId(i.bw, 0));
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(i.bx);
        if (this.gK != drawable2) {
            if (this.gK != null) {
                this.gK.setCallback(null);
            }
            this.gK = drawable2 != null ? drawable2.mutate() : null;
            if (this.gK != null) {
                this.gK.setBounds(0, 0, getWidth(), getHeight());
                this.gK.setCallback(this);
                this.gK.setAlpha(this.gM);
            }
            z.F(this);
        }
        drawable2 = obtainStyledAttributes.getDrawable(i.bF);
        if (this.gL != drawable2) {
            if (this.gL != null) {
                this.gL.setCallback(null);
            }
            if (drawable2 != null) {
                drawable = drawable2.mutate();
            }
            this.gL = drawable;
            if (this.gL != null) {
                boolean z;
                if (this.gL.isStateful()) {
                    this.gL.setState(getDrawableState());
                }
                android.support.v4.b.a.a.b(this.gL, z.J(this));
                drawable = this.gL;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable.setVisible(z, false);
                this.gL.setCallback(this);
                this.gL.setAlpha(this.gM);
            }
            z.F(this);
        }
        this.gy = obtainStyledAttributes.getResourceId(i.bI, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        z.b((View) this, new t(this) {
            final /* synthetic */ CollapsingToolbarLayout gR;

            {
                this.gR = r1;
            }

            public final ap a(View view, ap apVar) {
                return CollapsingToolbarLayout.a(this.gR, apVar);
            }
        });
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.gP == null) {
                this.gP = new a(this);
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            android.support.design.widget.AppBarLayout.a aVar = this.gP;
            if (!(aVar == null || appBarLayout.eE.contains(aVar))) {
                appBarLayout.eE.add(aVar);
            }
        }
        z.Z(this);
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.gP != null && (parent instanceof AppBarLayout)) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            android.support.design.widget.AppBarLayout.a aVar = this.gP;
            if (aVar != null) {
                appBarLayout.eE.remove(aVar);
            }
        }
        super.onDetachedFromWindow();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        P();
        if (this.gz == null && this.gK != null && this.gM > 0) {
            this.gK.mutate().setAlpha(this.gM);
            this.gK.draw(canvas);
        }
        if (this.gI && this.gJ) {
            this.gH.draw(canvas);
        }
        if (this.gL != null && this.gM > 0) {
            int systemWindowInsetTop = this.eD != null ? this.eD.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.gL.setBounds(0, -this.gQ, getWidth(), systemWindowInsetTop - this.gQ);
                this.gL.mutate().setAlpha(this.gM);
                this.gL.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        P();
        if (view == this.gz && this.gK != null && this.gM > 0) {
            this.gK.mutate().setAlpha(this.gM);
            this.gK.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.gK != null) {
            this.gK.setBounds(0, 0, i, i2);
        }
    }

    final void P() {
        if (this.gx) {
            View view;
            this.gz = null;
            this.gA = null;
            if (this.gy != -1) {
                this.gz = (Toolbar) findViewById(this.gy);
                if (this.gz != null) {
                    view = this.gz;
                    CollapsingToolbarLayout parent = view.getParent();
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = parent;
                        }
                        parent = parent.getParent();
                    }
                    this.gA = view;
                }
            }
            if (this.gz == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    view = getChildAt(i);
                    if (view instanceof Toolbar) {
                        toolbar = (Toolbar) view;
                        break;
                    }
                }
                toolbar = null;
                this.gz = toolbar;
            }
            if (!(this.gI || this.gB == null)) {
                ViewParent parent2 = this.gB.getParent();
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(this.gB);
                }
            }
            if (this.gI && this.gz != null) {
                if (this.gB == null) {
                    this.gB = new View(getContext());
                }
                if (this.gB.getParent() == null) {
                    this.gz.addView(this.gB, -1, -1);
                }
            }
            this.gx = false;
        }
    }

    protected void onMeasure(int i, int i2) {
        P();
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.gI && this.gB != null) {
            boolean z2 = z.al(this.gB) && this.gB.getVisibility() == 0;
            this.gJ = z2;
            if (this.gJ) {
                if (this.gA == null || this.gA == this) {
                    i5 = 0;
                } else {
                    i5 = ((LayoutParams) this.gA.getLayoutParams()).bottomMargin;
                }
                x.a(this, this.gB, this.gG);
                this.gH.b(this.gG.left, (i4 - this.gG.height()) - i5, this.gG.right, i4 - i5);
                if (z.J(this) != 1) {
                    i6 = 0;
                }
                f fVar = this.gH;
                i5 = i6 != 0 ? this.gE : this.gC;
                int i8 = this.gG.bottom + this.gD;
                int i9 = i3 - i;
                if (i6 != 0) {
                    i6 = this.gC;
                } else {
                    i6 = this.gE;
                }
                fVar.a(i5, i8, i9 - i6, (i4 - i2) - this.gF);
                this.gH.N();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            View childAt = getChildAt(i7);
            if (!(this.eD == null || z.aa(childAt))) {
                int systemWindowInsetTop = this.eD.getSystemWindowInsetTop();
                if (childAt.getTop() < systemWindowInsetTop) {
                    z.j(childAt, systemWindowInsetTop);
                }
            }
            k(childAt).ay();
            i7++;
        }
        if (this.gz != null) {
            if (this.gI && TextUtils.isEmpty(this.gH.mText)) {
                this.gH.setText(this.gz.aeY);
            }
            if (this.gA == null || this.gA == this) {
                setMinimumHeight(j(this.gz));
            } else {
                setMinimumHeight(j(this.gA));
            }
        }
    }

    private static int j(View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    private static z k(View view) {
        z zVar = (z) view.getTag(e.aw);
        if (zVar != null) {
            return zVar;
        }
        zVar = new z(view);
        view.setTag(e.aw, zVar);
        return zVar;
    }

    final void r(int i) {
        if (i != this.gM) {
            if (!(this.gK == null || this.gz == null)) {
                z.F(this.gz);
            }
            this.gM = i;
            z.F(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.gL;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        drawable = this.gK;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.gK || drawable == this.gL;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.gL == null || this.gL.isVisible() == z)) {
            this.gL.setVisible(z, false);
        }
        if (this.gK != null && this.gK.isVisible() != z) {
            this.gK.setVisible(z, false);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams Q() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
