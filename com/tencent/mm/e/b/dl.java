package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl extends c {
    private static final int gGf = "bulletin_scene".hashCode();
    private static final int gGg = "bulletin_content".hashCode();
    private static final int gGh = "bulletin_url".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    public String field_bulletin_content;
    public String field_bulletin_scene;
    public String field_bulletin_url;
    private boolean gGc = true;
    private boolean gGd = true;
    private boolean gGe = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gGf == hashCode) {
                    this.field_bulletin_scene = cursor.getString(i);
                    this.gGc = true;
                } else if (gGg == hashCode) {
                    this.field_bulletin_content = cursor.getString(i);
                } else if (gGh == hashCode) {
                    this.field_bulletin_url = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gGc) {
            contentValues.put("bulletin_scene", this.field_bulletin_scene);
        }
        if (this.gGd) {
            contentValues.put("bulletin_content", this.field_bulletin_content);
        }
        if (this.gGe) {
            contentValues.put("bulletin_url", this.field_bulletin_url);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
