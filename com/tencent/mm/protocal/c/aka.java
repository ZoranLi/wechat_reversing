package com.tencent.mm.protocal.c;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.appbrand.jsapi.v;

public final class aka extends a {
    public String fTO;
    public String tNC;
    public String tND;
    public String tNE;
    public String tNF;
    public int tNG;
    public int tNH;
    public String tNI;
    public int tNJ;
    public int tNK;
    public String tNL;
    public int tNM;
    public int tNN;
    public String tNO;
    public int tNP;
    public int tNQ;
    public String tNR;
    public String tNS;
    public String tNT;
    public String tNU;
    public String tpM;
    public int ttF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fTO != null) {
                aVar.e(1, this.fTO);
            }
            if (this.tNC != null) {
                aVar.e(20, this.tNC);
            }
            if (this.tND != null) {
                aVar.e(21, this.tND);
            }
            if (this.tNE != null) {
                aVar.e(22, this.tNE);
            }
            if (this.tNF != null) {
                aVar.e(23, this.tNF);
            }
            if (this.tpM != null) {
                aVar.e(31, this.tpM);
            }
            aVar.eO(32, this.tNG);
            aVar.eO(33, this.tNH);
            if (this.tNI != null) {
                aVar.e(34, this.tNI);
            }
            aVar.eO(35, this.tNJ);
            aVar.eO(36, this.tNK);
            if (this.tNL != null) {
                aVar.e(37, this.tNL);
            }
            aVar.eO(38, this.tNM);
            aVar.eO(39, this.tNN);
            if (this.tNO != null) {
                aVar.e(41, this.tNO);
            }
            aVar.eO(m.CTRL_INDEX, this.tNP);
            aVar.eO(bh.CTRL_INDEX, this.tNQ);
            aVar.eO(f.CTRL_INDEX, this.ttF);
            if (this.tNR != null) {
                aVar.e(aq.CTRL_INDEX, this.tNR);
            }
            if (this.tNS != null) {
                aVar.e(ao.CTRL_INDEX, this.tNS);
            }
            if (this.tNT != null) {
                aVar.e(cf.CTRL_INDEX, this.tNT);
            }
            if (this.tNU == null) {
                return 0;
            }
            aVar.e(v.CTRL_INDEX, this.tNU);
            return 0;
        } else if (i == 1) {
            if (this.fTO != null) {
                r0 = a.a.a.b.b.a.f(1, this.fTO) + 0;
            } else {
                r0 = 0;
            }
            if (this.tNC != null) {
                r0 += a.a.a.b.b.a.f(20, this.tNC);
            }
            if (this.tND != null) {
                r0 += a.a.a.b.b.a.f(21, this.tND);
            }
            if (this.tNE != null) {
                r0 += a.a.a.b.b.a.f(22, this.tNE);
            }
            if (this.tNF != null) {
                r0 += a.a.a.b.b.a.f(23, this.tNF);
            }
            if (this.tpM != null) {
                r0 += a.a.a.b.b.a.f(31, this.tpM);
            }
            r0 = (r0 + a.a.a.a.eL(32, this.tNG)) + a.a.a.a.eL(33, this.tNH);
            if (this.tNI != null) {
                r0 += a.a.a.b.b.a.f(34, this.tNI);
            }
            r0 = (r0 + a.a.a.a.eL(35, this.tNJ)) + a.a.a.a.eL(36, this.tNK);
            if (this.tNL != null) {
                r0 += a.a.a.b.b.a.f(37, this.tNL);
            }
            r0 = (r0 + a.a.a.a.eL(38, this.tNM)) + a.a.a.a.eL(39, this.tNN);
            if (this.tNO != null) {
                r0 += a.a.a.b.b.a.f(41, this.tNO);
            }
            r0 = ((r0 + a.a.a.a.eL(m.CTRL_INDEX, this.tNP)) + a.a.a.a.eL(bh.CTRL_INDEX, this.tNQ)) + a.a.a.a.eL(f.CTRL_INDEX, this.ttF);
            if (this.tNR != null) {
                r0 += a.a.a.b.b.a.f(aq.CTRL_INDEX, this.tNR);
            }
            if (this.tNS != null) {
                r0 += a.a.a.b.b.a.f(ao.CTRL_INDEX, this.tNS);
            }
            if (this.tNT != null) {
                r0 += a.a.a.b.b.a.f(cf.CTRL_INDEX, this.tNT);
            }
            if (this.tNU != null) {
                r0 += a.a.a.b.b.a.f(v.CTRL_INDEX, this.tNU);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            aka com_tencent_mm_protocal_c_aka = (aka) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aka.fTO = aVar3.xmD.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aka.tNC = aVar3.xmD.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aka.tND = aVar3.xmD.readString();
                    return 0;
                case 22:
                    com_tencent_mm_protocal_c_aka.tNE = aVar3.xmD.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aka.tNF = aVar3.xmD.readString();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    com_tencent_mm_protocal_c_aka.tpM = aVar3.xmD.readString();
                    return 0;
                case 32:
                    com_tencent_mm_protocal_c_aka.tNG = aVar3.xmD.mL();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_aka.tNH = aVar3.xmD.mL();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_aka.tNI = aVar3.xmD.readString();
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    com_tencent_mm_protocal_c_aka.tNJ = aVar3.xmD.mL();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_aka.tNK = aVar3.xmD.mL();
                    return 0;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    com_tencent_mm_protocal_c_aka.tNL = aVar3.xmD.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_aka.tNM = aVar3.xmD.mL();
                    return 0;
                case 39:
                    com_tencent_mm_protocal_c_aka.tNN = aVar3.xmD.mL();
                    return 0;
                case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.CTRL_BYTE /*41*/:
                    com_tencent_mm_protocal_c_aka.tNO = aVar3.xmD.readString();
                    return 0;
                case m.CTRL_INDEX /*200*/:
                    com_tencent_mm_protocal_c_aka.tNP = aVar3.xmD.mL();
                    return 0;
                case bh.CTRL_INDEX /*201*/:
                    com_tencent_mm_protocal_c_aka.tNQ = aVar3.xmD.mL();
                    return 0;
                case f.CTRL_INDEX /*202*/:
                    com_tencent_mm_protocal_c_aka.ttF = aVar3.xmD.mL();
                    return 0;
                case aq.CTRL_INDEX /*203*/:
                    com_tencent_mm_protocal_c_aka.tNR = aVar3.xmD.readString();
                    return 0;
                case ao.CTRL_INDEX /*204*/:
                    com_tencent_mm_protocal_c_aka.tNS = aVar3.xmD.readString();
                    return 0;
                case cf.CTRL_INDEX /*205*/:
                    com_tencent_mm_protocal_c_aka.tNT = aVar3.xmD.readString();
                    return 0;
                case v.CTRL_INDEX /*206*/:
                    com_tencent_mm_protocal_c_aka.tNU = aVar3.xmD.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
