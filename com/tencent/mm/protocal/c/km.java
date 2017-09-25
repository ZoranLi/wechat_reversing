package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class km extends avp {
    public bpq tqD;
    public boolean tqE;
    public String tqF;
    public String tqG;
    public boolean tqH;
    public String tqI;
    public String tqJ;

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
            if (this.tqD != null) {
                aVar.eQ(2, this.tqD.aUk());
                this.tqD.a(aVar);
            }
            aVar.an(3, this.tqE);
            if (this.tqF != null) {
                aVar.e(4, this.tqF);
            }
            if (this.tqG != null) {
                aVar.e(5, this.tqG);
            }
            aVar.an(6, this.tqH);
            if (this.tqI != null) {
                aVar.e(7, this.tqI);
            }
            if (this.tqJ == null) {
                return 0;
            }
            aVar.e(8, this.tqJ);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tqD != null) {
                r0 += a.a.a.a.eN(2, this.tqD.aUk());
            }
            r0 += a.a.a.b.b.a.cH(3) + 1;
            if (this.tqF != null) {
                r0 += a.a.a.b.b.a.f(4, this.tqF);
            }
            if (this.tqG != null) {
                r0 += a.a.a.b.b.a.f(5, this.tqG);
            }
            r0 += a.a.a.b.b.a.cH(6) + 1;
            if (this.tqI != null) {
                r0 += a.a.a.b.b.a.f(7, this.tqI);
            }
            if (this.tqJ != null) {
                r0 += a.a.a.b.b.a.f(8, this.tqJ);
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
            km kmVar = (km) objArr[1];
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
                        kmVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bpq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        kmVar.tqD = enVar;
                    }
                    return 0;
                case 3:
                    kmVar.tqE = aVar3.cib();
                    return 0;
                case 4:
                    kmVar.tqF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    kmVar.tqG = aVar3.xmD.readString();
                    return 0;
                case 6:
                    kmVar.tqH = aVar3.cib();
                    return 0;
                case 7:
                    kmVar.tqI = aVar3.xmD.readString();
                    return 0;
                case 8:
                    kmVar.tqJ = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
