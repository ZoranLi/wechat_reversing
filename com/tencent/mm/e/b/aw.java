package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class aw extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int ggr = "isSend".hashCode();
    private static final int goD = "talker".hashCode();
    private static final int goE = "encryptTalker".hashCode();
    private static final int goW = "msgContent".hashCode();
    private static final int goX = "svrId".hashCode();
    private static final int goY = "chatroomName".hashCode();
    public String field_chatroomName;
    public long field_createTime;
    public String field_encryptTalker;
    public int field_isSend;
    public String field_msgContent;
    public long field_svrId;
    public String field_talker;
    public int field_type;
    private boolean gbB = true;
    private boolean gbE = true;
    private boolean ggd = true;
    private boolean goT = true;
    private boolean goU = true;
    private boolean goV = true;
    private boolean gon = true;
    private boolean goo = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (goW == hashCode) {
                    this.field_msgContent = cursor.getString(i);
                } else if (ggr == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (goD == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (goE == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (goX == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (goY == hashCode) {
                    this.field_chatroomName = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_msgContent == null) {
            this.field_msgContent = "";
        }
        if (this.goT) {
            contentValues.put("msgContent", this.field_msgContent);
        }
        if (this.ggd) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_talker == null) {
            this.field_talker = "";
        }
        if (this.gon) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.goo) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.goU) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_chatroomName == null) {
            this.field_chatroomName = "";
        }
        if (this.goV) {
            contentValues.put("chatroomName", this.field_chatroomName);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
