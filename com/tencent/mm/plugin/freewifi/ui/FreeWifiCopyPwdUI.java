package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.i;

public class FreeWifiCopyPwdUI extends MMActivity {
    public static int lVX = 111;
    private String appId;
    private String fEN;
    private int fuV;
    private ae hgN = new ae(this) {
        final /* synthetic */ FreeWifiCopyPwdUI lWd;

        {
            this.lWd = r1;
        }

        public final void handleMessage(Message message) {
            b bVar = (b) message.obj;
            if (bVar.lWi == this.lWd.lVY) {
                FreeWifiCopyPwdUI.a(this.lWd, bVar.data);
            } else {
                FreeWifiCopyPwdUI.b(this.lWd, bVar.data);
            }
        }
    };
    private Intent intent;
    private int lUf;
    private int lVY = 1;
    private int lVZ = 2;
    protected TextView lWa;
    protected TextView lWb;
    protected TextView lWc;
    private String ssid;

    public static class a {
        public static a lWf = new a();
        public int lWg;
        public String lWh;
        public String text;
    }

    public class b {
        Object data;
        final /* synthetic */ FreeWifiCopyPwdUI lWd;
        int lWi;

        public b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, int i, Object obj) {
            this.lWd = freeWifiCopyPwdUI;
            this.lWi = i;
            this.data = obj;
        }
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, b bVar) {
        Message obtain = Message.obtain();
        obtain.obj = bVar;
        freeWifiCopyPwdUI.hgN.sendMessage(obtain);
    }

    static /* synthetic */ void a(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        if (obj instanceof dy) {
            com.tencent.mm.plugin.freewifi.k.a avZ;
            dy dyVar = (dy) obj;
            Intent intent = freeWifiCopyPwdUI.getIntent();
            intent.putExtra("free_wifi_appid", dyVar.teQ);
            intent.putExtra("free_wifi_app_nickname", dyVar.jOp);
            intent.putExtra("free_wifi_app_username", dyVar.jNj);
            intent.putExtra("free_wifi_signature", dyVar.hAG);
            intent.putExtra("free_wifi_finish_actioncode", dyVar.thK);
            intent.putExtra("free_wifi_finish_url", dyVar.thL);
            intent.putExtra(com.tencent.mm.ui.d.b.uOy, dyVar.lXF);
            if (dyVar.thK == 2) {
                if (bg.mA(dyVar.jNj)) {
                    intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", dyVar.jNj);
                    d.b(freeWifiCopyPwdUI, "profile", ".ui.ContactInfoUI", intent2);
                    d.qg();
                    w.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.y(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.z(freeWifiCopyPwdUI.getIntent()))});
                    avZ = k.avZ();
                    avZ.fEN = freeWifiCopyPwdUI.fEN;
                    avZ.lRA = m.y(intent);
                    avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.lSn;
                    avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoContactInfoUI.name;
                    avZ.fRr = m.B(intent);
                    avZ.lRB = m.A(intent);
                    avZ.result = 0;
                    avZ.ksO = "";
                    avZ.awb().b(intent, true).awa();
                    return;
                }
            } else if (m.wx(dyVar.thM)) {
                intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", dyVar.thM);
                intent.setClass(freeWifiCopyPwdUI, FreeWifiSuccWebViewUI.class);
            }
            avZ = k.avZ();
            avZ.fEN = freeWifiCopyPwdUI.fEN;
            avZ.lRA = m.y(intent);
            avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.lSn;
            avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.name;
            avZ.fRr = m.B(intent);
            avZ.lRB = m.A(intent);
            avZ.result = 0;
            avZ.ksO = "";
            avZ.awb().b(intent, true).awa();
            freeWifiCopyPwdUI.finish();
            freeWifiCopyPwdUI.startActivity(intent);
            d.qg();
            w.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.y(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.z(freeWifiCopyPwdUI.getIntent()))});
        }
    }

    static /* synthetic */ void b(FreeWifiCopyPwdUI freeWifiCopyPwdUI, Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            w.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[]{m.y(freeWifiCopyPwdUI.intent), Integer.valueOf(m.z(freeWifiCopyPwdUI.intent)), aVar.lWh});
            freeWifiCopyPwdUI.lWa.setVisibility(0);
            if (m.wx(aVar.text)) {
                if (aVar.lWg == 0) {
                    aVar.lWg = R.l.emm;
                }
                string = freeWifiCopyPwdUI.getString(aVar.lWg);
            } else {
                string = aVar.text;
            }
            freeWifiCopyPwdUI.lWa.setText(string);
            freeWifiCopyPwdUI.lWa.setVisibility(0);
            freeWifiCopyPwdUI.lWb.setVisibility(0);
            freeWifiCopyPwdUI.lWc.setVisibility(0);
            final String str = freeWifiCopyPwdUI.getString(R.l.emx) + ": " + aVar.lWh;
            freeWifiCopyPwdUI.lWc.setOnClickListener(new OnClickListener(freeWifiCopyPwdUI) {
                final /* synthetic */ FreeWifiCopyPwdUI lWd;

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", this.lWd.getString(R.l.eml));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(this.lWd, FreeWifiErrorUI.class);
                    this.lWd.startActivity(intent);
                }
            });
            w.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[]{m.y(freeWifiCopyPwdUI.getIntent()), Integer.valueOf(m.z(freeWifiCopyPwdUI.getIntent()))});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiCopyPwdUI lWd;

            {
                this.lWd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lWd.goBack();
                return true;
            }
        });
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.fEN = this.intent.getStringExtra("free_wifi_ap_key");
        this.appId = this.intent.getStringExtra("free_wifi_appid");
        this.fuV = this.intent.getIntExtra("free_wifi_channel_id", 0);
        this.lUf = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        ((TextView) findViewById(R.h.bRF)).setText(this.ssid);
        com.tencent.mm.pluginsdk.j.d.a(this.uSU.uTo, "wifi password", getIntent().getStringExtra("free_wifi_passowrd"));
        ((Button) findViewById(R.h.bRp)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiCopyPwdUI lWd;

            {
                this.lWd = r1;
            }

            public final void onClick(View view) {
                this.lWd.startActivityForResult(new Intent("android.settings.WIFI_SETTINGS"), FreeWifiCopyPwdUI.lVX);
            }
        });
        this.lWa = (TextView) findViewById(R.h.bRr);
        this.lWb = (TextView) findViewById(R.h.bRq);
        this.lWc = (TextView) findViewById(R.h.bRs);
        String awv = com.tencent.mm.plugin.freewifi.model.d.awv();
        String stringExtra = getIntent().getStringExtra("free_wifi_ap_key");
        int intExtra = getIntent().getIntExtra("free_wifi_protocol_type", 0);
        g.oUh.i(12651, new Object[]{Integer.valueOf(6), awv, Integer.valueOf(0), stringExtra, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(intExtra)});
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == lVX && m.awg() && !i.isNullOrEmpty(this.ssid) && this.ssid.equals(com.tencent.mm.plugin.freewifi.model.d.aww())) {
            w.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "sessionKey=%s, step=%d, desc=connect ssid succeeded. ", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent))});
            com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
            avZ.ssid = this.ssid;
            avZ.bssid = m.wB("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            avZ.fEO = m.wC("MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
            avZ.fEN = this.fEN;
            avZ.lRz = this.appId;
            avZ.lRA = m.y(this.intent);
            avZ.lRB = m.A(this.intent);
            avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.AddNetwork.lSn;
            avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.AddNetwork.name;
            avZ.result = 0;
            avZ.fRr = m.B(this.intent);
            avZ.awb().awa();
            m.a(this.intent, this.fEN, this.lUf, this.fuV, new com.tencent.mm.plugin.freewifi.m.a(this) {
                final /* synthetic */ FreeWifiCopyPwdUI lWd;

                {
                    this.lWd = r1;
                }

                public final void h(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI;
                    FreeWifiCopyPwdUI freeWifiCopyPwdUI2;
                    int c;
                    a aVar;
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof com.tencent.mm.plugin.freewifi.d.a) {
                            dy awQ = ((com.tencent.mm.plugin.freewifi.d.a) kVar).awQ();
                            if (awQ != null) {
                                w.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{awQ.teQ, awQ.jOp, awQ.jNj, Integer.valueOf(awQ.thK), awQ.thL, awQ.hAG, awQ.thM});
                                FreeWifiCopyPwdUI.a(this.lWd, new b(this.lWd, this.lWd.lVY, awQ));
                                return;
                            }
                            w.i("MicroMsg.FreeWifi.FreeWifiCopyPwdUI", "backPageInfo is null");
                            freeWifiCopyPwdUI = this.lWd;
                            freeWifiCopyPwdUI2 = this.lWd;
                            c = this.lWd.lVZ;
                            aVar = new a();
                            aVar.lWh = m.a(this.lWd.lUf, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, 21);
                            FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                        }
                    } else if (!m.ca(i, i2) || m.wx(str)) {
                        freeWifiCopyPwdUI = this.lWd;
                        freeWifiCopyPwdUI2 = this.lWd;
                        c = this.lWd.lVZ;
                        aVar = new a();
                        aVar.lWh = m.a(this.lWd.lUf, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                    } else {
                        freeWifiCopyPwdUI = this.lWd;
                        freeWifiCopyPwdUI2 = this.lWd;
                        c = this.lWd.lVZ;
                        aVar = new a();
                        aVar.text = str;
                        aVar.lWh = m.a(this.lWd.lUf, com.tencent.mm.plugin.freewifi.k.b.GetBackPageReturn, i2);
                        FreeWifiCopyPwdUI.a(freeWifiCopyPwdUI, new b(freeWifiCopyPwdUI2, c, aVar));
                    }
                }
            }, "MicroMsg.FreeWifi.FreeWifiCopyPwdUI");
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
        l.r(com.tencent.mm.plugin.freewifi.model.d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
        avZ.fEN = this.fEN;
        avZ.lRA = m.y(this.intent);
        avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.CopyPwdPageUIClosedByGoBack.lSn;
        avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.CopyPwdPageUIClosedByGoBack.name;
        avZ.fRr = m.B(this.intent);
        avZ.lRB = m.A(this.intent);
        avZ.result = 0;
        avZ.ksO = "";
        avZ.awb().b(this.intent, true).awa();
        com.tencent.mm.plugin.freewifi.g.imv.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return R.i.ddq;
    }
}
