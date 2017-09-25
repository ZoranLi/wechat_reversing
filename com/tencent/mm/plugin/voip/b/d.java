package com.tencent.mm.plugin.voip.b;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.Toast;
import com.tencent.mm.e.a.au;
import com.tencent.mm.e.a.ax;
import com.tencent.mm.e.a.be;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.i.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class d {
    public static Context rof = null;
    private static final String rog;
    private static final Uri roh = Uri.parse("content://com.lbe.security.miui.permmgr/active");

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
        stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
        stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
        stringBuilder.append("] BOARD:[" + Build.BOARD);
        stringBuilder.append("] DEVICE:[" + Build.DEVICE);
        stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
        stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        stringBuilder.append("] HOST:[" + Build.HOST);
        stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        stringBuilder.append("] MODEL:[" + Build.MODEL);
        stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
        stringBuilder.append("] TAGS:[" + Build.TAGS);
        stringBuilder.append("] TYPE:[" + Build.TYPE);
        stringBuilder.append("] USER:[" + Build.USER + "]");
        rog = stringBuilder.toString();
    }

    public static boolean brg() {
        return true;
    }

    public static int brh() {
        return VERSION.SDK_INT;
    }

    private static boolean bri() {
        FileInputStream fileInputStream;
        boolean z = false;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("ro.miui.ui.version.name", null);
                if (property != null && property.equals("V6")) {
                    z = true;
                }
            } catch (IOException e) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                w.d("VoipUtil", "isMIUIv6 " + z);
                return z;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            w.d("VoipUtil", "isMIUIv6 " + z);
            return z;
        }
        w.d("VoipUtil", "isMIUIv6 " + z);
        return z;
    }

    public static boolean cU(Context context) {
        boolean z = false;
        if (bri()) {
            z = cX(context);
        }
        w.d("VoipUtil", "isLbePermissionEnable ret:" + z);
        return z;
    }

    public static boolean cV(Context context) {
        boolean z = false;
        if (bri()) {
            z = cW(context);
        }
        w.d("VoipUtil", "setLbePermissionEnable ret:" + z);
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean cW(android.content.Context r13) {
        /*
        r11 = 2;
        r9 = 0;
        r10 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r7 = 1;
        r8 = 0;
        r6 = -1;
        r0 = r13.getContentResolver();	 Catch:{ Throwable -> 0x00ad, all -> 0x00d2 }
        r1 = roh;	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        r3 = 0;
        r4 = "userAccept";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        r3 = "pkgName='com.tencent.mm'";
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00f7, all -> 0x00d2 }
        if (r2 == 0) goto L_0x0107;
    L_0x0021:
        r1 = r2.getCount();	 Catch:{ Throwable -> 0x00fa }
        if (r1 <= 0) goto L_0x0107;
    L_0x0027:
        r1 = r2.moveToLast();	 Catch:{ Throwable -> 0x00fa }
        if (r1 == 0) goto L_0x0107;
    L_0x002d:
        r1 = 0;
        r6 = r2.getInt(r1);	 Catch:{ Throwable -> 0x00fa }
        r1 = r6;
    L_0x0033:
        if (r2 == 0) goto L_0x0102;
    L_0x0035:
        r2.close();
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x003b:
        r2 = "VoipUtil";
        r3 = "setLbePermissionEnable query ua: ";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r0);
        r4[r8] = r5;
        r5 = " flag: ";
        r4[r7] = r5;
        r5 = java.lang.Integer.valueOf(r10);
        r4[r11] = r5;
        com.tencent.mm.sdk.platformtools.w.d(r2, r3, r4);
        r2 = -1;
        r3 = -1;
        if (r0 == r3) goto L_0x00fc;
    L_0x005c:
        if (r1 == 0) goto L_0x00fc;
    L_0x005e:
        r3 = r0 | r10;
        r0 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00da }
        r0.<init>();	 Catch:{ Throwable -> 0x00da }
        r4 = "userAccept";
        r5 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x00da }
        r0.put(r4, r5);	 Catch:{ Throwable -> 0x00da }
        r4 = roh;	 Catch:{ Throwable -> 0x00da }
        r5 = "pkgName='com.tencent.mm'";
        r6 = 0;
        r0 = r1.update(r4, r0, r5, r6);	 Catch:{ Throwable -> 0x00da }
        r1 = "VoipUtil";
        r2 = "serLbePermissionEnable update ua: ";
        r4 = 5;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00f1 }
        r5 = 0;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x00f1 }
        r4[r5] = r3;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 1;
        r5 = " flag: ";
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 2;
        r5 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x00f1 }
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 3;
        r5 = " ret: ";
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        r3 = 4;
        r5 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x00f1 }
        r4[r3] = r5;	 Catch:{ Throwable -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.w.d(r1, r2, r4);	 Catch:{ Throwable -> 0x00f1 }
    L_0x00a8:
        r2 = r0;
    L_0x00a9:
        if (r2 <= 0) goto L_0x00ef;
    L_0x00ab:
        r0 = r7;
    L_0x00ac:
        return r0;
    L_0x00ad:
        r0 = move-exception;
        r1 = r0;
        r2 = r9;
        r0 = r9;
    L_0x00b1:
        r3 = "VoipUtil";
        r4 = "isLbePermissionEnable query ";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00f5 }
        r9 = 0;
        r5[r9] = r1;	 Catch:{ all -> 0x00f5 }
        r1 = 1;
        r9 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x00f5 }
        r5[r1] = r9;	 Catch:{ all -> 0x00f5 }
        com.tencent.mm.sdk.platformtools.w.w(r3, r4, r5);	 Catch:{ all -> 0x00f5 }
        if (r2 == 0) goto L_0x00fe;
    L_0x00cb:
        r2.close();
        r1 = r0;
        r0 = r6;
        goto L_0x003b;
    L_0x00d2:
        r0 = move-exception;
        r2 = r9;
    L_0x00d4:
        if (r2 == 0) goto L_0x00d9;
    L_0x00d6:
        r2.close();
    L_0x00d9:
        throw r0;
    L_0x00da:
        r0 = move-exception;
    L_0x00db:
        r1 = "VoipUtil";
        r3 = "isLbePermissionEnable update ";
        r4 = new java.lang.Object[r11];
        r4[r8] = r0;
        r0 = java.lang.Integer.valueOf(r10);
        r4[r7] = r0;
        com.tencent.mm.sdk.platformtools.w.w(r1, r3, r4);
        goto L_0x00a9;
    L_0x00ef:
        r0 = r8;
        goto L_0x00ac;
    L_0x00f1:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x00db;
    L_0x00f5:
        r0 = move-exception;
        goto L_0x00d4;
    L_0x00f7:
        r1 = move-exception;
        r2 = r9;
        goto L_0x00b1;
    L_0x00fa:
        r1 = move-exception;
        goto L_0x00b1;
    L_0x00fc:
        r0 = r2;
        goto L_0x00a8;
    L_0x00fe:
        r1 = r0;
        r0 = r6;
        goto L_0x003b;
    L_0x0102:
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x003b;
    L_0x0107:
        r1 = r6;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.b.d.cW(android.content.Context):boolean");
    }

    private static boolean cX(Context context) {
        Throwable th;
        Cursor query;
        try {
            query = context.getContentResolver().query(roh, new String[]{"suggestAccept", "userAccept", "userPrompt", "userReject"}, "pkgName='com.tencent.mm'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToLast()) {
                        boolean z = ((query.getInt(0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT && (query.getInt(2) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0 && (query.getInt(3) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) || (query.getInt(1) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        w.w("gray", "isLbePermissionEnable", new Object[]{th, Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)});
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return false;
    }

    public static void G(Context context, int i) {
        Toast.makeText(context, i, 0).show();
    }

    public static int mo(String str) {
        int i = 0;
        try {
            i = bg.getInt(g.sV().getValue(str), 0);
        } catch (Exception e) {
            w.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: " + str);
        }
        return i;
    }

    public static boolean brj() {
        b axVar = new ax();
        a.urY.m(axVar);
        return axVar.fEs.fEt;
    }

    public static boolean brk() {
        b rrVar = new rr();
        rrVar.fYI.fJK = 2;
        a.urY.m(rrVar);
        return rrVar.fYJ.fYK;
    }

    public static boolean brl() {
        b beVar = new be();
        a.urY.m(beVar);
        return beVar.fEJ.fEt;
    }

    public static boolean brm() {
        b auVar = new au();
        a.urY.m(auVar);
        return auVar.fEm.fEn;
    }

    public static Notification a(Builder builder) {
        if (com.tencent.mm.compatible.util.d.ep(16)) {
            return builder.getNotification();
        }
        return builder.build();
    }
}
