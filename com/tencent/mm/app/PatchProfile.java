package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.d.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class PatchProfile extends e {
    public static final String fwe = (ab.getPackageName() + ":patch");

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        s sVar = new s(c.ao(this.app.getBaseContext()));
        sVar.cR("PATCH");
        try {
            int intValue = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.xW(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e) {
            w.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            String string = sVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bg.mA(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.sYI = "android-" + string;
                d.sYK = string;
                b.Pb(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.bIv());
            }
        } catch (Exception e2) {
            w.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            intValue = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.sYM).append(" new: ").append(intValue);
            d.sYM = (long) intValue;
        } catch (Exception e3) {
            w.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            boolean b = bg.b(sVar.cS(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean b2 = bg.b(sVar.cS(".com.tencent.mm.debug.report.kvstat"), false);
            boolean b3 = bg.b(sVar.cS(".com.tencent.mm.debug.report.clientpref"), false);
            boolean b4 = bg.b(sVar.cS(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(b, b2, b3, b4);
            new StringBuilder("try control report : debugModel[").append(b).append("],kv[").append(b2).append("], clientPref[").append(b3).append("], useraction[").append(b4).append("]");
        } catch (Exception e4) {
            w.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        a.b(ab.getContext(), true);
        k.bi(fwe);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.urP, PatchProfile.class.getClassLoader());
        m.a(this.app);
        w.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
        com.tencent.mm.bb.d.a("hp", null, null);
        com.tencent.mm.bb.d.o("hp", null);
        w.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return fwe;
    }
}
