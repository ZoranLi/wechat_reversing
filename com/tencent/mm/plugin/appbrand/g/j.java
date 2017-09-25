package com.tencent.mm.plugin.appbrand.g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.ReportStorageSizeTask;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.g.m.b;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends FrameLayout {
    private String ivH;
    public h ixr;
    public LinkedList<h> jcp = new LinkedList();
    private LinkedList<h> jcq = new LinkedList();
    private m jcr;
    boolean jcs = false;
    public k jct;
    private boolean jcu = false;
    public a jcv;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ j jcx;
        final /* synthetic */ String val$url;

        public AnonymousClass11(j jVar, String str) {
            this.jcx = jVar;
            this.val$url = str;
        }

        public final void run() {
            j.a(this.jcx, this.val$url, v.NAVIGATE_TO);
        }
    }

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String jcw;
        final /* synthetic */ j jcx;

        public AnonymousClass1(j jVar, String str) {
            this.jcx = jVar;
            this.jcw = str;
        }

        public final void run() {
            j.a(this.jcx, this.jcw, v.APP_LAUNCH);
        }
    }

    public interface a {
        void PE();
    }

    static /* synthetic */ void a(j jVar, int i) {
        if (jVar.jcp.size() <= 1) {
            e.a(jVar.ivH, c.BACK);
            jVar.ixr.D(jVar.jcs);
            return;
        }
        long Nz = bg.Nz();
        if (i <= 0) {
            i = 1;
        }
        if (i >= jVar.jcp.size()) {
            i = jVar.jcp.size() - 1;
        }
        h hVar = (h) jVar.jcp.getFirst();
        final h hVar2 = (h) jVar.jcp.get(i);
        LinkedList linkedList = (LinkedList) d.d(jVar.jcp, i);
        k kVar = jVar.jct;
        m VC = ((h) linkedList.get(0)).VC();
        VC.a(new com.tencent.mm.plugin.appbrand.g.k.AnonymousClass3(kVar, VC, linkedList));
        kVar.jcP.e(VC);
        if (hVar2 != null) {
            final m VC2 = hVar2.VC();
            if (VC2 != null) {
                VC2.a(new m.d(jVar) {
                    final /* synthetic */ j jcx;

                    public final void UA() {
                        VC2.b((m.d) this);
                        this.jcx.jct.c(hVar2);
                    }
                });
            }
        }
        jVar.a(hVar, hVar2);
        jVar.a(hVar2, hVar, v.NAVIGATE_BACK);
        jVar.jct.g(bg.Nz() - Nz, 4);
    }

    static /* synthetic */ void a(j jVar, final h hVar, boolean z, final boolean z2) {
        if (hVar != null) {
            if (z2) {
                jVar.jcp.remove(hVar);
            }
            hVar.VA();
            Runnable anonymousClass6 = new Runnable(jVar) {
                final /* synthetic */ j jcx;

                public final void run() {
                    hVar.hide();
                    if (z2) {
                        this.jcx.a(hVar);
                    }
                }
            };
            if (z) {
                ObjectAnimator.ofFloat(hVar, "translationX", new float[]{0.0f, -(((float) hVar.getWidth()) * 0.25f)}).setDuration(250);
                ObjectAnimator.ofFloat(hVar, "translationX", new float[]{0.0f}).setDuration(0);
                Animator animatorSet = new AnimatorSet();
                animatorSet.playSequentially(new Animator[]{r1, r2});
                jVar.a(animatorSet, anonymousClass6);
                return;
            }
            anonymousClass6.run();
        }
    }

    static /* synthetic */ void a(j jVar, String str, v vVar) {
        if (!bg.mA(str)) {
            w.i("MicroMsg.AppBrandPageContainer", "navigateTo: " + str);
            if (vVar != v.SWITCH_TAB) {
                jVar.b(str, vVar);
            } else if (jVar.qm(str) != null) {
                jVar.ql(str);
            } else if (jVar.qn(str) != null) {
                jVar.ql(str);
            } else {
                jVar.b(str, v.SWITCH_TAB);
            }
        }
    }

    static /* synthetic */ void a(j jVar, String str, String str2, int[] iArr) {
        Iterator it = jVar.jcp.iterator();
        while (it.hasNext()) {
            ((h) it.next()).b(str, str2, iArr);
        }
        it = jVar.jcq.iterator();
        while (it.hasNext()) {
            ((h) it.next()).b(str, str2, iArr);
        }
    }

    static /* synthetic */ boolean b(v vVar) {
        return (vVar == v.APP_LAUNCH || vVar == v.REDIRECT_TO || vVar == v.RE_LAUNCH || vVar == v.AUTO_RE_LAUNCH) ? false : true;
    }

    static /* synthetic */ void c(j jVar) {
        if (!jVar.jcu) {
            jVar.jcu = true;
            jVar.jcv.PE();
            MainProcessTask reportStorageSizeTask = new ReportStorageSizeTask();
            reportStorageSizeTask.appId = jVar.ivH;
            AppBrandMainProcessService.a(reportStorageSizeTask);
        }
    }

    static /* synthetic */ boolean c(v vVar) {
        return vVar == v.REDIRECT_TO || vVar == v.SWITCH_TAB || vVar == v.RE_LAUNCH || vVar == v.AUTO_RE_LAUNCH;
    }

    public j(Context context, h hVar) {
        super(context);
        this.ixr = hVar;
        this.ivH = hVar.ivH;
        this.jct = new k(this.ixr);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    public final int getPageCount() {
        return this.jcp.size() + this.jcq.size();
    }

    public final void L(final String str, final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ j jcx;

            public final void run() {
                j.a(this.jcx, str, z ? v.AUTO_RE_LAUNCH : v.RE_LAUNCH);
            }
        });
    }

    public final void qj(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ j jcx;

            public final void run() {
                j.a(this.jcx, str, v.REDIRECT_TO);
            }
        });
    }

    public final void qk(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ j jcx;

            public final void run() {
                j.a(this.jcx, str, v.SWITCH_TAB);
            }
        });
    }

    public final void VM() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ j jcx;

            {
                this.jcx = r1;
            }

            public final void run() {
                this.jcx.ib(1);
            }
        });
    }

    public final void ib(final int i) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ j jcx;

            public final void run() {
                j.a(this.jcx, i);
            }
        });
    }

    private void b(String str, v vVar) {
        boolean z;
        View cVar;
        w.d("MicroMsg.AppBrandPageContainer", "navigateToNext: %s, Staging Count: %d", new Object[]{str, Integer.valueOf(this.jcq.size())});
        if (vVar == v.SWITCH_TAB) {
            z = true;
        } else if (vVar == v.RE_LAUNCH || vVar == v.AUTO_RE_LAUNCH) {
            z = this.ixr.iwp.iDO.ob(str);
        } else {
            z = this.ixr.iwp.iDO.ob(str) && (this.jcp.size() + 1) - (vVar == v.REDIRECT_TO ? 1 : 0) == 1;
        }
        if (z) {
            cVar = new c(getContext(), this);
        } else {
            cVar = new q(getContext(), this);
        }
        this.jcq.push(cVar);
        addView(cVar, 0);
        final boolean[] zArr = new boolean[]{false};
        final v vVar2 = vVar;
        final String str2 = str;
        Runnable anonymousClass18 = new Runnable(this) {
            final /* synthetic */ j jcx;

            public final void run() {
                zArr[0] = true;
                if (this.jcx.getPageCount() != 0) {
                    h hVar = this.jcx.jcp.isEmpty() ? null : (h) this.jcx.jcp.getFirst();
                    if (vVar2 == v.SWITCH_TAB || vVar2 == v.RE_LAUNCH || vVar2 == v.AUTO_RE_LAUNCH) {
                        this.jcx.a(hVar, null);
                    }
                    boolean b = j.b(vVar2);
                    j.a(this.jcx, hVar, b, j.c(vVar2));
                    this.jcx.a(cVar, b);
                    if (hVar != null) {
                        this.jcx.jct.b(hVar.VC(), str2);
                    }
                    this.jcx.jct.c(cVar.VC());
                }
            }
        };
        if (this.jcp.size() == 0) {
            postDelayed(anonymousClass18, 5000);
        } else {
            postDelayed(anonymousClass18, 500);
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final View view = cVar;
        final boolean[] zArr2 = zArr;
        final Runnable runnable = anonymousClass18;
        final v vVar3 = vVar;
        cVar.VC().a(new m.e(this) {
            final /* synthetic */ j jcx;

            public final void onReady() {
                int i;
                int i2 = 2;
                view.VC().b((m.e) this);
                if (!zArr2[0]) {
                    this.jcx.removeCallbacks(runnable);
                    this.jcx.post(runnable);
                }
                j.c(this.jcx);
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                k a = this.jcx.jct;
                switch (com.tencent.mm.plugin.appbrand.g.k.AnonymousClass4.jcU[vVar3.ordinal()]) {
                    case 1:
                        i = 1;
                        break;
                    case 2:
                    case 3:
                    case 4:
                        i = 3;
                        break;
                    default:
                        i = 2;
                        break;
                }
                a.g(currentTimeMillis, i);
                g.oUh.a(390, 0, 1, false);
                switch (((int) currentTimeMillis) / 250) {
                    case 0:
                        i2 = 1;
                        break;
                    case 1:
                        break;
                    case 2:
                        i2 = 3;
                        break;
                    case 3:
                        i2 = 4;
                        break;
                    case 4:
                    case 5:
                        i2 = 5;
                        break;
                    case 6:
                    case 7:
                        i2 = 6;
                        break;
                    default:
                        i2 = 7;
                        break;
                }
                g.oUh.a(390, (long) i2, 1, false);
                w.i("MicroMsg.AppBrandPageContainer", "onReady received, time: %d", new Object[]{Long.valueOf(currentTimeMillis)});
            }
        });
        cVar.loadUrl(str);
        cVar.a(vVar);
    }

    private void ql(final String str) {
        final m[] mVarArr = new m[1];
        final h[] hVarArr = new h[1];
        b anonymousClass3 = new b(this) {
            final /* synthetic */ j jcx;

            public final void SY() {
                mVarArr[0].b((b) this);
                if (!bg.mA(mVarArr[0].jde.jdU)) {
                    this.jcx.jct.b(mVarArr[0], str);
                }
                this.jcx.jct.c(hVarArr[0].VC());
            }
        };
        h qm = qm(str);
        hVarArr[0] = qm;
        if (qm != null) {
            m VC = qm.VC();
            mVarArr[0] = VC;
            VC.a(anonymousClass3);
            qm.loadUrl(str);
            qm.a(v.SWITCH_TAB);
            qm.VI();
            return;
        }
        qm = qn(str);
        hVarArr[0] = qm;
        if (qm != null) {
            VC = qm.VC();
            mVarArr[0] = VC;
            VC.a(anonymousClass3);
            qm.loadUrl(str);
            h hVar = (h) this.jcp.getFirst();
            a(hVar, qm);
            a(qm, hVar, v.SWITCH_TAB);
        }
    }

    private void a(h hVar, h hVar2) {
        Iterator it = this.jcp.iterator();
        Object obj = null;
        while (it.hasNext()) {
            h hVar3 = (h) it.next();
            if (hVar3 == hVar) {
                obj = 1;
            } else if (hVar3 == hVar2) {
                return;
            } else {
                if (obj != null) {
                    a(hVar3);
                    it.remove();
                }
            }
        }
    }

    private void a(final h hVar, final h hVar2, v vVar) {
        this.jcp.remove(hVar2);
        if (hVar2.jcl) {
            a(hVar2);
        } else {
            Runnable anonymousClass4 = new Runnable(this) {
                final /* synthetic */ j jcx;

                public final void run() {
                    this.jcx.a(hVar2);
                }
            };
            Animator ofFloat = ObjectAnimator.ofFloat(hVar2, "translationX", new float[]{0.0f, (float) hVar2.getWidth()});
            ofFloat.setDuration(250);
            a(ofFloat, anonymousClass4);
        }
        hVar.a(vVar);
        hVar.Vz();
        if (hVar2.jcl) {
            hVar.VI();
            return;
        }
        anonymousClass4 = new Runnable(this) {
            final /* synthetic */ j jcx;

            public final void run() {
                hVar.VI();
            }
        };
        ofFloat = ObjectAnimator.ofFloat(hVar, "translationX", new float[]{-(((float) hVar.getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        a(ofFloat, anonymousClass4);
    }

    private synchronized void a(final h hVar, boolean z) {
        if (hVar != null) {
            this.jcp.remove(hVar);
            this.jcp.push(hVar);
            this.jcq.remove(hVar);
            hVar.bringToFront();
            requestLayout();
            invalidate();
            hVar.Vz();
            Runnable anonymousClass7 = new Runnable(this) {
                final /* synthetic */ j jcx;

                public final void run() {
                    this.jcx.VP();
                    hVar.VI();
                }
            };
            if (z) {
                Animator ofFloat = ObjectAnimator.ofFloat(hVar, "translationX", new float[]{(float) hVar.getWidth(), 0.0f});
                ofFloat.setDuration(250);
                a(ofFloat, anonymousClass7);
            } else {
                anonymousClass7.run();
            }
        }
    }

    private h qm(String str) {
        if (this.jcp.size() == 0) {
            return null;
        }
        return ((this.jcp.getFirst() instanceof c) && ((h) this.jcp.getFirst()).qh(str)) ? (h) this.jcp.getFirst() : null;
    }

    private h qn(String str) {
        if (this.jcp.size() < 2) {
            return null;
        }
        int i = 1;
        while (i < this.jcp.size()) {
            if ((this.jcp.get(i) instanceof c) && ((h) this.jcp.get(i)).qh(str)) {
                return (h) this.jcp.get(i);
            }
            i++;
        }
        return null;
    }

    private void a(h hVar) {
        hVar.setVisibility(8);
        hVar.VB();
        removeView(hVar);
        hVar.Po();
    }

    public final void c(final String str, final String str2, final int[] iArr) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ j jcx;

            public final void run() {
                j.a(this.jcx, str, str2, iArr);
            }
        });
    }

    public final synchronized h VN() {
        h hVar;
        if (this.jcq.isEmpty()) {
            try {
                hVar = (h) this.jcp.getFirst();
            } catch (Exception e) {
                w.e("MicroMsg.AppBrandPageContainer", e.getMessage());
                hVar = null;
            }
        } else {
            hVar = (h) this.jcq.getFirst();
        }
        return hVar;
    }

    public final void Po() {
        k kVar = this.jct;
        h VN = VN();
        if (!(VN == null || kVar.jck)) {
            kVar.b(VN);
        }
        Iterator it = this.jcp.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            hVar.VB();
            hVar.Po();
        }
        it = this.jcq.iterator();
        while (it.hasNext()) {
            hVar = (h) it.next();
            hVar.VB();
            hVar.Po();
        }
        if (this.jcr != null) {
            this.jcr.Po();
        }
        this.jcp.clear();
        this.jcq.clear();
    }

    public final m VO() {
        if (this.jcr == null) {
            return new m(getContext(), this.ixr);
        }
        m mVar = this.jcr;
        this.jcr = null;
        mVar.jbY.setVisibility(0);
        removeView(mVar.jbY);
        return mVar;
    }

    public final void VP() {
        postDelayed(new Runnable(this) {
            final /* synthetic */ j jcx;

            {
                this.jcx = r1;
            }

            public final void run() {
                if (this.jcx.jcr == null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    m mVar = new m(this.jcx.getContext(), this.jcx.ixr);
                    mVar.jbY.setVisibility(4);
                    this.jcx.addView(mVar.jbY, 0);
                    this.jcx.jcr = mVar;
                    w.i("MicroMsg.AppBrandPageContainer", "preloadNextPageView: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
        }, 200);
    }

    private void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter(this) {
            final /* synthetic */ j jcx;

            public final void onAnimationEnd(Animator animator) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        animator.start();
    }
}
