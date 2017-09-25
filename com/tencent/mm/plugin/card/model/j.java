package com.tencent.mm.plugin.card.model;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class j extends i<i> {
    public static final String[] gUx = new String[]{i.a(i.gTP, "CardQrCodeConfi")};
    private e gUz;

    public j(e eVar) {
        super(eVar, i.gTP, "CardQrCodeConfi", null);
        this.gUz = eVar;
    }

    public final i ss(String str) {
        c iVar = new i();
        iVar.field_card_id = str;
        return b(iVar, new String[0]) ? iVar : null;
    }
}
