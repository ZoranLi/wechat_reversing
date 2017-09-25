package com.tencent.mm.modelcontrol;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class b {
    public static boolean iT(String str) {
        if (bg.mA(str)) {
            return false;
        }
        try {
            String[] split = new SimpleDateFormat("HH:mm").format(new Date()).split(":");
            int PY = (bg.PY(split[1]) + (bg.PY(split[0]) * 60)) - ((((int) Eq()) - 8) * 60);
            int i = PY < 0 ? PY + 1440 : PY >= 1440 ? PY - 1440 : PY;
            String[] split2 = str.split(";");
            for (String split3 : split2) {
                String[] split4 = split3.split("-");
                String[] split5 = split4[0].split(":");
                int PY2 = bg.PY(split5[1]) + (bg.PY(split5[0]) * 60);
                split4 = split4[1].split(":");
                int PY3 = bg.PY(split4[1]) + (bg.PY(split4[0]) * 60);
                boolean z = PY2 < PY3 ? i < PY3 && i >= PY2 : (i > 1440 || i < PY2) ? i < PY3 && i >= 0 : true;
                if (z) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BusyTimeControlLogic", e, "", new Object[0]);
            w.e("MicroMsg.BusyTimeControlLogic", "checkNeedToControl error : " + e.toString());
            return false;
        }
    }

    public static long Eq() {
        return ((long) ((int) (((long) TimeZone.getDefault().getRawOffset()) / 60000))) / 60;
    }
}
