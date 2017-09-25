package com.tencent.mm.wallet_core.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class m {
    private static long kho = 0;
    private static String rEK = "";
    private static String wEh = "";

    public static void setTimeStamp(String str) {
        rEK = str;
        kho = System.currentTimeMillis() / 1000;
        wEh = bg.bJZ().toString();
    }

    public static boolean cca() {
        long az = bg.az(kho);
        w.d("MicroMsg.TimeStampHelper", "pass time " + az);
        return az > 300;
    }

    public static String ccb() {
        if (bg.mA(rEK)) {
            w.i("MicroMsg.TimeStampHelper", "getTimeStamp is null from %s isOverdue %s update_time: %s", new Object[]{wEh, Boolean.valueOf(cca()), Long.valueOf(kho)});
        }
        return rEK;
    }
}
