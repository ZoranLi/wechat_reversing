package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public abstract class cm extends c {
    public static final String[] gaK = new String[0];
    private static final int gaT = "rowid".hashCode();
    private static final int gqM = DownloadInfo.FILENAME.hashCode();
    private static final int gyJ = "musicId".hashCode();
    private static final int gzI = "musicUrl".hashCode();
    private static final int gzJ = "indexBitData".hashCode();
    private static final int gzK = "fileCacheComplete".hashCode();
    private static final int gzL = "pieceFileMIMEType".hashCode();
    public int field_fileCacheComplete;
    public String field_fileName;
    public byte[] field_indexBitData;
    public String field_musicId;
    public String field_musicUrl;
    public String field_pieceFileMIMEType;
    private boolean gqt = true;
    private boolean gyg = true;
    private boolean gzE = true;
    private boolean gzF = true;
    private boolean gzG = true;
    private boolean gzH = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "musicId";
        aVar.uxd.put("musicId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" musicId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "musicId";
        aVar.columns[1] = "musicUrl";
        aVar.uxd.put("musicUrl", "TEXT");
        stringBuilder.append(" musicUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = DownloadInfo.FILENAME;
        aVar.uxd.put(DownloadInfo.FILENAME, "TEXT");
        stringBuilder.append(" fileName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "indexBitData";
        aVar.uxd.put("indexBitData", "BLOB");
        stringBuilder.append(" indexBitData BLOB");
        stringBuilder.append(", ");
        aVar.columns[4] = "fileCacheComplete";
        aVar.uxd.put("fileCacheComplete", "INTEGER");
        stringBuilder.append(" fileCacheComplete INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "pieceFileMIMEType";
        aVar.uxd.put("pieceFileMIMEType", "TEXT");
        stringBuilder.append(" pieceFileMIMEType TEXT");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gyJ == hashCode) {
                    this.field_musicId = cursor.getString(i);
                    this.gyg = true;
                } else if (gzI == hashCode) {
                    this.field_musicUrl = cursor.getString(i);
                } else if (gqM == hashCode) {
                    this.field_fileName = cursor.getString(i);
                } else if (gzJ == hashCode) {
                    this.field_indexBitData = cursor.getBlob(i);
                } else if (gzK == hashCode) {
                    this.field_fileCacheComplete = cursor.getInt(i);
                } else if (gzL == hashCode) {
                    this.field_pieceFileMIMEType = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gyg) {
            contentValues.put("musicId", this.field_musicId);
        }
        if (this.gzE) {
            contentValues.put("musicUrl", this.field_musicUrl);
        }
        if (this.gqt) {
            contentValues.put(DownloadInfo.FILENAME, this.field_fileName);
        }
        if (this.gzF) {
            contentValues.put("indexBitData", this.field_indexBitData);
        }
        if (this.gzG) {
            contentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
        }
        if (this.gzH) {
            contentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
