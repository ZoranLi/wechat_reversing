package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aqo extends avp {
    public String jOp;
    public int mtd;
    public int tCS;
    public int tCT;
    public String tEP;
    public String tTL;
    public int tVg;
    public int tVh;
    public int tVi;

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
            aVar.eO(2, this.tVg);
            aVar.eO(3, this.mtd);
            if (this.tTL != null) {
                aVar.e(4, this.tTL);
            }
            if (this.tEP != null) {
                aVar.e(5, this.tEP);
            }
            if (this.jOp != null) {
                aVar.e(6, this.jOp);
            }
            aVar.eO(7, this.tVh);
            aVar.eO(8, this.tCS);
            aVar.eO(9, this.tCT);
            aVar.eO(10, this.tVi);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tVg)) + a.a.a.a.eL(3, this.mtd);
            if (this.tTL != null) {
                r0 += a.a.a.b.b.a.f(4, this.tTL);
            }
            if (this.tEP != null) {
                r0 += a.a.a.b.b.a.f(5, this.tEP);
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(6, this.jOp);
            }
            return (((r0 + a.a.a.a.eL(7, this.tVh)) + a.a.a.a.eL(8, this.tCS)) + a.a.a.a.eL(9, this.tCT)) + a.a.a.a.eL(10, this.tVi);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            aqo com_tencent_mm_protocal_c_aqo = (aqo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aqo.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqo.tVg = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqo.mtd = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqo.tTL = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqo.tEP = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqo.jOp = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqo.tVh = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqo.tCS = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqo.tCT = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqo.tVi = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
