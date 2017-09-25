package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class biz extends avh {
    public avx tIn;
    public int tce;
    public avw tit;
    public String tjU;
    public avx tjY;
    public avw tjZ;
    public int uaK;
    public String uiC;
    public avx uiD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tce);
            if (this.uiC != null) {
                aVar.e(3, this.uiC);
            }
            if (this.tjU != null) {
                aVar.e(4, this.tjU);
            }
            if (this.tIn != null) {
                aVar.eQ(5, this.tIn.aUk());
                this.tIn.a(aVar);
            }
            if (this.uiD != null) {
                aVar.eQ(6, this.uiD.aUk());
                this.uiD.a(aVar);
            }
            if (this.tjY != null) {
                aVar.eQ(7, this.tjY.aUk());
                this.tjY.a(aVar);
            }
            if (this.tjZ != null) {
                aVar.eQ(8, this.tjZ.aUk());
                this.tjZ.a(aVar);
            }
            aVar.eO(9, this.uaK);
            if (this.tit == null) {
                return 0;
            }
            aVar.eQ(10, this.tit.aUk());
            this.tit.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tce);
            if (this.uiC != null) {
                r0 += a.a.a.b.b.a.f(3, this.uiC);
            }
            if (this.tjU != null) {
                r0 += a.a.a.b.b.a.f(4, this.tjU);
            }
            if (this.tIn != null) {
                r0 += a.a.a.a.eN(5, this.tIn.aUk());
            }
            if (this.uiD != null) {
                r0 += a.a.a.a.eN(6, this.uiD.aUk());
            }
            if (this.tjY != null) {
                r0 += a.a.a.a.eN(7, this.tjY.aUk());
            }
            if (this.tjZ != null) {
                r0 += a.a.a.a.eN(8, this.tjZ.aUk());
            }
            r0 += a.a.a.a.eL(9, this.uaK);
            if (this.tit != null) {
                r0 += a.a.a.a.eN(10, this.tit.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            biz com_tencent_mm_protocal_c_biz = (biz) objArr[1];
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
                        com_tencent_mm_protocal_c_biz.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_biz.tce = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_biz.uiC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_biz.tjU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biz.tIn = emVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biz.uiD = emVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biz.tjY = emVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biz.tjZ = emVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_biz.uaK = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biz.tit = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
