package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";
    public static final AtomicReference<String> iUm = new AtomicReference();

    private static final class a implements i<IPCVoid, IPCString> {
        private a() {
        }

        public final /* synthetic */ Object al(Object obj) {
            String str = h.vI().gYf + "address";
            return e.aO(str) ? new IPCString(str) : new IPCString("");
        }
    }

    public final void a(m mVar, JSONObject jSONObject, final int i) {
        final WeakReference weakReference = new WeakReference(mVar);
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ b iUn;

            public final void run() {
                String str;
                Object aT;
                String str2 = null;
                String str3 = (String) b.iUm.get();
                if (bg.mA(str3)) {
                    if (ab.bJf()) {
                        try {
                            str = ((IPCString) XIPCInvoker.a("com.tencent.mm", IPCVoid.gWv, a.class)).value;
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e, "query updated address path", new Object[0]);
                            str = str2;
                        }
                    } else {
                        str = "";
                    }
                    if (bg.mA(str)) {
                        str2 = str3;
                    } else {
                        try {
                            aT = e.aT(str);
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e2, "read address from file %s", new Object[]{str});
                        }
                    }
                    if (bg.mA(aT)) {
                        try {
                            aT = bg.convertStreamToString(ab.getContext().getAssets().open("address"));
                        } catch (Throwable e22) {
                            w.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e22, "read address from assets", new Object[0]);
                        }
                    }
                    if (!bg.mA(aT)) {
                        b.iUm.set(aT);
                    }
                } else {
                    str2 = str3;
                }
                m mVar = (m) weakReference.get();
                if (mVar != null && mVar.aaI) {
                    Map hashMap = new HashMap(1);
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, aT);
                    mVar.x(i, this.iUn.d("ok", hashMap));
                }
            }
        }, "AppBrandJsApiGetRegionData");
    }
}
