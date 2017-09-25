package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.f.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.n.a.b;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class k extends a {
    public static final int CTRL_INDEX = 22;
    public static final String NAME = "sendSocketMessage";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        j qd = a.jbC.qd(mVar.ivH);
        if (qd != null) {
            String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA);
            if (optString != null) {
                try {
                    c cVar;
                    if (jSONObject.optBoolean("isBuffer")) {
                        ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(optString.getBytes(ProtocolPackage.ServerEncoding), 2));
                        cVar = qd.jbw.joY;
                        if (wrap == null) {
                            w.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
                        } else {
                            cVar.d(cVar.joO.a(wrap, cVar.joP == b.joB));
                        }
                        mVar.x(i, d("ok", null));
                        return;
                    }
                    cVar = qd.jbw.joY;
                    if (optString == null) {
                        w.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "Cannot send 'null' data to a WebSocketImpl.");
                    } else {
                        cVar.d(cVar.joO.M(optString, cVar.joP == b.joB));
                    }
                    mVar.x(i, d("ok", null));
                    return;
                } catch (Exception e) {
                    w.e("MicroMsg.JsApiSendSocketMessage", "sendSocketMessage error : %s", new Object[]{e});
                    mVar.x(i, d("fail", null));
                }
            } else {
                mVar.x(i, d("fail", null));
                return;
            }
        }
        mVar.x(i, d("fail", null));
    }
}
