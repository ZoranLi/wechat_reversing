package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsBridge;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Collection;

public final class f {
    private static com.tencent.mm.network.m.a iGL = new com.tencent.mm.network.m.a() {
        public final void cU(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt(DownloadInfo.STATUS, i);
            e.a("com.tencent.mm:support", bundle, a.class, null);
        }
    };

    private static final class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, c cVar) {
            Collection<c> values = d.RP().iGI.values();
            if (values != null && !values.isEmpty()) {
                com.tencent.mm.plugin.appbrand.dynamic.core.c cVar2 = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
                CharSequence charSequence = cVar2.name;
                String jSONObject = cVar2.nQ().toString();
                for (c cVar3 : values) {
                    if (!(cVar3 == null || cVar3.iGz == null || TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(jSONObject))) {
                        MiniJsBridge miniJsBridge = cVar3.iGz;
                        String str = bg.mA(jSONObject) ? "{}" : jSONObject;
                        w.d("MicroMsg.MiniJsBridge", "dispatch, event: %s, data size: %s, srcId: %d, id : %s", new Object[]{charSequence, Integer.valueOf(str.length()), Integer.valueOf(0), miniJsBridge.iDc});
                        miniJsBridge.ixt.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{charSequence, str, "undefined", MiniJsBridge.Sd()}), null);
                    }
                }
            }
        }
    }

    public static void initialize() {
        if (ab.bJb()) {
            h.vJ();
            h.vH().a(iGL);
        }
    }

    public static void release() {
        h.vJ();
        h.vH().b(iGL);
    }
}
