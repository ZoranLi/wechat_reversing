package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class akw extends avh {
    public LinkedList<aky> tOD = new LinkedList();
    public int tOE;
    public String tOF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.d(2, 8, this.tOD);
            aVar.eO(3, this.tOE);
            if (this.tOF == null) {
                return 0;
            }
            aVar.e(4, this.tOF);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.c(2, 8, this.tOD)) + a.a.a.a.eL(3, this.tOE);
            if (this.tOF != null) {
                r0 += a.a.a.b.b.a.f(4, this.tOF);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tOD.clear();
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
            akw com_tencent_mm_protocal_c_akw = (akw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akw.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new aky();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akw.tOD.add(emVar);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akw.tOE = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akw.tOF = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
