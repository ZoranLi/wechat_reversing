package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;

public final class bot extends a {
    public String jOp;
    public String umH;
    public b umz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.jOp == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else {
                if (this.umH != null) {
                    aVar.e(1, this.umH);
                }
                if (this.jOp != null) {
                    aVar.e(2, this.jOp);
                }
                if (this.umz == null) {
                    return 0;
                }
                aVar.b(3, this.umz);
                return 0;
            }
        } else if (i == 1) {
            if (this.umH != null) {
                r0 = a.a.a.b.b.a.f(1, this.umH) + 0;
            } else {
                r0 = 0;
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(2, this.jOp);
            }
            if (this.umz != null) {
                r0 += a.a.a.a.a(3, this.umz);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.umH == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.jOp != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bot com_tencent_mm_protocal_c_bot = (bot) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bot.umH = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bot.jOp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bot.umz = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
