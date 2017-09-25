package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class p extends avh {
    public String oQK;
    public int scene;
    public long tbA;
    public String tbC;
    public String tbh;
    public String tbi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tbh != null) {
                aVar.e(2, this.tbh);
            }
            aVar.O(3, this.tbA);
            aVar.eO(4, this.scene);
            if (this.tbi != null) {
                aVar.e(5, this.tbi);
            }
            if (this.tbC != null) {
                aVar.e(6, this.tbC);
            }
            if (this.oQK == null) {
                return 0;
            }
            aVar.e(7, this.oQK);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tbh != null) {
                r0 += a.a.a.b.b.a.f(2, this.tbh);
            }
            r0 = (r0 + a.a.a.a.N(3, this.tbA)) + a.a.a.a.eL(4, this.scene);
            if (this.tbi != null) {
                r0 += a.a.a.b.b.a.f(5, this.tbi);
            }
            if (this.tbC != null) {
                r0 += a.a.a.b.b.a.f(6, this.tbC);
            }
            if (this.oQK != null) {
                r0 += a.a.a.b.b.a.f(7, this.oQK);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        pVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    pVar.tbh = aVar3.xmD.readString();
                    return 0;
                case 3:
                    pVar.tbA = aVar3.xmD.mM();
                    return 0;
                case 4:
                    pVar.scene = aVar3.xmD.mL();
                    return 0;
                case 5:
                    pVar.tbi = aVar3.xmD.readString();
                    return 0;
                case 6:
                    pVar.tbC = aVar3.xmD.readString();
                    return 0;
                case 7:
                    pVar.oQK = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
