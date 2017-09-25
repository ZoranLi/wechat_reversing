package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;

public final class e extends i<r> {
    public static final String[] gUx = new String[]{i.a(r.gTP, "WalletFunciontList")};
    public com.tencent.mm.sdk.e.e gUz;

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, r.gTP, "WalletFunciontList", null);
        this.gUz = eVar;
    }

    public final void b(int i, String str, String str2, String str3, String str4) {
        c rVar = new r();
        rVar.field_wallet_region = i;
        rVar.field_function_list = str;
        rVar.field_new_list = str2;
        rVar.field_banner_list = str3;
        rVar.field_type_name_list = str4;
        super.a(rVar);
    }
}
