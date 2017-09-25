package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class y extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gdO = "brandFlag".hashCode();
    private static final int gdr = "updateTime".hashCode();
    private static final int gdt = "username".hashCode();
    private static final int ggN = "bitFlag".hashCode();
    private static final int ghB = "brandList".hashCode();
    private static final int ghC = "brandListVersion".hashCode();
    private static final int ghD = "brandListContent".hashCode();
    private static final int ghE = "extInfo".hashCode();
    private static final int ghF = "brandInfo".hashCode();
    private static final int ghG = "brandIconURL".hashCode();
    private static final int ghH = "hadAlert".hashCode();
    private static final int ghI = "acceptType".hashCode();
    private static final int ghJ = "enterpriseFather".hashCode();
    private static final int ghK = "kfWorkerId".hashCode();
    private static final int ghL = "specialType".hashCode();
    private static final int ghM = "attrSyncVersion".hashCode();
    private static final int ghN = "incrementUpdateTime".hashCode();
    public int field_acceptType;
    public String field_attrSyncVersion;
    public int field_bitFlag;
    public int field_brandFlag;
    public String field_brandIconURL;
    public String field_brandInfo;
    public String field_brandList;
    public String field_brandListContent;
    public String field_brandListVersion;
    public String field_enterpriseFather;
    public String field_extInfo;
    public int field_hadAlert;
    public long field_incrementUpdateTime;
    public String field_kfWorkerId;
    public int field_specialType;
    public int field_status;
    public int field_type;
    public long field_updateTime;
    public String field_username;
    private boolean gaW = true;
    private boolean gbE = true;
    private boolean gdB = true;
    private boolean gdn = true;
    private boolean gds = true;
    private boolean ggB = true;
    private boolean ghA = true;
    private boolean gho = true;
    private boolean ghp = true;
    private boolean ghq = true;
    private boolean ghr = true;
    private boolean ghs = true;
    private boolean ght = true;
    private boolean ghu = true;
    private boolean ghv = true;
    private boolean ghw = true;
    private boolean ghx = true;
    private boolean ghy = true;
    private boolean ghz = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.gds = true;
                } else if (ghB == hashCode) {
                    this.field_brandList = cursor.getString(i);
                } else if (ghC == hashCode) {
                    this.field_brandListVersion = cursor.getString(i);
                } else if (ghD == hashCode) {
                    this.field_brandListContent = cursor.getString(i);
                } else if (gdO == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (ghE == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (ghF == hashCode) {
                    this.field_brandInfo = cursor.getString(i);
                } else if (ghG == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (gdr == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (ghH == hashCode) {
                    this.field_hadAlert = cursor.getInt(i);
                } else if (ghI == hashCode) {
                    this.field_acceptType = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (ghJ == hashCode) {
                    this.field_enterpriseFather = cursor.getString(i);
                } else if (ghK == hashCode) {
                    this.field_kfWorkerId = cursor.getString(i);
                } else if (ghL == hashCode) {
                    this.field_specialType = cursor.getInt(i);
                } else if (ghM == hashCode) {
                    this.field_attrSyncVersion = cursor.getString(i);
                } else if (ghN == hashCode) {
                    this.field_incrementUpdateTime = cursor.getLong(i);
                } else if (ggN == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_brandList == null) {
            this.field_brandList = "";
        }
        if (this.gho) {
            contentValues.put("brandList", this.field_brandList);
        }
        if (this.ghp) {
            contentValues.put("brandListVersion", this.field_brandListVersion);
        }
        if (this.ghq) {
            contentValues.put("brandListContent", this.field_brandListContent);
        }
        if (this.gdB) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.ghr) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.ghs) {
            contentValues.put("brandInfo", this.field_brandInfo);
        }
        if (this.ght) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.gdn) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.ghu) {
            contentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
        }
        if (this.ghv) {
            contentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.ghw) {
            contentValues.put("enterpriseFather", this.field_enterpriseFather);
        }
        if (this.ghx) {
            contentValues.put("kfWorkerId", this.field_kfWorkerId);
        }
        if (this.ghy) {
            contentValues.put("specialType", Integer.valueOf(this.field_specialType));
        }
        if (this.ghz) {
            contentValues.put("attrSyncVersion", this.field_attrSyncVersion);
        }
        if (this.ghA) {
            contentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
        }
        if (this.ggB) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
