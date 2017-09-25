package com.tencent.mm.plugin.wallet_core.c;

import android.database.Cursor;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c extends i<Bankcard> {
    public static final String[] gUx = new String[]{i.a(Bankcard.gTP, "WalletBankcard")};
    public e gUz;
    private List<Object> hDb = new LinkedList();

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        if (!super.a((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.hDb.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final /* synthetic */ boolean b(com.tencent.mm.sdk.e.c cVar) {
        return d((Bankcard) cVar);
    }

    public final /* synthetic */ boolean c(com.tencent.mm.sdk.e.c cVar, String[] strArr) {
        if (!super.c((Bankcard) cVar, strArr)) {
            return false;
        }
        Iterator it = this.hDb.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public c(e eVar) {
        super(eVar, Bankcard.gTP, "WalletBankcard", null);
        this.gUz = eVar;
    }

    public final ArrayList<Bankcard> buw() {
        ArrayList<Bankcard> arrayList = null;
        Cursor a = this.gUz.a("select * from WalletBankcard where cardType <= 7", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.b(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }

    public final ArrayList<Bankcard> buJ() {
        ArrayList<Bankcard> arrayList = null;
        Cursor a = this.gUz.a("select * from WalletBankcard where cardType & " + Bankcard.rDY + " != 0 ", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    Bankcard bankcard = new Bankcard();
                    bankcard.b(a);
                    arrayList.add(bankcard);
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }

    public final boolean bJ(List<Bankcard> list) {
        for (Bankcard b : list) {
            super.b(b);
        }
        Iterator it = this.hDb.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }

    public final boolean d(Bankcard bankcard) {
        if (!super.b(bankcard)) {
            return false;
        }
        Iterator it = this.hDb.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return true;
    }
}
