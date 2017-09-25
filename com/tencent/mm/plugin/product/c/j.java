package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class j extends a {
    public int fRW;
    public g oqc;
    public String oqd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.fRW);
            if (this.oqc != null) {
                aVar.eQ(2, this.oqc.aUk());
                this.oqc.a(aVar);
            }
            if (this.oqd != null) {
                aVar.e(3, this.oqd);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.fRW) + 0;
            if (this.oqc != null) {
                r0 += a.a.a.a.eN(2, this.oqc.aUk());
            }
            if (this.oqd != null) {
                return r0 + a.a.a.b.b.a.f(3, this.oqd);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.fRW = aVar3.xmD.mL();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a gVar = new g();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        jVar.oqc = gVar;
                    }
                    return 0;
                case 3:
                    jVar.oqd = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
