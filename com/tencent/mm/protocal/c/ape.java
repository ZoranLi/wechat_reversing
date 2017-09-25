package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ape extends avh {
    public String msm;
    public String mtb;
    public String muS;
    public String tBn;
    public String tUi;
    public String tUj;
    public String tUk;
    public String tUl;
    public String tUm;
    public at tnu;
    public String trf;
    public String trg;
    public String trh;
    public String tri;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            if (this.tUi != null) {
                aVar.e(3, this.tUi);
            }
            if (this.tBn != null) {
                aVar.e(4, this.tBn);
            }
            if (this.trf != null) {
                aVar.e(5, this.trf);
            }
            if (this.tUj != null) {
                aVar.e(6, this.tUj);
            }
            if (this.trg != null) {
                aVar.e(7, this.trg);
            }
            if (this.trh != null) {
                aVar.e(8, this.trh);
            }
            if (this.tri != null) {
                aVar.e(9, this.tri);
            }
            if (this.tUk != null) {
                aVar.e(10, this.tUk);
            }
            if (this.tnu != null) {
                aVar.eQ(11, this.tnu.aUk());
                this.tnu.a(aVar);
            }
            if (this.tUl != null) {
                aVar.e(12, this.tUl);
            }
            if (this.msm != null) {
                aVar.e(13, this.msm);
            }
            if (this.muS != null) {
                aVar.e(14, this.muS);
            }
            if (this.tUm == null) {
                return 0;
            }
            aVar.e(15, this.tUm);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            if (this.tUi != null) {
                r0 += a.a.a.b.b.a.f(3, this.tUi);
            }
            if (this.tBn != null) {
                r0 += a.a.a.b.b.a.f(4, this.tBn);
            }
            if (this.trf != null) {
                r0 += a.a.a.b.b.a.f(5, this.trf);
            }
            if (this.tUj != null) {
                r0 += a.a.a.b.b.a.f(6, this.tUj);
            }
            if (this.trg != null) {
                r0 += a.a.a.b.b.a.f(7, this.trg);
            }
            if (this.trh != null) {
                r0 += a.a.a.b.b.a.f(8, this.trh);
            }
            if (this.tri != null) {
                r0 += a.a.a.b.b.a.f(9, this.tri);
            }
            if (this.tUk != null) {
                r0 += a.a.a.b.b.a.f(10, this.tUk);
            }
            if (this.tnu != null) {
                r0 += a.a.a.a.eN(11, this.tnu.aUk());
            }
            if (this.tUl != null) {
                r0 += a.a.a.b.b.a.f(12, this.tUl);
            }
            if (this.msm != null) {
                r0 += a.a.a.b.b.a.f(13, this.msm);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(14, this.muS);
            }
            if (this.tUm != null) {
                r0 += a.a.a.b.b.a.f(15, this.tUm);
            }
            return r0;
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
            ape com_tencent_mm_protocal_c_ape = (ape) objArr[1];
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
                        com_tencent_mm_protocal_c_ape.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ape.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ape.tUi = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ape.tBn = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ape.trf = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ape.tUj = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ape.trg = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ape.trh = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ape.tri = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ape.tUk = aVar3.xmD.readString();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ape.tnu = emVar;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ape.tUl = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ape.msm = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ape.muS = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ape.tUm = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
