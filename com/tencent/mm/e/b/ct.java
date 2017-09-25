package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ct extends c {
    private static final int gBA = "province".hashCode();
    private static final int gBB = "city".hashCode();
    private static final int gBC = "distance".hashCode();
    private static final int gBD = "sex".hashCode();
    private static final int gBE = "imgstatus".hashCode();
    private static final int gBF = "hasHDImg".hashCode();
    private static final int gBG = "insertBatch".hashCode();
    private static final int gBH = "regionCode".hashCode();
    private static final int gBI = "snsFlag".hashCode();
    private static final int gBJ = "sns_bgurl".hashCode();
    private static final int gBz = "shakeItemID".hashCode();
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gcZ = "signature".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gdt = "username".hashCode();
    private static final int ghU = "nickname".hashCode();
    private static final int gnA = "reserved3".hashCode();
    private static final int gnB = "reserved4".hashCode();
    private static final int gny = "reserved1".hashCode();
    private static final int gnz = "reserved2".hashCode();
    private static final int gtM = "lvbuffer".hashCode();
    public String field_city;
    public String field_distance;
    public int field_hasHDImg;
    public int field_imgstatus;
    public int field_insertBatch;
    public byte[] field_lvbuffer;
    public String field_nickname;
    public String field_province;
    public String field_regionCode;
    public int field_reserved1;
    public int field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public int field_sex;
    public int field_shakeItemID;
    public String field_signature;
    public int field_snsFlag;
    public String field_sns_bgurl;
    public int field_type;
    public String field_username;
    private boolean gBo = true;
    private boolean gBp = true;
    private boolean gBq = true;
    private boolean gBr = true;
    private boolean gBs = true;
    private boolean gBt = true;
    private boolean gBu = true;
    private boolean gBv = true;
    private boolean gBw = true;
    private boolean gBx = true;
    private boolean gBy = true;
    private boolean gbE = true;
    private boolean gcI = true;
    private boolean gds = true;
    private boolean ghQ = true;
    private boolean gnb = true;
    private boolean gnc = true;
    private boolean gnd = true;
    private boolean gne = true;
    private boolean gtA = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gBz == hashCode) {
                    this.field_shakeItemID = cursor.getInt(i);
                    this.gBo = true;
                } else if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (ghU == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (gBA == hashCode) {
                    this.field_province = cursor.getString(i);
                } else if (gBB == hashCode) {
                    this.field_city = cursor.getString(i);
                } else if (gcZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (gBC == hashCode) {
                    this.field_distance = cursor.getString(i);
                } else if (gBD == hashCode) {
                    this.field_sex = cursor.getInt(i);
                } else if (gBE == hashCode) {
                    this.field_imgstatus = cursor.getInt(i);
                } else if (gBF == hashCode) {
                    this.field_hasHDImg = cursor.getInt(i);
                } else if (gBG == hashCode) {
                    this.field_insertBatch = cursor.getInt(i);
                } else if (gny == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (gnz == hashCode) {
                    this.field_reserved2 = cursor.getInt(i);
                } else if (gnA == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (gnB == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gtM == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (gBH == hashCode) {
                    this.field_regionCode = cursor.getString(i);
                } else if (gBI == hashCode) {
                    this.field_snsFlag = cursor.getInt(i);
                } else if (gBJ == hashCode) {
                    this.field_sns_bgurl = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gBo) {
            contentValues.put("shakeItemID", Integer.valueOf(this.field_shakeItemID));
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.ghQ) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.gBp) {
            contentValues.put("province", this.field_province);
        }
        if (this.gBq) {
            contentValues.put("city", this.field_city);
        }
        if (this.gcI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.gBr) {
            contentValues.put("distance", this.field_distance);
        }
        if (this.gBs) {
            contentValues.put("sex", Integer.valueOf(this.field_sex));
        }
        if (this.gBt) {
            contentValues.put("imgstatus", Integer.valueOf(this.field_imgstatus));
        }
        if (this.gBu) {
            contentValues.put("hasHDImg", Integer.valueOf(this.field_hasHDImg));
        }
        if (this.gBv) {
            contentValues.put("insertBatch", Integer.valueOf(this.field_insertBatch));
        }
        if (this.gnb) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.gnc) {
            contentValues.put("reserved2", Integer.valueOf(this.field_reserved2));
        }
        if (this.gnd) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.gne) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gtA) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.gBw) {
            contentValues.put("regionCode", this.field_regionCode);
        }
        if (this.gBx) {
            contentValues.put("snsFlag", Integer.valueOf(this.field_snsFlag));
        }
        if (this.gBy) {
            contentValues.put("sns_bgurl", this.field_sns_bgurl);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
