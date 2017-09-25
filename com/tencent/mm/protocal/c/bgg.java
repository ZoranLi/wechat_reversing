package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bgg extends avh {
    public String tkF;
    public String tkL;
    public gt ugB;
    public gt ugC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tkL == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.tkF == null) {
                throw new b("Not all required fields were included: bizchat_id");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tkL != null) {
                    aVar.e(2, this.tkL);
                }
                if (this.tkF != null) {
                    aVar.e(3, this.tkF);
                }
                if (this.ugB != null) {
                    aVar.eQ(4, this.ugB.aUk());
                    this.ugB.a(aVar);
                }
                if (this.ugC == null) {
                    return 0;
                }
                aVar.eQ(5, this.ugC.aUk());
                this.ugC.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tkL != null) {
                r0 += a.a.a.b.b.a.f(2, this.tkL);
            }
            if (this.tkF != null) {
                r0 += a.a.a.b.b.a.f(3, this.tkF);
            }
            if (this.ugB != null) {
                r0 += a.a.a.a.eN(4, this.ugB.aUk());
            }
            if (this.ugC != null) {
                r0 += a.a.a.a.eN(5, this.ugC.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tkL == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.tkF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bgg com_tencent_mm_protocal_c_bgg = (bgg) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bgg.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgg.tkL = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgg.tkF = aVar3.xmD.readString();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new gt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bgg.ugB = emVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new gt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bgg.ugC = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
