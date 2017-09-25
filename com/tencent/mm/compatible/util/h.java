package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class h {
    private static Boolean gSP = null;

    public static File getExternalStorageDirectory() {
        if (bg.mA(p.gRl.gQv)) {
            return Environment.getExternalStorageDirectory();
        }
        return new File(p.gRl.gQv);
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        if (bg.mA(p.gRl.gQw)) {
            return Environment.getExternalStoragePublicDirectory(str);
        }
        return new File(p.gRl.gQw);
    }

    public static File getDataDirectory() {
        if (bg.mA(p.gRl.gQx)) {
            return Environment.getDataDirectory();
        }
        return new File(p.gRl.gQx);
    }

    public static File getRootDirectory() {
        if (bg.mA(p.gRl.gQy)) {
            return Environment.getRootDirectory();
        }
        return new File(p.gRl.gQy);
    }

    public static File getDownloadCacheDirectory() {
        if (bg.mA(p.gRl.gQA)) {
            return Environment.getDownloadCacheDirectory();
        }
        return new File(p.gRl.gQA);
    }

    public static String getExternalStorageState() {
        if (bg.mA(p.gRl.gQz)) {
            return Environment.getExternalStorageState();
        }
        return p.gRl.gQz;
    }

    public static boolean sf() {
        FileInputStream fileInputStream;
        Throwable e;
        if (gSP == null) {
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    gSP = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        w.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        gSP = Boolean.valueOf(false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return gSP.booleanValue();
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                w.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                gSP = Boolean.valueOf(false);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return gSP.booleanValue();
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
        return gSP.booleanValue();
    }
}
