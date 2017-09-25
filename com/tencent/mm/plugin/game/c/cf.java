package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class cf extends avp {
    public String fDC;
    public String msK;
    public boolean msq;
    public i mvS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msK == null) {
                throw new b("Not all required fields were included: Message");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.an(2, this.msq);
                if (this.fDC != null) {
                    aVar.e(3, this.fDC);
                }
                if (this.msK != null) {
                    aVar.e(4, this.msK);
                }
                if (this.mvS == null) {
                    return 0;
                }
                aVar.eQ(5, this.mvS.aUk());
                this.mvS.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.b.b.a.cH(2) + 1;
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(3, this.fDC);
            }
            if (this.msK != null) {
                r0 += a.a.a.b.b.a.f(4, this.msK);
            }
            if (this.mvS != null) {
                r0 += a.a.a.a.eN(5, this.mvS.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.fDC == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.msK != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Message");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            cf cfVar = (cf) objArr[1];
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
                        cfVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    cfVar.msq = aVar3.cib();
                    return 0;
                case 3:
                    cfVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    cfVar.msK = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new i();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        cfVar.mvS = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
