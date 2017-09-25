package com.tencent.mm.modelmulti;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.afo;
import com.tencent.mm.protocal.c.afq;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.List;

public final class e extends k implements j {
    private com.tencent.mm.y.e gUD;
    public final b hKp;

    public e(List<afo> list, long j, afq com_tencent_mm_protocal_c_afq) {
        a aVar = new a();
        aVar.hsm = new uy();
        aVar.hsn = new uz();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        this.hKp = aVar.BE();
        uy uyVar = (uy) this.hKp.hsj.hsr;
        uyVar.tCx.addAll(list);
        uyVar.tCA = j;
        uyVar.tCz = com_tencent_mm_protocal_c_afq;
        w.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", Integer.valueOf(uyVar.tCx.size()));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.gUD.a(i2, i3, str, this);
        uy uyVar = (uy) this.hKp.hsj.hsr;
        afo com_tencent_mm_protocal_c_afo = (afo) uyVar.tCx.get(0);
        afq com_tencent_mm_protocal_c_afq = uyVar.tCz;
        uz uzVar = (uz) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            if (uzVar.result != 0) {
                g.oUh.i(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), com_tencent_mm_protocal_c_afo.mry, Integer.valueOf(com_tencent_mm_protocal_c_afo.major), Integer.valueOf(com_tencent_mm_protocal_c_afo.minor), String.valueOf(com_tencent_mm_protocal_c_afq.latitude), String.valueOf(com_tencent_mm_protocal_c_afq.longitude), Integer.valueOf(2), Integer.valueOf(uzVar.result));
            }
            w.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            return;
        }
        g.oUh.i(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), com_tencent_mm_protocal_c_afo.mry, Integer.valueOf(com_tencent_mm_protocal_c_afo.major), Integer.valueOf(com_tencent_mm_protocal_c_afo.minor), String.valueOf(com_tencent_mm_protocal_c_afq.latitude), String.valueOf(com_tencent_mm_protocal_c_afq.longitude), Integer.valueOf(1), Integer.valueOf(uzVar.result));
        w.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
    }

    public final int getType() {
        return 1708;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }
}
