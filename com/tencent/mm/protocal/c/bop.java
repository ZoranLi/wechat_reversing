package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bop extends a {
    public String une;
    public String unf;
    public String ung;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.une == null) {
                throw new b("Not all required fields were included: Plugin");
            } else if (this.unf == null) {
                throw new b("Not all required fields were included: ActivityPath");
            } else {
                if (this.une != null) {
                    aVar.e(1, this.une);
                }
                if (this.unf != null) {
                    aVar.e(2, this.unf);
                }
                if (this.ung == null) {
                    return 0;
                }
                aVar.e(3, this.ung);
                return 0;
            }
        } else if (i == 1) {
            if (this.une != null) {
                r0 = a.a.a.b.b.a.f(1, this.une) + 0;
            } else {
                r0 = 0;
            }
            if (this.unf != null) {
                r0 += a.a.a.b.b.a.f(2, this.unf);
            }
            if (this.ung != null) {
                r0 += a.a.a.b.b.a.f(3, this.ung);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.une == null) {
                throw new b("Not all required fields were included: Plugin");
            } else if (this.unf != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ActivityPath");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bop com_tencent_mm_protocal_c_bop = (bop) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bop.une = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bop.unf = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bop.ung = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
