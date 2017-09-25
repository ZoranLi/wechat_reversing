package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.bd.a;

public final class s extends a {
    public long jNU;
    public long jNV;
    public long jNx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.O(1, this.jNx);
            aVar.O(2, this.jNU);
            aVar.O(3, this.jNV);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.N(1, this.jNx) + 0) + a.a.a.a.N(2, this.jNU)) + a.a.a.a.N(3, this.jNV);
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
                s sVar = (s) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        sVar.jNx = aVar3.xmD.mM();
                        return 0;
                    case 2:
                        sVar.jNU = aVar3.xmD.mM();
                        return 0;
                    case 3:
                        sVar.jNV = aVar3.xmD.mM();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
