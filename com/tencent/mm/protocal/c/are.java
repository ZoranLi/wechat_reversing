package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class are extends avp {
    public int tFi;
    public LinkedList<qe> tVB = new LinkedList();
    public LinkedList<ar> tVC = new LinkedList();
    public int tVD;
    public String tnq;
    public int tnr;
    public String tns;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(2, this.tFi);
            aVar.d(3, 8, this.tVB);
            if (this.tnq != null) {
                aVar.e(4, this.tnq);
            }
            aVar.eO(5, this.tnr);
            if (this.tns != null) {
                aVar.e(6, this.tns);
            }
            aVar.d(7, 8, this.tVC);
            aVar.eO(8, this.tVD);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tFi)) + a.a.a.a.c(3, 8, this.tVB);
            if (this.tnq != null) {
                r0 += a.a.a.b.b.a.f(4, this.tnq);
            }
            r0 += a.a.a.a.eL(5, this.tnr);
            if (this.tns != null) {
                r0 += a.a.a.b.b.a.f(6, this.tns);
            }
            return (r0 + a.a.a.a.c(7, 8, this.tVC)) + a.a.a.a.eL(8, this.tVD);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tVB.clear();
            this.tVC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            are com_tencent_mm_protocal_c_are = (are) objArr[1];
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
                        com_tencent_mm_protocal_c_are.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_are.tFi = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new qe();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_are.tVB.add(enVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_are.tnq = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_are.tnr = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_are.tns = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new ar();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_are.tVC.add(enVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_are.tVD = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
