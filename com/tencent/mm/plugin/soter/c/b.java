package com.tencent.mm.plugin.soter.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.d.a.a;
import com.tencent.d.a.c.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public static c blU() {
        SharedPreferences bIY = ab.bIY();
        if (bIY == null) {
            return new c();
        }
        String string = bIY.getString("cpu_id", "");
        String string2 = bIY.getString("uid", "");
        if (bg.mA(string) || bg.mA(string2)) {
            w.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            g cfF = a.cfF();
            if (cfF != null) {
                string = cfF.qPZ;
                string2 = String.valueOf(cfF.uid);
                if (!(bg.mA(string) || bg.mA(string2))) {
                    dG(string, string2);
                    return new c(string, string2);
                }
            }
            return new c();
        }
        w.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        return new c(string, string2);
    }

    public static void dG(String str, String str2) {
        SharedPreferences bIY = ab.bIY();
        if (bIY != null) {
            w.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
            Editor edit = bIY.edit();
            edit.putString("cpu_id", str);
            edit.putString("uid", str2);
            edit.apply();
        }
    }
}
