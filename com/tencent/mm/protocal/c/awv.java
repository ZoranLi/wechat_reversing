package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class awv extends avp {
    public avw tDW;
    public long tDZ;
    public String tZM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tZM == null) {
                throw new b("Not all required fields were included: SearchResult");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tZM != null) {
                    aVar.e(2, this.tZM);
                }
                if (this.tDW != null) {
                    aVar.eQ(3, this.tDW.aUk());
                    this.tDW.a(aVar);
                }
                aVar.O(4, this.tDZ);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tZM != null) {
                r0 += a.a.a.b.b.a.f(2, this.tZM);
            }
            if (this.tDW != null) {
                r0 += a.a.a.a.eN(3, this.tDW.aUk());
            }
            return r0 + a.a.a.a.N(4, this.tDZ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tZM != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SearchResult");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awv com_tencent_mm_protocal_c_awv = (awv) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awv.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awv.tZM = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awv.tDW = enVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awv.tDZ = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
