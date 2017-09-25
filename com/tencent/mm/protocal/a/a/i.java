package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class i extends a {
    public int taE;
    public int taG;
    public LinkedList<e> taH = new LinkedList();
    public b taI;
    public int taq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.taq);
            aVar.eO(2, this.taG);
            aVar.eO(3, this.taE);
            aVar.d(4, 8, this.taH);
            if (this.taI != null) {
                aVar.b(5, this.taI);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.eL(1, this.taq) + 0) + a.a.a.a.eL(2, this.taG)) + a.a.a.a.eL(3, this.taE)) + a.a.a.a.c(4, 8, this.taH);
            if (this.taI != null) {
                return r0 + a.a.a.a.a(5, this.taI);
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.taq = aVar3.xmD.mL();
                    return 0;
                case 2:
                    iVar.taG = aVar3.xmD.mL();
                    return 0;
                case 3:
                    iVar.taE = aVar3.xmD.mL();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        iVar.taH.add(eVar);
                    }
                    return 0;
                case 5:
                    iVar.taI = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
