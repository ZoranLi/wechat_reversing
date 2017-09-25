package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class anz extends avh {
    public String tTd;
    public int tTe;
    public LinkedList<String> tTf = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tTd != null) {
                aVar.e(2, this.tTd);
            }
            aVar.eO(3, this.tTe);
            aVar.d(4, 1, this.tTf);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tTd != null) {
                r0 += a.a.a.b.b.a.f(2, this.tTd);
            }
            return (r0 + a.a.a.a.eL(3, this.tTe)) + a.a.a.a.c(4, 1, this.tTf);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tTf.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            anz com_tencent_mm_protocal_c_anz = (anz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anz.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anz.tTd = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anz.tTe = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anz.tTf.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
