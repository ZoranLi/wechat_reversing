package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class ay {
    private static ay mrB;
    private static TMQQDownloaderOpenSDK mrC;

    private static final class a {
        public String SNGAppId;
        public String actionFlag;
        public String mrD;
        public String taskApkId;
        public String taskAppId;
        public String taskPackageName;
        public int taskVersion;
        public String uin;
        public String uinType;
        public String via;

        public final TMQQDownloaderOpenSDKParam xV(String str) {
            w.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[]{str});
            if (bg.mA(str)) {
                w.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.taskApkId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                    this.via = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_VIA);
                    this.taskVersion = jSONObject.optInt(OpenSDKTool4Assistant.EXTRA_TASK_VERSION);
                    this.mrD = jSONObject.optString("channelID");
                    this.uin = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UIN);
                    this.SNGAppId = jSONObject.optString("SNGAppId");
                    this.taskAppId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                    this.uinType = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                    this.taskPackageName = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                    this.actionFlag = jSONObject.optString("actionFlag");
                } catch (Exception e) {
                    w.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[]{e.getMessage()});
                }
            }
            return new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.mrD, this.actionFlag);
        }
    }

    private ay() {
    }

    public static ay aBw() {
        if (mrB == null) {
            synchronized (ay.class) {
                if (mrB == null) {
                    mrB = new ay();
                }
            }
        }
        return mrB;
    }

    private static TMQQDownloaderOpenSDK aBx() {
        if (mrC == null) {
            TMQQDownloaderOpenSDK instance = TMQQDownloaderOpenSDK.getInstance();
            mrC = instance;
            instance.initQQDownloaderOpenSDK(ab.getContext());
        }
        return mrC;
    }

    public static void aBy() {
        boolean z = false;
        String str = "MicroMsg.QQDownloaderSDKWrapper";
        String str2 = "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(mrC == null);
        if (mrB == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        if (mrC != null) {
            mrC.destroyQQDownloaderOpenSDK();
        }
        mrC = null;
        mrB = null;
    }

    public static void Z(Context context, String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
        } else if (context == null) {
            w.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
        } else {
            w.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[]{str});
            TMQQDownloaderOpenSDKParam xV = new a().xV(str);
            try {
                aBw();
                aBx().startToDownloadTaskList(context, xV, true, true);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
            }
        }
    }

    public static int xU(String str) {
        if (!bg.mA(str)) {
            return a(new a().xV(str));
        }
        w.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
        return -1;
    }

    private static int a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        try {
            aBw();
            TMAssistantDownloadTaskInfo downloadTaskState = aBx().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                return downloadTaskState.mState;
            }
        } catch (Exception e) {
            w.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[]{e.getMessage()});
        }
        return -1;
    }

    public static int e(Context context, String str, int i) {
        int i2 = -1;
        if (bg.mA(str)) {
            w.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
        } else {
            try {
                PackageInfo az = p.az(context, str);
                if (az == null) {
                    i2 = 1;
                } else {
                    w.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[]{Integer.valueOf(az.versionCode)});
                    i2 = az.versionCode >= i ? 0 : 2;
                }
            } catch (Exception e) {
                w.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[]{e.getMessage()});
            }
            w.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[]{Integer.valueOf(i2)});
        }
        return i2;
    }

    public static void startToAuthorized(Context context, String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            return;
        }
        TMQQDownloaderOpenSDKParam xV = new a().xV(str);
        try {
            aBw();
            aBx().startToAuthorized(context, xV, "1");
        } catch (Exception e) {
            w.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public static boolean registerListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        aBw();
        return aBx().registerListener(iTMQQDownloaderOpenSDKListener);
    }

    public static boolean unregisterListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        aBw();
        return aBx().unregisterListener(iTMQQDownloaderOpenSDKListener);
    }
}
