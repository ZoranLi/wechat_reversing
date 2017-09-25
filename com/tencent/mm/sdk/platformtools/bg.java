package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.d;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.lang.Character.UnicodeBlock;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
import junit.framework.Assert;

public final class bg {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final long[] ijZ = new long[]{300, 200, 300, 200};
    private static final char[] jnN = new char[]{'<', '>', '\"', '\'', '&', '\r', '\n', ' ', '\t'};
    private static final String[] jnO = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};
    private static final long[] uwl = new long[]{300, 50, 300, 50};

    public static class a {
        private Context context;

        public a(Context context) {
            this.context = context;
        }

        public final String toString() {
            Context context = this.context;
            if (context == null) {
                return null;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String packageName = context.getPackageName();
            if (activityManager == null || bg.mA(packageName)) {
                return null;
            }
            List<RunningTaskInfo> runningTasks = activityManager.getRunningTasks(100);
            StringBuffer stringBuffer = new StringBuffer();
            for (RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.baseActivity.getClassName().startsWith(packageName) || runningTaskInfo.topActivity.getClassName().startsWith(packageName)) {
                    stringBuffer.append(String.format("{id:%d num:%d/%d top:%s base:%s}", new Object[]{Integer.valueOf(runningTaskInfo.id), Integer.valueOf(runningTaskInfo.numRunning), Integer.valueOf(runningTaskInfo.numActivities), runningTaskInfo.topActivity.getShortClassName(), runningTaskInfo.baseActivity.getShortClassName()}));
                }
            }
            return stringBuffer.toString();
        }
    }

    public static String my(String str) {
        if (str != null) {
            return str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        return str;
    }

    public static String PG(String str) {
        if (str != null) {
            return str.replace("../", "");
        }
        return str;
    }

    public static String c(List<String> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                stringBuilder.append(((String) list.get(i)).trim());
            } else {
                stringBuilder.append(((String) list.get(i)).trim() + str);
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> f(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        List<String> arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static String[] bU(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = (String) list.get(i);
        }
        return strArr;
    }

    public static int dM(int i, int i2) {
        Assert.assertTrue(i > i2);
        return new Random(System.currentTimeMillis()).nextInt((i - i2) + 1) + i2;
    }

    public static byte[] bJQ() {
        try {
            FileInputStream fileInputStream = new FileInputStream("/dev/urandom");
            byte[] bArr = new byte[16];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read == 16) {
                return bArr;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        return g.o((UUID.randomUUID().toString() + System.currentTimeMillis()).getBytes());
    }

    public static boolean bJR() {
        int i = new GregorianCalendar().get(11);
        return ((long) i) >= 6 && ((long) i) < 18;
    }

    public static String bJS() {
        int i;
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i = 1;
        } else {
            i = 0;
        }
        return String.format("%.2f", new Object[]{Double.valueOf((((double) rawOffset) / 3600.0d) + ((double) i))});
    }

    public static String eu(long j) {
        return new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(j));
    }

    public static String ev(long j) {
        return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000 * j));
    }

    public static boolean f(char c) {
        UnicodeBlock of = UnicodeBlock.of(c);
        if (of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static boolean PH(String str) {
        if (mA(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(str).find();
    }

    public static boolean j(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean PI(String str) {
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean PJ(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        try {
            long longValue = Long.valueOf(str.trim()).longValue();
            if (longValue <= 0 || longValue > 4294967295L) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            return false;
        }
    }

    public static boolean PK(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    }

    public static byte[] O(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        w.i("MicroMsg.Util", "recycle bitmap:%s", bitmap);
        bitmap.recycle();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        return toByteArray;
    }

    public static boolean PL(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.length() < 6 || trim.length() > 20 || !j(trim.charAt(0))) {
            return false;
        }
        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (!j(charAt) && !k(charAt) && charAt != '-' && charAt != '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean PM(String str) {
        if (str == null || str.length() < 8) {
            return false;
        }
        try {
            Long.parseLong(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static String ay(long j) {
        if ((j >> 30) > 0) {
            return b(j, 10.0d);
        }
        if ((j >> 20) > 0) {
            return a(j, 10.0d);
        }
        if ((j >> 9) <= 0) {
            return j + " B";
        }
        return (((double) Math.round((((double) j) * 10.0d) / 1024.0d)) / 10.0d) + " KB";
    }

    public static String a(long j, double d) {
        return (((double) Math.round((((double) j) * d) / 1048576.0d)) / d) + " MB";
    }

    public static String ew(long j) {
        return a(j, 10.0d);
    }

    public static String b(long j, double d) {
        return (((double) Math.round((((double) j) * d) / 1.073741824E9d)) / d) + " GB";
    }

    public static String bk(byte[] bArr) {
        return A(bArr, 0);
    }

    public static String A(byte[] bArr, int i) {
        int i2 = 0;
        if (bArr == null) {
            return "(null)";
        }
        if (i <= 0) {
            i = bArr.length;
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[((i * 3) + (i / 16))];
        int i3 = 0;
        while (i3 < i + 0) {
            byte b = bArr[i3];
            int i4 = i2 + 1;
            cArr2[i2] = ' ';
            i2 = i4 + 1;
            cArr2[i4] = cArr[(b >>> 4) & 15];
            i4 = i2 + 1;
            cArr2[i2] = cArr[b & 15];
            if (i3 % 16 != 0 || i3 <= 0) {
                i2 = i4;
            } else {
                i2 = i4 + 1;
                cArr2[i4] = '\n';
            }
            i3++;
        }
        return new String(cArr2);
    }

    public static String bl(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return "(null)";
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 3)];
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = ' ';
            int i4 = i3 + 1;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            i2 = i4 + 1;
            cArr2[i4] = cArr[b & 15];
            i++;
        }
        return new String(cArr2);
    }

    public static Intent PN(String str) {
        boolean z = (str == null || str.equals("")) ? false : true;
        Assert.assertTrue(z);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        return intent;
    }

    public static void i(String str, Context context) {
        context.startActivity(PN(str));
    }

    public static void k(Context context, boolean z) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            w.w("MicroMsg.Util", "shake:vibrator is null!");
        } else if (z) {
            vibrator.vibrate(ijZ, -1);
        } else {
            vibrator.cancel();
        }
    }

    public static void el(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(uwl, -1);
        }
    }

    public static long Ny() {
        return System.currentTimeMillis() / 1000;
    }

    public static String hb(int i) {
        return String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
    }

    public static long Nz() {
        return System.currentTimeMillis();
    }

    public static long az(long j) {
        return (System.currentTimeMillis() / 1000) - j;
    }

    public static long aA(long j) {
        return System.currentTimeMillis() - j;
    }

    public static long aB(long j) {
        return SystemClock.elapsedRealtime() - j;
    }

    public static long NA() {
        return SystemClock.elapsedRealtime();
    }

    public static long bJT() {
        return (System.currentTimeMillis() / 86400000) * 86400000;
    }

    public static long bJU() {
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        return instance.getTimeInMillis();
    }

    public static boolean w(long j, long j2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        if (instance.get(1) == instance2.get(1) && instance.get(5) == instance2.get(5) && instance.get(2) == instance2.get(2)) {
            return true;
        }
        return false;
    }

    public static String em(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            return deviceId == null ? null : deviceId.trim();
        } catch (SecurityException e) {
            w.e("MicroMsg.Util", "getDeviceId failed, security exception");
            return null;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
            return null;
        }
    }

    public static long bJV() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            if (VERSION.SDK_INT < 18) {
                return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e) {
            w.e("MicroMsg.Util", "getDataAvailableSize exception:%s", e.getMessage());
            return 0;
        }
    }

    public static long en(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.availMem / AppSupportContentFlag.MMAPP_SUPPORT_XLS) / AppSupportContentFlag.MMAPP_SUPPORT_XLS;
    }

    public static String eo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getLine1Number();
            }
            w.e("MicroMsg.Util", "getLine1Number failed, null tm");
            return null;
        } catch (Throwable e) {
            w.e("MicroMsg.Util", "getLine1Number failed:%s ", ah.g(e));
            return null;
        }
    }

    public static String bJW() {
        TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        String simCountryIso = telephonyManager.getSimCountryIso();
        if (mA(simCountryIso)) {
            return "";
        }
        return simCountryIso.toUpperCase().trim();
    }

    public static boolean bp(Context context) {
        String name = context.getClass().getName();
        String bk = bk(context);
        w.d("MicroMsg.Util", "top activity=" + bk + ", context=" + name);
        return bk.equalsIgnoreCase(name);
    }

    public static boolean bb(Context context, String str) {
        try {
            if (str.equals("com.tencent.mm") || str.startsWith("com.tencent.mm:") || VERSION.SDK_INT < 21) {
                w.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", str);
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    return false;
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                        w.w("MicroMsg.Util", "process " + str + " is running");
                        return true;
                    }
                }
            } else {
                w.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", str);
                for (String str2 : bKd()) {
                    w.d("MicroMsg.Util", "isProcessRunning, process command line = %s", str2);
                    if (str2 != null && str2.contains(str)) {
                        String[] split = str2.split("\\s+");
                        for (Object equals : split) {
                            if (str.equals(equals)) {
                                w.i("MicroMsg.Util", "process %s is running", str);
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            w.w("MicroMsg.Util", "process " + str + " is not running");
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        return false;
    }

    public static String q(Context context, int i) {
        return d.q(context, i);
    }

    public static String bk(Context context) {
        try {
            return ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            return "(null)";
        }
    }

    public static boolean j(Context context, Intent intent) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static List<ResolveInfo> x(Context context, Intent intent) {
        if (context == null || intent == null) {
            return null;
        }
        return context.getPackageManager().queryIntentActivities(intent, 65536);
    }

    public static String bw(Object obj) {
        if (obj != null) {
            return obj.toString();
        }
        return "null";
    }

    public static int f(Integer num) {
        return num == null ? 0 : num.intValue();
    }

    public static long c(Long l) {
        return l == null ? 0 : l.longValue();
    }

    public static String mz(String str) {
        return str == null ? "" : str;
    }

    public static boolean e(Boolean bool) {
        return bool == null ? true : bool.booleanValue();
    }

    public static boolean f(Boolean bool) {
        return bool == null ? false : bool.booleanValue();
    }

    public static int a(Integer num, int i) {
        return num == null ? i : num.intValue();
    }

    public static byte[] i(byte[] bArr, byte[] bArr2) {
        return bArr == null ? bArr2 : bArr;
    }

    public static long a(Long l, long j) {
        return l == null ? j : l.longValue();
    }

    public static boolean b(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static String ap(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int n(Object obj, int i) {
        if (obj == null) {
            return i;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return ((Long) obj).intValue();
        }
        return i;
    }

    public static long bx(Object obj) {
        if (obj != null && (obj instanceof Long)) {
            return ((Long) obj).longValue();
        }
        return 0;
    }

    public static boolean bV(List list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

    public static boolean mA(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean J(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() <= 0) {
            return true;
        }
        return false;
    }

    public static boolean bm(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return true;
        }
        return false;
    }

    public static boolean D(String... strArr) {
        for (String mA : strArr) {
            if (mA(mA)) {
                return true;
            }
        }
        return false;
    }

    public static int PO(String str) {
        if (str == null) {
            return -1;
        }
        return str.length();
    }

    public static int bn(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    public static int PP(String str) {
        int i = 0;
        if (mA(str)) {
            return i;
        }
        try {
            return (int) (new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime() / 1000);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[i]);
            return i;
        }
    }

    public static int getInt(String str, int i) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            }
        }
        return i;
    }

    public static long getLong(String str, long j) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    j = Long.decode(str).longValue();
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            }
        }
        return j;
    }

    public static float getFloat(String str, float f) {
        if (str != null) {
            try {
                f = Float.parseFloat(str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            }
        }
        return f;
    }

    public static double getDouble(String str, double d) {
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            }
        }
        return d;
    }

    public static int PQ(String str) {
        int i = 0;
        if (str == null) {
            return i;
        }
        try {
            return (int) (Long.decode(str).longValue() & 4294967295L);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[i]);
            return i;
        }
    }

    public static boolean cX(View view) {
        boolean hideSoftInputFromWindow;
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                return false;
            }
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            w.v("MicroMsg.Util", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
            return hideSoftInputFromWindow;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            w.e("MicroMsg.Util", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
    }

    public static String PR(String str) {
        if (str == null) {
            str = "";
        }
        if (str.length() <= 16) {
            return g.n(str.getBytes());
        }
        return g.n(str.substring(0, 16).getBytes());
    }

    public static String PS(String str) {
        return g.n(str.getBytes());
    }

    public static String convertStreamToString(InputStream inputStream) {
        return d.convertStreamToString(inputStream);
    }

    public static String bo(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
            }
        }
        return stringBuilder.toString();
    }

    public static byte[] PT(String str) {
        if (str == null || str.length() <= 0) {
            return new byte[0];
        }
        try {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) & 255);
            }
            return bArr;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            return new byte[0];
        }
    }

    public static int[] PU(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        List arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2 != null && str2.length() > 0) {
                try {
                    arrayList.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    w.e("MicroMsg.Util", "invalid port num, ignore");
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    public static int eA(String str, String str2) {
        Throwable e;
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!(name.contains("../") || name.contains("..\\"))) {
                            if (nextEntry.isDirectory()) {
                                new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                            } else {
                                File file = new File(str2 + File.separator + name);
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                    fileOutputStream.flush();
                                }
                                fileOutputStream.close();
                            }
                        }
                    } else {
                        try {
                            zipInputStream.close();
                            return 0;
                        } catch (IOException e2) {
                            w.e("MicroMsg.Util", "close zip stream failed.");
                            return 0;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e = e4;
                }
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            zipInputStream = null;
            try {
                w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e6) {
                        w.e("MicroMsg.Util", "close zip stream failed.");
                    }
                }
                return -1;
            } catch (Throwable th) {
                e = th;
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e7) {
                        w.e("MicroMsg.Util", "close zip stream failed.");
                    }
                }
                throw e;
            }
        } catch (IOException e8) {
            e = e8;
            zipInputStream = null;
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e9) {
                    w.e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            return -2;
        } catch (Throwable th2) {
            e = th2;
            zipInputStream = null;
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            throw e;
        }
    }

    public static final String PV(String str) {
        if (mA(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            w.w("MicroMsg.Util", "get host error");
            return str;
        }
    }

    public static boolean F(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (j(context, intent)) {
            context.startActivity(intent);
            return true;
        }
        w.e("MicroMsg.Util", "jump to url failed, " + str);
        return false;
    }

    public static String PW(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = jnN.length - 1; length2 >= 0; length2--) {
                if (jnN[length2] == charAt) {
                    stringBuffer.append(jnO[length2]);
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String PX(String str) {
        if (str == null || str.length() == 0 || VERSION.SDK_INT >= 8) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        while (i < length) {
            char charAt = str.charAt(i);
            int i4 = i2 + 1;
            cArr[i2] = charAt;
            if (charAt == '&' && i3 == -1) {
                i3 = i4;
            } else if (!(i3 == -1 || Character.isLetter(charAt) || Character.isDigit(charAt) || charAt == '#')) {
                if (charAt == ';') {
                    i2 = a(cArr, i3, (i4 - i3) - 1);
                    if (i2 > 65535) {
                        i4 = i2 - 65536;
                        cArr[i3 - 1] = (char) ((i4 >> 10) + 55296);
                        cArr[i3] = (char) ((i4 & 1023) + 56320);
                        i3++;
                    } else if (i2 != 0) {
                        cArr[i3 - 1] = (char) i2;
                    } else {
                        i3 = i4;
                    }
                    i4 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                }
            }
            i++;
            i2 = i4;
        }
        return new String(cArr, 0, i2);
    }

    private static int a(char[] cArr, int i, int i2) {
        int i3 = 0;
        if (i2 > 0) {
            if (cArr[i] != '#') {
                String str = new String(cArr, i, i2);
            } else if (i2 <= 1 || !(cArr[i + 1] == 'x' || cArr[i + 1] == 'X')) {
                try {
                    i3 = Integer.parseInt(new String(cArr, i + 1, i2 - 1), 10);
                } catch (NumberFormatException e) {
                }
            } else {
                try {
                    i3 = Integer.parseInt(new String(cArr, i + 2, i2 - 2), 16);
                } catch (NumberFormatException e2) {
                }
            }
        }
        return i3;
    }

    public static String a(LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<key>");
        for (Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                key = "unknow";
            }
            if (value == null) {
                value = "unknow";
            }
            stringBuilder.append("<" + key + ">");
            stringBuilder.append(value);
            stringBuilder.append("</" + key + ">");
        }
        stringBuilder.append("</key>");
        return stringBuilder.toString();
    }

    public static int PY(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            if (str != null) {
                w.e("MicroMsg.Util", "parserInt error " + str);
            }
        }
        return i;
    }

    public static long PZ(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            if (str != null) {
                w.e("MicroMsg.Util", "parseLong error " + str);
            }
        }
        return j;
    }

    public static double Qa(String str) {
        double d = 0.0d;
        try {
            d = Double.parseDouble(str);
        } catch (Exception e) {
            if (str != null) {
                w.e("MicroMsg.Util", "parseDouble error " + str);
            }
        }
        return d;
    }

    public static float Qb(String str) {
        float f = 0.0f;
        try {
            f = Float.parseFloat(str);
        } catch (Exception e) {
            if (str != null) {
                w.e("MicroMsg.Util", "parseFloat error " + str);
            }
        }
        return f;
    }

    public static boolean deleteFile(String str) {
        if (mA(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            return false;
        }
        return file.delete();
    }

    public static void d(String str, String str2, long j) {
        if (!mA(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile() && file2.getName().startsWith(str2) && (System.currentTimeMillis() - file2.lastModified()) - j >= 0) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    public static byte[] readFromFile(String str) {
        Throwable e;
        Throwable e2;
        if (mA(str)) {
            w.w("MicroMsg.Util", "readFromFile error, path is null or empty");
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            FileInputStream fileInputStream;
            try {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[length];
                    if (fileInputStream.read(bArr) != length) {
                        w.w("MicroMsg.Util", "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", str, Integer.valueOf(length), Integer.valueOf(fileInputStream.read(bArr)));
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
                            return null;
                        }
                    }
                    w.d("MicroMsg.Util", "readFromFile ok!");
                    try {
                        fileInputStream.close();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                    }
                    return bArr;
                } catch (Exception e4) {
                    e3 = e4;
                    try {
                        w.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
                        if (fileInputStream != null) {
                            return null;
                        }
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.Util", e32, "", new Object[0]);
                            return null;
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e322) {
                                w.printErrStackTrace("MicroMsg.Util", e322, "", new Object[0]);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e5) {
                e322 = e5;
                fileInputStream = null;
                w.printErrStackTrace("MicroMsg.Util", e322, "", new Object[0]);
                if (fileInputStream != null) {
                    return null;
                }
                fileInputStream.close();
                return null;
            } catch (Throwable e3222) {
                fileInputStream = null;
                e22 = e3222;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e22;
            }
        }
        w.w("MicroMsg.Util", "readFromFile error, file is not exit, path = %s", str);
        return null;
    }

    public static boolean r(String str, byte[] bArr) {
        Throwable e;
        if (mA(str) || bm(bArr)) {
            w.w("MicroMsg.Util", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                }
                w.d("MicroMsg.Util", "writeToFile ok!");
                return true;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    w.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                    w.w("MicroMsg.Util", "write to file error");
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            w.printErrStackTrace("MicroMsg.Util", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            w.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
            w.w("MicroMsg.Util", "write to file error");
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }

    public static String ep(Context context) {
        if (context == null) {
            return null;
        }
        return j(context.getPackageName(), context);
    }

    public static String j(String str, Context context) {
        String str2 = null;
        if (context == null || mA(str)) {
            return str2;
        }
        try {
            return g.n(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            return str2;
        }
    }

    public static boolean bJX() {
        String e = v.e(ab.getContext().getSharedPreferences(ab.bIX(), 0));
        String bIN = v.bIN();
        if (!e.equals("language_default")) {
            bIN = e;
        }
        if (!bIN.equals("zh_CN")) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            bIN = telephonyManager.getNetworkCountryIso();
            if (!(mA(bIN) || bIN.contains("cn") || bIN.contains("CN"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean Hp() {
        if (!Locale.getDefault().equals(Locale.CHINA)) {
            return true;
        }
        if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) ab.getContext().getSystemService("phone");
        if (telephonyManager != null) {
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (!(mA(networkCountryIso) || networkCountryIso.contains("cn") || networkCountryIso.contains("CN"))) {
                return true;
            }
        }
        return false;
    }

    public static OnTouchListener bJY() {
        return new OnTouchListener() {
            public final boolean onTouch(final View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        view.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 uwm;

                            public final void run() {
                                view.setPressed(false);
                            }
                        });
                        break;
                }
                return false;
            }
        };
    }

    public static byte[] Qc(String str) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.Util", "httpGet, url is null");
            return null;
        } else if (URLUtil.isDataUrl(str)) {
            return Qf(str);
        } else {
            if (URLUtil.isHttpsUrl(str)) {
                return Qe(str);
            }
            return Qd(str);
        }
    }

    private static byte[] Qd(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() != m.CTRL_INDEX) {
                w.e("MicroMsg.Util", "http get response code = %d", Integer.valueOf(httpURLConnection.getResponseCode()));
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
            for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Exception e) {
            w.e("MicroMsg.Util", "http download failed : %s", e.getMessage());
            return null;
        }
    }

    private static byte[] Qe(String str) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setRequestMethod("GET");
            if (httpsURLConnection.getResponseCode() != m.CTRL_INDEX) {
                w.e("MicroMsg.Util", "https get response code = %d", Integer.valueOf(httpsURLConnection.getResponseCode()));
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
            for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
            return toByteArray;
        } catch (Exception e) {
            w.e("MicroMsg.Util", "getHttpsData failed : %s", e.getMessage());
            return null;
        }
    }

    private static byte[] Qf(String str) {
        try {
            int indexOf = str.indexOf("base64");
            if (indexOf > 0) {
                str = str.substring(indexOf + 7);
            }
            return Base64.decode(str, 0);
        } catch (Exception e) {
            w.e("MicroMsg.Util", "decode base64 url failed : %s", e.getMessage());
            return null;
        }
    }

    public static CharSequence K(CharSequence charSequence) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String zc(String str) {
        return str.replaceAll("[\\.\\-]", "").trim();
    }

    public static String Qg(String str) {
        int i = 0;
        if (mA(str) || str.startsWith("+")) {
            return "";
        }
        if (str.length() <= 5) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str.subSequence(0, 3));
        while (i < str.length() - 5) {
            char charAt = str.charAt(i + 3);
            if (charAt < '0' || charAt > '9') {
                stringBuffer.append(charAt);
            } else {
                stringBuffer.append('*');
            }
            i++;
        }
        stringBuffer.append(str.charAt(str.length() - 2));
        stringBuffer.append(str.charAt(str.length() - 1));
        return stringBuffer.toString();
    }

    public static Boolean Qh(String str) {
        boolean z = Pattern.compile("^[+][0-9]{10,13}$").matcher(str).matches() || Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
        return Boolean.valueOf(z);
    }

    public static String formatNumber(String str) {
        if (mA(str)) {
            return "";
        }
        String replaceAll = str.replaceAll(",", "");
        if (replaceAll.length() <= 3) {
            return replaceAll;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = replaceAll.length() - 1;
        while (length >= 0) {
            stringBuffer.append(replaceAll.charAt(length));
            if ((replaceAll.length() - length) % 3 == 0 && length != 0) {
                stringBuffer.append(",");
            }
            length--;
        }
        return stringBuffer.reverse().toString();
    }

    public static ah bJZ() {
        return new ah();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String l(java.io.InputStream r6) {
        /*
        r5 = 0;
        if (r6 != 0) goto L_0x0005;
    L_0x0003:
        r0 = 0;
    L_0x0004:
        return r0;
    L_0x0005:
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
    L_0x000e:
        r2 = r6.read(r1);	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        r3 = -1;
        if (r2 == r3) goto L_0x0028;
    L_0x0015:
        r3 = new java.lang.String;	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        r4 = 0;
        r3.<init>(r1, r4, r2);	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        r0.append(r3);	 Catch:{ Exception -> 0x001f, all -> 0x0046 }
        goto L_0x000e;
    L_0x001f:
        r1 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x0039 }
    L_0x0023:
        r0 = r0.toString();
        goto L_0x0004;
    L_0x0028:
        r6.close();	 Catch:{ IOException -> 0x002c }
        goto L_0x0023;
    L_0x002c:
        r1 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x0023;
    L_0x0039:
        r1 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x0023;
    L_0x0046:
        r0 = move-exception;
        r6.close();	 Catch:{ IOException -> 0x004b }
    L_0x004a:
        throw r0;
    L_0x004b:
        r1 = move-exception;
        r2 = "MicroMsg.Util";
        r3 = "";
        r4 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.bg.l(java.io.InputStream):java.lang.String");
    }

    public static String Qi(String str) {
        if (str == null || str.length() <= 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("@");
        if (lastIndexOf != -1) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String Qj(String str) {
        if (mA(str)) {
            return "";
        }
        int length = str.length();
        if (length < 4) {
            return "*~" + length;
        }
        if (length < 8) {
            return str.substring(0, 1) + "*" + str.substring(length - 2, length - 1) + "~" + length;
        }
        return str.substring(0, 2) + "*" + str.substring(length - 3, length - 1) + "~" + length;
    }

    public static String g(Throwable th) {
        return ah.g(th);
    }

    public static int bKa() {
        return new Random().nextInt();
    }

    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("_data");
                        if (columnIndex == -1) {
                            w.e("MicroMsg.Util", "getDataColumn : columnIdx is -1, column with columnName = _data does not exist");
                            query.close();
                            if (query != null) {
                                query.close();
                            }
                            return null;
                        }
                        String string = query.getString(columnIndex);
                        if (query == null) {
                            return string;
                        }
                        query.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @TargetApi(19)
    public static String f(Context context, Uri uri) {
        Uri uri2 = null;
        if (context == null || uri == null) {
            w.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
            return null;
        }
        String scheme = uri.getScheme();
        if (mA(scheme)) {
            w.e("MicroMsg.Util", "input uri error. %s", uri);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            w.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
            return uri.getPath();
        } else {
            if (scheme.equalsIgnoreCase("content")) {
                w.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    return uri.getLastPathSegment();
                }
                try {
                    context.grantUriPermission(uri.getAuthority(), uri, 1);
                    scheme = a(context, uri, null, null);
                } catch (SecurityException e) {
                    w.e("MicroMsg.Util", "getFilePath : exception = " + e);
                    scheme = null;
                }
                if (!mA(scheme)) {
                    return scheme;
                }
                if (VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
                    String[] split;
                    if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                        split = DocumentsContract.getDocumentId(uri).split(":");
                        if ("primary".equalsIgnoreCase(split[0])) {
                            return Environment.getExternalStorageDirectory() + "/" + split[1];
                        }
                        return null;
                    } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                        return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                    } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                        Object obj = DocumentsContract.getDocumentId(uri).split(":")[0];
                        if (SlookAirButtonRecentMediaAdapter.IMAGE_TYPE.equals(obj)) {
                            uri2 = Media.EXTERNAL_CONTENT_URI;
                        } else if (SlookAirButtonRecentMediaAdapter.VIDEO_TYPE.equals(obj)) {
                            uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                        } else if (SlookAirButtonRecentMediaAdapter.AUDIO_TYPE.equals(obj)) {
                            uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return a(context, uri2, "_id=?", new String[]{split[1]});
                    }
                }
            }
            w.e("MicroMsg.Util", "unknown scheme");
            return null;
        }
    }

    public static boolean l(Uri uri) {
        if (uri == null) {
            return false;
        }
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            return Qk(uri.getPath());
        }
        return true;
    }

    public static boolean Qk(String str) {
        if (mA(str)) {
            return false;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            if (canonicalPath.contains("/com.tencent.mm/cache/")) {
                return true;
            }
            if (canonicalPath.contains("/com.tencent.mm/")) {
                return false;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean Ql(String str) {
        if (mA(str)) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            return Qm(str.substring(lastIndexOf + 1));
        }
        return false;
    }

    public static boolean Qm(String str) {
        if (mA(str)) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equals("webp") && VERSION.SDK_INT >= 14) {
            return true;
        }
        if (toLowerCase.equals("jpg") || toLowerCase.equals("gif") || toLowerCase.equals("bmp") || toLowerCase.equals("jpeg") || toLowerCase.equals("png")) {
            return true;
        }
        return false;
    }

    public static a eq(Context context) {
        return new a(context);
    }

    public static ComponentName er(Context context) {
        try {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                return null;
            }
            return ((RunningTaskInfo) runningTasks.get(0)).topActivity;
        } catch (Exception e) {
            w.e("MicroMsg.Util", "get Top Activity Exception:%s", e.getMessage());
            return null;
        }
    }

    public static String es(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String className;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    return "";
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        return null;
                    }
                    className = componentName.getClassName();
                    if (className.contains(".")) {
                        return className.substring(className.lastIndexOf(".") + 1);
                    }
                    return className;
                }
                return "";
            }
            className = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (className.contains(".")) {
                return className.substring(className.lastIndexOf(".") + 1);
            }
            return className;
        } catch (Throwable e) {
            w.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", e.getMessage(), ah.g(e));
        }
    }

    public static RunningTaskInfo aa(Context context, int i) {
        for (RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1000)) {
            if (runningTaskInfo.id == i) {
                return runningTaskInfo;
            }
        }
        return null;
    }

    public static String U(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static boolean r(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Util", e, "qualityClose", new Object[0]);
            }
        }
    }

    public static Locale et(Context context) {
        String d = v.d(context.getSharedPreferences(ab.bIX(), 0));
        if (d.equals("language_default")) {
            v.a(context, Locale.ENGLISH);
            return Locale.getDefault();
        }
        Locale Po = v.Po(d);
        v.a(context, Po);
        return Po;
    }

    public static String bKb() {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            stringBuffer.append(str.charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }

    public static void j(View view, int i, int i2, int i3, int i4) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i2;
        rect.bottom += i4;
        rect.left -= i;
        rect.right += i3;
        TouchDelegate touchDelegate = new TouchDelegate(rect, view);
        if (View.class.isInstance(view.getParent())) {
            ((View) view.getParent()).setTouchDelegate(touchDelegate);
        }
    }

    public static String Qn(String str) {
        return mA(str) ? str : str.replaceAll("‮", "");
    }

    public static int aE(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getInt();
    }

    public static final String Qo(String str) {
        if (mA(str)) {
            return null;
        }
        return Uri.parse(str).getHost();
    }

    public static boolean bKc() {
        String property = System.getProperty("java.vm.version");
        if (mA(property) || !property.startsWith("2")) {
            return false;
        }
        return true;
    }

    private static List<String> bKd() {
        LineNumberReader lineNumberReader;
        Exception e;
        Throwable th;
        List<String> arrayList = new ArrayList();
        try {
            Process exec = Runtime.getRuntime().exec("ps");
            lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.length() > 0) {
                        arrayList.add(readLine);
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
            exec.waitFor();
            exec.destroy();
            try {
                lineNumberReader.close();
            } catch (Exception e3) {
                w.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
            }
        } catch (Exception e4) {
            e3 = e4;
            lineNumberReader = null;
            try {
                w.e("MicroMsg.Util", "getRunningAppProcessesByPs fail, ex = %s", e3.getMessage());
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Exception e32) {
                        w.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e32.getMessage());
                    }
                }
                w.i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (Exception e5) {
                        w.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e5.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            lineNumberReader = null;
            if (lineNumberReader != null) {
                lineNumberReader.close();
            }
            throw th;
        }
        w.i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    public static boolean eB(String str, String str2) {
        if (mA(str) && mA(str2)) {
            return true;
        }
        if (mA(str) && !mA(str2)) {
            return false;
        }
        if (mA(str) || !mA(str2)) {
            return str.equals(str2);
        }
        return false;
    }

    public static boolean dN(int i, int i2) {
        return i == i2;
    }

    public static boolean x(long j, long j2) {
        return j == j2;
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean bKe() {
        return f.fuV == 1;
    }

    public static int bKf() {
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) ab.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            return 0;
        }
        return processMemoryInfo[0].getTotalPss() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public static String i(String str, Object... objArr) {
        try {
            str = String.format(str, objArr);
        } catch (Exception e) {
            w.i("MicroMsg.Util", "error safeFormatString %s", e.getMessage());
        }
        return str;
    }

    public static Intent y(Context context, Intent intent) {
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        w.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        ComponentName componentName = new ComponentName(r1, r0);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public static int aF(String str, int i) {
        try {
            i = Color.parseColor(str);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Util", e, "colorString:%s", str);
        }
        return i;
    }

    public static int ex(long j) {
        return Math.round(((float) j) / 1000.0f);
    }

    public static String n(double d) {
        return String.format("%.2f", new Object[]{Double.valueOf(d)});
    }
}
