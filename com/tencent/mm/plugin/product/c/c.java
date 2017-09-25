package com.tencent.mm.plugin.product.c;

import com.tencent.mm.bd.a;
import java.util.LinkedList;

public final class c extends a {
    public String hku;
    public String name;
    public String oga;
    public LinkedList<d> opK = new LinkedList();
    public int opL;
    public int opM;
    public int opN;
    public LinkedList<String> opO = new LinkedList();
    public String opP;
    public LinkedList<String> opQ = new LinkedList();
    public LinkedList<b> opR = new LinkedList();
    public LinkedList<String> opS = new LinkedList();
    public int opT;
    public int opU;
    public LinkedList<m> opV = new LinkedList();
    public LinkedList<a> opW = new LinkedList();
    public k opX;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.d(2, 8, this.opK);
            aVar.eO(3, this.opL);
            aVar.eO(4, this.opM);
            aVar.eO(5, this.opN);
            aVar.d(6, 1, this.opO);
            if (this.hku != null) {
                aVar.e(7, this.hku);
            }
            if (this.opP != null) {
                aVar.e(8, this.opP);
            }
            aVar.d(9, 1, this.opQ);
            aVar.d(10, 8, this.opR);
            aVar.d(11, 1, this.opS);
            aVar.eO(12, this.opT);
            aVar.eO(13, this.opU);
            aVar.d(14, 8, this.opV);
            aVar.eO(15, this.version);
            aVar.d(16, 8, this.opW);
            if (this.oga != null) {
                aVar.e(17, this.oga);
            }
            if (this.opX == null) {
                return 0;
            }
            aVar.eQ(18, this.opX.aUk());
            this.opX.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                r0 = a.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.c(2, 8, this.opK)) + a.a.a.a.eL(3, this.opL)) + a.a.a.a.eL(4, this.opM)) + a.a.a.a.eL(5, this.opN)) + a.a.a.a.c(6, 1, this.opO);
            if (this.hku != null) {
                r0 += a.a.a.b.b.a.f(7, this.hku);
            }
            if (this.opP != null) {
                r0 += a.a.a.b.b.a.f(8, this.opP);
            }
            r0 = (((((((r0 + a.a.a.a.c(9, 1, this.opQ)) + a.a.a.a.c(10, 8, this.opR)) + a.a.a.a.c(11, 1, this.opS)) + a.a.a.a.eL(12, this.opT)) + a.a.a.a.eL(13, this.opU)) + a.a.a.a.c(14, 8, this.opV)) + a.a.a.a.eL(15, this.version)) + a.a.a.a.c(16, 8, this.opW);
            if (this.oga != null) {
                r0 += a.a.a.b.b.a.f(17, this.oga);
            }
            if (this.opX != null) {
                r0 += a.a.a.a.eN(18, this.opX.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.opK.clear();
            this.opO.clear();
            this.opQ.clear();
            this.opR.clear();
            this.opS.clear();
            this.opV.clear();
            this.opW.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a dVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.name = aVar3.xmD.readString();
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        dVar = new d();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.opK.add(dVar);
                    }
                    return 0;
                case 3:
                    cVar.opL = aVar3.xmD.mL();
                    return 0;
                case 4:
                    cVar.opM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    cVar.opN = aVar3.xmD.mL();
                    return 0;
                case 6:
                    cVar.opO.add(aVar3.xmD.readString());
                    return 0;
                case 7:
                    cVar.hku = aVar3.xmD.readString();
                    return 0;
                case 8:
                    cVar.opP = aVar3.xmD.readString();
                    return 0;
                case 9:
                    cVar.opQ.add(aVar3.xmD.readString());
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        dVar = new b();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.opR.add(dVar);
                    }
                    return 0;
                case 11:
                    cVar.opS.add(aVar3.xmD.readString());
                    return 0;
                case 12:
                    cVar.opT = aVar3.xmD.mL();
                    return 0;
                case 13:
                    cVar.opU = aVar3.xmD.mL();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        dVar = new m();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.opV.add(dVar);
                    }
                    return 0;
                case 15:
                    cVar.version = aVar3.xmD.mL();
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        dVar = new a();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.opW.add(dVar);
                    }
                    return 0;
                case 17:
                    cVar.oga = aVar3.xmD.readString();
                    return 0;
                case 18:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        dVar = new k();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.opX = dVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
