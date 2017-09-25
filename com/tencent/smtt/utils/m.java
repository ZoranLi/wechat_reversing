package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.smtt.sdk.a.c;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class m {
    private static m wYg = null;
    private Handler mHandler;

    private m() {
        this.mHandler = null;
        this.mHandler = new Handler(this, Looper.getMainLooper()) {
            final /* synthetic */ m wYh;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void handleMessage(android.os.Message r5) {
                /*
                r4 = this;
                r0 = r5.what;	 Catch:{ Exception -> 0x001d }
                switch(r0) {
                    case 0: goto L_0x0009;
                    case 1: goto L_0x001f;
                    case 2: goto L_0x0073;
                    default: goto L_0x0005;
                };
            L_0x0005:
                super.handleMessage(r5);
                return;
            L_0x0009:
                r0 = r5.obj;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r1 = 0;
                r1 = r0[r1];	 Catch:{ Exception -> 0x001d }
                r1 = (android.content.Context) r1;	 Catch:{ Exception -> 0x001d }
                r2 = 1;
                r0 = r0[r2];	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x001d }
                com.tencent.smtt.utils.m.bG(r1, r0);	 Catch:{ Exception -> 0x001d }
                goto L_0x0005;
            L_0x001d:
                r0 = move-exception;
                goto L_0x0005;
            L_0x001f:
                r0 = r5.obj;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r1 = r4.wYh;	 Catch:{ Exception -> 0x001d }
                r2 = 0;
                r0 = r0[r2];	 Catch:{ Exception -> 0x001d }
                r0 = (android.content.Context) r0;	 Catch:{ Exception -> 0x001d }
                r1 = r1.cfv();	 Catch:{ Throwable -> 0x0071 }
                r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0071 }
                if (r2 != 0) goto L_0x0005;
            L_0x0036:
                r2 = new java.io.File;	 Catch:{ Throwable -> 0x0071 }
                r2.<init>(r1);	 Catch:{ Throwable -> 0x0071 }
                r1 = r2.exists();	 Catch:{ Throwable -> 0x0071 }
                if (r1 == 0) goto L_0x0005;
            L_0x0041:
                r1 = new android.content.Intent;	 Catch:{ Throwable -> 0x0071 }
                r3 = "android.intent.action.VIEW";
                r1.<init>(r3);	 Catch:{ Throwable -> 0x0071 }
                r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
                r1.addFlags(r3);	 Catch:{ Throwable -> 0x0071 }
                r2 = android.net.Uri.fromFile(r2);	 Catch:{ Throwable -> 0x0071 }
                r3 = "application/vnd.android.package-archive";
                r1.setDataAndType(r2, r3);	 Catch:{ Throwable -> 0x0071 }
                r0.startActivity(r1);	 Catch:{ Throwable -> 0x0071 }
                com.tencent.smtt.utils.n.gV(r0);	 Catch:{ Throwable -> 0x0071 }
                r0 = r0.getApplicationInfo();	 Catch:{ Throwable -> 0x0071 }
                r0 = r0.processName;	 Catch:{ Throwable -> 0x0071 }
                r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0071 }
                if (r1 != 0) goto L_0x0005;
            L_0x006a:
                com.tencent.smtt.utils.n.VA(r0);	 Catch:{ Throwable -> 0x0071 }
                com.tencent.smtt.utils.n.VB(r0);	 Catch:{ Throwable -> 0x0071 }
                goto L_0x0005;
            L_0x0071:
                r0 = move-exception;
                goto L_0x0005;
            L_0x0073:
                r0 = r5.obj;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.Object[]) r0;	 Catch:{ Exception -> 0x001d }
                r1 = 0;
                r1 = r0[r1];	 Catch:{ Exception -> 0x001d }
                r1 = (android.content.Context) r1;	 Catch:{ Exception -> 0x001d }
                r2 = 1;
                r0 = r0[r2];	 Catch:{ Exception -> 0x001d }
                r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x001d }
                com.tencent.smtt.utils.m.bH(r1, r0);	 Catch:{ Exception -> 0x001d }
                goto L_0x0005;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.m.1.handleMessage(android.os.Message):void");
            }
        };
    }

    private static Map<String, String> Vz(String str) {
        if (str.length() <= 0) {
            return null;
        }
        try {
            Map<String, String> hashMap = new HashMap();
            try {
                for (String str2 : str.split("\n")) {
                    if (str2 != null && str2.length() > 0) {
                        String[] split = str2.trim().split("=", 2);
                        if (split != null && split.length >= 2) {
                            String str3 = split[0];
                            Object obj = split[1];
                            if (str3 != null && str3.length() > 0) {
                                hashMap.put(str3, obj);
                            }
                        }
                    }
                }
                return hashMap;
            } catch (Throwable th) {
                return hashMap;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    public static void bG(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            c.a(context, str, null, null);
        }
    }

    public static void bH(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public static m cft() {
        if (wYg == null) {
            wYg = new m();
        }
        return wYg;
    }

    private static Map<String, String> cfu() {
        String str;
        Throwable th;
        FileInputStream fileInputStream = null;
        String str2 = "";
        FileInputStream fileInputStream2;
        try {
            FileInputStream fileInputStream3;
            String str3 = "/data/data/com.tencent.mobileqq/app_tbs/share/QQBrowserDownloadInfo.ini";
            String str4 = "/data/data/com.qzone/app_tbs/share/QQBrowserDownloadInfo.ini";
            File file = new File("/data/data/com.tencent.mm/app_tbs/share/QQBrowserDownloadInfo.ini");
            if (!file.exists()) {
                file = new File(str3);
            }
            File file2 = !file.exists() ? new File(str4) : file;
            if (file2.exists()) {
                fileInputStream2 = new FileInputStream(file2);
                try {
                    byte[] o = f.o(fileInputStream2);
                    if (o != null) {
                        str = new String(o, ProtocolPackage.ServerEncoding);
                        fileInputStream3 = fileInputStream2;
                    } else {
                        str = str2;
                        fileInputStream3 = fileInputStream2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                    throw th;
                }
            }
            String str5 = str2;
            fileInputStream3 = null;
            str = str5;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e2) {
                }
            }
        } catch (Throwable th3) {
            fileInputStream2 = null;
            th = th3;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return Vz(str);
    }

    private static PackageInfo m(String str, Context context) {
        PackageInfo packageInfo = null;
        if (!(context == null || TextUtils.isEmpty(str))) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, FileUtils.S_IWUSR);
            } catch (Throwable th) {
            }
        }
        return packageInfo;
    }

    public final boolean bF(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("tbsqbdownload://")) {
                    String substring;
                    String str2;
                    String[] split = str.substring(16).split(",");
                    if (split.length > 1) {
                        String[] split2 = split[0].split("=");
                        substring = (split2.length <= 1 || !SlookSmartClipMetaTag.TAG_TYPE_URL.equalsIgnoreCase(split2[0])) ? null : split[0].substring(4);
                        String[] split3 = split[1].split("=");
                        if (split3.length <= 1 || !"downloadurl".equalsIgnoreCase(split3[0])) {
                            str2 = substring;
                            substring = null;
                        } else {
                            str2 = substring;
                            substring = split[1].substring(12);
                        }
                    } else {
                        substring = null;
                        str2 = null;
                    }
                    if (str2 == null || substring == null) {
                        return false;
                    }
                    boolean z = m("com.tencent.mtt", context) != null ? true : !TextUtils.isEmpty(cfv());
                    Object obj;
                    Message message;
                    if (z) {
                        obj = new Object[]{context, str2};
                        message = new Message();
                        message.what = 0;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    } else if (z) {
                        obj = new Object[]{context};
                        message = new Message();
                        message.what = 1;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    } else {
                        obj = new Object[]{context, substring};
                        message = new Message();
                        message.what = 2;
                        message.obj = obj;
                        this.mHandler.sendMessage(message);
                        return true;
                    }
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    final String cfv() {
        Map cfu = cfu();
        if (cfu != null && cfu.size() > 0) {
            String str = (String) cfu.get("FileDownloadPath");
            String str2 = (String) cfu.get("FileDownloadVerifyInfo");
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            if (TextUtils.equals(i.aV(file.lastModified()), str2)) {
                return str;
            }
        }
        return "";
    }
}
