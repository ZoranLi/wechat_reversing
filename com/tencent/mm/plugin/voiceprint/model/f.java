package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    private String filename;
    private final b gUA;
    private e gUD;
    public boolean rcn = false;
    private boolean rco = false;
    private Handler rcp = null;
    int rcq = 0;
    private int rcr = 0;
    int rcs = 0;
    int rct = 0;
    private int wa = 0;

    public f(String str, int i, int i2, int i3) {
        w.d("MicroMsg.NetSceneRegisterVoicePrint", "step %d resid %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.rcs = i;
        a aVar = new a();
        aVar.hsm = new auq();
        aVar.hsn = new aur();
        aVar.uri = "/cgi-bin/micromsg-bin/registervoiceprint";
        aVar.hsl = 612;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        auq com_tencent_mm_protocal_c_auq = (auq) this.gUA.hsj.hsr;
        this.filename = str;
        this.wa = 0;
        com_tencent_mm_protocal_c_auq.tYm = i2;
        com_tencent_mm_protocal_c_auq.jOa = i;
        this.rcq = i3;
        com_tencent_mm_protocal_c_auq.tYk = i3;
        w.i("MicroMsg.NetSceneRegisterVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
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
        auq com_tencent_mm_protocal_c_auq = (auq) this.gUA.hsj.hsr;
        bjp com_tencent_mm_protocal_c_bjp = new bjp();
        g gVar = new g();
        com_tencent_mm_protocal_c_auq.tYl = com_tencent_mm_protocal_c_bjp;
        l lVar = new l(m.at(this.filename, false));
        int aN = com.tencent.mm.a.e.aN(m.at(this.filename, false));
        if (aN - this.wa >= 6000) {
            gVar = lVar.bd(this.wa, 6000);
        } else {
            gVar = lVar.bd(this.wa, aN - this.wa);
        }
        w.d("MicroMsg.NetSceneRegisterVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.wa), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.fAK), Integer.valueOf(aN), Boolean.valueOf(this.rcn)});
        if (gVar.fAK == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            w.w("MicroMsg.NetSceneRegisterVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.wa >= 469000) {
            w.i("MicroMsg.NetSceneRegisterVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.wa)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bjp.ujd = new avw().bb(gVar.buf);
            com_tencent_mm_protocal_c_bjp.tgK = this.wa;
            com_tencent_mm_protocal_c_bjp.ujb = gVar.fAK;
            com_tencent_mm_protocal_c_bjp.ujc = 0;
            com_tencent_mm_protocal_c_auq.tYk = this.rcq;
            if (this.rcn && gVar.iaP >= com.tencent.mm.a.e.aN(m.at(this.filename, false))) {
                com_tencent_mm_protocal_c_bjp.ujc = 1;
                this.rco = true;
                w.i("MicroMsg.NetSceneRegisterVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(aN)});
            }
            this.wa = gVar.iaP;
            com_tencent_mm_protocal_c_auq.tYl = com_tencent_mm_protocal_c_bjp;
            return 0;
        }
    }

    public final int getType() {
        return 612;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRegisterVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aur com_tencent_mm_protocal_c_aur = (aur) ((b) pVar).hsk.hsr;
        if (i2 == 0 || i3 == 0) {
            w.i("MicroMsg.NetSceneRegisterVoicePrint", "voice ticket %d ret %d nextstep %d %d ", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aur.tYk), Integer.valueOf(com_tencent_mm_protocal_c_aur.tYn), Integer.valueOf(com_tencent_mm_protocal_c_aur.tYo), Integer.valueOf(com_tencent_mm_protocal_c_aur.tYn)});
            this.rcq = com_tencent_mm_protocal_c_aur.tYk;
            this.rcr = com_tencent_mm_protocal_c_aur.tYo;
            this.rct = com_tencent_mm_protocal_c_aur.tYn;
            if (this.rco) {
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.i("MicroMsg.NetSceneRegisterVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(boy())});
            a(this.hsD, this.gUD);
            w.i("MicroMsg.NetSceneRegisterVoicePrint", "loop doscene");
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
