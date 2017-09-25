package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ku extends avh {
    public String mtb;
    public String tju;
    public at tnu;
    public String tqx;
    public String trf;
    public String trg;
    public String trh;
    public String tri;
    public int trj;
    public String trk;

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
            aVar.eO(9, this.trj);
            if (this.tnu != null) {
                aVar.eQ(10, this.tnu.aUk());
                this.tnu.a(aVar);
            }
            if (this.trk == null) {
                return 0;
            }
            aVar.e(11, this.trk);
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
            r0 += a.a.a.a.eL(9, this.trj);
            if (this.tnu != null) {
                r0 += a.a.a.a.eN(10, this.tnu.aUk());
            }
            if (this.trk != null) {
                r0 += a.a.a.b.b.a.f(11, this.trk);
            }
            return r0;
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
            ku kuVar = (ku) objArr[1];
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
                        kuVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    kuVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 3:
                    kuVar.trf = aVar3.xmD.readString();
                    return 0;
                case 4:
                    kuVar.tju = aVar3.xmD.readString();
                    return 0;
                case 5:
                    kuVar.trg = aVar3.xmD.readString();
                    return 0;
                case 6:
                    kuVar.trh = aVar3.xmD.readString();
                    return 0;
                case 7:
                    kuVar.tri = aVar3.xmD.readString();
                    return 0;
                case 8:
                    kuVar.tqx = aVar3.xmD.readString();
                    return 0;
                case 9:
                    kuVar.trj = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        kuVar.tnu = emVar;
                    }
                    return 0;
                case 11:
                    kuVar.trk = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
