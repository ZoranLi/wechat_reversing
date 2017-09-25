package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class alp extends a {
    public String fNG;
    public String tQu;
    public String tQv;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fNG == null) {
                throw new b("Not all required fields were included: wording");
            }
            aVar.eO(1, this.type);
            if (this.fNG != null) {
                aVar.e(2, this.fNG);
            }
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            if (this.tQu != null) {
                aVar.e(4, this.tQu);
            }
            if (this.tQv != null) {
                aVar.e(5, this.tQv);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.type) + 0;
            if (this.fNG != null) {
                r0 += a.a.a.b.b.a.f(2, this.fNG);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(3, this.url);
            }
            if (this.tQu != null) {
                r0 += a.a.a.b.b.a.f(4, this.tQu);
            }
            if (this.tQv != null) {
                return r0 + a.a.a.b.b.a.f(5, this.tQv);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.fNG != null) {
                return 0;
            }
            throw new b("Not all required fields were included: wording");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alp com_tencent_mm_protocal_c_alp = (alp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_alp.type = aVar3.xmD.mL();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alp.fNG = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alp.url = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alp.tQu = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alp.tQv = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
