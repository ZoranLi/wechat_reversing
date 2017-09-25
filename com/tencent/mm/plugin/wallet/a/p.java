package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class p extends a {
    public String ofY;
    public String rxJ;
    public String rxK;
    public String rxL;
    public int ryA;
    public String ryB;
    public String ryC;
    public LinkedList<b> ryD = new LinkedList();
    public int rys;
    public int ryt;
    public long ryu;
    public String ryv;
    public String ryw;
    public String ryx;
    public double ryy;
    public double ryz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.eO(1, this.rys);
            aVar.eO(2, this.ryt);
            aVar.O(3, this.ryu);
            if (this.ryv != null) {
                aVar.e(4, this.ryv);
            }
            if (this.rxJ != null) {
                aVar.e(5, this.rxJ);
            }
            if (this.ryw != null) {
                aVar.e(6, this.ryw);
            }
            if (this.ryx != null) {
                aVar.e(7, this.ryx);
            }
            if (this.rxK != null) {
                aVar.e(8, this.rxK);
            }
            if (this.rxL != null) {
                aVar.e(9, this.rxL);
            }
            aVar.a(10, this.ryy);
            aVar.a(11, this.ryz);
            aVar.eO(12, this.ryA);
            if (this.ryB != null) {
                aVar.e(13, this.ryB);
            }
            if (this.ofY != null) {
                aVar.e(14, this.ofY);
            }
            if (this.ryC != null) {
                aVar.e(16, this.ryC);
            }
            aVar.d(17, 6, this.ryD);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.eL(1, this.rys) + 0) + a.a.a.a.eL(2, this.ryt)) + a.a.a.a.N(3, this.ryu);
            if (this.ryv != null) {
                r0 += a.a.a.b.b.a.f(4, this.ryv);
            }
            if (this.rxJ != null) {
                r0 += a.a.a.b.b.a.f(5, this.rxJ);
            }
            if (this.ryw != null) {
                r0 += a.a.a.b.b.a.f(6, this.ryw);
            }
            if (this.ryx != null) {
                r0 += a.a.a.b.b.a.f(7, this.ryx);
            }
            if (this.rxK != null) {
                r0 += a.a.a.b.b.a.f(8, this.rxK);
            }
            if (this.rxL != null) {
                r0 += a.a.a.b.b.a.f(9, this.rxL);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cH(10) + 8)) + (a.a.a.b.b.a.cH(11) + 8)) + a.a.a.a.eL(12, this.ryA);
            if (this.ryB != null) {
                r0 += a.a.a.b.b.a.f(13, this.ryB);
            }
            if (this.ofY != null) {
                r0 += a.a.a.b.b.a.f(14, this.ofY);
            }
            if (this.ryC != null) {
                r0 += a.a.a.b.b.a.f(16, this.ryC);
            }
            return r0 + a.a.a.a.c(17, 6, this.ryD);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.ryD.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            p pVar = (p) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pVar.rys = aVar3.xmD.mL();
                    return 0;
                case 2:
                    pVar.ryt = aVar3.xmD.mL();
                    return 0;
                case 3:
                    pVar.ryu = aVar3.xmD.mM();
                    return 0;
                case 4:
                    pVar.ryv = aVar3.xmD.readString();
                    return 0;
                case 5:
                    pVar.rxJ = aVar3.xmD.readString();
                    return 0;
                case 6:
                    pVar.ryw = aVar3.xmD.readString();
                    return 0;
                case 7:
                    pVar.ryx = aVar3.xmD.readString();
                    return 0;
                case 8:
                    pVar.rxK = aVar3.xmD.readString();
                    return 0;
                case 9:
                    pVar.rxL = aVar3.xmD.readString();
                    return 0;
                case 10:
                    pVar.ryy = aVar3.xmD.readDouble();
                    return 0;
                case 11:
                    pVar.ryz = aVar3.xmD.readDouble();
                    return 0;
                case 12:
                    pVar.ryA = aVar3.xmD.mL();
                    return 0;
                case 13:
                    pVar.ryB = aVar3.xmD.readString();
                    return 0;
                case 14:
                    pVar.ofY = aVar3.xmD.readString();
                    return 0;
                case 16:
                    pVar.ryC = aVar3.xmD.readString();
                    return 0;
                case 17:
                    pVar.ryD.add(aVar3.cic());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
