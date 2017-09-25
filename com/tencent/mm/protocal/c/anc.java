package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class anc extends a {
    public String content;
    public String lang;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lang == null) {
                throw new b("Not all required fields were included: lang");
            } else if (this.content == null) {
                throw new b("Not all required fields were included: content");
            } else {
                if (this.lang != null) {
                    aVar.e(1, this.lang);
                }
                if (this.content == null) {
                    return 0;
                }
                aVar.e(2, this.content);
                return 0;
            }
        } else if (i == 1) {
            if (this.lang != null) {
                r0 = a.a.a.b.b.a.f(1, this.lang) + 0;
            } else {
                r0 = 0;
            }
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(2, this.content);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.lang == null) {
                throw new b("Not all required fields were included: lang");
            } else if (this.content != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            anc com_tencent_mm_protocal_c_anc = (anc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_anc.lang = aVar3.xmD.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anc.content = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
