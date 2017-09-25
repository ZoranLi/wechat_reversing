package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bv extends a {
    public int mtd;
    public int ogM;
    public long tfk;
    public int tfl;
    public avx tfm;
    public int tfn;
    public avx tfo;
    public int tfp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tfm == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.tfo == null) {
                throw new b("Not all required fields were included: DigestContent");
            } else {
                if (this.tfm != null) {
                    aVar.eQ(1, this.tfm.aUk());
                    this.tfm.a(aVar);
                }
                aVar.O(2, this.tfk);
                aVar.eO(3, this.tfl);
                aVar.eO(4, this.ogM);
                aVar.eO(5, this.tfn);
                if (this.tfo != null) {
                    aVar.eQ(6, this.tfo.aUk());
                    this.tfo.a(aVar);
                }
                aVar.eO(7, this.tfp);
                aVar.eO(8, this.mtd);
                return 0;
            }
        } else if (i == 1) {
            if (this.tfm != null) {
                r0 = a.a.a.a.eN(1, this.tfm.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.N(2, this.tfk)) + a.a.a.a.eL(3, this.tfl)) + a.a.a.a.eL(4, this.ogM)) + a.a.a.a.eL(5, this.tfn);
            if (this.tfo != null) {
                r0 += a.a.a.a.eN(6, this.tfo.aUk());
            }
            return (r0 + a.a.a.a.eL(7, this.tfp)) + a.a.a.a.eL(8, this.mtd);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tfm == null) {
                throw new b("Not all required fields were included: ChatRoomId");
            } else if (this.tfo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DigestContent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bv bvVar = (bv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        bvVar.tfm = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    bvVar.tfk = aVar3.xmD.mM();
                    return 0;
                case 3:
                    bvVar.tfl = aVar3.xmD.mL();
                    return 0;
                case 4:
                    bvVar.ogM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    bvVar.tfn = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        bvVar.tfo = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 7:
                    bvVar.tfp = aVar3.xmD.mL();
                    return 0;
                case 8:
                    bvVar.mtd = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
