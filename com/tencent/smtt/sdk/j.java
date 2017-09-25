package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class j {
    private static Context mContext = null;
    private static j wUD = null;

    private j() {
    }

    static File ced() {
        p.ceA();
        File file = new File(p.gm(mContext), "tbscoreinstall.txt");
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Properties cee() {
        /*
        r1 = 0;
        r0 = ced();	 Catch:{ Exception -> 0x0020, all -> 0x002a }
        r2 = new java.util.Properties;	 Catch:{ Exception -> 0x0020, all -> 0x002a }
        r2.<init>();	 Catch:{ Exception -> 0x0020, all -> 0x002a }
        if (r0 == 0) goto L_0x0041;
    L_0x000c:
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x003a, all -> 0x002a }
        r3.<init>(r0);	 Catch:{ Exception -> 0x003a, all -> 0x002a }
        r0 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x003a, all -> 0x002a }
        r0.<init>(r3);	 Catch:{ Exception -> 0x003a, all -> 0x002a }
        r2.load(r0);	 Catch:{ Exception -> 0x003d, all -> 0x0035 }
    L_0x0019:
        if (r0 == 0) goto L_0x001e;
    L_0x001b:
        r0.close();	 Catch:{ IOException -> 0x0031 }
    L_0x001e:
        r0 = r2;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = move-exception;
        r0 = r1;
    L_0x0022:
        if (r1 == 0) goto L_0x001f;
    L_0x0024:
        r1.close();	 Catch:{ IOException -> 0x0028 }
        goto L_0x001f;
    L_0x0028:
        r1 = move-exception;
        goto L_0x001f;
    L_0x002a:
        r0 = move-exception;
    L_0x002b:
        if (r1 == 0) goto L_0x0030;
    L_0x002d:
        r1.close();	 Catch:{ IOException -> 0x0033 }
    L_0x0030:
        throw r0;
    L_0x0031:
        r0 = move-exception;
        goto L_0x001e;
    L_0x0033:
        r1 = move-exception;
        goto L_0x0030;
    L_0x0035:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x002b;
    L_0x003a:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0022;
    L_0x003d:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
        goto L_0x0022;
    L_0x0041:
        r0 = r1;
        goto L_0x0019;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.j.cee():java.util.Properties");
    }

    static j fL(Context context) {
        if (wUD == null) {
            synchronized (j.class) {
                if (wUD == null) {
                    wUD = new j();
                }
            }
        }
        mContext = context.getApplicationContext();
        return wUD;
    }

    final int Vp(String str) {
        Properties cee = cee();
        return (cee == null || cee.getProperty(str) == null) ? -1 : Integer.parseInt(cee.getProperty(str));
    }

    final int Vq(String str) {
        Properties cee = cee();
        return (cee == null || cee.getProperty(str) == null) ? 0 : Integer.parseInt(cee.getProperty(str));
    }

    final String Vr(String str) {
        Properties cee = cee();
        return (cee == null || cee.getProperty(str) == null) ? null : cee.getProperty(str);
    }

    final void dj(String str, int i) {
        fe(str, String.valueOf(i));
    }

    final void eA(int i, int i2) {
        dj("copy_core_ver", i);
        dj("copy_status", i2);
    }

    final void eB(int i, int i2) {
        dj("install_core_ver", i);
        dj("install_status", i2);
    }

    final void fe(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Properties cee = cee();
            if (cee != null) {
                cee.setProperty(str, str2);
                File ced = ced();
                if (ced != null) {
                    fileOutputStream = new FileOutputStream(ced);
                    try {
                        cee.store(fileOutputStream, "update " + str + " and status!");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileOutputStream2 = fileOutputStream;
                        th = th3;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                }
            }
        } catch (Exception e5) {
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }
}
