package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.freewifi.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;

public class FreeWifiSuccWebViewUI extends WebViewUI implements e {
    private String fKK;
    private int fRr;
    private String fTO;
    private String lUg;
    private boolean lXG = false;
    private int lXu;
    private String lXv;
    private String signature;

    static /* synthetic */ void a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        String str = j.userName;
        if (bg.mA(freeWifiSuccWebViewUI.fKK) || !freeWifiSuccWebViewUI.fKK.equals(str)) {
            freeWifiSuccWebViewUI.lXG = false;
        } else {
            freeWifiSuccWebViewUI.lXG = true;
        }
        if (!(!freeWifiSuccWebViewUI.lXG || bg.mA(freeWifiSuccWebViewUI.fTO) || (o.eV(freeWifiSuccWebViewUI.fKK) && o.eU(freeWifiSuccWebViewUI.fKK)))) {
            ap.vd().a(1703, freeWifiSuccWebViewUI);
            ap.vd().a(new i(freeWifiSuccWebViewUI.fTO, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), m.y(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        l.c(d.awv(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.lXG);
        WifiInfo awu = d.awu();
        a avZ = k.avZ();
        if (awu != null) {
            str = awu.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.awe();
            }
            avZ.ssid = m.wy(awu.getSSID());
            avZ.bssid = awu.getBSSID();
            avZ.fEO = str;
        }
        avZ.fEN = m.C(freeWifiSuccWebViewUI.getIntent());
        avZ.lRz = freeWifiSuccWebViewUI.fTO;
        avZ.lRA = m.y(freeWifiSuccWebViewUI.getIntent());
        avZ.lRB = m.A(freeWifiSuccWebViewUI.getIntent());
        avZ.lRC = b.QinghuaiBackpageFinished.lSn;
        avZ.lRD = b.QinghuaiBackpageFinished.name;
        avZ.fRr = m.B(freeWifiSuccWebViewUI.getIntent());
        avZ.lRE = freeWifiSuccWebViewUI.fKK;
        avZ.awb().awa();
        str = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.lXu == 1 && !bg.mA(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(str).buildUpon().appendQueryParameter("lang", v.d(freeWifiSuccWebViewUI.getSharedPreferences(ab.bIX(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            com.tencent.mm.bb.d.b(freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
            w.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        j.userName = "";
        j.type = 0;
        w.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[]{getIntent().getStringExtra("free_wifi_qinghuai_url")});
        getIntent().putExtra("rawUrl", str);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.fTO = getIntent().getStringExtra("free_wifi_appid");
        this.lUg = getIntent().getStringExtra("free_wifi_app_nickname");
        this.fKK = getIntent().getStringExtra("free_wifi_app_username");
        this.lXu = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.lXv = getIntent().getStringExtra("free_wifi_finish_url");
        this.signature = getIntent().getStringExtra("free_wifi_signature");
        this.fRr = m.B(getIntent());
        if (this.fRr == 10) {
            str = p.gRh.gRz;
            String aw = p.aw(this.uSU.uTo);
            if (!(m.wx(str) || m.wx(aw))) {
                this.lXv = Uri.parse(this.lXv).buildUpon().appendQueryParameter("manufacturer", aw).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        w.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[]{this.fTO, this.lUg, this.fKK, Integer.valueOf(this.lXu), this.lXv, this.signature});
        WifiInfo awu = d.awu();
        a avZ = k.avZ();
        if (awu != null) {
            str = awu.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = m.awe();
            }
            avZ.ssid = m.wy(awu.getSSID());
            avZ.bssid = awu.getBSSID();
            avZ.fEO = str;
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

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(1703, this);
    }

    protected final void axz() {
        super.axz();
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected final void KC() {
        super.KC();
        kt(false);
        a(0, getString(R.l.emz), new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiSuccWebViewUI lXK;

            {
                this.lXK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lXK.finish();
                FreeWifiSuccWebViewUI.a(this.lXK);
                return true;
            }
        }, com.tencent.mm.ui.l.b.uUd);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!getString(R.l.emz).equals((String) menu.getItem(0).getTitle())) {
            a(0, getString(R.l.emz), new OnMenuItemClickListener(this) {
                final /* synthetic */ FreeWifiSuccWebViewUI lXK;

                {
                    this.lXK = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.lXK.finish();
                    FreeWifiSuccWebViewUI.a(this.lXK);
                    return true;
                }
            }, com.tencent.mm.ui.l.b.uUd);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        ap.vd().b(1703, this);
    }
}
