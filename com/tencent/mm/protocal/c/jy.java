package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class jy extends a {
    public int ksW;
    public LinkedList<jz> tpX = new LinkedList();
    public int tpY;
    public avx tpZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.ksW);
            aVar.d(2, 8, this.tpX);
            aVar.eO(3, this.tpY);
            if (this.tpZ != null) {
                aVar.eQ(4, this.tpZ.aUk());
                this.tpZ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.ksW) + 0) + a.a.a.a.c(2, 8, this.tpX)) + a.a.a.a.eL(3, this.tpY);
            if (this.tpZ != null) {
                return r0 + a.a.a.a.eN(4, this.tpZ.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tpX.clear();
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
            jy jyVar = (jy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a jzVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jyVar.ksW = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jzVar = new jz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jzVar.a(aVar4, jzVar, a.a(aVar4))) {
                        }
                        jyVar.tpX.add(jzVar);
                    }
                    return 0;
                case 3:
                    jyVar.tpY = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        jzVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = jzVar.a(aVar4, jzVar, a.a(aVar4))) {
                        }
                        jyVar.tpZ = jzVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
