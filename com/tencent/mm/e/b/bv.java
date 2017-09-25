package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bv extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gfD = "title".hashCode();
    private static final int ggs = "msgType".hashCode();
    private static final int goX = "svrId".hashCode();
    private static final int gsq = "isRead".hashCode();
    private static final int guB = "pushTime".hashCode();
    private static final int guC = "descUrl".hashCode();
    public String field_content;
    public String field_descUrl;
    public short field_isRead;
    public int field_msgType;
    public long field_pushTime;
    public long field_svrId;
    public String field_title;
    private boolean gbJ = true;
    private boolean gfz = true;
    private boolean gge = true;
    private boolean goU = true;
    private boolean gsh = true;
    private boolean guA = true;
    private boolean guz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (goX == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                    this.goU = true;
                } else if (gsq == hashCode) {
                    this.field_isRead = cursor.getShort(i);
                } else if (gfD == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (guB == hashCode) {
                    this.field_pushTime = cursor.getLong(i);
                } else if (ggs == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (guC == hashCode) {
                    this.field_descUrl = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.goU) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.gsh) {
            contentValues.put("isRead", Short.valueOf(this.field_isRead));
        }
        if (this.gfz) {
            contentValues.put("title", this.field_title);
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.guz) {
            contentValues.put("pushTime", Long.valueOf(this.field_pushTime));
        }
        if (this.gge) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.guA) {
            contentValues.put("descUrl", this.field_descUrl);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
