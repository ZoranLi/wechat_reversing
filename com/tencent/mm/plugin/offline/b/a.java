package com.tencent.mm.plugin.offline.b;

import android.database.Cursor;
import com.tencent.mm.plugin.offline.a.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends i<q> {
    public static final String[] gUx = new String[]{i.a(q.gTP, "OfflineOrderStatus")};
    public e gUz;

    public a(e eVar) {
        super(eVar, q.gTP, "OfflineOrderStatus", null);
        this.gUz = eVar;
    }

    public final q aQl() {
        q qVar = null;
        Cursor a = this.gUz.a("SELECT * FROM OfflineOrderStatus WHERE status!=-1 ORDER BY rowid DESC LIMIT 1", null, 2);
        if (a == null) {
            a.close();
        } else {
            a.moveToFirst();
            if ((!a.isAfterLast() ? 1 : null) != null) {
                qVar = new q();
                qVar.b(a);
            }
            a.close();
            if (qVar != null) {
                w.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder status = " + qVar.field_status);
            } else {
                w.i("MicroMsg.OfflineOrderStatusStorage", "getLastestOrder null");
            }
        }
        return qVar;
    }

    public final q BX(String str) {
        q qVar = null;
        Cursor a = this.gUz.a("select * from OfflineOrderStatus where reqkey=?", new String[]{str}, 2);
        if (a == null) {
            a.close();
        } else {
            a.moveToFirst();
            w.d("MicroMsg.OfflineOrderStatusStorage", "cursor.isAfterLast() = " + a.isAfterLast());
            if (!a.isAfterLast()) {
                qVar = new q();
                qVar.b(a);
            }
            a.close();
        }
        return qVar;
    }

    public final void a(q qVar) {
        int i = 1;
        Cursor a = this.gUz.a("select * from OfflineOrderStatus where reqkey=?", new String[]{qVar.field_reqkey}, 2);
        if (a == null) {
            a.close();
            i = 0;
        } else {
            a.moveToFirst();
            if (a.isAfterLast()) {
                i = 0;
            }
            a.close();
        }
        if (i == 0) {
            b(qVar);
        } else {
            c(qVar, new String[0]);
        }
    }

    public final void BY(String str) {
        q BX = BX(str);
        if (BX != null) {
            BX.field_status = -1;
        } else {
            BX = new q();
            BX.field_reqkey = str;
            BX.field_status = -1;
        }
        a(BX);
    }
}
