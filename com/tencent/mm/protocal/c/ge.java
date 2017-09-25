package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ge extends avp {
    public String fGV;
    public int tdE;
    public String tgG;
    public bad thp;
    public String thq;
    public String tjI;
    public int tjJ;
    public String tjK;
    public afd tjL;
    public hr tjM;
    public anh tjN;
    public String tjO;
    public int tjP;
    public awa tjQ;
    public String tjR;
    public String tjS;

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
            if (this.fGV != null) {
                aVar.e(2, this.fGV);
            }
            if (this.tjI != null) {
                aVar.e(3, this.tjI);
            }
            aVar.eO(4, this.tjJ);
            if (this.tjK != null) {
                aVar.e(5, this.tjK);
            }
            if (this.tgG != null) {
                aVar.e(6, this.tgG);
            }
            if (this.tjL != null) {
                aVar.eQ(7, this.tjL.aUk());
                this.tjL.a(aVar);
            }
            if (this.tjM != null) {
                aVar.eQ(8, this.tjM.aUk());
                this.tjM.a(aVar);
            }
            if (this.tjN != null) {
                aVar.eQ(9, this.tjN.aUk());
                this.tjN.a(aVar);
            }
            if (this.thq != null) {
                aVar.e(10, this.thq);
            }
            aVar.eO(11, this.tdE);
            if (this.tjO != null) {
                aVar.e(12, this.tjO);
            }
            aVar.eO(13, this.tjP);
            if (this.tjQ != null) {
                aVar.eQ(14, this.tjQ.aUk());
                this.tjQ.a(aVar);
            }
            if (this.tjR != null) {
                aVar.e(15, this.tjR);
            }
            if (this.tjS != null) {
                aVar.e(16, this.tjS);
            }
            if (this.thp == null) {
                return 0;
            }
            aVar.eQ(17, this.thp.aUk());
            this.thp.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fGV != null) {
                r0 += a.a.a.b.b.a.f(2, this.fGV);
            }
            if (this.tjI != null) {
                r0 += a.a.a.b.b.a.f(3, this.tjI);
            }
            r0 += a.a.a.a.eL(4, this.tjJ);
            if (this.tjK != null) {
                r0 += a.a.a.b.b.a.f(5, this.tjK);
            }
            if (this.tgG != null) {
                r0 += a.a.a.b.b.a.f(6, this.tgG);
            }
            if (this.tjL != null) {
                r0 += a.a.a.a.eN(7, this.tjL.aUk());
            }
            if (this.tjM != null) {
                r0 += a.a.a.a.eN(8, this.tjM.aUk());
            }
            if (this.tjN != null) {
                r0 += a.a.a.a.eN(9, this.tjN.aUk());
            }
            if (this.thq != null) {
                r0 += a.a.a.b.b.a.f(10, this.thq);
            }
            r0 += a.a.a.a.eL(11, this.tdE);
            if (this.tjO != null) {
                r0 += a.a.a.b.b.a.f(12, this.tjO);
            }
            r0 += a.a.a.a.eL(13, this.tjP);
            if (this.tjQ != null) {
                r0 += a.a.a.a.eN(14, this.tjQ.aUk());
            }
            if (this.tjR != null) {
                r0 += a.a.a.b.b.a.f(15, this.tjR);
            }
            if (this.tjS != null) {
                r0 += a.a.a.b.b.a.f(16, this.tjS);
            }
            if (this.thp != null) {
                r0 += a.a.a.a.eN(17, this.thp.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ge geVar = (ge) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        geVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    geVar.fGV = aVar3.xmD.readString();
                    return 0;
                case 3:
                    geVar.tjI = aVar3.xmD.readString();
                    return 0;
                case 4:
                    geVar.tjJ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    geVar.tjK = aVar3.xmD.readString();
                    return 0;
                case 6:
                    geVar.tgG = aVar3.xmD.readString();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new afd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        geVar.tjL = enVar;
                    }
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new hr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        geVar.tjM = enVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new anh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        geVar.tjN = enVar;
                    }
                    return 0;
                case 10:
                    geVar.thq = aVar3.xmD.readString();
                    return 0;
                case 11:
                    geVar.tdE = aVar3.xmD.mL();
                    return 0;
                case 12:
                    geVar.tjO = aVar3.xmD.readString();
                    return 0;
                case 13:
                    geVar.tjP = aVar3.xmD.mL();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new awa();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        geVar.tjQ = enVar;
                    }
                    return 0;
                case 15:
                    geVar.tjR = aVar3.xmD.readString();
                    return 0;
                case 16:
                    geVar.tjS = aVar3.xmD.readString();
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bad();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        geVar.thp = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
