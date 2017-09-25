package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class a implements k {
    public static i imv;
    public static h imw;

    public final void a(i iVar) {
        imv = iVar;
    }

    public final void a(h hVar) {
        imw = hVar;
    }

    public static void d(int i, Object obj) {
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "set config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = obj == null ? "null" : obj.toString();
        w.i(str, str2, objArr);
        ap.yY();
        c.vr().set(i, obj);
    }
}
