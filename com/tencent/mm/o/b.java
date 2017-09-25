package com.tencent.mm.o;

import android.database.Cursor;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    public k gTU;
    public a gTV;
    private com.tencent.mm.sdk.e.m.b gTW = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ b gTX;

        {
            this.gTX = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            if (b.tU()) {
                obj = (obj == null || !(obj instanceof String)) ? null : (String) obj;
                switch (i) {
                    case 2:
                        if (obj != null) {
                            this.gTX.gTU.a(65636, new f(this.gTX, obj));
                            return;
                        }
                        return;
                    case 5:
                        if (obj == null) {
                            this.gTX.gTU.a(65636, new c(this.gTX));
                            return;
                        } else {
                            this.gTX.gTU.a(65636, new d(this.gTX, obj));
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };

    private static class a {
        String aIO;
        String fOI;
        String gTY;
        String gTZ;
        String gUa;
        String gUb;
        String gUc;
        long id;
        int status;
        int type;
        String userName;

        a() {
        }

        a(com.tencent.mm.modelfriend.b bVar) {
            this.id = (long) com.tencent.mm.modelfriend.b.iX(bVar.EP());
            this.gTY = bVar.ER();
            this.gTZ = bVar.ET();
            this.gUa = bVar.ES();
            this.aIO = bVar.EU();
            this.gUb = bVar.EW();
            this.gUc = bVar.EV();
            this.userName = bVar.getUsername();
            this.fOI = bVar.EX();
            this.type = bVar.type;
            this.status = bVar.status;
        }
    }

    private static class e {
        public int gUk = 0;
        public int gUl = 0;
        public int mFailedCount = 0;
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b gTX;
        public boolean gUd = false;
        private HashSet<Long> gUe = null;
        private long gUf = Long.MIN_VALUE;
        private int gUg = -1;
        private HashMap<int[], e> gUh = new HashMap();

        public b(b bVar) {
            this.gTX = bVar;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
            this.gUd = b.tU();
            if (this.gUg < 0) {
                this.gUg = 0;
            }
            w.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", Boolean.valueOf(this.gUd), Integer.valueOf(this.gUg));
            if (this.gUg == 0) {
                if (this.gUd) {
                    if (!this.gUh.containsKey(com.tencent.mm.plugin.fts.a.c.lZm)) {
                        this.gUh.put(com.tencent.mm.plugin.fts.a.c.lZm, new e());
                    }
                    if (this.gUe == null) {
                        this.gUe = new HashSet();
                        Cursor a = this.gTX.gTV.a(com.tencent.mm.plugin.fts.a.c.lZm, false, true, false, false, false);
                        while (a.moveToNext()) {
                            this.gUe.add(Long.valueOf(a.getLong(0)));
                        }
                        a.close();
                    }
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                    }
                    int i;
                    e eVar;
                    Cursor g = ((l) h.j(l.class)).getFTSMainDB().g("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[]{Long.toString(this.gUf)});
                    int i2 = 50;
                    while (g.moveToNext()) {
                        if (Thread.interrupted()) {
                            g.close();
                            this.gTX.gTV.commit();
                            throw new InterruptedException();
                        }
                        long j = g.getLong(0);
                        this.gUf = j;
                        a aVar = new a();
                        aVar.id = j;
                        aVar.gTY = g.getString(1);
                        aVar.gTZ = g.getString(2);
                        aVar.gUa = g.getString(3);
                        aVar.aIO = g.getString(4);
                        aVar.gUb = g.getString(5);
                        aVar.gUc = g.getString(6);
                        aVar.userName = g.getString(7);
                        aVar.status = g.getInt(8);
                        aVar.fOI = g.getString(9);
                        aVar.type = 0;
                        if (aVar.status == 65536) {
                            aVar.status = 0;
                        }
                        if (b.a(aVar) && !this.gUe.remove(Long.valueOf(aVar.id))) {
                            if (i2 >= 50) {
                                this.gTX.gTV.commit();
                                this.gTX.gTV.beginTransaction();
                                i = 0;
                            } else {
                                i = i2;
                            }
                            try {
                                i += this.gTX.b(aVar);
                                eVar = (e) this.gUh.get(com.tencent.mm.plugin.fts.a.c.lZm);
                                eVar.gUk++;
                                i2 = i;
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", e, "Build mobile friend index failed with exception.", new Object[0]);
                                eVar = (e) this.gUh.get(com.tencent.mm.plugin.fts.a.c.lZm);
                                eVar.mFailedCount++;
                                i2 = i;
                            }
                        }
                    }
                    g.close();
                    this.gTX.gTV.commit();
                    Iterator it = this.gUe.iterator();
                    i2 = 50;
                    while (it.hasNext()) {
                        if (i2 >= 50) {
                            this.gTX.gTV.commit();
                            this.gTX.gTV.beginTransaction();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        this.gTX.gTV.a(com.tencent.mm.plugin.fts.a.c.lZm, ((Long) it.next()).longValue());
                        i++;
                        eVar = (e) this.gUh.get(com.tencent.mm.plugin.fts.a.c.lZm);
                        eVar.gUl++;
                        it.remove();
                        i2 = i;
                    }
                    this.gTX.gTV.commit();
                    this.gUe = null;
                    this.gUf = Long.MIN_VALUE;
                }
                this.gUg = -1;
            }
            return true;
        }

        public final String toString() {
            return this.gUh.containsKey(com.tencent.mm.plugin.fts.a.c.lZm) ? "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((e) this.gUh.get(com.tencent.mm.plugin.fts.a.c.lZm)).gUk + ", removed: " + ((e) this.gUh.get(com.tencent.mm.plugin.fts.a.c.lZm)).gUl + ", failed: " + ((e) this.gUh.get(com.tencent.mm.plugin.fts.a.c.lZm)).mFailedCount + "]" : "";
        }

        public final int getId() {
            return 2;
        }

        public final String getName() {
            return "BuildFriendIndexTask";
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b gTX;
        private int gUi = 0;
        private int mCount = 0;

        public c(b bVar) {
            this.gTX = bVar;
        }

        public final boolean execute() {
            w.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteAllFriendsTask mFriendType: %s]", Integer.valueOf(this.gUi));
            if (this.gUi == 0) {
                this.mCount = this.gTX.gTV.e(com.tencent.mm.plugin.fts.a.c.lZm, -1).size();
            }
            return true;
        }

        public final String toString() {
            return "DeleteAllFriends [" + this.mCount + ", " + this.gUi + "]";
        }
    }

    private class d extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b gTX;
        private int gUi = 0;
        private String gUj;

        public d(b bVar, String str) {
            this.gTX = bVar;
            this.gUj = str;
        }

        public final boolean execute() {
            w.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[DeleteFriendTask mEntityId: %s, mFriendType: %s]", this.gUj, Integer.valueOf(this.gUi));
            if (this.gUi == 0) {
                this.gTX.gTV.a(com.tencent.mm.plugin.fts.a.c.lZm, (long) com.tencent.mm.modelfriend.b.iX(this.gUj));
            }
            return true;
        }

        public final String toString() {
            return "DeleteFriend(\"" + this.gUj + "\", " + this.gUi + ")";
        }
    }

    private class f extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b gTX;
        private int gUi;
        private String gUj;
        private boolean gUm = false;

        public f(b bVar, String str) {
            this.gTX = bVar;
            this.gUj = str;
            this.gUi = 0;
        }

        public final boolean execute() {
            w.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[InsertFriendTask mEntityId: %s, mFriendType: %s]", this.gUj, Integer.valueOf(this.gUi));
            if (this.gUi == 0) {
                com.tencent.mm.modelfriend.b ja = af.FY().ja(this.gUj);
                if (ja == null) {
                    this.gUm = true;
                } else {
                    a aVar = new a(ja);
                    if (b.a(aVar)) {
                        this.gTX.b(aVar);
                    } else {
                        this.gUm = true;
                    }
                }
            }
            return true;
        }

        public final String toString() {
            return "InsertFriend(\"" + this.gUj + "\", " + this.gUi + ")" + (this.gUm ? " [skipped]" : "");
        }
    }

    private class g extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ b gTX;
        private int[] gUn;
        private int[] gUo;

        public g(b bVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.gTX = bVar;
            super(fVar);
            this.gUn = fVar.maa;
            this.gUo = fVar.mab;
        }

        protected final List<i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            Cursor a = this.gTX.gTV.a(strArr, this.gUn, this.gUo);
            HashMap hashMap = new HashMap();
            while (a.moveToNext()) {
                j e = new j().e(a);
                if (!fVar.mae.contains(e.lZO)) {
                    i iVar = (i) hashMap.get(Long.valueOf(e.mam));
                    if (iVar == null || com.tencent.mm.plugin.fts.a.d.b(com.tencent.mm.plugin.fts.a.c.lZu, e.hPr, iVar.hPr) < 0) {
                        e.axK();
                        hashMap.put(Long.valueOf(e.mam), e);
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            List<i> arrayList = new ArrayList();
            arrayList.addAll(hashMap.values());
            if (fVar.maf != null) {
                Collections.sort(arrayList, fVar.maf);
            }
            return arrayList;
        }

        public final String getName() {
            return "FTS5SearchFriendLogic.NormalSearchTask";
        }
    }

    public final String getName() {
        return "FTS5SearchFriendLogic";
    }

    protected final boolean onCreate() {
        if (((l) h.j(l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Success!");
            this.gTV = (a) ((l) h.j(l.class)).getFTSIndexStorage(1280);
            this.gTU = ((l) h.j(l.class)).getFTSTaskDaemon();
            this.gTU.a(131172, new b(this));
            af.FY().a(this.gTW);
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        af.FY().b(this.gTW);
        return true;
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.f fVar) {
        return this.gTU.a(-65536, new g(this, fVar));
    }

    public static boolean a(a aVar) {
        if (aVar.type == 0 && aVar.status != 2) {
            return true;
        }
        return false;
    }

    public final int b(a aVar) {
        int i;
        String str;
        String str2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        String mz = bg.mz(aVar.userName);
        int i2 = aVar.status != 0 ? 131073 : 131074;
        if (aVar.fOI == null || aVar.fOI.length() <= 0) {
            i = 0;
        } else {
            this.gTV.a(i2, 16, aVar.id, aVar.userName, currentTimeMillis, aVar.fOI);
            i = 1;
        }
        String str3 = aVar.gTY;
        String str4 = aVar.gTZ;
        String str5 = aVar.gUa;
        if (str3 != null && str3.length() > 0) {
            String str6;
            if (str3.equalsIgnoreCase(str4)) {
                str6 = null;
            } else {
                str6 = str4;
            }
            if (str6 == null || str6.equalsIgnoreCase(str5)) {
                str = null;
            } else {
                str = str5;
            }
            this.gTV.a(i2, 12, aVar.id, mz, currentTimeMillis, str3);
            i++;
            if (str6 != null) {
                this.gTV.a(i2, 13, aVar.id, mz, currentTimeMillis, str6);
                i++;
            }
            if (str != null) {
                this.gTV.a(i2, 14, aVar.id, mz, currentTimeMillis, str);
                i++;
            }
        }
        str3 = aVar.aIO;
        str4 = aVar.gUb;
        str5 = aVar.gUc;
        if (str3 == null || str3.length() <= 0) {
            return i;
        }
        if (str3.equalsIgnoreCase(str4)) {
            str = null;
        } else {
            str = str4;
        }
        if (!(str == null || str.equalsIgnoreCase(str5))) {
            str2 = str5;
        }
        this.gTV.a(i2, 5, aVar.id, mz, currentTimeMillis, str3);
        i++;
        if (str != null) {
            this.gTV.a(i2, 6, aVar.id, mz, currentTimeMillis, str);
            i++;
        }
        if (str2 == null) {
            return i;
        }
        this.gTV.a(i2, 7, aVar.id, mz, currentTimeMillis, str2);
        return i + 1;
    }

    public static boolean tU() {
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(6, null);
        if (str == null || str.length() <= 0) {
            return false;
        }
        return true;
    }
}
