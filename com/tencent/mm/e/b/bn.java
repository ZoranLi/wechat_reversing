package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class bn extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gdt = "username".hashCode();
    private static final int ghU = "nickname".hashCode();
    private static final int gsY = "googleid".hashCode();
    private static final int gsZ = "googlename".hashCode();
    private static final int gta = "googlephotourl".hashCode();
    private static final int gtb = "googlegmail".hashCode();
    private static final int gtc = "nicknameqp".hashCode();
    private static final int gtd = "usernamepy".hashCode();
    private static final int gte = "small_url".hashCode();
    private static final int gtf = "big_url".hashCode();
    private static final int gtg = "ret".hashCode();
    private static final int gth = "googleitemid".hashCode();
    private static final int gti = "googlecgistatus".hashCode();
    private static final int gtj = "contecttype".hashCode();
    private static final int gtk = "googlenamepy".hashCode();
    public String field_big_url;
    public String field_contecttype;
    public int field_googlecgistatus;
    public String field_googlegmail;
    public String field_googleid;
    public String field_googleitemid;
    public String field_googlename;
    public String field_googlenamepy;
    public String field_googlephotourl;
    public String field_nickname;
    public String field_nicknameqp;
    public int field_ret;
    public String field_small_url;
    public int field_status;
    public String field_username;
    public String field_usernamepy;
    private boolean gaW = true;
    private boolean gds = true;
    private boolean ghQ = true;
    private boolean gsL = true;
    private boolean gsM = true;
    private boolean gsN = true;
    private boolean gsO = true;
    private boolean gsP = true;
    private boolean gsQ = true;
    private boolean gsR = true;
    private boolean gsS = true;
    private boolean gsT = true;
    private boolean gsU = true;
    private boolean gsV = true;
    private boolean gsW = true;
    private boolean gsX = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gsY == hashCode) {
                    this.field_googleid = cursor.getString(i);
                } else if (gsZ == hashCode) {
                    this.field_googlename = cursor.getString(i);
                } else if (gta == hashCode) {
                    this.field_googlephotourl = cursor.getString(i);
                } else if (gtb == hashCode) {
                    this.field_googlegmail = cursor.getString(i);
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ghU == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (gtc == hashCode) {
                    this.field_nicknameqp = cursor.getString(i);
                } else if (gtd == hashCode) {
                    this.field_usernamepy = cursor.getString(i);
                } else if (gte == hashCode) {
                    this.field_small_url = cursor.getString(i);
                } else if (gtf == hashCode) {
                    this.field_big_url = cursor.getString(i);
                } else if (gtg == hashCode) {
                    this.field_ret = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gth == hashCode) {
                    this.field_googleitemid = cursor.getString(i);
                    this.gsU = true;
                } else if (gti == hashCode) {
                    this.field_googlecgistatus = cursor.getInt(i);
                } else if (gtj == hashCode) {
                    this.field_contecttype = cursor.getString(i);
                } else if (gtk == hashCode) {
                    this.field_googlenamepy = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gsL) {
            contentValues.put("googleid", this.field_googleid);
        }
        if (this.gsM) {
            contentValues.put("googlename", this.field_googlename);
        }
        if (this.gsN) {
            contentValues.put("googlephotourl", this.field_googlephotourl);
        }
        if (this.gsO) {
            contentValues.put("googlegmail", this.field_googlegmail);
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.ghQ) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.gsP) {
            contentValues.put("nicknameqp", this.field_nicknameqp);
        }
        if (this.gsQ) {
            contentValues.put("usernamepy", this.field_usernamepy);
        }
        if (this.gsR) {
            contentValues.put("small_url", this.field_small_url);
        }
        if (this.gsS) {
            contentValues.put("big_url", this.field_big_url);
        }
        if (this.gsT) {
            contentValues.put("ret", Integer.valueOf(this.field_ret));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gsU) {
            contentValues.put("googleitemid", this.field_googleitemid);
        }
        if (this.gsV) {
            contentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
        }
        if (this.gsW) {
            contentValues.put("contecttype", this.field_contecttype);
        }
        if (this.gsX) {
            contentValues.put("googlenamepy", this.field_googlenamepy);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
