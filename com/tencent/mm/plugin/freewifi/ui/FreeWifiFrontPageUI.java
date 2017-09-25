package com.tencent.mm.plugin.freewifi.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.freewifi.e.f;
import com.tencent.mm.plugin.freewifi.e.g;
import com.tencent.mm.plugin.freewifi.e.h;
import com.tencent.mm.plugin.freewifi.e.i;
import com.tencent.mm.plugin.freewifi.e.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FreeWifiFrontPageUI extends MMActivity {
    protected int cGa;
    protected String className;
    protected String fEN;
    protected String fTO;
    protected int fuV;
    private final com.tencent.mm.ah.a.a.c hIy;
    private ae hgN = new ae(this) {
        final /* synthetic */ FreeWifiFrontPageUI lWC;

        {
            this.lWC = r1;
        }

        public final void handleMessage(Message message) {
            c cVar = (c) message.obj;
            switch (cVar.lWB) {
                case START:
                    this.lWC.axq();
                    return;
                case lWH:
                    this.lWC.axr();
                    return;
                case FAIL:
                    this.lWC.aT(cVar.data);
                    return;
                case SUCCESS:
                    this.lWC.aU(cVar.data);
                    return;
                default:
                    return;
            }
        }
    };
    protected Intent intent;
    protected String lUe;
    protected int lUf;
    protected String lUg;
    private Lock lWA;
    private d lWB;
    protected TextView lWa;
    protected TextView lWb;
    protected TextView lWc;
    protected ImageView lWo;
    protected TextView lWp;
    protected TextView lWq;
    protected Button lWr;
    protected Button lWs;
    protected Dialog lWt;
    protected View lWu;
    protected String lWv;
    protected String lWw;
    protected String lWx;
    protected String lWy;
    protected com.tencent.mm.plugin.freewifi.e.a lWz;
    protected String ssid;

    public static class a {
        public static a lWE = new a();
        public int lWg;
        public String lWh;
        public String text;
    }

    public static class b {
        public dy lWF;
    }

    public static class c {
        Object data;
        d lWB;

        public c(d dVar, Object obj) {
            this.lWB = dVar;
            this.data = obj;
        }
    }

    public enum d {
        START,
        lWH,
        FAIL,
        SUCCESS
    }

    public FreeWifiFrontPageUI() {
        com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
        aVar.hIJ = true;
        aVar.hIK = true;
        aVar.hJa = R.g.bfh;
        aVar.hJi = true;
        aVar.hJj = 0.0f;
        this.hIy = aVar.Hg();
    }

    private d axo() {
        try {
            this.lWA.lock();
            d dVar = this.lWB;
            return dVar;
        } finally {
            this.lWA.unlock();
        }
    }

    public final void a(d dVar, Object obj) {
        try {
            this.lWA.lock();
            this.lWB = dVar;
            Message obtain = Message.obtain();
            obtain.obj = new c(dVar, obj);
            this.hgN.sendMessage(obtain);
        } finally {
            this.lWA.unlock();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        switch (this.lUf) {
            case 1:
                this.lWz = new g(this);
                break;
            case 4:
                this.lWz = new f(this);
                break;
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                this.lWz = new h(this);
                this.lWu.setVisibility(0);
                axp();
                break;
            case 32:
                this.lWz = new j(this);
                this.lWu.setVisibility(0);
                break;
            case 33:
                this.lWz = new i(this);
                break;
        }
        w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.onCreate, desc=it goes into connect frontpage. apKey=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.className, this.fEN});
        l.p(com.tencent.mm.plugin.freewifi.model.d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI lWC;

            {
                this.lWC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lWC.goBack();
                return true;
            }
        });
        if (this.lWt != null) {
            this.lWt.dismiss();
        }
        this.lWA = new ReentrantLock();
        this.className = getClass().getSimpleName();
        this.intent = getIntent();
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.lUe = getIntent().getStringExtra("free_wifi_url");
        this.fEN = getIntent().getStringExtra("free_wifi_ap_key");
        this.cGa = getIntent().getIntExtra("free_wifi_source", 1);
        this.fuV = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.lUf = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
        this.fTO = getIntent().getStringExtra("free_wifi_appid");
        this.lWv = getIntent().getStringExtra("free_wifi_head_img_url");
        this.lWw = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.lWx = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.lWy = getIntent().getStringExtra("free_wifi_privacy_url");
        this.lUg = getIntent().getStringExtra("free_wifi_app_nickname");
        w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=%s.initView, desc=Initializing the view. ssid=%s, fullUrl=%s, apKey=%s, source=%d, channel=%d, protocolNumber=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.className, this.ssid, this.lUe, this.fEN, Integer.valueOf(this.cGa), Integer.valueOf(this.fuV), Integer.valueOf(this.lUf), this.fTO, this.lWv, this.lWw, this.lWy});
        this.lWu = findViewById(R.h.cLi);
        this.lWo = (ImageView) findViewById(R.h.bRh);
        this.lWp = (TextView) findViewById(R.h.bRT);
        this.lWq = (TextView) findViewById(R.h.bRG);
        this.lWa = (TextView) findViewById(R.h.bRo);
        this.lWb = (TextView) findViewById(R.h.bRm);
        this.lWc = (TextView) findViewById(R.h.bRn);
        this.lWr = (Button) findViewById(R.h.bEI);
        this.lWr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI lWC;

            {
                this.lWC = r1;
            }

            public final void onClick(View view) {
                this.lWC.axp();
            }
        });
        this.lWs = (Button) findViewById(R.h.cLj);
        this.lWs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI lWC;

            {
                this.lWC = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.lWC.lWy);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.bb.d.b(this.lWC.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (bg.mA(this.ssid)) {
            this.lWq.setText(getString(R.l.emM));
            this.lWr.setVisibility(4);
        }
        qP(getString(R.l.emO));
        a(d.START, null);
    }

    private void axp() {
        l.q(com.tencent.mm.plugin.freewifi.model.d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        d axo = axo();
        w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=User click the connect button and starts the connect wifi process. uiState=%s", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.className, axo.name()});
        if (axo() == d.START || axo() == d.FAIL) {
            w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, class=%s, desc=It makes a decision whether to bind phone number. shoudBindPhone=%b, userPhoneState=%d(0 means no phone number. 1 means having a china phone number. 2 means having a foreign number.)", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent())), this.className, Boolean.valueOf(this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false)), Integer.valueOf(m.awf())});
            if (this.intent.getBooleanExtra("ConstantsFreeWifi.FREE_WIFI_SHOULD_BIND_PHONE", false) && r1 == 1 && this.lUf != 33) {
                com.tencent.mm.ui.base.g.a(this, R.l.emi, R.l.emj, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ FreeWifiFrontPageUI lWC;

                    {
                        this.lWC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        m.ce(this.lWC);
                    }
                }, null);
                return;
            }
            this.lWB = d.lWH;
            axr();
            this.lWz.connect();
        }
    }

    protected final void axq() {
        this.lWa.setVisibility(4);
        if (this.lUf == 31) {
            this.lWr.setVisibility(8);
        } else {
            this.lWr.setVisibility(0);
            this.lWr.setText(R.l.dXx);
        }
        if (!(m.B(getIntent()) != 10 || m.wx(p.gRh.gRz) || m.wx(p.aw(this.uSU.uTo)))) {
            this.lWr.setText(String.format(getString(R.l.emk), new Object[]{p.aw(this.uSU.uTo)}));
        }
        if (!bg.mA(this.lWx)) {
            this.lWq.setText(this.lWx);
        } else if (this.lUf == 33) {
            this.lWq.setText(getString(R.l.dXt) + ": " + this.ssid);
        } else {
            this.lWq.setText(getString(R.l.dXt));
        }
        if (!bg.mA(this.fTO)) {
            if (!bg.mA(this.lUg)) {
                this.lWp.setText(this.lUg);
            }
            if (!bg.mA(this.lWv)) {
                n.GW().a(this.lWv, this.lWo, this.hIy);
            }
        }
        w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
    }

    protected final void axr() {
        this.lWa.setVisibility(4);
        this.lWb.setVisibility(4);
        this.lWc.setVisibility(4);
        this.lWr.setText(R.l.dXu);
        Context context = this.uSU.uTo;
        OnCancelListener anonymousClass6 = new OnCancelListener(this) {
            final /* synthetic */ FreeWifiFrontPageUI lWC;

            {
                this.lWC = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                com.tencent.mm.plugin.freewifi.model.d.a(this.lWC.ssid, 4, this.lWC.getIntent());
                w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.y(this.lWC.getIntent()), Integer.valueOf(m.z(this.lWC.getIntent())), Integer.valueOf(4)});
            }
        };
        View inflate = View.inflate(context, R.i.ddx, null);
        Dialog iVar = new com.tencent.mm.ui.base.i(context, R.m.fot);
        iVar.setCancelable(true);
        iVar.setContentView(inflate);
        iVar.setOnCancelListener(anonymousClass6);
        this.lWt = iVar;
        w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
        this.lWt.show();
    }

    protected final void aT(Object obj) {
        if (obj instanceof a) {
            CharSequence string;
            a aVar = (a) obj;
            w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, desc=Connect failed. errcode=%s", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), aVar.lWh});
            if (this.lWt != null) {
                this.lWt.dismiss();
            }
            this.lWa.setVisibility(0);
            if (m.wx(aVar.text)) {
                if (aVar.lWg == 0) {
                    aVar.lWg = R.l.emm;
                }
                string = getString(aVar.lWg);
            } else {
                string = aVar.text;
            }
            this.lWa.setText(string);
            this.lWa.setVisibility(0);
            this.lWb.setVisibility(0);
            this.lWc.setVisibility(0);
            final String str = getString(R.l.emx) + ": " + aVar.lWh;
            this.lWc.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FreeWifiFrontPageUI lWC;

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_show_detail_error", 1);
                    intent.putExtra("free_wifi_error_ui_error_msg", this.lWC.getString(R.l.eml));
                    intent.putExtra("free_wifi_error_ui_error_msg_detail1", str);
                    intent.setClass(this.lWC, FreeWifiErrorUI.class);
                    this.lWC.startActivity(intent);
                }
            });
            this.lWr.setVisibility(0);
            this.lWr.setText(R.l.emK);
            w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=Protocol.toFail, desc=connect failed.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
        }
    }

    protected final void aU(Object obj) {
        if (obj instanceof b) {
            com.tencent.mm.plugin.freewifi.k.a avZ;
            dy dyVar = ((b) obj).lWF;
            if (!(this.lUf == 31 || this.lWt == null)) {
                this.lWt.dismiss();
            }
            this.lWr.setText(R.l.dXr);
            this.lWr.setClickable(false);
            Intent intent = getIntent();
            intent.putExtra("free_wifi_appid", dyVar.teQ);
            intent.putExtra("free_wifi_app_nickname", dyVar.jOp);
            intent.putExtra("free_wifi_app_username", dyVar.jNj);
            intent.putExtra("free_wifi_signature", dyVar.hAG);
            intent.putExtra("free_wifi_finish_actioncode", dyVar.thK);
            intent.putExtra("free_wifi_finish_url", dyVar.thL);
            intent.putExtra(com.tencent.mm.ui.d.b.uOy, dyVar.lXF);
            if (dyVar.thK == 2) {
                if (bg.mA(dyVar.jNj)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", dyVar.jNj);
                    com.tencent.mm.bb.d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    d.qg();
                    w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
                    avZ = k.avZ();
                    avZ.fEN = this.fEN;
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
                intent.setClass(this, FreeWifiSuccUI.class);
            } else {
                intent.putExtra("free_wifi_qinghuai_url", dyVar.thM);
                intent.setClass(this, FreeWifiSuccWebViewUI.class);
            }
            avZ = k.avZ();
            avZ.fEN = this.fEN;
            avZ.lRA = m.y(intent);
            avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.lSn;
            avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoSuc.name;
            avZ.fRr = m.B(intent);
            avZ.lRB = m.A(intent);
            avZ.result = 0;
            avZ.ksO = "";
            avZ.awb().b(intent, true).awa();
            finish();
            startActivity(intent);
            d.qg();
            w.i("MicroMsg.FreeWifi.FreeWifiFrontPageUI", "sessionKey=%s, step=%d, method=toSuccess, desc=connect succeeded.", new Object[]{m.y(getIntent()), Integer.valueOf(m.z(getIntent()))});
        }
    }

    public void finish() {
        super.finish();
        com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
        avZ.fEN = this.fEN;
        avZ.lRA = m.y(this.intent);
        avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.lSn;
        avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosed.name;
        avZ.fRr = m.B(this.intent);
        avZ.lRB = m.A(this.intent);
        avZ.result = 0;
        avZ.ksO = "";
        avZ.awb().b(this.intent, true).awa();
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
        l.r(com.tencent.mm.plugin.freewifi.model.d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.k.a avZ = k.avZ();
        avZ.fEN = this.fEN;
        avZ.lRA = m.y(this.intent);
        avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.lSn;
        avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.FrontPageUIClosedByGoBack.name;
        avZ.fRr = m.B(this.intent);
        avZ.lRB = m.A(this.intent);
        avZ.result = 0;
        avZ.ksO = "";
        avZ.awb().b(this.intent, true).awa();
        com.tencent.mm.plugin.freewifi.g.imv.i(new Intent(), this);
        finish();
    }

    protected final int Ol() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.freewifi.model.j.awF().release();
    }
}
