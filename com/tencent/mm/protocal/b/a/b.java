package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class b extends a {
    public String fEr;
    public int id;
    public LinkedList<a> tbf = new LinkedList();
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.id);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.fEr != null) {
                aVar.e(3, this.fEr);
            }
            aVar.d(4, 8, this.tbf);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.id) + 0;
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            if (this.fEr != null) {
                r0 += a.a.a.b.b.a.f(3, this.fEr);
            }
            return r0 + a.a.a.a.c(4, 8, this.tbf);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tbf.clear();
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.id = aVar3.xmD.mL();
                    return 0;
                case 2:
                    bVar.title = aVar3.xmD.readString();
                    return 0;
                case 3:
                    bVar.fEr = aVar3.xmD.readString();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a aVar4 = new a();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.tbf.add(aVar4);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
