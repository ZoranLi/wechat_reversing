package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class qn extends a {
    public String tvX;
    public String twi;
    public LinkedList<String> twj = new LinkedList();
    public boolean twk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tvX == null) {
                throw new b("Not all required fields were included: LoginUrl");
            }
            if (this.tvX != null) {
                aVar.e(1, this.tvX);
            }
            if (this.twi != null) {
                aVar.e(2, this.twi);
            }
            aVar.d(3, 1, this.twj);
            aVar.an(4, this.twk);
            return 0;
        } else if (i == 1) {
            if (this.tvX != null) {
                r0 = a.a.a.b.b.a.f(1, this.tvX) + 0;
            } else {
                r0 = 0;
            }
            if (this.twi != null) {
                r0 += a.a.a.b.b.a.f(2, this.twi);
            }
            return (r0 + a.a.a.a.c(3, 1, this.twj)) + (a.a.a.b.b.a.cH(4) + 1);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.twj.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tvX != null) {
                return 0;
            }
            throw new b("Not all required fields were included: LoginUrl");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            qn qnVar = (qn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qnVar.tvX = aVar3.xmD.readString();
                    return 0;
                case 2:
                    qnVar.twi = aVar3.xmD.readString();
                    return 0;
                case 3:
                    qnVar.twj.add(aVar3.xmD.readString());
                    return 0;
                case 4:
                    qnVar.twk = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
