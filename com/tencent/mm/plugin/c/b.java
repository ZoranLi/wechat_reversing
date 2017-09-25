package com.tencent.mm.plugin.c;

import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.bf;

public final class b {
    public static void hi(int i) {
        if (i > 0) {
            bf.zK();
            bf.zK();
            if (i == 20) {
                ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putInt("reg_style_id", i).commit();
            }
        }
    }

    private static int FB() {
        return ab.getContext().getSharedPreferences(ab.bIX(), 0).getInt("reg_style_id", 0);
    }

    public static void mM(String str) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putString("reg_last_exit_ui", str).commit();
    }

    public static String Oz() {
        return ab.getContext().getSharedPreferences(ab.bIX(), 0).getString("reg_last_exit_ui", "");
    }

    public static void mN(String str) {
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putString("reg_next_enter_ui", str).commit();
    }

    public static void mO(String str) {
        c.oTb.a(10645, str + "," + FB() + "," + bg.Nz() + "," + Oz(), true, true);
    }

    public static void b(boolean z, String str) {
        String str2;
        if (z) {
            str2 = str + "," + FB() + "," + bg.Nz() + "," + Oz();
        } else {
            str2 = str + "," + FB() + "," + bg.Nz() + "," + ab.getContext().getSharedPreferences(ab.bIX(), 0).getString("reg_next_enter_ui", "");
        }
        c.oTb.a(10645, str2, true, true);
    }
}
