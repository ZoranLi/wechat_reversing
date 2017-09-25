package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class e extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gbU = "snsId".hashCode();
    private static final int gbV = "userName".hashCode();
    private static final int gbW = "localFlag".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gbY = "head".hashCode();
    private static final int gbZ = "localPrivate".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gcb = "sourceType".hashCode();
    private static final int gcc = "likeFlag".hashCode();
    private static final int gcd = "pravited".hashCode();
    private static final int gce = "stringSeq".hashCode();
    private static final int gcf = "content".hashCode();
    private static final int gcg = "attrBuf".hashCode();
    private static final int gch = "postBuf".hashCode();
    private static final int gci = "adinfo".hashCode();
    private static final int gcj = "adxml".hashCode();
    private static final int gck = "createAdTime".hashCode();
    private static final int gcl = "exposureTime".hashCode();
    private static final int gcm = "firstControlTime".hashCode();
    private static final int gcn = "recxml".hashCode();
    private static final int gco = "subType".hashCode();
    private static final int gcp = "exposureCount".hashCode();
    public String field_adinfo;
    public String field_adxml;
    public byte[] field_attrBuf;
    public byte[] field_content;
    public int field_createAdTime;
    public int field_createTime;
    public int field_exposureCount;
    public int field_exposureTime;
    public int field_firstControlTime;
    public int field_head;
    public int field_likeFlag;
    public int field_localFlag;
    public int field_localPrivate;
    public byte[] field_postBuf;
    public int field_pravited;
    public String field_recxml;
    public long field_snsId;
    public int field_sourceType;
    public String field_stringSeq;
    public int field_subType;
    public int field_type;
    public String field_userName;
    private boolean gbA = true;
    private boolean gbB = true;
    private boolean gbC = true;
    private boolean gbD = true;
    private boolean gbE = true;
    private boolean gbF = true;
    private boolean gbG = true;
    private boolean gbH = true;
    private boolean gbI = true;
    private boolean gbJ = true;
    private boolean gbK = true;
    private boolean gbL = true;
    private boolean gbM = true;
    private boolean gbN = true;
    private boolean gbO = true;
    private boolean gbP = true;
    private boolean gbQ = true;
    private boolean gbR = true;
    private boolean gbS = true;
    private boolean gbT = true;
    private boolean gby = true;
    private boolean gbz = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbU == hashCode) {
                    this.field_snsId = cursor.getLong(i);
                } else if (gbV == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (gbW == hashCode) {
                    this.field_localFlag = cursor.getInt(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (gbY == hashCode) {
                    this.field_head = cursor.getInt(i);
                } else if (gbZ == hashCode) {
                    this.field_localPrivate = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gcb == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (gcc == hashCode) {
                    this.field_likeFlag = cursor.getInt(i);
                } else if (gcd == hashCode) {
                    this.field_pravited = cursor.getInt(i);
                } else if (gce == hashCode) {
                    this.field_stringSeq = cursor.getString(i);
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (gcg == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i);
                } else if (gch == hashCode) {
                    this.field_postBuf = cursor.getBlob(i);
                } else if (gci == hashCode) {
                    this.field_adinfo = cursor.getString(i);
                } else if (gcj == hashCode) {
                    this.field_adxml = cursor.getString(i);
                } else if (gck == hashCode) {
                    this.field_createAdTime = cursor.getInt(i);
                } else if (gcl == hashCode) {
                    this.field_exposureTime = cursor.getInt(i);
                } else if (gcm == hashCode) {
                    this.field_firstControlTime = cursor.getInt(i);
                } else if (gcn == hashCode) {
                    this.field_recxml = cursor.getString(i);
                } else if (gco == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (gcp == hashCode) {
                    this.field_exposureCount = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gby) {
            contentValues.put("snsId", Long.valueOf(this.field_snsId));
        }
        if (this.gbz) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.gbA) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.gbB) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.gbC) {
            contentValues.put("head", Integer.valueOf(this.field_head));
        }
        if (this.gbD) {
            contentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gbF) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.gbG) {
            contentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
        }
        if (this.gbH) {
            contentValues.put("pravited", Integer.valueOf(this.field_pravited));
        }
        if (this.gbI) {
            contentValues.put("stringSeq", this.field_stringSeq);
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.gbK) {
            contentValues.put("attrBuf", this.field_attrBuf);
        }
        if (this.gbL) {
            contentValues.put("postBuf", this.field_postBuf);
        }
        if (this.gbM) {
            contentValues.put("adinfo", this.field_adinfo);
        }
        if (this.gbN) {
            contentValues.put("adxml", this.field_adxml);
        }
        if (this.gbO) {
            contentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
        }
        if (this.gbP) {
            contentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
        }
        if (this.gbQ) {
            contentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
        }
        if (this.gbR) {
            contentValues.put("recxml", this.field_recxml);
        }
        if (this.gbS) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.gbT) {
            contentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
