package com.tencent.mm.booter;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class o {
    static long gKv = 0;

    static class a {
        int gKA;
        int gKB;
        int gKx;
        int gKy = 1;
        int gKz;

        a() {
        }

        public final boolean cX(String str) {
            String[] split = str.split(",");
            if (split == null || split.length != 5) {
                w.e("MicroMsg.ProcessReport", "error format");
                return false;
            }
            try {
                this.gKx = bg.getInt(split[0], 0);
                this.gKy = bg.getInt(split[1], 0);
                this.gKz = bg.getInt(split[2], 0);
                this.gKA = bg.getInt(split[3], 0);
                this.gKB = bg.getInt(split[4], 0);
                return true;
            } catch (Throwable e) {
                w.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
                w.printErrStackTrace("MicroMsg.ProcessReport", e, "", new Object[0]);
                return false;
            }
        }

        public final String toString() {
            return String.format("%d,%d,%d,%d,%d", new Object[]{Integer.valueOf(this.gKx), Integer.valueOf(this.gKy), Integer.valueOf(this.gKz), Integer.valueOf(this.gKA), Integer.valueOf(this.gKB)});
        }
    }

    public static void onCreate(boolean z) {
        if (z) {
            k("mm_proc_startup", 2);
        } else {
            k("push_proc_startup", 1);
        }
    }

    private static void k(String str, int i) {
        a aVar;
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length > 0) {
            aVar = new a();
            if (aVar.cX(split[split.length - 1])) {
                aVar.gKB = Process.myPid();
                split[split.length - 1] = aVar.toString();
            }
        }
        aVar = new a();
        aVar.gKx = i;
        aVar.gKz = Process.myPid();
        aVar.gKA = (int) bg.Ny();
        String d = d(split);
        String aVar2 = aVar.toString();
        if (d.length() > 0) {
            aVar2 = d + "=" + aVar2;
        }
        w.d("MicroMsg.ProcessReport", "startProc new info %s", aVar2);
        sharedPreferences.edit().putString("startup_info", aVar2).commit();
    }

    public static void oA() {
        cV("mm_proc_startup");
        cV("push_proc_startup");
    }

    private static void cV(String str) {
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split != null && split.length != 0) {
            a aVar = new a();
            if (aVar.cX(split[split.length - 1])) {
                aVar.gKy = 2;
                split[split.length - 1] = aVar.toString();
            }
            w.d("MicroMsg.ProcessReport", "uerExit new info %s", d(split));
            sharedPreferences.edit().putString("startup_info", r1).commit();
        }
    }

    public static void qg() {
        if (gKv == 0 || bg.aB(gKv) >= 3600000) {
            final int intValue = ((Integer) ap.yW().get(37, Integer.valueOf(0))).intValue();
            if (d.sYN != intValue) {
                ap.yW().set(37, Integer.valueOf(d.sYN));
                new ae(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        g.oUh.A(10675, intValue + "," + f.fuV);
                    }
                });
            }
            gKv = bg.NA();
            new ae(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    o.cW("mm_proc_startup");
                    o.cW("push_proc_startup");
                }
            });
        }
    }

    public static void cW(String str) {
        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences(str, 0);
        String[] split = sharedPreferences.getString("startup_info", "").split("=");
        if (split == null || split.length <= 1) {
            w.i("MicroMsg.ProcessReport", "nothing to reprot");
            return;
        }
        for (int i = 0; i < split.length - 1; i++) {
            w.i("MicroMsg.ProcessReport", "reprot %s: %s", str, split[i]);
            g.oUh.A(10667, split[i]);
        }
        sharedPreferences.edit().putString("startup_info", split[split.length - 1]).commit();
    }

    private static String d(String[] strArr) {
        String str = "";
        Object obj = 1;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            if (obj != null) {
                obj = null;
            } else {
                str = str + "=";
            }
            i++;
            str = str + str2;
        }
        return str;
    }
}
