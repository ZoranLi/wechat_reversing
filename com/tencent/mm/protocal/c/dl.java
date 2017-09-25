package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class dl extends a {
    public String fDC;
    public String msj;
    public String tgS;
    public String tgT;
    public dm tgU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tgU == null) {
                throw new b("Not all required fields were included: ArtisIcon");
            }
            if (this.msj != null) {
                aVar.e(1, this.msj);
            }
            if (this.fDC != null) {
                aVar.e(2, this.fDC);
            }
            if (this.tgS != null) {
                aVar.e(3, this.tgS);
            }
            if (this.tgT != null) {
                aVar.e(4, this.tgT);
            }
            if (this.tgU == null) {
                return 0;
            }
            aVar.eQ(5, this.tgU.aUk());
            this.tgU.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.msj != null) {
                r0 = a.a.a.b.b.a.f(1, this.msj) + 0;
            } else {
                r0 = 0;
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(2, this.fDC);
            }
            if (this.tgS != null) {
                r0 += a.a.a.b.b.a.f(3, this.tgS);
            }
            if (this.tgT != null) {
                r0 += a.a.a.b.b.a.f(4, this.tgT);
            }
            if (this.tgU != null) {
                r0 += a.a.a.a.eN(5, this.tgU.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tgU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisIcon");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            dl dlVar = (dl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dlVar.msj = aVar3.xmD.readString();
                    return 0;
                case 2:
                    dlVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 3:
                    dlVar.tgS = aVar3.xmD.readString();
                    return 0;
                case 4:
                    dlVar.tgT = aVar3.xmD.readString();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a dmVar = new dm();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dmVar.a(aVar4, dmVar, a.a(aVar4))) {
                        }
                        dlVar.tgU = dmVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
