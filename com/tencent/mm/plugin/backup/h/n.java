package com.tencent.mm.plugin.backup.h;

import a.a.a.b;
import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class n extends a {
    public String ID;
    public long jNt;
    public long jNu;
    public long jNv;
    public m jNw;
    public long jNx;
    public int jNy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.O(2, this.jNt);
            aVar.O(3, this.jNu);
            aVar.O(4, this.jNv);
            if (this.jNw != null) {
                aVar.eQ(5, this.jNw.aUk());
                this.jNw.a(aVar);
            }
            aVar.O(6, this.jNx);
            aVar.eO(7, this.jNy);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.N(2, this.jNt)) + a.a.a.a.N(3, this.jNu)) + a.a.a.a.N(4, this.jNv);
            if (this.jNw != null) {
                r0 += a.a.a.a.eN(5, this.jNw.aUk());
            }
            return (r0 + a.a.a.a.N(6, this.jNx)) + a.a.a.a.eL(7, this.jNy);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            n nVar = (n) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nVar.ID = aVar3.xmD.readString();
                    return 0;
                case 2:
                    nVar.jNt = aVar3.xmD.mM();
                    return 0;
                case 3:
                    nVar.jNu = aVar3.xmD.mM();
                    return 0;
                case 4:
                    nVar.jNv = aVar3.xmD.mM();
                    return 0;
                case 5:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a mVar = new m();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        nVar.jNw = mVar;
                    }
                    return 0;
                case 6:
                    nVar.jNx = aVar3.xmD.mM();
                    return 0;
                case 7:
                    nVar.jNy = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
