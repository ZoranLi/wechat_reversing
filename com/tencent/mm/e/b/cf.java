package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cf extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gnD = "groupId".hashCode();
    private static final int gnw = "state".hashCode();
    private static final int gxW = "wxGroupId".hashCode();
    private static final int gxX = "roomId".hashCode();
    private static final int gxY = "roomKey".hashCode();
    private static final int gxZ = "routeId".hashCode();
    private static final int gya = "inviteUserName".hashCode();
    private static final int gyb = "memberCount".hashCode();
    public long field_createTime;
    public String field_groupId;
    public String field_inviteUserName;
    public int field_memberCount;
    public int field_roomId;
    public long field_roomKey;
    public int field_routeId;
    public int field_state;
    public String field_wxGroupId;
    private boolean gbB = true;
    private boolean gmZ = true;
    private boolean gng = true;
    private boolean gxQ = true;
    private boolean gxR = true;
    private boolean gxS = true;
    private boolean gxT = true;
    private boolean gxU = true;
    private boolean gxV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gxW == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                    this.gxQ = true;
                } else if (gnD == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (gxX == hashCode) {
                    this.field_roomId = cursor.getInt(i);
                } else if (gxY == hashCode) {
                    this.field_roomKey = cursor.getLong(i);
                } else if (gxZ == hashCode) {
                    this.field_routeId = cursor.getInt(i);
                } else if (gya == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (gyb == hashCode) {
                    this.field_memberCount = cursor.getInt(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gnw == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gxQ) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.gng) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.gxR) {
            contentValues.put("roomId", Integer.valueOf(this.field_roomId));
        }
        if (this.gxS) {
            contentValues.put("roomKey", Long.valueOf(this.field_roomKey));
        }
        if (this.gxT) {
            contentValues.put("routeId", Integer.valueOf(this.field_routeId));
        }
        if (this.gxU) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.gxV) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gmZ) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
