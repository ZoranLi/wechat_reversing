package com.tencent.smtt.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.o;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;

public class m {
    private static m wUW;
    private boolean wUV;

    private m() {
    }

    public static m cey() {
        if (wUW == null) {
            synchronized (m.class) {
                if (wUW == null) {
                    wUW = new m();
                }
            }
        }
        return wUW;
    }

    public final synchronized boolean bw(Context context, String str) {
        boolean z;
        File file = new File(context.getFilesDir(), str);
        z = file.exists() && file.isFile();
        return z;
    }

    public final synchronized void fR(Context context) {
        if (!this.wUV) {
            if (bw(context, "bugly_switch.txt")) {
                Object ceO;
                if (t.gu(context)) {
                    ceO = t.ceO();
                } else {
                    p.ceA();
                    File gk = p.gk(context);
                    if (gk == null) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                    }
                    if (gk.listFiles() == null || gk.listFiles().length <= 0) {
                        TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    } else {
                        ceO = gk.getAbsolutePath();
                    }
                }
                if (TextUtils.isEmpty(ceO)) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                } else {
                    p.ceA();
                    File gk2 = p.gk(context);
                    if (gk2 == null) {
                        TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    } else {
                        File file = new File(ceO, "tbs_bugly_dex.jar");
                        try {
                            o.a(new DexClassLoader(file.getAbsolutePath(), gk2.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new Class[]{Context.class, String.class, String.class, String.class}, context, ceO, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                            this.wUV = true;
                            TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                        } catch (Throwable th) {
                            TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                        }
                    }
                }
            } else {
                TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            }
        }
    }

    public final synchronized boolean n(Context context, String str, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (context != null) {
                File file = new File(context.getFilesDir(), str);
                if (z) {
                    if (!file.exists()) {
                        try {
                            if (file.createNewFile()) {
                                z2 = true;
                            }
                        } catch (IOException e) {
                            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:" + str);
                        }
                    }
                } else if (file.exists()) {
                    if (file.delete()) {
                        z2 = true;
                    } else {
                        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:" + str);
                    }
                }
                z2 = true;
            }
        }
        return z2;
    }
}
