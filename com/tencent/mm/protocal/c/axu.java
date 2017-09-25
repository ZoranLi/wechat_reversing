package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class axu extends avh {
    public int ual;
    public LinkedList<Integer> uam = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.ual);
            aVar.c(3, this.uam);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.eL(2, this.ual)) + a.a.a.a.b(3, this.uam);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uam.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            axu com_tencent_mm_protocal_c_axu = (axu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axu.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axu.ual = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_axu.uam = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
