package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class on extends avh {
    public String tfU;
    public int tfc;
    public long tfk;
    public int tll;
    public String ttq;
    public int tuc;
    public long tud;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.eO(1, this.tfc);
            aVar.eO(2, this.tll);
            aVar.eO(3, this.tuc);
            if (this.tfU != null) {
                aVar.e(4, this.tfU);
            }
            if (this.tYN != null) {
                aVar.eQ(5, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.O(6, this.tfk);
            if (this.ttq != null) {
                aVar.e(7, this.ttq);
            }
            aVar.O(8, this.tud);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.tfc) + 0) + a.a.a.a.eL(2, this.tll)) + a.a.a.a.eL(3, this.tuc);
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(4, this.tfU);
            }
            if (this.tYN != null) {
                r0 += a.a.a.a.eN(5, this.tYN.aUk());
            }
            r0 += a.a.a.a.N(6, this.tfk);
            if (this.ttq != null) {
                r0 += a.a.a.b.b.a.f(7, this.ttq);
            }
            return r0 + a.a.a.a.N(8, this.tud);
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
            on onVar = (on) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    onVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    onVar.tll = aVar3.xmD.mL();
                    return 0;
                case 3:
                    onVar.tuc = aVar3.xmD.mL();
                    return 0;
                case 4:
                    onVar.tfU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        onVar.tYN = emVar;
                    }
                    return 0;
                case 6:
                    onVar.tfk = aVar3.xmD.mM();
                    return 0;
                case 7:
                    onVar.ttq = aVar3.xmD.readString();
                    return 0;
                case 8:
                    onVar.tud = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
