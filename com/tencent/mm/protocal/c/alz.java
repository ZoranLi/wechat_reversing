package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import java.util.LinkedList;

public final class alz extends a {
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
    public String tHj;
    public avx tLj;
    public int tMP;
    public String tMQ;
    public String tMR;
    public String tMS;
    public int tMT;
    public bcp tMV;
    public my tMW;
    public int tQB;
    public avx tQl;
    public avx tQm;
    public avx tQn;
    public avw tfh;
    public String tqb;
    public String tqc;
    public int tsD;
    public avx ttf;
    public avx ttg;
    public avx ttp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.tQl == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.tQm == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.tQn == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.ttp != null) {
                    aVar.eQ(1, this.ttp.aUk());
                    this.ttp.a(aVar);
                }
                if (this.tLj != null) {
                    aVar.eQ(2, this.tLj.aUk());
                    this.tLj.a(aVar);
                }
                if (this.ttf != null) {
                    aVar.eQ(3, this.ttf.aUk());
                    this.ttf.a(aVar);
                }
                if (this.ttg != null) {
                    aVar.eQ(4, this.ttg.aUk());
                    this.ttg.a(aVar);
                }
                aVar.eO(5, this.hAD);
                if (this.tfh != null) {
                    aVar.eQ(6, this.tfh.aUk());
                    this.tfh.a(aVar);
                }
                aVar.eO(7, this.tQB);
                if (this.tQl != null) {
                    aVar.eQ(8, this.tQl.aUk());
                    this.tQl.a(aVar);
                }
                if (this.tQm != null) {
                    aVar.eQ(9, this.tQm.aUk());
                    this.tQm.a(aVar);
                }
                if (this.tQn != null) {
                    aVar.eQ(10, this.tQn.aUk());
                    this.tQn.a(aVar);
                }
                aVar.eO(11, this.tsD);
                if (this.hAE != null) {
                    aVar.e(12, this.hAE);
                }
                if (this.hAF != null) {
                    aVar.e(13, this.hAF);
                }
                if (this.hAG != null) {
                    aVar.e(14, this.hAG);
                }
                aVar.eO(15, this.hAH);
                aVar.eO(16, this.tMP);
                if (this.tMQ != null) {
                    aVar.e(17, this.tMQ);
                }
                if (this.tMR != null) {
                    aVar.e(18, this.tMR);
                }
                if (this.tHj != null) {
                    aVar.e(19, this.tHj);
                }
                if (this.tMS != null) {
                    aVar.e(20, this.tMS);
                }
                aVar.eO(21, this.tMT);
                aVar.eO(22, this.hAK);
                aVar.eO(23, this.hAJ);
                if (this.hAL != null) {
                    aVar.e(24, this.hAL);
                }
                if (this.hAI != null) {
                    aVar.e(25, this.hAI);
                }
                if (this.tMV != null) {
                    aVar.eQ(26, this.tMV.aUk());
                    this.tMV.a(aVar);
                }
                if (this.hAM != null) {
                    aVar.e(27, this.hAM);
                }
                if (this.tqb != null) {
                    aVar.e(28, this.tqb);
                }
                if (this.tqc != null) {
                    aVar.e(29, this.tqc);
                }
                if (this.hAN != null) {
                    aVar.e(30, this.hAN);
                }
                if (this.tMW == null) {
                    return 0;
                }
                aVar.eQ(31, this.tMW.aUk());
                this.tMW.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.ttp != null) {
                r0 = a.a.a.a.eN(1, this.ttp.aUk()) + 0;
            } else {
                r0 = 0;
            }
            if (this.tLj != null) {
                r0 += a.a.a.a.eN(2, this.tLj.aUk());
            }
            if (this.ttf != null) {
                r0 += a.a.a.a.eN(3, this.ttf.aUk());
            }
            if (this.ttg != null) {
                r0 += a.a.a.a.eN(4, this.ttg.aUk());
            }
            r0 += a.a.a.a.eL(5, this.hAD);
            if (this.tfh != null) {
                r0 += a.a.a.a.eN(6, this.tfh.aUk());
            }
            r0 += a.a.a.a.eL(7, this.tQB);
            if (this.tQl != null) {
                r0 += a.a.a.a.eN(8, this.tQl.aUk());
            }
            if (this.tQm != null) {
                r0 += a.a.a.a.eN(9, this.tQm.aUk());
            }
            if (this.tQn != null) {
                r0 += a.a.a.a.eN(10, this.tQn.aUk());
            }
            r0 += a.a.a.a.eL(11, this.tsD);
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(12, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(13, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(14, this.hAG);
            }
            r0 = (r0 + a.a.a.a.eL(15, this.hAH)) + a.a.a.a.eL(16, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(17, this.tMQ);
            }
            if (this.tMR != null) {
                r0 += a.a.a.b.b.a.f(18, this.tMR);
            }
            if (this.tHj != null) {
                r0 += a.a.a.b.b.a.f(19, this.tHj);
            }
            if (this.tMS != null) {
                r0 += a.a.a.b.b.a.f(20, this.tMS);
            }
            r0 = ((r0 + a.a.a.a.eL(21, this.tMT)) + a.a.a.a.eL(22, this.hAK)) + a.a.a.a.eL(23, this.hAJ);
            if (this.hAL != null) {
                r0 += a.a.a.b.b.a.f(24, this.hAL);
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(25, this.hAI);
            }
            if (this.tMV != null) {
                r0 += a.a.a.a.eN(26, this.tMV.aUk());
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(27, this.hAM);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(28, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(29, this.tqc);
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(30, this.hAN);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(31, this.tMW.aUk());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            if (this.ttp == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.tLj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.ttf == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.ttg == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.tfh == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.tQl == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.tQm == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.tQn != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RemarkQuanPin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alz com_tencent_mm_protocal_c_alz = (alz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.ttp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.tLj = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.ttf = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.ttg = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alz.hAD = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.tfh = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_alz.tQB = aVar3.xmD.mL();
                    return 0;
                case 8:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.tQl = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 9:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.tQm = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.tQn = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_alz.tsD = aVar3.xmD.mL();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_alz.hAE = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_alz.hAF = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_alz.hAG = aVar3.xmD.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_alz.hAH = aVar3.xmD.mL();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_alz.tMP = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_alz.tMQ = aVar3.xmD.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_alz.tMR = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_alz.tHj = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_alz.tMS = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_alz.tMT = aVar3.xmD.mL();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_alz.hAK = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_alz.hAJ = aVar3.xmD.mL();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_alz.hAL = aVar3.xmD.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_alz.hAI = aVar3.xmD.readString();
                    return 0;
                case 26:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new bcp();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.tMV = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_alz.hAM = aVar3.xmD.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_alz.tqb = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_alz.tqc = aVar3.xmD.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_alz.hAN = aVar3.xmD.readString();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new my();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alz.tMW = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
