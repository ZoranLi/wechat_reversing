package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;

public final class h extends ab {
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    public final boolean eX(int i) {
        return i != 0 && i < 620758015;
    }

    public final void transfer(int i) {
        w.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", Integer.valueOf(i));
        ap.yY();
        g wO = c.wO();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username from rconversation");
        stringBuilder.append(" where flag & 4611686018427387904").append(" != 0");
        w.d("MicroMsg.App.SyncTopConversation", "sql:%s", stringBuilder);
        Cursor a = wO.a(stringBuilder.toString(), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                w.v("MicroMsg.App.SyncTopConversation", "userName %s", a.getString(0));
                o.l(r1, false);
            }
            a.close();
        }
    }
}
