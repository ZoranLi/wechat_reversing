package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bal extends a {
    public int ogX;
    public bz tFg;
    public String tnq;
    public LinkedList<ari> ubv = new LinkedList();
    public qe ubw;
    public LinkedList<aue> ubx = new LinkedList();
    public int uby;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ogX);
            aVar.d(2, 8, this.ubv);
            if (this.ubw != null) {
                aVar.eQ(3, this.ubw.aUk());
                this.ubw.a(aVar);
            }
            if (this.tFg != null) {
                aVar.eQ(4, this.tFg.aUk());
                this.tFg.a(aVar);
            }
            aVar.d(5, 8, this.ubx);
            aVar.eO(6, this.uby);
            if (this.tnq != null) {
                aVar.e(7, this.tnq);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.ogX) + 0) + a.a.a.a.c(2, 8, this.ubv);
            if (this.ubw != null) {
                r0 += a.a.a.a.eN(3, this.ubw.aUk());
            }
            if (this.tFg != null) {
                r0 += a.a.a.a.eN(4, this.tFg.aUk());
            }
            r0 = (r0 + a.a.a.a.c(5, 8, this.ubx)) + a.a.a.a.eL(6, this.uby);
            if (this.tnq != null) {
                return r0 + a.a.a.b.b.a.f(7, this.tnq);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ubv.clear();
            this.ubx.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bal com_tencent_mm_protocal_c_bal = (bal) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_ari;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bal.ogX = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ari = new ari();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ari.a(aVar4, com_tencent_mm_protocal_c_ari, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bal.ubv.add(com_tencent_mm_protocal_c_ari);
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ari = new qe();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ari.a(aVar4, com_tencent_mm_protocal_c_ari, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bal.ubw = com_tencent_mm_protocal_c_ari;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ari = new bz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ari.a(aVar4, com_tencent_mm_protocal_c_ari, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bal.tFg = com_tencent_mm_protocal_c_ari;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_ari = new aue();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ari.a(aVar4, com_tencent_mm_protocal_c_ari, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bal.ubx.add(com_tencent_mm_protocal_c_ari);
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bal.uby = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bal.tnq = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
