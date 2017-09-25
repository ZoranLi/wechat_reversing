package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bd.a;
import com.tencent.mm.protocal.c.rm;
import java.util.LinkedList;

public final class c extends a {
    public String desc;
    public LinkedList<rm> hkm = new LinkedList();
    public String tbg;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.d(3, 8, this.hkm);
            if (this.tbg == null) {
                return 0;
            }
            aVar.e(4, this.tbg);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            r0 += a.a.a.a.c(3, 8, this.hkm);
            if (this.tbg != null) {
                r0 += a.a.a.b.b.a.f(4, this.tbg);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hkm.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.title = aVar3.xmD.readString();
                    return 0;
                case 2:
                    cVar.desc = aVar3.xmD.readString();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a rmVar = new rm();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = rmVar.a(aVar4, rmVar, a.a(aVar4))) {
                        }
                        cVar.hkm.add(rmVar);
                    }
                    return 0;
                case 4:
                    cVar.tbg = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
