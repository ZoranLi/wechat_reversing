package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ot extends avh {
    public String leO;
    public String thC;
    public int thO;
    public avw tjF;
    public String tjK;
    public String tjk;
    public String tul;
    public String tum;
    public int tun;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tjF == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tjF != null) {
                aVar.eQ(2, this.tjF.aUk());
                this.tjF.a(aVar);
            }
            aVar.eO(3, this.thO);
            if (this.tjk != null) {
                aVar.e(4, this.tjk);
            }
            if (this.leO != null) {
                aVar.e(5, this.leO);
            }
            if (this.tjK != null) {
                aVar.e(6, this.tjK);
            }
            if (this.tul != null) {
                aVar.e(7, this.tul);
            }
            if (this.thC != null) {
                aVar.e(8, this.thC);
            }
            if (this.tum != null) {
                aVar.e(9, this.tum);
            }
            aVar.eO(10, this.tun);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tjF != null) {
                r0 += a.a.a.a.eN(2, this.tjF.aUk());
            }
            r0 += a.a.a.a.eL(3, this.thO);
            if (this.tjk != null) {
                r0 += a.a.a.b.b.a.f(4, this.tjk);
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(5, this.leO);
            }
            if (this.tjK != null) {
                r0 += a.a.a.b.b.a.f(6, this.tjK);
            }
            if (this.tul != null) {
                r0 += a.a.a.b.b.a.f(7, this.tul);
            }
            if (this.thC != null) {
                r0 += a.a.a.b.b.a.f(8, this.thC);
            }
            if (this.tum != null) {
                r0 += a.a.a.b.b.a.f(9, this.tum);
            }
            return r0 + a.a.a.a.eL(10, this.tun);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tjF != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ot otVar = (ot) objArr[1];
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
                        otVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        otVar.tjF = emVar;
                    }
                    return 0;
                case 3:
                    otVar.thO = aVar3.xmD.mL();
                    return 0;
                case 4:
                    otVar.tjk = aVar3.xmD.readString();
                    return 0;
                case 5:
                    otVar.leO = aVar3.xmD.readString();
                    return 0;
                case 6:
                    otVar.tjK = aVar3.xmD.readString();
                    return 0;
                case 7:
                    otVar.tul = aVar3.xmD.readString();
                    return 0;
                case 8:
                    otVar.thC = aVar3.xmD.readString();
                    return 0;
                case 9:
                    otVar.tum = aVar3.xmD.readString();
                    return 0;
                case 10:
                    otVar.tun = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
