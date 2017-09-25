package com.tencent.mm.plugin.sns.a.a;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.ay;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    private b gUA;
    public e gUD;

    public c(String str, int i, int i2, String str2, int i3) {
        this(str, i, i2, str2, i3, 0, 0, "");
    }

    public c(String str, int i, int i2, String str2, int i3, int i4, int i5, String str3) {
        a aVar = new a();
        aVar.hsm = new ax();
        aVar.hsn = new ay();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/click";
        aVar.uri = "/cgi-bin/mmoc-bin/ad/click";
        aVar.hsl = 1232;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        w.i("MicroMsg.NetSceneAdClick", "NetSceneAdClick clickPos: " + i + " viewId: " + str + " sceneType: " + i2 + " adtype " + i3 + ", clickAction " + i4 + ",source " + i5 + ", descXml " + str2);
        if (!bg.mA(str2)) {
            w.i("MicroMsg.NetSceneAdClick", "descXml: " + str2);
        }
        ax axVar = (ax) this.gUA.hsj.hsr;
        axVar.hTp = i;
        axVar.hTm = str;
        axVar.scene = i2;
        axVar.tek = str2;
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                axVar.bssid = bg.ap(connectionInfo.getBSSID(), "");
                axVar.ssid = bg.ap(connectionInfo.getSSID(), "");
            }
        }
        axVar.tel = System.currentTimeMillis();
        axVar.ten = i3;
        axVar.teo = i4;
        axVar.cGa = i5;
        axVar.tep = str3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 1232;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneAdClick", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gUD.a(i2, i3, str, this);
    }
}
