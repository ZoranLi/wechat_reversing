package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.o;
import com.tencent.mm.e.a.sr;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.axm;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.protocal.c.bdi;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.u.p;
import com.tencent.mm.u.q;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ah extends k implements j {
    public long fGM = 0;
    public au fTk = null;
    private b gUA;
    public e gUD;
    private a hGH = new a(this) {
        final /* synthetic */ ah sDW;

        {
            this.sDW = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            w.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.sDW.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
            if (i == -21005) {
                w.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.sDW.hGx);
                return 0;
            } else if (i != 0) {
                this.sDW.fTk.dv(5);
                c.oTb.a(111, 34, 1, true);
                ap.yY();
                com.tencent.mm.u.c.wT().a(this.sDW.fTk.field_msgId, this.sDW.fTk);
                g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.sDW.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "");
                this.sDW.gUD.a(3, i, "", this.sDW);
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.sDW.fTk.dv(5);
                        c.oTb.a(111, 34, 1, true);
                        ap.yY();
                        com.tencent.mm.u.c.wT().a(this.sDW.fTk.field_msgId, this.sDW.fTk);
                        g.oUh.i(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.sDW.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        g.oUh.i(13937, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.sDW.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.sDW.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.sDW);
                    } else {
                        if (this.sDW.hYY > 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength > 0) {
                            ai.q("SendAppMsgThumbTooBig", this.sDW.hYY + "," + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "," + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, this.sDW.hYY * 2 > com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                        }
                        w.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), bg.Qj(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                        ap.vd().a(new ai(this.sDW.fGM, false, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                            final /* synthetic */ AnonymousClass1 sDX;

                            public final void bb(int i, int i2) {
                                w.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                                g.oUh.i(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.sDX.sDW.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                                this.sDX.sDW.gUD.a(i, i2, "", this.sDX.sDW);
                            }
                        }, this.sDW.iCS, null), 0);
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    public String hGx = "";
    public int hYY = 0;
    public String iCS;
    private sr pUh;
    private String qJM;
    private o sDV;
    public long startTime = 0;

    public ah(long j, String str, String str2) {
        this.fGM = j;
        this.iCS = str;
        this.qJM = str2;
        b.a aVar = new b.a();
        aVar.hsm = new axm();
        aVar.hsn = new axn();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.hsl = 222;
        aVar.hso = MMGIFException.D_GIF_ERR_WRONG_RECORD;
        aVar.hsp = 1000000107;
        this.gUA = aVar.BE();
        w.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", Long.valueOf(j), str, bg.Qj(str2), bg.bJZ());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (this.startTime == 0) {
            this.startTime = bg.Nz();
        }
        ap.yY();
        this.fTk = com.tencent.mm.u.c.wT().cA(this.fGM);
        if (this.fTk == null || this.fTk.field_msgId != this.fGM) {
            return -1;
        }
        f.a aVar;
        f.a ek = f.a.ek(this.fTk.field_content);
        if (ek == null) {
            aj RD = aj.RD(this.fTk.field_content);
            if (bg.mA(RD.uJq)) {
                ek = new f.a();
                ek.hhs = RD.fFW;
                ek.type = 8;
                w.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                aVar = ek;
            } else {
                aVar = f.a.ek(RD.uJq);
            }
        } else {
            aVar = ek;
        }
        Assert.assertTrue("content != null [[" + this.fTk.field_content + "]]", aVar != null);
        if (aVar == null) {
            this.fTk = null;
            return -1;
        }
        String str;
        Object obj;
        String str2 = "";
        if (bg.mA(this.fTk.field_imgPath)) {
            str = str2;
        } else {
            str = n.GS().ju(this.fTk.field_imgPath);
        }
        if (aVar.type == 8 || aVar.type == 9 || aVar.type == 6) {
            w.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", Integer.valueOf(aVar.type));
            obj = null;
        } else if (bg.mA(str)) {
            w.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", Integer.valueOf(aVar.type));
            obj = null;
        } else {
            this.hYY = com.tencent.mm.a.e.aN(str);
            if (aVar.type == 33 || aVar.type == 36 || this.hYY < 262144) {
                w.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", Integer.valueOf(aVar.type), str, Integer.valueOf(this.hYY));
                if (bg.mA(aVar.fCW)) {
                    com.tencent.mm.modelcdntran.g.El();
                    if (com.tencent.mm.modelcdntran.c.fA(4)) {
                        this.hGx = d.a("upappmsg", this.fTk.field_createTime, this.fTk.field_talker, this.fTk.field_msgId);
                        if (bg.mA(this.hGx)) {
                            w.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", Long.valueOf(this.fTk.field_msgId));
                            obj = null;
                        } else {
                            h hVar = new h();
                            hVar.hze = this.hGH;
                            hVar.field_mediaId = this.hGx;
                            hVar.field_fullpath = "";
                            hVar.field_thumbpath = str;
                            hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                            hVar.field_talker = this.fTk.field_talker;
                            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                            hVar.field_needStorage = false;
                            hVar.field_isStreamMedia = false;
                            hVar.hze = this.hGH;
                            hVar.field_force_aeskeycdn = true;
                            hVar.field_trysafecdn = false;
                            w.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", Integer.valueOf(aVar.type), str, this.hGx, Integer.valueOf(hVar.field_fileType), Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_onlycheckexist), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn));
                            if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                                obj = 1;
                            } else {
                                w.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                                this.hGx = "";
                                obj = null;
                            }
                        }
                    } else {
                        Object[] objArr = new Object[1];
                        com.tencent.mm.modelcdntran.g.El();
                        objArr[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(4));
                        w.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", objArr);
                        obj = null;
                    }
                } else {
                    w.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", Long.valueOf(this.fGM));
                    obj = null;
                }
            } else {
                w.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(this.hYY));
                obj = null;
            }
        }
        if (obj != null) {
            w.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", this.hGx);
            return 0;
        }
        String str3;
        axm com_tencent_mm_protocal_c_axm = (axm) this.gUA.hsj.hsr;
        cu cuVar = new cu();
        cuVar.mtb = aVar.appId;
        cuVar.tfU = this.fTk.field_talker + this.fTk.field_msgId + "T" + this.fTk.field_createTime;
        cuVar.opI = f.a.a(aVar, null, null, 0, 0);
        cuVar.ogM = (int) bg.Ny();
        cuVar.mvU = this.fTk.field_talker;
        cuVar.mvV = m.xL();
        cuVar.jOc = aVar.type;
        cuVar.tfT = aVar.sdkVer;
        cuVar.tfW = aVar.hht;
        if (com.tencent.mm.modelbiz.e.dr(this.fTk.field_talker)) {
            cuVar.tfi = com.tencent.mm.modelbiz.a.e.iw(this.fTk.gxF);
        } else {
            cuVar.tfi = ba.zz();
        }
        cuVar.tfY = aVar.fUU;
        cuVar.tfZ = aVar.fUV;
        cuVar.tga = aVar.fUW;
        q.b fP = q.yC().fP(this.iCS);
        if (fP != null) {
            this.pUh = new sr();
            this.pUh.gaq.url = aVar.url;
            this.pUh.gaq.gar = fP.getString("prePublishId", "");
            this.pUh.gaq.gat = fP.getString("preUsername", "");
            this.pUh.gaq.gau = fP.getString("preChatName", "");
            this.pUh.gaq.gav = fP.getInt("preMsgIndex", 0);
            this.pUh.gaq.gaz = fP.getInt("sendAppMsgScene", 0);
            this.pUh.gaq.gaA = fP.getInt("getA8KeyScene", 0);
            this.pUh.gaq.gaB = fP.getString("referUrl", null);
            this.pUh.gaq.gaC = fP.getString("adExtStr", null);
            this.pUh.gaq.gaw = this.fTk.field_talker;
            this.pUh.gaq.gaD = aVar.title;
            ap.yY();
            x Rc = com.tencent.mm.u.c.wR().Rc(this.fTk.field_talker);
            if (Rc != null) {
                this.pUh.gaq.gax = Rc.tK();
            }
            this.pUh.gaq.gay = com.tencent.mm.u.j.eC(this.fTk.field_talker);
            str3 = "";
            if (aVar.fUY != null) {
                bdi com_tencent_mm_protocal_c_bdi = new bdi();
                try {
                    com_tencent_mm_protocal_c_bdi.aD(Base64.decode(aVar.fUY, 0));
                    if (com_tencent_mm_protocal_c_bdi.ueC != null) {
                        str3 = com_tencent_mm_protocal_c_bdi.ueC.mpy;
                    }
                } catch (Exception e) {
                }
            }
            com_tencent_mm_protocal_c_axm.uag = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.pUh.gaq.gar, this.pUh.gaq.gat, this.pUh.gaq.gau, Integer.valueOf(p.G(this.pUh.gaq.gat, this.pUh.gaq.gau)), Integer.valueOf(this.pUh.gaq.gaA), str3});
        }
        if (fP != null && aVar.type == 33) {
            this.sDV = new o();
            int i = fP.getInt("fromScene", 1);
            this.sDV.fCL.scene = i;
            String string = fP.getString("preChatName", "");
            if (2 == i) {
                this.sDV.fCL.fCN = string + ":" + fP.getString("preUsername", "");
            } else {
                this.sDV.fCL.fCN = string;
            }
            str3 = this.fTk.field_talker;
            boolean z = fP.getBoolean("moreRetrAction", false);
            if (str3.endsWith("@chatroom")) {
                this.sDV.fCL.action = z ? 5 : 2;
            } else {
                this.sDV.fCL.action = z ? 4 : 1;
            }
            this.sDV.fCL.fCM = aVar.hjT + 1;
            this.sDV.fCL.fCO = aVar.hjL;
            this.sDV.fCL.fCJ = aVar.hjM;
            this.sDV.fCL.appId = aVar.hjN;
            this.sDV.fCL.fCQ = bg.Ny();
            this.sDV.fCL.fCR = 1;
        }
        w.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", aVar.fUU, aVar.fUV, aVar.fUW);
        if (!bg.mA(str)) {
            byte[] c = com.tencent.mm.a.e.c(str, 0, -1);
            if (!bg.bm(c)) {
                cuVar.tfV = new avw().bb(c);
            }
        }
        str3 = "MicroMsg.NetSceneSendAppMsg";
        String str4 = "doScene thumbFile:[%s] thumbdata:%d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(cuVar.tfV != null ? cuVar.tfV.tZn : -1);
        w.d(str3, str4, objArr2);
        com_tencent_mm_protocal_c_axm.uae = cuVar;
        if (aVar.hhu != 0 || aVar.hhq > 26214400) {
            com_tencent_mm_protocal_c_axm.tgM = com.tencent.mm.modelcdntran.b.hxN;
        }
        com_tencent_mm_protocal_c_axm.tup = aVar.filemd5;
        com_tencent_mm_protocal_c_axm.hAG = this.qJM;
        w.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", com_tencent_mm_protocal_c_axm.tup, bg.Qj(com_tencent_mm_protocal_c_axm.hAG), Integer.valueOf(com_tencent_mm_protocal_c_axm.tgM), com_tencent_mm_protocal_c_axm.uag);
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.fGM), this.fTk.field_content);
        if (i2 == 3 && i3 == -1 && !bg.mA(this.hGx)) {
            w.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hGx);
        } else if (i2 == 0 && i3 == 0) {
            axn com_tencent_mm_protocal_c_axn = (axn) ((b) pVar).hsk.hsr;
            axm com_tencent_mm_protocal_c_axm = (axm) ((b) pVar).hsj.hsr;
            this.fTk.dv(2);
            this.fTk.y(com_tencent_mm_protocal_c_axn.tfk);
            ap.yY();
            com.tencent.mm.u.c.wT().a(this.fTk.field_msgId, this.fTk);
            com.tencent.mm.modelstat.b.hUp.a(this.fTk, com.tencent.mm.t.g.g(this.fTk));
            if (!(this.pUh == null || bg.mA(this.pUh.gaq.url))) {
                this.pUh.gaq.gas = "msg_" + Long.toString(com_tencent_mm_protocal_c_axn.tfk);
                com.tencent.mm.sdk.b.a.urY.m(this.pUh);
            }
            f.a ek = f.a.ek(this.fTk.field_content);
            if (ek != null && "wx4310bbd51be7d979".equals(ek.appId)) {
                Object obj = (bg.mA(this.fTk.field_talker) || !this.fTk.field_talker.endsWith("@chatroom")) ? null : 1;
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(ek.description, "UTF-8");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", e, "", new Object[0]);
                }
                w.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", "1," + (obj != null ? 2 : 1) + ",," + str2);
                g.oUh.A(13717, r0);
            }
            if (this.sDV != null) {
                this.sDV.fCL.fCP = "msg_" + this.fTk.field_msgSvrId;
                com.tencent.mm.sdk.b.a.urY.m(this.sDV);
            }
            if (com_tencent_mm_protocal_c_axm.uae.tfV != null) {
                g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(com_tencent_mm_protocal_c_axm.uae.tfV.tZn));
            }
            this.gUD.a(i2, i3, str, this);
        } else {
            this.fTk.dv(5);
            c.oTb.a(111, 34, 1, true);
            ap.yY();
            com.tencent.mm.u.c.wT().a(this.fTk.field_msgId, this.fTk);
            w.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + i2 + "," + i3 + ", msgId " + this.fTk.field_msgId);
            if (i2 == 4) {
                g.oUh.i(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(0));
            }
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 222;
    }

    protected final int a(com.tencent.mm.network.p pVar) {
        return b.hsT;
    }
}
