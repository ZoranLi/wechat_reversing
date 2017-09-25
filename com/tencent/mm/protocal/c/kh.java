package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class kh extends avh {
    public String msh;
    public String mvU;
    public String mvZ;
    public int tdM;
    public int tfW;
    public int tqs;
    public LinkedList<avx> tqt = new LinkedList();
    public String tqu;
    public String tqv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            aVar.eO(2, this.tfW);
            if (this.mvU != null) {
                aVar.e(3, this.mvU);
            }
            if (this.mvZ != null) {
                aVar.e(4, this.mvZ);
            }
            if (this.msh != null) {
                aVar.e(5, this.msh);
            }
            aVar.eO(6, this.tqs);
            aVar.d(7, 8, this.tqt);
            if (this.tqu != null) {
                aVar.e(8, this.tqu);
            }
            if (this.tqv != null) {
                aVar.e(9, this.tqv);
            }
            aVar.eO(10, this.tdM);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.tfW);
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvU);
            }
            if (this.mvZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvZ);
            }
            if (this.msh != null) {
                r0 += a.a.a.b.b.a.f(5, this.msh);
            }
            r0 = (r0 + a.a.a.a.eL(6, this.tqs)) + a.a.a.a.c(7, 8, this.tqt);
            if (this.tqu != null) {
                r0 += a.a.a.b.b.a.f(8, this.tqu);
            }
            if (this.tqv != null) {
                r0 += a.a.a.b.b.a.f(9, this.tqv);
            }
            return r0 + a.a.a.a.eL(10, this.tdM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tqt.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            kh khVar = (kh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        khVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    khVar.tfW = aVar3.xmD.mL();
                    return 0;
                case 3:
                    khVar.mvU = aVar3.xmD.readString();
                    return 0;
                case 4:
                    khVar.mvZ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    khVar.msh = aVar3.xmD.readString();
                    return 0;
                case 6:
                    khVar.tqs = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        khVar.tqt.add(emVar);
                    }
                    return 0;
                case 8:
                    khVar.tqu = aVar3.xmD.readString();
                    return 0;
                case 9:
                    khVar.tqv = aVar3.xmD.readString();
                    return 0;
                case 10:
                    khVar.tdM = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
