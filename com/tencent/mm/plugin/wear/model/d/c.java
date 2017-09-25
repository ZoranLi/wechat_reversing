package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bhq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.UUID;

public final class c extends k implements j {
    private String clientId;
    public String fJL;
    public String filename = null;
    private b gUA;
    public e gUD;
    aj hqQ = new aj(new a(this) {
        final /* synthetic */ c rUo;

        {
            this.rUo = r1;
        }

        public final boolean oQ() {
            long aN = ((long) com.tencent.mm.a.e.aN(this.rUo.filename)) - ((long) this.rUo.rUl);
            w.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[]{this.rUo.filename, Long.valueOf((long) com.tencent.mm.a.e.aN(this.rUo.filename)), Integer.valueOf(this.rUo.rUl), Boolean.valueOf(this.rUo.ibh), Long.valueOf(aN)});
            if (aN < 3300 && !this.rUo.ibh) {
                return true;
            }
            if (this.rUo.ibh && aN <= 0) {
                return false;
            }
            if (this.rUo.a(this.rUo.hsD, this.rUo.gUD) == -1) {
                this.rUo.gUD.a(3, -1, "doScene failed", this.rUo);
            }
            return false;
        }
    }, true);
    public boolean ibh = false;
    private boolean icM = false;
    private int icQ = 0;
    public int oWj;
    public int rUl = 0;
    public String rUm;
    public boolean rUn;

    public c(String str, String str2, int i) {
        this.oWj = i;
        this.fJL = str2;
        this.filename = str;
        this.icQ = 0;
        this.clientId = UUID.randomUUID().toString();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        int aN = com.tencent.mm.a.e.aN(this.filename);
        if (aN <= 0) {
            w.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[]{this.filename});
            return -1;
        }
        int i = aN - this.rUl;
        if (i > 3960) {
            i = 3960;
        } else if (i < 3300 && !this.ibh) {
            w.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.ibh)});
            return -1;
        } else if (this.ibh) {
            this.icM = true;
        }
        w.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[]{Integer.valueOf(aN), Integer.valueOf(this.rUl), Boolean.valueOf(this.ibh), Boolean.valueOf(this.icM), this.filename});
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.rUl, i);
        if (c != null) {
            b.a aVar = new b.a();
            aVar.hsm = new bhp();
            aVar.hsn = new bhq();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
            aVar.hsl = 349;
            aVar.hso = 158;
            aVar.hsp = 1000000158;
            this.gUA = aVar.BE();
            bhp com_tencent_mm_protocal_c_bhp = (bhp) this.gUA.hsj.hsr;
            ap.yY();
            com_tencent_mm_protocal_c_bhp.jNj = (String) com.tencent.mm.u.c.vr().get(2, "");
            com_tencent_mm_protocal_c_bhp.tsk = new avw().bb(c);
            com_tencent_mm_protocal_c_bhp.tll = this.rUl;
            com_tencent_mm_protocal_c_bhp.ugY = this.clientId;
            com_tencent_mm_protocal_c_bhp.tiL = this.icM ? 1 : 0;
            com_tencent_mm_protocal_c_bhp.ugZ = 0;
            com_tencent_mm_protocal_c_bhp.tgP = 0;
            com_tencent_mm_protocal_c_bhp.uha = this.icQ;
            com_tencent_mm_protocal_c_bhp.tgM = 0;
            aN = a(eVar, this.gUA, this);
            this.rUl = com_tencent_mm_protocal_c_bhp.tsk.tZn + com_tencent_mm_protocal_c_bhp.tll;
            long j = this.ibh ? 0 : 500;
            w.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[]{this.filename, Long.valueOf(j), Integer.valueOf(aN)});
            this.hqQ.v(j, j);
            return aN;
        } else if (this.icM) {
            return 0;
        } else {
            w.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(this.ibh), Boolean.valueOf(this.icM)});
            return -1;
        }
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 20;
    }

    protected final void a(k.a aVar) {
        this.gUD.a(3, 0, "securityCheckError", this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), this.filename});
        bhq com_tencent_mm_protocal_c_bhq = (bhq) ((b) pVar).hsk.hsr;
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bhq.tiL), d(com_tencent_mm_protocal_c_bhq.uhb)});
            if (com_tencent_mm_protocal_c_bhq.tiL == 1) {
                this.rUn = true;
                String d = d(com_tencent_mm_protocal_c_bhq.uhb);
                if (d != null) {
                    this.rUm = d;
                }
                this.gUD.a(i2, i3, str, this);
                return;
            }
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    private static String d(avw com_tencent_mm_protocal_c_avw) {
        if (com_tencent_mm_protocal_c_avw == null || com_tencent_mm_protocal_c_avw.tZp == null) {
            return null;
        }
        return com_tencent_mm_protocal_c_avw.tZp.bGX();
    }

    public final int getType() {
        return 349;
    }
}
