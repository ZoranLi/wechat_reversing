package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.protocal.c.ajd;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class e extends k implements j {
    final b gUA;
    private com.tencent.mm.y.e gUD;

    public e(String str) {
        a aVar = new a();
        aVar.hsm = new ajd();
        aVar.hsn = new aje();
        aVar.uri = "/cgi-bin/micromsg-bin/getroommember";
        aVar.hsl = 377;
        aVar.hso = 184;
        aVar.hsp = 1000000184;
        this.gUA = aVar.BE();
        ((ajd) this.gUA.hsj.hsr).hNe = str;
        w.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 377;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aje com_tencent_mm_protocal_c_aje = (aje) this.gUA.hsk.hsr;
        if (i2 != 0) {
            this.gUD.a(i2, i3, str, this);
            return;
        }
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_aje.teK.size(); i4++) {
            h hVar = new h();
            hVar.username = ((ajc) com_tencent_mm_protocal_c_aje.teK.get(i4)).jNj;
            hVar.hrB = ((ajc) com_tencent_mm_protocal_c_aje.teK.get(i4)).tqb;
            hVar.hrA = ((ajc) com_tencent_mm_protocal_c_aje.teK.get(i4)).tqc;
            hVar.aV(true);
            arrayList.add(hVar);
        }
        n.Bm().z(arrayList);
        this.gUD.a(i2, i3, str, this);
    }
}
