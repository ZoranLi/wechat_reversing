package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class arr extends avh {
    public String mvU;
    public String mvV;
    public long tVW;
    public int tVX;
    public String tVY;
    public int tWf;
    public int tWg;
    public int tWh;
    public int trD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mvV != null) {
                aVar.e(2, this.mvV);
            }
            if (this.tVY != null) {
                aVar.e(3, this.tVY);
            }
            aVar.eO(4, this.trD);
            aVar.O(5, this.tVW);
            aVar.eO(6, this.tVX);
            if (this.mvU != null) {
                aVar.e(7, this.mvU);
            }
            aVar.eO(8, this.tWg);
            aVar.eO(9, this.tWf);
            aVar.eO(10, this.tWh);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvV);
            }
            if (this.tVY != null) {
                r0 += a.a.a.b.b.a.f(3, this.tVY);
            }
            r0 = ((r0 + a.a.a.a.eL(4, this.trD)) + a.a.a.a.N(5, this.tVW)) + a.a.a.a.eL(6, this.tVX);
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(7, this.mvU);
            }
            return ((r0 + a.a.a.a.eL(8, this.tWg)) + a.a.a.a.eL(9, this.tWf)) + a.a.a.a.eL(10, this.tWh);
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
            arr com_tencent_mm_protocal_c_arr = (arr) objArr[1];
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
                        com_tencent_mm_protocal_c_arr.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arr.mvV = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arr.tVY = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arr.trD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_arr.tVW = aVar3.xmD.mM();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_arr.tVX = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_arr.mvU = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_arr.tWg = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_arr.tWf = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_arr.tWh = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
