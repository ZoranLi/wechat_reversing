package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class acd extends avh {
    public int cGa;
    public String fTO;
    public boolean tHK;
    public LinkedList<String> tHL = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.fTO != null) {
                aVar.e(2, this.fTO);
            }
            aVar.an(3, this.tHK);
            aVar.d(4, 1, this.tHL);
            aVar.eO(5, this.cGa);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.fTO != null) {
                r0 += a.a.a.b.b.a.f(2, this.fTO);
            }
            return ((r0 + (a.a.a.b.b.a.cH(3) + 1)) + a.a.a.a.c(4, 1, this.tHL)) + a.a.a.a.eL(5, this.cGa);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tHL.clear();
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
            acd com_tencent_mm_protocal_c_acd = (acd) objArr[1];
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
                        com_tencent_mm_protocal_c_acd.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acd.fTO = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_acd.tHK = aVar3.cib();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_acd.tHL.add(aVar3.xmD.readString());
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_acd.cGa = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
