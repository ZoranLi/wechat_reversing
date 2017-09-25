package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ag extends a {
    public String jNb;
    public LinkedList<Long> jOx = new LinkedList();
    public LinkedList<String> jOy = new LinkedList();
    public LinkedList<String> jOz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.jNb == null) {
                throw new b("Not all required fields were included: BakChatName");
            }
            aVar.d(1, 3, this.jOx);
            aVar.d(2, 1, this.jOy);
            aVar.d(3, 1, this.jOz);
            if (this.jNb != null) {
                aVar.e(4, this.jNb);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.c(1, 3, this.jOx) + 0) + a.a.a.a.c(2, 1, this.jOy)) + a.a.a.a.c(3, 1, this.jOz);
            if (this.jNb != null) {
                return r0 + a.a.a.b.b.a.f(4, this.jNb);
            }
            return r0;
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.jOx.clear();
            this.jOy.clear();
            this.jOz.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jNb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BakChatName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ag agVar = (ag) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agVar.jOx.add(Long.valueOf(aVar3.xmD.mM()));
                    return 0;
                case 2:
                    agVar.jOy.add(aVar3.xmD.readString());
                    return 0;
                case 3:
                    agVar.jOz.add(aVar3.xmD.readString());
                    return 0;
                case 4:
                    agVar.jNb = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
