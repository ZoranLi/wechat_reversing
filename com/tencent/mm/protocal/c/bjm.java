package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bjm extends avh {
    public String jNj;
    public int tgM;
    public int tgP;
    public int tiL;
    public int tll;
    public avw tsk;
    public String ugY;
    public int ugZ;
    public int uha;
    public int uiW;
    public int uiX;
    public LinkedList<avx> uiY = new LinkedList();
    public LinkedList<avw> uiZ = new LinkedList();

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
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            if (this.tsk != null) {
                aVar.eQ(3, this.tsk.aUk());
                this.tsk.a(aVar);
            }
            aVar.eO(4, this.tll);
            if (this.ugY != null) {
                aVar.e(5, this.ugY);
            }
            aVar.eO(6, this.tiL);
            aVar.eO(7, this.ugZ);
            aVar.eO(8, this.tgP);
            aVar.eO(9, this.uha);
            aVar.eO(10, this.tgM);
            aVar.eO(11, this.uiW);
            aVar.eO(12, this.uiX);
            aVar.d(13, 8, this.uiY);
            aVar.d(14, 8, this.uiZ);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(2, this.jNj);
            }
            if (this.tsk != null) {
                r0 += a.a.a.a.eN(3, this.tsk.aUk());
            }
            r0 += a.a.a.a.eL(4, this.tll);
            if (this.ugY != null) {
                r0 += a.a.a.b.b.a.f(5, this.ugY);
            }
            return ((((((((r0 + a.a.a.a.eL(6, this.tiL)) + a.a.a.a.eL(7, this.ugZ)) + a.a.a.a.eL(8, this.tgP)) + a.a.a.a.eL(9, this.uha)) + a.a.a.a.eL(10, this.tgM)) + a.a.a.a.eL(11, this.uiW)) + a.a.a.a.eL(12, this.uiX)) + a.a.a.a.c(13, 8, this.uiY)) + a.a.a.a.c(14, 8, this.uiZ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uiY.clear();
            this.uiZ.clear();
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
            bjm com_tencent_mm_protocal_c_bjm = (bjm) objArr[1];
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
                        com_tencent_mm_protocal_c_bjm.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjm.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjm.tsk = emVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjm.tll = aVar3.xmD.mL();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjm.ugY = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjm.tiL = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bjm.ugZ = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bjm.tgP = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bjm.uha = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bjm.tgM = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bjm.uiW = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bjm.uiX = aVar3.xmD.mL();
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjm.uiY.add(emVar);
                    }
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bjm.uiZ.add(emVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
