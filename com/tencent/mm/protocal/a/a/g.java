package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class g extends a {
    public int taG;
    public LinkedList<b> taH = new LinkedList();
    public b taI;
    public int taq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.taq);
            aVar.eO(2, this.taG);
            aVar.d(3, 8, this.taH);
            if (this.taI != null) {
                aVar.b(4, this.taI);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.taq) + 0) + a.a.a.a.eL(2, this.taG)) + a.a.a.a.c(3, 8, this.taH);
            if (this.taI != null) {
                return r0 + a.a.a.a.a(4, this.taI);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.taH.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gVar.taq = aVar3.xmD.mL();
                    return 0;
                case 2:
                    gVar.taG = aVar3.xmD.mL();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a bVar = new b();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        gVar.taH.add(bVar);
                    }
                    return 0;
                case 4:
                    gVar.taI = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
