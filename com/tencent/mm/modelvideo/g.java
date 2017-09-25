package com.tencent.mm.modelvideo;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bid;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ba;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class g extends k implements j {
    private static int hYS = 32000;
    private final int MAX_TIMES;
    public int fEX = 0;
    private String fVC = "";
    public String fyF;
    private b gUA;
    public e gUD;
    private a hGH = new a(this) {
        final /* synthetic */ g hZb;

        {
            this.hZb = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            w.d("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", this.hZb.KO(), this.hZb.hGx, Integer.valueOf(i), com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult);
            if (i == -21005) {
                w.d("MicroMsg.NetSceneUploadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", this.hZb.hGx);
                return 0;
            } else if (i != 0) {
                t.lA(this.hZb.fyF);
                com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(this.hZb.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hZb.hYB), Integer.valueOf(0), "");
                this.hZb.gUD.a(3, i, "", this.hZb);
                return 0;
            } else {
                this.hZb.hYz = t.lH(this.hZb.fyF);
                int i2;
                if (this.hZb.hYz == null || this.hZb.hYz.status == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                    w.i("MicroMsg.NetSceneUploadVideo", "%s info is null or has paused, status:%d", this.hZb.KO(), Integer.valueOf(this.hZb.hYz == null ? -1 : this.hZb.hYz.status));
                    com.tencent.mm.modelcdntran.g.El().iO(this.hZb.hGx);
                    this.hZb.gUD.a(3, i, "info is null or has paused, status" + i2, this.hZb);
                    return 0;
                } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                            w.e("MicroMsg.NetSceneUploadVideo", "%s cdntra sceneResult.retCode :%d arg[%s] info[%s]", this.hZb.KO(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult.field_arg, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo);
                            t.lA(this.hZb.fyF);
                            com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.hZb.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hZb.hYB), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            com.tencent.mm.plugin.report.service.g.oUh.i(13937, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(1), Long.valueOf(this.hZb.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hZb.hYB), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            this.hZb.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hZb);
                        } else {
                            w.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn uploadvideo by cdn, videohash isHitCacheUpload: %d, enableHitcheck:%b", this.hZb.KO(), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(this.hZb.hGO));
                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            Object[] objArr = new Object[2];
                            i2 = this.hZb.hYX ? 810 : this.hZb.hYW ? 820 : 830;
                            objArr[0] = Integer.valueOf(i2 + com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType);
                            objArr[1] = Integer.valueOf(this.hZb.hYz.hrs);
                            gVar.i(12696, objArr);
                            boolean z2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_isVideoReduced;
                            w.i("MicroMsg.NetSceneUploadVideo", "%s it video was reduced by cdn %b %s", this.hZb.KO(), Boolean.valueOf(z2), this.hZb.fyF);
                            if (z2) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(106, 200, 1, false);
                            } else {
                                com.tencent.mm.plugin.report.service.g.oUh.a(106, 205, 1, false);
                                if (this.hZb.hYY > 0 && com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength > 0) {
                                    w.i("MicroMsg.NetSceneUploadVideo", "%s send video thumb too big thumb length [%d, %d] ", this.hZb.KO(), Integer.valueOf(this.hZb.hYY), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength));
                                    if (this.hZb.hYY * 2 > com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength) {
                                        com.tencent.mm.plugin.report.service.g.oUh.a(106, 206, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.oUh.a(106, 207, 1, false);
                                    }
                                }
                                o.KV();
                                w.i("MicroMsg.NetSceneUploadVideo", "%s send video too big thumb length [%d, %d] ", this.hZb.KO(), Integer.valueOf(this.hZb.hYz.hrs), Integer.valueOf(com.tencent.mm.a.e.aN(s.lv(this.hZb.fyF))));
                                if (this.hZb.hYz.hrs != com.tencent.mm.a.e.aN(s.lv(this.hZb.fyF))) {
                                    com.tencent.mm.plugin.report.service.g.oUh.a(106, 208, 1, false);
                                } else {
                                    com.tencent.mm.plugin.report.service.g.oUh.a(106, 209, 1, false);
                                }
                            }
                            this.hZb.hYz = t.lH(this.hZb.fyF);
                            if (bg.mA(this.hZb.hYz.Lh())) {
                                w.i("MicroMsg.NetSceneUploadVideo", "%s cdn callback new build cdnInfo:%s", this.hZb.KO(), ((("<msg><videomsg aeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnthumbaeskey=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey + "\" cdnvideourl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "cdnthumburl=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId + "\" ") + "length=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + "\" ") + "cdnthumblength=\"" + com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength + "\"/></msg>");
                                this.hZb.hYz.iav = r2;
                                t.e(this.hZb.hYz);
                            }
                            Map q = bh.q(this.hZb.hYz.Lh(), "msg");
                            if (q != null) {
                                s KV = o.KV();
                                o.KV();
                                boolean o = KV.o(s.lv(this.hZb.fyF), (String) q.get(".msg.videomsg.$cdnvideourl"), (String) q.get(".msg.videomsg.$aeskey"));
                                gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf((o ? 1 : 2) + 900);
                                objArr[1] = Integer.valueOf(this.hZb.hYz.hrs);
                                gVar.i(12696, objArr);
                            }
                            n vd = h.vd();
                            String str2 = this.hZb.fyF;
                            if (z2) {
                                i2 = 0;
                            } else {
                                g gVar2 = this.hZb;
                                o.KV();
                                String lv = s.lv(gVar2.hYz.getFileName());
                                if (c.mD(lv)) {
                                    i2 = 0;
                                    com.tencent.mm.plugin.a.b bVar = new com.tencent.mm.plugin.a.b();
                                    long mC = bVar.mC(lv);
                                    long j = bVar.ilF;
                                    if (mC < 131072 && mC > 0 && gVar2.hYz.iap > 5 && bVar.ilG > 0 && j > 0) {
                                        i2 = ((int) j) + ((int) ((bVar.ilG * 5) / ((long) gVar2.hYz.iap)));
                                        if (i2 <= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                                            i2 += WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                                        }
                                    }
                                    w.i("MicroMsg.NetSceneUploadVideo", "%s check preload length[%d] moovPos[%d %d] duration[%d] filelen[%d]", gVar2.KO(), Integer.valueOf(i2), Long.valueOf(mC), Long.valueOf(j), Integer.valueOf(gVar2.hYz.iap), Long.valueOf(bVar.ilG));
                                } else {
                                    w.w("MicroMsg.NetSceneUploadVideo", "%s check preload length but it not mp4.", gVar2.KO());
                                    i2 = 0;
                                }
                            }
                            final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult2 = com_tencent_mm_modelcdntran_keep_SceneResult;
                            vd.a(new h(str2, i2, com_tencent_mm_modelcdntran_keep_SceneResult, new a(this) {
                                final /* synthetic */ AnonymousClass1 hZc;

                                public final void bb(int i, int i2) {
                                    if (i == 4 && i2 == 102) {
                                        h.vL().D(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 hZd;

                                            {
                                                this.hZd = r1;
                                            }

                                            public final void run() {
                                                this.hZd.hZc.hZb.hGO = false;
                                                this.hZd.hZc.hZb.hYz.status = 104;
                                                this.hZd.hZc.hZb.hYz.iam = bg.Ny();
                                                this.hZd.hZc.hZb.hYz.ian = bg.Ny();
                                                this.hZd.hZc.hZb.hYz.hYV = 0;
                                                this.hZd.hZc.hZb.hYz.fRW = 1800;
                                                boolean e = t.e(this.hZd.hZc.hZb.hYz);
                                                w.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", this.hZd.hZc.hZb.KO(), Boolean.valueOf(this.hZd.hZc.hZb.hGO), Boolean.valueOf(e), Long.valueOf(this.hZd.hZc.hZb.hYz.iam));
                                                this.hZd.hZc.hZb.a(this.hZd.hZc.hZb.hsD, this.hZd.hZc.hZb.gUD);
                                            }
                                        });
                                        return;
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(this.hZc.hZb.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hZc.hZb.hYB), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult2.field_fileLength), com_tencent_mm_modelcdntran_keep_SceneResult2.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult2.report_Part2);
                                    a.a(this.hZc.hZb.hYz, 0);
                                    g gVar = this.hZc.hZb;
                                    keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult = com_tencent_mm_modelcdntran_keep_SceneResult2;
                                    n KT = n.KT();
                                    o.KV();
                                    KT.a(com_tencent_mm_modelcdntran_keep_SceneResult, s.lv(gVar.fyF));
                                    this.hZc.hZb.gUD.a(i, i2, "", this.hZc.hZb);
                                }
                            }), 0);
                        }
                    }
                    return 0;
                } else if (this.hZb.hYz.hYV > com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                    w.w("MicroMsg.NetSceneUploadVideo", "%s cdntra cdnEndProc error oldpos:%d newpos:%d", this.hZb.KO(), Integer.valueOf(this.hZb.hYz.hYV), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                    return 0;
                } else {
                    this.hZb.hYz.ian = bg.Ny();
                    this.hZb.hYz.hYV = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                    this.hZb.hYz.fRW = 1032;
                    t.e(this.hZb.hYz);
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
    public boolean hGO = true;
    public String hGx = "";
    com.tencent.mm.compatible.util.g.a hKg = null;
    public int hYB = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
    boolean hYC = false;
    private final long hYT = 1800000;
    boolean hYU = false;
    private int hYV = -1;
    public boolean hYW = false;
    public boolean hYX = false;
    public int hYY = 0;
    private int hYZ = 0;
    public r hYz;
    int hZa = 0;
    aj hqQ = new aj(new aj.a(this) {
        final /* synthetic */ g hZb;

        {
            this.hZb = r1;
        }

        public final boolean oQ() {
            if (this.hZb.a(this.hZb.hsD, this.hZb.gUD) == -1) {
                this.hZb.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                this.hZb.gUD.a(3, -1, "doScene failed", this.hZb);
            }
            return false;
        }
    }, true);
    public long startTime = 0;

    private boolean KL() {
        if (o.fF(this.hYz.Le())) {
            w.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn user:%s", KO(), this.hYz.Le());
            return false;
        }
        com.tencent.mm.modelcdntran.g.El();
        if (com.tencent.mm.modelcdntran.c.fA(2) || this.hYz.iau == 1) {
            this.hGx = d.a("upvideo", this.hYz.iam, this.hYz.Le(), this.hYz.getFileName());
            if (bg.mA(this.hGx)) {
                w.w("MicroMsg.NetSceneUploadVideo", "%s cdntra genClientId failed not use cdn file:%s", KO(), this.hYz.getFileName());
                return false;
            }
            o.KV();
            String lw = s.lw(this.fyF);
            o.KV();
            String lv = s.lv(this.fyF);
            com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
            hVar.hze = this.hGH;
            hVar.field_mediaId = this.hGx;
            hVar.field_fullpath = lv;
            hVar.field_thumbpath = ll(lw);
            hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
            hVar.field_enable_hitcheck = this.hGO;
            hVar.field_largesvideo = com.tencent.mm.modelcontrol.d.Eu().iV(lv);
            if (this.hYz != null && 3 == this.hYz.iaw) {
                hVar.field_smallVideoFlag = 1;
            }
            String str = "MicroMsg.NetSceneUploadVideo";
            String str2 = "%s upload video MMSightExtInfo is null? %b %s";
            Object[] objArr = new Object[3];
            objArr[0] = KO();
            objArr[1] = Boolean.valueOf(this.hYz.iaz == null);
            objArr[2] = this.fyF;
            w.i(str, str2, objArr);
            if (this.hYz.iaz != null && this.hYz.iaz.tOs) {
                w.i("MicroMsg.NetSceneUploadVideo", "%s local capture video, mark use large video", KO());
                o.KV();
                n.KT().a("", s.lv(this.fyF), this.hYz.Le(), "", "", 2, 2);
                hVar.field_largesvideo = true;
            }
            str = "MicroMsg.NetSceneUploadVideo";
            str2 = "%s checkAD file:%s adinfo:%s";
            objArr = new Object[3];
            objArr[0] = KO();
            objArr[1] = this.hYz.getFileName();
            objArr[2] = this.hYz.iay == null ? "null" : this.hYz.iay.hjJ;
            w.i(str, str2, objArr);
            if (!(this.hYz.iay == null || bg.mA(this.hYz.iay.hjJ))) {
                hVar.field_advideoflag = 1;
            }
            hVar.field_talker = this.hYz.Le();
            hVar.field_chattype = o.dH(this.hYz.Le()) ? 1 : 0;
            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
            hVar.field_needStorage = false;
            hVar.field_isStreamMedia = false;
            hVar.field_trysafecdn = true;
            this.hYZ = com.tencent.mm.a.e.aN(hVar.field_fullpath);
            this.hYY = com.tencent.mm.a.e.aN(hVar.field_thumbpath);
            if (this.hYY >= com.tencent.mm.modelcdntran.b.hya) {
                w.w("MicroMsg.NetSceneUploadVideo", "%s cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", KO(), hVar.field_thumbpath, Integer.valueOf(this.hYY));
                return false;
            }
            int i;
            Map q = bh.q(this.hYz.Lh(), "msg");
            if (q != null) {
                hVar.field_fileId = (String) q.get(".msg.videomsg.$cdnvideourl");
                hVar.field_aesKey = (String) q.get(".msg.videomsg.$aeskey");
                this.hYX = true;
            } else {
                w.i("MicroMsg.NetSceneUploadVideo", "%s cdntra parse video recv xml failed", KO());
                try {
                    boolean z;
                    boolean z2;
                    boolean z3;
                    String[] split;
                    String[] split2 = bg.mz(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("UseVideoHash")).split(",");
                    h.vJ();
                    h.vG();
                    int aw = com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH(), 100);
                    boolean z4 = (split2 == null || split2.length <= 0) ? false : bg.getInt(split2[0], 0) >= aw;
                    boolean z5 = (split2 == null || split2.length < 2) ? false : bg.getInt(split2[1], 0) >= aw;
                    boolean z6 = (split2 == null || split2.length < 3) ? false : bg.getInt(split2[2], 0) >= aw;
                    if (com.tencent.mm.sdk.a.b.bIu()) {
                        z = true;
                        z2 = true;
                        z3 = true;
                    } else {
                        z = z5;
                        z2 = z4;
                        z3 = z6;
                    }
                    if (z2) {
                        s KV = o.KV();
                        w.i("MicroMsg.VideoInfoStorage", "checkVideoHash in fullCheckRatio:%s path:%s stack:%s", Integer.valueOf(bg.getInt(split2[2], 0)), lv, bg.bJZ());
                        long Nz = bg.Nz();
                        if (bg.mA(lv)) {
                            w.e("MicroMsg.VideoInfoStorage", "checkVideoHash failed , path:%s ", lv);
                            lw = "";
                        } else {
                            int[] ly = s.ly(lv);
                            if (ly == null || ly.length < 33) {
                                w.e("MicroMsg.VideoInfoStorage", "checkVideoHash  readHash failed :%s", lv);
                                lw = "";
                            } else {
                                int i2;
                                KV.hnH.eE("VideoHash", "delete from VideoHash where CreateTime < " + (bg.Ny() - 432000));
                                int i3 = ly[32];
                                StringBuffer stringBuffer = new StringBuffer();
                                for (i = 0; i < 32; i++) {
                                    stringBuffer.append(Integer.toHexString(ly[i]));
                                }
                                int length = stringBuffer.length();
                                Vector vector = new Vector();
                                Vector vector2 = new Vector();
                                Vector vector3 = new Vector();
                                Vector vector4 = new Vector();
                                int i4 = -1;
                                Cursor a = KV.hnH.a("select size, CreateTime, hash, cdnxml, orgpath from VideoHash where size = " + i3, null, 0);
                                while (a.moveToNext()) {
                                    long j = a.getLong(1);
                                    String string = a.getString(2);
                                    String string2 = a.getString(3);
                                    String string3 = a.getString(4);
                                    w.v("MicroMsg.VideoInfoStorage", "checkVideoHash select [%s][%s]", string, string2);
                                    if (bg.mA(string) || bg.mA(string2)) {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(104), Integer.valueOf(i3));
                                        w.w("MicroMsg.VideoInfoStorage", "checkVideoHash select error [%s][%s]", string, string2);
                                    } else if (length != string.length()) {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(MMGIFException.D_GIF_ERR_NO_IMAG_DSCR), Integer.valueOf(i3));
                                        w.w("MicroMsg.VideoInfoStorage", "checkVideoHash err length file:%d cursor:%d", Integer.valueOf(length), Integer.valueOf(string.length()));
                                    } else {
                                        i2 = 0;
                                        aw = 0;
                                        while (aw < length) {
                                            if (stringBuffer.charAt(aw) == string.charAt(aw)) {
                                                i = i2 + 1;
                                            } else {
                                                i = i2;
                                            }
                                            aw++;
                                            i2 = i;
                                        }
                                        if (i4 < 0 || vector3.size() <= i4 || ((Integer) vector3.get(i4)).intValue() < i2) {
                                            i = vector3.size();
                                        } else {
                                            i = i4;
                                        }
                                        vector3.add(Integer.valueOf(i2));
                                        vector.add(string2);
                                        vector2.add(string3);
                                        vector4.add(Long.valueOf(j));
                                        w.d("MicroMsg.VideoInfoStorage", "checkVideoHash cursor hitCount:%d/%d ,max:%d vector:%d/%d", Integer.valueOf(i2), Integer.valueOf(length), vector3.get(i), Integer.valueOf(i), Integer.valueOf(vector3.size()));
                                        i4 = i;
                                    }
                                }
                                a.close();
                                if (i4 < 0 || vector3.size() <= 0) {
                                    com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.bh.CTRL_INDEX), Integer.valueOf(i3));
                                    w.w("MicroMsg.VideoInfoStorage", "checkVideoHash cursor empty maxHitIndex:%d vector:%d", Integer.valueOf(i4), Integer.valueOf(vector3.size()));
                                    lw = "";
                                } else {
                                    int intValue = ((Integer) vector3.get(i4)).intValue();
                                    length = (intValue * 100) / 256;
                                    if (length < 77) {
                                        com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(f.CTRL_INDEX), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()));
                                        w.w("MicroMsg.VideoInfoStorage", "checkVideoHash NotEnoughHit. time:%d hit:%d percentMatch:%s arr:%d path:%s", Long.valueOf(bg.aA(Nz)), Integer.valueOf(intValue), Integer.valueOf(length), Integer.valueOf(ly.length - 1), lv);
                                        lw = "";
                                    } else {
                                        str2 = bg.mz((String) vector.get(i4));
                                        i2 = 0;
                                        int i5 = 0;
                                        while (i5 < vector3.size()) {
                                            if (i5 == i4 || ((Integer) vector3.get(i5)).intValue() < intValue || str2.hashCode() == ((String) vector.get(i5)).hashCode()) {
                                                i = i2;
                                            } else {
                                                i = i2 + 1;
                                            }
                                            i5++;
                                            i2 = i;
                                        }
                                        if (i2 > 0) {
                                            KV.hnH.eE("VideoHash", "delete from VideoHash where size = " + i3);
                                            com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(aq.CTRL_INDEX), Integer.valueOf(i3), Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(vector4.size()), Integer.valueOf(0), "", "", "", Integer.valueOf(i2));
                                            w.e("MicroMsg.VideoInfoStorage", "checkVideoHash Not ONE hash hit this path, give up duplicate:%s path:%s", Integer.valueOf(i2), lv);
                                            lw = "";
                                        } else {
                                            Nz = bg.aA(Nz);
                                            long a2 = bg.a((Long) vector4.get(i4), 0);
                                            com.tencent.mm.plugin.report.service.g.oUh.i(12696, (Object[]) new Object[]{Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX), String.format("%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(intValue), Long.valueOf(a2), Integer.valueOf(vector4.size()), Long.valueOf(Nz)})});
                                            com.tencent.mm.plugin.report.service.g.oUh.i(12696, (Object[]) new Object[]{Integer.valueOf(length + 3000), r5});
                                            w.i("MicroMsg.VideoInfoStorage", "checkVideoHash Succ time:%s hit:%s match:%s%% savetime:%s path:%s xml:%s orgpath:%s", Long.valueOf(Nz), Integer.valueOf(intValue), Integer.valueOf(length), Long.valueOf(a2), lv, str2, vector2.get(i4));
                                            lw = (String) vector2.get(i4);
                                            z4 = bg.Nz() % 1000 < ((long) (r14 * 10)) || length < 90;
                                            w.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff should:%s now:%s ratio:%s percentMatch:%s debuger:%s", Boolean.valueOf(z4), Long.valueOf(Nz), Integer.valueOf(r14), Integer.valueOf(length), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIu()));
                                            if (z4 || com.tencent.mm.sdk.a.b.bIu()) {
                                                com.tencent.mm.sdk.f.e.b(new com.tencent.mm.modelvideo.s.AnonymousClass2(KV, lv, lw, r5), "checkVideoHashByteDiff", 1);
                                            }
                                            lw = str2;
                                        }
                                    }
                                }
                            }
                        }
                        if (!bg.mA(lw)) {
                            split = lw.split("##");
                            if (z && split != null && split.length == 2) {
                                hVar.field_fileId = split[0];
                                hVar.field_aesKey = split[1];
                                this.hYW = true;
                            }
                            w.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", KO(), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIu()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.hYW), hVar.field_fileId, hVar.field_aesKey);
                        }
                    }
                    split = null;
                    hVar.field_fileId = split[0];
                    hVar.field_aesKey = split[1];
                    this.hYW = true;
                    w.i("MicroMsg.NetSceneUploadVideo", "%s CheckUseVideoHash debug:%s str:%s [%s,%s,%s] hasHash:%s [%s,%s]", KO(), Boolean.valueOf(com.tencent.mm.sdk.a.b.bIu()), r12, Boolean.valueOf(z2), Boolean.valueOf(z), Boolean.valueOf(z3), Boolean.valueOf(this.hYW), hVar.field_fileId, hVar.field_aesKey);
                } catch (Throwable e) {
                    w.e("MicroMsg.NetSceneUploadVideo", "Check use videohash :%s", bg.g(e));
                }
            }
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
            objArr = new Object[2];
            i = this.hYW ? 1 : this.hYX ? 2 : 0;
            objArr[0] = Integer.valueOf(i + 700);
            objArr[1] = Integer.valueOf(this.hYz.hrs);
            gVar.i(12696, objArr);
            if (bg.mA(hVar.field_aesKey) || bg.mA(hVar.field_aesKey)) {
                lw = "";
                hVar.field_aesKey = lw;
                hVar.field_fileId = lw;
            }
            w.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn check hit cache VideoHash :%s %s %s %b %b", KO(), hVar.field_mediaId, hVar.field_fileId, hVar.field_aesKey, Boolean.valueOf(this.hGO), Boolean.valueOf(hVar.field_largesvideo));
            if (com.tencent.mm.modelcdntran.g.El().b(hVar)) {
                if (this.hYz.iau != 1) {
                    this.hYz.iau = 1;
                    this.hYz.status = 104;
                    this.hYz.clientId = this.hGx;
                    this.hYz.fRW = 524544;
                    t.e(this.hYz);
                }
                return true;
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 226, 1, false);
            w.e("MicroMsg.NetSceneUploadVideo", "%s cdntra addSendTask failed.", KO());
            this.hGx = "";
            return false;
        }
        r4 = new Object[3];
        com.tencent.mm.modelcdntran.g.El();
        r4[1] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.fA(2));
        r4[2] = Integer.valueOf(this.hYz.iau);
        w.w("MicroMsg.NetSceneUploadVideo", "%s cdntra not use cdn flag:%b getCdnInfo:%d", r4);
        return false;
    }

    public g(String str) {
        Assert.assertTrue(str != null);
        w.d("MicroMsg.NetSceneUploadVideo", "NetSceneUploadVideo:  file:" + str);
        this.fyF = str;
        this.hYz = t.lH(str);
        if (this.hYz != null) {
            this.MAX_TIMES = 2500;
        } else {
            this.MAX_TIMES = 0;
        }
        this.hKg = new com.tencent.mm.compatible.util.g.a();
        if (this.hYz != null && 3 == this.hYz.iaw) {
            this.hYB = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        w.i("MicroMsg.NetSceneUploadVideo", "%s NetSceneUploadVideo:  videoType:[%d]", KO(), Integer.valueOf(this.hYB));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        this.hYz = t.lH(this.fyF);
        if (this.hYz == null || !(this.hYz.status == 104 || this.hYz.status == 103)) {
            w.e("MicroMsg.NetSceneUploadVideo", "%s Get info Failed file:", KO(), this.fyF);
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        }
        StringBuilder append = new StringBuilder("doscene file:").append(this.fyF).append(" stat:").append(this.hYz.status).append(" [").append(this.hYz.iak).append(",").append(this.hYz.ial).append("] [").append(this.hYz.hYV).append(",").append(this.hYz.hrs).append("]  netTimes:").append(this.hYz.iar).append(" times:");
        int i = this.hZa;
        this.hZa = i + 1;
        w.d("MicroMsg.NetSceneUploadVideo", append.append(i).toString());
        if (this.startTime == 0) {
            this.startTime = bg.Nz();
            this.hYV = this.hYz.hYV;
        }
        if (KL()) {
            w.d("MicroMsg.NetSceneUploadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fyF);
            return 0;
        }
        String aV;
        if (this.hYz.iat == 1) {
            this.hYU = true;
        } else if (this.hYz.iam + 600 < bg.Ny()) {
            w.e("MicroMsg.NetSceneUploadVideo", "create time check error:" + this.fyF);
            t.lA(this.fyF);
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        } else if (!t.lz(this.fyF)) {
            w.e("MicroMsg.NetSceneUploadVideo", "checkVoiceNetTimes Failed file:" + this.fyF);
            t.lA(this.fyF);
            this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hsm = new bid();
        aVar.hsn = new bie();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.hsl = com.tencent.mm.plugin.appbrand.jsapi.g.c.CTRL_INDEX;
        aVar.hso = 39;
        aVar.hsp = 1000000039;
        this.gUA = aVar.BE();
        bid com_tencent_mm_protocal_c_bid = (bid) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bid.mvV = (String) h.vI().vr().get(2, (Object) "");
        com_tencent_mm_protocal_c_bid.mvU = this.hYz.Le();
        com_tencent_mm_protocal_c_bid.tfU = this.fyF;
        if (this.hYU) {
            com_tencent_mm_protocal_c_bid.uhD = 2;
        }
        if (this.hYz.iaw == 3) {
            com_tencent_mm_protocal_c_bid.uhD = 3;
        }
        com_tencent_mm_protocal_c_bid.uhC = this.hYz.iap;
        com_tencent_mm_protocal_c_bid.tOS = this.hYz.ial;
        com_tencent_mm_protocal_c_bid.uhz = this.hYz.hrs;
        com_tencent_mm_protocal_c_bid.tua = aa.bn(ab.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_bid.tOV = 2;
        com_tencent_mm_protocal_c_bid.uhA = 0;
        com_tencent_mm_protocal_c_bid.uhB = new avw().bb(new byte[0]);
        com_tencent_mm_protocal_c_bid.tOU = new avw().bb(new byte[0]);
        if (bg.mA(this.fVC)) {
            o.KV();
            aV = com.tencent.mm.a.g.aV(s.lv(this.fyF));
            this.fVC = aV;
        } else {
            aV = this.fVC;
        }
        com_tencent_mm_protocal_c_bid.uhG = aV;
        com_tencent_mm_protocal_c_bid.tfi = ba.zz();
        com_tencent_mm_protocal_c_bid.uhP = this.hYz.fUY;
        bdu com_tencent_mm_protocal_c_bdu = this.hYz.iay;
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
        w.d("MicroMsg.NetSceneUploadVideo", "upload video: play length %d, thumb totalLen %d, video totalLen %d, funcFlag %d, videoMd5: %s stream %s streamtime: %d title %s thumburl %s", Integer.valueOf(com_tencent_mm_protocal_c_bid.uhC), Integer.valueOf(com_tencent_mm_protocal_c_bid.tOT), Integer.valueOf(com_tencent_mm_protocal_c_bid.uhz), Integer.valueOf(com_tencent_mm_protocal_c_bid.uhD), com_tencent_mm_protocal_c_bid.uhG, com_tencent_mm_protocal_c_bid.uhH, Integer.valueOf(com_tencent_mm_protocal_c_bid.uhI), com_tencent_mm_protocal_c_bid.uhJ, com_tencent_mm_protocal_c_bid.uhM);
        s.b h;
        Object obj;
        if (this.hYz.status == 103) {
            o.KV();
            h = s.h(s.lw(this.fyF), this.hYz.iak, hYS);
            if (h.ret < 0 || h.fAK == 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 225, 1, false);
                t.lA(this.fyF);
                w.e("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fyF + "]  Error ");
                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                return -1;
            }
            w.d("MicroMsg.NetSceneUploadVideo", "doScene READ THUMB[" + this.fyF + "] read ret:" + h.ret + " readlen:" + h.fAK + " newOff:" + h.iaP + " netOff:" + this.hYz.iak);
            if (h.iaP < this.hYz.iak) {
                w.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ THUMB[" + this.fyF + "] newOff:" + h.iaP + " OldtOff:" + this.hYz.iak);
                t.lA(this.fyF);
                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                return -1;
            }
            obj = new byte[h.fAK];
            System.arraycopy(h.buf, 0, obj, 0, h.fAK);
            com_tencent_mm_protocal_c_bid.tOT = this.hYz.iak;
            com_tencent_mm_protocal_c_bid.tOU = new avw().bb(obj);
        } else {
            o.KV();
            h = s.h(s.lv(this.fyF), this.hYz.hYV, hYS);
            if (h.ret < 0 || h.fAK == 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 224, 1, false);
                t.lA(this.fyF);
                w.e("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fyF + "]  Error ");
                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                return -1;
            }
            w.d("MicroMsg.NetSceneUploadVideo", "doScene READ VIDEO[" + this.fyF + "] read ret:" + h.ret + " readlen:" + h.fAK + " newOff:" + h.iaP + " netOff:" + this.hYz.hYV);
            if (h.iaP < this.hYz.hYV) {
                w.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fyF + "] newOff:" + h.iaP + " OldtOff:" + this.hYz.hYV);
                t.lA(this.fyF);
                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                return -1;
            } else if (h.iaP >= 20971520) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 222, 1, false);
                w.e("MicroMsg.NetSceneUploadVideo", "Err doScene READ VIDEO[" + this.fyF + "] maxsize:20971520");
                t.lA(this.fyF);
                this.fEX = 0 - (com.tencent.mm.compatible.util.g.sb() + 10000);
                return -1;
            } else {
                obj = new byte[h.fAK];
                System.arraycopy(h.buf, 0, obj, 0, h.fAK);
                com_tencent_mm_protocal_c_bid.uhA = this.hYz.hYV;
                com_tencent_mm_protocal_c_bid.tOT = this.hYz.iak;
                com_tencent_mm_protocal_c_bid.uhB = new avw().bb(obj);
            }
        }
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        bid com_tencent_mm_protocal_c_bid = (bid) ((b) pVar).hsj.hsr;
        if (!bg.mA(com_tencent_mm_protocal_c_bid.tfU) && com_tencent_mm_protocal_c_bid.tOV > 0 && !bg.mA(com_tencent_mm_protocal_c_bid.mvV) && !bg.mA(com_tencent_mm_protocal_c_bid.mvU) && com_tencent_mm_protocal_c_bid.tua > 0 && com_tencent_mm_protocal_c_bid.tOT <= com_tencent_mm_protocal_c_bid.tOS && com_tencent_mm_protocal_c_bid.tOT >= 0 && com_tencent_mm_protocal_c_bid.uhA <= com_tencent_mm_protocal_c_bid.uhz && com_tencent_mm_protocal_c_bid.uhA >= 0 && ((com_tencent_mm_protocal_c_bid.uhA != com_tencent_mm_protocal_c_bid.uhz || com_tencent_mm_protocal_c_bid.tOT != com_tencent_mm_protocal_c_bid.tOS) && com_tencent_mm_protocal_c_bid.tOS > 0 && com_tencent_mm_protocal_c_bid.uhz > 0 && (com_tencent_mm_protocal_c_bid.uhB.tZn > 0 || com_tencent_mm_protocal_c_bid.tOU.tZn > 0))) {
            return b.hsT;
        }
        w.e("MicroMsg.NetSceneUploadVideo", "ERR: Security Check Failed file:" + this.fyF + " user:" + com_tencent_mm_protocal_c_bid.mvU);
        return b.hsU;
    }

    protected final int ub() {
        return this.MAX_TIMES;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.oUh.a(111, 221, 1, false);
        t.lA(this.fyF);
    }

    public final boolean BJ() {
        boolean BJ = super.BJ();
        if (BJ) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 210, 1, false);
        }
        return BJ;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneUploadVideo", "cdntra onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " useCdnTransClientId:" + this.hGx);
        if (this.hYC) {
            w.d("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Call Stop by Service   file:" + this.fyF + " user:" + this.hYz.Le());
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bg.mA(this.hGx)) {
            w.w("MicroMsg.NetSceneUploadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hGx);
        } else {
            bie com_tencent_mm_protocal_c_bie = (bie) ((b) pVar).hsk.hsr;
            bid com_tencent_mm_protocal_c_bid = (bid) ((b) pVar).hsj.hsr;
            this.hYz = t.lH(this.fyF);
            if (this.hYz == null) {
                w.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fyF);
                this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                this.gUD.a(i2, i3, str, this);
            } else if (this.hYz.status == MMGIFException.D_GIF_ERR_NO_IMAG_DSCR) {
                w.w("MicroMsg.NetSceneUploadVideo", "onGYNetEnd STATUS PAUSE [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                this.gUD.a(i2, i3, str, this);
            } else if (this.hYz.status != 104 && this.hYz.status != 103) {
                w.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hYz.status + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                this.gUD.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 == -22) {
                w.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fyF + " user:" + this.hYz.Le());
                t.lB(this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 220, 1, false);
                w.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fyF + " user:" + this.hYz.Le());
                t.lA(this.fyF);
                com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hYB), Integer.valueOf(0));
                this.gUD.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 219, 1, false);
                w.e("MicroMsg.NetSceneUploadVideo", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fyF + " user:" + this.hYz.Le());
                this.gUD.a(i2, i3, str, this);
            } else if (!bg.bm(com_tencent_mm_protocal_c_bid.tOU.tZp.sYA) && com_tencent_mm_protocal_c_bid.tOT != com_tencent_mm_protocal_c_bie.tOT - com_tencent_mm_protocal_c_bid.tOU.tZn) {
                w.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + com_tencent_mm_protocal_c_bid.tOT + "," + com_tencent_mm_protocal_c_bid.tOU.tZn + "," + com_tencent_mm_protocal_c_bie.tOT + "] file:" + this.fyF + " user:" + com_tencent_mm_protocal_c_bid.mvU);
                t.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else if (bg.bm(com_tencent_mm_protocal_c_bid.uhB.tZp.sYA) || com_tencent_mm_protocal_c_bid.uhA == com_tencent_mm_protocal_c_bie.uhA - com_tencent_mm_protocal_c_bid.uhB.tZn) {
                this.hYz.ian = bg.Ny();
                this.hYz.fTQ = com_tencent_mm_protocal_c_bie.tfk;
                this.hYz.fRW = 1028;
                w.d("MicroMsg.NetSceneUploadVideo", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(this.hYz.fTQ), Integer.valueOf(r.iiX));
                if (!(10007 != r.iiW || r.iiX == 0 || this.hYz.fTQ == 0)) {
                    this.hYz.fTQ = (long) r.iiX;
                    r.iiX = 0;
                }
                Object obj = null;
                int i4 = this.hYz.status;
                if (i4 == 103) {
                    this.hYz.iak = com_tencent_mm_protocal_c_bid.tOU.tZn + com_tencent_mm_protocal_c_bid.tOT;
                    this.hYz.fRW |= 64;
                    if (this.hYz.iak >= this.hYz.ial) {
                        this.hYz.status = 104;
                        this.hYz.fRW |= 256;
                    }
                } else if (i4 == 104) {
                    this.hYz.hYV = com_tencent_mm_protocal_c_bid.uhB.tZn + com_tencent_mm_protocal_c_bid.uhA;
                    this.hYz.fRW |= 8;
                    if (this.hYz.hYV >= this.hYz.hrs) {
                        this.hYz.status = 199;
                        this.hYz.fRW |= 256;
                        t.c(this.hYz);
                        obj = 1;
                    }
                } else {
                    w.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd ERROR STATUS:" + i4 + " file:" + this.fyF + " user:" + com_tencent_mm_protocal_c_bid.mvU);
                    t.lA(this.fyF);
                    this.gUD.a(i2, i3, str, this);
                    return;
                }
                t.e(this.hYz);
                if (this.hYC) {
                    this.gUD.a(i2, i3, str, this);
                } else if (obj == null) {
                    this.hqQ.v(10, 10);
                } else {
                    boolean z;
                    com.tencent.mm.modelstat.b.hUp.f(((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA((long) this.hYz.iaq));
                    com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(d.aU(ab.getContext())), Integer.valueOf(this.hYB), Integer.valueOf(this.hYz.hrs - this.hYV));
                    if (this.hYz == null) {
                        z = false;
                    } else {
                        com.tencent.mm.j.a Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(this.hYz.Le());
                        z = (Rc == null || ((int) Rc.gTQ) <= 0) ? false : Rc.bLe();
                    }
                    if (z || o.fh(this.hYz.Le())) {
                        w.i("MicroMsg.NetSceneUploadVideo", "upload to biz :%s", this.hYz.Le());
                        if (this.hYz.fTQ < 0) {
                            w.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hYz.fTQ + " file:" + this.fyF + " toUser:" + this.hYz.Le());
                            t.lA(this.fyF);
                        }
                    } else {
                        w.i("MicroMsg.NetSceneUploadVideo", "not upload to biz");
                        if (this.hYz.fTQ <= 0) {
                            w.e("MicroMsg.NetSceneUploadVideo", "ERR: finish video invaild MSGSVRID :" + this.hYz.fTQ + " file:" + this.fyF + " toUser:" + this.hYz.Le());
                            t.lA(this.fyF);
                        }
                    }
                    long se = this.hKg != null ? this.hKg.se() : 0;
                    w.d("MicroMsg.NetSceneUploadVideo", "!!!FIN: file:" + this.fyF + " toUser:" + this.hYz.Le() + " msgsvrid:" + this.hYz.fTQ + " thumbsize:" + this.hYz.ial + " videosize:" + this.hYz.hrs + " useTime:" + se);
                    w.d("MicroMsg.NetSceneUploadVideo", "FinishLogForTime file:" + this.fyF + " packSize:" + hYS + " filesize:" + this.hYz.hrs + " useTime:" + se);
                    a.a(this.hYz, 0);
                    this.gUD.a(i2, i3, str, this);
                }
            } else {
                w.e("MicroMsg.NetSceneUploadVideo", "onGYNetEnd Err Thumb Pos:[" + com_tencent_mm_protocal_c_bid.uhA + "," + com_tencent_mm_protocal_c_bid.uhB.tZn + "," + com_tencent_mm_protocal_c_bie.uhA + "] file:" + this.fyF + " user:" + com_tencent_mm_protocal_c_bid.mvU);
                t.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
            }
        }
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.g.c.CTRL_INDEX;
    }

    private String ll(String str) {
        boolean z;
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable e;
        File file = new File(str);
        File file2 = new File(file.getParentFile(), "send" + file.getName());
        InputStream inputStream = null;
        OutputStream outputStream = null;
        boolean z2 = false;
        w.d("MicroMsg.NetSceneUploadVideo", "getSendThumbnailPath:origin file: %d", Long.valueOf(file.length()));
        try {
            if (file.length() <= 32768) {
                z = z2;
            } else if (file2.exists()) {
                w.d("MicroMsg.NetSceneUploadVideo", "dst file %s exist!", file2.getAbsolutePath());
                z = true;
            } else {
                Options Pe = com.tencent.mm.sdk.platformtools.d.Pe(file.getAbsolutePath());
                String str2 = "MicroMsg.NetSceneUploadVideo";
                String str3 = "getSendThumbnailPath:options %s";
                Object[] objArr = new Object[1];
                objArr[0] = Pe == null ? "null" : Pe.outWidth + "-" + Pe.outHeight;
                w.i(str2, str3, objArr);
                if (Pe == null || (Pe.outWidth <= 288 && Pe.outHeight <= 288)) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        Bitmap a = com.tencent.mm.sdk.platformtools.d.a(fileInputStream, 0.0f, 288, 288);
                        if (a != null) {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                z = a.compress(CompressFormat.JPEG, 60, fileOutputStream);
                                outputStream = fileOutputStream;
                                inputStream = fileInputStream;
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    w.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bg.g(e));
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            z = z2;
                                        } catch (IOException e4) {
                                            z = z2;
                                        }
                                    } else {
                                        z = z2;
                                    }
                                    if (z) {
                                        w.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", KO(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                                        return file2.getAbsolutePath();
                                    }
                                    w.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", KO(), Long.valueOf(file.length()), file.getAbsolutePath());
                                    return str;
                                } catch (Throwable th) {
                                    e = th;
                                    outputStream = fileOutputStream;
                                    inputStream = fileInputStream;
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    throw e;
                                }
                            }
                        }
                        z = z2;
                        inputStream = fileInputStream;
                    } catch (Exception e7) {
                        e = e7;
                        fileOutputStream = null;
                        w.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bg.g(e));
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            z = z2;
                        } else {
                            fileOutputStream.close();
                            z = z2;
                        }
                        if (z) {
                            w.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", KO(), Long.valueOf(file2.length()), file2.getAbsolutePath());
                            return file2.getAbsolutePath();
                        }
                        w.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", KO(), Long.valueOf(file.length()), file.getAbsolutePath());
                        return str;
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw e;
                    }
                }
                z = com.tencent.mm.sdk.platformtools.d.a(file.getAbsolutePath(), 288, 288, CompressFormat.JPEG, 60, file2.getParentFile().getAbsolutePath() + "/", file2.getName());
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e8) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e9) {
                }
            }
        } catch (Exception e10) {
            e = e10;
            fileOutputStream = null;
            fileInputStream = null;
            w.e("MicroMsg.NetSceneUploadVideo", "exception: %s", bg.g(e));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
                z = z2;
            } else {
                z = z2;
            }
            if (z) {
                w.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", KO(), Long.valueOf(file.length()), file.getAbsolutePath());
                return str;
            }
            w.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", KO(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        } catch (Throwable th3) {
            e = th3;
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw e;
        }
        if (z) {
            w.i("MicroMsg.NetSceneUploadVideo", "%s compress success: length=%d | path=%s", KO(), Long.valueOf(file2.length()), file2.getAbsolutePath());
            return file2.getAbsolutePath();
        }
        w.i("MicroMsg.NetSceneUploadVideo", "%s compress fail: origin length=%d | path=%s", KO(), Long.valueOf(file.length()), file.getAbsolutePath());
        return str;
    }

    public final String KO() {
        return this.fyF + "_" + hashCode();
    }
}
