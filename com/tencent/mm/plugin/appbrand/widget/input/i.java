package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Point;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.m.c;
import com.tencent.mm.plugin.appbrand.g.r;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.Reference;
import java.util.Map;

public class i implements c {
    private static final i jts = new i() {
        public final void YG() {
        }

        public final void YH() {
        }

        public final void onDestroy() {
        }

        public final String toString() {
            return super.toString() + "|DUMMY";
        }
    };
    private static final android.support.v4.e.a<m, i> jtx = new android.support.v4.e.a();
    public final m iNv;
    public final Map<a, i> jtr;
    public final int jtt;
    private final int jtu;
    public int jtv;
    private boolean jtw;
    private final Runnable jty;
    private final Runnable jtz;

    public interface a {
        void YJ();

        void YK();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.jtr.remove(aVar);
        }
    }

    public i() {
        this.jtr = new android.support.v4.e.a();
        this.jtu = 5;
        this.jtv = 0;
        this.jtw = false;
        this.jty = new Runnable(this) {
            final /* synthetic */ i jtA;

            {
                this.jtA = r1;
            }

            public final void run() {
                int i = 0;
                if (this.jtA.iNv.aaI) {
                    View YF = this.jtA.YF();
                    if (YF != null) {
                        YF.scrollTo(0, 0);
                        i iVar = this.jtA;
                        if (iVar.jtr.size() > 0) {
                            a[] aVarArr = (a[]) iVar.jtr.keySet().toArray(new a[iVar.jtr.size()]);
                            int length = aVarArr.length;
                            while (i < length) {
                                aVarArr[i].YK();
                                i++;
                            }
                        }
                    }
                }
            }
        };
        this.jtz = new Runnable(this) {
            final /* synthetic */ i jtA;

            {
                this.jtA = r1;
            }

            public final void run() {
                w.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
                x l = m.l(this.jtA.iNv);
                if (l != null && this.jtA.iNv.aaI && l.Yq() != null && l.Ym() != null) {
                    View Ym = l.Ym();
                    View Yq = l.Yq();
                    if (!g.bF(Ym)) {
                        if (Yq.getHeight() <= Yq.getMinimumHeight()) {
                            w.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[]{Integer.valueOf(Yq.getHeight()), Integer.valueOf(this.jtA.jtv)});
                            i iVar = this.jtA;
                            int i = iVar.jtv + 1;
                            iVar.jtv = i;
                            if (i < 5) {
                                this.jtA.cv(false);
                                return;
                            }
                            return;
                        }
                        this.jtA.jtv = 0;
                        w.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[]{Integer.valueOf(Yq.getHeight())});
                        int[] iArr = new int[2];
                        Ym.getLocationOnScreen(iArr);
                        int i2 = iArr[1];
                        w.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[]{Integer.valueOf(Ym.getHeight()), Integer.valueOf(i2), Boolean.valueOf(z.al(Ym))});
                        Display defaultDisplay = ((WindowManager) this.jtA.iNv.jbY.getContext().getSystemService("window")).getDefaultDisplay();
                        Point point = new Point();
                        defaultDisplay.getSize(point);
                        if (i2 <= point.y) {
                            int i3;
                            int i4;
                            int height = i2 + Ym.getHeight();
                            Yq.getLocationOnScreen(iArr);
                            int i5 = iArr[1];
                            if (!((y) Ym).YP() || Ym.getLayout() == null) {
                                i3 = height;
                                i4 = i2;
                            } else {
                                i4 = i2 + ((y) Ym).iW(Ym.getLayout().getLineForOffset(Ym.getSelectionStart()));
                                int iW = i2 + ((y) Ym).iW(Ym.getLayout().getLineForOffset(Ym.getSelectionStart()) + 1);
                                i3 = i4 - i2 >= Ym.getHeight() ? height - Ym.getLineHeight() : i4;
                                if (iW - i2 >= Ym.getHeight()) {
                                    i4 = i3;
                                    i3 = height;
                                } else {
                                    i4 = i3;
                                    i3 = iW;
                                }
                            }
                            i3 += l.Yr();
                            if (i5 < i3) {
                                i4 = Math.max(0, Math.min(i3 - i5, i4 - this.jtA.jtt));
                                r rVar = this.jtA.iNv.jde;
                                if (rVar != null) {
                                    View view = rVar.getView();
                                    if (view != null && Ym != null) {
                                        if (((y) Ym).Zp() || !((y) Ym).YP()) {
                                            iN(YI() + i4);
                                            return;
                                        }
                                        i3 = rVar.getHeight();
                                        i2 = view.getScrollY();
                                        height = h.iD(rVar.getContentHeight());
                                        Ym.getHeight();
                                        Ym.getTop();
                                        i3 = Math.max(0, Math.min((height - i2) - i3, i4));
                                        view.scrollBy(view.getScrollX(), i3);
                                        iN((i4 - i3) + YI());
                                    }
                                }
                            }
                        }
                    }
                }
            }

            private int YI() {
                View YF = this.jtA.YF();
                if (YF != null) {
                    return YF.getScrollY();
                }
                return 0;
            }

            private void iN(int i) {
                int i2 = 0;
                w.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[]{Integer.valueOf(i)});
                View YF = this.jtA.YF();
                if (YF != null) {
                    YF.scrollTo(0, i);
                    i iVar = this.jtA;
                    if (iVar.jtr.size() > 0) {
                        a[] aVarArr = (a[]) iVar.jtr.keySet().toArray(new a[iVar.jtr.size()]);
                        int length = aVarArr.length;
                        while (i2 < length) {
                            aVarArr[i2].YJ();
                            i2++;
                        }
                    }
                }
            }
        };
        this.iNv = null;
        this.jtt = 0;
    }

    private i(m mVar) {
        int i = 0;
        this.jtr = new android.support.v4.e.a();
        this.jtu = 5;
        this.jtv = 0;
        this.jtw = false;
        this.jty = /* anonymous class already generated */;
        this.jtz = /* anonymous class already generated */;
        this.iNv = mVar;
        this.iNv.a((c) this);
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(mVar.mContext, 10);
        if (VERSION.SDK_INT >= 21) {
            i = g.WW();
        }
        this.jtt = i + fromDPToPix;
    }

    public static i a(Reference<m> reference) {
        return g(reference == null ? null : (m) reference.get());
    }

    public static i g(m mVar) {
        if (mVar == null || !mVar.aaI) {
            w.h("MicroMsg.AppBrandInputPageOffsetHelper", " obtain with invalid page " + mVar, new Object[0]);
            return jts;
        }
        i iVar = (i) jtx.get(mVar);
        if (iVar != null) {
            return iVar;
        }
        iVar = new i(mVar);
        jtx.put(mVar, iVar);
        return iVar;
    }

    public final View YF() {
        if (this.iNv.aaI) {
            return this.iNv.jcb;
        }
        return null;
    }

    public final void cv(boolean z) {
        if (z) {
            this.jtv = 0;
            this.jtw = false;
        }
        if (!this.iNv.aaI || this.jtw) {
            return;
        }
        if (this.jtv == 0) {
            w.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] post, attached %B", new Object[]{Boolean.valueOf(z.al(this.iNv.jbY))});
            this.iNv.jbY.post(this.jtz);
            return;
        }
        w.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] postOnAnimation, attached %B", new Object[]{Boolean.valueOf(z.al(this.iNv.jbY))});
        this.iNv.jbY.postOnAnimation(this.jtz);
    }

    public void YG() {
        cv(true);
    }

    public void YH() {
        if (this.iNv.aaI) {
            this.jtw = true;
            this.iNv.jbY.post(this.jty);
        }
    }

    public void onDestroy() {
        this.iNv.b((c) this);
        jtx.remove(this.iNv);
    }
}
