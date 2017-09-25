package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;

public final class f extends i<v> {
    public static final String[] gUx = new String[]{i.a(v.gTP, "WalletKindInfo")};
    public e gUz;

    public f(e eVar) {
        super(eVar, v.gTP, "WalletKindInfo", null);
        this.gUz = eVar;
    }

    public final ArrayList<v> buK() {
        ArrayList<v> arrayList = null;
        Cursor a = this.gUz.a("select * from WalletKindInfo", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    v vVar = new v();
                    vVar.b(a);
                    arrayList.add(vVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }
}
