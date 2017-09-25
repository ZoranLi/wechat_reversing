package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.o;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f {
    long fGM;
    public String fGN;
    private com.tencent.mm.modelcdntran.h.a hGH = new com.tencent.mm.modelcdntran.h.a(this) {
        final /* synthetic */ f hYR;

        {
            this.hYR = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            if (i != 0) {
                w.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", Integer.valueOf(this.hYR.hashCode()), Integer.valueOf(i));
                if (this.hYR.hYQ != null) {
                    this.hYR.hYQ.a(this.hYR, false, 0, 0);
                }
            }
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                w.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", Integer.valueOf(this.hYR.hashCode()), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), str);
            }
            if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                w.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", Integer.valueOf(this.hYR.hashCode()), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode));
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == 0) {
                    w.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", Integer.valueOf(this.hYR.hashCode()));
                    this.hYR.d(this.hYR.hYK, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength, this.hYR.hzr);
                } else if (this.hYR.hYQ != null) {
                    this.hYR.hYQ.a(this.hYR, false, 0, 0);
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    private i hYA;
    public boolean hYJ = false;
    public String hYK;
    private long hYL;
    public long hYM;
    public long hYN;
    public int hYO;
    private String hYP;
    public a hYQ;
    private b hzp = new b(this) {
        final /* synthetic */ f hYR;

        {
            this.hYR = r1;
        }

        public final void onPreloadCompleted(String str, int i, int i2) {
            w.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d]", Integer.valueOf(this.hYR.hashCode()), str, this.hYR.hYK, Integer.valueOf(i), Integer.valueOf(i2));
            if (i > 0 && i2 > 0) {
                this.hYR.hYN = (long) f.c(this.hYR.hYK, i, true);
            }
            if (this.hYR.hYQ != null) {
                a aVar = this.hYR.hYQ;
                f fVar = this.hYR;
                boolean z = i > 0 && i2 > 0;
                aVar.a(fVar, z, i, i2);
            }
            this.hYR.hYM = bg.Ny();
            this.hYR.KN();
            if (this.hYR.hYJ) {
                g.oUh.a(354, 142, 1, false);
                if (this.hYR.hYO == 1) {
                    g.oUh.a(354, 123, 1, false);
                    return;
                } else {
                    g.oUh.a(354, 124, 1, false);
                    return;
                }
            }
            g.oUh.a(354, 143, 1, false);
        }
    };
    public String hzr;
    private String mediaId;

    public interface a {
        void a(f fVar, boolean z, int i, int i2);
    }

    public f(long j) {
        this.fGM = j;
        this.hYJ = true;
    }

    public f(i iVar, String str) {
        this.hYA = iVar;
        this.fGN = str;
        this.hYJ = false;
    }

    public final String KM() {
        return this.hYJ ? this.fGM : this.fGN;
    }

    public final void stop() {
        w.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", Integer.valueOf(hashCode()), this.mediaId);
        PInt pInt = new PInt();
        if (!bg.mA(this.mediaId)) {
            c El = com.tencent.mm.modelcdntran.g.El();
            String str = this.mediaId;
            int i = 0;
            if (((h) El.hyn.remove(str)) != null) {
                keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
                com.tencent.mm.modelcdntran.g.Em();
                i = com.tencent.mm.modelcdntran.b.a(str, com_tencent_mm_modelcdntran_keep_SceneResult);
                pInt.value = com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes;
                g.oUh.i(10769, Integer.valueOf(d.hyJ), Integer.valueOf(r0.field_fileType), Long.valueOf(bg.Nz() - r0.field_startTime));
            }
            El.hym.remove(str);
            El.hyo.remove(str);
            w.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(i));
            this.hYM = bg.Ny();
            this.hYN = (long) c(this.hYK, pInt.value, false);
            KN();
        }
        this.hYQ = null;
    }

    public final int a(a aVar) {
        this.hYQ = aVar;
        try {
            String str;
            String str2;
            h hVar;
            Object obj;
            w.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.fGM));
            h hVar2;
            if (this.hYJ) {
                ce cA = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().cA(this.fGM);
                ay.b gm = ay.gm(cA.gxF);
                if (gm == null || gm.hna <= 0) {
                    w.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", Integer.valueOf(hashCode()));
                    hVar2 = null;
                } else {
                    String str3 = cA.field_imgPath;
                    r lH = t.lH(str3);
                    if (lH == null) {
                        hVar2 = null;
                    } else {
                        Map q = bh.q(lH.Lh(), "msg");
                        if (q == null) {
                            w.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                            hVar2 = null;
                        } else {
                            str = (String) q.get(".msg.videomsg.$cdnvideourl");
                            if (bg.mA(str)) {
                                w.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                                hVar2 = null;
                            } else {
                                int intValue = Integer.valueOf((String) q.get(".msg.videomsg.$length")).intValue();
                                String str4 = (String) q.get(".msg.videomsg.$md5");
                                str2 = (String) q.get(".msg.videomsg.$newmd5");
                                String str5 = (String) q.get(".msg.videomsg.$aeskey");
                                String str6 = (String) q.get(".msg.videomsg.$fileparam");
                                String a = d.a("downvideo", lH.iam, lH.Le(), lH.getFileName());
                                if (bg.mA(a)) {
                                    w.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", lH.getFileName());
                                    hVar2 = null;
                                } else {
                                    o.KV();
                                    String lv = s.lv(str3);
                                    h iVar = new i();
                                    iVar.filename = str3;
                                    iVar.hzr = str4;
                                    iVar.hzs = intValue;
                                    iVar.hzt = 2;
                                    iVar.fOu = lH.Lf();
                                    iVar.hzu = lH.Le();
                                    iVar.fOw = o.dH(lH.Le()) ? j.eC(lH.Le()) : 0;
                                    iVar.field_mediaId = a;
                                    iVar.field_fullpath = lv;
                                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                    iVar.field_totalLen = intValue;
                                    iVar.field_aesKey = str5;
                                    iVar.field_fileId = str;
                                    iVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                                    iVar.field_wxmsgparam = str6;
                                    iVar.field_chattype = o.dH(lH.Le()) ? 1 : 0;
                                    iVar.field_autostart = false;
                                    iVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, lH);
                                    iVar.field_preloadRatio = gm.hna;
                                    iVar.fvn = str2;
                                    hVar2 = iVar;
                                }
                            }
                        }
                    }
                }
                if (hVar2 != null) {
                    this.hYO = o.dH(hVar2.hzu) ? 2 : 1;
                    g.oUh.a(354, 140, 1, false);
                    if (this.hYO == 1) {
                        g.oUh.a(354, 121, 1, false);
                        hVar = hVar2;
                    } else {
                        g.oUh.a(354, 122, 1, false);
                        hVar = hVar2;
                    }
                } else {
                    hVar = hVar2;
                }
            } else {
                this.hYO = 3;
                hVar2 = this.hYA;
                g.oUh.a(354, 141, 1, false);
                hVar = hVar2;
            }
            if (hVar == null) {
                w.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", Integer.valueOf(hashCode()));
                obj = null;
            } else {
                if (((Integer) com.tencent.mm.kernel.h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                    w.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
                } else if (!hVar.Ep()) {
                    str2 = hVar.hzr;
                    int i = hVar.hzs;
                    str = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().cH(str2, i);
                    int aN = i - e.aN(str);
                    if (!bg.mA(str) && aN >= 0 && aN <= 16) {
                        w.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, str);
                        com.tencent.mm.sdk.platformtools.j.ex(str, hVar.field_fullpath);
                        d(hVar.filename, i, str2);
                        obj = 1;
                        if (obj == null) {
                            w.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                            obj = null;
                        } else {
                            hVar.hzp = this.hzp;
                            hVar.hze = this.hGH;
                            hVar.hzn = 2;
                            this.hzr = hVar.hzr;
                            this.mediaId = hVar.field_mediaId;
                            this.hYK = hVar.filename;
                            this.hYL = bg.Ny();
                            this.hYP = hVar.fvn;
                            w.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), hVar);
                            com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
                            obj = 1;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    hVar.hzp = this.hzp;
                    hVar.hze = this.hGH;
                    hVar.hzn = 2;
                    this.hzr = hVar.hzr;
                    this.mediaId = hVar.field_mediaId;
                    this.hYK = hVar.filename;
                    this.hYL = bg.Ny();
                    this.hYP = hVar.fvn;
                    w.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), hVar);
                    com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
                    obj = 1;
                } else {
                    w.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                    obj = null;
                }
            }
            if (obj != null) {
                return 0;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", e, "", new Object[0]);
        }
        this.hYQ = null;
        return -1;
    }

    public static int c(String str, int i, boolean z) {
        r lH = t.lH(str);
        if (lH == null) {
            return i;
        }
        int i2;
        int i3 = lH.fOA;
        if (z) {
            lH.fOA = i;
        } else {
            lH.fOA = i3 + i;
        }
        w.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(lH.fOA), Boolean.valueOf(z));
        lH.ian = bg.Ny();
        lH.fRW = 1025;
        t.e(lH);
        if (z) {
            i2 = i - i3;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public final void d(String str, int i, String str2) {
        w.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), str2);
        if (t.lH(str) != null) {
            t.H(str, i);
            if (!bg.mA(str2)) {
                o.KV();
                String lv = s.lv(str);
                if (bg.mA(str2) || i <= 0 || bg.mA(lv) || !e.aO(lv)) {
                    w.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str2, lv);
                    return;
                }
                ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.r.a.a.class)).wY().p(str2, i, lv);
            }
        }
    }

    public final void KN() {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.hYL).append(",");
        stringBuffer.append(this.hYM).append(",");
        stringBuffer.append(this.hYN).append(",");
        stringBuffer.append(this.hYP).append(",");
        stringBuffer.append(this.hYO).append(",");
        try {
            i = (int) ((this.hYN / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / (this.hYM - this.hYL));
        } catch (Exception e) {
            i = 0;
        }
        stringBuffer.append(i).append(",");
        stringBuffer.append(0);
        w.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        g.oUh.A(14499, r0);
    }
}
