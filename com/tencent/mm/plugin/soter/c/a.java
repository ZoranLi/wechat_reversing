package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static int qPX = -1;
    private static int qPY = -1;

    public static void ur(int i) {
        qPX = i;
    }

    public static void blQ() {
        if (qPX == -1) {
            w.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.oUh.i(12925, new Object[]{Integer.valueOf(qPX)});
    }

    public static void blR() {
        if (qPX == -1) {
            w.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.oUh.i(12926, new Object[]{Integer.valueOf(qPX)});
    }

    public static void c(int i, int i2, int i3, String str) {
        if (qPX == -1) {
            w.e("MicroMsg.FingerpirntReporter", "hy: current open scene not set");
            return;
        }
        g.oUh.i(13413, new Object[]{Integer.valueOf(qPX), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
    }

    public static void blS() {
        qPY = (int) (System.currentTimeMillis() / 1000);
    }

    public static void us(int i) {
        if (qPY == -1) {
            w.e("MicroMsg.FingerpirntReporter", "hy: no current pay session");
            return;
        }
        g.oUh.i(12927, new Object[]{Integer.valueOf(qPY), Integer.valueOf(i)});
        qPX = -1;
    }

    public static boolean blT() {
        return qPX >= 0;
    }

    public static void di(int i, int i2) {
        w.v("MicroMsg.FingerpirntReporter", "alvinluo report open guide count, actionType: %d, actionCount: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        g.oUh.i(14381, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void dj(int i, int i2) {
        int i3;
        switch (i2) {
            case 4:
                i3 = 1;
                break;
            case 5:
                i3 = 3;
                break;
            case 9:
                i3 = 2;
                break;
            case 10:
                i3 = 4;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 0;
                    break;
                }
            case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                i3 = 5;
                break;
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            w.i("MicroMsg.FingerpirntReporter", "alvinluo soter idkey report id: %d, key: %d, value: %d", new Object[]{Integer.valueOf(672), Integer.valueOf(i3), Long.valueOf(1)});
            g.oUh.a(672, (long) i3, 1, false);
        }
    }

    public static void ut(int i) {
        w.i("MicroMsg.FingerpirntReporter", "alvinluo soter cLog report, sceneType: %d, detailScene: %d, content: %s", new Object[]{Integer.valueOf(3), Integer.valueOf(i), bg.g(new Throwable())});
        Map hashMap = new HashMap();
        hashMap.put("sceneType", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("scene", String.valueOf(i));
        g.oUh.d("Soter", "Fingerprint pay add authentication task failed: " + r0, hashMap);
    }
}
