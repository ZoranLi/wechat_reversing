package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aa extends avp {
    public int tce;
    public String tck;
    public int tcl;
    public int tcm;
    public String tcn;
    public bae tco;
    public aul tcp;
    public bae tcq;
    public asr tcr;
    public sr tcs;
    public dy tct;
    public String tcu;
    public String tcv;
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
            if (this.tck != null) {
                aVar.e(2, this.tck);
            }
            aVar.eO(3, this.tcl);
            aVar.eO(4, this.tcm);
            if (this.tcn != null) {
                aVar.e(5, this.tcn);
            }
            if (this.tco != null) {
                aVar.eQ(6, this.tco.aUk());
                this.tco.a(aVar);
            }
            aVar.eO(7, this.tce);
            if (this.tcp != null) {
                aVar.eQ(8, this.tcp.aUk());
                this.tcp.a(aVar);
            }
            if (this.tcq != null) {
                aVar.eQ(9, this.tcq.aUk());
                this.tcq.a(aVar);
            }
            if (this.tcr != null) {
                aVar.eQ(10, this.tcr.aUk());
                this.tcr.a(aVar);
            }
            if (this.tcs != null) {
                aVar.eQ(11, this.tcs.aUk());
                this.tcs.a(aVar);
            }
            if (this.tct != null) {
                aVar.eQ(12, this.tct.aUk());
                this.tct.a(aVar);
            }
            if (this.tcu != null) {
                aVar.e(13, this.tcu);
            }
            if (this.tcv != null) {
                aVar.e(14, this.tcv);
            }
            aVar.eO(15, this.tcw);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tck != null) {
                r0 += a.a.a.b.b.a.f(2, this.tck);
            }
            r0 = (r0 + a.a.a.a.eL(3, this.tcl)) + a.a.a.a.eL(4, this.tcm);
            if (this.tcn != null) {
                r0 += a.a.a.b.b.a.f(5, this.tcn);
            }
            if (this.tco != null) {
                r0 += a.a.a.a.eN(6, this.tco.aUk());
            }
            r0 += a.a.a.a.eL(7, this.tce);
            if (this.tcp != null) {
                r0 += a.a.a.a.eN(8, this.tcp.aUk());
            }
            if (this.tcq != null) {
                r0 += a.a.a.a.eN(9, this.tcq.aUk());
            }
            if (this.tcr != null) {
                r0 += a.a.a.a.eN(10, this.tcr.aUk());
            }
            if (this.tcs != null) {
                r0 += a.a.a.a.eN(11, this.tcs.aUk());
            }
            if (this.tct != null) {
                r0 += a.a.a.a.eN(12, this.tct.aUk());
            }
            if (this.tcu != null) {
                r0 += a.a.a.b.b.a.f(13, this.tcu);
            }
            if (this.tcv != null) {
                r0 += a.a.a.b.b.a.f(14, this.tcv);
            }
            return r0 + a.a.a.a.eL(15, this.tcw);
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
            aa aaVar = (aa) objArr[1];
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
                        aaVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    aaVar.tck = aVar3.xmD.readString();
                    return 0;
                case 3:
                    aaVar.tcl = aVar3.xmD.mL();
                    return 0;
                case 4:
                    aaVar.tcm = aVar3.xmD.mL();
                    return 0;
                case 5:
                    aaVar.tcn = aVar3.xmD.readString();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bae();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aaVar.tco = enVar;
                    }
                    return 0;
                case 7:
                    aaVar.tce = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new aul();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aaVar.tcp = enVar;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bae();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aaVar.tcq = enVar;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new asr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aaVar.tcr = enVar;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new sr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aaVar.tcs = enVar;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new dy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        aaVar.tct = enVar;
                    }
                    return 0;
                case 13:
                    aaVar.tcu = aVar3.xmD.readString();
                    return 0;
                case 14:
                    aaVar.tcv = aVar3.xmD.readString();
                    return 0;
                case 15:
                    aaVar.tcw = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
