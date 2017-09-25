package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class asm extends a {
    public String fVl;
    public int tWN;
    public boolean tWO;
    public String tWP;
    public int tWQ;
    public int tWR;
    public LinkedList<asl> tWS = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fVl != null) {
                aVar.e(1, this.fVl);
            }
            aVar.eO(2, this.tWN);
            aVar.an(3, this.tWO);
            if (this.tWP != null) {
                aVar.e(4, this.tWP);
            }
            aVar.eO(5, this.tWQ);
            aVar.eO(6, this.tWR);
            aVar.d(7, 8, this.tWS);
            return 0;
        } else if (i == 1) {
            if (this.fVl != null) {
                r0 = a.a.a.b.b.a.f(1, this.fVl) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tWN)) + (a.a.a.b.b.a.cH(3) + 1);
            if (this.tWP != null) {
                r0 += a.a.a.b.b.a.f(4, this.tWP);
            }
            return ((r0 + a.a.a.a.eL(5, this.tWQ)) + a.a.a.a.eL(6, this.tWR)) + a.a.a.a.c(7, 8, this.tWS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tWS.clear();
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
            asm com_tencent_mm_protocal_c_asm = (asm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_asm.fVl = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_asm.tWN = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asm.tWO = aVar3.cib();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asm.tWP = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asm.tWQ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asm.tWR = aVar3.xmD.mL();
                    return 0;
                case 7:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_asl = new asl();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_asl.a(aVar4, com_tencent_mm_protocal_c_asl, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asm.tWS.add(com_tencent_mm_protocal_c_asl);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
