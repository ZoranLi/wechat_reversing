package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class z extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int geR = "openId".hashCode();
    private static final int ghS = "brandUsername".hashCode();
    private static final int ghT = "headImgUrl".hashCode();
    private static final int ghU = "nickname".hashCode();
    private static final int ghV = "kfType".hashCode();
    public String field_brandUsername;
    public String field_headImgUrl;
    public int field_kfType;
    public String field_nickname;
    public String field_openId;
    public long field_updateTime;
    private boolean gdn = true;
    private boolean gev = true;
    private boolean ghO = true;
    private boolean ghP = true;
    private boolean ghQ = true;
    private boolean ghR = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (geR == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.gev = true;
                } else if (ghS == hashCode) {
                    this.field_brandUsername = cursor.getString(i);
                } else if (ghT == hashCode) {
                    this.field_headImgUrl = cursor.getString(i);
                } else if (ghU == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (ghV == hashCode) {
                    this.field_kfType = cursor.getInt(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gev) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.field_brandUsername == null) {
            this.field_brandUsername = "";
        }
        if (this.ghO) {
            contentValues.put("brandUsername", this.field_brandUsername);
        }
        if (this.ghP) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.ghQ) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.ghR) {
            contentValues.put("kfType", Integer.valueOf(this.field_kfType));
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
