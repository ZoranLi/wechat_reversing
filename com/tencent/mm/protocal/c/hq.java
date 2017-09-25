package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class hq extends a {
    public int port;
    public b tlM;
    public b tlN;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.type);
            aVar.eO(2, this.port);
            if (this.tlM != null) {
                aVar.b(3, this.tlM);
            }
            if (this.tlN != null) {
                aVar.b(4, this.tlN);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.eL(1, this.type) + 0) + a.a.a.a.eL(2, this.port);
            if (this.tlM != null) {
                r0 += a.a.a.a.a(3, this.tlM);
            }
            if (this.tlN != null) {
                return r0 + a.a.a.a.a(4, this.tlN);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            hq hqVar = (hq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hqVar.type = aVar3.xmD.mL();
                    return 0;
                case 2:
                    hqVar.port = aVar3.xmD.mL();
                    return 0;
                case 3:
                    hqVar.tlM = aVar3.cic();
                    return 0;
                case 4:
                    hqVar.tlN = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
