package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class f extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbV = "userName".hashCode();
    private static final int gcs = "scene".hashCode();
    private static final int gct = "ticket".hashCode();
    public int field_scene;
    public String field_ticket;
    public String field_userName;
    private boolean gbz = true;
    private boolean gcq = true;
    private boolean gcr = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.uxd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "scene";
        aVar.uxd.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "ticket";
        aVar.uxd.put("ticket", "TEXT");
        stringBuilder.append(" ticket TEXT");
        aVar.columns[3] = "rowid";
        aVar.uxe = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (gcs == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gct == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gbz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.gcq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.gcr) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
