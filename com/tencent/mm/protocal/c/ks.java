package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ks extends avh {
    public String fDC;
    public String mtb;
    public int tdM;
    public String tqY;
    public String tqZ;
    public String tra;
    public String trb;
    public String trc;
    public String trd;
    public String tre;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tqY != null) {
                aVar.e(2, this.tqY);
            }
            if (this.fDC != null) {
                aVar.e(3, this.fDC);
            }
            if (this.tqZ != null) {
                aVar.e(4, this.tqZ);
            }
            if (this.tra != null) {
                aVar.e(5, this.tra);
            }
            if (this.trb != null) {
                aVar.e(6, this.trb);
            }
            if (this.trc != null) {
                aVar.e(7, this.trc);
            }
            if (this.trd != null) {
                aVar.e(8, this.trd);
            }
            if (this.mtb != null) {
                aVar.e(9, this.mtb);
            }
            aVar.eO(10, this.tdM);
            if (this.tre == null) {
                return 0;
            }
            aVar.e(11, this.tre);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tqY != null) {
                r0 += a.a.a.b.b.a.f(2, this.tqY);
            }
            if (this.fDC != null) {
                r0 += a.a.a.b.b.a.f(3, this.fDC);
            }
            if (this.tqZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.tqZ);
            }
            if (this.tra != null) {
                r0 += a.a.a.b.b.a.f(5, this.tra);
            }
            if (this.trb != null) {
                r0 += a.a.a.b.b.a.f(6, this.trb);
            }
            if (this.trc != null) {
                r0 += a.a.a.b.b.a.f(7, this.trc);
            }
            if (this.trd != null) {
                r0 += a.a.a.b.b.a.f(8, this.trd);
            }
            if (this.mtb != null) {
                r0 += a.a.a.b.b.a.f(9, this.mtb);
            }
            r0 += a.a.a.a.eL(10, this.tdM);
            if (this.tre != null) {
                r0 += a.a.a.b.b.a.f(11, this.tre);
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
            ks ksVar = (ks) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        ksVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    ksVar.tqY = aVar3.xmD.readString();
                    return 0;
                case 3:
                    ksVar.fDC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    ksVar.tqZ = aVar3.xmD.readString();
                    return 0;
                case 5:
                    ksVar.tra = aVar3.xmD.readString();
                    return 0;
                case 6:
                    ksVar.trb = aVar3.xmD.readString();
                    return 0;
                case 7:
                    ksVar.trc = aVar3.xmD.readString();
                    return 0;
                case 8:
                    ksVar.trd = aVar3.xmD.readString();
                    return 0;
                case 9:
                    ksVar.mtb = aVar3.xmD.readString();
                    return 0;
                case 10:
                    ksVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 11:
                    ksVar.tre = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
