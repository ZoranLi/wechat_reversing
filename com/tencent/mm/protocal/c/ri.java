package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ri extends avp {
    public int ksW;
    public LinkedList<rj> teK = new LinkedList();
    public String ttq;
    public String tuo;

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
            if (this.tuo != null) {
                aVar.e(2, this.tuo);
            }
            aVar.eO(3, this.ksW);
            aVar.d(4, 8, this.teK);
            if (this.ttq == null) {
                return 0;
            }
            aVar.e(5, this.ttq);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(2, this.tuo);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.ksW)) + a.a.a.a.c(4, 8, this.teK);
            if (this.ttq != null) {
                r0 += a.a.a.b.b.a.f(5, this.ttq);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.teK.clear();
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
            ri riVar = (ri) objArr[1];
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
                        riVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    riVar.tuo = aVar3.xmD.readString();
                    return 0;
                case 3:
                    riVar.ksW = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new rj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        riVar.teK.add(enVar);
                    }
                    return 0;
                case 5:
                    riVar.ttq = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
