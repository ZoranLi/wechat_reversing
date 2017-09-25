package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.w;

public final class i extends com.tencent.mm.sdk.e.i<ab> {
    public static final String[] gUx = new String[]{com.tencent.mm.sdk.e.i.a(ab.gTP, "WalletRegionGreyAreaList")};
    private e gUz;

    public i(e eVar) {
        super(eVar, ab.gTP, "WalletRegionGreyAreaList", null);
        this.gUz = eVar;
    }

    public final void a(int i, apq com_tencent_mm_protocal_c_apq) {
        c abVar = new ab();
        abVar.field_wallet_region = i;
        try {
            abVar.field_wallet_grey_item_buf = com_tencent_mm_protocal_c_apq.toByteArray();
        } catch (Exception e) {
            w.e("MicroMsg.WalletRegionGreyItemStg", "setWalletRegionGreyItem error " + e.getMessage());
        }
        super.a(abVar);
    }

    public final ab vz(int i) {
        String str = "select * from WalletRegionGreyAreaList where wallet_region = " + i;
        Cursor a = this.gUz.a(str, null, 2);
        w.i("MicroMsg.WalletRegionGreyItemStg", "getWalletRegionGreyItem " + str);
        if (a == null) {
            return new ab();
        }
        ab abVar = new ab();
        if (a.moveToNext()) {
            abVar = new ab();
            abVar.b(a);
        }
        w.i("MicroMsg.WalletRegionGreyItemStg", "get grey item ");
        a.close();
        return abVar;
    }
}
