package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class to extends avp {
    public String SSID;
    public String fDC;
    public String jNj;
    public String mQZ;
    public String opI;
    public String tBF;
    public String tBG;
    public ags tBH;
    public tk tBI;
    public String tBJ;
    public int tBK;
    public LinkedList<hl> tBL = new LinkedList();
    public String tBM;
    public na tBN;
    public avw tBO;
    public int tBP;
    public LinkedList<afe> tBQ = new LinkedList();
    public String tBR;
    public String tcb;
    public int tcm;

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
            if (this.tBF != null) {
                aVar.e(2, this.tBF);
            }
            if (this.tBG != null) {
                aVar.e(3, this.tBG);
            }
            aVar.eO(4, this.tcm);
            if (this.fDC != null) {
                aVar.e(5, this.fDC);
            }
            if (this.opI != null) {
                aVar.e(6, this.opI);
            }
            if (this.tBH != null) {
                aVar.eQ(7, this.tBH.aUk());
                this.tBH.a(aVar);
            }
            if (this.tBI != null) {
                aVar.eQ(8, this.tBI.aUk());
                this.tBI.a(aVar);
            }
            if (this.jNj != null) {
                aVar.e(9, this.jNj);
            }
            if (this.tBJ != null) {
                aVar.e(15, this.tBJ);
            }
            aVar.eO(16, this.tBK);
            aVar.d(17, 8, this.tBL);
            if (this.tBM != null) {
                aVar.e(18, this.tBM);
            }
            if (this.SSID != null) {
                aVar.e(20, this.SSID);
            }
            if (this.tcb != null) {
                aVar.e(21, this.tcb);
            }
            if (this.tBN != null) {
                aVar.eQ(22, this.tBN.aUk());
                this.tBN.a(aVar);
            }
            if (this.tBO != null) {
                aVar.eQ(23, this.tBO.aUk());
                this.tBO.a(aVar);
            }
            aVar.eO(24, this.tBP);
            aVar.d(25, 8, this.tBQ);
            if (this.mQZ != null) {
                aVar.e(26, this.mQZ);
            }
            if (this.tBR == null) {
                return 0;
            }
            aVar.e(27, this.tBR);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tBF != null) {
                r0 += a.a.a.b.b.a.f(2, this.tBF);
            }
            if (this.tBG != null) {
                r0 += a.a.a.b.b.a.f(3, this.tBG);
            }
            r0 += a.a.a.a.eL(4, this.tcm);
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(5, this.fDC);
            }
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(6, this.opI);
            }
            if (this.tBH != null) {
                r0 += a.a.a.a.eN(7, this.tBH.aUk());
            }
            if (this.tBI != null) {
                r0 += a.a.a.a.eN(8, this.tBI.aUk());
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(9, this.jNj);
            }
            if (this.tBJ != null) {
                r0 += a.a.a.b.b.a.f(15, this.tBJ);
            }
            r0 = (r0 + a.a.a.a.eL(16, this.tBK)) + a.a.a.a.c(17, 8, this.tBL);
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(18, this.tBM);
            }
            if (this.SSID != null) {
                r0 += a.a.a.b.b.a.f(20, this.SSID);
            }
            if (this.tcb != null) {
                r0 += a.a.a.b.b.a.f(21, this.tcb);
            }
            if (this.tBN != null) {
                r0 += a.a.a.a.eN(22, this.tBN.aUk());
            }
            if (this.tBO != null) {
                r0 += a.a.a.a.eN(23, this.tBO.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(24, this.tBP)) + a.a.a.a.c(25, 8, this.tBQ);
            if (this.mQZ != null) {
                r0 += a.a.a.b.b.a.f(26, this.mQZ);
            }
            if (this.tBR != null) {
                r0 += a.a.a.b.b.a.f(27, this.tBR);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tBL.clear();
            this.tBQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
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
            to toVar = (to) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        toVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    toVar.tBF = aVar3.xmD.readString();
                    return 0;
                case 3:
                    toVar.tBG = aVar3.xmD.readString();
                    return 0;
                case 4:
                    toVar.tcm = aVar3.xmD.mL();
                    return 0;
                case 5:
                    toVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 6:
                    toVar.opI = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new ags();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        toVar.tBH = enVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new tk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        toVar.tBI = enVar;
                    }
                    return 0;
                case 9:
                    toVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 15:
                    toVar.tBJ = aVar3.xmD.readString();
                    return 0;
                case 16:
                    toVar.tBK = aVar3.xmD.mL();
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new hl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        toVar.tBL.add(enVar);
                    }
                    return 0;
                case 18:
                    toVar.tBM = aVar3.xmD.readString();
                    return 0;
                case 20:
                    toVar.SSID = aVar3.xmD.readString();
                    return 0;
                case 21:
                    toVar.tcb = aVar3.xmD.readString();
                    return 0;
                case 22:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new na();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        toVar.tBN = enVar;
                    }
                    return 0;
                case 23:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        toVar.tBO = enVar;
                    }
                    return 0;
                case 24:
                    toVar.tBP = aVar3.xmD.mL();
                    return 0;
                case 25:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new afe();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        toVar.tBQ.add(enVar);
                    }
                    return 0;
                case 26:
                    toVar.mQZ = aVar3.xmD.readString();
                    return 0;
                case 27:
                    toVar.tBR = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
