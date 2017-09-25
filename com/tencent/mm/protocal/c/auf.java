package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class auf extends a {
    public avx tXW;
    public int tXX;
    public LinkedList<axg> tXY = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tXW == null) {
                throw new b("Not all required fields were included: GroupName");
            }
            if (this.tXW != null) {
                aVar.eQ(1, this.tXW.aUk());
                this.tXW.a(aVar);
            }
            aVar.eO(2, this.tXX);
            aVar.d(3, 8, this.tXY);
            return 0;
        } else if (i == 1) {
            if (this.tXW != null) {
                r0 = a.a.a.a.eN(1, this.tXW.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.eL(2, this.tXX)) + a.a.a.a.c(3, 8, this.tXY);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tXY.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tXW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GroupName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auf com_tencent_mm_protocal_c_auf = (auf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auf.tXW = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auf.tXX = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new axg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auf.tXY.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
