package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ad.AnonymousClass1;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.WeakHashMap;

public final class z {
    static final m xZ;

    interface m {
        int C(View view);

        boolean D(View view);

        boolean E(View view);

        void F(View view);

        int G(View view);

        float H(View view);

        int I(View view);

        int J(View view);

        ViewParent K(View view);

        boolean L(View view);

        int M(View view);

        int N(View view);

        int P(View view);

        int Q(View view);

        float R(View view);

        float S(View view);

        int T(View view);

        int U(View view);

        ai V(View view);

        float W(View view);

        float X(View view);

        int Y(View view);

        void Z(View view);

        ap a(View view, ap apVar);

        void a(View view, int i, Paint paint);

        void a(View view, ColorStateList colorStateList);

        void a(View view, Paint paint);

        void a(View view, Mode mode);

        void a(View view, a aVar);

        void a(View view, Runnable runnable);

        void a(View view, Runnable runnable, long j);

        void a(View view, boolean z);

        void a(ViewGroup viewGroup, boolean z);

        boolean aa(View view);

        void ab(View view);

        boolean ad(View view);

        boolean ae(View view);

        ColorStateList af(View view);

        Mode ag(View view);

        boolean ah(View view);

        void ai(View view);

        boolean aj(View view);

        float ak(View view);

        boolean al(View view);

        boolean am(View view);

        ap b(View view, ap apVar);

        void b(View view, float f);

        void b(View view, int i, int i2, int i3, int i4);

        void b(View view, t tVar);

        void b(View view, boolean z);

        void c(View view, float f);

        void c(View view, int i, int i2);

        void c(View view, int i, int i2, int i3, int i4);

        void c(View view, boolean z);

        int combineMeasuredStates(int i, int i2);

        void d(View view, float f);

        void e(View view, float f);

        void f(View view, float f);

        void g(View view, float f);

        boolean g(View view, int i);

        boolean h(View view, int i);

        void i(View view, int i);

        void j(View view, int i);

        void k(View view, int i);

        void l(View view, int i);

        int resolveSizeAndState(int i, int i2, int i3);
    }

    static class a implements m {
        WeakHashMap<View, ai> ya = null;

        a() {
        }

        public boolean g(View view, int i) {
            if (view instanceof w) {
                boolean z;
                w wVar = (w) view;
                int computeHorizontalScrollOffset = wVar.computeHorizontalScrollOffset();
                int computeHorizontalScrollRange = wVar.computeHorizontalScrollRange() - wVar.computeHorizontalScrollExtent();
                if (computeHorizontalScrollRange != 0) {
                    if (i < 0) {
                        z = computeHorizontalScrollOffset > 0;
                    } else if (computeHorizontalScrollOffset < computeHorizontalScrollRange - 1) {
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public boolean h(View view, int i) {
            if (view instanceof w) {
                boolean z;
                w wVar = (w) view;
                int computeVerticalScrollOffset = wVar.computeVerticalScrollOffset();
                int computeVerticalScrollRange = wVar.computeVerticalScrollRange() - wVar.computeVerticalScrollExtent();
                if (computeVerticalScrollRange != 0) {
                    if (i < 0) {
                        z = computeVerticalScrollOffset > 0;
                    } else if (computeVerticalScrollOffset < computeVerticalScrollRange - 1) {
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
                z = false;
                if (z) {
                    return true;
                }
            }
            return false;
        }

        public int C(View view) {
            return 2;
        }

        public void a(View view, a aVar) {
        }

        public boolean D(View view) {
            return false;
        }

        public boolean E(View view) {
            return false;
        }

        public void F(View view) {
            view.invalidate();
        }

        public void b(View view, int i, int i2, int i3, int i4) {
            view.invalidate(i, i2, i3, i4);
        }

        public void a(View view, Runnable runnable) {
            view.postDelayed(runnable, bN());
        }

        public void a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, bN() + j);
        }

        long bN() {
            return 10;
        }

        public int G(View view) {
            return 0;
        }

        public void i(View view, int i) {
        }

        public float H(View view) {
            return 1.0f;
        }

        public void a(View view, int i, Paint paint) {
        }

        public int I(View view) {
            return 0;
        }

        public void a(View view, Paint paint) {
        }

        public int J(View view) {
            return 0;
        }

        public ViewParent K(View view) {
            return view.getParent();
        }

        public boolean L(View view) {
            Drawable background = view.getBackground();
            if (background == null || background.getOpacity() != -1) {
                return false;
            }
            return true;
        }

        public int resolveSizeAndState(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int M(View view) {
            return view.getMeasuredWidth();
        }

        public int N(View view) {
            return 0;
        }

        public void l(View view, int i) {
        }

        public int P(View view) {
            return view.getPaddingLeft();
        }

        public int Q(View view) {
            return view.getPaddingRight();
        }

        public void c(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public boolean ad(View view) {
            return true;
        }

        public float R(View view) {
            return 0.0f;
        }

        public float S(View view) {
            return 0.0f;
        }

        public float W(View view) {
            return 0.0f;
        }

        public int T(View view) {
            return aa.T(view);
        }

        public int U(View view) {
            return aa.U(view);
        }

        public ai V(View view) {
            return new ai(view);
        }

        public void b(View view, float f) {
        }

        public void c(View view, float f) {
        }

        public void d(View view, float f) {
        }

        public void e(View view, float f) {
        }

        public void f(View view, float f) {
        }

        public int Y(View view) {
            return 0;
        }

        public void Z(View view) {
        }

        public void g(View view, float f) {
        }

        public float X(View view) {
            return 0.0f;
        }

        public float an(View view) {
            return 0.0f;
        }

        public void a(ViewGroup viewGroup, boolean z) {
        }

        public boolean aa(View view) {
            return false;
        }

        public void a(View view, boolean z) {
        }

        public void ab(View view) {
        }

        public void b(View view, t tVar) {
        }

        public ap a(View view, ap apVar) {
            return apVar;
        }

        public ap b(View view, ap apVar) {
            return apVar;
        }

        public void c(View view, boolean z) {
        }

        public void b(View view, boolean z) {
        }

        public boolean ae(View view) {
            return false;
        }

        public boolean ah(View view) {
            if (view instanceof p) {
                return ((p) view).isNestedScrollingEnabled();
            }
            return false;
        }

        public ColorStateList af(View view) {
            return view instanceof x ? ((x) view).bL() : null;
        }

        public void a(View view, ColorStateList colorStateList) {
            if (view instanceof x) {
                ((x) view).d(colorStateList);
            }
        }

        public void a(View view, Mode mode) {
            if (view instanceof x) {
                ((x) view).a(mode);
            }
        }

        public Mode ag(View view) {
            return view instanceof x ? ((x) view).bM() : null;
        }

        public void ai(View view) {
            if (view instanceof p) {
                ((p) view).stopNestedScroll();
            }
        }

        public boolean aj(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public int combineMeasuredStates(int i, int i2) {
            return i | i2;
        }

        public float ak(View view) {
            return an(view) + X(view);
        }

        public boolean al(View view) {
            return view.getWindowToken() != null;
        }

        public boolean am(View view) {
            return false;
        }

        public void c(View view, int i, int i2) {
        }

        public void k(View view, int i) {
            int left = view.getLeft();
            view.offsetLeftAndRight(i);
            if (i != 0) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    int abs = Math.abs(i);
                    ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                    return;
                }
                view.invalidate();
            }
        }

        public void j(View view, int i) {
            int top = view.getTop();
            view.offsetTopAndBottom(i);
            if (i != 0) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    int abs = Math.abs(i);
                    ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                    return;
                }
                view.invalidate();
            }
        }
    }

    static class b extends a {
        b() {
        }

        public final boolean L(View view) {
            return view.isOpaque();
        }

        public final void a(ViewGroup viewGroup, boolean z) {
            if (ab.yh == null) {
                try {
                    ab.yh = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (NoSuchMethodException e) {
                }
                ab.yh.setAccessible(true);
            }
            try {
                ab.yh.invoke(viewGroup, new Object[]{Boolean.valueOf(true)});
            } catch (IllegalAccessException e2) {
            } catch (IllegalArgumentException e3) {
            } catch (InvocationTargetException e4) {
            }
        }
    }

    static class c extends b {
        c() {
        }

        public final int C(View view) {
            return view.getOverScrollMode();
        }
    }

    static class d extends c {
        d() {
        }

        final long bN() {
            return ValueAnimator.getFrameDelay();
        }

        public final float H(View view) {
            return view.getAlpha();
        }

        public final void a(View view, int i, Paint paint) {
            view.setLayerType(i, paint);
        }

        public final int I(View view) {
            return view.getLayerType();
        }

        public void a(View view, Paint paint) {
            a(view, view.getLayerType(), paint);
            view.invalidate();
        }

        public final int resolveSizeAndState(int i, int i2, int i3) {
            return View.resolveSizeAndState(i, i2, i3);
        }

        public final int M(View view) {
            return view.getMeasuredWidthAndState();
        }

        public final int N(View view) {
            return view.getMeasuredState();
        }

        public final float R(View view) {
            return view.getTranslationX();
        }

        public final float S(View view) {
            return view.getTranslationY();
        }

        public final void b(View view, float f) {
            view.setTranslationX(f);
        }

        public final void c(View view, float f) {
            view.setTranslationY(f);
        }

        public final void d(View view, float f) {
            view.setAlpha(f);
        }

        public final void e(View view, float f) {
            view.setScaleX(f);
        }

        public final void f(View view, float f) {
            view.setScaleY(f);
        }

        public final float W(View view) {
            return view.getScaleX();
        }

        public final void ab(View view) {
            view.jumpDrawablesToCurrentState();
        }

        public final void c(View view, boolean z) {
            view.setSaveFromParentEnabled(false);
        }

        public final void b(View view, boolean z) {
            view.setActivated(z);
        }

        public final int combineMeasuredStates(int i, int i2) {
            return View.combineMeasuredStates(i, i2);
        }

        public void k(View view, int i) {
            ac.k(view, i);
        }

        public void j(View view, int i) {
            ac.j(view, i);
        }
    }

    static class f extends d {
        static Field yb;
        static boolean yc = false;

        f() {
        }

        public final boolean g(View view, int i) {
            return view.canScrollHorizontally(i);
        }

        public final boolean h(View view, int i) {
            return view.canScrollVertically(i);
        }

        public final void a(View view, a aVar) {
            view.setAccessibilityDelegate((AccessibilityDelegate) (aVar == null ? null : aVar.wq));
        }

        public final boolean D(View view) {
            if (yc) {
                return false;
            }
            if (yb == null) {
                try {
                    Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                    yb = declaredField;
                    declaredField.setAccessible(true);
                } catch (Throwable th) {
                    yc = true;
                    return false;
                }
            }
            try {
                if (yb.get(view) != null) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                yc = true;
                return false;
            }
        }

        public final ai V(View view) {
            if (this.ya == null) {
                this.ya = new WeakHashMap();
            }
            ai aiVar = (ai) this.ya.get(view);
            if (aiVar != null) {
                return aiVar;
            }
            aiVar = new ai(view);
            this.ya.put(view, aiVar);
            return aiVar;
        }

        public final void a(View view, boolean z) {
            view.setFitsSystemWindows(z);
        }
    }

    static class e extends f {
        e() {
        }

        public final boolean am(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class g extends e {
        g() {
        }

        public final boolean E(View view) {
            return view.hasTransientState();
        }

        public final void F(View view) {
            view.postInvalidateOnAnimation();
        }

        public final void b(View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        public final void a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public final void a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        public final int G(View view) {
            return view.getImportantForAccessibility();
        }

        public void i(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        public final ViewParent K(View view) {
            return view.getParentForAccessibility();
        }

        public final int T(View view) {
            return view.getMinimumWidth();
        }

        public final int U(View view) {
            return view.getMinimumHeight();
        }

        public void Z(View view) {
            view.requestFitSystemWindows();
        }

        public final boolean aa(View view) {
            return view.getFitsSystemWindows();
        }

        public final boolean ad(View view) {
            return view.hasOverlappingRendering();
        }
    }

    static class h extends g {
        h() {
        }

        public final void a(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public final int J(View view) {
            return view.getLayoutDirection();
        }

        public final int P(View view) {
            return view.getPaddingStart();
        }

        public final int Q(View view) {
            return view.getPaddingEnd();
        }

        public final void c(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        public final int Y(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public final boolean ae(View view) {
            return view.isPaddingRelative();
        }
    }

    static class i extends h {
        i() {
        }
    }

    static class j extends i {
        j() {
        }

        public final void l(View view, int i) {
            view.setAccessibilityLiveRegion(1);
        }

        public final void i(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        public final boolean aj(View view) {
            return view.isLaidOut();
        }

        public final boolean al(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class k extends j {
        k() {
        }

        public final void Z(View view) {
            view.requestApplyInsets();
        }

        public final void g(View view, float f) {
            view.setElevation(f);
        }

        public final float X(View view) {
            return view.getElevation();
        }

        public final float an(View view) {
            return view.getTranslationZ();
        }

        public final void b(View view, t tVar) {
            if (tVar == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new AnonymousClass1(tVar));
            }
        }

        public final boolean ah(View view) {
            return view.isNestedScrollingEnabled();
        }

        public final void ai(View view) {
            view.stopNestedScroll();
        }

        public final ColorStateList af(View view) {
            return view.getBackgroundTintList();
        }

        public final void a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public final void a(View view, Mode mode) {
            view.setBackgroundTintMode(mode);
            if (VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
                if (background != null && obj != null) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        public final Mode ag(View view) {
            return view.getBackgroundTintMode();
        }

        public final ap a(View view, ap apVar) {
            if (!(apVar instanceof aq)) {
                return apVar;
            }
            WindowInsets windowInsets = ((aq) apVar).zI;
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            return onApplyWindowInsets != windowInsets ? new aq(onApplyWindowInsets) : apVar;
        }

        public final ap b(View view, ap apVar) {
            if (!(apVar instanceof aq)) {
                return apVar;
            }
            WindowInsets windowInsets = ((aq) apVar).zI;
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            return dispatchApplyWindowInsets != windowInsets ? new aq(dispatchApplyWindowInsets) : apVar;
        }

        public final float ak(View view) {
            return view.getZ();
        }

        public void k(View view, int i) {
            Object obj;
            Rect bO = ad.bO();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                bO.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !bO.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            ac.k(view, i);
            if (obj != null && bO.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(bO);
            }
        }

        public void j(View view, int i) {
            Object obj;
            Rect bO = ad.bO();
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                bO.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                obj = !bO.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
            } else {
                obj = null;
            }
            ac.j(view, i);
            if (obj != null && bO.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(bO);
            }
        }
    }

    static class l extends k {
        l() {
        }

        public final void c(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        public final void k(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        public final void j(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            xZ = new l();
        } else if (i >= 21) {
            xZ = new k();
        } else if (i >= 19) {
            xZ = new j();
        } else if (i >= 17) {
            xZ = new h();
        } else if (i >= 16) {
            xZ = new g();
        } else if (i >= 15) {
            xZ = new e();
        } else if (i >= 14) {
            xZ = new f();
        } else if (i >= 11) {
            xZ = new d();
        } else if (i >= 9) {
            xZ = new c();
        } else if (i >= 7) {
            xZ = new b();
        } else {
            xZ = new a();
        }
    }

    public static boolean g(View view, int i) {
        return xZ.g(view, i);
    }

    public static boolean h(View view, int i) {
        return xZ.h(view, i);
    }

    public static int C(View view) {
        return xZ.C(view);
    }

    public static void a(View view, a aVar) {
        xZ.a(view, aVar);
    }

    public static boolean D(View view) {
        return xZ.D(view);
    }

    public static boolean E(View view) {
        return xZ.E(view);
    }

    public static void F(View view) {
        xZ.F(view);
    }

    public static void b(View view, int i, int i2, int i3, int i4) {
        xZ.b(view, i, i2, i3, i4);
    }

    public static void a(View view, Runnable runnable) {
        xZ.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        xZ.a(view, runnable, j);
    }

    public static int G(View view) {
        return xZ.G(view);
    }

    public static void i(View view, int i) {
        xZ.i(view, i);
    }

    public static float H(View view) {
        return xZ.H(view);
    }

    public static void a(View view, int i, Paint paint) {
        xZ.a(view, i, paint);
    }

    public static int I(View view) {
        return xZ.I(view);
    }

    public static void a(View view, Paint paint) {
        xZ.a(view, paint);
    }

    public static int J(View view) {
        return xZ.J(view);
    }

    public static ViewParent K(View view) {
        return xZ.K(view);
    }

    public static boolean L(View view) {
        return xZ.L(view);
    }

    public static int resolveSizeAndState(int i, int i2, int i3) {
        return xZ.resolveSizeAndState(i, i2, i3);
    }

    public static int M(View view) {
        return xZ.M(view);
    }

    public static int N(View view) {
        return xZ.N(view);
    }

    public static int combineMeasuredStates(int i, int i2) {
        return xZ.combineMeasuredStates(i, i2);
    }

    public static void O(View view) {
        xZ.l(view, 1);
    }

    public static int P(View view) {
        return xZ.P(view);
    }

    public static int Q(View view) {
        return xZ.Q(view);
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        xZ.c(view, i, i2, i3, i4);
    }

    public static float R(View view) {
        return xZ.R(view);
    }

    public static float S(View view) {
        return xZ.S(view);
    }

    public static int T(View view) {
        return xZ.T(view);
    }

    public static int U(View view) {
        return xZ.U(view);
    }

    public static ai V(View view) {
        return xZ.V(view);
    }

    public static void b(View view, float f) {
        xZ.b(view, f);
    }

    public static void c(View view, float f) {
        xZ.c(view, f);
    }

    public static void d(View view, float f) {
        xZ.d(view, f);
    }

    public static void e(View view, float f) {
        xZ.e(view, f);
    }

    public static void f(View view, float f) {
        xZ.f(view, f);
    }

    public static float W(View view) {
        return xZ.W(view);
    }

    public static void g(View view, float f) {
        xZ.g(view, f);
    }

    public static float X(View view) {
        return xZ.X(view);
    }

    public static int Y(View view) {
        return xZ.Y(view);
    }

    public static void Z(View view) {
        xZ.Z(view);
    }

    public static void a(ViewGroup viewGroup) {
        xZ.a(viewGroup, true);
    }

    public static boolean aa(View view) {
        return xZ.aa(view);
    }

    public static void a(View view, boolean z) {
        xZ.a(view, z);
    }

    public static void ab(View view) {
        xZ.ab(view);
    }

    public static void b(View view, t tVar) {
        xZ.b(view, tVar);
    }

    public static ap a(View view, ap apVar) {
        return xZ.a(view, apVar);
    }

    public static ap b(View view, ap apVar) {
        return xZ.b(view, apVar);
    }

    public static void ac(View view) {
        xZ.c(view, false);
    }

    public static void b(View view, boolean z) {
        xZ.b(view, z);
    }

    public static boolean ad(View view) {
        return xZ.ad(view);
    }

    public static boolean ae(View view) {
        return xZ.ae(view);
    }

    public static ColorStateList af(View view) {
        return xZ.af(view);
    }

    public static void a(View view, ColorStateList colorStateList) {
        xZ.a(view, colorStateList);
    }

    public static Mode ag(View view) {
        return xZ.ag(view);
    }

    public static void a(View view, Mode mode) {
        xZ.a(view, mode);
    }

    public static boolean ah(View view) {
        return xZ.ah(view);
    }

    public static void ai(View view) {
        xZ.ai(view);
    }

    public static boolean aj(View view) {
        return xZ.aj(view);
    }

    public static float ak(View view) {
        return xZ.ak(view);
    }

    public static void j(View view, int i) {
        xZ.j(view, i);
    }

    public static void k(View view, int i) {
        xZ.k(view, i);
    }

    public static boolean al(View view) {
        return xZ.al(view);
    }

    public static boolean am(View view) {
        return xZ.am(view);
    }

    public static void c(View view, int i, int i2) {
        xZ.c(view, i, 3);
    }
}
