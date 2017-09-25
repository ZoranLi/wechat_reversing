package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class wo extends a {
    public String tDe;
    public jp tDh;
    public String tDi;
    public boolean tDj;
    public int tDk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.tDh != null) {
                aVar.eQ(1, this.tDh.aUk());
                this.tDh.a(aVar);
            }
            if (this.tDe != null) {
                aVar.e(2, this.tDe);
            }
            if (this.tDi != null) {
                aVar.e(3, this.tDi);
            }
            aVar.an(4, this.tDj);
            aVar.eO(5, this.tDk);
            return 0;
        } else if (i == 1) {
            if (this.tDh != null) {
                r0 = a.a.a.a.eN(1, this.tDh.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tDe != null) {
                r0 += a.a.a.b.b.a.f(2, this.tDe);
            }
            if (this.tDi != null) {
                r0 += a.a.a.b.b.a.f(3, this.tDi);
            }
            return (r0 + (a.a.a.b.b.a.cH(4) + 1)) + a.a.a.a.eL(5, this.tDk);
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
            wo woVar = (wo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        a jpVar = new jp();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jpVar.a(aVar4, jpVar, a.a(aVar4))) {
                        }
                        woVar.tDh = jpVar;
                    }
                    return 0;
                case 2:
                    woVar.tDe = aVar3.xmD.readString();
                    return 0;
                case 3:
                    woVar.tDi = aVar3.xmD.readString();
                    return 0;
                case 4:
                    woVar.tDj = aVar3.cib();
                    return 0;
                case 5:
                    woVar.tDk = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
