package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.b;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.os.c;
import android.support.v4.view.ap;
import android.support.v4.view.t;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@b(Behavior.class)
public class AppBarLayout extends LinearLayout {
    boolean eA;
    float eB;
    private int eC = 0;
    private ap eD;
    final List<a> eE;
    private int ex = -1;
    private int ey = -1;
    private int ez = -1;

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        int eV = 1;
        Interpolator eW;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bd);
            this.eV = obtainStyledAttributes.getInt(i.be, 0);
            if (obtainStyledAttributes.hasValue(i.bf)) {
                this.eW = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i.bf, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public interface a {
        void a(AppBarLayout appBarLayout, int i);
    }

    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        public int eG;
        private boolean eH;
        private boolean eI;
        private u eJ;
        private int eK = -1;
        private boolean eL;
        private float eM;
        private WeakReference<View> eN;
        private a eO;

        protected static class SavedState extends BaseSavedState {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new c<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            int eS;
            float eT;
            boolean eU;

            public SavedState(Parcel parcel) {
                super(parcel);
                this.eS = parcel.readInt();
                this.eT = parcel.readFloat();
                this.eU = parcel.readByte() != (byte) 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.eS);
                parcel.writeFloat(this.eT);
                parcel.writeByte((byte) (this.eU ? 1 : 0));
            }
        }

        public static abstract class a {
            public abstract boolean J();
        }

        public final /* bridge */ /* synthetic */ int I() {
            return super.I();
        }

        final /* synthetic */ int a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            view = (AppBarLayout) view;
            int H = H();
            if (i2 == 0 || H < i2 || H > i3) {
                this.eG = 0;
                return 0;
            }
            int b = n.b(i, i2, i3);
            if (H == b) {
                return 0;
            }
            int abs;
            int i4;
            int height;
            if (view.eA) {
                abs = Math.abs(b);
                int childCount = view.getChildCount();
                i4 = 0;
                while (i4 < childCount) {
                    View childAt = view.getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    Interpolator interpolator = layoutParams.eW;
                    if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                        i4++;
                    } else {
                        if (interpolator != null) {
                            i4 = layoutParams.eV;
                            if ((i4 & 1) != 0) {
                                height = (layoutParams.bottomMargin + (childAt.getHeight() + layoutParams.topMargin)) + 0;
                                if ((i4 & 2) != 0) {
                                    height -= z.U(childAt);
                                }
                            } else {
                                height = 0;
                            }
                            if (z.aa(childAt)) {
                                height -= view.G();
                            }
                            if (height > 0) {
                                i4 = abs - childAt.getTop();
                                height = Math.round(interpolator.getInterpolation(((float) i4) / ((float) height)) * ((float) height));
                                height = (height + childAt.getTop()) * Integer.signum(b);
                            }
                        }
                        height = b;
                    }
                }
                height = b;
            } else {
                height = b;
            }
            boolean f = super.f(height);
            i4 = H - b;
            this.eG = b - height;
            if (!f && view.eA) {
                abs = coordinatorLayout.ha.size();
                H = 0;
                b = 0;
                while (H < abs) {
                    View view2 = (View) coordinatorLayout.ha.get(H);
                    if (view2 == view) {
                        height = 1;
                    } else {
                        if (b != 0) {
                            d dVar = (d) view2.getLayoutParams();
                            android.support.design.widget.CoordinatorLayout.Behavior behavior = dVar.hu;
                            if (behavior != null && dVar.c(coordinatorLayout, view2, view)) {
                                behavior.b(coordinatorLayout, view2, view);
                            }
                        }
                        height = b;
                    }
                    H++;
                    b = height;
                }
            }
            j(view);
            return i4;
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, (View) appBarLayout, savedState.getSuperState());
                this.eK = savedState.eS;
                this.eM = savedState.eT;
                this.eL = savedState.eU;
                return;
            }
            super.a(coordinatorLayout, (View) appBarLayout, parcelable);
            this.eK = -1;
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!this.eI) {
                a(coordinatorLayout, appBarLayout);
            }
            this.eH = false;
            this.eI = false;
            this.eN = new WeakReference(view2);
        }

        public final /* synthetic */ void a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int[] iArr) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i != 0 && !this.eH) {
                int i2;
                int b;
                if (i < 0) {
                    i2 = -appBarLayout.F();
                    b = i2 + AppBarLayout.b(appBarLayout);
                } else {
                    i2 = -appBarLayout.F();
                    b = 0;
                }
                iArr[1] = b(coordinatorLayout, appBarLayout, i, i2, b);
            }
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, float f, boolean z) {
            boolean z2 = true;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (z) {
                int b;
                if (f < 0.0f) {
                    b = (-appBarLayout.F()) + AppBarLayout.b(appBarLayout);
                    if (H() < b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                } else {
                    b = -appBarLayout.F();
                    if (H() > b) {
                        a(coordinatorLayout, appBarLayout, b);
                    }
                }
                z2 = false;
            } else {
                z2 = a(coordinatorLayout, appBarLayout, -appBarLayout.F(), -f);
            }
            this.eI = z2;
            return z2;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean a = super.a(coordinatorLayout, appBarLayout, i);
            int e = appBarLayout.eC;
            if (e != 0) {
                int i2 = (e & 4) != 0 ? 1 : 0;
                if ((e & 2) != 0) {
                    e = -appBarLayout.F();
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, e);
                    } else {
                        c(coordinatorLayout, appBarLayout, e);
                    }
                } else if ((e & 1) != 0) {
                    if (i2 != 0) {
                        a(coordinatorLayout, appBarLayout, 0);
                    } else {
                        c(coordinatorLayout, appBarLayout, 0);
                    }
                }
            } else if (this.eK >= 0) {
                View childAt = appBarLayout.getChildAt(this.eK);
                e = -childAt.getBottom();
                super.f(this.eL ? z.U(childAt) + e : Math.round(((float) childAt.getHeight()) * this.eM) + e);
            }
            appBarLayout.eC = 0;
            this.eK = -1;
            super.f(n.b(super.I(), -appBarLayout.F(), 0));
            j(appBarLayout);
            return a;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            View view2 = (AppBarLayout) view;
            if (((d) view2.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, view2, i, i2, i3, i4);
            }
            coordinatorLayout.a(view2, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && AppBarLayout.a(appBarLayout) && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight();
            if (z && this.eJ != null) {
                this.eJ.ll.cancel();
            }
            this.eN = null;
            return z;
        }

        final /* synthetic */ int b(View view) {
            return ((AppBarLayout) view).F();
        }

        public final /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = false;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            Parcelable b = super.b(coordinatorLayout, appBarLayout);
            int I = super.I();
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + I;
                if (childAt.getTop() + I > 0 || bottom < 0) {
                    i++;
                } else {
                    SavedState savedState = new SavedState(b);
                    savedState.eS = i;
                    if (bottom == z.U(childAt)) {
                        z = true;
                    }
                    savedState.eU = z;
                    savedState.eT = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return b;
        }

        public final /* synthetic */ void b(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i < 0) {
                b(coordinatorLayout, appBarLayout, i, -AppBarLayout.d(appBarLayout), 0);
                this.eH = true;
                return;
            }
            this.eH = false;
        }

        final /* synthetic */ int c(View view) {
            return -AppBarLayout.d((AppBarLayout) view);
        }

        final /* synthetic */ boolean d(View view) {
            if (this.eO != null) {
                return this.eO.J();
            }
            if (this.eN != null) {
                View view2 = (View) this.eN.get();
                if (view2 == null || !view2.isShown() || z.h(view2, -1)) {
                    return false;
                }
            }
            return true;
        }

        public final /* bridge */ /* synthetic */ boolean f(int i) {
            return super.f(i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private void a(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i) {
            int H = H();
            if (H != i) {
                if (this.eJ == null) {
                    this.eJ = aa.av();
                    this.eJ.setInterpolator(a.ew);
                    this.eJ.a(new c(this) {
                        final /* synthetic */ Behavior eR;

                        public final void a(u uVar) {
                            this.eR.c(coordinatorLayout, appBarLayout, uVar.ll.aw());
                        }
                    });
                } else {
                    this.eJ.ll.cancel();
                }
                this.eJ.setDuration(Math.round(((((float) Math.abs(H - i)) / coordinatorLayout.getResources().getDisplayMetrics().density) * 1000.0f) / 300.0f));
                this.eJ.e(H, i);
                this.eJ.ll.start();
            } else if (this.eJ != null && this.eJ.ll.isRunning()) {
                this.eJ.ll.cancel();
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int i;
            View view;
            int H = H();
            int childCount = appBarLayout.getChildCount();
            for (i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                if (childAt.getTop() <= (-H) && childAt.getBottom() >= (-H)) {
                    view = childAt;
                    break;
                }
            }
            view = null;
            if (view != null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.eV & 17) == 17) {
                    int U;
                    childCount = -view.getTop();
                    i = -view.getBottom();
                    if ((layoutParams.eV & 2) == 2) {
                        U = z.U(view) + i;
                    } else {
                        U = i;
                    }
                    if (H >= (U + childCount) / 2) {
                        U = childCount;
                    }
                    a(coordinatorLayout, appBarLayout, n.b(U, -appBarLayout.F(), 0));
                }
            }
        }

        private void j(AppBarLayout appBarLayout) {
            List h = appBarLayout.eE;
            int size = h.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) h.get(i);
                if (aVar != null) {
                    aVar.a(appBarLayout, super.I());
                }
            }
        }

        final int H() {
            return super.I() + this.eG;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public final /* bridge */ /* synthetic */ int I() {
            return super.I();
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        public final /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cF);
            this.iJ = obtainStyledAttributes.getDimensionPixelSize(i.cG, 0);
            obtainStyledAttributes.recycle();
        }

        public final boolean e(View view) {
            return view instanceof AppBarLayout;
        }

        public final boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            android.support.design.widget.CoordinatorLayout.Behavior behavior = ((d) view2.getLayoutParams()).hu;
            if (behavior instanceof Behavior) {
                int bottom = view2.getBottom() - view.getTop();
                z.j(view, ((((Behavior) behavior).eG + bottom) + this.iI) - o(view2));
            }
            return false;
        }

        final float f(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int F = appBarLayout.F();
                int b = AppBarLayout.b(appBarLayout);
                android.support.design.widget.CoordinatorLayout.Behavior behavior = ((d) appBarLayout.getLayoutParams()).hu;
                int H = behavior instanceof Behavior ? ((Behavior) behavior).H() : 0;
                if (b != 0 && F + H <= b) {
                    return 0.0f;
                }
                F -= b;
                if (F != 0) {
                    return (((float) H) / ((float) F)) + 1.0f;
                }
            }
            return 0.0f;
        }

        final View c(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return view;
                }
            }
            return null;
        }

        final int g(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).F();
            }
            return super.g(view);
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m0generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    public /* synthetic */ android.widget.LinearLayout.LayoutParams m1generateLayoutParams(AttributeSet attributeSet) {
        return a(attributeSet);
    }

    protected /* synthetic */ android.widget.LinearLayout.LayoutParams m2generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return a(layoutParams);
    }

    static /* synthetic */ ap a(AppBarLayout appBarLayout, ap apVar) {
        ap apVar2 = null;
        if (z.aa(appBarLayout)) {
            apVar2 = apVar;
        }
        if (apVar2 != appBarLayout.eD) {
            appBarLayout.eD = apVar2;
            appBarLayout.E();
        }
        return apVar;
    }

    static /* synthetic */ boolean a(AppBarLayout appBarLayout) {
        return appBarLayout.F() != 0;
    }

    static /* synthetic */ int b(AppBarLayout appBarLayout) {
        if (appBarLayout.ey != -1) {
            return appBarLayout.ey;
        }
        int i;
        int childCount = appBarLayout.getChildCount() - 1;
        int i2 = 0;
        while (childCount >= 0) {
            View childAt = appBarLayout.getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.eV;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
                i = i2;
            } else {
                i = (layoutParams.bottomMargin + layoutParams.topMargin) + i2;
                i = (i3 & 8) != 0 ? i + z.U(childAt) : (i3 & 2) != 0 ? i + (measuredHeight - z.U(childAt)) : i + measuredHeight;
            }
            childCount--;
            i2 = i;
        }
        i = Math.max(0, i2);
        appBarLayout.ey = i;
        return i;
    }

    static /* synthetic */ int d(AppBarLayout appBarLayout) {
        if (appBarLayout.ez != -1) {
            return appBarLayout.ez;
        }
        int i;
        int childCount = appBarLayout.getChildCount();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = appBarLayout.getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            i = layoutParams.eV;
            if ((i & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i & 2) != 0) {
                i = i2 - (z.U(childAt) + appBarLayout.G());
                break;
            }
        }
        i = i2;
        i = Math.max(0, i);
        appBarLayout.ez = i;
        return i;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        int i = 1;
        int i2 = 0;
        super(context, attributeSet);
        setOrientation(1);
        t.g(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.bc, 0, h.aN);
        this.eB = (float) obtainStyledAttributes.getDimensionPixelSize(i.bh, 0);
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(i.bg));
        if (obtainStyledAttributes.hasValue(i.bi)) {
            boolean z = obtainStyledAttributes.getBoolean(i.bi, false);
            boolean aj = z.aj(this);
            if (!z) {
                i = 2;
            }
            if (aj) {
                i2 = 4;
            }
            this.eC = i2 | i;
            requestLayout();
        }
        obtainStyledAttributes.recycle();
        aa.u(this);
        this.eE = new ArrayList();
        z.g((View) this, this.eB);
        z.b((View) this, new t(this) {
            final /* synthetic */ AppBarLayout eF;

            {
                this.eF = r1;
            }

            public final ap a(View view, ap apVar) {
                return AppBarLayout.a(this.eF, apVar);
            }
        });
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        E();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        E();
        this.eA = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).eW != null) {
                this.eA = true;
                return;
            }
        }
    }

    private void E() {
        this.ex = -1;
        this.ey = -1;
        this.ez = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams a(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private static LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public final int F() {
        if (this.ex != -1) {
            return this.ex;
        }
        int U;
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.eV;
            if ((i3 & 1) == 0) {
                break;
            }
            i += layoutParams.bottomMargin + (measuredHeight + layoutParams.topMargin);
            if ((i3 & 2) != 0) {
                U = i - z.U(childAt);
                break;
            }
        }
        U = i;
        U = Math.max(0, U - G());
        this.ex = U;
        return U;
    }

    final int G() {
        return this.eD != null ? this.eD.getSystemWindowInsetTop() : 0;
    }
}
