package com.tencent.mm.plugin.emoji.h;

import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.pn;

public final class a {
    public static boolean anw() {
        return h.amc().kLb.bMZ();
    }

    public static boolean d(pn pnVar) {
        return pnVar == null ? false : uR(pnVar.tgW);
    }

    public static boolean b(com.tencent.mm.storage.a.a aVar) {
        return aVar == null ? false : uR(aVar.field_productID);
    }

    public static boolean uR(String str) {
        return str == null ? false : str.equals(aoK());
    }

    public static final String aoK() {
        return com.tencent.mm.storage.a.a.uKQ;
    }
}
