package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.rq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.IOException;
import java.lang.reflect.Field;

public abstract class az extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS FavModInfo_LocalId_Index ON FavEditInfo(localId)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gcs = "scene".hashCode();
    private static final int giv = "time".hashCode();
    private static final int gpn = "localId".hashCode();
    private static final int gpo = "modItem".hashCode();
    public long field_localId;
    public rq field_modItem;
    public int field_scene;
    public long field_time;
    public int field_type;
    private boolean gbE = true;
    private boolean gcq = true;
    private boolean gic = true;
    private boolean gpl = true;
    private boolean gpm = true;

    public static a pw() {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "localId";
        aVar.uxd.put("localId", "LONG");
        stringBuilder.append(" localId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "modItem";
        aVar.uxd.put("modItem", "BLOB");
        stringBuilder.append(" modItem BLOB");
        stringBuilder.append(", ");
        aVar.columns[2] = "time";
        aVar.uxd.put("time", "LONG");
        stringBuilder.append(" time LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "scene";
        aVar.uxd.put("scene", "INTEGER default '1' ");
        stringBuilder.append(" scene INTEGER default '1' ");
        aVar.columns[5] = "rowid";
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
                } else if (gpo == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_modItem = (rq) new rq().aD(blob);
                        }
                    } catch (IOException e) {
                        w.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
                    }
                } else if (giv == hashCode) {
                    this.field_time = cursor.getLong(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gcs == hashCode) {
                    this.field_scene = cursor.getInt(i);
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
        if (this.gpm && this.field_modItem != null) {
            try {
                contentValues.put("modItem", this.field_modItem.toByteArray());
            } catch (IOException e) {
                w.e("MicroMsg.SDK.BaseFavEditInfo", e.getMessage());
            }
        }
        if (this.gic) {
            contentValues.put("time", Long.valueOf(this.field_time));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gcq) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }
}
