package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public SQLiteStatement mch;
    public SQLiteStatement mci;
    private SQLiteStatement mcj;
    public SQLiteStatement mck;
    public SQLiteStatement mcl;
    private SQLiteStatement mcm;
    public SQLiteStatement mcn;

    protected final void tR() {
        if (tS()) {
            this.lYU.i(-102, 2);
        }
        this.lYU.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
        this.lYU.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
        this.lYU.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
        this.lYU.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
        this.lYU.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
        this.lYU.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
        this.mch = this.lYU.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
        this.mci = this.lYU.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
        this.mcj = this.lYU.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
        this.mck = this.lYU.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
        this.mcl = this.lYU.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
        this.mcm = this.lYU.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
        this.mcn = this.lYU.compileStatement("SELECT changes();");
    }

    protected final boolean tT() {
        super.tT();
        this.mch.close();
        this.mci.close();
        this.mcj.close();
        this.mck.close();
        this.mcl.close();
        this.mcm.close();
        this.mcn.close();
        return true;
    }

    public final void g(String str, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            boolean inTransaction = this.lYU.inTransaction();
            if (!inTransaction) {
                this.lYU.beginTransaction();
            }
            this.mck.bindString(1, str);
            for (Long longValue : list) {
                this.mck.bindLong(2, longValue.longValue());
                this.mck.execute();
            }
            if (!inTransaction) {
                this.lYU.commit();
            }
        }
    }

    public final void xg(String str) {
        this.mcm.bindString(1, str);
        this.mcm.execute();
    }

    public final Cursor xh(String str) {
        return this.lYU.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[]{str});
    }

    public final void i(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            boolean inTransaction = this.lYU.inTransaction();
            if (!inTransaction) {
                this.lYU.beginTransaction();
            }
            this.mch.bindString(1, str);
            for (String bindString : strArr) {
                this.mch.bindString(2, bindString);
                this.mch.execute();
            }
            if (!inTransaction) {
                this.lYU.commit();
            }
        }
    }

    public final void xi(String str) {
        this.mcj.bindString(1, str);
        this.mcj.execute();
    }

    protected final String getTableName() {
        return "Contact";
    }

    public final String getName() {
        return "FTS5ContactStorage";
    }

    public final int getType() {
        return 3;
    }

    public final int getPriority() {
        return 3;
    }

    protected final String axG() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{axE()});
    }

    protected final boolean tS() {
        return !cb(-102, 2);
    }

    public final boolean v(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder(32);
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append(strArr[i]);
            stringBuilder.append("*");
            if (i != strArr.length - 1) {
                stringBuilder.append(" OR ");
            }
        }
        Cursor rawQuery = this.lYU.rawQuery(String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[]{axE(), axF(), axE(), axF(), axF(), stringBuilder.toString()}), null);
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    protected final boolean axH() {
        return true;
    }
}
