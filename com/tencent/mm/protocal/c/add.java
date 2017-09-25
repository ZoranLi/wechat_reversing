package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class add extends avp {
    public int tEt;
    public LinkedList<blx> tEu = new LinkedList();
    public String tIA;
    public int tIB;
    public String tIC;
    public String tID;
    public String tIE;
    public String tIy;

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
            aVar.eO(2, this.tEt);
            aVar.d(3, 8, this.tEu);
            if (this.tIA != null) {
                aVar.e(4, this.tIA);
            }
            if (this.tIy != null) {
                aVar.e(5, this.tIy);
            }
            aVar.eO(6, this.tIB);
            if (this.tIC != null) {
                aVar.e(7, this.tIC);
            }
            if (this.tID != null) {
                aVar.e(8, this.tID);
            }
            if (this.tIE == null) {
                return 0;
            }
            aVar.e(9, this.tIE);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tEt)) + a.a.a.a.c(3, 8, this.tEu);
            if (this.tIA != null) {
                r0 += a.a.a.b.b.a.f(4, this.tIA);
            }
            if (this.tIy != null) {
                r0 += a.a.a.b.b.a.f(5, this.tIy);
            }
            r0 += a.a.a.a.eL(6, this.tIB);
            if (this.tIC != null) {
                r0 += a.a.a.b.b.a.f(7, this.tIC);
            }
            if (this.tID != null) {
                r0 += a.a.a.b.b.a.f(8, this.tID);
            }
            if (this.tIE != null) {
                r0 += a.a.a.b.b.a.f(9, this.tIE);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tEu.clear();
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
            add com_tencent_mm_protocal_c_add = (add) objArr[1];
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
                        com_tencent_mm_protocal_c_add.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_add.tEt = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new blx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_add.tEu.add(enVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_add.tIA = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_add.tIy = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_add.tIB = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_add.tIC = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_add.tID = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_add.tIE = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
