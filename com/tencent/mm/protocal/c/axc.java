package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class axc extends a {
    public String tDX;
    public aiz tOl;
    public int tZJ;
    public LinkedList<bin> tZK = new LinkedList();
    public long tlY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tDX == null) {
                throw new b("Not all required fields were included: KeyWord");
            }
            aVar.O(1, this.tlY);
            if (this.tDX != null) {
                aVar.e(2, this.tDX);
            }
            if (this.tOl != null) {
                aVar.eQ(3, this.tOl.aUk());
                this.tOl.a(aVar);
            }
            aVar.eO(4, this.tZJ);
            aVar.d(5, 8, this.tZK);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.tlY) + 0;
            if (this.tDX != null) {
                r0 += a.a.a.b.b.a.f(2, this.tDX);
            }
            if (this.tOl != null) {
                r0 += a.a.a.a.eN(3, this.tOl.aUk());
            }
            return (r0 + a.a.a.a.eL(4, this.tZJ)) + a.a.a.a.c(5, 8, this.tZK);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tZK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tDX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyWord");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            axc com_tencent_mm_protocal_c_axc = (axc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_aiz;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_axc.tlY = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_axc.tDX = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new aiz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axc.tOl = com_tencent_mm_protocal_c_aiz;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_axc.tZJ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_aiz = new bin();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aiz.a(aVar4, com_tencent_mm_protocal_c_aiz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axc.tZK.add(com_tencent_mm_protocal_c_aiz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
