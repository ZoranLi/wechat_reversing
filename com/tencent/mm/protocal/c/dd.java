package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class dd extends a {
    public int tgD;
    public de tgE;
    public int tgv;
    public int tgw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.tgv);
            aVar.eO(2, this.tgw);
            aVar.eO(3, this.tgD);
            if (this.tgE != null) {
                aVar.eQ(4, this.tgE.aUk());
                this.tgE.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.tgv) + 0) + a.a.a.a.eL(2, this.tgw)) + a.a.a.a.eL(3, this.tgD);
            if (this.tgE != null) {
                return r0 + a.a.a.a.eN(4, this.tgE.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dd ddVar = (dd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ddVar.tgv = aVar3.xmD.mL();
                    return 0;
                case 2:
                    ddVar.tgw = aVar3.xmD.mL();
                    return 0;
                case 3:
                    ddVar.tgD = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a deVar = new de();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = deVar.a(aVar4, deVar, a.a(aVar4))) {
                        }
                        ddVar.tgE = deVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
