package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class ad extends a {
    public LinkedList<String> mtB = new LinkedList();
    public String mtg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtg == null) {
                throw new b("Not all required fields were included: Detail");
            }
            if (this.mtg != null) {
                aVar.e(2, this.mtg);
            }
            aVar.d(3, 1, this.mtB);
            return 0;
        } else if (i == 1) {
            if (this.mtg != null) {
                r0 = a.a.a.b.b.a.f(2, this.mtg) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(3, 1, this.mtB);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.mtB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mtg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Detail");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ad adVar = (ad) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    adVar.mtg = aVar3.xmD.readString();
                    return 0;
                case 3:
                    adVar.mtB.add(aVar3.xmD.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
