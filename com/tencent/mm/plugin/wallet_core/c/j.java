package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j extends i<ae> {
    public static final String[] gUx = new String[]{i.a(ae.gTP, "WalletUserInfo")};
    public e gUz;
    private List<Object> hDb = new LinkedList();

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        if (!super.a((ae) cVar, strArr)) {
            return false;
        }
        Iterator it = this.hDb.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((ae) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        if (!super.c((ae) cVar, strArr)) {
            return false;
        }
        Iterator it = this.hDb.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public j(e eVar) {
        super(eVar, ae.gTP, "WalletUserInfo", null);
        this.gUz = eVar;
    }

    public final ae buL() {
        ae aeVar = new ae();
        Cursor a = this.gUz.a("select * from WalletUserInfo", null, 2);
        aeVar.field_is_reg = -1;
        if (a != null) {
            if (a.moveToNext()) {
                aeVar.b(a);
            }
            a.close();
        }
        return aeVar;
    }

    public final boolean a(ae aeVar) {
        if (!super.b(aeVar)) {
            return false;
        }
        Iterator it = this.hDb.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
