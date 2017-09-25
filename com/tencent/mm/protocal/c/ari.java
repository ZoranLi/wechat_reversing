package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ari extends a {
    public int jNd;
    public int jOc;
    public String msj;
    public String ohq;
    public String tGj;
    public int tVL;
    public LinkedList<aie> tVM = new LinkedList();
    public int tVN;
    public String tVO;
    public String tVP;
    public int tVQ;
    public String tVR;
    public int tVS;
    public LinkedList<od> tVT = new LinkedList();
    public int tdM;
    public String tvh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tVL);
            aVar.d(2, 8, this.tVM);
            aVar.eO(3, this.jNd);
            aVar.eO(4, this.tVN);
            if (this.tvh != null) {
                aVar.e(5, this.tvh);
            }
            if (this.tGj != null) {
                aVar.e(6, this.tGj);
            }
            if (this.tVO != null) {
                aVar.e(7, this.tVO);
            }
            if (this.tVP != null) {
                aVar.e(8, this.tVP);
            }
            aVar.eO(9, this.jOc);
            if (this.msj != null) {
                aVar.e(10, this.msj);
            }
            if (this.ohq != null) {
                aVar.e(11, this.ohq);
            }
            aVar.eO(12, this.tVQ);
            aVar.eO(13, this.tdM);
            if (this.tVR != null) {
                aVar.e(14, this.tVR);
            }
            aVar.eO(15, this.tVS);
            aVar.d(16, 8, this.tVT);
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.eL(1, this.tVL) + 0) + a.a.a.a.c(2, 8, this.tVM)) + a.a.a.a.eL(3, this.jNd)) + a.a.a.a.eL(4, this.tVN);
            if (this.tvh != null) {
                r0 += a.a.a.b.b.a.f(5, this.tvh);
            }
            if (this.tGj != null) {
                r0 += a.a.a.b.b.a.f(6, this.tGj);
            }
            if (this.tVO != null) {
                r0 += a.a.a.b.b.a.f(7, this.tVO);
            }
            if (this.tVP != null) {
                r0 += a.a.a.b.b.a.f(8, this.tVP);
            }
            r0 += a.a.a.a.eL(9, this.jOc);
            if (this.msj != null) {
                r0 += a.a.a.b.b.a.f(10, this.msj);
            }
            if (this.ohq != null) {
                r0 += a.a.a.b.b.a.f(11, this.ohq);
            }
            r0 = (r0 + a.a.a.a.eL(12, this.tVQ)) + a.a.a.a.eL(13, this.tdM);
            if (this.tVR != null) {
                r0 += a.a.a.b.b.a.f(14, this.tVR);
            }
            return (r0 + a.a.a.a.eL(15, this.tVS)) + a.a.a.a.c(16, 8, this.tVT);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tVM.clear();
            this.tVT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            ari com_tencent_mm_protocal_c_ari = (ari) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_aie;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ari.tVL = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aie = new aie();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aie.a(aVar4, com_tencent_mm_protocal_c_aie, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ari.tVM.add(com_tencent_mm_protocal_c_aie);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ari.jNd = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ari.tVN = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ari.tvh = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ari.tGj = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ari.tVO = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ari.tVP = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ari.jOc = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ari.msj = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ari.ohq = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ari.tVQ = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ari.tdM = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ari.tVR = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ari.tVS = aVar3.xmD.mL();
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aie = new od();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aie.a(aVar4, com_tencent_mm_protocal_c_aie, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ari.tVT.add(com_tencent_mm_protocal_c_aie);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
