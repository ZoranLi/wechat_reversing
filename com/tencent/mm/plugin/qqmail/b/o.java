package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import java.util.Random;

public final class o extends k implements j {
    private String fSm;
    public String filePath = null;
    private b gUA;
    private e gUD;
    private f hGt;
    private int hrs = 0;
    private int hrt = 0;

    public o(String str, String str2, f fVar) {
        this.filePath = str;
        this.fSm = str2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2);
        this.hGt = fVar;
        w.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[]{this.fSm, this.filePath});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bhm com_tencent_mm_protocal_c_bhm = (bhm) ((b) pVar).hsk.hsr;
            String str2 = com_tencent_mm_protocal_c_bhm.teW;
            w.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[]{com_tencent_mm_protocal_c_bhm.teW, Integer.valueOf(com_tencent_mm_protocal_c_bhm.tgJ), com_tencent_mm_protocal_c_bhm.tsQ});
            if (str2.equals(this.fSm)) {
                this.hrt = com_tencent_mm_protocal_c_bhm.tgK;
                if (this.hrt < this.hrs) {
                    w.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[]{Integer.valueOf(this.hrt), Integer.valueOf(this.hrs)});
                    if (a(this.hsD, this.gUD) < 0) {
                        w.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
                        if (this.gUD != null) {
                            this.gUD.a(i2, i3, str, this);
                        }
                        if (this.hGt != null) {
                            this.hGt.a(this.hrt, this.hrs, this);
                            return;
                        }
                        return;
                    }
                }
                String str3 = com_tencent_mm_protocal_c_bhm.tsQ;
                w.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[]{Integer.valueOf(this.hrt), Integer.valueOf(this.hrs), str3});
                if (this.gUD != null) {
                    this.gUD.a(i2, i3, str, this);
                }
                if (this.hGt != null) {
                    this.hGt.a(this.hrt, this.hrs, this);
                }
            }
        } else if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    protected final int ub() {
        return 640;
    }

    protected final int a(p pVar) {
        if (!bg.mA(this.filePath) && com.tencent.mm.a.e.aO(this.filePath)) {
            return k.b.hsT;
        }
        w.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
        return k.b.hsU;
    }

    protected final void a(a aVar) {
    }

    public final int getType() {
        return 484;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (bg.mA(this.filePath)) {
            w.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
            return -1;
        } else if (com.tencent.mm.a.e.aO(this.filePath)) {
            if (this.hrs == 0) {
                this.hrs = com.tencent.mm.a.e.aN(this.filePath);
                w.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[]{Integer.valueOf(this.hrs)});
            }
            int min = Math.min(this.hrs - this.hrt, WXMediaMessage.THUMB_LENGTH_LIMIT);
            w.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[]{Integer.valueOf(this.hrt), Integer.valueOf(min)});
            byte[] c = com.tencent.mm.a.e.c(this.filePath, this.hrt, min);
            if (c == null) {
                w.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
                return -1;
            }
            w.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[]{Integer.valueOf(c.length)});
            b.a aVar = new b.a();
            aVar.hsm = new bhl();
            aVar.hsn = new bhm();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadfile";
            aVar.hsl = 484;
            aVar.hso = 0;
            aVar.hsp = 0;
            this.gUA = aVar.BE();
            bhl com_tencent_mm_protocal_c_bhl = (bhl) this.gUA.hsj.hsr;
            com_tencent_mm_protocal_c_bhl.teW = this.fSm;
            com_tencent_mm_protocal_c_bhl.tgJ = this.hrs;
            com_tencent_mm_protocal_c_bhl.tgK = this.hrt;
            com_tencent_mm_protocal_c_bhl.tgL = min;
            com_tencent_mm_protocal_c_bhl.tsk = n.G(c);
            w.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[]{Integer.valueOf(a(eVar, this.gUA, this))});
            return a(eVar, this.gUA, this);
        } else {
            w.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[]{this.filePath});
            return -1;
        }
    }

    public final bhm aUs() {
        if (this.gUA != null) {
            return (bhm) this.gUA.hsk.hsr;
        }
        return null;
    }
}
