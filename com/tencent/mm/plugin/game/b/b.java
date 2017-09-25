package com.tencent.mm.plugin.game.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.w;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    public k gTU;
    private com.tencent.mm.sdk.e.j.a iJA = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ b mjm;

        {
            this.mjm = r1;
        }

        public final void a(String str, l lVar) {
            w.i("MicroMsg.FTS.FTS5SearchGameLogic", "appinfo storage change: event=%s | eventData=%s", new Object[]{str, lVar});
            switch (lVar.uxq) {
                case 2:
                case 3:
                    this.mjm.gTU.a(65606, new b(this.mjm, lVar.obj.toString()));
                    return;
                case 5:
                    this.mjm.gTU.a(65606, new a(this.mjm, lVar.obj.toString()));
                    return;
                default:
                    return;
            }
        }
    };
    public a mjl;

    class a extends com.tencent.mm.plugin.fts.a.a.a {
        private String appId;
        final /* synthetic */ b mjm;

        public a(b bVar, String str) {
            this.mjm = bVar;
            this.appId = str;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchGameLogic", "delete app info appId=%s", new Object[]{this.appId});
            this.mjm.mjl.a(com.tencent.mm.plugin.fts.a.c.lZg, this.appId);
            return true;
        }

        public final String toString() {
            return String.format("DeleteGame [%s]", new Object[]{this.appId});
        }
    }

    class b extends com.tencent.mm.plugin.fts.a.a.a {
        private String appId;
        final /* synthetic */ b mjm;
        private String name;

        public b(b bVar, String str) {
            this.mjm = bVar;
            this.appId = str;
        }

        public final boolean execute() {
            f Me = com.tencent.mm.plugin.w.a.a.a.aRv().aRt().Me(this.appId);
            if (Me != null && Me.bCU()) {
                w.i("MicroMsg.FTS.FTS5SearchGameLogic", "insert app info appId=%s", new Object[]{this.appId});
                this.mjm.mjl.beginTransaction();
                this.mjm.mjl.a(com.tencent.mm.plugin.fts.a.c.lZg, this.appId);
                this.mjm.mjl.a(327680, 1, 0, Me.field_appId, System.currentTimeMillis(), Me.field_appName);
                this.mjm.mjl.commit();
                this.name = Me.field_appName;
            }
            return true;
        }

        public final String toString() {
            String str = "InsertGame [%s, %s]";
            Object[] objArr = new Object[2];
            objArr[0] = this.name == null ? "(skipped)" : this.name;
            objArr[1] = this.appId;
            return String.format(str, objArr);
        }
    }

    class c extends e {
        final /* synthetic */ b mjm;

        c(b bVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.mjm = bVar;
            super(fVar);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected final java.util.List<com.tencent.mm.plugin.fts.a.a.i> a(java.lang.String[] r5, com.tencent.mm.plugin.fts.a.a.f r6) {
            /*
            r4 = this;
            r0 = new java.util.ArrayList;
            r0.<init>();
            r1 = r4.mjm;
            r1 = r1.mjl;
            r2 = com.tencent.mm.plugin.fts.a.c.lZg;
            r3 = 1;
            r1 = r1.a(r5, r2, r3);
        L_0x0010:
            r2 = r1.moveToNext();	 Catch:{ Throwable -> 0x0025 }
            if (r2 == 0) goto L_0x002e;
        L_0x0016:
            r2 = new com.tencent.mm.plugin.fts.a.a.j;	 Catch:{ Throwable -> 0x0025 }
            r2.<init>();	 Catch:{ Throwable -> 0x0025 }
            r2.e(r1);	 Catch:{ Throwable -> 0x0025 }
            r2.axK();	 Catch:{ Throwable -> 0x0025 }
            r0.add(r2);	 Catch:{ Throwable -> 0x0025 }
            goto L_0x0010;
        L_0x0025:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0027 }
        L_0x0027:
            r0 = move-exception;
            if (r1 == 0) goto L_0x002d;
        L_0x002a:
            r1.close();
        L_0x002d:
            throw r0;
        L_0x002e:
            if (r1 == 0) goto L_0x0033;
        L_0x0030:
            r1.close();
        L_0x0033:
            r1 = java.lang.Thread.interrupted();
            if (r1 == 0) goto L_0x003f;
        L_0x0039:
            r0 = new java.lang.InterruptedException;
            r0.<init>();
            throw r0;
        L_0x003f:
            r1 = r6.maf;
            if (r1 == 0) goto L_0x0048;
        L_0x0043:
            r1 = r6.maf;
            java.util.Collections.sort(r0, r1);
        L_0x0048:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.b.b.c.a(java.lang.String[], com.tencent.mm.plugin.fts.a.a.f):java.util.List<com.tencent.mm.plugin.fts.a.a.i>");
        }

        public final String getName() {
            return "SearchGameTask";
        }

        public final int getId() {
            return 10;
        }
    }

    class d extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b mjm;

        d(b bVar) {
            this.mjm = bVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean execute() {
            /*
            r12 = this;
            r11 = 0;
            r2 = 1;
            r9 = new java.util.LinkedList;
            r9.<init>();
            r0 = com.tencent.mm.plugin.w.a.a.a.aRv();
            r0 = r0.aRt();
            r1 = r0.bDb();
            if (r1 != 0) goto L_0x001f;
        L_0x0015:
            r0 = "MicroMsg.FTS.FTS5SearchGameLogic";
            r1 = "Game cursor is null!";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        L_0x001e:
            return r2;
        L_0x001f:
            r0 = r1.moveToFirst();	 Catch:{ Throwable -> 0x0085 }
            if (r0 == 0) goto L_0x0036;
        L_0x0025:
            r0 = new com.tencent.mm.pluginsdk.model.app.f;	 Catch:{ Throwable -> 0x0085 }
            r0.<init>();	 Catch:{ Throwable -> 0x0085 }
            r0.b(r1);	 Catch:{ Throwable -> 0x0085 }
            r9.add(r0);	 Catch:{ Throwable -> 0x0085 }
            r0 = r1.moveToNext();	 Catch:{ Throwable -> 0x0085 }
            if (r0 != 0) goto L_0x0025;
        L_0x0036:
            if (r1 == 0) goto L_0x003b;
        L_0x0038:
            r1.close();
        L_0x003b:
            r0 = r12.mjm;
            r0 = r0.mjl;
            r0.beginTransaction();
            r0 = r12.mjm;
            r0 = r0.mjl;
            r1 = com.tencent.mm.plugin.fts.a.c.lZg;
            r0.i(r1);
            r0 = "MicroMsg.FTS.FTS5SearchGameLogic";
            r1 = "current list size: %d";
            r3 = new java.lang.Object[r2];
            r4 = r9.size();
            r4 = java.lang.Integer.valueOf(r4);
            r3[r11] = r4;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r3);
            r10 = r9.iterator();
        L_0x0064:
            r0 = r10.hasNext();
            if (r0 == 0) goto L_0x008e;
        L_0x006a:
            r0 = r10.next();
            r8 = r0;
            r8 = (com.tencent.mm.pluginsdk.model.app.f) r8;
            r6 = java.lang.System.currentTimeMillis();
            r0 = r12.mjm;
            r0 = r0.mjl;
            r1 = 327680; // 0x50000 float:4.59177E-40 double:1.618954E-318;
            r3 = 0;
            r5 = r8.field_appId;
            r8 = r8.field_appName;
            r0.a(r1, r2, r3, r5, r6, r8);
            goto L_0x0064;
        L_0x0085:
            r0 = move-exception;
            throw r0;	 Catch:{ all -> 0x0087 }
        L_0x0087:
            r0 = move-exception;
            if (r1 == 0) goto L_0x008d;
        L_0x008a:
            r1.close();
        L_0x008d:
            throw r0;
        L_0x008e:
            r0 = r12.mjm;
            r0 = r0.mjl;
            r0.commit();
            r0 = "MicroMsg.FTS.FTS5SearchGameLogic";
            r1 = "UpdateIndexTask %d";
            r3 = new java.lang.Object[r2];
            r4 = r9.size();
            r4 = java.lang.Integer.valueOf(r4);
            r3[r11] = r4;
            com.tencent.mm.sdk.platformtools.w.d(r0, r1, r3);
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.b.b.d.execute():boolean");
        }

        public final String getName() {
            return "UpdateGameIndexTask";
        }

        public final int getId() {
            return 7;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.f fVar) {
        return this.gTU.a(-65536, new c(this, fVar));
    }

    protected final boolean onCreate() {
        if (((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchGameLogic", "Create Success!");
            this.mjl = (a) ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSIndexStorage(16);
            this.gTU = ((com.tencent.mm.plugin.fts.a.l) h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSTaskDaemon();
            this.gTU.a(65606, new d(this));
            com.tencent.mm.plugin.w.a.a.a.aRv().aRt().c(this.iJA);
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchGameLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        com.tencent.mm.plugin.w.a.a.a.aRv().aRt().f(this.iJA);
        this.mjl = null;
        this.gTU = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchGameLogic";
    }
}
