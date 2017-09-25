package com.tencent.mm.plugin.messenger.a;

import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public static c nyj;

    public static c aJW() {
        if (nyj == null) {
            nyj = new b();
        }
        if (nyj instanceof b) {
            w.w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
        }
        return nyj;
    }
}
