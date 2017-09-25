package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public class aiw extends a {
    public int hAD;
    public String hAE;
    public String hAF;
    public String hAG;
    public String hAI;
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

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
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
            aVar.eO(9, this.tMP);
            if (this.tMQ != null) {
                aVar.e(10, this.tMQ);
            }
            if (this.tHj != null) {
                aVar.e(11, this.tHj);
            }
            if (this.hAI != null) {
                aVar.e(12, this.hAI);
            }
            if (this.tMR != null) {
                aVar.e(13, this.tMR);
            }
            if (this.tMS != null) {
                aVar.e(14, this.tMS);
            }
            aVar.eO(15, this.tMT);
            aVar.eO(19, this.tMU);
            if (this.tMV != null) {
                aVar.eQ(20, this.tMV.aUk());
                this.tMV.a(aVar);
            }
            if (this.hAM != null) {
                aVar.e(21, this.hAM);
            }
            if (this.tqb != null) {
                aVar.e(22, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(23, this.tqc);
            }
            if (this.hAN != null) {
                aVar.e(24, this.hAN);
            }
            if (this.tMW != null) {
                aVar.eQ(25, this.tMW.aUk());
                this.tMW.a(aVar);
            }
            if (this.tBM == null) {
                return 0;
            }
            aVar.e(26, this.tBM);
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
            r0 = ((r0 + a.a.a.a.eL(7, this.hAD)) + a.a.a.a.eL(8, this.tfg)) + a.a.a.a.eL(9, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(10, this.tMQ);
            }
            if (this.tHj != null) {
                r0 += a.a.a.b.b.a.f(11, this.tHj);
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(12, this.hAI);
            }
            if (this.tMR != null) {
                r0 += a.a.a.b.b.a.f(13, this.tMR);
            }
            if (this.tMS != null) {
                r0 += a.a.a.b.b.a.f(14, this.tMS);
            }
            r0 = (r0 + a.a.a.a.eL(15, this.tMT)) + a.a.a.a.eL(19, this.tMU);
            if (this.tMV != null) {
                r0 += a.a.a.a.eN(20, this.tMV.aUk());
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(21, this.hAM);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(22, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(23, this.tqc);
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(24, this.hAN);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(25, this.tMW.aUk());
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(26, this.tBM);
            }
            return r0;
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
            aiw com_tencent_mm_protocal_c_aiw = (aiw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_bcp;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aiw.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aiw.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aiw.hAE = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aiw.hAF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aiw.hAG = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aiw.tMO = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aiw.hAD = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aiw.tfg = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aiw.tMP = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aiw.tMQ = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aiw.tHj = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aiw.hAI = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aiw.tMR = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aiw.tMS = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aiw.tMT = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aiw.tMU = aVar3.xmD.mL();
                    return 0;
                case 20:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new bcp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aiw.tMV = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aiw.hAM = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aiw.tqb = aVar3.xmD.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aiw.tqc = aVar3.xmD.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aiw.hAN = aVar3.xmD.readString();
                    return 0;
                case 25:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_bcp = new my();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcp.a(aVar4, com_tencent_mm_protocal_c_bcp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aiw.tMW = com_tencent_mm_protocal_c_bcp;
                    }
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_aiw.tBM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
