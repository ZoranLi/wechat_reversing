package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class mk extends a {
    public String fDC;
    public String msN;
    public String msk;
    public int tsN;
    public LinkedList<alh> tsO = new LinkedList();
    public int tsP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msk != null) {
                aVar.e(1, this.msk);
            }
            aVar.eO(2, this.tsN);
            if (this.fDC != null) {
                aVar.e(3, this.fDC);
            }
            if (this.msN != null) {
                aVar.e(4, this.msN);
            }
            aVar.d(5, 8, this.tsO);
            aVar.eO(6, this.tsP);
            return 0;
        } else if (i == 1) {
            if (this.msk != null) {
                r0 = a.a.a.b.b.a.f(1, this.msk) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tsN);
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(3, this.fDC);
            }
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(4, this.msN);
            }
            return (r0 + a.a.a.a.c(5, 8, this.tsO)) + a.a.a.a.eL(6, this.tsP);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tsO.clear();
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
            mk mkVar = (mk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mkVar.msk = aVar3.xmD.readString();
                    return 0;
                case 2:
                    mkVar.tsN = aVar3.xmD.mL();
                    return 0;
                case 3:
                    mkVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    mkVar.msN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_alh = new alh();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_alh.a(aVar4, com_tencent_mm_protocal_c_alh, a.a(aVar4))) {
                        }
                        mkVar.tsO.add(com_tencent_mm_protocal_c_alh);
                    }
                    return 0;
                case 6:
                    mkVar.tsP = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
