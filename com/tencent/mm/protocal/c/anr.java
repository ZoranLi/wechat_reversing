package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import java.util.LinkedList;

public final class anr extends avp {
    public int jNB;
    public String jNj;
    public int leD;
    public String leF;
    public String tHi;
    public avw tHl;
    public String tSD;
    public int tSE;
    public String tSF;
    public int tSG;
    public aqt tSH;
    public int tSI;
    public String tSJ;
    public String tSK;
    public axk tSL;
    public String tch;
    public int tdC;
    public String tdF;
    public String tdG;
    public int tdH;
    public String tdI;
    public String tdz;
    public String thm;
    public bad thp;
    public int thu;
    public afd tjL;
    public hr tjM;
    public anh tjN;
    public if tpc;
    public if tpd;
    public if tpe;

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
            aVar.eO(2, this.leD);
            if (this.tch != null) {
                aVar.e(3, this.tch);
            }
            if (this.tdF != null) {
                aVar.e(4, this.tdF);
            }
            if (this.tdG != null) {
                aVar.e(5, this.tdG);
            }
            if (this.tSD != null) {
                aVar.e(6, this.tSD);
            }
            if (this.tdz != null) {
                aVar.e(7, this.tdz);
            }
            aVar.eO(8, this.tdH);
            aVar.eO(9, this.tSE);
            if (this.tSF != null) {
                aVar.e(10, this.tSF);
            }
            if (this.tjM != null) {
                aVar.eQ(14, this.tjM.aUk());
                this.tjM.a(aVar);
            }
            if (this.tdI != null) {
                aVar.e(15, this.tdI);
            }
            if (this.jNj != null) {
                aVar.e(16, this.jNj);
            }
            aVar.eO(17, this.jNB);
            if (this.tjN != null) {
                aVar.eQ(18, this.tjN.aUk());
                this.tjN.a(aVar);
            }
            aVar.eO(19, this.tSG);
            aVar.eO(20, this.tdC);
            if (this.thm != null) {
                aVar.e(21, this.thm);
            }
            if (this.tSH != null) {
                aVar.eQ(22, this.tSH.aUk());
                this.tSH.a(aVar);
            }
            if (this.leF != null) {
                aVar.e(23, this.leF);
            }
            aVar.eO(24, this.tSI);
            if (this.tjL != null) {
                aVar.eQ(25, this.tjL.aUk());
                this.tjL.a(aVar);
            }
            if (this.tSJ != null) {
                aVar.e(26, this.tSJ);
            }
            if (this.tpc != null) {
                aVar.eQ(27, this.tpc.aUk());
                this.tpc.a(aVar);
            }
            if (this.tSK != null) {
                aVar.e(28, this.tSK);
            }
            if (this.tHi != null) {
                aVar.e(29, this.tHi);
            }
            if (this.tHl != null) {
                aVar.eQ(30, this.tHl.aUk());
                this.tHl.a(aVar);
            }
            if (this.thp != null) {
                aVar.eQ(31, this.thp.aUk());
                this.thp.a(aVar);
            }
            if (this.tpd != null) {
                aVar.eQ(32, this.tpd.aUk());
                this.tpd.a(aVar);
            }
            if (this.tpe != null) {
                aVar.eQ(33, this.tpe.aUk());
                this.tpe.a(aVar);
            }
            if (this.tSL != null) {
                aVar.eQ(34, this.tSL.aUk());
                this.tSL.a(aVar);
            }
            aVar.eO(35, this.thu);
            return 0;
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.eL(2, this.leD);
            if (this.tch != null) {
                r0 += a.a.a.b.b.a.f(3, this.tch);
            }
            if (this.tdF != null) {
                r0 += a.a.a.b.b.a.f(4, this.tdF);
            }
            if (this.tdG != null) {
                r0 += a.a.a.b.b.a.f(5, this.tdG);
            }
            if (this.tSD != null) {
                r0 += a.a.a.b.b.a.f(6, this.tSD);
            }
            if (this.tdz != null) {
                r0 += a.a.a.b.b.a.f(7, this.tdz);
            }
            r0 = (r0 + a.a.a.a.eL(8, this.tdH)) + a.a.a.a.eL(9, this.tSE);
            if (this.tSF != null) {
                r0 += a.a.a.b.b.a.f(10, this.tSF);
            }
            if (this.tjM != null) {
                r0 += a.a.a.a.eN(14, this.tjM.aUk());
            }
            if (this.tdI != null) {
                r0 += a.a.a.b.b.a.f(15, this.tdI);
            }
            if (this.jNj != null) {
                r0 += a.a.a.b.b.a.f(16, this.jNj);
            }
            r0 += a.a.a.a.eL(17, this.jNB);
            if (this.tjN != null) {
                r0 += a.a.a.a.eN(18, this.tjN.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(19, this.tSG)) + a.a.a.a.eL(20, this.tdC);
            if (this.thm != null) {
                r0 += a.a.a.b.b.a.f(21, this.thm);
            }
            if (this.tSH != null) {
                r0 += a.a.a.a.eN(22, this.tSH.aUk());
            }
            if (this.leF != null) {
                r0 += a.a.a.b.b.a.f(23, this.leF);
            }
            r0 += a.a.a.a.eL(24, this.tSI);
            if (this.tjL != null) {
                r0 += a.a.a.a.eN(25, this.tjL.aUk());
            }
            if (this.tSJ != null) {
                r0 += a.a.a.b.b.a.f(26, this.tSJ);
            }
            if (this.tpc != null) {
                r0 += a.a.a.a.eN(27, this.tpc.aUk());
            }
            if (this.tSK != null) {
                r0 += a.a.a.b.b.a.f(28, this.tSK);
            }
            if (this.tHi != null) {
                r0 += a.a.a.b.b.a.f(29, this.tHi);
            }
            if (this.tHl != null) {
                r0 += a.a.a.a.eN(30, this.tHl.aUk());
            }
            if (this.thp != null) {
                r0 += a.a.a.a.eN(31, this.thp.aUk());
            }
            if (this.tpd != null) {
                r0 += a.a.a.a.eN(32, this.tpd.aUk());
            }
            if (this.tpe != null) {
                r0 += a.a.a.a.eN(33, this.tpe.aUk());
            }
            if (this.tSL != null) {
                r0 += a.a.a.a.eN(34, this.tSL.aUk());
            }
            return r0 + a.a.a.a.eL(35, this.thu);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            anr com_tencent_mm_protocal_c_anr = (anr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            com.tencent.mm.bd.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tZe = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_anr.leD = aVar3.xmD.mL();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_anr.tch = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_anr.tdF = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_anr.tdG = aVar3.xmD.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_anr.tSD = aVar3.xmD.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_anr.tdz = aVar3.xmD.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_anr.tdH = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_anr.tSE = aVar3.xmD.mL();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_anr.tSF = aVar3.xmD.readString();
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new hr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tjM = enVar;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_anr.tdI = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_anr.jNj = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_anr.jNB = aVar3.xmD.mL();
                    return 0;
                case 18:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new anh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tjN = enVar;
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_anr.tSG = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_anr.tdC = aVar3.xmD.mL();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_anr.thm = aVar3.xmD.readString();
                    return 0;
                case 22:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new aqt();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tSH = enVar;
                    }
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_anr.leF = aVar3.xmD.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_anr.tSI = aVar3.xmD.mL();
                    return 0;
                case 25:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new afd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tjL = enVar;
                    }
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_anr.tSJ = aVar3.xmD.readString();
                    return 0;
                case 27:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tpc = enVar;
                    }
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_anr.tSK = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_anr.tHi = aVar3.xmD.readString();
                    return 0;
                case 30:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tHl = enVar;
                    }
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new bad();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.thp = enVar;
                    }
                    return 0;
                case 32:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tpd = enVar;
                    }
                    return 0;
                case 33:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tpe = enVar;
                    }
                    return 0;
                case 34:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        enVar = new axk();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_anr.tSL = enVar;
                    }
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    com_tencent_mm_protocal_c_anr.thu = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
