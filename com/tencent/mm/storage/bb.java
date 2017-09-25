package com.tencent.mm.storage;

import com.tencent.mm.e.b.df;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bb extends df {
    protected static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "encryptUsername";
        aVar.uxd.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "encryptUsername";
        aVar.columns[1] = "conRemark";
        aVar.uxd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactLabels";
        aVar.uxd.put("contactLabels", "TEXT default '' ");
        stringBuilder.append(" contactLabels TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "conDescription";
        aVar.uxd.put("conDescription", "TEXT default '' ");
        stringBuilder.append(" conDescription TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "conPhone";
        aVar.uxd.put("conPhone", "TEXT default '' ");
        stringBuilder.append(" conPhone TEXT default '' ");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public bb(String str) {
        this();
        this.field_conRemark = "";
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
    }

    public bb(String str, String str2) {
        this();
        if (str == null) {
            str = "";
        }
        this.field_encryptUsername = str;
        if (str2 == null) {
            str2 = "";
        }
        this.field_conRemark = str2;
    }

    public bb() {
        this.field_encryptUsername = "";
        this.field_conRemark = "";
    }

    protected final Object clone() {
        return super.clone();
    }
}
