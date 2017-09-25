package com.tencent.mm.plugin.product.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public class l extends a {
    public int opx;
    public String oqe;
    public int oqf;
    public LinkedList<e> oqg = new LinkedList();
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.oqe == null) {
                throw new b("Not all required fields were included: id_info");
            }
            if (this.oqe != null) {
                aVar.e(1, this.oqe);
            }
            aVar.eO(2, this.oqf);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.d(4, 8, this.oqg);
            aVar.eO(5, this.opx);
            return 0;
        } else if (i == 1) {
            if (this.oqe != null) {
                r0 = a.a.a.b.b.a.f(1, this.oqe) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.oqf);
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(3, this.url);
            }
            return (r0 + a.a.a.a.c(4, 8, this.oqg)) + a.a.a.a.eL(5, this.opx);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.oqg.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.oqe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: id_info");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.oqe = aVar3.xmD.readString();
                    return 0;
                case 2:
                    lVar.oqf = aVar3.xmD.mL();
                    return 0;
                case 3:
                    lVar.url = aVar3.xmD.readString();
                    return 0;
                case 4:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        lVar.oqg.add(eVar);
                    }
                    return 0;
                case 5:
                    lVar.opx = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
