package com.tencent.smtt.utils;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public final class r {
    private static r wYE = null;
    private Context mContext = null;
    public boolean wYC = false;
    private boolean wYD = false;
    private File wYF = null;
    private File wYs = null;

    private r(Context context) {
        this.mContext = context.getApplicationContext();
        cfx();
    }

    private synchronized void cfx() {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        BufferedInputStream bufferedInputStream2;
        try {
            if (this.wYF == null) {
                this.wYF = cfy();
            }
            if (this.wYF != null) {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(this.wYF));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("setting_forceUseSystemWebview", "");
                    if (!"".equals(property)) {
                        this.wYC = Boolean.parseBoolean(property);
                    }
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream2 = null;
            th = th4;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
        return;
    }

    private File cfy() {
        File file;
        try {
            if (this.wYs == null) {
                this.wYs = new File(this.mContext.getDir("tbs", 0), "core_private");
                if (this.wYs == null || !this.wYs.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.wYs, "debug.conf");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            file = null;
        }
        return file;
    }

    public static synchronized r cfz() {
        r rVar;
        synchronized (r.class) {
            rVar = wYE;
        }
        return rVar;
    }

    public static synchronized r ha(Context context) {
        r rVar;
        synchronized (r.class) {
            if (wYE == null) {
                wYE = new r(context);
            }
            rVar = wYE;
        }
        return rVar;
    }

    public final void mf(boolean z) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream = null;
        this.wYD = z;
        BufferedOutputStream bufferedOutputStream2;
        BufferedInputStream bufferedInputStream2;
        try {
            File cfy = cfy();
            if (cfy == null) {
                BufferedInputStream bufferedInputStream3 = null;
                try {
                    bufferedInputStream3.close();
                } catch (Exception e) {
                }
                bufferedOutputStream2 = null;
                try {
                    bufferedOutputStream2.close();
                    return;
                } catch (Exception e2) {
                    return;
                }
            }
            Properties properties;
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(cfy));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream2);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.wYC));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.wYD));
                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(cfy));
            } catch (Throwable th2) {
                th = th2;
                try {
                    bufferedInputStream2.close();
                } catch (Exception e3) {
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception e4) {
                }
                throw th;
            }
            try {
                properties.store(bufferedOutputStream2, null);
                try {
                    bufferedInputStream2.close();
                } catch (Exception e5) {
                }
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e6) {
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedOutputStream = bufferedOutputStream2;
                th = th4;
                bufferedInputStream2.close();
                bufferedOutputStream.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream2 = null;
            bufferedInputStream2.close();
            bufferedOutputStream.close();
            throw th;
        }
    }
}
