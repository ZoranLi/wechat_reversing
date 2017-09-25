package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aar extends avp {
    public int tGA;
    public avw tGB;
    public String tGC;
    public String tGD;
    public String tGE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tGB == null) {
                throw new b("Not all required fields were included: QRCode");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tGB != null) {
                    aVar.eQ(2, this.tGB.aUk());
                    this.tGB.a(aVar);
                }
                aVar.eO(5, this.tGA);
                if (this.tGC != null) {
                    aVar.e(6, this.tGC);
                }
                if (this.tGD != null) {
                    aVar.e(7, this.tGD);
                }
                if (this.tGE == null) {
                    return 0;
                }
                aVar.e(8, this.tGE);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tGB != null) {
                r0 += a.a.a.a.eN(2, this.tGB.aUk());
            }
            r0 += a.a.a.a.eL(5, this.tGA);
            if (this.tGC != null) {
                r0 += a.a.a.b.b.a.f(6, this.tGC);
            }
            if (this.tGD != null) {
                r0 += a.a.a.b.b.a.f(7, this.tGD);
            }
            if (this.tGE != null) {
                r0 += a.a.a.b.b.a.f(8, this.tGE);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tGB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: QRCode");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aar com_tencent_mm_protocal_c_aar = (aar) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aar.tGB = enVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aar.tGA = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aar.tGC = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aar.tGD = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aar.tGE = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
