package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ble extends avp {
    public int tWi;
    public int thR;
    public LinkedList<bjx> thS = new LinkedList();
    public int tvL;
    public long tvM;
    public int ujC;
    public LinkedList<blg> ujD = new LinkedList();
    public int ujE;
    public int ujF;
    public int ujG;
    public int ujH;
    public int ujI;
    public int ujJ;
    public int ujK;
    public int ujL;
    public int ujM;
    public int ujN;
    public int ujO;
    public int ujP;
    public int ujQ;
    public blf ujt;
    public int uju;
    public int ujv;
    public int ujw;
    public int ujx;
    public int ukx;
    public int uky;
    public int ukz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.eO(2, this.tvL);
            aVar.eO(3, this.thR);
            aVar.d(4, 8, this.thS);
            aVar.O(5, this.tvM);
            aVar.eO(6, this.tWi);
            if (this.ujt != null) {
                aVar.eQ(7, this.ujt.aUk());
                this.ujt.a(aVar);
            }
            aVar.eO(8, this.ujC);
            aVar.d(9, 8, this.ujD);
            aVar.eO(10, this.ujE);
            aVar.eO(11, this.ujF);
            aVar.eO(12, this.ujG);
            aVar.eO(13, this.ujH);
            aVar.eO(14, this.ukx);
            aVar.eO(15, this.ujI);
            aVar.eO(16, this.ujJ);
            aVar.eO(17, this.uju);
            aVar.eO(18, this.ujK);
            aVar.eO(19, this.ujL);
            aVar.eO(20, this.ujv);
            aVar.eO(21, this.ujM);
            aVar.eO(22, this.ujN);
            aVar.eO(23, this.ujO);
            aVar.eO(24, this.uky);
            aVar.eO(25, this.ujP);
            aVar.eO(26, this.ukz);
            aVar.eO(27, this.ujw);
            aVar.eO(28, this.ujx);
            aVar.eO(29, this.ujQ);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.eL(2, this.tvL)) + a.a.a.a.eL(3, this.thR)) + a.a.a.a.c(4, 8, this.thS)) + a.a.a.a.N(5, this.tvM)) + a.a.a.a.eL(6, this.tWi);
            if (this.ujt != null) {
                r0 += a.a.a.a.eN(7, this.ujt.aUk());
            }
            return (((((((((((((((((((((r0 + a.a.a.a.eL(8, this.ujC)) + a.a.a.a.c(9, 8, this.ujD)) + a.a.a.a.eL(10, this.ujE)) + a.a.a.a.eL(11, this.ujF)) + a.a.a.a.eL(12, this.ujG)) + a.a.a.a.eL(13, this.ujH)) + a.a.a.a.eL(14, this.ukx)) + a.a.a.a.eL(15, this.ujI)) + a.a.a.a.eL(16, this.ujJ)) + a.a.a.a.eL(17, this.uju)) + a.a.a.a.eL(18, this.ujK)) + a.a.a.a.eL(19, this.ujL)) + a.a.a.a.eL(20, this.ujv)) + a.a.a.a.eL(21, this.ujM)) + a.a.a.a.eL(22, this.ujN)) + a.a.a.a.eL(23, this.ujO)) + a.a.a.a.eL(24, this.uky)) + a.a.a.a.eL(25, this.ujP)) + a.a.a.a.eL(26, this.ukz)) + a.a.a.a.eL(27, this.ujw)) + a.a.a.a.eL(28, this.ujx)) + a.a.a.a.eL(29, this.ujQ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.thS.clear();
            this.ujD.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ble com_tencent_mm_protocal_c_ble = (ble) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ble.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ble.tvL = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ble.thR = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bjx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ble.thS.add(enVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ble.tvM = aVar3.xmD.mM();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ble.tWi = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new blf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ble.ujt = enVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ble.ujC = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new blg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ble.ujD.add(enVar);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ble.ujE = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ble.ujF = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ble.ujG = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ble.ujH = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ble.ukx = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ble.ujI = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ble.ujJ = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ble.uju = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ble.ujK = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ble.ujL = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ble.ujv = aVar3.xmD.mL();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ble.ujM = aVar3.xmD.mL();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_ble.ujN = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_ble.ujO = aVar3.xmD.mL();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ble.uky = aVar3.xmD.mL();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ble.ujP = aVar3.xmD.mL();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_ble.ukz = aVar3.xmD.mL();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ble.ujw = aVar3.xmD.mL();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_ble.ujx = aVar3.xmD.mL();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_ble.ujQ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
