package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class ax extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS FavCdnTransferInfo_LocalId ON FavCdnInfo(favLocalId)", "CREATE INDEX IF NOT EXISTS FavCDNInfo_modifyTime_Index ON FavCdnInfo(modifyTime)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcQ = "totalLen".hashCode();
    private static final int gcR = "offset".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gdi = "dataType".hashCode();
    private static final int geK = "modifyTime".hashCode();
    private static final int gnJ = "cdnUrl".hashCode();
    private static final int gpe = "dataId".hashCode();
    private static final int gpf = "favLocalId".hashCode();
    private static final int gpg = "cdnKey".hashCode();
    private static final int gph = "path".hashCode();
    private static final int gpi = "extFlag".hashCode();
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_dataType;
    public int field_extFlag;
    public long field_favLocalId;
    public long field_modifyTime;
    public int field_offset;
    public String field_path;
    public int field_status;
    public int field_totalLen;
    public int field_type;
    private boolean gaW = true;
    private boolean gbE = true;
    private boolean gcA = true;
    private boolean gcz = true;
    private boolean gdf = true;
    private boolean geo = true;
    private boolean gnm = true;
    private boolean goZ = true;
    private boolean gpa = true;
    private boolean gpb = true;
    private boolean gpc = true;
    private boolean gpd = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[12];
        aVar.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "dataId";
        aVar.uxd.put("dataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" dataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "dataId";
        aVar.columns[1] = "favLocalId";
        aVar.uxd.put("favLocalId", "LONG");
        stringBuilder.append(" favLocalId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "cdnUrl";
        aVar.uxd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "cdnKey";
        aVar.uxd.put("cdnKey", "TEXT");
        stringBuilder.append(" cdnKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "totalLen";
        aVar.uxd.put("totalLen", "INTEGER");
        stringBuilder.append(" totalLen INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "offset";
        aVar.uxd.put("offset", "INTEGER");
        stringBuilder.append(" offset INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = DownloadInfo.STATUS;
        aVar.uxd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "path";
        aVar.uxd.put("path", "TEXT");
        stringBuilder.append(" path TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "dataType";
        aVar.uxd.put("dataType", "INTEGER");
        stringBuilder.append(" dataType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "modifyTime";
        aVar.uxd.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "extFlag";
        aVar.uxd.put("extFlag", "INTEGER default '0' ");
        stringBuilder.append(" extFlag INTEGER default '0' ");
        aVar.columns[12] = "rowid";
        aVar.uxe = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpe == hashCode) {
                    this.field_dataId = cursor.getString(i);
                    this.goZ = true;
                } else if (gpf == hashCode) {
                    this.field_favLocalId = cursor.getLong(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gnJ == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gpg == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (gcQ == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (gcR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gph == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (gdi == hashCode) {
                    this.field_dataType = cursor.getInt(i);
                } else if (geK == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (gpi == hashCode) {
                    this.field_extFlag = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.goZ) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.gpa) {
            contentValues.put("favLocalId", Long.valueOf(this.field_favLocalId));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gnm) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.gpb) {
            contentValues.put("cdnKey", this.field_cdnKey);
        }
        if (this.gcz) {
            contentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
        }
        if (this.gcA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gpc) {
            contentValues.put("path", this.field_path);
        }
        if (this.gdf) {
            contentValues.put("dataType", Integer.valueOf(this.field_dataType));
        }
        if (this.geo) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.gpd) {
            contentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
