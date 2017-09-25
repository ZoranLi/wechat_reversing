package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bjs extends avh {
    public avx tYK;
    public int tiL;
    public int tlQ;
    public int tll;
    public avw tsk;
    public String ugY;
    public int uha;
    public int ujf;
    public LinkedList<avx> ujg = new LinkedList();
    public int ujh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tsk == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.tsk != null) {
                aVar.eQ(2, this.tsk.aUk());
                this.tsk.a(aVar);
            }
            aVar.eO(3, this.tll);
            if (this.ugY != null) {
                aVar.e(4, this.ugY);
            }
            aVar.eO(5, this.tiL);
            aVar.eO(6, this.uha);
            aVar.eO(7, this.tlQ);
            aVar.eO(8, this.ujf);
            aVar.d(9, 8, this.ujg);
            if (this.tYK != null) {
                aVar.eQ(10, this.tYK.aUk());
                this.tYK.a(aVar);
            }
            aVar.eO(11, this.ujh);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(2, this.tsk.aUk());
            }
            r0 += a.a.a.a.eL(3, this.tll);
            if (this.ugY != null) {
                r0 += a.a.a.b.b.a.f(4, this.ugY);
            }
            r0 = ((((r0 + a.a.a.a.eL(5, this.tiL)) + a.a.a.a.eL(6, this.uha)) + a.a.a.a.eL(7, this.tlQ)) + a.a.a.a.eL(8, this.ujf)) + a.a.a.a.c(9, 8, this.ujg);
            if (this.tYK != null) {
                r0 += a.a.a.a.eN(10, this.tYK.aUk());
            }
            return r0 + a.a.a.a.eL(11, this.ujh);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ujg.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tsk != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bjs com_tencent_mm_protocal_c_bjs = (bjs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjs.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjs.tsk = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjs.tll = aVar3.xmD.mL();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjs.ugY = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjs.tiL = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjs.uha = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjs.tlQ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bjs.ujf = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjs.ujg.add(emVar);
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjs.tYK = emVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bjs.ujh = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
