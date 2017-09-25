package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.w;
import java.net.HttpURLConnection;

public final class h extends e implements a {
    private String lUp = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int lUq = 0;

    public h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.lUp});
    }

    public final void connect() {
        w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.lUp});
        final String str = this.lUp;
        j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ h lUr;

            public final void run() {
                w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.y(this.lUr.intent), Integer.valueOf(m.z(this.lUr.intent)), str});
                a.awi();
                a.a(str, new a.a(this) {
                    final /* synthetic */ AnonymousClass1 lUs;

                    {
                        this.lUs = r1;
                    }

                    public final void d(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.y(this.lUs.lUr.intent), Integer.valueOf(m.z(this.lUs.lUr.intent)), Integer.valueOf(responseCode)});
                        if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                            this.lUs.lUr.W(0, "");
                            m.a(this.lUs.lUr.intent, this.lUs.lUr.fEN, this.lUs.lUr.lUf, this.lUs.lUr.fuV, this.lUs.lUr.lUd, "MicroMsg.FreeWifi.ProtocolThreeOne");
                        } else if (responseCode == 302) {
                            this.lUs.lUr.wL(httpURLConnection.getHeaderField("Location"));
                        } else {
                            w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lUs.lUr.intent), Integer.valueOf(m.z(this.lUs.lUr.intent))});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUs.lUr.lUd;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.lWh = m.a(this.lUs.lUr.lUf, b.ThreeOneAuth, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.lUs.lUr.W(32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[]{m.y(this.lUs.lUr.intent), Integer.valueOf(m.z(this.lUs.lUr.intent)), exception.getMessage(), m.f(exception)});
                        FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUs.lUr.lUd;
                        d dVar = d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.lWh = m.a(this.lUs.lUr.lUf, b.ThreeOneAuth, m.g(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        this.lUs.lUr.W(m.g(exception), m.e(exception));
                    }
                });
            }
        });
    }

    public final void wL(String str) {
        this.lUq++;
        if (this.lUq > 3) {
            w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUd;
            d dVar = d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.lWh = m.a(this.lUf, b.ThreeOneAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            W(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), str});
        if (m.wx(str)) {
            freeWifiFrontPageUI = this.lUd;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.lWh = m.a(this.lUf, b.ThreeOneAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            W(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        a.a anonymousClass2 = new a.a(this) {
            final /* synthetic */ h lUr;

            {
                this.lUr = r1;
            }

            public final void d(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.y(this.lUr.intent), Integer.valueOf(m.z(this.lUr.intent)), Integer.valueOf(responseCode)});
                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                    this.lUr.W(0, "");
                    m.a(this.lUr.intent, this.lUr.fEN, this.lUr.lUf, this.lUr.fuV, this.lUr.lUd, "MicroMsg.FreeWifi.ProtocolThreeOne");
                } else if (responseCode == 302) {
                    this.lUr.wL(httpURLConnection.getHeaderField("Location"));
                } else {
                    w.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.y(this.lUr.intent), Integer.valueOf(m.z(this.lUr.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUr.lUd;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.lWh = m.a(this.lUr.lUf, b.ThreeOneAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    this.lUr.W(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                w.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.y(this.lUr.intent), Integer.valueOf(m.z(this.lUr.intent)), exception.getMessage(), m.f(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUr.lUd;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.lWh = m.a(this.lUr.lUf, b.ThreeOneAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                this.lUr.W(m.g(exception), m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            a.awi();
            a.a(str, parse.getEncodedQuery(), anonymousClass2);
            return;
        }
        a.awi();
        a.a(str, anonymousClass2);
    }

    public final void W(int i, String str) {
        k.a avZ = k.avZ();
        avZ.ssid = this.ssid;
        avZ.bssid = m.wB("MicroMsg.FreeWifi.ProtocolThreeOne");
        avZ.fEO = m.wC("MicroMsg.FreeWifi.ProtocolThreeOne");
        avZ.fEN = this.fEN;
        avZ.lRz = this.appId;
        avZ.lRA = m.y(this.intent);
        avZ.lRB = 31;
        avZ.lRC = b.ThreeOneAuth.lSn;
        avZ.lRD = b.ThreeOneAuth.name;
        avZ.result = i;
        avZ.ksO = str;
        avZ.fRr = m.B(this.intent);
        avZ.awb().b(this.intent, i != 0).awa();
    }
}
