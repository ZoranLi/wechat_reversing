package com.tencent.mm.compatible.d;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

public final class t {
    public static boolean gRy = false;
    Map<String, String> gRA = null;
    public int gRB = 0;
    public String gRz = "";

    public final void em(int i) {
        this.gRB = i;
        gRy = true;
        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i);
        edit.commit();
        w.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.gRB));
    }

    public static boolean rQ() {
        if (!gRy) {
            return false;
        }
        gRy = false;
        return true;
    }

    public final void dv(String str) {
        this.gRz = str;
    }

    public final void i(Map<String, String> map) {
        this.gRA = map;
    }
}
