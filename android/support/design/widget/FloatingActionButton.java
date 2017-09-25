package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.h;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.z;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.List;

@android.support.design.widget.CoordinatorLayout.b(a.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private ColorStateList hL;
    private Mode hM;
    private int hN;
    private int hO;
    private int hP;
    private int hQ;
    private boolean hR;
    private final Rect hS;
    private i hT;
    private l hU;

    public static class a extends Behavior<FloatingActionButton> {
        private static final boolean hV = (VERSION.SDK_INT >= 11);
        private Rect gG;
        private u hW;
        private float hX;

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            int i3 = 0;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List n = coordinatorLayout.n(floatingActionButton);
            int size = n.size();
            for (i2 = 0; i2 < size; i2++) {
                View view2 = (View) n.get(i2);
                if ((view2 instanceof AppBarLayout) && a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.e(floatingActionButton, i);
            Rect c = floatingActionButton.hS;
            if (c != null && c.centerX() > 0 && c.centerY() > 0) {
                d dVar = (d) floatingActionButton.getLayoutParams();
                i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin ? c.right : floatingActionButton.getLeft() <= dVar.leftMargin ? -c.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - dVar.bottomMargin) {
                    i3 = c.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i3 = -c.top;
                }
                floatingActionButton.offsetTopAndBottom(i3);
                floatingActionButton.offsetLeftAndRight(i2);
            }
            return true;
        }

        public final /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            final FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof SnackbarLayout) {
                float min;
                float f = 0.0f;
                List n = coordinatorLayout.n(floatingActionButton);
                int size = n.size();
                int i = 0;
                while (i < size) {
                    View view3 = (View) n.get(i);
                    if (view3 instanceof SnackbarLayout) {
                        boolean z;
                        if (floatingActionButton.getVisibility() == 0 && view3.getVisibility() == 0) {
                            Rect rect = coordinatorLayout.hd;
                            coordinatorLayout.a((View) floatingActionButton, floatingActionButton.getParent() != coordinatorLayout, rect);
                            Rect rect2 = coordinatorLayout.he;
                            coordinatorLayout.a(view3, view3.getParent() != coordinatorLayout, rect2);
                            z = rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
                        } else {
                            z = false;
                        }
                        if (z) {
                            min = Math.min(f, z.S(view3) - ((float) view3.getHeight()));
                            i++;
                            f = min;
                        }
                    }
                    min = f;
                    i++;
                    f = min;
                }
                if (this.hX != f) {
                    min = z.S(floatingActionButton);
                    if (this.hW != null && this.hW.ll.isRunning()) {
                        this.hW.ll.cancel();
                    }
                    if (!floatingActionButton.isShown() || Math.abs(min - f) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                        z.c(floatingActionButton, f);
                    } else {
                        if (this.hW == null) {
                            this.hW = aa.av();
                            this.hW.setInterpolator(a.et);
                            this.hW.a(new c(this) {
                                final /* synthetic */ a hZ;

                                public final void a(u uVar) {
                                    z.c(floatingActionButton, uVar.ll.ax());
                                }
                            });
                        }
                        this.hW.e(min, f);
                        this.hW.ll.start();
                    }
                    this.hX = f;
                }
            } else if (view2 instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            }
            return false;
        }

        public final /* bridge */ /* synthetic */ boolean e(View view) {
            return hV && (view instanceof SnackbarLayout);
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            if (((d) floatingActionButton.getLayoutParams()).hy != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.lP != 0) {
                return false;
            }
            if (this.gG == null) {
                this.gG = new Rect();
            }
            Rect rect = this.gG;
            x.a(coordinatorLayout, appBarLayout, rect);
            int i2 = rect.bottom;
            int G = appBarLayout.G();
            int U = z.U(appBarLayout);
            if (U != 0) {
                i = (U * 2) + G;
            } else {
                U = appBarLayout.getChildCount();
                if (U > 0) {
                    i = (z.U(appBarLayout.getChildAt(U - 1)) * 2) + G;
                }
            }
            if (i2 <= i) {
                floatingActionButton.U().a(null, false);
            } else {
                floatingActionButton.U().b(null, false);
            }
            return true;
        }
    }

    private class b implements p {
        final /* synthetic */ FloatingActionButton ia;

        public b(FloatingActionButton floatingActionButton) {
            this.ia = floatingActionButton;
        }

        public final float V() {
            return ((float) this.ia.T()) / 2.0f;
        }

        public final void c(int i, int i2, int i3, int i4) {
            this.ia.hS.set(i, i2, i3, i4);
            this.ia.setPadding(this.ia.hQ + i, this.ia.hQ + i2, this.ia.hQ + i3, this.ia.hQ + i4);
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public final boolean W() {
            return this.ia.hR;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        Mode mode;
        super(context, attributeSet, i);
        this.hS = new Rect();
        t.g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.bV, i, h.aQ);
        this.hL = obtainStyledAttributes.getColorStateList(android.support.design.a.i.bW);
        switch (obtainStyledAttributes.getInt(android.support.design.a.i.bX, -1)) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            default:
                mode = null;
                break;
        }
        this.hM = mode;
        this.hO = obtainStyledAttributes.getColor(android.support.design.a.i.cc, 0);
        this.hP = obtainStyledAttributes.getInt(android.support.design.a.i.ca, 0);
        this.hN = obtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.bY, 0);
        float dimension = obtainStyledAttributes.getDimension(android.support.design.a.i.bZ, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(android.support.design.a.i.cb, 0.0f);
        this.hR = obtainStyledAttributes.getBoolean(android.support.design.a.i.cd, false);
        obtainStyledAttributes.recycle();
        this.hT = new i(this, android.support.v7.widget.h.ey());
        this.hT.a(attributeSet, i);
        this.hQ = (T() - ((int) getResources().getDimension(android.support.design.a.d.ag))) / 2;
        U().a(this.hL, this.hM, this.hO, this.hN);
        l U = U();
        if (U.is != dimension) {
            U.is = dimension;
            U.i(dimension);
        }
        l U2 = U();
        if (U2.it != dimension2) {
            U2.it = dimension2;
            U2.j(dimension2);
        }
        U().ab();
    }

    protected void onMeasure(int i, int i2) {
        int T = T();
        T = Math.min(resolveAdjustedSize(T, i), resolveAdjustedSize(T, i2));
        setMeasuredDimension((this.hS.left + T) + this.hS.right, (T + this.hS.top) + this.hS.bottom);
    }

    public ColorStateList getBackgroundTintList() {
        return this.hL;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.hL != colorStateList) {
            this.hL = colorStateList;
            U().setBackgroundTintList(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.hM;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.hM != mode) {
            this.hM = mode;
            U().setBackgroundTintMode(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundColor(int i) {
    }

    public void setImageResource(int i) {
        this.hT.setImageResource(i);
    }

    final int T() {
        switch (this.hP) {
            case 1:
                return getResources().getDimensionPixelSize(android.support.design.a.d.ah);
            default:
                return getResources().getDimensionPixelSize(android.support.design.a.d.aj);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l U = U();
        if (U.Z()) {
            if (U.ix == null) {
                U.ix = new OnPreDrawListener(U) {
                    final /* synthetic */ l iy;

                    {
                        this.iy = r1;
                    }

                    public final boolean onPreDraw() {
                        this.iy.aa();
                        return true;
                    }
                };
            }
            U.iv.getViewTreeObserver().addOnPreDrawListener(U.ix);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l U = U();
        if (U.ix != null) {
            U.iv.getViewTreeObserver().removeOnPreDrawListener(U.ix);
            U.ix = null;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        U().b(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        U().X();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private l U() {
        if (this.hU == null) {
            int i = VERSION.SDK_INT;
            l mVar = i >= 21 ? new m(this, new b(this)) : i >= 14 ? new k(this, new b(this)) : new j(this, new b(this));
            this.hU = mVar;
        }
        return this.hU;
    }
}
