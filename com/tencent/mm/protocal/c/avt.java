package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class avt extends avh {
    public String mvU;
    public String mvV;
    public int ogM;
    public int tZh;
    public int tZi;
    public int tZj;
    public long tZk;
    public String tfU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tfU != null) {
                aVar.e(2, this.tfU);
            }
            aVar.eO(3, this.tZh);
            aVar.eO(4, this.ogM);
            aVar.eO(5, this.tZi);
            if (this.mvV != null) {
                aVar.e(6, this.mvV);
            }
            if (this.mvU != null) {
                aVar.e(7, this.mvU);
            }
            aVar.eO(8, this.tZj);
            aVar.O(9, this.tZk);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(2, this.tfU);
            }
            r0 = ((r0 + a.a.a.a.eL(3, this.tZh)) + a.a.a.a.eL(4, this.ogM)) + a.a.a.a.eL(5, this.tZi);
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(6, this.mvV);
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(7, this.mvU);
            }
            return (r0 + a.a.a.a.eL(8, this.tZj)) + a.a.a.a.N(9, this.tZk);
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
            avt com_tencent_mm_protocal_c_avt = (avt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avt.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avt.tfU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avt.tZh = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avt.ogM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avt.tZi = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avt.mvV = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avt.mvU = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avt.tZj = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avt.tZk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
