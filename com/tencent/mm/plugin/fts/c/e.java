package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends a {
    public SQLiteStatement mct;
    public SQLiteStatement mcu;
    public SQLiteStatement mcv;

    protected final String getTableName() {
        return "TopHits";
    }

    public final String getName() {
        return "FTS5TopHitsStorage";
    }

    public final int getType() {
        return 1;
    }

    public final int getPriority() {
        return 768;
    }

    protected final void tR() {
        if (tS()) {
            this.lYU.i(-100, 2);
        }
        this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[]{axE(), axE()}));
        this.lYU.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[]{axE(), axE()}));
        this.mct = this.lYU.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{axF()}));
        this.mcu = this.lYU.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{axE()}));
        this.mcv = this.lYU.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[]{axE()}));
    }

    public final int axU() {
        Cursor rawQuery = this.lYU.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[]{axE()}), null);
        List<h> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            h hVar = new h();
            hVar.b(rawQuery);
            arrayList.add(hVar);
        }
        rawQuery.close();
        List linkedList = new LinkedList();
        Object linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (h hVar2 : arrayList) {
            h hVar22;
            g fTSIndexStorage;
            if (hVar22.type == 262144) {
                fTSIndexStorage = ((l) com.tencent.mm.kernel.h.j(l.class)).getFTSIndexStorage(17);
            } else {
                fTSIndexStorage = ((l) com.tencent.mm.kernel.h.j(l.class)).getFTSIndexStorage(3);
            }
            String aX = fTSIndexStorage.aX(hVar22.lZO, hVar22.hPr);
            if (bg.mA(aX)) {
                linkedList2.add(Long.valueOf(hVar22.mak));
            } else if (hVar22.fRM.equals("​chatroom_tophits")) {
                String str = "";
                for (String str2 : c.a.lZz.split(hVar22.man)) {
                    if (aX.indexOf(str2) >= 0) {
                        str = str + str2 + "​";
                    }
                }
                if (hVar22.man.equals(str)) {
                    linkedList.add(Long.valueOf(hVar22.mak));
                } else {
                    hVar22.man = str;
                    linkedList2.add(Long.valueOf(hVar22.mak));
                    linkedList3.add(hVar22);
                }
            } else if (hVar22.man.equals(aX)) {
                linkedList.add(Long.valueOf(hVar22.mak));
            } else {
                hVar22.man = aX;
                linkedList2.add(Long.valueOf(hVar22.mak));
                linkedList3.add(hVar22);
            }
        }
        w.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList.size())});
        if (linkedList2.size() > 0) {
            aC(linkedList2);
        }
        if (linkedList3.size() > 0) {
            boolean inTransaction = this.lYU.inTransaction();
            if (!inTransaction) {
                this.lYU.beginTransaction();
            }
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                hVar22 = (h) it.next();
                if (!bg.mA(hVar22.man)) {
                    this.mct.bindString(1, hVar22.man);
                    this.mct.execute();
                    this.mcu.bindLong(1, (long) hVar22.type);
                    this.mcu.bindLong(2, (long) hVar22.hPr);
                    this.mcu.bindLong(3, hVar22.mam);
                    this.mcu.bindString(4, hVar22.lZO);
                    this.mcu.bindLong(5, hVar22.timestamp);
                    this.mcu.bindString(6, hVar22.fRM);
                    this.mcu.bindLong(7, hVar22.mal);
                    this.mcu.bindLong(8, hVar22.hoE);
                    this.mcu.bindString(9, hVar22.man);
                    this.mcu.execute();
                }
            }
            if (!inTransaction) {
                commit();
            }
        }
        if (linkedList.size() > 0) {
            f(linkedList, 0);
        }
        return linkedList2.size();
    }

    protected final boolean tT() {
        super.tT();
        this.mct.close();
        this.mcu.close();
        this.mcv.close();
        return true;
    }

    protected final String axG() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[]{axE()});
    }

    protected final boolean tS() {
        return !cb(-100, 2);
    }
}
