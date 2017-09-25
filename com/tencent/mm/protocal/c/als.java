package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class als extends a {
    public String nzA;
    public LinkedList<String> tQy = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.nzA != null) {
                aVar.e(1, this.nzA);
            }
            aVar.d(2, 1, this.tQy);
            return 0;
        } else if (i == 1) {
            if (this.nzA != null) {
                r0 = a.a.a.b.b.a.f(1, this.nzA) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 1, this.tQy);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.tQy.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
            als com_tencent_mm_protocal_c_als = (als) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_als.nzA = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_als.tQy.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
