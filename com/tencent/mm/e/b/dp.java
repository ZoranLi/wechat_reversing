package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dp extends c {
    private static final int gGQ = "pref_key".hashCode();
    private static final int gGR = "pref_title".hashCode();
    private static final int gGS = "pref_url".hashCode();
    private static final int gGT = "is_show".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    public int field_is_show;
    public String field_pref_key;
    public String field_pref_title;
    public String field_pref_url;
    private boolean gGM = true;
    private boolean gGN = true;
    private boolean gGO = true;
    private boolean gGP = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gGQ == hashCode) {
                    this.field_pref_key = cursor.getString(i);
                    this.gGM = true;
                } else if (gGR == hashCode) {
                    this.field_pref_title = cursor.getString(i);
                } else if (gGS == hashCode) {
                    this.field_pref_url = cursor.getString(i);
                } else if (gGT == hashCode) {
                    this.field_is_show = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gGM) {
            contentValues.put("pref_key", this.field_pref_key);
        }
        if (this.gGN) {
            contentValues.put("pref_title", this.field_pref_title);
        }
        if (this.gGO) {
            contentValues.put("pref_url", this.field_pref_url);
        }
        if (this.gGP) {
            contentValues.put("is_show", Integer.valueOf(this.field_is_show));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
