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
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI extends MMActivity {
    protected int cGa;
    private String fEN;
    private String fGV;
    private int fHm = 1;
    protected String fKK;
    protected String fTO;
    protected int fuV;
    private boolean fyL = false;
    private final c hIy;
    private Intent intent;
    protected String lUe;
    protected String lUg;
    private String lUp;
    private int lUq = 0;
    private a lVC;
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
        final /* synthetic */ ProtocolThreeOneUI lXS;

        {
            this.lXS = r1;
        }

        public final boolean oQ() {
            if (!bg.mA(this.lXS.ssid)) {
                this.lXS.fHm = this.lXS.axh();
                if (this.lXS.fHm != 2) {
                    this.lXS.fyL = true;
                    w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent())), d.mL(this.lXS.fHm)});
                    d.a(this.lXS.ssid, 3, this.lXS.getIntent());
                    this.lXS.W(31, "AUTH_TIMEOUT");
                }
            }
            return false;
        }
    }, false);
    private p lXp;
    protected int lXu;
    protected String lXv;
    protected String lXw;
    protected String signature;
    protected String ssid;

    public ProtocolThreeOneUI() {
        c.a aVar = new c.a();
        aVar.hIJ = true;
        aVar.hIK = true;
        aVar.hJa = R.g.bfh;
        aVar.hJi = true;
        aVar.hJj = 0.0f;
        this.hIy = aVar.Hg();
    }

    static /* synthetic */ void a(ProtocolThreeOneUI protocolThreeOneUI, String str) {
        protocolThreeOneUI.lUq++;
        if (protocolThreeOneUI.lUq > 3) {
            w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(protocolThreeOneUI.getIntent()), Integer.valueOf(m.z(protocolThreeOneUI.getIntent()))});
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.W(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.y(protocolThreeOneUI.getIntent()), Integer.valueOf(m.z(protocolThreeOneUI.getIntent())), str});
        if (m.wx(str)) {
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.W(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass7 = new com.tencent.mm.plugin.freewifi.a.a.a(protocolThreeOneUI) {
            final /* synthetic */ ProtocolThreeOneUI lXS;

            {
                this.lXS = r1;
            }

            public final void d(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                    ProtocolThreeOneUI.e(this.lXS);
                } else if (responseCode == 302) {
                    ProtocolThreeOneUI.a(this.lXS, httpURLConnection.getHeaderField("Location"));
                } else {
                    w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent()))});
                    d.a(this.lXS.ssid, 3, this.lXS.getIntent());
                    this.lXS.W(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                w.e("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent())), exception.getMessage()});
                d.a(this.lXS.ssid, 3, this.lXS.getIntent());
                this.lXS.W(101, m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.awi();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass7);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.awi();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass7);
    }

    static /* synthetic */ void e(ProtocolThreeOneUI protocolThreeOneUI) {
        protocolThreeOneUI.W(0, "");
        j.awF().awp().post(new Runnable(protocolThreeOneUI) {
            final /* synthetic */ ProtocolThreeOneUI lXS;

            {
                this.lXS = r1;
            }

            public final void run() {
                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent())), this.lXS.lUe, d.awr(), d.awt(), Integer.valueOf(d.aws())});
                new com.tencent.mm.plugin.freewifi.d.a(this.lXS.lUe, r2, r3, r4, this.lXS.fuV, m.y(this.lXS.getIntent())).b(new e(this) {
                    final /* synthetic */ AnonymousClass8 lXU;

                    {
                        this.lXU = r1;
                    }

                    public final void a(int i, int i2, String str, k kVar) {
                        w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.y(this.lXU.lXS.getIntent()), Integer.valueOf(m.z(this.lXU.lXS.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                            dy awQ = ((com.tencent.mm.plugin.freewifi.d.a) kVar).awQ();
                            if (awQ != null) {
                                w.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG});
                                this.lXU.lXS.fTO = awQ.teQ;
                                this.lXU.lXS.lUg = awQ.jOp;
                                this.lXU.lXS.fKK = awQ.jNj;
                                this.lXU.lXS.lXu = awQ.thK;
                                this.lXU.lXS.lXv = awQ.thL;
                                this.lXU.lXS.signature = awQ.hAG;
                                this.lXU.lXS.lXw = awQ.thM;
                                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.y(this.lXU.lXS.getIntent()), Integer.valueOf(m.z(this.lXU.lXS.getIntent())), this.lXU.lXS.fTO, this.lXU.lXS.lUg, this.lXU.lXS.fKK, Integer.valueOf(this.lXU.lXS.lXu), this.lXU.lXS.lXv, this.lXU.lXS.signature, this.lXU.lXS.lXw});
                            }
                            d.a(this.lXU.lXS.ssid, 2, this.lXU.lXS.getIntent());
                            w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.y(this.lXU.lXS.getIntent()), Integer.valueOf(m.z(this.lXU.lXS.getIntent())), Integer.valueOf(2)});
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
        this.fGV = getIntent().getStringExtra("free_wifi_schema_ticket");
        this.lUp = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
        w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.fEN, this.fGV});
        KC();
        if (bg.mA(this.ssid)) {
            w.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
        } else {
            com.tencent.mm.sdk.e.c cVar;
            int i;
            com.tencent.mm.sdk.e.c wP = j.awC().wP(this.ssid);
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
            cVar.field_wifiType = 3;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.awC().b(cVar);
            } else {
                j.awC().c(cVar, new String[0]);
            }
            w.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.lVw, Integer.valueOf(this.cGa)});
            this.lVC = new a(this) {
                final /* synthetic */ ProtocolThreeOneUI lXS;
                private int lXy = -999999999;

                {
                    this.lXS = r2;
                }

                public final void a(String str, l lVar) {
                    this.lXS.fHm = this.lXS.axh();
                    if (this.lXy != this.lXS.fHm) {
                        this.lXy = this.lXS.fHm;
                        this.lXS.mO(this.lXS.fHm);
                    }
                }
            };
            j.awC().c(this.lVC);
            w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
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
        w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.ssid, this.lVw, this.lUe, Integer.valueOf(this.cGa), Integer.valueOf(this.fuV), this.fTO, this.lWv, this.lWw, this.lWy});
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProtocolThreeOneUI lXS;

            {
                this.lXS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXS.goBack();
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
            final /* synthetic */ ProtocolThreeOneUI lXS;

            {
                this.lXS = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.q(d.awv(), this.lXS.getIntent().getStringExtra("free_wifi_ap_key"), this.lXS.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent())), d.mL(this.lXS.axh())});
                if (this.lXS.axh() == 2) {
                    this.lXS.finish();
                    return;
                }
                d.a(this.lXS.ssid, 1, this.lXS.getIntent());
                this.lXS.connect();
            }
        });
        this.lWs = (Button) findViewById(R.h.cLj);
        this.lWs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeOneUI lXS;

            {
                this.lXS = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.lXS.lWy);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bb.d.b(this.lXS.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
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
        w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), d.mL(this.fHm)});
        if (this.fHm != 2) {
            this.lXR.v(15000, 15000);
            w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), Integer.valueOf(60)});
            final String str = this.lUp;
            j.awF().awp().post(new Runnable(this) {
                final /* synthetic */ ProtocolThreeOneUI lXS;

                public final void run() {
                    w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent())), str});
                    com.tencent.mm.plugin.freewifi.a.a.awi();
                    com.tencent.mm.plugin.freewifi.a.a.a(str, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass6 lXT;

                        {
                            this.lXT = r1;
                        }

                        public final void d(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.y(this.lXT.lXS.getIntent()), Integer.valueOf(m.z(this.lXT.lXS.getIntent())), Integer.valueOf(responseCode)});
                            if (!this.lXT.lXS.fyL) {
                                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                                    ProtocolThreeOneUI.e(this.lXT.lXS);
                                } else if (responseCode == 302) {
                                    ProtocolThreeOneUI.a(this.lXT.lXS, httpURLConnection.getHeaderField("Location"));
                                } else {
                                    w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lXT.lXS.getIntent()), Integer.valueOf(m.z(this.lXT.lXS.getIntent()))});
                                    d.a(this.lXT.lXS.ssid, 3, this.lXT.lXS.getIntent());
                                    this.lXT.lXS.W(32, "INVALID_HTTP_RESP_CODE");
                                }
                            }
                        }

                        public final void h(Exception exception) {
                            w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.y(this.lXT.lXS.getIntent()), Integer.valueOf(m.z(this.lXT.lXS.getIntent())), exception.getMessage()});
                            d.a(this.lXT.lXS.ssid, 3, this.lXT.lXS.getIntent());
                            this.lXT.lXS.W(101, m.e(exception));
                        }
                    });
                }
            });
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void mO(int i) {
        w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.lWa.setVisibility(4);
                this.lWr.setText(R.l.dXu);
                this.lXp = g.a(this.uSU.uTo, getString(R.l.dXu), true, new OnCancelListener(this) {
                    final /* synthetic */ ProtocolThreeOneUI lXS;

                    {
                        this.lXS = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.lXS.ssid, 4, this.lXS.getIntent());
                        w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.y(this.lXS.getIntent()), Integer.valueOf(m.z(this.lXS.getIntent())), Integer.valueOf(4)});
                    }
                });
                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
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
                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            case 3:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lXR.KH();
                this.lWa.setVisibility(0);
                this.lWr.setText(R.l.emK);
                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            case 4:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lXR.KH();
                this.lWa.setVisibility(4);
                this.lWr.setText(R.l.dXx);
                if (!(m.B(getIntent()) != 10 || m.wx(com.tencent.mm.compatible.d.p.gRh.gRz) || m.wx(com.tencent.mm.compatible.d.p.aw(this.uSU.uTo)))) {
                    this.lWr.setText(String.format(getString(R.l.emk), new Object[]{com.tencent.mm.compatible.d.p.aw(this.uSU.uTo)}));
                }
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
                w.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
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
            w.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c wP = j.awC().wP(this.ssid);
        if (wP == null || !wP.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return wP.field_connectState;
    }

    protected final int Ol() {
        return 1;
    }

    private void W(int i, String str) {
        com.tencent.mm.plugin.freewifi.k.a avZ = com.tencent.mm.plugin.freewifi.k.avZ();
        avZ.ssid = this.ssid;
        avZ.bssid = m.wB("MicroMsg.FreeWifi.Protocol31UI");
        avZ.fEO = m.wC("MicroMsg.FreeWifi.Protocol31UI");
        avZ.fEN = this.fEN;
        avZ.lRz = this.fTO;
        avZ.lRA = m.y(this.intent);
        avZ.lRB = m.A(this.intent);
        avZ.lRC = b.lSd.lSn;
        avZ.lRD = b.lSd.name;
        avZ.result = i;
        avZ.ksO = str;
        avZ.fRr = m.B(this.intent);
        avZ.lRE = this.fKK;
        avZ.awb().awa();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lVC != null) {
            j.awC().f(this.lVC);
        }
        this.lXR.KH();
        j.awF().release();
    }
}
