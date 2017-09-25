package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SharePatchFileUtil {
    private static char[] usT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static File hx(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker");
    }

    public static File hy(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker_temp");
    }

    public static File hz(Context context) {
        File hy = hy(context);
        if (hy == null) {
            return null;
        }
        return new File(hy, "tinker_last_crash");
    }

    public static File VQ(String str) {
        return new File(str + "/patch.info");
    }

    public static File VR(String str) {
        return new File(str + "/info.lock");
    }

    public static String VS(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return "patch-" + str.substring(0, 8);
    }

    public static String VT(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return VS(str) + ".apk";
    }

    public static boolean VU(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static String hA(Context context) {
        Object e;
        Throwable th;
        File hz = hz(context);
        if (!U(hz)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(hz)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } else {
                        c(bufferedReader);
                        return stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            try {
                new StringBuilder("checkTinkerLastUncaughtCrash exception: ").append(e);
                c(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                c(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            c(bufferedReader);
            throw th;
        }
    }

    public static final boolean U(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static long V(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j += V(file2);
            } else {
                j += file2.length();
            }
        }
        return j;
    }

    public static final boolean W(File file) {
        boolean z = true;
        if (file != null) {
            new StringBuilder("safeDeleteFile, try to delete path: ").append(file.getPath());
            if (file.exists()) {
                z = file.delete();
                if (!z) {
                    new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(file.getPath());
                    file.deleteOnExit();
                }
            }
        }
        return z;
    }

    public static final boolean aP(String str) {
        if (str == null) {
            return false;
        }
        return d(new File(str));
    }

    public static final boolean d(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            W(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    d(listFiles[i]);
                    i++;
                }
                W(file);
            }
        }
        return true;
    }

    public static boolean e(File file, String str) {
        if (str == null) {
            return false;
        }
        String X = X(file);
        if (X != null) {
            return str.equals(X);
        }
        return false;
    }

    public static boolean VV(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".dex");
    }

    public static boolean f(File file, String str) {
        return b(file, "classes.dex", str);
    }

    public static boolean b(File file, String str, String str2) {
        Throwable th;
        boolean z = false;
        if (file == null || str2 == null || str == null) {
            return z;
        }
        Object X;
        if (VV(file.getName())) {
            X = X(file);
        } else {
            ZipFile zipFile;
            try {
                zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry(str);
                    if (entry == null) {
                        new StringBuilder("There's no entry named: classes.dex in ").append(file.getAbsolutePath());
                        try {
                            zipFile.close();
                            return z;
                        } catch (Throwable th2) {
                            return z;
                        }
                    }
                    X = s(zipFile.getInputStream(entry));
                    try {
                        zipFile.close();
                    } catch (Throwable th3) {
                    }
                } catch (Throwable th4) {
                    try {
                        new StringBuilder("Bad dex jar file: ").append(file.getAbsolutePath());
                        if (zipFile != null) {
                            return z;
                        }
                        try {
                            zipFile.close();
                            return z;
                        } catch (Throwable th5) {
                            return z;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (Throwable th7) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                zipFile = null;
                if (zipFile != null) {
                    zipFile.close();
                }
                throw th;
            }
        }
        return str2.equals(X);
    }

    public static void k(File file, File file2) {
        Throwable th;
        Closeable closeable = null;
        if (U(file) && file2 != null && !file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            File parentFile = file2.getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            Closeable fileOutputStream;
            try {
                Closeable fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, false);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    closeable = fileInputStream;
                    c(closeable);
                    c(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            c(fileInputStream);
                            c(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = fileInputStream;
                    c(closeable);
                    c(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                c(closeable);
                c(fileOutputStream);
                throw th;
            }
        }
    }

    public static String a(JarFile jarFile, JarEntry jarEntry) {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        Closeable bufferedInputStream;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        c(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            c(bufferedInputStream);
            throw th;
        }
    }

    private static String s(InputStream inputStream) {
        String str = null;
        if (inputStream != null) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuilder stringBuilder = new StringBuilder(32);
                byte[] bArr = new byte[102400];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                byte[] digest = instance.digest();
                for (byte b : digest) {
                    stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
                }
                str = stringBuilder.toString();
            } catch (Exception e) {
            }
        }
        return str;
    }

    public static String bG(byte[] bArr) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr[i2] = usT[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = usT[b & 15];
                i++;
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String X(File file) {
        Closeable fileInputStream;
        Throwable th;
        String str = null;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = s(fileInputStream);
                    c(fileInputStream);
                } catch (Exception e) {
                    c(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    c(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = str;
                c(fileInputStream);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = str;
                th = th4;
                c(fileInputStream);
                throw th;
            }
        }
        return str;
    }

    public static String l(File file, File file2) {
        String name;
        if (ShareTinkerInternals.cgX()) {
            try {
                String cgY = ShareTinkerInternals.cgY();
                File parentFile = file.getParentFile();
                name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    name = name.substring(0, lastIndexOf);
                }
                return parentFile.getAbsolutePath() + "/oat/" + cgY + "/" + name + ".odex";
            } catch (Throwable e) {
                throw new TinkerRuntimeException("getCurrentInstructionSet fail:", e);
            }
        }
        name = file.getName();
        if (!name.endsWith(".dex")) {
            int lastIndexOf2 = name.lastIndexOf(".");
            if (lastIndexOf2 < 0) {
                name = name + ".dex";
            } else {
                StringBuilder stringBuilder = new StringBuilder(lastIndexOf2 + 4);
                stringBuilder.append(name, 0, lastIndexOf2);
                stringBuilder.append(".dex");
                name = stringBuilder.toString();
            }
        }
        return new File(file2, name).getPath();
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean g(File file, String str) {
        Throwable th;
        Throwable th2;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("resources.arsc");
                if (entry == null) {
                    a(zipFile2);
                    return false;
                }
                Closeable inputStream = zipFile2.getInputStream(entry);
                String s = s(inputStream);
                if (s == null || !s.equals(str)) {
                    c(inputStream);
                    a(zipFile2);
                    return false;
                }
                c(inputStream);
                a(zipFile2);
                return true;
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = zipFile2;
                a(zipFile);
                throw th2;
            }
        } catch (Throwable th4) {
            th = th4;
            new StringBuilder("checkResourceArscMd5 throwable:").append(th.getMessage());
            a(zipFile);
            return false;
        }
    }

    public static void Y(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }
}
