package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class gu extends a {
    public gx tkO;
    public String tkP;
    public String tkQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tkO != null) {
                aVar.eQ(1, this.tkO.aUk());
                this.tkO.a(aVar);
            }
            if (this.tkP != null) {
                aVar.e(2, this.tkP);
            }
            if (this.tkQ == null) {
                return 0;
            }
            aVar.e(3, this.tkQ);
            return 0;
        } else if (i == 1) {
            if (this.tkO != null) {
                r0 = a.a.a.a.eN(1, this.tkO.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tkP != null) {
                r0 += a.a.a.b.b.a.f(2, this.tkP);
            }
            if (this.tkQ != null) {
                r0 += a.a.a.b.b.a.f(3, this.tkQ);
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
            gu guVar = (gu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a gxVar = new gx();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gxVar.a(aVar4, gxVar, a.a(aVar4))) {
                        }
                        guVar.tkO = gxVar;
                    }
                    return 0;
                case 2:
                    guVar.tkP = aVar3.xmD.readString();
                    return 0;
                case 3:
                    guVar.tkQ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
