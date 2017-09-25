package com.tencent.mm.plugin.freewifi.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.i;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b {
    public Activity activity;
    public String fEN;
    public int fRr;
    public Intent intent;

    class AnonymousClass2 implements e {
        final /* synthetic */ b lVS;
        final /* synthetic */ String lVT;
        final /* synthetic */ String lVU;
        final /* synthetic */ String lVV;
        final /* synthetic */ String lVW;

        AnonymousClass2(b bVar, String str, String str2, String str3, String str4) {
            this.lVS = bVar;
            this.lVT = str;
            this.lVU = str2;
            this.lVV = str3;
            this.lVW = str4;
        }

        public final void a(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo.callback, desc=net request [GetPortalApInfo] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.y(this.lVS.intent), Integer.valueOf(m.z(this.lVS.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
            a avZ;
            if (i == 0 && i2 == 0) {
                avZ = com.tencent.mm.plugin.freewifi.k.avZ();
                avZ.fEN = this.lVS.fEN;
                avZ.lRA = m.y(this.lVS.intent);
                avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.lSn;
                avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.name;
                avZ.fRr = this.lVS.fRr;
                avZ.result = i2;
                avZ.ksO = str;
                avZ.awb().b(this.lVS.intent, false).awa();
                i iVar = (i) kVar;
                String awU = iVar.awU();
                if (m.wx(awU)) {
                    w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=authUrl is empty, so it fails to connect wifi. ", new Object[]{m.y(this.lVS.intent), Integer.valueOf(m.z(this.lVS.intent))});
                    this.lVS.wR(this.lVS.activity.getString(R.l.emu));
                    avZ = com.tencent.mm.plugin.freewifi.k.avZ();
                    avZ.fEN = this.lVS.fEN;
                    avZ.lRA = m.y(this.lVS.intent);
                    avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.lSn;
                    avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.name;
                    avZ.fRr = this.lVS.fRr;
                    avZ.lRB = m.A(this.lVS.intent);
                    avZ.result = -1;
                    avZ.ksO = "31 auth url is empty.";
                    avZ.awb().b(this.lVS.intent, true).awa();
                    return;
                }
                String wz = m.wz(iVar.awV());
                String wz2 = m.wz(this.lVT);
                String wz3 = m.wz(this.lVU);
                StringBuilder stringBuilder = new StringBuilder(awU);
                if (awU.indexOf("?") != -1) {
                    stringBuilder.append("&extend=").append(wz);
                } else {
                    stringBuilder.append("?extend=").append(wz);
                }
                stringBuilder.append("&openId=").append(wz2).append("&tid=").append(wz3).append("&timestamp=").append(m.wz(this.lVV)).append("&sign=").append(m.wz(this.lVW));
                w.i("MicroMsg.FreeWifi.FreeWifiNetCheckUI", "sessionKey=%s, step=%d, method=FreeWifiConnector.protocol31GetPortalApInfo, desc=it gets authentication url. http url=%s ", new Object[]{m.y(this.lVS.intent), Integer.valueOf(m.z(this.lVS.intent)), stringBuilder.toString()});
                this.lVS.intent.putExtra("free_wifi_portal_ap_info_authurl_with_params", stringBuilder.toString());
                this.lVS.intent.setClass(this.lVS.activity, FreeWifiFrontPageUI.class);
                this.lVS.activity.startActivity(this.lVS.intent);
                this.lVS.activity.finish();
                this.lVS.activity.overridePendingTransition(R.a.aRN, R.a.aRM);
                avZ = com.tencent.mm.plugin.freewifi.k.avZ();
                avZ.fEN = this.lVS.fEN;
                avZ.lRA = m.y(this.lVS.intent);
                avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.lSn;
                avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturnDataCheck.name;
                avZ.fRr = this.lVS.fRr;
                avZ.lRB = m.A(this.lVS.intent);
                avZ.result = 0;
                avZ.ksO = "";
                avZ.awb().b(this.lVS.intent, true).awa();
                return;
            }
            avZ = com.tencent.mm.plugin.freewifi.k.avZ();
            avZ.fEN = this.lVS.fEN;
            avZ.lRA = m.y(this.lVS.intent);
            avZ.lRC = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.lSn;
            avZ.lRD = com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn.name;
            avZ.fRr = this.lVS.fRr;
            avZ.lRB = m.A(this.lVS.intent);
            avZ.result = i2;
            avZ.ksO = str;
            avZ.awb().b(this.lVS.intent, true).awa();
            if (m.ca(i, i2) && !m.wx(str)) {
                this.lVS.wR(str + "(" + m.a(m.A(this.lVS.intent), com.tencent.mm.plugin.freewifi.k.b.GetPortalApInfoReturn, i2) + ")");
            } else if (m.wx(str)) {
                this.lVS.wR(this.lVS.activity.getString(R.l.emu));
            } else {
                this.lVS.wR(str);
            }
        }
    }

    public b(Activity activity, String str, int i) {
        if (activity == null || bg.mA(str)) {
            throw new IllegalArgumentException("acitvity or apKey cannot be null.");
        }
        this.activity = activity;
        this.intent = activity.getIntent();
        this.fEN = str;
        this.fRr = i;
    }

    public final void wR(String str) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.setClass(this.activity, FreeWifiErrorUI.class);
        this.activity.finish();
        this.activity.startActivity(intent);
    }
}
