package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class qt extends avh {
    public String gkB;
    public String gkC;
    public String lfx;
    public String twt;
    public String twu;
    public long twv;
    public double tww;
    public double twx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.lfx != null) {
                aVar.e(2, this.lfx);
            }
            if (this.gkC != null) {
                aVar.e(3, this.gkC);
            }
            if (this.gkB != null) {
                aVar.e(4, this.gkB);
            }
            if (this.twt != null) {
                aVar.e(5, this.twt);
            }
            if (this.twu != null) {
                aVar.e(6, this.twu);
            }
            aVar.O(7, this.twv);
            aVar.a(8, this.tww);
            aVar.a(9, this.twx);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lfx != null) {
                r0 += a.a.a.b.b.a.f(2, this.lfx);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkC);
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkB);
            }
            if (this.twt != null) {
                r0 += a.a.a.b.b.a.f(5, this.twt);
            }
            if (this.twu != null) {
                r0 += a.a.a.b.b.a.f(6, this.twu);
            }
            return ((r0 + a.a.a.a.N(7, this.twv)) + (a.a.a.b.b.a.cH(8) + 8)) + (a.a.a.b.b.a.cH(9) + 8);
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
            qt qtVar = (qt) objArr[1];
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
                        qtVar.tYN = emVar;
                    }
                    return 0;
                case 2:
                    qtVar.lfx = aVar3.xmD.readString();
                    return 0;
                case 3:
                    qtVar.gkC = aVar3.xmD.readString();
                    return 0;
                case 4:
                    qtVar.gkB = aVar3.xmD.readString();
                    return 0;
                case 5:
                    qtVar.twt = aVar3.xmD.readString();
                    return 0;
                case 6:
                    qtVar.twu = aVar3.xmD.readString();
                    return 0;
                case 7:
                    qtVar.twv = aVar3.xmD.mM();
                    return 0;
                case 8:
                    qtVar.tww = aVar3.xmD.readDouble();
                    return 0;
                case 9:
                    qtVar.twx = aVar3.xmD.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
