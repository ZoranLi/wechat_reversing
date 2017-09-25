package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class t {
    private static Context aMW;
    private static boolean wWa;
    private static String wWb = null;
    public static boolean wWc = false;
    private static String wWd = null;
    private static int wWe = 0;
    private static String wWf = null;
    private static boolean wWg = false;
    private static boolean wWh = false;
    private static String wWi = null;
    private static boolean wWj = false;
    private static boolean wWk = false;

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            tbsLinuxToolsJni.ff(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.ff(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.ff(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    private static File bB(Context context, String str) {
        p.ceA();
        File gl = p.gl(context);
        if (gl == null) {
            return null;
        }
        File file = new File(gl, str);
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

    private static Context bC(Context context, String str) {
        Context context2 = null;
        try {
            context2 = context.createPackageContext(str, 2);
        } catch (NameNotFoundException e) {
        } catch (Exception e2) {
        }
        return context2;
    }

    public static synchronized void c(Context context, int i, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2 = null;
        synchronized (t.class) {
            if (i == 0) {
                gv(context);
                k.fM(aMW).CY(-401);
            } else {
                int gx = gx(context);
                if (gx < 0) {
                    k.fM(aMW).CY(-402);
                } else if (i == gx) {
                    BufferedInputStream bufferedInputStream2;
                    try {
                        File bB = bB(context, "core_info");
                        if (bB != null) {
                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bB));
                            try {
                                Properties properties = new Properties();
                                properties.load(bufferedInputStream2);
                                properties.setProperty("core_disabled", "false");
                                if (z) {
                                    p.ceA();
                                    r5 = p.gk(context).getAbsolutePath();
                                    r6 = context.getApplicationContext().getPackageName();
                                    r7 = c.getAppVersionCode(context);
                                    properties.setProperty("core_packagename", r6);
                                    properties.setProperty("core_path", r5);
                                    properties.setProperty("app_version", String.valueOf(r7));
                                }
                                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bB));
                                try {
                                    properties.store(bufferedOutputStream, null);
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (Exception e) {
                                    }
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (Exception e2) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bufferedInputStream2 != null) {
                                        try {
                                            bufferedInputStream2.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    if (bufferedOutputStream != null) {
                                        try {
                                            bufferedOutputStream.close();
                                        } catch (Exception e4) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                bufferedOutputStream = null;
                                th = th4;
                                if (bufferedInputStream2 != null) {
                                    bufferedInputStream2.close();
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th32) {
                        bufferedInputStream2 = null;
                        th = th32;
                        bufferedOutputStream = null;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                    k.fM(aMW).CY(-403);
                } else if (i >= gx || i >= 43300) {
                    File bB2;
                    TbsLinuxToolsJni tbsLinuxToolsJni;
                    Context bC;
                    String[] ceL = ceL();
                    String[] strArr;
                    if (z) {
                        strArr = new String[]{context.getApplicationContext().getPackageName()};
                    } else {
                        strArr = ceL;
                    }
                    if (wWb != null) {
                        p.ceA();
                        if (i == p.Vt(wWb)) {
                            d(context, Integer.toString(i), "AppDefined", wWb, Integer.toString(1));
                            try {
                                bB2 = bB(context, "core_info");
                                if (!(wWh || bB2 == null)) {
                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(aMW);
                                    tbsLinuxToolsJni.ff(bB2.getAbsolutePath(), "644");
                                    p.ceA();
                                    tbsLinuxToolsJni.ff(p.gl(context).getAbsolutePath(), "755");
                                    wWh = true;
                                }
                            } catch (Throwable th5) {
                            }
                        } else {
                            p.ceA();
                            if (i > p.Vt(wWb)) {
                                for (String str : r2) {
                                    if (i == 0) {
                                        bC = bC(context, str);
                                        p.ceA();
                                        r6 = p.gk(bC).getAbsolutePath();
                                        c.getAppVersionCode(context);
                                        p.ceA();
                                        if (p.fX(bC)) {
                                            try {
                                                f.a(new File(r6), new File(wWb), new FileFilter() {
                                                    public final boolean accept(File file) {
                                                        return !file.getName().endsWith(".dex");
                                                    }
                                                });
                                                d(context, Integer.toString(i), "AppDefined", wWb, Integer.toString(1));
                                                bB2 = bB(context, "core_info");
                                                if (!(wWh || bB2 == null)) {
                                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(aMW);
                                                    tbsLinuxToolsJni.ff(bB2.getAbsolutePath(), "644");
                                                    p.ceA();
                                                    tbsLinuxToolsJni.ff(p.gl(context).getAbsolutePath(), "755");
                                                    wWh = true;
                                                }
                                            } catch (Throwable th6) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (String str2 : r2) {
                        if (i == 0) {
                            bC = bC(context, str2);
                            p.ceA();
                            r6 = p.gk(bC).getAbsolutePath();
                            r7 = c.getAppVersionCode(context);
                            p.ceA();
                            if (p.fX(bC)) {
                                if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    p.ceA();
                                    try {
                                        f.J(p.gk(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th7) {
                                    }
                                }
                                d(context, Integer.toString(i), str2, r6, Integer.toString(r7));
                                try {
                                    bB2 = bB(context, "core_info");
                                    if (!(wWh || bB2 == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(aMW);
                                        tbsLinuxToolsJni.ff(bB2.getAbsolutePath(), "644");
                                        p.ceA();
                                        tbsLinuxToolsJni.ff(p.gl(context).getAbsolutePath(), "755");
                                        wWh = true;
                                    }
                                } catch (Throwable th8) {
                                }
                            }
                        } else if (i == 0) {
                            bC = bC(context, str2);
                            p.ceA();
                            r6 = p.gj(bC).getAbsolutePath();
                            r7 = c.getAppVersionCode(context);
                            p.ceA();
                            if (p.fX(bC)) {
                                if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                    TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i);
                                    p.ceA();
                                    try {
                                        f.J(p.gk(context));
                                        TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                    } catch (Throwable th9) {
                                    }
                                }
                                d(context, Integer.toString(i), str2, r6, Integer.toString(r7));
                                try {
                                    bB2 = bB(context, "core_info");
                                    if (!(wWh || bB2 == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(aMW);
                                        tbsLinuxToolsJni.ff(bB2.getAbsolutePath(), "644");
                                        p.ceA();
                                        tbsLinuxToolsJni.ff(p.gl(context).getAbsolutePath(), "755");
                                        wWh = true;
                                    }
                                } catch (Throwable th10) {
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    gv(context);
                    k.fM(aMW).CY(-404);
                }
            }
        }
        return;
    }

    public static String ceK() {
        return wWb;
    }

    public static String[] ceL() {
        return new String[]{"com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone"};
    }

    public static long ceM() {
        String[] ceL = ceL();
        for (int i = 0; i < 4; i++) {
            String str = ceL[i];
            if (!(str.equalsIgnoreCase("com.tencent.mm") || str.equalsIgnoreCase("com.tencent.mobileqq"))) {
                str.equalsIgnoreCase("com.qzone");
            }
        }
        return 0;
    }

    public static boolean ceN() {
        return wWg;
    }

    static String ceO() {
        return wWd;
    }

    static int ceP() {
        return wWe;
    }

    static int ceQ() {
        return wWe;
    }

    public static int ceR() {
        return wWe;
    }

    public static boolean ceS() {
        return wWj;
    }

    static boolean ceT() {
        TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
        return false;
    }

    private static void d(Context context, String str, String str2, String str3, String str4) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File bB = bB(context, "core_info");
            if (bB == null) {
                k.fM(aMW).CY(-405);
                return;
            }
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bB));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e) {
                }
                if (i != 0) {
                    properties.setProperty("core_version", str);
                    properties.setProperty("core_disabled", "false");
                    properties.setProperty("core_packagename", str2);
                    properties.setProperty("core_path", str3);
                    properties.setProperty("app_version", str4);
                } else {
                    properties.setProperty("core_disabled", "true");
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(bB));
                try {
                    properties.store(bufferedOutputStream, null);
                    wWk = false;
                    k.fM(aMW).CY(-406);
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e2) {
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e3) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedOutputStream = null;
                th = th4;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th32) {
            bufferedInputStream2 = null;
            th = th32;
            bufferedOutputStream = null;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    static void gs(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            p.ceA();
            a(context, tbsLinuxToolsJni, p.gk(context));
            p.ceA();
            tbsLinuxToolsJni.ff(p.gl(context).getAbsolutePath(), "755");
        } catch (Throwable th) {
        }
    }

    static void gt(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            p.ceA();
            a(context, tbsLinuxToolsJni, p.gj(context));
        } catch (Throwable th) {
        }
    }

    public static boolean gu(Context context) {
        try {
            if (aMW != null && aMW.equals(context.getApplicationContext())) {
                return wWa;
            }
            Context applicationContext = context.getApplicationContext();
            aMW = applicationContext;
            String packageName = applicationContext.getPackageName();
            String[] ceL = ceL();
            for (int i = 0; i < 4; i++) {
                if (packageName.equals(ceL[i])) {
                    wWa = false;
                    return false;
                }
            }
            wWa = true;
            return true;
        } catch (Throwable th) {
        }
    }

    private static boolean gv(Context context) {
        if (context == null) {
            return false;
        }
        d(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    static synchronized String gw(Context context) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        Throwable th;
        String str = null;
        synchronized (t.class) {
            try {
                File bB = bB(context, "core_info");
                if (bB != null) {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(bB));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream);
                        String property = properties.getProperty("core_packagename", "");
                        if ("".equals(property)) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                            }
                            str = property;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                bufferedInputStream = null;
                th = th3;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
        return str;
    }

    private static synchronized int gx(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        synchronized (t.class) {
            BufferedInputStream bufferedInputStream2;
            try {
                File bB = bB(context, "core_info");
                if (bB != null) {
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(bB));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream2);
                        String property = properties.getProperty("core_version", "");
                        if ("".equals(property)) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e) {
                            }
                        } else {
                            i = Math.max(Integer.parseInt(property), 0);
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e2) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = null;
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                throw th;
            }
        }
        return i;
    }

    public static void x(Context context, boolean z) {
        try {
            if (gu(context)) {
                p.ceA();
                File gl = p.gl(context);
                if (gl == null) {
                    return;
                }
                if (!z || !new File(gl, "core_info").exists()) {
                    if (wWb != null) {
                        p.ceA();
                        int Vt = p.Vt(wWb);
                        if (Vt > 0) {
                            wWd = wWb;
                            wWf = "AppDefined";
                            wWe = Vt;
                            d(context, Integer.toString(wWe), wWf, wWd, Integer.toString(1));
                            return;
                        }
                    }
                    ceL();
                }
            }
        } catch (Exception e) {
        }
    }
}
