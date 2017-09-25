package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import java.util.LinkedList;

public final class anq extends avh {
    public String hAI;
    public String jNj;
    public String jOp;
    public String leN;
    public String leO;
    public String tHi;
    public String tHj;
    public int tHk;
    public String tOy;
    public String tSA;
    public String tSB;
    public String tSC;
    public int tSw;
    public int tSx;
    public int tSy;
    public String tSz;
    public String tdA;
    public int tdy;
    public String tdz;
    public int thB;
    public String thC;
    public os thJ;
    public int tjC;
    public avw tjF;
    public String tjK;
    public String tum;
    public String tuo;
    public String twR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tYN != null) {
                aVar.eQ(1, this.tYN.aUk());
                this.tYN.a(aVar);
            }
            if (this.jNj != null) {
                aVar.e(2, this.jNj);
            }
            if (this.tjK != null) {
                aVar.e(3, this.tjK);
            }
            if (this.jOp != null) {
                aVar.e(4, this.jOp);
            }
            aVar.eO(5, this.tdy);
            if (this.tdz != null) {
                aVar.e(6, this.tdz);
            }
            if (this.tdA != null) {
                aVar.e(7, this.tdA);
            }
            if (this.tuo != null) {
                aVar.e(8, this.tuo);
            }
            aVar.eO(12, this.thB);
            aVar.eO(13, this.tSw);
            aVar.eO(14, this.tHk);
            if (this.leN != null) {
                aVar.e(15, this.leN);
            }
            if (this.leO != null) {
                aVar.e(16, this.leO);
            }
            aVar.eO(17, this.tjC);
            if (this.tum != null) {
                aVar.e(18, this.tum);
            }
            if (this.tjF != null) {
                aVar.eQ(19, this.tjF.aUk());
                this.tjF.a(aVar);
            }
            if (this.hAI != null) {
                aVar.e(20, this.hAI);
            }
            if (this.tHi != null) {
                aVar.e(21, this.tHi);
            }
            if (this.tHj != null) {
                aVar.e(22, this.tHj);
            }
            aVar.eO(23, this.tSx);
            aVar.eO(24, this.tSy);
            if (this.thC != null) {
                aVar.e(31, this.thC);
            }
            if (this.tOy != null) {
                aVar.e(32, this.tOy);
            }
            if (this.tSz != null) {
                aVar.e(33, this.tSz);
            }
            if (this.twR != null) {
                aVar.e(34, this.twR);
            }
            if (this.tSA != null) {
                aVar.e(35, this.tSA);
            }
            if (this.tSB != null) {
                aVar.e(36, this.tSB);
            }
            if (this.thJ != null) {
                aVar.eQ(37, this.thJ.aUk());
                this.thJ.a(aVar);
            }
            if (this.tSC == null) {
                return 0;
            }
            aVar.e(38, this.tSC);
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
            if (this.tjK != null) {
                r0 += a.a.a.b.b.a.f(3, this.tjK);
            }
            if (this.jOp != null) {
                r0 += a.a.a.b.b.a.f(4, this.jOp);
            }
            r0 += a.a.a.a.eL(5, this.tdy);
            if (this.tdz != null) {
                r0 += a.a.a.b.b.a.f(6, this.tdz);
            }
            if (this.tdA != null) {
                r0 += a.a.a.b.b.a.f(7, this.tdA);
            }
            if (this.tuo != null) {
                r0 += a.a.a.b.b.a.f(8, this.tuo);
            }
            r0 = ((r0 + a.a.a.a.eL(12, this.thB)) + a.a.a.a.eL(13, this.tSw)) + a.a.a.a.eL(14, this.tHk);
            if (this.leN != null) {
                r0 += a.a.a.b.b.a.f(15, this.leN);
            }
            if (this.leO != null) {
                r0 += a.a.a.b.b.a.f(16, this.leO);
            }
            r0 += a.a.a.a.eL(17, this.tjC);
            if (this.tum != null) {
                r0 += a.a.a.b.b.a.f(18, this.tum);
            }
            if (this.tjF != null) {
                r0 += a.a.a.a.eN(19, this.tjF.aUk());
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(20, this.hAI);
            }
            if (this.tHi != null) {
                r0 += a.a.a.b.b.a.f(21, this.tHi);
            }
            if (this.tHj != null) {
                r0 += a.a.a.b.b.a.f(22, this.tHj);
            }
            r0 = (r0 + a.a.a.a.eL(23, this.tSx)) + a.a.a.a.eL(24, this.tSy);
            if (this.thC != null) {
                r0 += a.a.a.b.b.a.f(31, this.thC);
            }
            if (this.tOy != null) {
                r0 += a.a.a.b.b.a.f(32, this.tOy);
            }
            if (this.tSz != null) {
                r0 += a.a.a.b.b.a.f(33, this.tSz);
            }
            if (this.twR != null) {
                r0 += a.a.a.b.b.a.f(34, this.twR);
            }
            if (this.tSA != null) {
                r0 += a.a.a.b.b.a.f(35, this.tSA);
            }
            if (this.tSB != null) {
                r0 += a.a.a.b.b.a.f(36, this.tSB);
            }
            if (this.thJ != null) {
                r0 += a.a.a.a.eN(37, this.thJ.aUk());
            }
            if (this.tSC != null) {
                r0 += a.a.a.b.b.a.f(38, this.tSC);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            anq com_tencent_mm_protocal_c_anq = (anq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a emVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new em();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anq.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anq.jNj = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anq.tjK = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anq.jOp = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_anq.tdy = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_anq.tdz = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_anq.tdA = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_anq.tuo = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_anq.thB = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_anq.tSw = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_anq.tHk = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_anq.leN = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_anq.leO = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_anq.tjC = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_anq.tum = aVar3.xmD.readString();
                    return 0;
                case 19:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anq.tjF = emVar;
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_anq.hAI = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_anq.tHi = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_anq.tHj = aVar3.xmD.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_anq.tSx = aVar3.xmD.mL();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_anq.tSy = aVar3.xmD.mL();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    com_tencent_mm_protocal_c_anq.thC = aVar3.xmD.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_anq.tOy = aVar3.xmD.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_anq.tSz = aVar3.xmD.readString();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_anq.twR = aVar3.xmD.readString();
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    com_tencent_mm_protocal_c_anq.tSA = aVar3.xmD.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_anq.tSB = aVar3.xmD.readString();
                    return 0;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new os();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anq.thJ = emVar;
                    }
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_anq.tSC = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
