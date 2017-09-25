package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class z extends a {
    public LinkedList<String> jNT = new LinkedList();
    public String jNb;
    public long jOm;
    public long jOn;
    public String jOo;
    public String jOp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNb == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.jOo == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.jOp == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.jNb != null) {
                    aVar.e(1, this.jNb);
                }
                aVar.O(2, this.jOm);
                aVar.O(3, this.jOn);
                if (this.jOo != null) {
                    aVar.e(4, this.jOo);
                }
                if (this.jOp != null) {
                    aVar.e(5, this.jOp);
                }
                aVar.d(6, 1, this.jNT);
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
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(5, this.jOp);
            }
            return r0 + a.a.a.a.c(6, 1, this.jNT);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jNT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNb == null) {
                throw new b("Not all required fields were included: BakChatName");
            } else if (this.jOo == null) {
                throw new b("Not all required fields were included: MsgDataID");
            } else if (this.jOp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            z zVar = (z) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    zVar.jNb = aVar3.xmD.readString();
                    return 0;
                case 2:
                    zVar.jOm = aVar3.xmD.mM();
                    return 0;
                case 3:
                    zVar.jOn = aVar3.xmD.mM();
                    return 0;
                case 4:
                    zVar.jOo = aVar3.xmD.readString();
                    return 0;
                case 5:
                    zVar.jOp = aVar3.xmD.readString();
                    return 0;
                case 6:
                    zVar.jNT.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
