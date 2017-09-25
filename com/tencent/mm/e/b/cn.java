package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class cn extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gaZ = DownloadInfo.STATUS.hashCode();
    private static final int gcO = "mediaId".hashCode();
    private static final int gcQ = "totalLen".hashCode();
    private static final int gcR = "offset".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gnJ = "cdnUrl".hashCode();
    private static final int gpJ = "toUser".hashCode();
    private static final int gpe = "dataId".hashCode();
    private static final int gpg = "cdnKey".hashCode();
    private static final int gph = "path".hashCode();
    private static final int gpn = "localId".hashCode();
    private static final int gqO = "fileType".hashCode();
    private static final int gqY = "errCode".hashCode();
    private static final int gzO = "recordLocalId".hashCode();
    private static final int gzP = "isThumb".hashCode();
    public String field_cdnKey;
    public String field_cdnUrl;
    public String field_dataId;
    public int field_errCode;
    public int field_fileType;
    public boolean field_isThumb;
    public int field_localId;
    public String field_mediaId;
    public int field_offset;
    public String field_path;
    public int field_recordLocalId;
    public int field_status;
    public String field_toUser;
    public int field_totalLen;
    public int field_type;
    private boolean gaW = true;
    private boolean gbE = true;
    private boolean gcA = true;
    private boolean gcx = true;
    private boolean gcz = true;
    private boolean gnm = true;
    private boolean goZ = true;
    private boolean gpb = true;
    private boolean gpc = true;
    private boolean gpl = true;
    private boolean gpv = true;
    private boolean gqF = true;
    private boolean gqv = true;
    private boolean gzM = true;
    private boolean gzN = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpn == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gpl = true;
                } else if (gzO == hashCode) {
                    this.field_recordLocalId = cursor.getInt(i);
                } else if (gpJ == hashCode) {
                    this.field_toUser = cursor.getString(i);
                } else if (gpe == hashCode) {
                    this.field_dataId = cursor.getString(i);
                } else if (gcO == hashCode) {
                    this.field_mediaId = cursor.getString(i);
                } else if (gph == hashCode) {
                    this.field_path = cursor.getString(i);
                } else if (gnJ == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gpg == hashCode) {
                    this.field_cdnKey = cursor.getString(i);
                } else if (gcQ == hashCode) {
                    this.field_totalLen = cursor.getInt(i);
                } else if (gzP == hashCode) {
                    this.field_isThumb = cursor.getInt(i) != 0;
                } else if (gcR == hashCode) {
                    this.field_offset = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gqO == hashCode) {
                    this.field_fileType = cursor.getInt(i);
                } else if (gaZ == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gqY == hashCode) {
                    this.field_errCode = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gpl) {
            contentValues.put("localId", Integer.valueOf(this.field_localId));
        }
        if (this.gzM) {
            contentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
        }
        if (this.field_toUser == null) {
            this.field_toUser = "";
        }
        if (this.gpv) {
            contentValues.put("toUser", this.field_toUser);
        }
        if (this.goZ) {
            contentValues.put("dataId", this.field_dataId);
        }
        if (this.gcx) {
            contentValues.put("mediaId", this.field_mediaId);
        }
        if (this.gpc) {
            contentValues.put("path", this.field_path);
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
        if (this.gzN) {
            contentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
        }
        if (this.gcA) {
            contentValues.put("offset", Integer.valueOf(this.field_offset));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gqv) {
            contentValues.put("fileType", Integer.valueOf(this.field_fileType));
        }
        if (this.gaW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gqF) {
            contentValues.put("errCode", Integer.valueOf(this.field_errCode));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
