package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.w;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j extends e implements a {
    public String lUC = this.intent.getStringExtra("free_wifi_tid");
    private a lUk;
    private int lUq = 0;
    public String lUw = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    public String openId = this.intent.getStringExtra("free_wifi_openid");
    public String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ j lUD;
        final /* synthetic */ String val$url;

        AnonymousClass3(j jVar, String str) {
            this.lUD = jVar;
            this.val$url = str;
        }

        public final void run() {
            w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.y(this.lUD.intent), Integer.valueOf(m.z(this.lUD.intent)), this.val$url});
            com.tencent.mm.plugin.freewifi.a.a.awi();
            com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                final /* synthetic */ AnonymousClass3 lUL;

                {
                    this.lUL = r1;
                }

                public final void d(HttpURLConnection httpURLConnection) {
                    int responseCode = httpURLConnection.getResponseCode();
                    w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.y(this.lUL.lUD.intent), Integer.valueOf(m.z(this.lUL.lUD.intent)), Integer.valueOf(responseCode)});
                    if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                        this.lUL.lUD.Y(0, "");
                        m.a(this.lUL.lUD.intent, this.lUL.lUD.fEN, this.lUL.lUD.lUf, this.lUL.lUD.fuV, this.lUL.lUD.lUd, "MicroMsg.FreeWifi.Protocol32");
                    } else if (responseCode == 302) {
                        this.lUL.lUD.wL(httpURLConnection.getHeaderField("Location"));
                    } else {
                        w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.y(this.lUL.lUD.intent), Integer.valueOf(m.z(this.lUL.lUD.intent))});
                        FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUL.lUD.lUd;
                        d dVar = d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.lWh = m.a(this.lUL.lUD.lUf, b.ThreeTwoAuth, 32);
                        freeWifiFrontPageUI.a(dVar, aVar);
                        this.lUL.lUD.Y(32, "INVALID_HTTP_RESP_CODE");
                    }
                }

                public final void h(Exception exception) {
                    w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.y(this.lUL.lUD.intent), Integer.valueOf(m.z(this.lUL.lUD.intent)), exception.getMessage(), m.f(exception)});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUL.lUD.lUd;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.lWh = m.a(this.lUL.lUD.lUf, b.ThreeTwoAuth, m.g(exception));
                    freeWifiFrontPageUI.a(dVar, aVar);
                    this.lUL.lUD.Y(m.g(exception), m.e(exception));
                }
            });
        }
    }

    public j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.openId, this.lUC, this.lUw, this.sign});
    }

    public final void connect() {
        this.lUk = new a(this.ssid, this.lUd);
        com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ j lUD;

            {
                this.lUD = r1;
            }

            public final void run() {
                this.lUD.awZ();
            }
        });
    }

    public final void awZ() {
        w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.ssid});
        this.lUk.a(new a.a(this) {
            final /* synthetic */ j lUD;

            {
                this.lUD = r1;
            }

            public final void onSuccess() {
                k.a avZ = k.avZ();
                avZ.ssid = this.lUD.ssid;
                avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol32");
                avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol32");
                avZ.fEN = this.lUD.fEN;
                avZ.lRz = this.lUD.appId;
                avZ.lRA = m.y(this.lUD.intent);
                avZ.lRB = m.A(this.lUD.intent);
                avZ.lRC = b.AddNetwork.lSn;
                avZ.lRD = b.AddNetwork.name;
                avZ.result = 0;
                avZ.fRr = m.B(this.lUD.intent);
                avZ.awb().awa();
                final String avY = b.lRu.avY();
                w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.y(this.lUD.intent), Integer.valueOf(m.z(this.lUD.intent)), this.lUD.ssid, avY});
                com.tencent.mm.plugin.freewifi.a.a.a anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                    int lUE = 0;
                    private final int lUF = 3;
                    private int lUG = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a lUH = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 lUK;

                        {
                            this.lUK = r1;
                        }

                        public final void d(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            FreeWifiFrontPageUI freeWifiFrontPageUI;
                            d dVar;
                            FreeWifiFrontPageUI.a aVar;
                            if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                                w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.y(this.lUK.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUK.lUJ.lUD.intent))});
                                freeWifiFrontPageUI = this.lUK.lUJ.lUD.lUd;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.lWh = m.a(this.lUK.lUJ.lUD.lUf, b.ThreeTwoBlack, 35);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                this.lUK.lUJ.lUD.Y(35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            } else if (responseCode == 302) {
                                this.lUK.wM(httpURLConnection.getHeaderField("Location"));
                            } else {
                                w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lUK.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUK.lUJ.lUD.intent))});
                                freeWifiFrontPageUI = this.lUK.lUJ.lUD.lUd;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.lWh = m.a(this.lUK.lUJ.lUD.lUf, b.ThreeTwoBlack, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                this.lUK.lUJ.lUD.Y(32, "INVALID_HTTP_RESP_CODE");
                            }
                        }

                        public final void h(Exception exception) {
                            w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", new Object[]{m.y(this.lUK.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUK.lUJ.lUD.intent)), exception.getMessage(), m.f(exception)});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUK.lUJ.lUD.lUd;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.lWh = m.a(this.lUK.lUJ.lUD.lUf, b.ThreeTwoBlack, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.lUK.lUJ.lUD.Y(m.g(exception), m.e(exception));
                        }
                    };
                    final /* synthetic */ AnonymousClass2 lUJ;

                    public final void d(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                            w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[]{m.y(this.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUJ.lUD.intent))});
                            this.lUJ.lUD.Y(0, "");
                            m.a(this.lUJ.lUD.intent, this.lUJ.lUD.fEN, this.lUJ.lUD.lUf, this.lUJ.lUD.fuV, this.lUJ.lUD.lUd, "MicroMsg.FreeWifi.Protocol32");
                        } else if (responseCode == 302) {
                            wM(httpURLConnection.getHeaderField("Location"));
                        } else {
                            w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUJ.lUD.intent))});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUJ.lUD.lUd;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.lWh = m.a(this.lUJ.lUD.lUf, b.ThreeTwoBlack, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.lUJ.lUD.X(32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        FreeWifiFrontPageUI.a aVar;
                        w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.y(this.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUJ.lUD.intent)), exception.getMessage(), m.f(exception)});
                        if (exception instanceof UnknownHostException) {
                            this.lUJ.lUD.X(102, m.e(exception));
                            w.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.lUE);
                            int i = this.lUE + 1;
                            this.lUE = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.awi();
                                    com.tencent.mm.plugin.freewifi.a.a.a(avY, this);
                                    return;
                                } catch (InterruptedException e) {
                                    w.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", new Object[]{m.f(exception)});
                                    this.lUJ.lUD.X(103, m.e(exception));
                                    freeWifiFrontPageUI = this.lUJ.lUD.lUd;
                                    dVar = d.FAIL;
                                    aVar = new FreeWifiFrontPageUI.a();
                                    aVar.lWh = m.a(this.lUJ.lUD.lUf, b.ThreeTwoBlack, 103);
                                    freeWifiFrontPageUI.a(dVar, aVar);
                                    return;
                                }
                            }
                            freeWifiFrontPageUI = this.lUJ.lUD.lUd;
                            dVar = d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.lWh = m.a(this.lUJ.lUD.lUf, b.ThreeTwoBlack, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.lUJ.lUD.X(m.g(exception), m.e(exception));
                            return;
                        }
                        freeWifiFrontPageUI = this.lUJ.lUD.lUd;
                        dVar = d.FAIL;
                        aVar = new FreeWifiFrontPageUI.a();
                        aVar.lWh = m.a(this.lUJ.lUD.lUf, b.ThreeTwoBlack, m.g(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        this.lUJ.lUD.X(m.g(exception), m.e(exception));
                    }

                    public final void wM(String str) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String wz = m.wz(parse.getQueryParameter("extend"));
                        w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[]{m.y(this.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUJ.lUD.intent)), str, queryParameter, wz});
                        if (m.wx(queryParameter)) {
                            this.lUG++;
                            if (this.lUG < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.awi();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.lUH);
                                return;
                            }
                            w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(this.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUJ.lUD.intent))});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUJ.lUD.lUd;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.lWh = m.a(this.lUJ.lUD.lUf, b.ThreeTwoBlack, 36);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.lUJ.lUD.Y(36, "BLACK_302_TIMES_EXCESS");
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(wz);
                        } else {
                            stringBuilder.append("?extend=").append(wz);
                        }
                        stringBuilder.append("&openId=").append(m.wz(this.lUJ.lUD.openId)).append("&tid=").append(m.wz(this.lUJ.lUD.lUC)).append("&timestamp=").append(this.lUJ.lUD.lUw).append("&sign=").append(this.lUJ.lUD.sign);
                        com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new AnonymousClass3(this.lUJ.lUD, stringBuilder.toString()));
                        w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", new Object[]{m.y(this.lUJ.lUD.intent), Integer.valueOf(m.z(this.lUJ.lUD.intent)), stringBuilder.toString()});
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.awi();
                com.tencent.mm.plugin.freewifi.a.a.a(avY, anonymousClass1);
            }

            public final void mF(int i) {
                w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.y(this.lUD.intent), Integer.valueOf(m.z(this.lUD.intent)), this.lUD.ssid, Integer.valueOf(i)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUD.lUd;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.lWh = m.a(this.lUD.lUf, b.AddNetwork, i);
                freeWifiFrontPageUI.a(dVar, aVar);
                k.a avZ = k.avZ();
                avZ.ssid = this.lUD.ssid;
                avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol32");
                avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol32");
                avZ.fEN = this.lUD.fEN;
                avZ.lRz = this.lUD.appId;
                avZ.lRA = m.y(this.lUD.intent);
                avZ.lRB = m.A(this.lUD.intent);
                avZ.lRD = b.AddNetwork.name;
                avZ.lRC = b.AddNetwork.lSn;
                avZ.result = i;
                avZ.fRr = m.B(this.lUD.intent);
                avZ.awb().awa();
            }
        });
    }

    public final void wL(String str) {
        this.lUq++;
        if (this.lUq > 3) {
            w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUd;
            d dVar = d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.lWh = m.a(this.lUf, b.ThreeTwoAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            Y(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), str});
        if (m.wx(str)) {
            freeWifiFrontPageUI = this.lUd;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.lWh = m.a(this.lUf, b.ThreeTwoAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            Y(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass4 = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
            final /* synthetic */ j lUD;

            {
                this.lUD = r1;
            }

            public final void d(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.y(this.lUD.intent), Integer.valueOf(m.z(this.lUD.intent)), Integer.valueOf(responseCode)});
                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                    this.lUD.Y(0, "");
                    m.a(this.lUD.intent, this.lUD.fEN, this.lUD.lUf, this.lUD.fuV, this.lUD.lUd, "MicroMsg.FreeWifi.Protocol32");
                } else if (responseCode == 302) {
                    this.lUD.wL(httpURLConnection.getHeaderField("Location"));
                } else {
                    w.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.y(this.lUD.intent), Integer.valueOf(m.z(this.lUD.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUD.lUd;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.lWh = m.a(this.lUD.lUf, b.ThreeTwoAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    this.lUD.Y(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                w.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.y(this.lUD.intent), Integer.valueOf(m.z(this.lUD.intent)), exception.getMessage(), m.f(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.lUD.lUd;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.lWh = m.a(this.lUD.lUf, b.ThreeTwoAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                this.lUD.Y(m.g(exception), m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.awi();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass4);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.awi();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass4);
    }

    public final void X(int i, String str) {
        k.a avZ = k.avZ();
        avZ.ssid = this.ssid;
        avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol32");
        avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol32");
        avZ.fEN = this.fEN;
        avZ.lRz = this.appId;
        avZ.lRA = m.y(this.intent);
        avZ.lRB = 32;
        avZ.lRC = b.ThreeTwoAuth.lSn;
        avZ.lRD = b.ThreeTwoAuth.name;
        avZ.result = i;
        avZ.ksO = str;
        avZ.fRr = m.B(this.intent);
        avZ.awb().awa();
    }

    public final void Y(int i, String str) {
        k.a avZ = k.avZ();
        avZ.ssid = this.ssid;
        avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol32");
        avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol32");
        avZ.fEN = this.fEN;
        avZ.lRz = this.appId;
        avZ.lRA = m.y(this.intent);
        avZ.lRB = 32;
        avZ.lRC = b.ThreeTwoAuth.lSn;
        avZ.lRD = b.ThreeTwoAuth.name;
        avZ.result = i;
        avZ.ksO = str;
        avZ.fRr = m.B(this.intent);
        avZ.awb().awa();
    }
}
