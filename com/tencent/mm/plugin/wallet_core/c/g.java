package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.HashMap;
import java.util.Map;

public final class g extends i<w> {
    public static final String[] gUx = new String[]{i.a(w.gTP, "WalletLuckyMoney")};
    public static Map<String, w> ioj = new HashMap();
    private e gUz;

    public g(e eVar) {
        super(eVar, w.gTP, "WalletLuckyMoney", null);
        this.gUz = eVar;
    }

    public final w If(String str) {
        Cursor rawQuery = this.gUz.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[]{str});
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        w wVar = new w();
        wVar.b(rawQuery);
        rawQuery.close();
        return wVar;
    }

    public final boolean a(w wVar) {
        if (wVar != null && ioj.containsKey(wVar.field_mNativeUrl)) {
            ioj.put(wVar.field_mNativeUrl, wVar);
        }
        return super.a(wVar);
    }
}
