package com.tencent.mm.booter;

import com.tencent.mm.a.h;
import com.tencent.mm.i.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class j {
    public static void run() {
        int i = g.sV().getInt("EnableForgroundService", 0);
        ap.yY();
        int aw = h.aw(c.uH(), 101);
        boolean z = b.bIu() || (i > 0 && aw >= 0 && aw <= i);
        if (!z) {
            z = d.sYQ;
        }
        if (!z) {
            z = b.bIu();
        }
        if (f.fuV == 1) {
            z = false;
        }
        ab.getContext().getSharedPreferences("system_config_prefs", 0).edit().putBoolean("set_service", z).commit();
        w.i("MicroMsg.PostTaskSetPushForegroundService", "Set service, userHash:%d, prob:%d, enabled: %b  isalpha:%b channel:%d", Integer.valueOf(aw), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(d.sYQ), Integer.valueOf(f.fuV));
    }
}
