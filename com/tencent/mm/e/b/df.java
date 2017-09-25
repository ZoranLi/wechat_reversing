package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df extends c {
    private static final int gDV = "contactLabels".hashCode();
    private static final int gDW = "conDescription".hashCode();
    private static final int gDX = "conPhone".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gkc = "conRemark".hashCode();
    private static final int gkm = "encryptUsername".hashCode();
    public String field_conDescription;
    public String field_conPhone;
    public String field_conRemark;
    public String field_contactLabels;
    public String field_encryptUsername;
    private boolean gDS = true;
    private boolean gDT = true;
    private boolean gDU = true;
    private boolean gjN = true;
    private boolean gjX = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gkm == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                    this.gjX = true;
                } else if (gkc == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (gDV == hashCode) {
                    this.field_contactLabels = cursor.getString(i);
                } else if (gDW == hashCode) {
                    this.field_conDescription = cursor.getString(i);
                } else if (gDX == hashCode) {
                    this.field_conPhone = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.gjX) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.gjN) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_contactLabels == null) {
            this.field_contactLabels = "";
        }
        if (this.gDS) {
            contentValues.put("contactLabels", this.field_contactLabels);
        }
        if (this.field_conDescription == null) {
            this.field_conDescription = "";
        }
        if (this.gDT) {
            contentValues.put("conDescription", this.field_conDescription);
        }
        if (this.field_conPhone == null) {
            this.field_conPhone = "";
        }
        if (this.gDU) {
            contentValues.put("conPhone", this.field_conPhone);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
