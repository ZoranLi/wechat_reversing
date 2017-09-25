package com.tencent.mm.plugin.appbrand.dynamic.core;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.dynamic.performance.collector.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f {
    public Handler iHc;
    public b iHd;
    private com.tencent.mm.plugin.appbrand.dynamic.h.a iHe;

    private static final class a implements com.tencent.mm.plugin.appbrand.dynamic.core.b.a {
        JSONObject iHn;

        a() {
        }

        public final void f(JSONObject jSONObject) {
            this.iHn = jSONObject;
        }
    }

    private static final class b implements e {
        MiniJsBridge iGz;
        public com.tencent.mm.u.q.b iHo = new com.tencent.mm.u.q.b();
        Context mContext;

        b(Context context, MiniJsBridge miniJsBridge) {
            this.mContext = context;
            this.iGz = miniJsBridge;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final com.tencent.mm.u.q.b RT() {
            return this.iHo;
        }
    }

    public f(Context context, MiniJsBridge miniJsBridge, com.tencent.mm.plugin.appbrand.dynamic.h.a aVar) {
        this.iHd = new b(context, miniJsBridge);
        this.iHe = aVar;
        HandlerThread handlerThread = new HandlerThread("MiniJsApiFramework-Thread:" + hashCode());
        handlerThread.start();
        this.iHc = new Handler(handlerThread.getLooper());
    }

    public final String j(String str, String str2, int i) {
        String str3 = "";
        try {
            final b bVar = bg.mA(str) ? null : (b) h.Sc().iHE.get(str);
            if (bVar == null) {
                w.i("MicroMsg.MiniJsApiCore", "JsApiFunc(%s) do not exist.", new Object[]{str});
                return aO(str, "fail:not supported");
            }
            byte b;
            com.tencent.mm.plugin.appbrand.dynamic.h.a aVar = this.iHe;
            int i2 = bVar.index;
            int i3 = com.tencent.mm.plugin.appbrand.dynamic.h.a.iIy;
            if (i3 == -1) {
                w.d("MicroMsg.PermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm on", new Object[]{aVar.id, Integer.valueOf(i2)});
                b = (byte) 1;
            } else if (i3 == -2) {
                w.d("MicroMsg.PermissionFilter", "getCtrlByte, id = %s, ctrlIndex = %d, hard code perm off", new Object[]{aVar.id, Integer.valueOf(i2)});
                b = (byte) 0;
            } else {
                b = i2 == -2 ? (byte) 1 : i2 == -1 ? (byte) 0 : (aVar.iIz == null || i2 < 0 || i2 >= aVar.iIz.length) ? (byte) 0 : aVar.iIz[i2];
            }
            if ((b == (byte) 1 ? 1 : null) == null) {
                w.i("MicroMsg.MiniJsApiCore", "JsApiFunc(%s) no permission.", new Object[]{str});
                return aO(str, "fail:access denied");
            }
            final String aF = com.tencent.mm.plugin.appbrand.l.b.aF(System.nanoTime());
            final boolean oO = com.tencent.mm.plugin.appbrand.dynamic.performance.collector.f.oO(str);
            c.c("jsapi_draw_canvas", aF, "start_jsapi_invoke", oO);
            c.aR(aF, "after_draw_actions");
            if (bVar instanceof d) {
                JSONObject oB = oB(str2);
                if (oB == null) {
                    return aO(str, "fail:invalid data");
                }
                com.tencent.mm.plugin.appbrand.dynamic.core.b.a aVar2 = new a();
                bVar.a(this.iHd, oB, aVar2);
                return aVar2.iHn == null ? "" : aVar2.iHn.toString();
            } else {
                final String str4 = str2;
                final int i4 = i;
                final String str5 = str;
                this.iHc.post(new Runnable(this) {
                    final /* synthetic */ f iHl;

                    public final void run() {
                        c.f(aF, "parse_json_start", oO);
                        JSONObject oB = f.oB(str4);
                        if (oB == null) {
                            this.iHl.iHd.iGz.w(i4, f.aO(str5, "fail:invalid data"));
                            return;
                        }
                        c.f(aF, "parse_json_end", oO);
                        com.tencent.mm.plugin.appbrand.dynamic.performance.collector.f.a(aF, str4, oB);
                        bVar.a(this.iHl.iHd, oB, new com.tencent.mm.plugin.appbrand.dynamic.core.b.a(this) {
                            final /* synthetic */ AnonymousClass1 iHm;

                            {
                                this.iHm = r1;
                            }

                            public final void f(JSONObject jSONObject) {
                                this.iHm.iHl.iHd.iGz.w(i4, jSONObject == null ? "" : jSONObject.toString());
                            }
                        });
                    }
                });
                return str3;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.MiniJsApiCore", "Invoke JsApi error: %s, %s", new Object[]{str, Log.getStackTraceString(e)});
            throw e;
        }
    }

    public static JSONObject oB(String str) {
        try {
            if (bg.mA(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Throwable e) {
            w.e("MicroMsg.MiniJsApiCore", Log.getStackTraceString(e));
            return null;
        }
    }

    static String aO(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }
}
