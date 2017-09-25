package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.c;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bbs;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Locale;

public final class n extends k implements j {
    private b gUA;
    public e gUD;
    private String pTJ;
    private bav pTK;
    private int type;

    public n(bav com_tencent_mm_protocal_c_bav, String str) {
        a aVar = new a();
        aVar.hsm = new bbb();
        aVar.hsn = new bbc();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnscomment";
        aVar.hsl = c.CTRL_INDEX;
        aVar.hso = 100;
        aVar.hsp = 1000000100;
        this.gUA = aVar.BE();
        bbb com_tencent_mm_protocal_c_bbb = (bbb) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bbb.ubA = com_tencent_mm_protocal_c_bav;
        this.type = com_tencent_mm_protocal_c_bav.ubR.jOc;
        this.pTK = com_tencent_mm_protocal_c_bav;
        com_tencent_mm_protocal_c_bbb.teW = str;
        this.pTJ = str;
        w.d("MicroMsg.NetSceneSnsComment", com_tencent_mm_protocal_c_bav.ubR.tWt + " " + com_tencent_mm_protocal_c_bav.ubR.tvK);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        m dG = ae.beL().dG(this.pTK.tmx);
        if (dG == null) {
            com.tencent.mm.plugin.sns.storage.e dz = ae.beN().dz(this.pTK.tmx);
            if (dz != null) {
                dG = dz.bhf();
            }
        }
        if (dG != null) {
            try {
                bbk com_tencent_mm_protocal_c_bbk = (bbk) new bbk().aD(dG.field_attrBuf);
                if (com_tencent_mm_protocal_c_bbk.ucA != null && com_tencent_mm_protocal_c_bbk.ucA.tZq) {
                    bbs com_tencent_mm_protocal_c_bbs = (bbs) new bbs().aD(com_tencent_mm_protocal_c_bbk.ucA.tZp.sYA);
                    bbb com_tencent_mm_protocal_c_bbb = (bbb) this.gUA.hsj.hsr;
                    if (com_tencent_mm_protocal_c_bbs.ucP != null) {
                        w.i("MicroMsg.NetSceneSnsComment", "doScene(sight_autodownload) snsStatExt:%s", new Object[]{String.format(Locale.US, "preloadLayerId=%d&preloadExpId=%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bbs.ucP.ttz), Integer.valueOf(com_tencent_mm_protocal_c_bbs.ucP.ttA)})});
                        com_tencent_mm_protocal_c_bbb.ubB = new avx().OV(r0);
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
            }
        }
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSnsComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ae.beK().c(this.pTK.tmx, this.type, this.pTJ);
            bau com_tencent_mm_protocal_c_bau = this.pTK.ubR;
            if (com_tencent_mm_protocal_c_bau.jOc == 1 || com_tencent_mm_protocal_c_bau.jOc == 2 || com_tencent_mm_protocal_c_bau.jOc == 3 || com_tencent_mm_protocal_c_bau.jOc == 5) {
                bba com_tencent_mm_protocal_c_bba = new bba();
                com_tencent_mm_protocal_c_bba.ogM = com_tencent_mm_protocal_c_bau.ogM;
                com_tencent_mm_protocal_c_bba.jOc = com_tencent_mm_protocal_c_bau.jOc;
                com_tencent_mm_protocal_c_bba.tfW = com_tencent_mm_protocal_c_bau.tfW;
                com_tencent_mm_protocal_c_bba.tgG = com_tencent_mm_protocal_c_bau.tWt;
                com_tencent_mm_protocal_c_bba.tNz = com_tencent_mm_protocal_c_bau.ubH;
                com_tencent_mm_protocal_c_bba.opI = com_tencent_mm_protocal_c_bau.opI;
                com_tencent_mm_protocal_c_bba.ubP = com_tencent_mm_protocal_c_bau.ubP;
                try {
                    bbk com_tencent_mm_protocal_c_bbk = ((bbc) this.gUA.hsk.hsr).ubC;
                    if (com_tencent_mm_protocal_c_bau.jOc == 1 || com_tencent_mm_protocal_c_bau.jOc == 5) {
                        w.i("MicroMsg.NetSceneSnsComment", "snsComment:" + com_tencent_mm_protocal_c_bbk.tmx + " " + com.tencent.mm.platformtools.n.b(com_tencent_mm_protocal_c_bbk.ucj) + " " + com_tencent_mm_protocal_c_bbk.ucn.size() + " " + com_tencent_mm_protocal_c_bbk.ucq.size());
                    } else {
                        w.i("MicroMsg.NetSceneSnsComment", "snsComment:" + com_tencent_mm_protocal_c_bbk.tmx + " " + com_tencent_mm_protocal_c_bbk.ucn.size() + " " + com_tencent_mm_protocal_c_bbk.ucq.size());
                    }
                    ai.d(com_tencent_mm_protocal_c_bbk);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneSnsComment", e, "", new Object[0]);
                }
            }
            ae.beK().bem();
        } else if (i2 == 4) {
            ae.beK().c(this.pTK.tmx, this.type, this.pTJ);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
