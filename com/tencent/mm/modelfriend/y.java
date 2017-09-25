package com.tencent.mm.modelfriend;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y extends k implements j {
    private final b gUA;
    private e gUD = null;

    public y(String str, List<String[]> list) {
        int i = 0;
        a aVar = new a();
        aVar.hsm = new ajn();
        aVar.hsn = new ajo();
        aVar.uri = "/cgi-bin/micromsg-bin/listmfriend";
        aVar.hsl = 431;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ajn com_tencent_mm_protocal_c_ajn = (ajn) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ajn.tuo = str;
        com_tencent_mm_protocal_c_ajn.tNm = 0;
        if (list != null) {
            i = list.size();
        }
        com_tencent_mm_protocal_c_ajn.tNk = i;
        com_tencent_mm_protocal_c_ajn.tNn = new LinkedList();
        com_tencent_mm_protocal_c_ajn.tNl = new LinkedList();
        if (list != null) {
            for (String[] strArr : list) {
                if (!bg.mA(strArr[2])) {
                    com_tencent_mm_protocal_c_ajn.tNl.add(new avx().OV(strArr[2]));
                }
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final LinkedList<ajm> FK() {
        LinkedList linkedList = ((ajo) this.gUA.hsk.hsr).tNo;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ajm com_tencent_mm_protocal_c_ajm = (ajm) it.next();
                ap.yY();
                c.xB().eI(com_tencent_mm_protocal_c_ajm.jNj, com_tencent_mm_protocal_c_ajm.tBM);
            }
        }
        return ((ajo) this.gUA.hsk.hsr).tNo;
    }

    public final int getType() {
        return 431;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        final ajo com_tencent_mm_protocal_c_ajo = (ajo) this.gUA.hsk.hsr;
        ap.vL().a(new af.a(this) {
            final /* synthetic */ y hBN;

            public final boolean Bo() {
                return false;
            }

            public final boolean Bn() {
                if (com_tencent_mm_protocal_c_ajo != null && com_tencent_mm_protocal_c_ajo.tNo.size() > 0) {
                    Iterator it = com_tencent_mm_protocal_c_ajo.tNo.iterator();
                    while (it.hasNext()) {
                        ajm com_tencent_mm_protocal_c_ajm = (ajm) it.next();
                        if (com_tencent_mm_protocal_c_ajm.jNB == 1) {
                            h hVar = new h();
                            hVar.username = com_tencent_mm_protocal_c_ajm.jNj;
                            hVar.hrB = com_tencent_mm_protocal_c_ajm.tqb;
                            hVar.hrA = com_tencent_mm_protocal_c_ajm.tqc;
                            hVar.fRW = -1;
                            w.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", hVar.getUsername(), hVar.Bs(), hVar.Bt());
                            hVar.gkq = 3;
                            hVar.aV(true);
                            n.Bm().a(hVar);
                        }
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|onGYNetEnd";
            }
        });
        this.gUD.a(i2, i3, str, this);
    }
}
