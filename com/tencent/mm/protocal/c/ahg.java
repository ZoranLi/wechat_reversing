package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ahg extends avp {
    public String hAG;
    public String muS;
    public LinkedList<awh> tBL = new LinkedList();
    public agn tLL;
    public String tLN;
    public String tLO;
    public String tLP;
    public int tLQ;
    public String tch;
    public String tcu;
    public String tee;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            if (this.tLL != null) {
                aVar.eQ(2, this.tLL.aUk());
                this.tLL.a(aVar);
            }
            if (this.tLO != null) {
                aVar.e(3, this.tLO);
            }
            aVar.d(4, 8, this.tBL);
            if (this.muS != null) {
                aVar.e(5, this.muS);
            }
            if (this.tee != null) {
                aVar.e(6, this.tee);
            }
            if (this.tcu != null) {
                aVar.e(7, this.tcu);
            }
            if (this.tch != null) {
                aVar.e(8, this.tch);
            }
            if (this.tLP != null) {
                aVar.e(9, this.tLP);
            }
            aVar.eO(10, this.tLQ);
            if (this.tLN != null) {
                aVar.e(11, this.tLN);
            }
            if (this.hAG == null) {
                return 0;
            }
            aVar.e(12, this.hAG);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tLL != null) {
                r0 += a.a.a.a.eN(2, this.tLL.aUk());
            }
            if (this.tLO != null) {
                r0 += a.a.a.b.b.a.f(3, this.tLO);
            }
            r0 += a.a.a.a.c(4, 8, this.tBL);
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(5, this.muS);
            }
            if (this.tee != null) {
                r0 += a.a.a.b.b.a.f(6, this.tee);
            }
            if (this.tcu != null) {
                r0 += a.a.a.b.b.a.f(7, this.tcu);
            }
            if (this.tch != null) {
                r0 += a.a.a.b.b.a.f(8, this.tch);
            }
            if (this.tLP != null) {
                r0 += a.a.a.b.b.a.f(9, this.tLP);
            }
            r0 += a.a.a.a.eL(10, this.tLQ);
            if (this.tLN != null) {
                r0 += a.a.a.b.b.a.f(11, this.tLN);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(12, this.hAG);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tBL.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ahg com_tencent_mm_protocal_c_ahg = (ahg) objArr[1];
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
                        com_tencent_mm_protocal_c_ahg.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new agn();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.tLL = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahg.tLO = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new awh();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahg.tBL.add(enVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahg.muS = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ahg.tee = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ahg.tcu = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ahg.tch = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ahg.tLP = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ahg.tLQ = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ahg.tLN = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ahg.hAG = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
