package com.tencent.mm.plugin.sns.a.a;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bb;
import com.tencent.mm.protocal.c.bc;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private b gUA;
    public e gUD;

    public d(String str, int i, be beVar, int i2, int i3) {
        this(str, i, 1, 0, null, beVar, i2, "", i3);
    }

    public d(String str, int i, int i2, int i3, bb bbVar, be beVar, int i4, String str2, int i5) {
        a aVar = new a();
        aVar.hsm = new bc();
        aVar.hsn = new bd();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
        aVar.hsl = 1231;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bc bcVar = (bc) this.gUA.hsj.hsr;
        bcVar.tey = i3;
        bcVar.type = i2;
        bcVar.scene = i;
        bcVar.hTm = str;
        bcVar.teB = i5;
        if (bbVar != null) {
            bcVar.tez = bbVar;
            w.i("MicroMsg.NetSceneAdExposure", "exposure_info " + bbVar.tew);
        }
        if (beVar != null) {
            bcVar.teA = beVar;
            w.i("MicroMsg.NetSceneAdExposure", "social_info " + beVar.teC + " " + beVar.cbl);
        }
        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                bcVar.bssid = bg.ap(connectionInfo.getBSSID(), "");
                bcVar.ssid = bg.ap(connectionInfo.getSSID(), "");
            }
        }
        bcVar.tel = System.currentTimeMillis();
        bcVar.ten = i4;
        if (str2 != null) {
            bcVar.tek = str2;
        }
        w.i("MicroMsg.NetSceneAdExposure", "##time viewid " + str + " sceneType " + i + " type: " + i2 + " duration " + i3 + " ad_type " + i4 + " exposureCount " + i5 + " descXml:" + str2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 1231;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAdExposure", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bd bdVar = (bd) this.gUA.hsk.hsr;
        w.i("MicroMsg.NetSceneAdExposure", "resp " + bdVar.ret + " msg: " + bdVar.fEr);
        this.gUD.a(i2, i3, str, this);
    }
}
