package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class gz extends avh {
    public int tdM;
    public String tgW;
    public LinkedList<String> tlb = new LinkedList();
    public String tlc;
    public double tld;
    public double tle;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tgW != null) {
                aVar.e(2, this.tgW);
            }
            aVar.d(3, 1, this.tlb);
            aVar.eO(4, this.tdM);
            if (this.tlc != null) {
                aVar.e(5, this.tlc);
            }
            aVar.a(6, this.tld);
            aVar.a(7, this.tle);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tgW != null) {
                r0 += a.a.a.b.b.a.f(2, this.tgW);
            }
            r0 = (r0 + a.a.a.a.c(3, 1, this.tlb)) + a.a.a.a.eL(4, this.tdM);
            if (this.tlc != null) {
                r0 += a.a.a.b.b.a.f(5, this.tlc);
            }
            return (r0 + (a.a.a.b.b.a.cH(6) + 8)) + (a.a.a.b.b.a.cH(7) + 8);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tlb.clear();
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
            gz gzVar = (gz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com.tencent.mm.bd.a emVar = new em();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        gzVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    gzVar.tgW = aVar3.xmD.readString();
                    return 0;
                case 3:
                    gzVar.tlb.add(aVar3.xmD.readString());
                    return 0;
                case 4:
                    gzVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    gzVar.tlc = aVar3.xmD.readString();
                    return 0;
                case 6:
                    gzVar.tld = aVar3.xmD.readDouble();
                    return 0;
                case 7:
                    gzVar.tle = aVar3.xmD.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
