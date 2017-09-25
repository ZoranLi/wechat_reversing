package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class dn extends a {
    public String tgW;
    public pl tgX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgW == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.tgX == null) {
                throw new b("Not all required fields were included: Price");
            } else {
                if (this.tgW != null) {
                    aVar.e(1, this.tgW);
                }
                if (this.tgX == null) {
                    return 0;
                }
                aVar.eQ(2, this.tgX.aUk());
                this.tgX.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tgW != null) {
                r0 = a.a.a.b.b.a.f(1, this.tgW) + 0;
            } else {
                r0 = 0;
            }
            if (this.tgX != null) {
                r0 += a.a.a.a.eN(2, this.tgX.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgW == null) {
                throw new b("Not all required fields were included: ProductID");
            } else if (this.tgX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Price");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dn dnVar = (dn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dnVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 2:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a plVar = new pl();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = plVar.a(aVar4, plVar, a.a(aVar4))) {
                        }
                        dnVar.tgX = plVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
