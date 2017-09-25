package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ti extends avh {
    public String mtb;
    public String mvZ;
    public String tBk;
    public String tBl;
    public String tBm;
    public int tcg;
    public int tdM;
    public String tju;
    public at tnu;
    public String tqx;
    public String trf;
    public String trg;
    public String trh;
    public String tri;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.mtb != null) {
                aVar.e(2, this.mtb);
            }
            if (this.trf != null) {
                aVar.e(3, this.trf);
            }
            if (this.tju != null) {
                aVar.e(4, this.tju);
            }
            if (this.trg != null) {
                aVar.e(5, this.trg);
            }
            if (this.trh != null) {
                aVar.e(6, this.trh);
            }
            if (this.tri != null) {
                aVar.e(7, this.tri);
            }
            if (this.tqx != null) {
                aVar.e(8, this.tqx);
            }
            if (this.tBk != null) {
                aVar.e(9, this.tBk);
            }
            aVar.eO(10, this.tcg);
            if (this.mvZ != null) {
                aVar.e(11, this.mvZ);
            }
            if (this.tBl != null) {
                aVar.e(12, this.tBl);
            }
            if (this.tBm != null) {
                aVar.e(13, this.tBm);
            }
            if (this.tnu != null) {
                aVar.eQ(14, this.tnu.aUk());
                this.tnu.a(aVar);
            }
            aVar.eO(15, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(2, this.mtb);
            }
            if (this.trf != null) {
                r0 += a.a.a.b.b.a.f(3, this.trf);
            }
            if (this.tju != null) {
                r0 += a.a.a.b.b.a.f(4, this.tju);
            }
            if (this.trg != null) {
                r0 += a.a.a.b.b.a.f(5, this.trg);
            }
            if (this.trh != null) {
                r0 += a.a.a.b.b.a.f(6, this.trh);
            }
            if (this.tri != null) {
                r0 += a.a.a.b.b.a.f(7, this.tri);
            }
            if (this.tqx != null) {
                r0 += a.a.a.b.b.a.f(8, this.tqx);
            }
            if (this.tBk != null) {
                r0 += a.a.a.b.b.a.f(9, this.tBk);
            }
            r0 += a.a.a.a.eL(10, this.tcg);
            if (this.mvZ != null) {
                r0 += a.a.a.b.b.a.f(11, this.mvZ);
            }
            if (this.tBl != null) {
                r0 += a.a.a.b.b.a.f(12, this.tBl);
            }
            if (this.tBm != null) {
                r0 += a.a.a.b.b.a.f(13, this.tBm);
            }
            if (this.tnu != null) {
                r0 += a.a.a.a.eN(14, this.tnu.aUk());
            }
            return r0 + a.a.a.a.eL(15, this.tdM);
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
            ti tiVar = (ti) objArr[1];
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
                        tiVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    tiVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    tiVar.trf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    tiVar.tju = aVar3.xmD.readString();
                    return 0;
                case 5:
                    tiVar.trg = aVar3.xmD.readString();
                    return 0;
                case 6:
                    tiVar.trh = aVar3.xmD.readString();
                    return 0;
                case 7:
                    tiVar.tri = aVar3.xmD.readString();
                    return 0;
                case 8:
                    tiVar.tqx = aVar3.xmD.readString();
                    return 0;
                case 9:
                    tiVar.tBk = aVar3.xmD.readString();
                    return 0;
                case 10:
                    tiVar.tcg = aVar3.xmD.mL();
                    return 0;
                case 11:
                    tiVar.mvZ = aVar3.xmD.readString();
                    return 0;
                case 12:
                    tiVar.tBl = aVar3.xmD.readString();
                    return 0;
                case 13:
                    tiVar.tBm = aVar3.xmD.readString();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        tiVar.tnu = emVar;
                    }
                    return 0;
                case 15:
                    tiVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
