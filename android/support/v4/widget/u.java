package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public final class u {
    private static final Interpolator yp = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    int EK;
    float[] EL;
    float[] EM;
    float[] EN;
    float[] EO;
    private int[] EP;
    private int[] EQ;
    private int[] ER;
    private int ES;
    private float ET;
    float EU;
    int EV;
    int EW;
    private final a EX;
    View EY;
    private boolean EZ;
    private final ViewGroup Fa;
    private final Runnable Fb = new Runnable(this) {
        final /* synthetic */ u Fc;

        {
            this.Fc = r1;
        }

        public final void run() {
            this.Fc.ao(0);
        }
    };
    private VelocityTracker fk;
    private int fl = -1;
    private q iB;
    public int iE;

    public static abstract class a {
        public abstract boolean b(View view, int i);

        public void j(int i) {
        }

        public void a(View view, int i, int i2) {
        }

        public void f(View view, int i) {
        }

        public void a(View view, float f, float f2) {
        }

        public void cq() {
        }

        public void n(int i, int i2) {
        }

        public int s(View view) {
            return 0;
        }

        public int K() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }

        public int c(View view, int i) {
            return 0;
        }
    }

    public static u a(ViewGroup viewGroup, a aVar) {
        return new u(viewGroup.getContext(), viewGroup, aVar);
    }

    public static u a(ViewGroup viewGroup, float f, a aVar) {
        u a = a(viewGroup, aVar);
        a.iE = (int) (((float) a.iE) * (1.0f / f));
        return a;
    }

    private u(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.Fa = viewGroup;
            this.EX = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.EV = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.iE = viewConfiguration.getScaledTouchSlop();
            this.ET = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.EU = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.iB = q.a(context, yp);
        }
    }

    public final void n(View view, int i) {
        if (view.getParent() != this.Fa) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.Fa + ")");
        }
        this.EY = view;
        this.fl = i;
        this.EX.f(view, i);
        ao(1);
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

    public final void abort() {
        cancel();
        if (this.EK == 2) {
            this.iB.getCurrX();
            this.iB.getCurrY();
            this.iB.abortAnimation();
            this.EX.a(this.EY, this.iB.getCurrX(), this.iB.getCurrY());
        }
        ao(0);
    }

    public final boolean e(View view, int i, int i2) {
        this.EY = view;
        this.fl = -1;
        boolean e = e(i, i2, 0, 0);
        if (!(e || this.EK != 0 || this.EY == null)) {
            this.EY = null;
        }
        return e;
    }

    public final boolean q(int i, int i2) {
        if (this.EZ) {
            return e(i, i2, (int) y.a(this.fk, this.fl), (int) y.b(this.fk, this.fl));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean e(int i, int i2, int i3, int i4) {
        int left = this.EY.getLeft();
        int top = this.EY.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.iB.abortAnimation();
            ao(0);
            return false;
        }
        View view = this.EY;
        int h = h(i3, (int) this.EU, (int) this.ET);
        int h2 = h(i4, (int) this.EU, (int) this.ET);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(h);
        int abs4 = Math.abs(h2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        this.iB.startScroll(left, top, i5, i6, (int) (((h2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) g(i6, h2, this.EX.K()))) + ((h != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) g(i5, h, this.EX.s(view))))));
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

    public final boolean cH() {
        if (this.EK == 2) {
            boolean computeScrollOffset = this.iB.computeScrollOffset();
            int currX = this.iB.getCurrX();
            int currY = this.iB.getCurrY();
            int left = currX - this.EY.getLeft();
            int top = currY - this.EY.getTop();
            if (left != 0) {
                z.k(this.EY, left);
            }
            if (top != 0) {
                z.j(this.EY, top);
            }
            if (!(left == 0 && top == 0)) {
                this.EX.a(this.EY, currX, currY);
            }
            if (computeScrollOffset && currX == this.iB.getFinalX() && currY == this.iB.getFinalY()) {
                this.iB.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.Fa.post(this.Fb);
            }
        }
        if (this.EK == 2) {
            return true;
        }
        return false;
    }

    private void i(float f, float f2) {
        this.EZ = true;
        this.EX.a(this.EY, f, f2);
        this.EZ = false;
        if (this.EK == 1) {
            ao(0);
        }
    }

    private void am(int i) {
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

    private void a(float f, float f2, int i) {
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

    private void i(MotionEvent motionEvent) {
        int f = o.f(motionEvent);
        for (int i = 0; i < f; i++) {
            int c = o.c(motionEvent, i);
            float d = o.d(motionEvent, i);
            float e = o.e(motionEvent, i);
            this.EN[c] = d;
            this.EO[c] = e;
        }
    }

    public final boolean an(int i) {
        return (this.ES & (1 << i)) != 0;
    }

    final void ao(int i) {
        this.Fa.removeCallbacks(this.Fb);
        if (this.EK != i) {
            this.EK = i;
            this.EX.j(i);
            if (this.EK == 0) {
                this.EY = null;
            }
        }
    }

    private boolean o(View view, int i) {
        if (view == this.EY && this.fl == i) {
            return true;
        }
        if (view == null || !this.EX.b(view, i)) {
            return false;
        }
        this.fl = i;
        n(view, i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.view.o.d(r14);
        r1 = android.support.v4.view.o.e(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.cancel();
    L_0x000d:
        r2 = r13.fk;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.fk = r2;
    L_0x0017:
        r2 = r13.fk;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x011f;
            case 2: goto L_0x008c;
            case 3: goto L_0x011f;
            case 4: goto L_0x001f;
            case 5: goto L_0x0057;
            case 6: goto L_0x0116;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.EK;
        r1 = 1;
        if (r0 != r1) goto L_0x0124;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.view.o.c(r14, r2);
        r13.a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.r(r0, r1);
        r1 = r13.EY;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.EK;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.o(r0, r2);
    L_0x0048:
        r0 = r13.EP;
        r0 = r0[r2];
        r1 = r13.EW;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0051:
        r0 = r13.EX;
        r0.cq();
        goto L_0x001f;
    L_0x0057:
        r0 = android.support.v4.view.o.c(r14, r1);
        r2 = android.support.v4.view.o.d(r14, r1);
        r1 = android.support.v4.view.o.e(r14, r1);
        r13.a(r2, r1, r0);
        r3 = r13.EK;
        if (r3 != 0) goto L_0x0079;
    L_0x006a:
        r1 = r13.EP;
        r0 = r1[r0];
        r1 = r13.EW;
        r0 = r0 & r1;
        if (r0 == 0) goto L_0x001f;
    L_0x0073:
        r0 = r13.EX;
        r0.cq();
        goto L_0x001f;
    L_0x0079:
        r3 = r13.EK;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x007e:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.r(r2, r1);
        r2 = r13.EY;
        if (r1 != r2) goto L_0x001f;
    L_0x0088:
        r13.o(r1, r0);
        goto L_0x001f;
    L_0x008c:
        r0 = r13.EL;
        if (r0 == 0) goto L_0x001f;
    L_0x0090:
        r0 = r13.EM;
        if (r0 == 0) goto L_0x001f;
    L_0x0094:
        r2 = android.support.v4.view.o.f(r14);
        r0 = 0;
        r1 = r0;
    L_0x009a:
        if (r1 >= r2) goto L_0x0111;
    L_0x009c:
        r3 = android.support.v4.view.o.c(r14, r1);
        r0 = r13.ap(r3);
        if (r0 == 0) goto L_0x010b;
    L_0x00a6:
        r0 = android.support.v4.view.o.d(r14, r1);
        r4 = android.support.v4.view.o.e(r14, r1);
        r5 = r13.EL;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.EM;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.r(r0, r4);
        if (r4 == 0) goto L_0x010f;
    L_0x00c2:
        r0 = r13.b(r4, r5, r6);
        if (r0 == 0) goto L_0x010f;
    L_0x00c8:
        r0 = 1;
    L_0x00c9:
        if (r0 == 0) goto L_0x00fb;
    L_0x00cb:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.EX;
        r8 = r9.d(r4, r8);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.EX;
        r10 = r11.c(r4, r10);
        r11 = r13.EX;
        r11 = r11.s(r4);
        r12 = r13.EX;
        r12 = r12.K();
        if (r11 == 0) goto L_0x00f5;
    L_0x00f1:
        if (r11 <= 0) goto L_0x00fb;
    L_0x00f3:
        if (r8 != r7) goto L_0x00fb;
    L_0x00f5:
        if (r12 == 0) goto L_0x0111;
    L_0x00f7:
        if (r12 <= 0) goto L_0x00fb;
    L_0x00f9:
        if (r10 == r9) goto L_0x0111;
    L_0x00fb:
        r13.b(r5, r6, r3);
        r5 = r13.EK;
        r6 = 1;
        if (r5 == r6) goto L_0x0111;
    L_0x0103:
        if (r0 == 0) goto L_0x010b;
    L_0x0105:
        r0 = r13.o(r4, r3);
        if (r0 != 0) goto L_0x0111;
    L_0x010b:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x009a;
    L_0x010f:
        r0 = 0;
        goto L_0x00c9;
    L_0x0111:
        r13.i(r14);
        goto L_0x001f;
    L_0x0116:
        r0 = android.support.v4.view.o.c(r14, r1);
        r13.am(r0);
        goto L_0x001f;
    L_0x011f:
        r13.cancel();
        goto L_0x001f;
    L_0x0124:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.u.j(android.view.MotionEvent):boolean");
    }

    public final void k(MotionEvent motionEvent) {
        int i = 0;
        int d = o.d(motionEvent);
        int e = o.e(motionEvent);
        if (d == 0) {
            cancel();
        }
        if (this.fk == null) {
            this.fk = VelocityTracker.obtain();
        }
        this.fk.addMovement(motionEvent);
        float x;
        float y;
        View r;
        int left;
        switch (d) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = o.c(motionEvent, 0);
                r = r((int) x, (int) y);
                a(x, y, i);
                o(r, i);
                if ((this.EP[i] & this.EW) != 0) {
                    this.EX.cq();
                    return;
                }
                return;
            case 1:
                if (this.EK == 1) {
                    cI();
                }
                cancel();
                return;
            case 2:
                int f;
                if (this.EK != 1) {
                    f = o.f(motionEvent);
                    while (i < f) {
                        d = o.c(motionEvent, i);
                        if (ap(d)) {
                            float d2 = o.d(motionEvent, i);
                            float e2 = o.e(motionEvent, i);
                            float f2 = d2 - this.EL[d];
                            float f3 = e2 - this.EM[d];
                            b(f2, f3, d);
                            if (this.EK != 1) {
                                r = r((int) d2, (int) e2);
                                if (b(r, f2, f3) && o(r, d)) {
                                }
                            }
                            i(motionEvent);
                            return;
                        }
                        i++;
                    }
                    i(motionEvent);
                    return;
                } else if (ap(this.fl)) {
                    i = o.b(motionEvent, this.fl);
                    x = o.d(motionEvent, i);
                    d = (int) (x - this.EN[this.fl]);
                    e = (int) (o.e(motionEvent, i) - this.EO[this.fl]);
                    f = this.EY.getLeft() + d;
                    i = this.EY.getTop() + e;
                    left = this.EY.getLeft();
                    int top = this.EY.getTop();
                    if (d != 0) {
                        f = this.EX.d(this.EY, f);
                        z.k(this.EY, f - left);
                    }
                    if (e != 0) {
                        i = this.EX.c(this.EY, i);
                        z.j(this.EY, i - top);
                    }
                    if (!(d == 0 && e == 0)) {
                        this.EX.a(this.EY, f, i);
                    }
                    i(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.EK == 1) {
                    i(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = o.c(motionEvent, e);
                x = o.d(motionEvent, e);
                y = o.e(motionEvent, e);
                a(x, y, i);
                if (this.EK == 0) {
                    o(r((int) x, (int) y), i);
                    if ((this.EP[i] & this.EW) != 0) {
                        this.EX.cq();
                        return;
                    }
                    return;
                }
                if (f(this.EY, (int) x, (int) y)) {
                    o(this.EY, i);
                    return;
                }
                return;
            case 6:
                d = o.c(motionEvent, e);
                if (this.EK == 1 && d == this.fl) {
                    e = o.f(motionEvent);
                    while (i < e) {
                        left = o.c(motionEvent, i);
                        if (left != this.fl) {
                            if (r((int) o.d(motionEvent, i), (int) o.e(motionEvent, i)) == this.EY && o(this.EY, left)) {
                                i = this.fl;
                                if (i == -1) {
                                    cI();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        cI();
                    }
                }
                am(d);
                return;
            default:
                return;
        }
    }

    private void b(float f, float f2, int i) {
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
            iArr[i] = iArr[i] | i2;
            this.EX.n(i2, i);
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

    private boolean b(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.EX.s(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.EX.K() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.iE * this.iE))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.iE)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.iE)) {
            return false;
        } else {
            return true;
        }
    }

    private void cI() {
        this.fk.computeCurrentVelocity(1000, this.ET);
        i(e(y.a(this.fk, this.fl), this.EU, this.ET), e(y.b(this.fk, this.fl), this.EU, this.ET));
    }

    public static boolean f(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
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

    private boolean ap(int i) {
        if (an(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
