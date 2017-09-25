package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI extends MMActivity {
    protected int cGa;
    private String fEN;
    private int fHm = 1;
    protected String fKK;
    protected String fTO;
    protected int fuV;
    private final c hIy;
    private Intent intent;
    private String lUC;
    protected String lUe;
    protected String lUg;
    private a lUk;
    private int lUq = 0;
    private String lUw;
    private j.a lVC;
    protected String lVw;
    private TextView lWa;
    private ImageView lWo;
    private TextView lWp;
    private TextView lWq;
    private Button lWr;
    private Button lWs;
    protected String lWv;
    protected String lWw;
    protected String lWx;
    protected String lWy;
    private aj lXR = new aj(new aj.a(this) {
        final /* synthetic */ ProtocolThreeTwoUI lXY;

        {
            this.lXY = r1;
        }

        public final boolean oQ() {
            if (!bg.mA(this.lXY.ssid)) {
                this.lXY.fHm = this.lXY.axh();
                if (this.lXY.fHm != 2) {
                    w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), d.mL(this.lXY.fHm)});
                    d.a(this.lXY.ssid, 3, this.lXY.getIntent());
                    this.lXY.W(33, "AUTH_302_TIMES_EXCESS");
                }
            }
            return false;
        }
    }, false);
    private p lXp;
    protected int lXu;
    protected String lXv;
    protected String lXw;
    private String openId;
    private String sign;
    protected String signature;
    protected String ssid;

    public ProtocolThreeTwoUI() {
        c.a aVar = new c.a();
        aVar.hIJ = true;
        aVar.hIK = true;
        aVar.hJa = R.g.bfh;
        aVar.hJi = true;
        aVar.hJj = 0.0f;
        this.hIy = aVar.Hg();
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        protocolThreeTwoUI.lUq++;
        if (protocolThreeTwoUI.lUq > 3) {
            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.z(protocolThreeTwoUI.getIntent()))});
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.W(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.y(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.z(protocolThreeTwoUI.getIntent())), str});
        if (m.wx(str)) {
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.W(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass11 = new com.tencent.mm.plugin.freewifi.a.a.a(protocolThreeTwoUI) {
            final /* synthetic */ ProtocolThreeTwoUI lXY;

            {
                this.lXY = r1;
            }

            public final void d(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                    ProtocolThreeTwoUI.f(this.lXY);
                } else if (responseCode == 302) {
                    ProtocolThreeTwoUI.b(this.lXY, httpURLConnection.getHeaderField("Location"));
                } else {
                    w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent()))});
                    d.a(this.lXY.ssid, 3, this.lXY.getIntent());
                    this.lXY.W(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                w.e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), exception.getMessage()});
                this.lXY.W(101, m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.awi();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass11);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.awi();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass11);
    }

    static /* synthetic */ void c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.y(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.z(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid});
        protocolThreeTwoUI.lUk.a(new a.a(protocolThreeTwoUI) {
            final /* synthetic */ ProtocolThreeTwoUI lXY;

            {
                this.lXY = r1;
            }

            public final void onSuccess() {
                k.a avZ = k.avZ();
                avZ.ssid = this.lXY.ssid;
                avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol32UI");
                avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol32UI");
                avZ.fEN = this.lXY.fEN;
                avZ.lRz = this.lXY.fTO;
                avZ.lRA = m.y(this.lXY.intent);
                avZ.lRB = m.A(this.lXY.intent);
                avZ.lRC = b.lRN.lSn;
                avZ.lRD = b.lRN.name;
                avZ.result = 0;
                avZ.fRr = m.B(this.lXY.intent);
                avZ.lRE = this.lXY.fKK;
                avZ.awb().awa();
                final String avY = h.b.lRu.avY();
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), this.lXY.ssid, avY});
                com.tencent.mm.plugin.freewifi.a.a.a anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                    int lUE = 0;
                    private final int lUF = 3;
                    private int lUG = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a lUH = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 lYb;

                        {
                            this.lYb = r1;
                        }

                        public final void d(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.y(this.lYb.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYb.lYa.lXY.getIntent()))});
                                d.a(this.lYb.lYa.lXY.ssid, 3, this.lYb.lYa.lXY.getIntent());
                                this.lYb.lYa.lXY.W(35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            } else if (responseCode == 302) {
                                this.lYb.wM(httpURLConnection.getHeaderField("Location"));
                            } else {
                                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lYb.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYb.lYa.lXY.getIntent()))});
                                d.a(this.lYb.lYa.lXY.ssid, 3, this.lYb.lYa.lXY.getIntent());
                                this.lYb.lYa.lXY.W(32, "INVALID_HTTP_RESP_CODE");
                            }
                        }

                        public final void h(Exception exception) {
                            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.y(this.lYb.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYb.lYa.lXY.getIntent())), exception.getMessage()});
                            d.a(this.lYb.lYa.lXY.ssid, 3, this.lYb.lYa.lXY.getIntent());
                            this.lYb.lYa.lXY.W(101, m.e(exception));
                        }
                    };
                    final /* synthetic */ AnonymousClass9 lYa;

                    public final void d(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[]{m.y(this.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYa.lXY.getIntent()))});
                            ProtocolThreeTwoUI.f(this.lYa.lXY);
                        } else if (responseCode == 302) {
                            wM(httpURLConnection.getHeaderField("Location"));
                        } else {
                            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYa.lXY.getIntent()))});
                            d.a(this.lYa.lXY.ssid, 3, this.lYa.lXY.getIntent());
                            this.lYa.lXY.W(32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.y(this.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYa.lXY.getIntent())), exception.getMessage()});
                        if (exception instanceof UnknownHostException) {
                            this.lYa.lXY.W(102, m.e(exception));
                            int i = this.lUE + 1;
                            this.lUE = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.awi();
                                    com.tencent.mm.plugin.freewifi.a.a.a(avY, this);
                                    return;
                                } catch (InterruptedException e) {
                                    return;
                                }
                            }
                            d.a(this.lYa.lXY.ssid, 3, this.lYa.lXY.getIntent());
                            this.lYa.lXY.W(101, m.e(exception));
                            return;
                        }
                        d.a(this.lYa.lXY.ssid, 3, this.lYa.lXY.getIntent());
                        this.lYa.lXY.W(101, m.e(exception));
                    }

                    public final void wM(String str) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String wz = m.wz(parse.getQueryParameter("extend"));
                        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[]{m.y(this.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYa.lXY.getIntent())), str, queryParameter, wz});
                        if (m.wx(queryParameter)) {
                            this.lUG++;
                            if (this.lUG < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.awi();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.lUH);
                                return;
                            }
                            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(this.lYa.lXY.getIntent()), Integer.valueOf(m.z(this.lYa.lXY.getIntent()))});
                            d.a(this.lYa.lXY.ssid, 3, this.lYa.lXY.getIntent());
                            this.lYa.lXY.W(36, "BLACK_302_TIMES_EXCESS");
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(wz);
                        } else {
                            stringBuilder.append("?extend=").append(wz);
                        }
                        stringBuilder.append("&openId=").append(m.wz(this.lYa.lXY.openId)).append("&tid=").append(m.wz(this.lYa.lXY.lUC)).append("&timestamp=").append(this.lYa.lXY.lUw).append("&sign=").append(this.lYa.lXY.sign);
                        com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(this.lYa.lXY, stringBuilder.toString()) {
                            final /* synthetic */ ProtocolThreeTwoUI lXY;

                            public final void run() {
                                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), r3});
                                com.tencent.mm.plugin.freewifi.a.a.awi();
                                com.tencent.mm.plugin.freewifi.a.a.a(r3, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                                    final /* synthetic */ AnonymousClass10 lYc;

                                    {
                                        this.lYc = r1;
                                    }

                                    public final void d(HttpURLConnection httpURLConnection) {
                                        int responseCode = httpURLConnection.getResponseCode();
                                        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.y(this.lYc.lXY.getIntent()), Integer.valueOf(m.z(this.lYc.lXY.getIntent())), Integer.valueOf(responseCode)});
                                        if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                                            ProtocolThreeTwoUI.f(this.lYc.lXY);
                                        } else if (responseCode == 302) {
                                            ProtocolThreeTwoUI.b(this.lYc.lXY, httpURLConnection.getHeaderField("Location"));
                                        } else {
                                            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.y(this.lYc.lXY.getIntent()), Integer.valueOf(m.z(this.lYc.lXY.getIntent()))});
                                            d.a(this.lYc.lXY.ssid, 3, this.lYc.lXY.getIntent());
                                            this.lYc.lXY.W(32, "INVALID_HTTP_RESP_CODE");
                                        }
                                    }

                                    public final void h(Exception exception) {
                                        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.y(this.lYc.lXY.getIntent()), Integer.valueOf(m.z(this.lYc.lXY.getIntent())), exception.getMessage()});
                                        d.a(this.lYc.lXY.ssid, 3, this.lYc.lXY.getIntent());
                                        this.lYc.lXY.W(101, m.e(exception));
                                    }
                                });
                            }
                        });
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.awi();
                com.tencent.mm.plugin.freewifi.a.a.a(avY, anonymousClass1);
            }

            public final void mF(int i) {
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), this.lXY.ssid, Integer.valueOf(i)});
                d.a(this.lXY.ssid, 3, this.lXY.getIntent());
                k.a avZ = k.avZ();
                avZ.ssid = this.lXY.ssid;
                avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol32UI");
                avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol32UI");
                avZ.fEN = this.lXY.fEN;
                avZ.lRz = this.lXY.fTO;
                avZ.lRA = m.y(this.lXY.intent);
                avZ.lRB = m.A(this.lXY.intent);
                avZ.lRC = b.lRN.lSn;
                avZ.lRD = b.lRN.name;
                avZ.result = i;
                avZ.fRr = m.B(this.lXY.intent);
                avZ.lRE = this.lXY.fKK;
                avZ.awb().awa();
            }
        });
    }

    static /* synthetic */ void f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        protocolThreeTwoUI.W(0, "");
        com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(protocolThreeTwoUI) {
            final /* synthetic */ ProtocolThreeTwoUI lXY;

            {
                this.lXY = r1;
            }

            public final void run() {
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), this.lXY.lUe, d.awr(), d.awt(), Integer.valueOf(d.aws())});
                new com.tencent.mm.plugin.freewifi.d.a(this.lXY.lUe, r2, r3, r4, this.lXY.fuV, m.y(this.lXY.getIntent())).b(new e(this) {
                    final /* synthetic */ AnonymousClass2 lXZ;

                    {
                        this.lXZ = r1;
                    }

                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.y(this.lXZ.lXY.getIntent()), Integer.valueOf(m.z(this.lXZ.lXY.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                            dy awQ = ((com.tencent.mm.plugin.freewifi.d.a) kVar).awQ();
                            if (awQ != null) {
                                w.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG});
                                this.lXZ.lXY.fTO = awQ.teQ;
                                this.lXZ.lXY.lUg = awQ.jOp;
                                this.lXZ.lXY.fKK = awQ.jNj;
                                this.lXZ.lXY.lXu = awQ.thK;
                                this.lXZ.lXY.lXv = awQ.thL;
                                this.lXZ.lXY.signature = awQ.hAG;
                                this.lXZ.lXY.lXw = awQ.thM;
                                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.y(this.lXZ.lXY.getIntent()), Integer.valueOf(m.z(this.lXZ.lXY.getIntent())), this.lXZ.lXY.fTO, this.lXZ.lXY.lUg, this.lXZ.lXY.fKK, Integer.valueOf(this.lXZ.lXY.lXu), this.lXZ.lXY.lXv, this.lXZ.lXY.signature, this.lXZ.lXY.lXw});
                            }
                            d.a(this.lXZ.lXY.ssid, 2, this.lXZ.lXY.getIntent());
                            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.y(this.lXZ.lXY.getIntent()), Integer.valueOf(m.z(this.lXZ.lXY.getIntent())), Integer.valueOf(2)});
                        }
                    }
                });
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.intent = getIntent();
        this.fEN = getIntent().getStringExtra("free_wifi_ap_key");
        this.openId = getIntent().getStringExtra("free_wifi_openid");
        this.lUC = getIntent().getStringExtra("free_wifi_tid");
        this.lUw = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.sign = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.fEN});
        KC();
        if (bg.mA(this.ssid)) {
            w.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
        } else {
            com.tencent.mm.sdk.e.c cVar;
            int i;
            com.tencent.mm.sdk.e.c wP = com.tencent.mm.plugin.freewifi.model.j.awC().wP(this.ssid);
            if (wP == null) {
                wP = new com.tencent.mm.plugin.freewifi.g.c();
                wP.field_ssidmd5 = aa.Pq(this.ssid);
                wP.field_ssid = this.ssid;
                cVar = wP;
                i = 1;
            } else {
                cVar = wP;
                i = 0;
            }
            cVar.field_url = this.lUe;
            cVar.field_mid = this.lVw;
            cVar.field_wifiType = 32;
            cVar.field_connectState = 1;
            if (i != 0) {
                com.tencent.mm.plugin.freewifi.model.j.awC().b(cVar);
            } else {
                com.tencent.mm.plugin.freewifi.model.j.awC().c(cVar, new String[0]);
            }
            w.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.lVw, Integer.valueOf(this.cGa)});
            this.lVC = new j.a(this) {
                final /* synthetic */ ProtocolThreeTwoUI lXY;
                private int lXy = -999999999;

                {
                    this.lXY = r2;
                }

                public final void a(String str, l lVar) {
                    this.lXY.fHm = this.lXY.axh();
                    if (this.lXy != this.lXY.fHm) {
                        this.lXy = this.lXY.fHm;
                        this.lXY.mO(this.lXY.fHm);
                    }
                }
            };
            com.tencent.mm.plugin.freewifi.model.j.awC().c(this.lVC);
            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        com.tencent.mm.plugin.freewifi.l.p(d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void KC() {
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.lVw = getIntent().getStringExtra("free_wifi_mid");
        this.lUe = getIntent().getStringExtra("free_wifi_url");
        this.cGa = getIntent().getIntExtra("free_wifi_source", 1);
        this.fuV = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.fTO = getIntent().getStringExtra("free_wifi_appid");
        this.lWv = getIntent().getStringExtra("free_wifi_head_img_url");
        this.lWw = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.lWx = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.lWy = getIntent().getStringExtra("free_wifi_privacy_url");
        this.lUg = getIntent().getStringExtra("free_wifi_app_nickname");
        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.ssid, this.lVw, this.lUe, Integer.valueOf(this.cGa), Integer.valueOf(this.fuV), this.fTO, this.lWv, this.lWw, this.lWy});
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProtocolThreeTwoUI lXY;

            {
                this.lXY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXY.goBack();
                return true;
            }
        });
        findViewById(R.h.cLi).setVisibility(0);
        this.lWo = (ImageView) findViewById(R.h.bRh);
        this.lWp = (TextView) findViewById(R.h.bRT);
        this.lWq = (TextView) findViewById(R.h.bRG);
        this.lWa = (TextView) findViewById(R.h.bRo);
        this.lWr = (Button) findViewById(R.h.bEI);
        this.lWr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeTwoUI lXY;

            {
                this.lXY = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.q(d.awv(), this.lXY.getIntent().getStringExtra("free_wifi_ap_key"), this.lXY.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), d.mL(this.lXY.axh())});
                if (this.lXY.axh() == 2) {
                    this.lXY.finish();
                    return;
                }
                d.a(this.lXY.ssid, 1, this.lXY.getIntent());
                this.lXY.connect();
            }
        });
        this.lWs = (Button) findViewById(R.h.cLj);
        this.lWs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeTwoUI lXY;

            {
                this.lXY = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.lXY.lWy);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bb.d.b(this.lXY.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (bg.mA(this.ssid)) {
            this.lWq.setText(getString(R.l.emM));
            this.lWr.setVisibility(4);
        }
        qP(getString(R.l.emO));
    }

    protected final void connect() {
        this.fHm = axh();
        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), d.mL(this.fHm)});
        if (this.fHm != 2) {
            this.lXR.v(45000, 45000);
            w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), Integer.valueOf(60)});
            this.lUk = new a(this.ssid, this);
            com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(this) {
                final /* synthetic */ ProtocolThreeTwoUI lXY;

                {
                    this.lXY = r1;
                }

                public final void run() {
                    ProtocolThreeTwoUI.c(this.lXY);
                }
            });
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void mO(int i) {
        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.lWa.setVisibility(4);
                this.lWr.setText(R.l.dXu);
                this.lXp = g.a(this.uSU.uTo, getString(R.l.dXu), true, new OnCancelListener(this) {
                    final /* synthetic */ ProtocolThreeTwoUI lXY;

                    {
                        this.lXY = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.lXY.ssid, 4, this.lXY.getIntent());
                        w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.y(this.lXY.getIntent()), Integer.valueOf(m.z(this.lXY.getIntent())), Integer.valueOf(4)});
                    }
                });
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            case 2:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lXR.KH();
                this.lWr.setText(R.l.dXr);
                this.lWr.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.fTO);
                intent.putExtra("free_wifi_app_nickname", this.lUg);
                intent.putExtra("free_wifi_app_username", this.fKK);
                intent.putExtra("free_wifi_signature", this.signature);
                intent.putExtra("free_wifi_finish_actioncode", this.lXu);
                intent.putExtra("free_wifi_finish_url", this.lXv);
                if (bg.mA(this.lXw)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.lXw);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                d.qg();
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            case 3:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lXR.KH();
                this.lWa.setVisibility(0);
                this.lWr.setText(R.l.emK);
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            case 4:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lXR.KH();
                this.lWa.setVisibility(4);
                this.lWr.setText(R.l.dXx);
                if (this.cGa == 3) {
                    this.lWq.setText(getString(R.l.eAS, new Object[]{this.ssid}));
                } else if (bg.mA(this.lWx)) {
                    this.lWq.setText(getString(R.l.dXt));
                } else {
                    this.lWq.setText(this.lWx);
                }
                if (!bg.mA(this.fTO)) {
                    if (!bg.mA(this.lUg)) {
                        this.lWp.setText(this.lUg);
                    }
                    if (!bg.mA(this.lWv)) {
                        n.GW().a(this.lWv, this.lWo, this.hIy);
                    }
                }
                w.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.ddr;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.freewifi.l.r(d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.g.imv.i(new Intent(), this);
        finish();
    }

    protected final int axh() {
        if (bg.mA(this.ssid)) {
            w.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c wP = com.tencent.mm.plugin.freewifi.model.j.awC().wP(this.ssid);
        if (wP == null || !wP.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return wP.field_connectState;
    }

    private void W(int i, String str) {
        k.a avZ = k.avZ();
        avZ.ssid = this.ssid;
        avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol32UI");
        avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol32UI");
        avZ.fEN = this.fEN;
        avZ.lRz = this.fTO;
        avZ.lRA = m.y(this.intent);
        avZ.lRB = m.A(this.intent);
        avZ.lRC = b.lSe.lSn;
        avZ.lRD = b.lSe.name;
        avZ.result = i;
        avZ.ksO = str;
        avZ.fRr = m.B(this.intent);
        avZ.lRE = this.fKK;
        avZ.awb().awa();
    }

    protected final int Ol() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lVC != null) {
            com.tencent.mm.plugin.freewifi.model.j.awC().f(this.lVC);
        }
        this.lXR.KH();
        com.tencent.mm.plugin.freewifi.model.j.awF().release();
    }
}
