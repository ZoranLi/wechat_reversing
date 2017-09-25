package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class db extends a {
    public String mtb;
    public int tce;
    public int tgv;
    public int tgw;
    public dg tgx;
    public da tgy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mtb == null) {
                throw new b("Not all required fields were included: AppId");
            }
            aVar.eO(1, this.tce);
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            aVar.eO(3, this.tgv);
            aVar.eO(4, this.tgw);
            if (this.tgx != null) {
                aVar.eQ(5, this.tgx.aUk());
                this.tgx.a(aVar);
            }
            if (this.tgy != null) {
                aVar.eQ(6, this.tgy.aUk());
                this.tgy.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tce) + 0;
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tgv)) + a.a.a.a.eL(4, this.tgw);
            if (this.tgx != null) {
                r0 += a.a.a.a.eN(5, this.tgx.aUk());
            }
            if (this.tgy != null) {
                return r0 + a.a.a.a.eN(6, this.tgy.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.mtb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            db dbVar = (db) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a dgVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dbVar.tce = aVar3.xmD.mL();
                    return 0;
                case 2:
                    dbVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    dbVar.tgv = aVar3.xmD.mL();
                    return 0;
                case 4:
                    dbVar.tgw = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        dgVar = new dg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        dbVar.tgx = dgVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        dgVar = new da();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        dbVar.tgy = dgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
