package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
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
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI extends MMActivity implements a, b {
    protected int cGa;
    protected String fEN;
    private int fHm = 1;
    protected String fKK;
    protected String fTO;
    protected int fuV;
    private final c hIy;
    protected String lUe;
    protected String lUg;
    private aj lVA = new aj(new aj.a(this) {
        final /* synthetic */ FreeWifiStateUI lXx;

        {
            this.lXx = r1;
        }

        public final boolean oQ() {
            if (!bg.mA(this.lXx.ssid)) {
                this.lXx.fHm = this.lXx.axh();
                w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{this.lXx.ssid, Integer.valueOf(this.lXx.fHm)});
                this.lXx.lVB.KH();
                k.a avZ = k.avZ();
                avZ.ssid = this.lXx.ssid;
                avZ.fEN = this.lXx.fEN;
                avZ.lRA = m.y(this.lXx.getIntent());
                avZ.lRB = m.A(this.lXx.getIntent());
                avZ.lRC = k.b.AddNetwork.lSn;
                avZ.lRD = k.b.AddNetwork.name;
                avZ.result = -16;
                avZ.fRr = m.B(this.lXx.getIntent());
                avZ.lRz = this.lXx.fTO;
                avZ.lRE = this.lXx.fKK;
                avZ.awb().awa();
                if (this.lXx.fHm != 2) {
                    this.lXx.axl();
                    this.lXx.axj();
                    d.a(this.lXx.ssid, 3, this.lXx.getIntent());
                }
            }
            return false;
        }
    }, false);
    private aj lVB = new aj(new aj.a(this) {
        final /* synthetic */ FreeWifiStateUI lXx;

        {
            this.lXx = r1;
        }

        public final boolean oQ() {
            if (!d.wG(this.lXx.ssid)) {
                return true;
            }
            this.lXx.a(State.CONNECTED);
            this.lXx.lVB.KH();
            return false;
        }
    }, true);
    private j.a lVC;
    protected String lVw;
    protected FreeWifiNetworkReceiver lVx;
    protected boolean lVy = false;
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
    private p lXp = null;
    protected int lXu;
    protected String lXv;
    protected String lXw;
    protected String signature;
    protected String ssid;

    protected abstract void Tq();

    public abstract void a(State state);

    protected abstract void axg();

    protected abstract int axh();

    public FreeWifiStateUI() {
        c.a aVar = new c.a();
        aVar.hIJ = true;
        aVar.hIK = true;
        aVar.hJa = R.g.bfh;
        aVar.hJi = true;
        aVar.hJj = 0.0f;
        this.hIy = aVar.Hg();
        this.lVC = new j.a(this) {
            final /* synthetic */ FreeWifiStateUI lXx;
            private int lXy = -999999999;

            {
                this.lXx = r2;
            }

            public final void a(String str, l lVar) {
                this.lXx.fHm = this.lXx.axh();
                if (this.lXy != this.lXx.fHm) {
                    this.lXy = this.lXx.fHm;
                    this.lXx.lW(this.lXx.fHm);
                }
            }
        };
    }

    static /* synthetic */ void d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.lVx == null) {
            freeWifiStateUI.axm();
        }
        freeWifiStateUI.lVx.lTv = freeWifiStateUI;
        d.awq();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r9);
        r0 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r0 = r0.getStringExtra(r3);
        r8.fEN = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_ssid";
        r0 = r0.getStringExtra(r3);
        r8.ssid = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_mid";
        r0 = r0.getStringExtra(r3);
        r8.lVw = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_url";
        r0 = r0.getStringExtra(r3);
        r8.lUe = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_source";
        r0 = r0.getIntExtra(r3, r1);
        r8.cGa = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_channel_id";
        r0 = r0.getIntExtra(r3, r2);
        r8.fuV = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_appid";
        r0 = r0.getStringExtra(r3);
        r8.fTO = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_head_img_url";
        r0 = r0.getStringExtra(r3);
        r8.lWv = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_msg";
        r0 = r0.getStringExtra(r3);
        r8.lWw = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_sub_title";
        r0 = r0.getStringExtra(r3);
        r8.lWx = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_privacy_url";
        r0 = r0.getStringExtra(r3);
        r8.lWy = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_app_nickname";
        r0 = r0.getStringExtra(r3);
        r8.lUg = r0;
        r0 = r8.cGa;
        switch(r0) {
            case 1: goto L_0x011b;
            case 2: goto L_0x00e3;
            case 3: goto L_0x011b;
            case 4: goto L_0x011b;
            case 5: goto L_0x011b;
            case 6: goto L_0x011b;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x0179;
    L_0x00b0:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x00b9:
        r8.KC();
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r1 = r8.lVC;
        r0.c(r1);
        r0 = com.tencent.mm.plugin.freewifi.model.d.awv();
        r1 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r1 = r1.getStringExtra(r3);
        r3 = r8.getIntent();
        r4 = "free_wifi_protocol_type";
        r2 = r3.getIntExtra(r4, r2);
        com.tencent.mm.plugin.freewifi.l.p(r0, r1, r2);
        return;
    L_0x00e3:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r0 = r0.axe();
        if (r0 == 0) goto L_0x0111;
    L_0x00ed:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.lVw = r3;
        r0 = r0.field_url;
        r8.lUe = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.lVw;
        r4[r1] = r5;
        r5 = r8.lUe;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        goto L_0x00a8;
    L_0x0111:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.w.i(r0, r3);
        goto L_0x00a8;
    L_0x011b:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 == 0) goto L_0x012d;
    L_0x0123:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x00b9;
    L_0x012d:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r3 = r8.ssid;
        r0 = r0.wP(r3);
        if (r0 != 0) goto L_0x0196;
    L_0x0139:
        r0 = new com.tencent.mm.plugin.freewifi.g.c;
        r0.<init>();
        r3 = r8.ssid;
        r3 = com.tencent.mm.sdk.platformtools.aa.Pq(r3);
        r0.field_ssidmd5 = r3;
        r3 = r8.ssid;
        r0.field_ssid = r3;
        r3 = r0;
        r0 = r1;
    L_0x014c:
        r4 = r8.lUe;
        r3.field_url = r4;
        r4 = r8.lVw;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        r3.field_connectState = r1;
        if (r0 == 0) goto L_0x016e;
    L_0x0165:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r0.b(r3);
        goto L_0x00a8;
    L_0x016e:
        r0 = com.tencent.mm.plugin.freewifi.model.j.awC();
        r4 = new java.lang.String[r2];
        r0.c(r3, r4);
        goto L_0x00a8;
    L_0x0179:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.lVw;
        r4[r1] = r5;
        r1 = r8.cGa;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        goto L_0x00b9;
    L_0x0196:
        r3 = r0;
        r0 = r2;
        goto L_0x014c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int Ol() {
        return 1;
    }

    protected void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiStateUI lXx;

            {
                this.lXx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXx.goBack();
                return true;
            }
        });
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(R.h.cLi).setVisibility(0);
        }
        this.lWo = (ImageView) findViewById(R.h.bRh);
        this.lWp = (TextView) findViewById(R.h.bRT);
        this.lWq = (TextView) findViewById(R.h.bRG);
        this.lWa = (TextView) findViewById(R.h.bRo);
        this.lWr = (Button) findViewById(R.h.bEI);
        this.lWr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiStateUI lXx;

            {
                this.lXx = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.freewifi.l.q(d.awv(), this.lXx.getIntent().getStringExtra("free_wifi_ap_key"), this.lXx.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                if (this.lXx.axh() == 2) {
                    this.lXx.finish();
                    return;
                }
                d.a(this.lXx.ssid, 1, this.lXx.getIntent());
                this.lXx.lVy = false;
                this.lXx.axn();
            }
        });
        this.lWs = (Button) findViewById(R.h.cLj);
        this.lWs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiStateUI lXx;

            {
                this.lXx = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.lXx.lWy);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bb.d.b(this.lXx.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (bg.mA(this.ssid)) {
            this.lWq.setText(getString(R.l.emM));
            this.lWr.setVisibility(4);
        }
    }

    protected final void axj() {
        if (this.lVx != null) {
            w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
            this.lVx.lTv = null;
        }
    }

    protected final void axk() {
        if (this.lVx == null) {
            axm();
        }
        this.lVx.lTw = this;
    }

    protected final void axl() {
        if (this.lVx != null) {
            w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
            this.lVx.lTw = null;
        }
    }

    private void axm() {
        this.lVx = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.lVx, intentFilter);
    }

    protected final void axn() {
        if (d.isWifiEnabled()) {
            this.fHm = axh();
            w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[]{Integer.valueOf(this.fHm)});
            if (this.fHm != 2) {
                if (m.A(getIntent()) == 4) {
                    this.lVA.v(30000, 30000);
                } else {
                    this.lVA.v(60000, 60000);
                }
                this.lVB.v(1000, 1000);
                if (d.wG(this.ssid)) {
                    w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[]{Boolean.valueOf(this.lVy)});
                    if (this.lVy) {
                        w.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
                        return;
                    }
                    this.lVA.v(60000, 60000);
                    this.lVB.v(1000, 1000);
                    Tq();
                    this.lVy = true;
                    return;
                }
                com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(this) {
                    final /* synthetic */ FreeWifiStateUI lXx;

                    {
                        this.lXx = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[]{this.lXx.ssid});
                        this.lXx.axg();
                    }
                });
                return;
            }
            d.a(this.ssid, this.fHm, getIntent());
            return;
        }
        this.lVA.v(60000, 60000);
        this.lVB.v(1000, 1000);
        w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
        com.tencent.mm.plugin.freewifi.model.j.awF().awp().post(new Runnable(this) {
            final /* synthetic */ FreeWifiStateUI lXx;

            {
                this.lXx = r1;
            }

            public final void run() {
                FreeWifiStateUI.d(this.lXx);
            }
        });
    }

    protected final void lW(int i) {
        w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -2014:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lVA.KH();
                this.lVB.KH();
                this.lWa.setVisibility(0);
                this.lWr.setText(R.l.emK);
                return;
            case -1:
                return;
            case 1:
                this.lWa.setVisibility(4);
                this.lWr.setText(R.l.dXu);
                this.lXp = g.a(this.uSU.uTo, getString(R.l.dXu), true, new OnCancelListener(this) {
                    final /* synthetic */ FreeWifiStateUI lXx;

                    {
                        this.lXx = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.lXx.ssid, 4, this.lXx.getIntent());
                    }
                });
                return;
            case 2:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lVA.KH();
                this.lVB.KH();
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
                return;
            case 3:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lVA.KH();
                this.lVB.KH();
                this.lWa.setVisibility(0);
                this.lWr.setText(R.l.emK);
                return;
            case 4:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
                this.lVA.KH();
                this.lVB.KH();
                this.lVy = false;
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
                    if (!bg.mA(this.lWw)) {
                        this.lWp.setText(this.lWw);
                    }
                    if (!bg.mA(this.lWv)) {
                        n.GW().a(this.lWv, this.lWo, this.hIy);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (this.lXp != null) {
                    this.lXp.dismiss();
                }
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
                    if (!bg.mA(this.lWw)) {
                        this.lWp.setText(this.lWw);
                    }
                    if (!bg.mA(this.lWv)) {
                        n.GW().a(this.lWv, this.lWo, this.hIy);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.ddr;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.awC().f(this.lVC);
        axj();
        axl();
        if (this.lVx != null) {
            unregisterReceiver(this.lVx);
        }
        this.lVA.KH();
        this.lVB.KH();
        com.tencent.mm.plugin.freewifi.model.j.awF().release();
    }

    public final void mM(int i) {
        w.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 3:
                axj();
                axn();
                return;
            default:
                return;
        }
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
}
