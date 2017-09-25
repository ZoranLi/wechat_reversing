package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.widget.q;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Arrays;

public final class a {
    private static final Interpolator yp = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    public int EK;
    public float[] EL;
    public float[] EM;
    public float[] EN;
    public float[] EO;
    public int[] EP;
    private int[] EQ;
    private int[] ER;
    public int ES;
    public float ET;
    public float EU;
    private int EV;
    public int EW;
    public View EY;
    public boolean EZ;
    public final ViewGroup Fa;
    public final Runnable Fb = new Runnable(this) {
        final /* synthetic */ a wjC;

        {
            this.wjC = r1;
        }

        public final void run() {
            this.wjC.ao(0);
        }
    };
    public VelocityTracker fk;
    public int fl = -1;
    public q iB;
    private int iE;
    public final a wjB;

    public static abstract class a {
        public abstract boolean Ca(int i);

        public void j(int i) {
        }

        public void eg(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public int bZo() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }
    }

    public static a a(ViewGroup viewGroup, a aVar) {
        return new a(viewGroup.getContext(), viewGroup, aVar);
    }

    private a(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.Fa = viewGroup;
            this.wjB = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.EV = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.iE = viewConfiguration.getScaledTouchSlop();
            this.ET = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.EU = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.iB = q.a(context, yp);
        }
    }

    public final void cancel() {
        this.fl = -1;
        if (this.EL != null) {
            Arrays.fill(this.EL, 0.0f);
            Arrays.fill(this.EM, 0.0f);
            Arrays.fill(this.EN, 0.0f);
            Arrays.fill(this.EO, 0.0f);
            Arrays.fill(this.EP, 0);
            Arrays.fill(this.EQ, 0);
            Arrays.fill(this.ER, 0);
            this.ES = 0;
        }
        if (this.fk != null) {
            this.fk.recycle();
            this.fk = null;
        }
    }

    public final boolean e(int i, int i2, int i3, int i4) {
        int left = this.EY.getLeft();
        int top = this.EY.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.iB.abortAnimation();
            ao(0);
            return false;
        }
        int h = h(i3, (int) this.EU, (int) this.ET);
        int h2 = h(i4, (int) this.EU, (int) this.ET);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(h);
        int abs4 = Math.abs(h2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        w.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf((int) (((h2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) g(i6, h2, 0))) + ((h != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) g(i5, h, this.wjB.bZo()))))));
        this.iB.startScroll(left, top, i5, i6, abs3);
        ao(2);
        return true;
    }

    private int g(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.Fa.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private static int h(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float e(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final void i(float f, float f2) {
        this.EZ = true;
        this.wjB.a(this.EY, f, f2);
        this.EZ = false;
        if (this.EK == 1) {
            ao(0);
        }
    }

    public final void am(int i) {
        if (this.EL != null) {
            this.EL[i] = 0.0f;
            this.EM[i] = 0.0f;
            this.EN[i] = 0.0f;
            this.EO[i] = 0.0f;
            this.EP[i] = 0;
            this.EQ[i] = 0;
            this.ER[i] = 0;
            this.ES &= (1 << i) ^ -1;
        }
    }

    public final void a(float f, float f2, int i) {
        int i2 = 0;
        if (this.EL == null || this.EL.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.EL != null) {
                System.arraycopy(this.EL, 0, obj, 0, this.EL.length);
                System.arraycopy(this.EM, 0, obj2, 0, this.EM.length);
                System.arraycopy(this.EN, 0, obj3, 0, this.EN.length);
                System.arraycopy(this.EO, 0, obj4, 0, this.EO.length);
                System.arraycopy(this.EP, 0, obj5, 0, this.EP.length);
                System.arraycopy(this.EQ, 0, obj6, 0, this.EQ.length);
                System.arraycopy(this.ER, 0, obj7, 0, this.ER.length);
            }
            this.EL = obj;
            this.EM = obj2;
            this.EN = obj3;
            this.EO = obj4;
            this.EP = obj5;
            this.EQ = obj6;
            this.ER = obj7;
        }
        float[] fArr = this.EL;
        this.EN[i] = f;
        fArr[i] = f;
        fArr = this.EM;
        this.EO[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.EP;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.Fa.getLeft() + this.EV) {
            i2 = 1;
        }
        if (i4 < this.Fa.getTop() + this.EV) {
            i2 |= 4;
        }
        if (i3 > this.Fa.getRight() - this.EV) {
            i2 |= 2;
        }
        if (i4 > this.Fa.getBottom() - this.EV) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.ES |= 1 << i;
    }

    public final void i(MotionEvent motionEvent) {
        int f = o.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = o.c(motionEvent, i);
            float d = o.d(motionEvent, i);
            float e = o.e(motionEvent, i);
            this.EN[c] = d;
            this.EO[c] = e;
        }
    }

    final void ao(int i) {
        if (this.EK != i) {
            this.EK = i;
            this.wjB.j(i);
            if (i == 0) {
                this.EY = null;
            }
        }
    }

    public final boolean o(View view, int i) {
        if (view == this.EY && this.fl == i) {
            return true;
        }
        if (view == null || !this.wjB.Ca(i)) {
            return false;
        }
        this.fl = i;
        if (view.getParent() != this.Fa) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Fa + ")");
        }
        this.EY = view;
        this.fl = i;
        ao(1);
        return true;
    }

    public final void b(float f, float f2, int i) {
        int i2 = 1;
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.EQ;
            iArr[i] = i2 | iArr[i];
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.EP[i] & i2) != i2 || (this.EW & i2) == 0 || (this.ER[i] & i2) == i2 || (this.EQ[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.iE) || abs2 > ((float) this.iE)) && (this.EQ[i] & i2) == 0 && abs > ((float) this.iE)) {
            return true;
        }
        return false;
    }

    public final boolean l(View view, float f) {
        if (view == null) {
            return false;
        }
        if (!(this.wjB.bZo() > 0) || Math.abs(f) <= ((float) this.iE)) {
            return false;
        }
        return true;
    }

    public final void cI() {
        this.fk.computeCurrentVelocity(1000, this.ET);
        i(e(y.a(this.fk, this.fl), this.EU, this.ET), e(y.b(this.fk, this.fl), this.EU, this.ET));
    }

    public final View r(int i, int i2) {
        for (int childCount = this.Fa.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.Fa.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
