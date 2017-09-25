package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.o;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.dynamic.b;
import com.tencent.mm.plugin.appbrand.dynamic.g;
import com.tencent.mm.plugin.appbrand.dynamic.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import org.json.JSONArray;

public class IPCDynamicPageView extends LinearLayout implements a, g {
    public static ae iGt;
    private static LayoutParams iJs = new LayoutParams(-1, -1);
    public String iDc;
    private com.tencent.mm.plugin.appbrand.dynamic.i.a iGx;
    private Bundle iJj;
    private com.tencent.mm.plugin.appbrand.dynamic.a iJk;
    private long iJl;
    private q iJm;
    public volatile boolean iJn;
    public long iJo;
    private a iJp;
    private Runnable iJq = new Runnable(this) {
        final /* synthetic */ IPCDynamicPageView iJt;

        {
            this.iJt = r1;
        }

        public final void run() {
            int i = 1;
            if (!this.iJt.iJn) {
                this.iJt.iJn = true;
                this.iJt.hG(4);
                long currentTimeMillis = System.currentTimeMillis() - this.iJt.iJo;
                if (currentTimeMillis <= 1000) {
                    i = 0;
                } else if (currentTimeMillis > 2000) {
                    i = currentTimeMillis <= 3000 ? 2 : currentTimeMillis <= 4000 ? 3 : currentTimeMillis <= 5000 ? 4 : currentTimeMillis <= 6000 ? 5 : currentTimeMillis <= 7000 ? 6 : currentTimeMillis <= 8000 ? 7 : currentTimeMillis <= 9000 ? 8 : currentTimeMillis <= 10000 ? 9 : 10;
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(645, (long) i, 1, false);
            }
            this.iJt.iJl = System.currentTimeMillis();
            this.iJt.iJp.Rp();
        }
    };
    private Runnable iJr = new Runnable(this) {
        final /* synthetic */ IPCDynamicPageView iJt;

        {
            this.iJt = r1;
        }

        public final void run() {
            String e = this.iJt.iDc;
            if (bg.mA(e)) {
                w.i("MicroMsg.IPCDynamicPageView", "detach failed, id is null or nil.");
                return;
            }
            this.iJt.pn = true;
            com.tencent.mm.plugin.appbrand.dynamic.a f = this.iJt.iJk;
            if (e == null || e.length() == 0) {
                w.v("MicroMsg.DynamicIPCJsBridge", "detach(%s) failed, id is null or nil.", new Object[]{Integer.valueOf(f.hashCode())});
            } else {
                w.i("MicroMsg.DynamicIPCJsBridge", "detach(%s, id : %s)", new Object[]{Integer.valueOf(f.hashCode()), e});
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                e.a("com.tencent.mm:support", bundle, b.class, new com.tencent.mm.plugin.appbrand.dynamic.a.AnonymousClass2(f, e));
            }
            com.tencent.mm.plugin.appbrand.dynamic.e RQ = com.tencent.mm.plugin.appbrand.dynamic.e.RQ();
            if (bg.mA(e)) {
                w.w("MicroMsg.DynamicPageViewMgr", "remove view from manager failed, key is null or nil.");
            } else {
                WeakReference weakReference = (WeakReference) RQ.iGK.remove(e);
                if (weakReference != null) {
                    weakReference.get();
                }
            }
            this.iJt.Po();
            this.iJt.iGx = null;
            this.iJt.iDc = null;
            this.iJt.iJm = null;
            this.iJt.iJn = false;
            this.iJt.iJp.Rt();
        }
    };
    private volatile boolean pn;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String fxR;
        final /* synthetic */ Bundle iGl;
        final /* synthetic */ IPCDynamicPageView iJt;
        final /* synthetic */ q iJu;
        final /* synthetic */ String uF;

        public AnonymousClass3(IPCDynamicPageView iPCDynamicPageView, String str, Bundle bundle, q qVar, String str2) {
            this.iJt = iPCDynamicPageView;
            this.uF = str;
            this.iGl = bundle;
            this.iJu = qVar;
            this.fxR = str2;
        }

        public final void run() {
            if (!(this.iJt.iDc == null || this.uF.equals(this.iJt.iDc))) {
                this.iJt.detach();
            }
            this.iJt.iDc = this.uF;
            this.iJt.iJj = this.iGl;
            this.iJt.iJm = new r(this.iJu);
            com.tencent.mm.plugin.appbrand.dynamic.a f = this.iJt.iJk;
            String str = this.uF;
            String str2 = this.fxR;
            Bundle bundle = this.iGl;
            f.iDc = str;
            String str3 = "Token#" + System.nanoTime();
            f.iGi = str3;
            Bundle bundle2 = new Bundle();
            bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle2.putString("appId", str2);
            if (bundle != null) {
                bundle2.putInt("scene", bundle.getInt("scene"));
                bundle2.putInt("widgetType", bundle.getInt("widget_type"));
                bundle2.putInt("wxaPkgType", bundle.getInt("msg_pkg_type"));
                bundle2.putString("searchId", bundle.getString("search_id", ""));
                bundle2.putInt("pkgVersion", bundle.getInt("pkg_version"));
            }
            e.a("com.tencent.mm:support", bundle2, c.class, new com.tencent.mm.plugin.appbrand.dynamic.a.AnonymousClass1(f, str3, str, str2, bundle));
            this.iJt.pn = false;
        }
    }

    static /* synthetic */ Bundle b(IPCDynamicPageView iPCDynamicPageView, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("__page_view_id", iPCDynamicPageView.iDc);
        bundle2.putString("__process_name", ab.um());
        int measuredWidth = iPCDynamicPageView.getMeasuredWidth();
        int measuredHeight = iPCDynamicPageView.getMeasuredHeight();
        if ((measuredWidth == 0 || measuredHeight == 0) && bundle != null) {
            measuredWidth = bundle.getInt("view_init_width");
            measuredHeight = bundle.getInt("view_init_height");
        }
        bundle2.putInt("__page_view_width", measuredWidth);
        bundle2.putInt("__page_view_height", measuredHeight);
        return bundle2;
    }

    static {
        HandlerThread Qu = com.tencent.mm.sdk.f.e.Qu("MiniJsApiFramework#UIActionThread");
        Qu.start();
        iGt = new ae(Qu.getLooper());
    }

    public IPCDynamicPageView(Context context) {
        super(context);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.iJk = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
        View aR = b.aR(context);
        addView(aR, iJs);
        this.iJp = (a) aR;
    }

    public final void d(final String str, final String str2, final Bundle bundle) {
        iGt.post(new Runnable(this) {
            final /* synthetic */ IPCDynamicPageView iJt;

            public final void run() {
                String str = "";
                if (bundle != null) {
                    str = bundle.getString("cache_key", "");
                }
                w.i("MicroMsg.IPCDynamicPageView", "attach(%s, %s, %s)", new Object[]{str, str2, str});
                this.iJt.iGx = d.oS(str);
                if (this.iJt.iGx == null) {
                    this.iJt.iGx = new com.tencent.mm.plugin.appbrand.dynamic.i.a();
                }
                this.iJt.iGx.field_id = str;
                this.iJt.iGx.field_cacheKey = str;
                this.iJt.iGx.field_appId = str2;
                this.iJt.nU(str);
                com.tencent.mm.plugin.appbrand.dynamic.e RQ = com.tencent.mm.plugin.appbrand.dynamic.e.RQ();
                String str2 = str;
                IPCDynamicPageView iPCDynamicPageView = this.iJt;
                if (bg.mA(str2)) {
                    w.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, key is null or nil.");
                } else if (iPCDynamicPageView == null) {
                    w.w("MicroMsg.DynamicPageViewMgr", "add view into manager failed, view is null.");
                } else {
                    WeakReference weakReference = (WeakReference) RQ.iGK.put(str2, new WeakReference(iPCDynamicPageView));
                    if (!(weakReference == null || weakReference.get() == null)) {
                        w.i("MicroMsg.DynamicPageViewMgr", "add a new view and remove old one with key : %s.", new Object[]{str2});
                    }
                }
                if (bundle != null) {
                    bundle.putBundle("__env_args", IPCDynamicPageView.b(this.iJt, bundle));
                }
                this.iJt.iJk;
                str = str;
                str2 = str2;
                Bundle bundle = bundle;
                Bundle bundle2 = new Bundle();
                bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
                bundle2.putString("appId", str2);
                bundle2.putBundle("extData", bundle);
                e.a("com.tencent.mm:support", bundle2, a.class, null);
            }
        });
    }

    public final void detach() {
        if (Looper.myLooper() == iGt.getLooper()) {
            this.iJr.run();
        } else {
            iGt.post(this.iJr);
        }
    }

    public final void Po() {
        if (this.iGx != null) {
            w.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[]{this.iDc, this.iGx.field_id, this.iGx.field_appId, this.iGx.field_cacheKey});
        } else {
            w.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[]{this.iDc});
        }
        Rq();
    }

    public final void hD(int i) {
        hG(i);
        detach();
    }

    public final void b(int i, p pVar) {
        if (this.iJm == null) {
            pVar.a(false, "listener is null", null);
            return;
        }
        o AW = this.iJm.AW();
        if (AW == null) {
            pVar.a(false, "listener is null", null);
        } else {
            AW.a(i, pVar);
        }
    }

    public final boolean b(Canvas canvas) {
        return this.iJp.b(canvas);
    }

    public final void Rp() {
        long currentTimeMillis = System.currentTimeMillis() - this.iJl;
        iGt.removeCallbacks(this.iJq);
        if (currentTimeMillis < 12) {
            iGt.postDelayed(this.iJq, currentTimeMillis);
        } else {
            this.iJq.run();
        }
    }

    public final void d(JSONArray jSONArray) {
        this.iJp.d(jSONArray);
    }

    public final void e(JSONArray jSONArray) {
        this.iJp.e(jSONArray);
    }

    public final void Rq() {
        this.iJp.Rq();
    }

    public final void nU(String str) {
        this.iJp.nU(str);
    }

    public final void j(Runnable runnable) {
        this.iJp.j(runnable);
    }

    public final void onPause() {
        w.v("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[]{this.iDc});
        this.iJp.onPause();
        iGt.post(new Runnable(this) {
            final /* synthetic */ IPCDynamicPageView iJt;

            {
                this.iJt = r1;
            }

            public final void run() {
                this.iJt.iJk;
                String e = this.iJt.iDc;
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                e.a("com.tencent.mm:support", bundle, d.class, null);
            }
        });
    }

    public final void onResume() {
        w.v("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[]{this.iDc});
        this.iJp.onResume();
        iGt.post(new Runnable(this) {
            final /* synthetic */ IPCDynamicPageView iJt;

            {
                this.iJt = r1;
            }

            public final void run() {
                this.iJt.iJk;
                String e = this.iJt.iDc;
                Bundle bundle = new Bundle();
                bundle.putString(SlookAirButtonFrequentContactAdapter.ID, e);
                e.a("com.tencent.mm:support", bundle, e.class, null);
            }
        });
    }

    public final boolean isPaused() {
        return this.iJp.isPaused();
    }

    public final void nV(String str) {
        this.iJp.nV(str);
    }

    public final int Rr() {
        return this.iJp.Rr();
    }

    public final int Rs() {
        return this.iJp.Rs();
    }

    public final void setStartTime(long j) {
        this.iJp.setStartTime(j);
    }

    public final void Rt() {
        this.iJp.Rt();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        Bundle bundle = new Bundle();
        bundle.putInt("__page_view_width", i);
        bundle.putInt("__page_view_height", i2);
        String str = this.iDc;
        Bundle bundle2 = new Bundle();
        bundle2.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle2.putBundle("__env_args", bundle);
        e.a("com.tencent.mm:support", bundle2, f.class, null);
    }

    private void hG(final int i) {
        if (this.iJm == null) {
            w.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[]{this.iDc, Integer.valueOf(i)});
            return;
        }
        final f AV = this.iJm.AV();
        if (AV == null) {
            w.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[]{this.iDc, Integer.valueOf(i)});
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            AV.q(this, i);
        } else {
            b.l(new Runnable(this) {
                final /* synthetic */ IPCDynamicPageView iJt;

                public final void run() {
                    AV.q(this.iJt, i);
                }
            });
        }
    }
}
