package com.tencent.mm.plugin.remittance.c;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class n {
    public static void Dw(String str) {
        if (!bg.mA(str)) {
            String aXe = aXe();
            w.d("Micromsg.RemittanceLogic", "cur friendsListStr=" + aXe);
            StringBuilder stringBuilder = new StringBuilder();
            if (!bg.mA(aXe)) {
                String[] split = aXe.split(",");
                if (split != null) {
                    int i = 0;
                    for (int i2 = 0; i2 < split.length; i2++) {
                        if (!str.equals(split[i2])) {
                            stringBuilder.append(split[i2]);
                            stringBuilder.append(",");
                            i++;
                            if (i >= 4) {
                                break;
                            }
                        }
                    }
                }
            }
            stringBuilder.insert(0, ",");
            stringBuilder.insert(0, str);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            w.d("Micromsg.RemittanceLogic", "new friendsListStr=" + stringBuilder.toString());
            ap.yY();
            c.vr().set(327733, stringBuilder.toString());
            ap.yY();
            c.vr().jY(true);
        }
    }

    public static String aXe() {
        ap.yY();
        return bg.mz((String) c.vr().get(327733, null));
    }
}
