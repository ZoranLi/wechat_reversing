package com.tencent.mm.modelvideo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class d extends k implements j {
    int fEX;
    public String fyF;
    private b gUA;
    public e gUD;
    public String hGE;
    public int hGF;
    private a hGH;
    public String hGx;
    public i hYA;
    public int hYB;
    private boolean hYC;
    public long hYD;
    public boolean hYx;
    public boolean hYy;
    public r hYz;
    private aj hqQ;
    public int hrs;
    private String mediaId;
    private int startOffset;
    public long startTime;

    public final boolean pd() {
        boolean z = false;
        if (!bg.mA(this.mediaId)) {
            if (this.hYx) {
                w.i("MicroMsg.NetSceneDownloadVideo", "cancel online video task.");
                o.KW().b(this.mediaId, null);
            } else {
                w.i("MicroMsg.NetSceneDownloadVideo", "cancel offline video task.");
                g.El().iP(this.mediaId);
            }
            z = true;
        }
        this.hYC = true;
        return z;
    }

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        boolean z2 = false;
        this.hYz = null;
        this.hGx = "";
        this.startOffset = 0;
        this.startTime = 0;
        this.hrs = 0;
        this.fEX = 0;
        this.hYB = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.hYC = false;
        this.hGE = null;
        this.hGF = 0;
        this.hYD = 0;
        this.hGH = new a(this) {
            final /* synthetic */ d hYE;

            {
                this.hYE = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21006) {
                    w.d("MicroMsg.NetSceneDownloadVideo", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", this.hYE.hGx);
                    return 0;
                } else if (i != 0) {
                    t.lA(this.hYE.fyF);
                    com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.hYE.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(this.hYE.hYB), Integer.valueOf(this.hYE.hrs), "");
                    com.tencent.mm.plugin.report.service.g.oUh.i(13937, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(this.hYE.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(this.hYE.hYB), Integer.valueOf(this.hYE.hrs), "");
                    this.hYE.gUD.a(3, i, "", this.hYE);
                    return 0;
                } else {
                    this.hYE.hYz = t.lH(this.hYE.fyF);
                    int i2;
                    if (this.hYE.hYz == null || this.hYE.hYz.status == 113) {
                        w.i("MicroMsg.NetSceneDownloadVideo", "upload video info is null or has paused, status:%d", Integer.valueOf(this.hYE.hYz == null ? -1 : this.hYE.hYz.status));
                        this.hYE.pd();
                        this.hYE.gUD.a(3, i, "upload video info is null or has paused, status" + i2, this.hYE);
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null) {
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            w.i("MicroMsg.NetSceneDownloadVideo", "cdntra sceneResult.retCode:%d useTime:%d ", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Long.valueOf(bg.Nz() - this.hYE.hYD));
                            d.a(this.hYE.hYA, com_tencent_mm_modelcdntran_keep_SceneResult);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                t.lA(this.hYE.fyF);
                                if (this.hYE.hYx) {
                                    com.tencent.mm.plugin.report.service.g.oUh.a(354, 13, 1, false);
                                }
                                if (this.hYE.hYy) {
                                    com.tencent.mm.plugin.report.service.g.oUh.a(354, 136, 1, false);
                                }
                                this.hYE.gUD.a(3, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode, "", this.hYE);
                            } else {
                                if (this.hYE.hYx) {
                                    com.tencent.mm.plugin.report.service.g.oUh.a(354, 12, 1, false);
                                }
                                if (this.hYE.hYy) {
                                    r lH = t.lH(this.hYE.fyF);
                                    if (lH != null) {
                                        lH.videoFormat = 1;
                                        lH.fRW = 2;
                                        o.KV().b(lH);
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.a(354, 137, 1, false);
                                }
                                this.hYE.gN(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
                            }
                            com.tencent.mm.plugin.report.service.g.oUh.i(10421, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.hYE.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(this.hYE.hYB), Integer.valueOf(this.hYE.hrs), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(13937, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(2), Long.valueOf(this.hYE.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(this.hYE.hYB), Integer.valueOf(this.hYE.hrs), com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, "", "", "", "", "", "", "", com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
                            }
                            a.a(this.hYE.hYz, 1);
                            this.hYE.hYA = null;
                        }
                        return 0;
                    } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == this.hYE.hrs) {
                        w.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                        return 0;
                    } else if (this.hYE.hYz.iaj <= com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength || this.hYE.hYx) {
                        i2 = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        this.hYE.hYz.ian = bg.Ny();
                        if (this.hYE.hYz.iaj < com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                            this.hYE.hYz.iaj = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                            i2 = 1040;
                        }
                        this.hYE.hYz.fRW = i2;
                        t.e(this.hYE.hYz);
                        w.d("MicroMsg.NetSceneDownloadVideo", "cdntra progresscallback id:%s finish:%d total:%d", this.hYE.hGx, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength));
                        return 0;
                    } else {
                        w.e("MicroMsg.NetSceneDownloadVideo", "cdnEndProc error oldpos:%d newpos:%d", Integer.valueOf(this.hYE.hYz.iaj), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                        t.lA(this.hYE.fyF);
                        this.hYE.gUD.a(3, i, "", this.hYE);
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
        this.hqQ = new aj(new aj.a(this) {
            final /* synthetic */ d hYE;

            {
                this.hYE = r1;
            }

            public final boolean oQ() {
                if (this.hYE.a(this.hYE.hsD, this.hYE.gUD) == -1) {
                    this.hYE.gUD.a(3, -1, "doScene failed", this.hYE);
                }
                return false;
            }
        }, false);
        if (str != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        w.i("MicroMsg.NetSceneDownloadVideo", "NetSceneDownloadVideo:  file:" + str + " isCompleteOnlineVideo : " + z);
        this.fyF = str;
        this.hYx = z;
    }

    private boolean KL() {
        w.d("MicroMsg.NetSceneDownloadVideo", "parseVideoMsgXML content:" + this.hYz.Lh());
        Map q = bh.q(this.hYz.Lh(), "msg");
        if (q == null) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 214, 1, false);
            w.w("MicroMsg.NetSceneDownloadVideo", "cdntra parse video recv xml failed");
            return false;
        }
        String str = (String) q.get(".msg.videomsg.$cdnvideourl");
        if (bg.mA(str)) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 213, 1, false);
            w.w("MicroMsg.NetSceneDownloadVideo", "cdntra parse video recv xml failed");
            return false;
        }
        String str2 = (String) q.get(".msg.videomsg.$aeskey");
        this.hrs = Integer.valueOf((String) q.get(".msg.videomsg.$length")).intValue();
        String str3 = (String) q.get(".msg.videomsg.$fileparam");
        this.hGx = com.tencent.mm.modelcdntran.d.a("downvideo", this.hYz.iam, this.hYz.Le(), this.hYz.getFileName());
        if (bg.mA(this.hGx)) {
            w.w("MicroMsg.NetSceneDownloadVideo", "cdntra genClientId failed not use cdn file:%s", this.hYz.getFileName());
            return false;
        }
        int i;
        Object obj;
        String Le;
        int i2;
        int subtype;
        String str4 = (String) q.get(".msg.videomsg.$md5");
        StringBuilder stringBuilder = new StringBuilder();
        o.KV();
        String stringBuilder2 = stringBuilder.append(s.lv(this.fyF)).append(".tmp").toString();
        this.hYA = new i();
        this.hYA.filename = this.hYz.getFileName();
        this.hYA.hzr = str4;
        this.hYA.hzs = this.hrs;
        this.hYA.hzt = 0;
        this.hYA.fOu = this.hYz.Lf();
        this.hYA.hzu = this.hYz.Le();
        this.hYA.fOw = o.dH(this.hYz.Le()) ? com.tencent.mm.u.j.eC(this.hYz.Le()) : 0;
        this.hYA.field_mediaId = this.hGx;
        this.hYA.field_fullpath = stringBuilder2;
        this.hYA.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.hYA.field_totalLen = this.hrs;
        this.hYA.field_aesKey = str2;
        this.hYA.field_fileId = str;
        this.hYA.field_priority = com.tencent.mm.modelcdntran.b.hxL;
        this.hYA.hze = this.hGH;
        this.hYA.field_wxmsgparam = str3;
        this.hYA.field_chattype = o.dH(this.hYz.Le()) ? 1 : 0;
        this.hYA.hzv = this.hYz.hzv;
        ce x = ((h) com.tencent.mm.kernel.h.h(h.class)).aJX().x(this.hYz.Le(), this.hYz.fTQ);
        this.hYA.hzx = x.field_createTime;
        this.hYA.fTQ = x.field_msgSvrId;
        ay.b gm = ay.gm(x.gxF);
        this.hYA.hzy = gm != null ? gm.hna : 0;
        if (this.hYz.Le().equals(x.field_talker)) {
            this.hYA.field_limitrate = gm == null ? 0 : gm.hmY / 8;
        }
        w.d("MicroMsg.NetSceneDownloadVideo", "limitrate:%d file:%s", Integer.valueOf(this.hYA.field_limitrate), this.hYz.getFileName());
        if (g.El().hyr.contains("video_" + this.hYz.iaq)) {
            g.El().hyr.remove("video_" + this.hYz.iaq);
            this.hYA.field_autostart = true;
        } else {
            this.hYA.field_autostart = false;
        }
        if (3 == this.hYz.iaw) {
            this.hYA.field_smallVideoFlag = 1;
        }
        if (!(bg.mA(str4) || this.hYx)) {
            str2 = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().cH(str4, this.hrs);
            int aN = com.tencent.mm.a.e.aN(str2);
            int i3 = this.hrs - aN;
            o.KV();
            str3 = s.lv(this.fyF);
            if (com.tencent.mm.a.e.aN(str3) > 0) {
                w.w("MicroMsg.NetSceneDownloadVideo", "already copy dup file, but download again, something error here.");
                boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(str3);
                at wY = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
                int i4 = this.hrs;
                i = 0;
                if (!bg.mA(str4)) {
                    i = wY.gUz.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str4, String.valueOf(i4), "100"});
                }
                r lH = t.lH(this.fyF);
                lH.iaj = 0;
                lH.fRW = 16;
                t.e(lH);
                w.w("MicroMsg.NetSceneDownloadVideo", "don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", Integer.valueOf(r8), Boolean.valueOf(deleteFile), Integer.valueOf(i));
                str2 = "";
            }
            w.i("MicroMsg.NetSceneDownloadVideo", "MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", Integer.valueOf(this.hrs), str4, Integer.valueOf(aN), str2, Integer.valueOf(i3), stringBuilder2, Integer.valueOf(r8));
            if (bg.mA(str2)) {
                this.hGE = str4;
                this.hGF = this.hrs;
            } else if (i3 >= 0 && i3 <= 16) {
                w.i("MicroMsg.NetSceneDownloadVideo", "MediaCheckDuplicationStorage copy dup file now :%s -> %s", str2, stringBuilder2);
                com.tencent.mm.sdk.platformtools.j.ex(str2, stringBuilder2);
                gN(this.hrs);
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                Object[] objArr = new Object[7];
                objArr[0] = str;
                objArr[1] = Long.valueOf(this.hYz.fTQ);
                objArr[2] = str4;
                objArr[3] = Long.valueOf(this.hYz.iam);
                objArr[4] = this.hYz.Le();
                objArr[5] = Integer.valueOf(3 != this.hYz.iaw ? 43 : 62);
                objArr[6] = Integer.valueOf(aN);
                gVar.i(13267, objArr);
                obj = 1;
                if (obj == null) {
                    this.mediaId = this.hYA.field_mediaId;
                    this.hYD = bg.Nz();
                    this.hYy = this.hYz.videoFormat != 2;
                    w.i("MicroMsg.NetSceneDownloadVideo", "%d check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(this.hYy), Boolean.valueOf(this.hYx));
                    if (this.hYy && this.hYx) {
                        i iVar = this.hYA;
                        o.KV();
                        iVar.field_fullpath = s.lv(this.fyF);
                        o.KW().a(this.hYA, false);
                    } else if (!g.El().b(this.hYA, -1)) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(111, 212, 1, false);
                        w.e("MicroMsg.NetSceneDownloadVideo", "cdntra addSendTask failed.");
                        this.hGx = "";
                        return false;
                    } else if (this.hYy) {
                        com.tencent.mm.plugin.report.service.g.oUh.a(354, 135, 1, false);
                    }
                }
                if (this.hYz.iau != 1) {
                    this.hYz.iau = 1;
                    this.hYz.fRW = SQLiteGlobal.journalSizeLimit;
                    t.e(this.hYz);
                }
                if (3 != this.hYz.iaw) {
                    Le = this.hYz.Le();
                    if (!bg.mA(Le)) {
                        if (o.dH(Le)) {
                            i2 = 0;
                        } else {
                            i2 = com.tencent.mm.u.j.eC(Le);
                        }
                        try {
                            NetworkInfo activeNetworkInfo;
                            activeNetworkInfo = ((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                            subtype = activeNetworkInfo.getSubtype();
                            if (activeNetworkInfo.getType() != 1) {
                                i = 1;
                            } else if (subtype != 13 || subtype == 15 || subtype == 14) {
                                i = 4;
                            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                                i = 3;
                            } else if (subtype == 1 || subtype == 2) {
                                i = 2;
                            } else {
                                i = 0;
                            }
                        } catch (Throwable e) {
                            w.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", bg.g(e));
                            i = 0;
                        }
                        w.i("MicroMsg.NetSceneDownloadVideo", "dk12024 report:%s", Le + "," + i2 + "," + str + "," + this.hrs + "," + i);
                        com.tencent.mm.plugin.report.service.g.oUh.A(12024, str);
                    }
                }
                return true;
            }
        }
        obj = null;
        if (obj == null) {
            this.mediaId = this.hYA.field_mediaId;
            this.hYD = bg.Nz();
            if (this.hYz.videoFormat != 2) {
            }
            this.hYy = this.hYz.videoFormat != 2;
            w.i("MicroMsg.NetSceneDownloadVideo", "%d check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(this.hYy), Boolean.valueOf(this.hYx));
            if (this.hYy) {
            }
            if (!g.El().b(this.hYA, -1)) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 212, 1, false);
                w.e("MicroMsg.NetSceneDownloadVideo", "cdntra addSendTask failed.");
                this.hGx = "";
                return false;
            } else if (this.hYy) {
                com.tencent.mm.plugin.report.service.g.oUh.a(354, 135, 1, false);
            }
        }
        if (this.hYz.iau != 1) {
            this.hYz.iau = 1;
            this.hYz.fRW = SQLiteGlobal.journalSizeLimit;
            t.e(this.hYz);
        }
        if (3 != this.hYz.iaw) {
            Le = this.hYz.Le();
            if (bg.mA(Le)) {
                if (o.dH(Le)) {
                    i2 = 0;
                } else {
                    i2 = com.tencent.mm.u.j.eC(Le);
                }
                activeNetworkInfo = ((ConnectivityManager) ab.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                subtype = activeNetworkInfo.getSubtype();
                if (activeNetworkInfo.getType() != 1) {
                    if (subtype != 13) {
                    }
                    i = 4;
                } else {
                    i = 1;
                }
                w.i("MicroMsg.NetSceneDownloadVideo", "dk12024 report:%s", Le + "," + i2 + "," + str + "," + this.hrs + "," + i);
                com.tencent.mm.plugin.report.service.g.oUh.A(12024, str);
            }
        }
        return true;
    }

    public final void gN(final int i) {
        StringBuilder stringBuilder = new StringBuilder();
        o.KV();
        File file = new File(stringBuilder.append(s.lv(this.fyF)).append(".tmp").toString());
        o.KV();
        file.renameTo(new File(s.lv(this.fyF)));
        com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
            final /* synthetic */ d hYE;

            public final void run() {
                Map q = bh.q(this.hYE.hYz.Lh(), "msg");
                if (q != null) {
                    s KV = o.KV();
                    o.KV();
                    KV.o(s.lv(this.hYE.fyF), (String) q.get(".msg.videomsg.$cdnvideourl"), (String) q.get(".msg.videomsg.$aeskey"));
                }
                boolean H = t.H(this.hYE.fyF, i);
                w.i("MicroMsg.NetSceneDownloadVideo", "ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d", this.hYE.fyF, Long.valueOf(this.hYE.hYz.fTQ), this.hYE.hYz.Lf(), this.hYE.hYz.Le(), Boolean.valueOf(H), this.hYE.hGE, Integer.valueOf(this.hYE.hGF));
                if (!bg.mA(this.hYE.hGE) && this.hYE.hGF > 0) {
                    at wY = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY();
                    String str = this.hYE.hGE;
                    int i = this.hYE.hGF;
                    o.KV();
                    wY.p(str, i, s.lv(this.hYE.fyF));
                }
                if (this.hYE.hYz.iaw == 3) {
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 38, (long) this.hYE.hYz.hrs, false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 40, (long) this.hYE.hYz.iap, false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 41, 1, false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, o.dH(this.hYE.hYz.Le()) ? 43 : 42, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 31, (long) this.hYE.hYz.hrs, false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 33, (long) this.hYE.hYz.iap, false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, 34, 1, false);
                    com.tencent.mm.plugin.report.service.g.oUh.a(198, o.dH(this.hYE.hYz.Le()) ? 36 : 35, 1, false);
                }
                this.hYE.gUD.a(0, 0, "", this.hYE);
            }
        });
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 1;
        this.gUD = eVar2;
        this.hYz = t.lH(this.fyF);
        if (this.hYz == null) {
            w.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fyF);
            this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
            return -1;
        }
        if (this.hYz != null && 3 == this.hYz.iaw) {
            this.hYB = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = bg.Nz();
            this.startOffset = this.hYz.iaj;
        }
        if (KL()) {
            w.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fyF);
            return 0;
        } else if (this.hYz.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            w.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.hYz.status + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "]");
            this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
            return -1;
        } else {
            w.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "]  filesize:" + this.hYz.iaj + " file:" + this.hYz.hrs + " netTimes:" + this.hYz.iar);
            if (!t.lz(this.fyF)) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.hYz.iar + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                return -1;
            } else if (this.hYz.fTQ <= 0) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.hYz.fTQ + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                return -1;
            } else if (this.hYz.iaj < 0 || this.hYz.hrs <= this.hYz.iaj || this.hYz.hrs <= 0) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.hYz.iaj + " total:" + this.hYz.hrs + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                return -1;
            } else {
                b.a aVar = new b.a();
                aVar.hsm = new ol();
                aVar.hsn = new om();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                aVar.hsl = ck.CTRL_INDEX;
                aVar.hso = 40;
                aVar.hsp = 1000000040;
                this.gUA = aVar.BE();
                ol olVar = (ol) this.gUA.hsj.hsr;
                olVar.tfk = this.hYz.fTQ;
                olVar.tgK = this.hYz.iaj;
                olVar.tgJ = this.hYz.hrs;
                if (!aa.bn(ab.getContext())) {
                    i = 2;
                }
                olVar.tua = i;
                return a(eVar, this.gUA, this);
            }
        }
    }

    protected final int a(p pVar) {
        ol olVar = (ol) ((b) pVar).hsj.hsr;
        if (olVar.tfk > 0 && olVar.tgK >= 0 && olVar.tgJ > 0 && olVar.tgJ > olVar.tgK) {
            return b.hsT;
        }
        w.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
        t.lA(this.fyF);
        return b.hsU;
    }

    protected final int ub() {
        return 2500;
    }

    public final boolean BJ() {
        boolean BJ = super.BJ();
        if (BJ) {
            com.tencent.mm.plugin.report.service.g.oUh.a(111, 210, 1, false);
        }
        return BJ;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.oUh.a(111, 211, 1, false);
        t.lA(this.fyF);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (this.hYC) {
            w.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
            this.gUD.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bg.mA(this.hGx)) {
            w.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hGx);
        } else {
            om omVar = (om) ((b) pVar).hsk.hsr;
            ol olVar = (ol) ((b) pVar).hsj.hsr;
            this.hYz = t.lH(this.fyF);
            if (this.hYz == null) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fyF);
                this.fEX = (0 - com.tencent.mm.compatible.util.g.sb()) - 10000;
                this.gUD.a(i2, i3, str, this);
            } else if (this.hYz.status == 113) {
                w.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                this.gUD.a(i2, i3, str, this);
            } else if (this.hYz.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hYz.status + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                this.gUD.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 208, 1, false);
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(this.hYB), Integer.valueOf(this.hrs - this.startOffset));
                this.gUD.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.g.oUh.a(111, 207, 1, false);
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i2 + " errCode:" + i3 + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                this.hYz.status = 113;
                t.e(this.hYz);
                this.gUD.a(i2, i3, str, this);
            } else if (bg.bm(omVar.tsk.tZp.sYA)) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else if (omVar.tgK != olVar.tgK) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + omVar.tgK + " reqStartPos:" + olVar.tgK + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else if (omVar.tgJ != olVar.tgJ) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + omVar.tgJ + " reqTotal:" + olVar.tgJ + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else if (olVar.tgJ < omVar.tgK) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + omVar.tgJ + " respStartPos:" + olVar.tgK + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else if (omVar.tfk != olVar.tfk) {
                w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + omVar.tfk + " reqMsgId:" + olVar.tfk + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                t.lA(this.fyF);
                this.gUD.a(i2, i3, str, this);
            } else {
                w.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + omVar.tsk.tZn + " reqStartPos:" + olVar.tgK + " totallen:" + olVar.tgJ + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                o.KV();
                int a = s.a(s.lv(this.fyF), olVar.tgK, omVar.tsk.tZp.toByteArray());
                if (a < 0) {
                    w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                    t.lA(this.fyF);
                    this.gUD.a(i2, i3, str, this);
                } else if (a > this.hYz.hrs) {
                    w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a + " totalLen:" + this.hYz.hrs + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                    t.lA(this.fyF);
                    this.gUD.a(i2, i3, str, this);
                } else {
                    int sb;
                    String str2 = this.fyF;
                    r lH = t.lH(str2);
                    if (lH == null) {
                        w.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.sd() + " getinfo failed: " + str2);
                        sb = 0 - com.tencent.mm.compatible.util.g.sb();
                    } else {
                        lH.iaj = a;
                        lH.ian = bg.Ny();
                        lH.fRW = 1040;
                        sb = 0;
                        if (lH.hrs > 0 && a >= lH.hrs) {
                            t.d(lH);
                            lH.status = 199;
                            lH.fRW |= 256;
                            w.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a + " total:" + lH.hrs + " status:" + lH.status + " netTimes:" + lH.iar);
                            sb = 1;
                        }
                        w.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.sd() + " file:" + str2 + " newsize:" + a + " total:" + lH.hrs + " status:" + lH.status);
                        if (!t.e(lH)) {
                            sb = 0 - com.tencent.mm.compatible.util.g.sb();
                        }
                    }
                    if (sb < 0) {
                        w.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + sb + " newOffset :" + a + " [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "] ");
                        this.gUD.a(i2, i3, str, this);
                    } else if (sb == 1) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bg.Nz()), Integer.valueOf(com.tencent.mm.modelcdntran.d.aU(ab.getContext())), Integer.valueOf(this.hYB), Integer.valueOf(this.hrs - this.startOffset));
                        a.a(this.hYz, 1);
                        w.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fyF + "," + this.hYz.fTQ + "," + this.hYz.Lf() + "," + this.hYz.Le() + "]");
                        this.gUD.a(i2, i3, str, this);
                    } else if (this.hYC) {
                        this.gUD.a(i2, i3, str, this);
                    } else {
                        this.hqQ.v(0, 0);
                    }
                }
            }
        }
    }

    public final int getType() {
        return ck.CTRL_INDEX;
    }

    public static void a(i iVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (iVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            w.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
        } else if (iVar.field_smallVideoFlag == 1) {
            w.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
        } else if (iVar != null && com_tencent_mm_modelcdntran_keep_SceneResult != null) {
            w.i("MicroMsg.NetSceneDownloadVideo", "sceneResult.field_recvedBytes %d, time [%d, %d]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes), Long.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime), Long.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime));
            o.KW();
            f.a(null, com_tencent_mm_modelcdntran_keep_SceneResult, iVar, true);
        }
    }
}
