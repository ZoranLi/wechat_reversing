package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.plugin.clean.b.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class d {
    private static ArrayList<b> jKb;
    private static long kyC = 0;
    private static long kyD = 0;
    private static final ae kyJ = new ae();
    public static int kyK = 0;
    private static b kyx;

    public static void a(b bVar) {
        kyx = bVar;
    }

    public static b ajK() {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "getThreadController threadController is null? %b";
        Object[] objArr = new Object[1];
        if (kyx != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.d(str, str2, objArr);
        return kyx;
    }

    public static void p(ArrayList<b> arrayList) {
        boolean z = true;
        String str = "MicroMsg.CleanLogic";
        String str2 = "set analyse data: is null? %b";
        Object[] objArr = new Object[1];
        if (arrayList != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        jKb = arrayList;
    }

    public static ArrayList<b> abX() {
        return jKb;
    }

    public static void aP(long j) {
        kyD = j;
    }

    public static long ajL() {
        return kyD;
    }

    public static void aQ(long j) {
        kyC = j;
    }

    public static long ajM() {
        return kyC;
    }

    public static final void ajN() {
        w.i("MicroMsg.CleanLogic", "startCleanDataNow");
        kyJ.removeCallbacksAndMessages(null);
        kyD = 0;
        kyC = 0;
        p(null);
        kyK = 0;
    }

    public static final void ajO() {
        w.i("MicroMsg.CleanLogic", "start to post clean runnable!!");
        kyJ.removeCallbacksAndMessages(null);
        kyJ.postDelayed(new Runnable() {
            public final void run() {
                if (d.kyK == 0) {
                    w.i("MicroMsg.CleanLogic", "clean data");
                    d.aP(0);
                    d.p(null);
                    return;
                }
                w.i("MicroMsg.CleanLogic", "clean data is using");
            }
        }, 300000);
    }

    public static final void ajP() {
        kyK++;
    }

    public static final void ajQ() {
        kyK--;
    }
}
