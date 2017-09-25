package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class g extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gcL = "appId".hashCode();
    private static final int gcM = "sdkVer".hashCode();
    private static final int gcN = "mediaSvrId".hashCode();
    private static final int gcO = "mediaId".hashCode();
    private static final int gcP = "clientAppDataId".hashCode();
    private static final int gcQ = "totalLen".hashCode();
    private static final int gcR = "offset".hashCode();
    private static final int gcS = "isUpload".hashCode();
    private static final int gcT = "lastModifyTime".hashCode();
    private static final int gcU = "fileFullPath".hashCode();
    private static final int gcV = "fullXml".hashCode();
    private static final int gcW = "msgInfoId".hashCode();
    private static final int gcX = "netTimes".hashCode();
    private static final int gcY = "isUseCdn".hashCode();
    private static final int gcZ = "signature".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gda = "fakeAeskey".hashCode();
    private static final int gdb = "fakeSignature".hashCode();
    public String field_appId;
    public String field_clientAppDataId;
    public long field_createTime;
    public String field_fakeAeskey;
    public String field_fakeSignature;
    public String field_fileFullPath;
    public String field_fullXml;
    public boolean field_isUpload;
    public int field_isUseCdn;
    public long field_lastModifyTime;
    public String field_mediaId;
    public String field_mediaSvrId;
    public long field_msgInfoId;
    public long field_netTimes;
    public long field_offset;
    public long field_sdkVer;
    public String field_signature;
    public long field_status;
    public long field_totalLen;
    public long field_type;
    private boolean gaW = true;
    private boolean gbB = true;
    private boolean gbE = true;
    private boolean gcA = true;
    private boolean gcB = true;
    private boolean gcC = true;
    private boolean gcD = true;
    private boolean gcE = true;
    private boolean gcF = true;
    private boolean gcG = true;
    private boolean gcH = true;
    private boolean gcI = true;
    private boolean gcJ = true;
    private boolean gcK = true;
    private boolean gcu = true;
    private boolean gcv = true;
    private boolean gcw = true;
    private boolean gcx = true;
    private boolean gcy = true;
    private boolean gcz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gcL == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gcM == hashCode) {
                    this.field_sdkVer = cursor.getLong(i);
                } else if (gcN == hashCode) {
                    this.field_mediaSvrId = cursor.getString(i);
                } else if (gcO == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (gcP == hashCode) {
                    this.field_clientAppDataId = cursor.getString(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getLong(i);
                } else if (gcQ == hashCode) {
                    this.field_totalLen = cursor.getLong(i);
                } else if (gcR == hashCode) {
                    this.field_offset = cursor.getLong(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getLong(i);
                } else if (gcS == hashCode) {
                    this.field_isUpload = cursor.getInt(i) != 0;
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gcT == hashCode) {
                    this.field_lastModifyTime = cursor.getLong(i);
                } else if (gcU == hashCode) {
                    this.field_fileFullPath = cursor.getString(i);
                } else if (gcV == hashCode) {
                    this.field_fullXml = cursor.getString(i);
                } else if (gcW == hashCode) {
                    this.field_msgInfoId = cursor.getLong(i);
                } else if (gcX == hashCode) {
                    this.field_netTimes = cursor.getLong(i);
                } else if (gcY == hashCode) {
                    this.field_isUseCdn = cursor.getInt(i);
                } else if (gcZ == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (gda == hashCode) {
                    this.field_fakeAeskey = cursor.getString(i);
                } else if (gdb == hashCode) {
                    this.field_fakeSignature = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gcu) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gcv) {
            contentValues.put("sdkVer", Long.valueOf(this.field_sdkVer));
        }
        if (this.gcw) {
            contentValues.put("mediaSvrId", this.field_mediaSvrId);
        }
        if (this.gcx) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.gcy) {
            contentValues.put("clientAppDataId", this.field_clientAppDataId);
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Long.valueOf(this.field_type));
        }
        if (this.gcz) {
            contentValues.put("totalLen", Long.valueOf(this.field_totalLen));
        }
        if (this.gcA) {
            contentValues.put("offset", Long.valueOf(this.field_offset));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Long.valueOf(this.field_status));
        }
        if (this.gcB) {
            contentValues.put("isUpload", Boolean.valueOf(this.field_isUpload));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gcC) {
            contentValues.put("lastModifyTime", Long.valueOf(this.field_lastModifyTime));
        }
        if (this.gcD) {
            contentValues.put("fileFullPath", this.field_fileFullPath);
        }
        if (this.gcE) {
            contentValues.put("fullXml", this.field_fullXml);
        }
        if (this.gcF) {
            contentValues.put("msgInfoId", Long.valueOf(this.field_msgInfoId));
        }
        if (this.gcG) {
            contentValues.put("netTimes", Long.valueOf(this.field_netTimes));
        }
        if (this.gcH) {
            contentValues.put("isUseCdn", Integer.valueOf(this.field_isUseCdn));
        }
        if (this.gcI) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.gcJ) {
            contentValues.put("fakeAeskey", this.field_fakeAeskey);
        }
        if (this.gcK) {
            contentValues.put("fakeSignature", this.field_fakeSignature);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
