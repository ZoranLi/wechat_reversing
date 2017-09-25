package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.protocal.c.bbe;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.OutputStream;

public final class o extends k implements j {
    private String filename;
    private b gUA;
    public e gUD;
    private OutputStream hrI = null;
    String mediaId = "";
    private String pTT;
    private int pTU = -1;
    int pTV = -1;
    private boolean pTW = true;
    private String pTX = null;
    private alh pTY;

    public o(alh com_tencent_mm_protocal_c_alh, String str, String str2, int i, boolean z, int i2, String str3) {
        this.mediaId = str;
        this.pTY = com_tencent_mm_protocal_c_alh;
        this.pTW = z;
        this.pTU = i;
        this.pTV = i2;
        this.pTX = str3;
        this.pTT = am.du(ae.getAccSnsPath(), str);
        a aVar = new a();
        aVar.hsm = new bbd();
        aVar.hsn = new bbe();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsdownload";
        aVar.hsl = bv.CTRL_INDEX;
        aVar.hso = 96;
        aVar.hsp = 1000000096;
        this.gUA = aVar.BE();
        bbd com_tencent_mm_protocal_c_bbd = (bbd) this.gUA.hsj.hsr;
        q Gv = ae.beA().Gv(str);
        if (Gv == null) {
            Gv = new q();
        }
        Gv.qnS = str;
        Gv.offset = 0;
        ae.beA().a(str, Gv);
        if (z) {
            this.filename = i.n(com_tencent_mm_protocal_c_alh);
        } else {
            this.filename = i.m(com_tencent_mm_protocal_c_alh);
        }
        FileOp.kl(this.pTT);
        FileOp.deleteFile(am.du(ae.getAccSnsPath(), str) + this.filename);
        com_tencent_mm_protocal_c_bbd.ucf = str2;
        com_tencent_mm_protocal_c_bbd.ucg = 0;
        com_tencent_mm_protocal_c_bbd.tgK = 0;
        com_tencent_mm_protocal_c_bbd.tgJ = 0;
        com_tencent_mm_protocal_c_bbd.jOc = this.pTU;
        w.d("MicroMsg.NetSceneSnsDownload", "requestKey " + str3);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSnsDownload", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bbe com_tencent_mm_protocal_c_bbe = (bbe) ((b) pVar).hsk.hsr;
        if (((c) pVar.zg()).sZC != 0) {
            this.gUD.a(i2, i3, str, this);
            ae.beG().EX(this.pTX);
            return;
        }
        q Gv = ae.beA().Gv(this.mediaId);
        if (com_tencent_mm_protocal_c_bbe.tgJ <= 0) {
            w.e("MicroMsg.NetSceneSnsDownload", "error 1");
            onError();
        } else if (com_tencent_mm_protocal_c_bbe.tij == null) {
            w.e("MicroMsg.NetSceneSnsDownload", "error 2");
            onError();
        } else if (com_tencent_mm_protocal_c_bbe.tgK < 0 || com_tencent_mm_protocal_c_bbe.tgK + com_tencent_mm_protocal_c_bbe.tij.tZp.sYA.length > com_tencent_mm_protocal_c_bbe.tgJ) {
            w.e("MicroMsg.NetSceneSnsDownload", "error 3");
            onError();
        } else if (com_tencent_mm_protocal_c_bbe.tgK != Gv.offset) {
            w.e("MicroMsg.NetSceneSnsDownload", "error 4");
            onError();
        } else {
            int z = z(com_tencent_mm_protocal_c_bbe.tij.tZp.toByteArray());
            if (z < 0) {
                w.e("MicroMsg.NetSceneSnsDownload", "error 5");
                onError();
                return;
            }
            Gv.offset += z;
            Gv.qnP = com_tencent_mm_protocal_c_bbe.tgJ;
            w.d("MicroMsg.NetSceneSnsDownload", "byteLen " + z + "  totalLen " + com_tencent_mm_protocal_c_bbe.tgJ);
            ae.beA().a(this.mediaId, Gv);
            Object obj = (Gv.offset != Gv.qnP || Gv.qnP == 0) ? null : 1;
            if (obj != null) {
                w.d("MicroMsg.NetSceneSnsDownload", "downLoad ok");
                String e = this.pTV == 1 ? i.e(this.pTY) : i.l(this.pTY);
                String du = am.du(ae.getAccSnsPath(), this.mediaId);
                FileOp.deleteFile(du + e);
                FileOp.h(du, this.filename, e);
                if (this.pTW) {
                    r.b(du, e, i.f(this.pTY), (float) ae.beS());
                } else {
                    String e2 = i.e(this.pTY);
                    if (!FileOp.aO(du + e2)) {
                        r.a(du, e, e2, (float) ae.beT());
                    }
                    e2 = i.f(this.pTY);
                    if (!FileOp.aO(du + e2)) {
                        r.b(du, e, e2, (float) ae.beS());
                    }
                }
                ae.beG().EX(this.pTX);
                this.gUD.a(i2, i3, str, this);
                return;
            }
            a(this.hsD, this.gUD);
        }
    }

    private void onError() {
        ae.beG().EX(this.pTX);
    }

    public final int getType() {
        return bv.CTRL_INDEX;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 100;
    }

    private int z(byte[] bArr) {
        if (!i.EN(ae.xv())) {
            return 0;
        }
        try {
            if (this.hrI == null) {
                FileOp.kl(this.pTT);
                this.hrI = FileOp.gQ(this.pTT + this.filename);
            }
            w.d("MicroMsg.NetSceneSnsDownload", "appendBuf " + bArr.length);
            this.hrI.write(bArr);
            return bArr.length;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "appendBuf failed: " + this.filename, new Object[0]);
            return -1;
        } finally {
            Bv();
        }
    }

    private void Bv() {
        try {
            if (this.hrI != null) {
                this.hrI.flush();
                this.hrI.close();
                this.hrI = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneSnsDownload", e, "", new Object[0]);
        }
    }
}
