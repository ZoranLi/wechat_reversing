package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class t extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int ggg = "bizChatId".hashCode();
    private static final int ggh = "brandUserName".hashCode();
    private static final int ggi = "unReadCount".hashCode();
    private static final int ggj = "newUnReadCount".hashCode();
    private static final int ggk = "lastMsgID".hashCode();
    private static final int ggl = "lastMsgTime".hashCode();
    private static final int ggm = "digest".hashCode();
    private static final int ggn = "digestUser".hashCode();
    private static final int ggo = "atCount".hashCode();
    private static final int ggp = "editingMsg".hashCode();
    private static final int ggq = "chatType".hashCode();
    private static final int ggr = "isSend".hashCode();
    private static final int ggs = "msgType".hashCode();
    private static final int ggt = "msgCount".hashCode();
    public int field_atCount;
    public long field_bizChatId;
    public String field_brandUserName;
    public int field_chatType;
    public String field_content;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_flag;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_lastMsgTime;
    public int field_msgCount;
    public String field_msgType;
    public int field_newUnReadCount;
    public int field_status;
    public int field_unReadCount;
    private boolean gaW = true;
    private boolean gbJ = true;
    private boolean gfG = true;
    private boolean gfS = true;
    private boolean gfT = true;
    private boolean gfU = true;
    private boolean gfV = true;
    private boolean gfW = true;
    private boolean gfX = true;
    private boolean gfY = true;
    private boolean gfZ = true;
    private boolean gga = true;
    private boolean ggb = true;
    private boolean ggc = true;
    private boolean ggd = true;
    private boolean gge = true;
    private boolean ggf = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggg == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                    this.gfS = true;
                } else if (ggh == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (ggi == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (ggj == hashCode) {
                    this.field_newUnReadCount = cursor.getInt(i);
                } else if (ggk == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i);
                } else if (ggl == hashCode) {
                    this.field_lastMsgTime = cursor.getLong(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (ggm == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (ggn == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (ggo == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (ggp == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (ggq == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ggr == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (ggs == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (ggt == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gfS) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.gfT) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.gfU) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.gfV) {
            contentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
        }
        if (this.gfW) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.gfX) {
            contentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.gfY) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.gfZ) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.gga) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.ggb) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.ggc) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.ggd) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.gge) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.ggf) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.gfG) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
