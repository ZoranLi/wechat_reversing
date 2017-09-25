package com.tencent.mm.plugin.shake.d.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class o extends i<n> {
    public static final String[] gUx = new String[]{i.a(n.gTP, "shaketvhistory")};
    public static final String[] gaK = new String[0];
    public e gUz;

    public o(e eVar) {
        super(eVar, n.gTP, "shaketvhistory", gUx);
        this.gUz = eVar;
    }

    public final Cursor bbw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM shaketvhistory ORDER BY createtime").append(" DESC");
        return this.gUz.rawQuery(stringBuilder.toString(), null);
    }
}
