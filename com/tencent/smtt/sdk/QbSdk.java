package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.t;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SuppressLint({"NewApi"})
public class QbSdk {
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    public static q mTbsListener = null;
    public static q mTbsListenerForInit = null;
    public static boolean sIsVersionPrinted = false;
    static long sWifiConnectedTime = 0;
    static Map<String, Object> wTA = null;
    private static int wTb = 0;
    private static String wTc = "";
    private static Class<?> wTd;
    private static Object wTe;
    static boolean wTf = false;
    static boolean wTg = false;
    static boolean wTh = true;
    private static boolean wTi = false;
    private static String[] wTj;
    private static String wTk = "NULL";
    private static String wTl = "UNKNOWN";
    static String wTm;
    static boolean wTn = false;
    static long wTo = 0;
    static Object wTp = new Object();
    static boolean wTq = true;
    private static int wTr = 0;
    private static int wTs = 170;
    private static String wTt = null;
    private static String wTu = null;
    static volatile boolean wTv = wTf;
    private static boolean wTw = true;
    private static boolean wTx = false;
    private static boolean wTy = false;
    static q wTz = new q() {
        public final void iu(int i) {
            if (l.cen()) {
                TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                l.wUO = true;
                return;
            }
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            l.wUO = false;
            if (QbSdk.mTbsListener != null) {
                QbSdk.mTbsListener.iu(i);
            }
            if (QbSdk.mTbsListenerForInit != null) {
                QbSdk.mTbsListenerForInit.iu(i);
            }
        }

        public final void iv(int i) {
            QbSdk.setTBSInstallingStatus(false);
            l.wUO = false;
            if (l.ceo()) {
                l.wUO = true;
            } else {
                l.wUO = false;
            }
            if (QbSdk.mTbsListener != null) {
                QbSdk.mTbsListener.iv(i);
            }
            if (QbSdk.mTbsListenerForInit != null) {
                QbSdk.mTbsListenerForInit.iv(i);
            }
        }

        public final void iw(int i) {
            if (QbSdk.mTbsListenerForInit != null) {
                QbSdk.mTbsListenerForInit.iw(i);
            }
            if (QbSdk.mTbsListener != null) {
                QbSdk.mTbsListener.iw(i);
            }
        }
    };

    public interface a {
        void al(boolean z);

        void ot();
    }

    static boolean ag(Context context, int i) {
        if (fE(context)) {
            Object a = o.a(wTe, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43501), Integer.valueOf(20000));
            if (a != null) {
                return ((Boolean) a).booleanValue();
            }
            a = o.a(wTe, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43501));
            if (a != null) {
                return ((Boolean) a).booleanValue();
            }
        }
        return true;
    }

    static synchronized void bv(Context context, String str) {
        synchronized (QbSdk.class) {
            if (!wTf) {
                wTf = true;
                wTl = "forceSysWebViewInner: " + str;
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + wTl);
                i.cec().a(context, 401, new Throwable(wTl));
            }
        }
    }

    static Object c(Context context, String str, Bundle bundle) {
        if (!fD(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object a = o.a(wTe, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
        return a == null ? null : a;
    }

    public static boolean canLoadVideo(Context context) {
        Object a = o.a(wTe, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (a == null) {
            i.cec().ai(context, 314);
        } else if (!((Boolean) a).booleanValue()) {
            i.cec().ai(context, 313);
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }

    public static boolean canLoadX5(Context context) {
        return p(context, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (wTd == null) {
                p.ceA();
                File gk = p.gk(context);
                if (gk == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(t.ceO(), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    wTd = new DexClassLoader(file.getAbsolutePath(), gk.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
            }
            if (wTe == null) {
                if (t.ceK() == null) {
                    r.gr(context.getApplicationContext()).aN(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                    return false;
                }
                wTd.getConstructor(new Class[]{Context.class, Context.class});
                wTe = wTd.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, t.ceK()});
            }
            Object a = o.a(wTe, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void canOpenFile(final Context context, final String str, final y<Boolean> yVar) {
        new Thread() {
            public final void run() {
                boolean booleanValue;
                ac cfb = ac.cfb();
                cfb.b(context, null);
                if (cfb.cfc()) {
                    ad cfd = cfb.cfd();
                    Context context = context;
                    String str = str;
                    Object invokeStaticMethod = cfd.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
                    booleanValue = invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
                } else {
                    booleanValue = false;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 wTC;

                    public final void run() {
                        yVar.onReceiveValue(Boolean.valueOf(booleanValue));
                    }
                });
            }
        }.start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !o(context, false) ? false : false;
    }

    public static boolean canOpenWebPlus(Context context) {
        BufferedInputStream bufferedInputStream;
        boolean z;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        InputStream inputStream = null;
        if (wTr == 0) {
            wTr = a.cdP();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + wTr);
        if (VERSION.SDK_INT < 7 || wTr < wTs || context == null) {
            return false;
        }
        try {
            p.ceA();
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(p.gk(context), "tbs.conf")));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                String property = properties.getProperty("android_sdk_max_supported");
                String property2 = properties.getProperty("android_sdk_min_supported");
                int parseInt = Integer.parseInt(property);
                int parseInt2 = Integer.parseInt(property2);
                int parseInt3 = Integer.parseInt(VERSION.SDK);
                if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                    TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: " + parseInt3);
                    try {
                        bufferedInputStream.close();
                        return false;
                    } catch (Exception e) {
                        return false;
                    }
                }
                parseInt = Integer.parseInt(properties.getProperty("tbs_core_version"));
                try {
                    bufferedInputStream.close();
                } catch (Exception e2) {
                }
                InputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(new File(p.gm(context), "tbs_extension.conf"));
                    try {
                        Properties properties2 = new Properties();
                        properties2.load(fileInputStream);
                        int parseInt4 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                        parseInt2 = Integer.parseInt(properties2.getProperty("app_versioncode_for_switch"));
                        if (parseInt == 88888888 || parseInt4 == 88888888) {
                            z = false;
                        } else if (parseInt > parseInt4) {
                            z = false;
                        } else if (parseInt == parseInt4) {
                            if (parseInt2 > 0) {
                                if (parseInt2 != c.getAppVersionCode(context)) {
                                    z = false;
                                }
                            }
                            z = Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !k.fM(context.getApplicationContext()).wUG.getBoolean("switch_backupcore_enable", false);
                        } else {
                            z = false;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
                if (z) {
                }
            } catch (Throwable th4) {
                try {
                    TbsLog.i("QbSdk", "canOpenWebPlus - canLoadX5 Exception");
                    if (bufferedInputStream != null) {
                        return false;
                    }
                    try {
                        bufferedInputStream.close();
                        return false;
                    } catch (Exception e4) {
                        return false;
                    }
                } catch (Throwable th5) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th5;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object a = o.a(wTe, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
    }

    static String cdQ() {
        return wTc;
    }

    protected static String cdR() {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                return (String) invokeStaticMethod;
            }
        }
        return null;
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(Context context, boolean z) {
        try {
            WebView webView = new WebView(context);
            if (VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th));
        }
        ad cfd;
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                ac cfb = ac.cfb();
                if (cfb != null && cfb.cfc()) {
                    cfd = cfb.cfd();
                    TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
                    if (z) {
                        cfd.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
                        return;
                    }
                    cfd.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
                }
            }
        } catch (Exception e) {
            cfd.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            cfd.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            cfd.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            cfd.wWu.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            cfd.wWu.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = cfd.wWu.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                cfd.wWu.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            invokeStaticMethod = cfd.wWu.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                cfd.wWu.invokeMethod(invokeStaticMethod, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            cfd.wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        } catch (Throwable th2) {
        }
    }

    public static void closeFileReader(Context context) {
        ac cfb = ac.cfb();
        cfb.b(context, null);
        if (cfb.cfc()) {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null) {
            return false;
        }
        if (l.fP(context)) {
            return false;
        }
        if (isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            return false;
        }
        Bitmap bitmap = null;
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        DexLoader dexLoader = cfb.cfd().wWu;
        TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
        Object invokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
        TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + invokeStaticMethod);
        return invokeStaticMethod != null;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || l.fP(context)) {
            return false;
        }
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            return false;
        }
        return cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null;
    }

    public static void disAllowThirdAppDownload() {
        wTh = false;
    }

    static Bundle e(Context context, Bundle bundle) {
        if (fD(context)) {
            Object a = o.a(wTe, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a != null) {
                return (Bundle) a;
            }
            r.gr(context).aM(com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX, "incrUpdate return null!");
            return null;
        }
        r.gr(context).aM(com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX, "initForPatch return false!");
        return null;
    }

    private static boolean fD(Context context) {
        try {
            if (wTd != null) {
                return true;
            }
            p.ceA();
            File gk = p.gk(context);
            if (gk == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(gk, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                Class loadClass = new DexClassLoader(file.getAbsolutePath(), gk.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                wTd = loadClass;
                wTe = loadClass.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    private static boolean fE(Context context) {
        try {
            if (wTd != null) {
                return true;
            }
            p.ceA();
            File gk = p.gk(context);
            if (gk == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            } else if (t.gu(context)) {
                i.cec().ai(context, 304);
                return false;
            } else {
                p.ceA();
                File file = new File(p.gk(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    Class loadClass = new DexClassLoader(file.getAbsolutePath(), gk.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    wTd = loadClass;
                    Constructor constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                    if (!t.gu(context)) {
                        wTe = constructor.newInstance(new Object[]{context, context});
                    } else if (t.ceK() == null) {
                        r.gr(context.getApplicationContext()).aN(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                        return false;
                    } else {
                        wTe = wTd.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, t.ceK()});
                    }
                    o.a(wTe, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aMq, c.wXy, c.wXz, c.aQl);
                    o.a(wTe, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    return true;
                }
                i.cec().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
                return false;
            }
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        ac cfb = ac.cfb();
        if (cfb != null && cfb.cfc()) {
            try {
                cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, context, str, valueCallback);
            } catch (Throwable th) {
            }
        }
    }

    public static void forceSysWebView() {
        wTg = true;
        wTk = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        return context != null ? k.fM(context.getApplicationContext()).wUG.getLong("tbs_apkfilesize", 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (wTj instanceof String[]) {
            int length = wTj.length;
            String[] strArr = new String[length];
            while (i < length) {
                strArr[i] = str + wTj[i];
                i++;
            }
            return strArr;
        }
        Object a = o.a(wTe, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a instanceof String[])) {
            a = new String[]{""};
        }
        return (String[]) a;
    }

    public static boolean getDownloadWithoutWifi() {
        return wTx;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return wTg;
    }

    public static String getMiniQBVersion(Context context) {
        ac cfb = ac.cfb();
        cfb.b(context, null);
        if (cfb == null || !cfb.cfc()) {
            return null;
        }
        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public static String getQQBuildNumber() {
        return wTu;
    }

    public static boolean getTBSInstalling() {
        return wTy;
    }

    public static String getTID() {
        return wTt;
    }

    public static int getTbsVersion(Context context) {
        if (t.gu(context)) {
            return t.ceQ();
        }
        int gc = p.ceA().gc(context);
        if (gc != 0 || j.fL(context).Vp("install_status") != 3) {
            return gc;
        }
        reset(context);
        return gc;
    }

    public static void initBuglyAsync(boolean z) {
        wTq = z;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (wTA == null) {
            wTA = map;
            return;
        }
        try {
            wTA.putAll(map);
        } catch (Exception e) {
        }
    }

    public static void initX5Environment(final Context context, final a aVar) {
        if (context != null) {
            mTbsListenerForInit = new q() {
                public final void iu(int i) {
                }

                public final void iv(int i) {
                    QbSdk.preInit(context, aVar);
                }

                public final void iw(int i) {
                }
            };
            if (t.gu(context)) {
                p.ceA().v(context, true);
            }
            l.a(context, false, false, new com.tencent.smtt.sdk.l.a() {
                public final void e(boolean z, int i) {
                    if (t.ceR() != 0 || t.ceN()) {
                        if (QbSdk.wTq && t.gu(context)) {
                            m.cey().fR(context);
                        }
                        QbSdk.preInit(context, aVar);
                        return;
                    }
                    t.x(context, false);
                    if (QbSdk.wTq && t.gu(context)) {
                        m.cey().fR(context);
                    }
                }
            });
        }
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        d mb = d.mb(true);
        mb.a(context, null);
        if (mb == null || !mb.wTH) {
            return false;
        }
        Object invokeStaticMethod = mb.cdS().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (com.tencent.smtt.sdk.a.c.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                ac cfb = ac.cfb();
                if (cfb != null && cfb.cfc() && cfb.cfd().a(context, substring, null, str2, null) == 0) {
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (l.fP(context)) {
            return false;
        }
        ac cfb = ac.cfb();
        if (cfb == null || !cfb.cfc()) {
            return false;
        }
        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod == null) {
            return false;
        }
        return (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.valueOf(false)).booleanValue();
    }

    public static boolean isTbsCoreInited() {
        d mb = d.mb(false);
        return mb != null && mb.wTI;
    }

    public static boolean isX5DisabledSync(Context context) {
        if (j.fL(context).Vp("install_status") == 2) {
            int i = 1;
        } else {
            boolean z = false;
        }
        if (i != 0) {
            return false;
        }
        if (!fE(context)) {
            return true;
        }
        i = p.ceA().gc(context);
        Object a = o.a(wTe, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43501));
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    @SuppressLint({"NewApi"})
    private static boolean o(Context context, boolean z) {
        int i;
        Throwable th;
        int i2;
        File gk;
        Class loadClass;
        int i3 = -1;
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43501; SDK_VERSION_NAME: 3.5.0.1016");
            sIsVersionPrinted = true;
        }
        if (wTf && !z) {
            TbsLog.e("QbSdk", "QbSdk init: " + wTl, false);
            i.cec().a(context, 414, new Throwable(wTl));
            return false;
        } else if (wTg) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            i.cec().a(context, 402, new Throwable(wTk));
            return false;
        } else {
            File ced;
            Constructor constructor;
            if (!wTw) {
                wTw = true;
                SharedPreferences sharedPreferences;
                int i4;
                Editor edit;
                try {
                    sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
                    try {
                        i4 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
                        if (i4 >= 0) {
                            i4++;
                            if (i4 <= 4) {
                                i = i4;
                            }
                        } else {
                            i = i4;
                            i4 = -1;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        i4 = -1;
                        i2 = -1;
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                        i = -1;
                        if (i <= 3) {
                            try {
                                i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                edit = sharedPreferences.edit();
                                if (i != i2) {
                                    p.ceA();
                                    f.c(p.gk(context), false);
                                    j.fL(context);
                                    ced = j.ced();
                                    if (ced != null) {
                                        f.c(ced, false);
                                    }
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                                } else {
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i);
                                }
                                edit.putInt("tbs_precheck_disable_version", i);
                                edit.commit();
                            } catch (Throwable th3) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th3));
                            }
                        } else {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            ac.cfb().b(context, null);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i3 = 0;
                            try {
                                i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                }
                            } catch (Throwable th32) {
                                TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th32));
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i3);
                        }
                        p.ceA();
                        gk = p.gk(context);
                        if (gk == null) {
                            if (!t.gu(context)) {
                                if (wTb != 0) {
                                    i = 0;
                                } else {
                                    i = p.ceA().a(true, context);
                                    if (wTb != i) {
                                        wTd = null;
                                        wTe = null;
                                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                        TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + wTb, true);
                                        i.cec().a(context, 303, new Throwable("sTbsVersion: " + wTb + "; tbsCoreInstalledVer: " + i));
                                        return false;
                                    }
                                }
                                wTb = i;
                            }
                            if (wTd != null) {
                                return true;
                            }
                            if (t.gu(context)) {
                                p.ceA();
                                ced = new File(p.gk(context), "tbs_sdk_extension_dex.jar");
                                if (ced.exists()) {
                                    try {
                                        TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                                        i = p.ceA().gc(context);
                                        if (new File(ced.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                            if (i > 0) {
                                                i.cec().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                            } else {
                                                i.cec().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                            }
                                        } else if (i > 0) {
                                            i.cec().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                        } else {
                                            i.cec().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                        }
                                    } catch (Throwable th4) {
                                    }
                                    return false;
                                }
                                loadClass = new DexClassLoader(ced.getAbsolutePath(), gk.getAbsolutePath(), ced.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                wTd = loadClass;
                                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                if (!t.gu(context)) {
                                    wTe = constructor.newInstance(new Object[]{context, context});
                                } else if (t.ceK() == null) {
                                    wTe = wTd.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, t.ceK()});
                                } else {
                                    r.gr(context.getApplicationContext()).aN(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                                    return false;
                                }
                                o.a(wTe, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aMq, c.wXy, c.wXz, c.aQl);
                                o.a(wTe, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                                return true;
                            }
                            i.cec().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                            return false;
                        }
                        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                        i.cec().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                        return false;
                    }
                    try {
                        i2 = p.ceA().gc(context);
                        if (i2 > 0) {
                            if (i <= 4) {
                                try {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i).commit();
                                } catch (Throwable th5) {
                                    th32 = th5;
                                    TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                                    i = -1;
                                    if (i <= 3) {
                                        i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                        edit = sharedPreferences.edit();
                                        if (i != i2) {
                                            p.ceA();
                                            f.c(p.gk(context), false);
                                            j.fL(context);
                                            ced = j.ced();
                                            if (ced != null) {
                                                f.c(ced, false);
                                            }
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                                        } else {
                                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i);
                                        }
                                        edit.putInt("tbs_precheck_disable_version", i);
                                        edit.commit();
                                    } else {
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                        ac.cfb().b(context, null);
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                        i3 = 0;
                                        i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                        if (i > 0) {
                                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                        }
                                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i3);
                                    }
                                    p.ceA();
                                    gk = p.gk(context);
                                    if (gk == null) {
                                        if (t.gu(context)) {
                                            if (wTb != 0) {
                                                i = 0;
                                            } else {
                                                i = p.ceA().a(true, context);
                                                if (wTb != i) {
                                                    wTd = null;
                                                    wTe = null;
                                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + wTb, true);
                                                    i.cec().a(context, 303, new Throwable("sTbsVersion: " + wTb + "; tbsCoreInstalledVer: " + i));
                                                    return false;
                                                }
                                            }
                                            wTb = i;
                                        }
                                        if (wTd != null) {
                                            return true;
                                        }
                                        if (t.gu(context)) {
                                            p.ceA();
                                            ced = new File(p.gk(context), "tbs_sdk_extension_dex.jar");
                                            if (ced.exists()) {
                                                loadClass = new DexClassLoader(ced.getAbsolutePath(), gk.getAbsolutePath(), ced.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                                                wTd = loadClass;
                                                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                                                if (!t.gu(context)) {
                                                    wTe = constructor.newInstance(new Object[]{context, context});
                                                } else if (t.ceK() == null) {
                                                    wTe = wTd.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, t.ceK()});
                                                } else {
                                                    r.gr(context.getApplicationContext()).aN(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                                                    return false;
                                                }
                                                o.a(wTe, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aMq, c.wXy, c.wXz, c.aQl);
                                                o.a(wTe, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                                                return true;
                                            }
                                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                                            i = p.ceA().gc(context);
                                            if (new File(ced.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                                if (i > 0) {
                                                    i.cec().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                                } else {
                                                    i.cec().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                                                }
                                            } else if (i > 0) {
                                                i.cec().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                            } else {
                                                i.cec().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                            }
                                            return false;
                                        }
                                        i.cec().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                                        return false;
                                    }
                                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                                    i.cec().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                                    return false;
                                }
                            }
                            i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                            if (i >= 0) {
                                i++;
                                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i).commit();
                                if (i <= 3) {
                                    i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                    edit = sharedPreferences.edit();
                                    if (i != i2) {
                                        p.ceA();
                                        f.c(p.gk(context), false);
                                        j.fL(context);
                                        ced = j.ced();
                                        if (ced != null) {
                                            f.c(ced, false);
                                        }
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                                    } else {
                                        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i);
                                    }
                                    edit.putInt("tbs_precheck_disable_version", i);
                                    edit.commit();
                                } else {
                                    if (i4 > 0 && i4 <= 3) {
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                        ac.cfb().b(context, null);
                                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                        i3 = 0;
                                    }
                                    i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                    if (i > 0) {
                                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                    }
                                    TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i3);
                                }
                            }
                            i = -1;
                            if (i <= 3) {
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                                ac.cfb().b(context, null);
                                TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                                i3 = 0;
                                i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                                }
                                TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i3);
                            } else {
                                i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                edit = sharedPreferences.edit();
                                if (i != i2) {
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i);
                                } else {
                                    p.ceA();
                                    f.c(p.gk(context), false);
                                    j.fL(context);
                                    ced = j.ced();
                                    if (ced != null) {
                                        f.c(ced, false);
                                    }
                                    TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                                }
                                edit.putInt("tbs_precheck_disable_version", i);
                                edit.commit();
                            }
                        }
                    } catch (Throwable th6) {
                        th32 = th6;
                        i2 = -1;
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                        i = -1;
                        if (i <= 3) {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            ac.cfb().b(context, null);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                            i3 = 0;
                            i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                            if (i > 0) {
                                sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                            }
                            TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i3);
                        } else {
                            i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i != i2) {
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i);
                            } else {
                                p.ceA();
                                f.c(p.gk(context), false);
                                j.fL(context);
                                ced = j.ced();
                                if (ced != null) {
                                    f.c(ced, false);
                                }
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                            }
                            edit.putInt("tbs_precheck_disable_version", i);
                            edit.commit();
                        }
                        p.ceA();
                        gk = p.gk(context);
                        if (gk == null) {
                            TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                            i.cec().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                            return false;
                        }
                        if (t.gu(context)) {
                            if (wTb != 0) {
                                i = p.ceA().a(true, context);
                                if (wTb != i) {
                                    wTd = null;
                                    wTe = null;
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                    TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + wTb, true);
                                    i.cec().a(context, 303, new Throwable("sTbsVersion: " + wTb + "; tbsCoreInstalledVer: " + i));
                                    return false;
                                }
                            }
                            i = 0;
                            wTb = i;
                        }
                        if (wTd != null) {
                            return true;
                        }
                        if (t.gu(context)) {
                            i.cec().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                            return false;
                        }
                        p.ceA();
                        ced = new File(p.gk(context), "tbs_sdk_extension_dex.jar");
                        if (ced.exists()) {
                            TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                            i = p.ceA().gc(context);
                            if (new File(ced.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                                if (i > 0) {
                                    i.cec().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                } else {
                                    i.cec().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                                }
                            } else if (i > 0) {
                                i.cec().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            } else {
                                i.cec().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                            }
                            return false;
                        }
                        loadClass = new DexClassLoader(ced.getAbsolutePath(), gk.getAbsolutePath(), ced.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                        wTd = loadClass;
                        constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                        if (!t.gu(context)) {
                            wTe = constructor.newInstance(new Object[]{context, context});
                        } else if (t.ceK() == null) {
                            r.gr(context.getApplicationContext()).aN(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                            return false;
                        } else {
                            wTe = wTd.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, t.ceK()});
                        }
                        o.a(wTe, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aMq, c.wXy, c.wXz, c.aQl);
                        o.a(wTe, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                        return true;
                    }
                } catch (Throwable th7) {
                    th32 = th7;
                    sharedPreferences = null;
                    i2 = -1;
                    i4 = -1;
                    TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th32));
                    i = -1;
                    if (i <= 3) {
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        ac.cfb().b(context, null);
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        i3 = 0;
                        i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i - 1).commit();
                        }
                        TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i3);
                    } else {
                        i = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                        edit = sharedPreferences.edit();
                        if (i != i2) {
                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i);
                        } else {
                            p.ceA();
                            f.c(p.gk(context), false);
                            j.fL(context);
                            ced = j.ced();
                            if (ced != null) {
                                f.c(ced, false);
                            }
                            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                        }
                        edit.putInt("tbs_precheck_disable_version", i);
                        edit.commit();
                    }
                    p.ceA();
                    gk = p.gk(context);
                    if (gk == null) {
                        TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                        i.cec().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                        return false;
                    }
                    if (t.gu(context)) {
                        if (wTb != 0) {
                            i = p.ceA().a(true, context);
                            if (wTb != i) {
                                wTd = null;
                                wTe = null;
                                TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                                TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + wTb, true);
                                i.cec().a(context, 303, new Throwable("sTbsVersion: " + wTb + "; tbsCoreInstalledVer: " + i));
                                return false;
                            }
                        }
                        i = 0;
                        wTb = i;
                    }
                    if (wTd != null) {
                        return true;
                    }
                    if (t.gu(context)) {
                        i.cec().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                        return false;
                    }
                    p.ceA();
                    ced = new File(p.gk(context), "tbs_sdk_extension_dex.jar");
                    if (ced.exists()) {
                        TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                        i = p.ceA().gc(context);
                        if (new File(ced.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                            if (i > 0) {
                                i.cec().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                            } else {
                                i.cec().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                            }
                        } else if (i > 0) {
                            i.cec().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                        } else {
                            i.cec().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                        }
                        return false;
                    }
                    loadClass = new DexClassLoader(ced.getAbsolutePath(), gk.getAbsolutePath(), ced.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    wTd = loadClass;
                    constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                    if (!t.gu(context)) {
                        wTe = constructor.newInstance(new Object[]{context, context});
                    } else if (t.ceK() == null) {
                        r.gr(context.getApplicationContext()).aN(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                        return false;
                    } else {
                        wTe = wTd.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, t.ceK()});
                    }
                    o.a(wTe, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aMq, c.wXy, c.wXz, c.aQl);
                    o.a(wTe, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    return true;
                }
            }
            try {
                p.ceA();
                gk = p.gk(context);
                if (gk == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    i.cec().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                if (t.gu(context)) {
                    if (wTb != 0) {
                        i = p.ceA().a(true, context);
                        if (wTb != i) {
                            wTd = null;
                            wTe = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=" + i, true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + wTb, true);
                            i.cec().a(context, 303, new Throwable("sTbsVersion: " + wTb + "; tbsCoreInstalledVer: " + i));
                            return false;
                        }
                    }
                    i = 0;
                    wTb = i;
                }
                if (wTd != null) {
                    return true;
                }
                if (t.gu(context)) {
                    i.cec().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                p.ceA();
                ced = new File(p.gk(context), "tbs_sdk_extension_dex.jar");
                if (ced.exists()) {
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    i = p.ceA().gc(context);
                    if (new File(ced.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (i > 0) {
                            i.cec().a(context, 4131, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                        } else {
                            i.cec().a(context, 4132, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!" + i));
                        }
                    } else if (i > 0) {
                        i.cec().a(context, 4121, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                    } else {
                        i.cec().a(context, 4122, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!" + i));
                    }
                    return false;
                }
                loadClass = new DexClassLoader(ced.getAbsolutePath(), gk.getAbsolutePath(), ced.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                wTd = loadClass;
                constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                if (!t.gu(context)) {
                    wTe = constructor.newInstance(new Object[]{context, context});
                } else if (t.ceK() == null) {
                    r.gr(context.getApplicationContext()).aN(GameJsApiGetOpenDeviceId.CTRL_BYTE, "host context is null!");
                    return false;
                } else {
                    wTe = wTd.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, null, t.ceK()});
                }
                o.a(wTe, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, c.aMq, c.wXy, c.wXz, c.aQl);
                o.a(wTe, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                return true;
            } catch (Throwable th322) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th322));
                i.cec().a(context, 306, th322);
                return false;
            }
        }
    }

    static boolean p(Context context, boolean z) {
        int i = 1;
        boolean z2 = false;
        if (t.gu(context)) {
            t.ceT();
            i.cec().ai(context, 302);
        } else if (o(context, false)) {
            Object a = o.a(wTe, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(43501));
            boolean ag;
            if (a == null) {
                a = o.a(wTe, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.cdP()));
                if (a == null) {
                    i.cec().ai(context, 308);
                } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                    if (a instanceof Boolean) {
                        wTb = d.cdT();
                        ag = ag(context, d.cdT());
                        if (((Boolean) a).booleanValue() && !ag) {
                            z2 = true;
                        }
                        if (!z2) {
                            TbsLog.e("loaderror", "318");
                            TbsLog.w("loaderror", "isX5Disable:" + ag);
                            TbsLog.w("loaderror", "(Boolean) ret:" + ((Boolean) a));
                        }
                    }
                }
            } else if (!((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail"))) {
                if (a instanceof Bundle) {
                    Bundle bundle = (Bundle) a;
                    if (bundle.isEmpty()) {
                        i.cec().a(context, 331, new Throwable(String.valueOf(a)));
                        TbsLog.e("loaderror", "empty bundle");
                    } else {
                        int i2;
                        try {
                            i2 = bundle.getInt("result_code", -1);
                        } catch (Exception e) {
                            TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e.toString());
                            i2 = -1;
                        }
                        ag = i2 == 0;
                        String valueOf;
                        if (t.gu(context)) {
                            d.CV(t.ceP());
                            valueOf = String.valueOf(t.ceP());
                            wTc = valueOf;
                            if (valueOf.length() == 5) {
                                wTc = "0" + wTc;
                            }
                            if (wTc.length() != 6) {
                                wTc = "";
                            }
                        } else {
                            if (VERSION.SDK_INT >= 12) {
                                wTc = bundle.getString("tbs_core_version", "0");
                            } else {
                                valueOf = bundle.getString("tbs_core_version");
                                wTc = valueOf;
                                if (valueOf == null) {
                                    wTc = "0";
                                }
                            }
                            try {
                                wTb = Integer.parseInt(wTc);
                            } catch (NumberFormatException e2) {
                                wTb = 0;
                            }
                            d.CV(wTb);
                            if (wTb == 0) {
                                i.cec().a(context, 307, new Throwable("sTbsVersion is 0"));
                            } else {
                                if ((wTb <= 0 || wTb > 25442) && wTb != 25472) {
                                    i = 0;
                                }
                                if (i != 0) {
                                    TbsLog.e("TbsDownload", "is_obsolete --> delete old core:" + wTb);
                                    p.ceA();
                                    f.J(p.gk(context));
                                    i.cec().a(context, 307, new Throwable("is_obsolete --> delete old core:" + wTb));
                                }
                            }
                        }
                        try {
                            wTj = bundle.getStringArray("tbs_jarfiles");
                            if (wTj instanceof String[]) {
                                wTm = bundle.getString("tbs_librarypath");
                                a = null;
                                if (i2 != 0) {
                                    try {
                                        a = o.a(wTe, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e3) {
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(a instanceof Integer)) {
                                            i.cec().a(context, TencentLocation.ERROR_UNKNOWN, new Throwable("detail: " + a));
                                            z2 = ag;
                                            break;
                                        }
                                        i.cec().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                        z2 = ag;
                                        break;
                                    case -1:
                                        if (!(a instanceof Integer)) {
                                            i.cec().a(context, 307, new Throwable("detail: " + a));
                                            z2 = ag;
                                            break;
                                        }
                                        i.cec().a(context, ((Integer) a).intValue(), new Throwable("detail: " + a));
                                        z2 = ag;
                                        break;
                                    case 0:
                                        z2 = ag;
                                        break;
                                    default:
                                        i.cec().a(context, 415, new Throwable("detail: " + a + "errcode" + i2));
                                        z2 = ag;
                                        break;
                                }
                            }
                            i.cec().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + wTj));
                        } catch (Throwable th) {
                            i.cec().a(context, 329, th);
                        }
                    }
                } else {
                    i.cec().a(context, 330, new Throwable(String.valueOf(a)));
                    TbsLog.e("loaderror", "ret not instance of bundle");
                }
            }
            if (!z2) {
                TbsLog.e("loaderror", "319");
            }
        } else {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
        }
        return z2;
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(final Context context, final a aVar) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            wTv = wTf;
            if (!wTi) {
                final Handler anonymousClass2 = new Handler(Looper.getMainLooper()) {
                    public final void handleMessage(Message message) {
                        switch (message.what) {
                            case 1:
                                ad cfd = ac.cfb().cfd();
                                if (cfd != null) {
                                    cfd.gG(context);
                                }
                                if (aVar != null) {
                                    aVar.al(true);
                                }
                                TbsLog.writeLogToDisk();
                                return;
                            case 2:
                                if (aVar != null) {
                                    aVar.al(false);
                                }
                                TbsLog.writeLogToDisk();
                                return;
                            case 3:
                                if (aVar != null) {
                                    aVar.ot();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                Thread anonymousClass3 = new Thread() {
                    public final void run() {
                        if (p.ceA().a(true, context) == 0) {
                            p.ceA().v(context, true);
                        }
                        d.mb(true).a(context, null);
                        ac cfb = ac.cfb();
                        cfb.b(context, null);
                        boolean cfc = cfb.cfc();
                        anonymousClass2.sendEmptyMessage(3);
                        if (cfc) {
                            anonymousClass2.sendEmptyMessage(1);
                        } else {
                            anonymousClass2.sendEmptyMessage(2);
                        }
                    }
                };
                anonymousClass3.setName("tbs_preinit");
                anonymousClass3.setPriority(10);
                anonymousClass3.start();
                wTi = true;
            }
        }
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reset(android.content.Context r5, boolean r6) {
        /*
        r1 = 0;
        r0 = 1;
        r2 = "QbSdk";
        r3 = "QbSdk reset!";
        com.tencent.smtt.utils.TbsLog.e(r2, r3, r0);
        com.tencent.smtt.sdk.l.stopDownload();	 Catch:{ Throwable -> 0x008d }
        if (r6 == 0) goto L_0x00a9;
    L_0x0010:
        r2 = com.tencent.smtt.sdk.t.gu(r5);	 Catch:{ Throwable -> 0x008d }
        if (r2 != 0) goto L_0x00a9;
    L_0x0016:
        com.tencent.smtt.sdk.p.ceA();	 Catch:{ Throwable -> 0x008d }
        r2 = com.tencent.smtt.sdk.p.gb(r5);	 Catch:{ Throwable -> 0x008d }
        r3 = com.tencent.smtt.sdk.p.ceA();	 Catch:{ Throwable -> 0x008d }
        r3 = r3.gc(r5);	 Catch:{ Throwable -> 0x008d }
        r4 = 43300; // 0xa924 float:6.0676E-41 double:2.1393E-319;
        if (r2 <= r4) goto L_0x00a9;
    L_0x002a:
        if (r2 == r3) goto L_0x00a9;
    L_0x002c:
        com.tencent.smtt.sdk.l.fQ(r5);	 Catch:{ Throwable -> 0x008d }
        r1 = "tbs";
        r2 = 0;
        r1 = r5.getDir(r1, r2);	 Catch:{ Throwable -> 0x008d }
        r2 = "core_share_decouple";
        com.tencent.smtt.utils.f.d(r1, r2);	 Catch:{ Throwable -> 0x008d }
        r1 = "QbSdk";
        r2 = "delete downloaded apk success";
        r3 = 1;
        com.tencent.smtt.utils.TbsLog.i(r1, r2, r3);	 Catch:{ Throwable -> 0x008d }
        r1 = com.tencent.smtt.sdk.p.wVj;	 Catch:{ Throwable -> 0x008d }
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Throwable -> 0x008d }
        r1.set(r2);	 Catch:{ Throwable -> 0x008d }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x008d }
        r2 = r5.getFilesDir();	 Catch:{ Throwable -> 0x008d }
        r3 = "bugly_switch.txt";
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x008d }
        r2 = r1.exists();	 Catch:{ Throwable -> 0x008d }
        if (r2 == 0) goto L_0x0066;
    L_0x0063:
        r1.delete();	 Catch:{ Throwable -> 0x008d }
    L_0x0066:
        if (r0 == 0) goto L_0x008c;
    L_0x0068:
        com.tencent.smtt.sdk.p.ceA();	 Catch:{ Throwable -> 0x008d }
        r0 = com.tencent.smtt.sdk.p.gj(r5);	 Catch:{ Throwable -> 0x008d }
        com.tencent.smtt.sdk.p.ceA();	 Catch:{ Throwable -> 0x008d }
        r1 = com.tencent.smtt.sdk.p.gn(r5);	 Catch:{ Throwable -> 0x008d }
        com.tencent.smtt.utils.f.h(r0, r1);	 Catch:{ Throwable -> 0x008d }
        com.tencent.smtt.sdk.p.ceA();	 Catch:{ Throwable -> 0x008d }
        r0 = 1;
        com.tencent.smtt.sdk.p.w(r5, r0);	 Catch:{ Throwable -> 0x008d }
        r0 = com.tencent.smtt.sdk.j.fL(r5);	 Catch:{ Throwable -> 0x008d }
        r1 = com.tencent.smtt.sdk.p.gb(r5);	 Catch:{ Throwable -> 0x008d }
        r2 = 2;
        r0.eB(r1, r2);	 Catch:{ Throwable -> 0x008d }
    L_0x008c:
        return;
    L_0x008d:
        r0 = move-exception;
        r1 = "QbSdk";
        r2 = new java.lang.StringBuilder;
        r3 = "QbSdk reset exception:";
        r2.<init>(r3);
        r0 = android.util.Log.getStackTraceString(r0);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
        goto L_0x008c;
    L_0x00a9:
        r0 = r1;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.reset(android.content.Context, boolean):void");
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            p.ceA();
            f.J(p.gj(context));
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            wTt = "0000000000000000".substring(substring.length()) + substring;
        }
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        c.aMq = str;
        c.wXy = str2;
        c.wXz = str3;
        c.aQl = str4;
    }

    public static void setDownloadWithoutWifi(boolean z) {
        wTx = z;
    }

    public static void setQQBuildNumber(String str) {
        wTu = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        wTy = z;
    }

    public static void setTbsListener(q qVar) {
        mTbsListener = qVar;
    }

    public static void setTbsLogClient(t tVar) {
        TbsLog.setTbsLogClient(tVar);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        i.cec().ai(context, 501);
        if (context == null) {
            return -100;
        }
        ac cfb = ac.cfb();
        cfb.b(context, null);
        if (!cfb.cfc()) {
            i.cec().ai(context, 502);
            return -102;
        } else if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return -101;
        } else {
            int a = cfb.cfd().a(context, str, hashMap, null, valueCallback);
            if (a == 0) {
                i.cec().ai(context, 503);
                return a;
            }
            r.gr(context).aN(504, String.valueOf(a));
            return a;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == "com.tencent.mobileqq") {
                    ac cfb = ac.cfb();
                    if (cfb != null && cfb.cfc()) {
                        Object invokeStaticMethod = cfb.cfd().wWu.invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
                        if (invokeStaticMethod != null) {
                            IX5WebViewBase iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                            if (iX5WebViewBase != null) {
                                webView = (WebView) iX5WebViewBase.getView().getParent();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return com.tencent.smtt.sdk.a.c.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, y<String> yVar) {
        if (context == null) {
            return false;
        }
        ac cfb = ac.cfb();
        cfb.b(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && cfb.cfc()) {
            cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (com.tencent.smtt.sdk.a.c.a(context, str, hashMap, str2, null) == 0) {
            return true;
        }
        if (cfb.cfc()) {
            if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                return false;
            }
            if (cfb.cfd().a(context, str, hashMap, null, yVar) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void unForceSysWebView() {
        wTg = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (wTe == null) {
            return false;
        }
        Object a = o.a(wTe, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = o.a(wTe, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.cdP()));
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }
}
