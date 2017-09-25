package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ano extends avp {
    public avw tSq;
    public avw tSr;
    public int tSs;
    public int tSt;
    public LinkedList<lu> tSu = new LinkedList();
    public int tcG;
    public int tlZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tSq == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.tSr == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tSq != null) {
                    aVar.eQ(2, this.tSq.aUk());
                    this.tSq.a(aVar);
                }
                if (this.tSr != null) {
                    aVar.eQ(3, this.tSr.aUk());
                    this.tSr.a(aVar);
                }
                aVar.eO(4, this.tlZ);
                aVar.eO(5, this.tSs);
                aVar.eO(6, this.tSt);
                aVar.d(7, 8, this.tSu);
                aVar.eO(8, this.tcG);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tSq != null) {
                r0 += a.a.a.a.eN(2, this.tSq.aUk());
            }
            if (this.tSr != null) {
                r0 += a.a.a.a.eN(3, this.tSr.aUk());
            }
            return ((((r0 + a.a.a.a.eL(4, this.tlZ)) + a.a.a.a.eL(5, this.tSs)) + a.a.a.a.eL(6, this.tSt)) + a.a.a.a.c(7, 8, this.tSu)) + a.a.a.a.eL(8, this.tcG);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tSu.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tSq == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.tSr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ano com_tencent_mm_protocal_c_ano = (ano) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ano.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ano.tSq = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ano.tSr = enVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ano.tlZ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ano.tSs = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ano.tSt = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new lu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ano.tSu.add(enVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ano.tcG = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
