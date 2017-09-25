package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zr extends avp {
    public String msN;
    public String tFD;
    public int tFE;
    public int tFX;
    public LinkedList<aoy> tFY = new LinkedList();
    public int tFZ;
    public avw tFu;
    public String tGa;
    public int tce;
    public String tcu;
    public String tmb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tFu == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                aVar.eO(2, this.tFX);
                aVar.d(3, 8, this.tFY);
                aVar.eO(4, this.tce);
                aVar.eO(5, this.tFZ);
                if (this.tFu != null) {
                    aVar.eQ(6, this.tFu.aUk());
                    this.tFu.a(aVar);
                }
                if (this.msN != null) {
                    aVar.e(7, this.msN);
                }
                if (this.tFD != null) {
                    aVar.e(8, this.tFD);
                }
                if (this.tGa != null) {
                    aVar.e(9, this.tGa);
                }
                if (this.tcu != null) {
                    aVar.e(10, this.tcu);
                }
                aVar.eO(11, this.tFE);
                if (this.tmb == null) {
                    return 0;
                }
                aVar.e(12, this.tmb);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.eL(2, this.tFX)) + a.a.a.a.c(3, 8, this.tFY)) + a.a.a.a.eL(4, this.tce)) + a.a.a.a.eL(5, this.tFZ);
            if (this.tFu != null) {
                r0 += a.a.a.a.eN(6, this.tFu.aUk());
            }
            if (this.msN != null) {
                r0 += a.a.a.b.b.a.f(7, this.msN);
            }
            if (this.tFD != null) {
                r0 += a.a.a.b.b.a.f(8, this.tFD);
            }
            if (this.tGa != null) {
                r0 += a.a.a.b.b.a.f(9, this.tGa);
            }
            if (this.tcu != null) {
                r0 += a.a.a.b.b.a.f(10, this.tcu);
            }
            r0 += a.a.a.a.eL(11, this.tFE);
            if (this.tmb != null) {
                r0 += a.a.a.b.b.a.f(12, this.tmb);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tFY.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.tFu != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zr zrVar = (zr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        zrVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    zrVar.tFX = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aoy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        zrVar.tFY.add(enVar);
                    }
                    return 0;
                case 4:
                    zrVar.tce = aVar3.xmD.mL();
                    return 0;
                case 5:
                    zrVar.tFZ = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        zrVar.tFu = enVar;
                    }
                    return 0;
                case 7:
                    zrVar.msN = aVar3.xmD.readString();
                    return 0;
                case 8:
                    zrVar.tFD = aVar3.xmD.readString();
                    return 0;
                case 9:
                    zrVar.tGa = aVar3.xmD.readString();
                    return 0;
                case 10:
                    zrVar.tcu = aVar3.xmD.readString();
                    return 0;
                case 11:
                    zrVar.tFE = aVar3.xmD.mL();
                    return 0;
                case 12:
                    zrVar.tmb = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
