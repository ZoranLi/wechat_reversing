package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class u extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int ggG = "bizChatLocalId".hashCode();
    private static final int ggH = "bizChatServId".hashCode();
    private static final int ggI = "headImageUrl".hashCode();
    private static final int ggJ = "chatName".hashCode();
    private static final int ggK = "chatNamePY".hashCode();
    private static final int ggL = "chatVersion".hashCode();
    private static final int ggM = "needToUpdate".hashCode();
    private static final int ggN = "bitFlag".hashCode();
    private static final int ggO = "maxMemberCnt".hashCode();
    private static final int ggP = "ownerUserId".hashCode();
    private static final int ggQ = "userList".hashCode();
    private static final int ggR = "addMemberUrl".hashCode();
    private static final int ggh = "brandUserName".hashCode();
    private static final int ggq = "chatType".hashCode();
    public String field_addMemberUrl;
    public int field_bitFlag;
    public long field_bizChatLocalId;
    public String field_bizChatServId;
    public String field_brandUserName;
    public String field_chatName;
    public String field_chatNamePY;
    public int field_chatType;
    public int field_chatVersion;
    public String field_headImageUrl;
    public int field_maxMemberCnt;
    public boolean field_needToUpdate;
    public String field_ownerUserId;
    public String field_userList;
    private boolean gfT = true;
    private boolean ggA = true;
    private boolean ggB = true;
    private boolean ggC = true;
    private boolean ggD = true;
    private boolean ggE = true;
    private boolean ggF = true;
    private boolean ggc = true;
    private boolean ggu = true;
    private boolean ggv = true;
    private boolean ggw = true;
    private boolean ggx = true;
    private boolean ggy = true;
    private boolean ggz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggG == hashCode) {
                    this.field_bizChatLocalId = cursor.getLong(i);
                    this.ggu = true;
                } else if (ggH == hashCode) {
                    this.field_bizChatServId = cursor.getString(i);
                } else if (ggh == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (ggq == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (ggI == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (ggJ == hashCode) {
                    this.field_chatName = cursor.getString(i);
                } else if (ggK == hashCode) {
                    this.field_chatNamePY = cursor.getString(i);
                } else if (ggL == hashCode) {
                    this.field_chatVersion = cursor.getInt(i);
                } else if (ggM == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (ggN == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (ggO == hashCode) {
                    this.field_maxMemberCnt = cursor.getInt(i);
                } else if (ggP == hashCode) {
                    this.field_ownerUserId = cursor.getString(i);
                } else if (ggQ == hashCode) {
                    this.field_userList = cursor.getString(i);
                } else if (ggR == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.ggu) {
            contentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
        }
        if (this.ggv) {
            contentValues.put("bizChatServId", this.field_bizChatServId);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.gfT) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.ggc) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.ggw) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.field_chatName == null) {
            this.field_chatName = "";
        }
        if (this.ggx) {
            contentValues.put("chatName", this.field_chatName);
        }
        if (this.field_chatNamePY == null) {
            this.field_chatNamePY = "";
        }
        if (this.ggy) {
            contentValues.put("chatNamePY", this.field_chatNamePY);
        }
        if (this.ggz) {
            contentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
        }
        if (this.ggA) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.ggB) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.ggC) {
            contentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
        }
        if (this.ggD) {
            contentValues.put("ownerUserId", this.field_ownerUserId);
        }
        if (this.ggE) {
            contentValues.put("userList", this.field_userList);
        }
        if (this.ggF) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
