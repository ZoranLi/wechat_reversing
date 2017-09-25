package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class bjz extends avh {
    public String tWt;
    public int trD;
    public int tvL;
    public long tvM;
    public int ujA;
    public int ujB;
    public blj ujn;
    public blj ujo;
    public long ujr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tWt != null) {
                aVar.e(2, this.tWt);
            }
            aVar.eO(3, this.tvL);
            aVar.eO(4, this.ujA);
            if (this.ujn != null) {
                aVar.eQ(5, this.ujn.aUk());
                this.ujn.a(aVar);
            }
            if (this.ujo != null) {
                aVar.eQ(6, this.ujo.aUk());
                this.ujo.a(aVar);
            }
            aVar.O(7, this.tvM);
            aVar.eO(8, this.trD);
            aVar.O(9, this.ujr);
            aVar.eO(10, this.ujB);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tWt != null) {
                r0 += a.a.a.b.b.a.f(2, this.tWt);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tvL)) + a.a.a.a.eL(4, this.ujA);
            if (this.ujn != null) {
                r0 += a.a.a.a.eN(5, this.ujn.aUk());
            }
            if (this.ujo != null) {
                r0 += a.a.a.a.eN(6, this.ujo.aUk());
            }
            return (((r0 + a.a.a.a.N(7, this.tvM)) + a.a.a.a.eL(8, this.trD)) + a.a.a.a.N(9, this.ujr)) + a.a.a.a.eL(10, this.ujB);
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
            bjz com_tencent_mm_protocal_c_bjz = (bjz) objArr[1];
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
                        com_tencent_mm_protocal_c_bjz.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjz.tWt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjz.tvL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjz.ujA = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new blj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjz.ujn = emVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new blj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjz.ujo = emVar;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjz.tvM = aVar3.xmD.mM();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bjz.trD = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bjz.ujr = aVar3.xmD.mM();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bjz.ujB = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
