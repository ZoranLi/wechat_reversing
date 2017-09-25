package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public final class h extends k implements j {
    private e gUD;
    public final b hKp;

    public h(List<afo> list, String str) {
        a aVar = new a();
        aVar.hsm = new uw();
        aVar.hsn = new ux();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
        aVar.hsl = 1704;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hKp = aVar.BE();
        uw uwVar = (uw) this.hKp.hsj.hsr;
        uwVar.tCx.addAll(list);
        uwVar.fTO = str;
        w.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", new Object[]{Integer.valueOf(uwVar.tCx.size())});
    }

    public final int getType() {
        return 1704;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
        } else {
            w.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
        }
        this.gUD.a(i2, i3, str, this);
    }
}
