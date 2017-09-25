package com.tencent.mm.modelcdntran;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.m.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class c implements b, b, e {
    m hyk = new a(this) {
        final /* synthetic */ c hys;

        {
            this.hys = r1;
        }

        public final void cU(int i) {
            w.d("MicroMsg.CdnTransportService", "cdntra onNetworkChange st:%d ", Integer.valueOf(i));
            BaseEvent.onNetworkChange();
            if ((i == 4 || i == 6) && h.vG().uV()) {
                h.vd().a(new e(), 0);
            }
        }
    };
    public Queue<String> hyl = new LinkedList();
    public Map<String, h> hym = new HashMap();
    public Map<String, h> hyn = new HashMap();
    public Map<String, Integer> hyo = new HashMap();
    private String hyp = "";
    private long hyq = 0;
    public HashSet<String> hyr = new HashSet();

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (h.vG().uV()) {
            int n = bg.n(obj, 0);
            w.d("MicroMsg.CdnTransportService", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(n), mVar);
            if (mVar != h.vI().vr() || n <= 0) {
                w.e("MicroMsg.CdnTransportService", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(n), mVar);
            } else if (n == 144385) {
                h.vd().a(new e(), 0);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 379) {
            w.d("MicroMsg.CdnTransportService", "cdntra onSceneEnd it will tryStart sceneType:%d [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
            if (h.vG().uV()) {
                h.vL().D(new Runnable(this) {
                    final /* synthetic */ c hys;

                    {
                        this.hys = r1;
                    }

                    public final void run() {
                        this.hys.be(true);
                    }

                    public final String toString() {
                        return super.toString() + "|onSceneEnd";
                    }
                });
            }
        }
    }

    public static boolean fA(int i) {
        h.vG();
        if (!com.tencent.mm.kernel.a.uU()) {
            return true;
        }
        w.d("MicroMsg.CdnTransportService", "summersafecdn cdntra cdnBitSet:%d grayScaleFlag:%d res:%d Test.forceCDNTrans:%b", Integer.valueOf(bg.a((Integer) h.vI().vr().get(144385, null), 0)), Integer.valueOf(i), Integer.valueOf(bg.a((Integer) h.vI().vr().get(144385, null), 0) & i), Boolean.valueOf(r.iiQ));
        if (r.iiQ) {
            return true;
        }
        return (r0 & i) > 0;
    }

    public c() {
        h.vH().a(this.hyk);
        if (h.vG().uV()) {
            h.vI().vr().a(this);
        }
        h.vd().a(379, (e) this);
    }

    public final boolean b(final h hVar, final int i) {
        if (hVar == null) {
            w.e("MicroMsg.CdnTransportService", "addRecvTask task info is null");
            return false;
        } else if (bg.mA(hVar.field_mediaId)) {
            w.e("MicroMsg.CdnTransportService", "addRecvTask mediaId is null");
            return false;
        } else {
            if (hVar.field_fileId == null) {
                hVar.field_fileId = "";
            }
            if (hVar.field_aesKey == null) {
                hVar.field_aesKey = "";
            }
            hVar.fZK = false;
            h.vL().D(new Runnable(this) {
                final /* synthetic */ c hys;

                public final void run() {
                    if (i != -1) {
                        this.hys.hyo.put(hVar.field_mediaId, Integer.valueOf(i));
                    }
                    this.hys.hyl.add(hVar.field_mediaId);
                    this.hys.hym.put(hVar.field_mediaId, hVar);
                    this.hys.be(false);
                }

                public final String toString() {
                    return super.toString() + "|addRecvTask";
                }
            });
            return true;
        }
    }

    public final boolean b(final h hVar) {
        if (bg.mA(hVar.field_mediaId)) {
            w.e("MicroMsg.CdnTransportService", "summersafecdn addSendTask mediaId is null");
            return false;
        }
        if (hVar.field_fileId == null) {
            hVar.field_fileId = "";
        }
        if (hVar.field_aesKey == null) {
            hVar.field_aesKey = "";
        }
        hVar.fZK = true;
        h.vL().D(new Runnable(this) {
            final /* synthetic */ c hys;

            public final void run() {
                this.hys.hyl.add(hVar.field_mediaId);
                this.hys.hym.put(hVar.field_mediaId, hVar);
                this.hys.be(false);
            }

            public final String toString() {
                return super.toString() + "|addSendTask";
            }
        });
        return true;
    }

    public final boolean iO(String str) {
        if (((h) this.hyn.remove(str)) != null) {
            g.Em();
            b.iH(str);
            g.oUh.i(10769, Integer.valueOf(d.hyK), Integer.valueOf(r0.field_fileType), Long.valueOf(bg.Nz() - r0.field_startTime));
        }
        this.hym.remove(str);
        w.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelSendTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(0));
        return true;
    }

    public final boolean iP(String str) {
        h hVar = (h) this.hyn.remove(str);
        if (hVar != null) {
            if (hVar.hzf) {
                g.Em();
                b.iM(str);
            } else if (hVar.hzk) {
                g.Em();
                b.iN(str);
            } else {
                g.Em();
                b.iI(str);
            }
            g.oUh.i(10769, Integer.valueOf(d.hyJ), Integer.valueOf(hVar.field_fileType), Long.valueOf(bg.Nz() - hVar.field_startTime));
        }
        this.hym.remove(str);
        this.hyo.remove(str);
        w.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, hVar, Integer.valueOf(0));
        return true;
    }

    public final void be(boolean z) {
        if (!z && g.Em().Ef()) {
            h.vG();
            if (com.tencent.mm.kernel.a.uU()) {
                w.w("MicroMsg.CdnTransportService", "summersafecdn cdntra Not init cdn dnsinfo , will retry after set info");
                h.vd().a(new e(), 0);
                return;
            }
        }
        Eg();
        w.i("MicroMsg.CdnTransportService", "summersafecdn tryStart queue:%d", Integer.valueOf(this.hyl.size()));
        while (!this.hyl.isEmpty()) {
            h hVar = (h) this.hym.remove((String) this.hyl.poll());
            if (hVar == null) {
                w.e("MicroMsg.CdnTransportService", "summersafecdn task queue is empty , maybe bug here");
                return;
            }
            w.i("MicroMsg.CdnTransportService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", hVar.field_mediaId, Boolean.valueOf(hVar.field_autostart), Integer.valueOf(hVar.field_chattype));
            hVar.field_startTime = bg.Nz();
            String str;
            int i;
            int startC2CUpload;
            if (hVar.fZK) {
                String str2 = "MicroMsg.CdnTransportService";
                str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                Object[] objArr = new Object[7];
                if (hVar.field_fullpath == null) {
                    i = -1;
                } else {
                    i = hVar.field_fullpath.length();
                }
                objArr[0] = Integer.valueOf(i);
                if (hVar.field_thumbpath == null) {
                    i = -1;
                } else {
                    i = hVar.field_thumbpath.length();
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = bg.Qj(hVar.field_svr_signature);
                objArr[3] = bg.Qj(hVar.field_aesKey);
                objArr[4] = Integer.valueOf(hVar.field_fileType);
                objArr[5] = hVar.field_mediaId;
                objArr[6] = Boolean.valueOf(hVar.field_onlycheckexist);
                w.i(str2, str, objArr);
                if (hVar.field_fullpath == null) {
                    hVar.field_fullpath = "";
                }
                if (hVar.field_thumbpath == null) {
                    hVar.field_thumbpath = "";
                }
                g.Em();
                C2CUploadRequest c2CUploadRequest = new C2CUploadRequest();
                c2CUploadRequest.fileKey = hVar.field_mediaId;
                c2CUploadRequest.filePath = hVar.field_fullpath;
                c2CUploadRequest.thumbfilePath = hVar.field_thumbpath;
                c2CUploadRequest.fileSize = hVar.field_totalLen;
                c2CUploadRequest.fileType = hVar.field_fileType;
                c2CUploadRequest.forwardAeskey = hVar.field_aesKey;
                c2CUploadRequest.forwardFileid = hVar.field_fileId;
                c2CUploadRequest.midfileSize = hVar.field_midFileLength;
                c2CUploadRequest.queueTimeoutSeconds = 0;
                c2CUploadRequest.transforTimeoutSeconds = 0;
                c2CUploadRequest.toUser = hVar.field_talker;
                c2CUploadRequest.sendmsgFromCDN = hVar.field_sendmsg_viacdn;
                c2CUploadRequest.needCompressImage = hVar.field_needCompressImage;
                c2CUploadRequest.chatType = hVar.field_chattype;
                c2CUploadRequest.apptype = hVar.field_appType;
                c2CUploadRequest.bizscene = hVar.field_bzScene;
                c2CUploadRequest.checkExistOnly = hVar.field_onlycheckexist;
                c2CUploadRequest.isSmallVideo = hVar.field_smallVideoFlag == 1;
                c2CUploadRequest.isLargeSVideo = hVar.field_largesvideo;
                c2CUploadRequest.isSnsAdVideo = hVar.field_advideoflag == 1;
                c2CUploadRequest.isStorageMode = hVar.field_needStorage;
                c2CUploadRequest.isStreamMedia = hVar.field_isStreamMedia;
                c2CUploadRequest.enableHitCheck = hVar.field_enable_hitcheck;
                c2CUploadRequest.forceNoSafeCdn = hVar.field_force_aeskeycdn;
                c2CUploadRequest.trySafeCdn = hVar.field_trysafecdn;
                c2CUploadRequest.midimgPath = hVar.field_midimgpath;
                c2CUploadRequest.bigfileSignature = hVar.field_svr_signature;
                if (bg.mA(c2CUploadRequest.bigfileSignature)) {
                    c2CUploadRequest.bigfileSignature = "";
                }
                c2CUploadRequest.fakeBigfileSignature = hVar.field_fake_bigfile_signature;
                if (bg.mA(c2CUploadRequest.fakeBigfileSignature)) {
                    c2CUploadRequest.fakeBigfileSignature = "";
                }
                c2CUploadRequest.fakeBigfileSignatureAeskey = hVar.field_fake_bigfile_signature_aeskey;
                if (bg.mA(c2CUploadRequest.fakeBigfileSignatureAeskey)) {
                    c2CUploadRequest.fakeBigfileSignatureAeskey = "";
                }
                startC2CUpload = CdnLogic.startC2CUpload(c2CUploadRequest);
                if (startC2CUpload != 0) {
                    w.e("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia error:%d clientid:%s", Integer.valueOf(startC2CUpload), hVar.field_mediaId);
                    if (hVar.hze != null) {
                        hVar.hze.a(hVar.field_mediaId, startC2CUpload, null, null, hVar.field_onlycheckexist);
                    }
                } else {
                    w.i("MicroMsg.CdnTransportService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", hVar.field_mediaId);
                    this.hyn.put(hVar.field_mediaId, hVar);
                }
            } else {
                i = -1;
                String str3;
                Object[] objArr2;
                int i2;
                if (hVar.hzf) {
                    if (!(hVar.field_fullpath == null || hVar.field_fullpath.isEmpty())) {
                        g.Em();
                        i = b.a(hVar.field_mediaId, hVar.hzg, hVar.field_fullpath, hVar.hzh, hVar.hzi, hVar.hzj);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str3 = "https download tryStart recv file:%d field_mediaId[%s], download_url[%s]";
                    objArr2 = new Object[3];
                    if (hVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = hVar.field_fullpath.length();
                    }
                    objArr2[0] = Integer.valueOf(i2);
                    objArr2[1] = hVar.field_mediaId;
                    objArr2[2] = hVar.hzg;
                    w.i(str, str3, objArr2);
                    startC2CUpload = i;
                } else if (hVar.hzk) {
                    if (!(hVar.field_fullpath == null || hVar.field_fullpath.isEmpty())) {
                        g.Em();
                        i = b.a(hVar.field_mediaId, hVar.field_fullpath, hVar.hzg, hVar.hzl, hVar.hzm, hVar.allow_mobile_net_download, hVar.hzh, hVar.hzi, hVar.hzj);
                    }
                    str = "MicroMsg.CdnTransportService";
                    str3 = "game package download tryStart recv file:%d field_mediaId[%s], download_url[%s] https url[%s]";
                    objArr2 = new Object[4];
                    if (hVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = hVar.field_fullpath.length();
                    }
                    objArr2[0] = Integer.valueOf(i2);
                    objArr2[1] = hVar.field_mediaId;
                    objArr2[2] = hVar.hzg;
                    objArr2[3] = hVar.hzl;
                    w.i(str, str3, objArr2);
                    startC2CUpload = i;
                } else {
                    str = "MicroMsg.CdnTransportService";
                    str3 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                    objArr2 = new Object[7];
                    if (hVar.field_fullpath == null) {
                        i2 = -1;
                    } else {
                        i2 = hVar.field_fullpath.length();
                    }
                    objArr2[0] = Integer.valueOf(i2);
                    if (hVar.field_thumbpath == null) {
                        i2 = -1;
                    } else {
                        i2 = hVar.field_thumbpath.length();
                    }
                    objArr2[1] = Integer.valueOf(i2);
                    objArr2[2] = hVar.field_svr_signature;
                    objArr2[3] = hVar.field_aesKey;
                    objArr2[4] = Integer.valueOf(hVar.field_fileType);
                    objArr2[5] = hVar.field_mediaId;
                    objArr2[6] = Boolean.valueOf(hVar.field_onlycheckexist);
                    w.i(str, str3, objArr2);
                    if (hVar.hzn != 2) {
                        g.Em();
                        startC2CUpload = CdnLogic.startC2CDownload(b.a(hVar));
                    } else if (hVar instanceof i) {
                        i iVar = (i) hVar;
                        if (iVar.Eo()) {
                            g.Em();
                            startC2CUpload = b.a(hVar, 2);
                        } else {
                            if (iVar.En()) {
                                g.Em();
                                i = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.hzt, iVar.iplist, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.isColdSnsData, iVar.signalQuality, iVar.snsScene, iVar.field_preloadRatio);
                            }
                            startC2CUpload = i;
                        }
                    } else {
                        startC2CUpload = -1;
                    }
                }
                if (startC2CUpload != 0) {
                    w.e("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(startC2CUpload), hVar.field_mediaId);
                    if (hVar.hze != null) {
                        hVar.hze.a(hVar.field_mediaId, startC2CUpload, null, null, hVar.field_onlycheckexist);
                    }
                } else {
                    w.i("MicroMsg.CdnTransportService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", hVar.field_mediaId);
                    this.hyn.put(hVar.field_mediaId, hVar);
                }
            }
        }
    }

    public static void Eg() {
        h.vG();
        if (com.tencent.mm.kernel.a.uU()) {
            c cVar = new c(g.Em());
            String value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNUploadImg");
            String value2 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNVerifyConnect");
            String value3 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableCDNVideoRedirectOC");
            String value4 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableStreamUploadVideo");
            String value5 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("C2COverloadDelaySeconds");
            String value6 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("SNSOverloadDelaySeconds");
            String value7 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableSnsStreamDownload");
            try {
                if (!bg.mA(value)) {
                    cVar.field_UseStreamCDN = Integer.valueOf(value).intValue();
                }
                if (!bg.mA(value2)) {
                    cVar.field_EnableCDNVerifyConnect = Integer.valueOf(value2).intValue();
                }
                if (!bg.mA(value3)) {
                    cVar.field_EnableCDNVideoRedirectOC = Integer.valueOf(value3).intValue();
                }
                if (!bg.mA(value4)) {
                    cVar.field_EnableStreamUploadVideo = Integer.valueOf(value4).intValue();
                }
                if (!bg.mA(value5)) {
                    cVar.field_C2COverloadDelaySeconds = Integer.valueOf(value5).intValue();
                }
                if (!bg.mA(value6)) {
                    cVar.field_SNSOverloadDelaySeconds = Integer.valueOf(value6).intValue();
                }
                if (!bg.mA(value7)) {
                    cVar.field_EnableSnsStreamDownload = Integer.valueOf(value7).intValue();
                }
                g.El();
                cVar.field_EnableSafeCDN = fA(256) ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    value = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGUploadSizeLimitWifi");
                    value2 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGUploadSizeLimit3G");
                    value3 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGDownloadSizeLimit");
                    value4 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("ProgJPEGOnlyRecvPTL");
                    value5 = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("EnableJPEGDyncmicETL");
                    if (!bg.mA(value)) {
                        cVar.field_WifiEtl = Integer.valueOf(value).intValue();
                    }
                    if (!bg.mA(value2)) {
                        cVar.field_noWifiEtl = Integer.valueOf(value2).intValue();
                    }
                    if (!bg.mA(value3)) {
                        cVar.field_Ptl = Integer.valueOf(value3).intValue();
                    }
                    if (!bg.mA(value4)) {
                        cVar.field_onlyrecvPtl = Integer.valueOf(value4).intValue() != 0;
                    }
                    if (!bg.mA(value5)) {
                        cVar.field_UseDynamicETL = Integer.valueOf(value5).intValue();
                    }
                }
                w.i("MicroMsg.CdnTransportService", "summersafecdn streamcdn config[SVR]:%s", cVar);
                g.Em();
                b.a(cVar);
            } catch (NumberFormatException e) {
                w.e("MicroMsg.CdnTransportService", e.toString());
            }
            if (r.ijp) {
                int i;
                w.w("MicroMsg.CdnTransportService", "use cdn debug configure.");
                cVar.field_UseStreamCDN = r.ijl ? 1 : 0;
                if (cVar.field_UseStreamCDN != 0) {
                    cVar.field_onlysendETL = r.ijm;
                    cVar.field_onlyrecvPtl = r.ijn;
                    if (!bg.mA(r.iji)) {
                        cVar.field_WifiEtl = Integer.valueOf(r.iji).intValue();
                    }
                    if (!bg.mA(r.ijj)) {
                        cVar.field_noWifiEtl = Integer.valueOf(r.ijj).intValue();
                    }
                    if (!bg.mA(r.ijk)) {
                        cVar.field_Ptl = Integer.valueOf(r.ijk).intValue();
                    }
                }
                cVar.field_EnableCDNVerifyConnect = r.ijq ? 1 : 0;
                if (r.ijr) {
                    i = 1;
                } else {
                    i = 0;
                }
                cVar.field_EnableCDNVideoRedirectOC = i;
                w.i("MicroMsg.CdnTransportService", "streamcdn config[DEBUG]:%s", cVar);
                g.Em();
                b.a(cVar);
            }
        }
    }

    public final int a(final String str, final keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (bg.mA(str)) {
            w.e("MicroMsg.CdnTransportService", "cdn callback mediaid is null");
            return -1;
        } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null && com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            w.e("MicroMsg.CdnTransportService", "cdn callback info all null");
            return -2;
        } else {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                w.d("MicroMsg.CdnTransportService", "CDN progress. total:%d, cur:%d, canshow:%b", Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify));
            }
            this.hyq = bg.Nz();
            this.hyp = str;
            h.vL().D(new Runnable(this) {
                final /* synthetic */ c hys;

                public final void run() {
                    int i = 0;
                    h hVar = (h) this.hys.hyn.get(str);
                    if (hVar == null) {
                        w.e("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", str);
                        return;
                    }
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                        com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId = str;
                        w.i("MicroMsg.CdnTransportService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify));
                    }
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        com_tencent_mm_modelcdntran_keep_SceneResult.mediaId = str;
                    }
                    if (hVar.hze != null) {
                        long Nz = bg.Nz();
                        if (com_tencent_mm_modelcdntran_keep_SceneResult != null || com_tencent_mm_modelcdntran_keep_ProgressInfo == null || com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify || am.getNetWorkType(ab.getContext()) != -1) {
                            hVar.field_lastProgressCallbackTime = Nz;
                            hVar.hze.a(str, 0, com_tencent_mm_modelcdntran_keep_ProgressInfo, com_tencent_mm_modelcdntran_keep_SceneResult, hVar.field_onlycheckexist);
                        } else {
                            return;
                        }
                    }
                    keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo = com_tencent_mm_modelcdntran_keep_ProgressInfo;
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo == null || com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength) {
                        i = 1;
                    }
                    if (i != 0) {
                        this.hys.hyo.remove(str);
                    }
                    if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                        this.hys.hyn.remove(str);
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode == -5103011) {
                            w.i("MicroMsg.CdnTransportService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            g.oUh.a(546, 4, 1, true);
                            g.Em().keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|callback";
                }
            });
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (bg.mA(str)) {
            w.e("MicroMsg.CdnTransportService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        h hVar = (h) this.hyn.get(str);
        if (hVar == null) {
            w.e("MicroMsg.CdnTransportService", " getauthbuf task in jni get info failed mediaid:%s", str);
        } else if (hVar.hze != null) {
            hVar.hze.a(str, byteArrayOutputStream);
        } else {
            w.e("MicroMsg.CdnTransportService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] i(String str, byte[] bArr) {
        if (bg.mA(str)) {
            w.e("MicroMsg.CdnTransportService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        h hVar = (h) this.hyn.get(str);
        if (hVar == null) {
            w.e("MicroMsg.CdnTransportService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            return null;
        } else if (hVar.hze != null) {
            return hVar.hze.i(str, bArr);
        } else {
            w.e("MicroMsg.CdnTransportService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }

    public final void onPreloadCompleted(final String str, final int i, final int i2) {
        if (!bg.mA(str)) {
            h.vL().D(new Runnable(this) {
                final /* synthetic */ c hys;

                public final void run() {
                    h hVar = (h) this.hys.hyn.get(str);
                    if (hVar == null) {
                        w.e("MicroMsg.CdnTransportService", " task in jni get info failed mediaid:%s", str);
                    } else if (hVar.hzp != null) {
                        hVar.hzp.onPreloadCompleted(str, i, i2);
                    }
                }
            });
        }
    }
}
