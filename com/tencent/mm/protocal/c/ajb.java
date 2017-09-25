package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ajb extends avp {
    public int pUD;
    public int tDR;
    public LinkedList<aiw> tDS = new LinkedList();
    public int tNd;
    public int tNe;
    public int tNf;

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
            aVar.eO(2, this.tDR);
            aVar.d(3, 8, this.tDS);
            aVar.eO(4, this.pUD);
            aVar.eO(5, this.tNd);
            aVar.eO(6, this.tNe);
            aVar.eO(7, this.tNf);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + a.a.a.a.eL(2, this.tDR)) + a.a.a.a.c(3, 8, this.tDS)) + a.a.a.a.eL(4, this.pUD)) + a.a.a.a.eL(5, this.tNd)) + a.a.a.a.eL(6, this.tNe)) + a.a.a.a.eL(7, this.tNf);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tDS.clear();
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
            ajb com_tencent_mm_protocal_c_ajb = (ajb) objArr[1];
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
                        com_tencent_mm_protocal_c_ajb.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajb.tDR = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aiw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajb.tDS.add(enVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajb.pUD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajb.tNd = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ajb.tNe = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ajb.tNf = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
