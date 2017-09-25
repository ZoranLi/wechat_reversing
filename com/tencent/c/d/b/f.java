package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class f {
    private static Boolean wSp = null;
    private static final Object wSq = new Object();

    public static boolean cdK() {
        Boolean bool;
        Closeable fileInputStream;
        boolean booleanValue;
        Closeable closeable = null;
        boolean z = false;
        synchronized (wSq) {
            if (wSp == null) {
                if (VERSION.SDK_INT < 17 || !new File("/sys/fs/selinux/enforce").exists()) {
                    bool = null;
                } else {
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            if (fileInputStream.read() == 49) {
                                z = true;
                            }
                            Boolean valueOf = Boolean.valueOf(z);
                            b.c(fileInputStream);
                            bool = valueOf;
                        } catch (Exception e) {
                            b.c(fileInputStream);
                            bool = null;
                            if (bool == null) {
                                bool = Boolean.valueOf(false);
                            }
                            wSp = bool;
                            booleanValue = wSp.booleanValue();
                            return booleanValue;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            closeable = fileInputStream;
                            Throwable th3 = th2;
                            b.c(closeable);
                            throw th3;
                        }
                    } catch (Exception e2) {
                        fileInputStream = null;
                        b.c(fileInputStream);
                        bool = null;
                        if (bool == null) {
                            bool = Boolean.valueOf(false);
                        }
                        wSp = bool;
                        booleanValue = wSp.booleanValue();
                        return booleanValue;
                    } catch (Throwable th4) {
                        th3 = th4;
                        b.c(closeable);
                        throw th3;
                    }
                }
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                wSp = bool;
            }
            booleanValue = wSp.booleanValue();
        }
        return booleanValue;
    }
}
