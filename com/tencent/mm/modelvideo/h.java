package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bid;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import junit.framework.Assert;

public final class h extends k implements j {
    String fyF = null;
    private b gUA;
    private e gUD;
    private int hZe = 0;
    private keep_SceneResult hZf = null;
    private a hZg = null;

    interface a {
        void bb(int i, int i2);
    }

    public h(String str, int i, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, a aVar) {
        boolean z = false;
        Assert.assertTrue(str != null);
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        this.fyF = str;
        this.hZf = com_tencent_mm_modelcdntran_keep_SceneResult;
        this.hZg = aVar;
        this.hZe = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        r lH = t.lH(this.fyF);
        if (lH == null) {
            w.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fyF);
            this.hZg.bb(3, -1);
            return -1;
        }
        String zz;
        int i;
        String str;
        String str2;
        Object[] objArr;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bid();
        aVar.hsn = new bie();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.hsl = c.CTRL_INDEX;
        aVar.hso = 39;
        aVar.hsp = 1000000039;
        this.gUA = aVar.BE();
        bid com_tencent_mm_protocal_c_bid = (bid) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bid.uhA = 0;
        com_tencent_mm_protocal_c_bid.uhz = this.hZf.field_fileLength;
        com_tencent_mm_protocal_c_bid.uhB = new avw().bb(new byte[0]);
        com_tencent_mm_protocal_c_bid.tOT = 0;
        com_tencent_mm_protocal_c_bid.tOS = this.hZf.field_thumbimgLength;
        com_tencent_mm_protocal_c_bid.tOU = new avw().bb(new byte[0]);
        com_tencent_mm_protocal_c_bid.mvV = m.xL();
        com_tencent_mm_protocal_c_bid.mvU = this.hZf.field_toUser;
        com_tencent_mm_protocal_c_bid.tfU = this.fyF;
        if (lH.iat == 1) {
            com_tencent_mm_protocal_c_bid.uhD = 2;
        }
        if (lH.iaw == 3) {
            com_tencent_mm_protocal_c_bid.uhD = 3;
        }
        com_tencent_mm_protocal_c_bid.uhC = lH.iap;
        com_tencent_mm_protocal_c_bid.tua = aa.bn(ab.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bid.tOV = 2;
        com_tencent_mm_protocal_c_bid.uhr = this.hZf.field_thumbimgLength;
        com_tencent_mm_protocal_c_bid.uhE = this.hZf.field_fileId;
        com_tencent_mm_protocal_c_bid.tKH = this.hZf.field_fileId;
        com_tencent_mm_protocal_c_bid.tnh = 1;
        if (this.hZf.isUploadBySafeCDNWithMD5()) {
            w.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", KO(), Boolean.valueOf(this.hZf.field_upload_by_safecdn), Integer.valueOf(this.hZf.field_UploadHitCacheType), Integer.valueOf(this.hZf.field_filecrc), this.hZf.field_aesKey);
            com_tencent_mm_protocal_c_bid.uah = 1;
            com_tencent_mm_protocal_c_bid.tng = "";
            com_tencent_mm_protocal_c_bid.tKJ = "";
        } else {
            com_tencent_mm_protocal_c_bid.tng = this.hZf.field_aesKey;
            com_tencent_mm_protocal_c_bid.tKJ = this.hZf.field_aesKey;
        }
        com_tencent_mm_protocal_c_bid.uhG = this.hZf.field_filemd5;
        com_tencent_mm_protocal_c_bid.uhQ = this.hZf.field_mp4identifymd5;
        com_tencent_mm_protocal_c_bid.tni = this.hZf.field_filecrc;
        if (this.hZe <= 0 || this.hZe > 1048576) {
            zz = ba.zz();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msgsource>");
            stringBuilder.append("<videopreloadlen>").append(this.hZe).append("</videopreloadlen>");
            stringBuilder.append("</msgsource>");
            g.oUh.a(354, 35, 1, false);
            zz = stringBuilder.toString();
        }
        com_tencent_mm_protocal_c_bid.tfi = zz;
        com_tencent_mm_protocal_c_bid.uhP = lH.fUY;
        bdu com_tencent_mm_protocal_c_bdu = lH.iay;
        if (com_tencent_mm_protocal_c_bdu != null && !bg.mA(com_tencent_mm_protocal_c_bdu.hjD)) {
            com_tencent_mm_protocal_c_bid.uhH = bg.ap(com_tencent_mm_protocal_c_bdu.hjD, "");
            com_tencent_mm_protocal_c_bid.uhI = com_tencent_mm_protocal_c_bdu.tyZ;
            com_tencent_mm_protocal_c_bid.uhJ = bg.ap(com_tencent_mm_protocal_c_bdu.hjF, "");
            com_tencent_mm_protocal_c_bid.uhL = bg.ap(com_tencent_mm_protocal_c_bdu.hjH, "");
            com_tencent_mm_protocal_c_bid.uhK = bg.ap(com_tencent_mm_protocal_c_bdu.hjG, "");
            com_tencent_mm_protocal_c_bid.uhM = bg.ap(com_tencent_mm_protocal_c_bdu.hjI, "");
        } else if (!(com_tencent_mm_protocal_c_bdu == null || bg.mA(com_tencent_mm_protocal_c_bdu.hjH) || bg.mA(com_tencent_mm_protocal_c_bdu.hjG))) {
            com_tencent_mm_protocal_c_bid.uhL = com_tencent_mm_protocal_c_bdu.hjH;
            com_tencent_mm_protocal_c_bid.uhK = com_tencent_mm_protocal_c_bdu.hjG;
        }
        if (com_tencent_mm_protocal_c_bdu != null) {
            com_tencent_mm_protocal_c_bid.uhO = bg.ap(com_tencent_mm_protocal_c_bdu.hjJ, "");
            com_tencent_mm_protocal_c_bid.uhN = bg.ap(com_tencent_mm_protocal_c_bdu.hjK, "");
        }
        o.KV();
        Options Pe = d.Pe(s.lw(this.fyF));
        if (Pe != null) {
            com_tencent_mm_protocal_c_bid.uht = Pe.outWidth;
            com_tencent_mm_protocal_c_bid.uhs = Pe.outHeight;
        } else {
            w.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", zz);
        }
        o.KV();
        zz = s.lv(this.fyF);
        n KT = n.KT();
        if (!bg.mA(zz)) {
            a aVar2 = (a) KT.hZB.get(zz);
            if (aVar2 != null) {
                i = aVar2.hZS;
                switch (i) {
                    case 1:
                        com_tencent_mm_protocal_c_bid.tnj = 1;
                        com_tencent_mm_protocal_c_bid.tfW = 2;
                        break;
                    case 2:
                        com_tencent_mm_protocal_c_bid.tnj = 1;
                        com_tencent_mm_protocal_c_bid.tfW = 1;
                        break;
                    case 3:
                    case 6:
                        com_tencent_mm_protocal_c_bid.tnj = 2;
                        com_tencent_mm_protocal_c_bid.tfW = 3;
                        break;
                    case 7:
                        com_tencent_mm_protocal_c_bid.tnj = 3;
                        com_tencent_mm_protocal_c_bid.tfW = 4;
                        break;
                    case 8:
                        com_tencent_mm_protocal_c_bid.tnj = 1;
                        com_tencent_mm_protocal_c_bid.tfW = 5;
                        break;
                    default:
                        com_tencent_mm_protocal_c_bid.tnj = 0;
                        com_tencent_mm_protocal_c_bid.tfW = 0;
                        break;
                }
                str = "MicroMsg.NetSceneUploadVideoForCdn";
                str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
                objArr = new Object[22];
                objArr[0] = KO();
                objArr[1] = this.fyF;
                objArr[2] = this.hZf.field_toUser;
                if (this.hZf.field_aesKey != null) {
                    i = -1;
                } else {
                    i = this.hZf.field_aesKey.length();
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = this.hZf.field_fileId;
                objArr[5] = Integer.valueOf(this.hZf.field_thumbimgLength);
                objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uht);
                objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uhs);
                objArr[8] = bg.Qj(com_tencent_mm_protocal_c_bid.tKJ);
                objArr[9] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uhD);
                objArr[10] = com_tencent_mm_protocal_c_bid.uhG;
                objArr[11] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uah);
                objArr[12] = Integer.valueOf(com_tencent_mm_protocal_c_bid.tni);
                objArr[13] = com_tencent_mm_protocal_c_bid.uhQ;
                objArr[14] = bg.Qj(com_tencent_mm_protocal_c_bid.tng);
                objArr[15] = com_tencent_mm_protocal_c_bid.uhH;
                objArr[16] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uhI);
                objArr[17] = com_tencent_mm_protocal_c_bid.uhJ;
                objArr[18] = com_tencent_mm_protocal_c_bid.uhM;
                objArr[19] = com_tencent_mm_protocal_c_bid.tfi;
                objArr[20] = Integer.valueOf(com_tencent_mm_protocal_c_bid.tnj);
                objArr[21] = Integer.valueOf(com_tencent_mm_protocal_c_bid.tfW);
                w.i(str, str2, objArr);
                return a(eVar, this.gUA, this);
            }
        }
        i = 0;
        switch (i) {
            case 1:
                com_tencent_mm_protocal_c_bid.tnj = 1;
                com_tencent_mm_protocal_c_bid.tfW = 2;
                break;
            case 2:
                com_tencent_mm_protocal_c_bid.tnj = 1;
                com_tencent_mm_protocal_c_bid.tfW = 1;
                break;
            case 3:
            case 6:
                com_tencent_mm_protocal_c_bid.tnj = 2;
                com_tencent_mm_protocal_c_bid.tfW = 3;
                break;
            case 7:
                com_tencent_mm_protocal_c_bid.tnj = 3;
                com_tencent_mm_protocal_c_bid.tfW = 4;
                break;
            case 8:
                com_tencent_mm_protocal_c_bid.tnj = 1;
                com_tencent_mm_protocal_c_bid.tfW = 5;
                break;
            default:
                com_tencent_mm_protocal_c_bid.tnj = 0;
                com_tencent_mm_protocal_c_bid.tfW = 0;
                break;
        }
        str = "MicroMsg.NetSceneUploadVideoForCdn";
        str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
        objArr = new Object[22];
        objArr[0] = KO();
        objArr[1] = this.fyF;
        objArr[2] = this.hZf.field_toUser;
        if (this.hZf.field_aesKey != null) {
            i = this.hZf.field_aesKey.length();
        } else {
            i = -1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.hZf.field_fileId;
        objArr[5] = Integer.valueOf(this.hZf.field_thumbimgLength);
        objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uht);
        objArr[7] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uhs);
        objArr[8] = bg.Qj(com_tencent_mm_protocal_c_bid.tKJ);
        objArr[9] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uhD);
        objArr[10] = com_tencent_mm_protocal_c_bid.uhG;
        objArr[11] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uah);
        objArr[12] = Integer.valueOf(com_tencent_mm_protocal_c_bid.tni);
        objArr[13] = com_tencent_mm_protocal_c_bid.uhQ;
        objArr[14] = bg.Qj(com_tencent_mm_protocal_c_bid.tng);
        objArr[15] = com_tencent_mm_protocal_c_bid.uhH;
        objArr[16] = Integer.valueOf(com_tencent_mm_protocal_c_bid.uhI);
        objArr[17] = com_tencent_mm_protocal_c_bid.uhJ;
        objArr[18] = com_tencent_mm_protocal_c_bid.uhM;
        objArr[19] = com_tencent_mm_protocal_c_bid.tfi;
        objArr[20] = Integer.valueOf(com_tencent_mm_protocal_c_bid.tnj);
        objArr[21] = Integer.valueOf(com_tencent_mm_protocal_c_bid.tfW);
        w.i(str, str2, objArr);
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 1;
    }

    protected final void a(a aVar) {
        t.lA(this.fyF);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", KO(), Integer.valueOf(i2), Integer.valueOf(i3));
        bie com_tencent_mm_protocal_c_bie = (bie) ((b) pVar).hsk.hsr;
        r lH = t.lH(this.fyF);
        if (lH == null) {
            w.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fyF);
            this.gUD.a(i2, i3, str, this);
            this.hZg.bb(3, -1);
        } else if (i2 == 4 && i3 == 102) {
            w.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fyF + " user:" + lH.Le());
            this.gUD.a(i2, i3, str, this);
            this.hZg.bb(i2, i3);
        } else if (i2 == 4 && i3 == -22) {
            w.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fyF + " user:" + lH.Le());
            t.lB(this.fyF);
            this.gUD.a(i2, i3, str, this);
            this.hZg.bb(i2, i3);
        } else if (i2 == 4 && i3 != 0) {
            w.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fyF + " user:" + lH.Le());
            t.lA(this.fyF);
            this.gUD.a(i2, i3, str, this);
            this.hZg.bb(i2, i3);
        } else if (i2 == 0 && i3 == 0) {
            lH.ian = bg.Ny();
            lH.fTQ = com_tencent_mm_protocal_c_bie.tfk;
            w.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", KO(), Long.valueOf(lH.fTQ), Integer.valueOf(r.iiX));
            if (!(10007 != r.iiW || r.iiX == 0 || lH.fTQ == 0)) {
                lH.fTQ = (long) r.iiX;
                r.iiX = 0;
            }
            lH.status = 199;
            lH.fRW = 1284;
            if (this.hZf.isUploadBySafeCDNWithMD5()) {
                w.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", KO(), com_tencent_mm_protocal_c_bie.tng, lH.Lh());
                if (bg.mA(com_tencent_mm_protocal_c_bie.tng)) {
                    w.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", KO());
                } else {
                    w.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + com_tencent_mm_protocal_c_bie.tng + "\" cdnthumbaeskey=\"" + com_tencent_mm_protocal_c_bie.tng + "\" cdnvideourl=\"" + this.hZf.field_fileId + "\" ") + "cdnthumburl=\"" + this.hZf.field_fileId + "\" ") + "length=\"" + this.hZf.field_fileLength + "\" ") + "cdnthumblength=\"" + this.hZf.field_thumbimgLength + "\"/></msg>");
                    lH.iav = r1;
                    s KV = o.KV();
                    o.KV();
                    boolean o = KV.o(s.lv(this.fyF), this.hZf.field_fileId, com_tencent_mm_protocal_c_bie.tng);
                    g gVar = g.oUh;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf((o ? 1 : 2) + 900);
                    objArr[1] = Integer.valueOf(lH.hrs);
                    gVar.i(12696, objArr);
                    w.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", KO(), com_tencent_mm_protocal_c_bie.tng, lH.Lh(), Boolean.valueOf(o));
                }
            }
            t.e(lH);
            t.c(lH);
            com.tencent.mm.modelstat.b.hUp.f(((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) lH.iaq));
            com.tencent.mm.j.a Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(lH.Le());
            boolean bLe = (Rc == null || ((int) Rc.gTQ) <= 0) ? false : Rc.bLe();
            if (bLe || o.fh(lH.Le())) {
                w.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", KO(), lH.Le());
                if (lH.fTQ < 0) {
                    w.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + lH.fTQ + " file:" + this.fyF + " toUser:" + lH.Le());
                    t.lA(this.fyF);
                    this.hZg.bb(3, -1);
                }
            } else {
                w.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", KO());
                if (lH.fTQ <= 0) {
                    w.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + lH.fTQ + " file:" + this.fyF + " toUser:" + lH.Le());
                    t.lA(this.fyF);
                    this.hZg.bb(3, -1);
                }
            }
            this.gUD.a(i2, i3, str, this);
            this.hZg.bb(0, 0);
        } else {
            w.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fyF + " user:" + lH.Le());
            t.lA(this.fyF);
            this.gUD.a(i2, i3, str, this);
            this.hZg.bb(i2, i3);
        }
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    private String KO() {
        return this.fyF + "_" + hashCode();
    }
}
