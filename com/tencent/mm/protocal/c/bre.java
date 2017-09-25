package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class bre extends a {
    public String hhW;
    public String title;
    public int uoY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hhW == null) {
                throw new b("Not all required fields were included: rankid");
            } else if (this.title == null) {
                throw new b("Not all required fields were included: title");
            } else {
                if (this.hhW != null) {
                    aVar.e(1, this.hhW);
                }
                if (this.title != null) {
                    aVar.e(2, this.title);
                }
                aVar.eO(3, this.uoY);
                return 0;
            }
        } else if (i == 1) {
            if (this.hhW != null) {
                r0 = a.a.a.b.b.a.f(1, this.hhW) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            return r0 + a.a.a.a.eL(3, this.uoY);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.hhW == null) {
                throw new b("Not all required fields were included: rankid");
            } else if (this.title != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: title");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bre com_tencent_mm_protocal_c_bre = (bre) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bre.hhW = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bre.title = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bre.uoY = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
