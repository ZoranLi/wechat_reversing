package com.tencent.mm.plugin.appbrand.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.AppBrandJSInterface;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.menu.j;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.widget.AppBrandOptionButton;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.WebView;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"ViewConstructor"})
public final class m extends com.tencent.mm.plugin.appbrand.jsapi.c {
    public boolean aaI = true;
    public String ivH;
    public h ixr;
    private AppBrandJSInterface ixs;
    public LinearLayout jbY;
    public Set<e> jcW = Collections.newSetFromMap(new ConcurrentHashMap());
    public Set<b> jcX = Collections.newSetFromMap(new ConcurrentHashMap());
    public Set<d> jcY = Collections.newSetFromMap(new ConcurrentHashMap());
    public Set<c> jcZ = Collections.newSetFromMap(new ConcurrentHashMap());
    public FrameLayout jcb;
    public final List<j> jcn;
    public Set<a> jda = Collections.newSetFromMap(new ConcurrentHashMap());
    public com.tencent.mm.plugin.appbrand.widget.a jdb;
    public s jdc;
    public com.tencent.mm.plugin.appbrand.widget.input.e jdd;
    public r jde;
    public p jdf;
    public f jdg;
    public boolean jdh = false;
    public int jdi;
    boolean jdj = false;
    public String jdk = null;
    public final n jdl = new n(hashCode());
    public Context mContext;

    class AnonymousClass13 implements Runnable {
        final /* synthetic */ m jdm;
        final /* synthetic */ String jdo;

        AnonymousClass13(m mVar, String str) {
            this.jdm = mVar;
            this.jdo = str;
        }

        public final void run() {
            this.jdm.jdb.rh(this.jdo);
        }
    }

    class AnonymousClass14 implements Runnable {
        final /* synthetic */ int iwS;
        final /* synthetic */ m jdm;

        public AnonymousClass14(m mVar, int i) {
            this.jdm = mVar;
            this.iwS = i;
        }

        public final void run() {
            com.tencent.mm.plugin.appbrand.widget.a aVar = this.jdm.jdb;
            aVar.jqj = this.iwS;
            aVar.Ye();
        }
    }

    class AnonymousClass19 implements Runnable {
        final /* synthetic */ m jdm;
        final /* synthetic */ boolean jdq = false;

        AnonymousClass19(m mVar, boolean z) {
            this.jdm = mVar;
        }

        public final void run() {
            this.jdm.jdf.cb(this.jdq);
        }
    }

    class AnonymousClass20 implements Runnable {
        final /* synthetic */ m jdm;
        final /* synthetic */ String jdo;
        final /* synthetic */ String jdr;

        AnonymousClass20(m mVar, String str, String str2) {
            this.jdm = mVar;
            this.jdo = str;
            this.jdr = str2;
        }

        public final void run() {
            p pVar = this.jdm.jdf;
            String str = this.jdo;
            String str2 = this.jdr;
            if ("light".equals(str)) {
                pVar.jdP.setImageDrawable(p.a(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
                pVar.jdQ.setImageDrawable(p.a(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
                pVar.jdR.setImageDrawable(p.a(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
            } else {
                pVar.jdP.setImageDrawable(p.a(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
                pVar.jdQ.setImageDrawable(p.a(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
                pVar.jdR.setImageDrawable(p.a(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
            }
            pVar.if(com.tencent.mm.plugin.webview.ui.tools.d.cd(str2, -1));
            pVar.Wd();
        }
    }

    class AnonymousClass7 implements Runnable {
        final /* synthetic */ m jdm;
        final /* synthetic */ String jdn;

        AnonymousClass7(m mVar, String str) {
            this.jdm = mVar;
            this.jdn = str;
        }

        public final void run() {
            com.tencent.mm.plugin.appbrand.widget.a aVar = this.jdm.jdb;
            aVar.CU = com.tencent.mm.plugin.webview.ui.tools.d.cd(this.jdn, aVar.CU);
            aVar.setBackgroundColor(aVar.CU);
        }
    }

    class AnonymousClass8 implements Runnable {
        final /* synthetic */ int iwS;
        final /* synthetic */ m jdm;

        public AnonymousClass8(m mVar, int i) {
            this.jdm = mVar;
            this.iwS = i;
        }

        public final void run() {
            this.jdm.jdb.setBackgroundColor(this.iwS);
        }
    }

    public interface a {
        boolean UQ();
    }

    public interface b {
        void SY();
    }

    public interface c {
        void onDestroy();
    }

    public interface d {
        void UA();
    }

    public interface e {
        void onReady();
    }

    public m(Context context, h hVar) {
        this.mContext = context;
        this.ixr = hVar;
        this.ivH = hVar.ivH;
        this.jcn = l.pO(this.ivH);
        this.jdi = context.getResources().getColor(R.e.aVV);
        this.jdb = new com.tencent.mm.plugin.appbrand.widget.a(this.mContext);
        this.jdb.jql = new OnClickListener(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void onClick(View view) {
                this.jdm.ixr.iwr.VM();
            }
        };
        this.jdb.jqm = new OnClickListener(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void onClick(View view) {
                int indexOf;
                boolean z;
                com.tencent.mm.plugin.appbrand.e.a(this.jdm.ivH, com.tencent.mm.plugin.appbrand.e.c.CLOSE);
                h hVar = this.jdm.ixr;
                i iVar = hVar.iwl;
                for (indexOf = iVar.iwW.indexOf(hVar); indexOf < iVar.iwW.size(); indexOf++) {
                    if (((h) iVar.iwW.get(indexOf)).Pw()) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    iVar = hVar.iwl;
                    if (!hVar.Pw()) {
                        int indexOf2 = iVar.iwW.indexOf(hVar) + 1;
                        if (indexOf2 != 0 && indexOf2 < iVar.iwW.size()) {
                            LinkedList linkedList = new LinkedList();
                            indexOf = indexOf2;
                            while (indexOf < iVar.iwW.size() && !((h) iVar.iwW.get(indexOf)).Pw()) {
                                linkedList.add(iVar.iwW.get(indexOf));
                                indexOf++;
                            }
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                iVar.a((h) it.next());
                            }
                        }
                    }
                    hVar.D(false);
                    return;
                }
                hVar.iwl.D(false);
            }
        };
        com.tencent.mm.plugin.appbrand.widget.a aVar = this.jdb;
        aVar.jpZ.setOnClickListener(new com.tencent.mm.plugin.appbrand.widget.a.AnonymousClass2(aVar, new OnClickListener(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void onClick(View view) {
                r rVar = this.jdm.jde;
                rVar.getView().scrollTo(rVar.getView().getScrollX(), 0);
                g.ai(this.jdm.ivH, this.jdm.hashCode());
            }
        }));
        aVar = this.jdb;
        aVar.jqg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void onClick(View view) {
                boolean z;
                int i = 0;
                AppBrandOptionButton appBrandOptionButton = (AppBrandOptionButton) view;
                if (this.jdm.mContext == null || !(this.jdm.mContext instanceof MMActivity)) {
                    z = false;
                } else {
                    z = ((MMActivity) this.jdm.mContext).uSU.are();
                }
                if (appBrandOptionButton.jqE) {
                    Runnable anonymousClass1 = new Runnable(this) {
                        final /* synthetic */ AnonymousClass26 jds;

                        {
                            this.jds = r1;
                        }

                        public final void run() {
                            i iVar = new i(this.jds.jdm.mContext, this.jds.jdm.ivH, this.jds.jdm, new LinkedList(this.jds.jdm.jcn));
                        }
                    };
                    if (z) {
                        i = 100;
                    }
                    af.f(anonymousClass1, (long) i);
                    return;
                }
                com.tencent.mm.plugin.appbrand.jsapi.j.a.pd(this.jdm.ivH);
            }
        });
        aVar = this.jdb;
        aVar.jqf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void onClick(View view) {
                j jVar = this.jdm.ixr.iwr;
                jVar.qj(jVar.ixr.iwp.Rw());
                com.tencent.mm.plugin.appbrand.report.a.a(this.jdm.ivH, this.jdm.jde.jdU, 12, "", bg.Ny(), 1, 0);
            }
        });
        this.jde = new r(this.mContext, this.ixr);
        r rVar = this.jde;
        AppBrandJSInterface appBrandJSInterface = new AppBrandJSInterface(this);
        this.ixs = appBrandJSInterface;
        rVar.addJavascriptInterface(appBrandJSInterface, "WeixinJSCore");
        this.jde.jea = new u(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void Uz() {
                m mVar = this.jdm;
                mVar.C(mVar.jdi, mVar.jdk);
                s sVar = this.jdm.jdc;
                a ij = sVar.ij(sVar.jel);
                if (ij != null) {
                    if (sVar.jel != sVar.jek) {
                        a ij2 = sVar.ij(sVar.jek);
                        sVar.a(sVar.jek, new int[]{ij2.l, ij2.t, ij2.w, ij2.h, ij2.z}, ij2.visibility);
                    }
                    int i = sVar.jel;
                    sVar.jek = -1;
                    sVar.jel = -1;
                    if (sVar.jea != null) {
                        sVar.jea.Uz();
                        sVar.jea = null;
                    }
                    sVar.a(i, new int[]{ij.l, ij.t, ij.w, ij.h, ij.z}, ij.visibility);
                }
            }
        };
        this.jde.jdW = new t(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                this.jdm.jdd.onScrollChanged(i, i2, i3, i4, view);
            }
        };
        rVar = this.jde;
        if (rVar.jeg == null) {
            rVar.jeg = rVar.We() + "page-frame.html";
        }
        rVar.loadUrl(rVar.jeg);
        this.jdf = new p(this.mContext, this.jde);
        this.jdf.jdJ = new com.tencent.mm.plugin.appbrand.g.p.a(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void VU() {
                this.jdm.a("onPullDownRefresh", null, null);
            }
        };
        this.jdf.jdK = new com.tencent.mm.plugin.appbrand.g.p.b(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void id(int i) {
                this.jdm.jdd.setTranslationY((float) i);
            }
        };
        this.jcb = new FrameLayout(this.mContext);
        this.jcb.addView(this.jdf);
        FrameLayout frameLayout = this.jcb;
        View eVar = new com.tencent.mm.plugin.appbrand.widget.input.e(this.mContext, this);
        this.jdd = eVar;
        frameLayout.addView(eVar);
        frameLayout = this.jcb;
        eVar = new f(this.mContext);
        this.jdg = eVar;
        frameLayout.addView(eVar);
        this.jdf.jdK = this.jdd;
        this.jbY = new LinearLayout(this, this.mContext) {
            final /* synthetic */ m jdm;

            protected final void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                s sVar = this.jdm.jdc;
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                obtain.setSource(4098);
                for (a aVar : sVar.jej) {
                    View view = (View) aVar.jet.get();
                    if (view != null) {
                        view.dispatchTouchEvent(obtain);
                    }
                }
                obtain.recycle();
            }
        };
        this.jbY.setId(R.h.bpk);
        this.jbY.setLayoutParams(new LayoutParams(-1, -1));
        this.jbY.setOrientation(1);
        this.jbY.addView(this.jdb);
        this.jbY.addView(this.jcb, new LayoutParams(-1, -1));
        this.jdc = new s(this.jde);
        com.tencent.mm.plugin.appbrand.widget.input.m.h(this);
    }

    public final String getAppId() {
        return this.ivH;
    }

    public final h PI() {
        return this.ixr;
    }

    public final com.tencent.mm.plugin.appbrand.d PJ() {
        return this.jde;
    }

    public final void qo(String str) {
        boolean z;
        r rVar = this.jde;
        rVar.jdU = o.qW(str);
        rVar.jdV = str;
        if (com.tencent.mm.plugin.appbrand.appcache.l.b(rVar.ixr, rVar.jdU)) {
            rVar.jee = System.currentTimeMillis();
            if (rVar.ixy) {
                rVar.qv(rVar.jdU);
                w.i("MicroMsg.AppBrandWebView", "Frame ready, inject page");
            } else {
                w.i("MicroMsg.AppBrandWebView", "Frame not ready, wait for it");
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.jdb.cl(false);
            runOnUiThread(new AnonymousClass19(this, false));
            j jVar = this.ixr.iwr;
            if (jVar.getPageCount() < 2) {
                jVar.jcs = true;
            }
            View bVar = new b(this.mContext);
            AppBrandSysConfig appBrandSysConfig = this.ixr.iwo;
            b.inflate(bVar.getContext(), R.i.cTX, bVar);
            bVar.jbU = (ImageView) bVar.findViewById(R.h.boT);
            bVar.jbV = (TextView) bVar.findViewById(R.h.boV);
            bVar.jbW = (Button) bVar.findViewById(R.h.boS);
            bVar.jbV.setText(bVar.getResources().getString(R.l.dEa, new Object[]{appBrandSysConfig.fGs}));
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            bVar.jbU.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            com.tencent.mm.modelappbrand.a.b.AY().a(bVar.jbU, appBrandSysConfig.iEP, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqF);
            bVar.jbW.setVisibility(8);
            bVar.setBackgroundColor(-1);
            com.tencent.mm.plugin.appbrand.report.a.al(appBrandSysConfig.appId, 27);
            this.jcb.addView(bVar);
            onReady();
        }
        n nVar = this.jdl;
        nVar.jdu = bg.Nz();
        nVar.jdt.Wt();
    }

    public final void a(String str, String str2, int[] iArr) {
        this.ixr.iwq.f(str, str2, hashCode());
    }

    public final boolean isRunning() {
        return this.aaI;
    }

    public final void Po() {
        this.jde.destroy();
        this.ixs.Po();
        this.jcW.clear();
        this.jcZ.clear();
        this.jcX.clear();
        this.jcY.clear();
        this.jda.clear();
    }

    public final void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.jbY.post(runnable);
        }
    }

    public final void a(e eVar) {
        this.jcW.add(eVar);
    }

    public final void b(e eVar) {
        this.jcW.remove(eVar);
    }

    public final void onReady() {
        n nVar = this.jdl;
        nVar.jdv = bg.Nz() - nVar.jdu;
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void run() {
                r rVar = this.jdm.jde;
                rVar.ixr.iwB.k(4, System.currentTimeMillis() - rVar.jed);
                AppBrandPerformanceManager.b(rVar.ivH, aq.CTRL_INDEX, System.currentTimeMillis() - rVar.jee);
                com.tencent.mm.plugin.appbrand.performance.a.a(rVar.ivH, "Native", "PageLoad", rVar.jee, System.currentTimeMillis(), "");
                for (e onReady : this.jdm.jcW) {
                    onReady.onReady();
                }
            }
        });
    }

    final void UA() {
        if (com.tencent.mm.plugin.appbrand.b.mZ(this.ivH).scene == 1023) {
            if (this.ixr.iwr.getPageCount() == 1) {
                this.jdb.co(true);
            } else {
                this.jdb.co(false);
                this.jdb.cn(true);
            }
        } else if (this.ixr.Pw()) {
            this.jdb.co(false);
            this.jdb.cn(true);
        } else {
            this.jdb.co(false);
            this.jdb.cn(false);
        }
        if (this.ixr.Pw() || this.ixr.iwr.getPageCount() != 1 || this.ixr.iwr.VN().qh(this.ixr.iwp.Rw())) {
            this.jdb.cm(false);
        } else {
            this.jdb.cm(true);
        }
        n nVar = this.jdl;
        if (nVar.jdu > 0) {
            nVar.jdt.Wt();
        }
        this.jde.qu(qt("VISIBLE"));
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void run() {
                for (d UA : this.jdm.jcY) {
                    UA.UA();
                }
            }
        });
    }

    public final void a(d dVar) {
        this.jcY.add(dVar);
    }

    public final void b(d dVar) {
        this.jcY.remove(dVar);
    }

    final void SY() {
        this.jde.Wf();
        this.jdl.jdt.Wu();
        this.jde.qu(qt("INVISIBLE"));
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void run() {
                for (b SY : this.jdm.jcX) {
                    SY.SY();
                }
            }
        });
    }

    public final void a(b bVar) {
        this.jcX.add(bVar);
    }

    public final void b(b bVar) {
        this.jcX.remove(bVar);
    }

    final void onDestroy() {
        this.aaI = false;
        n nVar = this.jdl;
        nVar.jdt.Wu();
        com.tencent.mm.plugin.appbrand.report.e eVar = nVar.jdt;
        eVar.quit();
        eVar.pQ = true;
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void run() {
                for (c onDestroy : this.jdm.jcZ) {
                    onDestroy.onDestroy();
                }
            }
        });
    }

    public final void a(c cVar) {
        this.jcZ.add(cVar);
    }

    public final void b(c cVar) {
        this.jcZ.remove(cVar);
    }

    public final void qp(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            public final void run() {
                this.jdm.jdb.rg(str);
            }
        });
    }

    public final String VR() {
        CharSequence text = this.jdb.jqa.getText();
        return text != null ? text.toString() : "";
    }

    public final void qq(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            public final void run() {
                com.tencent.mm.plugin.appbrand.widget.a aVar = this.jdm.jdb;
                CharSequence charSequence = str;
                if (bg.mA(charSequence)) {
                    aVar.jqb.setVisibility(8);
                } else {
                    aVar.jqb.setVisibility(0);
                    aVar.jqb.setText(charSequence);
                }
                aVar.jqb.clearAnimation();
            }
        });
    }

    public final void VS() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void run() {
                com.tencent.mm.plugin.appbrand.widget.a aVar = this.jdm.jdb;
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setStartOffset(0);
                alphaAnimation.setRepeatMode(2);
                alphaAnimation.setRepeatCount(-1);
                aVar.jqb.startAnimation(alphaAnimation);
            }
        });
    }

    public final void bZ(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            public final void run() {
                this.jdm.jdb.cp(z);
            }
        });
    }

    public final void ca(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            public final void run() {
                this.jdm.jdf.cb(z);
                this.jdm.jdf.ca(z);
            }
        });
    }

    public final void qr(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            public final void run() {
                this.jdm.jdf.cb(true);
                this.jdm.jdf.ca(false);
                p pVar = this.jdm.jdf;
                CharSequence charSequence = str;
                if (bg.mA(charSequence)) {
                    pVar.jdN.setVisibility(8);
                    return;
                }
                pVar.if(com.tencent.mm.bg.a.b(pVar.getContext(), R.e.aWs));
                pVar.jdN.setTextColor(com.tencent.mm.bg.a.b(pVar.getContext(), R.e.aWt));
                pVar.jdN.setVisibility(0);
                pVar.jdN.setText(charSequence);
            }
        });
    }

    public final void A(int i, boolean z) {
        if (i != 0) {
            l.a(this.jcn, i - 1, z);
        }
    }

    public final j ic(int i) {
        return l.c(this.jcn, i - 1);
    }

    public final void qs(String str) {
        this.jdj = true;
        this.jdk = str;
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ m jdm;

            {
                this.jdm = r1;
            }

            public final void run() {
                this.jdm.C(this.jdm.jdi, this.jdm.jdk);
            }
        });
    }

    public final void C(int i, String str) {
        View view = this.jbY;
        boolean equals = "black".equals(str);
        if (view != null) {
            while (!(view instanceof com.tencent.mm.plugin.appbrand.widget.i)) {
                ViewParent parent = view.getParent();
                if (parent == null) {
                    return;
                }
                if (parent instanceof ViewGroup) {
                    view = (View) parent;
                } else {
                    return;
                }
            }
            ((com.tencent.mm.plugin.appbrand.widget.i) view).C(i, equals);
        }
    }

    private String qt(String str) {
        return this.ivH + ":" + this.jde.jdU + ":" + str;
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.l.a VT() {
        return d(this.jdc.ih(0));
    }

    private com.tencent.mm.plugin.appbrand.jsapi.l.a d(ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof com.tencent.mm.plugin.appbrand.jsapi.l.a) {
                return (com.tencent.mm.plugin.appbrand.jsapi.l.a) childAt;
            }
            if (childAt instanceof ViewGroup) {
                com.tencent.mm.plugin.appbrand.jsapi.l.a d = d((ViewGroup) childAt);
                if (d != null) {
                    return d;
                }
            }
        }
        return null;
    }
}
