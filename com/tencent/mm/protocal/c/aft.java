package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;

public final class aft extends a {
    public String desc;
    public String tKP;
    public String tKQ;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.tKP != null) {
                aVar.e(3, this.tKP);
            }
            if (this.tKQ == null) {
                return 0;
            }
            aVar.e(4, this.tKQ);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            if (this.tKP != null) {
                r0 += a.a.a.b.b.a.f(3, this.tKP);
            }
            if (this.tKQ != null) {
                r0 += a.a.a.b.b.a.f(4, this.tKQ);
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
            aft com_tencent_mm_protocal_c_aft = (aft) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aft.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aft.desc = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aft.tKP = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aft.tKQ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
