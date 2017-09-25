package com.tencent.mm.plugin.appbrand.dynamic.performance;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.w;

public class c implements a {
    public final void a(Bundle bundle, com.tencent.mm.ipcinvoker.c cVar) {
        BaseIPCService dW = j.uq().dW(d.up());
        if (dW != null) {
            w.i("MicroMsg.IPCInvokeTask_KillAllProcess", "killSelf process(%s)", new Object[]{r0});
            dW.aO(true);
        }
    }
}
