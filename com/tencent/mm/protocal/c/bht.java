package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bht extends avh {
    public int mvo;
    public int tgJ;
    public int tgK;
    public int tgL;
    public avw tsk;
    public avx uhf;
    public avx uhg;
    public int uhh;
    public int uhi;
    public int uhj;
    public int uhk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.uhf == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.uhg == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.uhf != null) {
                    aVar.eQ(2, this.uhf.aUk());
                    this.uhf.a(aVar);
                }
                if (this.uhg != null) {
                    aVar.eQ(3, this.uhg.aUk());
                    this.uhg.a(aVar);
                }
                aVar.eO(4, this.tgJ);
                aVar.eO(5, this.tgK);
                aVar.eO(6, this.tgL);
                if (this.tsk != null) {
                    aVar.eQ(7, this.tsk.aUk());
                    this.tsk.a(aVar);
                }
                aVar.eO(8, this.mvo);
                aVar.eO(9, this.uhh);
                aVar.eO(10, this.uhi);
                aVar.eO(11, this.uhj);
                aVar.eO(12, this.uhk);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.uhf != null) {
                r0 += a.a.a.a.eN(2, this.uhf.aUk());
            }
            if (this.uhg != null) {
                r0 += a.a.a.a.eN(3, this.uhg.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(4, this.tgJ)) + a.a.a.a.eL(5, this.tgK)) + a.a.a.a.eL(6, this.tgL);
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(7, this.tsk.aUk());
            }
            return ((((r0 + a.a.a.a.eL(8, this.mvo)) + a.a.a.a.eL(9, this.uhh)) + a.a.a.a.eL(10, this.uhi)) + a.a.a.a.eL(11, this.uhj)) + a.a.a.a.eL(12, this.uhk);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uhf == null) {
                throw new b("Not all required fields were included: ClientMediaId");
            } else if (this.uhg == null) {
                throw new b("Not all required fields were included: DataMD5");
            } else if (this.tsk != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bht com_tencent_mm_protocal_c_bht = (bht) objArr[1];
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
                        com_tencent_mm_protocal_c_bht.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.uhf = emVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.uhg = emVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bht.tgJ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bht.tgK = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bht.tgL = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bht.tsk = emVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bht.mvo = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bht.uhh = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bht.uhi = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bht.uhj = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bht.uhk = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
