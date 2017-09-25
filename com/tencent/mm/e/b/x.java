package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbV = "userName".hashCode();
    private static final int ghh = "qyUin".hashCode();
    private static final int ghi = "userUin".hashCode();
    private static final int ghj = "userFlag".hashCode();
    private static final int ghk = "wwExposeTimes".hashCode();
    private static final int ghl = "wwMaxExposeTimes".hashCode();
    private static final int ghm = "wwCorpId".hashCode();
    private static final int ghn = "wwUserVid".hashCode();
    public int field_qyUin;
    public int field_userFlag;
    public String field_userName;
    public int field_userUin;
    public long field_wwCorpId;
    public int field_wwExposeTimes;
    public int field_wwMaxExposeTimes;
    public long field_wwUserVid;
    private boolean gbz = true;
    private boolean gha = true;
    private boolean ghb = true;
    private boolean ghc = true;
    private boolean ghd = true;
    private boolean ghe = true;
    private boolean ghf = true;
    private boolean ghg = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbV == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.gbz = true;
                } else if (ghh == hashCode) {
                    this.field_qyUin = cursor.getInt(i);
                } else if (ghi == hashCode) {
                    this.field_userUin = cursor.getInt(i);
                } else if (ghj == hashCode) {
                    this.field_userFlag = cursor.getInt(i);
                } else if (ghk == hashCode) {
                    this.field_wwExposeTimes = cursor.getInt(i);
                } else if (ghl == hashCode) {
                    this.field_wwMaxExposeTimes = cursor.getInt(i);
                } else if (ghm == hashCode) {
                    this.field_wwCorpId = cursor.getLong(i);
                } else if (ghn == hashCode) {
                    this.field_wwUserVid = cursor.getLong(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gbz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.gha) {
            contentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
        }
        if (this.ghb) {
            contentValues.put("userUin", Integer.valueOf(this.field_userUin));
        }
        if (this.ghc) {
            contentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
        }
        if (this.ghd) {
            contentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
        }
        if (this.ghe) {
            contentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
        }
        if (this.ghf) {
            contentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
        }
        if (this.ghg) {
            contentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
