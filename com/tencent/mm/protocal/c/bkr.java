package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bkr extends avh {
    public String mvU;
    public int tVX;
    public String tWt;
    public int tvL;
    public long tvM;
    public long ujr;
    public blr uki;
    public int ukj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.uki == null) {
                throw new b("Not all required fields were included: ReportData");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tWt != null) {
                aVar.e(2, this.tWt);
            }
            aVar.eO(3, this.tvL);
            aVar.O(4, this.tvM);
            if (this.mvU != null) {
                aVar.e(6, this.mvU);
            }
            if (this.uki != null) {
                aVar.eQ(8, this.uki.aUk());
                this.uki.a(aVar);
            }
            aVar.eO(9, this.ukj);
            aVar.O(10, this.ujr);
            aVar.eO(11, this.tVX);
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
            r0 = (r0 + a.a.a.a.eL(3, this.tvL)) + a.a.a.a.N(4, this.tvM);
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(6, this.mvU);
            }
            if (this.uki != null) {
                r0 += a.a.a.a.eN(8, this.uki.aUk());
            }
            return ((r0 + a.a.a.a.eL(9, this.ukj)) + a.a.a.a.N(10, this.ujr)) + a.a.a.a.eL(11, this.tVX);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uki != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReportData");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bkr com_tencent_mm_protocal_c_bkr = (bkr) objArr[1];
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
                        com_tencent_mm_protocal_c_bkr.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bkr.tWt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bkr.tvL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bkr.tvM = aVar3.xmD.mM();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bkr.mvU = aVar3.xmD.readString();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new blr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bkr.uki = emVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bkr.ukj = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bkr.ujr = aVar3.xmD.mM();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bkr.tVX = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
