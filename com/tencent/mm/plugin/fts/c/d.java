package com.tencent.mm.plugin.fts.c;

import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d implements g {
    private boolean lYR;
    private boolean lYS;
    public f lYU;
    public SQLiteStatement lYV;
    public SQLiteStatement lYW;
    public SQLiteStatement mcs;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return 0;
    }

    public d() {
        w.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[]{"FTS5SOSHistoryStorage"});
    }

    public final void create() {
        w.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[]{"FTS5SOSHistoryStorage", Boolean.valueOf(this.lYR)});
        if (!this.lYR) {
            int i;
            if (((l) h.j(l.class)).isFTSContextReady()) {
                this.lYU = ((l) h.j(l.class)).getFTSIndexDB();
                w.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
                if (this.lYU.wT(axF()) && this.lYU.wT(axE())) {
                    w.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
                } else {
                    w.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{axF()});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{axE()});
                    this.lYU.execSQL(format);
                    this.lYU.execSQL(format2);
                    this.lYU.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{axF()}));
                    this.lYU.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, history TEXT, timestamp INTEGER);", new Object[]{axE()}));
                    this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_history ON %s(history);", new Object[]{axE()}));
                    this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[]{axE()}));
                }
                this.lYV = this.lYU.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{axF()}));
                this.lYW = this.lYU.compileStatement(String.format("INSERT INTO %s (docid, history, timestamp) VALUES (last_insert_rowid(), ?, ?);", new Object[]{axE()}));
                this.mcs = this.lYU.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE docid = ?", new Object[]{axE()}));
                boolean z = true;
            } else {
                w.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
                i = 0;
            }
            if (i != 0) {
                w.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
                this.lYR = true;
            }
        }
    }

    public final void destroy() {
        w.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{"FTS5SOSHistoryStorage", Boolean.valueOf(this.lYS), Boolean.valueOf(this.lYR)});
        if (!this.lYS && this.lYR) {
            this.lYV.close();
            this.mcs.close();
            this.lYW.close();
            w.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
            this.lYS = true;
        }
    }

    public final String getName() {
        return "FTS5SOSHistoryStorage";
    }

    public final int getType() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public final int getPriority() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public static String axE() {
        return new StringBuilder("FTS5MetaSOSHistory").toString();
    }

    public static String axF() {
        return new StringBuilder("FTS5IndexSOSHistory").toString();
    }

    public final String aX(String str, int i) {
        return null;
    }
}
