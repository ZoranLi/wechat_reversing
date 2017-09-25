package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.o;
import com.tencent.mm.e.a.sr;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.q;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Locale;

public final class ai extends k implements j {
    private long fGM = 0;
    private au fTk = null;
    private b gUA;
    private e gUD;
    private keep_SceneResult gVp = null;
    private String iCS;
    private sr pUh;
    private o sDV;
    private b sDY = null;
    private boolean sDZ = false;
    private a sEa = null;

    interface a {
        void bb(int i, int i2);
    }

    public ai(long j, boolean z, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar, String str, b bVar) {
        this.fGM = j;
        this.iCS = str;
        this.gVp = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.sEa = aVar;
        this.sDZ = z;
        this.sDY = bVar;
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new axm();
        aVar2.hsn = new axn();
        aVar2.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar2.hsl = 222;
        aVar2.hso = MMGIFException.D_GIF_ERR_WRONG_RECORD;
        aVar2.hsp = 1000000107;
        this.gUA = aVar2.BE();
        w.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", Long.valueOf(j), com_tencent_mm_modelcdntran_keep_SceneResult, str, bVar, bg.bJZ());
    }

    public final int getType() {
        return 222;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        ap.yY();
        this.fTk = c.wT().cA(this.fGM);
        if (this.fTk == null || this.fTk.field_msgId != this.fGM) {
            w.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", Long.valueOf(this.fGM));
            this.sEa.bb(3, -1);
            return -1;
        }
        String str;
        int i;
        String string;
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.fTk.field_content);
        if (ek == null) {
            w.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", Long.valueOf(this.fGM));
            this.sEa.bb(3, -1);
        }
        axm com_tencent_mm_protocal_c_axm = (axm) this.gUA.hsj.hsr;
        cu cuVar = new cu();
        cuVar.mtb = ek.appId;
        cuVar.tfU = this.fTk.field_talker + this.fTk.field_msgId + "T" + this.fTk.field_createTime;
        cuVar.ogM = (int) bg.Ny();
        cuVar.mvU = this.fTk.field_talker;
        cuVar.mvV = m.xL();
        cuVar.jOc = ek.type;
        cuVar.tfT = ek.sdkVer;
        cuVar.tfW = ek.hht;
        if (com.tencent.mm.modelbiz.e.dr(this.fTk.field_talker)) {
            cuVar.tfi = com.tencent.mm.modelbiz.a.e.iw(this.fTk.gxF);
        } else {
            cuVar.tfi = ba.zz();
        }
        cuVar.tfY = ek.fUU;
        cuVar.tfZ = ek.fUV;
        cuVar.tga = ek.fUW;
        q.b fP = q.yC().fP(this.iCS);
        if (fP != null) {
            this.pUh = new sr();
            this.pUh.gaq.url = ek.url;
            this.pUh.gaq.gar = fP.getString("prePublishId", "");
            this.pUh.gaq.gat = fP.getString("preUsername", "");
            this.pUh.gaq.gau = fP.getString("preChatName", "");
            this.pUh.gaq.gav = fP.getInt("preMsgIndex", 0);
            this.pUh.gaq.gaz = fP.getInt("sendAppMsgScene", 0);
            this.pUh.gaq.gaA = fP.getInt("getA8KeyScene", 0);
            this.pUh.gaq.gaB = fP.getString("referUrl", null);
            this.pUh.gaq.gaC = fP.getString("adExtStr", null);
            this.pUh.gaq.gaw = this.fTk.field_talker;
            this.pUh.gaq.gaD = ek.title;
            ap.yY();
            x Rc = c.wR().Rc(this.fTk.field_talker);
            if (Rc != null) {
                this.pUh.gaq.gax = Rc.tK();
            }
            this.pUh.gaq.gay = com.tencent.mm.u.j.eC(this.fTk.field_talker);
            str = "";
            if (ek.fUY != null) {
                bdi com_tencent_mm_protocal_c_bdi = new bdi();
                try {
                    com_tencent_mm_protocal_c_bdi.aD(Base64.decode(ek.fUY, 0));
                    if (com_tencent_mm_protocal_c_bdi.ueC != null) {
                        str = com_tencent_mm_protocal_c_bdi.ueC.mpy;
                    }
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_axm.uag = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.pUh.gaq.gar, this.pUh.gaq.gat, this.pUh.gaq.gau, Integer.valueOf(com.tencent.mm.u.p.G(this.pUh.gaq.gat, this.pUh.gaq.gau)), Integer.valueOf(this.pUh.gaq.gaA), str});
        }
        if (fP != null && ek.type == 33) {
            this.sDV = new o();
            i = fP.getInt("fromScene", 1);
            this.sDV.fCL.scene = i;
            string = fP.getString("preChatName", "");
            if (2 == i) {
                this.sDV.fCL.fCN = string + ":" + fP.getString("preUsername", "");
            } else {
                this.sDV.fCL.fCN = string;
            }
            str = this.fTk.field_talker;
            boolean z = fP.getBoolean("moreRetrAction", false);
            if (str.endsWith("@chatroom")) {
                this.sDV.fCL.action = z ? 5 : 2;
            } else {
                this.sDV.fCL.action = z ? 4 : 1;
            }
            this.sDV.fCL.fCM = ek.hjT + 1;
            this.sDV.fCL.fCO = ek.hjL;
            this.sDV.fCL.fCJ = ek.hjM;
            this.sDV.fCL.appId = ek.hjN;
            this.sDV.fCL.fCQ = bg.Ny();
            this.sDV.fCL.fCR = 1;
        }
        w.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", ek.fUU, ek.fUV, ek.fUW);
        int i2 = 0;
        i = 0;
        if (!bg.mA(this.fTk.field_imgPath)) {
            Options Pe = d.Pe(n.GS().ju(this.fTk.field_imgPath));
            if (Pe != null) {
                i2 = Pe.outWidth;
                i = Pe.outHeight;
            }
        }
        if (this.gVp.isUploadBySafeCDNWithMD5()) {
            w.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", Integer.valueOf(this.gVp.field_filecrc), Boolean.valueOf(this.gVp.field_upload_by_safecdn), Integer.valueOf(this.gVp.field_UploadHitCacheType), this.gVp.field_aesKey);
            this.gVp.field_aesKey = "";
            com_tencent_mm_protocal_c_axm.uah = 1;
        }
        com_tencent_mm_protocal_c_axm.tni = this.gVp.field_filecrc;
        string = null;
        if (this.sDZ) {
            string = "@cdn_" + this.gVp.field_fileId + "_" + this.gVp.field_aesKey + "_1";
        }
        cuVar.opI = com.tencent.mm.t.f.a.a(ek, string, this.gVp, i2, i);
        com_tencent_mm_protocal_c_axm.uae = cuVar;
        if (this.sDY != null && (ek.hhu != 0 || ek.hhq > 26214400)) {
            com_tencent_mm_protocal_c_axm.hAG = this.sDY.field_signature;
            com_tencent_mm_protocal_c_axm.tgM = com.tencent.mm.modelcdntran.b.hxN;
        }
        com_tencent_mm_protocal_c_axm.tup = ek.filemd5;
        if (bg.mA(this.gVp.field_filemd5)) {
            w.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", ek.filemd5);
        } else {
            com_tencent_mm_protocal_c_axm.tup = this.gVp.field_filemd5;
        }
        w.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", com_tencent_mm_protocal_c_axm.tup, Integer.valueOf(com_tencent_mm_protocal_c_axm.uah), bg.Qj(com_tencent_mm_protocal_c_axm.hAG), Integer.valueOf(com_tencent_mm_protocal_c_axm.tgM), this.gVp, com_tencent_mm_protocal_c_axm.uag);
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        axm com_tencent_mm_protocal_c_axm = (axm) ((b) pVar).hsj.hsr;
        w.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.fGM), this.fTk.field_content, com_tencent_mm_protocal_c_axm.uae.opI);
        if (i2 == 0 && i3 == 0) {
            axn com_tencent_mm_protocal_c_axn = (axn) ((b) pVar).hsk.hsr;
            w.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", Long.valueOf(com_tencent_mm_protocal_c_axn.tfk), com_tencent_mm_protocal_c_axn.tng, this.fTk.field_content);
            if (this.gVp != null && this.gVp.isUploadBySafeCDNWithMD5()) {
                if (bg.mA(com_tencent_mm_protocal_c_axn.tng)) {
                    w.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
                } else {
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.fTk.field_content);
                    ek.hhE = com_tencent_mm_protocal_c_axn.tng;
                    this.fTk.setContent(com.tencent.mm.t.f.a.a(ek, null, null));
                    w.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", com_tencent_mm_protocal_c_axn.tng, this.fTk.field_content);
                }
            }
            this.fTk.dv(2);
            this.fTk.y(com_tencent_mm_protocal_c_axn.tfk);
            ap.yY();
            c.wT().a(this.fTk.field_msgId, this.fTk);
            com.tencent.mm.modelstat.b.hUp.a(this.fTk, g.g(this.fTk));
            this.gUD.a(i2, i3, str, this);
            this.sEa.bb(i2, i3);
            if (!(this.pUh == null || bg.mA(this.pUh.gaq.url))) {
                this.pUh.gaq.gas = "msg_" + Long.toString(com_tencent_mm_protocal_c_axn.tfk);
                com.tencent.mm.sdk.b.a.urY.m(this.pUh);
            }
            if (this.sDV != null) {
                this.sDV.fCL.fCP = "msg_" + this.fTk.field_msgSvrId;
                com.tencent.mm.sdk.b.a.urY.m(this.sDV);
            }
        } else if (i2 == 4 && i3 == 102) {
            w.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
            this.gUD.a(i2, i3, str, this);
            this.sEa.bb(i2, i3);
        } else {
            this.fTk.dv(5);
            ap.yY();
            c.wT().a(this.fTk.field_msgId, this.fTk);
            w.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + i2 + "," + i3);
            this.gUD.a(i2, i3, str, this);
            this.sEa.bb(i2, i3);
        }
    }
}
