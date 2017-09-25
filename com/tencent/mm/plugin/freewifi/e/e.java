package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.sdk.platformtools.w;

public class e {
    protected String appId = this.intent.getStringExtra("free_wifi_appid");
    protected int cGa = this.intent.getIntExtra("free_wifi_source", 1);
    protected String fEN = this.intent.getStringExtra("free_wifi_ap_key");
    protected int fuV = this.intent.getIntExtra("free_wifi_channel_id", 0);
    protected final Intent intent;
    protected FreeWifiFrontPageUI lUd;
    protected String lUe = this.intent.getStringExtra("free_wifi_url");
    protected int lUf = this.intent.getIntExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 0);
    protected String lUg = this.intent.getStringExtra("free_wifi_app_nickname");
    protected String ssid = this.intent.getStringExtra("free_wifi_ssid");

    public e(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        this.lUd = freeWifiFrontPageUI;
        this.intent = freeWifiFrontPageUI.getIntent();
        w.i("MicroMsg.FreeWifi.ProtocolBase", "sessionKey=%s, step=%d, desc=Data retrieved. ssid=%s, fullUrl=%s, apKey=%s, source=%s, channelId=%d, appid=%s, appNickName=%s, protocolNumber=%d", new Object[]{m.y(this.intent), Integer.valueOf(m.z(this.intent)), this.ssid, this.lUe, this.fEN, Integer.valueOf(this.cGa), Integer.valueOf(this.fuV), this.appId, this.lUg, Integer.valueOf(this.lUf)});
    }
}
