package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class alj extends a {
    public float tPY;
    public float tPZ;
    public float tQa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.n(1, this.tPY);
            aVar.n(2, this.tPZ);
            aVar.n(3, this.tQa);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.b.b.a.cH(1) + 4) + 0) + (a.a.a.b.b.a.cH(2) + 4)) + (a.a.a.b.b.a.cH(3) + 4);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cid();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                alj com_tencent_mm_protocal_c_alj = (alj) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_alj.tPY = aVar3.xmD.readFloat();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_alj.tPZ = aVar3.xmD.readFloat();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_alj.tQa = aVar3.xmD.readFloat();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
