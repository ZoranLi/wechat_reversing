package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class up extends avp {
    public dy lWF;
    public int tci;
    public int tcm;
    public String tcn;
    public bae tco;
    public int tcw;

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
            aVar.eO(2, this.tcm);
            aVar.eO(3, this.tcw);
            if (this.tcn != null) {
                aVar.e(4, this.tcn);
            }
            if (this.tco != null) {
                aVar.eQ(5, this.tco.aUk());
                this.tco.a(aVar);
            }
            if (this.lWF != null) {
                aVar.eQ(6, this.lWF.aUk());
                this.lWF.a(aVar);
            }
            aVar.eO(7, this.tci);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tcm)) + a.a.a.a.eL(3, this.tcw);
            if (this.tcn != null) {
                r0 += a.a.a.b.b.a.f(4, this.tcn);
            }
            if (this.tco != null) {
                r0 += a.a.a.a.eN(5, this.tco.aUk());
            }
            if (this.lWF != null) {
                r0 += a.a.a.a.eN(6, this.lWF.aUk());
            }
            return r0 + a.a.a.a.eL(7, this.tci);
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
            up upVar = (up) objArr[1];
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
                        upVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    upVar.tcm = aVar3.xmD.mL();
                    return 0;
                case 3:
                    upVar.tcw = aVar3.xmD.mL();
                    return 0;
                case 4:
                    upVar.tcn = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bae();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        upVar.tco = enVar;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new dy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        upVar.lWF = enVar;
                    }
                    return 0;
                case 7:
                    upVar.tci = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
