package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aor extends avh {
    public int mtd;
    public String tTL;
    public mj tTM;
    public mj tTN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tTM == null) {
                throw new b("Not all required fields were included: BigContentInfo");
            } else if (this.tTN == null) {
                throw new b("Not all required fields were included: SmallContentInfo");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tTL != null) {
                    aVar.e(2, this.tTL);
                }
                if (this.tTM != null) {
                    aVar.eQ(3, this.tTM.aUk());
                    this.tTM.a(aVar);
                }
                if (this.tTN != null) {
                    aVar.eQ(4, this.tTN.aUk());
                    this.tTN.a(aVar);
                }
                aVar.eO(5, this.mtd);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tTL != null) {
                r0 += a.a.a.b.b.a.f(2, this.tTL);
            }
            if (this.tTM != null) {
                r0 += a.a.a.a.eN(3, this.tTM.aUk());
            }
            if (this.tTN != null) {
                r0 += a.a.a.a.eN(4, this.tTN.aUk());
            }
            return r0 + a.a.a.a.eL(5, this.mtd);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tTM == null) {
                throw new b("Not all required fields were included: BigContentInfo");
            } else if (this.tTN != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SmallContentInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aor com_tencent_mm_protocal_c_aor = (aor) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aor.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aor.tTL = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new mj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aor.tTM = emVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new mj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aor.tTN = emVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aor.mtd = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
