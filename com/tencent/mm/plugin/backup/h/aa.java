package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class aa extends a {
    public String jNb;
    public long jOm;
    public long jOn;
    public String jOo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNb == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.jOo == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else {
                if (this.jNb != null) {
                    aVar.e(1, this.jNb);
                }
                aVar.O(2, this.jOm);
                aVar.O(3, this.jOn);
                if (this.jOo == null) {
                    return 0;
                }
                aVar.e(4, this.jOo);
                return 0;
            }
        } else if (i == 1) {
            if (this.jNb != null) {
                r0 = a.a.a.b.b.a.f(1, this.jNb) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.N(2, this.jOm)) + a.a.a.a.N(3, this.jOn);
            if (this.jOo != null) {
                r0 += a.a.a.b.b.a.f(4, this.jOo);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNb == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.jOo != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MsgDataID");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aaVar.jNb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    aaVar.jOm = aVar3.xmD.mM();
                    return 0;
                case 3:
                    aaVar.jOn = aVar3.xmD.mM();
                    return 0;
                case 4:
                    aaVar.jOo = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
