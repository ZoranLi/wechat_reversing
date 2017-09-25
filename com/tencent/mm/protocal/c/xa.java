package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xa extends avp {
    public String ID;
    public long jNx;
    public int jOc;
    public String tDJ;
    public int tdM;
    public avw thF;
    public int thR;
    public LinkedList<me> thS = new LinkedList();
    public String thT;
    public String thU;
    public String thV;
    public int tia;
    public String tib;
    public String tic;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.thF == null) {
                throw new b("Not all required fields were included: Key");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.ID != null) {
                    aVar.e(2, this.ID);
                }
                if (this.thF != null) {
                    aVar.eQ(3, this.thF.aUk());
                    this.thF.a(aVar);
                }
                if (this.tib != null) {
                    aVar.e(4, this.tib);
                }
                if (this.tic != null) {
                    aVar.e(5, this.tic);
                }
                aVar.eO(6, this.jOc);
                aVar.eO(7, this.thR);
                aVar.d(8, 8, this.thS);
                if (this.tDJ != null) {
                    aVar.e(9, this.tDJ);
                }
                if (this.thT != null) {
                    aVar.e(10, this.thT);
                }
                if (this.thU != null) {
                    aVar.e(11, this.thU);
                }
                aVar.eO(12, this.tia);
                aVar.eO(13, this.tdM);
                aVar.O(14, this.jNx);
                if (this.thV == null) {
                    return 0;
                }
                aVar.e(15, this.thV);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ID != null) {
                r0 += a.a.a.b.b.a.f(2, this.ID);
            }
            if (this.thF != null) {
                r0 += a.a.a.a.eN(3, this.thF.aUk());
            }
            if (this.tib != null) {
                r0 += a.a.a.b.b.a.f(4, this.tib);
            }
            if (this.tic != null) {
                r0 += a.a.a.b.b.a.f(5, this.tic);
            }
            r0 = ((r0 + a.a.a.a.eL(6, this.jOc)) + a.a.a.a.eL(7, this.thR)) + a.a.a.a.c(8, 8, this.thS);
            if (this.tDJ != null) {
                r0 += a.a.a.b.b.a.f(9, this.tDJ);
            }
            if (this.thT != null) {
                r0 += a.a.a.b.b.a.f(10, this.thT);
            }
            if (this.thU != null) {
                r0 += a.a.a.b.b.a.f(11, this.thU);
            }
            r0 = ((r0 + a.a.a.a.eL(12, this.tia)) + a.a.a.a.eL(13, this.tdM)) + a.a.a.a.N(14, this.jNx);
            if (this.thV != null) {
                r0 += a.a.a.b.b.a.f(15, this.thV);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.thS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.thF != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Key");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xa xaVar = (xa) objArr[1];
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
                        xaVar.tZe = enVar;
                    }
                    return 0;
                case 2:
                    xaVar.ID = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xaVar.thF = enVar;
                    }
                    return 0;
                case 4:
                    xaVar.tib = aVar3.xmD.readString();
                    return 0;
                case 5:
                    xaVar.tic = aVar3.xmD.readString();
                    return 0;
                case 6:
                    xaVar.jOc = aVar3.xmD.mL();
                    return 0;
                case 7:
                    xaVar.thR = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new me();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        xaVar.thS.add(enVar);
                    }
                    return 0;
                case 9:
                    xaVar.tDJ = aVar3.xmD.readString();
                    return 0;
                case 10:
                    xaVar.thT = aVar3.xmD.readString();
                    return 0;
                case 11:
                    xaVar.thU = aVar3.xmD.readString();
                    return 0;
                case 12:
                    xaVar.tia = aVar3.xmD.mL();
                    return 0;
                case 13:
                    xaVar.tdM = aVar3.xmD.mL();
                    return 0;
                case 14:
                    xaVar.jNx = aVar3.xmD.mM();
                    return 0;
                case 15:
                    xaVar.thV = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
