package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class aq extends avp {
    public bo muA;
    public LinkedList<b> muB = new LinkedList();
    public boolean muC;
    public int muD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            if (this.muA != null) {
                aVar.eQ(2, this.muA.aUk());
                this.muA.a(aVar);
            }
            aVar.d(3, 8, this.muB);
            aVar.an(4, this.muC);
            aVar.eO(5, this.muD);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.muA != null) {
                r0 += a.a.a.a.eN(2, this.muA.aUk());
            }
            return ((r0 + a.a.a.a.c(3, 8, this.muB)) + (a.a.a.b.b.a.cH(4) + 1)) + a.a.a.a.eL(5, this.muD);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.muB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aq aqVar = (aq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aqVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aqVar.muA = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new b();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aqVar.muB.add(enVar);
                    }
                    return 0;
                case 4:
                    aqVar.muC = aVar3.cib();
                    return 0;
                case 5:
                    aqVar.muD = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
