package com.tencent.mm.aw;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bhq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import java.util.Set;

public final class d extends a implements j {
    public int fEX;
    public String filename;
    private b gUA;
    public e gUD;
    public int hTM;
    aj hqQ;
    public boolean ibh;
    private long icL;
    private boolean icM;
    private String[] icO;
    private int icQ;

    public final void LG() {
        this.ibh = true;
    }

    public final String[] LH() {
        return this.icO;
    }

    public final long LI() {
        return this.icL;
    }

    public final Set<String> LJ() {
        return null;
    }

    public d(String str, int i) {
        this.fEX = 0;
        this.ibh = false;
        this.hTM = 0;
        this.filename = null;
        this.icL = -1;
        this.icM = false;
        this.icQ = 0;
        this.icO = new String[0];
        this.hqQ = new aj(new a(this) {
            final /* synthetic */ d icR;

            {
                this.icR = r1;
            }

            public final boolean oQ() {
                long aN = (long) com.tencent.mm.a.e.aN(this.icR.filename);
                w.d("MicroMsg.NetSceneVoiceInput", g.sd() + " onTimerExpired: file:" + this.icR.filename + " nowlen:" + aN + " oldoff:" + this.icR.hTM + " isFin:" + this.icR.ibh);
                if (aN - ((long) this.icR.hTM) < 3300 && !this.icR.ibh) {
                    return true;
                }
                if (this.icR.a(this.icR.hsD, this.icR.gUD) == -1) {
                    this.icR.fEX = g.sb() + 40000;
                    this.icR.gUD.a(3, -1, "doScene failed", this.icR);
                }
                return false;
            }
        }, true);
        this.icL = (long) (bg.Nz()).hashCode();
        this.filename = str;
        this.icQ = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        int aN = com.tencent.mm.a.e.aN(this.filename);
        w.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", this.filename, Integer.valueOf(aN), Integer.valueOf(this.hTM), Boolean.valueOf(this.ibh));
        if (aN <= 0) {
            w.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
            this.fEX = g.sb() + 40000;
            return -1;
        }
        int i = aN - this.hTM;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.ibh) {
            w.e("MicroMsg.NetSceneVoiceInput", g.sd() + " read failed :" + this.filename + "can read:" + i + " isfinish:" + this.ibh);
            this.fEX = g.sb() + 40000;
            return -1;
        } else if (this.ibh) {
            this.icM = true;
        }
        w.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", this.filename, Integer.valueOf(aN), Boolean.valueOf(this.ibh), Boolean.valueOf(this.ibh), Boolean.valueOf(this.icM));
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.hTM, i);
        if (c == null) {
            w.e("MicroMsg.NetSceneVoiceInput", g.sd() + " read failed :" + this.filename + " read:" + i);
            this.fEX = g.sb() + 40000;
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hsm = new bhp();
        aVar.hsn = new bhq();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
        aVar.hsl = 349;
        aVar.hso = 158;
        aVar.hsp = 1000000158;
        this.gUA = aVar.BE();
        bhp com_tencent_mm_protocal_c_bhp = (bhp) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bhp.jNj = (String) h.vI().vr().get(2, (Object) "");
        com_tencent_mm_protocal_c_bhp.tsk = new avw().bb(c);
        w.d("MicroMsg.NetSceneVoiceInput", g.sd() + " read file:" + this.filename + " readlen:" + c.length + " datalen:" + com_tencent_mm_protocal_c_bhp.tsk.tZp.toByteArray().length + " dataiLen:" + com_tencent_mm_protocal_c_bhp.tsk.tZn + " md5:" + com.tencent.mm.a.g.n(c) + " datamd5:" + com.tencent.mm.a.g.n(com_tencent_mm_protocal_c_bhp.tsk.tZp.toByteArray()));
        com_tencent_mm_protocal_c_bhp.tll = this.hTM;
        com_tencent_mm_protocal_c_bhp.ugY = this.icL;
        com_tencent_mm_protocal_c_bhp.tiL = this.icM ? 1 : 0;
        com_tencent_mm_protocal_c_bhp.ugZ = 0;
        com_tencent_mm_protocal_c_bhp.tgP = 0;
        com_tencent_mm_protocal_c_bhp.uha = this.icQ;
        com_tencent_mm_protocal_c_bhp.tgM = 0;
        w.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.icL);
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 20;
    }

    protected final void a(a aVar) {
        this.gUD.a(3, g.sb() + 40000, "ecurityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bhp com_tencent_mm_protocal_c_bhp = (bhp) ((b) pVar).hsj.hsr;
        bhq com_tencent_mm_protocal_c_bhq = (bhq) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneVoiceInput", g.sd() + " onGYNetEnd  file:" + this.filename + " endflag:" + com_tencent_mm_protocal_c_bhq.tiL);
            if (com_tencent_mm_protocal_c_bhp.tiL == 1) {
                if (!(com_tencent_mm_protocal_c_bhq.uhb == null || com_tencent_mm_protocal_c_bhq.uhb.tZp == null)) {
                    this.icO = new String[]{com_tencent_mm_protocal_c_bhq.uhb.tZp.bGX()};
                }
                this.gUD.a(i2, i3, str, this);
                return;
            }
            this.hTM = com_tencent_mm_protocal_c_bhp.tsk.tZn + com_tencent_mm_protocal_c_bhp.tll;
            long j = this.ibh ? 0 : 500;
            w.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.hqQ.v(j, j);
            return;
        }
        w.e("MicroMsg.NetSceneVoiceInput", g.sd() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 349;
    }
}
