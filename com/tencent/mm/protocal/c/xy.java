package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xy extends avp {
    public LinkedList<pe> tEA = new LinkedList();
    public int tEo;
    public LinkedList<pn> tEp = new LinkedList();
    public pc tEq;
    public int tEr;
    public LinkedList<pc> tEs = new LinkedList();
    public int tEt;
    public LinkedList<pg> tEu = new LinkedList();
    public int tEv;
    public LinkedList<pe> tEw = new LinkedList();
    public int tEx;
    public int tEy;
    public int tEz;
    public avw tfG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tfG == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.tfG != null) {
                    aVar.eQ(2, this.tfG.aUk());
                    this.tfG.a(aVar);
                }
                aVar.eO(3, this.tEo);
                aVar.d(4, 8, this.tEp);
                if (this.tEq != null) {
                    aVar.eQ(5, this.tEq.aUk());
                    this.tEq.a(aVar);
                }
                aVar.eO(6, this.tEr);
                aVar.d(7, 8, this.tEs);
                aVar.eO(8, this.tEt);
                aVar.d(9, 8, this.tEu);
                aVar.eO(10, this.tEv);
                aVar.d(11, 8, this.tEw);
                aVar.eO(12, this.tEx);
                aVar.eO(13, this.tEy);
                aVar.eO(14, this.tEz);
                aVar.d(15, 8, this.tEA);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfG != null) {
                r0 += a.a.a.a.eN(2, this.tfG.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tEo)) + a.a.a.a.c(4, 8, this.tEp);
            if (this.tEq != null) {
                r0 += a.a.a.a.eN(5, this.tEq.aUk());
            }
            return (((((((((r0 + a.a.a.a.eL(6, this.tEr)) + a.a.a.a.c(7, 8, this.tEs)) + a.a.a.a.eL(8, this.tEt)) + a.a.a.a.c(9, 8, this.tEu)) + a.a.a.a.eL(10, this.tEv)) + a.a.a.a.c(11, 8, this.tEw)) + a.a.a.a.eL(12, this.tEx)) + a.a.a.a.eL(13, this.tEy)) + a.a.a.a.eL(14, this.tEz)) + a.a.a.a.c(15, 8, this.tEA);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tEp.clear();
            this.tEs.clear();
            this.tEu.clear();
            this.tEw.clear();
            this.tEA.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tfG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xy xyVar = (xy) objArr[1];
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
                        xyVar.tZe = enVar;
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
                        xyVar.tfG = enVar;
                    }
                    return 0;
                case 3:
                    xyVar.tEo = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new pn();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xyVar.tEp.add(enVar);
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new pc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xyVar.tEq = enVar;
                    }
                    return 0;
                case 6:
                    xyVar.tEr = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new pc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xyVar.tEs.add(enVar);
                    }
                    return 0;
                case 8:
                    xyVar.tEt = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new pg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xyVar.tEu.add(enVar);
                    }
                    return 0;
                case 10:
                    xyVar.tEv = aVar3.xmD.mL();
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new pe();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xyVar.tEw.add(enVar);
                    }
                    return 0;
                case 12:
                    xyVar.tEx = aVar3.xmD.mL();
                    return 0;
                case 13:
                    xyVar.tEy = aVar3.xmD.mL();
                    return 0;
                case 14:
                    xyVar.tEz = aVar3.xmD.mL();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new pe();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xyVar.tEA.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
