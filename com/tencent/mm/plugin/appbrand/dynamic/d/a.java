package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.plugin.appbrand.dynamic.performance.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.performance.collector.d;
import com.tencent.mm.plugin.appbrand.dynamic.performance.collector.f;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.dynamic.core.a {

    private static class a implements Runnable {
        String iHN;
        JSONObject iHO;
        a iHP;
        com.tencent.mm.plugin.appbrand.dynamic.core.b.a iHQ;
        com.tencent.mm.u.q.b iHR;
        String process;

        public final void run() {
            synchronized (this.iHR) {
                this.iHR.l(this.iHP.oF("lastTime"), Long.valueOf(System.currentTimeMillis()));
            }
            Bundle bundle = new Bundle();
            bundle.putString("viewId", this.iHN);
            bundle.putString("jsApiInvokeData", this.iHO.toString());
            String g = f.g(this.iHO);
            Parcelable aQ = c.aQ(g, "after_jsapi_invoke");
            bundle.putString("__session_id", g);
            bundle.putParcelable("__cost_time_session", aQ);
            e.a(this.process, bundle, b.class, new com.tencent.mm.ipcinvoker.c(this) {
                final /* synthetic */ a iHS;

                {
                    this.iHS = r1;
                }

                public final void k(Bundle bundle) {
                    this.iHS.iHQ.f(this.iHS.iHP.a(bundle.getBoolean("ret"), bundle.getString("reason", ""), null));
                }
            });
        }
    }

    private static class b implements com.tencent.mm.ipcinvoker.a {
        private b() {
        }

        public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
            String string = bundle.getString("__session_id");
            c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
            c.aQ(string, "after_cross_process_invoke");
            Bundle bundle2 = new Bundle();
            View oz = com.tencent.mm.plugin.appbrand.dynamic.e.RQ().oz(bundle.getString("viewId"));
            if (oz instanceof com.tencent.mm.plugin.appbrand.canvas.widget.a) {
                try {
                    JSONObject jSONObject = new JSONObject(bundle.getString("jsApiInvokeData"));
                    JSONArray optJSONArray = jSONObject.optJSONArray("actions");
                    boolean optBoolean = jSONObject.optBoolean("reserve");
                    c.aQ(string, "after_cp_parse_json_end");
                    if (oz instanceof d) {
                        d dVar = (d) oz;
                        dVar.nV(string);
                        dVar.setStartTime(jSONObject.optLong("__invoke_jsapi_timestamp"));
                    }
                    com.tencent.mm.plugin.appbrand.canvas.widget.a aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) oz;
                    if (optBoolean) {
                        aVar.e(optJSONArray);
                    } else {
                        aVar.d(optJSONArray);
                    }
                    aVar.Rp();
                    bundle2.putBoolean("ret", true);
                    cVar.k(bundle2);
                    return;
                } catch (JSONException e) {
                    w.e("MicroMsg.JsApiFunc_DrawCanvas", "drawCanvas failed, IPC parse JSONObject error : %s", new Object[]{e});
                    bundle2.putBoolean("ret", false);
                    bundle2.putString("reason", "parse json data error");
                    cVar.k(bundle2);
                    return;
                }
            }
            w.i("MicroMsg.JsApiFunc_DrawCanvas", "drawCanvas failed, view is not a instance of DrawableView.(%s)", new Object[]{r0});
            bundle2.putBoolean("ret", false);
            bundle2.putString("reason", "view is not a instance of DrawableView");
            cVar.k(bundle2);
        }
    }

    public a() {
        super(x.NAME, 265);
    }

    protected final void b(com.tencent.mm.plugin.appbrand.dynamic.core.e eVar, JSONObject jSONObject, com.tencent.mm.plugin.appbrand.dynamic.core.b.a aVar) {
        c.aQ(f.g(jSONObject), "before_jsapi_invoke");
        com.tencent.mm.u.q.b RT = eVar.RT();
        String string = RT.getString("__page_view_id", null);
        String string2 = RT.getString("__process_name", ab.um());
        if (com.tencent.mm.plugin.appbrand.dynamic.d.RP().oy(string) == null) {
            w.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", new Object[]{string});
            aVar.f(a(false, "got 'null' when get view by the given viewId", null));
            return;
        }
        Object obj;
        long j;
        synchronized (RT) {
            long longValue;
            long currentTimeMillis = System.currentTimeMillis();
            CharSequence oF = oF("lastTime");
            if (!TextUtils.isEmpty(oF)) {
                obj = RT.hlC.get(oF);
                if (obj instanceof Long) {
                    longValue = ((Long) obj).longValue();
                    j = currentTimeMillis - longValue;
                }
            }
            longValue = 0;
            j = currentTimeMillis - longValue;
        }
        obj = (a) RT.fS(oF("DrawCanvasRunnable"));
        if (obj == null) {
            obj = new a();
            RT.l(oF("DrawCanvasRunnable"), obj);
        }
        obj.process = string2;
        obj.iHN = string;
        obj.iHO = jSONObject;
        obj.iHP = this;
        obj.iHQ = aVar;
        obj.iHR = RT;
        com.tencent.mm.plugin.appbrand.dynamic.b.RN().removeCallbacks(obj);
        if (j < 16) {
            w.v("MicroMsg.JsApiFunc_DrawCanvas", "postDelayed(%s)", new Object[]{Long.valueOf(j)});
            com.tencent.mm.plugin.appbrand.dynamic.b.RN().postDelayed(obj, j);
            return;
        }
        obj.run();
    }

    public final String oF(String str) {
        return this.name + "#" + str;
    }
}
