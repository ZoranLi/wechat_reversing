package android.support.v7.widget.a;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.e;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.d;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.t;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public final class a extends g implements i {
    private d ZT = null;
    public RecyclerView aak;
    final List<View> afN = new ArrayList();
    private final float[] afO = new float[2];
    t afP = null;
    float afQ;
    float afR;
    float afS;
    float afT;
    float afU;
    float afV;
    float afW;
    float afX;
    a afY;
    int afZ = 0;
    int aga;
    List<c> agb = new ArrayList();
    private int agc;
    public final Runnable agd = new Runnable(this) {
        final /* synthetic */ a agl;

        {
            this.agl = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r14 = this;
            r12 = -9223372036854775808;
            r6 = 0;
            r8 = 0;
            r0 = r14.agl;
            r0 = r0.afP;
            if (r0 == 0) goto L_0x00dd;
        L_0x000a:
            r9 = r14.agl;
            r0 = r9.afP;
            if (r0 == 0) goto L_0x0134;
        L_0x0010:
            r10 = java.lang.System.currentTimeMillis();
            r0 = r9.agk;
            r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1));
            if (r0 != 0) goto L_0x00de;
        L_0x001a:
            r4 = 0;
        L_0x001c:
            r0 = r9.aak;
            r0 = r0.Zf;
            r1 = r9.gG;
            if (r1 != 0) goto L_0x002b;
        L_0x0024:
            r1 = new android.graphics.Rect;
            r1.<init>();
            r9.gG = r1;
        L_0x002b:
            r1 = r9.afP;
            r1 = r1.abf;
            r2 = r9.gG;
            r0.a(r1, r2);
            r1 = r0.eR();
            if (r1 == 0) goto L_0x0109;
        L_0x003a:
            r1 = r9.afW;
            r2 = r9.afU;
            r1 = r1 + r2;
            r1 = (int) r1;
            r2 = r9.gG;
            r2 = r2.left;
            r2 = r1 - r2;
            r3 = r9.aak;
            r3 = r3.getPaddingLeft();
            r3 = r2 - r3;
            r2 = r9.afU;
            r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r2 >= 0) goto L_0x00e4;
        L_0x0054:
            if (r3 >= 0) goto L_0x00e4;
        L_0x0056:
            r0 = r0.eS();
            if (r0 == 0) goto L_0x0131;
        L_0x005c:
            r0 = r9.afX;
            r1 = r9.afV;
            r0 = r0 + r1;
            r0 = (int) r0;
            r1 = r9.gG;
            r1 = r1.top;
            r1 = r0 - r1;
            r2 = r9.aak;
            r2 = r2.getPaddingTop();
            r7 = r1 - r2;
            r1 = r9.afV;
            r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
            if (r1 >= 0) goto L_0x010c;
        L_0x0076:
            if (r7 >= 0) goto L_0x010c;
        L_0x0078:
            if (r3 == 0) goto L_0x013a;
        L_0x007a:
            r0 = r9.afY;
            r1 = r9.aak;
            r2 = r9.afP;
            r2 = r2.abf;
            r2 = r2.getWidth();
            r8 = r9.aak;
            r8.getWidth();
            r3 = r0.a(r1, r2, r3, r4);
            r8 = r3;
        L_0x0090:
            if (r7 == 0) goto L_0x0137;
        L_0x0092:
            r0 = r9.afY;
            r1 = r9.aak;
            r2 = r9.afP;
            r2 = r2.abf;
            r2 = r2.getHeight();
            r3 = r9.aak;
            r3.getHeight();
            r3 = r7;
            r0 = r0.a(r1, r2, r3, r4);
        L_0x00a8:
            if (r8 != 0) goto L_0x00ac;
        L_0x00aa:
            if (r0 == 0) goto L_0x0134;
        L_0x00ac:
            r2 = r9.agk;
            r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
            if (r1 != 0) goto L_0x00b4;
        L_0x00b2:
            r9.agk = r10;
        L_0x00b4:
            r1 = r9.aak;
            r1.scrollBy(r8, r0);
            r6 = 1;
        L_0x00ba:
            if (r6 == 0) goto L_0x00dd;
        L_0x00bc:
            r0 = r14.agl;
            r0 = r0.afP;
            if (r0 == 0) goto L_0x00cb;
        L_0x00c2:
            r0 = r14.agl;
            r1 = r14.agl;
            r1 = r1.afP;
            r0.y(r1);
        L_0x00cb:
            r0 = r14.agl;
            r0 = r0.aak;
            r1 = r14.agl;
            r1 = r1.agd;
            r0.removeCallbacks(r1);
            r0 = r14.agl;
            r0 = r0.aak;
            android.support.v4.view.z.a(r0, r14);
        L_0x00dd:
            return;
        L_0x00de:
            r0 = r9.agk;
            r4 = r10 - r0;
            goto L_0x001c;
        L_0x00e4:
            r2 = r9.afU;
            r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
            if (r2 <= 0) goto L_0x0109;
        L_0x00ea:
            r2 = r9.afP;
            r2 = r2.abf;
            r2 = r2.getWidth();
            r1 = r1 + r2;
            r2 = r9.gG;
            r2 = r2.right;
            r1 = r1 + r2;
            r2 = r9.aak;
            r2 = r2.getWidth();
            r3 = r9.aak;
            r3 = r3.getPaddingRight();
            r2 = r2 - r3;
            r3 = r1 - r2;
            if (r3 > 0) goto L_0x0056;
        L_0x0109:
            r3 = r6;
            goto L_0x0056;
        L_0x010c:
            r1 = r9.afV;
            r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
            if (r1 <= 0) goto L_0x0131;
        L_0x0112:
            r1 = r9.afP;
            r1 = r1.abf;
            r1 = r1.getHeight();
            r0 = r0 + r1;
            r1 = r9.gG;
            r1 = r1.bottom;
            r0 = r0 + r1;
            r1 = r9.aak;
            r1 = r1.getHeight();
            r2 = r9.aak;
            r2 = r2.getPaddingBottom();
            r1 = r1 - r2;
            r7 = r0 - r1;
            if (r7 > 0) goto L_0x0078;
        L_0x0131:
            r7 = r6;
            goto L_0x0078;
        L_0x0134:
            r9.agk = r12;
            goto L_0x00ba;
        L_0x0137:
            r0 = r7;
            goto L_0x00a8;
        L_0x013a:
            r8 = r3;
            goto L_0x0090;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.1.run():void");
        }
    };
    private List<t> age;
    private List<Integer> agf;
    public View agg = null;
    public int agh = -1;
    public e agi;
    private final j agj = new j(this) {
        final /* synthetic */ a agl;

        {
            this.agl = r1;
        }

        public final boolean n(MotionEvent motionEvent) {
            this.agl.agi.onTouchEvent(motionEvent);
            int d = o.d(motionEvent);
            if (d == 0) {
                this.agl.fl = o.c(motionEvent, 0);
                this.agl.afQ = motionEvent.getX();
                this.agl.afR = motionEvent.getY();
                a aVar = this.agl;
                if (aVar.fk != null) {
                    aVar.fk.recycle();
                }
                aVar.fk = VelocityTracker.obtain();
                if (this.agl.afP == null) {
                    c cVar;
                    a aVar2 = this.agl;
                    if (!aVar2.agb.isEmpty()) {
                        View p = aVar2.p(motionEvent);
                        for (int size = aVar2.agb.size() - 1; size >= 0; size--) {
                            cVar = (c) aVar2.agb.get(size);
                            if (cVar.aas.abf == p) {
                                break;
                            }
                        }
                    }
                    cVar = null;
                    if (cVar != null) {
                        a aVar3 = this.agl;
                        aVar3.afQ -= cVar.agA;
                        aVar3 = this.agl;
                        aVar3.afR -= cVar.agB;
                        this.agl.a(cVar.aas, true);
                        if (this.agl.afN.remove(cVar.aas.abf)) {
                            this.agl.afY.c(this.agl.aak, cVar.aas);
                        }
                        this.agl.d(cVar.aas, cVar.afZ);
                        this.agl.a(motionEvent, this.agl.aga, 0);
                    }
                }
            } else if (d == 3 || d == 1) {
                this.agl.fl = -1;
                this.agl.d(null, 0);
            } else if (this.agl.fl != -1) {
                int b = o.b(motionEvent, this.agl.fl);
                if (b >= 0) {
                    this.agl.a(d, motionEvent, b);
                }
            }
            if (this.agl.fk != null) {
                this.agl.fk.addMovement(motionEvent);
            }
            if (this.agl.afP != null) {
                return true;
            }
            return false;
        }

        public final void o(MotionEvent motionEvent) {
            int i = 0;
            this.agl.agi.onTouchEvent(motionEvent);
            if (this.agl.fk != null) {
                this.agl.fk.addMovement(motionEvent);
            }
            if (this.agl.fl != -1) {
                int d = o.d(motionEvent);
                int b = o.b(motionEvent, this.agl.fl);
                if (b >= 0) {
                    this.agl.a(d, motionEvent, b);
                }
                t tVar = this.agl.afP;
                if (tVar != null) {
                    switch (d) {
                        case 1:
                            break;
                        case 2:
                            if (b >= 0) {
                                this.agl.a(motionEvent, this.agl.aga, b);
                                this.agl.y(tVar);
                                this.agl.aak.removeCallbacks(this.agl.agd);
                                this.agl.agd.run();
                                this.agl.aak.invalidate();
                                return;
                            }
                            return;
                        case 3:
                            if (this.agl.fk != null) {
                                this.agl.fk.clear();
                                break;
                            }
                            break;
                        case 6:
                            d = o.e(motionEvent);
                            if (o.c(motionEvent, d) == this.agl.fl) {
                                if (d == 0) {
                                    i = 1;
                                }
                                this.agl.fl = o.c(motionEvent, i);
                                this.agl.a(motionEvent, this.agl.aga, d);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    this.agl.d(null, 0);
                    this.agl.fl = -1;
                }
            }
        }

        public final void T(boolean z) {
            if (z) {
                this.agl.d(null, 0);
            }
        }
    };
    long agk;
    public VelocityTracker fk;
    int fl = -1;
    Rect gG;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ a agl;
        final /* synthetic */ int agm;
        final /* synthetic */ c ago;

        AnonymousClass4(a aVar, c cVar, int i) {
            this.agl = aVar;
            this.ago = cVar;
            this.agm = i;
        }

        public final void run() {
            if (this.agl.aak != null && this.agl.aak.isAttachedToWindow() && !this.ago.agC && this.ago.aas.gf() != -1) {
                RecyclerView.e eVar = this.agl.aak.ZB;
                if (eVar == null || !eVar.a(null)) {
                    Object obj;
                    a aVar = this.agl;
                    int size = aVar.agb.size();
                    for (int i = 0; i < size; i++) {
                        if (!((c) aVar.agb.get(i)).nz) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        this.agl.afY.ho();
                        return;
                    }
                }
                this.agl.aak.post(this);
            }
        }
    }

    public static abstract class a {
        private static final b agp;
        private static final Interpolator agq = new Interpolator() {
            public final float getInterpolation(float f) {
                return (((f * f) * f) * f) * f;
            }
        };
        private static final Interpolator agr = new Interpolator() {
            public final float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
            }
        };
        private int ags = -1;

        public abstract boolean a(t tVar, t tVar2);

        public abstract int hh();

        public abstract void ho();

        static {
            if (VERSION.SDK_INT >= 21) {
                agp = new c();
            } else if (VERSION.SDK_INT >= 11) {
                agp = new b();
            } else {
                agp = new a();
            }
        }

        public static int ah(int i, int i2) {
            int i3 = i & 789516;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 << 2);
            }
            return (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
        }

        public static int ai(int i, int i2) {
            int i3 = i & 3158064;
            if (i3 == 0) {
                return i;
            }
            int i4 = (i3 ^ -1) & i;
            if (i2 == 0) {
                return i4 | (i3 >> 2);
            }
            return (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
        }

        final int C(RecyclerView recyclerView) {
            return ai(3342387, z.J(recyclerView));
        }

        public static boolean hi() {
            return true;
        }

        public boolean hj() {
            return true;
        }

        public boolean hk() {
            return true;
        }

        public static int hl() {
            return 0;
        }

        public static float hm() {
            return 0.5f;
        }

        public float hn() {
            return 0.5f;
        }

        public static float F(float f) {
            return f;
        }

        public static float G(float f) {
            return f;
        }

        public static t a(t tVar, List<t> list, int i, int i2) {
            int width = i + tVar.abf.getWidth();
            int height = i2 + tVar.abf.getHeight();
            t tVar2 = null;
            int i3 = -1;
            int left = i - tVar.abf.getLeft();
            int top = i2 - tVar.abf.getTop();
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                int i5;
                t tVar3;
                int i6;
                t tVar4;
                int i7;
                t tVar5 = (t) list.get(i4);
                if (left > 0) {
                    int right = tVar5.abf.getRight() - width;
                    if (right < 0 && tVar5.abf.getRight() > tVar.abf.getRight()) {
                        right = Math.abs(right);
                        if (right > i3) {
                            i5 = right;
                            tVar3 = tVar5;
                            if (left < 0) {
                                i3 = tVar5.abf.getLeft() - i;
                                if (i3 > 0 && tVar5.abf.getLeft() < tVar.abf.getLeft()) {
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        tVar3 = tVar5;
                                        if (top < 0) {
                                            i5 = tVar5.abf.getTop() - i2;
                                            if (i5 > 0 && tVar5.abf.getTop() < tVar.abf.getTop()) {
                                                i5 = Math.abs(i5);
                                                if (i5 > i3) {
                                                    tVar3 = tVar5;
                                                    if (top > 0) {
                                                        i3 = tVar5.abf.getBottom() - height;
                                                        if (i3 < 0 && tVar5.abf.getBottom() > tVar.abf.getBottom()) {
                                                            i3 = Math.abs(i3);
                                                            if (i3 > i5) {
                                                                i6 = i3;
                                                                tVar4 = tVar5;
                                                                i7 = i6;
                                                                i4++;
                                                                tVar2 = tVar4;
                                                                i3 = i7;
                                                            }
                                                        }
                                                    }
                                                    i7 = i5;
                                                    tVar4 = tVar3;
                                                    i4++;
                                                    tVar2 = tVar4;
                                                    i3 = i7;
                                                }
                                            }
                                        }
                                        i5 = i3;
                                        if (top > 0) {
                                            i3 = tVar5.abf.getBottom() - height;
                                            i3 = Math.abs(i3);
                                            if (i3 > i5) {
                                                i6 = i3;
                                                tVar4 = tVar5;
                                                i7 = i6;
                                                i4++;
                                                tVar2 = tVar4;
                                                i3 = i7;
                                            }
                                        }
                                        i7 = i5;
                                        tVar4 = tVar3;
                                        i4++;
                                        tVar2 = tVar4;
                                        i3 = i7;
                                    }
                                }
                            }
                            i3 = i5;
                            if (top < 0) {
                                i5 = tVar5.abf.getTop() - i2;
                                i5 = Math.abs(i5);
                                if (i5 > i3) {
                                    tVar3 = tVar5;
                                    if (top > 0) {
                                        i3 = tVar5.abf.getBottom() - height;
                                        i3 = Math.abs(i3);
                                        if (i3 > i5) {
                                            i6 = i3;
                                            tVar4 = tVar5;
                                            i7 = i6;
                                            i4++;
                                            tVar2 = tVar4;
                                            i3 = i7;
                                        }
                                    }
                                    i7 = i5;
                                    tVar4 = tVar3;
                                    i4++;
                                    tVar2 = tVar4;
                                    i3 = i7;
                                }
                            }
                            i5 = i3;
                            if (top > 0) {
                                i3 = tVar5.abf.getBottom() - height;
                                i3 = Math.abs(i3);
                                if (i3 > i5) {
                                    i6 = i3;
                                    tVar4 = tVar5;
                                    i7 = i6;
                                    i4++;
                                    tVar2 = tVar4;
                                    i3 = i7;
                                }
                            }
                            i7 = i5;
                            tVar4 = tVar3;
                            i4++;
                            tVar2 = tVar4;
                            i3 = i7;
                        }
                    }
                }
                tVar3 = tVar2;
                i5 = i3;
                if (left < 0) {
                    i3 = tVar5.abf.getLeft() - i;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        tVar3 = tVar5;
                        if (top < 0) {
                            i5 = tVar5.abf.getTop() - i2;
                            i5 = Math.abs(i5);
                            if (i5 > i3) {
                                tVar3 = tVar5;
                                if (top > 0) {
                                    i3 = tVar5.abf.getBottom() - height;
                                    i3 = Math.abs(i3);
                                    if (i3 > i5) {
                                        i6 = i3;
                                        tVar4 = tVar5;
                                        i7 = i6;
                                        i4++;
                                        tVar2 = tVar4;
                                        i3 = i7;
                                    }
                                }
                                i7 = i5;
                                tVar4 = tVar3;
                                i4++;
                                tVar2 = tVar4;
                                i3 = i7;
                            }
                        }
                        i5 = i3;
                        if (top > 0) {
                            i3 = tVar5.abf.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                tVar4 = tVar5;
                                i7 = i6;
                                i4++;
                                tVar2 = tVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        tVar4 = tVar3;
                        i4++;
                        tVar2 = tVar4;
                        i3 = i7;
                    }
                }
                i3 = i5;
                if (top < 0) {
                    i5 = tVar5.abf.getTop() - i2;
                    i5 = Math.abs(i5);
                    if (i5 > i3) {
                        tVar3 = tVar5;
                        if (top > 0) {
                            i3 = tVar5.abf.getBottom() - height;
                            i3 = Math.abs(i3);
                            if (i3 > i5) {
                                i6 = i3;
                                tVar4 = tVar5;
                                i7 = i6;
                                i4++;
                                tVar2 = tVar4;
                                i3 = i7;
                            }
                        }
                        i7 = i5;
                        tVar4 = tVar3;
                        i4++;
                        tVar2 = tVar4;
                        i3 = i7;
                    }
                }
                i5 = i3;
                if (top > 0) {
                    i3 = tVar5.abf.getBottom() - height;
                    i3 = Math.abs(i3);
                    if (i3 > i5) {
                        i6 = i3;
                        tVar4 = tVar5;
                        i7 = i6;
                        i4++;
                        tVar2 = tVar4;
                        i3 = i7;
                    }
                }
                i7 = i5;
                tVar4 = tVar3;
                i4++;
                tVar2 = tVar4;
                i3 = i7;
            }
            return tVar2;
        }

        public void e(t tVar, int i) {
            if (tVar != null) {
                agp.bA(tVar.abf);
            }
        }

        public void c(RecyclerView recyclerView, t tVar) {
            agp.bz(tVar.abf);
        }

        public void a(Canvas canvas, RecyclerView recyclerView, t tVar, float f, float f2, int i, boolean z) {
            agp.a(canvas, recyclerView, tVar.abf, f, f2, i, z);
        }

        public static void a(Canvas canvas, RecyclerView recyclerView, t tVar, float f, float f2, int i) {
            agp.a(canvas, recyclerView, tVar.abf, f, f2, i);
        }

        public static long f(RecyclerView recyclerView, int i) {
            RecyclerView.e eVar = recyclerView.ZB;
            return eVar == null ? i == 8 ? 200 : 250 : i == 8 ? eVar.aah : eVar.aag;
        }

        public final int a(RecyclerView recyclerView, int i, int i2, long j) {
            float f = 1.0f;
            if (this.ags == -1) {
                this.ags = recyclerView.getResources().getDimensionPixelSize(android.support.v7.d.a.a.Ov);
            }
            int signum = (int) (((float) (this.ags * ((int) Math.signum((float) i2)))) * agr.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
            if (j <= 2000) {
                f = ((float) j) / 2000.0f;
            }
            int interpolation = (int) (agq.getInterpolation(f) * ((float) signum));
            if (interpolation != 0) {
                return interpolation;
            }
            if (i2 > 0) {
                return 1;
            }
            return -1;
        }
    }

    private class b extends SimpleOnGestureListener {
        final /* synthetic */ a agl;

        private b(a aVar) {
            this.agl = aVar;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            View p = this.agl.p(motionEvent);
            if (p != null) {
                t aQ = this.agl.aak.aQ(p);
                if (aQ != null) {
                    int i;
                    if ((this.agl.afY.C(this.agl.aak) & 16711680) != 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0 && o.c(motionEvent, 0) == this.agl.fl) {
                        i = o.b(motionEvent, this.agl.fl);
                        float d = o.d(motionEvent, i);
                        float e = o.e(motionEvent, i);
                        this.agl.afQ = d;
                        this.agl.afR = e;
                        a aVar = this.agl;
                        this.agl.afV = 0.0f;
                        aVar.afU = 0.0f;
                        this.agl.afY.hj();
                        this.agl.d(aQ, 2);
                    }
                }
            }
        }
    }

    private class c implements android.support.v4.a.b {
        final t aas;
        final int afZ;
        float agA;
        float agB;
        boolean agC = false;
        final /* synthetic */ a agl;
        final float agt;
        final float agu;
        final float agv;
        final float agw;
        final android.support.v4.a.g agx;
        public final int agy;
        public boolean agz;
        float nx;
        public boolean nz = false;

        public c(final a aVar, t tVar, int i, int i2, float f, float f2, float f3, float f4) {
            this.agl = aVar;
            this.afZ = i2;
            this.agy = i;
            this.aas = tVar;
            this.agt = f;
            this.agu = f2;
            this.agv = f3;
            this.agw = f4;
            this.agx = android.support.v4.a.a.aB();
            this.agx.a(new android.support.v4.a.d(this) {
                final /* synthetic */ c agE;

                public final void b(android.support.v4.a.g gVar) {
                    this.agE.nx = gVar.getAnimatedFraction();
                }
            });
            this.agx.w(tVar.abf);
            this.agx.a(this);
            this.nx = 0.0f;
        }

        public void a(android.support.v4.a.g gVar) {
            if (!this.nz) {
                this.aas.U(true);
            }
            this.nz = true;
        }

        public final void aC() {
            this.nx = 1.0f;
        }
    }

    public a(a aVar) {
        this.afY = aVar;
    }

    private static boolean a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= ((float) view.getWidth()) + f3 && f2 >= f4 && f2 <= ((float) view.getHeight()) + f4;
    }

    public final void B(RecyclerView recyclerView) {
        if (this.aak != recyclerView) {
            RecyclerView recyclerView2;
            if (this.aak != null) {
                View view = this.aak;
                if (view.Zf != null) {
                    view.Zf.q("Cannot remove item decoration during a scroll  or layout");
                }
                view.Zh.remove(this);
                if (view.Zh.isEmpty()) {
                    view.setWillNotDraw(z.C(view) == 2);
                }
                view.fJ();
                view.requestLayout();
                recyclerView2 = this.aak;
                j jVar = this.agj;
                recyclerView2.Zi.remove(jVar);
                if (recyclerView2.Zj == jVar) {
                    recyclerView2.Zj = null;
                }
                recyclerView2 = this.aak;
                if (recyclerView2.Zu != null) {
                    recyclerView2.Zu.remove(this);
                }
                for (int size = this.agb.size() - 1; size >= 0; size--) {
                    this.afY.c(this.aak, ((c) this.agb.get(0)).aas);
                }
                this.agb.clear();
                this.agg = null;
                this.agh = -1;
                hg();
            }
            this.aak = recyclerView;
            if (this.aak != null) {
                Resources resources = recyclerView.getResources();
                this.afS = resources.getDimension(android.support.v7.d.a.a.Ox);
                this.afT = resources.getDimension(android.support.v7.d.a.a.Ow);
                this.agc = ViewConfiguration.get(this.aak.getContext()).getScaledTouchSlop();
                this.aak.a(this);
                this.aak.Zi.add(this.agj);
                recyclerView2 = this.aak;
                if (recyclerView2.Zu == null) {
                    recyclerView2.Zu = new ArrayList();
                }
                recyclerView2.Zu.add(this);
                if (this.agi == null) {
                    this.agi = new e(this.aak.getContext(), new b());
                }
            }
        }
    }

    private void a(float[] fArr) {
        if ((this.aga & 12) != 0) {
            fArr[0] = (this.afW + this.afU) - ((float) this.afP.abf.getLeft());
        } else {
            fArr[0] = z.R(this.afP.abf);
        }
        if ((this.aga & 3) != 0) {
            fArr[1] = (this.afX + this.afV) - ((float) this.afP.abf.getTop());
        } else {
            fArr[1] = z.S(this.afP.abf);
        }
    }

    public final void b(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        int i;
        if (this.afP != null) {
            a(this.afO);
            float f3 = this.afO[0];
            f = this.afO[1];
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        t tVar = this.afP;
        List list = this.agb;
        int i2 = this.afZ;
        int size = list.size();
        for (i = 0; i < size; i++) {
            c cVar = (c) list.get(i);
            int save = canvas.save();
            a.a(canvas, recyclerView, cVar.aas, cVar.agA, cVar.agB, cVar.afZ);
            canvas.restoreToCount(save);
        }
        if (tVar != null) {
            i = canvas.save();
            a.a(canvas, recyclerView, tVar, f2, f, i2);
            canvas.restoreToCount(i);
        }
        Object obj = null;
        int i3 = size - 1;
        while (i3 >= 0) {
            Object obj2;
            cVar = (c) list.get(i3);
            if (!cVar.nz || cVar.agz) {
                obj2 = !cVar.nz ? 1 : obj;
            } else {
                list.remove(i3);
                obj2 = obj;
            }
            i3--;
            obj = obj2;
        }
        if (obj != null) {
            recyclerView.invalidate();
        }
    }

    public final void a(Canvas canvas, RecyclerView recyclerView) {
        float f;
        float f2;
        int i;
        this.agh = -1;
        if (this.afP != null) {
            a(this.afO);
            float f3 = this.afO[0];
            f = this.afO[1];
            f2 = f3;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        a aVar = this.afY;
        t tVar = this.afP;
        List list = this.agb;
        int i2 = this.afZ;
        int size = list.size();
        for (i = 0; i < size; i++) {
            c cVar = (c) list.get(i);
            if (cVar.agt == cVar.agv) {
                cVar.agA = z.R(cVar.aas.abf);
            } else {
                cVar.agA = cVar.agt + (cVar.nx * (cVar.agv - cVar.agt));
            }
            if (cVar.agu == cVar.agw) {
                cVar.agB = z.S(cVar.aas.abf);
            } else {
                cVar.agB = cVar.agu + (cVar.nx * (cVar.agw - cVar.agu));
            }
            int save = canvas.save();
            aVar.a(canvas, recyclerView, cVar.aas, cVar.agA, cVar.agB, cVar.afZ, false);
            canvas.restoreToCount(save);
        }
        if (tVar != null) {
            i = canvas.save();
            aVar.a(canvas, recyclerView, tVar, f2, f, i2, true);
            canvas.restoreToCount(i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(android.support.v7.widget.RecyclerView.t r13, int r14) {
        /*
        r12 = this;
        r0 = r12.afP;
        if (r13 != r0) goto L_0x0009;
    L_0x0004:
        r0 = r12.afZ;
        if (r14 != r0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = -9223372036854775808;
        r12.agk = r0;
        r4 = r12.afZ;
        r0 = 1;
        r12.a(r13, r0);
        r12.afZ = r14;
        r0 = 2;
        if (r14 != r0) goto L_0x0034;
    L_0x0018:
        r0 = r13.abf;
        r12.agg = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x0034;
    L_0x0022:
        r0 = r12.ZT;
        if (r0 != 0) goto L_0x002d;
    L_0x0026:
        r0 = new android.support.v7.widget.a.a$5;
        r0.<init>(r12);
        r12.ZT = r0;
    L_0x002d:
        r0 = r12.aak;
        r1 = r12.ZT;
        r0.a(r1);
    L_0x0034:
        r0 = 1;
        r1 = r14 * 8;
        r1 = r1 + 8;
        r0 = r0 << r1;
        r11 = r0 + -1;
        r0 = 0;
        r1 = r12.afP;
        if (r1 == 0) goto L_0x00d1;
    L_0x0041:
        r2 = r12.afP;
        r1 = r2.abf;
        r1 = r1.getParent();
        if (r1 == 0) goto L_0x017d;
    L_0x004b:
        r0 = 2;
        if (r4 == r0) goto L_0x0132;
    L_0x004e:
        r0 = r12.afZ;
        r1 = 2;
        if (r0 == r1) goto L_0x0132;
    L_0x0053:
        r0 = r12.afY;
        r0 = r0.hh();
        r1 = r12.aak;
        r1 = android.support.v4.view.z.J(r1);
        r0 = android.support.v7.widget.a.a.a.ai(r0, r1);
        r1 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
        r0 = r0 & r1;
        r0 = r0 >> 8;
        if (r0 == 0) goto L_0x0132;
    L_0x006b:
        r1 = r12.afU;
        r1 = java.lang.Math.abs(r1);
        r3 = r12.afV;
        r3 = java.lang.Math.abs(r3);
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 <= 0) goto L_0x0135;
    L_0x007b:
        r9 = r12.bJ(r0);
        if (r9 <= 0) goto L_0x012c;
    L_0x0081:
        r0 = r9 & 0;
        if (r0 != 0) goto L_0x008f;
    L_0x0085:
        r0 = r12.aak;
        r0 = android.support.v4.view.z.J(r0);
        r9 = android.support.v7.widget.a.a.a.ah(r9, r0);
    L_0x008f:
        r12.hg();
        switch(r9) {
            case 1: goto L_0x0163;
            case 2: goto L_0x0163;
            case 4: goto L_0x0151;
            case 8: goto L_0x0151;
            case 16: goto L_0x0151;
            case 32: goto L_0x0151;
            default: goto L_0x0095;
        };
    L_0x0095:
        r7 = 0;
        r8 = 0;
    L_0x0097:
        r0 = 2;
        if (r4 != r0) goto L_0x0175;
    L_0x009a:
        r3 = 8;
    L_0x009c:
        r0 = r12.afO;
        r12.a(r0);
        r0 = r12.afO;
        r1 = 0;
        r5 = r0[r1];
        r0 = r12.afO;
        r1 = 1;
        r6 = r0[r1];
        r0 = new android.support.v7.widget.a.a$3;
        r1 = r12;
        r10 = r2;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        r1 = r12.aak;
        r2 = android.support.v7.widget.a.a.a.f(r1, r3);
        r1 = r0.agx;
        r1.setDuration(r2);
        r1 = r12.agb;
        r1.add(r0);
        r1 = r0.aas;
        r2 = 0;
        r1.U(r2);
        r0 = r0.agx;
        r0.start();
        r0 = 1;
    L_0x00ce:
        r1 = 0;
        r12.afP = r1;
    L_0x00d1:
        r1 = r0;
        if (r13 == 0) goto L_0x0103;
    L_0x00d4:
        r0 = r12.afY;
        r2 = r12.aak;
        r0 = r0.C(r2);
        r0 = r0 & r11;
        r2 = r12.afZ;
        r2 = r2 * 8;
        r0 = r0 >> r2;
        r12.aga = r0;
        r0 = r13.abf;
        r0 = r0.getLeft();
        r0 = (float) r0;
        r12.afW = r0;
        r0 = r13.abf;
        r0 = r0.getTop();
        r0 = (float) r0;
        r12.afX = r0;
        r12.afP = r13;
        r0 = 2;
        if (r14 != r0) goto L_0x0103;
    L_0x00fb:
        r0 = r12.afP;
        r0 = r0.abf;
        r2 = 0;
        r0.performHapticFeedback(r2);
    L_0x0103:
        r0 = r12.aak;
        r2 = r0.getParent();
        if (r2 == 0) goto L_0x0113;
    L_0x010b:
        r0 = r12.afP;
        if (r0 == 0) goto L_0x018b;
    L_0x010f:
        r0 = 1;
    L_0x0110:
        r2.requestDisallowInterceptTouchEvent(r0);
    L_0x0113:
        if (r1 != 0) goto L_0x011c;
    L_0x0115:
        r0 = r12.aak;
        r0 = r0.Zf;
        r1 = 1;
        r0.aam = r1;
    L_0x011c:
        r0 = r12.afY;
        r1 = r12.afP;
        r2 = r12.afZ;
        r0.e(r1, r2);
        r0 = r12.aak;
        r0.invalidate();
        goto L_0x0008;
    L_0x012c:
        r9 = r12.bK(r0);
        if (r9 > 0) goto L_0x008f;
    L_0x0132:
        r9 = 0;
        goto L_0x008f;
    L_0x0135:
        r9 = r12.bK(r0);
        if (r9 > 0) goto L_0x008f;
    L_0x013b:
        r9 = r12.bJ(r0);
        if (r9 <= 0) goto L_0x0132;
    L_0x0141:
        r0 = r9 & 0;
        if (r0 != 0) goto L_0x008f;
    L_0x0145:
        r0 = r12.aak;
        r0 = android.support.v4.view.z.J(r0);
        r9 = android.support.v7.widget.a.a.a.ah(r9, r0);
        goto L_0x008f;
    L_0x0151:
        r8 = 0;
        r0 = r12.afU;
        r0 = java.lang.Math.signum(r0);
        r1 = r12.aak;
        r1 = r1.getWidth();
        r1 = (float) r1;
        r7 = r0 * r1;
        goto L_0x0097;
    L_0x0163:
        r7 = 0;
        r0 = r12.afV;
        r0 = java.lang.Math.signum(r0);
        r1 = r12.aak;
        r1 = r1.getHeight();
        r1 = (float) r1;
        r8 = r0 * r1;
        goto L_0x0097;
    L_0x0175:
        if (r9 <= 0) goto L_0x017a;
    L_0x0177:
        r3 = 2;
        goto L_0x009c;
    L_0x017a:
        r3 = 4;
        goto L_0x009c;
    L_0x017d:
        r1 = r2.abf;
        r12.by(r1);
        r1 = r12.afY;
        r3 = r12.aak;
        r1.c(r3, r2);
        goto L_0x00ce;
    L_0x018b:
        r0 = 0;
        goto L_0x0110;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a.d(android.support.v7.widget.RecyclerView$t, int):void");
    }

    public final void y(t tVar) {
        if (!this.aak.isLayoutRequested() && this.afZ == 2) {
            float hn = this.afY.hn();
            int i = (int) (this.afW + this.afU);
            int i2 = (int) (this.afX + this.afV);
            if (((float) Math.abs(i2 - tVar.abf.getTop())) >= ((float) tVar.abf.getHeight()) * hn || ((float) Math.abs(i - tVar.abf.getLeft())) >= hn * ((float) tVar.abf.getWidth())) {
                if (this.age == null) {
                    this.age = new ArrayList();
                    this.agf = new ArrayList();
                } else {
                    this.age.clear();
                    this.agf.clear();
                }
                a.hl();
                int round = Math.round(this.afW + this.afU) + 0;
                int round2 = Math.round(this.afX + this.afV) + 0;
                int width = (tVar.abf.getWidth() + round) + 0;
                int height = (tVar.abf.getHeight() + round2) + 0;
                int i3 = (round + width) / 2;
                int i4 = (round2 + height) / 2;
                h hVar = this.aak.Zf;
                int childCount = hVar.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = hVar.getChildAt(i5);
                    if (childAt != tVar.abf && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                        t aQ = this.aak.aQ(childAt);
                        a.hi();
                        int abs = Math.abs(i3 - ((childAt.getLeft() + childAt.getRight()) / 2));
                        int abs2 = Math.abs(i4 - ((childAt.getBottom() + childAt.getTop()) / 2));
                        int i6 = (abs * abs) + (abs2 * abs2);
                        int size = this.age.size();
                        int i7 = 0;
                        abs = 0;
                        while (abs < size && i6 > ((Integer) this.agf.get(abs)).intValue()) {
                            i7++;
                            abs++;
                        }
                        this.age.add(i7, aQ);
                        this.agf.add(i7, Integer.valueOf(i6));
                    }
                }
                List list = this.age;
                if (list.size() != 0) {
                    t a = a.a(tVar, list, i, i2);
                    if (a == null) {
                        this.age.clear();
                        this.agf.clear();
                        return;
                    }
                    a.gf();
                    tVar.gf();
                    this.afY.a(tVar, a);
                }
            }
        }
    }

    public final void bm(View view) {
        by(view);
        t aQ = this.aak.aQ(view);
        if (aQ != null) {
            if (this.afP == null || aQ != this.afP) {
                a(aQ, false);
                if (this.afN.remove(aQ.abf)) {
                    this.afY.c(this.aak, aQ);
                    return;
                }
                return;
            }
            d(null, 0);
        }
    }

    public final int a(t tVar, boolean z) {
        for (int size = this.agb.size() - 1; size >= 0; size--) {
            c cVar = (c) this.agb.get(size);
            if (cVar.aas == tVar) {
                cVar.agC |= z;
                if (!cVar.nz) {
                    cVar.agx.cancel();
                }
                this.agb.remove(size);
                return cVar.agy;
            }
        }
        return 0;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView) {
        rect.setEmpty();
    }

    private void hg() {
        if (this.fk != null) {
            this.fk.recycle();
            this.fk = null;
        }
    }

    public final boolean a(int i, MotionEvent motionEvent, int i2) {
        t tVar = null;
        if (this.afP != null || i != 2 || this.afZ == 2 || !this.afY.hk() || this.aak.xV == 1) {
            return false;
        }
        float d;
        h hVar = this.aak.Zf;
        if (this.fl != -1) {
            int b = o.b(motionEvent, this.fl);
            d = o.d(motionEvent, b) - this.afQ;
            float e = o.e(motionEvent, b) - this.afR;
            d = Math.abs(d);
            e = Math.abs(e);
            if ((d >= ((float) this.agc) || e >= ((float) this.agc)) && ((d <= e || !hVar.eR()) && (e <= d || !hVar.eS()))) {
                View p = p(motionEvent);
                if (p != null) {
                    tVar = this.aak.aQ(p);
                }
            }
        }
        if (tVar == null) {
            return false;
        }
        int C = (this.afY.C(this.aak) & 65280) >> 8;
        if (C == 0) {
            return false;
        }
        e = o.d(motionEvent, i2);
        e -= this.afQ;
        d = o.e(motionEvent, i2) - this.afR;
        float abs = Math.abs(e);
        float abs2 = Math.abs(d);
        if (abs < ((float) this.agc) && abs2 < ((float) this.agc)) {
            return false;
        }
        if (abs > abs2) {
            if (e < 0.0f && (C & 4) == 0) {
                return false;
            }
            if (e > 0.0f && (C & 8) == 0) {
                return false;
            }
        } else if (d < 0.0f && (C & 1) == 0) {
            return false;
        } else {
            if (d > 0.0f && (C & 2) == 0) {
                return false;
            }
        }
        this.afV = 0.0f;
        this.afU = 0.0f;
        this.fl = o.c(motionEvent, 0);
        d(tVar, 1);
        return true;
    }

    public final View p(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.afP != null) {
            View view = this.afP.abf;
            if (a(view, x, y, this.afW + this.afU, this.afX + this.afV)) {
                return view;
            }
        }
        for (int size = this.agb.size() - 1; size >= 0; size--) {
            c cVar = (c) this.agb.get(size);
            View view2 = cVar.aas.abf;
            if (a(view2, x, y, cVar.agA, cVar.agB)) {
                return view2;
            }
        }
        return this.aak.j(x, y);
    }

    public final void a(MotionEvent motionEvent, int i, int i2) {
        float d = o.d(motionEvent, i2);
        float e = o.e(motionEvent, i2);
        this.afU = d - this.afQ;
        this.afV = e - this.afR;
        if ((i & 4) == 0) {
            this.afU = Math.max(0.0f, this.afU);
        }
        if ((i & 8) == 0) {
            this.afU = Math.min(0.0f, this.afU);
        }
        if ((i & 1) == 0) {
            this.afV = Math.max(0.0f, this.afV);
        }
        if ((i & 2) == 0) {
            this.afV = Math.min(0.0f, this.afV);
        }
    }

    private int bJ(int i) {
        int i2 = 8;
        if ((i & 12) != 0) {
            int i3 = this.afU > 0.0f ? 8 : 4;
            if (this.fk != null && this.fl >= 0) {
                this.fk.computeCurrentVelocity(1000, a.G(this.afT));
                float a = y.a(this.fk, this.fl);
                float b = y.b(this.fk, this.fl);
                if (a <= 0.0f) {
                    i2 = 4;
                }
                float abs = Math.abs(a);
                if ((i2 & i) != 0 && i3 == i2 && abs >= a.F(this.afS) && abs > Math.abs(b)) {
                    return i2;
                }
            }
            float width = ((float) this.aak.getWidth()) * a.hm();
            if ((i & i3) != 0 && Math.abs(this.afU) > width) {
                return i3;
            }
        }
        return 0;
    }

    private int bK(int i) {
        int i2 = 2;
        if ((i & 3) != 0) {
            int i3 = this.afV > 0.0f ? 2 : 1;
            if (this.fk != null && this.fl >= 0) {
                this.fk.computeCurrentVelocity(1000, a.G(this.afT));
                float a = y.a(this.fk, this.fl);
                float b = y.b(this.fk, this.fl);
                if (b <= 0.0f) {
                    i2 = 1;
                }
                float abs = Math.abs(b);
                if ((i2 & i) != 0 && i2 == i3 && abs >= a.F(this.afS) && abs > Math.abs(a)) {
                    return i2;
                }
            }
            float height = ((float) this.aak.getHeight()) * a.hm();
            if ((i & i3) != 0 && Math.abs(this.afV) > height) {
                return i3;
            }
        }
        return 0;
    }

    public final void by(View view) {
        if (view == this.agg) {
            this.agg = null;
            if (this.ZT != null) {
                this.aak.a(null);
            }
        }
    }
}
