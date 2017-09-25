package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class rl extends a {
    public int jNB;
    public String tng;
    public int tnh;
    public String tql;
    public String tqm;
    public String tqn;
    public int tqo;
    public String twY;
    public String twZ;
    public int txa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tql != null) {
                aVar.e(1, this.tql);
            }
            if (this.tqm != null) {
                aVar.e(2, this.tqm);
            }
            if (this.tqn != null) {
                aVar.e(3, this.tqn);
            }
            aVar.eO(4, this.tqo);
            if (this.twY != null) {
                aVar.e(5, this.twY);
            }
            if (this.tng != null) {
                aVar.e(6, this.tng);
            }
            aVar.eO(7, this.tnh);
            if (this.twZ != null) {
                aVar.e(8, this.twZ);
            }
            aVar.eO(9, this.jNB);
            aVar.eO(10, this.txa);
            return 0;
        } else if (i == 1) {
            if (this.tql != null) {
                r0 = a.a.a.b.b.a.f(1, this.tql) + 0;
            } else {
                r0 = 0;
            }
            if (this.tqm != null) {
                r0 += a.a.a.b.b.a.f(2, this.tqm);
            }
            if (this.tqn != null) {
                r0 += a.a.a.b.b.a.f(3, this.tqn);
            }
            r0 += a.a.a.a.eL(4, this.tqo);
            if (this.twY != null) {
                r0 += a.a.a.b.b.a.f(5, this.twY);
            }
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(6, this.tng);
            }
            r0 += a.a.a.a.eL(7, this.tnh);
            if (this.twZ != null) {
                r0 += a.a.a.b.b.a.f(8, this.twZ);
            }
            return (r0 + a.a.a.a.eL(9, this.jNB)) + a.a.a.a.eL(10, this.txa);
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
            rl rlVar = (rl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rlVar.tql = aVar3.xmD.readString();
                    return 0;
                case 2:
                    rlVar.tqm = aVar3.xmD.readString();
                    return 0;
                case 3:
                    rlVar.tqn = aVar3.xmD.readString();
                    return 0;
                case 4:
                    rlVar.tqo = aVar3.xmD.mL();
                    return 0;
                case 5:
                    rlVar.twY = aVar3.xmD.readString();
                    return 0;
                case 6:
                    rlVar.tng = aVar3.xmD.readString();
                    return 0;
                case 7:
                    rlVar.tnh = aVar3.xmD.mL();
                    return 0;
                case 8:
                    rlVar.twZ = aVar3.xmD.readString();
                    return 0;
                case 9:
                    rlVar.jNB = aVar3.xmD.mL();
                    return 0;
                case 10:
                    rlVar.txa = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
