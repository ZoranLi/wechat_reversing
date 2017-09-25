package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class ds extends c {
    private static final int gHD = "occupation".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    public String field_appId;
    public long field_occupation;
    private boolean gHC = true;
    private boolean gcu = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.uxd.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "appId";
        aVar.columns[1] = "occupation";
        aVar.uxd.put("occupation", "LONG");
        stringBuilder.append(" occupation LONG");
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
                if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.gcu = true;
                } else if (gHD == hashCode) {
                    this.field_occupation = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gHC) {
            contentValues.put("occupation", Long.valueOf(this.field_occupation));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
