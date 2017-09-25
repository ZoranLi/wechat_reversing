package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.wcdb.FileUtils;
import java.util.LinkedList;

public final class ame extends a {
    public String gkP;
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
    public String mvZ;
    public jy tDC;
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
    public avx tQF;
    public int tQG;
    public int tQH;
    public String tQI;
    public String tQJ;
    public String tQK;
    public String tQL;
    public String tQM;
    public String tQN;
    public String tQO;
    public String tQP;
    public by tQQ;
    public int tQR;
    public int tQS;
    public int tQT;
    public int tQU;
    public String tQV;
    public aql tQW;
    public int tQX;
    public int tQY;
    public int tQZ;
    public avx tQl;
    public avx tQm;
    public avx tQn;
    public int tfW;
    public avw tfh;
    public String tgT;
    public String tqb;
    public String tqc;
    public int tsD;
    public int tsE;
    public LinkedList<avv> tsF = new LinkedList();
    public int tsH;
    public int tsI;
    public int tsx;
    public int tsy;
    public avx ttf;
    public avx ttg;
    public avx ttp;
    public int ttr;
    public String tts;

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
                aVar.eO(7, this.tsx);
                aVar.eO(8, this.tsy);
                aVar.eO(9, this.tQB);
                if (this.tQl != null) {
                    aVar.eQ(10, this.tQl.aUk());
                    this.tQl.a(aVar);
                }
                if (this.tQm != null) {
                    aVar.eQ(11, this.tQm.aUk());
                    this.tQm.a(aVar);
                }
                if (this.tQn != null) {
                    aVar.eQ(12, this.tQn.aUk());
                    this.tQn.a(aVar);
                }
                aVar.eO(13, this.tsD);
                aVar.eO(14, this.tsE);
                aVar.d(15, 8, this.tsF);
                if (this.tQF != null) {
                    aVar.eQ(16, this.tQF.aUk());
                    this.tQF.a(aVar);
                }
                aVar.eO(17, this.tsH);
                aVar.eO(18, this.tsI);
                if (this.hAE != null) {
                    aVar.e(19, this.hAE);
                }
                if (this.hAF != null) {
                    aVar.e(20, this.hAF);
                }
                if (this.hAG != null) {
                    aVar.e(21, this.hAG);
                }
                aVar.eO(22, this.hAH);
                aVar.eO(23, this.tQG);
                aVar.eO(24, this.tMP);
                if (this.tMQ != null) {
                    aVar.e(25, this.tMQ);
                }
                aVar.eO(26, this.tQH);
                aVar.eO(27, this.tfW);
                if (this.tMR != null) {
                    aVar.e(28, this.tMR);
                }
                if (this.tHj != null) {
                    aVar.e(29, this.tHj);
                }
                if (this.hAI != null) {
                    aVar.e(30, this.hAI);
                }
                if (this.tQI != null) {
                    aVar.e(31, this.tQI);
                }
                if (this.tMS != null) {
                    aVar.e(32, this.tMS);
                }
                aVar.eO(33, this.tMT);
                aVar.eO(34, this.hAK);
                aVar.eO(35, this.hAJ);
                if (this.hAL != null) {
                    aVar.e(36, this.hAL);
                }
                if (this.tMV != null) {
                    aVar.eQ(37, this.tMV.aUk());
                    this.tMV.a(aVar);
                }
                if (this.hAM != null) {
                    aVar.e(38, this.hAM);
                }
                if (this.tqb != null) {
                    aVar.e(39, this.tqb);
                }
                if (this.tqc != null) {
                    aVar.e(40, this.tqc);
                }
                if (this.hAN != null) {
                    aVar.e(41, this.hAN);
                }
                if (this.tMW != null) {
                    aVar.eQ(42, this.tMW.aUk());
                    this.tMW.a(aVar);
                }
                if (this.tQJ != null) {
                    aVar.e(43, this.tQJ);
                }
                if (this.tQK != null) {
                    aVar.e(44, this.tQK);
                }
                if (this.tQL != null) {
                    aVar.e(45, this.tQL);
                }
                if (this.tQM != null) {
                    aVar.e(46, this.tQM);
                }
                if (this.tQN != null) {
                    aVar.e(47, this.tQN);
                }
                if (this.tQO != null) {
                    aVar.e(48, this.tQO);
                }
                if (this.tQP != null) {
                    aVar.e(49, this.tQP);
                }
                if (this.tQQ != null) {
                    aVar.eQ(50, this.tQQ.aUk());
                    this.tQQ.a(aVar);
                }
                aVar.eO(53, this.tQR);
                if (this.mvZ != null) {
                    aVar.e(54, this.mvZ);
                }
                aVar.eO(55, this.tQS);
                aVar.eO(56, this.tQT);
                if (this.tDC != null) {
                    aVar.eQ(57, this.tDC.aUk());
                    this.tDC.a(aVar);
                }
                aVar.eO(58, this.tQU);
                if (this.tgT != null) {
                    aVar.e(59, this.tgT);
                }
                if (this.tQV != null) {
                    aVar.e(60, this.tQV);
                }
                if (this.tts != null) {
                    aVar.e(61, this.tts);
                }
                if (this.tQW != null) {
                    aVar.eQ(62, this.tQW.aUk());
                    this.tQW.a(aVar);
                }
                if (this.gkP != null) {
                    aVar.e(63, this.gkP);
                }
                aVar.eO(64, this.tQX);
                aVar.eO(65, this.ttr);
                aVar.eO(66, this.tQY);
                aVar.eO(67, this.tQZ);
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
            r0 = ((r0 + a.a.a.a.eL(7, this.tsx)) + a.a.a.a.eL(8, this.tsy)) + a.a.a.a.eL(9, this.tQB);
            if (this.tQl != null) {
                r0 += a.a.a.a.eN(10, this.tQl.aUk());
            }
            if (this.tQm != null) {
                r0 += a.a.a.a.eN(11, this.tQm.aUk());
            }
            if (this.tQn != null) {
                r0 += a.a.a.a.eN(12, this.tQn.aUk());
            }
            r0 = ((r0 + a.a.a.a.eL(13, this.tsD)) + a.a.a.a.eL(14, this.tsE)) + a.a.a.a.c(15, 8, this.tsF);
            if (this.tQF != null) {
                r0 += a.a.a.a.eN(16, this.tQF.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(17, this.tsH)) + a.a.a.a.eL(18, this.tsI);
            if (this.hAE != null) {
                r0 += a.a.a.b.b.a.f(19, this.hAE);
            }
            if (this.hAF != null) {
                r0 += a.a.a.b.b.a.f(20, this.hAF);
            }
            if (this.hAG != null) {
                r0 += a.a.a.b.b.a.f(21, this.hAG);
            }
            r0 = ((r0 + a.a.a.a.eL(22, this.hAH)) + a.a.a.a.eL(23, this.tQG)) + a.a.a.a.eL(24, this.tMP);
            if (this.tMQ != null) {
                r0 += a.a.a.b.b.a.f(25, this.tMQ);
            }
            r0 = (r0 + a.a.a.a.eL(26, this.tQH)) + a.a.a.a.eL(27, this.tfW);
            if (this.tMR != null) {
                r0 += a.a.a.b.b.a.f(28, this.tMR);
            }
            if (this.tHj != null) {
                r0 += a.a.a.b.b.a.f(29, this.tHj);
            }
            if (this.hAI != null) {
                r0 += a.a.a.b.b.a.f(30, this.hAI);
            }
            if (this.tQI != null) {
                r0 += a.a.a.b.b.a.f(31, this.tQI);
            }
            if (this.tMS != null) {
                r0 += a.a.a.b.b.a.f(32, this.tMS);
            }
            r0 = ((r0 + a.a.a.a.eL(33, this.tMT)) + a.a.a.a.eL(34, this.hAK)) + a.a.a.a.eL(35, this.hAJ);
            if (this.hAL != null) {
                r0 += a.a.a.b.b.a.f(36, this.hAL);
            }
            if (this.tMV != null) {
                r0 += a.a.a.a.eN(37, this.tMV.aUk());
            }
            if (this.hAM != null) {
                r0 += a.a.a.b.b.a.f(38, this.hAM);
            }
            if (this.tqb != null) {
                r0 += a.a.a.b.b.a.f(39, this.tqb);
            }
            if (this.tqc != null) {
                r0 += a.a.a.b.b.a.f(40, this.tqc);
            }
            if (this.hAN != null) {
                r0 += a.a.a.b.b.a.f(41, this.hAN);
            }
            if (this.tMW != null) {
                r0 += a.a.a.a.eN(42, this.tMW.aUk());
            }
            if (this.tQJ != null) {
                r0 += a.a.a.b.b.a.f(43, this.tQJ);
            }
            if (this.tQK != null) {
                r0 += a.a.a.b.b.a.f(44, this.tQK);
            }
            if (this.tQL != null) {
                r0 += a.a.a.b.b.a.f(45, this.tQL);
            }
            if (this.tQM != null) {
                r0 += a.a.a.b.b.a.f(46, this.tQM);
            }
            if (this.tQN != null) {
                r0 += a.a.a.b.b.a.f(47, this.tQN);
            }
            if (this.tQO != null) {
                r0 += a.a.a.b.b.a.f(48, this.tQO);
            }
            if (this.tQP != null) {
                r0 += a.a.a.b.b.a.f(49, this.tQP);
            }
            if (this.tQQ != null) {
                r0 += a.a.a.a.eN(50, this.tQQ.aUk());
            }
            r0 += a.a.a.a.eL(53, this.tQR);
            if (this.mvZ != null) {
                r0 += a.a.a.b.b.a.f(54, this.mvZ);
            }
            r0 = (r0 + a.a.a.a.eL(55, this.tQS)) + a.a.a.a.eL(56, this.tQT);
            if (this.tDC != null) {
                r0 += a.a.a.a.eN(57, this.tDC.aUk());
            }
            r0 += a.a.a.a.eL(58, this.tQU);
            if (this.tgT != null) {
                r0 += a.a.a.b.b.a.f(59, this.tgT);
            }
            if (this.tQV != null) {
                r0 += a.a.a.b.b.a.f(60, this.tQV);
            }
            if (this.tts != null) {
                r0 += a.a.a.b.b.a.f(61, this.tts);
            }
            if (this.tQW != null) {
                r0 += a.a.a.a.eN(62, this.tQW.aUk());
            }
            if (this.gkP != null) {
                r0 += a.a.a.b.b.a.f(63, this.gkP);
            }
            return (((r0 + a.a.a.a.eL(64, this.tQX)) + a.a.a.a.eL(65, this.ttr)) + a.a.a.a.eL(66, this.tQY)) + a.a.a.a.eL(67, this.tQZ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.tsF.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            } else if (this.tfh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ame com_tencent_mm_protocal_c_ame = (ame) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a com_tencent_mm_protocal_c_avx;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.ttp = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 2:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tLj = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 3:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.ttf = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 4:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.ttg = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ame.hAD = aVar3.xmD.mL();
                    return 0;
                case 6:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tfh = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ame.tsx = aVar3.xmD.mL();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ame.tsy = aVar3.xmD.mL();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ame.tQB = aVar3.xmD.mL();
                    return 0;
                case 10:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tQl = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 11:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tQm = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 12:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tQn = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ame.tsD = aVar3.xmD.mL();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ame.tsE = aVar3.xmD.mL();
                    return 0;
                case 15:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tsF.add(com_tencent_mm_protocal_c_avx);
                    }
                    return 0;
                case 16:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new avx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tQF = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ame.tsH = aVar3.xmD.mL();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ame.tsI = aVar3.xmD.mL();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ame.hAE = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ame.hAF = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ame.hAG = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_ame.hAH = aVar3.xmD.mL();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_ame.tQG = aVar3.xmD.mL();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ame.tMP = aVar3.xmD.mL();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ame.tMQ = aVar3.xmD.readString();
                    return 0;
                case 26:
                    com_tencent_mm_protocal_c_ame.tQH = aVar3.xmD.mL();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ame.tfW = aVar3.xmD.mL();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_ame.tMR = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    com_tencent_mm_protocal_c_ame.tHj = aVar3.xmD.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_ame.hAI = aVar3.xmD.readString();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    com_tencent_mm_protocal_c_ame.tQI = aVar3.xmD.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_ame.tMS = aVar3.xmD.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_ame.tMT = aVar3.xmD.mL();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_ame.hAK = aVar3.xmD.mL();
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    com_tencent_mm_protocal_c_ame.hAJ = aVar3.xmD.mL();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_ame.hAL = aVar3.xmD.readString();
                    return 0;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new bcp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tMV = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_ame.hAM = aVar3.xmD.readString();
                    return 0;
                case 39:
                    com_tencent_mm_protocal_c_ame.tqb = aVar3.xmD.readString();
                    return 0;
                case 40:
                    com_tencent_mm_protocal_c_ame.tqc = aVar3.xmD.readString();
                    return 0;
                case v.CTRL_BYTE /*41*/:
                    com_tencent_mm_protocal_c_ame.hAN = aVar3.xmD.readString();
                    return 0;
                case 42:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new my();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tMW = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 43:
                    com_tencent_mm_protocal_c_ame.tQJ = aVar3.xmD.readString();
                    return 0;
                case 44:
                    com_tencent_mm_protocal_c_ame.tQK = aVar3.xmD.readString();
                    return 0;
                case 45:
                    com_tencent_mm_protocal_c_ame.tQL = aVar3.xmD.readString();
                    return 0;
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    com_tencent_mm_protocal_c_ame.tQM = aVar3.xmD.readString();
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    com_tencent_mm_protocal_c_ame.tQN = aVar3.xmD.readString();
                    return 0;
                case 48:
                    com_tencent_mm_protocal_c_ame.tQO = aVar3.xmD.readString();
                    return 0;
                case 49:
                    com_tencent_mm_protocal_c_ame.tQP = aVar3.xmD.readString();
                    return 0;
                case 50:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new by();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tQQ = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    com_tencent_mm_protocal_c_ame.tQR = aVar3.xmD.mL();
                    return 0;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    com_tencent_mm_protocal_c_ame.mvZ = aVar3.xmD.readString();
                    return 0;
                case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                    com_tencent_mm_protocal_c_ame.tQS = aVar3.xmD.mL();
                    return 0;
                case FileUtils.S_IRWXG /*56*/:
                    com_tencent_mm_protocal_c_ame.tQT = aVar3.xmD.mL();
                    return 0;
                case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*57*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new jy();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tDC = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case m.CTRL_INDEX /*58*/:
                    com_tencent_mm_protocal_c_ame.tQU = aVar3.xmD.mL();
                    return 0;
                case bc.CTRL_INDEX /*59*/:
                    com_tencent_mm_protocal_c_ame.tgT = aVar3.xmD.readString();
                    return 0;
                case 60:
                    com_tencent_mm_protocal_c_ame.tQV = aVar3.xmD.readString();
                    return 0;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                    com_tencent_mm_protocal_c_ame.tts = aVar3.xmD.readString();
                    return 0;
                case 62:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        com_tencent_mm_protocal_c_avx = new aql();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avx.a(aVar4, com_tencent_mm_protocal_c_avx, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ame.tQW = com_tencent_mm_protocal_c_avx;
                    }
                    return 0;
                case 63:
                    com_tencent_mm_protocal_c_ame.gkP = aVar3.xmD.readString();
                    return 0;
                case 64:
                    com_tencent_mm_protocal_c_ame.tQX = aVar3.xmD.mL();
                    return 0;
                case 65:
                    com_tencent_mm_protocal_c_ame.ttr = aVar3.xmD.mL();
                    return 0;
                case 66:
                    com_tencent_mm_protocal_c_ame.tQY = aVar3.xmD.mL();
                    return 0;
                case 67:
                    com_tencent_mm_protocal_c_ame.tQZ = aVar3.xmD.mL();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
