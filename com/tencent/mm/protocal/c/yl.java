package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class yl extends avh {
    public String jNj;
    public int tEQ;
    public int tER;
    public String tES;
    public int tET;
    public int tgJ;
    public int tgK;

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
            aVar.eO(3, this.tEQ);
            aVar.eO(4, this.tER);
            if (this.tES != null) {
                aVar.e(5, this.tES);
            }
            aVar.eO(6, this.tgJ);
            aVar.eO(7, this.tgK);
            aVar.eO(8, this.tET);
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
            r0 = (r0 + a.a.a.a.eL(3, this.tEQ)) + a.a.a.a.eL(4, this.tER);
            if (this.tES != null) {
                r0 += a.a.a.b.b.a.f(5, this.tES);
            }
            return ((r0 + a.a.a.a.eL(6, this.tgJ)) + a.a.a.a.eL(7, this.tgK)) + a.a.a.a.eL(8, this.tET);
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
            yl ylVar = (yl) objArr[1];
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
                        ylVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    ylVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ylVar.tEQ = aVar3.xmD.mL();
                    return 0;
                case 4:
                    ylVar.tER = aVar3.xmD.mL();
                    return 0;
                case 5:
                    ylVar.tES = aVar3.xmD.readString();
                    return 0;
                case 6:
                    ylVar.tgJ = aVar3.xmD.mL();
                    return 0;
                case 7:
                    ylVar.tgK = aVar3.xmD.mL();
                    return 0;
                case 8:
                    ylVar.tET = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
