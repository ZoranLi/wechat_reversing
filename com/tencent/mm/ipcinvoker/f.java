package com.tencent.mm.ipcinvoker;

import com.tencent.mm.sdk.platformtools.w;

public final class f {
    public static void dT(final String str) {
        if (!dV(str)) {
            m.post(new Runnable() {
                public final void run() {
                    b un = b.un();
                    String str = str;
                    if (d.dS(str)) {
                        w.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", str);
                        return;
                    }
                    un.dQ(str);
                }
            });
        }
    }

    public static void dU(final String str) {
        if (!dV(str)) {
            m.post(new Runnable() {
                public final void run() {
                    b.un().dR(str);
                }
            });
        }
    }

    public static boolean dV(String str) {
        b un = b.un();
        if (d.dS(str)) {
            w.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", str);
        } else if (un.gVE.get(str) != null) {
            return true;
        }
        return false;
    }
}
