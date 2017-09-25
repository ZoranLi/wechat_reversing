package com.tencent.mm.protocal;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;

public final class d extends e {
    public static String DEVICE_TYPE = ("android-" + VERSION.SDK_INT);
    public static final String sYG = Build.BRAND;
    public static final String sYH = (Build.MODEL + Build.CPU_ABI);
    public static String sYI = ("android-" + VERSION.SDK_INT);
    public static final String sYJ = ("android-" + Build.MANUFACTURER);
    public static String sYK = (VERSION.SDK_INT);
    public static final String sYL = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static long sYM = 0;
    public static int sYN;
    public static boolean sYO = bHf();
    public static boolean sYP = bHe();
    public static boolean sYQ = bHd();
    public static boolean sYR = bHc();
    public static int sYS = 5;
    public static final byte[] sYT = null;
    public static final byte[] sYU = null;
    public static final byte[] sYV = null;

    public static void xW(int i) {
        sYN = i;
        sYQ = bHd();
        sYR = bHc();
        sYO = bHf();
        sYP = bHe();
    }

    static {
        sYN = Integer.decode("0x26050D40").intValue();
        try {
            int i = ab.getContext().getPackageManager().getApplicationInfo(ab.getPackageName(), FileUtils.S_IWUSR).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
            if (i > sYN && i - sYN < 255 && (i & 255) >= 48) {
                sYN = i;
            }
        } catch (Exception e) {
            w.h("MicroMsg.ConstantsProtocal", "", e);
        }
    }

    private static boolean bHc() {
        return (sYN & 255) >= 32 && (sYN & 255) <= 47;
    }

    private static boolean bHd() {
        return (sYN & 255) >= 0 && (sYN & 255) <= 31;
    }

    private static boolean bHe() {
        return (sYN & 255) >= 96 && (sYN & 255) <= JsApiGetBackgroundAudioState.CTRL_INDEX;
    }

    private static boolean bHf() {
        return (sYN & 255) >= 48 && (sYN & 255) <= 95;
    }
}
