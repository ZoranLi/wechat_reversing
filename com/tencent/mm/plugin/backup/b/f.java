package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class f {
    public static int jDa;
    public static int jDb;
    public static int jDc;
    public static int jDd;
    public static int jDe;
    public static int jDf;
    public static int jDg;
    public static long jDh;
    public static long jDi;
    public static long jDj;

    public static void reset() {
        jDa = 0;
        jDb = 0;
        jDc = 0;
        jDd = 0;
        jDe = 0;
        jDf = 0;
        jDg = 0;
        long Nz = bg.Nz();
        jDh = Nz;
        jDj = Nz - jDi;
    }

    public static void jh(int i) {
        switch (i) {
            case 1:
                jDc++;
                break;
            case 3:
                jDa++;
                break;
            case 34:
                jDe++;
                break;
            case JsApiGetLocation.CTRL_INDEX /*37*/:
            case 40:
            case 42:
            case 48:
            case 10000:
                jDb++;
                break;
            case 43:
                jDd++;
                break;
            case 49:
                jDf++;
                break;
        }
        jDg++;
    }

    public static void aav() {
        w.d("MicroMsg.TestInfo", "total_count: " + jDg + "text_count: " + jDc + "normal_count : " + jDb + " image_count: " + jDa + " voice_count : " + jDe + " video_count " + jDd + " app_count : " + jDf + " time: " + (bg.Nz() - jDh) + " net: " + jDj);
    }

    public static void aaw() {
        w.d("MicroMsg.TestInfo", "netTime" + (bg.Nz() - jDi));
    }
}
