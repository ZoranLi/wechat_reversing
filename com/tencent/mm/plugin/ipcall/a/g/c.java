package com.tencent.mm.plugin.ipcall.a.g;

import com.tencent.mm.e.b.bu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;

public final class c extends bu {
    public static a gTP;
    public ArrayList<String> mQW;

    static {
        a aVar = new a();
        aVar.hXH = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wechatUsername";
        aVar.uxd.put("wechatUsername", "TEXT");
        stringBuilder.append(" wechatUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "systemAddressBookUsername";
        aVar.uxd.put("systemAddressBookUsername", "TEXT");
        stringBuilder.append(" systemAddressBookUsername TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "contactId";
        aVar.uxd.put("contactId", "TEXT");
        stringBuilder.append(" contactId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sortKey";
        aVar.uxd.put("sortKey", "TEXT");
        stringBuilder.append(" sortKey TEXT");
        aVar.columns[4] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public static boolean cx(String str, String str2) {
        if (str == null && str2 != null) {
            return false;
        }
        if (str == null || str.equals(str2)) {
            return true;
        }
        return false;
    }
}
