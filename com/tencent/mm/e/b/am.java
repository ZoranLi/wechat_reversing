package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class am extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gdh = SlookAirButtonFrequentContactAdapter.DATA.hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int glS = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int glT = "cacheKey".hashCode();
    private static final int glU = "interval".hashCode();
    public String field_appId;
    public String field_cacheKey;
    public String field_data;
    public String field_id;
    public int field_interval;
    public long field_updateTime;
    private boolean gcu = true;
    private boolean gde = true;
    private boolean gdn = true;
    private boolean glP = true;
    private boolean glQ = true;
    private boolean glR = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glS == hashCode) {
                    this.field_id = cursor.getString(i);
                } else if (glT == hashCode) {
                    this.field_cacheKey = cursor.getString(i);
                } else if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gdh == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (glU == hashCode) {
                    this.field_interval = cursor.getInt(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
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
        if (this.glQ) {
            contentValues.put("cacheKey", this.field_cacheKey);
        }
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gde) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, this.field_data);
        }
        if (this.glR) {
            contentValues.put("interval", Integer.valueOf(this.field_interval));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
