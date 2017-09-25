package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.protocal.c.ahr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public int errCode;
    public int errType;
    public String fPf;
    public final com.tencent.mm.y.b gUA;
    private e gUD;
    private Runnable hSV;
    public String kAZ;
    public String naM = "";

    public b(String str) {
        a aVar = new a();
        aVar.hsm = new ahq();
        aVar.hsn = new ahr();
        aVar.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        aVar.hsl = 490;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((ahq) this.gUA.hsj.hsr).tLZ = str;
        w.d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:" + str);
    }

    public final int getType() {
        return 490;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ahr com_tencent_mm_protocal_c_ahr;
        this.errType = i2;
        this.errCode = i3;
        this.fPf = str;
        if (((com.tencent.mm.y.b) pVar).hsk.hsr != null) {
            com_tencent_mm_protocal_c_ahr = (ahr) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        } else {
            com_tencent_mm_protocal_c_ahr = null;
        }
        w.d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if ((i3 == 0 || i3 >= 1000) && com_tencent_mm_protocal_c_ahr != null) {
            this.naM = com_tencent_mm_protocal_c_ahr.tvV;
            w.d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", new Object[]{this.naM});
        }
        if (com_tencent_mm_protocal_c_ahr != null) {
            this.kAZ = com_tencent_mm_protocal_c_ahr.tns;
        }
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
        if (this.hSV != null) {
            this.hSV.run();
        }
    }
}
