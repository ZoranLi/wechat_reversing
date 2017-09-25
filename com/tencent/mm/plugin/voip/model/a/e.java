package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.bkz;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends n<bkz, bla> {
    public e(int i, long j, String str) {
        a aVar = new a();
        aVar.hsm = new bkz();
        aVar.hsn = new bla();
        aVar.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        aVar.hsl = 303;
        aVar.hso = 119;
        aVar.hsp = 1000000119;
        this.gUA = aVar.BE();
        bkz com_tencent_mm_protocal_c_bkz = (bkz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bkz.tvL = i;
        com_tencent_mm_protocal_c_bkz.tvM = j;
        com_tencent_mm_protocal_c_bkz.ukr = str;
        com_tencent_mm_protocal_c_bkz.jOc = 1;
        com_tencent_mm_protocal_c_bkz.ujr = System.currentTimeMillis();
    }

    public final int getType() {
        return 303;
    }

    public final void dl(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bla) bqE()) != null) {
                w.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", new Object[]{Integer.valueOf(((bla) bqE()).tvL), Long.valueOf(((bla) bqE()).tvM), Integer.valueOf(((bla) bqE()).ksW), Integer.valueOf(((bla) bqE()).ukj)});
                return;
            }
            return;
        }
        w.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    }

    public final com.tencent.mm.y.e bqA() {
        return new com.tencent.mm.y.e(this) {
            final /* synthetic */ e rjv;

            {
                this.rjv = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.dI("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                if (i == 0 && i2 == 0 && kVar != null) {
                    bla com_tencent_mm_protocal_c_bla = (bla) this.rjv.bqE();
                    if (com_tencent_mm_protocal_c_bla.tZe.thX == 0 && !d.bpd().riE.bqr()) {
                        d.bpd().a(com_tencent_mm_protocal_c_bla);
                    }
                }
            }
        };
    }
}
