package com.tencent.mm.plugin.game.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.en;
import java.util.LinkedList;

public final class ak extends avp {
    public boolean mtL;
    public z mtM;
    public String mtN;
    public d mtO;
    public v mtP;
    public e mtQ;

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
            aVar.an(2, this.mtL);
            if (this.mtM != null) {
                aVar.eQ(3, this.mtM.aUk());
                this.mtM.a(aVar);
            }
            if (this.mtN != null) {
                aVar.e(4, this.mtN);
            }
            if (this.mtO != null) {
                aVar.eQ(5, this.mtO.aUk());
                this.mtO.a(aVar);
            }
            if (this.mtP != null) {
                aVar.eQ(6, this.mtP.aUk());
                this.mtP.a(aVar);
            }
            if (this.mtQ == null) {
                return 0;
            }
            aVar.eQ(7, this.mtQ.aUk());
            this.mtQ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.b.b.a.cH(2) + 1;
            if (this.mtM != null) {
                r0 += a.a.a.a.eN(3, this.mtM.aUk());
            }
            if (this.mtN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mtN);
            }
            if (this.mtO != null) {
                r0 += a.a.a.a.eN(5, this.mtO.aUk());
            }
            if (this.mtP != null) {
                r0 += a.a.a.a.eN(6, this.mtP.aUk());
            }
            if (this.mtQ != null) {
                r0 += a.a.a.a.eN(7, this.mtQ.aUk());
            }
            return r0;
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
            ak akVar = (ak) objArr[1];
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
                        akVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    akVar.mtL = aVar3.cib();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new z();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        akVar.mtM = enVar;
                    }
                    return 0;
                case 4:
                    akVar.mtN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new d();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        akVar.mtO = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new v();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        akVar.mtP = enVar;
                    }
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new e();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        akVar.mtQ = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
