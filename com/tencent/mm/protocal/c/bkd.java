package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bkd extends avh {
    public int tBz;
    public long tVW;
    public int tVX;
    public long tvM;
    public long ujT;
    public String ujU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tVX);
            aVar.O(3, this.ujT);
            aVar.O(4, this.tvM);
            if (this.ujU != null) {
                aVar.e(5, this.ujU);
            }
            aVar.O(6, this.tVW);
            aVar.eO(7, this.tBz);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.eL(2, this.tVX)) + a.a.a.a.N(3, this.ujT)) + a.a.a.a.N(4, this.tvM);
            if (this.ujU != null) {
                r0 += a.a.a.b.b.a.f(5, this.ujU);
            }
            return (r0 + a.a.a.a.N(6, this.tVW)) + a.a.a.a.eL(7, this.tBz);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bkd com_tencent_mm_protocal_c_bkd = (bkd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkd.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkd.tVX = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkd.ujT = aVar3.xmD.mM();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkd.tvM = aVar3.xmD.mM();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bkd.ujU = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkd.tVW = aVar3.xmD.mM();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bkd.tBz = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
