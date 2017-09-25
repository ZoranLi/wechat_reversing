package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class bb extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gcf = "content".hashCode();
    private static final int giv = "time".hashCode();
    private static final int gpT = "tagContent".hashCode();
    private static final int gpU = "subtype".hashCode();
    private static final int gpn = "localId".hashCode();
    public String field_content;
    public long field_localId;
    public int field_subtype;
    public String field_tagContent;
    public long field_time;
    public int field_type;
    private boolean gbE = true;
    private boolean gbJ = true;
    private boolean gic = true;
    private boolean gpR = true;
    private boolean gpS = true;
    private boolean gpl = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.uxd.put("localId", "LONG PRIMARY KEY ");
        stringBuilder.append(" localId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "localId";
        aVar.columns[1] = "content";
        aVar.uxd.put("content", "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "tagContent";
        aVar.uxd.put("tagContent", "TEXT");
        stringBuilder.append(" tagContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "time";
        aVar.uxd.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "subtype";
        aVar.uxd.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
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
                if (gpn == hashCode) {
                    this.field_localId = cursor.getLong(i);
                    this.gpl = true;
                } else if (gcf == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gpT == hashCode) {
                    this.field_tagContent = cursor.getString(i);
                } else if (giv == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gpU == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues pv() {
        ContentValues contentValues = new ContentValues();
        if (this.gpl) {
            contentValues.put("localId", Long.valueOf(this.field_localId));
        }
        if (this.gbJ) {
            contentValues.put("content", this.field_content);
        }
        if (this.gpR) {
            contentValues.put("tagContent", this.field_tagContent);
        }
        if (this.gic) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gpS) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
