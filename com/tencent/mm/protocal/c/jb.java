package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import java.util.LinkedList;

public final class jb extends a {
    public String aJE;
    public String fTO;
    public String hib;
    public String kAO;
    public String kdE;
    public int kdF;
    public String kdG;
    public String kdH;
    public String keS;
    public String keT;
    public String title;
    public String toA;
    public int toB;
    public oa toC;
    public bik toD;
    public sl toE;
    public au toF;
    public int toG;
    public int toH;
    public String toI;
    public int toJ;
    public String toK;
    public int toL;
    public lz toM;
    public String toN;
    public lz toO;
    public or toP;
    public boolean toQ;
    public int toR;
    public boolean toS;
    public String tog;
    public int toh;
    public String toi;
    public LinkedList<lz> toj = new LinkedList();
    public LinkedList<lz> tok = new LinkedList();
    public String tol;
    public String tom;
    public int ton;
    public String too;
    public String toq;
    public int tor;
    public String tos;
    public String tot;
    public long tou;
    public String tov;
    public String tow;
    public String tox;
    public iv toy;
    public String toz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.kdE != null) {
                aVar.e(1, this.kdE);
            }
            if (this.kdG != null) {
                aVar.e(2, this.kdG);
            }
            if (this.fTO != null) {
                aVar.e(3, this.fTO);
            }
            if (this.tog != null) {
                aVar.e(4, this.tog);
            }
            aVar.eO(5, this.toh);
            aVar.eO(6, this.kdF);
            if (this.keT != null) {
                aVar.e(7, this.keT);
            }
            if (this.title != null) {
                aVar.e(8, this.title);
            }
            if (this.kdH != null) {
                aVar.e(9, this.kdH);
            }
            if (this.hib != null) {
                aVar.e(10, this.hib);
            }
            if (this.kAO != null) {
                aVar.e(11, this.kAO);
            }
            if (this.toi != null) {
                aVar.e(12, this.toi);
            }
            aVar.d(13, 8, this.toj);
            aVar.d(14, 8, this.tok);
            if (this.tol != null) {
                aVar.e(15, this.tol);
            }
            if (this.tom != null) {
                aVar.e(16, this.tom);
            }
            if (this.aJE != null) {
                aVar.e(17, this.aJE);
            }
            aVar.eO(18, this.ton);
            if (this.keS != null) {
                aVar.e(19, this.keS);
            }
            if (this.too != null) {
                aVar.e(20, this.too);
            }
            if (this.toq != null) {
                aVar.e(21, this.toq);
            }
            aVar.eO(22, this.tor);
            if (this.tos != null) {
                aVar.e(23, this.tos);
            }
            if (this.tot != null) {
                aVar.e(24, this.tot);
            }
            aVar.O(25, this.tou);
            if (this.tov != null) {
                aVar.e(26, this.tov);
            }
            if (this.tow != null) {
                aVar.e(27, this.tow);
            }
            if (this.tox != null) {
                aVar.e(28, this.tox);
            }
            if (this.toy != null) {
                aVar.eQ(29, this.toy.aUk());
                this.toy.a(aVar);
            }
            if (this.toz != null) {
                aVar.e(30, this.toz);
            }
            if (this.toA != null) {
                aVar.e(31, this.toA);
            }
            aVar.eO(32, this.toB);
            if (this.toC != null) {
                aVar.eQ(33, this.toC.aUk());
                this.toC.a(aVar);
            }
            if (this.toD != null) {
                aVar.eQ(34, this.toD.aUk());
                this.toD.a(aVar);
            }
            if (this.toE != null) {
                aVar.eQ(35, this.toE.aUk());
                this.toE.a(aVar);
            }
            if (this.toF != null) {
                aVar.eQ(36, this.toF.aUk());
                this.toF.a(aVar);
            }
            aVar.eO(37, this.toG);
            aVar.eO(38, this.toH);
            if (this.toI != null) {
                aVar.e(39, this.toI);
            }
            aVar.eO(40, this.toJ);
            if (this.toK != null) {
                aVar.e(41, this.toK);
            }
            aVar.eO(42, this.toL);
            if (this.toM != null) {
                aVar.eQ(43, this.toM.aUk());
                this.toM.a(aVar);
            }
            if (this.toN != null) {
                aVar.e(44, this.toN);
            }
            if (this.toO != null) {
                aVar.eQ(45, this.toO.aUk());
                this.toO.a(aVar);
            }
            if (this.toP != null) {
                aVar.eQ(46, this.toP.aUk());
                this.toP.a(aVar);
            }
            aVar.an(47, this.toQ);
            aVar.eO(48, this.toR);
            aVar.an(49, this.toS);
            return 0;
        } else if (i == 1) {
            if (this.kdE != null) {
                r0 = a.a.a.b.b.a.f(1, this.kdE) + 0;
            } else {
                r0 = 0;
            }
            if (this.kdG != null) {
                r0 += a.a.a.b.b.a.f(2, this.kdG);
            }
            if (this.fTO != null) {
                r0 += a.a.a.b.b.a.f(3, this.fTO);
            }
            if (this.tog != null) {
                r0 += a.a.a.b.b.a.f(4, this.tog);
            }
            r0 = (r0 + a.a.a.a.eL(5, this.toh)) + a.a.a.a.eL(6, this.kdF);
            if (this.keT != null) {
                r0 += a.a.a.b.b.a.f(7, this.keT);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(8, this.title);
            }
            if (this.kdH != null) {
                r0 += a.a.a.b.b.a.f(9, this.kdH);
            }
            if (this.hib != null) {
                r0 += a.a.a.b.b.a.f(10, this.hib);
            }
            if (this.kAO != null) {
                r0 += a.a.a.b.b.a.f(11, this.kAO);
            }
            if (this.toi != null) {
                r0 += a.a.a.b.b.a.f(12, this.toi);
            }
            r0 = (r0 + a.a.a.a.c(13, 8, this.toj)) + a.a.a.a.c(14, 8, this.tok);
            if (this.tol != null) {
                r0 += a.a.a.b.b.a.f(15, this.tol);
            }
            if (this.tom != null) {
                r0 += a.a.a.b.b.a.f(16, this.tom);
            }
            if (this.aJE != null) {
                r0 += a.a.a.b.b.a.f(17, this.aJE);
            }
            r0 += a.a.a.a.eL(18, this.ton);
            if (this.keS != null) {
                r0 += a.a.a.b.b.a.f(19, this.keS);
            }
            if (this.too != null) {
                r0 += a.a.a.b.b.a.f(20, this.too);
            }
            if (this.toq != null) {
                r0 += a.a.a.b.b.a.f(21, this.toq);
            }
            r0 += a.a.a.a.eL(22, this.tor);
            if (this.tos != null) {
                r0 += a.a.a.b.b.a.f(23, this.tos);
            }
            if (this.tot != null) {
                r0 += a.a.a.b.b.a.f(24, this.tot);
            }
            r0 += a.a.a.a.N(25, this.tou);
            if (this.tov != null) {
                r0 += a.a.a.b.b.a.f(26, this.tov);
            }
            if (this.tow != null) {
                r0 += a.a.a.b.b.a.f(27, this.tow);
            }
            if (this.tox != null) {
                r0 += a.a.a.b.b.a.f(28, this.tox);
            }
            if (this.toy != null) {
                r0 += a.a.a.a.eN(29, this.toy.aUk());
            }
            if (this.toz != null) {
                r0 += a.a.a.b.b.a.f(30, this.toz);
            }
            if (this.toA != null) {
                r0 += a.a.a.b.b.a.f(31, this.toA);
            }
            r0 += a.a.a.a.eL(32, this.toB);
            if (this.toC != null) {
                r0 += a.a.a.a.eN(33, this.toC.aUk());
            }
            if (this.toD != null) {
                r0 += a.a.a.a.eN(34, this.toD.aUk());
            }
            if (this.toE != null) {
                r0 += a.a.a.a.eN(35, this.toE.aUk());
            }
            if (this.toF != null) {
                r0 += a.a.a.a.eN(36, this.toF.aUk());
            }
            r0 = (r0 + a.a.a.a.eL(37, this.toG)) + a.a.a.a.eL(38, this.toH);
            if (this.toI != null) {
                r0 += a.a.a.b.b.a.f(39, this.toI);
            }
            r0 += a.a.a.a.eL(40, this.toJ);
            if (this.toK != null) {
                r0 += a.a.a.b.b.a.f(41, this.toK);
            }
            r0 += a.a.a.a.eL(42, this.toL);
            if (this.toM != null) {
                r0 += a.a.a.a.eN(43, this.toM.aUk());
            }
            if (this.toN != null) {
                r0 += a.a.a.b.b.a.f(44, this.toN);
            }
            if (this.toO != null) {
                r0 += a.a.a.a.eN(45, this.toO.aUk());
            }
            if (this.toP != null) {
                r0 += a.a.a.a.eN(46, this.toP.aUk());
            }
            return ((r0 + (a.a.a.b.b.a.cH(47) + 1)) + a.a.a.a.eL(48, this.toR)) + (a.a.a.b.b.a.cH(49) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.toj.clear();
            this.tok.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.cid();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            jb jbVar = (jb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList En;
            int size;
            a lzVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jbVar.kdE = aVar3.xmD.readString();
                    return 0;
                case 2:
                    jbVar.kdG = aVar3.xmD.readString();
                    return 0;
                case 3:
                    jbVar.fTO = aVar3.xmD.readString();
                    return 0;
                case 4:
                    jbVar.tog = aVar3.xmD.readString();
                    return 0;
                case 5:
                    jbVar.toh = aVar3.xmD.mL();
                    return 0;
                case 6:
                    jbVar.kdF = aVar3.xmD.mL();
                    return 0;
                case 7:
                    jbVar.keT = aVar3.xmD.readString();
                    return 0;
                case 8:
                    jbVar.title = aVar3.xmD.readString();
                    return 0;
                case 9:
                    jbVar.kdH = aVar3.xmD.readString();
                    return 0;
                case 10:
                    jbVar.hib = aVar3.xmD.readString();
                    return 0;
                case 11:
                    jbVar.kAO = aVar3.xmD.readString();
                    return 0;
                case 12:
                    jbVar.toi = aVar3.xmD.readString();
                    return 0;
                case 13:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toj.add(lzVar);
                    }
                    return 0;
                case 14:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.tok.add(lzVar);
                    }
                    return 0;
                case 15:
                    jbVar.tol = aVar3.xmD.readString();
                    return 0;
                case 16:
                    jbVar.tom = aVar3.xmD.readString();
                    return 0;
                case 17:
                    jbVar.aJE = aVar3.xmD.readString();
                    return 0;
                case 18:
                    jbVar.ton = aVar3.xmD.mL();
                    return 0;
                case 19:
                    jbVar.keS = aVar3.xmD.readString();
                    return 0;
                case 20:
                    jbVar.too = aVar3.xmD.readString();
                    return 0;
                case 21:
                    jbVar.toq = aVar3.xmD.readString();
                    return 0;
                case 22:
                    jbVar.tor = aVar3.xmD.mL();
                    return 0;
                case 23:
                    jbVar.tos = aVar3.xmD.readString();
                    return 0;
                case 24:
                    jbVar.tot = aVar3.xmD.readString();
                    return 0;
                case 25:
                    jbVar.tou = aVar3.xmD.mM();
                    return 0;
                case 26:
                    jbVar.tov = aVar3.xmD.readString();
                    return 0;
                case 27:
                    jbVar.tow = aVar3.xmD.readString();
                    return 0;
                case 28:
                    jbVar.tox = aVar3.xmD.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new iv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toy = lzVar;
                    }
                    return 0;
                case 30:
                    jbVar.toz = aVar3.xmD.readString();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    jbVar.toA = aVar3.xmD.readString();
                    return 0;
                case 32:
                    jbVar.toB = aVar3.xmD.mL();
                    return 0;
                case 33:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new oa();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toC = lzVar;
                    }
                    return 0;
                case 34:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new bik();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toD = lzVar;
                    }
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new sl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toE = lzVar;
                    }
                    return 0;
                case 36:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new au();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toF = lzVar;
                    }
                    return 0;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    jbVar.toG = aVar3.xmD.mL();
                    return 0;
                case 38:
                    jbVar.toH = aVar3.xmD.mL();
                    return 0;
                case 39:
                    jbVar.toI = aVar3.xmD.readString();
                    return 0;
                case 40:
                    jbVar.toJ = aVar3.xmD.mL();
                    return 0;
                case v.CTRL_BYTE /*41*/:
                    jbVar.toK = aVar3.xmD.readString();
                    return 0;
                case 42:
                    jbVar.toL = aVar3.xmD.mL();
                    return 0;
                case 43:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toM = lzVar;
                    }
                    return 0;
                case 44:
                    jbVar.toN = aVar3.xmD.readString();
                    return 0;
                case 45:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new lz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toO = lzVar;
                    }
                    return 0;
                case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    En = aVar3.En(intValue);
                    size = En.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) En.get(intValue);
                        lzVar = new or();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        jbVar.toP = lzVar;
                    }
                    return 0;
                case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    jbVar.toQ = aVar3.cib();
                    return 0;
                case 48:
                    jbVar.toR = aVar3.xmD.mL();
                    return 0;
                case 49:
                    jbVar.toS = aVar3.cib();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
