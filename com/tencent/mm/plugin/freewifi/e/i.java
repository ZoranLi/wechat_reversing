package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import java.net.HttpURLConnection;

public final class i extends e implements a {
    private int lUq;
    protected String lUt;
    protected String lUu;
    protected String lUv;
    protected String lUw;
    private Uri lUx;
    private String lUy;
    protected String sign;

    public i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        this.lUq = 0;
        this.lUy = this.intent.getStringExtra("free_wifi_schema_uri");
        this.lUx = Uri.parse(this.lUy);
        this.appId = this.lUx.getQueryParameter("appId");
        this.lUt = this.lUx.getQueryParameter("shopId");
        this.lUu = this.lUx.getQueryParameter("authUrl");
        this.lUv = this.lUx.getQueryParameter("extend");
        this.lUw = this.lUx.getQueryParameter("timestamp");
        this.sign = this.lUx.getQueryParameter("sign");
        w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.lUx, this.appId, this.lUt, this.lUu, this.lUv, this.lUw, this.sign});
    }

    public final void connect() {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (m.wx(this.ssid)) {
            w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent))});
            freeWifiFrontPageUI = this.lUd;
            dVar = d.FAIL;
            aVar = new a();
            aVar.lWh = m.a(this.lUf, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else if (m.wx(this.lUu)) {
            w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent))});
            freeWifiFrontPageUI = this.lUd;
            dVar = d.FAIL;
            aVar = new a();
            aVar.lWh = m.a(this.lUf, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else {
            StringBuilder stringBuilder = new StringBuilder(this.lUu);
            if (this.lUu.indexOf("?") == -1) {
                stringBuilder.append("?extend=").append(this.lUv);
            } else {
                stringBuilder.append("&extend=").append(this.lUv);
            }
            final String stringBuilder2 = stringBuilder.toString();
            j.awF().awp().post(new Runnable(this) {
                final /* synthetic */ i lUz;

                public final void run() {
                    w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.y(this.lUz.intent), Integer.valueOf(m.z(this.lUz.intent)), stringBuilder2});
                    com.tencent.mm.plugin.freewifi.a.a.awi();
                    com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 lUA;

                        {
                            this.lUA = r1;
                        }

                        public final void d(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.y(this.lUA.lUz.intent), Integer.valueOf(m.z(this.lUA.lUz.intent)), Integer.valueOf(responseCode)});
                            if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                                this.lUA.lUz.axc();
                            } else if (responseCode == 302) {
                                this.lUA.lUz.wL(httpURLConnection.getHeaderField("Location"));
                            } else {
                                w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lUA.lUz.intent), Integer.valueOf(m.z(this.lUA.lUz.intent))});
                                FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUA.lUz.lUd;
                                d dVar = d.FAIL;
                                a aVar = new a();
                                aVar.lWh = m.a(this.lUA.lUz.lUf, b.ThreeThreeAuth, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                            }
                        }

                        public final void h(Exception exception) {
                            w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.y(this.lUA.lUz.intent), Integer.valueOf(m.z(this.lUA.lUz.intent)), exception.getMessage(), m.f(exception)});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUA.lUz.lUd;
                            d dVar = d.FAIL;
                            a aVar = new a();
                            aVar.lWh = m.a(this.lUA.lUz.lUf, b.ThreeThreeAuth, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                        }
                    });
                }
            });
        }
    }

    public final void wL(String str) {
        this.lUq++;
        if (this.lUq > 3) {
            w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUd;
            d dVar = d.FAIL;
            a aVar = new a();
            aVar.lWh = m.a(this.lUf, b.ThreeThreeAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), str});
        if (m.wx(str)) {
            freeWifiFrontPageUI = this.lUd;
            dVar = d.FAIL;
            aVar = new a();
            aVar.lWh = m.a(this.lUf, b.ThreeThreeAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass2 = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
            final /* synthetic */ i lUz;

            {
                this.lUz = r1;
            }

            public final void d(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.y(this.lUz.intent), Integer.valueOf(m.z(this.lUz.intent)), Integer.valueOf(responseCode)});
                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                    this.lUz.axc();
                } else if (responseCode == 302) {
                    this.lUz.wL(httpURLConnection.getHeaderField("Location"));
                } else {
                    w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.y(this.lUz.intent), Integer.valueOf(m.z(this.lUz.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUz.lUd;
                    d dVar = d.FAIL;
                    a aVar = new a();
                    aVar.lWh = m.a(this.lUz.lUf, b.ThreeThreeAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                }
            }

            public final void h(Exception exception) {
                w.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.y(this.lUz.intent), Integer.valueOf(m.z(this.lUz.intent)), exception.getMessage(), m.f(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUz.lUd;
                d dVar = d.FAIL;
                a aVar = new a();
                aVar.lWh = m.a(this.lUz.lUf, b.ThreeThreeAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.awi();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass2);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.awi();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass2);
    }

    protected final void axc() {
        j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ i lUz;

            {
                this.lUz = r1;
            }

            public final void run() {
                k.a avZ = k.avZ();
                avZ.ssid = this.lUz.ssid;
                avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol33");
                avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol33");
                avZ.fEN = this.lUz.fEN;
                avZ.lRA = m.y(this.lUz.intent);
                avZ.lRB = this.lUz.lUf;
                avZ.lRC = b.GetBackPage33.lSn;
                avZ.lRD = b.GetBackPage33.name;
                avZ.fRr = m.B(this.lUz.intent);
                avZ.result = 0;
                avZ.awb().awa();
                String awr = com.tencent.mm.plugin.freewifi.model.d.awr();
                String awt = com.tencent.mm.plugin.freewifi.model.d.awt();
                int aws = com.tencent.mm.plugin.freewifi.model.d.aws();
                w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.y(this.lUz.intent), Integer.valueOf(m.z(this.lUz.intent)), "", awr, awt, Integer.valueOf(aws)});
                new f(this.lUz.ssid, m.wB("MicroMsg.FreeWifi.Protocol33"), this.lUz.appId, this.lUz.lUt, this.lUz.lUu, this.lUz.lUv, this.lUz.lUw, this.lUz.sign).b(new e(this) {
                    final /* synthetic */ AnonymousClass3 lUB;

                    {
                        this.lUB = r1;
                    }

                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                        w.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.y(this.lUB.lUz.intent), Integer.valueOf(m.z(this.lUB.lUz.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
                        k.a avZ = k.avZ();
                        avZ.ssid = this.lUB.lUz.ssid;
                        avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol33");
                        avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol33");
                        avZ.fEN = this.lUB.lUz.fEN;
                        avZ.lRA = m.y(this.lUB.lUz.intent);
                        avZ.lRB = m.A(this.lUB.lUz.intent);
                        avZ.lRC = b.GetBackPage33Return.lSn;
                        avZ.lRD = b.GetBackPage33Return.name;
                        avZ.fRr = m.B(this.lUB.lUz.intent);
                        avZ.result = i2;
                        avZ.ksO = str;
                        avZ.awb().awa();
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        a aVar;
                        if (i == 0 && i2 == 0) {
                            dy awQ = ((f) kVar).awQ();
                            if (awQ != null) {
                                w.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG, awQ.thM});
                                FreeWifiFrontPageUI freeWifiFrontPageUI2 = this.lUB.lUz.lUd;
                                d dVar2 = d.SUCCESS;
                                FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                                bVar.lWF = awQ;
                                freeWifiFrontPageUI2.a(dVar2, bVar);
                                return;
                            }
                            freeWifiFrontPageUI = this.lUB.lUz.lUd;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.lWh = m.a(this.lUB.lUz.lUf, b.GetBackPage33Return, 20);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        } else if (i2 == -30032) {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", this.lUB.lUz.lUd.getString(R.l.emp));
                            intent.setClass(this.lUB.lUz.lUd, FreeWifiErrorUI.class);
                            this.lUB.lUz.lUd.finish();
                            this.lUB.lUz.lUd.startActivity(intent);
                        } else {
                            freeWifiFrontPageUI = this.lUB.lUz.lUd;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.lWg = R.l.emm;
                            aVar.lWh = m.a(this.lUB.lUz.lUf, b.GetBackPage33Return, i2);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        }
                    }
                });
            }
        });
    }
}
