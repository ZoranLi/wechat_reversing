package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class uo extends avh {
    public String appId;
    public String lUt;
    public String lUu;
    public String lUv;
    public String lUw;
    public String sign;
    public cj tCr;
    public String tch;
    public int tci;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            if (this.lUt != null) {
                aVar.e(3, this.lUt);
            }
            if (this.lUu != null) {
                aVar.e(4, this.lUu);
            }
            if (this.lUv != null) {
                aVar.e(5, this.lUv);
            }
            if (this.lUw != null) {
                aVar.e(6, this.lUw);
            }
            if (this.sign != null) {
                aVar.e(7, this.sign);
            }
            if (this.tCr != null) {
                aVar.eQ(8, this.tCr.aUk());
                this.tCr.a(aVar);
            }
            if (this.tch != null) {
                aVar.e(9, this.tch);
            }
            aVar.eO(10, this.tci);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.appId != null) {
                r0 += a.a.a.b.b.a.f(2, this.appId);
            }
            if (this.lUt != null) {
                r0 += a.a.a.b.b.a.f(3, this.lUt);
            }
            if (this.lUu != null) {
                r0 += a.a.a.b.b.a.f(4, this.lUu);
            }
            if (this.lUv != null) {
                r0 += a.a.a.b.b.a.f(5, this.lUv);
            }
            if (this.lUw != null) {
                r0 += a.a.a.b.b.a.f(6, this.lUw);
            }
            if (this.sign != null) {
                r0 += a.a.a.b.b.a.f(7, this.sign);
            }
            if (this.tCr != null) {
                r0 += a.a.a.a.eN(8, this.tCr.aUk());
            }
            if (this.tch != null) {
                r0 += a.a.a.b.b.a.f(9, this.tch);
            }
            return r0 + a.a.a.a.eL(10, this.tci);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            uo uoVar = (uo) objArr[1];
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
                        uoVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    uoVar.appId = aVar3.xmD.readString();
                    return 0;
                case 3:
                    uoVar.lUt = aVar3.xmD.readString();
                    return 0;
                case 4:
                    uoVar.lUu = aVar3.xmD.readString();
                    return 0;
                case 5:
                    uoVar.lUv = aVar3.xmD.readString();
                    return 0;
                case 6:
                    uoVar.lUw = aVar3.xmD.readString();
                    return 0;
                case 7:
                    uoVar.sign = aVar3.xmD.readString();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new cj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        uoVar.tCr = emVar;
                    }
                    return 0;
                case 9:
                    uoVar.tch = aVar3.xmD.readString();
                    return 0;
                case 10:
                    uoVar.tci = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
