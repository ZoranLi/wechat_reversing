package com.tencent.mm.t;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.t.f.a;
import java.util.Map;

public final class j {
    public int hko;
    public int hkp;

    public static final j eo(String str) {
        j jVar = new j();
        a B = a.B(str, null);
        if (B != null) {
            Map map = B.hjZ;
            if (map != null) {
                jVar.hko = bg.getInt((String) map.get(".msg.appmsg.xmlfulllen"), 0);
                jVar.hkp = bg.getInt((String) map.get(".msg.appmsg.realinnertype"), 0);
            }
        }
        return jVar;
    }
}
