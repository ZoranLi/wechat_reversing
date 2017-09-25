package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a extends c {
    public static final String[] gaK = new String[0];
    private static final int gaP = "payMsgId".hashCode();
    private static final int gaQ = "insertmsg".hashCode();
    private static final int gaR = "chatroom".hashCode();
    private static final int gaS = "msgId".hashCode();
    private static final int gaT = "rowid".hashCode();
    public String field_chatroom;
    public boolean field_insertmsg;
    public long field_msgId;
    public String field_payMsgId;
    private boolean gaL = true;
    private boolean gaM = true;
    private boolean gaN = true;
    private boolean gaO = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaP == hashCode) {
                    this.field_payMsgId = cursor.getString(i);
                    this.gaL = true;
                } else if (gaQ == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (gaR == hashCode) {
                    this.field_chatroom = cursor.getString(i);
                } else if (gaS == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gaL) {
            contentValues.put("payMsgId", this.field_payMsgId);
        }
        if (this.gaM) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.gaN) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.gaO) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
