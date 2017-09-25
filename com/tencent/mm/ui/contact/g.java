package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.List;

public final class g {
    static final List<String> cL(List<String> list) {
        List<String> arrayList = new ArrayList();
        ap.yY();
        Cursor b = c.wW().b(o.hlr, (List) list, true, null);
        if (b.moveToFirst()) {
            int i = 0;
            do {
                aj aeVar = new ae();
                aeVar.b(b);
                if (GV(aeVar.field_username)) {
                    arrayList.add(aeVar.field_username);
                    i++;
                    if (i >= 4) {
                        break;
                    }
                }
            } while (b.moveToNext());
        }
        b.close();
        return arrayList;
    }

    private static final boolean GV(String str) {
        for (Object equals : o.hly) {
            if (str.equals(equals)) {
                return false;
            }
        }
        if (o.dH(str) || o.eV(str)) {
            return false;
        }
        return true;
    }
}
