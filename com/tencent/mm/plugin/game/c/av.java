package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class av extends a {
    public String desc;
    public LinkedList<bc> khj = new LinkedList();
    public String muI;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.muI != null) {
                aVar.e(1, this.muI);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.d(3, 8, this.khj);
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            if (this.title == null) {
                return 0;
            }
            aVar.e(5, this.title);
            return 0;
        } else if (i == 1) {
            if (this.muI != null) {
                r0 = a.a.a.b.b.a.f(1, this.muI) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            r0 += a.a.a.a.c(3, 8, this.khj);
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(4, this.url);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(5, this.title);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.khj.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            av avVar = (av) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    avVar.muI = aVar3.xmD.readString();
                    return 0;
                case 2:
                    avVar.desc = aVar3.xmD.readString();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a bcVar = new bc();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bcVar.a(aVar4, bcVar, a.a(aVar4))) {
                        }
                        avVar.khj.add(bcVar);
                    }
                    return 0;
                case 4:
                    avVar.url = aVar3.xmD.readString();
                    return 0;
                case 5:
                    avVar.title = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
