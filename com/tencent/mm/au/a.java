package com.tencent.mm.au;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bht;
import com.tencent.mm.protocal.c.bhu;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private String filemd5;
    public String filename;
    private b gUA;
    public e gUD;
    private String hTJ;
    private int hTK;
    private int hTL;
    public int hTM;
    private int hTN;
    aj hqQ;
    private int sampleRate;

    public a(String str, int i, int i2, int i3, int i4) {
        this.hTJ = null;
        this.filemd5 = null;
        this.filename = null;
        this.sampleRate = 0;
        this.hTK = 0;
        this.hTL = 0;
        this.hTM = 0;
        this.hTN = 5;
        this.hqQ = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a hTO;

            {
                this.hTO = r1;
            }

            public final boolean oQ() {
                w.d("MicroMsg.NetSceneUploadMedia", g.sd() + " onTimerExpired: file:" + this.hTO.filename + " nowlen:" + ((long) com.tencent.mm.a.e.aN(this.hTO.filename)) + " oldoff:" + this.hTO.hTM);
                if (this.hTO.a(this.hTO.hsD, this.hTO.gUD) == -1) {
                    this.hTO.gUD.a(3, -1, "doScene failed", this.hTO);
                }
                return false;
            }
        }, true);
        this.hTJ = bg.Nz();
        this.filename = str;
        this.hTN = i;
        this.sampleRate = i2;
        this.hTK = i3;
        this.hTL = i4;
        this.filemd5 = com.tencent.mm.a.g.n(com.tencent.mm.a.e.c(this.filename, 0, com.tencent.mm.a.e.aN(this.filename)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 3960;
        this.gUD = eVar2;
        int aN = com.tencent.mm.a.e.aN(this.filename);
        w.d("MicroMsg.NetSceneUploadMedia", g.sd() + " read file:" + this.filename + " filelen:" + aN + " oldoff:" + this.hTM + "this.filemd5 " + this.filemd5);
        if (aN <= 0) {
            w.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
            return -1;
        }
        int i2 = aN - this.hTM;
        if (i2 <= 3960) {
            i = i2;
        }
        w.i("MicroMsg.NetSceneUploadMedia", g.sd() + " read file:" + this.filename + " filelen:" + aN + " oldoff:" + this.hTM + "  canReadLen " + i);
        byte[] c = com.tencent.mm.a.e.c(this.filename, this.hTM, i);
        if (c == null) {
            w.e("MicroMsg.NetSceneUploadMedia", "read data error");
            return -1;
        }
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bht();
        aVar.hsn = new bhu();
        aVar.uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
        aVar.hsl = 240;
        aVar.hso = 111;
        aVar.hsp = 1000000111;
        this.gUA = aVar.BE();
        bht com_tencent_mm_protocal_c_bht = (bht) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bht.uhf = new avx().OV(this.hTJ);
        com_tencent_mm_protocal_c_bht.tsk = new avw().bb(c);
        com_tencent_mm_protocal_c_bht.tgL = c.length;
        com_tencent_mm_protocal_c_bht.uhg = new avx().OV(this.filemd5);
        com_tencent_mm_protocal_c_bht.tgJ = aN;
        com_tencent_mm_protocal_c_bht.tgK = this.hTM;
        com_tencent_mm_protocal_c_bht.mvo = this.hTN;
        com_tencent_mm_protocal_c_bht.uhh = 1;
        com_tencent_mm_protocal_c_bht.uhi = this.sampleRate;
        com_tencent_mm_protocal_c_bht.uhj = this.hTK;
        com_tencent_mm_protocal_c_bht.uhk = this.hTL;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 240;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUploadMedia", g.sd() + " onGYNetEnd file:" + this.filename + " errtype:" + i2 + " errCode:" + i3);
        bht com_tencent_mm_protocal_c_bht = (bht) ((b) pVar).hsj.hsr;
        String str2 = ((bhu) ((b) pVar).hsk.hsr).ttW;
        w.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", this.filename, str2, Integer.valueOf(com_tencent_mm_protocal_c_bht.tgJ), Integer.valueOf(com_tencent_mm_protocal_c_bht.tgL), Integer.valueOf(com_tencent_mm_protocal_c_bht.tgK));
        if (i2 != 0 || i3 != 0) {
            w.e("MicroMsg.NetSceneUploadMedia", g.sd() + " onGYNetEnd file:" + this.filename + " errType:" + i2 + " errCode:" + i3);
            this.gUD.a(i2, i3, str, this);
        } else if (com_tencent_mm_protocal_c_bht.tgJ > com_tencent_mm_protocal_c_bht.tgL + com_tencent_mm_protocal_c_bht.tgK || str2 == null || str2.equals("0")) {
            this.hTM = com_tencent_mm_protocal_c_bht.tsk.tZn + com_tencent_mm_protocal_c_bht.tgK;
            w.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
            this.hqQ.v(500, 500);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 60;
    }
}
