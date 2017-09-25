package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.e.a.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tinkerboots.sdk.a;

public final class f extends c<e> {
    private static long aQq = 0;

    public f() {
        this.usg = e.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((e) bVar).fCm.fCn || ap.yQ())) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - aQq < 21600000) {
                w.d("MicroMsg.Tinker.TinkerBootsActivateListener", "wait for next time. will check after %d second", new Object[]{Long.valueOf((21600000 - (currentTimeMillis - aQq)) / 1000)});
            } else if (a.chU() != null) {
                a.chU().mm(false);
                w.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
                aQq = currentTimeMillis;
            }
        }
        return false;
    }

    public static void cp(long j) {
        aQq = j;
    }
}
