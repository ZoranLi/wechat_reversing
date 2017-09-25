package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class ab extends k implements j {
    int fEX;
    public long fGM;
    public au fTk;
    private b gUA;
    public e gUD;
    private com.tencent.mm.modelcdntran.h.a hGH;
    public f hGt;
    public String hGx;
    private long jFH;
    public String mediaId;
    public b sDF;
    long sDI;
    private int sDJ;
    public String sDK;
    public boolean sDL;
    private boolean sDM;
    private boolean sDN;
    public long startTime;
    private int type;

    public interface a {
        void bDg();
    }

    public ab(String str) {
        this(str, null, 0);
    }

    public ab(long j, String str, f fVar) {
        this(str, fVar, 0);
        this.fGM = j;
    }

    public ab(long j, long j2, f fVar) {
        this.sDF = null;
        this.sDI = -1;
        this.mediaId = "";
        this.fGM = 0;
        this.fTk = null;
        this.hGx = "";
        this.startTime = 0;
        this.sDJ = -1;
        this.sDK = "";
        this.type = 0;
        this.fEX = 0;
        this.sDL = false;
        this.sDM = false;
        this.jFH = 0;
        this.sDN = false;
        this.hGH = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ ab sDO;

            {
                this.sDO = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                String str2 = "MicroMsg.NetSceneDownloadAppAttach";
                String str3 = "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo;
                objArr[3] = com_tencent_mm_modelcdntran_keep_SceneResult;
                objArr[4] = Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo == null);
                w.d(str2, str3, objArr);
                if (i == -21006) {
                    w.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", this.sDO.hGx);
                    return 0;
                } else if (i != 0) {
                    l.ee(this.sDO.sDF.uxb);
                    g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.sDO.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "");
                    this.sDO.gUD.a(3, i, "", this.sDO);
                    return 0;
                } else {
                    this.sDO.sDF = an.abL().eb(this.sDO.fGM);
                    if (this.sDO.sDF == null) {
                        w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                        this.sDO.gUD.a(3, i, "", this.sDO);
                        return 0;
                    } else if (this.sDO.sDF.field_status == 102) {
                        w.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(this.sDO.sDF.field_status));
                        com.tencent.mm.modelcdntran.g.El().iO(this.sDO.hGx);
                        this.sDO.gUD.a(3, i, "attach  has paused, status=" + this.sDO.sDF.field_status, this.sDO);
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                l.ee(this.sDO.sDF.uxb);
                                w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode));
                                this.sDO.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.sDO);
                            } else {
                                new File(this.sDO.sDK).renameTo(new File(this.sDO.sDF.field_fileFullPath));
                                this.sDO.sDF.field_status = 199;
                                this.sDO.sDF.field_offset = this.sDO.sDF.field_totalLen;
                                an.abL().c(this.sDO.sDF, new String[0]);
                                g.oUh.a(198, 45, this.sDO.sDF.field_totalLen, false);
                                g.oUh.a(198, 46, 1, false);
                                g.oUh.a(198, o.dH(this.sDO.fTk == null ? "" : this.sDO.fTk.field_talker) ? 48 : 47, 1, false);
                                ap.yY();
                                au cA = c.wT().cA(this.sDO.sDF.field_msgInfoId);
                                if (cA.field_status == 5) {
                                    cA.dv(3);
                                    ap.yY();
                                    c.wT().a(cA.field_msgId, cA);
                                }
                                this.sDO.gUD.a(0, 0, "", this.sDO);
                            }
                            g.oUh.i(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.sDO.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sDO.sDF.field_totalLen), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                g.oUh.i(13937, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.sDO.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sDO.sDF.field_totalLen), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            }
                            if (this.sDO.hGt != null) {
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 sDP;

                                    {
                                        this.sDP = r1;
                                    }

                                    public final void run() {
                                        this.sDP.sDO.hGt.a((int) this.sDP.sDO.sDF.field_offset, (int) this.sDP.sDO.sDF.field_totalLen, this.sDP.sDO);
                                    }
                                });
                            }
                        }
                        return 0;
                    } else if (((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) == this.sDO.sDF.field_totalLen) {
                        w.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                        return 0;
                    } else if (this.sDO.sDF.field_offset > ((long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)) {
                        w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(this.sDO.sDF.field_offset), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                        l.ee(this.sDO.sDF.uxb);
                        this.sDO.gUD.a(3, i, "", this.sDO);
                        return 0;
                    } else {
                        this.sDO.sDF.field_offset = (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                        an.abL().c(this.sDO.sDF, new String[0]);
                        if (this.sDO.hGt != null) {
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 sDP;

                                {
                                    this.sDP = r1;
                                }

                                public final void run() {
                                    this.sDP.sDO.hGt.a((int) this.sDP.sDO.sDF.field_offset, (int) this.sDP.sDO.sDF.field_totalLen, this.sDP.sDO);
                                }
                            });
                        }
                        w.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", this.sDO.hGx, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength));
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] i(String str, byte[] bArr) {
                return null;
            }
        };
        this.jFH = j2;
        this.fGM = j;
        this.sDF = an.abL().eb(j);
        this.hGt = fVar;
        this.sDM = true;
        if (this.sDF == null) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId" + j, Long.valueOf(j2));
            return;
        }
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new oj();
        aVar.hsn = new ok();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hsl = 221;
        aVar.hso = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        aVar.hsp = 1000000106;
        this.gUA = aVar.BE();
    }

    public ab(b bVar) {
        this.sDF = null;
        this.sDI = -1;
        this.mediaId = "";
        this.fGM = 0;
        this.fTk = null;
        this.hGx = "";
        this.startTime = 0;
        this.sDJ = -1;
        this.sDK = "";
        this.type = 0;
        this.fEX = 0;
        this.sDL = false;
        this.sDM = false;
        this.jFH = 0;
        this.sDN = false;
        this.hGH = /* anonymous class already generated */;
        this.sDF = bVar;
        this.sDL = true;
        this.mediaId = this.sDF.field_mediaId;
        this.hGt = null;
        this.type = 0;
        if (bVar == null) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
            return;
        }
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new oj();
        aVar.hsn = new ok();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hsl = 221;
        aVar.hso = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        aVar.hsp = 1000000106;
        this.gUA = aVar.BE();
        w.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", bVar.field_fileFullPath, Boolean.valueOf(true), bg.bJZ());
    }

    public ab(String str, f fVar, int i) {
        this.sDF = null;
        this.sDI = -1;
        this.mediaId = "";
        this.fGM = 0;
        this.fTk = null;
        this.hGx = "";
        this.startTime = 0;
        this.sDJ = -1;
        this.sDK = "";
        this.type = 0;
        this.fEX = 0;
        this.sDL = false;
        this.sDM = false;
        this.jFH = 0;
        this.sDN = false;
        this.hGH = /* anonymous class already generated */;
        this.mediaId = str;
        this.hGt = fVar;
        this.type = i;
        this.sDF = an.abL().LW(str);
        if (this.sDF == null) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + str);
            return;
        }
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new oj();
        aVar.hsn = new ok();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hsl = 221;
        aVar.hso = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        aVar.hsp = 1000000106;
        this.gUA = aVar.BE();
        w.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", Integer.valueOf(i), this.sDF.field_fileFullPath, Long.valueOf(this.sDF.field_type), this.sDF.field_signature, bg.bJZ());
    }

    public final void bDf() {
        this.sDN = true;
        if (this.sDN) {
            com.tencent.mm.a.e.e(this.sDF.field_fileFullPath, "#!AMR\n".getBytes());
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (this.sDF == null) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.sd() + " get info failed mediaId:" + this.mediaId);
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            return -1;
        }
        ap.yY();
        this.fTk = c.wT().cA(this.fGM);
        if (this.fTk == null || this.fTk.field_msgId != this.fGM) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.sd() + " get msginfo failed mediaId:%s  msgId:%d", this.mediaId, Long.valueOf(this.fGM));
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = bg.Nz();
            this.sDJ = (int) this.sDF.field_offset;
        }
        if (this.jFH != 0) {
            oj ojVar = (oj) this.gUA.hsj.hsr;
            ojVar.jNj = m.xL();
            ojVar.tgJ = (int) this.sDF.field_totalLen;
            ojVar.tgK = (int) this.sDF.field_offset;
            ojVar.tgL = 0;
            ojVar.jOc = 40;
            ojVar.tfk = this.jFH;
            return a(eVar, this.gUA, this);
        }
        Object obj;
        String str = this.fTk.field_content;
        if (o.dH(this.fTk.field_talker)) {
            int gh = ay.gh(this.fTk.field_content);
            if (gh != -1) {
                str = (this.fTk.field_content + " ").substring(gh + 2).trim();
            }
        }
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(bg.PX(str));
        if (ek == null) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", this.mediaId);
            obj = null;
        } else {
            w.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", Long.valueOf(this.fGM), Long.valueOf(this.sDF.field_totalLen), this.sDF.field_fileFullPath, ek.hhx, bg.Qj(ek.hhE));
            if (bg.mA(ek.hhx) || bg.mA(ek.hhE)) {
                w.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", Long.valueOf(this.fGM), ek.hhx, bg.Qj(ek.hhE));
                obj = null;
            } else {
                this.hGx = d.a("downattach", this.sDF.field_createTime, this.fTk.field_talker, this.sDI);
                if (bg.mA(this.hGx)) {
                    w.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.sDI));
                    obj = null;
                } else {
                    com.tencent.mm.a.e.aU(this.sDF.field_fileFullPath);
                    this.sDK = this.sDF.field_fileFullPath + "_tmp";
                    h hVar = new h();
                    hVar.field_mediaId = this.hGx;
                    hVar.field_fullpath = this.sDK;
                    int i = (ek.hhu != 0 || ek.hhq > 26214400) ? com.tencent.mm.modelcdntran.b.hxN : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                    hVar.field_fileType = i;
                    hVar.field_totalLen = (int) this.sDF.field_totalLen;
                    hVar.field_aesKey = ek.hhE;
                    hVar.field_fileId = ek.hhx;
                    hVar.field_svr_signature = this.sDF.field_signature;
                    hVar.field_fake_bigfile_signature_aeskey = this.sDF.field_fakeAeskey;
                    hVar.field_fake_bigfile_signature = this.sDF.field_fakeSignature;
                    hVar.field_onlycheckexist = false;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                    hVar.hze = this.hGH;
                    hVar.field_chattype = o.dH(this.fTk.field_talker) ? 1 : 0;
                    w.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", Integer.valueOf(hVar.field_fileType), hVar.field_fullpath, bg.Qj(hVar.field_aesKey), bg.Qj(hVar.field_svr_signature), bg.Qj(hVar.field_fake_bigfile_signature_aeskey), bg.Qj(hVar.field_fake_bigfile_signature), Boolean.valueOf(hVar.field_onlycheckexist));
                    if (com.tencent.mm.modelcdntran.g.El().b(hVar, -1)) {
                        if (this.sDF.field_isUseCdn != 1) {
                            this.sDF.field_isUseCdn = 1;
                            boolean c = an.abL().c(this.sDF, new String[0]);
                            if (!c) {
                                w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                                this.gUD.a(3, -1, "", this);
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        w.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.hGx = "";
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            w.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", this.mediaId);
            return 0;
        }
        if (this.sDF.field_status == 102) {
            this.sDF.field_status = 101;
            if (!this.sDL) {
                an.abL().c(this.sDF, new String[0]);
            }
        }
        this.sDI = this.sDF.uxb;
        if (bg.mA(this.sDF.field_mediaSvrId) && this.jFH == 0) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            return -1;
        } else if (this.sDF.field_totalLen <= 0 || this.sDF.field_totalLen > 26214400) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.sDF.field_totalLen);
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            return -1;
        } else if (bg.mA(this.sDF.field_fileFullPath) && this.jFH == 0) {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            return -1;
        } else {
            i = com.tencent.mm.a.e.aN(this.sDF.field_fileFullPath);
            if (this.sDN) {
                i -= 6;
                if (i <= 0) {
                    i = 0;
                }
            }
            if (((long) i) != this.sDF.field_offset) {
                w.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.sDF.field_offset);
                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                return -1;
            }
            w.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", this.sDF.field_appId, this.sDF.field_mediaSvrId, Long.valueOf(this.sDF.field_sdkVer));
            ojVar = (oj) this.gUA.hsj.hsr;
            ojVar.mtb = this.sDF.field_appId;
            ojVar.ttW = this.sDF.field_mediaSvrId;
            ojVar.tfT = (int) this.sDF.field_sdkVer;
            ojVar.jNj = m.xL();
            ojVar.tgJ = (int) this.sDF.field_totalLen;
            ojVar.tgK = (int) this.sDF.field_offset;
            ojVar.tgL = 0;
            if (this.jFH != 0) {
                ojVar.tfk = this.jFH;
            }
            if (this.type != 0) {
                ojVar.jOc = this.type;
            } else {
                ojVar.jOc = (int) this.sDF.field_type;
            }
            return a(eVar, this.gUA, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bg.mA(this.hGx)) {
            w.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hGx);
        } else if (i2 == 0 && i3 == 0) {
            ok okVar = (ok) ((b) pVar).hsk.hsr;
            this.sDF.field_totalLen = (long) okVar.tgJ;
            if (okVar.ttW != null && !okVar.ttW.equals(this.sDF.field_mediaSvrId)) {
                w.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                this.gUD.a(3, -1, "", this);
            } else if (((long) okVar.tgK) != this.sDF.field_offset) {
                w.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + okVar.tgK);
                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                this.gUD.a(3, -1, "", this);
            } else if (((long) okVar.tgL) + this.sDF.field_offset > this.sDF.field_totalLen) {
                w.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + okVar.tgL + " off:" + this.sDF.field_offset + " total?:" + this.sDF.field_totalLen);
                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                this.gUD.a(3, -1, "", this);
            } else {
                byte[] a = n.a(okVar.tsk);
                if (a == null || a.length == 0 || a.length != okVar.tgL) {
                    w.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                    this.gUD.a(3, -1, "", this);
                    return;
                }
                String str2 = new String(a);
                w.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", Boolean.valueOf(this.sDM));
                if (this.sDF.field_offset < this.sDF.field_totalLen && this.sDM) {
                    ap.yY();
                    au cA = c.wT().cA(this.sDF.field_msgInfoId);
                    StringBuffer stringBuffer;
                    if (!str2.startsWith("<appmsg")) {
                        if (!cA.field_content.startsWith("<msg>")) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(cA.field_content).append(str2);
                            this.sDF.field_fullXml = stringBuffer.toString();
                        }
                        if (str2.endsWith("</appmsg>") || this.sDF.field_offset + ((long) a.length) == this.sDF.field_totalLen) {
                            if (o.dH(cA.field_talker)) {
                                String[] split = cA.field_content.split("\n", 2);
                                String str3 = split[0];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(str3).append("\n<msg>").append(split[1]).append(str2).append("</msg>");
                                this.sDF.field_fullXml = stringBuffer2.toString();
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append("<msg>").append(this.sDF.field_fullXml).append("</msg>");
                                this.sDF.field_fullXml = stringBuffer.toString();
                            }
                        }
                    } else if (!o.dH(cA.field_talker)) {
                        this.sDF.field_fullXml = str2;
                    } else if (!bg.mA(cA.field_content)) {
                        String str4 = cA.field_content.split("\n", 2)[0];
                        this.sDF.field_fullXml = new StringBuffer().append(str4).append("\n").toString();
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(this.sDF.field_fullXml).append(str2);
                        this.sDF.field_fullXml = stringBuffer.toString();
                    }
                    cA.setContent(this.sDF.field_fullXml);
                    ap.yY();
                    c.wT().a(this.sDF.field_msgInfoId, cA);
                    w.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", str2);
                }
                int e = com.tencent.mm.a.e.e(this.sDF.field_fileFullPath, a);
                if (bg.mA(this.sDF.field_fileFullPath) || e == 0) {
                    b bVar = this.sDF;
                    bVar.field_offset += (long) a.length;
                    if (this.sDF.field_offset == this.sDF.field_totalLen) {
                        this.sDF.field_status = 199;
                    }
                    if (this.hGt != null) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ ab sDO;

                            {
                                this.sDO = r1;
                            }

                            public final void run() {
                                this.sDO.hGt.a((int) this.sDO.sDF.field_offset, (int) this.sDO.sDF.field_totalLen, this.sDO);
                            }
                        });
                    }
                    if (!(this.sDL ? true : an.abL().c(this.sDF, new String[0]))) {
                        w.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:" + e);
                        this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                        this.gUD.a(3, -1, "", this);
                        return;
                    } else if (this.sDF.field_status == 199) {
                        g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.sDF.field_totalLen - ((long) this.sDJ)));
                        this.gUD.a(0, 0, "", this);
                        return;
                    } else if (this.sDF.field_status == 102) {
                        this.gUD.a(3, -1, "", this);
                        this.fEX = -20102;
                        return;
                    } else if (a(this.hsD, this.gUD) < 0) {
                        w.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                        this.gUD.a(3, -1, "", this);
                        return;
                    } else {
                        return;
                    }
                }
                w.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:" + e);
                this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
                this.gUD.a(3, -1, "", this);
            }
        } else {
            w.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.fEX = -10000 - com.tencent.mm.compatible.util.g.sb();
            if (i2 == 4) {
                g.oUh.i(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(com.tencent.mm.sdk.platformtools.ab.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0));
            }
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 221;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 400;
    }

    public final String getMediaId() {
        if (this.sDF == null) {
            return "";
        }
        return this.sDF.field_mediaSvrId;
    }
}
