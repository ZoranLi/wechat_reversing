package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.r;
import android.support.v4.view.s;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;

public class SwipeRefreshLayout extends ViewGroup implements p, r {
    private static final String DU = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] ym = new int[]{16842766};
    private a DV;
    private boolean DW = false;
    private float DX = -1.0f;
    private float DY;
    private final q DZ;
    private final Animation EA = new Animation(this) {
        final /* synthetic */ SwipeRefreshLayout EC;

        {
            this.EC = r1;
        }

        public final void applyTransformation(float f, Transformation transformation) {
            int j;
            if (this.EC.Ey) {
                j = (int) this.EC.Eu;
            } else {
                j = (int) (this.EC.Eu - ((float) Math.abs(this.EC.Eo)));
            }
            this.EC.l((((int) (((float) (j - this.EC.Em)) * f)) + this.EC.Em) - this.EC.Ek.getTop(), false);
            this.EC.Ep.v(1.0f - f);
        }
    };
    private final Animation EB = new Animation(this) {
        final /* synthetic */ SwipeRefreshLayout EC;

        {
            this.EC = r1;
        }

        public final void applyTransformation(float f, Transformation transformation) {
            this.EC.l((this.EC.Em + ((int) (((float) (this.EC.Eo - this.EC.Em)) * f))) - this.EC.Ek.getTop(), false);
        }
    };
    private final int[] Ea = new int[2];
    private final int[] Eb = new int[2];
    private boolean Ec;
    private int Ed;
    private int Ee;
    private boolean Ef = false;
    private float Eg;
    private boolean Eh;
    private boolean Ei;
    private final DecelerateInterpolator Ej;
    private b Ek;
    private int El = -1;
    protected int Em;
    private float En;
    protected int Eo;
    private l Ep;
    private Animation Eq;
    private Animation Er;
    private Animation Es;
    private Animation Et;
    private float Eu;
    private boolean Ev;
    private int Ew;
    private int Ex;
    private boolean Ey;
    private AnimationListener Ez = new AnimationListener(this) {
        final /* synthetic */ SwipeRefreshLayout EC;

        {
            this.EC = r1;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.EC.DW) {
                this.EC.Ep.setAlpha(255);
                this.EC.Ep.start();
                if (this.EC.Ev && this.EC.DV != null) {
                    this.EC.DV;
                }
                this.EC.Ee = this.EC.Ek.getTop();
                return;
            }
            this.EC.reset();
        }
    };
    private int fl = -1;
    private final s hs;
    private boolean iC;
    private int iE;
    private View nw;
    private float xD;

    public interface a {
    }

    private void reset() {
        this.Ek.clearAnimation();
        this.Ep.stop();
        this.Ek.setVisibility(8);
        al(255);
        if (this.Eh) {
            B(0.0f);
        } else {
            l(this.Eo - this.Ee, true);
        }
        this.Ee = this.Ek.getTop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void al(int i) {
        this.Ek.getBackground().setAlpha(i);
        this.Ep.setAlpha(i);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iE = ViewConfiguration.get(context).getScaledTouchSlop();
        this.Ed = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.Ej = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ym);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.Ew = (int) (displayMetrics.density * 40.0f);
        this.Ex = (int) (displayMetrics.density * 40.0f);
        this.Ek = new b(getContext());
        this.Ep = new l(getContext(), this);
        this.Ep.Ct.CU = -328966;
        this.Ek.setImageDrawable(this.Ep);
        this.Ek.setVisibility(8);
        addView(this.Ek);
        z.a(this);
        this.Eu = displayMetrics.density * 64.0f;
        this.DX = this.Eu;
        this.hs = new s(this);
        this.DZ = new q(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.El < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.El;
        }
        if (i2 >= this.El) {
            return i2 + 1;
        }
        return i2;
    }

    private static boolean cE() {
        return VERSION.SDK_INT < 11;
    }

    private void B(float f) {
        if (cE()) {
            al((int) (255.0f * f));
            return;
        }
        z.e(this.Ek, f);
        z.f(this.Ek, f);
    }

    private void a(AnimationListener animationListener) {
        this.Eq = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout EC;

            {
                this.EC = r1;
            }

            public final void applyTransformation(float f, Transformation transformation) {
                this.EC.B(1.0f - f);
            }
        };
        this.Eq.setDuration(150);
        this.Ek.AY = animationListener;
        this.Ek.clearAnimation();
        this.Ek.startAnimation(this.Eq);
    }

    private Animation p(final int i, final int i2) {
        if (this.Eh && cE()) {
            return null;
        }
        Animation anonymousClass3 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout EC;

            public final void applyTransformation(float f, Transformation transformation) {
                this.EC.Ep.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        anonymousClass3.setDuration(300);
        this.Ek.AY = null;
        this.Ek.clearAnimation();
        this.Ek.startAnimation(anonymousClass3);
        return anonymousClass3;
    }

    private void cF() {
        if (this.nw == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.Ek)) {
                    i++;
                } else {
                    this.nw = childAt;
                    return;
                }
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.nw == null) {
                cF();
            }
            if (this.nw != null) {
                View view = this.nw;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.Ek.getMeasuredWidth();
                this.Ek.layout((measuredWidth / 2) - (measuredHeight / 2), this.Ee, (measuredWidth / 2) + (measuredHeight / 2), this.Ee + this.Ek.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.nw == null) {
            cF();
        }
        if (this.nw != null) {
            int i3;
            this.nw.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.Ek.measure(MeasureSpec.makeMeasureSpec(this.Ew, 1073741824), MeasureSpec.makeMeasureSpec(this.Ex, 1073741824));
            if (!(this.Ey || this.Ef)) {
                this.Ef = true;
                i3 = -this.Ek.getMeasuredHeight();
                this.Eo = i3;
                this.Ee = i3;
            }
            this.El = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.Ek) {
                    this.El = i3;
                    return;
                }
            }
        }
    }

    private boolean cG() {
        if (VERSION.SDK_INT >= 14) {
            return z.h(this.nw, -1);
        }
        if (!(this.nw instanceof AbsListView)) {
            return z.h(this.nw, -1) || this.nw.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.nw;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        cF();
        int d = o.d(motionEvent);
        if (this.Ei && d == 0) {
            this.Ei = false;
        }
        if (!isEnabled() || this.Ei || cG() || this.DW || this.Ec) {
            return false;
        }
        float g;
        switch (d) {
            case 0:
                l(this.Eo - this.Ek.getTop(), true);
                this.fl = o.c(motionEvent, 0);
                this.iC = false;
                g = g(motionEvent, this.fl);
                if (g != -1.0f) {
                    this.Eg = g;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.iC = false;
                this.fl = -1;
                break;
            case 2:
                if (this.fl == -1) {
                    return false;
                }
                g = g(motionEvent, this.fl);
                if (g != -1.0f) {
                    if (g - this.Eg > ((float) this.iE) && !this.iC) {
                        this.xD = this.Eg + ((float) this.iE);
                        this.iC = true;
                        this.Ep.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return this.iC;
    }

    private static float g(MotionEvent motionEvent, int i) {
        int b = o.b(motionEvent, i);
        if (b < 0) {
            return -1.0f;
        }
        return o.e(motionEvent, b);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.nw instanceof AbsListView)) {
            return;
        }
        if (this.nw == null || z.ah(this.nw)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.Ei || this.DW || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.hs.xn = i;
        startNestedScroll(i & 2);
        this.DY = 0.0f;
        this.Ec = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.DY > 0.0f) {
            if (((float) i2) > this.DY) {
                iArr[1] = i2 - ((int) this.DY);
                this.DY = 0.0f;
            } else {
                this.DY -= (float) i2;
                iArr[1] = i2;
            }
            C(this.DY);
        }
        if (this.Ey && i2 > 0 && this.DY == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.Ek.setVisibility(8);
        }
        int[] iArr2 = this.Ea;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.hs.xn;
    }

    public void onStopNestedScroll(View view) {
        this.hs.xn = 0;
        this.Ec = false;
        if (this.DY > 0.0f) {
            D(this.DY);
            this.DY = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.Eb);
        int i5 = this.Eb[1] + i4;
        if (i5 < 0 && !cG()) {
            this.DY = ((float) Math.abs(i5)) + this.DY;
            C(this.DY);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.DZ.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.DZ.xk;
    }

    public boolean startNestedScroll(int i) {
        return this.DZ.startNestedScroll(i);
    }

    public void stopNestedScroll() {
        this.DZ.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return this.DZ.hasNestedScrollingParent();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.DZ.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.DZ.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.DZ.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.DZ.dispatchNestedPreFling(f, f2);
    }

    private static boolean d(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void C(float f) {
        this.Ep.u(true);
        float min = Math.min(1.0f, Math.abs(f / this.DX));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.DX;
        float f2 = this.Ey ? this.Eu - ((float) this.Eo) : this.Eu;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.Eo;
        if (this.Ek.getVisibility() != 0) {
            this.Ek.setVisibility(0);
        }
        if (!this.Eh) {
            z.e(this.Ek, 1.0f);
            z.f(this.Ek, 1.0f);
        }
        if (this.Eh) {
            B(Math.min(1.0f, f / this.DX));
        }
        if (f < this.DX) {
            if (this.Ep.getAlpha() > 76 && !d(this.Er)) {
                this.Er = p(this.Ep.getAlpha(), 76);
            }
        } else if (this.Ep.getAlpha() < 255 && !d(this.Es)) {
            this.Es = p(this.Ep.getAlpha(), 255);
        }
        this.Ep.w(Math.min(0.8f, max * 0.8f));
        this.Ep.v(Math.min(1.0f, max));
        this.Ep.Ct.setRotation(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        l(i - this.Ee, true);
    }

    private void D(float f) {
        if (f <= this.DX) {
            this.DW = false;
            this.Ep.w(0.0f);
            AnimationListener animationListener = null;
            if (!this.Eh) {
                animationListener = new AnimationListener(this) {
                    final /* synthetic */ SwipeRefreshLayout EC;

                    {
                        this.EC = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (!this.EC.Eh) {
                            this.EC.a(null);
                        }
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                };
            }
            int i = this.Ee;
            if (this.Eh) {
                this.Em = i;
                if (cE()) {
                    this.En = (float) this.Ep.getAlpha();
                } else {
                    this.En = z.W(this.Ek);
                }
                this.Et = new Animation(this) {
                    final /* synthetic */ SwipeRefreshLayout EC;

                    {
                        this.EC = r1;
                    }

                    public final void applyTransformation(float f, Transformation transformation) {
                        this.EC.B(this.EC.En + ((-this.EC.En) * f));
                        this.EC.l((this.EC.Em + ((int) (((float) (this.EC.Eo - this.EC.Em)) * f))) - this.EC.Ek.getTop(), false);
                    }
                };
                this.Et.setDuration(150);
                if (animationListener != null) {
                    this.Ek.AY = animationListener;
                }
                this.Ek.clearAnimation();
                this.Ek.startAnimation(this.Et);
            } else {
                this.Em = i;
                this.EB.reset();
                this.EB.setDuration(200);
                this.EB.setInterpolator(this.Ej);
                if (animationListener != null) {
                    this.Ek.AY = animationListener;
                }
                this.Ek.clearAnimation();
                this.Ek.startAnimation(this.EB);
            }
            this.Ep.u(false);
        } else if (!this.DW) {
            this.Ev = true;
            cF();
            this.DW = true;
            if (this.DW) {
                int i2 = this.Ee;
                AnimationListener animationListener2 = this.Ez;
                this.Em = i2;
                this.EA.reset();
                this.EA.setDuration(200);
                this.EA.setInterpolator(this.Ej);
                if (animationListener2 != null) {
                    this.Ek.AY = animationListener2;
                }
                this.Ek.clearAnimation();
                this.Ek.startAnimation(this.EA);
                return;
            }
            a(this.Ez);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int d = o.d(motionEvent);
        if (this.Ei && d == 0) {
            this.Ei = false;
        }
        if (!isEnabled() || this.Ei || cG() || this.Ec) {
            return false;
        }
        float e;
        switch (d) {
            case 0:
                this.fl = o.c(motionEvent, 0);
                this.iC = false;
                break;
            case 1:
                d = o.b(motionEvent, this.fl);
                if (d < 0) {
                    return false;
                }
                e = (o.e(motionEvent, d) - this.xD) * 0.5f;
                this.iC = false;
                D(e);
                this.fl = -1;
                return false;
            case 2:
                d = o.b(motionEvent, this.fl);
                if (d < 0) {
                    return false;
                }
                e = (o.e(motionEvent, d) - this.xD) * 0.5f;
                if (this.iC) {
                    if (e > 0.0f) {
                        C(e);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                d = o.e(motionEvent);
                if (d >= 0) {
                    this.fl = o.c(motionEvent, d);
                    break;
                }
                return false;
            case 6:
                h(motionEvent);
                break;
        }
        return true;
    }

    private void l(int i, boolean z) {
        this.Ek.bringToFront();
        this.Ek.offsetTopAndBottom(i);
        this.Ee = this.Ek.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void h(MotionEvent motionEvent) {
        int e = o.e(motionEvent);
        if (o.c(motionEvent, e) == this.fl) {
            this.fl = o.c(motionEvent, e == 0 ? 1 : 0);
        }
    }
}
