package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsApiFramework;
import com.tencent.mm.plugin.appbrand.dynamic.performance.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.l.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class c implements OnAttachStateChangeListener, e, a, com.tencent.mm.sdk.platformtools.ai.c {
    private String hEr;
    private com.tencent.mm.modelappbrand.c iGN;
    private b iGU;
    private d iGV;

    public final void initialize() {
        if (!(this.hEr == null || this.hEr.length() == 0)) {
            shutdown();
        }
        this.hEr = "Token#" + System.nanoTime();
        ai.a(this);
    }

    public final void shutdown() {
        Map AL = RR().AL();
        if (AL != null && !AL.isEmpty()) {
            for (Object next : new LinkedHashSet(AL.keySet())) {
                if (next != null && (next instanceof String)) {
                    gL((String) next);
                }
            }
        }
    }

    public final View aR(Context context) {
        return new IPCDynamicPageView(context);
    }

    public final boolean a(String str, View view, Bundle bundle, q qVar) {
        f fVar = null;
        if (!(view instanceof IPCDynamicPageView)) {
            return false;
        }
        String string;
        String string2;
        String aF = b.aF(System.nanoTime());
        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.c("widget_launch", aF, "on_bind_view", true);
        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.aR(aF, "init_finish");
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        if (bundle != null) {
            string = bundle.getString("app_id");
            string2 = bundle.getString("msg_id");
            bundle.putString("__session_id", str);
            bundle.putLong("__on_bind_nano_time", System.nanoTime());
            bundle.putString("__session_id", aF);
            bundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c.oI(aF));
        } else {
            string2 = null;
            string = null;
        }
        aF = MiniJsApiFramework.aP(string, string2);
        iPCDynamicPageView.removeOnAttachStateChangeListener(this);
        iPCDynamicPageView.addOnAttachStateChangeListener(this);
        Assert.assertNotNull(aF);
        iPCDynamicPageView.iJo = System.currentTimeMillis();
        if (qVar != null) {
            fVar = qVar.AV();
        }
        if (!(iPCDynamicPageView.iDc == null || aF.equals(iPCDynamicPageView.iDc))) {
            iPCDynamicPageView.Po();
        }
        if (!((aF.equals(iPCDynamicPageView.iDc) || fVar == null) && iPCDynamicPageView.iJn)) {
            fVar.q(iPCDynamicPageView, 0);
        }
        iPCDynamicPageView.iJn = false;
        IPCDynamicPageView.iGt.post(new AnonymousClass3(iPCDynamicPageView, aF, bundle, qVar, string));
        w.v("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[]{aF});
        com.tencent.mm.plugin.appbrand.dynamic.performance.a Si = com.tencent.mm.plugin.appbrand.dynamic.performance.a.Si();
        if (!(this == null || str == null || str.length() == 0)) {
            Si.iIl.put(str, this);
        }
        com.tencent.mm.plugin.appbrand.dynamic.performance.a.Si().c(str, iPCDynamicPageView);
        RR().g(str, iPCDynamicPageView);
        return true;
    }

    public final void a(String str, View view) {
        if (view instanceof IPCDynamicPageView) {
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            w.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", new Object[]{iPCDynamicPageView.iDc});
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            RR().h(str, iPCDynamicPageView);
            com.tencent.mm.plugin.appbrand.dynamic.performance.a.Si().b(str, iPCDynamicPageView);
            iPCDynamicPageView.detach();
        }
    }

    public final void gL(String str) {
        com.tencent.mm.plugin.appbrand.dynamic.performance.a.Si().iIk.remove(str);
        com.tencent.mm.plugin.appbrand.dynamic.performance.a Si = com.tencent.mm.plugin.appbrand.dynamic.performance.a.Si();
        if (!(str == null || str.length() == 0)) {
            Si.iIl.remove(str);
        }
        Set<View> az = RR().az(str);
        if (az != null && !az.isEmpty()) {
            for (View view : az) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
                    w.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", new Object[]{iPCDynamicPageView.iDc});
                    iPCDynamicPageView.removeOnAttachStateChangeListener(this);
                    iPCDynamicPageView.detach();
                }
            }
            if (RR().AL().isEmpty()) {
                com.tencent.mm.bk.a.post(new Runnable() {
                    public final void run() {
                        com.tencent.mm.ipcinvoker.e.a("com.tencent.mm:support", null, b.class, null);
                    }
                });
            }
        }
    }

    private com.tencent.mm.modelappbrand.c RR() {
        if (this.iGN == null) {
            synchronized (this) {
                if (this.iGN == null) {
                    this.iGN = new a();
                }
            }
        }
        return this.iGN;
    }

    public final d AM() {
        if (this.iGU == null) {
            synchronized (this) {
                if (this.iGU == null) {
                    this.iGU = new b(RR());
                }
            }
        }
        return this.iGU;
    }

    public final i AN() {
        if (this.iGV == null) {
            synchronized (this) {
                if (this.iGV == null) {
                    this.iGV = new d();
                }
            }
        }
        return this.iGV;
    }

    public final void b(Throwable th) {
        w.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", new Object[]{Log.getStackTraceString(th)});
        shutdown();
    }

    public final void onViewAttachedToWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            w.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", new Object[]{((IPCDynamicPageView) view).iDc});
            r6.onResume();
        }
    }

    public final void onViewDetachedFromWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            w.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", new Object[]{((IPCDynamicPageView) view).iDc});
            r6.onPause();
        }
    }

    public final void a(String str, IPCDynamicPageView iPCDynamicPageView) {
        w.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", new Object[]{str, iPCDynamicPageView.iDc});
        a(str, (View) iPCDynamicPageView);
    }
}
