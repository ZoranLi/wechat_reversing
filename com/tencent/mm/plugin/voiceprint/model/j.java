package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.protocal.c.bji;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends k implements com.tencent.mm.network.j {
    private String filename;
    private final b gUA;
    private e gUD;
    public boolean rcn = false;
    private boolean rco = false;
    private Handler rcp = null;
    private int rcq = 0;
    int rct = 0;
    private String rcw = "";
    private int wa = 0;

    public j(String str, int i) {
        w.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[]{Integer.valueOf(i)});
        a aVar = new a();
        aVar.hsm = new bjh();
        aVar.hsn = new bji();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
        aVar.hsl = 613;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bjh com_tencent_mm_protocal_c_bjh = (bjh) this.gUA.hsj.hsr;
        this.filename = str;
        this.wa = 0;
        com_tencent_mm_protocal_c_bjh.tYm = i;
        this.rcq = 0;
        com_tencent_mm_protocal_c_bjh.tYk = 0;
        w.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        this.rcn = true;
        boy();
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 240;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    private int boy() {
        bjh com_tencent_mm_protocal_c_bjh = (bjh) this.gUA.hsj.hsr;
        bjp com_tencent_mm_protocal_c_bjp = new bjp();
        g gVar = new g();
        com_tencent_mm_protocal_c_bjh.uiU = com_tencent_mm_protocal_c_bjp;
        l lVar = new l(m.at(this.filename, false));
        int aN = com.tencent.mm.a.e.aN(m.at(this.filename, false));
        if (aN - this.wa >= 6000) {
            gVar = lVar.bd(this.wa, 6000);
        } else {
            gVar = lVar.bd(this.wa, aN - this.wa);
        }
        w.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.wa), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.fAK), Integer.valueOf(aN), Boolean.valueOf(this.rcn)});
        if (gVar.fAK == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            w.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.wa >= 469000) {
            w.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.wa)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bjp.ujd = new avw().bb(gVar.buf);
            com_tencent_mm_protocal_c_bjp.tgK = this.wa;
            com_tencent_mm_protocal_c_bjp.ujb = gVar.fAK;
            com_tencent_mm_protocal_c_bjp.ujc = 0;
            com_tencent_mm_protocal_c_bjh.tYk = this.rcq;
            if (this.rcn && gVar.iaP >= com.tencent.mm.a.e.aN(m.at(this.filename, false))) {
                com_tencent_mm_protocal_c_bjp.ujc = 1;
                this.rco = true;
                w.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(aN)});
            }
            this.wa = gVar.iaP;
            com_tencent_mm_protocal_c_bjh.uiU = com_tencent_mm_protocal_c_bjp;
            return 0;
        }
    }

    public final int getType() {
        return 613;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        bji com_tencent_mm_protocal_c_bji = (bji) ((b) pVar).hsk.hsr;
        if (i2 == 0 || i3 == 0) {
            this.rcq = com_tencent_mm_protocal_c_bji.tYk;
            this.rct = com_tencent_mm_protocal_c_bji.tqS;
            w.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bji.tYk), Integer.valueOf(this.rct)});
            if (this.rco) {
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(boy())});
            a(this.hsD, this.gUD);
            w.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
