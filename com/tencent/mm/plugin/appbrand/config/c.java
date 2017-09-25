package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;

public final class c extends i<b> {
    public static final String[] iCe = new String[]{i.a(b.izp, "AppBrandCommonKVData")};
    public final e iAL;

    public c(e eVar) {
        super(eVar, b.izp, "AppBrandCommonKVData", null);
        this.iAL = eVar;
    }

    public final boolean aL(String str, String str2) {
        if (bg.mA(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        bVar.field_value = str2;
        if (!bg.mA(bVar.field_value)) {
            return super.a(bVar);
        }
        if (super.a(bVar, new String[0])) {
            return false;
        }
        return true;
    }

    public final String get(String str, String str2) {
        if (bg.mA(str)) {
            return str2;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_key = str;
        if (super.b(bVar, new String[0])) {
            return bVar.field_value;
        }
        return str2;
    }

    public final void oc(String str) {
        super.eE("AppBrandCommonKVData", String.format("delete from %s where %s like '%s%%'", new Object[]{"AppBrandCommonKVData", "key", str}));
    }
}
