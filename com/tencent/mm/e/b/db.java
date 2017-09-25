package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class db extends c {
    private static final int gDA = "faultS".hashCode();
    private static final int gDB = "snsBgId".hashCode();
    private static final int gDC = "snsuser".hashCode();
    private static final int gDD = "adsession".hashCode();
    private static final int gDE = "lastFirstPageRequestErrCode".hashCode();
    private static final int gDF = "lastFirstPageRequestErrType".hashCode();
    private static final int gDs = "newerIds".hashCode();
    private static final int gDt = "bgId".hashCode();
    private static final int gDu = "bgUrl".hashCode();
    private static final int gDv = "older_bgId".hashCode();
    private static final int gDw = "local_flag".hashCode();
    private static final int gDx = "istyle".hashCode();
    private static final int gDy = "iFlag".hashCode();
    private static final int gDz = "icount".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbV = "userName".hashCode();
    private static final int gns = "md5".hashCode();
    public byte[] field_adsession;
    public String field_bgId;
    public String field_bgUrl;
    public byte[] field_faultS;
    public int field_iFlag;
    public int field_icount;
    public int field_istyle;
    public int field_lastFirstPageRequestErrCode;
    public int field_lastFirstPageRequestErrType;
    public int field_local_flag;
    public String field_md5;
    public String field_newerIds;
    public String field_older_bgId;
    public long field_snsBgId;
    public byte[] field_snsuser;
    public String field_userName;
    private boolean gDe = true;
    private boolean gDf = true;
    private boolean gDg = true;
    private boolean gDh = true;
    private boolean gDi = true;
    private boolean gDj = true;
    private boolean gDk = true;
    private boolean gDl = true;
    private boolean gDm = true;
    private boolean gDn = true;
    private boolean gDo = true;
    private boolean gDp = true;
    private boolean gDq = true;
    private boolean gDr = true;
    private boolean gbz = true;
    private boolean gmV = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbV == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.gbz = true;
                } else if (gns == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (gDs == hashCode) {
                    this.field_newerIds = cursor.getString(i);
                } else if (gDt == hashCode) {
                    this.field_bgId = cursor.getString(i);
                } else if (gDu == hashCode) {
                    this.field_bgUrl = cursor.getString(i);
                } else if (gDv == hashCode) {
                    this.field_older_bgId = cursor.getString(i);
                } else if (gDw == hashCode) {
                    this.field_local_flag = cursor.getInt(i);
                } else if (gDx == hashCode) {
                    this.field_istyle = cursor.getInt(i);
                } else if (gDy == hashCode) {
                    this.field_iFlag = cursor.getInt(i);
                } else if (gDz == hashCode) {
                    this.field_icount = cursor.getInt(i);
                } else if (gDA == hashCode) {
                    this.field_faultS = cursor.getBlob(i);
                } else if (gDB == hashCode) {
                    this.field_snsBgId = cursor.getLong(i);
                } else if (gDC == hashCode) {
                    this.field_snsuser = cursor.getBlob(i);
                } else if (gDD == hashCode) {
                    this.field_adsession = cursor.getBlob(i);
                } else if (gDE == hashCode) {
                    this.field_lastFirstPageRequestErrCode = cursor.getInt(i);
                } else if (gDF == hashCode) {
                    this.field_lastFirstPageRequestErrType = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.gbz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.gmV) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.gDe) {
            contentValues.put("newerIds", this.field_newerIds);
        }
        if (this.gDf) {
            contentValues.put("bgId", this.field_bgId);
        }
        if (this.gDg) {
            contentValues.put("bgUrl", this.field_bgUrl);
        }
        if (this.gDh) {
            contentValues.put("older_bgId", this.field_older_bgId);
        }
        if (this.gDi) {
            contentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
        }
        if (this.gDj) {
            contentValues.put("istyle", Integer.valueOf(this.field_istyle));
        }
        if (this.gDk) {
            contentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
        }
        if (this.gDl) {
            contentValues.put("icount", Integer.valueOf(this.field_icount));
        }
        if (this.gDm) {
            contentValues.put("faultS", this.field_faultS);
        }
        if (this.gDn) {
            contentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
        }
        if (this.gDo) {
            contentValues.put("snsuser", this.field_snsuser);
        }
        if (this.gDp) {
            contentValues.put("adsession", this.field_adsession);
        }
        if (this.gDq) {
            contentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
        }
        if (this.gDr) {
            contentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
