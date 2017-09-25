package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Looper;
import android.view.View;
import com.tencent.mm.plugin.appbrand.g.s;
import com.tencent.mm.plugin.appbrand.g.s.AnonymousClass4;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c extends d {

    protected static class a {
        int iMH;
        com.tencent.mm.plugin.appbrand.jsapi.c iRn;

        a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i) {
            this.iRn = cVar;
            this.iMH = i;
        }

        public final void pq(String str) {
            this.iRn.x(this.iMH, str);
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
        if (b == null) {
            w.w("MicroMsg.BaseUpdateViewJsApi", "invoke JsApi updateView failed, current page view is null.");
            mVar.x(i, d("fail:page is null", null));
            return;
        }
        a((com.tencent.mm.plugin.appbrand.jsapi.c) mVar, i, b, jSONObject);
    }

    public final void a(com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        a((com.tencent.mm.plugin.appbrand.jsapi.c) mVar, i, mVar, jSONObject);
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i, com.tencent.mm.plugin.appbrand.g.m mVar, JSONObject jSONObject) {
        final com.tencent.mm.plugin.appbrand.g.m mVar2 = mVar;
        final com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        af.v(new Runnable(this) {
            final /* synthetic */ c iRm;

            public final void run() {
                if (mVar2 == null) {
                    w.w("MicroMsg.BaseUpdateViewJsApi", "page view has been release.");
                    cVar2.x(i2, this.iRm.d("fail:page is null", null));
                    return;
                }
                try {
                    int h = this.iRm.h(jSONObject2);
                    View il = mVar2.jdc.il(h);
                    if (il == null) {
                        w.w("MicroMsg.BaseUpdateViewJsApi", "get view by viewId(%s) return null.", new Object[]{Integer.valueOf(h)});
                        cVar2.x(i2, this.iRm.d("fail:got 'null' when get view by the given viewId", null));
                        return;
                    }
                    boolean booleanValue;
                    c cVar = this.iRm;
                    com.tencent.mm.plugin.appbrand.g.m mVar = mVar2;
                    JSONObject jSONObject = jSONObject2;
                    if (cVar.Tf()) {
                        try {
                            b B = mVar.jdc.B(h, false);
                            if (B != null) {
                                jSONObject.getBoolean("disableScroll");
                                if (!B.fR("isTouching")) {
                                    B.o("disableScroll", true);
                                } else if (!B.getBoolean("disableScroll", false)) {
                                    B.o("disableScroll-nextState", true);
                                }
                            }
                        } catch (JSONException e) {
                        }
                    }
                    try {
                        int[] i = d.i(jSONObject2);
                        int j = d.j(jSONObject2);
                        s sVar = mVar2.jdc;
                        bb anonymousClass4 = new AnonymousClass4(sVar, Boolean.valueOf(false), h, i, j);
                        booleanValue = Thread.currentThread() == Looper.getMainLooper().getThread() ? ((Boolean) anonymousClass4.b(null)).booleanValue() : ((Boolean) anonymousClass4.b(sVar.mHandler)).booleanValue();
                        String str = "MicroMsg.BaseUpdateViewJsApi";
                        String str2 = "update view(parentId : %s, viewId : %d), ret : %b";
                        Object[] objArr = new Object[4];
                        a ij = mVar2.jdc.ij(h);
                        objArr[0] = Integer.valueOf(ij == null ? 0 : ij.jeu);
                        objArr[1] = Integer.valueOf(h);
                        objArr[2] = Integer.valueOf(il.hashCode());
                        objArr[3] = Boolean.valueOf(booleanValue);
                        w.i(str, str2, objArr);
                    } catch (JSONException e2) {
                        booleanValue = true;
                    }
                    if (booleanValue) {
                        if (this.iRm.Ts()) {
                            booleanValue = this.iRm.a(mVar2, h, il, jSONObject2, new a(cVar2, i2));
                        } else {
                            booleanValue = this.iRm.a(mVar2, h, il, jSONObject2);
                        }
                    }
                    if (!this.iRm.Ts()) {
                        String str3;
                        com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar2;
                        int i2 = i2;
                        d dVar = this.iRm;
                        if (booleanValue) {
                            str3 = "ok";
                        } else {
                            str3 = "fail";
                        }
                        cVar2.x(i2, dVar.d(str3, null));
                    }
                } catch (JSONException e3) {
                    cVar2.x(i2, this.iRm.d("fail:view id do not exist", null));
                }
            }
        });
    }

    public boolean a(com.tencent.mm.plugin.appbrand.g.m mVar, int i, View view, JSONObject jSONObject) {
        return true;
    }

    public boolean a(com.tencent.mm.plugin.appbrand.g.m mVar, int i, View view, JSONObject jSONObject, a aVar) {
        return true;
    }

    public boolean Tf() {
        return false;
    }

    public boolean Ts() {
        return false;
    }
}
