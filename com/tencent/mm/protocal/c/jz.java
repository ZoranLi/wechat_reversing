package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class jz extends a {
    public String jNj;
    public String jOp;
    public String tqa;
    public String tqb;
    public String tqc;
    public int tqd;
    public String tqe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj != null) {
                aVar.e(1, this.jNj);
            }
            if (this.jOp != null) {
                aVar.e(2, this.jOp);
            }
            if (this.tqa != null) {
                aVar.e(3, this.tqa);
            }
            if (this.tqb != null) {
                aVar.e(4, this.tqb);
            }
            if (this.tqc != null) {
                aVar.e(5, this.tqc);
            }
            aVar.eO(6, this.tqd);
            if (this.tqe == null) {
                return 0;
            }
            aVar.e(7, this.tqe);
            return 0;
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            if (this.tqa != null) {
                r0 += a.a.a.b.b.a.f(3, this.tqa);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(4, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(5, this.tqc);
            }
            r0 += a.a.a.a.eL(6, this.tqd);
            if (this.tqe != null) {
                r0 += a.a.a.b.b.a.f(7, this.tqe);
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
            jz jzVar = (jz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jzVar.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    jzVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    jzVar.tqa = aVar3.xmD.readString();
                    return 0;
                case 4:
                    jzVar.tqb = aVar3.xmD.readString();
                    return 0;
                case 5:
                    jzVar.tqc = aVar3.xmD.readString();
                    return 0;
                case 6:
                    jzVar.tqd = aVar3.xmD.mL();
                    return 0;
                case 7:
                    jzVar.tqe = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
