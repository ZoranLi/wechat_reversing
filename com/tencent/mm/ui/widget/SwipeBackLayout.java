package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.j;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SwipeBackLayout extends FrameLayout {
    private float BC;
    public View Ih;
    private Rect gG;
    public boolean mEnable;
    private boolean pd;
    public boolean wuc;
    private float wxA;
    private int wxB;
    private int wxC;
    public com.tencent.mm.ui.mogic.a wxD;
    private float wxE;
    public Drawable wxF;
    public boolean wxG;
    private boolean wxH;
    public boolean wxI;
    public boolean wxJ;
    private boolean wxK;
    public a wxL;

    public interface a {
        void VK();

        void VL();

        void onCancel();
    }

    private class b extends com.tencent.mm.ui.mogic.a.a implements com.tencent.mm.ui.base.b.a {
        int wxM = 0;
        int wxN = 0;
        int wxO = 0;
        final /* synthetic */ SwipeBackLayout wxP;

        public b(SwipeBackLayout swipeBackLayout) {
            this.wxP = swipeBackLayout;
        }

        public final boolean Ca(int i) {
            boolean z;
            com.tencent.mm.ui.mogic.a a = this.wxP.wxD;
            if ((a.ES & (1 << i)) != 0) {
                z = true;
            } else {
                z = false;
            }
            return z && (a.EP[i] & 1) != 0;
        }

        public final int bZo() {
            return 1;
        }

        public final void eg(int i, int i2) {
            if (this.wxP.wxI) {
                this.wxP.wxE = Math.abs(((float) i) / ((float) (this.wxP.Ih.getWidth() + this.wxP.wxF.getIntrinsicWidth())));
                this.wxP.wxB = i;
                this.wxP.wxC = i2;
                this.wxP.invalidate();
                if (Float.compare(this.wxP.wxE, 1.0f) >= 0 && !this.wxP.wxJ) {
                    this.wxP.wxJ = true;
                    af.v(new Runnable(this) {
                        final /* synthetic */ b wxQ;

                        {
                            this.wxQ = r1;
                        }

                        public final void run() {
                            if (this.wxQ.wxP.wxL != null) {
                                this.wxQ.wxP.wxL.VK();
                                w.d("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                            }
                            this.wxQ.wxP.wuc = false;
                        }
                    });
                } else if (Float.compare(this.wxP.wxE, 0.01f) <= 0) {
                    this.wxP.wuc = false;
                }
                if (this.wxP.wxD.EK == 1) {
                    j.ax(this.wxP.wxE);
                }
            }
        }

        public final void a(View view, float f, float f2) {
            int width = view.getWidth();
            this.wxN = 0;
            this.wxO = 0;
            width = (f > 0.0f || (f == 0.0f && this.wxP.wxE > this.wxP.wxA)) ? (width + this.wxP.wxF.getIntrinsicWidth()) + 10 : 0;
            this.wxN = width;
            w.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(this.wxN), Integer.valueOf(this.wxO), Boolean.valueOf(this.wxP.wxI));
            this.wxP.wuc = true;
            if (this.wxP.wxI) {
                com.tencent.mm.ui.mogic.a a = this.wxP.wxD;
                int i = this.wxN;
                int i2 = this.wxO;
                if (a.EZ) {
                    a.e(i, i2, (int) y.a(a.fk, a.fl), (int) y.b(a.fk, a.fl));
                    this.wxP.invalidate();
                    return;
                }
                throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            }
            this.wxP.wxK = true;
        }

        public final int d(View view, int i) {
            if (this.wxP.wxI) {
                int max = Math.max(this.wxM, i);
                this.wxM = 0;
                return Math.min(view.getWidth(), Math.max(max, 0));
            }
            this.wxM = Math.max(this.wxM, i);
            return 0;
        }

        public final void j(int i) {
            w.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i), Boolean.valueOf(this.wxP.wxH), Boolean.valueOf(this.wxP.wxK));
            if (1 == i) {
                w.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if (this.wxP.getContext() instanceof Activity) {
                    ((Activity) this.wxP.getContext()).getWindow().getDecorView().setBackgroundResource(d.transparent);
                }
                if (this.wxP.wxL != null) {
                    this.wxP.wxL.VL();
                }
                this.wxP.wxJ = false;
                if (this.wxP.wxI) {
                    j.ax(0.0f);
                }
            }
            if (i == 0 && !this.wxP.wxK) {
                w.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (this.wxP.wxL != null) {
                    this.wxP.wxL.onCancel();
                }
                j.ax(1.0f);
            }
            if (1 == i && this.wxP.wxG && (this.wxP.getContext() instanceof Activity) && !this.wxP.wxI && !this.wxP.wxH) {
                w.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                this.wxP.wxH = true;
                Activity activity = (Activity) this.wxP.getContext();
                if (com.tencent.mm.compatible.util.d.ep(16)) {
                    w.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", Integer.valueOf(VERSION.SDK_INT));
                } else {
                    try {
                        Object newProxyInstance;
                        Class[] declaredClasses = Activity.class.getDeclaredClasses();
                        int length = declaredClasses.length;
                        int i2 = 0;
                        Class cls = null;
                        while (i2 < length) {
                            Class cls2 = declaredClasses[i2];
                            if (!cls2.getSimpleName().contains("TranslucentConversionListener")) {
                                cls2 = cls;
                            }
                            i2++;
                            cls = cls2;
                        }
                        if (this != null) {
                            InvocationHandler bVar = new b();
                            bVar.vfG = new WeakReference(this);
                            newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, bVar);
                        } else {
                            newProxyInstance = null;
                        }
                        Method declaredMethod;
                        if (com.tencent.mm.compatible.util.d.ep(21)) {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance});
                        } else {
                            declaredMethod = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[]{cls, ActivityOptions.class});
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(activity, new Object[]{newProxyInstance, null});
                        }
                    } catch (Throwable th) {
                        w.printErrStackTrace("MicroMsg.ActivityUtil", th, "call convertActivityToTranslucent Fail: %s", th.getMessage());
                    }
                }
            }
            if (2 == i) {
                boolean z;
                w.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.wxN));
                if (this.wxN > 0) {
                    z = true;
                } else {
                    z = false;
                }
                j.u(z, this.wxN);
            }
        }

        public final void kG(final boolean z) {
            af.v(new Runnable(this) {
                final /* synthetic */ b wxQ;

                public final void run() {
                    w.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(this.wxQ.wxN));
                    this.wxQ.wxP.wxH = z;
                    if (!z) {
                        this.wxQ.wxP.wuc = false;
                    } else if (this.wxQ.wxN > 0) {
                        j.ax(0.0f);
                    } else {
                        j.ax(1.0f);
                    }
                    this.wxQ.wxP.lU(z);
                    if (z && this.wxQ.wxP.wxK) {
                        if (this.wxQ.wxN == 0) {
                            j.a(this.wxQ.wxP.Ih, 200, 0.0f, new com.tencent.mm.ui.tools.j.a(this) {
                                final /* synthetic */ AnonymousClass2 wxS;

                                {
                                    this.wxS = r1;
                                }

                                public final void onAnimationEnd() {
                                    this.wxS.wxQ.wxP.wuc = false;
                                }

                                public final void bZJ() {
                                    onAnimationEnd();
                                }
                            });
                        } else {
                            j.a(this.wxQ.wxP.Ih, 200, (float) this.wxQ.wxN, new com.tencent.mm.ui.tools.j.a(this) {
                                final /* synthetic */ AnonymousClass2 wxS;

                                {
                                    this.wxS = r1;
                                }

                                public final void onAnimationEnd() {
                                    this.wxS.wxQ.wxP.wxJ = true;
                                    af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass2 wxT;

                                        {
                                            this.wxT = r1;
                                        }

                                        public final void run() {
                                            if (this.wxT.wxS.wxQ.wxP.wxL != null) {
                                                this.wxT.wxS.wxQ.wxP.wxL.VK();
                                                w.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                                            }
                                            j.ax(1.0f);
                                            this.wxT.wxS.wxQ.wxP.wuc = false;
                                        }
                                    });
                                }

                                public final void bZJ() {
                                    onAnimationEnd();
                                }
                            });
                            j.u(true, this.wxQ.wxN);
                        }
                    }
                    this.wxQ.wxP.wxK = false;
                }
            });
        }
    }

    public SwipeBackLayout(Context context) {
        this(context, null);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.wxA = 0.3f;
        this.mEnable = true;
        this.gG = new Rect();
        this.wxG = true;
        this.wxH = false;
        this.wxI = false;
        this.wxJ = false;
        this.wuc = false;
        this.wxK = false;
        this.wxL = null;
        this.wxF = getResources().getDrawable(f.hbS);
        setFocusable(true);
        setDescendantFocusability(262144);
        init();
    }

    public final void init() {
        this.wxD = com.tencent.mm.ui.mogic.a.a(this, new b(this));
        this.wxD.EW = 1;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 100.0f * f;
        f *= 300.0f;
        this.wxD.EU = f2;
        this.wxD.ET = f;
        this.wxB = 0;
        this.wxC = 0;
    }

    public final void lU(boolean z) {
        w.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.wxI = z;
    }

    public final boolean caO() {
        caP();
        return this.wuc;
    }

    public void onFinishInflate() {
        this.Ih = this;
    }

    public final boolean caP() {
        if (!this.wuc) {
            return false;
        }
        if (Float.compare((float) this.Ih.getLeft(), 0.01f) > 0) {
            return true;
        }
        this.wuc = false;
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.mEnable) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (caP()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        try {
            int d;
            int e;
            float x;
            View r;
            float d2;
            float e2;
            float f;
            float e3;
            if (this.wxD.EK == 1) {
                com.tencent.mm.ui.mogic.a aVar = this.wxD;
                d = o.d(motionEvent);
                e = o.e(motionEvent);
                if (d == 0) {
                    aVar.cancel();
                }
                if (aVar.fk == null) {
                    aVar.fk = VelocityTracker.obtain();
                }
                aVar.fk.addMovement(motionEvent);
                int e4;
                int left;
                int left2;
                switch (d) {
                    case 0:
                        x = motionEvent.getX();
                        float y = motionEvent.getY();
                        e = o.c(motionEvent, 0);
                        r = aVar.r((int) x, (int) y);
                        aVar.a(x, y, e);
                        aVar.o(r, e);
                        return (aVar.EW & aVar.EP[e]) != 0 ? true : true;
                    case 1:
                        if (aVar.EK == 1) {
                            aVar.cI();
                        }
                        aVar.cancel();
                        return true;
                    case 2:
                        if (aVar.EK == 1) {
                            d = o.b(motionEvent, aVar.fl);
                            e = (int) (o.d(motionEvent, d) - aVar.EN[aVar.fl]);
                            e4 = (int) (o.e(motionEvent, d) - aVar.EO[aVar.fl]);
                            left = aVar.EY.getLeft() + e;
                            d = aVar.EY.getTop() + e4;
                            left2 = aVar.EY.getLeft();
                            int top = aVar.EY.getTop();
                            if (e != 0) {
                                left = aVar.wjB.d(aVar.EY, left);
                                aVar.EY.offsetLeftAndRight(left - left2);
                            }
                            if (e4 != 0) {
                                aVar.EY.offsetTopAndBottom(0 - top);
                                d = 0;
                            }
                            if (!(e == 0 && e4 == 0)) {
                                aVar.wjB.eg(left, d);
                            }
                            aVar.i(motionEvent);
                            return true;
                        }
                        left = o.f(motionEvent);
                        d = 0;
                        while (d < left) {
                            e = o.c(motionEvent, d);
                            d2 = o.d(motionEvent, d);
                            e2 = o.e(motionEvent, d);
                            f = d2 - aVar.EL[e];
                            aVar.b(f, e2 - aVar.EM[e], e);
                            if (aVar.EK != 1) {
                                r = aVar.r((int) d2, (int) e2);
                                if (!aVar.l(r, f) || !aVar.o(r, e)) {
                                    d++;
                                }
                            }
                            aVar.i(motionEvent);
                            return true;
                        }
                        aVar.i(motionEvent);
                        return true;
                    case 3:
                        if (aVar.EK == 1) {
                            aVar.i(0.0f, 0.0f);
                        }
                        aVar.cancel();
                        return true;
                    case 5:
                        left = o.c(motionEvent, e);
                        x = o.d(motionEvent, e);
                        e3 = o.e(motionEvent, e);
                        aVar.a(x, e3, left);
                        if (aVar.EK == 0) {
                            aVar.o(aVar.r((int) x, (int) e3), left);
                            return true;
                        }
                        boolean z;
                        d = (int) x;
                        e = (int) e3;
                        r = aVar.EY;
                        if (r == null || d < r.getLeft() || d >= r.getRight() || e < r.getTop() || e >= r.getBottom()) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            return true;
                        }
                        aVar.o(aVar.EY, left);
                        return true;
                    case 6:
                        e = o.c(motionEvent, e);
                        if (aVar.EK == 1 && e == aVar.fl) {
                            e4 = o.f(motionEvent);
                            for (d = 0; d < e4; d++) {
                                left2 = o.c(motionEvent, d);
                                if (left2 != aVar.fl) {
                                    if (aVar.r((int) o.d(motionEvent, d), (int) o.e(motionEvent, d)) == aVar.EY && aVar.o(aVar.EY, left2)) {
                                        d = aVar.fl;
                                        if (d == -1) {
                                            aVar.cI();
                                        }
                                    }
                                }
                            }
                            d = -1;
                            if (d == -1) {
                                aVar.cI();
                            }
                        }
                        aVar.am(e);
                        return true;
                    default:
                        return true;
                }
            }
            com.tencent.mm.ui.mogic.a aVar2 = this.wxD;
            d = o.d(motionEvent);
            int e5 = o.e(motionEvent);
            if (d == 0) {
                aVar2.cancel();
            }
            if (aVar2.fk == null) {
                aVar2.fk = VelocityTracker.obtain();
            }
            aVar2.fk.addMovement(motionEvent);
            float y2;
            switch (d) {
                case 0:
                    x = motionEvent.getX();
                    y2 = motionEvent.getY();
                    e = o.c(motionEvent, 0);
                    aVar2.a(x, y2, e);
                    View r2 = aVar2.r((int) x, (int) y2);
                    if (r2 == aVar2.EY && aVar2.EK == 2) {
                        aVar2.o(r2, e);
                    }
                    if ((aVar2.EP[e] & aVar2.EW) != 0) {
                        break;
                    }
                    break;
                case 1:
                case 3:
                    aVar2.cancel();
                    break;
                case 2:
                    e5 = o.f(motionEvent);
                    d = 0;
                    while (d < e5) {
                        e = o.c(motionEvent, d);
                        d2 = o.d(motionEvent, d);
                        e2 = o.e(motionEvent, d);
                        f = d2 - aVar2.EL[e];
                        aVar2.b(f, e2 - aVar2.EM[e], e);
                        if (aVar2.EK != 1) {
                            r = aVar2.r((int) d2, (int) e2);
                            if (r == null || !aVar2.l(r, f) || !aVar2.o(r, e)) {
                                d++;
                            }
                        }
                        aVar2.i(motionEvent);
                        break;
                    }
                    aVar2.i(motionEvent);
                    break;
                case 5:
                    d = o.c(motionEvent, e5);
                    e3 = o.d(motionEvent, e5);
                    y2 = o.e(motionEvent, e5);
                    aVar2.a(e3, y2, d);
                    if (aVar2.EK != 0 && aVar2.EK == 2) {
                        View r3 = aVar2.r((int) e3, (int) y2);
                        if (r3 == aVar2.EY) {
                            aVar2.o(r3, d);
                            break;
                        }
                    }
                    break;
                case 6:
                    aVar2.am(o.c(motionEvent, e5));
                    break;
            }
            if (aVar2.EK == 1) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        } catch (Throwable e6) {
            w.printErrStackTrace("MicroMsg.SwipeBackLayout", e6, "got an NullPointerException", new Object[0]);
            return false;
        } catch (Throwable e62) {
            w.printErrStackTrace("MicroMsg.SwipeBackLayout", e62, "got an IllegalArgumentException", new Object[0]);
            return false;
        } catch (Throwable e622) {
            w.printErrStackTrace("MicroMsg.SwipeBackLayout", e622, "got an ArrayIndexOutOfBoundsException", new Object[0]);
            return false;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.pd = true;
        if (this.Ih != null) {
            this.Ih.layout(this.wxB, this.wxC, this.wxB + this.Ih.getMeasuredWidth(), this.wxC + this.Ih.getMeasuredHeight());
        }
        this.pd = false;
    }

    public void requestLayout() {
        if (!this.pd) {
            super.requestLayout();
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        Object obj = view == this.Ih ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(Float.compare(this.BC, 0.0f) <= 0 || obj == null || this.wxD.EK == 0)) {
            Rect rect = this.gG;
            view.getHitRect(rect);
            this.wxF.setBounds(rect.left - this.wxF.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.wxF.setAlpha((int) (this.BC * 255.0f));
            this.wxF.draw(canvas);
        }
        return drawChild;
    }

    public void computeScroll() {
        this.BC = Math.max(0.0f, 1.0f - this.wxE);
        com.tencent.mm.ui.mogic.a aVar = this.wxD;
        if (aVar.EK == 2) {
            boolean computeScrollOffset = aVar.iB.computeScrollOffset();
            int currX = aVar.iB.getCurrX();
            int currY = aVar.iB.getCurrY();
            int left = currX - aVar.EY.getLeft();
            int top = currY - aVar.EY.getTop();
            if (left != 0) {
                aVar.EY.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.EY.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.wjB.eg(currX, currY);
            }
            if (computeScrollOffset && currX == aVar.iB.getFinalX() && currY == aVar.iB.getFinalY()) {
                aVar.iB.abortAnimation();
                computeScrollOffset = aVar.iB.isFinished();
            }
            if (!computeScrollOffset) {
                aVar.Fa.post(aVar.Fb);
            }
        }
        if ((aVar.EK == 2 ? 1 : null) != null) {
            z.F(this);
        }
    }
}
