package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.w;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI extends FreeWifiActivateStateUI {
    private String lRc;
    private int lVp;
    private boolean lVq;

    protected abstract String axi();

    public void onCreate(Bundle bundle) {
        this.lVp = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.lRc = getIntent().getStringExtra("free_wifi_passowrd");
        this.lVq = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 1, getIntent());
        w.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void KC() {
        super.KC();
        this.lVv.setVisibility(0);
        qP(axi());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        w.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
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
            w.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
            return;
        }
        this.lVy = true;
        axk();
        d.d(this.ssid, this.lRc, this.lVp, this.lVq);
    }

    protected int axh() {
        if (!d.wG(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
