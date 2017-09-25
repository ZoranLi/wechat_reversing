package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class au extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int geK = "modifyTime".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int goi = "prodcutID".hashCode();
    private static final int goj = "totalCount".hashCode();
    private static final int gok = "continuCount".hashCode();
    private static final int gol = "showTipsTime".hashCode();
    private static final int gom = "setFlagTime".hashCode();
    public int field_continuCount;
    public int field_flag;
    public long field_modifyTime;
    public String field_prodcutID;
    public long field_setFlagTime;
    public long field_showTipsTime;
    public int field_totalCount;
    private boolean geo = true;
    private boolean gfG = true;
    private boolean god = true;
    private boolean goe = true;
    private boolean gof = true;
    private boolean gog = true;
    private boolean goh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (goi == hashCode) {
                    this.field_prodcutID = cursor.getString(i);
                    this.god = true;
                } else if (goj == hashCode) {
                    this.field_totalCount = cursor.getInt(i);
                } else if (gok == hashCode) {
                    this.field_continuCount = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (geK == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (gol == hashCode) {
                    this.field_showTipsTime = cursor.getLong(i);
                } else if (gom == hashCode) {
                    this.field_setFlagTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.god) {
            contentValues.put("prodcutID", this.field_prodcutID);
        }
        if (this.goe) {
            contentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
        }
        if (this.gof) {
            contentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
        }
        if (this.gfG) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.geo) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.gog) {
            contentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
        }
        if (this.goh) {
            contentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
