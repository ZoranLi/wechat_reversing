package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class it extends a {
    public String code;
    public int status;
    public int tnA;
    public LinkedList<jg> tnB = new LinkedList();
    public LinkedList<jg> tnC = new LinkedList();
    public LinkedList<jg> tnD = new LinkedList();
    public LinkedList<String> tnE = new LinkedList();
    public int tnF;
    public int tnG;
    public LinkedList<lz> tnH = new LinkedList();
    public long tnI;
    public int tnJ;
    public String tnK;
    public lz tnL;
    public LinkedList<au> tnM = new LinkedList();
    public lz tnN;
    public lz tnO;
    public lz tnP;
    public ob tnQ;
    public String tnR;
    public lz tnS;
    public String tnT;
    public lz tnU;
    public boolean tnV;
    public int tnz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.status);
            aVar.eO(2, this.tnz);
            aVar.eO(3, this.tnA);
            aVar.d(4, 8, this.tnB);
            aVar.d(5, 8, this.tnC);
            aVar.d(6, 8, this.tnD);
            aVar.d(7, 1, this.tnE);
            aVar.eO(8, this.tnF);
            if (this.code != null) {
                aVar.e(9, this.code);
            }
            aVar.eO(10, this.tnG);
            aVar.d(11, 8, this.tnH);
            aVar.O(12, this.tnI);
            aVar.eO(13, this.tnJ);
            if (this.tnK != null) {
                aVar.e(14, this.tnK);
            }
            if (this.tnL != null) {
                aVar.eQ(15, this.tnL.aUk());
                this.tnL.a(aVar);
            }
            aVar.d(16, 8, this.tnM);
            if (this.tnN != null) {
                aVar.eQ(17, this.tnN.aUk());
                this.tnN.a(aVar);
            }
            if (this.tnO != null) {
                aVar.eQ(18, this.tnO.aUk());
                this.tnO.a(aVar);
            }
            if (this.tnP != null) {
                aVar.eQ(19, this.tnP.aUk());
                this.tnP.a(aVar);
            }
            if (this.tnQ != null) {
                aVar.eQ(20, this.tnQ.aUk());
                this.tnQ.a(aVar);
            }
            if (this.tnR != null) {
                aVar.e(21, this.tnR);
            }
            if (this.tnS != null) {
                aVar.eQ(22, this.tnS.aUk());
                this.tnS.a(aVar);
            }
            if (this.tnT != null) {
                aVar.e(23, this.tnT);
            }
            if (this.tnU != null) {
                aVar.eQ(24, this.tnU.aUk());
                this.tnU.a(aVar);
            }
            aVar.an(25, this.tnV);
            return 0;
        } else if (i == 1) {
            r0 = (((((((a.a.a.a.eL(1, this.status) + 0) + a.a.a.a.eL(2, this.tnz)) + a.a.a.a.eL(3, this.tnA)) + a.a.a.a.c(4, 8, this.tnB)) + a.a.a.a.c(5, 8, this.tnC)) + a.a.a.a.c(6, 8, this.tnD)) + a.a.a.a.c(7, 1, this.tnE)) + a.a.a.a.eL(8, this.tnF);
            if (this.code != null) {
                r0 += a.a.a.b.b.a.f(9, this.code);
            }
            r0 = (((r0 + a.a.a.a.eL(10, this.tnG)) + a.a.a.a.c(11, 8, this.tnH)) + a.a.a.a.N(12, this.tnI)) + a.a.a.a.eL(13, this.tnJ);
            if (this.tnK != null) {
                r0 += a.a.a.b.b.a.f(14, this.tnK);
            }
            if (this.tnL != null) {
                r0 += a.a.a.a.eN(15, this.tnL.aUk());
            }
            r0 += a.a.a.a.c(16, 8, this.tnM);
            if (this.tnN != null) {
                r0 += a.a.a.a.eN(17, this.tnN.aUk());
            }
            if (this.tnO != null) {
                r0 += a.a.a.a.eN(18, this.tnO.aUk());
            }
            if (this.tnP != null) {
                r0 += a.a.a.a.eN(19, this.tnP.aUk());
            }
            if (this.tnQ != null) {
                r0 += a.a.a.a.eN(20, this.tnQ.aUk());
            }
            if (this.tnR != null) {
                r0 += a.a.a.b.b.a.f(21, this.tnR);
            }
            if (this.tnS != null) {
                r0 += a.a.a.a.eN(22, this.tnS.aUk());
            }
            if (this.tnT != null) {
                r0 += a.a.a.b.b.a.f(23, this.tnT);
            }
            if (this.tnU != null) {
                r0 += a.a.a.a.eN(24, this.tnU.aUk());
            }
            return r0 + (a.a.a.b.b.a.cH(25) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tnB.clear();
            this.tnC.clear();
            this.tnD.clear();
            this.tnE.clear();
            this.tnH.clear();
            this.tnM.clear();
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
            it itVar = (it) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a jgVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    itVar.status = aVar3.xmD.mL();
                    return 0;
                case 2:
                    itVar.tnz = aVar3.xmD.mL();
                    return 0;
                case 3:
                    itVar.tnA = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new jg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnB.add(jgVar);
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new jg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnC.add(jgVar);
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new jg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnD.add(jgVar);
                    }
                    return 0;
                case 7:
                    itVar.tnE.add(aVar3.xmD.readString());
                    return 0;
                case 8:
                    itVar.tnF = aVar3.xmD.mL();
                    return 0;
                case 9:
                    itVar.code = aVar3.xmD.readString();
                    return 0;
                case 10:
                    itVar.tnG = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnH.add(jgVar);
                    }
                    return 0;
                case 12:
                    itVar.tnI = aVar3.xmD.mM();
                    return 0;
                case 13:
                    itVar.tnJ = aVar3.xmD.mL();
                    return 0;
                case 14:
                    itVar.tnK = aVar3.xmD.readString();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnL = jgVar;
                    }
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new au();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnM.add(jgVar);
                    }
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnN = jgVar;
                    }
                    return 0;
                case 18:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnO = jgVar;
                    }
                    return 0;
                case 19:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnP = jgVar;
                    }
                    return 0;
                case 20:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new ob();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnQ = jgVar;
                    }
                    return 0;
                case 21:
                    itVar.tnR = aVar3.xmD.readString();
                    return 0;
                case 22:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnS = jgVar;
                    }
                    return 0;
                case 23:
                    itVar.tnT = aVar3.xmD.readString();
                    return 0;
                case 24:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jgVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jgVar.a(aVar4, jgVar, a.a(aVar4))) {
                        }
                        itVar.tnU = jgVar;
                    }
                    return 0;
                case 25:
                    itVar.tnV = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
