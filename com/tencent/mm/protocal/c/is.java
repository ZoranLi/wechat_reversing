package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class is extends a {
    public String name;
    public String tbt;
    public LinkedList<mr> tnw = new LinkedList();
    public int tnx;
    public String tny;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.tnw);
            if (this.tbt != null) {
                aVar.e(2, this.tbt);
            }
            aVar.eO(3, this.tnx);
            if (this.tny != null) {
                aVar.e(4, this.tny);
            }
            if (this.name != null) {
                aVar.e(5, this.name);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.tnw) + 0;
            if (this.tbt != null) {
                r0 += a.a.a.b.b.a.f(2, this.tbt);
            }
            r0 += a.a.a.a.eL(3, this.tnx);
            if (this.tny != null) {
                r0 += a.a.a.b.b.a.f(4, this.tny);
            }
            if (this.name != null) {
                return r0 + a.a.a.b.b.a.f(5, this.name);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tnw.clear();
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
            is isVar = (is) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a mrVar = new mr();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = mrVar.a(aVar4, mrVar, a.a(aVar4))) {
                        }
                        isVar.tnw.add(mrVar);
                    }
                    return 0;
                case 2:
                    isVar.tbt = aVar3.xmD.readString();
                    return 0;
                case 3:
                    isVar.tnx = aVar3.xmD.mL();
                    return 0;
                case 4:
                    isVar.tny = aVar3.xmD.readString();
                    return 0;
                case 5:
                    isVar.name = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
