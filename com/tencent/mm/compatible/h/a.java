package com.tencent.mm.compatible.h;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.t;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private static int gSo = 0;

    public static boolean rX() {
        boolean z = bg.ap(VERSION.INCREMENTAL, "").toLowerCase().contains("flyme") || bg.ap(Build.DISPLAY, "").toLowerCase().contains("flyme");
        if (z) {
            t tVar = p.gRh;
            if (!ab.bJb()) {
                tVar.gRB = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "system_config_prefs", 4).getInt("update_swip_back_status", 0);
            }
            if (tVar.gRB == 1) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
        }
        if (gSo == 0) {
            SharedPreferences bIY = ab.bIY();
            if (bIY == null || !bIY.getBoolean("settings_support_swipe", true)) {
                gSo = 2;
            } else {
                gSo = 1;
            }
        }
        if (gSo == 1) {
            return true;
        }
        return false;
    }

    public static void aE(boolean z) {
        SharedPreferences bIY = ab.bIY();
        if (bIY.getBoolean("settings_support_swipe", true) != z) {
            bIY.edit().putBoolean("settings_support_swipe", z).commit();
        }
        w.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(r1), Boolean.valueOf(z));
    }
}
