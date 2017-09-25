package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import java.util.LinkedList;

public final class awr extends avp {
    public int hAD;
    public String hAE;
    public String hAF;
    public String hAG;
    public int hAH;
    public String hAI;
    public int hAJ;
    public int hAK;
    public String hAL;
    public String hAM;
    public String hAN;
    public String tBM;
    public int tDR;
    public LinkedList<awp> tDS = new LinkedList();
    public avx tLj;
    public int tMP;
    public String tMQ;
    public String tMR;
    public String tMS;
    public int tMT;
    public bcp tMV;
    public my tMW;
    public avw tZG;
    public String tZH;
    public int tZI;
    public avw tfh;
    public String tqb;
    public String tqc;
    public avx ttf;
    public avx ttg;
    public avx ttp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.tZe != null) {
                    aVar.eQ(1, this.tZe.aUk());
                    this.tZe.a(aVar);
                }
                if (this.ttp != null) {
                    aVar.eQ(2, this.ttp.aUk());
                    this.ttp.a(aVar);
                }
                if (this.tLj != null) {
                    aVar.eQ(3, this.tLj.aUk());
                    this.tLj.a(aVar);
                }
                if (this.ttf != null) {
                    aVar.eQ(4, this.ttf.aUk());
                    this.ttf.a(aVar);
                }
                if (this.ttg != null) {
                    aVar.eQ(5, this.ttg.aUk());
                    this.ttg.a(aVar);
                }
                aVar.eO(6, this.hAD);
                if (this.tfh != null) {
                    aVar.eQ(7, this.tfh.aUk());
                    this.tfh.a(aVar);
                }
                if (this.hAE != null) {
                    aVar.e(8, this.hAE);
                }
                if (this.hAF != null) {
                    aVar.e(9, this.hAF);
                }
                if (this.hAG != null) {
                    aVar.e(10, this.hAG);
                }
                aVar.eO(11, this.hAH);
                aVar.eO(12, this.tMP);
                if (this.tMQ != null) {
                    aVar.e(13, this.tMQ);
                }
                if (this.tMR != null) {
                    aVar.e(14, this.tMR);
                }
                if (this.hAI != null) {
                    aVar.e(15, this.hAI);
                }
                if (this.tMS != null) {
                    aVar.e(16, this.tMS);
                }
                aVar.eO(17, this.tMT);
                aVar.eO(18, this.hAK);
                aVar.eO(19, this.hAJ);
                if (this.hAL != null) {
                    aVar.e(20, this.hAL);
                }
                if (this.tMV != null) {
                    aVar.eQ(21, this.tMV.aUk());
                    this.tMV.a(aVar);
                }
                if (this.hAM != null) {
                    aVar.e(22, this.hAM);
                }
                if (this.hAN != null) {
                    aVar.e(23, this.hAN);
                }
                if (this.tMW != null) {
                    aVar.eQ(24, this.tMW.aUk());
                    this.tMW.a(aVar);
                }
                aVar.eO(25, this.tDR);
                aVar.d(26, 8, this.tDS);
                if (this.tqb != null) {
                    aVar.e(27, this.tqb);
                }
                if (this.tqc != null) {
                    aVar.e(28, this.tqc);
                }
                if (this.tZG != null) {
                    aVar.eQ(29, this.tZG.aUk());
                    this.tZG.a(aVar);
                }
                if (this.tBM != null) {
                    aVar.e(30, this.tBM);
                }
                if (this.tZH != null) {
                    aVar.e(31, this.tZH);
                }
                aVar.eO(32, this.tZI);
                return 0;
            }
        } else if (i == 1) {
            if (this.tZe != null) {
                r0 = a.a.a.a.eN(1, this.tZe.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.ttp != null) {
                r0 += a.a.a.a.eN(2, this.ttp.aUk());
            }
            if (this.tLj != null) {
                r0 += a.a.a.a.eN(3, this.tLj.aUk());
            }
            if (this.ttf != null) {
                r0 += a.a.a.a.eN(4, this.ttf.aUk());
            }
            if (this.ttg != null) {
                r0 += a.a.a.a.eN(5, this.ttg.aUk());
            }
            r0 += a.a.a.a.eL(6, this.hAD);
            if (this.tfh != null) {
                r0 += a.a.a.a.eN(7, this.tfh.aUk());
            }
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(8, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(9, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(10, this.hAG);
            }
            r0 = (r0 + a.a.a.a.eL(11, this.hAH)) + a.a.a.a.eL(12, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(13, this.tMQ);
            }
            if (this.tMR != null) {
                r0 += a.a.a.b.b.a.f(14, this.tMR);
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(15, this.hAI);
            }
            if (this.tMS != null) {
                r0 += a.a.a.b.b.a.f(16, this.tMS);
            }
            r0 = ((r0 + a.a.a.a.eL(17, this.tMT)) + a.a.a.a.eL(18, this.hAK)) + a.a.a.a.eL(19, this.hAJ);
            if (this.hAL != null) {
                r0 += a.a.a.b.b.a.f(20, this.hAL);
            }
            if (this.tMV != null) {
                r0 += a.a.a.a.eN(21, this.tMV.aUk());
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(22, this.hAM);
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(23, this.hAN);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(24, this.tMW.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(25, this.tDR)) + a.a.a.a.c(26, 8, this.tDS);
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(27, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(28, this.tqc);
            }
            if (this.tZG != null) {
                r0 += a.a.a.a.eN(29, this.tZG.aUk());
            }
            if (this.tBM != null) {
                r0 += a.a.a.b.b.a.f(30, this.tBM);
            }
            if (this.tZH != null) {
                r0 += a.a.a.b.b.a.f(31, this.tZH);
            }
            return r0 + a.a.a.a.eL(32, this.tZI);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tDS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.bd.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.bd.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.tZe == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.tfh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awr com_tencent_mm_protocal_c_awr = (awr) objArr[1];
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
                        com_tencent_mm_protocal_c_awr.tZe = enVar;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.ttp = enVar;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.tLj = enVar;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.ttf = enVar;
                    }
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.ttg = enVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awr.hAD = aVar3.xmD.mL();
                    return 0;
                case 7:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.tfh = enVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_awr.hAE = aVar3.xmD.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_awr.hAF = aVar3.xmD.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_awr.hAG = aVar3.xmD.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_awr.hAH = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_awr.tMP = aVar3.xmD.mL();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_awr.tMQ = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_awr.tMR = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_awr.hAI = aVar3.xmD.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_awr.tMS = aVar3.xmD.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_awr.tMT = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_awr.hAK = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_awr.hAJ = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_awr.hAL = aVar3.xmD.readString();
                    return 0;
                case 21:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new bcp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.tMV = enVar;
                    }
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_awr.hAM = aVar3.xmD.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_awr.hAN = aVar3.xmD.readString();
                    return 0;
                case 24:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new my();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.tMW = enVar;
                    }
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_awr.tDR = aVar3.xmD.mL();
                    return 0;
                case 26:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new awp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.tDS.add(enVar);
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_awr.tqb = aVar3.xmD.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_awr.tqc = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        enVar = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.bd.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awr.tZG = enVar;
                    }
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_awr.tBM = aVar3.xmD.readString();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    com_tencent_mm_protocal_c_awr.tZH = aVar3.xmD.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_awr.tZI = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
