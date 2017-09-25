package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import java.util.LinkedList;

public final class bid extends avh {
    public String mvU;
    public String mvV;
    public String tKH;
    public String tKJ;
    public int tOS;
    public int tOT;
    public avw tOU;
    public int tOV;
    public String tfU;
    public int tfW;
    public String tfi;
    public String tng;
    public int tnh;
    public int tni;
    public int tnj;
    public int tuG;
    public int tua;
    public int uah;
    public int uhA;
    public avw uhB;
    public int uhC;
    public int uhD;
    public String uhE;
    public int uhF;
    public String uhG;
    public String uhH;
    public int uhI;
    public String uhJ;
    public String uhK;
    public String uhL;
    public String uhM;
    public String uhN;
    public String uhO;
    public String uhP;
    public String uhQ;
    public int uhr;
    public int uhs;
    public int uht;
    public int uhz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tOU == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.uhB == null) {
                throw new b("Not all required fields were included: VideoData");
            } else {
                if (this.tYN != null) {
                    aVar.eQ(1, this.tYN.aUk());
                    this.tYN.a(aVar);
                }
                if (this.tfU != null) {
                    aVar.e(2, this.tfU);
                }
                if (this.mvV != null) {
                    aVar.e(3, this.mvV);
                }
                if (this.mvU != null) {
                    aVar.e(4, this.mvU);
                }
                aVar.eO(5, this.tOS);
                aVar.eO(6, this.tOT);
                if (this.tOU != null) {
                    aVar.eQ(7, this.tOU.aUk());
                    this.tOU.a(aVar);
                }
                aVar.eO(8, this.uhz);
                aVar.eO(9, this.uhA);
                if (this.uhB != null) {
                    aVar.eQ(10, this.uhB.aUk());
                    this.uhB.a(aVar);
                }
                aVar.eO(11, this.uhC);
                aVar.eO(12, this.tua);
                aVar.eO(13, this.tOV);
                aVar.eO(14, this.uhD);
                if (this.tfi != null) {
                    aVar.e(15, this.tfi);
                }
                if (this.uhE != null) {
                    aVar.e(16, this.uhE);
                }
                if (this.tng != null) {
                    aVar.e(17, this.tng);
                }
                aVar.eO(18, this.tnh);
                if (this.tKH != null) {
                    aVar.e(19, this.tKH);
                }
                aVar.eO(20, this.uhr);
                aVar.eO(21, this.uhs);
                aVar.eO(22, this.uht);
                if (this.tKJ != null) {
                    aVar.e(23, this.tKJ);
                }
                aVar.eO(24, this.uhF);
                aVar.eO(25, this.tuG);
                if (this.uhG != null) {
                    aVar.e(26, this.uhG);
                }
                if (this.uhH != null) {
                    aVar.e(27, this.uhH);
                }
                aVar.eO(28, this.uhI);
                if (this.uhJ != null) {
                    aVar.e(29, this.uhJ);
                }
                if (this.uhK != null) {
                    aVar.e(30, this.uhK);
                }
                if (this.uhL != null) {
                    aVar.e(31, this.uhL);
                }
                if (this.uhM != null) {
                    aVar.e(32, this.uhM);
                }
                if (this.uhN != null) {
                    aVar.e(33, this.uhN);
                }
                if (this.uhO != null) {
                    aVar.e(34, this.uhO);
                }
                if (this.uhP != null) {
                    aVar.e(35, this.uhP);
                }
                aVar.eO(36, this.uah);
                if (this.uhQ != null) {
                    aVar.e(37, this.uhQ);
                }
                aVar.eO(38, this.tni);
                aVar.eO(39, this.tnj);
                aVar.eO(40, this.tfW);
                return 0;
            }
        } else if (i == 1) {
            if (this.tYN != null) {
                r0 = a.a.a.a.eN(1, this.tYN.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tfU != null) {
                r0 += a.a.a.b.b.a.f(2, this.tfU);
            }
            if (this.mvV != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvV);
            }
            if (this.mvU != null) {
                r0 += a.a.a.b.b.a.f(4, this.mvU);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.tOS)) + a.a.a.a.eL(6, this.tOT);
            if (this.tOU != null) {
                r0 += a.a.a.a.eN(7, this.tOU.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(8, this.uhz)) + a.a.a.a.eL(9, this.uhA);
            if (this.uhB != null) {
                r0 += a.a.a.a.eN(10, this.uhB.aUk());
            }
            r0 = (((r0 + a.a.a.a.eL(11, this.uhC)) + a.a.a.a.eL(12, this.tua)) + a.a.a.a.eL(13, this.tOV)) + a.a.a.a.eL(14, this.uhD);
            if (this.tfi != null) {
                r0 += a.a.a.b.b.a.f(15, this.tfi);
            }
            if (this.uhE != null) {
                r0 += a.a.a.b.b.a.f(16, this.uhE);
            }
            if (this.tng != null) {
                r0 += a.a.a.b.b.a.f(17, this.tng);
            }
            r0 += a.a.a.a.eL(18, this.tnh);
            if (this.tKH != null) {
                r0 += a.a.a.b.b.a.f(19, this.tKH);
            }
            r0 = ((r0 + a.a.a.a.eL(20, this.uhr)) + a.a.a.a.eL(21, this.uhs)) + a.a.a.a.eL(22, this.uht);
            if (this.tKJ != null) {
                r0 += a.a.a.b.b.a.f(23, this.tKJ);
            }
            r0 = (r0 + a.a.a.a.eL(24, this.uhF)) + a.a.a.a.eL(25, this.tuG);
            if (this.uhG != null) {
                r0 += a.a.a.b.b.a.f(26, this.uhG);
            }
            if (this.uhH != null) {
                r0 += a.a.a.b.b.a.f(27, this.uhH);
            }
            r0 += a.a.a.a.eL(28, this.uhI);
            if (this.uhJ != null) {
                r0 += a.a.a.b.b.a.f(29, this.uhJ);
            }
            if (this.uhK != null) {
                r0 += a.a.a.b.b.a.f(30, this.uhK);
            }
            if (this.uhL != null) {
                r0 += a.a.a.b.b.a.f(31, this.uhL);
            }
            if (this.uhM != null) {
                r0 += a.a.a.b.b.a.f(32, this.uhM);
            }
            if (this.uhN != null) {
                r0 += a.a.a.b.b.a.f(33, this.uhN);
            }
            if (this.uhO != null) {
                r0 += a.a.a.b.b.a.f(34, this.uhO);
            }
            if (this.uhP != null) {
                r0 += a.a.a.b.b.a.f(35, this.uhP);
            }
            r0 += a.a.a.a.eL(36, this.uah);
            if (this.uhQ != null) {
                r0 += a.a.a.b.b.a.f(37, this.uhQ);
            }
            return ((r0 + a.a.a.a.eL(38, this.tni)) + a.a.a.a.eL(39, this.tnj)) + a.a.a.a.eL(40, this.tfW);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tOU == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.uhB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: VideoData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bid com_tencent_mm_protocal_c_bid = (bid) objArr[1];
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
                        com_tencent_mm_protocal_c_bid.tYN = emVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bid.tfU = aVar3.xmD.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bid.mvV = aVar3.xmD.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bid.mvU = aVar3.xmD.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bid.tOS = aVar3.xmD.mL();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bid.tOT = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bid.tOU = emVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bid.uhz = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bid.uhA = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        emVar = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emVar.a(aVar4, emVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bid.uhB = emVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bid.uhC = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bid.tua = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bid.tOV = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bid.uhD = aVar3.xmD.mL();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bid.tfi = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bid.uhE = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bid.tng = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bid.tnh = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bid.tKH = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bid.uhr = aVar3.xmD.mL();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bid.uhs = aVar3.xmD.mL();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_bid.uht = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_bid.tKJ = aVar3.xmD.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bid.uhF = aVar3.xmD.mL();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bid.tuG = aVar3.xmD.mL();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_bid.uhG = aVar3.xmD.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bid.uhH = aVar3.xmD.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bid.uhI = aVar3.xmD.mL();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_bid.uhJ = aVar3.xmD.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bid.uhK = aVar3.xmD.readString();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    com_tencent_mm_protocal_c_bid.uhL = aVar3.xmD.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_bid.uhM = aVar3.xmD.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_bid.uhN = aVar3.xmD.readString();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_bid.uhO = aVar3.xmD.readString();
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    com_tencent_mm_protocal_c_bid.uhP = aVar3.xmD.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_bid.uah = aVar3.xmD.mL();
                    return 0;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    com_tencent_mm_protocal_c_bid.uhQ = aVar3.xmD.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_bid.tni = aVar3.xmD.mL();
                    return 0;
                case 39:
                    com_tencent_mm_protocal_c_bid.tnj = aVar3.xmD.mL();
                    return 0;
                case 40:
                    com_tencent_mm_protocal_c_bid.tfW = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
