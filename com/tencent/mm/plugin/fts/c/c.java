package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    public SQLiteStatement mcq;
    private SQLiteStatement mcr;

    protected final void tR() {
        if (tS()) {
            this.lYU.i(-105, 3);
            this.lYU.i(-200, Long.MAX_VALUE);
        }
        this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{axE(), axE()}));
        this.mcq = this.lYU.compileStatement(String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[]{axE()}));
        this.mcr = this.lYU.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{axE()}));
    }

    protected final boolean tT() {
        this.mcq.close();
        this.mcr.close();
        return super.tT();
    }

    protected final String getTableName() {
        return "Message";
    }

    public final String getName() {
        return "FTS5MessageStorage";
    }

    public final int getType() {
        return 4;
    }

    public final int getPriority() {
        return 4;
    }

    public final void a(int[] iArr, long j, long j2) {
        List arrayList = new ArrayList(4);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.k(iArr) + " AND entity_id=? AND timestamp=?;", new Object[]{axE()});
        Cursor rawQuery = this.lYU.rawQuery(format, new String[]{Long.toString(j), Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aC(arrayList);
    }

    public final Cursor b(String[] strArr, List<String> list) {
        String s = d.s(strArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("',");
        }
        String str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        return this.lYU.rawQuery(String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[]{Integer.valueOf(list.size()), axE(), axF(), axE(), axF(), axF(), s, str2}), null);
    }

    protected final boolean tS() {
        return !cb(-105, 3);
    }

    protected final String axG() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[]{axE()});
    }

    public final void a(int i, long j, String str, long j2, String str2, String str3) {
        try {
            this.lYV.bindString(1, str2);
            this.lYV.execute();
            this.mcr.bindLong(1, 65536);
            this.mcr.bindLong(2, (long) i);
            this.mcr.bindLong(3, j);
            this.mcr.bindString(4, str);
            this.mcr.bindLong(5, j2);
            this.mcr.bindString(6, str3);
            this.mcr.execute();
        } catch (SQLiteException e) {
            w.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(65536), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.lZc.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                w.e("MicroMsg.FTS.FTS5MessageStorage", ">> " + simpleQueryForString);
            }
            throw e;
        }
    }
}
