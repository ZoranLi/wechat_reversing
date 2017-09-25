package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bco extends avp {
    public int jOc;
    public int tQc;
    public LinkedList<bax> tQd = new LinkedList();
    public String teW;
    public int tgJ;
    public int tgK;
    public long tmx;
    public bax udE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.udE == null) {
                throw new b("Not all required fields were included: BufferUrl");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(2, this.tgK);
                aVar.eO(3, this.tgJ);
                if (this.teW != null) {
                    aVar.e(4, this.teW);
                }
                if (this.udE != null) {
                    aVar.eQ(5, this.udE.aUk());
                    this.udE.a(aVar);
                }
                aVar.eO(6, this.tQc);
                aVar.d(7, 8, this.tQd);
                aVar.O(8, this.tmx);
                aVar.eO(9, this.jOc);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tgK)) + a.a.a.a.eL(3, this.tgJ);
            if (this.teW != null) {
                r0 += a.a.a.b.b.a.f(4, this.teW);
            }
            if (this.udE != null) {
                r0 += a.a.a.a.eN(5, this.udE.aUk());
            }
            return (((r0 + a.a.a.a.eL(6, this.tQc)) + a.a.a.a.c(7, 8, this.tQd)) + a.a.a.a.N(8, this.tmx)) + a.a.a.a.eL(9, this.jOc);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tQd.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.udE != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BufferUrl");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bco com_tencent_mm_protocal_c_bco = (bco) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bco.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bco.tgK = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bco.tgJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bco.teW = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bax();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bco.udE = enVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bco.tQc = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bax();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bco.tQd.add(enVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bco.tmx = aVar3.xmD.mM();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bco.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
