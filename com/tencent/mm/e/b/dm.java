package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dm extends c {
    private static final int gGn = "wallet_region".hashCode();
    private static final int gGo = "function_list".hashCode();
    private static final int gGp = "new_list".hashCode();
    private static final int gGq = "banner_list".hashCode();
    private static final int gGr = "type_name_list".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    public String field_banner_list;
    public String field_function_list;
    public String field_new_list;
    public String field_type_name_list;
    public int field_wallet_region;
    private boolean gGi = true;
    private boolean gGj = true;
    private boolean gGk = true;
    private boolean gGl = true;
    private boolean gGm = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gGn == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.gGi = true;
                } else if (gGo == hashCode) {
                    this.field_function_list = cursor.getString(i);
                } else if (gGp == hashCode) {
                    this.field_new_list = cursor.getString(i);
                } else if (gGq == hashCode) {
                    this.field_banner_list = cursor.getString(i);
                } else if (gGr == hashCode) {
                    this.field_type_name_list = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gGi) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.gGj) {
            contentValues.put("function_list", this.field_function_list);
        }
        if (this.gGk) {
            contentValues.put("new_list", this.field_new_list);
        }
        if (this.gGl) {
            contentValues.put("banner_list", this.field_banner_list);
        }
        if (this.gGm) {
            contentValues.put("type_name_list", this.field_type_name_list);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
