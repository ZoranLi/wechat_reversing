package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class h extends i<g> {
    public static final String[] gUx = new String[]{i.a(g.gTP, "CardMsgInfo")};
    public e gUz;

    public h(e eVar) {
        super(eVar, g.gTP, "CardMsgInfo", null);
        this.gUz = eVar;
    }

    public final Cursor Kk() {
        return this.gUz.rawQuery("select * from CardMsgInfo order by time desc", null);
    }

    public final int Kr() {
        int i = 0;
        Cursor a = this.gUz.a(" select count(*) from CardMsgInfo where read_state = ? ", new String[]{"1"}, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final boolean afV() {
        return this.gUz.eE("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
    }
}
