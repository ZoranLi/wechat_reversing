package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class ij extends a {
    public String tiy;
    public String tnl;
    public int tnm;
    public String tnn;
    public String tno;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tnl != null) {
                aVar.e(1, this.tnl);
            }
            aVar.eO(2, this.tnm);
            if (this.tnn != null) {
                aVar.e(3, this.tnn);
            }
            if (this.tiy != null) {
                aVar.e(4, this.tiy);
            }
            if (this.tno == null) {
                return 0;
            }
            aVar.e(5, this.tno);
            return 0;
        } else if (i == 1) {
            if (this.tnl != null) {
                r0 = a.a.a.b.b.a.f(1, this.tnl) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tnm);
            if (this.tnn != null) {
                r0 += a.a.a.b.b.a.f(3, this.tnn);
            }
            if (this.tiy != null) {
                r0 += a.a.a.b.b.a.f(4, this.tiy);
            }
            if (this.tno != null) {
                r0 += a.a.a.b.b.a.f(5, this.tno);
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
            ij ijVar = (ij) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ijVar.tnl = aVar3.xmD.readString();
                    return 0;
                case 2:
                    ijVar.tnm = aVar3.xmD.mL();
                    return 0;
                case 3:
                    ijVar.tnn = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ijVar.tiy = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ijVar.tno = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
