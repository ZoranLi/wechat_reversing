package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bhb;
import com.tencent.mm.protocal.c.bhc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

public final class ak extends k implements j {
    public a fDa = null;
    public int fEX = 0;
    public String fFF;
    private b gUA;
    public e gUD;
    private boolean gVm = false;
    public int gVo = 0;
    public keep_SceneResult gVp;
    public c gVr = new c<ly>(this) {
        final /* synthetic */ ak sEe;

        {
            this.sEe = r2;
            this.usg = ly.class.getName().hashCode();
        }

        private boolean a(ly lyVar) {
            if (lyVar.fTe.filePath.equals(this.sEe.sDF.field_fileFullPath)) {
                String str = "";
                try {
                    str = URLEncoder.encode(lyVar.fTe.result, "UTF-8");
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", e, "", new Object[0]);
                }
                if (this.sEe.gVo == 1) {
                    ap.yY();
                    ce cA = com.tencent.mm.u.c.wT().cA(this.sEe.sDF.field_msgInfoId);
                    d dVar = new d();
                    dVar.n("20toUser", this.sEe.toUser + ",");
                    dVar.n("21source", "4,");
                    dVar.n("22qrUrl", str + ",");
                    dVar.n("23md5", (this.sEe.gVp == null ? "" : this.sEe.gVp.field_filemd5) + ",");
                    dVar.n("24cdnFileId", (this.sEe.gVp == null ? "" : this.sEe.gVp.field_fileId) + ",");
                    dVar.n("25cdnAesKey", (this.sEe.gVp == null ? "" : this.sEe.gVp.field_aesKey) + ",");
                    str = "";
                    if (cA.axO()) {
                        a ek = a.ek(cA.field_content);
                        if (ek != null) {
                            str = ek.appId;
                        }
                    }
                    dVar.n("26appip", str + ",");
                    dVar.n("2toUsersCount", com.tencent.mm.u.j.eC(this.sEe.toUser) + ",");
                    w.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + dVar.JG());
                    n.s(13628, dVar.toString());
                }
                com.tencent.mm.sdk.b.a.urY.c(this.sEe.gVr);
            }
            return false;
        }
    };
    private h.a hGH = new h.a(this) {
        final /* synthetic */ ak sEe;

        {
            this.sEe = r1;
        }

        public final int a(String str, final int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            String str2 = "MicroMsg.NetSceneUploadAppAttach";
            String str3 = "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
            Object[] objArr = new Object[7];
            objArr[0] = this.sEe.hGx;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
            objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
            objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo != null);
            objArr[5] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult != null);
            objArr[6] = Boolean.valueOf(z);
            w.d(str2, str3, objArr);
            an.abL().b(this.sEe.sDI, this.sEe.sDF);
            if (i == -21005) {
                w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.sEe.hGx);
                return 0;
            } else if (i != 0) {
                l.ee(this.sEe.sDF.uxb);
                an.abL().b(this.sEe.sDI, this.sEe.sDF);
                this.sEe.sDF.field_signature = "";
                r0 = an.abL().c(this.sEe.sDF, new String[0]);
                w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Long.valueOf(this.sEe.sDI), Boolean.valueOf(r0));
                this.sEe.gUD.a(3, i, "", this.sEe);
                g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.sEe.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "");
                return 0;
            } else if (this.sEe.sDF.field_status == 105) {
                w.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", Long.valueOf(this.sEe.sDF.field_status), Long.valueOf(this.sEe.sDI));
                com.tencent.mm.modelcdntran.g.El().iO(this.sEe.hGx);
                this.sEe.gUD.a(3, i, "attach  has paused, status" + this.sEe.sDF.field_status, this.sEe);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        l.ee(this.sEe.sDF.uxb);
                        an.abL().b(this.sEe.sDI, this.sEe.sDF);
                        this.sEe.sDF.field_signature = "";
                        r0 = an.abL().c(this.sEe.sDF, new String[0]);
                        w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(this.sEe.sDI), Boolean.valueOf(r0));
                        g.oUh.i(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.sEe.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        g.oUh.i(13937, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.sEe.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        this.sEe.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.sEe);
                    } else {
                        w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), bg.Qj(this.sEe.sDF.field_signature));
                        if (!z) {
                            a(i, com_tencent_mm_modelcdntran_keep_SceneResult);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck) {
                            ap.vd().a(new z(this.sEe.fDa, this.sEe.sDF.field_fileFullPath, this.sEe.toUser, new z.a(this) {
                                final /* synthetic */ AnonymousClass1 sEg;

                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z = true;
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = bg.Qj(str2);
                                    objArr[2] = bg.Qj(str3);
                                    objArr[3] = bg.Qj(str4);
                                    objArr[4] = bg.Qj(str5);
                                    if (this.sEg.sEe.fDa != null) {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(this.sEg.sEe.hGO);
                                    w.i(str6, str7, objArr);
                                    if (!bg.mA(str3)) {
                                        this.sEg.sEe.sDF.field_signature = str3;
                                        this.sEg.sEe.sDF.field_fakeAeskey = str4;
                                        this.sEg.sEe.sDF.field_fakeSignature = str5;
                                    }
                                    this.sEg.a(i, com_tencent_mm_modelcdntran_keep_SceneResult);
                                }
                            }), 0);
                        } else {
                            w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                            ap.vd().a(new z(null, this.sEe.sDF.field_fileFullPath, this.sEe.toUser, new z.a(this) {
                                final /* synthetic */ AnonymousClass1 sEg;

                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = bg.Qj(str2);
                                    objArr[2] = bg.Qj(str3);
                                    objArr[3] = bg.Qj(str4);
                                    objArr[4] = bg.Qj(str5);
                                    objArr[5] = Boolean.valueOf(this.sEg.sEe.fDa == null);
                                    objArr[6] = Boolean.valueOf(this.sEg.sEe.hGO);
                                    w.i(str6, str7, objArr);
                                    if (!bg.mA(str3)) {
                                        this.sEg.sEe.sDF.field_signature = str3;
                                        this.sEg.sEe.sDF.field_fakeAeskey = str4;
                                        this.sEg.sEe.sDF.field_fakeSignature = str5;
                                        this.sEg.sEe.sDF.field_lastModifyTime = bg.Nz();
                                        if (this.sEg.sEe.fDa != null) {
                                            this.sEg.sEe.fDa.filemd5 = str;
                                            this.sEg.sEe.fDa.hhE = str2;
                                            this.sEg.sEe.fDa.hhq = (int) j;
                                            ap.yY();
                                            au cA = com.tencent.mm.u.c.wT().cA(this.sEg.sEe.sDF.field_msgInfoId);
                                            cA.setContent(a.a(this.sEg.sEe.fDa, null, null));
                                            ap.yY();
                                            com.tencent.mm.u.c.wT().a(cA.field_msgId, cA);
                                        }
                                    }
                                    this.sEg.sEe.hGO = false;
                                    boolean c = an.abL().c(this.sEg.sEe.sDF, new String[0]);
                                    if (c) {
                                        ap.vL().D(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass2 sEh;

                                            {
                                                this.sEh = r1;
                                            }

                                            public final void run() {
                                                w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                                                this.sEh.sEg.sEe.a(this.sEh.sEg.sEe.hsD, this.sEh.sEg.sEe.gUD);
                                            }
                                        });
                                        return;
                                    }
                                    w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
                                    this.sEg.sEe.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                                    this.sEg.sEe.gUD.a(3, i, "", this.sEg.sEe);
                                }
                            }), 0);
                        }
                    }
                }
                return 0;
            } else if (this.sEe.sDF.field_offset > ((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)) {
                w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(this.sEe.sDF.field_offset), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                return 0;
            } else {
                this.sEe.sDF.field_lastModifyTime = bg.Ny();
                this.sEe.sDF.field_offset = (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                r0 = an.abL().c(this.sEe.sDF, new String[0]);
                if (r0) {
                    return 0;
                }
                w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + r0);
                this.sEe.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                this.sEe.gUD.a(3, i, "", this.sEe);
                return 0;
            }
        }

        public final void a(int i, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
            this.sEe.sDF.field_status = 199;
            boolean c = an.abL().c(this.sEe.sDF, new String[0]);
            if (c) {
                l.a(this.sEe.sDF.field_msgInfoId, this.sEe.sDF.field_mediaSvrId, com_tencent_mm_modelcdntran_keep_SceneResult);
                ap.vd().a(new ai(this.sEe.sDF.field_msgInfoId, true, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                    final /* synthetic */ AnonymousClass1 sEg;

                    public final void bb(int i, int i2) {
                        w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 4 && i2 == 102) {
                            ap.vL().D(new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 sEi;

                                {
                                    this.sEi = r1;
                                }

                                public final void run() {
                                    this.sEi.sEg.sEe.hGO = false;
                                    this.sEi.sEg.sEe.sDF.field_createTime = bg.Nz();
                                    this.sEi.sEg.sEe.sDF.field_lastModifyTime = bg.Ny();
                                    this.sEi.sEg.sEe.sDF.field_offset = 0;
                                    this.sEi.sEg.sEe.sDF.field_status = 101;
                                    boolean c = an.abL().c(this.sEi.sEg.sEe.sDF, new String[0]);
                                    w.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(this.sEi.sEg.sEe.hGO), Boolean.valueOf(c), Long.valueOf(this.sEi.sEg.sEe.sDF.field_createTime));
                                    this.sEi.sEg.sEe.a(this.sEi.sEg.sEe.hsD, this.sEi.sEg.sEe.gUD);
                                }
                            });
                            return;
                        }
                        g.oUh.i(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.sEg.sEe.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        if (i == 0 && i2 == 0) {
                            this.sEg.sEe.c(com_tencent_mm_modelcdntran_keep_SceneResult);
                        }
                        this.sEg.sEe.gUD.a(i, i2, "", this.sEg.sEe);
                    }
                }, this.sEe.fFF, this.sEe.sDF), 0);
                return;
            }
            w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
            this.sEe.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            this.sEe.gUD.a(3, i, "", this.sEe);
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    public boolean hGO = true;
    public String hGx = "";
    private String hhs = null;
    public b sDF = null;
    public long sDI = -1;
    private boolean sEc = true;
    private long sEd = -1;
    public long startTime = 0;
    public String toUser;

    public ak(long j, String str, String str2) {
        this.sDI = j;
        this.hhs = str;
        this.fFF = str2;
        b.a aVar = new b.a();
        aVar.hsm = new bhb();
        aVar.hsn = new bhc();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.hsl = 220;
        aVar.hso = MMGIFException.D_GIF_ERR_NO_IMAG_DSCR;
        aVar.hsp = 1000000105;
        this.gUA = aVar.BE();
        w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", Long.valueOf(j), str, bg.bJZ());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        this.sDF = new b();
        if (!an.abL().b(this.sDI, this.sDF) || this.sDF == null) {
            w.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sd() + " summerbig get info failed rowid:" + this.sDI);
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            this.sDF = null;
            return -1;
        } else if (this.sDF.field_status != 101) {
            w.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sd() + " summerbig get field_status failed rowid:" + this.sDI + " status:" + this.sDF.field_status);
            return -1;
        } else {
            Object obj;
            if (this.startTime == 0) {
                this.startTime = bg.Nz();
                this.sEd = this.sDF.field_offset;
            }
            w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", Long.valueOf(this.sDI), this.sDF.field_fileFullPath, Long.valueOf(this.sDF.field_totalLen), Boolean.valueOf(this.sDF.field_isUpload), Integer.valueOf(this.sDF.field_isUseCdn), Long.valueOf(this.sDF.field_type));
            if (bg.mA(this.sDF.field_appId)) {
                w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                if (!(this.sDF.field_type == 8 || this.sDF.field_type == 6)) {
                    this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                    return -1;
                }
            }
            if (this.sDF.field_type == 8 || this.sDF.field_type == 9) {
                w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", Long.valueOf(this.sDF.field_type));
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.El();
                if (com.tencent.mm.modelcdntran.c.fA(4) || this.sDF.field_isUseCdn == 1) {
                    ap.yY();
                    ce cA = com.tencent.mm.u.c.wT().cA(this.sDF.field_msgInfoId);
                    if (cA.field_msgId != this.sDF.field_msgInfoId) {
                        w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", Long.valueOf(this.sDF.field_msgInfoId), Long.valueOf(this.sDF.uxb), Long.valueOf(this.sDF.field_createTime), Long.valueOf(this.sDF.field_totalLen), Long.valueOf(this.sDF.field_status), Boolean.valueOf(this.sDF.field_isUpload), Integer.valueOf(this.sDF.field_isUseCdn), this.sDF.field_mediaId);
                        this.toUser = null;
                        obj = null;
                    } else {
                        this.toUser = cA.field_talker;
                        String str = "";
                        if (!bg.mA(cA.field_imgPath)) {
                            str = com.tencent.mm.ah.n.GS().ju(cA.field_imgPath);
                        }
                        int aN = com.tencent.mm.a.e.aN(str);
                        int aN2 = com.tencent.mm.a.e.aN(this.sDF.field_fileFullPath);
                        if (aN >= com.tencent.mm.modelcdntran.b.hya) {
                            w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(aN));
                            obj = null;
                        } else {
                            this.hGx = com.tencent.mm.modelcdntran.d.a("upattach", this.sDF.field_createTime, cA.field_talker, this.sDI);
                            w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", Long.valueOf(this.sDF.field_createTime), this.hGx);
                            if (bg.mA(this.hGx)) {
                                w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.sDI));
                                obj = null;
                            } else {
                                Object obj2;
                                h hVar = new h();
                                String str2 = cA.field_content;
                                if (o.dH(cA.field_talker)) {
                                    int gh = ay.gh(cA.field_content);
                                    if (gh != -1) {
                                        str2 = (cA.field_content + " ").substring(gh + 2).trim();
                                    }
                                }
                                this.fDa = a.ek(bg.PX(str2));
                                if (this.fDa != null) {
                                    w.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", this.fDa.hhx, bg.Qj(this.fDa.hhE), this.fDa.filemd5, Integer.valueOf(this.fDa.type));
                                    hVar.field_fileId = this.fDa.hhx;
                                    hVar.field_aesKey = this.fDa.hhE;
                                    hVar.field_filemd5 = this.fDa.filemd5;
                                    obj2 = (this.fDa.hhu != 0 || this.fDa.hhq > 26214400) ? 1 : null;
                                } else {
                                    w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                    obj2 = null;
                                }
                                hVar.hze = this.hGH;
                                hVar.field_mediaId = this.hGx;
                                hVar.field_fullpath = this.sDF.field_fileFullPath;
                                hVar.field_thumbpath = str;
                                hVar.field_fileType = obj2 != null ? com.tencent.mm.modelcdntran.b.hxN : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                                hVar.field_svr_signature = obj2 != null ? bg.mz(this.sDF.field_signature) : "";
                                hVar.field_onlycheckexist = obj2 != null ? bg.mA(this.sDF.field_signature) : false;
                                hVar.field_fake_bigfile_signature_aeskey = this.sDF.field_fakeAeskey;
                                hVar.field_fake_bigfile_signature = this.sDF.field_fakeSignature;
                                hVar.field_talker = cA.field_talker;
                                hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                                hVar.field_totalLen = aN2;
                                hVar.field_needStorage = false;
                                hVar.field_isStreamMedia = false;
                                hVar.field_enable_hitcheck = this.hGO;
                                hVar.field_chattype = o.dH(cA.field_talker) ? 1 : 0;
                                hVar.field_force_aeskeycdn = false;
                                hVar.field_trysafecdn = true;
                                w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", Long.valueOf(this.sDF.field_msgInfoId), hVar.field_fullpath, Integer.valueOf(aN2), str, Integer.valueOf(aN), this.hGx, Integer.valueOf(hVar.field_fileType), Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_onlycheckexist), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn), bg.Qj(hVar.field_aesKey), hVar.field_filemd5, bg.Qj(hVar.field_svr_signature), bg.Qj(hVar.field_fake_bigfile_signature_aeskey), bg.Qj(hVar.field_fake_bigfile_signature));
                                if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                                    if (this.sDF.field_isUseCdn != 1) {
                                        this.sDF.field_isUseCdn = 1;
                                        boolean c = an.abL().c(this.sDF, new String[0]);
                                        if (!c) {
                                            w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                                            this.gUD.a(3, -1, "", this);
                                            obj = null;
                                        }
                                    }
                                    w.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", this.hGx);
                                    obj = 1;
                                } else {
                                    w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.hGx = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                } else {
                    r2 = new Object[2];
                    com.tencent.mm.modelcdntran.g.El();
                    r2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(4));
                    r2[1] = Integer.valueOf(this.sDF.field_isUseCdn);
                    w.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", r2);
                    obj = null;
                }
            }
            if (obj != null) {
                w.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", Long.valueOf(this.sDI));
                return 0;
            } else if (this.sDF.field_netTimes > 3200) {
                l.ee(this.sDF.uxb);
                w.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.sd() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.sDI);
                return -1;
            } else {
                b bVar = this.sDF;
                bVar.field_netTimes++;
                if (bg.mA(this.sDF.field_clientAppDataId)) {
                    w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                    return -1;
                } else if (this.sDF.field_totalLen <= 0 || this.sDF.field_totalLen > 26214400) {
                    w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.sDF.field_totalLen);
                    this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                    if (this.sDF.field_totalLen > 26214400) {
                        l.ee(this.sDF.uxb);
                    }
                    return -1;
                } else if (bg.mA(this.sDF.field_fileFullPath)) {
                    w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                    return -1;
                } else if (com.tencent.mm.a.e.aN(this.sDF.field_fileFullPath) > 26214400) {
                    w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    l.ee(this.sDF.uxb);
                    return -1;
                } else {
                    byte[] d;
                    if (bg.mA(this.hhs)) {
                        d = com.tencent.mm.a.e.d(this.sDF.field_fileFullPath, (int) this.sDF.field_offset, 8192);
                    } else {
                        d = com.tencent.mm.a.e.d(this.sDF.field_fileFullPath, (int) this.sDF.field_offset, WXMediaMessage.THUMB_LENGTH_LIMIT);
                    }
                    if (bg.bm(d)) {
                        w.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                        return -1;
                    }
                    bhb com_tencent_mm_protocal_c_bhb = (bhb) this.gUA.hsj.hsr;
                    com_tencent_mm_protocal_c_bhb.mtb = this.sDF.field_appId;
                    com_tencent_mm_protocal_c_bhb.tfT = (int) this.sDF.field_sdkVer;
                    com_tencent_mm_protocal_c_bhb.ugK = this.sDF.field_clientAppDataId;
                    com_tencent_mm_protocal_c_bhb.jOc = (int) this.sDF.field_type;
                    com_tencent_mm_protocal_c_bhb.jNj = m.xL();
                    com_tencent_mm_protocal_c_bhb.tgJ = (int) this.sDF.field_totalLen;
                    com_tencent_mm_protocal_c_bhb.tgK = (int) this.sDF.field_offset;
                    if (this.hhs == null || !this.sEc) {
                        com_tencent_mm_protocal_c_bhb.tgL = d.length;
                        com_tencent_mm_protocal_c_bhb.tsk = new avw().bb(d);
                        if (this.hhs != null) {
                            com_tencent_mm_protocal_c_bhb.tuy = this.hhs;
                        }
                        return a(eVar, this.gUA, this);
                    }
                    com_tencent_mm_protocal_c_bhb.tuy = this.hhs;
                    com_tencent_mm_protocal_c_bhb.tgJ = (int) this.sDF.field_totalLen;
                    com_tencent_mm_protocal_c_bhb.tgL = 0;
                    com_tencent_mm_protocal_c_bhb.tsk = new avw().bb(new byte[0]);
                    this.sEc = false;
                    return a(eVar, this.gUA, this);
                }
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bg.mA(this.hGx)) {
            w.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hGx);
        } else if (i2 == 0 && i3 == 0) {
            bhc com_tencent_mm_protocal_c_bhc = (bhc) ((b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_bhc.mtb != null && this.hhs == null && (!com_tencent_mm_protocal_c_bhc.mtb.equals(this.sDF.field_appId) || !com_tencent_mm_protocal_c_bhc.ugK.equals(this.sDF.field_clientAppDataId))) {
                w.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                this.gUD.a(3, -1, "", this);
            } else if (com_tencent_mm_protocal_c_bhc.tgJ < 0 || ((long) com_tencent_mm_protocal_c_bhc.tgJ) != this.sDF.field_totalLen || com_tencent_mm_protocal_c_bhc.tgK < 0 || ((long) com_tencent_mm_protocal_c_bhc.tgK) > this.sDF.field_totalLen) {
                w.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                this.gUD.a(3, -1, "", this);
            } else {
                this.sDF.field_offset = (long) com_tencent_mm_protocal_c_bhc.tgK;
                this.sDF.field_mediaSvrId = l.Mf(com_tencent_mm_protocal_c_bhc.ttW) ? com_tencent_mm_protocal_c_bhc.ttW : "";
                if (this.sDF.field_status == 105) {
                    w.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.sDF.field_mediaSvrId + "," + this.sDF.field_offset + "] ");
                    this.gUD.a(i2, -1, "", this);
                    return;
                }
                if (this.sDF.field_offset == this.sDF.field_totalLen) {
                    if (bg.mA(this.sDF.field_mediaSvrId)) {
                        w.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                        this.gUD.a(3, -1, "", this);
                        l.ee(this.sDF.uxb);
                        return;
                    }
                    this.sDF.field_status = 199;
                    g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sDF.field_totalLen - this.sEd));
                }
                boolean c = an.abL().c(this.sDF, new String[0]);
                if (!c) {
                    w.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:" + c);
                    this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                    c(null);
                    this.gUD.a(3, -1, "", this);
                } else if (this.sDF.field_status == 199) {
                    this.gUD.a(0, 0, "", this);
                } else if (a(this.hsD, this.gUD) < 0) {
                    w.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                    this.gUD.a(3, -1, "", this);
                }
            }
        } else {
            w.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            if (i2 == 4) {
                g.oUh.i(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sDF.field_totalLen - this.sEd));
            }
            this.gUD.a(i2, i3, str, this);
        }
    }

    protected final int ub() {
        return 3200;
    }

    public final int getType() {
        return 220;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final void c(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.sDF.field_type == 2) {
            com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100131");
            if (dX.isValid()) {
                this.gVo = u.getInt((String) dX.bKK().get("needUploadData"), 1);
            }
            if (!this.gVm && this.gVo != 0) {
                this.gVp = com_tencent_mm_modelcdntran_keep_SceneResult;
                this.gVm = true;
                com.tencent.mm.sdk.b.b lwVar = new lw();
                com.tencent.mm.sdk.b.a.urY.b(this.gVr);
                lwVar.fTb.filePath = this.sDF.field_fileFullPath;
                com.tencent.mm.sdk.b.a.urY.m(lwVar);
            }
        }
    }
}
