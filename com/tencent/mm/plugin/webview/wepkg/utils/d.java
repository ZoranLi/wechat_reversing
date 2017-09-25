package com.tencent.mm.plugin.webview.wepkg.utils;

import android.content.SharedPreferences;
import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.a;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public final class d {
    private static volatile af hta;
    private static final Object jnL = new Object();
    private static final Set<Object> jnM = new HashSet();

    public static long XH() {
        return bg.Ny();
    }

    public static <T> T aN(T t) {
        jnM.add(t);
        return t;
    }

    public static void aO(Object obj) {
        if (obj != null) {
            jnM.remove(obj);
        }
    }

    public static void XI() {
        if (hta != null) {
            synchronized (jnL) {
                if (hta != null) {
                    hta.nJF.quit();
                    hta = null;
                }
            }
        }
    }

    public static af vL() {
        if (hta == null) {
            synchronized (jnL) {
                hta = new af("WebviewCache#WorkerThread");
            }
        }
        return hta;
    }

    public static String KN(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return b.iAV + str + "/";
    }

    public static String ec(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return "";
        }
        return KN(str) + str2;
    }

    public static void a(String str, final a aVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        final WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.ou = MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED;
        wepkgCrossProcessTask.sqv = str;
        if (ab.bJb()) {
            vL().D(new Runnable() {
                public final void run() {
                    wepkgCrossProcessTask.PM();
                    if (aVar != null) {
                        aVar.a(wepkgCrossProcessTask);
                    }
                }
            });
            return;
        }
        wepkgCrossProcessTask.iMD = new Runnable() {
            public final void run() {
                w.i("MicroMsg.Wepkg.WepkgUtil", "bind service time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                if (aVar != null) {
                    aVar.a(wepkgCrossProcessTask);
                }
                wepkgCrossProcessTask.SN();
            }
        };
        wepkgCrossProcessTask.SM();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static String KO(String str) {
        if (bg.mA(str)) {
            return "";
        }
        try {
            return bg.mz(Uri.parse(str).getQueryParameter("wechat_pkgid"));
        } catch (UnsupportedOperationException e) {
            w.e("MicroMsg.Wepkg.WepkgUtil", e.getMessage());
            return "";
        }
    }

    public static String KP(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return Uri.parse(str).getHost();
    }

    public static String KQ(String str) {
        if (bg.mA(str) || !URLUtil.isNetworkUrl(str)) {
            return "";
        }
        try {
            String replaceFirst = str.replaceFirst(Uri.parse(str).getScheme() + "://", "");
            try {
                if (replaceFirst.contains("?")) {
                    return replaceFirst.substring(0, replaceFirst.indexOf("?"));
                }
                return replaceFirst;
            } catch (Exception e) {
                return replaceFirst;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    public static boolean KR(String str) {
        if (bg.mA(KO(str))) {
            return false;
        }
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null && sharedPreferences.getBoolean("disable_we_pkg", false)) {
            w.i("MicroMsg.Wepkg.WepkgUtil", "disable wepkg");
            a.b("EnterWeb", str, KO(str), null, 0, 0, a.wN(11));
            return false;
        } else if (!b.srv) {
            return true;
        } else {
            w.i("MicroMsg.Wepkg.WepkgUtil", "config wepkg disable");
            a.b("EnterWeb", str, KO(str), null, 0, 0, a.wN(12));
            return false;
        }
    }

    public static String ed(String str, String str2) {
        return g.n((str + "_" + str2).getBytes());
    }

    public static boolean KS(String str) {
        try {
            File file = new File(str);
            if (!(file.exists() && file.isDirectory())) {
                file.mkdirs();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean bAE() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        int i = gregorianCalendar.get(11);
        int i2 = gregorianCalendar.get(12);
        if (i >= 12 && i < 14) {
            return true;
        }
        if (i == 14) {
            if (i2 <= 30) {
                return true;
            }
        } else if (i >= 18 && i <= 24) {
            return true;
        }
        return false;
    }
}
