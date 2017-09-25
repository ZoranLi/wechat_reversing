package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cx extends c {
    private static final int gCv = "fileNameHash".hashCode();
    private static final int gCw = "fileMd5".hashCode();
    private static final int gCx = "fileLength".hashCode();
    private static final int gCy = "fileStatus".hashCode();
    private static final int gCz = "fileDuration".hashCode();
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gbX = "createTime".hashCode();
    private static final int gpn = "localId".hashCode();
    private static final int gqM = DownloadInfo.FILENAME.hashCode();
    public long field_createTime;
    public int field_fileDuration;
    public long field_fileLength;
    public String field_fileMd5;
    public String field_fileName;
    public int field_fileNameHash;
    public int field_fileStatus;
    public int field_localId;
    private boolean gCq = true;
    private boolean gCr = true;
    private boolean gCs = true;
    private boolean gCt = true;
    private boolean gCu = true;
    private boolean gbB = true;
    private boolean gpl = true;
    private boolean gqt = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpn == hashCode) {
                    this.field_localId = cursor.getInt(i);
                    this.gpl = true;
                } else if (gqM == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gCv == hashCode) {
                    this.field_fileNameHash = cursor.getInt(i);
                } else if (gCw == hashCode) {
                    this.field_fileMd5 = cursor.getString(i);
                } else if (gCx == hashCode) {
                    this.field_fileLength = cursor.getLong(i);
                } else if (gCy == hashCode) {
                    this.field_fileStatus = cursor.getInt(i);
                } else if (gCz == hashCode) {
                    this.field_fileDuration = cursor.getInt(i);
                } else if (gbX == hashCode) {
                    this.field_createTime = cursor.getLong(i);
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
        if (this.gqt) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gCq) {
            contentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
        }
        if (this.field_fileMd5 == null) {
            this.field_fileMd5 = "";
        }
        if (this.gCr) {
            contentValues.put("fileMd5", this.field_fileMd5);
        }
        if (this.gCs) {
            contentValues.put("fileLength", Long.valueOf(this.field_fileLength));
        }
        if (this.gCt) {
            contentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
        }
        if (this.gCu) {
            contentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
        }
        if (this.gbB) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
