package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bnm extends a {
    public String jNj;
    public String jOp;
    public int mvT;
    public String opI;
    public b umz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNj == null) {
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.jOp == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.opI == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.eO(1, this.mvT);
                if (this.jNj != null) {
                    aVar.e(2, this.jNj);
                }
                if (this.jOp != null) {
                    aVar.e(3, this.jOp);
                }
                if (this.opI != null) {
                    aVar.e(4, this.opI);
                }
                if (this.umz != null) {
                    aVar.b(5, this.umz);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.mvT) + 0;
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(3, this.jOp);
            }
            if (this.opI != null) {
                r0 += a.a.a.b.b.a.f(4, this.opI);
            }
            if (this.umz != null) {
                return r0 + a.a.a.a.a(5, this.umz);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNj == null) {
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.jOp == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.opI != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bnm com_tencent_mm_protocal_c_bnm = (bnm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bnm.mvT = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bnm.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bnm.jOp = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bnm.opI = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bnm.umz = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
