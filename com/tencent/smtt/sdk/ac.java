package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class ac {
    private static ac wWZ;
    private static FileLock wXc = null;
    boolean wTI;
    ad wXa;
    private boolean wXb;

    private ac() {
    }

    public static FileLock cfa() {
        return wXc;
    }

    public static ac cfb() {
        if (wWZ == null) {
            synchronized (ac.class) {
                if (wWZ == null) {
                    wWZ = new ac();
                }
            }
        }
        return wWZ;
    }

    public final synchronized void b(Context context, o oVar) {
        Object obj;
        Object obj2 = null;
        synchronized (this) {
            if (oVar != null) {
                oVar.a("x5_core_engine_init_sync", (byte) 2);
            }
            d mb = d.mb(true);
            mb.a(context, oVar);
            StringBuilder stringBuilder = new StringBuilder();
            if (oVar != null) {
                oVar.a("init_x5_core", (byte) 1);
            }
            w cdS = mb.cdS();
            if (!mb.wTH || cdS == null) {
                this.wXb = false;
                stringBuilder.append("can not use X5 by !tbs available");
                obj = null;
            } else {
                if (!this.wTI) {
                    if (oVar != null) {
                        oVar.wUY = true;
                    }
                    this.wXa = new ad(cdS.wWu);
                    try {
                        this.wXb = this.wXa.cfe();
                        if (!this.wXb) {
                            stringBuilder.append("can not use X5 by x5corewizard return false");
                        }
                        obj = null;
                    } catch (NoSuchMethodException e) {
                        this.wXb = true;
                        obj = null;
                    } catch (Throwable th) {
                        obj = th;
                        this.wXb = false;
                        stringBuilder.append("can not use x5 by throwable " + Log.getStackTraceString(obj));
                    }
                    if (this.wXb) {
                        CookieManager.getInstance().n(context, true);
                        CookieManager.getInstance().cdO();
                    }
                }
                obj = null;
            }
            if (!this.wXb) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (mb.wTH && cdS != null && obj == null) {
                    try {
                        DexLoader dexLoader = cdS.wWu;
                        if (dexLoader != null) {
                            obj2 = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj2 instanceof Throwable) {
                            Throwable th2 = (Throwable) obj2;
                            stringBuilder.append("#" + th2.getMessage() + "; cause: " + th2.getCause() + "; th: " + th2);
                        }
                        if (obj2 instanceof String) {
                            stringBuilder.append("failure detail:" + obj2);
                        }
                    } catch (Throwable th3) {
                    }
                    if (stringBuilder.toString().contains("isPreloadX5Disabled:-10000")) {
                        i.cec().a(context, 408, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    } else {
                        i.cec().a(context, 407, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + stringBuilder.toString()));
                    }
                } else if (mb.wTH) {
                    i.cec().a(context, 409, new Throwable("mCanUseX5=false, available true, reason: " + obj));
                } else {
                    i.cec().a(context, 410, new Throwable("mCanUseX5=false, available false, reason: " + obj));
                }
            } else if (wXc == null) {
                gF(context);
            }
            this.wTI = true;
            if (oVar != null) {
                oVar.a("init_x5_core", (byte) 2);
            }
        }
    }

    public final boolean cfc() {
        return QbSdk.wTf ? false : this.wXb;
    }

    public final ad cfd() {
        return QbSdk.wTf ? null : this.wXa;
    }

    public final synchronized FileLock gF(Context context) {
        FileLock fileLock;
        if (wXc != null) {
            fileLock = wXc;
        } else {
            FileOutputStream b = f.b(context, true, "tbs_rename_lock.txt");
            if (b != null) {
                wXc = f.a(b);
            }
            fileLock = wXc;
        }
        return fileLock;
    }
}
