package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class an extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gfI = "flag".hashCode();
    private static final int gmA = "packDesc".hashCode();
    private static final int gmB = "packAuthInfo".hashCode();
    private static final int gmC = "packPrice".hashCode();
    private static final int gmD = "packType".hashCode();
    private static final int gmE = "packFlag".hashCode();
    private static final int gmF = "packExpire".hashCode();
    private static final int gmG = "packTimeStamp".hashCode();
    private static final int gmH = "packCopyright".hashCode();
    private static final int gmI = "sort".hashCode();
    private static final int gmJ = "lastUseTime".hashCode();
    private static final int gmK = "packStatus".hashCode();
    private static final int gmL = "recommand".hashCode();
    private static final int gmM = "sync".hashCode();
    private static final int gmN = "idx".hashCode();
    private static final int gmO = "BigIconUrl".hashCode();
    private static final int gmP = "MutiLanName".hashCode();
    private static final int gmQ = "recommandType".hashCode();
    private static final int gmR = "lang".hashCode();
    private static final int gmS = "recommandWord".hashCode();
    private static final int gmT = "buttonType".hashCode();
    private static final int gmU = "count".hashCode();
    private static final int gmv = "productID".hashCode();
    private static final int gmw = "packIconUrl".hashCode();
    private static final int gmx = "packGrayIconUrl".hashCode();
    private static final int gmy = "packCoverUrl".hashCode();
    private static final int gmz = "packName".hashCode();
    public String field_BigIconUrl;
    public String field_MutiLanName;
    public int field_buttonType;
    public int field_count;
    public int field_flag;
    public int field_idx;
    public String field_lang;
    public long field_lastUseTime;
    public String field_packAuthInfo;
    public String field_packCopyright;
    public String field_packCoverUrl;
    public String field_packDesc;
    public long field_packExpire;
    public int field_packFlag;
    public String field_packGrayIconUrl;
    public String field_packIconUrl;
    public String field_packName;
    public String field_packPrice;
    public int field_packStatus;
    public long field_packTimeStamp;
    public int field_packType;
    public String field_productID;
    public int field_recommand;
    public int field_recommandType;
    public String field_recommandWord;
    public int field_sort;
    public int field_status;
    public int field_sync;
    public int field_type;
    private boolean gaW = true;
    private boolean gbE = true;
    private boolean gfG = true;
    private boolean glV = true;
    private boolean glW = true;
    private boolean glX = true;
    private boolean glY = true;
    private boolean glZ = true;
    private boolean gma = true;
    private boolean gmb = true;
    private boolean gmc = true;
    private boolean gmd = true;
    private boolean gme = true;
    private boolean gmf = true;
    private boolean gmg = true;
    private boolean gmh = true;
    private boolean gmi = true;
    private boolean gmj = true;
    private boolean gmk = true;
    private boolean gml = true;
    private boolean gmm = true;
    private boolean gmn = true;
    private boolean gmo = true;
    private boolean gmp = true;
    private boolean gmq = true;
    private boolean gmr = true;
    private boolean gms = true;
    private boolean gmt = true;
    private boolean gmu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gmv == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.glV = true;
                } else if (gmw == hashCode) {
                    this.field_packIconUrl = cursor.getString(i);
                } else if (gmx == hashCode) {
                    this.field_packGrayIconUrl = cursor.getString(i);
                } else if (gmy == hashCode) {
                    this.field_packCoverUrl = cursor.getString(i);
                } else if (gmz == hashCode) {
                    this.field_packName = cursor.getString(i);
                } else if (gmA == hashCode) {
                    this.field_packDesc = cursor.getString(i);
                } else if (gmB == hashCode) {
                    this.field_packAuthInfo = cursor.getString(i);
                } else if (gmC == hashCode) {
                    this.field_packPrice = cursor.getString(i);
                } else if (gmD == hashCode) {
                    this.field_packType = cursor.getInt(i);
                } else if (gmE == hashCode) {
                    this.field_packFlag = cursor.getInt(i);
                } else if (gmF == hashCode) {
                    this.field_packExpire = cursor.getLong(i);
                } else if (gmG == hashCode) {
                    this.field_packTimeStamp = cursor.getLong(i);
                } else if (gmH == hashCode) {
                    this.field_packCopyright = cursor.getString(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gmI == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (gmJ == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (gmK == hashCode) {
                    this.field_packStatus = cursor.getInt(i);
                } else if (gfI == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gmL == hashCode) {
                    this.field_recommand = cursor.getInt(i);
                } else if (gmM == hashCode) {
                    this.field_sync = cursor.getInt(i);
                } else if (gmN == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (gmO == hashCode) {
                    this.field_BigIconUrl = cursor.getString(i);
                } else if (gmP == hashCode) {
                    this.field_MutiLanName = cursor.getString(i);
                } else if (gmQ == hashCode) {
                    this.field_recommandType = cursor.getInt(i);
                } else if (gmR == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (gmS == hashCode) {
                    this.field_recommandWord = cursor.getString(i);
                } else if (gmT == hashCode) {
                    this.field_buttonType = cursor.getInt(i);
                } else if (gmU == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.glV) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.glW) {
            contentValues.put("packIconUrl", this.field_packIconUrl);
        }
        if (this.glX) {
            contentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
        }
        if (this.glY) {
            contentValues.put("packCoverUrl", this.field_packCoverUrl);
        }
        if (this.glZ) {
            contentValues.put("packName", this.field_packName);
        }
        if (this.gma) {
            contentValues.put("packDesc", this.field_packDesc);
        }
        if (this.gmb) {
            contentValues.put("packAuthInfo", this.field_packAuthInfo);
        }
        if (this.gmc) {
            contentValues.put("packPrice", this.field_packPrice);
        }
        if (this.gmd) {
            contentValues.put("packType", Integer.valueOf(this.field_packType));
        }
        if (this.gme) {
            contentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
        }
        if (this.gmf) {
            contentValues.put("packExpire", Long.valueOf(this.field_packExpire));
        }
        if (this.gmg) {
            contentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
        }
        if (this.gmh) {
            contentValues.put("packCopyright", this.field_packCopyright);
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gmi) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.gmj) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.gmk) {
            contentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
        }
        if (this.gfG) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.gml) {
            contentValues.put("recommand", Integer.valueOf(this.field_recommand));
        }
        if (this.gmm) {
            contentValues.put("sync", Integer.valueOf(this.field_sync));
        }
        if (this.gmn) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.gmo) {
            contentValues.put("BigIconUrl", this.field_BigIconUrl);
        }
        if (this.gmp) {
            contentValues.put("MutiLanName", this.field_MutiLanName);
        }
        if (this.gmq) {
            contentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
        }
        if (this.gmr) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.gms) {
            contentValues.put("recommandWord", this.field_recommandWord);
        }
        if (this.gmt) {
            contentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
        }
        if (this.gmu) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
