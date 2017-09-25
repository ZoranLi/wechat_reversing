package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class gd extends avh {
    public String jNj;
    public String leO;
    public String thC;
    public int thO;
    public String thq;
    public int tjA;
    public String tjB;
    public int tjC;
    public String tjD;
    public String tjE;
    public avw tjF;
    public int tjG;
    public int tjH;
    public String tjy;
    public String tjz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            if (this.tjy != null) {
                aVar.e(3, this.tjy);
            }
            aVar.eO(4, this.thO);
            if (this.tjz != null) {
                aVar.e(5, this.tjz);
            }
            aVar.eO(6, this.tjA);
            if (this.tjB != null) {
                aVar.e(7, this.tjB);
            }
            if (this.thq != null) {
                aVar.e(8, this.thq);
            }
            aVar.eO(9, this.tjC);
            if (this.tjD != null) {
                aVar.e(10, this.tjD);
            }
            if (this.tjE != null) {
                aVar.e(11, this.tjE);
            }
            if (this.tjF != null) {
                aVar.eQ(12, this.tjF.aUk());
                this.tjF.a(aVar);
            }
            if (this.leO != null) {
                aVar.e(13, this.leO);
            }
            aVar.eO(14, this.tjG);
            aVar.eO(15, this.tjH);
            if (this.thC == null) {
                return 0;
            }
            aVar.e(16, this.thC);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            if (this.tjy != null) {
                r0 += a.a.a.b.b.a.f(3, this.tjy);
            }
            r0 += a.a.a.a.eL(4, this.thO);
            if (this.tjz != null) {
                r0 += a.a.a.b.b.a.f(5, this.tjz);
            }
            r0 += a.a.a.a.eL(6, this.tjA);
            if (this.tjB != null) {
                r0 += a.a.a.b.b.a.f(7, this.tjB);
            }
            if (this.thq != null) {
                r0 += a.a.a.b.b.a.f(8, this.thq);
            }
            r0 += a.a.a.a.eL(9, this.tjC);
            if (this.tjD != null) {
                r0 += a.a.a.b.b.a.f(10, this.tjD);
            }
            if (this.tjE != null) {
                r0 += a.a.a.b.b.a.f(11, this.tjE);
            }
            if (this.tjF != null) {
                r0 += a.a.a.a.eN(12, this.tjF.aUk());
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(13, this.leO);
            }
            r0 = (r0 + a.a.a.a.eL(14, this.tjG)) + a.a.a.a.eL(15, this.tjH);
            if (this.thC != null) {
                r0 += a.a.a.b.b.a.f(16, this.thC);
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
            gd gdVar = (gd) objArr[1];
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
                        gdVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    gdVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    gdVar.tjy = aVar3.xmD.readString();
                    return 0;
                case 4:
                    gdVar.thO = aVar3.xmD.mL();
                    return 0;
                case 5:
                    gdVar.tjz = aVar3.xmD.readString();
                    return 0;
                case 6:
                    gdVar.tjA = aVar3.xmD.mL();
                    return 0;
                case 7:
                    gdVar.tjB = aVar3.xmD.readString();
                    return 0;
                case 8:
                    gdVar.thq = aVar3.xmD.readString();
                    return 0;
                case 9:
                    gdVar.tjC = aVar3.xmD.mL();
                    return 0;
                case 10:
                    gdVar.tjD = aVar3.xmD.readString();
                    return 0;
                case 11:
                    gdVar.tjE = aVar3.xmD.readString();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        gdVar.tjF = emVar;
                    }
                    return 0;
                case 13:
                    gdVar.leO = aVar3.xmD.readString();
                    return 0;
                case 14:
                    gdVar.tjG = aVar3.xmD.mL();
                    return 0;
                case 15:
                    gdVar.tjH = aVar3.xmD.mL();
                    return 0;
                case 16:
                    gdVar.thC = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
