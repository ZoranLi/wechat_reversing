package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class SandBoxProfile extends e {
    public static final String fwe = (ab.getPackageName() + ":sandbox");

    public final void onCreate() {
        c ao = c.ao(ab.getContext());
        k.setupBrokenLibraryHandler();
        k.b(a.urP, SandBoxProfile.class.getClassLoader());
        k.b("MMProtocalJni", SandBoxProfile.class.getClassLoader());
        MMProtocalJni.setClientPackVersion(d.sYN);
        u uVar = new u(ao);
        try {
            uVar.cR("SANDBOX");
            r.iiL = bg.b(uVar.cS(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            w.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + r.iiL);
        } catch (Error e) {
        }
        m.a(this.app);
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return fwe;
    }
}
