package com.tencent.mm.plugin.exdevice.e;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class n extends a {
    public c lfg;
    public int lfk;
    public int lfl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lfg == null) {
                throw new b("Not all required fields were included: BasePush");
            }
            if (this.lfg != null) {
                aVar.eQ(1, this.lfg.aUk());
                this.lfg.a(aVar);
            }
            aVar.eO(2, this.lfk);
            aVar.eO(3, this.lfl);
            return 0;
        } else if (i == 1) {
            if (this.lfg != null) {
                r0 = a.a.a.a.eN(1, this.lfg.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.eL(2, this.lfk)) + a.a.a.a.eL(3, this.lfl);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.lfg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BasePush");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a cVar = new c();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        nVar.lfg = cVar;
                    }
                    return 0;
                case 2:
                    nVar.lfk = aVar3.xmD.mL();
                    return 0;
                case 3:
                    nVar.lfl = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
