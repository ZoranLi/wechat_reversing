package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.ban;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.bau;
import com.tencent.mm.protocal.c.bav;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.protocal.c.bbk;
import com.tencent.mm.protocal.c.bby;
import com.tencent.mm.protocal.c.bdj;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends k implements com.tencent.mm.network.j {
    private b gUA;
    public e gUD;
    private String pTJ;
    private bav pTK;
    private int type;

    public j(bav com_tencent_mm_protocal_c_bav, String str, String str2) {
        bdj kS;
        a aVar = new a();
        aVar.hsm = new ban();
        aVar.hsn = new bao();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadcomment";
        aVar.hsl = 682;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ban com_tencent_mm_protocal_c_ban = (ban) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ban.ubA = com_tencent_mm_protocal_c_bav;
        this.type = com_tencent_mm_protocal_c_bav.ubR.jOc;
        this.pTK = com_tencent_mm_protocal_c_bav;
        com_tencent_mm_protocal_c_ban.teW = str;
        this.pTJ = str;
        com.tencent.mm.plugin.sns.storage.e dz = ae.beN().dz(com_tencent_mm_protocal_c_bav.tmx);
        if (dz != null) {
            bfc bhd = dz.bhd();
            if (bhd != null) {
                kS = o.kS(bhd.qui);
            } else {
                w.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
                kS = null;
            }
        } else {
            w.v("SnsAdExtUtil", "parseStatSnsAdInfo snsInfo null, snsId %d", new Object[]{Long.valueOf(r2)});
            kS = null;
        }
        if (kS != null) {
            com_tencent_mm_protocal_c_ban.ubB = n.mw(o.a(kS));
            com_tencent_mm_protocal_c_ban.tfW = kS.cGa;
        }
        com_tencent_mm_protocal_c_ban.ubz = n.mw(bg.ap(str2, ""));
        w.i("MicroMsg.NetSceneSnsAdComment", com_tencent_mm_protocal_c_bav.ubR.tWt + " " + com_tencent_mm_protocal_c_bav.ubR.tvK + " type " + com_tencent_mm_protocal_c_bav.ubR.jOc + " aduxinfo " + str2 + ", SnsStat=" + com_tencent_mm_protocal_c_ban.ubB + ", source=" + com_tencent_mm_protocal_c_ban.tfW);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 682;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSnsAdComment", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ae.beK().c(this.pTK.tmx, this.type, this.pTJ);
            bau com_tencent_mm_protocal_c_bau = this.pTK.ubR;
            if (com_tencent_mm_protocal_c_bau.jOc == 1 || com_tencent_mm_protocal_c_bau.jOc == 2 || com_tencent_mm_protocal_c_bau.jOc == 3 || com_tencent_mm_protocal_c_bau.jOc == 5 || com_tencent_mm_protocal_c_bau.jOc == 7 || com_tencent_mm_protocal_c_bau.jOc == 8) {
                bba com_tencent_mm_protocal_c_bba = new bba();
                com_tencent_mm_protocal_c_bba.ogM = com_tencent_mm_protocal_c_bau.ogM;
                com_tencent_mm_protocal_c_bba.jOc = com_tencent_mm_protocal_c_bau.jOc;
                com_tencent_mm_protocal_c_bba.tfW = com_tencent_mm_protocal_c_bau.tfW;
                com_tencent_mm_protocal_c_bba.tgG = com_tencent_mm_protocal_c_bau.tWt;
                com_tencent_mm_protocal_c_bba.tNz = com_tencent_mm_protocal_c_bau.ubH;
                com_tencent_mm_protocal_c_bba.opI = com_tencent_mm_protocal_c_bau.opI;
                com_tencent_mm_protocal_c_bba.ubP = com_tencent_mm_protocal_c_bau.ubP;
                try {
                    bbk com_tencent_mm_protocal_c_bbk;
                    bao com_tencent_mm_protocal_c_bao = (bao) this.gUA.hsk.hsr;
                    if (((ban) this.gUA.hsj.hsr).tfW == 1) {
                        bby com_tencent_mm_protocal_c_bby = com_tencent_mm_protocal_c_bao.tXT;
                        com_tencent_mm_protocal_c_bbk = com_tencent_mm_protocal_c_bby.ubC;
                        a.a(com_tencent_mm_protocal_c_bby);
                    } else {
                        baq com_tencent_mm_protocal_c_baq = com_tencent_mm_protocal_c_bao.tfu;
                        com_tencent_mm_protocal_c_bbk = com_tencent_mm_protocal_c_baq.ubC;
                        a.b(com_tencent_mm_protocal_c_baq);
                    }
                    w.d("MicroMsg.NetSceneSnsAdComment", "snsComment:" + com_tencent_mm_protocal_c_bbk.toString() + " " + com_tencent_mm_protocal_c_bbk.ucn.size() + " " + com_tencent_mm_protocal_c_bbk.ucq.size());
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneSnsAdComment", e, "", new Object[0]);
                }
            }
            ae.beK().bem();
        } else if (i2 == 4) {
            ae.beK().c(this.pTK.tmx, this.type, this.pTJ);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
