package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import java.util.LinkedList;

public final class bbk extends a {
    public int ogM;
    public String tNz;
    public LinkedList<avx> tPQ = new LinkedList();
    public int tQU;
    public int tQZ;
    public int tSp;
    public LinkedList<bbf> tfz = new LinkedList();
    public String tgG;
    public long tmx;
    public int ubL;
    public avw ucA;
    public bbz ucB;
    public ara ucC;
    public baw ucD;
    public avw ucj;
    public int uck;
    public int ucl;
    public int ucm;
    public LinkedList<bba> ucn = new LinkedList();
    public int uco;
    public int ucp;
    public LinkedList<bba> ucq = new LinkedList();
    public int ucr;
    public int ucs;
    public LinkedList<bba> uct = new LinkedList();
    public int ucu;
    public String ucv;
    public long ucw;
    public int ucx;
    public LinkedList<avx> ucy = new LinkedList();
    public int ucz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ucj == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.O(1, this.tmx);
            if (this.tgG != null) {
                aVar.e(2, this.tgG);
            }
            if (this.tNz != null) {
                aVar.e(3, this.tNz);
            }
            aVar.eO(4, this.ogM);
            if (this.ucj != null) {
                aVar.eQ(5, this.ucj.aUk());
                this.ucj.a(aVar);
            }
            aVar.eO(6, this.uck);
            aVar.eO(7, this.ucl);
            aVar.eO(8, this.ucm);
            aVar.d(9, 8, this.ucn);
            aVar.eO(10, this.uco);
            aVar.eO(11, this.ucp);
            aVar.d(12, 8, this.ucq);
            aVar.eO(13, this.ucr);
            aVar.eO(14, this.ucs);
            aVar.d(15, 8, this.uct);
            aVar.eO(16, this.tQZ);
            aVar.eO(17, this.ucu);
            aVar.eO(18, this.tSp);
            aVar.d(19, 8, this.tfz);
            aVar.eO(20, this.ubL);
            if (this.ucv != null) {
                aVar.e(21, this.ucv);
            }
            aVar.O(22, this.ucw);
            aVar.eO(23, this.ucx);
            aVar.d(24, 8, this.ucy);
            aVar.eO(25, this.tQU);
            aVar.eO(26, this.ucz);
            aVar.d(27, 8, this.tPQ);
            if (this.ucA != null) {
                aVar.eQ(28, this.ucA.aUk());
                this.ucA.a(aVar);
            }
            if (this.ucB != null) {
                aVar.eQ(29, this.ucB.aUk());
                this.ucB.a(aVar);
            }
            if (this.ucC != null) {
                aVar.eQ(30, this.ucC.aUk());
                this.ucC.a(aVar);
            }
            if (this.ucD != null) {
                aVar.eQ(31, this.ucD.aUk());
                this.ucD.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.N(1, this.tmx) + 0;
            if (this.tgG != null) {
                r0 += a.a.a.b.b.a.f(2, this.tgG);
            }
            if (this.tNz != null) {
                r0 += a.a.a.b.b.a.f(3, this.tNz);
            }
            r0 += a.a.a.a.eL(4, this.ogM);
            if (this.ucj != null) {
                r0 += a.a.a.a.eN(5, this.ucj.aUk());
            }
            r0 = ((((((((((((((r0 + a.a.a.a.eL(6, this.uck)) + a.a.a.a.eL(7, this.ucl)) + a.a.a.a.eL(8, this.ucm)) + a.a.a.a.c(9, 8, this.ucn)) + a.a.a.a.eL(10, this.uco)) + a.a.a.a.eL(11, this.ucp)) + a.a.a.a.c(12, 8, this.ucq)) + a.a.a.a.eL(13, this.ucr)) + a.a.a.a.eL(14, this.ucs)) + a.a.a.a.c(15, 8, this.uct)) + a.a.a.a.eL(16, this.tQZ)) + a.a.a.a.eL(17, this.ucu)) + a.a.a.a.eL(18, this.tSp)) + a.a.a.a.c(19, 8, this.tfz)) + a.a.a.a.eL(20, this.ubL);
            if (this.ucv != null) {
                r0 += a.a.a.b.b.a.f(21, this.ucv);
            }
            r0 = (((((r0 + a.a.a.a.N(22, this.ucw)) + a.a.a.a.eL(23, this.ucx)) + a.a.a.a.c(24, 8, this.ucy)) + a.a.a.a.eL(25, this.tQU)) + a.a.a.a.eL(26, this.ucz)) + a.a.a.a.c(27, 8, this.tPQ);
            if (this.ucA != null) {
                r0 += a.a.a.a.eN(28, this.ucA.aUk());
            }
            if (this.ucB != null) {
                r0 += a.a.a.a.eN(29, this.ucB.aUk());
            }
            if (this.ucC != null) {
                r0 += a.a.a.a.eN(30, this.ucC.aUk());
            }
            if (this.ucD != null) {
                return r0 + a.a.a.a.eN(31, this.ucD.aUk());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ucn.clear();
            this.ucq.clear();
            this.uct.clear();
            this.tfz.clear();
            this.ucy.clear();
            this.tPQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
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
            bbk com_tencent_mm_protocal_c_bbk = (bbk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avw;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bbk.tmx = aVar3.xmD.mM();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbk.tgG = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbk.tNz = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbk.ogM = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucj = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bbk.uck = aVar3.xmD.mL();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bbk.ucl = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bbk.ucm = aVar3.xmD.mL();
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bba();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucn.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bbk.uco = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bbk.ucp = aVar3.xmD.mL();
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bba();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucq.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bbk.ucr = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bbk.ucs = aVar3.xmD.mL();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bba();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.uct.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bbk.tQZ = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bbk.ucu = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bbk.tSp = aVar3.xmD.mL();
                    return 0;
                case 19:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bbf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.tfz.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bbk.ubL = aVar3.xmD.mL();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bbk.ucv = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bbk.ucw = aVar3.xmD.mM();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bbk.ucx = aVar3.xmD.mL();
                    return 0;
                case 24:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucy.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bbk.tQU = aVar3.xmD.mL();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bbk.ucz = aVar3.xmD.mL();
                    return 0;
                case 27:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.tPQ.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 28:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucA = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new bbz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucB = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case 30:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new ara();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucC = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avw = new baw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbk.ucD = com_tencent_mm_protocal_c_avw;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
