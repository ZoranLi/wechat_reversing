package com.tencent.mm.plugin.game.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class b extends a {
    public int jOc;
    public c msc;
    public a msf;
    public String msg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.jOc);
            if (this.msc != null) {
                aVar.eQ(2, this.msc.aUk());
                this.msc.a(aVar);
            }
            if (this.msf != null) {
                aVar.eQ(3, this.msf.aUk());
                this.msf.a(aVar);
            }
            if (this.msg != null) {
                aVar.e(4, this.msg);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.jOc) + 0;
            if (this.msc != null) {
                r0 += a.a.a.a.eN(2, this.msc.aUk());
            }
            if (this.msf != null) {
                r0 += a.a.a.a.eN(3, this.msf.aUk());
            }
            if (this.msg != null) {
                return r0 + a.a.a.b.b.a.f(4, this.msg);
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a cVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        cVar = new c();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        bVar.msc = cVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        cVar = new a();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        bVar.msf = cVar;
                    }
                    return 0;
                case 4:
                    bVar.msg = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
