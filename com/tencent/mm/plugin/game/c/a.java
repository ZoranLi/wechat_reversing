package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bd.a {
    public c msc;
    public String msd;
    public String mse;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.msd == null) {
                throw new b("Not all required fields were included: AdURL");
            }
            if (this.msc != null) {
                aVar.eQ(1, this.msc.aUk());
                this.msc.a(aVar);
            }
            if (this.msd != null) {
                aVar.e(2, this.msd);
            }
            if (this.mse == null) {
                return 0;
            }
            aVar.e(3, this.mse);
            return 0;
        } else if (i == 1) {
            if (this.msc != null) {
                r0 = a.a.a.a.eN(1, this.msc.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.msd != null) {
                r0 += a.a.a.b.b.a.f(2, this.msd);
            }
            if (this.mse != null) {
                r0 += a.a.a.b.b.a.f(3, this.mse);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.msd != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AdURL");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a cVar = new c();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar5, cVar, com.tencent.mm.bd.a.a(aVar5))) {
                        }
                        aVar4.msc = cVar;
                    }
                    return 0;
                case 2:
                    aVar4.msd = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aVar4.mse = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
