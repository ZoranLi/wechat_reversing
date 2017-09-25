package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.biz.b;
import com.tencent.mm.sdk.platformtools.bg;

public final class c implements j {
    public final boolean MM(String str) {
        return e.dr(str);
    }

    public final Object MN(String str) {
        Object iD = w.DL().iD(str);
        if (iD != null && !bg.mA(iD.field_userId) && iD.field_userId.equals(str)) {
            return iD;
        }
        j jVar = new j();
        jVar.field_userId = str;
        return jVar;
    }

    public final com.tencent.mm.ah.a.a.c MO(String str) {
        a aVar = new a();
        aVar.hIO = com.tencent.mm.modelbiz.a.e.iA(str);
        aVar.hIL = true;
        aVar.hJh = true;
        aVar.hJa = b.a.bes;
        return aVar.Hg();
    }

    public final String bp(Object obj) {
        return ((j) obj).field_userName;
    }

    public final String bq(Object obj) {
        return ((j) obj).field_headImageUrl;
    }

    public final String br(Object obj) {
        return ((j) obj).field_userId;
    }
}
