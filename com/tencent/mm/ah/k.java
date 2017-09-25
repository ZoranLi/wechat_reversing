package com.tencent.mm.ah;

import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelstat.g;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.r;
import com.tencent.mm.y.t;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import junit.framework.Assert;

public final class k extends com.tencent.mm.y.k implements j {
    public static boolean DEBUG = true;
    private static long hGX;
    public String TAG;
    public au fCZ;
    public float fOb;
    public String fVb;
    public final com.tencent.mm.y.b gUA;
    public e gUD;
    public long gVi;
    public int gVj;
    private d gVk;
    private boolean gVq;
    public int hFc;
    public long hFg;
    private int hGB;
    private com.tencent.mm.modelcdntran.h.a hGH;
    public String hGM;
    public String hGN;
    public boolean hGO;
    private d hGP;
    private int hGQ;
    public b hGR;
    public String hGS;
    private boolean hGT;
    public float hGU;
    public String hGV;
    public String hGW;
    public final f hGt;
    public long hGu;
    private g hGw;
    public String hGx;
    public int hGy;
    public int scene;
    public int startOffset;
    public long startTime;

    public interface a {
        void GF();
    }

    private class b {
        final /* synthetic */ k hGZ;
        public a hHc;

        final void GF() {
            d GG;
            if (this.hGZ.hGu == this.hGZ.gVi) {
                GG = this.hGZ.GG();
            } else {
                GG = this.hGZ.GH();
            }
            if (GG.hFk == 1) {
                com.tencent.mm.plugin.report.service.f.rZ(23);
                com.tencent.mm.plugin.report.service.f.rZ(21);
            }
            if (n.GS().a(Long.valueOf(this.hGZ.gVi), this.hGZ.GG()) < 0) {
                w.e(this.hGZ.TAG, "update db failed local id:" + this.hGZ.gVi + " server id:" + this.hGZ.GG().fTQ);
                h.fX((int) this.hGZ.hGu);
                h.fW((int) this.hGZ.hGu);
                this.hGZ.gUD.a(3, -1, "", this.hGZ);
            }
            if (this.hGZ.gVi != this.hGZ.hGu) {
                n.GS().a(Long.valueOf(this.hGZ.hGu), this.hGZ.GH());
            }
            this.hGZ.ak(this.hGZ.gVi);
            if (this.hGZ.hGu != this.hGZ.gVi) {
                this.hGZ.ak(this.hGZ.hGu);
            }
            if (this.hHc != null) {
                this.hHc.GF();
            }
            this.hGZ.fY(this.hGZ.hFc);
            this.hGZ.hGR = null;
        }

        public b(k kVar, a aVar) {
            this.hGZ = kVar;
            this.hHc = aVar;
        }
    }

    public final d GG() {
        if (this.gVk == null) {
            this.gVk = n.GS().b(Long.valueOf(this.gVi));
        }
        return this.gVk;
    }

    public final d GH() {
        if (this.hGP == null) {
            this.hGP = n.GS().b(Long.valueOf(this.hGu));
        }
        return this.hGP;
    }

    public final void ak(final long j) {
        af.v(new Runnable(this) {
            final /* synthetic */ k hGZ;

            public final void run() {
                m.GJ().hHf.remove(Long.valueOf(j));
            }
        });
    }

    public k(String str, String str2, String str3, int i) {
        this(4, str, str2, str3, i, null, "", "");
    }

    public k(int i, String str, String str2, String str3, int i2, f fVar, int i3, a aVar, int i4) {
        this(3, str, str2, str3, i2, fVar, i3, "", "", true, i4);
        this.hGR = new b(this, aVar);
    }

    private k(int i, String str, String str2, String str3, int i2, f fVar, String str4, String str5) {
        this(4, str, str2, str3, i2, null, 0, str4, str5, false, -1);
    }

    public k(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4) {
        this(i, str, str2, str3, i2, fVar, i3, str4, str5, z, i4, 0, -1000.0f, -1000.0f);
    }

    public k(int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, boolean z, int i4, int i5, float f, float f2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hGM = "";
        this.hGN = "";
        this.hGO = true;
        this.hGQ = 16384;
        this.hFc = 0;
        this.fCZ = null;
        this.hGw = null;
        this.hGx = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hGy = 0;
        this.hGR = new b(this, null);
        this.hGH = new com.tencent.mm.modelcdntran.h.a(this) {
            final /* synthetic */ k hGZ;

            {
                this.hGZ = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                Throwable th;
                w.d(this.hGZ.TAG, "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.hGZ.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
                if (i == -21005) {
                    w.w(this.hGZ.TAG, "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.hGZ.hGx);
                    if (this.hGZ.hGR != null) {
                        this.hGZ.hGR.GF();
                    }
                    this.hGZ.gUD.a(3, i, "", this.hGZ);
                    return 0;
                } else if (i != 0) {
                    w.e(this.hGZ.TAG, "cdntra cdnCallback clientid:%s startRet:%d", this.hGZ.hGx, Integer.valueOf(i));
                    h.fX((int) this.hGZ.hGu);
                    h.fW((int) this.hGZ.hGu);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        r1 = com.tencent.mm.plugin.report.service.g.oUh;
                        Object[] objArr = new Object[16];
                        objArr[0] = Integer.valueOf(i);
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Long.valueOf(this.hGZ.startTime);
                        objArr[3] = Long.valueOf(bg.Nz());
                        objArr[4] = Integer.valueOf(d.aU(ab.getContext()));
                        objArr[5] = Integer.valueOf(this.hGZ.hGy);
                        objArr[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                        objArr[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                        objArr[8] = "";
                        objArr[9] = "";
                        objArr[10] = "";
                        objArr[11] = "";
                        objArr[12] = "";
                        objArr[13] = "";
                        objArr[14] = "";
                        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                            r0 = "";
                        } else {
                            r0 = k.jw(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                        }
                        objArr[15] = r0;
                        r1.i(10421, objArr);
                    }
                    this.hGZ.gUD.a(3, i, "", this.hGZ);
                    if (this.hGZ.hGR != null) {
                        this.hGZ.hGR.GF();
                    }
                    return 0;
                } else {
                    final d GG = this.hGZ.GG();
                    if (GG == null || GG.hEY != this.hGZ.gVi) {
                        com.tencent.mm.modelcdntran.g.El().iO(this.hGZ.hGx);
                        w.e(this.hGZ.TAG, "cdntra get imginfo failed maybe delete by user imgLocalId:%d client:%s", Long.valueOf(this.hGZ.gVi), this.hGZ.hGx);
                        if (this.hGZ.hGR != null) {
                            this.hGZ.hGR.GF();
                        }
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                        this.hGZ.a(GG, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, 0, 0, com_tencent_mm_modelcdntran_keep_SceneResult);
                        return 0;
                    } else {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            w.i(this.hGZ.TAG, "dkupimg sceneResult:%s", com_tencent_mm_modelcdntran_keep_SceneResult);
                            bhw com_tencent_mm_protocal_c_bhw;
                            Object[] objArr2;
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                w.e(this.hGZ.TAG, "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", this.hGZ.hGx, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult);
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == -21111) {
                                    w.w(this.hGZ.TAG, "summersafecdn cdntra  ERR_CDNCOM_SAFEPROTO_NOAESKEY clientid:%s, enableHitcheck:%b", this.hGZ.hGx, Boolean.valueOf(this.hGZ.hGO));
                                    h.vJ();
                                    h.vL().D(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass4 hHa;

                                        public final void run() {
                                            this.hHa.hGZ.hGO = false;
                                            this.hHa.hGZ.startTime = 0;
                                            this.hHa.hGZ.startOffset = 0;
                                            d GG = this.hHa.hGZ.GG();
                                            GG.fM(0);
                                            this.hHa.hGZ.fCZ.z(ay.gk(this.hHa.hGZ.fCZ.field_talker));
                                            this.hHa.hGZ.hGx = d.a("upimg", this.hHa.hGZ.fCZ.field_createTime, this.hHa.hGZ.fCZ.field_talker, this.hHa.hGZ.fCZ.field_msgId + "_" + this.hHa.hGZ.gVi + "_" + this.hHa.hGZ.hFc);
                                            boolean a = this.hHa.hGZ.a(GG, 0, 0, 0, com_tencent_mm_modelcdntran_keep_SceneResult);
                                            bhv com_tencent_mm_protocal_c_bhv = (bhv) this.hHa.hGZ.gUA.hsj.hsr;
                                            if (com_tencent_mm_protocal_c_bhv == null) {
                                                w.w(this.hHa.hGZ.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again but old req is null");
                                            } else {
                                                com_tencent_mm_protocal_c_bhv.uhl = new avx().OV(this.hHa.hGZ.hGx);
                                            }
                                            w.i(this.hHa.hGZ.TAG, "summersafecdn ERR_CDNCOM_SAFEPROTO_NOAESKEY doScene again enableHitcheck[%b], ret[%b] new clientid[%s] createtime[%d]", Boolean.valueOf(this.hHa.hGZ.hGO), Boolean.valueOf(a), this.hHa.hGZ.hGx, Long.valueOf(this.hHa.hGZ.fCZ.field_createTime));
                                            this.hHa.hGZ.a(this.hHa.hGZ.hsD, this.hHa.hGZ.gUD);
                                        }
                                    });
                                    return 0;
                                }
                                com_tencent_mm_protocal_c_bhw = null;
                                if (!bg.bm(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf)) {
                                    com_tencent_mm_protocal_c_bhw = new bhw();
                                    try {
                                        com_tencent_mm_protocal_c_bhw.aD(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf);
                                        w.d(this.hGZ.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(com_tencent_mm_protocal_c_bhw.tZe.thX), com_tencent_mm_protocal_c_bhw.tZe.tiE.toString());
                                    } catch (Throwable e) {
                                        th = e;
                                        com_tencent_mm_protocal_c_bhw = null;
                                        w.e(this.hGZ.TAG, "UploadMsgImgResponse parse fail: %s", th);
                                        w.e(this.hGZ.TAG, "exception:%s", bg.g(th));
                                    } catch (Throwable e2) {
                                        th = e2;
                                        com_tencent_mm_protocal_c_bhw = null;
                                        w.e(this.hGZ.TAG, "UploadMsgImgResponse parse UninitializedMessageException: %s", th);
                                        w.e(this.hGZ.TAG, "exception:%s", bg.g(th));
                                    }
                                }
                                h.fX((int) this.hGZ.hGu);
                                h.fW((int) this.hGZ.hGu);
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr2[1] = Integer.valueOf(1);
                                objArr2[2] = Long.valueOf(this.hGZ.startTime);
                                objArr2[3] = Long.valueOf(bg.Nz());
                                objArr2[4] = Integer.valueOf(d.aU(ab.getContext()));
                                objArr2[5] = Integer.valueOf(this.hGZ.hGy);
                                objArr2[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                                objArr2[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : k.jw(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                                gVar.i(10421, objArr2);
                                gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                objArr2 = new Object[16];
                                objArr2[0] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                                objArr2[1] = Integer.valueOf(1);
                                objArr2[2] = Long.valueOf(this.hGZ.startTime);
                                objArr2[3] = Long.valueOf(bg.Nz());
                                objArr2[4] = Integer.valueOf(d.aU(ab.getContext()));
                                objArr2[5] = Integer.valueOf(this.hGZ.hGy);
                                objArr2[6] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                                objArr2[7] = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo;
                                objArr2[8] = "";
                                objArr2[9] = "";
                                objArr2[10] = "";
                                objArr2[11] = "";
                                objArr2[12] = "";
                                objArr2[13] = "";
                                objArr2[14] = "";
                                objArr2[15] = com_tencent_mm_modelcdntran_keep_SceneResult == null ? "" : k.jw(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                                gVar.i(13937, objArr2);
                                if (com_tencent_mm_protocal_c_bhw == null || com_tencent_mm_protocal_c_bhw.tZe.thX == 0) {
                                    this.hGZ.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hGZ);
                                } else {
                                    this.hGZ.gUD.a(4, com_tencent_mm_protocal_c_bhw.tZe.thX, com_tencent_mm_protocal_c_bhw.tZe.tiE.toString(), this.hGZ);
                                }
                                if (this.hGZ.hGR != null) {
                                    this.hGZ.hGR.GF();
                                }
                            } else {
                                w.i(this.hGZ.TAG, "summersafecdn uploadMsgImg by cdn, UploadHitCacheType: %d, needSendMsg:%b", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField));
                                r1 = com.tencent.mm.plugin.report.service.g.oUh;
                                objArr2 = new Object[3];
                                objArr2[0] = Integer.valueOf(GG.cGa == 0 ? 3 : GG.cGa);
                                objArr2[1] = this.hGZ.hGM;
                                objArr2[2] = Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType);
                                r1.i(13230, objArr2);
                                r0 = this.hGZ.hGS;
                                if (bg.mA(r0)) {
                                    r0 = (("<msg><img aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\" ") + "length=\"" + (com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength == 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength : com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength) + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/></msg>";
                                    w.i(this.hGZ.TAG, "cdn callback new build cdnInfo:%s", r0);
                                } else {
                                    Map q = bh.q(r0, "msg");
                                    if (q != null) {
                                        if (GG.hFc == 0) {
                                            r0 = (("<msg><img aeskey=\"" + ((String) q.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + ((String) q.get(".msg.img.$cdnbigimgurl")) + "\" ") + "cdnthumburl=\"" + ((String) q.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) q.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) q.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + (com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength == 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength : com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength) + "\" hdlength=\"" + ((String) q.get(".msg.img.$hdlength")) + "\"/></msg>";
                                        } else {
                                            r0 = (("<msg><img aeskey=\"" + ((String) q.get(".msg.img.$aeskey")) + "\" cdnmidimgurl=\"" + ((String) q.get(".msg.img.$cdnmidimgurl")) + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + ((String) q.get(".msg.img.$cdnthumburl")) + "\" cdnthumbaeskey=\"" + ((String) q.get(".msg.img.$cdnthumbaeskey")) + "\" cdnthumblength=\"" + ((String) q.get(".msg.img.cdnthumblength")) + "\" ") + "length=\"" + ((String) q.get(".msg.img.$length")) + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/></msg>";
                                        }
                                        w.i(this.hGZ.TAG, "cdn callback rebuild cdnInfo:%s", r0);
                                    }
                                }
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
                                    if (bg.mA(this.hGZ.hGW)) {
                                        w.w(this.hGZ.TAG, "summersafecdn sceneResult isUploadBySafeCDNWithMD5 but prepareResponse AESKey is null");
                                    } else {
                                        r0 = (("<msg><img aeskey=\"" + this.hGZ.hGW + "\" cdnmidimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnbigimgurl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" cdnthumbaeskey=\"" + this.hGZ.hGW + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength + "\" hdlength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\"/></msg>";
                                    }
                                }
                                GG.jr(r0);
                                if (this.hGZ.hGu != this.hGZ.gVi) {
                                    this.hGZ.GH().jr(r0);
                                }
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField) {
                                    h.vH().gXC.a(new l(this.hGZ.gVj, (bhv) this.hGZ.gUA.hsj.hsr, GG, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                                        final /* synthetic */ AnonymousClass4 hHa;

                                        public final void a(long j, int i, int i2, int i3) {
                                            com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.hHa.hGZ.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hHa.hGZ.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jw(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2));
                                            w.i(this.hHa.hGZ.TAG, "cdntra clientid:%s NetSceneUploadMsgImgForCdn ret:[%d,%d]", this.hHa.hGZ.hGx, Integer.valueOf(i2), Integer.valueOf(i3));
                                            if (i2 == 0 && i3 == 0) {
                                                this.hHa.hGZ.a(GG, GG.hrs, j, i, com_tencent_mm_modelcdntran_keep_SceneResult);
                                                return;
                                            }
                                            h.fX((int) this.hHa.hGZ.hGu);
                                            h.fW((int) this.hHa.hGZ.hGu);
                                            this.hHa.hGZ.gUD.a(i2, i3, "", this.hHa.hGZ);
                                            if (this.hHa.hGZ.hGR != null) {
                                                this.hHa.hGZ.hGR.GF();
                                            }
                                        }
                                    }), 0);
                                } else {
                                    com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.hGZ.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGZ.hGy), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", k.jw(com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2));
                                    com_tencent_mm_protocal_c_bhw = new bhw();
                                    try {
                                        com_tencent_mm_protocal_c_bhw.aD(com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf);
                                        long j = com_tencent_mm_protocal_c_bhw.tfk != 0 ? com_tencent_mm_protocal_c_bhw.tfk : (long) com_tencent_mm_protocal_c_bhw.tfc;
                                        w.d(this.hGZ.TAG, "parse skeyrespbuf: ret:%d,msg:%s", Integer.valueOf(com_tencent_mm_protocal_c_bhw.tZe.thX), com_tencent_mm_protocal_c_bhw.tZe.tiE.toString());
                                        this.hGZ.a(GG, GG.hrs, j, com_tencent_mm_protocal_c_bhw.ogM, com_tencent_mm_modelcdntran_keep_SceneResult);
                                        this.hGZ.gUD.a(0, 0, "", this.hGZ);
                                        if (this.hGZ.hGR != null) {
                                            this.hGZ.hGR.GF();
                                        }
                                        return 0;
                                    } catch (Throwable e22) {
                                        w.e(this.hGZ.TAG, "UploadMsgImgResponse parse fail: %s", e22);
                                        w.e(this.hGZ.TAG, "exception:%s", bg.g(e22));
                                        this.hGZ.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hGZ);
                                        if (this.hGZ.hGR != null) {
                                            this.hGZ.hGR.GF();
                                        }
                                    }
                                }
                            }
                        }
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                bhv com_tencent_mm_protocal_c_bhv = (bhv) this.hGZ.gUA.hsj.hsr;
                com.tencent.mm.bd.a ihVar = new ih();
                ihVar.tmV = com_tencent_mm_protocal_c_bhv.uhl.tZr;
                ihVar.mvV = com_tencent_mm_protocal_c_bhv.tfd.tZr;
                ihVar.mvU = com_tencent_mm_protocal_c_bhv.tfe.tZr;
                ihVar.tmW = com_tencent_mm_protocal_c_bhv.uhs;
                ihVar.tmX = com_tencent_mm_protocal_c_bhv.uht;
                ihVar.tdM = this.hGZ.scene;
                ihVar.tmZ = this.hGZ.hGU;
                ihVar.tna = this.hGZ.fOb;
                ihVar.tnb = this.hGZ.hGV;
                ihVar.tfi = com_tencent_mm_protocal_c_bhv.tfi;
                ihVar.tng = this.hGZ.hGN;
                d GG = this.hGZ.GG();
                String m = n.GS().m(GG.hEZ, "", "");
                com.tencent.mm.modelcdntran.g.Em();
                ihVar.tni = com.tencent.mm.modelcdntran.b.iK(m);
                ihVar.tnj = GG.hFd;
                if (ihVar.tnj <= 0) {
                    ihVar.tnj = this.hGZ.gVj == 4 ? 2 : 1;
                }
                switch (this.hGZ.gVj) {
                    case 1:
                    case 2:
                        ihVar.tfW = 1;
                        break;
                    case 4:
                        ihVar.tfW = 3;
                        break;
                    case 6:
                        ihVar.tfW = 5;
                        break;
                    default:
                        ihVar.tfW = 2;
                        break;
                }
                if (ihVar.tnj == 3) {
                    ihVar.tfW = 4;
                }
                w.i(this.hGZ.TAG, "getCdnAuthInfo: mediaid:%s thumbwidth:%d, thumbheight:%d,MsgSource:%s,touser:%s aeskey[%s], imgLocalId[%d], msgLocalId[%d], getBigImgPath()[%s], fullpath[%s], prereq.CRC32[%d] prereq.MsgForwardType[%d], prereq.Source[%d]", str, Integer.valueOf(ihVar.tmW), Integer.valueOf(ihVar.tmX), ihVar.tfi, ihVar.mvU, ihVar.tng, Long.valueOf(this.hGZ.gVi), Long.valueOf(this.hGZ.hFg), GG.hEZ, m, Integer.valueOf(ihVar.tni), Integer.valueOf(ihVar.tnj), Integer.valueOf(ihVar.tfW));
                com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
                aVar.hsm = ihVar;
                aVar.hsn = new bhw();
                aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
                aVar.hsl = 625;
                aVar.hso = 9;
                aVar.hsp = 1000000009;
                com.tencent.mm.y.b BE = aVar.BE();
                c Cc = this.hGZ.hsD.Cc();
                String str2 = this.hGZ.TAG;
                String str3 = "getCdnAuthInfo login:%s";
                Object[] objArr = new Object[1];
                objArr[0] = Cc == null ? "acc == null" : Boolean.valueOf(Cc.BY());
                w.i(str2, str3, objArr);
                if (Cc == null || !Cc.BY()) {
                    w.e(this.hGZ.TAG, "getCdnAuthInfo accinfo return null. clientimgid:%s", ihVar.tmV);
                    return;
                }
                if (r.a(Cc.vc(), Cc.BX(), Cc.BZ(), BE.BG(), byteArrayOutputStream, Cc.Ca())) {
                    w.d(this.hGZ.TAG, "getCdnAuthInfo successed.clientimgid:%s", ihVar.tmV);
                } else {
                    w.e(this.hGZ.TAG, "getCdnAuthInfo failed. clientimgid:%s", ihVar.tmV);
                }
            }

            public final byte[] i(String str, byte[] bArr) {
                PInt pInt = new PInt();
                avp iiVar = new ii();
                try {
                    byte[] a = t.a(bArr, h.vH().gXC.hsZ.Cc().vc(), pInt, iiVar);
                    w.i(this.hGZ.TAG, "decodePrepareResponse aeskey[%s], fileid[%s], clientimgid[%s]", iiVar.tng, iiVar.tnk, iiVar.tmV);
                    this.hGZ.hGW = iiVar.tng;
                    w.i(this.hGZ.TAG, "decodePrepareResponse, clientmediaid:%s, ret:%d", str, Integer.valueOf(pInt.value));
                    return a;
                } catch (Exception e) {
                    w.e(this.hGZ.TAG, "decodePrepareResponse Exception:%s", e);
                    this.hGZ.hGW = null;
                    return null;
                }
            }
        };
        this.gVq = false;
        w.i(this.TAG, "dkupimg init uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s], scene: %d, longtitude: %f, latitude: %f", Integer.valueOf(i), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.valueOf(true), bg.bJZ(), Integer.valueOf(i5), Float.valueOf(f), Float.valueOf(f2));
        this.hGT = z;
        this.hGB = i4;
        this.hGt = fVar;
        this.hFc = i2;
        this.scene = i5;
        this.fOb = f2;
        this.hGU = f;
        this.gVj = i;
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.hGS = str4;
        pString.value = str5;
        this.hGu = n.GS().a(str3, i2, i, i3, pString, pInt, pInt2);
        this.gVi = this.hGu;
        w.i(this.TAG, "FROM A UI :" + str2 + " " + this.hGu);
        if (this.hGu < 0 || !h.fV((int) this.hGu)) {
            w.e(this.TAG, "insert to img storage failed id:" + this.hGu);
            this.hFg = -1;
            this.gUA = null;
            return;
        }
        d GG;
        Assert.assertTrue(this.hGu >= 0);
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bhv();
        aVar.hsn = new bhw();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hsl = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.hso = 9;
        aVar.hsp = 1000000009;
        this.gUA = aVar.BE();
        this.fVb = str2;
        this.fCZ = new au();
        this.fCZ.setType(o.fH(str2));
        this.fCZ.cH(str2);
        this.fCZ.dw(1);
        this.fCZ.dv(1);
        this.fCZ.cI(pString.value);
        this.fCZ.dH(pInt.value);
        this.fCZ.dI(pInt2.value);
        this.fCZ.z(ay.gk(this.fCZ.field_talker));
        com.tencent.mm.h.a.a.qB().b(this.fCZ);
        this.hFg = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().L(this.fCZ);
        Assert.assertTrue(this.hFg >= 0);
        w.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.hFg);
        d GH = GH();
        GH.ag((long) ((int) this.hFg));
        n.GS().a(Long.valueOf(this.hGu), GH);
        if (i2 == 1) {
            this.gVi = (long) GH.hFi;
            GG = GG();
        } else {
            GG = GH;
        }
        GG.fO(com.tencent.mm.a.e.aN(n.GS().m(GG.hEZ, "", "")));
        n.GS().a(Long.valueOf(this.gVi), GG);
        w.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gVi + " img len = " + GG.hrs);
        bhv com_tencent_mm_protocal_c_bhv = (bhv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bhv.tfd = new avx().OV(str);
        com_tencent_mm_protocal_c_bhv.tfe = new avx().OV(str2);
        com_tencent_mm_protocal_c_bhv.tgK = GG.offset;
        com_tencent_mm_protocal_c_bhv.tgJ = GG.hrs;
        com_tencent_mm_protocal_c_bhv.mtd = this.fCZ.field_type;
        com_tencent_mm_protocal_c_bhv.tFO = i2;
        com_tencent_mm_protocal_c_bhv.trD = aa.bn(ab.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bhv.udC = GG.cGa;
        com_tencent_mm_protocal_c_bhv.tnj = GG.hFd;
        com_tencent_mm_protocal_c_bhv.uhs = pInt2.value;
        com_tencent_mm_protocal_c_bhv.uht = pInt.value;
        w.i(this.TAG, "LINE237 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bhv.uhs), Integer.valueOf(com_tencent_mm_protocal_c_bhv.uht));
        if (com_tencent_mm_protocal_c_bhv.tnj == 0) {
            com_tencent_mm_protocal_c_bhv.tnj = i == 4 ? 2 : 1;
        }
        w.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(GG.cGa), Integer.valueOf(com_tencent_mm_protocal_c_bhv.tnj));
        if (GG.offset == 0) {
            this.hGw = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) GG.hrs);
        }
        fY(i2);
        if (fVar != null) {
            final int i6 = GG.offset;
            final int i7 = GG.hrs;
            final f fVar2 = fVar;
            af.v(new Runnable(this) {
                final /* synthetic */ k hGZ;

                public final void run() {
                    fVar2.a(i6, i7, this.hGZ);
                }
            });
        }
    }

    public k(long j, int i, String str, String str2, String str3, int i2, f fVar, int i3, String str4, String str5, int i4) {
        d GG;
        String str6;
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hGM = "";
        this.hGN = "";
        this.hGO = true;
        this.hGQ = 16384;
        this.hFc = 0;
        this.fCZ = null;
        this.hGw = null;
        this.hGx = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hGy = 0;
        this.hGR = new b(this, null);
        this.hGH = /* anonymous class already generated */;
        this.gVq = false;
        w.i(this.TAG, "dkupimg init id:%d uploadsrc:%d from:%s to:%s ori:%s cmptype:%d prog:%s rotate:%d cdn:%s thumb:%s chatt:%b , res:%d run:%b [%s]", Long.valueOf(j), Integer.valueOf(3), str, str2, str3, Integer.valueOf(i2), fVar, Integer.valueOf(i3), str4, str5, Boolean.valueOf(true), Integer.valueOf(i4), Boolean.valueOf(true), bg.bJZ());
        this.hGT = true;
        this.hGB = i4;
        this.hGt = fVar;
        this.hFc = i2;
        this.gVj = 3;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        this.hGS = str4;
        this.hGu = j;
        this.gVi = this.hGu;
        d GH = GH();
        this.fCZ = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(GH.hFg);
        this.hFg = this.fCZ.field_msgId;
        pInt2.value = this.fCZ.gxH;
        pInt.value = this.fCZ.gxG;
        if (i2 == 1) {
            this.gVi = (long) GH.hFi;
            this.gVk = null;
            GG = GG();
        } else {
            GG = GH;
        }
        if (this.fCZ.field_talker.equals(str2)) {
            str6 = str2;
        } else {
            w.e(this.TAG, "fatal!! Send user mis-match, want:%s, fact:%s", str2, this.fCZ.field_talker);
            com.tencent.mm.plugin.report.service.g.oUh.a(594, 4, 1, true);
            str6 = this.fCZ.field_talker;
        }
        w.i(this.TAG, "NetSceneUploadMsgImg: local msgId = " + this.fCZ.field_msgId);
        w.d(this.TAG, "FROM A UI :" + str2 + "   msg:" + str6 + this.hGu);
        if (this.hGu < 0 || !h.fV((int) this.hGu)) {
            w.e(this.TAG, "insert to img storage failed id:" + this.hGu);
            this.hFg = -1;
            this.gUA = null;
            return;
        }
        Assert.assertTrue(this.hGu >= 0);
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bhv();
        aVar.hsn = new bhw();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hsl = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.hso = 9;
        aVar.hsp = 1000000009;
        this.gUA = aVar.BE();
        w.i(this.TAG, "NetSceneUploadMsgImg: local imgId = " + this.gVi + " img len = " + GG.hrs);
        bhv com_tencent_mm_protocal_c_bhv = (bhv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bhv.tfd = new avx().OV(str);
        com_tencent_mm_protocal_c_bhv.tfe = new avx().OV(str6);
        com_tencent_mm_protocal_c_bhv.tgK = GG.offset;
        com_tencent_mm_protocal_c_bhv.tgJ = GG.hrs;
        com_tencent_mm_protocal_c_bhv.mtd = this.fCZ.field_type;
        com_tencent_mm_protocal_c_bhv.tFO = i2;
        com_tencent_mm_protocal_c_bhv.trD = aa.bn(ab.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bhv.udC = GG.cGa;
        com_tencent_mm_protocal_c_bhv.tnj = GG.hFd;
        com_tencent_mm_protocal_c_bhv.uhs = pInt2.value;
        com_tencent_mm_protocal_c_bhv.uht = pInt.value;
        w.i(this.TAG, "LINE350 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bhv.uhs), Integer.valueOf(com_tencent_mm_protocal_c_bhv.uht));
        if (com_tencent_mm_protocal_c_bhv.tnj == 0) {
            com_tencent_mm_protocal_c_bhv.tnj = 1;
        }
        w.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(GG.cGa), Integer.valueOf(com_tencent_mm_protocal_c_bhv.tnj));
        if (GG.offset == 0) {
            this.hGw = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) GG.hrs);
        }
        if (fVar != null) {
            final int i5 = GG.offset;
            final int i6 = GG.hrs;
            final f fVar2 = fVar;
            af.v(new Runnable(this) {
                final /* synthetic */ k hGZ;

                public final void run() {
                    fVar2.a(i5, i6, this.hGZ);
                }
            });
        }
    }

    public final void fY(int i) {
        int i2 = 0;
        if (this.fCZ == null) {
            w.w(this.TAG, "createHDThumb but msg is null msgLocalId[%d], compressType[%d]", Long.valueOf(this.hFg), Integer.valueOf(i));
        } else if (!this.hGT) {
            n.GS().a(this.fCZ.field_imgPath, com.tencent.mm.bg.a.getDensity(ab.getContext()), true);
        } else if (this.fCZ.gxK == 0) {
            boolean z;
            f GS = n.GS();
            ce ceVar = this.fCZ;
            int i3 = this.hGB;
            String p = f.p(ceVar);
            if (bg.mA(p)) {
                z = false;
            } else {
                z = GS.a(p, ceVar.field_imgPath, i3, i);
            }
            ceVar = this.fCZ;
            if (z) {
                i2 = 1;
            }
            ceVar.gxK = i2;
            ceVar.gtA = true;
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(this.hFg, this.fCZ);
        }
    }

    public k(int i, int i2) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hGM = "";
        this.hGN = "";
        this.hGO = true;
        this.hGQ = 16384;
        this.hFc = 0;
        this.fCZ = null;
        this.hGw = null;
        this.hGx = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hGy = 0;
        this.hGR = new b(this, null);
        this.hGH = /* anonymous class already generated */;
        this.gVq = false;
        w.i(this.TAG, "dkupimg init id:%d cmptype:%d  [%s]", Integer.valueOf(i), Integer.valueOf(i2), bg.bJZ());
        this.hGu = (long) i;
        this.gVi = (long) i;
        this.hFc = i2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bhv();
        aVar.hsn = new bhw();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hsl = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.hso = 9;
        aVar.hsp = 1000000009;
        this.gUA = aVar.BE();
        this.hGt = null;
        w.d(this.TAG, "FROM B SERVICE:" + this.hGu);
        if (h.fV((int) this.hGu)) {
            d b;
            d b2 = n.GS().b(Long.valueOf(this.hGu));
            this.hFg = b2.hFg;
            if (i2 == 1) {
                this.gVi = (long) b2.hFi;
                b = n.GS().b(Long.valueOf(this.gVi));
            } else {
                b = b2;
            }
            b2 = n.GS().fU((int) b.hEY);
            if (b2 != null) {
                this.hFg = b2.hFg;
            }
            this.fCZ = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(this.hFg);
            if (this.fCZ != null && this.fCZ.field_msgId != this.hFg) {
                w.w(this.TAG, "init get msg by id failed:%d", Long.valueOf(this.hFg));
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 206, 1, false);
                this.fCZ = null;
                return;
            } else if (this.fCZ != null) {
                bhv com_tencent_mm_protocal_c_bhv = (bhv) this.gUA.hsj.hsr;
                com_tencent_mm_protocal_c_bhv.tfd = new avx().OV(m.xL());
                com_tencent_mm_protocal_c_bhv.tfe = new avx().OV(this.fCZ.field_talker);
                com_tencent_mm_protocal_c_bhv.tgK = b.offset;
                com_tencent_mm_protocal_c_bhv.tgJ = b.hrs;
                com_tencent_mm_protocal_c_bhv.mtd = this.fCZ.field_type;
                com_tencent_mm_protocal_c_bhv.tFO = i2;
                com_tencent_mm_protocal_c_bhv.trD = aa.bn(ab.getContext()) ? 1 : 2;
                com_tencent_mm_protocal_c_bhv.udC = b.cGa;
                com_tencent_mm_protocal_c_bhv.tnj = b.hFd;
                com_tencent_mm_protocal_c_bhv.tnj = b.hFd;
                com_tencent_mm_protocal_c_bhv.uhs = this.fCZ.gxH;
                com_tencent_mm_protocal_c_bhv.uht = this.fCZ.gxG;
                w.i(this.TAG, "LINE425 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bhv.uhs), Integer.valueOf(com_tencent_mm_protocal_c_bhv.uht));
                w.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b.cGa), Integer.valueOf(com_tencent_mm_protocal_c_bhv.tnj));
                if (b.offset == 0) {
                    this.hGw = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) b.hrs);
                    return;
                }
                return;
            } else {
                return;
            }
        }
        this.hGu = -1;
    }

    public k(int i, int i2, byte b) {
        this.TAG = "MicroMsg.NetSceneUploadMsgImg";
        this.hGM = "";
        this.hGN = "";
        this.hGO = true;
        this.hGQ = 16384;
        this.hFc = 0;
        this.fCZ = null;
        this.hGw = null;
        this.hGx = "";
        this.startTime = 0;
        this.startOffset = -1;
        this.hGy = 0;
        this.hGR = new b(this, null);
        this.hGH = /* anonymous class already generated */;
        this.gVq = false;
        w.i(this.TAG, "dkupimg init id:%d cmptype:%d pro:%s  [%s]", Integer.valueOf(i), Integer.valueOf(i2), null, bg.bJZ());
        this.hGu = (long) i;
        this.gVi = (long) i;
        this.hFc = i2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new bhv();
        aVar.hsn = new bhw();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        aVar.hsl = MMGIFException.D_GIF_ERR_CLOSE_FAILED;
        aVar.hso = 9;
        aVar.hsp = 1000000009;
        this.gUA = aVar.BE();
        this.hGt = null;
        w.d(this.TAG, "FROM C SERVICE:" + this.hGu);
        if (h.fV((int) this.hGu)) {
            d b2;
            d b3 = n.GS().b(Long.valueOf(this.hGu));
            this.hFg = b3.hFg;
            b3.dv(0);
            b3.y(0);
            b3.setOffset(0);
            n.GS().a((int) this.gVi, b3);
            if (i2 == 1) {
                this.gVi = (long) b3.hFi;
                b2 = n.GS().b(Long.valueOf(this.gVi));
            } else {
                b2 = b3;
            }
            this.fCZ = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(this.hFg);
            if (this.fCZ != null) {
                this.fCZ.dv(1);
                String str = b2.hFb;
                if (str == null || !str.startsWith("THUMBNAIL_DIRPATH://")) {
                    this.fCZ.cI("THUMBNAIL://" + b2.hEY);
                } else {
                    this.fCZ.cI(str);
                }
                ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(this.hFg, this.fCZ);
                bhv com_tencent_mm_protocal_c_bhv = (bhv) this.gUA.hsj.hsr;
                com_tencent_mm_protocal_c_bhv.tfd = new avx().OV(m.xL());
                com_tencent_mm_protocal_c_bhv.tfe = new avx().OV(this.fCZ.field_talker);
                com_tencent_mm_protocal_c_bhv.tgK = b2.offset;
                com_tencent_mm_protocal_c_bhv.tgJ = b2.hrs;
                com_tencent_mm_protocal_c_bhv.mtd = this.fCZ.field_type;
                com_tencent_mm_protocal_c_bhv.tFO = i2;
                com_tencent_mm_protocal_c_bhv.trD = aa.bn(ab.getContext()) ? 1 : 2;
                com_tencent_mm_protocal_c_bhv.udC = b2.cGa;
                com_tencent_mm_protocal_c_bhv.tnj = b2.hFd;
                com_tencent_mm_protocal_c_bhv.uhs = this.fCZ.gxH;
                com_tencent_mm_protocal_c_bhv.uht = this.fCZ.gxG;
                w.i(this.TAG, "LINE492 thumb.width:%d,thumb.height:%d", Integer.valueOf(com_tencent_mm_protocal_c_bhv.uhs), Integer.valueOf(com_tencent_mm_protocal_c_bhv.uht));
                w.d(this.TAG, "dkimgsource: %d, forwardtype:%d", Integer.valueOf(b2.cGa), Integer.valueOf(com_tencent_mm_protocal_c_bhv.tnj));
                if (b2.offset == 0) {
                    this.hGw = new g(MMGIFException.D_GIF_ERR_CLOSE_FAILED, true, (long) b2.hrs);
                    return;
                }
                return;
            }
            return;
        }
        this.hGu = -1;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        h.vJ();
        h.vL().e(new Runnable(this) {
            final /* synthetic */ k hGZ;

            {
                this.hGZ = r1;
            }

            public final void run() {
                ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().Af("SendImgSpeeder");
            }
        }, 100);
        if (this.gVi < 0) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 204, 1, false);
            w.e(this.TAG, "doScene invalid imgLocalId:" + this.gVi);
            return fZ(-1);
        } else if (this.fCZ == null) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 203, 1, false);
            w.e(this.TAG, "doScene msg is null imgid:%d", Long.valueOf(this.gVi));
            h.fX((int) this.hGu);
            return fZ(-2);
        } else {
            String zz;
            this.gUD = eVar2;
            c(eVar);
            bhv com_tencent_mm_protocal_c_bhv = (bhv) this.gUA.hsj.hsr;
            d GG = GG();
            d fU = n.GS().fU((int) GG.hEY);
            if (fU != null) {
                if (fU.status == -1) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(111, 202, 1, false);
                    w.e(this.TAG, "doScene hd img info is null or error.");
                    return fZ(-3);
                }
            } else if (GG == null || GG.status == -1) {
                w.e(this.TAG, "doScene img info is null or error.");
                return fZ(-4);
            }
            if (com.tencent.mm.h.a.a.qB().dr(this.fCZ.field_talker)) {
                com_tencent_mm_protocal_c_bhv.tfi = com.tencent.mm.h.a.a.qB().c(this.fCZ);
            } else {
                zz = ba.zz();
                if (!(zz == null || zz.equals(this.fCZ.gxF)) || (zz == null && !bg.mA(this.fCZ.gxF))) {
                    this.fCZ.cN(zz);
                    ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(this.fCZ.field_msgId, this.fCZ);
                }
                com_tencent_mm_protocal_c_bhv.tfi = this.fCZ.gxF;
            }
            String m = n.GS().m(GG.hEZ, "", "");
            String m2 = n.GS().m(GG.hFb, "", "");
            zz = "";
            if (!bg.mA(GG.hFa)) {
                zz = n.GS().m(GG.hFa, "", "");
            }
            if (com.tencent.mm.a.e.aN(m) <= 0 || com.tencent.mm.a.e.aN(m2) <= 0) {
                w.e(this.TAG, "doScene invalid imgLocalId:%d filesize:[%d,%d] %s %s", Long.valueOf(this.gVi), Integer.valueOf(com.tencent.mm.a.e.aN(m)), Integer.valueOf(com.tencent.mm.a.e.aN(m2)), m, m2);
                return fZ(-5);
            }
            Object obj;
            if (com_tencent_mm_protocal_c_bhv.uhl == null || bg.mA(com_tencent_mm_protocal_c_bhv.uhl.tZr)) {
                if (bg.mA(this.hGx)) {
                    w.i(this.TAG, "createMediaId time:%d talker:%s msg:%d img:%d compressType:%d", Long.valueOf(this.fCZ.field_createTime), this.fCZ.field_talker, Long.valueOf(this.fCZ.field_msgId), Long.valueOf(this.gVi), Integer.valueOf(this.hFc));
                    this.hGx = d.a("upimg", this.fCZ.field_createTime, this.fCZ.field_talker, this.fCZ.field_msgId + "_" + this.gVi + "_" + this.hFc);
                }
                com_tencent_mm_protocal_c_bhv.uhl = new avx().OV(this.hGx);
                ce ceVar = this.fCZ;
                ceVar.gxM = this.hGx;
                ceVar.gtA = true;
            }
            if (this.startTime == 0) {
                this.startTime = bg.Nz();
                this.startOffset = GG.offset;
                this.hGy = this.hFc == 1 ? com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE : com.tencent.mm.modelcdntran.b.MediaType_IMAGE;
            }
            w.i(this.TAG, "before checkUseCdn %s, %s, imgBitPath:%s", m, m2, GG.hEZ);
            if (o.fF(this.fCZ.field_talker)) {
                w.w(this.TAG, "cdntra not use cdn user:%s", this.fCZ.field_talker);
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.El();
                if (!com.tencent.mm.modelcdntran.c.fA(1) && bg.mA(GG.hFj)) {
                    r7 = new Object[2];
                    com.tencent.mm.modelcdntran.g.El();
                    r7[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(1));
                    r7[1] = GG.hFj;
                    w.w(this.TAG, "cdntra not use cdn flag:%b getCdnInfo:%s", r7);
                    obj = null;
                } else if (bg.mA(this.hGx)) {
                    w.w(this.TAG, "cdntra genClientId failed not use cdn imgLocalId:%d", Long.valueOf(this.gVi));
                    obj = null;
                } else {
                    com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
                    hVar.hze = this.hGH;
                    hVar.field_mediaId = this.hGx;
                    hVar.field_fullpath = m;
                    hVar.field_thumbpath = m2;
                    hVar.field_fileType = this.hGy;
                    hVar.field_talker = this.fCZ.field_talker;
                    hVar.field_chattype = o.dH(this.fCZ.field_talker) ? 1 : 0;
                    hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                    hVar.field_needStorage = false;
                    hVar.field_isStreamMedia = false;
                    hVar.field_sendmsg_viacdn = true;
                    hVar.field_enable_hitcheck = this.hGO;
                    hVar.field_midimgpath = zz;
                    hVar.field_force_aeskeycdn = false;
                    hVar.field_trysafecdn = true;
                    if (hVar.field_fileType == com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE && bg.mA(hVar.field_midimgpath)) {
                        com.tencent.mm.modelcdntran.g.El();
                        if (com.tencent.mm.modelcdntran.c.fA(256)) {
                            w.w(this.TAG, "summersafecdn send fullsizeimage but midimgpath is null set field_force_aeskeycdn true");
                            hVar.field_force_aeskeycdn = true;
                            hVar.field_trysafecdn = false;
                        }
                    }
                    Map q = bh.q(this.hGS, "msg");
                    if (q != null) {
                        if (this.hFc != 1) {
                            hVar.field_fileId = (String) q.get(".msg.img.$cdnmidimgurl");
                            hVar.field_midFileLength = bg.getInt((String) q.get(".msg.img.$length"), 0);
                            hVar.field_totalLen = 0;
                        } else {
                            hVar.field_fileId = (String) q.get(".msg.img.$cdnbigimgurl");
                            hVar.field_midFileLength = bg.getInt((String) q.get(".msg.img.$length"), 0);
                            hVar.field_totalLen = 0;
                        }
                        hVar.field_aesKey = (String) q.get(".msg.img.$aeskey");
                    } else {
                        w.i(this.TAG, "parse cdnInfo failed. [%s]", GG.hFj);
                    }
                    if (bg.mA(hVar.field_aesKey)) {
                        com.tencent.mm.modelcdntran.g.Em();
                        hVar.field_aesKey = com.tencent.mm.modelcdntran.b.Ee();
                        w.i(this.TAG, "summersafecdn cdntra oldAeskey is null and gen new[%s]", hVar.field_aesKey);
                    }
                    w.i(this.TAG, "dkupimg src:%d fileid:%s", Integer.valueOf(GG.cGa), hVar.field_fileId);
                    this.hGM = hVar.field_fileId;
                    this.hGN = hVar.field_aesKey;
                    w.d(this.TAG, "summersafecdn checkUseCdn field_enable_hitcheck[%b], field_fileType[%d], field_midimgpath[%s], field_fullpath[%s], aeskey[%s], fileid[%s], enable_hitcheck[%b], aeskeycdn[%b], trysafecdn[%b]", Boolean.valueOf(hVar.field_enable_hitcheck), Integer.valueOf(hVar.field_fileType), hVar.field_midimgpath, hVar.field_fullpath, hVar.field_aesKey, hVar.field_fileId, Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn));
                    this.hGW = null;
                    if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                        if (bg.mz(GG.hFj).length() <= 0) {
                            GG.jr("CDNINFO_SEND");
                            GG.fRW = Downloads.RECV_BUFFER_SIZE;
                        }
                        obj = 1;
                    } else {
                        com.tencent.mm.plugin.report.service.g.oUh.a(111, 205, 1, false);
                        w.e(this.TAG, "cdntra addSendTask failed. clientid:%s", this.hGx);
                        this.hGx = "";
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                w.d(this.TAG, "cdntra use cdn return -1 for onGYNetEnd clientid:%s", com_tencent_mm_protocal_c_bhv.uhl.tZr);
                return 0;
            }
            w.i(this.TAG, "after checkUseCdn, it use cgi to upload image.");
            int i = GG.hFh;
            if (i >= ub()) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 201, 1, false);
                w.e(this.TAG, "doScene limit net time:" + i);
                h.fX((int) this.hGu);
                return fZ(-6);
            }
            GG.fM(i + 1);
            GG.fRW = 512;
            n.GS().a(Long.valueOf(this.gVi), GG);
            int i2 = GG.hrs - GG.offset;
            if (i2 > this.hGQ) {
                i2 = this.hGQ;
            }
            if (com.tencent.mm.a.e.aN(m) > 10485760) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 200, 1, false);
                w.e(this.TAG, "doScene, file size is too large");
                return fZ(-7);
            }
            byte[] c = com.tencent.mm.a.e.c(m, GG.offset, i2);
            if (c == null || c.length <= 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 199, 1, false);
                w.e(this.TAG, "doScene, file read buf error.");
                return fZ(-8);
            }
            com_tencent_mm_protocal_c_bhv.tgL = c.length;
            com_tencent_mm_protocal_c_bhv.tgK = GG.offset;
            com_tencent_mm_protocal_c_bhv.tsk = new avw().bb(c);
            if (this.hGw != null) {
                this.hGw.Ka();
            }
            int a = a(eVar, this.gUA, this);
            if (a >= 0) {
                return a;
            }
            w.e(this.TAG, "doScene netId error");
            h.fX((int) this.hGu);
            return fZ(-9);
        }
    }

    private int fZ(int i) {
        w.e(this.TAG, "do Scene error code : " + i + " hashcode : " + hashCode());
        if (this.hGR != null) {
            this.hGR.GF();
        }
        return -1;
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_CLOSE_FAILED;
    }

    protected final int ub() {
        if (this.hFc == 0) {
            return 100;
        }
        return 1350;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        bhw com_tencent_mm_protocal_c_bhw = (bhw) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        w.i(this.TAG, "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.hGx);
        if (i2 == 3 && i3 == -1 && !bg.mA(this.hGx)) {
            w.w(this.TAG, "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hGx);
        } else if (i2 == 0 && i3 == 0) {
            this.hGQ = com_tencent_mm_protocal_c_bhw.tgL;
            if (this.hGQ > 16384) {
                this.hGQ = 16384;
            }
            d GG = GG();
            w.v(this.TAG, "onGYNetEnd localId:" + this.gVi + "  totalLen:" + GG.hrs + " offSet:" + GG.offset);
            if (com_tencent_mm_protocal_c_bhw.tgK < 0 || (com_tencent_mm_protocal_c_bhw.tgK > GG.hrs && GG.hrs > 0)) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 197, 1, false);
                w.e(this.TAG, "onGYNetEnd invalid server return value : startPos = " + com_tencent_mm_protocal_c_bhw.tgK + " img totalLen = " + GG.hrs);
                h.fX((int) this.hGu);
                h.fW((int) this.hGu);
                com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(-2), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGy), Integer.valueOf(0));
                this.gUD.a(4, -2, "", this);
                if (this.hGR != null) {
                    this.hGR.GF();
                }
            } else if (com_tencent_mm_protocal_c_bhw.tgK < GG.offset || (e.b(GG) && this.hGQ <= 0)) {
                w.e(this.TAG, "onGYNetEnd invalid data startPos = " + com_tencent_mm_protocal_c_bhw.tgK + " totalLen = " + GG.hrs + " off:" + GG.offset);
                h.fX((int) this.hGu);
                h.fW((int) this.hGu);
                this.gUD.a(4, -1, "", this);
                if (this.hGR != null) {
                    this.hGR.GF();
                }
            } else {
                w.d("ImgInfoLogic", "resp.rImpl.getStartPos() " + com_tencent_mm_protocal_c_bhw.tgK);
                if (a(GG, com_tencent_mm_protocal_c_bhw.tgK, com_tencent_mm_protocal_c_bhw.tfk, com_tencent_mm_protocal_c_bhw.ogM, null) && a(this.hsD, this.gUD) < 0) {
                    h.fW((int) this.hGu);
                    this.gUD.a(3, -1, "", this);
                    if (this.hGR != null) {
                        this.hGR.GF();
                    }
                }
            }
        } else {
            w.e(this.TAG, "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 198, 1, false);
            h.fX((int) this.hGu);
            h.fW((int) this.hGu);
            com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGy), Integer.valueOf(0));
            this.gUD.a(i2, i3, str, this);
            if (this.hGR != null) {
                this.hGR.GF();
            }
        }
    }

    public final void GI() {
        w.i(this.TAG, "send img from system");
        this.gVq = true;
    }

    public final boolean a(d dVar, int i, long j, int i2, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        w.d(this.TAG, "cdntra clientid:%s start:%d svrid:%d createtime:%d", this.hGx, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        w.d(this.TAG, "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(j), Integer.valueOf(com.tencent.mm.platformtools.r.iiX));
        if (10007 == com.tencent.mm.platformtools.r.iiW && com.tencent.mm.platformtools.r.iiX != 0) {
            j = (long) com.tencent.mm.platformtools.r.iiX;
            com.tencent.mm.platformtools.r.iiX = 0;
        }
        final long j2 = dVar.hEY;
        final int i3 = dVar.hrs;
        if (this.hGt != null) {
            final int i4 = i;
            af.v(new Runnable(this) {
                final /* synthetic */ k hGZ;

                public final void run() {
                    m GJ = m.GJ();
                    long j = j2;
                    long j2 = (long) i3;
                    long j3 = (long) i4;
                    m.d dVar = GJ.hHf.containsKey(Long.valueOf(j)) ? (m.d) GJ.hHf.get(Long.valueOf(j)) : new m.d();
                    dVar.hHx = j3;
                    dVar.hHw = j2;
                    GJ.hHf.put(Long.valueOf(j), dVar);
                    this.hGZ.hGt.a(i4, i3, this.hGZ);
                }
            });
        }
        dVar.setOffset(i);
        dVar.y(j);
        if (e.b(dVar) && this.hGu != this.gVi) {
            d b = n.GS().b(Long.valueOf(this.hGu));
            b.y(j);
            b.fO(dVar.hrs);
            b.setOffset(dVar.hrs);
            n.GS().a(Long.valueOf(this.hGu), b);
        }
        if (!e.b(dVar)) {
            return true;
        }
        if (bg.mA(this.hGx)) {
            com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hGy), Integer.valueOf(dVar.hrs - this.startOffset));
        }
        this.fCZ.dv(2);
        this.fCZ.y(j);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(this.hFg, this.fCZ);
        if (q.hXD != null) {
            q.hXD.f(this.fCZ);
        }
        h.fW((int) this.hGu);
        if (this.hGw != null) {
            this.hGw.ar(0);
        }
        this.gUD.a(0, 0, "", this);
        if (q.hIb != null) {
            q.hIb.a(this.gVi, this.fCZ, this.gUA, this.gVj, this.gVq, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        if (this.hGR != null) {
            this.hGR.GF();
        }
        return false;
    }

    public static void al(long j) {
        hGX = j;
    }

    public static String jw(String str) {
        try {
            if (!bg.mA(str)) {
                String[] split = str.split(",");
                if (split != null && split.length > 19) {
                    StringBuilder stringBuilder = new StringBuilder();
                    long j = hGX;
                    hGX = -1;
                    split[19] = stringBuilder.append(j).toString();
                    str = bg.c(bg.f(split), ",");
                }
            }
        } catch (Exception e) {
        }
        return str;
    }
}
