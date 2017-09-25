package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import java.util.LinkedList;
import java.util.List;

public final class c extends ab {
    public final boolean eX(int i) {
        return i != 0 && i < 620757033;
    }

    public final void transfer(int i) {
        w.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 620757033) {
            List<String> linkedList = new LinkedList();
            ap.yY();
            Cursor d = com.tencent.mm.u.c.wR().d("@black.android", "", null);
            if (d != null) {
                d.moveToFirst();
                while (!d.isAfterLast()) {
                    af xVar = new x();
                    xVar.b(d);
                    linkedList.add(xVar.field_username);
                    d.moveToNext();
                }
                d.close();
            }
            if (linkedList.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Update rconversation");
                stringBuilder.append(" set parentRef = '@blacklist").append("' where 1 != 1 ");
                for (String append : linkedList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                w.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", stringBuilder.toString());
                ap.yY();
                com.tencent.mm.u.c.wO().eE("rconversation", append);
            }
        }
    }

    public final String getTag() {
        return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
    }
}
