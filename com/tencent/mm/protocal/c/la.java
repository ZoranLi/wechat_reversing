package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class la extends a {
    public String tro;
    public String trp;
    public LinkedList<bfe> trq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tro == null) {
                throw new b("Not all required fields were included: baseid");
            }
            if (this.tro != null) {
                aVar.e(1, this.tro);
            }
            if (this.trp != null) {
                aVar.e(2, this.trp);
            }
            aVar.d(3, 8, this.trq);
            return 0;
        } else if (i == 1) {
            if (this.tro != null) {
                r0 = a.a.a.b.b.a.f(1, this.tro) + 0;
            } else {
                r0 = 0;
            }
            if (this.trp != null) {
                r0 += a.a.a.b.b.a.f(2, this.trp);
            }
            return r0 + a.a.a.a.c(3, 8, this.trq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.trq.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tro != null) {
                return 0;
            }
            throw new b("Not all required fields were included: baseid");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            la laVar = (la) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    laVar.tro = aVar3.xmD.readString();
                    return 0;
                case 2:
                    laVar.trp = aVar3.xmD.readString();
                    return 0;
                case 3:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a com_tencent_mm_protocal_c_bfe = new bfe();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bfe.a(aVar4, com_tencent_mm_protocal_c_bfe, a.a(aVar4))) {
                        }
                        laVar.trq.add(com_tencent_mm_protocal_c_bfe);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
