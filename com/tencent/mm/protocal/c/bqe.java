package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bqe extends a {
    public int fWL;
    public String fWM;
    public int jOc;
    public String jgo;
    public int jgt;
    public int lfd;
    public String mtb;
    public int oTD;
    public int oTE;
    public int rVD;
    public int uod;
    public String uoo;
    public String uop;
    public String uoq;
    public String uor;
    public int uos;
    public String uot;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jOc);
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            if (this.uoo != null) {
                aVar.e(3, this.uoo);
            }
            aVar.eO(4, this.oTD);
            aVar.eO(5, this.lfd);
            aVar.eO(6, this.oTE);
            if (this.uop != null) {
                aVar.e(7, this.uop);
            }
            aVar.eO(8, this.uod);
            if (this.uoq != null) {
                aVar.e(9, this.uoq);
            }
            if (this.uor != null) {
                aVar.e(10, this.uor);
            }
            aVar.eO(11, this.rVD);
            aVar.eO(12, this.uos);
            if (this.uot != null) {
                aVar.e(13, this.uot);
            }
            if (this.jgo != null) {
                aVar.e(14, this.jgo);
            }
            aVar.eO(15, this.fWL);
            if (this.fWM != null) {
                aVar.e(16, this.fWM);
            }
            aVar.eO(17, this.jgt);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jOc) + 0;
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            if (this.uoo != null) {
                r0 += a.a.a.b.b.a.f(3, this.uoo);
            }
            r0 = ((r0 + a.a.a.a.eL(4, this.oTD)) + a.a.a.a.eL(5, this.lfd)) + a.a.a.a.eL(6, this.oTE);
            if (this.uop != null) {
                r0 += a.a.a.b.b.a.f(7, this.uop);
            }
            r0 += a.a.a.a.eL(8, this.uod);
            if (this.uoq != null) {
                r0 += a.a.a.b.b.a.f(9, this.uoq);
            }
            if (this.uor != null) {
                r0 += a.a.a.b.b.a.f(10, this.uor);
            }
            r0 = (r0 + a.a.a.a.eL(11, this.rVD)) + a.a.a.a.eL(12, this.uos);
            if (this.uot != null) {
                r0 += a.a.a.b.b.a.f(13, this.uot);
            }
            if (this.jgo != null) {
                r0 += a.a.a.b.b.a.f(14, this.jgo);
            }
            r0 += a.a.a.a.eL(15, this.fWL);
            if (this.fWM != null) {
                r0 += a.a.a.b.b.a.f(16, this.fWM);
            }
            return r0 + a.a.a.a.eL(17, this.jgt);
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
            bqe com_tencent_mm_protocal_c_bqe = (bqe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bqe.jOc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqe.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqe.uoo = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqe.oTD = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bqe.lfd = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bqe.oTE = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bqe.uop = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bqe.uod = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bqe.uoq = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bqe.uor = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bqe.rVD = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bqe.uos = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bqe.uot = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bqe.jgo = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bqe.fWL = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bqe.fWM = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bqe.jgt = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
