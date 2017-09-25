package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dn extends c {
    private static final int gGA = "wallet_name".hashCode();
    private static final int gGB = "wallet_selected".hashCode();
    private static final int gGC = "wallet_balance".hashCode();
    private static final int gGD = "wallet_tpa_country_mask".hashCode();
    private static final int gGy = "wallet_tpa_country".hashCode();
    private static final int gGz = "wallet_type".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    public int field_wallet_balance;
    public String field_wallet_name;
    public int field_wallet_selected;
    public String field_wallet_tpa_country;
    public int field_wallet_tpa_country_mask;
    public int field_wallet_type;
    private boolean gGs = true;
    private boolean gGt = true;
    private boolean gGu = true;
    private boolean gGv = true;
    private boolean gGw = true;
    private boolean gGx = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gGy == hashCode) {
                    this.field_wallet_tpa_country = cursor.getString(i);
                    this.gGs = true;
                } else if (gGz == hashCode) {
                    this.field_wallet_type = cursor.getInt(i);
                } else if (gGA == hashCode) {
                    this.field_wallet_name = cursor.getString(i);
                } else if (gGB == hashCode) {
                    this.field_wallet_selected = cursor.getInt(i);
                } else if (gGC == hashCode) {
                    this.field_wallet_balance = cursor.getInt(i);
                } else if (gGD == hashCode) {
                    this.field_wallet_tpa_country_mask = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gGs) {
            contentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
        }
        if (this.gGt) {
            contentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
        }
        if (this.gGu) {
            contentValues.put("wallet_name", this.field_wallet_name);
        }
        if (this.gGv) {
            contentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
        }
        if (this.gGw) {
            contentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
        }
        if (this.gGx) {
            contentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
