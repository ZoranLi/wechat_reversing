package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bhj;
import com.tencent.mm.protocal.c.bhk;
import com.tencent.mm.protocal.c.ox;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ba;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class r extends k implements j {
    private c fEk;
    private final b gUA;
    private e gUD;
    private long hFg;
    private boolean kMR;

    public r(String str, String str2, c cVar, long j) {
        this(str, str2, cVar, j, (byte) 0);
    }

    private r(String str, String str2, c cVar, long j, byte b) {
        int i = 1;
        this.kMR = true;
        this.hFg = 0;
        boolean z = (str2 == null || str2.length() <= 0 || cVar == null) ? false : true;
        Assert.assertTrue(z);
        this.hFg = j;
        this.fEk = cVar;
        a aVar = new a();
        aVar.hsm = new bhj();
        aVar.hsn = new bhk();
        aVar.uri = "/cgi-bin/micromsg-bin/sendemoji";
        aVar.hsl = aa.CTRL_BYTE;
        aVar.hso = 68;
        aVar.hsp = 1000000068;
        this.gUA = aVar.BE();
        h.amc().kLa.a(ab.getContext(), cVar);
        bhj com_tencent_mm_protocal_c_bhj = (bhj) this.gUA.hsj.hsr;
        ox oxVar = new ox();
        oxVar.tuy = cVar.EP();
        oxVar.tuC = str;
        oxVar.mvU = str2;
        oxVar.tgJ = cVar.field_size;
        oxVar.tuA = cVar.pM();
        oxVar.jOc = cVar.field_type;
        oxVar.tfi = ba.zz();
        oxVar.tuD = 0;
        if (str2.endsWith("@chatroom")) {
            i = 2;
        }
        if (cVar.field_catalog == c.uKX) {
            oxVar.tuB = "56,2," + i;
        } else if (cVar.field_catalog == c.uKW) {
            oxVar.tuB = "56,1," + i;
        }
        com_tencent_mm_protocal_c_bhj.tuF.add(oxVar);
        com_tencent_mm_protocal_c_bhj.ugV = com_tencent_mm_protocal_c_bhj.tuF.size();
    }

    public final int getType() {
        return aa.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        this.gUD = eVar2;
        ox oxVar = (ox) ((bhj) this.gUA.hsj.hsr).tuF.get(0);
        if (this.kMR) {
            w.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + oxVar.tuy);
            oxVar.tuz = new avw();
            oxVar.tgK = 0;
            return a(eVar, this.gUA, this);
        }
        byte[] bArr;
        int i2 = this.fEk.field_size - this.fEk.field_start;
        if (i2 <= 8192) {
            i = i2;
        }
        if ((this.fEk.field_reserved4 & c.uLn) == c.uLn) {
            Object a = com.tencent.mm.plugin.emoji.e.e.alz().a(this.fEk);
            if (bg.bm(a)) {
                w.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
                bArr = new byte[0];
            } else {
                Object obj = new byte[i];
                w.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[]{Integer.valueOf(a.length), Integer.valueOf(i)});
                System.arraycopy(a, this.fEk.field_start, obj, 0, i);
                bArr = obj;
            }
        } else {
            bArr = this.fEk.dP(this.fEk.field_start, i);
        }
        if (EmojiLogic.ad(bArr) == c.uKP && this.kMR) {
            w.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.fEk.bNs();
            return -1;
        } else if (bArr == null || bArr.length <= 0) {
            w.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            return -1;
        } else {
            i2 = bArr.length;
            oxVar.tgK = this.fEk.field_start;
            oxVar.tuz = new avw().b(com.tencent.mm.bd.b.aU(bArr));
            if (com.tencent.mm.modelbiz.e.dr(oxVar.mvU)) {
                ap.yY();
                oxVar.tfi = com.tencent.mm.modelbiz.a.e.iw(com.tencent.mm.u.c.wT().cA(this.hFg).gxF);
                w.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[]{oxVar.tfi});
            }
            w.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.fEk.field_start + ", total:" + this.fEk.field_size + ", len:" + i2);
            return a(eVar, this.gUA, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bhj com_tencent_mm_protocal_c_bhj = (bhj) ((b) pVar).hsj.hsr;
            bhk com_tencent_mm_protocal_c_bhk = (bhk) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_bhj.tuF.size() != com_tencent_mm_protocal_c_bhk.tuF.size()) {
                w.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + com_tencent_mm_protocal_c_bhk.tuF.size() + ", resp size:" + com_tencent_mm_protocal_c_bhj.tuF.size());
                this.gUD.a(i2, i3, str, this);
                return;
            }
            oy oyVar = (oy) com_tencent_mm_protocal_c_bhk.tuF.get(0);
            if (oyVar.tuy == null || !oyVar.tuy.equals(this.fEk.EP()) || oyVar.tgK < this.fEk.field_start) {
                w.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + oyVar.tgK + ", size=" + this.fEk.field_size);
                this.gUD.a(4, -2, "", this);
                this.fEk.field_start = 0;
                h.amc().kLa.u(this.fEk);
                return;
            } else if (com_tencent_mm_protocal_c_bhk.tZe.thX != 0) {
                w.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bhk.tZe.thX)});
                this.gUD.a(4, -2, "", this);
                return;
            } else {
                if (this.kMR) {
                    this.kMR = false;
                }
                if (oyVar.tgK >= oyVar.tgJ) {
                    w.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + oyVar.tuE);
                    ap.yY();
                    au cA = com.tencent.mm.u.c.wT().cA(this.hFg);
                    w.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[]{Integer.valueOf(oyVar.tuE), Integer.valueOf(com.tencent.mm.platformtools.r.iiX)});
                    if (10007 == com.tencent.mm.platformtools.r.iiW && com.tencent.mm.platformtools.r.iiX != 0) {
                        oyVar.tuE = com.tencent.mm.platformtools.r.iiX;
                        com.tencent.mm.platformtools.r.iiX = 0;
                    }
                    cA.y((long) oyVar.tuE);
                    ap.yY();
                    com.tencent.mm.u.c.wT().a(this.hFg, cA);
                    this.fEk.field_start = 0;
                    this.fEk.field_lastUseTime = System.currentTimeMillis();
                    this.fEk.field_state = c.uLg;
                    h.amc().kLa.u(this.fEk);
                    if (cA.axO()) {
                        com.tencent.mm.modelstat.b.hUp.a(cA, g.g(cA));
                    } else {
                        com.tencent.mm.modelstat.b.hUp.f(cA);
                    }
                    this.gUD.a(i2, i3, "", this);
                    return;
                }
                this.fEk.field_start = oyVar.tgK;
                this.fEk.field_lastUseTime = System.currentTimeMillis();
                h.amc().kLa.u(this.fEk);
                if (a(this.hsD, this.gUD) < 0) {
                    this.gUD.a(3, -1, "", this);
                    return;
                }
                return;
            }
        }
        w.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }

    protected final int ub() {
        return 256;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }
}
