package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zg extends avp {
    public String hAF;
    public LinkedList<avx> tFA = new LinkedList();
    public int tFB;
    public LinkedList<aix> tFC = new LinkedList();
    public String tFD;
    public int tFE;
    public int tFF;
    public aiy tFG;
    public String tFH;
    public avw tFu;
    public int tFz;
    public int tlZ;
    public String tmb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tFu == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tFu != null) {
                    aVar.eQ(2, this.tFu.aUk());
                    this.tFu.a(aVar);
                }
                aVar.eO(3, this.tFz);
                aVar.d(4, 8, this.tFA);
                aVar.eO(5, this.tFB);
                aVar.d(6, 8, this.tFC);
                aVar.eO(7, this.tlZ);
                if (this.tFD != null) {
                    aVar.e(8, this.tFD);
                }
                if (this.tmb != null) {
                    aVar.e(9, this.tmb);
                }
                aVar.eO(10, this.tFE);
                if (this.hAF != null) {
                    aVar.e(11, this.hAF);
                }
                aVar.eO(12, this.tFF);
                if (this.tFG != null) {
                    aVar.eQ(13, this.tFG.aUk());
                    this.tFG.a(aVar);
                }
                if (this.tFH == null) {
                    return 0;
                }
                aVar.e(14, this.tFH);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tFu != null) {
                r0 += a.a.a.a.eN(2, this.tFu.aUk());
            }
            r0 = ((((r0 + a.a.a.a.eL(3, this.tFz)) + a.a.a.a.c(4, 8, this.tFA)) + a.a.a.a.eL(5, this.tFB)) + a.a.a.a.c(6, 8, this.tFC)) + a.a.a.a.eL(7, this.tlZ);
            if (this.tFD != null) {
                r0 += a.a.a.b.b.a.f(8, this.tFD);
            }
            if (this.tmb != null) {
                r0 += a.a.a.b.b.a.f(9, this.tmb);
            }
            r0 += a.a.a.a.eL(10, this.tFE);
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(11, this.hAF);
            }
            r0 += a.a.a.a.eL(12, this.tFF);
            if (this.tFG != null) {
                r0 += a.a.a.a.eN(13, this.tFG.aUk());
            }
            if (this.tFH != null) {
                r0 += a.a.a.b.b.a.f(14, this.tFH);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tFA.clear();
            this.tFC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tFu != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zg zgVar = (zg) objArr[1];
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
                        zgVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        zgVar.tFu = enVar;
                    }
                    return 0;
                case 3:
                    zgVar.tFz = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        zgVar.tFA.add(enVar);
                    }
                    return 0;
                case 5:
                    zgVar.tFB = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aix();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        zgVar.tFC.add(enVar);
                    }
                    return 0;
                case 7:
                    zgVar.tlZ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    zgVar.tFD = aVar3.xmD.readString();
                    return 0;
                case 9:
                    zgVar.tmb = aVar3.xmD.readString();
                    return 0;
                case 10:
                    zgVar.tFE = aVar3.xmD.mL();
                    return 0;
                case 11:
                    zgVar.hAF = aVar3.xmD.readString();
                    return 0;
                case 12:
                    zgVar.tFF = aVar3.xmD.mL();
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aiy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        zgVar.tFG = enVar;
                    }
                    return 0;
                case 14:
                    zgVar.tFH = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
