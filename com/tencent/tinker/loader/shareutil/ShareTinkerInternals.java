package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ShareTinkerInternals {
    private static String processName = null;
    private static final boolean xiU = VX(System.getProperty("java.vm.version"));
    private static final boolean xiV = cgZ();
    private static Boolean xiW = null;
    private static String xiX = null;
    private static String xiY = null;

    public static boolean cgV() {
        return xiU || VERSION.SDK_INT >= 21;
    }

    public static boolean cgW() {
        return xiV && VERSION.SDK_INT < 24;
    }

    public static boolean cgX() {
        return VERSION.SDK_INT > 25;
    }

    public static String cgY() {
        if (xiY != null) {
            return xiY;
        }
        xiY = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        new StringBuilder("getCurrentInstructionSet:").append(xiY);
        return xiY;
    }

    public static boolean VW(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            new StringBuilder("fingerprint empty:").append(str).append(",current:").append(str2);
            return false;
        } else if (str.equals(str2)) {
            return false;
        } else {
            new StringBuilder("system OTA,fingerprint not equal:").append(str).append(",").append(str2);
            return true;
        }
    }

    public static ShareDexDiffPatchInfo a(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        if (shareDexDiffPatchInfo.xhB.startsWith("test.dex")) {
            return new ShareDexDiffPatchInfo("classes" + i + ".dex", shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.xhC, shareDexDiffPatchInfo.xhD, shareDexDiffPatchInfo.xhG, shareDexDiffPatchInfo.xhE, shareDexDiffPatchInfo.xhF, shareDexDiffPatchInfo.xhH);
        }
        return null;
    }

    public static boolean mA(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int a(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        int i2;
        if (shareSecurityCheck.aa(file)) {
            String hB = hB(context);
            if (hB == null) {
                i2 = -5;
            } else {
                HashMap cgU = shareSecurityCheck.cgU();
                if (cgU == null) {
                    i2 = -2;
                } else {
                    String str = (String) cgU.get("TINKER_ID");
                    if (str == null) {
                        i2 = -6;
                    } else if (hB.equals(str)) {
                        i2 = 0;
                    } else {
                        new StringBuilder("tinkerId is not equal, base is ").append(hB).append(", but patch is ").append(str);
                        i2 = -7;
                    }
                }
            }
        } else {
            i2 = -1;
        }
        if (i2 != 0) {
            return i2;
        }
        Object obj;
        if (i == 7) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            cgU = shareSecurityCheck.xiS;
            if (!DW(i) && cgU.containsKey("assets/dex_meta.txt")) {
                return -9;
            }
            if (!DX(i) && cgU.containsKey("assets/so_meta.txt")) {
                return -9;
            }
            if (!DY(i) && cgU.containsKey("assets/res_meta.txt")) {
                return -9;
            }
        }
        return 0;
    }

    public static Properties ab(File file) {
        Closeable inputStream;
        Throwable th;
        IOException e;
        ZipFile zipFile;
        Throwable th2;
        if (!file.isFile() || file.length() == 0) {
            return null;
        }
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.a(zipFile2);
                    return null;
                }
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.c(inputStream);
                        SharePatchFileUtil.a(zipFile2);
                        return properties;
                    } catch (Throwable th3) {
                        th = th3;
                        SharePatchFileUtil.c(inputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    SharePatchFileUtil.c(inputStream);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
                try {
                    new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                    SharePatchFileUtil.a(zipFile);
                    return null;
                } catch (Throwable th5) {
                    th2 = th5;
                    zipFile2 = zipFile;
                    SharePatchFileUtil.a(zipFile2);
                    throw th2;
                }
            } catch (Throwable th6) {
                th2 = th6;
                SharePatchFileUtil.a(zipFile2);
                throw th2;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
            SharePatchFileUtil.a(zipFile);
            return null;
        } catch (Throwable th7) {
            zipFile2 = null;
            th2 = th7;
            SharePatchFileUtil.a(zipFile2);
            throw th2;
        }
    }

    private static String hB(Context context) {
        if (xiX != null) {
            return xiX;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData.get("TINKER_ID");
            if (obj != null) {
                xiX = String.valueOf(obj);
            } else {
                xiX = null;
            }
            return xiX;
        } catch (Exception e) {
            new StringBuilder("getManifestTinkerID exception:").append(e.getMessage());
            return null;
        }
    }

    public static boolean DW(int i) {
        return (i & 1) != 0;
    }

    public static boolean DX(int i) {
        return (i & 2) != 0;
    }

    public static boolean DY(int i) {
        return (i & 4) != 0;
    }

    public static String DZ(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static void hC(Context context) {
        context.getSharedPreferences("tinker_share_config", 4).edit().putBoolean("tinker_enable_1.8.0", false).commit();
    }

    public static boolean hD(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("tinker_share_config", 4).getBoolean("tinker_enable_1.8.0", true);
    }

    public static boolean Ea(int i) {
        return i != 0;
    }

    public static boolean hE(Context context) {
        String packageName = context.getPackageName();
        Object hH = hH(context);
        if (hH == null || hH.length() == 0) {
            hH = "";
        }
        return packageName.equals(hH);
    }

    public static boolean hF(Context context) {
        if (xiW != null) {
            return xiW.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(hH(context).endsWith(":patch"));
        xiW = valueOf;
        return valueOf.booleanValue();
    }

    public static String bL(Context context, String str) {
        if (!str.equals("changing")) {
            return str;
        }
        if (hE(context)) {
            return "odex";
        }
        return "interpet";
    }

    public static void hG(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static String hH(Context context) {
        if (processName != null) {
            return processName;
        }
        String hI = hI(context);
        processName = hI;
        return hI;
    }

    private static String hI(Context context) {
        Throwable th;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                RunningAppProcessInfo runningAppProcessInfo;
                try {
                    for (RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                        if (runningAppProcessInfo2.pid == myPid) {
                            break;
                        }
                    }
                    runningAppProcessInfo2 = null;
                } catch (Exception e) {
                    Exception e2;
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    runningAppProcessInfo2 = null;
                }
                if (runningAppProcessInfo2 != null) {
                    return runningAppProcessInfo2.processName;
                }
            }
        }
        byte[] bArr = new byte[FileUtils.S_IWUSR];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i = 0;
                    while (i < read) {
                        if (bArr[i] > Byte.MIN_VALUE || bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                        i++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return "";
            } catch (Exception e5) {
                e2 = e5;
                try {
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            fileInputStream = null;
            new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private static boolean VX(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean cgZ() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            String str = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejit"});
            String str2 = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejitprofiles"});
            if (!mA(str) && mA(str2) && str.equals("true")) {
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isVmJitInternal ex:").append(th);
        }
        return false;
    }

    public static String h(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String Px = Px(byteArrayOutputStream.toString());
        return Px;
    }

    private static String Px(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        if (c != '\u0000') {
            return new String(toCharArray, 0, i);
        }
        return str;
    }
}
