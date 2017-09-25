package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aya;
import com.tencent.mm.protocal.c.ayb;
import com.tencent.mm.protocal.c.bfi;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    private String clientId = "";
    private b gUA;
    private com.tencent.mm.y.e gUD;
    private long hYG = -1;
    private r hYH = null;
    private keep_SceneResult hYI = null;

    public e(long j, r rVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, String str) {
        w.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", Long.valueOf(j), str);
        this.hYG = j;
        this.hYH = rVar;
        this.hYI = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.clientId = str;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        int i = 0;
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new aya();
        aVar.hsn = new ayb();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsight";
        aVar.hsl = 245;
        this.gUA = aVar.BE();
        aya com_tencent_mm_protocal_c_aya = (aya) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aya.hhE = this.hYI.field_aesKey;
        com_tencent_mm_protocal_c_aya.qaM = this.clientId;
        com_tencent_mm_protocal_c_aya.fFW = this.hYH.fVC;
        com_tencent_mm_protocal_c_aya.uaq = this.hYH.iap;
        o.KV();
        Options Pe = d.Pe(s.lw(this.hYH.getFileName()));
        if (Pe != null) {
            com_tencent_mm_protocal_c_aya.hhD = Pe.outWidth;
            com_tencent_mm_protocal_c_aya.hhC = Pe.outHeight;
        } else {
            w.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", r2);
        }
        com_tencent_mm_protocal_c_aya.hYY = this.hYH.ial;
        String[] split = bg.ap(this.hYH.iax, "").split(",");
        if (split == null || split.length <= 0) {
            w.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", Long.valueOf(this.hYG));
            return -1;
        }
        int length = split.length;
        while (i < length) {
            String str = split[i];
            bfi com_tencent_mm_protocal_c_bfi = new bfi();
            com_tencent_mm_protocal_c_bfi.username = str;
            com_tencent_mm_protocal_c_aya.uap.add(com_tencent_mm_protocal_c_bfi);
            i++;
        }
        com_tencent_mm_protocal_c_aya.url = this.hYI.field_fileId;
        com_tencent_mm_protocal_c_aya.iap = this.hYH.hrs;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.hYG);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 245;
    }
}
