package com.tencent.tinker.loader.shareutil;

import android.os.Build;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SharePatchInfo {
    public String xgB;
    public String xiG;
    public String xiH;
    public String xiI;

    public SharePatchInfo(String str, String str2, String str3, String str4) {
        this.xiG = str;
        this.xiH = str2;
        this.xiI = str3;
        this.xgB = str4;
    }

    public static SharePatchInfo m(File file, File file2) {
        ShareFileLockHelper T;
        Throwable e;
        Throwable th;
        SharePatchInfo sharePatchInfo = null;
        if (!(file == null || file2 == null)) {
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                T = ShareFileLockHelper.T(file2);
                try {
                    sharePatchInfo = Z(file);
                    try {
                        T.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
                    } catch (Throwable th2) {
                        e = th2;
                        if (T != null) {
                            try {
                                T.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Throwable e5) {
                th = e5;
                T = null;
                e = th;
                throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
            } catch (Throwable e52) {
                th = e52;
                T = null;
                e = th;
                if (T != null) {
                    T.close();
                }
                throw e;
            }
        }
        return sharePatchInfo;
    }

    public static boolean a(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            shareFileLockHelper = ShareFileLockHelper.T(file2);
            boolean a = a(file, sharePatchInfo);
            try {
                shareFileLockHelper.close();
                return a;
            } catch (IOException e) {
                return a;
            }
        } catch (Throwable e2) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e2);
        } catch (Throwable th) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    private static SharePatchInfo Z(File file) {
        Object e;
        Throwable th;
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (i < 2 && i2 == 0) {
            Closeable fileInputStream;
            String property;
            int i3 = i + 1;
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    str4 = properties.getProperty("old");
                    str3 = properties.getProperty("new");
                    str2 = properties.getProperty("print");
                    property = properties.getProperty("dir");
                    SharePatchFileUtil.c(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        new StringBuilder("read property failed, e:").append(e);
                        SharePatchFileUtil.c(fileInputStream);
                        property = str;
                        if (str4 != null) {
                        }
                        str = property;
                        i = i3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                new StringBuilder("read property failed, e:").append(e);
                SharePatchFileUtil.c(fileInputStream);
                property = str;
                if (str4 != null) {
                }
                str = property;
                i = i3;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            if (str4 != null || r4 == null) {
                str = property;
                i = i3;
            } else if ((str4.equals("") || SharePatchFileUtil.VU(str4)) && SharePatchFileUtil.VU(r4)) {
                str = property;
                i2 = 1;
                i = i3;
            } else {
                new StringBuilder("path info file  corrupted:").append(file.getAbsolutePath());
                str = property;
                i = i3;
            }
        }
        if (i2 != 0) {
            return new SharePatchInfo(str4, str3, str2, str);
        }
        return null;
        SharePatchFileUtil.c(fileInputStream);
        throw th;
    }

    private static boolean a(File file, SharePatchInfo sharePatchInfo) {
        Closeable fileOutputStream;
        Object e;
        SharePatchInfo Z;
        Throwable th;
        if (file == null || sharePatchInfo == null) {
            return false;
        }
        if (ShareTinkerInternals.mA(sharePatchInfo.xiI)) {
            sharePatchInfo.xiI = Build.FINGERPRINT;
        }
        if (ShareTinkerInternals.mA(sharePatchInfo.xgB)) {
            sharePatchInfo.xgB = "odex";
        }
        new StringBuilder("rewritePatchInfoFile file path:").append(file.getAbsolutePath()).append(" , oldVer:").append(sharePatchInfo.xiG).append(", newVer:").append(sharePatchInfo.xiH).append(", fingerprint:").append(sharePatchInfo.xiI).append(", oatDir:").append(sharePatchInfo.xgB);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        int i = 0;
        boolean z = false;
        while (i < 2 && !z) {
            boolean z2;
            int i2 = i + 1;
            Properties properties = new Properties();
            properties.put("old", sharePatchInfo.xiG);
            properties.put("new", sharePatchInfo.xiH);
            properties.put("print", sharePatchInfo.xiI);
            properties.put("dir", sharePatchInfo.xgB);
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, "from old version:" + sharePatchInfo.xiG + " to new version:" + sharePatchInfo.xiH);
                    SharePatchFileUtil.c(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        new StringBuilder("write property failed, e:").append(e);
                        SharePatchFileUtil.c(fileOutputStream);
                        Z = Z(file);
                        if (Z == null) {
                        }
                        z2 = false;
                        if (z2) {
                            file.delete();
                        }
                        z = z2;
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                new StringBuilder("write property failed, e:").append(e);
                SharePatchFileUtil.c(fileOutputStream);
                Z = Z(file);
                if (Z == null) {
                }
                z2 = false;
                if (z2) {
                    file.delete();
                }
                z = z2;
                i = i2;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            Z = Z(file);
            if (Z == null && Z.xiG.equals(sharePatchInfo.xiG) && Z.xiH.equals(sharePatchInfo.xiH)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                file.delete();
            }
            z = z2;
            i = i2;
        }
        if (z) {
            return true;
        }
        return false;
        SharePatchFileUtil.c(fileOutputStream);
        throw th;
    }
}
