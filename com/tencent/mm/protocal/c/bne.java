package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bne extends a {
    public String jNj;
    public int jOc;
    public String jOp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.jOp == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.jNj != null) {
                    aVar.e(1, this.jNj);
                }
                if (this.jOp != null) {
                    aVar.e(2, this.jOp);
                }
                aVar.eO(3, this.jOc);
                return 0;
            }
        } else if (i == 1) {
            if (this.jNj != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNj) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            return r0 + a.a.a.a.eL(3, this.jOc);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNj == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.jOp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bne com_tencent_mm_protocal_c_bne = (bne) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bne.jNj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bne.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bne.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
