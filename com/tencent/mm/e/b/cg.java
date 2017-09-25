package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cg extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gbV = "userName".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gxW = "wxGroupId".hashCode();
    private static final int gya = "inviteUserName".hashCode();
    private static final int gye = "memberUuid".hashCode();
    private static final int gyf = "memberId".hashCode();
    public long field_createTime;
    public String field_inviteUserName;
    public long field_memberId;
    public long field_memberUuid;
    public int field_status;
    public String field_userName;
    public String field_wxGroupId;
    private boolean gaW = true;
    private boolean gbB = true;
    private boolean gbz = true;
    private boolean gxQ = true;
    private boolean gxU = true;
    private boolean gyc = true;
    private boolean gyd = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gye == hashCode) {
                    this.field_memberUuid = cursor.getLong(i);
                } else if (gxW == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                } else if (gbV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (gya == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (gyf == hashCode) {
                    this.field_memberId = cursor.getLong(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gyc) {
            contentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
        }
        if (this.gxQ) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.gbz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.gxU) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.gyd) {
            contentValues.put("memberId", Long.valueOf(this.field_memberId));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
