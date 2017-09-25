package com.tencent.mm.modelcdntran;

import com.tencent.mm.e.a.iu;
import com.tencent.mm.e.a.kk;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements a, e {
    public Map<String, i> hyS = new HashMap();
    public Map<String, keep_SceneResult> hyT = new HashMap();
    public Queue<String> hyl = new LinkedList();
    public Map<String, i> hym = new HashMap();
    public Map<String, i> hyn = new HashMap();

    public f() {
        h.vd().a(379, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 379) {
            w.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", Integer.valueOf(i), Integer.valueOf(i2));
            if (h.vG().uV()) {
                h.vL().D(new Runnable(this) {
                    final /* synthetic */ f hyU;

                    {
                        this.hyU = r1;
                    }

                    public final void run() {
                        this.hyU.be(true);
                    }
                });
            }
        }
    }

    public final boolean a(final i iVar, boolean z) {
        if (iVar == null) {
            w.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            return false;
        } else if (bg.mA(iVar.field_mediaId)) {
            w.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            return false;
        } else {
            w.i("MicroMsg.OnlineVideoService", "add download task : " + iVar.field_mediaId + " delay : " + z);
            if (iVar.field_fileId == null) {
                iVar.field_fileId = "";
            }
            if (iVar.field_aesKey == null) {
                iVar.field_aesKey = "";
            }
            iVar.fZK = false;
            if (b(iVar.field_mediaId, null) || z) {
                h.vL().D(new Runnable(this) {
                    final /* synthetic */ f hyU;

                    public final void run() {
                        this.hyU.hyl.add(iVar.field_mediaId);
                        this.hyU.hym.put(iVar.field_mediaId, iVar);
                        this.hyU.be(false);
                    }
                });
            } else {
                h.vL().D(new Runnable(this) {
                    final /* synthetic */ f hyU;

                    public final void run() {
                        this.hyU.hyl.add(iVar.field_mediaId);
                        this.hyU.hym.put(iVar.field_mediaId, iVar);
                        this.hyU.be(false);
                    }
                });
            }
            return true;
        }
    }

    public final boolean b(final String str, final Object[] objArr) {
        boolean z = false;
        if (!bg.mA(str)) {
            if (this.hyn.containsKey(str)) {
                z = true;
            } else {
                g.El().iP(str);
            }
            h.vL().D(new Runnable(this) {
                final /* synthetic */ f hyU;

                public final void run() {
                    i iVar = (i) this.hyU.hyn.remove(str);
                    keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult;
                    if (iVar != null) {
                        com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
                        g.Em();
                        if (b.a(iVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult) == 0) {
                            f.a(objArr, com_tencent_mm_modelcdntran_keep_SceneResult, iVar, false);
                        } else {
                            w.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(b.a(iVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult)), iVar.field_mediaId);
                        }
                    } else {
                        iVar = (i) this.hyU.hyS.remove(str);
                        com_tencent_mm_modelcdntran_keep_SceneResult = (keep_SceneResult) this.hyU.hyT.remove(str);
                        if (!(iVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null)) {
                            f.a(objArr, com_tencent_mm_modelcdntran_keep_SceneResult, iVar, true);
                        }
                    }
                    this.hyU.hym.remove(str);
                }
            });
        }
        w.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        if (((i) this.hyn.get(str)) == null) {
            w.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", str);
            return false;
        }
        g.Em();
        w.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(b.isVideoDataAvailable(str, i, i2)));
        return b.isVideoDataAvailable(str, i, i2);
    }

    public static int e(String str, int i, int i2) {
        g.Em();
        w.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(b.requestVideoData(str, i, i2, 0)));
        return b.requestVideoData(str, i, i2, 0);
    }

    public final void be(boolean z) {
        if (h.vG().uV()) {
            if (!z && g.Em().Ef()) {
                h.vG();
                if (a.uU()) {
                    w.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
                    g.El().be(z);
                    return;
                }
            }
            c.Eg();
            while (!this.hyl.isEmpty()) {
                String str = (String) this.hyl.poll();
                h hVar = (i) this.hym.remove(str);
                if (hVar != null) {
                    hVar.field_startTime = bg.Nz();
                    if (!hVar.fZK) {
                        Object obj;
                        b kkVar;
                        int a;
                        boolean Eo;
                        int i;
                        r lH;
                        int i2;
                        if (((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                            w.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
                        } else if (!hVar.Ep()) {
                            String str2 = hVar.hzr;
                            int i3 = hVar.hzs;
                            String cH = ((com.tencent.mm.plugin.r.a.a) h.h(com.tencent.mm.plugin.r.a.a.class)).wY().cH(str2, i3);
                            int aN = i3 - com.tencent.mm.a.e.aN(cH);
                            if (!bg.mA(cH) && aN >= 0 && aN <= 16) {
                                w.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", Integer.valueOf(i3), str2, cH);
                                j.ex(cH, hVar.field_fullpath);
                                a(t.lH(hVar.filename), i3, str2);
                                obj = 1;
                                if (obj == null) {
                                    kkVar = new kk();
                                    kkVar.fQO.fJK = 6;
                                    kkVar.fQO.mediaId = str;
                                    com.tencent.mm.sdk.b.a.urY.m(kkVar);
                                } else {
                                    if (hVar.Eo()) {
                                        g.Em();
                                        a = b.a(hVar, hVar.hzt);
                                    } else if (hVar.En()) {
                                        g.Em();
                                        a = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.hzt, hVar.iplist, hVar.initialDownloadOffset, hVar.initialDownloadLength, hVar.field_preloadRatio);
                                    } else {
                                        g.Em();
                                        a = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.hzt, hVar.iplist, hVar.initialDownloadOffset, hVar.initialDownloadLength, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.field_preloadRatio);
                                    }
                                    w.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", hVar, Integer.valueOf(a));
                                    if (a == 0) {
                                        w.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + hVar.field_mediaId);
                                        Eo = hVar.Eo();
                                        i = hVar.hzt;
                                        if (Eo) {
                                            g.oUh.a(354, 210, 1, false);
                                            if (i != 1) {
                                                g.oUh.a(354, 211, 1, false);
                                            } else {
                                                g.oUh.a(354, 212, 1, false);
                                            }
                                            g.oUh.i(13836, Integer.valueOf(m.CTRL_INDEX), Long.valueOf(bg.Ny()), "");
                                        } else {
                                            g.oUh.a(354, 3, 1, false);
                                            if (i != 1) {
                                                if (a == -21006) {
                                                    g.oUh.a(354, 100, 1, false);
                                                } else if (a != -20003) {
                                                    g.oUh.a(354, 101, 1, false);
                                                } else {
                                                    g.oUh.a(354, 102, 1, false);
                                                }
                                            } else if (a == -21006) {
                                                g.oUh.a(354, 106, 1, false);
                                            } else if (a != -20003) {
                                                g.oUh.a(354, 107, 1, false);
                                            } else {
                                                g.oUh.a(354, 108, 1, false);
                                            }
                                            g.oUh.i(13836, Integer.valueOf(100), Long.valueOf(bg.Ny()), "");
                                        }
                                    } else {
                                        hVar.hzq = bg.Nz();
                                        if (hVar.Eo()) {
                                            lH = t.lH(hVar.filename);
                                            if (lH != null) {
                                                i2 = lH.status;
                                                if (!(i2 == 120 || i2 == 122 || i2 == 121)) {
                                                    lH.status = 120;
                                                    lH.fRW = 256;
                                                    o.KV().b(lH);
                                                }
                                            }
                                        }
                                        this.hyn.put(hVar.field_mediaId, hVar);
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            if (hVar.Eo()) {
                                g.Em();
                                a = b.a(hVar, hVar.hzt);
                            } else if (hVar.En()) {
                                g.Em();
                                a = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.hzt, hVar.iplist, hVar.initialDownloadOffset, hVar.initialDownloadLength, hVar.field_preloadRatio);
                            } else {
                                g.Em();
                                a = b.a(hVar.field_mediaId, hVar.url, hVar.referer, hVar.field_fullpath, hVar.hzt, hVar.iplist, hVar.initialDownloadOffset, hVar.initialDownloadLength, hVar.isColdSnsData, hVar.signalQuality, hVar.snsScene, hVar.field_preloadRatio);
                            }
                            w.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", hVar, Integer.valueOf(a));
                            if (a == 0) {
                                hVar.hzq = bg.Nz();
                                if (hVar.Eo()) {
                                    lH = t.lH(hVar.filename);
                                    if (lH != null) {
                                        i2 = lH.status;
                                        lH.status = 120;
                                        lH.fRW = 256;
                                        o.KV().b(lH);
                                    }
                                }
                                this.hyn.put(hVar.field_mediaId, hVar);
                            } else {
                                w.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + hVar.field_mediaId);
                                Eo = hVar.Eo();
                                i = hVar.hzt;
                                if (Eo) {
                                    g.oUh.a(354, 210, 1, false);
                                    if (i != 1) {
                                        g.oUh.a(354, 212, 1, false);
                                    } else {
                                        g.oUh.a(354, 211, 1, false);
                                    }
                                    g.oUh.i(13836, Integer.valueOf(m.CTRL_INDEX), Long.valueOf(bg.Ny()), "");
                                } else {
                                    g.oUh.a(354, 3, 1, false);
                                    if (i != 1) {
                                        if (a == -21006) {
                                            g.oUh.a(354, 106, 1, false);
                                        } else if (a != -20003) {
                                            g.oUh.a(354, 108, 1, false);
                                        } else {
                                            g.oUh.a(354, 107, 1, false);
                                        }
                                    } else if (a == -21006) {
                                        g.oUh.a(354, 100, 1, false);
                                    } else if (a != -20003) {
                                        g.oUh.a(354, 102, 1, false);
                                    } else {
                                        g.oUh.a(354, 101, 1, false);
                                    }
                                    g.oUh.i(13836, Integer.valueOf(100), Long.valueOf(bg.Ny()), "");
                                }
                            }
                        } else {
                            kkVar = new kk();
                            kkVar.fQO.fJK = 6;
                            kkVar.fQO.mediaId = str;
                            com.tencent.mm.sdk.b.a.urY.m(kkVar);
                        }
                    }
                }
            }
        }
    }

    public final void onMoovReady(final String str, final int i, final int i2) {
        w.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", str);
        if (!bg.mA(str)) {
            h.vL().D(new Runnable(this) {
                final /* synthetic */ f hyU;

                public final void run() {
                    boolean z = false;
                    i iVar = (i) this.hyU.hyn.get(str);
                    if (iVar == null) {
                        return;
                    }
                    if (iVar.hzz != null) {
                        iVar.hzz.onMoovReady(str, i, i2);
                    } else if (q.lo(iVar.field_fullpath)) {
                        w.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + iVar.hzt);
                        if (iVar.hzt == 1) {
                            f.e(iVar.field_mediaId, 0, iVar.field_totalLen);
                            g.oUh.a(354, 19, 1, false);
                        }
                    } else {
                        b kkVar = new kk();
                        kkVar.fQO.fJK = 1;
                        kkVar.fQO.fEX = 0;
                        kkVar.fQO.mediaId = str;
                        kkVar.fQO.offset = i;
                        kkVar.fQO.length = i2;
                        kkVar.fQO.fQP = iVar.hzq;
                        kk.a aVar = kkVar.fQO;
                        if (iVar.initialDownloadLength > 0) {
                            z = true;
                        }
                        aVar.fQQ = z;
                        com.tencent.mm.sdk.b.a.urY.m(kkVar);
                        r lH = t.lH(iVar.filename);
                        if (lH != null) {
                            w.i("MicroMsg.OnlineVideoService", "on moov ready info: " + lH.getFileName() + " status : " + lH.status);
                            if (lH.status != 130 && lH.status != 122) {
                                lH = t.lH(iVar.filename);
                                if (lH != null) {
                                    lH.status = 121;
                                    lH.fRW = 256;
                                    o.KV().b(lH);
                                }
                                if (iVar.hzt == 0) {
                                    w.i("MicroMsg.OnlineVideoService", "stop download video");
                                    o.La().Lt();
                                    o.La().run();
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public final void onDataAvailable(final String str, final int i, final int i2) {
        w.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!bg.mA(str)) {
            h.vL().D(new Runnable(this) {
                final /* synthetic */ f hyU;

                public final void run() {
                    i iVar = (i) this.hyU.hyn.get(str);
                    if (iVar != null) {
                        if (iVar.hzz != null) {
                            iVar.hzz.onDataAvailable(str, i, i2);
                        }
                        b kkVar = new kk();
                        kkVar.fQO.fJK = 2;
                        kkVar.fQO.fEX = 0;
                        kkVar.fQO.mediaId = str;
                        kkVar.fQO.offset = i;
                        kkVar.fQO.length = i2;
                        com.tencent.mm.sdk.b.a.urY.m(kkVar);
                    }
                }
            });
        }
    }

    public final void onDownloadToEnd(final String str, final int i, final int i2) {
        w.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!bg.mA(str)) {
            h.vL().D(new Runnable(this) {
                final /* synthetic */ f hyU;

                public final void run() {
                    i iVar = (i) this.hyU.hyn.get(str);
                    if (iVar == null) {
                        return;
                    }
                    if (iVar.hzz != null) {
                        iVar.hzz.w(str, 0);
                        return;
                    }
                    b kkVar = new kk();
                    kkVar.fQO.fJK = 3;
                    kkVar.fQO.fEX = 0;
                    kkVar.fQO.mediaId = str;
                    kkVar.fQO.offset = i;
                    kkVar.fQO.length = i2;
                    com.tencent.mm.sdk.b.a.urY.m(kkVar);
                    if (i == 0 && i2 >= iVar.hzs) {
                        f.a(t.lH(iVar.filename), iVar.hzs, iVar.hzr);
                    }
                }
            });
        }
    }

    public final int a(final String str, final keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (bg.mA(str)) {
            w.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            return -1;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null && com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            w.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            return -2;
        } else {
            h.vL().D(new Runnable(this) {
                final /* synthetic */ f hyU;

                public final void run() {
                    i iVar = (i) this.hyU.hyn.get(str);
                    if (iVar != null) {
                        if (iVar.hzz == null) {
                            r lH = t.lH(iVar.filename);
                            if (lH == null) {
                                w.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", iVar.filename);
                            } else if (iVar.hze != null) {
                                iVar.hze.a(str, 0, com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, iVar.field_onlycheckexist);
                                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                                    this.hyU.hyn.remove(str);
                                }
                            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                                if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == lH.hrs) {
                                    w.i("MicroMsg.OnlineVideoService", "stream download finish.");
                                } else if (lH.status == 130 || lH.iaj <= com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) {
                                    w.i("MicroMsg.OnlineVideoService", "callback progress info " + com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength);
                                    lH.ian = bg.Ny();
                                    lH.iaj = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                                    lH.fRW = 1040;
                                    t.e(lH);
                                    r0 = new kk();
                                    r0.fQO.fJK = 5;
                                    r0.fQO.mediaId = str;
                                    r0.fQO.offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                                    r0.fQO.length = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                                    com.tencent.mm.sdk.b.a.urY.m(r0);
                                } else {
                                    w.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", Integer.valueOf(lH.iaj), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
                                }
                            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                                w.i("MicroMsg.OnlineVideoService", "callback result info " + com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode + ", filesize:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength + ",recved:" + com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes);
                                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != -10012) {
                                        t.lA(lH.getFileName());
                                    }
                                    boolean Eo = iVar.Eo();
                                    int i = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                                    int i2 = iVar.hzt;
                                    if (Eo) {
                                        if (i2 == 1) {
                                            if (i == -5103059) {
                                                g.oUh.a(354, 111, 1, false);
                                            } else if (i == -5103087) {
                                                g.oUh.a(354, 112, 1, false);
                                            } else if (i == -10012) {
                                                g.oUh.a(354, 113, 1, false);
                                            } else {
                                                g.oUh.a(354, 114, 1, false);
                                            }
                                        } else if (i == -5103059) {
                                            g.oUh.a(354, 116, 1, false);
                                        } else if (i == -5103087) {
                                            g.oUh.a(354, 117, 1, false);
                                        } else if (i == -10012) {
                                            g.oUh.a(354, 118, 1, false);
                                        } else {
                                            g.oUh.a(354, 119, 1, false);
                                        }
                                        g.oUh.i(13836, Integer.valueOf(101), Long.valueOf(bg.Ny()), Integer.valueOf(i));
                                    } else {
                                        g.oUh.a(354, 213, 1, false);
                                        if (i2 == 1) {
                                            g.oUh.a(354, 214, 1, false);
                                        } else {
                                            g.oUh.a(354, 215, 1, false);
                                        }
                                        g.oUh.i(13836, Integer.valueOf(bh.CTRL_INDEX), Long.valueOf(bg.Ny()), Integer.valueOf(i));
                                    }
                                } else {
                                    f.a(lH, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength, iVar.hzr);
                                    this.hyU.hyS.put(iVar.field_mediaId, iVar);
                                    this.hyU.hyT.put(iVar.field_mediaId, com_tencent_mm_modelcdntran_keep_SceneResult);
                                }
                                r0 = new kk();
                                r0.fQO.fJK = 4;
                                r0.fQO.mediaId = str;
                                r0.fQO.offset = 0;
                                r0.fQO.fEX = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                                r0.fQO.length = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                                com.tencent.mm.sdk.b.a.urY.m(r0);
                                this.hyU.hyn.remove(str);
                            }
                        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                            iVar.hzz.f(str, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength);
                        } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                            iVar.hzz.w(str, com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                        }
                    }
                }
            });
            if (this.hyn.get(str) != null) {
                return 1;
            }
            return 0;
        }
    }

    public static void a(r rVar, int i, String str) {
        w.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", Integer.valueOf(i));
        if (rVar != null) {
            t.H(rVar.getFileName(), i);
            String fileName = rVar.getFileName();
            if (!bg.mA(str)) {
                o.KV();
                String lv = s.lv(fileName);
                if (bg.mA(str) || i <= 0 || bg.mA(lv)) {
                    w.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str, lv);
                    return;
                }
                ((com.tencent.mm.plugin.r.a.a) h.h(com.tencent.mm.plugin.r.a.a.class)).wY().p(str, i, lv);
            }
        }
    }

    public static i a(an anVar, String str, String str2, String str3, int i) {
        if (anVar == null) {
            w.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            return null;
        } else if (bg.mA(str)) {
            w.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            return null;
        } else {
            r lH = t.lH(str3);
            if (lH == null) {
                w.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", str3);
                return null;
            }
            String a = d.a("snsvideo", (long) anVar.cIm, "sns", str);
            if (bg.mA(a)) {
                w.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", str);
                return null;
            }
            i iVar = new i();
            iVar.filename = str3;
            iVar.field_fullpath = str2;
            iVar.field_mediaId = a;
            iVar.hzo = 2;
            iVar.hzt = i;
            iVar.hzv = lH.hzv;
            String str4 = "";
            if (anVar == null) {
                a = "";
            } else if (anVar.equals(an.uJF)) {
                a = "album_friend";
            } else if (anVar.equals(an.uJG)) {
                a = "album_self";
            } else if (anVar.equals(an.uJH)) {
                a = "album_stranger";
            } else if (anVar.equals(an.uJI)) {
                a = "profile_friend";
            } else if (anVar.equals(an.uJJ)) {
                a = "profile_stranger";
            } else if (anVar.equals(an.uJK)) {
                a = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
            } else if (anVar.equals(an.uJE)) {
                a = "timeline";
            } else if (anVar.equals(an.uJN)) {
                a = "snssight";
            } else {
                a = str4;
            }
            String str5 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s";
            r3 = new Object[5];
            h.vJ();
            h.vG();
            r3[1] = com.tencent.mm.a.o.getString(a.uH());
            r3[2] = Integer.valueOf(am.getNetTypeForStat(ab.getContext()));
            r3[3] = Integer.valueOf(am.getStrength(ab.getContext()));
            r3[4] = !bg.mA(a) ? "&scene=" + a : "";
            iVar.referer = String.format(str5, r3);
            iVar.url = str;
            long j = (long) ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            w.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("SnsSightDomainList"), Long.valueOf(j), Integer.valueOf(anVar.cIm));
            if (j <= 0) {
                j = 259200;
            }
            boolean a2 = a(anVar, iVar.url, j, r5);
            try {
                iVar.host = new URL(iVar.url).getHost();
                List arrayList = new ArrayList();
                com.tencent.mm.network.b.a(a2, arrayList, iVar.host);
                iVar.iplist = new String[arrayList.size()];
                arrayList.toArray(iVar.iplist);
                iVar.isColdSnsData = bg.az((long) anVar.cIm) > j;
                iVar.signalQuality = am.getStrength(ab.getContext());
                iVar.snsScene = a;
                return iVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.OnlineVideoService", e, "check can sns online video error taskInfo %s", iVar);
                return null;
            }
        }
    }

    private static boolean a(an anVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (anVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || anVar.cIm == 0 || bg.az((long) anVar.cIm) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.OnlineVideoService", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    public static void a(Object[] objArr, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, i iVar, boolean z) {
        if (iVar == null || com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            w.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
        } else if (!iVar.Ep()) {
            int intValue;
            int intValue2;
            int intValue3;
            int intValue4;
            int intValue5;
            int intValue6;
            String str;
            w.i("MicroMsg.OnlineVideoService", "rpt online video format[%d]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat));
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat == 2) {
                r lH = t.lH(iVar.filename);
                if (lH != null) {
                    lH.videoFormat = 2;
                    lH.fRW = 2;
                    boolean b = o.KV().b(lH);
                    w.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", Boolean.valueOf(b), r2, Integer.valueOf(2));
                }
            }
            boolean Eo = iVar.Eo();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pInt2.value = 0;
            pInt.value = 0;
            t.a(iVar.field_fullpath, pInt, pInt2);
            int i = pInt.value * 1000;
            int i2 = pInt2.value;
            int i3 = 0;
            if (objArr != null) {
                intValue = ((Integer) objArr[0]).intValue() * 1000;
                intValue2 = ((Integer) objArr[1]).intValue();
                intValue3 = ((Integer) objArr[2]).intValue();
                int intValue7 = ((Integer) objArr[3]).intValue();
                intValue4 = ((Integer) objArr[4]).intValue();
                intValue5 = ((Integer) objArr[5]).intValue();
                intValue6 = ((Integer) objArr[6]).intValue();
                i3 = intValue7;
            } else {
                intValue5 = 0;
                intValue6 = 0;
                intValue = 0;
                intValue2 = 0;
                intValue3 = 0;
                intValue4 = 0;
            }
            int i4 = iVar.hzv;
            if (i4 <= 0) {
                if (Eo) {
                    i4 = 10;
                } else {
                    i4 = 31;
                }
            }
            int ef = am.ef(ab.getContext());
            StringBuffer stringBuffer = new StringBuffer();
            if (Eo) {
                stringBuffer.append(iVar.field_fileId).append(",").append(iVar.field_aesKey).append(",");
            } else {
                stringBuffer.append(iVar.url).append(",").append(iVar.hzw).append(",");
            }
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength).append(",").append(i).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes).append(",");
            stringBuffer.append(intValue + ",").append(intValue2 + ",").append(intValue3 + ",");
            stringBuffer.append(i3 + ",").append(intValue4 + ",");
            stringBuffer.append(ef).append(",");
            stringBuffer.append(i4).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime).append(",");
            if (Eo) {
                stringBuffer.append(iVar.hzu != null ? com.tencent.mm.a.g.n(iVar.hzu.getBytes()) : Integer.valueOf(0)).append(",");
                stringBuffer.append(com.tencent.mm.u.o.dH(iVar.hzu) ? 1 : 0).append(",");
            } else {
                stringBuffer.append(0).append(",");
                stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_httpStatusCode).append(",");
            }
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_enQueueTime).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestSize).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestDownloadSize).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCompleted ? 1 : 0).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_averageSpeed).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_averageConnectCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_firstConnectCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_netConnectTimes).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovRequestTimes).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCost).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovSize).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCompleted ? 1 : 0).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_moovFailReason).append(",");
            stringBuffer.append(intValue5).append(",");
            stringBuffer.append(intValue6).append(",");
            if (Eo) {
                stringBuffer.append(i2).append(",");
            } else {
                stringBuffer.append(i2).append(",");
                stringBuffer.append(iVar.hzu != null ? com.tencent.mm.a.g.n(iVar.hzu.getBytes()) : Integer.valueOf(0)).append(",");
            }
            String str2 = "";
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                for (String str3 : com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps) {
                    stringBuffer2.append(str3).append("|");
                }
                str2 = stringBuffer2.toString();
            }
            stringBuffer.append(str2).append(",");
            stringBuffer.append(iVar.hzx).append(",");
            stringBuffer.append(iVar.fTQ).append(",");
            stringBuffer.append(iVar.initialDownloadLength).append(",");
            stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat);
            w.i("MicroMsg.OnlineVideoService", "report online video %d:%s", Integer.valueOf(Eo ? 13570 : 13790), stringBuffer.toString());
            g.oUh.A(i3, r3);
            if (z) {
                String str4 = iVar.fOu;
                str3 = iVar.hzu;
                intValue2 = iVar.fOw;
                String str5 = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                long j = com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime;
                long j2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime;
                String str6 = iVar.field_fullpath;
                String[] strArr = com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps;
                String str7 = iVar.url;
                String str8 = iVar.filename;
                int i5 = iVar.hzy;
                r lH2 = t.lH(str8);
                if (lH2 != null) {
                    intValue4 = lH2.fOA;
                    i3 = lH2.hrs;
                    intValue5 = intValue4;
                    intValue4 = i3;
                } else {
                    intValue5 = 0;
                    intValue4 = 0;
                }
                if (i5 <= 0) {
                    i3 = 1;
                } else {
                    i3 = intValue5 < ((int) ((((float) i5) / 100.0f) * ((float) intValue4))) ? 2 : 3;
                    w.d("MicroMsg.OnlineVideoService", "rptMediaInfo %d * %d = configSize[%d] preloadSize[%d]", Integer.valueOf(i5), Integer.valueOf(intValue4), Integer.valueOf((int) ((((float) i5) / 100.0f) * ((float) intValue4))), Integer.valueOf(intValue5));
                }
                b iuVar = new iu();
                iuVar.fOt.fOu = str4;
                iuVar.fOt.fOv = str3;
                iuVar.fOt.fOw = intValue2;
                iuVar.fOt.fOx = str5;
                iuVar.fOt.netType = ef;
                iuVar.fOt.startTime = j;
                iuVar.fOt.endTime = j2;
                iuVar.fOt.path = str6;
                iuVar.fOt.fOy = strArr;
                iuVar.fOt.fOz = str7;
                iuVar.fOt.fOA = intValue5;
                iuVar.fOt.fOB = i3;
                com.tencent.mm.sdk.b.a.urY.m(iuVar);
            }
            if (!Eo) {
                return;
            }
            if (com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat == 2) {
                g.oUh.a(354, 132, 1, false);
            } else {
                g.oUh.a(354, 133, 1, false);
            }
        }
    }
}
