package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class oj extends avh {
    public String jNj;
    public int jOc;
    public String mtb;
    public int tfT;
    public long tfk;
    public int tgJ;
    public int tgK;
    public int tgL;
    public String ttW;
    public String ttX;
    public int ttY;
    public int ttZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            aVar.eO(3, this.tfT);
            if (this.ttW != null) {
                aVar.e(4, this.ttW);
            }
            if (this.jNj != null) {
                aVar.e(5, this.jNj);
            }
            aVar.eO(6, this.tgJ);
            aVar.eO(7, this.tgK);
            aVar.eO(8, this.tgL);
            if (this.ttX != null) {
                aVar.e(9, this.ttX);
            }
            aVar.eO(10, this.ttY);
            aVar.eO(11, this.jOc);
            aVar.eO(12, this.ttZ);
            aVar.O(13, this.tfk);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            r0 += a.a.a.a.eL(3, this.tfT);
            if (this.ttW != null) {
                r0 += a.a.a.b.b.a.f(4, this.ttW);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(5, this.jNj);
            }
            r0 = ((r0 + a.a.a.a.eL(6, this.tgJ)) + a.a.a.a.eL(7, this.tgK)) + a.a.a.a.eL(8, this.tgL);
            if (this.ttX != null) {
                r0 += a.a.a.b.b.a.f(9, this.ttX);
            }
            return (((r0 + a.a.a.a.eL(10, this.ttY)) + a.a.a.a.eL(11, this.jOc)) + a.a.a.a.eL(12, this.ttZ)) + a.a.a.a.N(13, this.tfk);
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
            oj ojVar = (oj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        ojVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    ojVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ojVar.tfT = aVar3.xmD.mL();
                    return 0;
                case 4:
                    ojVar.ttW = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ojVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 6:
                    ojVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    ojVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 8:
                    ojVar.tgL = aVar3.xmD.mL();
                    return 0;
                case 9:
                    ojVar.ttX = aVar3.xmD.readString();
                    return 0;
                case 10:
                    ojVar.ttY = aVar3.xmD.mL();
                    return 0;
                case 11:
                    ojVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 12:
                    ojVar.ttZ = aVar3.xmD.mL();
                    return 0;
                case 13:
                    ojVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
