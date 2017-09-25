package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement mco;

    public static class a {
        public int mcp;
        public long timestamp;
    }

    protected final void tR() {
        if (tS()) {
            this.lYU.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{"Feature"}));
            i(-101, 1);
        }
        if (!this.lYU.wT("Feature")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CREATE TABLE IF NOT EXISTS Feature ( ");
            stringBuilder.append(c.gTP.uxe);
            stringBuilder.append(");");
            this.lYU.execSQL(stringBuilder.toString());
        }
        this.mco = this.lYU.compileStatement(String.format("INSERT INTO %s (featureId, title, titlePY, titleShortPY, tag, actionType, url, helpUrl, updateUrl, androidUrl, iconPath, timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{"Feature"}));
    }

    protected final boolean tS() {
        return !cb(-101, 1);
    }

    public final List<a> axT() {
        List<a> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.lYU.rawQuery(String.format("SELECT entity_id, timestamp FROM %s", new Object[]{axE()}), null);
        while (rawQuery.moveToNext()) {
            int i = rawQuery.getInt(0);
            if (hashSet.add(Integer.valueOf(i))) {
                a aVar = new a();
                aVar.mcp = i;
                aVar.timestamp = rawQuery.getLong(1);
                arrayList.add(aVar);
            }
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean aE(List<c> list) {
        boolean inTransaction = this.lYU.inTransaction();
        if (!inTransaction) {
            this.lYU.beginTransaction();
        }
        this.lYU.execSQL("Delete from Feature");
        for (c cVar : list) {
            try {
                this.mco.bindLong(1, (long) cVar.field_featureId);
                this.mco.bindString(2, cVar.field_title);
                this.mco.bindString(3, cVar.field_titlePY);
                this.mco.bindString(4, cVar.field_titleShortPY);
                this.mco.bindString(5, cVar.field_tag);
                this.mco.bindLong(6, (long) cVar.field_actionType);
                this.mco.bindString(7, cVar.field_url);
                this.mco.bindString(8, cVar.field_helpUrl);
                this.mco.bindString(9, cVar.field_updateUrl);
                this.mco.bindString(10, cVar.field_androidUrl);
                this.mco.bindString(11, cVar.field_iconPath);
                this.mco.bindLong(12, cVar.field_timestamp);
                long executeInsert = this.mco.executeInsert();
                w.d("MicroMsg.FTS.FTS5FeatureStorage", "insertFeatureItem rowid=%d timestamp=%d", new Object[]{Long.valueOf(executeInsert), Long.valueOf(cVar.field_timestamp)});
            } catch (Exception e) {
            }
        }
        if (!inTransaction) {
            this.lYU.commit();
        }
        return true;
    }

    public final c mR(int i) {
        c cVar = null;
        Cursor rawQuery = this.lYU.rawQuery("Select * from Feature where featureId = " + i, null);
        try {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.b(rawQuery);
                rawQuery.close();
            }
            return cVar;
        } finally {
            rawQuery.close();
        }
    }

    protected final String getTableName() {
        return "Feature";
    }

    public final String getName() {
        return "FTS5FeatureStorage";
    }

    public final int getType() {
        return 17;
    }

    public final int getPriority() {
        return 17;
    }

    protected final boolean tT() {
        super.tT();
        this.mco.close();
        return true;
    }

    protected final boolean axH() {
        return true;
    }
}
