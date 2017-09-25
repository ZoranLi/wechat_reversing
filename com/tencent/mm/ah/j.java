package com.tencent.mm.ah;

import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.protocal.c.zm;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.j {
    public String TAG;
    public au fCZ;
    private long fGM;
    private final b gUA;
    public e gUD;
    public long gVi;
    private int hFc;
    public String hGA;
    int hGB;
    public boolean hGC;
    private int hGD;
    private String hGE;
    private int hGF;
    public boolean hGG;
    private a hGH;
    public final f hGt;
    public final long hGu;
    private int hGv;
    private g hGw;
    public String hGx;
    public int hGy;
    private String hGz;
    public int hrs;
    private int startOffset;
    public long startTime;
    private int token;

    public j(long j, long j2, int i, f fVar) {
        this(j, j2, i, fVar, -1);
    }

    public j(long j, long j2, int i, final f fVar, int i2) {
        d b;
        this.TAG = "MicroMsg.NetSceneGetMsgImg";
        this.hGw = null;
        this.fGM = -1;
        this.fCZ = null;
        this.hGx = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hGy = 0;
        this.hGz = "";
        this.hGA = "";
        this.hrs = 0;
        this.hGB = -1;
        this.hGC = false;
        this.hGD = -1;
        this.hGE = null;
        this.hGF = 0;
        this.token = -1;
        this.hGG = false;
        this.hGH = new a(this) {
            final /* synthetic */ j hGK;

            {
                this.hGK = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21006) {
                    w.i(this.hGK.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", this.hGK.hGx);
                    return 0;
                } else if (i != 0) {
                    h.fX((int) this.hGK.hGu);
                    h.fW((int) this.hGK.hGu);
                    r1 = com.tencent.mm.plugin.report.service.g.oUh;
                    r3 = new Object[16];
                    r3[0] = Integer.valueOf(i);
                    r3[1] = Integer.valueOf(2);
                    r3[2] = Long.valueOf(this.hGK.startTime);
                    r3[3] = Long.valueOf(bg.Nz());
                    r3[4] = Integer.valueOf(d.aU(ab.getContext()));
                    r3[5] = Integer.valueOf(this.hGK.hGy);
                    r3[6] = Integer.valueOf(this.hGK.hrs);
                    r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                    r3[8] = "";
                    r3[9] = "";
                    r3[10] = "";
                    r3[11] = "";
                    r3[12] = "";
                    r3[13] = "";
                    r3[14] = "";
                    r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                    r1.i(10421, r3);
                    r1 = com.tencent.mm.plugin.report.service.g.oUh;
                    r3 = new Object[16];
                    r3[0] = Integer.valueOf(i);
                    r3[1] = Integer.valueOf(2);
                    r3[2] = Long.valueOf(this.hGK.startTime);
                    r3[3] = Long.valueOf(bg.Nz());
                    r3[4] = Integer.valueOf(d.aU(ab.getContext()));
                    r3[5] = Integer.valueOf(this.hGK.hGy);
                    r3[6] = Integer.valueOf(this.hGK.hrs);
                    r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                    r3[8] = "";
                    r3[9] = "";
                    r3[10] = "";
                    r3[11] = "";
                    r3[12] = "";
                    r3[13] = "";
                    r3[14] = "";
                    r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                    r1.i(13937, r3);
                    this.hGK.gUD.a(3, i, "", this.hGK);
                    return 0;
                } else {
                    d b = n.GS().b(Long.valueOf(this.hGK.gVi));
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                h.fW((int) this.hGK.hGu);
                                w.e(this.hGK.TAG, "cdntra sceneResult.retCode :%d", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode));
                                this.hGK.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hGK);
                            } else {
                                w.i(this.hGK.TAG, "cdntra getimg ok. need convert:%b", Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline));
                                if (b.hFc == 1) {
                                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 26, (long) b.hrs, false);
                                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 27, 1, false);
                                    com.tencent.mm.plugin.report.service.g.oUh.a(198, o.dH(this.hGK.fCZ != null ? this.hGK.fCZ.field_talker : "") ? 29 : 28, 1, false);
                                } else {
                                    long j;
                                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 21, (long) b.hrs, false);
                                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 22, 1, false);
                                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                    if (o.dH(this.hGK.fCZ != null ? this.hGK.fCZ.field_talker : "")) {
                                        j = 24;
                                    } else {
                                        j = 23;
                                    }
                                    gVar.a(198, j, 1, false);
                                }
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline) {
                                    w.i(this.hGK.TAG, "cdntra need convert2baseline. file:%s", this.hGK.hGA);
                                    boolean Convert2Baseline = MMNativeJpeg.Convert2Baseline(this.hGK.hGA, 60);
                                    w.i(this.hGK.TAG, "convert result:%b", Boolean.valueOf(Convert2Baseline));
                                }
                                if (this.hGK.hGG) {
                                    this.hGK.a(b, b.offset, b.offset, 0, null);
                                } else {
                                    this.hGK.a(b, this.hGK.hrs, b.offset, this.hGK.hrs - b.offset, null);
                                }
                            }
                            r1 = com.tencent.mm.plugin.report.service.g.oUh;
                            r3 = new Object[16];
                            r3[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                            r3[1] = Integer.valueOf(2);
                            r3[2] = Long.valueOf(this.hGK.startTime);
                            r3[3] = Long.valueOf(bg.Nz());
                            r3[4] = Integer.valueOf(d.aU(ab.getContext()));
                            r3[5] = Integer.valueOf(this.hGK.hGy);
                            r3[6] = Integer.valueOf(this.hGK.hrs);
                            r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                            r3[8] = "";
                            r3[9] = "";
                            r3[10] = "";
                            r3[11] = "";
                            r3[12] = "";
                            r3[13] = "";
                            r3[14] = "";
                            r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                            r1.i(10421, r3);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                r1 = com.tencent.mm.plugin.report.service.g.oUh;
                                r3 = new Object[16];
                                r3[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                r3[1] = Integer.valueOf(2);
                                r3[2] = Long.valueOf(this.hGK.startTime);
                                r3[3] = Long.valueOf(bg.Nz());
                                r3[4] = Integer.valueOf(d.aU(ab.getContext()));
                                r3[5] = Integer.valueOf(this.hGK.hGy);
                                r3[6] = Integer.valueOf(this.hGK.hrs);
                                r3[7] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                r3[8] = "";
                                r3[9] = "";
                                r3[10] = "";
                                r3[11] = "";
                                r3[12] = "";
                                r3[13] = "";
                                r3[14] = "";
                                r3[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2;
                                r1.i(13937, r3);
                            }
                        }
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == this.hGK.hrs) {
                        w.d(this.hGK.TAG, "cdntra ignore progress 100%");
                        return 0;
                    } else {
                        this.hGK.hGG = true;
                        if (!this.hGK.hGC) {
                            this.hGK.hGC = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify;
                        }
                        w.i(this.hGK.TAG, "cdntra progresscallback id:%s finish:%d total:%d,  canshowProgressimg:%b", this.hGK.hGx, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Boolean.valueOf(this.hGK.hGC));
                        this.hGK.a(b, this.hGK.hrs, b.offset, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength - b.offset, null);
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
        boolean z = j >= 0 && j2 >= 0 && fVar != null;
        Assert.assertTrue(z);
        this.hGt = fVar;
        this.hFc = i;
        this.hGu = j;
        this.gVi = j;
        this.fGM = j2;
        this.hGD = i2;
        d b2 = n.GS().b(Long.valueOf(this.gVi));
        if (i == 1) {
            this.gVi = (long) b2.hFi;
            b = n.GS().b(Long.valueOf(this.gVi));
        } else {
            b = b2;
        }
        this.TAG += "[" + this.gVi + "]";
        b.a aVar = new b.a();
        aVar.hsm = new zl();
        aVar.hsn = new zm();
        aVar.uri = "/cgi-bin/micromsg-bin/getmsgimg";
        aVar.hsl = MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
        aVar.hso = 10;
        aVar.hsp = 1000000010;
        this.gUA = aVar.BE();
        zl zlVar = (zl) this.gUA.hsj.hsr;
        this.fCZ = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().cA(j2);
        zlVar.tgK = b.offset;
        zlVar.tgJ = b.hrs;
        w.d(this.TAG, "cdntra offset:%d total:%d stack:[%s]", Integer.valueOf(b.offset), Integer.valueOf(b.hrs), bg.bJZ());
        zlVar.tfk = this.fCZ.field_msgSvrId;
        zlVar.tfd = new avx().OV(this.fCZ.field_talker);
        zlVar.tfe = new avx().OV((String) com.tencent.mm.kernel.h.vI().vr().get(2, null));
        zlVar.tFO = i;
        if (b.offset == 0) {
            this.hGw = new g(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM, false, (long) b.hrs);
        }
        this.hGv = 8192;
        if (fVar != null) {
            final int i3 = b.offset;
            final int i4 = b.hrs;
            af.v(new Runnable(this) {
                final /* synthetic */ j hGK;

                public final void run() {
                    fVar.a(i3, i4, this.hGK);
                }
            });
        }
    }

    protected final int ub() {
        if (this.hFc == 0) {
            return 100;
        }
        return 1280;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void cancel() {
        if (!(bg.mA(this.hGx) || com.tencent.mm.modelcdntran.g.El() == null)) {
            w.d(this.TAG, "cancel recv task");
            com.tencent.mm.modelcdntran.g.El().iP(this.hGx);
        }
        super.cancel();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        zl zlVar = (zl) this.gUA.hsj.hsr;
        d b = n.GS().b(Long.valueOf(this.gVi));
        if (b.hEY == 0) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 195, 1, false);
            w.e(this.TAG, "doScene id:%d  img:%s", Long.valueOf(this.gVi), b);
            return -1;
        } else if (b.status != 0) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 194, 1, false);
            w.e(this.TAG, "doSceneError, id:%d, status:%d", Long.valueOf(b.hEY), Integer.valueOf(b.status));
            return -1;
        } else {
            Object obj;
            if (b.hEZ.startsWith("SERVERID://")) {
                this.hGz = com.tencent.mm.a.g.n(b.hEZ.getBytes());
                this.hGA = n.GS().m(this.hGz, null, ".temp");
                b.jo(this.hGz + ".temp");
                n.GS().a(Long.valueOf(this.gVi), b);
            } else {
                this.hGz = b.hEZ;
                this.hGA = n.GS().m(this.hGz, null, "");
            }
            w.i(this.TAG, "doscene id:%d comp:%d off:%d total:%d name:%s tmp:%s full:%s", Long.valueOf(b.hEY), Integer.valueOf(this.hFc), Integer.valueOf(b.offset), Integer.valueOf(b.hrs), r4, this.hGz, this.hGA);
            if (this.startTime == 0) {
                this.startTime = bg.Nz();
                this.startOffset = b.offset;
                this.hGy = this.hFc == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            String str = zlVar.tfd.tZr;
            long j = zlVar.tfk;
            if (bg.mA(b.hFj)) {
                obj = null;
            } else {
                Map q = bh.q(b.hFj, "msg");
                if (q == null) {
                    w.e(this.TAG, "parse cdnInfo failed. [%s]", b.hFj);
                    obj = null;
                } else {
                    String str2;
                    this.hrs = 0;
                    if (this.hFc != 1) {
                        str = (String) q.get(".msg.img.$cdnmidimgurl");
                        this.hrs = bg.getInt((String) q.get(".msg.img.$length"), 0);
                        str2 = str;
                    } else {
                        str = (String) q.get(".msg.img.$cdnbigimgurl");
                        this.hrs = bg.getInt((String) q.get(".msg.img.$hdlength"), 0);
                        str2 = str;
                    }
                    w.d(this.TAG, "cdntra read xml  comptype:%d totallen:%d url:[%s]", Integer.valueOf(this.hFc), Integer.valueOf(this.hrs), str2);
                    if (bg.mA(str2)) {
                        w.e(this.TAG, "cdntra get cdnUrlfailed.");
                        obj = null;
                    } else {
                        str = (String) q.get(".msg.img.$aeskey");
                        if (bg.mA(str)) {
                            w.e(this.TAG, "cdntra get aes key failed.");
                            obj = null;
                        } else {
                            this.hGx = d.a("downimg", (long) b.hFf, this.fCZ.field_talker, this.fCZ.field_msgId);
                            if (bg.mA(this.hGx)) {
                                w.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.gVi));
                                obj = null;
                            } else {
                                String str3 = (String) q.get(".msg.img.$md5");
                                if (!bg.mA(str3) && (bg.mA((String) q.get(".msg.img.$cdnbigimgurl")) || this.hFc == 1)) {
                                    com.tencent.mm.plugin.n.a.aDu();
                                    String cH = com.tencent.mm.plugin.n.a.wY().cH(str3, this.hrs);
                                    int aN = com.tencent.mm.a.e.aN(cH);
                                    int i = this.hrs - aN;
                                    String str4 = this.TAG;
                                    String str5 = "MediaCheckDuplicationStorage: totallen:%s md5:%s big:%s NOcompress:%s  dup(len:%d path:%s) diffLen:%d to:%s";
                                    Integer[] numArr = new Object[8];
                                    numArr[0] = Integer.valueOf(this.hrs);
                                    numArr[1] = str3;
                                    numArr[2] = q.get(".msg.img.$cdnbigimgurl");
                                    numArr[3] = Boolean.valueOf(this.hFc == 1);
                                    numArr[4] = Integer.valueOf(aN);
                                    numArr[5] = cH;
                                    numArr[6] = Integer.valueOf(i);
                                    numArr[7] = this.hGA;
                                    w.i(str4, str5, numArr);
                                    if (bg.mA(cH)) {
                                        this.hGE = str3;
                                        this.hGF = this.hrs;
                                    } else if (i >= 0 && i <= 16) {
                                        boolean ex = com.tencent.mm.sdk.platformtools.j.ex(cH, this.hGA);
                                        w.i(this.TAG, "MediaCheckDuplicationStorage copy dup file now :%s -> %s [%b]", cH, this.hGA, Boolean.valueOf(ex));
                                        a(b, this.hrs, this.hrs, 0, null);
                                        com.tencent.mm.plugin.report.service.g.oUh.i(13267, str2, Long.valueOf(this.fCZ.field_msgSvrId), str3, Long.valueOf(this.fCZ.field_createTime / 1000), this.fCZ.field_talker, Integer.valueOf(3), Integer.valueOf(aN));
                                        obj = 1;
                                    }
                                }
                                com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
                                hVar.field_mediaId = this.hGx;
                                hVar.field_fullpath = this.hGA;
                                hVar.field_fileType = this.hGy;
                                hVar.field_totalLen = this.hrs;
                                hVar.field_aesKey = str;
                                hVar.field_fileId = str2;
                                hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                                hVar.hze = this.hGH;
                                hVar.field_chattype = o.dH(this.fCZ.field_talker) ? 1 : 0;
                                w.i(this.TAG, "cdnautostart %s %b", "image_" + this.fCZ.field_msgId, Boolean.valueOf(com.tencent.mm.modelcdntran.g.El().hyr.contains("image_" + this.fCZ.field_msgId)));
                                if (com.tencent.mm.modelcdntran.g.El().hyr.contains("image_" + this.fCZ.field_msgId)) {
                                    com.tencent.mm.modelcdntran.g.El().hyr.remove("image_" + this.fCZ.field_msgId);
                                    hVar.field_autostart = true;
                                } else {
                                    hVar.field_autostart = false;
                                }
                                if (com.tencent.mm.modelcdntran.g.El().b(hVar, this.hGD)) {
                                    w.d(this.TAG, "add recv task");
                                    obj = 1;
                                } else {
                                    com.tencent.mm.plugin.report.service.g.oUh.a(111, 196, 1, false);
                                    w.e(this.TAG, "addRecvTask failed :%s", this.hGx);
                                    this.hGx = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj != null) {
                w.d(this.TAG, "cdntra this img use cdn : %s", this.hGx);
                return 0;
            }
            w.d(this.TAG, "cdntra this img NOT USE CDN: %s", this.hGx);
            b.jr("");
            b.fRW = Downloads.RECV_BUFFER_SIZE;
            n.GS().a(Long.valueOf(this.gVi), b);
            zlVar.tgK = b.offset;
            zlVar.tgL = this.hGv;
            zlVar.tgJ = b.hrs;
            if (this.hGw != null) {
                this.hGw.Ka();
            }
            return a(eVar, this.gUA, this);
        }
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 3 && i3 == -1 && !bg.mA(this.hGx)) {
            w.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hGx);
        } else if (i2 == 0 && i3 == 0) {
            zm zmVar = (zm) ((b) pVar).hsk.hsr;
            d b = n.GS().b(Long.valueOf(this.gVi));
            Object obj = null;
            if (zmVar.tgL <= 0) {
                w.e(this.TAG, "flood control, malformed data_len");
                obj = -1;
            } else if (zmVar.tsk == null || zmVar.tgL != zmVar.tsk.tZn) {
                w.e(this.TAG, "flood control, malformed data is null or dataLen not match with data buf length");
                obj = -1;
            } else if (zmVar.tgK < 0 || zmVar.tgK + zmVar.tgL > zmVar.tgJ) {
                w.e(this.TAG, "flood control, malformed start pos");
                obj = -1;
            } else if (zmVar.tgK != b.offset) {
                w.e(this.TAG, "flood control, malformed start_pos");
                obj = -1;
            } else if (zmVar.tgJ <= 0) {
                w.e(this.TAG, "flood control, malformed total_len");
                obj = -1;
            }
            if (obj != null) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 192, 1, false);
                com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(-1), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGy), Integer.valueOf(this.hrs - this.startOffset));
                this.gUD.a(4, -1, "", this);
                return;
            }
            if (a(b, zmVar.tgJ, zmVar.tgK, zmVar.tgL, zmVar.tsk.tZp.sYA) && a(this.hsD, this.gUD) < 0) {
                this.gUD.a(3, -1, "", this);
            }
        } else {
            if (i2 == 4) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 193, 1, false);
                com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGy), Integer.valueOf(this.hrs - this.startOffset));
            }
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final boolean a(final d dVar, int i, int i2, int i3, byte[] bArr) {
        String str;
        boolean z;
        dVar.fO(i);
        dVar.setOffset(i2 + i3);
        this.hGv = i3;
        if (bArr != null) {
            com.tencent.mm.a.e.e(this.hGA, bArr);
        }
        w.d(this.TAG, "onGYNetEnd : offset = " + dVar.offset + " totalLen = " + dVar.hrs + " stack:[%s]", bg.bJZ());
        if (dVar.GA()) {
            String str2 = this.hGA;
            if (str2 == null || str2.equals("")) {
                str2 = "";
            } else {
                byte[] c = com.tencent.mm.a.e.c(str2, 0, 2);
                if (c == null || c.length < 2) {
                    str2 = "";
                } else {
                    str = ".jpg";
                    byte b = c[0];
                    if (b < (byte) 0) {
                        b += 256;
                    }
                    byte b2 = c[1];
                    if (b2 < (byte) 0) {
                        b2 += 256;
                    }
                    str2 = (b == (byte) 66 && b2 == (byte) 77) ? ".bmp" : (b == (byte) -1 && b2 == (byte) -40) ? ".jpg" : (b == (byte) -119 && b2 == (byte) 80) ? ".png" : (b == (byte) 71 && b2 == (byte) 73) ? ".gif" : str;
                }
            }
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            boolean checkIsImageLegal = MMBitmapFactory.checkIsImageLegal(this.hGA, decodeResultLogger);
            File file = new File(this.hGA);
            if (checkIsImageLegal) {
                str = n.GS().m(this.hGz, null, str2);
                w.i(this.TAG, "sceneEndproc ext:%s tmp:%s tmpfull:%s full:%s ", str2, this.hGz, this.hGA, str);
                file.renameTo(new File(str));
                dVar.jo(this.hGz + str2);
                dVar.jn(FileOp.ko(str));
                dVar.fS(this.hFc);
                if (n.GS().a(Long.valueOf(this.gVi), dVar) >= 0) {
                    w.e(this.TAG, "onGYNetEnd : update img fail");
                    this.gUD.a(3, -1, "", this);
                    return false;
                }
                if (this.hGt != null) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ j hGK;

                        public final void run() {
                            this.hGK.hGt.a(dVar.offset, dVar.hrs, this.hGK);
                        }
                    });
                }
                w.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(dVar.GA()), this.hGx);
                if (dVar.GA()) {
                    return true;
                }
                if (bg.mA(this.hGx)) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGy), Integer.valueOf(i - this.startOffset));
                }
                z = false;
                if (this.hGB > 0) {
                    z = n.GS().a(str, dVar.hFb, this.hGB, 1);
                }
                if (z) {
                    dVar.gxK = 1;
                    dVar.hFz = true;
                    ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a(this.fCZ.field_msgId, this.fCZ);
                }
                n.GS().a(Long.valueOf(this.gVi), dVar);
                w.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.hGA, str, dVar.hEZ, this.hGE);
                if (this.hGw != null) {
                    this.hGw.ar((long) dVar.hrs);
                }
                if (!bg.mA(this.hGE) && this.hGF > 0) {
                    com.tencent.mm.plugin.n.a.aDu();
                    com.tencent.mm.plugin.n.a.wY().p(this.hGE, this.hGF, str);
                }
                this.gUD.a(0, 0, "", this);
                return false;
            }
            file.delete();
            if (decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                com.tencent.mm.plugin.report.service.g.oUh.A(12712, KVStatHelper.getKVStatString(this.hGA, 2, decodeResultLogger));
            }
        }
        str = null;
        if (n.GS().a(Long.valueOf(this.gVi), dVar) >= 0) {
            if (this.hGt != null) {
                af.v(/* anonymous class already generated */);
            }
            w.d(this.TAG, "cdntra check iscompleted :%b clientid:%s", Boolean.valueOf(dVar.GA()), this.hGx);
            if (dVar.GA()) {
                return true;
            }
            if (bg.mA(this.hGx)) {
                com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGy), Integer.valueOf(i - this.startOffset));
            }
            z = false;
            if (this.hGB > 0) {
                z = n.GS().a(str, dVar.hFb, this.hGB, 1);
            }
            if (z) {
                dVar.gxK = 1;
                dVar.hFz = true;
                ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().a(this.fCZ.field_msgId, this.fCZ);
            }
            n.GS().a(Long.valueOf(this.gVi), dVar);
            w.d(this.TAG, "cdntra ext:%s %s %s  MediaCheckDuplicationStorage md5:%s", this.hGA, str, dVar.hEZ, this.hGE);
            if (this.hGw != null) {
                this.hGw.ar((long) dVar.hrs);
            }
            com.tencent.mm.plugin.n.a.aDu();
            com.tencent.mm.plugin.n.a.wY().p(this.hGE, this.hGF, str);
            this.gUD.a(0, 0, "", this);
            return false;
        }
        w.e(this.TAG, "onGYNetEnd : update img fail");
        this.gUD.a(3, -1, "", this);
        return false;
    }
}
