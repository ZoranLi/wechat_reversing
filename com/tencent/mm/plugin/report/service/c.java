package com.tencent.mm.plugin.report.service;

import a.a.a.b;
import com.tencent.mm.bd.a;

public final class c extends a {
    public boolean oTF;
    public int oTM;
    public String oTN;
    public boolean oTO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.oTN == null) {
                throw new b("Not all required fields were included: Value");
            }
            aVar.eO(1, this.oTM);
            if (this.oTN != null) {
                aVar.e(2, this.oTN);
            }
            aVar.an(3, this.oTO);
            aVar.an(4, this.oTF);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.oTM) + 0;
            if (this.oTN != null) {
                r0 += a.a.a.b.b.a.f(2, this.oTN);
            }
            return (r0 + (a.a.a.b.b.a.cH(3) + 1)) + (a.a.a.b.b.a.cH(4) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.oTN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Value");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.oTM = aVar3.xmD.mL();
                    return 0;
                case 2:
                    cVar.oTN = aVar3.xmD.readString();
                    return 0;
                case 3:
                    cVar.oTO = aVar3.cib();
                    return 0;
                case 4:
                    cVar.oTF = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
