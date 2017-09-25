package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bu extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int guv = "wechatUsername".hashCode();
    private static final int guw = "systemAddressBookUsername".hashCode();
    private static final int gux = "contactId".hashCode();
    private static final int guy = "sortKey".hashCode();
    public String field_contactId;
    public String field_sortKey;
    public String field_systemAddressBookUsername;
    public String field_wechatUsername;
    private boolean gur = true;
    private boolean gus = true;
    private boolean gut = true;
    private boolean guu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guv == hashCode) {
                    this.field_wechatUsername = cursor.getString(i);
                } else if (guw == hashCode) {
                    this.field_systemAddressBookUsername = cursor.getString(i);
                } else if (gux == hashCode) {
                    this.field_contactId = cursor.getString(i);
                } else if (guy == hashCode) {
                    this.field_sortKey = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gur) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.gus) {
            contentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
        }
        if (this.gut) {
            contentValues.put("contactId", this.field_contactId);
        }
        if (this.guu) {
            contentValues.put("sortKey", this.field_sortKey);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
