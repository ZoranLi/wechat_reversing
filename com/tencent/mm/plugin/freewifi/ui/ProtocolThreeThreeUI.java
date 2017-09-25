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
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.e.c;
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
public class ProtocolThreeThreeUI extends MMActivity {
    protected String appId;
    protected String bssid;
    protected int cGa;
    private int fHm = 1;
    protected String fKK;
    protected int fuV;
    protected String lUg;
    private int lUq = 0;
    protected String lUt;
    protected String lUu;
    protected String lUv;
    protected String lUw;
    private Uri lUx;
    private String lUy;
    private a lVC;
    private TextView lWa;
    private ImageView lWo;
    private TextView lWp;
    private TextView lWq;
    private Button lWr;
    private Button lWs;
    private aj lXR = new aj(new aj.a(this) {
        final /* synthetic */ ProtocolThreeThreeUI lXV;

        {
            this.lXV = r1;
        }

        public final boolean oQ() {
            if (!bg.mA(this.lXV.ssid)) {
                this.lXV.fHm = this.lXV.axh();
                if (this.lXV.fHm != 2) {
                    w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent())), d.mL(this.lXV.fHm)});
                    d.a(this.lXV.ssid, 3, this.lXV.getIntent());
                }
            }
            return false;
        }
    }, false);
    private p lXp;
    protected int lXu;
    protected String lXv;
    protected String lXw;
    protected String sign;
    protected String signature;
    protected String ssid;

    static /* synthetic */ void a(ProtocolThreeThreeUI protocolThreeThreeUI, String str) {
        protocolThreeThreeUI.lUq++;
        if (protocolThreeThreeUI.lUq > 3) {
            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.y(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.z(protocolThreeThreeUI.getIntent()))});
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.y(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.z(protocolThreeThreeUI.getIntent())), str});
        if (m.wx(str)) {
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass7 = new com.tencent.mm.plugin.freewifi.a.a.a(protocolThreeThreeUI) {
            final /* synthetic */ ProtocolThreeThreeUI lXV;

            {
                this.lXV = r1;
            }

            public final void d(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                    j.awF().awp().post(new Runnable(this.lXV) {
                        final /* synthetic */ ProtocolThreeThreeUI lXV;

                        {
                            this.lXV = r1;
                        }

                        public final void run() {
                            String awr = d.awr();
                            String awt = d.awt();
                            int aws = d.aws();
                            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent())), "", awr, awt, Integer.valueOf(aws)});
                            new f(this.lXV.ssid, this.lXV.bssid, this.lXV.appId, this.lXV.lUt, this.lXV.lUu, this.lXV.lUv, this.lXV.lUw, this.lXV.sign).b(new e(this) {
                                final /* synthetic */ AnonymousClass8 lXX;

                                {
                                    this.lXX = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar) {
                                    w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.y(this.lXX.lXV.getIntent()), Integer.valueOf(m.z(this.lXX.lXV.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
                                    if (i == 0 && i2 == 0) {
                                        dy awQ = ((f) kVar).awQ();
                                        if (awQ != null) {
                                            w.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG});
                                            this.lXX.lXV.lUg = awQ.jOp;
                                            this.lXX.lXV.fKK = awQ.jNj;
                                            this.lXX.lXV.lXu = awQ.thK;
                                            this.lXX.lXV.lXv = awQ.thL;
                                            this.lXX.lXV.signature = awQ.hAG;
                                            this.lXX.lXV.lXw = awQ.thM;
                                            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.y(this.lXX.lXV.getIntent()), Integer.valueOf(m.z(this.lXX.lXV.getIntent())), this.lXX.lXV.appId, this.lXX.lXV.lUg, this.lXX.lXV.fKK, Integer.valueOf(this.lXX.lXV.lXu), this.lXX.lXV.lXv, this.lXX.lXV.signature, this.lXX.lXV.lXw});
                                        }
                                        d.a(this.lXX.lXV.ssid, 2, this.lXX.lXV.getIntent());
                                        w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.y(this.lXX.lXV.getIntent()), Integer.valueOf(m.z(this.lXX.lXV.getIntent())), Integer.valueOf(2)});
                                    } else if (i2 == -30032) {
                                        Intent intent = new Intent();
                                        intent.putExtra("free_wifi_error_ui_error_msg", this.lXX.lXV.getString(R.l.emp));
                                        intent.setClass(this.lXX.lXV, FreeWifiErrorUI.class);
                                        this.lXX.lXV.finish();
                                        this.lXX.lXV.startActivity(intent);
                                    } else {
                                        d.a(this.lXX.lXV.ssid, 3, this.lXX.lXV.getIntent());
                                        w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", new Object[]{m.y(this.lXX.lXV.getIntent()), Integer.valueOf(m.z(this.lXX.lXV.getIntent())), Integer.valueOf(i2)});
                                    }
                                }
                            });
                        }
                    });
                } else if (responseCode == 302) {
                    ProtocolThreeThreeUI.a(this.lXV, httpURLConnection.getHeaderField("Location"));
                } else {
                    w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent()))});
                    d.a(this.lXV.ssid, 3, this.lXV.getIntent());
                }
            }

            public final void h(Exception exception) {
                w.e("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent())), exception.getMessage()});
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lUy = getIntent().getStringExtra("free_wifi_schema_uri");
        this.lUx = Uri.parse(this.lUy);
        this.appId = this.lUx.getQueryParameter("appId");
        this.lUt = this.lUx.getQueryParameter("shopId");
        this.lUu = this.lUx.getQueryParameter("authUrl");
        this.lUv = this.lUx.getQueryParameter("extend");
        this.lUw = this.lUx.getQueryParameter("timestamp");
        this.sign = this.lUx.getQueryParameter("sign");
        w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.lUy});
        KC();
        if (bg.mA(this.ssid)) {
            w.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
            c cVar;
            int i;
            c wP = j.awC().wP(this.ssid);
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
            cVar.field_url = "";
            cVar.field_mid = "";
            cVar.field_wifiType = 33;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.awC().b(cVar);
            } else {
                j.awC().c(cVar, new String[0]);
            }
            w.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, "", Integer.valueOf(this.cGa)});
            this.lVC = new a(this) {
                final /* synthetic */ ProtocolThreeThreeUI lXV;
                private int lXy = -999999999;

                {
                    this.lXV = r2;
                }

                public final void a(String str, l lVar) {
                    this.lXV.fHm = this.lXV.axh();
                    if (this.lXy != this.lXV.fHm) {
                        this.lXy = this.lXV.fHm;
                        this.lXV.mO(this.lXV.fHm);
                    }
                }
            };
            j.awC().c(this.lVC);
            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        com.tencent.mm.plugin.freewifi.l.p(d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void KC() {
        this.ssid = m.wA("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = m.wB("MicroMsg.FreeWifi.Protocol33UI");
        this.cGa = getIntent().getIntExtra("free_wifi_source", 1);
        this.fuV = getIntent().getIntExtra("free_wifi_channel_id", 0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProtocolThreeThreeUI lXV;

            {
                this.lXV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXV.goBack();
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
            final /* synthetic */ ProtocolThreeThreeUI lXV;

            {
                this.lXV = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.q(d.awv(), this.lXV.getIntent().getStringExtra("free_wifi_ap_key"), this.lXV.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent())), d.mL(this.lXV.axh())});
                if (this.lXV.axh() == 2) {
                    this.lXV.finish();
                    return;
                }
                d.a(this.lXV.ssid, 1, this.lXV.getIntent());
                this.lXV.connect();
            }
        });
        this.lWs = (Button) findViewById(R.h.cLj);
        this.lWs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeThreeUI lXV;

            {
                this.lXV = r1;
            }

            public final void onClick(View view) {
            }
        });
        if (bg.mA(this.ssid)) {
            this.lWq.setText(getString(R.l.emM));
            this.lWr.setVisibility(4);
        }
        qP(getString(R.l.emO));
    }

    protected final void connect() {
        if (m.wx(this.ssid)) {
            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else if (m.wx(this.lUu)) {
            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else {
            this.fHm = axh();
            w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), d.mL(this.fHm)});
            if (this.fHm != 2) {
                this.lXR.v(30000, 30000);
                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), Integer.valueOf(60)});
                m.wx(this.lUu);
                StringBuilder stringBuilder = new StringBuilder(this.lUu);
                if (this.lUu.indexOf("?") == -1) {
                    stringBuilder.append("?extend=").append(this.lUv);
                } else {
                    stringBuilder.append("&extend=").append(this.lUv);
                }
                final String stringBuilder2 = stringBuilder.toString();
                j.awF().awp().post(new Runnable(this) {
                    final /* synthetic */ ProtocolThreeThreeUI lXV;

                    public final void run() {
                        w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent())), stringBuilder2});
                        com.tencent.mm.plugin.freewifi.a.a.awi();
                        com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                            final /* synthetic */ AnonymousClass6 lXW;

                            {
                                this.lXW = r1;
                            }

                            public final void d(HttpURLConnection httpURLConnection) {
                                int responseCode = httpURLConnection.getResponseCode();
                                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.y(this.lXW.lXV.getIntent()), Integer.valueOf(m.z(this.lXW.lXV.getIntent())), Integer.valueOf(responseCode)});
                                if (responseCode == com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX) {
                                    j.awF().awp().post(/* anonymous class already generated */);
                                } else if (responseCode == 302) {
                                    ProtocolThreeThreeUI.a(this.lXW.lXV, httpURLConnection.getHeaderField("Location"));
                                } else {
                                    w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.y(this.lXW.lXV.getIntent()), Integer.valueOf(m.z(this.lXW.lXV.getIntent()))});
                                    d.a(this.lXW.lXV.ssid, 3, this.lXW.lXV.getIntent());
                                }
                            }

                            public final void h(Exception exception) {
                                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.y(this.lXW.lXV.getIntent()), Integer.valueOf(m.z(this.lXW.lXV.getIntent())), exception.getMessage()});
                                d.a(this.lXW.lXV.ssid, 3, this.lXW.lXV.getIntent());
                            }
                        });
                    }
                });
                return;
            }
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void mO(int i) {
        w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.lWa.setVisibility(4);
                this.lWr.setText(R.l.dXu);
                this.lXp = g.a(this.uSU.uTo, getString(R.l.dXu), true, new OnCancelListener(this) {
                    final /* synthetic */ ProtocolThreeThreeUI lXV;

                    {
                        this.lXV = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.lXV.ssid, 4, this.lXV.getIntent());
                        w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.y(this.lXV.getIntent()), Integer.valueOf(m.z(this.lXV.getIntent())), Integer.valueOf(4)});
                    }
                });
                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            case 2:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lXR.KH();
                this.lWr.setText(R.l.dXr);
                this.lWr.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
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
                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                return;
            case 3:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lXR.KH();
                this.lWa.setVisibility(0);
                this.lWr.setText(R.l.emK);
                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
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
                } else {
                    this.lWq.setText(getString(R.l.dXv, new Object[]{this.ssid}));
                }
                w.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
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
            w.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
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

    protected void onDestroy() {
        super.onDestroy();
        if (this.lVC != null) {
            j.awC().f(this.lVC);
        }
        this.lXR.KH();
        j.awF().release();
    }
}
