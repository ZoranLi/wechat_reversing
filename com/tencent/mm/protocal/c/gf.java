package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class gf extends avh {
    public avw tit;
    public String tjD;
    public String tjE;
    public String tjK;
    public int tjT;
    public String tjU;
    public String tjV;
    public String tjW;
    public int tjX;
    public avx tjY;
    public avw tjZ;
    public int tka;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tjT);
            if (this.tjK != null) {
                aVar.e(3, this.tjK);
            }
            if (this.tjU != null) {
                aVar.e(4, this.tjU);
            }
            if (this.tjV != null) {
                aVar.e(5, this.tjV);
            }
            if (this.tjW != null) {
                aVar.e(6, this.tjW);
            }
            aVar.eO(7, this.tjX);
            if (this.tjY != null) {
                aVar.eQ(8, this.tjY.aUk());
                this.tjY.a(aVar);
            }
            if (this.tjZ != null) {
                aVar.eQ(9, this.tjZ.aUk());
                this.tjZ.a(aVar);
            }
            aVar.eO(10, this.tka);
            if (this.tjD != null) {
                aVar.e(11, this.tjD);
            }
            if (this.tjE != null) {
                aVar.e(12, this.tjE);
            }
            if (this.tit == null) {
                return 0;
            }
            aVar.eQ(13, this.tit.aUk());
            this.tit.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tjT);
            if (this.tjK != null) {
                r0 += a.a.a.b.b.a.f(3, this.tjK);
            }
            if (this.tjU != null) {
                r0 += a.a.a.b.b.a.f(4, this.tjU);
            }
            if (this.tjV != null) {
                r0 += a.a.a.b.b.a.f(5, this.tjV);
            }
            if (this.tjW != null) {
                r0 += a.a.a.b.b.a.f(6, this.tjW);
            }
            r0 += a.a.a.a.eL(7, this.tjX);
            if (this.tjY != null) {
                r0 += a.a.a.a.eN(8, this.tjY.aUk());
            }
            if (this.tjZ != null) {
                r0 += a.a.a.a.eN(9, this.tjZ.aUk());
            }
            r0 += a.a.a.a.eL(10, this.tka);
            if (this.tjD != null) {
                r0 += a.a.a.b.b.a.f(11, this.tjD);
            }
            if (this.tjE != null) {
                r0 += a.a.a.b.b.a.f(12, this.tjE);
            }
            if (this.tit != null) {
                r0 += a.a.a.a.eN(13, this.tit.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            gf gfVar = (gf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        gfVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    gfVar.tjT = aVar3.xmD.mL();
                    return 0;
                case 3:
                    gfVar.tjK = aVar3.xmD.readString();
                    return 0;
                case 4:
                    gfVar.tjU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    gfVar.tjV = aVar3.xmD.readString();
                    return 0;
                case 6:
                    gfVar.tjW = aVar3.xmD.readString();
                    return 0;
                case 7:
                    gfVar.tjX = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        gfVar.tjY = emVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        gfVar.tjZ = emVar;
                    }
                    return 0;
                case 10:
                    gfVar.tka = aVar3.xmD.mL();
                    return 0;
                case 11:
                    gfVar.tjD = aVar3.xmD.readString();
                    return 0;
                case 12:
                    gfVar.tjE = aVar3.xmD.readString();
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        gfVar.tit = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
