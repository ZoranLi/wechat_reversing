package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.pluginsdk.l.a;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static boolean auV() {
        boolean auZ = a.sBC.auZ();
        w.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is " + auZ);
        return auZ;
    }

    public static int a(b bVar, boolean z) {
        return a.sBC.a(bVar, 0, z);
    }

    public static void release() {
        a.sBC.ave();
    }

    public static void abort() {
        a.sBC.avf();
    }

    public static void auW() {
        a.sBC.auW();
    }

    public static boolean auX() {
        return a.sBC.ava();
    }

    public static g auY() {
        return a.sBC.auY();
    }
}
