package com.tencent.mm.ah;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j {
    private final b gUA;
    private e gUD;
    private int gVj;
    private d hHd;
    private a hHe;

    interface a {
        void a(long j, int i, int i2, int i3);
    }

    public l(int i, bhv com_tencent_mm_protocal_c_bhv, d dVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar) {
        int i2;
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new bhv();
        aVar2.hsn = new bhw();
        aVar2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar2.hsl = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        this.gUA = aVar2.BE();
        this.hHe = aVar;
        this.gVj = i;
        this.hHd = dVar;
        bhv com_tencent_mm_protocal_c_bhv2 = (bhv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bhv2.tfd = com_tencent_mm_protocal_c_bhv.tfd;
        com_tencent_mm_protocal_c_bhv2.tfe = com_tencent_mm_protocal_c_bhv.tfe;
        com_tencent_mm_protocal_c_bhv2.uhl = com_tencent_mm_protocal_c_bhv.uhl;
        com_tencent_mm_protocal_c_bhv2.mtd = com_tencent_mm_protocal_c_bhv.mtd;
        com_tencent_mm_protocal_c_bhv2.tfi = com_tencent_mm_protocal_c_bhv.tfi;
        com_tencent_mm_protocal_c_bhv2.tnj = com_tencent_mm_protocal_c_bhv.tnj;
        Options Pe = d.Pe(n.GS().m(dVar.hFb, "", ""));
        com_tencent_mm_protocal_c_bhv2.uht = Pe != null ? Pe.outWidth : 0;
        if (Pe != null) {
            i2 = Pe.outHeight;
        } else {
            i2 = 0;
        }
        com_tencent_mm_protocal_c_bhv2.uhs = i2;
        com_tencent_mm_protocal_c_bhv2.uhq = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        com_tencent_mm_protocal_c_bhv2.uhr = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bhv2.tgJ = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bhv2.tgK = 0;
        com_tencent_mm_protocal_c_bhv2.tgL = com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength;
        com_tencent_mm_protocal_c_bhv2.tsk = new avw().bb(new byte[0]);
        com_tencent_mm_protocal_c_bhv2.tnh = 1;
        if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
            w.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc), com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
            com_tencent_mm_protocal_c_bhv2.uah = 1;
            com_tencent_mm_protocal_c_bhv2.tng = "";
            com_tencent_mm_protocal_c_bhv2.tKJ = "";
        } else {
            com_tencent_mm_protocal_c_bhv2.tng = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
            com_tencent_mm_protocal_c_bhv2.tKJ = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
        }
        com_tencent_mm_protocal_c_bhv2.tFO = com_tencent_mm_protocal_c_bhv.tFO;
        if (com_tencent_mm_protocal_c_bhv.tFO == 1) {
            com_tencent_mm_protocal_c_bhv2.uho = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
            com_tencent_mm_protocal_c_bhv2.uhp = com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength;
            com_tencent_mm_protocal_c_bhv2.uhm = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
            com_tencent_mm_protocal_c_bhv2.uhn = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        } else {
            com_tencent_mm_protocal_c_bhv2.uho = 0;
            com_tencent_mm_protocal_c_bhv2.uhp = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
            com_tencent_mm_protocal_c_bhv2.uhm = "";
            com_tencent_mm_protocal_c_bhv2.uhn = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        }
        com_tencent_mm_protocal_c_bhv2.tni = com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc;
        com_tencent_mm_protocal_c_bhv2.tup = com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5;
        w.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", Integer.valueOf(com_tencent_mm_protocal_c_bhv2.tnj), Integer.valueOf(com_tencent_mm_protocal_c_bhv2.uah), bg.Qj(com_tencent_mm_protocal_c_bhv2.tng), Integer.valueOf(com_tencent_mm_protocal_c_bhv2.tni));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", ((bhv) this.gUA.hsj.hsr).toString());
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        bhw com_tencent_mm_protocal_c_bhw = (bhw) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", Integer.valueOf(com_tencent_mm_protocal_c_bhw.ogM), Long.valueOf(com_tencent_mm_protocal_c_bhw.tfk));
        if (this.hHe != null) {
            this.hHe.a(com_tencent_mm_protocal_c_bhw.tfk, com_tencent_mm_protocal_c_bhw.ogM, i2, i3);
        }
        this.gUD.a(0, 0, "", this);
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_CLOSE_FAILED;
    }
}
