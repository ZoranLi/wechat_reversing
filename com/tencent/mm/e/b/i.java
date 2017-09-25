package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class i extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdd = "key".hashCode();
    private static final int gdh = SlookAirButtonFrequentContactAdapter.DATA.hashCode();
    private static final int gdi = "dataType".hashCode();
    private static final int gdj = "size".hashCode();
    public String field_data;
    public String field_dataType;
    public String field_key;
    public int field_size;
    private boolean gdc = true;
    private boolean gde = true;
    private boolean gdf = true;
    private boolean gdg = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdd == hashCode) {
                    this.field_key = cursor.getString(i);
                    this.gdc = true;
                } else if (gdh == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (gdi == hashCode) {
                    this.field_dataType = cursor.getString(i);
                } else if (gdj == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gdc) {
            contentValues.put("key", this.field_key);
        }
        if (this.gde) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, this.field_data);
        }
        if (this.gdf) {
            contentValues.put("dataType", this.field_dataType);
        }
        if (this.gdg) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
