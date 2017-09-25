package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class akt extends avh {
    public String hAG;
    public String jNn;
    public String leN;
    public String leO;
    public int mtE;
    public String tBx;
    public int tOA;
    public String tOx;
    public String tOy;
    public String tOz;
    public int tcg;
    public String thA;
    public int thB;
    public String thC;
    public String thD;
    public ek thy;
    public String thz;
    public String tlu;
    public String tlv;
    public String tum;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.thy != null) {
                aVar.eQ(2, this.thy.aUk());
                this.thy.a(aVar);
            }
            if (this.thz != null) {
                aVar.e(3, this.thz);
            }
            if (this.thA != null) {
                aVar.e(4, this.thA);
            }
            aVar.eO(5, this.thB);
            if (this.thC != null) {
                aVar.e(6, this.thC);
            }
            if (this.hAG != null) {
                aVar.e(7, this.hAG);
            }
            if (this.jNn != null) {
                aVar.e(8, this.jNn);
            }
            if (this.thD != null) {
                aVar.e(9, this.thD);
            }
            if (this.leO != null) {
                aVar.e(10, this.leO);
            }
            if (this.leN != null) {
                aVar.e(11, this.leN);
            }
            aVar.eO(13, this.tcg);
            aVar.eO(14, this.mtE);
            if (this.tlv != null) {
                aVar.e(15, this.tlv);
            }
            if (this.tlu != null) {
                aVar.e(16, this.tlu);
            }
            if (this.tOx != null) {
                aVar.e(17, this.tOx);
            }
            if (this.tum != null) {
                aVar.e(18, this.tum);
            }
            if (this.tBx != null) {
                aVar.e(19, this.tBx);
            }
            if (this.tOy != null) {
                aVar.e(20, this.tOy);
            }
            if (this.tOz != null) {
                aVar.e(21, this.tOz);
            }
            aVar.eO(22, this.tOA);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.thy != null) {
                r0 += a.a.a.a.eN(2, this.thy.aUk());
            }
            if (this.thz != null) {
                r0 += a.a.a.b.b.a.f(3, this.thz);
            }
            if (this.thA != null) {
                r0 += a.a.a.b.b.a.f(4, this.thA);
            }
            r0 += a.a.a.a.eL(5, this.thB);
            if (this.thC != null) {
                r0 += a.a.a.b.b.a.f(6, this.thC);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(7, this.hAG);
            }
            if (this.jNn != null) {
                r0 += a.a.a.b.b.a.f(8, this.jNn);
            }
            if (this.thD != null) {
                r0 += a.a.a.b.b.a.f(9, this.thD);
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(10, this.leO);
            }
            if (this.leN != null) {
                r0 += a.a.a.b.b.a.f(11, this.leN);
            }
            r0 = (r0 + a.a.a.a.eL(13, this.tcg)) + a.a.a.a.eL(14, this.mtE);
            if (this.tlv != null) {
                r0 += a.a.a.b.b.a.f(15, this.tlv);
            }
            if (this.tlu != null) {
                r0 += a.a.a.b.b.a.f(16, this.tlu);
            }
            if (this.tOx != null) {
                r0 += a.a.a.b.b.a.f(17, this.tOx);
            }
            if (this.tum != null) {
                r0 += a.a.a.b.b.a.f(18, this.tum);
            }
            if (this.tBx != null) {
                r0 += a.a.a.b.b.a.f(19, this.tBx);
            }
            if (this.tOy != null) {
                r0 += a.a.a.b.b.a.f(20, this.tOy);
            }
            if (this.tOz != null) {
                r0 += a.a.a.b.b.a.f(21, this.tOz);
            }
            return r0 + a.a.a.a.eL(22, this.tOA);
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
            akt com_tencent_mm_protocal_c_akt = (akt) objArr[1];
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
                        com_tencent_mm_protocal_c_akt.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new ek();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akt.thy = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akt.thz = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akt.thA = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akt.thB = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akt.thC = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akt.hAG = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_akt.jNn = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_akt.thD = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_akt.leO = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_akt.leN = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_akt.tcg = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_akt.mtE = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_akt.tlv = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_akt.tlu = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_akt.tOx = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_akt.tum = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_akt.tBx = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_akt.tOy = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_akt.tOz = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_akt.tOA = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
