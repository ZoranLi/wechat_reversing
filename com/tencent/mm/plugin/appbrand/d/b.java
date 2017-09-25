package com.tencent.mm.plugin.appbrand.d;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    public k gTU;
    private com.tencent.mm.sdk.e.j.a iJA = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ b iJB;

        {
            this.iJB = r1;
        }

        public final void a(String str, l lVar) {
            w.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp storage change: event=%s | eventData=%s", new Object[]{str, lVar});
            switch (lVar.uxq) {
                case 2:
                case 3:
                    if (!"batch".equals(str)) {
                        this.iJB.gTU.a(65616, new b(this.iJB, lVar.obj.toString()));
                        return;
                    } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                        for (String bVar : (List) lVar.obj) {
                            this.iJB.gTU.a(65616, new b(this.iJB, bVar));
                        }
                        return;
                    } else {
                        return;
                    }
                case 5:
                    if (!"batch".equals(str)) {
                        this.iJB.gTU.a(65616, new a(this.iJB, lVar.obj.toString()));
                        return;
                    } else if (lVar.obj != null && (lVar.obj instanceof List)) {
                        for (String bVar2 : (List) lVar.obj) {
                            this.iJB.gTU.a(65616, new a(this.iJB, bVar2));
                        }
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    };
    public c iJz;

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b iJB;
        private String id;

        public a(b bVar, String str) {
            this.iJB = bVar;
            this.id = str;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "delete we app info id=%s", new Object[]{this.id});
            this.iJB.iJz.a(com.tencent.mm.plugin.fts.a.c.lZh, this.id);
            return true;
        }

        public final String toString() {
            return String.format("DeleteWeApp [%s]", new Object[]{this.id});
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b iJB;
        private String id;
        private String name;

        public b(b bVar, String str) {
            this.iJB = bVar;
            this.id = str;
        }

        public final boolean execute() {
            this.iJB.iJz.beginTransaction();
            this.iJB.iJz.a(com.tencent.mm.plugin.fts.a.c.lZh, this.id);
            e oV = i.oV(this.id);
            if (oV != null) {
                long currentTimeMillis = System.currentTimeMillis();
                String mz = bg.mz(oV.gSl);
                int hashCode = mz.hashCode();
                this.iJB.iJz.a(393216, 1, (long) hashCode, mz, currentTimeMillis, oV.appName);
                this.iJB.iJz.a(393216, 2, (long) hashCode, mz, currentTimeMillis, com.tencent.mm.platformtools.c.mp(oV.appName));
                this.iJB.iJz.a(393216, 3, (long) hashCode, mz, currentTimeMillis, com.tencent.mm.platformtools.c.mq(oV.appName));
                this.name = oV.appName;
                w.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "inserted we app info id = %s", new Object[]{mz});
            }
            this.iJB.iJz.commit();
            return true;
        }

        public final String toString() {
            String str = "InsertWeApp [%s, %s]";
            Object[] objArr = new Object[2];
            objArr[0] = this.name == null ? "(skipped)" : this.name;
            objArr[1] = this.id;
            return String.format(str, objArr);
        }
    }

    class c extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ b iJB;

        c(b bVar, f fVar) {
            this.iJB = bVar;
            super(fVar);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final java.util.List<com.tencent.mm.plugin.fts.a.a.i> a(java.lang.String[] r7, com.tencent.mm.plugin.fts.a.a.f r8) {
            /*
            r6 = this;
            r0 = new java.util.ArrayList;
            r0.<init>();
            r1 = new java.util.HashSet;
            r1.<init>();
            r2 = r6.iJB;
            r2 = r2.iJz;
            r3 = com.tencent.mm.plugin.fts.a.c.lZh;
            r4 = 0;
            r2 = r2.a(r7, r3, r4);
        L_0x0015:
            r3 = r2.moveToNext();	 Catch:{ Throwable -> 0x0049 }
            if (r3 == 0) goto L_0x0052;
        L_0x001b:
            r3 = new com.tencent.mm.plugin.fts.a.a.j;	 Catch:{ Throwable -> 0x0049 }
            r3.<init>();	 Catch:{ Throwable -> 0x0049 }
            r3.e(r2);	 Catch:{ Throwable -> 0x0049 }
            r4 = r3.mam;	 Catch:{ Throwable -> 0x0049 }
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x0049 }
            r4 = r1.contains(r4);	 Catch:{ Throwable -> 0x0049 }
            if (r4 != 0) goto L_0x0015;
        L_0x002f:
            r4 = r8.mae;	 Catch:{ Throwable -> 0x0049 }
            r5 = r3.lZO;	 Catch:{ Throwable -> 0x0049 }
            r4 = r4.contains(r5);	 Catch:{ Throwable -> 0x0049 }
            if (r4 != 0) goto L_0x0015;
        L_0x0039:
            r3.axK();	 Catch:{ Throwable -> 0x0049 }
            r0.add(r3);	 Catch:{ Throwable -> 0x0049 }
            r4 = r3.mam;	 Catch:{ Throwable -> 0x0049 }
            r3 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x0049 }
            r1.add(r3);	 Catch:{ Throwable -> 0x0049 }
            goto L_0x0015;
        L_0x0049:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x004b }
        L_0x004b:
            r0 = move-exception;
            if (r2 == 0) goto L_0x0051;
        L_0x004e:
            r2.close();
        L_0x0051:
            throw r0;
        L_0x0052:
            if (r2 == 0) goto L_0x0057;
        L_0x0054:
            r2.close();
        L_0x0057:
            r1 = java.lang.Thread.interrupted();
            if (r1 == 0) goto L_0x0063;
        L_0x005d:
            r0 = new java.lang.InterruptedException;
            r0.<init>();
            throw r0;
        L_0x0063:
            r1 = r8.maf;
            if (r1 == 0) goto L_0x006c;
        L_0x0067:
            r1 = r8.maf;
            java.util.Collections.sort(r0, r1);
        L_0x006c:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.d.b.c.a(java.lang.String[], com.tencent.mm.plugin.fts.a.a.f):java.util.List<com.tencent.mm.plugin.fts.a.a.i>");
        }

        public final String getName() {
            return "SearchWeAppTask";
        }

        public final int getId() {
            return 21;
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b iJB;

        d(b bVar) {
            this.iJB = bVar;
        }

        public final boolean execute() {
            List<e> Sv = i.Sv();
            if (Sv.isEmpty()) {
                w.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "WeApp recent usage list is nil.");
                return true;
            }
            this.iJB.iJz.beginTransaction();
            this.iJB.iJz.i(com.tencent.mm.plugin.fts.a.c.lZh);
            for (e eVar : Sv) {
                String mz = bg.mz(eVar.gSl);
                int hashCode = mz.hashCode();
                long currentTimeMillis = System.currentTimeMillis();
                this.iJB.iJz.a(393216, 1, (long) hashCode, mz, currentTimeMillis, eVar.appName);
                this.iJB.iJz.a(393216, 2, (long) hashCode, mz, currentTimeMillis, com.tencent.mm.platformtools.c.mp(eVar.appName));
                this.iJB.iJz.a(393216, 3, (long) hashCode, mz, currentTimeMillis, com.tencent.mm.platformtools.c.mq(eVar.appName));
            }
            this.iJB.iJz.commit();
            w.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "UpdateWeAppIndexTask %d", new Object[]{Integer.valueOf(Sv.size())});
            return true;
        }

        public final String getName() {
            return "UpdateWeAppIndexTask";
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(f fVar) {
        return this.gTU.a(-65536, new c(this, fVar));
    }

    protected final boolean onCreate() {
        if (((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
            this.iJz = (c) ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSIndexStorage(512);
            this.gTU = ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSTaskDaemon();
            this.gTU.a(65616, new d(this));
            i.onCreate();
            i.d(this.iJA);
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        i.onDestroy();
        i.e(this.iJA);
        this.iJz = null;
        this.gTU = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchWeAppLogic";
    }
}
