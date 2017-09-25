package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class nn extends a {
    public int jNd;
    public avx ttp;
    public LinkedList<Integer> ttw = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.ttp != null) {
                aVar.eQ(1, this.ttp.aUk());
                this.ttp.a(aVar);
            }
            aVar.eO(2, this.jNd);
            aVar.c(3, this.ttw);
            return 0;
        } else if (i == 1) {
            if (this.ttp != null) {
                r0 = a.a.a.a.eN(1, this.ttp.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.eL(2, this.jNd)) + a.a.a.a.b(3, this.ttw);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ttw.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttp != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            nn nnVar = (nn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_avx = new avx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        nnVar.ttp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    nnVar.jNd = aVar3.xmD.mL();
                    return 0;
                case 3:
                    nnVar.ttw = new a.a.a.a.a(aVar3.cic().sYA, unknownTagHandler).chZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
