package com.tencent.tinker.lib.e;

import android.content.Context;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class c {
    private static c xgS;
    private Context context = null;
    public boolean xgT = true;
    public File xgU = null;
    public File xgV = null;
    public int xgW = 5;

    static class a {
        public String fFW;
        public String xgX;

        public a(String str, String str2) {
            this.fFW = str;
            this.xgX = str2;
        }

        public static a R(File file) {
            String property;
            Object e;
            Throwable th;
            String str = null;
            Properties properties = new Properties();
            Closeable fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    property = properties.getProperty("md5");
                    try {
                        str = properties.getProperty("times");
                        SharePatchFileUtil.c(fileInputStream);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
                            SharePatchFileUtil.c(fileInputStream);
                            return new a(property, str);
                        } catch (Throwable th2) {
                            th = th2;
                            SharePatchFileUtil.c(fileInputStream);
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    IOException iOException = e3;
                    property = str;
                    a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
                    SharePatchFileUtil.c(fileInputStream);
                    return new a(property, str);
                }
            } catch (IOException e32) {
                e = e32;
                fileInputStream = str;
                property = str;
                a.e("Tinker.UpgradePatchRetry", "fail to readRetryProperty:" + e, new Object[0]);
                SharePatchFileUtil.c(fileInputStream);
                return new a(property, str);
            } catch (Throwable th3) {
                fileInputStream = str;
                th = th3;
                SharePatchFileUtil.c(fileInputStream);
                throw th;
            }
            return new a(property, str);
        }

        public static void a(File file, a aVar) {
            Closeable fileOutputStream;
            Throwable e;
            if (aVar != null) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                Properties properties = new Properties();
                properties.put("md5", aVar.fFW);
                properties.put("times", aVar.xgX);
                try {
                    fileOutputStream = new FileOutputStream(file, false);
                    try {
                        properties.store(fileOutputStream, null);
                        SharePatchFileUtil.c(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                            SharePatchFileUtil.c(fileOutputStream);
                        } catch (Throwable th) {
                            e = th;
                            SharePatchFileUtil.c(fileOutputStream);
                            throw e;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    a.printErrStackTrace("Tinker.UpgradePatchRetry", e, "retry write property fail", new Object[0]);
                    SharePatchFileUtil.c(fileOutputStream);
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    SharePatchFileUtil.c(fileOutputStream);
                    throw e;
                }
            }
        }
    }

    private c(Context context) {
        this.context = context;
        this.xgU = new File(SharePatchFileUtil.hy(context), "patch.retry");
        this.xgV = new File(SharePatchFileUtil.hy(context), "temp.apk");
    }

    public static c hu(Context context) {
        if (xgS == null) {
            xgS = new c(context);
        }
        return xgS;
    }

    public final boolean cgS() {
        if (!this.xgT) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry disabled, just return", new Object[0]);
            return false;
        } else if (!com.tencent.tinker.lib.d.a.hp(this.context).qPN) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
            return false;
        } else if (!this.xgU.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad retry info not exist, just return", new Object[0]);
            return false;
        } else if (b.hr(this.context)) {
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad tinker service is running, just return", new Object[0]);
            return false;
        } else {
            String absolutePath = this.xgV.getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is not exist, just return", new Object[]{absolutePath});
                return false;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchRetryLoad patch file: %s is exist, retry to patch", new Object[]{absolutePath});
            com.tencent.tinker.lib.d.c.bJ(this.context, absolutePath);
            return true;
        }
    }

    public final boolean VO(String str) {
        if (!this.xgT) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry disabled, just return", new Object[0]);
            return true;
        } else if (!this.xgU.exists()) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck retry file is not exist, just return", new Object[0]);
            return true;
        } else if (str == null) {
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck md5 is null, just return", new Object[0]);
            return true;
        } else {
            a R = a.R(this.xgU);
            if (!str.equals(R.fFW) || Integer.parseInt(R.xgX) < this.xgW) {
                return true;
            }
            a.w("Tinker.UpgradePatchRetry", "onPatchListenerCheck, retry count %d must exceed than max retry count", new Object[]{Integer.valueOf(Integer.parseInt(R.xgX))});
            SharePatchFileUtil.W(this.xgV);
            return false;
        }
    }

    public final void Q(File file) {
        if (!file.getAbsolutePath().equals(this.xgV.getAbsolutePath())) {
            a.w("Tinker.UpgradePatchRetry", "try copy file: %s to %s", new Object[]{file.getAbsolutePath(), this.xgV.getAbsolutePath()});
            try {
                SharePatchFileUtil.k(file, this.xgV);
            } catch (IOException e) {
                a.e("Tinker.UpgradePatchRetry", "fail to copy file: %s to %s", new Object[]{file.getAbsolutePath(), this.xgV.getAbsolutePath()});
            }
        }
    }
}
