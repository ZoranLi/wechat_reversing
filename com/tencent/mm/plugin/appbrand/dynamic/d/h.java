package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.modelappbrand.p;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class h extends com.tencent.mm.plugin.appbrand.dynamic.core.a {

    private static class a implements g<com.tencent.mm.plugin.appbrand.dynamic.widget.a.a, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final com.tencent.mm.ipcinvoker.h hVar) {
            com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar = (com.tencent.mm.plugin.appbrand.dynamic.widget.a.a) obj;
            final Bundle bundle = new Bundle();
            View oz = e.RQ().oz(aVar.id);
            if (oz instanceof com.tencent.mm.plugin.appbrand.dynamic.g) {
                ((com.tencent.mm.plugin.appbrand.dynamic.g) oz).b(aVar.height, new p(this) {
                    final /* synthetic */ a iHW;

                    public final void a(boolean z, String str, Bundle bundle) {
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle(SlookAirButtonFrequentContactAdapter.DATA, bundle);
                        hVar.ak(bundle);
                    }
                });
                return;
            }
            w.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "drawCanvas failed, view is not a instance of DynamicPageAccessible.(%s)", new Object[]{aVar.id});
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            hVar.ak(bundle);
        }
    }

    public h() {
        super("setWidgetSize", 289);
    }

    protected final void b(com.tencent.mm.plugin.appbrand.dynamic.core.e eVar, JSONObject jSONObject, final com.tencent.mm.plugin.appbrand.dynamic.core.b.a aVar) {
        b RT = eVar.RT();
        com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar2 = new com.tencent.mm.plugin.appbrand.dynamic.widget.a.a();
        aVar2.id = RT.getString("__page_view_id", "");
        aVar2.width = jSONObject.optInt("width", RT.getInt("__page_view_width", 0));
        aVar2.height = jSONObject.optInt("height", RT.getInt("__page_view_height", 0));
        XIPCInvoker.a(RT.getString("__process_name", ab.um()), aVar2, a.class, new com.tencent.mm.ipcinvoker.h<Bundle>(this) {
            final /* synthetic */ h iHU;

            public final /* synthetic */ void ak(Object obj) {
                boolean z;
                Bundle bundle;
                Object obj2 = null;
                Bundle bundle2 = (Bundle) obj;
                if (bundle2 != null) {
                    z = bundle2.getBoolean("ret");
                    obj2 = bundle2.getString("reason");
                    bundle = bundle2.getBundle(SlookAirButtonFrequentContactAdapter.DATA);
                } else {
                    z = false;
                    bundle = null;
                }
                com.tencent.mm.plugin.appbrand.dynamic.core.b.a aVar = aVar;
                com.tencent.mm.plugin.appbrand.dynamic.core.b bVar = this.iHU;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bVar.name);
                stringBuilder.append(":");
                stringBuilder.append(z ? "ok" : "fail");
                if (!TextUtils.isEmpty(obj2)) {
                    stringBuilder.append(":");
                    stringBuilder.append(bg.mz(obj2));
                }
                Map hashMap = new HashMap();
                hashMap.put("errMsg", stringBuilder.toString());
                if (bundle != null) {
                    Set<String> keySet = bundle.keySet();
                    if (!(keySet == null || keySet.isEmpty())) {
                        for (String str : keySet) {
                            hashMap.put(str, bundle.get(str));
                        }
                    }
                }
                d.r(hashMap);
                aVar.f(new JSONObject(hashMap));
            }
        });
    }
}
