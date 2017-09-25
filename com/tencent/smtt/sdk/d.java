package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.i.a;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

class d {
    private static d wTG = null;
    private static int wTJ = 0;
    private static int wTK = 0;
    static boolean wTL = false;
    private static int wTM = 3;
    private static String wTO = null;
    w wTF = null;
    boolean wTH = false;
    boolean wTI = false;
    private File wTN = null;

    private d() {
    }

    static void CV(int i) {
        wTJ = i;
    }

    private void CW(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(wTO, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.wTN, "count.prop")), null);
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
    }

    static void Vo(String str) {
        wTO = str;
    }

    public static int cdT() {
        return wTJ;
    }

    static boolean cdU() {
        wTL = true;
        return true;
    }

    private int cdV() {
        BufferedInputStream bufferedInputStream;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(this.wTN, "count.prop");
            if (file.exists()) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    i = Integer.valueOf(properties.getProperty(wTO, "1")).intValue();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e) {
                    }
                } catch (Exception e2) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return i;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Exception e5) {
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            return i;
        } catch (Throwable th3) {
            th2 = th3;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th2;
        }
        return i;
    }

    public static d mb(boolean z) {
        if (wTG == null && z) {
            synchronized (d.class) {
                if (wTG == null) {
                    wTG = new d();
                }
            }
        }
        return wTG;
    }

    public static boolean useSoftWare() {
        return QbSdk.useSoftWare();
    }

    public final synchronized void a(Context context, o oVar) {
        Object obj = null;
        synchronized (this) {
            TbsLog.addLog(999, null, new Object[0]);
            TbsLog.initIfNeed(context);
            wTK++;
            if (oVar != null) {
                oVar.wUZ = wTK == 1;
            }
            i cec = i.cec();
            if (cec.wUv != null) {
                a aVar = cec.wUv;
                Arrays.fill(aVar.wUA, 0);
                aVar.wUB = 0;
                aVar.wUC = 0;
            }
            cec.wUw = false;
            if (oVar != null) {
                oVar.a("tbs_rename_task", (byte) 1);
            }
            p.ceA().v(context, wTK == 1);
            if (oVar != null) {
                oVar.a("tbs_rename_task", (byte) 2);
            }
            t.x(context, true);
            if (oVar != null) {
                oVar.a("can_load_x5", (byte) 1);
            }
            boolean p = QbSdk.p(context, false);
            if (oVar != null) {
                oVar.a("can_load_x5", (byte) 2);
            }
            boolean z = VERSION.SDK_INT >= 7;
            Object obj2 = (p && z) ? 1 : null;
            if (obj2 == null) {
                String str = "can_load_x5=" + p + "; is_compatible=" + z;
                TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: " + str);
                if (!(QbSdk.wTf && this.wTH)) {
                    this.wTH = false;
                    i.cec().a(context, 405, new Throwable(str));
                }
                this.wTN = p.gm(context);
                this.wTI = true;
            } else if (!this.wTH) {
                try {
                    if (t.gu(context)) {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                        if (oVar != null) {
                            oVar.a("read_core_info", (byte) 1);
                        }
                        if (oVar != null) {
                            oVar.a("read_core_info", (byte) 2);
                        }
                        this.wTH = false;
                        QbSdk.bv(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                    } else {
                        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                        p.ceA();
                        File gk = p.gk(context);
                        if (wTJ == 25436 || wTJ == 25437) {
                            obj = 1;
                        }
                        Context applicationContext = obj != null ? context.getApplicationContext() : context;
                        if (gk == null) {
                            this.wTH = false;
                            QbSdk.bv(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                        } else {
                            this.wTF = new w(context, applicationContext, gk.getAbsolutePath(), gk.getAbsolutePath(), QbSdk.getDexLoaderFileList(context, applicationContext, gk.getAbsolutePath()), QbSdk.wTm, oVar);
                            this.wTH = true;
                            this.wTN = p.gm(context);
                            this.wTI = true;
                        }
                    }
                } catch (Throwable th) {
                    TbsLog.e("SDKEngine", "useSystemWebView by exception: " + th);
                    i.cec().a(context, 327, th);
                    this.wTH = false;
                    QbSdk.bv(context, "SDKEngine::useSystemWebView by exception: " + th);
                }
            }
        }
    }

    public final w cdS() {
        return this.wTH ? this.wTF : null;
    }

    final boolean getTbsNeedReboot() {
        if (wTL) {
            if (wTO == null) {
                return false;
            }
            int cdV = cdV();
            if (cdV == 0) {
                CW(1);
            } else if (cdV + 1 > wTM) {
                return false;
            } else {
                CW(cdV + 1);
            }
        }
        return wTL;
    }
}
