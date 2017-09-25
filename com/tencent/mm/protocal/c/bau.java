package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class bau extends a {
    public int jOc;
    public int ogM;
    public String opI;
    public String tWt;
    public int tfW;
    public String tvK;
    public String ubH;
    public String ubI;
    public int ubJ;
    public int ubK;
    public int ubL;
    public long ubM;
    public long ubN;
    public avw ubO;
    public int ubP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tWt != null) {
                aVar.e(1, this.tWt);
            }
            if (this.tvK != null) {
                aVar.e(2, this.tvK);
            }
            if (this.ubH != null) {
                aVar.e(3, this.ubH);
            }
            if (this.ubI != null) {
                aVar.e(4, this.ubI);
            }
            aVar.eO(5, this.jOc);
            aVar.eO(6, this.tfW);
            aVar.eO(7, this.ogM);
            if (this.opI != null) {
                aVar.e(8, this.opI);
            }
            aVar.eO(9, this.ubJ);
            aVar.eO(10, this.ubK);
            aVar.eO(11, this.ubL);
            aVar.O(12, this.ubM);
            aVar.O(13, this.ubN);
            if (this.ubO != null) {
                aVar.eQ(14, this.ubO.aUk());
                this.ubO.a(aVar);
            }
            aVar.eO(15, this.ubP);
            return 0;
        } else if (i == 1) {
            if (this.tWt != null) {
                r0 = a.a.a.b.b.a.f(1, this.tWt) + 0;
            } else {
                r0 = 0;
            }
            if (this.tvK != null) {
                r0 += a.a.a.b.b.a.f(2, this.tvK);
            }
            if (this.ubH != null) {
                r0 += a.a.a.b.b.a.f(3, this.ubH);
            }
            if (this.ubI != null) {
                r0 += a.a.a.b.b.a.f(4, this.ubI);
            }
            r0 = ((r0 + a.a.a.a.eL(5, this.jOc)) + a.a.a.a.eL(6, this.tfW)) + a.a.a.a.eL(7, this.ogM);
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(8, this.opI);
            }
            r0 = ((((r0 + a.a.a.a.eL(9, this.ubJ)) + a.a.a.a.eL(10, this.ubK)) + a.a.a.a.eL(11, this.ubL)) + a.a.a.a.N(12, this.ubM)) + a.a.a.a.N(13, this.ubN);
            if (this.ubO != null) {
                r0 += a.a.a.a.eN(14, this.ubO.aUk());
            }
            return r0 + a.a.a.a.eL(15, this.ubP);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bau com_tencent_mm_protocal_c_bau = (bau) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bau.tWt = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bau.tvK = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bau.ubH = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bau.ubI = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bau.jOc = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bau.tfW = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bau.ogM = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bau.opI = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bau.ubJ = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bau.ubK = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bau.ubL = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bau.ubM = aVar3.xmD.mM();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bau.ubN = aVar3.xmD.mM();
                    return 0;
                case 14:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avw = new avw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bau.ubO = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bau.ubP = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
