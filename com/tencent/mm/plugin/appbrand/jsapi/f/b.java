package com.tencent.mm.plugin.appbrand.jsapi.f;

import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.f.i;
import com.tencent.mm.plugin.appbrand.f.j;
import com.tencent.mm.plugin.appbrand.f.j.AnonymousClass3;
import com.tencent.mm.plugin.appbrand.f.k;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.n.b.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class b extends a {
    public static final int CTRL_INDEX = 20;
    public static final String NAME = "connectSocket";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        final com.tencent.mm.plugin.appbrand.a mV = com.tencent.mm.plugin.appbrand.a.mV(mVar.ivH);
        com.tencent.mm.plugin.appbrand.a.Pm();
        j qd = a.jbC.qd(mVar.ivH);
        if (qd != null) {
            if (qd.jbw != null ? qd.jbw.joY.isOpen() : false) {
                w.i("MicroMsg.JsApiConnectSocket", "the already appid has a websocket");
                Map hashMap = new HashMap();
                hashMap.put("message", "websocket is connected");
                mVar.x(i, d("fail", hashMap));
                return;
            }
        }
        if (qd != null) {
            a.jbC.qe(mVar.ivH);
        }
        final j jVar = new j(mVar.ivH);
        final com.tencent.mm.plugin.appbrand.a.b.a anonymousClass1 = new com.tencent.mm.plugin.appbrand.a.b.a(this) {
            final /* synthetic */ b iTE;

            public final void a(com.tencent.mm.plugin.appbrand.a.a aVar) {
                if (aVar == com.tencent.mm.plugin.appbrand.a.a.SUSPEND || aVar == com.tencent.mm.plugin.appbrand.a.a.DESTROYED) {
                    jVar.Vq();
                }
            }
        };
        final m mVar2 = mVar;
        final int i2 = i;
        j.a anonymousClass2 = new j.a(this) {
            final /* synthetic */ b iTE;

            public final void TQ() {
                k kVar = a.jbC;
                String str = mVar2.ivH;
                j jVar = jVar;
                if (!kVar.jaX.containsKey(str)) {
                    kVar.jaX.put(str, jVar);
                }
                mVar2.ixr.iwC.a(anonymousClass1);
                mVar2.f("onSocketOpen", null, 0);
            }

            public final void pu(String str) {
                Map hashMap = new HashMap();
                hashMap.put("message", str);
                mVar2.f("onSocketError", new JSONObject(hashMap).toString(), 0);
            }

            public final void pv(String str) {
                Map hashMap = new HashMap();
                hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                mVar2.f("onSocketMessage", new JSONObject(hashMap).toString(), 0);
            }

            public final void a(ByteBuffer byteBuffer) {
                Map hashMap = new HashMap();
                try {
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, new String(Base64.encode(byteBuffer.array(), 2), ProtocolPackage.ServerEncoding));
                    hashMap.put("isBuffer", Boolean.valueOf(true));
                    mVar2.f("onSocketMessage", new JSONObject(hashMap).toString(), 0);
                } catch (UnsupportedEncodingException e) {
                    w.e("MicroMsg.JsApiConnectSocket", "create string by buffer error. exception : %s", new Object[]{e});
                }
            }

            public final void z(int i, String str) {
                a.jbC.qe(mVar2.ivH);
                com.tencent.mm.plugin.appbrand.a.b bVar = mVar2.ixr.iwC;
                com.tencent.mm.plugin.appbrand.a.b.a aVar = anonymousClass1;
                if (!(aVar == null || com.tencent.mm.plugin.appbrand.a.a.DESTROYED == bVar.iAk.QD())) {
                    synchronized (bVar.iAl) {
                        bVar.iAl.remove(aVar);
                    }
                }
                Map hashMap = new HashMap();
                if (mV.Pn()) {
                    hashMap.put("message", "interrupted");
                } else if (!bg.mA(str)) {
                    hashMap.put("message", str);
                }
                hashMap.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, Integer.valueOf(i));
                mVar2.f("onSocketClose", new JSONObject(hashMap).toString(), 0);
            }

            public final void pw(String str) {
                if (bg.mA(str)) {
                    mVar2.x(i2, this.iTE.d("fail", null));
                } else {
                    mVar2.x(i2, this.iTE.d("fail:" + str, null));
                }
            }

            public final void TR() {
                mVar2.x(i2, this.iTE.d("ok", null));
            }
        };
        com.tencent.mm.plugin.appbrand.config.a aVar = mVar.ixr.iwp;
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bg.mA(optString)) {
            w.i("MicroMsg.JsApiConnectSocket", "url is null");
            mVar.x(i, d("fail", null));
            return;
        }
        w.i("MicroMsg.JsApiConnectSocket", "url is " + optString);
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        Map a = i.a(jSONObject, mY);
        if (!i.c(mY) || i.b(mY.iFe, optString)) {
            int a2 = i.a(mY, aVar, 1);
            if (a2 <= 0) {
                a2 = 60000;
            }
            w.i("MicroMsg.JsApiConnectSocket", "send request ok, url is : %s ,appid: %s", new Object[]{optString, mY.appId});
            String optString2 = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            try {
                URI uri = new URI(optString2);
                w.i("MicroMsg.AppBrandNetworkWebSocket", "connectSocket, url= %s, timeout = %d", new Object[]{optString2, Integer.valueOf(a2)});
                a.put("User-Agent", s.aZ(ab.getContext(), ""));
                String o = j.o(jSONObject);
                if (!bg.mA(o)) {
                    w.i("MicroMsg.AppBrandNetworkWebSocket", "protocols %s", new Object[]{o});
                    a.put("Sec-WebSocket-Protocol", o);
                }
                o = j.a(uri);
                if (!bg.mA(o)) {
                    w.i("MicroMsg.AppBrandNetworkWebSocket", "Origin %s", new Object[]{o});
                    a.put("Origin", o);
                }
                try {
                    jVar.jbw = new com.tencent.mm.plugin.appbrand.f.j.AnonymousClass1(jVar, uri, new d(), a, a2, optString2, anonymousClass2);
                    aj ajVar;
                    long j;
                    if (s.eq(optString2, "ws://")) {
                        w.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user ws connect", new Object[]{optString2});
                        jVar.jbw.a(new Socket(Proxy.NO_PROXY));
                        jVar.jbw.connect();
                        anonymousClass2.TR();
                        j.KH();
                        ajVar = new aj(new com.tencent.mm.plugin.appbrand.f.j.AnonymousClass2(jVar, anonymousClass2), false);
                        j.jby = ajVar;
                        j = (long) a2;
                        ajVar.v(j, j);
                        return;
                    } else if (s.eq(optString2, "wss://")) {
                        w.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,user wss connect", new Object[]{optString2});
                        jVar.jbw.a((jVar.jbx != null ? jVar.jbx : (SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket());
                        jVar.jbw.connect();
                        anonymousClass2.TR();
                        j.KH();
                        ajVar = new aj(new AnonymousClass3(jVar, anonymousClass2), false);
                        j.jby = ajVar;
                        j = (long) a2;
                        ajVar.v(j, j);
                        return;
                    } else {
                        w.i("MicroMsg.AppBrandNetworkWebSocket", "url error: %s not ws:// or wss://", new Object[]{optString2});
                        anonymousClass2.pw("url not ws or wss");
                        return;
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandNetworkWebSocket", "url %s exception %s", new Object[]{optString2, e.toString()});
                    anonymousClass2.pu("");
                    return;
                }
            } catch (Exception e2) {
                w.e("MicroMsg.AppBrandNetworkWebSocket", "connect fail : %s ", new Object[]{e2.toString()});
                anonymousClass2.pw("url not well format");
                return;
            }
        }
        mVar.x(i, d("fail:url not in domain list", null));
        w.i("MicroMsg.JsApiConnectSocket", "not in domain url %s", new Object[]{optString});
    }
}
