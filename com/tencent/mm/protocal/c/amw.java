package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.bd.b;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import java.util.LinkedList;

public final class amw extends a {
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
    public int jNB;
    public avx tLj;
    public int tMP;
    public String tMQ;
    public String tMR;
    public String tMS;
    public int tMT;
    public int tQH;
    public int tRA;
    public String tRB;
    public oe tRb;
    public int tRn;
    public int tRo;
    public b tRp;
    public int tRr = 2048;
    public avx tRs;
    public avx tRt;
    public int tRu;
    public int tRv;
    public int tRw;
    public int tRx;
    public int tRy;
    public aea tRz;
    public int tdB;
    public int tdy;
    public avx ttp;
    public long twD;
    public String twE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ttp == null) {
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.tLj == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.tRs == null) {
                throw new a.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.tRt == null) {
                throw new a.a.a.b("Not all required fields were included: BindMobile");
            } else {
                aVar.eO(1, this.tRr);
                if (this.ttp != null) {
                    aVar.eQ(2, this.ttp.aUk());
                    this.ttp.a(aVar);
                }
                if (this.tLj != null) {
                    aVar.eQ(3, this.tLj.aUk());
                    this.tLj.a(aVar);
                }
                aVar.eO(4, this.tdy);
                if (this.tRs != null) {
                    aVar.eQ(5, this.tRs.aUk());
                    this.tRs.a(aVar);
                }
                if (this.tRt != null) {
                    aVar.eQ(6, this.tRt.aUk());
                    this.tRt.a(aVar);
                }
                aVar.eO(7, this.jNB);
                aVar.eO(8, this.tRo);
                if (this.tRp != null) {
                    aVar.b(9, this.tRp);
                }
                aVar.eO(10, this.hAD);
                if (this.hAE != null) {
                    aVar.e(11, this.hAE);
                }
                if (this.hAF != null) {
                    aVar.e(12, this.hAF);
                }
                if (this.hAG != null) {
                    aVar.e(13, this.hAG);
                }
                aVar.eO(14, this.hAH);
                if (this.tRb != null) {
                    aVar.eQ(15, this.tRb.aUk());
                    this.tRb.a(aVar);
                }
                aVar.eO(16, this.tdB);
                aVar.eO(17, this.tMP);
                if (this.tMQ != null) {
                    aVar.e(18, this.tMQ);
                }
                aVar.eO(19, this.tRu);
                aVar.eO(20, this.tRv);
                aVar.eO(21, this.tQH);
                aVar.eO(22, this.tRw);
                aVar.eO(23, this.tRx);
                if (this.tMR != null) {
                    aVar.e(24, this.tMR);
                }
                aVar.eO(25, this.tRy);
                if (this.tRz != null) {
                    aVar.eQ(26, this.tRz.aUk());
                    this.tRz.a(aVar);
                }
                if (this.hAI != null) {
                    aVar.e(27, this.hAI);
                }
                if (this.tMS != null) {
                    aVar.e(28, this.tMS);
                }
                aVar.eO(29, this.tMT);
                aVar.eO(30, this.tRA);
                aVar.O(31, this.twD);
                if (this.twE != null) {
                    aVar.e(32, this.twE);
                }
                aVar.eO(33, this.hAK);
                aVar.eO(34, this.hAJ);
                if (this.hAL != null) {
                    aVar.e(35, this.hAL);
                }
                aVar.eO(36, this.tRn);
                if (this.tRB != null) {
                    aVar.e(37, this.tRB);
                }
                if (this.hAM != null) {
                    aVar.e(38, this.hAM);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.eL(1, this.tRr) + 0;
            if (this.ttp != null) {
                r0 += a.a.a.a.eN(2, this.ttp.aUk());
            }
            if (this.tLj != null) {
                r0 += a.a.a.a.eN(3, this.tLj.aUk());
            }
            r0 += a.a.a.a.eL(4, this.tdy);
            if (this.tRs != null) {
                r0 += a.a.a.a.eN(5, this.tRs.aUk());
            }
            if (this.tRt != null) {
                r0 += a.a.a.a.eN(6, this.tRt.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(7, this.jNB)) + a.a.a.a.eL(8, this.tRo);
            if (this.tRp != null) {
                r0 += a.a.a.a.a(9, this.tRp);
            }
            r0 += a.a.a.a.eL(10, this.hAD);
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(11, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(12, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(13, this.hAG);
            }
            r0 += a.a.a.a.eL(14, this.hAH);
            if (this.tRb != null) {
                r0 += a.a.a.a.eN(15, this.tRb.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(16, this.tdB)) + a.a.a.a.eL(17, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(18, this.tMQ);
            }
            r0 = ((((r0 + a.a.a.a.eL(19, this.tRu)) + a.a.a.a.eL(20, this.tRv)) + a.a.a.a.eL(21, this.tQH)) + a.a.a.a.eL(22, this.tRw)) + a.a.a.a.eL(23, this.tRx);
            if (this.tMR != null) {
                r0 += a.a.a.b.b.a.f(24, this.tMR);
            }
            r0 += a.a.a.a.eL(25, this.tRy);
            if (this.tRz != null) {
                r0 += a.a.a.a.eN(26, this.tRz.aUk());
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(27, this.hAI);
            }
            if (this.tMS != null) {
                r0 += a.a.a.b.b.a.f(28, this.tMS);
            }
            r0 = ((r0 + a.a.a.a.eL(29, this.tMT)) + a.a.a.a.eL(30, this.tRA)) + a.a.a.a.N(31, this.twD);
            if (this.twE != null) {
                r0 += a.a.a.b.b.a.f(32, this.twE);
            }
            r0 = (r0 + a.a.a.a.eL(33, this.hAK)) + a.a.a.a.eL(34, this.hAJ);
            if (this.hAL != null) {
                r0 += a.a.a.b.b.a.f(35, this.hAL);
            }
            r0 += a.a.a.a.eL(36, this.tRn);
            if (this.tRB != null) {
                r0 += a.a.a.b.b.a.f(37, this.tRB);
            }
            if (this.hAM != null) {
                return r0 + a.a.a.b.b.a.f(38, this.hAM);
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
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.tLj == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.tRs == null) {
                throw new a.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.tRt != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: BindMobile");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            amw com_tencent_mm_protocal_c_amw = (amw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_amw.tRr = aVar3.xmD.mL();
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
                        com_tencent_mm_protocal_c_amw.ttp = com_tencent_mm_protocal_c_avx;
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
                        com_tencent_mm_protocal_c_amw.tLj = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_amw.tdy = aVar3.xmD.mL();
                    return 0;
                case 5:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amw.tRs = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amw.tRt = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_amw.jNB = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_amw.tRo = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_amw.tRp = aVar3.cic();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_amw.hAD = aVar3.xmD.mL();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_amw.hAE = aVar3.xmD.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_amw.hAF = aVar3.xmD.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_amw.hAG = aVar3.xmD.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_amw.hAH = aVar3.xmD.mL();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new oe();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amw.tRb = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_amw.tdB = aVar3.xmD.mL();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_amw.tMP = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_amw.tMQ = aVar3.xmD.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_amw.tRu = aVar3.xmD.mL();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_amw.tRv = aVar3.xmD.mL();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_amw.tQH = aVar3.xmD.mL();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_amw.tRw = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_amw.tRx = aVar3.xmD.mL();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_amw.tMR = aVar3.xmD.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_amw.tRy = aVar3.xmD.mL();
                    return 0;
                case 26:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new aea();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_amw.tRz = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_amw.hAI = aVar3.xmD.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_amw.tMS = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_amw.tMT = aVar3.xmD.mL();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_amw.tRA = aVar3.xmD.mL();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    com_tencent_mm_protocal_c_amw.twD = aVar3.xmD.mM();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_amw.twE = aVar3.xmD.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_amw.hAK = aVar3.xmD.mL();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_amw.hAJ = aVar3.xmD.mL();
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    com_tencent_mm_protocal_c_amw.hAL = aVar3.xmD.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_amw.tRn = aVar3.xmD.mL();
                    return 0;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    com_tencent_mm_protocal_c_amw.tRB = aVar3.xmD.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_amw.hAM = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
