package com.tencent.mm.plugin.i;

import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends c {
    public final void execute(com.tencent.mm.kernel.b.e eVar) {
        int rl = l.rl();
        if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            w.i("MicroMsg.SightInitTask", "load wechatsight_v7a, core number[%d]", Integer.valueOf(rl >> 12));
            k.b("wechatsight_v7a", getClass().getClassLoader());
            if ((rl >> 12) >= 4) {
                b.ptx = 3;
                b.ptz = 3;
                b.ptA = 544000;
                return;
            }
            b.ptx = 1;
            b.ptz = 1;
            b.ptA = 640000;
            return;
        }
        w.i("MicroMsg.SightInitTask", "load wechatsight");
        k.b("wechatsight", getClass().getClassLoader());
        b.ptx = 1;
        b.ptz = 1;
        b.ptA = 640000;
    }

    public final String name() {
        return "boot-sight-init";
    }
}
