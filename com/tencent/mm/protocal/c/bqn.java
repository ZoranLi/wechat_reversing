package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class bqn extends a {
    public String huw;
    public String ofg;
    public String title;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.huw != null) {
                aVar.e(3, this.huw);
            }
            if (this.ofg == null) {
                return 0;
            }
            aVar.e(4, this.ofg);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                r0 = a.a.a.b.b.a.f(1, this.username) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            if (this.huw != null) {
                r0 += a.a.a.b.b.a.f(3, this.huw);
            }
            if (this.ofg != null) {
                r0 += a.a.a.b.b.a.f(4, this.ofg);
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
            bqn com_tencent_mm_protocal_c_bqn = (bqn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bqn.username = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bqn.title = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bqn.huw = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bqn.ofg = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
