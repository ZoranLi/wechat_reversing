package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class qu extends avp {
    public int boy;
    public int fFG;
    public int fZG;
    public int fZH;
    public int kAC;
    public String kAD;
    public int njA;
    public String njB;
    public String njC;
    public String njD;
    public int njE;
    public String njw;
    public String nmD;
    public aua twy;

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
            aVar.eO(2, this.kAC);
            if (this.kAD != null) {
                aVar.e(3, this.kAD);
            }
            aVar.eO(4, this.fFG);
            if (this.njw != null) {
                aVar.e(5, this.njw);
            }
            aVar.eO(6, this.fZG);
            aVar.eO(7, this.fZH);
            if (this.nmD != null) {
                aVar.e(8, this.nmD);
            }
            aVar.eO(9, this.boy);
            if (this.twy != null) {
                aVar.eQ(10, this.twy.aUk());
                this.twy.a(aVar);
            }
            aVar.eO(11, this.njA);
            if (this.njB != null) {
                aVar.e(12, this.njB);
            }
            if (this.njC != null) {
                aVar.e(13, this.njC);
            }
            if (this.njD != null) {
                aVar.e(14, this.njD);
            }
            aVar.eO(15, this.njE);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.kAC);
            if (this.kAD != null) {
                r0 += a.a.a.b.b.a.f(3, this.kAD);
            }
            r0 += a.a.a.a.eL(4, this.fFG);
            if (this.njw != null) {
                r0 += a.a.a.b.b.a.f(5, this.njw);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.fZG)) + a.a.a.a.eL(7, this.fZH);
            if (this.nmD != null) {
                r0 += a.a.a.b.b.a.f(8, this.nmD);
            }
            r0 += a.a.a.a.eL(9, this.boy);
            if (this.twy != null) {
                r0 += a.a.a.a.eN(10, this.twy.aUk());
            }
            r0 += a.a.a.a.eL(11, this.njA);
            if (this.njB != null) {
                r0 += a.a.a.b.b.a.f(12, this.njB);
            }
            if (this.njC != null) {
                r0 += a.a.a.b.b.a.f(13, this.njC);
            }
            if (this.njD != null) {
                r0 += a.a.a.b.b.a.f(14, this.njD);
            }
            return r0 + a.a.a.a.eL(15, this.njE);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            qu quVar = (qu) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        quVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    quVar.kAC = aVar3.xmD.mL();
                    return 0;
                case 3:
                    quVar.kAD = aVar3.xmD.readString();
                    return 0;
                case 4:
                    quVar.fFG = aVar3.xmD.mL();
                    return 0;
                case 5:
                    quVar.njw = aVar3.xmD.readString();
                    return 0;
                case 6:
                    quVar.fZG = aVar3.xmD.mL();
                    return 0;
                case 7:
                    quVar.fZH = aVar3.xmD.mL();
                    return 0;
                case 8:
                    quVar.nmD = aVar3.xmD.readString();
                    return 0;
                case 9:
                    quVar.boy = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new aua();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        quVar.twy = enVar;
                    }
                    return 0;
                case 11:
                    quVar.njA = aVar3.xmD.mL();
                    return 0;
                case 12:
                    quVar.njB = aVar3.xmD.readString();
                    return 0;
                case 13:
                    quVar.njC = aVar3.xmD.readString();
                    return 0;
                case 14:
                    quVar.njD = aVar3.xmD.readString();
                    return 0;
                case 15:
                    quVar.njE = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
