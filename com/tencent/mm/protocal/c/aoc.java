package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aoc extends avp {
    public String hiE;
    public LinkedList<aod> tTh = new LinkedList();
    public String tTi;
    public boolean tTj;
    public boolean tTk;
    public boolean tTl;
    public String tpW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.tZe != null) {
                aVar.eQ(1, this.tZe.aUk());
                this.tZe.a(aVar);
            }
            aVar.d(3, 8, this.tTh);
            if (this.hiE != null) {
                aVar.e(4, this.hiE);
            }
            if (this.tTi != null) {
                aVar.e(5, this.tTi);
            }
            if (this.tpW != null) {
                aVar.e(6, this.tpW);
            }
            aVar.an(8, this.tTj);
            aVar.an(9, this.tTk);
            aVar.an(10, this.tTl);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(3, 8, this.tTh);
            if (this.hiE != null) {
                r0 += a.a.a.b.b.a.f(4, this.hiE);
            }
            if (this.tTi != null) {
                r0 += a.a.a.b.b.a.f(5, this.tTi);
            }
            if (this.tpW != null) {
                r0 += a.a.a.b.b.a.f(6, this.tpW);
            }
            return ((r0 + (a.a.a.b.b.a.cH(8) + 1)) + (a.a.a.b.b.a.cH(9) + 1)) + (a.a.a.b.b.a.cH(10) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tTh.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avp.a(aVar2); r0 > 0; r0 = avp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aoc com_tencent_mm_protocal_c_aoc = (aoc) objArr[1];
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
                        com_tencent_mm_protocal_c_aoc.tZe = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aod();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, avp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aoc.tTh.add(enVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoc.hiE = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoc.tTi = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoc.tpW = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aoc.tTj = aVar3.cib();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aoc.tTk = aVar3.cib();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aoc.tTl = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
