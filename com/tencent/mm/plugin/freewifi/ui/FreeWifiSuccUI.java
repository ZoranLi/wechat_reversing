package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.e;

public class FreeWifiSuccUI extends MMActivity implements e {
    private String fKK;
    private String fTO;
    private Button jKT;
    private CheckBox kpA;
    private String lUg;
    private View lXA;
    private TextView lXB;
    private View lXC;
    private TextView lXD;
    private View lXE;
    private int lXF;
    private boolean lXG = false;
    private boolean lXH = false;
    private TextView lXn;
    private int lXu;
    private String lXv;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccUI freeWifiSuccUI) {
        freeWifiSuccUI.axy();
        WifiInfo awu = d.awu();
        a avZ = k.avZ();
        if (awu != null) {
            String macAddress = awu.getMacAddress();
            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                macAddress = m.awe();
            }
            avZ.ssid = m.wy(awu.getSSID());
            avZ.bssid = awu.getBSSID();
            avZ.fEO = macAddress;
        }
        avZ.fEN = m.C(freeWifiSuccUI.getIntent());
        avZ.lRz = freeWifiSuccUI.fTO;
        avZ.lRA = m.y(freeWifiSuccUI.getIntent());
        avZ.lRB = m.A(freeWifiSuccUI.getIntent());
        avZ.lRC = b.BackpageFinished.lSn;
        avZ.lRD = b.BackpageFinished.name;
        avZ.fRr = m.B(freeWifiSuccUI.getIntent());
        avZ.lRE = freeWifiSuccUI.fKK;
        avZ.awb().awa();
        if (freeWifiSuccUI.lXu == 1 && !bg.mA(freeWifiSuccUI.lXv)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.lXv).buildUpon().appendQueryParameter("lang", v.d(freeWifiSuccUI.getSharedPreferences(ab.bIX(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bb.d.b(freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
            w.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fTO = getIntent().getStringExtra("free_wifi_appid");
        this.lUg = getIntent().getStringExtra("free_wifi_app_nickname");
        this.fKK = getIntent().getStringExtra("free_wifi_app_username");
        this.lXu = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.lXv = getIntent().getStringExtra("free_wifi_finish_url");
        this.lXF = getIntent().getIntExtra(com.tencent.mm.ui.d.b.uOy, 0);
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        w.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[]{this.fTO, this.lUg, this.fKK, Integer.valueOf(this.lXu), this.lXv, this.signature});
        WifiInfo awu = d.awu();
        a avZ = k.avZ();
        String macAddress = awu.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = m.awe();
        }
        if (awu != null) {
            avZ.ssid = m.wy(awu.getSSID());
            avZ.bssid = awu.getBSSID();
            avZ.fEO = macAddress;
        }
        avZ.fEN = getIntent().getStringExtra("free_wifi_ap_key");
        avZ.lRz = this.fTO;
        avZ.lRA = m.y(getIntent());
        avZ.lRB = m.A(getIntent());
        avZ.lRC = b.GetBackPage.lSn;
        avZ.lRD = b.GetBackPage.name;
        avZ.fRr = m.B(getIntent());
        avZ.lRE = this.fKK;
        avZ.awb().awa();
    }

    protected void onResume() {
        super.onResume();
        KC();
    }

    public void finish() {
        super.finish();
        axy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        ap.vd().b(1703, this);
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.ddz;
    }

    protected final void KC() {
        zi(R.l.emO);
        kt(false);
        this.lXA = findViewById(R.h.bRM);
        this.lXB = (TextView) findViewById(R.h.bRN);
        this.kpA = (CheckBox) findViewById(R.h.bRK);
        this.lXC = findViewById(R.h.bRH);
        this.lXD = (TextView) findViewById(R.h.bRI);
        this.lXE = findViewById(R.h.bRO);
        this.lXn = (TextView) findViewById(R.h.bRJ);
        this.jKT = (Button) findViewById(R.h.bEJ);
        this.jKT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiSuccUI lXI;

            {
                this.lXI = r1;
            }

            public final void onClick(View view) {
                this.lXI.finish();
                FreeWifiSuccUI.a(this.lXI);
            }
        });
        if (bg.mA(this.fTO) || bg.mA(this.fKK) || bg.mA(this.lUg)) {
            this.lXA.setVisibility(8);
            this.lXC.setVisibility(8);
            this.lXE.setVisibility(8);
        } else if (o.eV(this.fKK) && o.eU(this.fKK)) {
            l.b(d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.lXA.setVisibility(8);
            this.lXC.setVisibility(8);
            this.lXE.setVisibility(0);
            this.lXn.setText(this.lUg);
            this.lXE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FreeWifiSuccUI lXI;

                {
                    this.lXI = r1;
                }

                public final void onClick(View view) {
                    if (!bg.mA(this.lXI.fKK)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", this.lXI.fKK);
                        com.tencent.mm.bb.d.b(this.lXI, "profile", ".ui.ContactInfoUI", intent);
                    }
                }
            });
        } else {
            l.b(d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.lXE.setVisibility(8);
            this.lXA.setVisibility(0);
            if (bg.mA(this.signature)) {
                this.lXC.setVisibility(8);
                findViewById(R.h.bRL).setBackgroundColor(getResources().getColor(R.e.white));
            } else {
                this.lXC.setVisibility(0);
                this.lXD.setText(this.signature);
            }
            this.lXB.setText(getString(R.l.emA, new Object[]{this.lUg}));
            if (this.lXF == 1) {
                this.kpA.setChecked(true);
                this.lXG = true;
            } else {
                this.kpA.setChecked(false);
                this.lXG = false;
            }
            this.kpA.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ FreeWifiSuccUI lXI;

                {
                    this.lXI = r1;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        this.lXI.lXG = true;
                    } else {
                        this.lXI.lXG = false;
                    }
                }
            });
        }
        if (m.B(getIntent()) == 10) {
            final String str = p.gRh.gRz;
            if (!m.wx(str) && !m.wx(p.aw(this.uSU.uTo))) {
                Button button = (Button) findViewById(R.h.bRP);
                button.setText(String.format(getString(R.l.emN), new Object[]{p.aw(this.uSU.uTo)}));
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FreeWifiSuccUI lXI;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        com.tencent.mm.bb.d.b(this.lXI, "profile", ".ui.ContactInfoUI", intent);
                    }
                });
                button.setVisibility(0);
            }
        }
    }

    private void axy() {
        if (!this.lXH) {
            this.lXH = true;
            if (!(!this.lXG || bg.mA(this.fTO) || (o.eV(this.fKK) && o.eU(this.fKK)))) {
                ap.vd().a(1703, this);
                ap.vd().a(new i(this.fTO, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.y(getIntent())), 0);
            }
            l.c(d.awv(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.lXG);
        }
    }
}
