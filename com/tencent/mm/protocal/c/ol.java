package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ol extends avh {
    public int tfc;
    public long tfk;
    public int tgJ;
    public int tgK;
    public int tua;
    public int tub;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tfc);
            aVar.eO(3, this.tgJ);
            aVar.eO(4, this.tgK);
            aVar.eO(5, this.tua);
            aVar.eO(6, this.tub);
            aVar.O(7, this.tfk);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + a.a.a.a.eL(2, this.tfc)) + a.a.a.a.eL(3, this.tgJ)) + a.a.a.a.eL(4, this.tgK)) + a.a.a.a.eL(5, this.tua)) + a.a.a.a.eL(6, this.tub)) + a.a.a.a.N(7, this.tfk);
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
            ol olVar = (ol) objArr[1];
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
                        olVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    olVar.tfc = aVar3.xmD.mL();
                    return 0;
                case 3:
                    olVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    olVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 5:
                    olVar.tua = aVar3.xmD.mL();
                    return 0;
                case 6:
                    olVar.tub = aVar3.xmD.mL();
                    return 0;
                case 7:
                    olVar.tfk = aVar3.xmD.mM();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
