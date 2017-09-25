package com.tencent.mm.plugin.qqmail.b;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class y extends a {
    public String name;
    public long oBg;
    public String oBh;
    public String path;
    public long size;
    public int state;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.path == null) {
                throw new b("Not all required fields were included: path");
            } else if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else {
                if (this.path != null) {
                    aVar.e(1, this.path);
                }
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                aVar.O(3, this.size);
                aVar.eO(4, this.state);
                aVar.O(5, this.oBg);
                if (this.oBh == null) {
                    return 0;
                }
                aVar.e(6, this.oBh);
                return 0;
            }
        } else if (i == 1) {
            if (this.path != null) {
                r0 = a.a.a.b.b.a.f(1, this.path) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            r0 = ((r0 + a.a.a.a.N(3, this.size)) + a.a.a.a.eL(4, this.state)) + a.a.a.a.N(5, this.oBg);
            if (this.oBh != null) {
                r0 += a.a.a.b.b.a.f(6, this.oBh);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.path == null) {
                throw new b("Not all required fields were included: path");
            } else if (this.name != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.path = aVar3.xmD.readString();
                    return 0;
                case 2:
                    yVar.name = aVar3.xmD.readString();
                    return 0;
                case 3:
                    yVar.size = aVar3.xmD.mM();
                    return 0;
                case 4:
                    yVar.state = aVar3.xmD.mL();
                    return 0;
                case 5:
                    yVar.oBg = aVar3.xmD.mM();
                    return 0;
                case 6:
                    yVar.oBh = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
