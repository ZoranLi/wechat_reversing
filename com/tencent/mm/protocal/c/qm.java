package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class qm extends avp {
    public qp twc;
    public qj twd;
    public qk twe;
    public String twf;
    public int twg;
    public int twh;

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
            if (this.twc != null) {
                aVar.eQ(2, this.twc.aUk());
                this.twc.a(aVar);
            }
            if (this.twd != null) {
                aVar.eQ(3, this.twd.aUk());
                this.twd.a(aVar);
            }
            if (this.twe != null) {
                aVar.eQ(4, this.twe.aUk());
                this.twe.a(aVar);
            }
            if (this.twf != null) {
                aVar.e(5, this.twf);
            }
            aVar.eO(6, this.twg);
            aVar.eO(7, this.twh);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.twc != null) {
                r0 += a.a.a.a.eN(2, this.twc.aUk());
            }
            if (this.twd != null) {
                r0 += a.a.a.a.eN(3, this.twd.aUk());
            }
            if (this.twe != null) {
                r0 += a.a.a.a.eN(4, this.twe.aUk());
            }
            if (this.twf != null) {
                r0 += a.a.a.b.b.a.f(5, this.twf);
            }
            return (r0 + a.a.a.a.eL(6, this.twg)) + a.a.a.a.eL(7, this.twh);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            qm qmVar = (qm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        qmVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new qp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        qmVar.twc = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new qj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        qmVar.twd = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new qk();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        qmVar.twe = enVar;
                    }
                    return 0;
                case 5:
                    qmVar.twf = aVar3.xmD.readString();
                    return 0;
                case 6:
                    qmVar.twg = aVar3.xmD.mL();
                    return 0;
                case 7:
                    qmVar.twh = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
