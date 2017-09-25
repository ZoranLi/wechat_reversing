package com.tencent.mm.modelsns;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static int hTF = 0;
    public static c hTG = new c();

    public static void JF() {
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100024");
        w.i("MicroMsg.StatisticsOplogAbTest", "test " + dX.field_rawXML + " " + dX.isValid());
        if (dX.isValid()) {
            hTF = bg.PY((String) dX.bKK().get("Switch"));
            w.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + hTF);
        }
    }
}
