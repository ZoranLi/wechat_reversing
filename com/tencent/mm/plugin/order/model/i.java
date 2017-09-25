package com.tencent.mm.plugin.order.model;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class i extends a {
    public String muS;
    public String ogJ;
    public double ogK;
    public String ogL;
    public int ogM;
    public String ogN;
    public int ogO;
    public String ogP;
    public int ogQ;
    public int ogR;
    public String ogS;
    public String ogT;
    public String ogU;
    public String ogV;
    public String ogW;
    public int ogX;
    public LinkedList<k> ogY = new LinkedList();
    public String ogZ;
    public String oha;
    public double ohb;
    public String ohc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ogJ != null) {
                aVar.e(1, this.ogJ);
            }
            aVar.a(2, this.ogK);
            if (this.ogL != null) {
                aVar.e(3, this.ogL);
            }
            aVar.eO(4, this.ogM);
            if (this.ogN != null) {
                aVar.e(5, this.ogN);
            }
            aVar.eO(6, this.ogO);
            if (this.ogP != null) {
                aVar.e(7, this.ogP);
            }
            aVar.eO(8, this.ogQ);
            aVar.eO(9, this.ogR);
            if (this.ogS != null) {
                aVar.e(10, this.ogS);
            }
            if (this.muS != null) {
                aVar.e(11, this.muS);
            }
            if (this.ogT != null) {
                aVar.e(12, this.ogT);
            }
            if (this.ogU != null) {
                aVar.e(13, this.ogU);
            }
            if (this.ogV != null) {
                aVar.e(14, this.ogV);
            }
            if (this.ogW != null) {
                aVar.e(15, this.ogW);
            }
            aVar.eO(16, this.ogX);
            aVar.d(17, 8, this.ogY);
            if (this.ogZ != null) {
                aVar.e(18, this.ogZ);
            }
            if (this.oha != null) {
                aVar.e(19, this.oha);
            }
            aVar.a(20, this.ohb);
            if (this.ohc == null) {
                return 0;
            }
            aVar.e(21, this.ohc);
            return 0;
        } else if (i == 1) {
            if (this.ogJ != null) {
                r0 = a.a.a.b.b.a.f(1, this.ogJ) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.b.b.a.cH(2) + 8;
            if (this.ogL != null) {
                r0 += a.a.a.b.b.a.f(3, this.ogL);
            }
            r0 += a.a.a.a.eL(4, this.ogM);
            if (this.ogN != null) {
                r0 += a.a.a.b.b.a.f(5, this.ogN);
            }
            r0 += a.a.a.a.eL(6, this.ogO);
            if (this.ogP != null) {
                r0 += a.a.a.b.b.a.f(7, this.ogP);
            }
            r0 = (r0 + a.a.a.a.eL(8, this.ogQ)) + a.a.a.a.eL(9, this.ogR);
            if (this.ogS != null) {
                r0 += a.a.a.b.b.a.f(10, this.ogS);
            }
            if (this.muS != null) {
                r0 += a.a.a.b.b.a.f(11, this.muS);
            }
            if (this.ogT != null) {
                r0 += a.a.a.b.b.a.f(12, this.ogT);
            }
            if (this.ogU != null) {
                r0 += a.a.a.b.b.a.f(13, this.ogU);
            }
            if (this.ogV != null) {
                r0 += a.a.a.b.b.a.f(14, this.ogV);
            }
            if (this.ogW != null) {
                r0 += a.a.a.b.b.a.f(15, this.ogW);
            }
            r0 = (r0 + a.a.a.a.eL(16, this.ogX)) + a.a.a.a.c(17, 8, this.ogY);
            if (this.ogZ != null) {
                r0 += a.a.a.b.b.a.f(18, this.ogZ);
            }
            if (this.oha != null) {
                r0 += a.a.a.b.b.a.f(19, this.oha);
            }
            r0 += a.a.a.b.b.a.cH(20) + 8;
            if (this.ohc != null) {
                r0 += a.a.a.b.b.a.f(21, this.ohc);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ogY.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.ogJ = aVar3.xmD.readString();
                    return 0;
                case 2:
                    iVar.ogK = aVar3.xmD.readDouble();
                    return 0;
                case 3:
                    iVar.ogL = aVar3.xmD.readString();
                    return 0;
                case 4:
                    iVar.ogM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    iVar.ogN = aVar3.xmD.readString();
                    return 0;
                case 6:
                    iVar.ogO = aVar3.xmD.mL();
                    return 0;
                case 7:
                    iVar.ogP = aVar3.xmD.readString();
                    return 0;
                case 8:
                    iVar.ogQ = aVar3.xmD.mL();
                    return 0;
                case 9:
                    iVar.ogR = aVar3.xmD.mL();
                    return 0;
                case 10:
                    iVar.ogS = aVar3.xmD.readString();
                    return 0;
                case 11:
                    iVar.muS = aVar3.xmD.readString();
                    return 0;
                case 12:
                    iVar.ogT = aVar3.xmD.readString();
                    return 0;
                case 13:
                    iVar.ogU = aVar3.xmD.readString();
                    return 0;
                case 14:
                    iVar.ogV = aVar3.xmD.readString();
                    return 0;
                case 15:
                    iVar.ogW = aVar3.xmD.readString();
                    return 0;
                case 16:
                    iVar.ogX = aVar3.xmD.mL();
                    return 0;
                case 17:
                    LinkedList En = aVar3.En(intValue);
                    int size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        a kVar = new k();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        iVar.ogY.add(kVar);
                    }
                    return 0;
                case 18:
                    iVar.ogZ = aVar3.xmD.readString();
                    return 0;
                case 19:
                    iVar.oha = aVar3.xmD.readString();
                    return 0;
                case 20:
                    iVar.ohb = aVar3.xmD.readDouble();
                    return 0;
                case 21:
                    iVar.ohc = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
