package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class abq extends avp {
    public LinkedList<adx> muJ = new LinkedList();
    public LinkedList<aw> mvj = new LinkedList();
    public int tHo;
    public LinkedList<atl> tHp = new LinkedList();
    public int tHq;
    public int tHr;
    public int tHs;
    public adw tHt;

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
            aVar.eO(2, this.tHo);
            aVar.d(3, 8, this.tHp);
            aVar.eO(4, this.tHq);
            aVar.eO(5, this.tHr);
            aVar.d(6, 8, this.mvj);
            aVar.eO(7, this.tHs);
            aVar.d(8, 8, this.muJ);
            if (this.tHt == null) {
                return 0;
            }
            aVar.eQ(9, this.tHt.aUk());
            this.tHt.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + a.a.a.a.eL(2, this.tHo)) + a.a.a.a.c(3, 8, this.tHp)) + a.a.a.a.eL(4, this.tHq)) + a.a.a.a.eL(5, this.tHr)) + a.a.a.a.c(6, 8, this.mvj)) + a.a.a.a.eL(7, this.tHs)) + a.a.a.a.c(8, 8, this.muJ);
            if (this.tHt != null) {
                r0 += a.a.a.a.eN(9, this.tHt.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tHp.clear();
            this.mvj.clear();
            this.muJ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
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
            abq com_tencent_mm_protocal_c_abq = (abq) objArr[1];
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
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abq.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_abq.tHo = aVar3.xmD.mL();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new atl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abq.tHp.add(enVar);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_abq.tHq = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_abq.tHr = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new aw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abq.mvj.add(enVar);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_abq.tHs = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new adx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abq.muJ.add(enVar);
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new adw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abq.tHt = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
