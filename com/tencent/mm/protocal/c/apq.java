package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class apq extends avp {
    public String fIA;
    public int fIz;
    public int nvk;
    public String rIf;
    public bmo tUA;
    public bml tUB;
    public bmj tUC;
    public bmm tUD;
    public boolean tUE;
    public LinkedList<String> tUF = new LinkedList();

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
            aVar.eO(2, this.fIz);
            if (this.fIA != null) {
                aVar.e(3, this.fIA);
            }
            if (this.tUA != null) {
                aVar.eQ(4, this.tUA.aUk());
                this.tUA.a(aVar);
            }
            if (this.tUB != null) {
                aVar.eQ(5, this.tUB.aUk());
                this.tUB.a(aVar);
            }
            if (this.tUC != null) {
                aVar.eQ(6, this.tUC.aUk());
                this.tUC.a(aVar);
            }
            if (this.tUD != null) {
                aVar.eQ(7, this.tUD.aUk());
                this.tUD.a(aVar);
            }
            aVar.eO(8, this.nvk);
            aVar.an(9, this.tUE);
            if (this.rIf != null) {
                aVar.e(10, this.rIf);
            }
            aVar.d(11, 1, this.tUF);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.fIz);
            if (this.fIA != null) {
                r0 += a.a.a.b.b.a.f(3, this.fIA);
            }
            if (this.tUA != null) {
                r0 += a.a.a.a.eN(4, this.tUA.aUk());
            }
            if (this.tUB != null) {
                r0 += a.a.a.a.eN(5, this.tUB.aUk());
            }
            if (this.tUC != null) {
                r0 += a.a.a.a.eN(6, this.tUC.aUk());
            }
            if (this.tUD != null) {
                r0 += a.a.a.a.eN(7, this.tUD.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(8, this.nvk)) + (a.a.a.b.b.a.cH(9) + 1);
            if (this.rIf != null) {
                r0 += a.a.a.b.b.a.f(10, this.rIf);
            }
            return r0 + a.a.a.a.c(11, 1, this.tUF);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tUF.clear();
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
            apq com_tencent_mm_protocal_c_apq = (apq) objArr[1];
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
                        com_tencent_mm_protocal_c_apq.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apq.fIz = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_apq.fIA = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bmo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apq.tUA = enVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bml();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apq.tUB = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bmj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apq.tUC = enVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bmm();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apq.tUD = enVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_apq.nvk = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_apq.tUE = aVar3.cib();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_apq.rIf = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_apq.tUF.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
