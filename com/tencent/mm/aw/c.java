package com.tencent.mm.aw;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bjm;
import com.tencent.mm.protocal.c.bjn;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import java.util.Set;

public final class c extends a implements j {
    public int fEX;
    public String filename;
    private b gUA;
    public e gUD;
    public int hTM;
    aj hqQ;
    public boolean ibh;
    private long icL;
    private boolean icM;
    private int icN;
    private String[] icO;

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

    public c(String str, int i) {
        this.fEX = 0;
        this.hTM = 0;
        this.filename = null;
        this.icL = -1;
        this.icM = false;
        this.ibh = false;
        this.icO = new String[0];
        this.hqQ = new aj(new a(this) {
            final /* synthetic */ c icP;

            {
                this.icP = r1;
            }

            public final boolean oQ() {
                long aN = (long) com.tencent.mm.a.e.aN(this.icP.filename);
                w.d("MicroMsg.NetSceneVoiceAddr", g.sd() + " onTimerExpired: file:" + this.icP.filename + " nowlen:" + aN + " oldoff:" + this.icP.hTM + " isFin:" + this.icP.ibh);
                if (aN - ((long) this.icP.hTM) < 3300 && !this.icP.ibh) {
                    return true;
                }
                if (this.icP.a(this.icP.hsD, this.icP.gUD) == -1) {
                    this.icP.fEX = g.sb() + 40000;
                    this.icP.gUD.a(3, -1, "doScene failed", this.icP);
                }
                return false;
            }
        }, true);
        this.icL = bg.Nz();
        this.filename = str;
        this.icN = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.gUD = eVar2;
        int aN = com.tencent.mm.a.e.aN(this.filename);
        w.d("MicroMsg.NetSceneVoiceAddr", g.sd() + " read file:" + this.filename + " filelen:" + aN + " oldoff:" + this.hTM + " isFin:" + this.ibh);
        if (aN <= 0) {
            w.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
            this.fEX = g.sb() + 40000;
            return -1;
        }
        int i2 = aN - this.hTM;
        if (i2 <= 3960) {
            if (i2 >= 3300 || this.ibh) {
                if (this.ibh) {
                    this.icM = true;
                }
                i = i2;
            } else {
                w.e("MicroMsg.NetSceneVoiceAddr", g.sd() + " read failed :" + this.filename + "can read:" + i2 + " isfinish:" + this.ibh);
                this.fEX = g.sb() + 40000;
                return -1;
            }
        }
        w.d("MicroMsg.NetSceneVoiceAddr", g.sd() + " read file:" + this.filename + " filelen:" + aN + " oldoff:" + this.hTM + " isFin:" + this.ibh + " endFlag:" + this.icM);
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.hTM, i);
        if (c == null) {
            w.e("MicroMsg.NetSceneVoiceAddr", g.sd() + " read failed :" + this.filename + " read:" + i);
            this.fEX = g.sb() + 40000;
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hsm = new bjm();
        aVar.hsn = new bjn();
        aVar.uri = "/cgi-bin/micromsg-bin/voiceaddr";
        aVar.hsl = v.CTRL_INDEX;
        aVar.hso = 94;
        aVar.hsp = 1000000094;
        this.gUA = aVar.BE();
        bjm com_tencent_mm_protocal_c_bjm = (bjm) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bjm.tsk = new avw().bb(c);
        w.d("MicroMsg.NetSceneVoiceAddr", g.sd() + " read file:" + this.filename + " readlen:" + c.length + " datalen:" + com_tencent_mm_protocal_c_bjm.tsk.tZp.toByteArray().length + " dataiLen:" + com_tencent_mm_protocal_c_bjm.tsk.tZn + " md5:" + com.tencent.mm.a.g.n(c) + " datamd5:" + com.tencent.mm.a.g.n(com_tencent_mm_protocal_c_bjm.tsk.tZp.toByteArray()));
        com_tencent_mm_protocal_c_bjm.jNj = (String) h.vI().vr().get(2, (Object) "");
        com_tencent_mm_protocal_c_bjm.tll = this.hTM;
        com_tencent_mm_protocal_c_bjm.ugY = this.icL;
        com_tencent_mm_protocal_c_bjm.tiL = this.icM ? 1 : 0;
        com_tencent_mm_protocal_c_bjm.ugZ = 0;
        com_tencent_mm_protocal_c_bjm.tgP = 0;
        com_tencent_mm_protocal_c_bjm.uha = 0;
        com_tencent_mm_protocal_c_bjm.tgM = 0;
        com_tencent_mm_protocal_c_bjm.uiW = this.icN;
        w.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.icL);
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
        w.d("MicroMsg.NetSceneVoiceAddr", g.sd() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bjm com_tencent_mm_protocal_c_bjm = (bjm) ((b) pVar).hsj.hsr;
        bjn com_tencent_mm_protocal_c_bjn = (bjn) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneVoiceAddr", g.sd() + " onGYNetEnd  file:" + this.filename + " endflag:" + com_tencent_mm_protocal_c_bjn.tiL + " lst:" + com_tencent_mm_protocal_c_bjn.tiO);
            if (com_tencent_mm_protocal_c_bjm.tiL == 1) {
                this.icO = new String[com_tencent_mm_protocal_c_bjn.tiO.size()];
                for (int i4 = 0; i4 < com_tencent_mm_protocal_c_bjn.tiO.size(); i4++) {
                    this.icO[i4] = ((avx) com_tencent_mm_protocal_c_bjn.tiO.get(i4)).tZr;
                }
                this.gUD.a(i2, i3, str, this);
                return;
            }
            this.hTM = com_tencent_mm_protocal_c_bjm.tsk.tZn + com_tencent_mm_protocal_c_bjm.tll;
            long j = this.ibh ? 0 : 500;
            w.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + j);
            this.hqQ.v(j, j);
            return;
        }
        w.e("MicroMsg.NetSceneVoiceAddr", g.sd() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return v.CTRL_INDEX;
    }
}
