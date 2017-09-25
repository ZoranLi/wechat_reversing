package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class f extends a {
    public double rxM;
    public double rxN;
    public double rxO;
    public String rxP;
    public LinkedList<p> rxQ = new LinkedList();
    public g rxR;
    public int rxS;
    public String rxT;
    public String rxU;
    public double rxV;
    public double rxW;
    public int rxX;
    public String rxY;
    public String rxZ;
    public a rya;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.rxM);
            aVar.a(2, this.rxN);
            aVar.a(3, this.rxO);
            if (this.rxP != null) {
                aVar.e(4, this.rxP);
            }
            aVar.d(5, 8, this.rxQ);
            if (this.rxR != null) {
                aVar.eQ(6, this.rxR.aUk());
                this.rxR.a(aVar);
            }
            aVar.eO(7, this.rxS);
            if (this.rxT != null) {
                aVar.e(8, this.rxT);
            }
            if (this.rxU != null) {
                aVar.e(9, this.rxU);
            }
            aVar.a(10, this.rxV);
            aVar.a(11, this.rxW);
            aVar.eO(12, this.rxX);
            if (this.rxY != null) {
                aVar.e(13, this.rxY);
            }
            if (this.rxZ != null) {
                aVar.e(14, this.rxZ);
            }
            if (this.rya != null) {
                aVar.eQ(15, this.rya.aUk());
                this.rya.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.b.b.a.cH(1) + 8) + 0) + (a.a.a.b.b.a.cH(2) + 8)) + (a.a.a.b.b.a.cH(3) + 8);
            if (this.rxP != null) {
                r0 += a.a.a.b.b.a.f(4, this.rxP);
            }
            r0 += a.a.a.a.c(5, 8, this.rxQ);
            if (this.rxR != null) {
                r0 += a.a.a.a.eN(6, this.rxR.aUk());
            }
            r0 += a.a.a.a.eL(7, this.rxS);
            if (this.rxT != null) {
                r0 += a.a.a.b.b.a.f(8, this.rxT);
            }
            if (this.rxU != null) {
                r0 += a.a.a.b.b.a.f(9, this.rxU);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cH(10) + 8)) + (a.a.a.b.b.a.cH(11) + 8)) + a.a.a.a.eL(12, this.rxX);
            if (this.rxY != null) {
                r0 += a.a.a.b.b.a.f(13, this.rxY);
            }
            if (this.rxZ != null) {
                r0 += a.a.a.b.b.a.f(14, this.rxZ);
            }
            if (this.rya != null) {
                return r0 + a.a.a.a.eN(15, this.rya.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
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
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a pVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    fVar.rxM = aVar3.xmD.readDouble();
                    return 0;
                case 2:
                    fVar.rxN = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    fVar.rxO = aVar3.xmD.readDouble();
                    return 0;
                case 4:
                    fVar.rxP = aVar3.xmD.readString();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        pVar = new p();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = pVar.a(aVar4, pVar, a.a(aVar4))) {
                        }
                        fVar.rxQ.add(pVar);
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        pVar = new g();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = pVar.a(aVar4, pVar, a.a(aVar4))) {
                        }
                        fVar.rxR = pVar;
                    }
                    return 0;
                case 7:
                    fVar.rxS = aVar3.xmD.mL();
                    return 0;
                case 8:
                    fVar.rxT = aVar3.xmD.readString();
                    return 0;
                case 9:
                    fVar.rxU = aVar3.xmD.readString();
                    return 0;
                case 10:
                    fVar.rxV = aVar3.xmD.readDouble();
                    return 0;
                case 11:
                    fVar.rxW = aVar3.xmD.readDouble();
                    return 0;
                case 12:
                    fVar.rxX = aVar3.xmD.mL();
                    return 0;
                case 13:
                    fVar.rxY = aVar3.xmD.readString();
                    return 0;
                case 14:
                    fVar.rxZ = aVar3.xmD.readString();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        pVar = new a();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = pVar.a(aVar4, pVar, a.a(aVar4))) {
                        }
                        fVar.rya = pVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
