package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.qq.taf.jce.BuildConfig;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l {
    public static Context aMW;
    private static String wUH;
    private static Handler wUI;
    private static String wUJ;
    public static boolean wUK = false;
    private static Object wUL = new byte[0];
    public static h wUM;
    private static HandlerThread wUN;
    static boolean wUO;
    private static boolean wUP = false;
    private static boolean wUQ = false;
    private static boolean wUR = false;
    private static long wUS = -1;

    public interface a {
        void e(boolean z, int i);
    }

    protected static File Da(int i) {
        String[] ceL = t.ceL();
        File file = null;
        for (int i2 = 0; i2 < 4; i2++) {
            String str = ceL[i2];
            if (!str.equals(aMW.getApplicationInfo().packageName)) {
                file = new File(f.a(aMW, str, 4, false), fP(aMW) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (!file.exists()) {
                    TbsLog.i("TbsDownload", "can not find local backup core file");
                } else if (com.tencent.smtt.utils.a.c(aMW, file) == i) {
                    TbsLog.i("TbsDownload", "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i("TbsDownload", "version is not match");
                }
            }
        }
        return file;
    }

    protected static File Db(int i) {
        String[] ceL = t.ceL();
        File file = null;
        for (int i2 = 0; i2 < 4; i2++) {
            String str = ceL[i2];
            File file2 = new File(f.a(aMW, str, 4, false), fP(aMW) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file2.exists() && com.tencent.smtt.utils.a.c(aMW, file2) == i) {
                TbsLog.i("TbsDownload", "local tbs version fond,path = " + file2.getAbsolutePath());
                return file2;
            }
            file = new File(f.a(aMW, str, 4, false), "x5.tbs.decouple");
            if (file.exists() && com.tencent.smtt.utils.a.c(aMW, file) == i) {
                TbsLog.i("TbsDownload", "local tbs version fond,path = " + file.getAbsolutePath());
                return file;
            }
        }
        return file;
    }

    private static String Vs(String str) {
        return str == null ? "" : str;
    }

    private static boolean a(Context context, boolean z, a aVar) {
        Matcher matcher = null;
        k fM = k.fM(context);
        if (VERSION.SDK_INT < 8) {
            fM.CY(-102);
            return false;
        }
        if (!fM.wUG.contains("is_oversea")) {
            if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
                z = false;
            }
            fM.wUF.put("is_oversea", Boolean.valueOf(z));
            fM.commit();
            wUQ = z;
            TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + z);
        }
        if (!fP(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
            CharSequence string = fM.wUG.getString("device_cpuabi", matcher);
            wUJ = string;
            if (!TextUtils.isEmpty(string)) {
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(wUJ);
                } catch (Exception e) {
                }
                if (matcher != null && matcher.find()) {
                    if (aVar != null) {
                        aVar.e(false, 0);
                    }
                    fM.CY(-104);
                    return false;
                }
            }
            return true;
        }
        TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
        if (aVar != null) {
            aVar.e(false, 0);
        }
        fM.CY(-103);
        return false;
    }

    public static boolean a(Context context, boolean z, boolean z2, a aVar) {
        TbsLog.initIfNeed(context);
        if (!p.wVm) {
            TbsLog.app_extra("TbsDownload", context);
            Context applicationContext = context.getApplicationContext();
            aMW = applicationContext;
            k fM = k.fM(applicationContext);
            fM.CY(-100);
            if (!a(aMW, z, aVar)) {
                return false;
            }
            ceq();
            if (wUP) {
                if (aVar != null) {
                    aVar.e(false, 0);
                }
                fM.CY(-105);
                return false;
            }
            boolean contains;
            boolean d = d(aMW, z2, false);
            if (d) {
                TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
                wUI.removeMessages(100);
                Message obtain = Message.obtain(wUI, 100);
                if (aVar != null) {
                    obtain.obj = aVar;
                }
                obtain.arg1 = 0;
                obtain.arg1 = z2 ? 1 : 0;
                obtain.sendToTarget();
                fM.CY(-114);
            }
            wUI.removeMessages(102);
            Message.obtain(wUI, 102).sendToTarget();
            if (QbSdk.wTh || !t.gu(context)) {
                contains = fM.wUG.contains("tbs_needdownload");
                TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + contains);
                contains = (contains || t.gu(context)) ? fM.wUG.getBoolean("tbs_needdownload", false) : true;
            } else {
                contains = false;
            }
            if (!contains) {
                int ge = p.ceA().ge(aMW);
                if (d || ge <= 0) {
                    wUI.removeMessages(103);
                    if (ge > 0 || d) {
                        Message.obtain(wUI, 103, 1, 0, aMW).sendToTarget();
                    } else {
                        Message.obtain(wUI, 103, 0, 0, aMW).sendToTarget();
                    }
                    fM.CY(-121);
                } else {
                    fM.CY(-119);
                }
            } else if (cew()) {
                fM.CY(-118);
            } else {
                contains = false;
            }
            if (!(d || aVar == null)) {
                aVar.e(false, 0);
            }
            TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + contains);
            return contains;
        } else if (aVar == null) {
            return false;
        } else {
            aVar.e(false, 0);
            return false;
        }
    }

    public static synchronized boolean atk() {
        boolean z;
        synchronized (l.class) {
            TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + wUO);
            z = wUO;
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    private static boolean c(java.lang.String r29, int r30, boolean r31, boolean r32) {
        /*
        r2 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r4 = "[TbsDownloader.readResponse] response=";
        r3.<init>(r4);
        r0 = r29;
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = aMW;
        r12 = com.tencent.smtt.sdk.k.fM(r2);
        r2 = android.text.TextUtils.isEmpty(r29);
        if (r2 == 0) goto L_0x0033;
    L_0x0024:
        if (r31 == 0) goto L_0x002d;
    L_0x0026:
        r2 = -108; // 0xffffffffffffff94 float:NaN double:NaN;
        r12.CY(r2);
    L_0x002b:
        r2 = 0;
    L_0x002c:
        return r2;
    L_0x002d:
        r2 = -208; // 0xffffffffffffff30 float:NaN double:NaN;
        r12.CY(r2);
        goto L_0x002b;
    L_0x0033:
        r13 = new org.json.JSONObject;
        r0 = r29;
        r13.<init>(r0);
        r2 = "RET";
        r2 = r13.getInt(r2);
        if (r2 == 0) goto L_0x0052;
    L_0x0043:
        if (r31 == 0) goto L_0x004c;
    L_0x0045:
        r2 = -109; // 0xffffffffffffff93 float:NaN double:NaN;
        r12.CY(r2);
    L_0x004a:
        r2 = 0;
        goto L_0x002c;
    L_0x004c:
        r2 = -209; // 0xffffffffffffff2f float:NaN double:NaN;
        r12.CY(r2);
        goto L_0x004a;
    L_0x0052:
        r2 = "RESPONSECODE";
        r14 = r13.getInt(r2);
        r2 = "DOWNLOADURL";
        r15 = r13.getString(r2);
        r2 = "URLLIST";
        r3 = "";
        r16 = r13.optString(r2, r3);
        r2 = "TBSAPKSERVERVERSION";
        r17 = r13.getInt(r2);
        r2 = "DOWNLOADMAXFLOW";
        r18 = r13.getInt(r2);
        r2 = "DOWNLOAD_MIN_FREE_SPACE";
        r19 = r13.getInt(r2);
        r2 = "DOWNLOAD_SUCCESS_MAX_RETRYTIMES";
        r20 = r13.getInt(r2);
        r2 = "DOWNLOAD_FAILED_MAX_RETRYTIMES";
        r21 = r13.getInt(r2);
        r2 = "DOWNLOAD_SINGLE_TIMEOUT";
        r22 = r13.getLong(r2);
        r2 = "TBSAPKFILESIZE";
        r24 = r13.getLong(r2);
        r2 = "RETRY_INTERVAL";
        r4 = 0;
        r10 = r13.optLong(r2, r4);
        r2 = "FLOWCTR";
        r3 = -1;
        r26 = r13.optInt(r2, r3);
        r2 = 0;
        r3 = "USEBBACKUPVER";
        r2 = r13.getInt(r3);	 Catch:{ Exception -> 0x0759 }
    L_0x00b4:
        r3 = r12.wUF;
        r4 = "use_backup_version";
        r2 = java.lang.Integer.valueOf(r2);
        r3.put(r4, r2);
        if (r31 == 0) goto L_0x00e6;
    L_0x00c2:
        r2 = com.tencent.smtt.sdk.QbSdk.wTq;
        if (r2 == 0) goto L_0x00e6;
    L_0x00c6:
        r2 = aMW;
        r2 = com.tencent.smtt.sdk.t.gu(r2);
        if (r2 == 0) goto L_0x00e6;
    L_0x00ce:
        r2 = "BUGLY";
        r3 = 0;
        r2 = r13.optInt(r2, r3);	 Catch:{ Throwable -> 0x01d0 }
        r3 = com.tencent.smtt.sdk.m.cey();	 Catch:{ Throwable -> 0x01d0 }
        r4 = aMW;	 Catch:{ Throwable -> 0x01d0 }
        r5 = "bugly_switch.txt";
        r6 = 1;
        if (r2 != r6) goto L_0x01cd;
    L_0x00e2:
        r2 = 1;
    L_0x00e3:
        r3.n(r4, r5, r2);	 Catch:{ Throwable -> 0x01d0 }
    L_0x00e6:
        if (r31 == 0) goto L_0x0117;
    L_0x00e8:
        r2 = "TEMPLATESWITCH";
        r3 = 0;
        r2 = r13.optInt(r2, r3);	 Catch:{ Throwable -> 0x01f0 }
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x01ed;
    L_0x00f4:
        r2 = 1;
    L_0x00f5:
        r3 = com.tencent.smtt.sdk.m.cey();	 Catch:{ Throwable -> 0x01f0 }
        r4 = aMW;	 Catch:{ Throwable -> 0x01f0 }
        r5 = "cookie_switch.txt";
        r3.n(r4, r5, r2);	 Catch:{ Throwable -> 0x01f0 }
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01f0 }
        r5 = "useCookieCompatiable:";
        r4.<init>(r5);	 Catch:{ Throwable -> 0x01f0 }
        r2 = r4.append(r2);	 Catch:{ Throwable -> 0x01f0 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01f0 }
        com.tencent.smtt.utils.TbsLog.w(r3, r2);	 Catch:{ Throwable -> 0x01f0 }
    L_0x0117:
        r7 = 0;
        r6 = 0;
        r4 = 0;
        r5 = 0;
        r2 = 0;
        r3 = "";
        r8 = "PKGMD5";
        r8 = r13.getString(r8);	 Catch:{ Exception -> 0x0210 }
        r7 = "RESETX5";
        r7 = r13.getInt(r7);	 Catch:{ Exception -> 0x0743 }
        r6 = "UPLOADLOG";
        r6 = r13.getInt(r6);	 Catch:{ Exception -> 0x0747 }
        r5 = "RESETTOKEN";
        r5 = r13.has(r5);	 Catch:{ Exception -> 0x074c }
        if (r5 == 0) goto L_0x0765;
    L_0x013d:
        r5 = "RESETTOKEN";
        r2 = r13.getInt(r5);	 Catch:{ Exception -> 0x074c }
        if (r2 == 0) goto L_0x020d;
    L_0x0146:
        r2 = 1;
    L_0x0147:
        r5 = r2;
    L_0x0148:
        r2 = "SETTOKEN";
        r2 = r13.has(r2);	 Catch:{ Exception -> 0x0752 }
        if (r2 == 0) goto L_0x0762;
    L_0x0151:
        r2 = "SETTOKEN";
        r2 = r13.getString(r2);	 Catch:{ Exception -> 0x0752 }
    L_0x0158:
        r9 = r8;
        r8 = r7;
        r7 = r6;
        r6 = r5;
        r5 = r2;
    L_0x015d:
        r2 = "RESETDECOUPLECORE";
        r2 = r13.getInt(r2);	 Catch:{ Exception -> 0x0218 }
    L_0x0164:
        r3 = 0;
        r4 = "RESETTODECOUPLECORE";
        r3 = r13.getInt(r4);	 Catch:{ Exception -> 0x0740 }
    L_0x016c:
        r4 = wUL;
        monitor-enter(r4);
        if (r6 == 0) goto L_0x0180;
    L_0x0171:
        r6 = r12.wUF;	 Catch:{ all -> 0x021c }
        r27 = "tbs_deskey_token";
        r28 = "";
        r0 = r27;
        r1 = r28;
        r6.put(r0, r1);	 Catch:{ all -> 0x021c }
    L_0x0180:
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x021c }
        if (r6 != 0) goto L_0x01b6;
    L_0x0186:
        r6 = r5.length();	 Catch:{ all -> 0x021c }
        r27 = 96;
        r0 = r27;
        if (r6 != r0) goto L_0x01b6;
    L_0x0190:
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x021c }
        r6.<init>();	 Catch:{ all -> 0x021c }
        r5 = r6.append(r5);	 Catch:{ all -> 0x021c }
        r6 = "&";
        r5 = r5.append(r6);	 Catch:{ all -> 0x021c }
        r6 = com.tencent.smtt.utils.j.cfp();	 Catch:{ all -> 0x021c }
        r5 = r5.append(r6);	 Catch:{ all -> 0x021c }
        r5 = r5.toString();	 Catch:{ all -> 0x021c }
        r6 = r12.wUF;	 Catch:{ all -> 0x021c }
        r27 = "tbs_deskey_token";
        r0 = r27;
        r6.put(r0, r5);	 Catch:{ all -> 0x021c }
    L_0x01b6:
        monitor-exit(r4);	 Catch:{ all -> 0x021c }
        r4 = 1;
        if (r8 != r4) goto L_0x0227;
    L_0x01ba:
        if (r31 == 0) goto L_0x021f;
    L_0x01bc:
        r2 = -110; // 0xffffffffffffff92 float:NaN double:NaN;
        r12.CY(r2);
    L_0x01c1:
        r4 = aMW;
        r2 = 1;
        if (r3 != r2) goto L_0x0225;
    L_0x01c6:
        r2 = 1;
    L_0x01c7:
        com.tencent.smtt.sdk.QbSdk.reset(r4, r2);
        r2 = 0;
        goto L_0x002c;
    L_0x01cd:
        r2 = 0;
        goto L_0x00e3;
    L_0x01d0:
        r2 = move-exception;
        r3 = "qbsdk";
        r4 = new java.lang.StringBuilder;
        r5 = "throwable:";
        r4.<init>(r5);
        r2 = r2.toString();
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r2);
        goto L_0x00e6;
    L_0x01ed:
        r2 = 0;
        goto L_0x00f5;
    L_0x01f0:
        r2 = move-exception;
        r3 = "qbsdk";
        r4 = new java.lang.StringBuilder;
        r5 = "throwable:";
        r4.<init>(r5);
        r2 = r2.toString();
        r2 = r4.append(r2);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r2);
        goto L_0x0117;
    L_0x020d:
        r2 = 0;
        goto L_0x0147;
    L_0x0210:
        r8 = move-exception;
    L_0x0211:
        r8 = r6;
        r9 = r7;
        r7 = r5;
        r6 = r2;
        r5 = r3;
        goto L_0x015d;
    L_0x0218:
        r2 = move-exception;
        r2 = r4;
        goto L_0x0164;
    L_0x021c:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x021c }
        throw r2;
    L_0x021f:
        r2 = -210; // 0xffffffffffffff2e float:NaN double:NaN;
        r12.CY(r2);
        goto L_0x01c1;
    L_0x0225:
        r2 = 0;
        goto L_0x01c7;
    L_0x0227:
        r3 = 1;
        if (r2 != r3) goto L_0x022f;
    L_0x022a:
        r2 = aMW;
        com.tencent.smtt.sdk.QbSdk.resetDecoupleCore(r2);
    L_0x022f:
        r2 = 1;
        if (r7 != r2) goto L_0x0244;
    L_0x0232:
        r2 = wUI;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2.removeMessages(r3);
        r2 = wUI;
        r3 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r2 = android.os.Message.obtain(r2, r3);
        r2.sendToTarget();
    L_0x0244:
        r4 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;
        r2 = 1;
        r0 = r26;
        if (r0 != r2) goto L_0x075c;
    L_0x024c:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x075f;
    L_0x0253:
        r2 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
    L_0x0256:
        r6 = 0;
        r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r6 <= 0) goto L_0x075c;
    L_0x025c:
        r4 = wUS;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 < 0) goto L_0x0266;
    L_0x0264:
        r2 = wUS;
    L_0x0266:
        r4 = r12.wUF;
        r5 = "retry_interval";
        r2 = java.lang.Long.valueOf(r2);
        r4.put(r5, r2);
        r2 = 0;
        r3 = 0;
        if (r31 == 0) goto L_0x0325;
    L_0x0276:
        r4 = "DECOUPLECOREVERSION";
        r2 = r13.getInt(r4);	 Catch:{ Exception -> 0x073d }
    L_0x027d:
        r4 = aMW;	 Catch:{ Exception -> 0x073a }
        r4 = com.tencent.smtt.sdk.k.fM(r4);	 Catch:{ Exception -> 0x073a }
        r4 = r4.wUG;	 Catch:{ Exception -> 0x073a }
        r5 = "tbs_downloaddecouplecore";
        r6 = 0;
        r3 = r4.getInt(r5, r6);	 Catch:{ Exception -> 0x073a }
    L_0x028d:
        if (r31 == 0) goto L_0x02a2;
    L_0x028f:
        r4 = aMW;
        r4 = com.tencent.smtt.sdk.t.gu(r4);
        if (r4 != 0) goto L_0x02a2;
    L_0x0297:
        if (r2 != 0) goto L_0x02a2;
    L_0x0299:
        com.tencent.smtt.sdk.p.ceA();
        r2 = aMW;
        r2 = com.tencent.smtt.sdk.p.gb(r2);
    L_0x02a2:
        r4 = "TbsDownload";
        r5 = new java.lang.StringBuilder;
        r6 = "in response decoupleCoreVersion is ";
        r5.<init>(r6);
        r5 = r5.append(r2);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r4, r5);
        r4 = r12.wUF;
        r5 = "tbs_decouplecoreversion";
        r6 = java.lang.Integer.valueOf(r2);
        r4.put(r5, r6);
        r4 = r12.wUF;
        r5 = "tbs_downloaddecouplecore";
        r6 = java.lang.Integer.valueOf(r3);
        r4.put(r5, r6);
        r4 = aMW;
        r4 = com.tencent.smtt.sdk.t.gu(r4);
        if (r4 != 0) goto L_0x02fa;
    L_0x02d8:
        if (r2 <= 0) goto L_0x0337;
    L_0x02da:
        com.tencent.smtt.sdk.p.ceA();
        r4 = aMW;
        r4 = com.tencent.smtt.sdk.p.gb(r4);
        if (r2 == r4) goto L_0x0337;
    L_0x02e5:
        r4 = com.tencent.smtt.sdk.p.ceA();
        r5 = aMW;
        r4 = r4.gc(r5);
        if (r2 != r4) goto L_0x0337;
    L_0x02f1:
        r2 = com.tencent.smtt.sdk.p.ceA();
        r4 = aMW;
        r2.gg(r4);
    L_0x02fa:
        r2 = android.text.TextUtils.isEmpty(r15);
        if (r2 == 0) goto L_0x0348;
    L_0x0300:
        r2 = aMW;
        r2 = com.tencent.smtt.sdk.t.gu(r2);
        if (r2 == 0) goto L_0x0348;
    L_0x0308:
        r2 = r12.wUF;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r12.commit();
        if (r31 == 0) goto L_0x0322;
    L_0x031a:
        r2 = aMW;
        r3 = 0;
        r0 = r17;
        com.tencent.smtt.sdk.t.c(r2, r0, r3);
    L_0x0322:
        r2 = 0;
        goto L_0x002c;
    L_0x0325:
        r4 = aMW;	 Catch:{ Exception -> 0x073d }
        r4 = com.tencent.smtt.sdk.k.fM(r4);	 Catch:{ Exception -> 0x073d }
        r4 = r4.wUG;	 Catch:{ Exception -> 0x073d }
        r5 = "tbs_decouplecoreversion";
        r6 = 0;
        r2 = r4.getInt(r5, r6);	 Catch:{ Exception -> 0x073d }
        goto L_0x027d;
    L_0x0337:
        if (r2 != 0) goto L_0x02fa;
    L_0x0339:
        com.tencent.smtt.sdk.p.ceA();	 Catch:{ Throwable -> 0x0346 }
        r2 = aMW;	 Catch:{ Throwable -> 0x0346 }
        r2 = com.tencent.smtt.sdk.p.gj(r2);	 Catch:{ Throwable -> 0x0346 }
        com.tencent.smtt.utils.f.J(r2);	 Catch:{ Throwable -> 0x0346 }
        goto L_0x02fa;
    L_0x0346:
        r2 = move-exception;
        goto L_0x02fa;
    L_0x0348:
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "in response responseCode is ";
        r4.<init>(r5);
        r4 = r4.append(r14);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
        if (r14 != 0) goto L_0x03ae;
    L_0x0360:
        r2 = r12.wUF;
        r3 = "tbs_responsecode";
        r4 = java.lang.Integer.valueOf(r14);
        r2.put(r3, r4);
        r2 = r12.wUF;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        if (r31 == 0) goto L_0x039a;
    L_0x037b:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -111; // 0xffffffffffffff91 float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x0389:
        r12.commit();
        r2 = aMW;
        r2 = com.tencent.smtt.sdk.t.gu(r2);
        if (r2 != 0) goto L_0x0397;
    L_0x0394:
        ceo();
    L_0x0397:
        r2 = 0;
        goto L_0x002c;
    L_0x039a:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -211; // 0xffffffffffffff2d float:NaN double:NaN;
        r12.CY(r2);
        goto L_0x0389;
    L_0x03ae:
        r2 = aMW;
        r2 = com.tencent.smtt.sdk.k.fM(r2);
        r2 = r2.wUG;
        r4 = "tbs_download_version";
        r5 = 0;
        r4 = r2.getInt(r4, r5);
        r0 = r17;
        if (r4 <= r0) goto L_0x03cf;
    L_0x03c2:
        r2 = wUM;
        r2.clearCache();
        com.tencent.smtt.sdk.p.ceA();
        r2 = aMW;
        com.tencent.smtt.sdk.p.gi(r2);
    L_0x03cf:
        r2 = 0;
        r5 = aMW;
        r5 = com.tencent.smtt.sdk.t.gu(r5);
        if (r5 != 0) goto L_0x0409;
    L_0x03d8:
        com.tencent.smtt.sdk.p.ceA();
        r5 = aMW;
        r5 = com.tencent.smtt.sdk.p.ga(r5);
        r0 = r17;
        if (r5 < r0) goto L_0x03e6;
    L_0x03e5:
        r2 = 1;
    L_0x03e6:
        r6 = "TbsDownload";
        r7 = new java.lang.StringBuilder;
        r8 = "tmpCoreVersion is ";
        r7.<init>(r8);
        r5 = r7.append(r5);
        r7 = " tbsDownloadVersion is";
        r5 = r5.append(r7);
        r0 = r17;
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r6, r5);
    L_0x0409:
        r0 = r30;
        r1 = r17;
        if (r0 >= r1) goto L_0x0417;
    L_0x040f:
        r5 = android.text.TextUtils.isEmpty(r15);
        if (r5 != 0) goto L_0x0417;
    L_0x0415:
        if (r2 == 0) goto L_0x04dc;
    L_0x0417:
        r2 = 1;
        if (r3 == r2) goto L_0x04dc;
    L_0x041a:
        r2 = r12.wUF;
        r3 = "tbs_needdownload";
        r5 = 0;
        r5 = java.lang.Boolean.valueOf(r5);
        r2.put(r3, r5);
        if (r31 == 0) goto L_0x04b3;
    L_0x0429:
        r2 = android.text.TextUtils.isEmpty(r15);
        if (r2 == 0) goto L_0x047e;
    L_0x042f:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -124; // 0xffffffffffffff84 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
    L_0x043d:
        r12.commit();
        r2 = "TbsDownload";
        r3 = new java.lang.StringBuilder;
        r5 = "version error or downloadUrl empty ,return ahead tbsLocalVersion=";
        r3.<init>(r5);
        r0 = r30;
        r3 = r3.append(r0);
        r5 = " tbsDownloadVersion=";
        r3 = r3.append(r5);
        r0 = r17;
        r3 = r3.append(r0);
        r5 = " tbsLastDownloadVersion=";
        r3 = r3.append(r5);
        r3 = r3.append(r4);
        r4 = " downloadUrl=";
        r3 = r3.append(r4);
        r3 = r3.append(r15);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
        r2 = 0;
        goto L_0x002c;
    L_0x047e:
        if (r17 > 0) goto L_0x048f;
    L_0x0480:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -125; // 0xffffffffffffff83 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
        goto L_0x043d;
    L_0x048f:
        r0 = r30;
        r1 = r17;
        if (r0 < r1) goto L_0x04a4;
    L_0x0495:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -127; // 0xffffffffffffff81 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
        goto L_0x043d;
    L_0x04a4:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r5 = -112; // 0xffffffffffffff90 float:NaN double:NaN;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r3, r5);
        goto L_0x043d;
    L_0x04b3:
        r2 = -212; // 0xffffffffffffff2c float:NaN double:NaN;
        r3 = android.text.TextUtils.isEmpty(r15);
        if (r3 == 0) goto L_0x04ce;
    L_0x04bb:
        r2 = -217; // 0xffffffffffffff27 float:NaN double:NaN;
    L_0x04bd:
        r3 = r12.wUF;
        r5 = "tbs_download_interrupt_code_reason";
        r6 = java.lang.Integer.valueOf(r2);
        r3.put(r5, r6);
        r12.CY(r2);
        goto L_0x043d;
    L_0x04ce:
        if (r17 > 0) goto L_0x04d3;
    L_0x04d0:
        r2 = -218; // 0xffffffffffffff26 float:NaN double:NaN;
        goto L_0x04bd;
    L_0x04d3:
        r0 = r30;
        r1 = r17;
        if (r0 < r1) goto L_0x04bd;
    L_0x04d9:
        r2 = -219; // 0xffffffffffffff25 float:NaN double:NaN;
        goto L_0x04bd;
    L_0x04dc:
        r2 = r12.wUG;
        r4 = "tbs_downloadurl";
        r5 = 0;
        r2 = r2.getString(r4, r5);
        r2 = r15.equals(r2);
        if (r2 != 0) goto L_0x050b;
    L_0x04ec:
        r2 = wUM;
        r2.clearCache();
        r2 = r12.wUF;
        r4 = "tbs_download_failed_retrytimes";
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        r2 = r12.wUF;
        r4 = "tbs_download_success_retrytimes";
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
    L_0x050b:
        r2 = r12.wUF;
        r4 = "tbs_download_version";
        r5 = java.lang.Integer.valueOf(r17);
        r2.put(r4, r5);
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "put KEY_TBS_DOWNLOAD_V is ";
        r4.<init>(r5);
        r0 = r17;
        r4 = r4.append(r0);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r4);
        if (r17 <= 0) goto L_0x0557;
    L_0x0531:
        r2 = 1;
        if (r3 != r2) goto L_0x0615;
    L_0x0534:
        r2 = r12.wUF;
        r4 = "tbs_download_version_type";
        r5 = 1;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
    L_0x0541:
        r2 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "put KEY_TBS_DOWNLOAD_V_TYPE is ";
        r4.<init>(r5);
        r3 = r4.append(r3);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r2, r3);
    L_0x0557:
        r2 = r12.wUF;
        r3 = "tbs_downloadurl";
        r2.put(r3, r15);
        r2 = r12.wUF;
        r3 = "tbs_downloadurl_list";
        r0 = r16;
        r2.put(r3, r0);
        r2 = r12.wUF;
        r3 = "tbs_responsecode";
        r4 = java.lang.Integer.valueOf(r14);
        r2.put(r3, r4);
        r2 = r12.wUF;
        r3 = "tbs_download_maxflow";
        r4 = java.lang.Integer.valueOf(r18);
        r2.put(r3, r4);
        r2 = r12.wUF;
        r3 = "tbs_download_min_free_space";
        r4 = java.lang.Integer.valueOf(r19);
        r2.put(r3, r4);
        r2 = r12.wUF;
        r3 = "tbs_download_success_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r20);
        r2.put(r3, r4);
        r2 = r12.wUF;
        r3 = "tbs_download_failed_max_retrytimes";
        r4 = java.lang.Integer.valueOf(r21);
        r2.put(r3, r4);
        r2 = r12.wUF;
        r3 = "tbs_single_timeout";
        r4 = java.lang.Long.valueOf(r22);
        r2.put(r3, r4);
        r2 = r12.wUF;
        r3 = "tbs_apkfilesize";
        r4 = java.lang.Long.valueOf(r24);
        r2.put(r3, r4);
        r12.commit();
        if (r9 == 0) goto L_0x05ca;
    L_0x05c2:
        r2 = r12.wUF;
        r3 = "tbs_apk_md5";
        r2.put(r3, r9);
    L_0x05ca:
        if (r32 != 0) goto L_0x0638;
    L_0x05cc:
        r2 = com.tencent.smtt.sdk.p.ceA();
        r3 = aMW;
        r0 = r17;
        r2 = r2.aj(r3, r0);
        if (r2 == 0) goto L_0x0638;
    L_0x05da:
        if (r31 == 0) goto L_0x0624;
    L_0x05dc:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -113; // 0xffffffffffffff8f float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
    L_0x05ea:
        r2 = r12.wUF;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
    L_0x05f7:
        r2 = "stop_pre_oat";
        r3 = 0;
        r2 = r13.optInt(r2, r3);
        r3 = 1;
        if (r2 != r3) goto L_0x060f;
    L_0x0602:
        r2 = r12.wUF;
        r3 = "tbs_stop_preoat";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
    L_0x060f:
        r12.commit();
        r2 = 1;
        goto L_0x002c;
    L_0x0615:
        r2 = r12.wUF;
        r4 = "tbs_download_version_type";
        r5 = 0;
        r5 = java.lang.Integer.valueOf(r5);
        r2.put(r4, r5);
        goto L_0x0541;
    L_0x0624:
        r2 = r12.wUF;
        r3 = "tbs_download_interrupt_code_reason";
        r4 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r4 = java.lang.Integer.valueOf(r4);
        r2.put(r3, r4);
        r2 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
        r12.CY(r2);
        goto L_0x05ea;
    L_0x0638:
        if (r32 != 0) goto L_0x06aa;
    L_0x063a:
        r3 = wUM;
        r2 = 1;
        if (r14 == r2) goto L_0x0642;
    L_0x063f:
        r2 = 2;
        if (r14 != r2) goto L_0x069b;
    L_0x0642:
        r2 = 1;
    L_0x0643:
        r2 = r3.mc(r2);
        if (r2 == 0) goto L_0x06aa;
    L_0x0649:
        r2 = r12.wUF;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = aMW;
        com.tencent.smtt.sdk.r.gr(r2);
        r2 = com.tencent.smtt.sdk.r.ceD();
        r3 = 100;
        r2.setErrorCode(r3);
        r3 = new java.lang.StringBuilder;
        r4 = "use local backup apk in needDownload";
        r3.<init>(r4);
        r4 = wUM;
        r4 = r4.wUr;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.Vw(r3);
        r3 = aMW;
        r3 = com.tencent.smtt.sdk.k.fM(r3);
        r3 = r3.wUG;
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = 1;
        if (r3 != r4) goto L_0x069d;
    L_0x068e:
        r3 = aMW;
        r3 = com.tencent.smtt.sdk.r.gr(r3);
        r4 = com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD_DECOUPLE;
        r3.a(r4, r2);
        goto L_0x05f7;
    L_0x069b:
        r2 = 0;
        goto L_0x0643;
    L_0x069d:
        r3 = aMW;
        r3 = com.tencent.smtt.sdk.r.gr(r3);
        r4 = com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD;
        r3.a(r4, r2);
        goto L_0x05f7;
    L_0x06aa:
        r2 = aMW;
        r2 = com.tencent.smtt.sdk.k.fM(r2);
        r2 = r2.wUG;
        r3 = "tbs_download_version_type";
        r4 = 0;
        r2 = r2.getInt(r3, r4);
        r3 = 1;
        if (r2 != r3) goto L_0x0724;
    L_0x06bd:
        r2 = wUM;
        r2 = r2.cdX();
        if (r2 == 0) goto L_0x0724;
    L_0x06c5:
        r2 = r12.wUF;
        r3 = "tbs_needdownload";
        r4 = 0;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        r2 = aMW;
        com.tencent.smtt.sdk.r.gr(r2);
        r2 = com.tencent.smtt.sdk.r.ceD();
        r3 = 100;
        r2.setErrorCode(r3);
        r3 = new java.lang.StringBuilder;
        r4 = "installDecoupleCoreFromBackup";
        r3.<init>(r4);
        r4 = wUM;
        r4 = r4.wUr;
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.Vw(r3);
        r3 = aMW;
        r3 = com.tencent.smtt.sdk.k.fM(r3);
        r3 = r3.wUG;
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = 1;
        if (r3 != r4) goto L_0x0717;
    L_0x070a:
        r3 = aMW;
        r3 = com.tencent.smtt.sdk.r.gr(r3);
        r4 = com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD_DECOUPLE;
        r3.a(r4, r2);
        goto L_0x05f7;
    L_0x0717:
        r3 = aMW;
        r3 = com.tencent.smtt.sdk.r.gr(r3);
        r4 = com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD;
        r3.a(r4, r2);
        goto L_0x05f7;
    L_0x0724:
        if (r31 != 0) goto L_0x072b;
    L_0x0726:
        r2 = -216; // 0xffffffffffffff28 float:NaN double:NaN;
        r12.CY(r2);
    L_0x072b:
        r2 = r12.wUF;
        r3 = "tbs_needdownload";
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r2.put(r3, r4);
        goto L_0x05f7;
    L_0x073a:
        r4 = move-exception;
        goto L_0x028d;
    L_0x073d:
        r4 = move-exception;
        goto L_0x027d;
    L_0x0740:
        r4 = move-exception;
        goto L_0x016c;
    L_0x0743:
        r7 = move-exception;
        r7 = r8;
        goto L_0x0211;
    L_0x0747:
        r6 = move-exception;
        r6 = r7;
        r7 = r8;
        goto L_0x0211;
    L_0x074c:
        r5 = move-exception;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        goto L_0x0211;
    L_0x0752:
        r2 = move-exception;
        r2 = r5;
        r5 = r6;
        r6 = r7;
        r7 = r8;
        goto L_0x0211;
    L_0x0759:
        r3 = move-exception;
        goto L_0x00b4;
    L_0x075c:
        r2 = r4;
        goto L_0x025c;
    L_0x075f:
        r2 = r10;
        goto L_0x0256;
    L_0x0762:
        r2 = r3;
        goto L_0x0158;
    L_0x0765:
        r5 = r2;
        goto L_0x0148;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.c(java.lang.String, int, boolean, boolean):boolean");
    }

    public static int cem() {
        p.ceA();
        return p.gb(aMW);
    }

    public static boolean cen() {
        if (t.gu(aMW) || k.fM(aMW).wUG.getInt("tbs_downloaddecouplecore", 0) == 1) {
            return false;
        }
        if (System.currentTimeMillis() - k.fM(aMW).wUG.getLong("last_download_decouple_core", 0) < 1000 * k.fM(aMW).ceh()) {
            return false;
        }
        int i = k.fM(aMW).wUG.getInt("tbs_decouplecoreversion", 0);
        if (i <= 0) {
            return false;
        }
        p.ceA();
        return (i == p.gb(aMW) || k.fM(aMW).wUG.getInt("tbs_download_version", 0) == i) ? false : true;
    }

    public static boolean ceo() {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
        if (t.gu(aMW)) {
            return false;
        }
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
        if (k.fM(aMW).wUG.getInt("tbs_downloaddecouplecore", 0) == 1) {
            return false;
        }
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
        long j = k.fM(aMW).wUG.getLong("last_download_decouple_core", 0);
        if (System.currentTimeMillis() - j < 1000 * k.fM(aMW).ceh()) {
            return false;
        }
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
        int i = k.fM(aMW).wUG.getInt("tbs_decouplecoreversion", 0);
        if (i > 0) {
            p.ceA();
            if (i != p.gb(aMW)) {
                if (k.fM(aMW).wUG.getInt("tbs_download_version", 0) != i || k.fM(aMW).wUG.getInt("tbs_download_version_type", 0) == 1) {
                    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
                    wUO = true;
                    wUI.removeMessages(108);
                    Message obtain = Message.obtain(wUI, 108, QbSdk.wTz);
                    obtain.arg1 = 0;
                    obtain.sendToTarget();
                    k.fM(aMW).wUF.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
                    return true;
                }
                TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + k.fM(aMW).wUG.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i + " KEY_TBS_DOWNLOAD_V_TYPE is " + k.fM(aMW).wUG.getInt("tbs_download_version_type", 0));
                return false;
            }
        }
        StringBuilder append = new StringBuilder("startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is ").append(i).append(" getTbsCoreShareDecoupleCoreVersion is ");
        p.ceA();
        TbsLog.i("TbsDownload", append.append(p.gb(aMW)).toString());
        return false;
    }

    public static boolean cep() {
        if (wUM != null) {
            h hVar = wUM;
            TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + hVar.wUq);
            if (hVar.wUq) {
                return true;
            }
        }
        return false;
    }

    private static synchronized void ceq() {
        synchronized (l.class) {
            if (wUN == null) {
                wUN = n.cez();
                try {
                    wUM = new h(aMW);
                    wUI = new Handler(wUN.getLooper()) {
                        public final void handleMessage(Message message) {
                            boolean z = true;
                            switch (message.what) {
                                case 100:
                                    boolean z2 = message.arg1 == 1;
                                    z = l.cet();
                                    if (message.obj != null && (message.obj instanceof a)) {
                                        TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + z);
                                        if (!z || z2) {
                                            ((a) message.obj).e(z, k.fM(l.aMW).wUG.getInt("tbs_download_version", 0));
                                        }
                                    }
                                    if (t.gu(l.aMW) && z) {
                                        l.fO(l.aMW);
                                        return;
                                    }
                                    return;
                                case 101:
                                case 108:
                                    FileLock fileLock = null;
                                    FileOutputStream b = f.b(l.aMW, false, "tbs_download_lock_file" + k.fM(l.aMW).wUG.getInt("tbs_download_version", 0) + ".txt");
                                    if (b != null) {
                                        fileLock = f.a(b);
                                        if (fileLock == null) {
                                            TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                                            k.fM(l.aMW).CY(-203);
                                            TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                                            return;
                                        }
                                    } else if (f.gT(l.aMW)) {
                                        k.fM(l.aMW).CY(-204);
                                        TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                                        return;
                                    }
                                    boolean z3 = message.arg1 == 1;
                                    k fM = k.fM(l.aMW);
                                    if (!l.e(false, z3, 108 == message.what)) {
                                        QbSdk.wTz.iu(MMGIFException.D_GIF_ERR_CLOSE_FAILED);
                                    } else if (z3 && p.ceA().aj(l.aMW, k.fM(l.aMW).wUG.getInt("tbs_download_version", 0))) {
                                        QbSdk.wTz.iu(122);
                                        fM.CY(-213);
                                    } else if (fM.wUG.getBoolean("tbs_needdownload", false)) {
                                        k.fM(l.aMW).CY(-215);
                                        h hVar = l.wUM;
                                        if (108 != message.what) {
                                            z = false;
                                        }
                                        hVar.N(z3, z);
                                    } else {
                                        QbSdk.wTz.iu(MMGIFException.D_GIF_ERR_CLOSE_FAILED);
                                    }
                                    TbsLog.i("TbsDownload", "------freeFileLock called :");
                                    f.a(fileLock, b);
                                    return;
                                case 102:
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                    int ceQ = t.gu(l.aMW) ? t.ceQ() : p.ceA().ge(l.aMW);
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + ceQ);
                                    h hVar2 = l.wUM;
                                    try {
                                        File file = new File(hVar2.wUb, "x5.tbs");
                                        int c = com.tencent.smtt.utils.a.c(hVar2.mContext, file);
                                        if (-1 == c || (ceQ > 0 && ceQ == c)) {
                                            file.delete();
                                        }
                                    } catch (Exception e) {
                                    }
                                    r.gr(l.aMW).ceE();
                                    return;
                                case 103:
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                    if (message.arg1 == 0) {
                                        p.ceA().u((Context) message.obj, true);
                                        return;
                                    } else {
                                        p.ceA().u((Context) message.obj, false);
                                        return;
                                    }
                                case 104:
                                    TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                    r.gr(l.aMW).ceG();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                } catch (Exception e) {
                    wUP = true;
                    TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
                }
            }
        }
    }

    private static boolean cer() {
        try {
            return k.fM(aMW).wUG.getString("last_thirdapp_sendrequest_coreversion", "").equals(ces().toString());
        } catch (Exception e) {
            return false;
        }
    }

    private static JSONArray ces() {
        int i = 0;
        if (!t.gu(aMW)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Object ceL = t.ceL();
        String packageName = aMW.getApplicationContext().getPackageName();
        if (packageName.equals(t.gw(aMW))) {
            Object obj = new String[5];
            System.arraycopy(ceL, 0, obj, 0, 4);
            obj[4] = packageName;
        }
        if (t.ceK() == null) {
            return jSONArray;
        }
        p.ceA();
        int Vt = p.Vt(t.ceK());
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.optInt(i2) == Vt) {
                i = 1;
                break;
            }
        }
        if (i == 0) {
            jSONArray.put(Vt);
        }
        return jSONArray;
    }

    public static boolean cet() {
        return e(true, false, false);
    }

    public static long ceu() {
        return wUS;
    }

    static String cev() {
        if (!TextUtils.isEmpty(wUH)) {
            return wUH;
        }
        String str;
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = VERSION.RELEASE;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(BuildConfig.VERSION_NAME);
        }
        stringBuffer.append("; ");
        str = locale.getLanguage();
        if (str != null) {
            stringBuffer.append(str.toLowerCase());
            str = locale.getCountry();
            if (str != null) {
                stringBuffer.append("-");
                stringBuffer.append(str.toLowerCase());
            }
        } else {
            stringBuffer.append("en");
        }
        if ("REL".equals(VERSION.CODENAME)) {
            str2 = Build.MODEL;
            try {
                str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception e2) {
                str = str2;
            }
            if (str.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str);
            }
        }
        str = Build.ID.replaceAll("[一-龥]", "");
        if (str.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(str);
        }
        str = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[]{stringBuffer});
        wUH = str;
        return str;
    }

    private static boolean cew() {
        k fM = k.fM(aMW);
        if (fM.wUG.getInt("tbs_download_success_retrytimes", 0) >= fM.cej()) {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            fM.CY(-115);
            return false;
        } else if (fM.wUG.getInt("tbs_download_failed_retrytimes", 0) >= fM.cek()) {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            fM.CY(-116);
            return false;
        } else if (f.gU(aMW)) {
            if (System.currentTimeMillis() - fM.wUG.getLong("tbs_downloadstarttime", 0) <= 86400000) {
                long j = fM.wUG.getLong("tbs_downloadflow", 0);
                TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + j);
                if (j >= fM.ceg()) {
                    TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    fM.CY(-120);
                    return false;
                }
            }
            return true;
        } else {
            TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            fM.CY(-117);
            return false;
        }
    }

    private static JSONArray cex() {
        JSONArray jSONArray = new JSONArray();
        String[] ceL = t.ceL();
        for (int i = 0; i < 4; i++) {
            File file = new File(f.a(aMW, ceL[i], 4, false), fP(aMW) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                long c = (long) com.tencent.smtt.utils.a.c(aMW, file);
                if (c > 0) {
                    boolean z;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (((long) jSONArray.optInt(i2)) == c) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(c);
                    }
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject d(boolean z, boolean z2, boolean z3) {
        Object simCountryIso;
        JSONObject jSONObject;
        int ge;
        int i;
        JSONArray cex;
        h hVar;
        File fI;
        boolean z4;
        boolean booleanValue;
        Object obj = null;
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        k fM = k.fM(aMW);
        String cev = cev();
        String gP = c.gP(aMW);
        String V = c.V(aMW);
        String gR = c.gR(aMW);
        String str = "";
        String str2 = "";
        String id = TimeZone.getDefault().getID();
        if (id != null) {
            Object obj2 = id;
        } else {
            String str3 = str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) aMW.getSystemService("phone");
            if (telephonyManager != null) {
                simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso == null) {
                    str = str2;
                }
                jSONObject = new JSONObject();
                jSONObject.put("TIMEZONEID", obj2);
                jSONObject.put("COUNTRYISO", simCountryIso);
                jSONObject.put("PROTOCOLVERSION", 1);
                if (t.gu(aMW)) {
                    ge = p.ceA().ge(aMW);
                    if (ge == 0 && p.ceA().gd(aMW)) {
                        ge = -1;
                    }
                    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + ge + " isDownloadForeground=" + z2);
                    if (z2) {
                        i = ge;
                        if (z) {
                            jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                        } else {
                            jSONObject.put("FUNCTION", 2);
                        }
                        if (t.gu(aMW)) {
                            cex = cex();
                            if (b.gN(aMW) != 3 && cex.length() != 0 && i == 0 && z) {
                                jSONObject.put("TBSBACKUPARR", cex);
                            }
                        } else {
                            cex = ces();
                            jSONObject.put("TBSVLARR", cex);
                            fM.wUF.put("last_thirdapp_sendrequest_coreversion", cex.toString());
                            fM.commit();
                            if (QbSdk.wTh) {
                                jSONObject.put("THIRDREQ", 1);
                            }
                        }
                        jSONObject.put("APPN", aMW.getPackageName());
                        jSONObject.put("APPVN", Vs(fM.wUG.getString("app_versionname", null)));
                        jSONObject.put("APPVC", fM.wUG.getInt("app_versioncode", 0));
                        jSONObject.put("APPMETA", Vs(fM.wUG.getString("app_metadata", null)));
                        jSONObject.put("TBSSDKV", 43501);
                        jSONObject.put("TBSV", i);
                        jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                        fM.wUF.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                        fM.commit();
                        if (i != 0) {
                            str3 = "TBSBACKUPV";
                            hVar = wUM;
                            fI = h.fI(hVar.mContext);
                            if (fI != null) {
                                ge = 0;
                            } else {
                                ge = com.tencent.smtt.utils.a.c(hVar.mContext, new File(fI, fP(hVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                            }
                            jSONObject.put(str3, ge);
                        }
                        jSONObject.put("CPU", wUJ);
                        jSONObject.put("UA", cev);
                        jSONObject.put("IMSI", Vs(gP));
                        jSONObject.put("IMEI", Vs(V));
                        jSONObject.put("ANDROID_ID", Vs(gR));
                        if (!t.gu(aMW)) {
                            if (i == 0) {
                                jSONObject.put("STATUS", QbSdk.ag(aMW, i) ? 0 : 1);
                            } else {
                                jSONObject.put("STATUS", 0);
                            }
                            p.ceA();
                            jSONObject.put("TBSDV", p.gb(aMW));
                        }
                        z4 = k.fM(aMW).wUG.getBoolean("request_full_package", false);
                        simCountryIso = QbSdk.c(aMW, "can_unlzma", null);
                        booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                        if (booleanValue && !z4) {
                            obj = 1;
                        }
                        if (obj != null) {
                            jSONObject.put("REQUEST_LZMA", 1);
                        }
                        if (fP(aMW)) {
                            jSONObject.put("OVERSEA", 1);
                        }
                        if (z2) {
                            jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                        }
                        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                        return jSONObject;
                    } else if (!p.ceA().gd(aMW)) {
                        ge = 0;
                    }
                } else {
                    ge = QbSdk.wTh ? t.ceQ() : k.fM(aMW).wUG.getInt("tbs_download_version", 0);
                }
                i = ge;
                if (z) {
                    if (i != 0) {
                    }
                    jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                } else {
                    jSONObject.put("FUNCTION", 2);
                }
                if (t.gu(aMW)) {
                    cex = cex();
                    jSONObject.put("TBSBACKUPARR", cex);
                } else {
                    cex = ces();
                    jSONObject.put("TBSVLARR", cex);
                    fM.wUF.put("last_thirdapp_sendrequest_coreversion", cex.toString());
                    fM.commit();
                    if (QbSdk.wTh) {
                        jSONObject.put("THIRDREQ", 1);
                    }
                }
                jSONObject.put("APPN", aMW.getPackageName());
                jSONObject.put("APPVN", Vs(fM.wUG.getString("app_versionname", null)));
                jSONObject.put("APPVC", fM.wUG.getInt("app_versioncode", 0));
                jSONObject.put("APPMETA", Vs(fM.wUG.getString("app_metadata", null)));
                jSONObject.put("TBSSDKV", 43501);
                jSONObject.put("TBSV", i);
                if (z3) {
                }
                jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                if (z3) {
                }
                fM.wUF.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                fM.commit();
                if (i != 0) {
                    str3 = "TBSBACKUPV";
                    hVar = wUM;
                    fI = h.fI(hVar.mContext);
                    if (fI != null) {
                        if (fP(hVar.mContext)) {
                        }
                        ge = com.tencent.smtt.utils.a.c(hVar.mContext, new File(fI, fP(hVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                    } else {
                        ge = 0;
                    }
                    jSONObject.put(str3, ge);
                }
                jSONObject.put("CPU", wUJ);
                jSONObject.put("UA", cev);
                jSONObject.put("IMSI", Vs(gP));
                jSONObject.put("IMEI", Vs(V));
                jSONObject.put("ANDROID_ID", Vs(gR));
                if (t.gu(aMW)) {
                    if (i == 0) {
                        jSONObject.put("STATUS", 0);
                    } else {
                        if (QbSdk.ag(aMW, i)) {
                        }
                        jSONObject.put("STATUS", QbSdk.ag(aMW, i) ? 0 : 1);
                    }
                    p.ceA();
                    jSONObject.put("TBSDV", p.gb(aMW));
                }
                z4 = k.fM(aMW).wUG.getBoolean("request_full_package", false);
                simCountryIso = QbSdk.c(aMW, "can_unlzma", null);
                if (simCountryIso == null) {
                }
                obj = 1;
                if (obj != null) {
                    jSONObject.put("REQUEST_LZMA", 1);
                }
                if (fP(aMW)) {
                    jSONObject.put("OVERSEA", 1);
                }
                if (z2) {
                    jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                }
                TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                return jSONObject;
            }
        } catch (Exception e) {
        }
        str = id;
        if (simCountryIso == null) {
            str = str2;
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("TIMEZONEID", obj2);
            jSONObject.put("COUNTRYISO", simCountryIso);
            jSONObject.put("PROTOCOLVERSION", 1);
            if (t.gu(aMW)) {
                ge = p.ceA().ge(aMW);
                ge = -1;
                TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + ge + " isDownloadForeground=" + z2);
                if (z2) {
                    i = ge;
                    if (z) {
                        jSONObject.put("FUNCTION", 2);
                    } else {
                        if (i != 0) {
                        }
                        jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
                    }
                    if (t.gu(aMW)) {
                        cex = ces();
                        jSONObject.put("TBSVLARR", cex);
                        fM.wUF.put("last_thirdapp_sendrequest_coreversion", cex.toString());
                        fM.commit();
                        if (QbSdk.wTh) {
                            jSONObject.put("THIRDREQ", 1);
                        }
                    } else {
                        cex = cex();
                        jSONObject.put("TBSBACKUPARR", cex);
                    }
                    jSONObject.put("APPN", aMW.getPackageName());
                    jSONObject.put("APPVN", Vs(fM.wUG.getString("app_versionname", null)));
                    jSONObject.put("APPVC", fM.wUG.getInt("app_versioncode", 0));
                    jSONObject.put("APPMETA", Vs(fM.wUG.getString("app_metadata", null)));
                    jSONObject.put("TBSSDKV", 43501);
                    jSONObject.put("TBSV", i);
                    if (z3) {
                    }
                    jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                    if (z3) {
                    }
                    fM.wUF.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
                    fM.commit();
                    if (i != 0) {
                        str3 = "TBSBACKUPV";
                        hVar = wUM;
                        fI = h.fI(hVar.mContext);
                        if (fI != null) {
                            ge = 0;
                        } else {
                            if (fP(hVar.mContext)) {
                            }
                            ge = com.tencent.smtt.utils.a.c(hVar.mContext, new File(fI, fP(hVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                        }
                        jSONObject.put(str3, ge);
                    }
                    jSONObject.put("CPU", wUJ);
                    jSONObject.put("UA", cev);
                    jSONObject.put("IMSI", Vs(gP));
                    jSONObject.put("IMEI", Vs(V));
                    jSONObject.put("ANDROID_ID", Vs(gR));
                    if (t.gu(aMW)) {
                        if (i == 0) {
                            if (QbSdk.ag(aMW, i)) {
                            }
                            jSONObject.put("STATUS", QbSdk.ag(aMW, i) ? 0 : 1);
                        } else {
                            jSONObject.put("STATUS", 0);
                        }
                        p.ceA();
                        jSONObject.put("TBSDV", p.gb(aMW));
                    }
                    z4 = k.fM(aMW).wUG.getBoolean("request_full_package", false);
                    simCountryIso = QbSdk.c(aMW, "can_unlzma", null);
                    if (simCountryIso == null) {
                    }
                    obj = 1;
                    if (obj != null) {
                        jSONObject.put("REQUEST_LZMA", 1);
                    }
                    if (fP(aMW)) {
                        jSONObject.put("OVERSEA", 1);
                    }
                    if (z2) {
                        jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                    }
                    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                    return jSONObject;
                } else if (p.ceA().gd(aMW)) {
                    ge = 0;
                }
            } else if (QbSdk.wTh) {
            }
            i = ge;
            if (z) {
                if (i != 0) {
                }
                jSONObject.put("FUNCTION", i != 0 ? 0 : 1);
            } else {
                jSONObject.put("FUNCTION", 2);
            }
            if (t.gu(aMW)) {
                cex = cex();
                jSONObject.put("TBSBACKUPARR", cex);
            } else {
                cex = ces();
                jSONObject.put("TBSVLARR", cex);
                fM.wUF.put("last_thirdapp_sendrequest_coreversion", cex.toString());
                fM.commit();
                if (QbSdk.wTh) {
                    jSONObject.put("THIRDREQ", 1);
                }
            }
            jSONObject.put("APPN", aMW.getPackageName());
            jSONObject.put("APPVN", Vs(fM.wUG.getString("app_versionname", null)));
            jSONObject.put("APPVC", fM.wUG.getInt("app_versioncode", 0));
            jSONObject.put("APPMETA", Vs(fM.wUG.getString("app_metadata", null)));
            jSONObject.put("TBSSDKV", 43501);
            jSONObject.put("TBSV", i);
            if (z3) {
            }
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            if (z3) {
            }
            fM.wUF.put("tbs_downloaddecouplecore", Integer.valueOf(z3 ? 1 : 0));
            fM.commit();
            if (i != 0) {
                str3 = "TBSBACKUPV";
                hVar = wUM;
                fI = h.fI(hVar.mContext);
                if (fI != null) {
                    if (fP(hVar.mContext)) {
                    }
                    ge = com.tencent.smtt.utils.a.c(hVar.mContext, new File(fI, fP(hVar.mContext) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
                } else {
                    ge = 0;
                }
                jSONObject.put(str3, ge);
            }
            jSONObject.put("CPU", wUJ);
            jSONObject.put("UA", cev);
            jSONObject.put("IMSI", Vs(gP));
            jSONObject.put("IMEI", Vs(V));
            jSONObject.put("ANDROID_ID", Vs(gR));
            if (t.gu(aMW)) {
                if (i == 0) {
                    jSONObject.put("STATUS", 0);
                } else {
                    if (QbSdk.ag(aMW, i)) {
                    }
                    jSONObject.put("STATUS", QbSdk.ag(aMW, i) ? 0 : 1);
                }
                p.ceA();
                jSONObject.put("TBSDV", p.gb(aMW));
            }
            z4 = k.fM(aMW).wUG.getBoolean("request_full_package", false);
            simCountryIso = QbSdk.c(aMW, "can_unlzma", null);
            if (simCountryIso == null) {
            }
            obj = 1;
            if (obj != null) {
                jSONObject.put("REQUEST_LZMA", 1);
            }
            if (fP(aMW)) {
                jSONObject.put("OVERSEA", 1);
            }
            if (z2) {
                jSONObject.put("DOWNLOAD_FOREGROUND", 1);
            }
        } catch (Exception e2) {
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        return jSONObject;
    }

    private static boolean d(Context context, boolean z, boolean z2) {
        boolean z3;
        r.b ceD;
        k fM = k.fM(context);
        String str = null;
        if (!z) {
            String string = fM.wUG.getString("app_versionname", null);
            int i = fM.wUG.getInt("app_versioncode", 0);
            String string2 = fM.wUG.getString("app_metadata", null);
            String appVersionName = c.getAppVersionName(aMW);
            int appVersionCode = c.getAppVersionCode(aMW);
            String bD = c.bD(aMW, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
            TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + appVersionName + " oldAppVersionName=" + string + " appVersionCode=" + appVersionCode + " oldAppVersionCode=" + i + " appMetadata=" + bD + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j = fM.wUG.getLong("last_check", 0);
            TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j + " timeNow=" + currentTimeMillis);
            if (z2) {
                boolean contains = fM.wUG.contains("last_check");
                TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + contains);
                if (contains && j == 0) {
                    j = currentTimeMillis;
                }
            }
            long ceh = fM.ceh();
            TbsLog.i("TbsDownload", "retryInterval = " + ceh + " s");
            if (currentTimeMillis - j <= ceh * 1000) {
                if (t.gu(aMW) && t.ceR() == 0 && !cer()) {
                    z3 = true;
                    f.J(aMW.getDir("tbs", 0));
                    p.wVj.set(Integer.valueOf(0));
                    r.gr(aMW);
                    ceD = r.ceD();
                    ceD.setErrorCode(-119);
                    ceD.Vw(str);
                    r.gr(aMW).a(com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD, ceD);
                    return z3;
                }
                String str2;
                if (appVersionName == null || appVersionCode == 0 || bD == null) {
                    if (t.gu(aMW)) {
                        str2 = "timeNow - timeLastCheck is " + (currentTimeMillis - j) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + t.ceR() + " sendRequestWithSameHostCoreVersion() is " + cer() + " appVersionName is " + appVersionName + " appVersionCode is " + appVersionCode + " appMetadata is " + bD + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                    }
                    str2 = null;
                } else {
                    if (!(appVersionName.equals(string) && appVersionCode == i && bD.equals(string2))) {
                        z3 = true;
                        if (!z3 && t.gu(aMW)) {
                            r.gr(aMW);
                            ceD = r.ceD();
                            ceD.setErrorCode(-119);
                            ceD.Vw(str);
                            r.gr(aMW).a(com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD, ceD);
                        }
                        return z3;
                    }
                    str2 = null;
                }
                str = str2;
                z3 = false;
                r.gr(aMW);
                ceD = r.ceD();
                ceD.setErrorCode(-119);
                ceD.Vw(str);
                r.gr(aMW).a(com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD, ceD);
                return z3;
            }
        }
        z3 = true;
        r.gr(aMW);
        ceD = r.ceD();
        ceD.setErrorCode(-119);
        ceD.Vw(str);
        r.gr(aMW).a(com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD, ceD);
        return z3;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(final boolean r12, boolean r13, boolean r14) {
        /*
        r1 = 1;
        r3 = -1;
        r11 = -104; // 0xffffffffffffff98 float:NaN double:NaN;
        r10 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
        r2 = 0;
        r0 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r5 = "[TbsDownloader.sendRequest]isQuery: ";
        r4.<init>(r5);
        r4 = r4.append(r12);
        r5 = " forDecoupleCore is ";
        r4 = r4.append(r5);
        r4 = r4.append(r14);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r4);
        r0 = com.tencent.smtt.sdk.p.ceA();
        r4 = aMW;
        r0 = r0.fT(r4);
        if (r0 == 0) goto L_0x003e;
    L_0x0034:
        r0 = "TbsDownload";
        r1 = "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
    L_0x003d:
        return r2;
    L_0x003e:
        r0 = aMW;
        r4 = com.tencent.smtt.sdk.k.fM(r0);
        r5 = new java.io.File;
        r0 = aMW;
        r6 = com.tencent.smtt.utils.f.al(r0, r1);
        r0 = aMW;
        r0 = fP(r0);
        if (r0 == 0) goto L_0x01ad;
    L_0x0054:
        r0 = "x5.oversea.tbs.org";
    L_0x0057:
        r5.<init>(r6, r0);
        r6 = new java.io.File;
        r0 = aMW;
        r7 = 2;
        r7 = com.tencent.smtt.utils.f.al(r0, r7);
        r0 = aMW;
        r0 = fP(r0);
        if (r0 == 0) goto L_0x01b2;
    L_0x006b:
        r0 = "x5.oversea.tbs.org";
    L_0x006e:
        r6.<init>(r7, r0);
        r7 = new java.io.File;
        r0 = aMW;
        r8 = 3;
        r8 = com.tencent.smtt.utils.f.al(r0, r8);
        r0 = aMW;
        r0 = fP(r0);
        if (r0 == 0) goto L_0x01b7;
    L_0x0082:
        r0 = "x5.oversea.tbs.org";
    L_0x0085:
        r7.<init>(r8, r0);
        r8 = new java.io.File;
        r0 = aMW;
        r9 = 4;
        r9 = com.tencent.smtt.utils.f.al(r0, r9);
        r0 = aMW;
        r0 = fP(r0);
        if (r0 == 0) goto L_0x01bc;
    L_0x0099:
        r0 = "x5.oversea.tbs.org";
    L_0x009c:
        r8.<init>(r9, r0);
        r0 = r8.exists();
        if (r0 != 0) goto L_0x00ae;
    L_0x00a5:
        r0 = r7.exists();
        if (r0 == 0) goto L_0x01c1;
    L_0x00ab:
        r7.renameTo(r8);
    L_0x00ae:
        r0 = wUJ;
        if (r0 != 0) goto L_0x00c5;
    L_0x00b2:
        r0 = com.tencent.smtt.utils.c.cfg();
        wUJ = r0;
        r0 = r4.wUF;
        r5 = "device_cpuabi";
        r6 = wUJ;
        r0.put(r5, r6);
        r4.commit();
    L_0x00c5:
        r0 = wUJ;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0203;
    L_0x00cd:
        r0 = 0;
        r5 = "i686|mips|x86_64";
        r5 = java.util.regex.Pattern.compile(r5);	 Catch:{ Exception -> 0x0200 }
        r6 = wUJ;	 Catch:{ Exception -> 0x0200 }
        r0 = r5.matcher(r6);	 Catch:{ Exception -> 0x0200 }
    L_0x00db:
        if (r0 == 0) goto L_0x0203;
    L_0x00dd:
        r0 = r0.find();
        if (r0 == 0) goto L_0x0203;
    L_0x00e3:
        r0 = aMW;
        r0 = com.tencent.smtt.sdk.t.gu(r0);
        if (r0 == 0) goto L_0x01df;
    L_0x00eb:
        r0 = aMW;
        com.tencent.smtt.sdk.r.gr(r0);
        r0 = com.tencent.smtt.sdk.r.ceD();
        if (r12 == 0) goto L_0x01d7;
    L_0x00f6:
        r4.CY(r11);
        r0.setErrorCode(r11);
    L_0x00fc:
        r5 = new java.lang.StringBuilder;
        r6 = "mycpu is ";
        r5.<init>(r6);
        r6 = wUJ;
        r5 = r5.append(r6);
        r5 = r5.toString();
        r0.Vw(r5);
        r5 = aMW;
        r5 = com.tencent.smtt.sdk.r.gr(r5);
        r6 = com.tencent.smtt.sdk.r.a.TYPE_DOWNLOAD;
        r5.a(r6, r0);
    L_0x011c:
        r0 = r1;
    L_0x011d:
        r5 = d(r12, r13, r14);
        r1 = "TBSV";
        r1 = r5.getInt(r1);	 Catch:{ Exception -> 0x01eb }
    L_0x0128:
        if (r0 != 0) goto L_0x012c;
    L_0x012a:
        if (r1 == r3) goto L_0x0172;
    L_0x012c:
        r6 = java.lang.System.currentTimeMillis();
        r8 = r4.wUF;
        r9 = "last_check";
        r6 = java.lang.Long.valueOf(r6);
        r8.put(r9, r6);
        r6 = r4.wUF;
        r7 = "app_versionname";
        r8 = aMW;
        r8 = com.tencent.smtt.utils.c.getAppVersionName(r8);
        r6.put(r7, r8);
        r6 = r4.wUF;
        r7 = "app_versioncode";
        r8 = aMW;
        r8 = com.tencent.smtt.utils.c.getAppVersionCode(r8);
        r8 = java.lang.Integer.valueOf(r8);
        r6.put(r7, r8);
        r6 = r4.wUF;
        r7 = "app_metadata";
        r8 = aMW;
        r9 = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
        r8 = com.tencent.smtt.utils.c.bD(r8, r9);
        r6.put(r7, r8);
        r4.commit();
        if (r0 != 0) goto L_0x003d;
    L_0x0172:
        if (r1 == r3) goto L_0x003d;
    L_0x0174:
        r0 = aMW;	 Catch:{ Throwable -> 0x01ef }
        r0 = com.tencent.smtt.utils.q.gZ(r0);	 Catch:{ Throwable -> 0x01ef }
        r0 = r0.wYy;	 Catch:{ Throwable -> 0x01ef }
        r3 = "TbsDownload";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01ef }
        r7 = "[TbsDownloader.sendRequest] postUrl=";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x01ef }
        r6 = r6.append(r0);	 Catch:{ Throwable -> 0x01ef }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x01ef }
        com.tencent.smtt.utils.TbsLog.i(r3, r6);	 Catch:{ Throwable -> 0x01ef }
        r3 = r5.toString();	 Catch:{ Throwable -> 0x01ef }
        r5 = "utf-8";
        r3 = r3.getBytes(r5);	 Catch:{ Throwable -> 0x01ef }
        r5 = new com.tencent.smtt.sdk.l$2;	 Catch:{ Throwable -> 0x01ef }
        r5.<init>(r12, r4);	 Catch:{ Throwable -> 0x01ef }
        r6 = 0;
        r0 = com.tencent.smtt.utils.g.a(r0, r3, r5, r6);	 Catch:{ Throwable -> 0x01ef }
        r2 = c(r0, r1, r12, r13);	 Catch:{ Throwable -> 0x01ef }
        goto L_0x003d;
    L_0x01ad:
        r0 = "x5.tbs.org";
        goto L_0x0057;
    L_0x01b2:
        r0 = "x5.tbs.org";
        goto L_0x006e;
    L_0x01b7:
        r0 = "x5.tbs.org";
        goto L_0x0085;
    L_0x01bc:
        r0 = "x5.tbs.org";
        goto L_0x009c;
    L_0x01c1:
        r0 = r6.exists();
        if (r0 == 0) goto L_0x01cc;
    L_0x01c7:
        r6.renameTo(r8);
        goto L_0x00ae;
    L_0x01cc:
        r0 = r5.exists();
        if (r0 == 0) goto L_0x00ae;
    L_0x01d2:
        r5.renameTo(r8);
        goto L_0x00ae;
    L_0x01d7:
        r4.CY(r10);
        r0.setErrorCode(r10);
        goto L_0x00fc;
    L_0x01df:
        if (r12 == 0) goto L_0x01e6;
    L_0x01e1:
        r4.CY(r11);
        goto L_0x011c;
    L_0x01e6:
        r4.CY(r10);
        goto L_0x011c;
    L_0x01eb:
        r1 = move-exception;
        r1 = r3;
        goto L_0x0128;
    L_0x01ef:
        r0 = move-exception;
        if (r12 == 0) goto L_0x01f9;
    L_0x01f2:
        r0 = -106; // 0xffffffffffffff96 float:NaN double:NaN;
        r4.CY(r0);
        goto L_0x003d;
    L_0x01f9:
        r0 = -206; // 0xffffffffffffff32 float:NaN double:NaN;
        r4.CY(r0);
        goto L_0x003d;
    L_0x0200:
        r5 = move-exception;
        goto L_0x00db;
    L_0x0203:
        r0 = r2;
        goto L_0x011d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.l.e(boolean, boolean, boolean):boolean");
    }

    public static boolean fN(Context context) {
        boolean z = true;
        aMW = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (!a(aMW, false, null)) {
            return false;
        }
        int ge = p.ceA().ge(context);
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + ge);
        if (ge > 0) {
            return false;
        }
        if (d(aMW, false, true)) {
            return true;
        }
        k fM = k.fM(aMW);
        boolean contains = fM.wUG.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + contains);
        boolean z2 = !contains ? true : fM.wUG.getBoolean("tbs_needdownload", false);
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + z2);
        if (!(z2 && cew())) {
            z = false;
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + z);
        return z;
    }

    public static void fO(Context context) {
        r(context, false);
    }

    public static synchronized boolean fP(Context context) {
        boolean z;
        synchronized (l.class) {
            if (!wUR) {
                wUR = true;
                k fM = k.fM(context);
                if (fM.wUG.contains("is_oversea")) {
                    wUQ = fM.wUG.getBoolean("is_oversea", false);
                    TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + wUQ);
                }
                TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + wUQ);
            }
            z = wUQ;
        }
        return z;
    }

    @TargetApi(11)
    static void fQ(Context context) {
        k fM = k.fM(context);
        try {
            fM.wUF.clear();
            Editor edit = fM.wUG.edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
        try {
            edit = r.gr(context).ceI().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e2) {
        }
        h.fK(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
    }

    public static boolean q(Context context, boolean z) {
        return a(context, z, false, null);
    }

    public static synchronized void r(Context context, boolean z) {
        int i = 1;
        synchronized (l.class) {
            TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + aMW);
            if (!p.wVm) {
                wUO = true;
                Context applicationContext = context.getApplicationContext();
                aMW = applicationContext;
                k.fM(applicationContext).CY(-200);
                if (VERSION.SDK_INT < 8) {
                    QbSdk.wTz.iu(MMGIFException.D_GIF_ERR_CLOSE_FAILED);
                    k.fM(aMW).CY(-201);
                } else {
                    ceq();
                    if (wUP) {
                        QbSdk.wTz.iu(121);
                        k.fM(aMW).CY(-202);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        wUI.removeMessages(101);
                        wUI.removeMessages(100);
                        Message obtain = Message.obtain(wUI, 101, QbSdk.wTz);
                        if (!z) {
                            i = 0;
                        }
                        obtain.arg1 = i;
                        obtain.sendToTarget();
                    }
                }
            }
        }
    }

    public static void stopDownload() {
        if (!wUP) {
            TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
            if (wUM != null) {
                wUM.stopDownload();
            }
            if (wUI != null) {
                wUI.removeMessages(100);
                wUI.removeMessages(101);
                wUI.removeMessages(108);
            }
        }
    }
}
