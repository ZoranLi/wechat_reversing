package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class f extends a {
    public j opZ;
    public String oqa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.opZ != null) {
                aVar.eQ(1, this.opZ.aUk());
                this.opZ.a(aVar);
            }
            if (this.oqa == null) {
                return 0;
            }
            aVar.e(2, this.oqa);
            return 0;
        } else if (i == 1) {
            if (this.opZ != null) {
                r0 = a.a.a.a.eN(1, this.opZ.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.oqa != null) {
                r0 += a.a.a.b.b.a.f(2, this.oqa);
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
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a jVar = new j();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jVar.a(aVar4, jVar, a.a(aVar4))) {
                        }
                        fVar.opZ = jVar;
                    }
                    return 0;
                case 2:
                    fVar.oqa = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
