package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.b;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.afv;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.ans;
import com.tencent.mm.protocal.c.bds;
import com.tencent.mm.protocal.c.lk;
import com.tencent.mm.protocal.c.ll;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.protocal.c.wy;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static ll toMMReportKvReq(i iVar) {
        ll llVar = new ll();
        llVar.trE = iVar.taq;
        llVar.trF = iVar.taG;
        llVar.trG = iVar.taE;
        for (int i = 0; i < iVar.taH.size(); i++) {
            e eVar = (e) iVar.taH.get(i);
            lk lkVar = new lk();
            lkVar.leD = eVar.uin;
            lkVar.tiC = eVar.tao;
            lkVar.trD = eVar.nettype;
            lkVar.tlw = eVar.taA;
            lkVar.tlu = eVar.tay;
            lkVar.tlv = eVar.taz;
            lkVar.tlx = eVar.taB;
            lkVar.tly = eVar.taC;
            lkVar.jOg = eVar.taD;
            for (int i2 = 0; i2 < eVar.tap.size(); i2++) {
                d dVar = (d) eVar.tap.get(i2);
                aic com_tencent_mm_protocal_c_aic = new aic();
                com_tencent_mm_protocal_c_aic.tMh = dVar.tan;
                com_tencent_mm_protocal_c_aic.tMi = dVar.taw;
                com_tencent_mm_protocal_c_aic.tMj = dVar.tax;
                com_tencent_mm_protocal_c_aic.ttQ = dVar.poY;
                com_tencent_mm_protocal_c_aic.jNd = dVar.count;
                lkVar.muY.add(com_tencent_mm_protocal_c_aic);
            }
            llVar.trH.add(lkVar);
        }
        return llVar;
    }

    public static ll toMMReportIdkeyReq(g gVar) {
        ll llVar = new ll();
        llVar.trE = gVar.taq;
        llVar.trF = gVar.taG;
        llVar.trG = 0;
        for (int i = 0; i < gVar.taH.size(); i++) {
            b bVar = (b) gVar.taH.get(i);
            lk lkVar = new lk();
            lkVar.leD = bVar.uin;
            lkVar.tiC = bVar.tao;
            lkVar.trD = bVar.nettype;
            for (int i2 = 0; i2 < bVar.tap.size(); i2++) {
                a aVar = (a) bVar.tap.get(i2);
                aic com_tencent_mm_protocal_c_aic = new aic();
                com_tencent_mm_protocal_c_aic.tMh = aVar.tan;
                com_tencent_mm_protocal_c_aic.ttQ = 0;
                com_tencent_mm_protocal_c_aic.tMj = 0;
                com_tencent_mm_protocal_c_aic.jNd = aVar.count;
                com_tencent_mm_protocal_c_aic.tMi = com.tencent.mm.bd.b.aU(Integer.toString(aVar.value).getBytes());
                lkVar.muY.add(com_tencent_mm_protocal_c_aic);
            }
            llVar.trH.add(lkVar);
        }
        return llVar;
    }

    private static o fillStrategyTable(LinkedList<bds> linkedList) {
        o oVar = new o();
        for (int i = 0; i < linkedList.size(); i++) {
            bds com_tencent_mm_protocal_c_bds = (bds) linkedList.get(i);
            m mVar = new m();
            mVar.taT = com_tencent_mm_protocal_c_bds.ueY;
            mVar.taU = com_tencent_mm_protocal_c_bds.ueZ;
            for (int i2 = 0; i2 < com_tencent_mm_protocal_c_bds.ufa.size(); i2++) {
                ans com_tencent_mm_protocal_c_ans = (ans) com_tencent_mm_protocal_c_bds.ufa.get(i2);
                n nVar = new n();
                nVar.tan = com_tencent_mm_protocal_c_ans.tMh;
                nVar.taW = com_tencent_mm_protocal_c_ans.tSO;
                nVar.taX = com_tencent_mm_protocal_c_ans.tSM;
                nVar.taY = com_tencent_mm_protocal_c_ans.tSN;
                nVar.taZ = com_tencent_mm_protocal_c_ans.tSP;
                nVar.tba = com_tencent_mm_protocal_c_ans.tSQ;
                nVar.tbb = com_tencent_mm_protocal_c_ans.tSR;
                mVar.taV.add(nVar);
            }
            oVar.tbc.add(mVar);
        }
        return oVar;
    }

    public static j toSmcReportKvResp(lm lmVar) {
        j jVar = new j();
        jVar.ret = lmVar.thX;
        jVar.taq = lmVar.trK;
        jVar.tar = lmVar.trL;
        jVar.taE = lmVar.trM;
        jVar.tau = lmVar.trQ;
        jVar.taJ = lmVar.trR;
        jVar.tav = lmVar.trS;
        jVar.tas = fillStrategyTable(lmVar.trN);
        jVar.tat = fillStrategyTable(lmVar.trO);
        jVar.taF = fillStrategyTable(lmVar.trP);
        return jVar;
    }

    public static h toSmcReportIdkeyResp(lm lmVar) {
        h hVar = new h();
        hVar.ret = lmVar.thX;
        hVar.taq = lmVar.trK;
        hVar.tar = lmVar.trL;
        hVar.tau = lmVar.trQ;
        hVar.taJ = lmVar.trR;
        hVar.tav = lmVar.trS;
        hVar.tas = fillStrategyTable(lmVar.trN);
        hVar.tat = fillStrategyTable(lmVar.trO);
        return hVar;
    }

    public static wx toMMGetStrategyReq() {
        wx wxVar = new wx();
        ArrayList strategyVersions = SmcLogic.getStrategyVersions();
        if (strategyVersions.size() != 6) {
            return null;
        }
        wxVar.trE = ((Integer) strategyVersions.get(0)).intValue();
        wxVar.trF = ((Integer) strategyVersions.get(1)).intValue();
        wxVar.trG = ((Integer) strategyVersions.get(2)).intValue();
        wxVar.tDD = ((Integer) strategyVersions.get(3)).intValue();
        wxVar.tDE = ((Integer) strategyVersions.get(4)).intValue();
        wxVar.tDF = ((Integer) strategyVersions.get(5)).intValue();
        return wxVar;
    }

    public static f toSmcKVStrategyResp(wy wyVar) {
        f fVar = new f();
        fVar.ret = wyVar.thX;
        fVar.taq = wyVar.tDD;
        fVar.tar = wyVar.tDE;
        fVar.taE = wyVar.tDF;
        fVar.tau = wyVar.trQ;
        fVar.tav = wyVar.trS;
        fVar.tas = fillStrategyTable(wyVar.tDG);
        fVar.tat = fillStrategyTable(wyVar.tDH);
        fVar.taF = fillStrategyTable(wyVar.tDI);
        return fVar;
    }

    public static c toSmcIdkeyStrategyResp(wy wyVar) {
        c cVar = new c();
        cVar.ret = wyVar.thX;
        cVar.taq = wyVar.trK;
        cVar.tar = wyVar.trL;
        cVar.tau = wyVar.trQ;
        cVar.tav = wyVar.trS;
        cVar.tas = fillStrategyTable(wyVar.trN);
        cVar.tat = fillStrategyTable(wyVar.trO);
        return cVar;
    }

    public static afu toMMSelfMonitor(k kVar) {
        afu com_tencent_mm_protocal_c_afu = new afu();
        com_tencent_mm_protocal_c_afu.tKR = kVar.taK;
        for (int i = 0; i < kVar.taL.size(); i++) {
            afv com_tencent_mm_protocal_c_afv = new afv();
            l lVar = (l) kVar.taL.get(i);
            com_tencent_mm_protocal_c_afv.tKS = lVar.taM;
            com_tencent_mm_protocal_c_afv.fDB = lVar.action;
            com_tencent_mm_protocal_c_afv.tKT = lVar.taN;
            com_tencent_mm_protocal_c_afv.tKU = lVar.taO;
            com_tencent_mm_protocal_c_afv.tKV = lVar.taP;
            com_tencent_mm_protocal_c_afv.tKW = lVar.taQ;
            com_tencent_mm_protocal_c_afv.tKX = lVar.taR;
            com_tencent_mm_protocal_c_afv.tKY = lVar.taS;
            com_tencent_mm_protocal_c_afu.muY.add(com_tencent_mm_protocal_c_afv);
        }
        return com_tencent_mm_protocal_c_afu;
    }
}
