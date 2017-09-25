package com.tencent.mars.cdn;

import com.tencent.mars.Mars;
import java.util.ArrayList;

public class CdnLogic {
    public static final int HIT_FILEID = 1;
    public static final int HIT_UPLOADCHECKMD5 = 2;
    public static final int HIT_UPLOADWITHMD5 = 3;
    public static final int MediaType_FAVORITE_FILE = 10001;
    public static final int MediaType_FAVORITE_VIDEO = 10002;
    public static final int MediaType_FILE = 5;
    public static final int MediaType_FRIENDS = 20201;
    public static final int MediaType_FRIENDS_Video = 20202;
    public static final int MediaType_FULLSIZEIMAGE = 1;
    public static final int MediaType_IMAGE = 2;
    public static final int MediaType_THUMBIMAGE = 3;
    public static final int MediaType_TinyVideo = 6;
    public static final int MediaType_VIDEO = 4;
    public static final int NO_ERROR = 0;
    public static final int NO_HITCACHE = 0;
    public static final int PreloadMode = 2;
    public static final int StorageMode = 0;
    private static final String TAG = "mars.CdnLogic";
    public static final int VideoFormat_Unknown = 0;
    public static final int VideoFormat_X264 = 1;
    public static final int VideoFormat_X265 = 2;
    public static final int VideoPlayMode = 1;
    private static ICallback callBack = null;

    public static class C2CDownloadRequest {
        public String aeskey = "";
        public boolean allow_mobile_net_download = false;
        public String argInfo = "";
        public String bakup_url = "";
        public String bigfileSignature = "";
        public int chatType = 0;
        public String fakeBigfileSignature = "";
        public String fakeBigfileSignatureAeskey = "";
        public String fileKey = "";
        public int fileSize = 0;
        public int fileType = 0;
        public String fileid = "";
        public String host = "";
        public int initialDownloadLength = -1;
        public int initialDownloadOffset = -1;
        public String[] iplist = null;
        public boolean isAutoStart = false;
        public boolean isColdSnsData = false;
        public boolean isLargeSVideo = false;
        public boolean isSilentTask = false;
        public boolean isSmallVideo = false;
        public boolean isStorageMode = false;
        public int limitRate = 0;
        public String msgExtra = "";
        public int preloadRatio = 30;
        public int queueTimeoutSeconds = 1800;
        public String referer = "";
        public int requestVideoFormat = 1;
        public String savePath = "";
        public String serialized_verify_headers = "";
        public String signalQuality = "";
        public String snsScene = "";
        public int transforTimeoutSeconds = 600;
        public String url = "";
        public String videofileid = "";
    }

    public static class C2CDownloadResult {
        public String argInfo = "";
        public int averageConnectCost = 0;
        public int averageSpeed = 0;
        public long enQueueTime = 0;
        public long endTime = 0;
        public int errorCode = 0;
        public int fileSize = 0;
        public String fileid = "";
        public int firstConnectCost = 0;
        public boolean firstRequestCompleted = false;
        public int firstRequestCost = 0;
        public int firstRequestDownloadSize = 0;
        public int firstRequestSize = 0;
        public String httpResponseHeader = "";
        public int httpStatusCode = 0;
        public boolean moovCompleted = false;
        public int moovCost = 0;
        public int moovFailReason = 0;
        public int moovRequestTimes = 0;
        public int moovSize = 0;
        public int netConnectTimes = 0;
        public int recvedBytes = 0;
        public long startTime = 0;
        public String transforMsg = "";
        public String[] usedSvrIps;
        public int videoFormat = 0;
    }

    public static class C2CUploadRequest {
        public int apptype = 0;
        public String bigfileSignature = "";
        public int bizscene = 0;
        public int chatType = 0;
        public boolean checkExistOnly = false;
        public boolean enableHitCheck = true;
        public String fakeBigfileSignature = "";
        public String fakeBigfileSignatureAeskey = "";
        public String fileKey = "";
        public String filePath = "";
        public int fileSize = 0;
        public int fileType = 0;
        public boolean forceNoSafeCdn = false;
        public String forwardAeskey = "";
        public String forwardFileid = "";
        public boolean isLargeSVideo = false;
        public boolean isSmallVideo = false;
        public boolean isSnsAdVideo = false;
        public boolean isStorageMode = false;
        public boolean isStreamMedia = false;
        public int midfileSize = 0;
        public String midimgPath = "";
        public boolean needCompressImage = false;
        public boolean onlyCheckExist = false;
        public int queueTimeoutSeconds = 1800;
        public boolean sendmsgFromCDN = false;
        public String thumbfilePath = "";
        public String toUser = "";
        public int transforTimeoutSeconds = 600;
        public boolean trySafeCdn = false;
    }

    public static class C2CUploadResult {
        public String aeskey = "";
        public int errorCode = 0;
        public boolean existOnSvr = false;
        public int fileCrc32 = 0;
        public int fileSize = 0;
        public String fileUrl = "";
        public String fileid = "";
        public String filemd5 = "";
        public int filetype = 0;
        public int hitCache = 0;
        public boolean isVideoReduced = false;
        public int midfileSize = 0;
        public String mp4identifymd5 = "";
        public boolean sendmsgFromCDN = false;
        public byte[] skeyrespbuf = null;
        public int thumbfileSize = 0;
        public String thumbfileUrl = "";
        public String thumbfilemd5 = "";
        public String touser = "";
        public String transforMsg = "";
        public boolean uploadBySafecdn = false;
        public String[] usedSvrIps;
        public String videofileid = "";
    }

    public static class CdnInfo {
        public byte[] authkey = null;
        public int frontid = 0;
        public String frontip1 = null;
        public String frontip2 = null;
        public int[] frontports = null;
        public int nettype = 0;
        public int uin = 0;
        public int ver = 0;
        public int zoneid = 0;
        public String zoneip1 = null;
        public String zoneip2 = null;
        public int[] zoneports = null;
    }

    public static class CdnInfoParams {
        public int c2CretryIntervalMs = 0;
        public int c2CrwtimeoutMs = 0;
        public int c2CshowErrorDelayMs = 0;
        public int snsretryIntervalMs = 0;
        public int snsrwtimeoutMs = 0;
        public int snsshowErrorDelayMs = 0;
    }

    public static class CdnTaskStateInfo {
        public static final int kNotExits = 103;
        public static final int kPausing = 102;
        public static final int kRunning = 100;
        public static final int kWaiting = 101;
        public int completeSize = 0;
        public int fileTotalSize = 0;
        public int taskState = -100;
    }

    public static class CheckFileIDResult {
        public int errorCode = 0;
        public int[] existFlags = null;
        public CheckFileidItem[] fileItems = null;
        public String fileKey = "";
        public String[] newFileids = null;
    }

    public static class CheckFileIdRequest {
        public CheckFileidItem[] fileItems = null;
        public String fileKey = "";
        public int queueTimeoutSeconds = 1800;
        public String toUser = "";
        public int transforTimeoutSeconds = 600;
    }

    public static class CheckFileidItem {
        public int fileType = 0;
        public String fileid = "";
    }

    public static class Config {
        public int AckSlice = 8192;
        public int C2COverloadDelaySeconds = 10;
        public int EnableCDNVerifyConnect = 1;
        public int EnableCDNVideoRedirectOC = 1;
        public int EnableSafeCDN = 0;
        public int EnableSnsStreamDownload = 0;
        public int EnableStreamUploadVideo = 1;
        public int MobileEtl = 70;
        public int Ptl = 35;
        public int SNSOverloadDelaySeconds = 60;
        public int UseDynamicETL = 0;
        public int UseStreamCDN = 1;
        public int WifiEtl = 90;
        public boolean onlyrecvPtl = false;
        public boolean onlysendETL = false;

        public String toString() {
            return String.format("wifietl:%d, nowifietl:%d,ptl:%d,UseStreamCDN:%d,onlysendetl:%b,onlyrecvptl:%b,ackslice:%d,enableverify:%d,enableoc:%d,enablevideo:%d,dynamicetl:%b,c2coverload:%d,snsoverload:%d,safecdn:%d,snsstream:%d", new Object[]{Integer.valueOf(this.WifiEtl), Integer.valueOf(this.MobileEtl), Integer.valueOf(this.Ptl), Integer.valueOf(this.UseStreamCDN), Boolean.valueOf(this.onlysendETL), Boolean.valueOf(this.onlyrecvPtl), Integer.valueOf(this.AckSlice), Integer.valueOf(this.EnableCDNVerifyConnect), Integer.valueOf(this.EnableCDNVideoRedirectOC), Integer.valueOf(this.EnableStreamUploadVideo), Integer.valueOf(this.UseDynamicETL), Integer.valueOf(this.C2COverloadDelaySeconds), Integer.valueOf(this.SNSOverloadDelaySeconds), Integer.valueOf(this.EnableSafeCDN), Integer.valueOf(this.EnableSnsStreamDownload)});
        }
    }

    public interface ICallback {
        void RequestGetCDN(int i);

        byte[] decodeSessionResponseBuf(String str, byte[] bArr);

        byte[] getSessionRequestBuf(String str, byte[] bArr);

        void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult);

        void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult);

        void onCheckFileidCompleted(String str, CheckFileIDResult checkFileIDResult);

        void onDataAvailable(String str, int i, int i2);

        void onDownloadToEnd(String str, int i, int i2);

        void onMoovReady(String str, int i, int i2);

        void onPreloadCompleted(String str, int i, int i2);

        void onProgressChanged(String str, int i, int i2);

        void onRecvedData(String str, int i, byte[] bArr);
    }

    public static native int cancelDownloadTaskWithResult(String str, C2CDownloadResult c2CDownloadResult);

    public static native void cancelTask(String str);

    public static native int cancelUploadTaskWithResult(String str, C2CUploadResult c2CUploadResult);

    public static native String createAeskey();

    public static native int getFileCrc32(String str);

    public static native String getFileMD5(String str);

    private static native ArrayList<String> getLoadLibraries();

    public static native String getMP4IdentifyMD5(String str);

    public static native CdnTaskStateInfo httpMultiSocketDownloadTaskState(String str);

    public static native boolean isVideoDataAvailable(String str, int i, int i2);

    public static native void onCreate(String str);

    public static native int pauseHttpMultiSocketDownloadTask(String str);

    public static native int requestVideoData(String str, int i, int i2, int i3);

    public static native int resumeHttpMultiSocketDownloadTask(String str);

    public static native void setCdnInfo(byte[] bArr, byte[] bArr2);

    public static native void setCdnInfoParams(CdnInfoParams cdnInfoParams, CdnInfoParams cdnInfoParams2, int i);

    public static native void setConfig(Config config);

    public static native void setDebugIP(String str);

    public static native void setFlowLimitPerHour(int i);

    public static native void setLegacyCdnInfo(CdnInfo cdnInfo, CdnInfo cdnInfo2, CdnInfo cdnInfo3, CdnInfo cdnInfo4, byte[] bArr, byte[] bArr2);

    public static native void setRSAPublicKeyParams(String str, String str2, String str3);

    public static native void setToUserCiper(String str);

    public static native int startC2CDownload(C2CDownloadRequest c2CDownloadRequest);

    public static native int startC2CUpload(C2CUploadRequest c2CUploadRequest);

    public static native int startCheckFileId(CheckFileIdRequest checkFileIdRequest);

    public static native int startHttpMultiSocketDownloadTask(C2CDownloadRequest c2CDownloadRequest);

    public static native int startHttpVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, int i);

    public static native int startHttpsDownload(C2CDownloadRequest c2CDownloadRequest);

    public static native int startSNSDownload(C2CDownloadRequest c2CDownloadRequest, int i);

    public static native int startVideoStreamingDownload(C2CDownloadRequest c2CDownloadRequest, int i);

    static {
        ArrayList loadLibraries;
        try {
            loadLibraries = getLoadLibraries();
        } catch (UnsatisfiedLinkError e) {
            loadLibraries = null;
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(loadLibraries, TAG);
    }

    public static void setCallBack(ICallback iCallback) {
        callBack = iCallback;
    }

    private static void onProgressChanged(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onProgressChanged(str, i, i2);
        }
    }

    private static void onC2CUploadCompleted(String str, C2CUploadResult c2CUploadResult) {
        if (callBack != null) {
            callBack.onC2CUploadCompleted(str, c2CUploadResult);
        }
    }

    private static void onC2CDownloadCompleted(String str, C2CDownloadResult c2CDownloadResult) {
        if (callBack != null) {
            callBack.onC2CDownloadCompleted(str, c2CDownloadResult);
        }
    }

    private static void onCheckFileIDCompleted(String str, CheckFileIDResult checkFileIDResult) {
        if (callBack != null) {
            callBack.onCheckFileidCompleted(str, checkFileIDResult);
        }
    }

    private static void onRecvedData(String str, int i, byte[] bArr) {
        if (callBack != null) {
            callBack.onRecvedData(str, i, bArr);
        }
    }

    private static byte[] getSessionRequestBuf(String str, byte[] bArr) {
        if (callBack == null) {
            return null;
        }
        return callBack.getSessionRequestBuf(str, bArr);
    }

    private static byte[] decodeSessionResponseBuf(String str, byte[] bArr) {
        if (callBack == null) {
            return null;
        }
        return callBack.decodeSessionResponseBuf(str, bArr);
    }

    public static void onMoovReady(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onMoovReady(str, i, i2);
        }
    }

    public static void onDataAvailable(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onDataAvailable(str, i, i2);
        }
    }

    public static void onDownloadToEnd(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onDownloadToEnd(str, i, i2);
        }
    }

    public static void onPreloadCompleted(String str, int i, int i2) {
        if (callBack != null) {
            callBack.onPreloadCompleted(str, i, i2);
        }
    }

    public static void RequestGetCDN(int i) {
        if (callBack != null) {
            callBack.RequestGetCDN(i);
        }
    }
}
