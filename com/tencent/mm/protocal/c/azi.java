package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class azi extends a {
    public int hAD;
    public String hAE;
    public String hAF;
    public String hAG;
    public String hAM;
    public String hAN;
    public String jNj;
    public String jOp;
    public String tBM;
    public String tHj;
    public String tMO;
    public int tMP;
    public String tMQ;
    public String tMR;
    public String tMS;
    public int tMT;
    public int tMU;
    public bcp tMV;
    public my tMW;
    public int tfg;
    public String tqb;
    public String tqc;
    public int uaF;
    public avw uaG;
    public int uaH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.uaG == null) {
                throw new b("Not all required fields were included: ImgBuffer");
            }
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            if (this.jOp != null) {
                aVar.e(2, this.jOp);
            }
            if (this.hAE != null) {
                aVar.e(3, this.hAE);
            }
            if (this.hAF != null) {
                aVar.e(4, this.hAF);
            }
            if (this.hAG != null) {
                aVar.e(5, this.hAG);
            }
            if (this.tMO != null) {
                aVar.e(6, this.tMO);
            }
            aVar.eO(7, this.hAD);
            aVar.eO(8, this.tfg);
            aVar.eO(9, this.uaF);
            if (this.uaG != null) {
                aVar.eQ(10, this.uaG.aUk());
                this.uaG.a(aVar);
            }
            aVar.eO(11, this.uaH);
            if (this.tMR != null) {
                aVar.e(12, this.tMR);
            }
            if (this.tMS != null) {
                aVar.e(13, this.tMS);
            }
            aVar.eO(14, this.tMT);
            aVar.eO(15, this.tMP);
            if (this.tMQ != null) {
                aVar.e(16, this.tMQ);
            }
            if (this.tHj != null) {
                aVar.e(17, this.tHj);
            }
            aVar.eO(21, this.tMU);
            if (this.tMV != null) {
                aVar.eQ(22, this.tMV.aUk());
                this.tMV.a(aVar);
            }
            if (this.hAM != null) {
                aVar.e(23, this.hAM);
            }
            if (this.tqb != null) {
                aVar.e(24, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(25, this.tqc);
            }
            if (this.hAN != null) {
                aVar.e(26, this.hAN);
            }
            if (this.tMW != null) {
                aVar.eQ(27, this.tMW.aUk());
                this.tMW.a(aVar);
            }
            if (this.tBM == null) {
                return 0;
            }
            aVar.e(28, this.tBM);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(3, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(4, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(5, this.hAG);
            }
            if (this.tMO != null) {
                r0 += a.a.a.b.b.a.f(6, this.tMO);
            }
            r0 = ((r0 + a.a.a.a.eL(7, this.hAD)) + a.a.a.a.eL(8, this.tfg)) + a.a.a.a.eL(9, this.uaF);
            if (this.uaG != null) {
                r0 += a.a.a.a.eN(10, this.uaG.aUk());
            }
            r0 += a.a.a.a.eL(11, this.uaH);
            if (this.tMR != null) {
                r0 += a.a.a.b.b.a.f(12, this.tMR);
            }
            if (this.tMS != null) {
                r0 += a.a.a.b.b.a.f(13, this.tMS);
            }
            r0 = (r0 + a.a.a.a.eL(14, this.tMT)) + a.a.a.a.eL(15, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(16, this.tMQ);
            }
            if (this.tHj != null) {
                r0 += a.a.a.b.b.a.f(17, this.tHj);
            }
            r0 += a.a.a.a.eL(21, this.tMU);
            if (this.tMV != null) {
                r0 += a.a.a.a.eN(22, this.tMV.aUk());
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(23, this.hAM);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(24, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(25, this.tqc);
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(26, this.hAN);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(27, this.tMW.aUk());
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(28, this.tBM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.uaG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            azi com_tencent_mm_protocal_c_azi = (azi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_azi.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azi.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azi.hAE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azi.hAF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azi.hAG = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azi.tMO = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_azi.hAD = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azi.tfg = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_azi.uaF = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azi.uaG = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_azi.uaH = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_azi.tMR = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_azi.tMS = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_azi.tMT = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_azi.tMP = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_azi.tMQ = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_azi.tHj = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_azi.tMU = aVar3.xmD.mL();
                    return 0;
                case 22:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bcp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azi.tMV = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_azi.hAM = aVar3.xmD.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_azi.tqb = aVar3.xmD.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_azi.tqc = aVar3.xmD.readString();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_azi.hAN = aVar3.xmD.readString();
                    return 0;
                case 27:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new my();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azi.tMW = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_azi.tBM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
