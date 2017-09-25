package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import java.util.LinkedList;

public final class h extends a {
    public double rxO;
    public LinkedList<p> rxQ = new LinkedList();
    public double rxV;
    public double rxW;
    public int rxX;
    public String rxY;
    public String rxZ;
    public b ryc;
    public String ryd;
    public double rye;
    public LinkedList<e> ryf = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ryd != null) {
                aVar.e(1, this.ryd);
            }
            aVar.a(2, this.rye);
            aVar.a(3, this.rxO);
            aVar.d(4, 8, this.ryf);
            aVar.d(5, 8, this.rxQ);
            aVar.a(6, this.rxV);
            aVar.a(7, this.rxW);
            aVar.eO(8, this.rxX);
            if (this.rxY != null) {
                aVar.e(9, this.rxY);
            }
            if (this.rxZ != null) {
                aVar.e(10, this.rxZ);
            }
            if (this.ryc == null) {
                return 0;
            }
            aVar.b(11, this.ryc);
            return 0;
        } else if (i == 1) {
            if (this.ryd != null) {
                r0 = a.a.a.b.b.a.f(1, this.ryd) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + (a.a.a.b.b.a.cH(2) + 8)) + (a.a.a.b.b.a.cH(3) + 8)) + a.a.a.a.c(4, 8, this.ryf)) + a.a.a.a.c(5, 8, this.rxQ)) + (a.a.a.b.b.a.cH(6) + 8)) + (a.a.a.b.b.a.cH(7) + 8)) + a.a.a.a.eL(8, this.rxX);
            if (this.rxY != null) {
                r0 += a.a.a.b.b.a.f(9, this.rxY);
            }
            if (this.rxZ != null) {
                r0 += a.a.a.b.b.a.f(10, this.rxZ);
            }
            if (this.ryc != null) {
                r0 += a.a.a.a.a(11, this.ryc);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ryf.clear();
            this.rxQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a eVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hVar.ryd = aVar3.xmD.readString();
                    return 0;
                case 2:
                    hVar.rye = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    hVar.rxO = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        eVar = new e();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        hVar.ryf.add(eVar);
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        eVar = new p();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        hVar.rxQ.add(eVar);
                    }
                    return 0;
                case 6:
                    hVar.rxV = aVar3.xmD.readDouble();
                    return 0;
                case 7:
                    hVar.rxW = aVar3.xmD.readDouble();
                    return 0;
                case 8:
                    hVar.rxX = aVar3.xmD.mL();
                    return 0;
                case 9:
                    hVar.rxY = aVar3.xmD.readString();
                    return 0;
                case 10:
                    hVar.rxZ = aVar3.xmD.readString();
                    return 0;
                case 11:
                    hVar.ryc = aVar3.cic();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
