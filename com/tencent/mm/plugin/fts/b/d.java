package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class d extends com.tencent.mm.plugin.fts.a.b {
    private k gTU;
    public com.tencent.mm.plugin.fts.c.d mbT;

    public class a extends com.tencent.mm.plugin.fts.a.a.a {
        public String mbU;
        final /* synthetic */ d mbV;

        public a(d dVar) {
            this.mbV = dVar;
        }

        public final boolean execute() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.mbU);
            stringBuffer.append("​");
            stringBuffer.append(com.tencent.mm.plugin.fts.a.d.X(this.mbU, false));
            stringBuffer.append("​");
            stringBuffer.append(com.tencent.mm.plugin.fts.a.d.X(this.mbU, true));
            com.tencent.mm.plugin.fts.c.d dVar = this.mbV.mbT;
            String str = this.mbU;
            String stringBuffer2 = stringBuffer.toString();
            Cursor rawQuery = dVar.lYU.rawQuery(String.format("SELECT docid FROM %s WHERE history = ?", new Object[]{com.tencent.mm.plugin.fts.c.d.axE()}), new String[]{str});
            long j = -1;
            if (rawQuery.moveToNext()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
            if (j >= 0) {
                dVar.mcs.bindLong(1, System.currentTimeMillis());
                dVar.mcs.bindLong(2, j);
                dVar.mcs.execute();
            } else {
                if (!dVar.lYU.inTransaction()) {
                    dVar.lYU.beginTransaction();
                }
                dVar.lYV.bindString(1, stringBuffer2);
                dVar.lYV.execute();
                dVar.lYW.bindString(1, str);
                dVar.lYW.bindLong(2, System.currentTimeMillis());
                dVar.lYW.execute();
                if (dVar.lYU.inTransaction()) {
                    dVar.lYU.commit();
                }
            }
            return true;
        }

        public final String getName() {
            return "AddSOSHistoryTask";
        }
    }

    public class b extends com.tencent.mm.plugin.fts.a.a.a {
        public String mbU;
        final /* synthetic */ d mbV;

        public b(d dVar) {
            this.mbV = dVar;
        }

        public final boolean execute() {
            com.tencent.mm.plugin.fts.c.d dVar = this.mbV.mbT;
            String str = this.mbU;
            dVar.lYU.execSQL(String.format("DELETE FROM %s WHERE history = ?;", new Object[]{com.tencent.mm.plugin.fts.c.d.axE()}), new String[]{str});
            return true;
        }

        public final String getName() {
            return "DeleteSOSHistoryTask";
        }
    }

    public class c extends e {
        final /* synthetic */ d mbV;

        public c(d dVar, f fVar) {
            this.mbV = dVar;
            super(fVar);
        }

        protected final List<i> a(String[] strArr, f fVar) {
            Cursor rawQuery;
            List<i> arrayList = new ArrayList();
            com.tencent.mm.plugin.fts.c.d dVar = this.mbV.mbT;
            String str = fVar.fRM;
            int i = fVar.mad;
            if (str.trim().length() > 0) {
                str = com.tencent.mm.plugin.fts.a.d.s(new String[]{str});
                rawQuery = dVar.lYU.rawQuery(String.format("SELECT history FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY timestamp desc LIMIT " + i, new Object[]{com.tencent.mm.plugin.fts.c.d.axE(), com.tencent.mm.plugin.fts.c.d.axF(), com.tencent.mm.plugin.fts.c.d.axE(), com.tencent.mm.plugin.fts.c.d.axF(), com.tencent.mm.plugin.fts.c.d.axF(), str}), null);
            } else {
                rawQuery = dVar.lYU.rawQuery(String.format("SELECT history FROM %s ORDER BY timestamp desc LIMIT " + i, new Object[]{com.tencent.mm.plugin.fts.c.d.axE()}), null);
            }
            while (rawQuery != null && rawQuery.moveToNext()) {
                str = rawQuery.getString(0);
                i jVar = new j();
                jVar.content = str;
                arrayList.add(jVar);
            }
            rawQuery.close();
            return arrayList;
        }

        public final String getName() {
            return "SearchSOSHistoryTask";
        }
    }

    public final String getName() {
        return "FTS5SearchSOSHistoryLogic";
    }

    protected final boolean onCreate() {
        if (((l) h.j(l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Success!");
            this.mbT = (com.tencent.mm.plugin.fts.c.d) ((l) h.j(l.class)).getFTSIndexStorage(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            this.gTU = ((l) h.j(l.class)).getFTSTaskDaemon();
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchSOSHistoryLogic", "Create Fail!");
        return false;
    }

    public final void addSOSHistory(String str) {
        com.tencent.mm.plugin.fts.a.a.a aVar = new a(this);
        aVar.mbU = str;
        this.gTU.a(132072, aVar);
    }

    public final void deleteSOSHistory(String str) {
        com.tencent.mm.plugin.fts.a.a.a bVar = new b(this);
        bVar.mbU = str;
        this.gTU.a(132072, bVar);
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(f fVar) {
        com.tencent.mm.plugin.fts.a.a.a cVar = new c(this, fVar);
        this.gTU.a(-65536, cVar);
        return cVar;
    }

    protected final boolean tT() {
        this.mbT = null;
        this.gTU = null;
        return true;
    }
}
