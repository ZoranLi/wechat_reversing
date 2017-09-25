package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public final class e extends com.tencent.mm.plugin.fts.a.b {
    private k gTU;
    public com.tencent.mm.plugin.fts.c.e mbW;
    HashSet<String> mbX;

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        int mbY;
        int mbZ;
        final /* synthetic */ e mca;

        public a(e eVar) {
            this.mca = eVar;
        }

        public final boolean execute() {
            this.mbZ = this.mca.mbW.axU();
            long currentTimeMillis = System.currentTimeMillis() - 5184000000L;
            com.tencent.mm.plugin.fts.a.a aVar = this.mca.mbW;
            String format = String.format("SELECT docid FROM %s WHERE timestamp < ? OR score = 0;", new Object[]{aVar.axE()});
            Cursor rawQuery = aVar.lYU.rawQuery(format, new String[]{String.valueOf(currentTimeMillis)});
            Object linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                linkedList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            aVar.aC(linkedList);
            this.mbY = linkedList.size();
            return true;
        }

        public final String toString() {
            return String.format("BuildTopHitsIndexTask [%d] [%d]", new Object[]{Integer.valueOf(this.mbZ), Integer.valueOf(this.mbY)});
        }

        public final String getName() {
            return "BuildTopHitsIndexTask";
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.e {
        private int[] gUn;
        final /* synthetic */ e mca;
        private int scene;

        public b(e eVar, f fVar) {
            this.mca = eVar;
            super(fVar);
            this.gUn = fVar.maa;
            this.scene = fVar.scene;
        }

        protected final List<i> a(String[] strArr, f fVar) {
            HashSet hashSet = new HashSet();
            List<i> linkedList = new LinkedList();
            com.tencent.mm.plugin.fts.a.a aVar = this.mca.mbW;
            String str = this.lZW.fRM;
            int[] iArr = this.gUn;
            int i = this.scene;
            int size = fVar.mad + fVar.mae.size();
            String str2 = str.trim() + '%';
            str = d.s(strArr);
            String str3 = "query LIKE ?";
            String format = String.format("AND %s MATCH '%s'", new Object[]{aVar.axF(), str});
            String str4 = "AND type IN " + d.k(iArr);
            String str5 = "AND status >= 0 AND score >= 3";
            str = size > 0 ? "LIMIT " + size : "";
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, 1, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[]{aVar.axE(), aVar.axF(), aVar.axF(), aVar.axE(), str3, format, str4, "AND scene=?", str5, aVar.axE(), aVar.axF(), str}), new String[]{str2, String.valueOf(i)});
            while (rawQuery.moveToNext()) {
                j e;
                try {
                    e = new j().e(rawQuery);
                    if (hashSet.add(e.lZO)) {
                        e.axK();
                        e.userData = "";
                        if (e.type == 262144) {
                            e.userData = ((com.tencent.mm.plugin.fts.c.b) ((l) h.j(l.class)).getFTSIndexStorage(17)).mR((int) e.mam);
                            if (e.userData == null) {
                                continue;
                            }
                        }
                        linkedList.add(e);
                        if (linkedList.size() >= fVar.mad) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    rawQuery.close();
                }
            }
            rawQuery.close();
            w.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[]{Integer.valueOf(linkedList.size())});
            if (strArr.length <= 1) {
                return linkedList;
            }
            List<i> subList;
            if (linkedList.size() > 2) {
                subList = linkedList.subList(0, 2);
            } else {
                subList = linkedList;
            }
            hashSet.clear();
            for (int i2 = 0; i2 < subList.size(); i2++) {
                hashSet.add(((i) subList.get(i2)).lZO);
            }
            HashSet hashSet2 = new HashSet();
            com.tencent.mm.plugin.fts.a.a aVar2 = this.mca.mbW;
            iArr = this.gUn;
            i = this.scene;
            size = fVar.mad + fVar.mae.size();
            str2 = d.s(strArr);
            Cursor rawQuery2 = aVar2.lYU.rawQuery(String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + i + (" AND type IN " + d.k(iArr)) + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[]{aVar2.axF(), str2}) + " ORDER BY score desc limit " + size + ";", new Object[]{aVar2.axE(), aVar2.axF(), aVar2.axE(), aVar2.axF(), aVar2.axE(), aVar2.axF()}), new String[]{"​chatroom_tophits"});
            while (rawQuery2.moveToNext()) {
                str4 = rawQuery2.getString(0);
                if (!hashSet.contains(str4)) {
                    hashSet2.add(str4);
                }
            }
            rawQuery2.close();
            com.tencent.mm.plugin.fts.c.a aVar3 = (com.tencent.mm.plugin.fts.c.a) ((l) h.j(l.class)).getFTSIndexStorage(3);
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                String str6 = (String) it.next();
                str4 = d.s(strArr);
                Cursor rawQuery3 = aVar3.lYU.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, 1, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38" + ";", new Object[]{aVar3.axE(), aVar3.axF(), aVar3.axE(), aVar3.axF(), aVar3.axE(), aVar3.axF(), aVar3.axF(), str4}), new String[]{str6});
                if (rawQuery3.moveToNext()) {
                    e = new j().e(rawQuery3);
                    e.userData = "​chatroom_tophits";
                    e.axK();
                    subList.add(e);
                    if (subList.size() >= fVar.mad) {
                        return subList;
                    }
                }
                rawQuery3.close();
            }
            return subList;
        }

        public final String getName() {
            return "SearchTopHitsTask";
        }

        public final int getId() {
            return 8;
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        public String fRM;
        public HashMap<String, String> lZF;
        final /* synthetic */ e mca;
        public i mcb;
        public int scene;

        public c(e eVar) {
            this.mca = eVar;
        }

        public final boolean execute() {
            int i;
            int i2;
            com.tencent.mm.plugin.fts.a.a aVar = this.mca.mbW;
            String str = this.fRM;
            i iVar = this.mcb;
            int i3 = this.scene;
            HashMap hashMap = this.lZF;
            Object trim = str.trim();
            hashMap.remove(iVar.lZO);
            boolean inTransaction = aVar.lYU.inTransaction();
            if (!inTransaction) {
                aVar.lYU.beginTransaction();
            }
            long currentTimeMillis = System.currentTimeMillis();
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[]{aVar.axE()}), new String[]{trim, iVar.lZO, String.valueOf(iVar.hPr), String.valueOf(i3)});
            if (rawQuery.moveToNext()) {
                int i4 = rawQuery.getInt(0);
                i = rawQuery.getInt(1);
                i2 = i4;
            } else {
                i = -1;
                i2 = -1;
            }
            rawQuery.close();
            String str2 = "";
            for (Entry entry : hashMap.entrySet()) {
                str2 = !((String) entry.getValue()).equals("​chatroom_tophits") ? str2 + "'" + ((String) entry.getKey()) + "'," : str2;
            }
            if (str2.length() > 0) {
                str = "AND aux_index IN (" + str2.substring(0, str2.length() - 1) + ")";
                aVar.lYU.execSQL(String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[]{aVar.axE(), Integer.valueOf(i3), str}));
            }
            str2 = "";
            for (Entry entry2 : hashMap.entrySet()) {
                str2 = ((String) entry2.getValue()).equals("​chatroom_tophits") ? str2 + "'" + ((String) entry2.getKey()) + "'," : str2;
            }
            if (str2.length() > 0) {
                str = "AND aux_index IN(" + str2.substring(0, str2.length() - 1) + ")";
                aVar.lYU.execSQL(String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[]{aVar.axE(), Integer.valueOf(i3), str}), new String[]{"​chatroom_tophits"});
            }
            if (i2 < 0 || i < 0) {
                aVar.mct.bindString(1, iVar.content);
                aVar.mct.execute();
                aVar.mcu.bindLong(1, (long) iVar.type);
                aVar.mcu.bindLong(2, (long) iVar.hPr);
                aVar.mcu.bindLong(3, iVar.mam);
                aVar.mcu.bindString(4, iVar.lZO);
                aVar.mcu.bindLong(5, currentTimeMillis);
                aVar.mcu.bindString(6, trim);
                aVar.mcu.bindLong(7, 3);
                aVar.mcu.bindLong(8, (long) i3);
                aVar.mcu.bindString(9, iVar.content);
                aVar.mcu.execute();
            } else {
                int i5 = i > 6 ? i + 1 : i + 3;
                aVar.lYU.execSQL(String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[]{aVar.axE()}), new String[]{String.valueOf(i5), String.valueOf(currentTimeMillis), String.valueOf(i2)});
            }
            if (!inTransaction) {
                aVar.lYU.commit();
            }
            String[] split = com.tencent.mm.plugin.fts.a.c.a.lZD.split(trim);
            if (split.length > 1 && iVar.type == 131075 && iVar.hPr == 38) {
                HashSet hashSet = new HashSet();
                com.tencent.mm.plugin.fts.a.a.h hVar = new com.tencent.mm.plugin.fts.a.a.h();
                Cursor rawQuery2 = aVar.lYU.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[]{aVar.axE()}), new String[]{iVar.lZO, "​chatroom_tophits"});
                if (rawQuery2.moveToNext()) {
                    hVar.b(rawQuery2);
                    for (Object add : com.tencent.mm.plugin.fts.a.c.a.lZz.split(hVar.man)) {
                        hashSet.add(add);
                    }
                }
                rawQuery2.close();
                i4 = 0;
                while (i4 < iVar.mau.size() && i4 < split.length) {
                    com.tencent.mm.plugin.fts.a.a.d dVar = (com.tencent.mm.plugin.fts.a.a.d) iVar.mau.get(i4);
                    if (hashSet.add(dVar.content)) {
                        hVar.man += dVar.content + "​";
                    }
                    i4++;
                }
                w.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[]{hVar.man});
                if (hVar.mak > 0) {
                    aVar.h(Long.valueOf(hVar.mak));
                }
                hVar.mak = 0;
                hVar.fRM = "​chatroom_tophits";
                hVar.mal++;
                hVar.hoE = (long) i3;
                hVar.lZO = iVar.lZO;
                hVar.mam = iVar.mam;
                hVar.type = iVar.type;
                hVar.hPr = iVar.hPr;
                hVar.timestamp = currentTimeMillis;
                aVar.mct.bindString(1, hVar.man);
                aVar.mct.execute();
                aVar.mcu.bindLong(1, (long) hVar.type);
                aVar.mcu.bindLong(2, (long) hVar.hPr);
                aVar.mcu.bindLong(3, hVar.mam);
                aVar.mcu.bindString(4, hVar.lZO);
                aVar.mcu.bindLong(5, hVar.timestamp);
                aVar.mcu.bindString(6, hVar.fRM);
                aVar.mcu.bindLong(7, hVar.mal);
                aVar.mcu.bindLong(8, hVar.hoE);
                aVar.mcu.bindString(9, hVar.man);
                aVar.mcu.execute();
            }
            return true;
        }

        public final String toString() {
            return String.format("%s : query=%s scene=%d", new Object[]{super.toString(), this.fRM, Integer.valueOf(this.scene)});
        }

        public final String getName() {
            return "UpdateTopHitsWithQueryTask";
        }
    }

    protected final boolean onCreate() {
        if (((l) h.j(l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
            this.mbX = new HashSet();
            this.mbW = (com.tencent.mm.plugin.fts.c.e) ((l) h.j(l.class)).getFTSIndexStorage(1);
            this.gTU = ((l) h.j(l.class)).getFTSTaskDaemon();
            this.gTU.a(65626, new a(this));
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        if (this.mbX != null) {
            this.mbX.clear();
        }
        this.mbW = null;
        this.gTU = null;
        return true;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(f fVar) {
        return this.gTU.a(-65536, new b(this, fVar));
    }

    public final void xf(String str) {
        if (this.mbX.add(str)) {
            com.tencent.mm.plugin.fts.c.e eVar = this.mbW;
            eVar.mcv.bindLong(1, 1);
            eVar.mcv.bindString(2, str);
            eVar.mcv.execute();
        }
    }

    public final void c(int[] iArr, String str) {
        this.mbW.a(iArr, str);
    }

    public final String getName() {
        return "FTS5SearchTopHitsLogic";
    }

    public final void a(String str, i iVar, int i, HashMap<String, String> hashMap) {
        com.tencent.mm.plugin.fts.a.a.a cVar = new c(this);
        cVar.fRM = str;
        cVar.mcb = iVar;
        cVar.scene = i;
        cVar.lZF = hashMap;
        this.gTU.a(65626, cVar);
    }
}
