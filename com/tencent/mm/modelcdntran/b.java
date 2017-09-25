package com.tencent.mm.modelcdntran;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.CdnInfo;
import com.tencent.mars.cdn.CdnLogic.CheckFileIDResult;
import com.tencent.mars.cdn.CdnLogic.Config;
import com.tencent.mars.cdn.CdnLogic.ICallback;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Map.Entry;

public final class b implements ICallback {
    public static int MediaType_FAVORITE_FILE = CdnLogic.MediaType_FAVORITE_FILE;
    public static int MediaType_FAVORITE_VIDEO = CdnLogic.MediaType_FAVORITE_VIDEO;
    public static int MediaType_FILE = 5;
    public static int MediaType_FRIENDS = CdnLogic.MediaType_FRIENDS;
    public static int MediaType_FULLSIZEIMAGE = 1;
    public static int MediaType_IMAGE = 2;
    public static int MediaType_THUMBIMAGE = 3;
    public static int MediaType_TinyVideo = 6;
    public static int MediaType_VIDEO = 4;
    public static int hxK = 1;
    public static int hxL = 2;
    public static int hxM = 3;
    public static int hxN = 7;
    public static int hxO = 10011;
    public static int hxP = CdnLogic.MediaType_FRIENDS_Video;
    public static int hxQ = 20301;
    public static int hxR = 20302;
    public static int hxS = 20304;
    public static int hxT = 20303;
    public static int hxU = 20321;
    public static int hxV = 20322;
    public static int hxW = 100;
    public static int hxX = 101;
    public static int hxY = 102;
    public static int hxZ = 103;
    public static int hya = WXMediaMessage.THUMB_LENGTH_LIMIT;
    public static int hyb = 7340033;
    private if hyc = null;
    b hyd = null;
    public int hye = 0;
    public int hyf = 0;
    public String hyg = "";
    private aj hyh = new aj(h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ b hyj;

        {
            this.hyj = r1;
        }

        public final boolean oQ() {
            if (this.hyj.hye == 0 && this.hyj.hyf == 0) {
                return false;
            }
            w.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", this.hyj.hyg, Integer.valueOf(this.hyj.hye), Integer.valueOf(this.hyj.hyf));
            com.tencent.mm.u.ag.a.hlT.aH(this.hyj.hyf, this.hyj.hye);
            this.hyj.hye = 0;
            this.hyj.hyf = 0;
            return true;
        }
    }, true);
    public a hyi;

    interface a {
        int a(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult);

        void onDataAvailable(String str, int i, int i2);

        void onDownloadToEnd(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);
    }

    interface b {
        int a(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult);

        void a(String str, ByteArrayOutputStream byteArrayOutputStream);

        byte[] i(String str, byte[] bArr);

        void onPreloadCompleted(String str, int i, int i2);
    }

    class c {
        public int field_AckSlice = 8192;
        public int field_C2COverloadDelaySeconds = 10;
        public int field_EnableCDNVerifyConnect = 1;
        public int field_EnableCDNVideoRedirectOC = 1;
        public int field_EnableSafeCDN = 0;
        public int field_EnableSnsStreamDownload = 0;
        public int field_EnableStreamUploadVideo = 1;
        public int field_Ptl = 35;
        public int field_SNSOverloadDelaySeconds = 60;
        public int field_UseDynamicETL = 0;
        public int field_UseStreamCDN = 1;
        public int field_WifiEtl = 90;
        public int field_noWifiEtl = 70;
        public boolean field_onlyrecvPtl = false;
        public boolean field_onlysendETL = false;
        final /* synthetic */ b hyj;

        c(b bVar) {
            this.hyj = bVar;
        }

        public final String toString() {
            return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d, safecdn:%d, snsstream:%d", new Object[]{Integer.valueOf(this.field_WifiEtl), Integer.valueOf(this.field_noWifiEtl), Integer.valueOf(this.field_Ptl), Integer.valueOf(this.field_UseStreamCDN), Boolean.valueOf(this.field_onlysendETL), Boolean.valueOf(this.field_onlyrecvPtl), Integer.valueOf(this.field_AckSlice), Integer.valueOf(this.field_EnableCDNVerifyConnect), Integer.valueOf(this.field_EnableCDNVideoRedirectOC), Integer.valueOf(this.field_EnableStreamUploadVideo), Integer.valueOf(this.field_UseDynamicETL), Integer.valueOf(this.field_C2COverloadDelaySeconds), Integer.valueOf(this.field_SNSOverloadDelaySeconds), Integer.valueOf(this.field_EnableSafeCDN), Integer.valueOf(this.field_EnableSnsStreamDownload)});
        }
    }

    public b(String str, b bVar) {
        this.hyd = bVar;
        CdnLogic.setCallBack(this);
        CdnLogic.onCreate(str);
        CdnLogic.setRSAPublicKeyParams("1", "BFEDFFB5EA28509F9C89ED83FA7FDDA8881435D444E984D53A98AD8E9410F1145EDD537890E10456190B22E6E5006455EFC6C12E41FDA985F38FBBC7213ECB810E3053D4B8D74FFBC70B4600ABD728202322AFCE1406046631261BD5EE3D44721082FEAB74340D73645DC0D02A293B962B9D47E4A64100BD7524DE00D9D3B5C1", "010001");
        CdnLogic.setToUserCiper("cdnwx2013usrname");
    }

    public static int keep_callFromJni(int i, int i2, byte[] bArr) {
        if (i == hxW) {
            d.a(bArr, "MicroMsg.CdnEngine", i2);
        }
        return 0;
    }

    static C2CDownloadRequest a(h hVar) {
        boolean z = true;
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileid = hVar.field_fileId;
        c2CDownloadRequest.aeskey = hVar.field_aesKey;
        c2CDownloadRequest.fileType = hVar.field_fileType;
        c2CDownloadRequest.fileKey = hVar.field_mediaId;
        c2CDownloadRequest.fileSize = hVar.field_totalLen;
        c2CDownloadRequest.savePath = hVar.field_fullpath;
        c2CDownloadRequest.isStorageMode = hVar.field_needStorage;
        if (hVar.field_smallVideoFlag != 1) {
            z = false;
        }
        c2CDownloadRequest.isSmallVideo = z;
        c2CDownloadRequest.isLargeSVideo = hVar.field_largesvideo;
        c2CDownloadRequest.limitRate = hVar.field_limitrate;
        c2CDownloadRequest.isAutoStart = hVar.field_autostart;
        c2CDownloadRequest.chatType = hVar.field_chattype;
        c2CDownloadRequest.isSilentTask = hVar.field_isSilentTask;
        c2CDownloadRequest.requestVideoFormat = hVar.field_requestVideoFormat;
        c2CDownloadRequest.isColdSnsData = hVar.field_isColdSnsData;
        c2CDownloadRequest.signalQuality = hVar.field_signalQuality;
        c2CDownloadRequest.snsScene = hVar.field_snsScene;
        c2CDownloadRequest.requestVideoFormat = hVar.field_requestVideoFormat;
        c2CDownloadRequest.videofileid = hVar.field_videoFileId;
        c2CDownloadRequest.bigfileSignature = hVar.field_svr_signature;
        if (bg.mA(c2CDownloadRequest.bigfileSignature)) {
            c2CDownloadRequest.bigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignature = hVar.field_fake_bigfile_signature;
        if (bg.mA(c2CDownloadRequest.fakeBigfileSignature)) {
            c2CDownloadRequest.fakeBigfileSignature = "";
        }
        c2CDownloadRequest.fakeBigfileSignatureAeskey = hVar.field_fake_bigfile_signature_aeskey;
        if (bg.mA(c2CDownloadRequest.fakeBigfileSignatureAeskey)) {
            c2CDownloadRequest.fakeBigfileSignatureAeskey = "";
        }
        c2CDownloadRequest.msgExtra = hVar.field_wxmsgparam;
        if (bg.mA(c2CDownloadRequest.msgExtra)) {
            c2CDownloadRequest.msgExtra = "";
        }
        c2CDownloadRequest.queueTimeoutSeconds = 0;
        c2CDownloadRequest.transforTimeoutSeconds = 0;
        c2CDownloadRequest.initialDownloadLength = hVar.initialDownloadLength;
        c2CDownloadRequest.initialDownloadOffset = hVar.initialDownloadOffset;
        c2CDownloadRequest.preloadRatio = hVar.field_preloadRatio;
        return c2CDownloadRequest;
    }

    public static int iH(String str) {
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int iI(String str) {
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static String iJ(String str) {
        return CdnLogic.getFileMD5(str);
    }

    public static String Ee() {
        return CdnLogic.createAeskey();
    }

    public static int iK(String str) {
        return CdnLogic.getFileCrc32(str);
    }

    public static String iL(String str) {
        return CdnLogic.getMP4IdentifyMD5(str);
    }

    public static int a(String str, String str2, String str3, int i, int i2, String[] strArr) {
        w.i("MicroMsg.CdnTransportEngine", "startHttpsDownload: mediaid:" + str);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.savePath = str3;
        c2CDownloadRequest.queueTimeoutSeconds = i;
        c2CDownloadRequest.transforTimeoutSeconds = i2;
        c2CDownloadRequest.iplist = strArr;
        return CdnLogic.startHttpsDownload(c2CDownloadRequest);
    }

    public static int a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2, int i3, boolean z, String str5, String str6, int i4) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileType = CdnLogic.MediaType_FRIENDS_Video;
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.initialDownloadOffset = i2;
        c2CDownloadRequest.initialDownloadLength = i3;
        if (strArr != null) {
            c2CDownloadRequest.iplist = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.iplist = null;
        }
        c2CDownloadRequest.isColdSnsData = z;
        c2CDownloadRequest.signalQuality = str5;
        c2CDownloadRequest.snsScene = str6;
        c2CDownloadRequest.preloadRatio = i4;
        return CdnLogic.startSNSDownload(c2CDownloadRequest, i);
    }

    public static int iM(String str) {
        w.i("MicroMsg.CdnTransportEngine", "stopHttpsDownload: mediaid:" + str);
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int a(String str, String str2, String str3, String str4, Map<String, String> map, boolean z, int i, int i2, String[] strArr) {
        w.i("MicroMsg.CdnTransportEngine", "startGamePackageDownload: mediaid:" + str);
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str3;
        c2CDownloadRequest.bakup_url = str4;
        c2CDownloadRequest.savePath = str2;
        c2CDownloadRequest.queueTimeoutSeconds = i;
        c2CDownloadRequest.transforTimeoutSeconds = i2;
        c2CDownloadRequest.iplist = strArr;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getKey());
                c2CDownloadRequest.serialized_verify_headers += ":";
                c2CDownloadRequest.serialized_verify_headers += ((String) entry.getValue());
                c2CDownloadRequest.serialized_verify_headers += ";";
            }
        }
        c2CDownloadRequest.allow_mobile_net_download = z;
        return CdnLogic.startHttpMultiSocketDownloadTask(c2CDownloadRequest);
    }

    public static int iN(String str) {
        w.i("MicroMsg.CdnTransportEngine", "stopGamePackageDownload: mediaid:" + str);
        CdnLogic.cancelTask(str);
        return 0;
    }

    public static int a(h hVar, int i) {
        return CdnLogic.startVideoStreamingDownload(a(hVar), i);
    }

    public static int a(String str, String str2, String str3, String str4, int i, String[] strArr, int i2, int i3, int i4) {
        C2CDownloadRequest c2CDownloadRequest = new C2CDownloadRequest();
        c2CDownloadRequest.fileKey = str;
        c2CDownloadRequest.url = str2;
        c2CDownloadRequest.referer = str3;
        c2CDownloadRequest.savePath = str4;
        c2CDownloadRequest.fileSize = 0;
        c2CDownloadRequest.initialDownloadOffset = i2;
        c2CDownloadRequest.initialDownloadLength = i3;
        if (strArr != null) {
            c2CDownloadRequest.iplist = (String[]) strArr.clone();
        } else {
            c2CDownloadRequest.iplist = null;
        }
        c2CDownloadRequest.preloadRatio = i4;
        return CdnLogic.startHttpVideoStreamingDownload(c2CDownloadRequest, i);
    }

    public static int a(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        C2CDownloadResult c2CDownloadResult = new C2CDownloadResult();
        int cancelDownloadTaskWithResult = CdnLogic.cancelDownloadTaskWithResult(str, c2CDownloadResult);
        a(c2CDownloadResult, com_tencent_mm_modelcdntran_keep_SceneResult);
        return cancelDownloadTaskWithResult;
    }

    public static int requestVideoData(String str, int i, int i2, int i3) {
        return CdnLogic.requestVideoData(str, i, i2, 0);
    }

    public static boolean isVideoDataAvailable(String str, int i, int i2) {
        return CdnLogic.isVideoDataAvailable(str, i, i2);
    }

    public final boolean Ef() {
        return this.hyc == null;
    }

    private static CdnInfo a(if ifVar) {
        int i;
        CdnInfo cdnInfo = new CdnInfo();
        cdnInfo.ver = ifVar.tmF;
        cdnInfo.uin = ifVar.leD;
        cdnInfo.frontid = ifVar.tmH;
        cdnInfo.zoneid = ifVar.tmM;
        cdnInfo.nettype = d.aT(ab.getContext());
        cdnInfo.authkey = n.a(ifVar.tmL);
        if (ifVar.tmI >= 2) {
            cdnInfo.frontip1 = n.a((avx) ifVar.tmJ.get(0));
            cdnInfo.frontip2 = n.a((avx) ifVar.tmJ.get(1));
            w.i("MicroMsg.CdnTransportEngine", "frontip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (ifVar.tmN >= 2) {
            cdnInfo.zoneip1 = n.a((avx) ifVar.tmO.get(0));
            cdnInfo.zoneip2 = n.a((avx) ifVar.tmO.get(1));
            w.i("MicroMsg.CdnTransportEngine", "zoneip %s, %s", cdnInfo.frontip1, cdnInfo.frontip2);
        }
        if (ifVar.tmR > 0) {
            int i2;
            i2 = ((ig) ifVar.tmP.get(0)).tmT;
            cdnInfo.frontports = new int[i2];
            for (i = 0; i < i2; i++) {
                cdnInfo.frontports[i] = ((Integer) ((ig) ifVar.tmP.get(0)).tmU.get(i)).intValue();
            }
        }
        if (ifVar.tmS > 0) {
            i2 = ((ig) ifVar.tmQ.get(0)).tmT;
            cdnInfo.zoneports = new int[i2];
            for (i = 0; i < i2; i++) {
                cdnInfo.zoneports[i] = ((Integer) ((ig) ifVar.tmQ.get(0)).tmU.get(i)).intValue();
            }
        }
        return cdnInfo;
    }

    public final boolean a(if ifVar, if ifVar2, if ifVar3, byte[] bArr, byte[] bArr2, if ifVar4) {
        w.i("MicroMsg.CdnTransportEngine", "summersafecdn cdntra setCDNDnsInfo old [%s]  new [%s], safecdn [%s], stack[%s]", this.hyc, ifVar, ifVar4, bg.bJZ());
        if (ifVar == null && bArr == null) {
            return false;
        }
        this.hyc = ifVar;
        try {
            CdnLogic.setLegacyCdnInfo(a(ifVar), a(ifVar2), a(ifVar3), a(ifVar4), bArr, bArr2);
            CdnLogic.setDebugIP("");
            if (r.ijp && r.ijg != null && r.ijg.length() >= 7) {
                w.w("MicroMsg.CdnTransportEngine", "setcdndns use debugip %s", r.ijg);
                CdnLogic.setDebugIP(r.ijg);
            }
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.CdnTransportEngine", "tocdninfo failed:" + e.getLocalizedMessage());
            return false;
        }
    }

    public static void a(c cVar) {
        w.i("MicroMsg.CdnTransportEngine", "set WXConfig:" + cVar);
        Config config = new Config();
        config.AckSlice = cVar.field_AckSlice;
        config.UseDynamicETL = cVar.field_UseDynamicETL;
        config.UseStreamCDN = cVar.field_UseStreamCDN;
        config.C2COverloadDelaySeconds = cVar.field_C2COverloadDelaySeconds;
        config.SNSOverloadDelaySeconds = cVar.field_SNSOverloadDelaySeconds;
        config.EnableCDNVerifyConnect = cVar.field_EnableCDNVerifyConnect;
        config.EnableCDNVideoRedirectOC = cVar.field_EnableCDNVideoRedirectOC;
        config.EnableStreamUploadVideo = cVar.field_EnableStreamUploadVideo;
        config.EnableSafeCDN = cVar.field_EnableSafeCDN;
        config.EnableSnsStreamDownload = cVar.field_EnableSnsStreamDownload;
        config.WifiEtl = cVar.field_WifiEtl;
        config.MobileEtl = cVar.field_noWifiEtl;
        config.onlyrecvPtl = cVar.field_onlyrecvPtl;
        config.onlysendETL = cVar.field_onlysendETL;
        config.Ptl = cVar.field_Ptl;
        CdnLogic.setConfig(config);
    }

    public final int keep_onUploadProgress(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo) {
        if (this.hyd != null) {
            w.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadProgress mediaId:%s, totalLen%d, offset%d", str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
            this.hyd.a(str, com_tencent_mm_modelcdntran_keep_ProgressInfo, null);
        }
        return 0;
    }

    public final int keep_onUploadError(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.hyd != null) {
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hyd.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        return 0;
    }

    public final int keep_onUploadSuccessed(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.hyd != null) {
            w.v("MicroMsg.CdnTransportEngine", "klem keep_onUploadSuccessed mediaId:%s", str);
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hyd.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        return 0;
    }

    public final int keep_onDownloadProgress(String str, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo) {
        int a;
        if (this.hyi != null) {
            a = this.hyi.a(str, com_tencent_mm_modelcdntran_keep_ProgressInfo, null);
        } else {
            a = 0;
        }
        if (a == 0 && this.hyd != null) {
            this.hyd.a(str, com_tencent_mm_modelcdntran_keep_ProgressInfo, null);
        }
        return 0;
    }

    public final int keep_onDownloadError(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        int a;
        if (this.hyi != null) {
            a = this.hyi.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            a = 0;
        }
        if (a == 0 && this.hyd != null) {
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hyd.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        return 0;
    }

    public final int keep_onDownloadSuccessed(String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        int a;
        if (this.hyi != null) {
            a = this.hyi.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            a = 0;
        }
        if (a == 0 && this.hyd != null) {
            a(com_tencent_mm_modelcdntran_keep_SceneResult);
            this.hyd.a(str, null, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
        return 0;
    }

    public final void keep_cdnGetSkeyBuf(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (this.hyd != null) {
            this.hyd.a(str, byteArrayOutputStream);
        }
    }

    public final byte[] keep_cdnDecodePrepareResponse(String str, byte[] bArr) {
        if (this.hyd != null) {
            return this.hyd.i(str, bArr);
        }
        return null;
    }

    public final void keep_onMoovReady(String str, int i, int i2) {
        w.i("MicroMsg.CdnTransportEngine", "keep_onMoovReady %s, %d, %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hyi != null) {
            this.hyi.onMoovReady(str, i, i2);
        }
    }

    public final void keep_onDataAvailable(String str, int i, int i2) {
        w.i("MicroMsg.CdnTransportEngine", "keep_onDataAvailable %s, %d, %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hyi != null) {
            this.hyi.onDataAvailable(str, i, i2);
        }
    }

    public final void keep_onDownloadToEnd(String str, int i, int i2) {
        w.i("MicroMsg.CdnTransportEngine", "keep_onDownloadToEnd %s, %d, %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (this.hyi != null) {
            this.hyi.onDownloadToEnd(str, i, i2);
        }
    }

    private static void a(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && !bg.mA(com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo)) {
            int indexOf = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo.indexOf("@,");
            if (indexOf > 0) {
                com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2 = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo.substring(indexOf + 2);
                com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo = com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo.substring(0, indexOf);
            }
            w.v("MicroMsg.CdnTransportEngine", "transinfo:%s, report_part2:%s", com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo, com_tencent_mm_modelcdntran_keep_SceneResult.report_Part2);
        }
    }

    public final void keep_cdnSendAndRecvData(String str, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            this.hye += i;
            this.hyf += i2;
            if (!bg.mA(str)) {
                this.hyg = str;
            }
            if (this.hye + this.hyf > 51200) {
                this.hyh.v(500, 500);
            }
        }
    }

    public final void keep_OnRequestDoGetCdnDnsInfo(int i) {
        h.vG();
        if (com.tencent.mm.kernel.a.uU()) {
            h.vd().a(new e(i + 1000), 0);
        }
    }

    public final void onProgressChanged(String str, int i, int i2) {
        keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo = new keep_ProgressInfo();
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength = i;
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength = i2;
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_status = 0;
        com_tencent_mm_modelcdntran_keep_ProgressInfo.field_mtlnotify = false;
        keep_onDownloadProgress(str, com_tencent_mm_modelcdntran_keep_ProgressInfo);
        keep_onUploadProgress(str, com_tencent_mm_modelcdntran_keep_ProgressInfo);
    }

    public final void onRecvedData(String str, int i, byte[] bArr) {
    }

    public final void RequestGetCDN(int i) {
        w.i("MicroMsg.CdnTransportEngine", "requestgetcdn %d", Integer.valueOf(i));
        keep_OnRequestDoGetCdnDnsInfo(i);
    }

    private static keep_SceneResult a(C2CDownloadResult c2CDownloadResult, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
        }
        com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode = c2CDownloadResult.errorCode;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_argInfo = c2CDownloadResult.argInfo;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength = c2CDownloadResult.fileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId = c2CDownloadResult.fileid;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo = c2CDownloadResult.transforMsg;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_convert2baseline = false;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_recvedBytes = c2CDownloadResult.recvedBytes;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFormat = c2CDownloadResult.videoFormat;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_enQueueTime = c2CDownloadResult.enQueueTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime = c2CDownloadResult.startTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime = c2CDownloadResult.endTime;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCost = c2CDownloadResult.firstRequestCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestSize = c2CDownloadResult.firstRequestSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestDownloadSize = c2CDownloadResult.firstRequestDownloadSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstRequestCompleted = c2CDownloadResult.firstRequestCompleted;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_averageSpeed = c2CDownloadResult.averageSpeed;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_averageConnectCost = c2CDownloadResult.averageConnectCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_firstConnectCost = c2CDownloadResult.firstConnectCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_netConnectTimes = c2CDownloadResult.netConnectTimes;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovRequestTimes = c2CDownloadResult.moovRequestTimes;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCost = c2CDownloadResult.moovCost;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovSize = c2CDownloadResult.moovSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovCompleted = c2CDownloadResult.moovCompleted;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_moovFailReason = c2CDownloadResult.moovFailReason;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_httpStatusCode = c2CDownloadResult.httpStatusCode;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_httpResponseHeader = c2CDownloadResult.httpResponseHeader;
        if (c2CDownloadResult.usedSvrIps != null) {
            com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps = (String[]) c2CDownloadResult.usedSvrIps.clone();
        }
        return com_tencent_mm_modelcdntran_keep_SceneResult;
    }

    public final void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult) {
        keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult = new keep_SceneResult();
        com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode = c2CUploadResult.errorCode;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_toUser = c2CUploadResult.touser;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType = c2CUploadResult.hitCache;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId = c2CUploadResult.fileid;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey = c2CUploadResult.aeskey;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5 = c2CUploadResult.filemd5;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbfilemd5 = c2CUploadResult.thumbfilemd5;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5 = c2CUploadResult.mp4identifymd5;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo = c2CUploadResult.transforMsg;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength = c2CUploadResult.fileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_midimgLength = c2CUploadResult.midfileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbimgLength = c2CUploadResult.thumbfileSize;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_needSendMsgField = !c2CUploadResult.sendmsgFromCDN;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck = c2CUploadResult.existOnSvr;
        if (c2CUploadResult.skeyrespbuf != null) {
            com_tencent_mm_modelcdntran_keep_SceneResult.field_sKeyrespbuf = (byte[]) c2CUploadResult.skeyrespbuf.clone();
        }
        com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId = c2CUploadResult.videofileid;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc = c2CUploadResult.fileCrc32;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn = c2CUploadResult.uploadBySafecdn;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_isVideoReduced = c2CUploadResult.isVideoReduced;
        if (c2CUploadResult.usedSvrIps != null) {
            com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps = (String[]) c2CUploadResult.usedSvrIps.clone();
        }
        com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl = c2CUploadResult.fileUrl;
        com_tencent_mm_modelcdntran_keep_SceneResult.field_thumbUrl = c2CUploadResult.thumbfileUrl;
        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
            keep_onUploadError(str, com_tencent_mm_modelcdntran_keep_SceneResult);
        } else {
            keep_onUploadSuccessed(str, com_tencent_mm_modelcdntran_keep_SceneResult);
        }
    }

    public final void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult) {
        keep_SceneResult a = a(c2CDownloadResult, null);
        if (a.field_retCode != 0) {
            keep_onDownloadError(str, a);
        } else {
            keep_onDownloadSuccessed(str, a);
        }
    }

    public final void onCheckFileidCompleted(String str, CheckFileIDResult checkFileIDResult) {
    }

    public final byte[] getSessionRequestBuf(String str, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        keep_cdnGetSkeyBuf(str, byteArrayOutputStream);
        if (byteArrayOutputStream.size() > 0) {
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public final byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        return keep_cdnDecodePrepareResponse(str, bArr);
    }

    public final void onMoovReady(String str, int i, int i2) {
        keep_onMoovReady(str, i, i2);
    }

    public final void onDataAvailable(String str, int i, int i2) {
        keep_onDataAvailable(str, i, i2);
    }

    public final void onDownloadToEnd(String str, int i, int i2) {
        keep_onDownloadToEnd(str, i, i2);
    }

    public final void onPreloadCompleted(String str, int i, int i2) {
        if (this.hyd != null) {
            this.hyd.onPreloadCompleted(str, i, i2);
        }
    }
}
