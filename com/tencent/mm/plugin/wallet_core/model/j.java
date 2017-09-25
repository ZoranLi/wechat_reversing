package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.cd;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends cd {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "title";
        aVar.uxd.put("title", "TEXT PRIMARY KEY ");
        stringBuilder.append(" title TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "title";
        aVar.columns[1] = "loan_jump_url";
        aVar.uxd.put("loan_jump_url", "TEXT");
        stringBuilder.append(" loan_jump_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "red_dot_index";
        aVar.uxd.put("red_dot_index", "INTEGER");
        stringBuilder.append(" red_dot_index INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show_entry";
        aVar.uxd.put("is_show_entry", "INTEGER");
        stringBuilder.append(" is_show_entry INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "tips";
        aVar.uxd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "is_overdue";
        aVar.uxd.put("is_overdue", "INTEGER");
        stringBuilder.append(" is_overdue INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "available_otb";
        aVar.uxd.put("available_otb", "TEXT");
        stringBuilder.append(" available_otb TEXT");
        aVar.columns[7] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }
}
