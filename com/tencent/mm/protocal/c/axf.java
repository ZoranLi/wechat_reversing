package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class axf extends avp {
    public int tFZ;
    public int tNa;
    public avw tZG;
    public int tZT;
    public LinkedList<axg> tZU = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tZG == null) {
                throw new b("Not all required fields were included: ResBuf");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(2, this.tZT);
                aVar.d(3, 8, this.tZU);
                aVar.eO(4, this.tNa);
                aVar.eO(5, this.tFZ);
                if (this.tZG == null) {
                    return 0;
                }
                aVar.eQ(6, this.tZG.aUk());
                this.tZG.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.eL(2, this.tZT)) + a.a.a.a.c(3, 8, this.tZU)) + a.a.a.a.eL(4, this.tNa)) + a.a.a.a.eL(5, this.tFZ);
            if (this.tZG != null) {
                r0 += a.a.a.a.eN(6, this.tZG.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tZU.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tZG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ResBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axf com_tencent_mm_protocal_c_axf = (axf) objArr[1];
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
                        com_tencent_mm_protocal_c_axf.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axf.tZT = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new axg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axf.tZU.add(enVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axf.tNa = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_axf.tFZ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axf.tZG = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
