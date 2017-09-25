package com.tencent.mm.plugin.remittance.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class d extends i<c> {
    public static final String[] gUx = new String[]{i.a(c.gTP, "RemittanceRecord")};
    private static final String[] ioi = new String[]{"*", "rowid"};
    public static Map<String, c> ioj = new HashMap();
    private e gUz;

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        c cVar2 = (c) cVar;
        if (cVar2 != null && ioj.containsKey(cVar2.field_transferId)) {
            ioj.remove(cVar2.field_transferId);
        }
        return super.a(cVar2, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        c cVar2 = (c) cVar;
        if (cVar2 != null && ioj.containsKey(cVar2.field_transferId)) {
            ioj.put(cVar2.field_transferId, cVar2);
        }
        return super.b(cVar2);
    }

    public d(e eVar) {
        super(eVar, c.gTP, "RemittanceRecord", null);
        this.gUz = eVar;
    }

    public final c Dt(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Cursor a = this.gUz.a("RemittanceRecord", ioi, "transferId=?", new String[]{str}, null, null, null, 2);
        c cVar;
        try {
            if (a.moveToFirst()) {
                cVar = new c();
                cVar.b(a);
                return cVar;
            }
            a.close();
            return null;
        } catch (Exception e) {
            cVar = e;
            w.printErrStackTrace("MicroMsg.RemittanceSendRecordStorage", cVar, "getRecordByTransferId error: %s", new Object[]{cVar.getMessage()});
            return null;
        } finally {
            a.close();
        }
    }

    public final boolean a(c cVar) {
        if (cVar != null && ioj.containsKey(cVar.field_transferId)) {
            ioj.put(cVar.field_transferId, cVar);
        }
        return super.a(cVar);
    }
}
