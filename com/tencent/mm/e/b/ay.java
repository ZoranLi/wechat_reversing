package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class ay extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbj = Columns.VALUE.hashCode();
    private static final int gpk = "configId".hashCode();
    public int field_configId;
    public String field_value;
    private boolean gbb = true;
    private boolean gpj = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "configId";
        aVar.uxd.put("configId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" configId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "configId";
        aVar.columns[1] = Columns.VALUE;
        aVar.uxd.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpk == hashCode) {
                    this.field_configId = cursor.getInt(i);
                    this.gpj = true;
                } else if (gbj == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gpj) {
            contentValues.put("configId", Integer.valueOf(this.field_configId));
        }
        if (this.gbb) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
