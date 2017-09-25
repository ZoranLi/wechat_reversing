package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.w;

@Deprecated
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String lRc;
    private int lVp;
    private boolean lVq;

    protected abstract String axi();

    public void onCreate(Bundle bundle) {
        this.lVp = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.lRc = getIntent().getStringExtra("free_wifi_passowrd");
        this.lVq = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        w.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void KC() {
        super.KC();
        qP(axi());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        w.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.wG(this.ssid)) {
            axl();
            this.lVy = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void Tq() {
        axg();
    }

    protected final void axg() {
        if (this.lVy) {
            w.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.lVy = true;
        axk();
        int d = d.d(this.ssid, this.lRc, this.lVp, this.lVq);
        a avZ = k.avZ();
        avZ.ssid = this.ssid;
        avZ.fEN = this.fEN;
        avZ.lRA = m.y(getIntent());
        avZ.lRB = m.A(getIntent());
        avZ.lRC = b.AddNetwork.lSn;
        avZ.lRD = b.AddNetwork.name;
        avZ.result = d;
        avZ.fRr = m.B(getIntent());
        avZ.lRz = this.fTO;
        avZ.lRE = this.fKK;
        avZ.awb().awa();
    }

    protected int axh() {
        if (!d.wG(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
