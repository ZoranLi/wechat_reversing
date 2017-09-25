package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class bg extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int glS = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int grD = "protocolNumber".hashCode();
    private static final int grE = "logContent".hashCode();
    public long field_createTime;
    public String field_id;
    public String field_logContent;
    public int field_protocolNumber;
    private boolean gbB = true;
    private boolean glP = true;
    private boolean grB = true;
    private boolean grC = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glS == hashCode) {
                    this.field_id = cursor.getString(i);
                    this.glP = true;
                } else if (grD == hashCode) {
                    this.field_protocolNumber = cursor.getInt(i);
                } else if (grE == hashCode) {
                    this.field_logContent = cursor.getString(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.glP) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, this.field_id);
        }
        if (this.grB) {
            contentValues.put("protocolNumber", Integer.valueOf(this.field_protocolNumber));
        }
        if (this.grC) {
            contentValues.put("logContent", this.field_logContent);
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
