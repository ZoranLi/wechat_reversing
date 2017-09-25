package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.modelvoice.g;
import com.tencent.mm.modelvoice.l;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.av;
import com.tencent.mm.u.av.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class h extends k implements j {
    private String filename;
    public e gUD;
    private final p htt;
    public boolean rcn = false;
    private boolean rco = false;
    private Handler rcp = null;
    private int rcq = 0;
    int rct = 0;
    String rcw = "";
    private int wa = 0;

    public h(String str, int i, String str2) {
        w.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "resid %d vertifyTicket %s", new Object[]{Integer.valueOf(i), bg.ap(str2, "")});
        this.htt = new c();
        a aVar = (a) this.htt.BG();
        this.filename = str;
        this.wa = 0;
        aVar.hmx.tYm = i;
        aVar.hmx.tIq = str2;
        this.rcq = 0;
        aVar.hmx.tYk = 0;
        w.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "voiceRegist %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        this.rcn = true;
        boy();
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 240;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    private int boy() {
        a aVar = (a) this.htt.BG();
        bjp com_tencent_mm_protocal_c_bjp = new bjp();
        g gVar = new g();
        aVar.hmx.uiU = com_tencent_mm_protocal_c_bjp;
        l lVar = new l(m.at(this.filename, false));
        int aN = com.tencent.mm.a.e.aN(m.at(this.filename, false));
        if (aN - this.wa >= 6000) {
            gVar = lVar.bd(this.wa, 6000);
        } else {
            gVar = lVar.bd(this.wa, aN - this.wa);
        }
        w.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[]{Integer.valueOf(this.wa), Integer.valueOf(gVar.ret), Integer.valueOf(gVar.fAK), Integer.valueOf(aN), Boolean.valueOf(this.rcn)});
        if (gVar.fAK == 0) {
            return -2;
        }
        if (gVar.ret < 0) {
            w.w("MicroMsg.NetSceneRsaVertifyVoicePrint", "readerror %d", new Object[]{Integer.valueOf(gVar.ret)});
            return -1;
        } else if (this.wa >= 469000) {
            w.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "moffset > maxfile %d", new Object[]{Integer.valueOf(this.wa)});
            return -1;
        } else {
            com_tencent_mm_protocal_c_bjp.ujd = new avw().bb(gVar.buf);
            com_tencent_mm_protocal_c_bjp.tgK = this.wa;
            com_tencent_mm_protocal_c_bjp.ujb = gVar.fAK;
            com_tencent_mm_protocal_c_bjp.ujc = 0;
            aVar.hmx.tYk = this.rcq;
            if (this.rcn && gVar.iaP >= com.tencent.mm.a.e.aN(m.at(this.filename, false))) {
                com_tencent_mm_protocal_c_bjp.ujc = 1;
                this.rco = true;
                w.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "the last one pack for uploading totallen %d", new Object[]{Integer.valueOf(aN)});
            }
            this.wa = gVar.iaP;
            aVar.hmx.uiU = com_tencent_mm_protocal_c_bjp;
            return 0;
        }
    }

    public final int getType() {
        return 617;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        av.b bVar = (av.b) pVar.zg();
        if (i2 == 4 && i3 == -102) {
            final int i4 = pVar.BG().sZA.ver;
            w.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(i4)});
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ h rcx;

                public final void run() {
                    new m().a(this.rcx.hsD, new e(this) {
                        final /* synthetic */ AnonymousClass1 rcy;

                        {
                            this.rcy = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            w.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
                            if (i == 0 && i2 == 0) {
                                this.rcy.rcx.a(this.rcy.rcx.hsD, this.rcy.rcx.gUD);
                            } else {
                                this.rcy.rcx.gUD.a(i, i2, "", this.rcy.rcx);
                            }
                        }
                    });
                }
            });
        } else if (i2 == 0 || i3 == 0) {
            this.rcq = bVar.hmy.tYk;
            this.rct = bVar.hmy.tqS;
            this.rcw = bVar.hmy.uiV;
            String str2 = "MicroMsg.NetSceneRsaVertifyVoicePrint";
            String str3 = "voice VoiceTicket %d mResult %d mAuthPwd is null: %b, mAuthPwd.len: %d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bVar.hmy.tYk);
            objArr[1] = Integer.valueOf(this.rct);
            objArr[2] = Boolean.valueOf(bg.mA(this.rcw));
            objArr[3] = Integer.valueOf(bg.mA(this.rcw) ? 0 : this.rcw.length());
            w.i(str2, str3, objArr);
            if (this.rco) {
                this.gUD.a(i2, i3, str, this);
                return;
            }
            w.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "tryDoScene ret %d", new Object[]{Integer.valueOf(boy())});
            a(this.hsD, this.gUD);
            w.i("MicroMsg.NetSceneRsaVertifyVoicePrint", "loop doscene");
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
