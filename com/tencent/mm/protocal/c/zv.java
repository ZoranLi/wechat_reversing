package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zv extends avp {
    public int jNd;
    public LinkedList<apb> jNe = new LinkedList();
    public int jOc;
    public int tGb;
    public int tlZ;

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
            aVar.eO(2, this.jNd);
            aVar.d(3, 8, this.jNe);
            aVar.eO(4, this.tlZ);
            aVar.eO(5, this.tGb);
            aVar.eO(6, this.jOc);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            return ((((r0 + a.a.a.a.eL(2, this.jNd)) + a.a.a.a.c(3, 8, this.jNe)) + a.a.a.a.eL(4, this.tlZ)) + a.a.a.a.eL(5, this.tGb)) + a.a.a.a.eL(6, this.jOc);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.jNe.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
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
            zv zvVar = (zv) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zvVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    zvVar.jNd = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new apb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        zvVar.jNe.add(enVar);
                    }
                    return 0;
                case 4:
                    zvVar.tlZ = aVar3.xmD.mL();
                    return 0;
                case 5:
                    zvVar.tGb = aVar3.xmD.mL();
                    return 0;
                case 6:
                    zvVar.jOc = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
