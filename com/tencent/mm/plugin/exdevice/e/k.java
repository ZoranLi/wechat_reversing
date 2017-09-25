package com.tencent.mm.plugin.exdevice.e;

import a.a.a.c.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class k extends i {
    public b jMQ;
    public int jOc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.jMQ == null) {
                throw new a.a.a.b("Not all required fields were included: Data");
            }
            if (this.lfh != null) {
                aVar.eQ(1, this.lfh.aUk());
                this.lfh.a(aVar);
            }
            if (this.jMQ != null) {
                aVar.b(2, this.jMQ);
            }
            aVar.eO(3, this.jOc);
            return 0;
        } else if (i == 1) {
            if (this.lfh != null) {
                r0 = a.a.a.a.eN(1, this.lfh.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.jMQ != null) {
                r0 += a.a.a.a.a(2, this.jMQ);
            }
            return r0 + a.a.a.a.eL(3, this.jOc);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = i.a(aVar2); r0 > 0; r0 = i.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.jMQ != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            k kVar = (k) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a dVar = new d();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, i.a(aVar4))) {
                        }
                        kVar.lfh = dVar;
                    }
                    return 0;
                case 2:
                    kVar.jMQ = aVar3.cic();
                    return 0;
                case 3:
                    kVar.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
