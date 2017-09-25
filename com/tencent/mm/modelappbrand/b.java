package com.tencent.mm.modelappbrand;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public static String hpQ;
    public static String hpR;

    public static String AK() {
        StringBuilder stringBuilder = new StringBuilder("sid_");
        h.vG();
        hpQ = stringBuilder.append(a.uH()).append("_").append(bg.Nz()).toString();
        w.v("MicroMsg.AppBrandReporter", "refreshWeAppSearchSessionId : %s", new Object[]{hpQ});
        return hpQ;
    }

    public static void gI(String str) {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "pref_appbrand_process", 4);
        String str2 = str + ":start_time";
        Editor edit = sharedPreferences.edit();
        edit.remove(str2);
        edit.commit();
        c.oTb.a(365, 5, 1, false);
        w.v("MicroMsg.AppBrandReporter", "onProcessExit");
    }
}
