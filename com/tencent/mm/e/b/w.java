package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbV = "userName".hashCode();
    private static final int ggI = "headImageUrl".hashCode();
    private static final int ggM = "needToUpdate".hashCode();
    private static final int ggN = "bitFlag".hashCode();
    private static final int ggR = "addMemberUrl".hashCode();
    private static final int ggT = "userId".hashCode();
    private static final int ggX = "userNamePY".hashCode();
    private static final int ggY = "UserVersion".hashCode();
    private static final int ggZ = "profileUrl".hashCode();
    private static final int ggh = "brandUserName".hashCode();
    public int field_UserVersion;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public String field_brandUserName;
    public String field_headImageUrl;
    public boolean field_needToUpdate;
    public String field_profileUrl;
    public String field_userId;
    public String field_userName;
    public String field_userNamePY;
    private boolean gbz = true;
    private boolean gfT = true;
    private boolean ggA = true;
    private boolean ggB = true;
    private boolean ggF = true;
    private boolean ggS = true;
    private boolean ggU = true;
    private boolean ggV = true;
    private boolean ggW = true;
    private boolean ggw = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggT == hashCode) {
                    this.field_userId = cursor.getString(i);
                    this.ggS = true;
                } else if (gbV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (ggX == hashCode) {
                    this.field_userNamePY = cursor.getString(i);
                } else if (ggh == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (ggY == hashCode) {
                    this.field_UserVersion = cursor.getInt(i);
                } else if (ggM == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (ggI == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (ggZ == hashCode) {
                    this.field_profileUrl = cursor.getString(i);
                } else if (ggN == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
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
        if (this.ggS) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.gbz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.field_userNamePY == null) {
            this.field_userNamePY = "";
        }
        if (this.ggU) {
            contentValues.put("userNamePY", this.field_userNamePY);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.gfT) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.ggV) {
            contentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
        }
        if (this.ggA) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.ggw) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.ggW) {
            contentValues.put("profileUrl", this.field_profileUrl);
        }
        if (this.ggB) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
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
