package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bbv extends avh {
    public avw tNc;
    public int tPF;
    public LinkedList<bbf> tPL = new LinkedList();
    public LinkedList<avx> tPQ = new LinkedList();
    public bbu tPR;
    public int tSp;
    public bfw tVq;
    public String teW;
    public bbz ucB;
    public int ucR;
    public int ucS;
    public int ucT;
    public bbt ucU;
    public avw ucV;
    public String ucW;
    public iq ucX;
    public int ucY;
    public LinkedList<alf> ucZ = new LinkedList();
    public avw ucj;
    public int ucs;
    public LinkedList<avx> uct = new LinkedList();
    public long ucw;
    public int ucx;
    public LinkedList<avx> ucy = new LinkedList();
    public int ucz;
    public baw uda;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ucj == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.ucj != null) {
                aVar.eQ(2, this.ucj.aUk());
                this.ucj.a(aVar);
            }
            aVar.eO(3, this.ucs);
            aVar.d(4, 8, this.uct);
            aVar.eO(5, this.ucR);
            aVar.eO(6, this.tPF);
            if (this.teW != null) {
                aVar.e(7, this.teW);
            }
            aVar.eO(8, this.ucS);
            aVar.eO(9, this.tSp);
            aVar.d(10, 8, this.tPL);
            aVar.eO(11, this.ucT);
            aVar.O(12, this.ucw);
            aVar.eO(13, this.ucx);
            aVar.d(14, 8, this.ucy);
            if (this.tVq != null) {
                aVar.eQ(15, this.tVq.aUk());
                this.tVq.a(aVar);
            }
            aVar.eO(16, this.ucz);
            aVar.d(17, 8, this.tPQ);
            if (this.ucU != null) {
                aVar.eQ(18, this.ucU.aUk());
                this.ucU.a(aVar);
            }
            if (this.tPR != null) {
                aVar.eQ(19, this.tPR.aUk());
                this.tPR.a(aVar);
            }
            if (this.ucB != null) {
                aVar.eQ(20, this.ucB.aUk());
                this.ucB.a(aVar);
            }
            if (this.ucV != null) {
                aVar.eQ(21, this.ucV.aUk());
                this.ucV.a(aVar);
            }
            if (this.ucW != null) {
                aVar.e(22, this.ucW);
            }
            if (this.ucX != null) {
                aVar.eQ(23, this.ucX.aUk());
                this.ucX.a(aVar);
            }
            aVar.eO(24, this.ucY);
            aVar.d(25, 8, this.ucZ);
            if (this.uda != null) {
                aVar.eQ(26, this.uda.aUk());
                this.uda.a(aVar);
            }
            if (this.tNc == null) {
                return 0;
            }
            aVar.eQ(27, this.tNc.aUk());
            this.tNc.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ucj != null) {
                r0 += a.a.a.a.eN(2, this.ucj.aUk());
            }
            r0 = (((r0 + a.a.a.a.eL(3, this.ucs)) + a.a.a.a.c(4, 8, this.uct)) + a.a.a.a.eL(5, this.ucR)) + a.a.a.a.eL(6, this.tPF);
            if (this.teW != null) {
                r0 += a.a.a.b.b.a.f(7, this.teW);
            }
            r0 = ((((((r0 + a.a.a.a.eL(8, this.ucS)) + a.a.a.a.eL(9, this.tSp)) + a.a.a.a.c(10, 8, this.tPL)) + a.a.a.a.eL(11, this.ucT)) + a.a.a.a.N(12, this.ucw)) + a.a.a.a.eL(13, this.ucx)) + a.a.a.a.c(14, 8, this.ucy);
            if (this.tVq != null) {
                r0 += a.a.a.a.eN(15, this.tVq.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(16, this.ucz)) + a.a.a.a.c(17, 8, this.tPQ);
            if (this.ucU != null) {
                r0 += a.a.a.a.eN(18, this.ucU.aUk());
            }
            if (this.tPR != null) {
                r0 += a.a.a.a.eN(19, this.tPR.aUk());
            }
            if (this.ucB != null) {
                r0 += a.a.a.a.eN(20, this.ucB.aUk());
            }
            if (this.ucV != null) {
                r0 += a.a.a.a.eN(21, this.ucV.aUk());
            }
            if (this.ucW != null) {
                r0 += a.a.a.b.b.a.f(22, this.ucW);
            }
            if (this.ucX != null) {
                r0 += a.a.a.a.eN(23, this.ucX.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(24, this.ucY)) + a.a.a.a.c(25, 8, this.ucZ);
            if (this.uda != null) {
                r0 += a.a.a.a.eN(26, this.uda.aUk());
            }
            if (this.tNc != null) {
                r0 += a.a.a.a.eN(27, this.tNc.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.uct.clear();
            this.tPL.clear();
            this.ucy.clear();
            this.tPQ.clear();
            this.ucZ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = avh.a(aVar2); r0 > 0; r0 = avh.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ucj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bbv com_tencent_mm_protocal_c_bbv = (bbv) objArr[1];
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
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.tYN = emVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.ucj = emVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbv.ucs = aVar3.xmD.mL();
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.uct.add(emVar);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbv.ucR = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bbv.tPF = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bbv.teW = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bbv.ucS = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bbv.tSp = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bbf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.tPL.add(emVar);
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bbv.ucT = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bbv.ucw = aVar3.xmD.mM();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bbv.ucx = aVar3.xmD.mL();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.ucy.add(emVar);
                    }
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bfw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.tVq = emVar;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bbv.ucz = aVar3.xmD.mL();
                    return 0;
                case 17:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.tPQ.add(emVar);
                    }
                    return 0;
                case 18:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bbt();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.ucU = emVar;
                    }
                    return 0;
                case 19:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bbu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.tPR = emVar;
                    }
                    return 0;
                case 20:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new bbz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.ucB = emVar;
                    }
                    return 0;
                case 21:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.ucV = emVar;
                    }
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bbv.ucW = aVar3.xmD.readString();
                    return 0;
                case 23:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new iq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.ucX = emVar;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bbv.ucY = aVar3.xmD.mL();
                    return 0;
                case 25:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new alf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.ucZ.add(emVar);
                    }
                    return 0;
                case 26:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new baw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.uda = emVar;
                    }
                    return 0;
                case 27:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, avh.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbv.tNc = emVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
