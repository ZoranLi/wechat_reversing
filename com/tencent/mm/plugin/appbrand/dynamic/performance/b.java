package com.tencent.mm.plugin.appbrand.dynamic.performance;

import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    private static final aj iIm = new aj(new a() {
        public final boolean oQ() {
            BaseIPCService dW = j.uq().dW("com.tencent.mm:support");
            if (dW != null) {
                dW.aO(false);
            }
            return false;
        }
    }, true);

    public static void Sj() {
        if (d.dS("com.tencent.mm:support")) {
            if (com.tencent.mm.plugin.appbrand.dynamic.d.RP().size() != 0) {
                w.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[]{Integer.valueOf(com.tencent.mm.plugin.appbrand.dynamic.d.RP().size())});
                return;
            }
            w.i("MicroMsg.DynamicProcessPerformance", "post delayed to kill the support process.");
            iIm.v(60000, 60000);
            return;
        }
        w.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
    }

    public static void Sk() {
        if (d.dS("com.tencent.mm:support")) {
            w.i("MicroMsg.DynamicProcessPerformance", "kill support process");
            iIm.postDelayed(new Runnable() {
                public final void run() {
                    Process.killProcess(Process.myPid());
                }
            }, 500);
            return;
        }
        w.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the supoort process.");
    }

    public static void Sl() {
        w.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
        e.a("com.tencent.mm:tools", null, c.class, new c() {
            public final void k(Bundle bundle) {
                w.i("MicroMsg.DynamicProcessPerformance", "on kill process tools callback");
                f.dU("com.tencent.mm:tools");
            }
        });
        e.a("com.tencent.mm:support", null, c.class, new c() {
            public final void k(Bundle bundle) {
                w.i("MicroMsg.DynamicProcessPerformance", "on kill process support callback");
                f.dU("com.tencent.mm:support");
            }
        });
    }
}
