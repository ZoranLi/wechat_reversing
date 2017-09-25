package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zq extends avh {
    public String tAN;
    public double tFV;
    public double tFW;
    public avw tFu;
    public int tFw;
    public int tce;
    public int tdM;
    public double tld;
    public double tle;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tFu == null) {
                throw new b("Not all required fields were included: Buff");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tdM);
            aVar.eO(3, this.tce);
            if (this.tAN != null) {
                aVar.e(4, this.tAN);
            }
            if (this.tFu != null) {
                aVar.eQ(5, this.tFu.aUk());
                this.tFu.a(aVar);
            }
            aVar.a(6, this.tld);
            aVar.a(7, this.tle);
            aVar.a(8, this.tFV);
            aVar.a(9, this.tFW);
            aVar.eO(10, this.tFw);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.eL(2, this.tdM)) + a.a.a.a.eL(3, this.tce);
            if (this.tAN != null) {
                r0 += a.a.a.b.b.a.f(4, this.tAN);
            }
            if (this.tFu != null) {
                r0 += a.a.a.a.eN(5, this.tFu.aUk());
            }
            return ((((r0 + (a.a.a.b.b.a.cH(6) + 8)) + (a.a.a.b.b.a.cH(7) + 8)) + (a.a.a.b.b.a.cH(8) + 8)) + (a.a.a.b.b.a.cH(9) + 8)) + a.a.a.a.eL(10, this.tFw);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tFu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buff");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zq zqVar = (zq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        zqVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    zqVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 3:
                    zqVar.tce = aVar3.xmD.mL();
                    return 0;
                case 4:
                    zqVar.tAN = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        zqVar.tFu = emVar;
                    }
                    return 0;
                case 6:
                    zqVar.tld = aVar3.xmD.readDouble();
                    return 0;
                case 7:
                    zqVar.tle = aVar3.xmD.readDouble();
                    return 0;
                case 8:
                    zqVar.tFV = aVar3.xmD.readDouble();
                    return 0;
                case 9:
                    zqVar.tFW = aVar3.xmD.readDouble();
                    return 0;
                case 10:
                    zqVar.tFw = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
