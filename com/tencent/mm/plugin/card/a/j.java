package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.pluginsdk.l.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;

public final class j implements c {
    public final boolean afJ() {
        return l.aiJ();
    }

    public final boolean afK() {
        return l.aiL();
    }

    public final String afL() {
        ap.yY();
        return (String) com.tencent.mm.u.c.vr().get(a.uAF, null);
    }

    public final int afM() {
        int i = 0;
        com.tencent.mm.plugin.card.model.c aga = al.aga();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
        Cursor a = aga.gUz.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        w.i("MicroMsg.CardMgrImpl", "getGiftCardCount:" + i);
        return i;
    }

    public final boolean ko(int i) {
        return l.ko(i);
    }
}
