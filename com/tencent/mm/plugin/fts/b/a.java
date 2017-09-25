package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.e.a.ra;
import com.tencent.mm.e.a.re;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.AssertionFailedError;

public final class a extends com.tencent.mm.plugin.fts.a.b {
    private static Set<String> maU = new HashSet();
    public com.tencent.mm.plugin.fts.a.k gTU;
    public com.tencent.mm.plugin.fts.a.h lDR;
    public com.tencent.mm.plugin.fts.c.a maG;
    public HashSet<String> maH;
    public HashMap<String, List<Long>> maI;
    public HashMap<String, String[]> maJ;
    public HashMap<String, List<Long>> maK;
    private Method maL;
    private com.tencent.mm.sdk.e.m.b maM = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ a maV;

        {
            this.maV = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
            String str = (String) obj;
            if (a.xc(str)) {
                x QX = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().QX(str);
                if (QX == null || (a.C(QX) && !QX.bLe())) {
                    switch (i) {
                        case 2:
                        case 5:
                            if (!this.maV.maI.containsKey(str)) {
                                this.maV.gTU.a(65556, new h(this.maV, str));
                                return;
                            }
                            return;
                        case 3:
                            if (!this.maV.maH.contains(str) && !this.maV.maI.containsKey(str)) {
                                this.maV.gTU.a(65556, new i(this.maV, str));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                w.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[]{str});
                return;
            }
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "onConversationChangeListener filterByUsername %s", new Object[]{str});
        }
    };
    private com.tencent.mm.sdk.e.m.b maN = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ a maV;

        {
            this.maV = r1;
        }

        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
            String str = (String) obj;
            if (a.xc(str)) {
                x QX = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().QX(str);
                if (QX == null || a.C(QX)) {
                    switch (i) {
                        case 2:
                            this.maV.gTU.a(65556, new e(this.maV, str));
                            return;
                        case 3:
                        case 4:
                            if (!this.maV.maI.containsKey(str)) {
                                this.maV.gTU.a(65556, new h(this.maV, str));
                                return;
                            }
                            return;
                        case 5:
                            this.maV.gTU.a(65556, new d(this.maV, str));
                            return;
                        default:
                            return;
                    }
                }
                w.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[]{str});
                return;
            }
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[]{str});
        }
    };
    private com.tencent.mm.sdk.e.j.a maO = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ a maV;

        {
            this.maV = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            if (!str.equals("*") && !str.equals("chatroomname") && !this.maV.maI.containsKey(str)) {
                this.maV.gTU.a(65556, new h(this.maV, str));
            }
        }
    };
    private com.tencent.mm.sdk.e.j.a maP = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ a maV;

        {
            this.maV = r1;
        }

        public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
            String[] split = str.split(" ");
            if (split != null && split.length != 0 && split[0].equals("update")) {
                for (int i = 1; i < split.length; i++) {
                    this.maV.gTU.a(65554, new u(this.maV, bg.getLong(split[i], 0)));
                }
                this.maV.gTU.a(65556, new t(this.maV));
            }
        }
    };
    private com.tencent.mm.sdk.b.c maQ = new com.tencent.mm.sdk.b.c<re>(this) {
        final /* synthetic */ a maV;

        {
            this.maV = r2;
            this.usg = re.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            re reVar = (re) bVar;
            if (reVar.fYh.fYi <= 0) {
                this.maV.gTU.a(131093, new t(this.maV));
            } else if (this.maV.maT.bJq()) {
                aj ajVar = this.maV.maT;
                long j = reVar.fYh.fYi;
                ajVar.v(j, j);
                w.i("MicroMsg.FTS.FTS5SearchContactLogic", "* Update contact at once triggered.");
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c maR = new com.tencent.mm.sdk.b.c<ra>(this) {
        final /* synthetic */ a maV;

        {
            this.maV = r2;
            this.usg = ra.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.maV.gTU.a(65556, new g(this.maV, com.tencent.mm.plugin.fts.a.c.lZl));
            this.maV.gTU.a(131093, new t(this.maV));
            return false;
        }
    };
    private aj maS = new aj(com.tencent.mm.kernel.h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ a maV;
        private int maW = 0;

        {
            this.maV = r2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean oQ() {
            /*
            r6 = this;
            r1 = 0;
            r2 = 1;
            r0 = com.tencent.mm.plugin.fts.PluginFTS.class;
            r0 = com.tencent.mm.kernel.h.j(r0);
            r0 = (com.tencent.mm.plugin.fts.PluginFTS) r0;
            r3 = r0.isCharging();
            if (r3 != 0) goto L_0x0016;
        L_0x0010:
            r0 = r0.isInBackground();
            if (r0 != 0) goto L_0x0023;
        L_0x0016:
            r0 = r2;
        L_0x0017:
            if (r0 != 0) goto L_0x0025;
        L_0x0019:
            r0 = r6.maW;
            r0 = r0 + 1;
            r6.maW = r0;
            r3 = 6;
            if (r0 >= r3) goto L_0x0025;
        L_0x0022:
            return r2;
        L_0x0023:
            r0 = r1;
            goto L_0x0017;
        L_0x0025:
            r0 = r6.maV;
            r0 = r0.gTU;
            r3 = 131093; // 0x20015 float:1.837E-40 double:6.47685E-319;
            r4 = new com.tencent.mm.plugin.fts.b.a$t;
            r5 = r6.maV;
            r4.<init>(r5);
            r0.a(r3, r4);
            r6.maW = r1;
            goto L_0x0022;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.b.a.7.oQ():boolean");
        }

        public final String toString() {
            return super.toString() + "|delayIndexTimer";
        }
    }, true);
    public aj maT = new aj(com.tencent.mm.kernel.h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ a maV;

        {
            this.maV = r1;
        }

        public final boolean oQ() {
            this.maV.gTU.a(131093, new t(this.maV));
            return false;
        }

        public final String toString() {
            return super.toString() + "|atOnceIndexTimer";
        }
    }, false);

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int lDY = 0;
        private int lDZ = 0;
        final /* synthetic */ a maV;

        public a(a aVar) {
            this.maV = aVar;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
            HashSet hashSet = new HashSet();
            Cursor rawQuery = this.maV.maG.lYU.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Cursor g = this.maV.lDR.g("SELECT chatroomname, memberlist FROM chatroom;", null);
            int i = 5;
            while (g.moveToNext()) {
                if (Thread.interrupted()) {
                    g.close();
                    this.maV.maG.commit();
                    throw new InterruptedException();
                }
                String string = g.getString(0);
                Object split = com.tencent.mm.plugin.fts.a.c.a.lZx.split(g.getString(1));
                this.maV.maJ.put(string, split);
                if (!hashSet.remove(string)) {
                    if (i >= 5) {
                        this.maV.maG.commit();
                        this.maV.maG.beginTransaction();
                        i = 0;
                    }
                    this.maV.maG.i(string, split);
                    i++;
                    this.lDY++;
                }
            }
            g.close();
            this.maV.maG.commit();
            Iterator it = hashSet.iterator();
            int i2 = 5;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i2 >= 5) {
                    this.maV.maG.commit();
                    this.maV.maG.beginTransaction();
                    i2 = 0;
                }
                this.maV.maG.xi(str);
                i = i2 + 1;
                this.lDZ++;
                i2 = i;
            }
            this.maV.maG.commit();
            return true;
        }

        public final String getName() {
            return "BuildChatroomIndexTask";
        }

        public final String toString() {
            return "BuildChatroomIndex [new: " + this.lDY + ", removed: " + this.lDZ + "]";
        }

        public final int getId() {
            return 3;
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a maV;
        private HashSet<String> maX;
        private HashMap<String, x> maY = new HashMap();
        private long maZ = -1;
        private long mba = -1;
        private int mbb = 0;
        private int mbc = 0;
        private int mbd = 0;
        private int mbe = 0;
        private int mbf;
        private int mbg;
        private int mbh;

        public b(a aVar) {
            this.maV = aVar;
        }

        public final boolean execute() {
            int i;
            long j;
            List list;
            Throwable e;
            Throwable e2;
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
            xa("start");
            if (this.maX == null) {
                this.maX = new HashSet();
                Cursor a = this.maV.maG.a(com.tencent.mm.plugin.fts.a.c.lZk, true, false, true, false, true);
                while (a.moveToNext()) {
                    String string = a.getString(1);
                    i = a.getInt(2);
                    j = a.getLong(0);
                    if (i == 1) {
                        list = (List) this.maV.maI.get(string);
                        if (list == null) {
                            list = new ArrayList(16);
                            this.maV.maI.put(string, list);
                        }
                        list.add(Long.valueOf(j));
                    } else {
                        this.maX.add(string);
                        if (i == 2) {
                            this.maV.maH.add(string);
                        }
                    }
                }
                a.close();
                this.mbf = this.maV.maI.size();
                this.mbg = this.maV.maH.size();
                this.mbh = this.maX.size();
            }
            xa("getBuildContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.maV.maI.size() > 0) {
                List arrayList = new ArrayList();
                for (List list2 : this.maV.maI.values()) {
                    arrayList.addAll(list2);
                }
                this.maV.maI.clear();
                this.maV.maG.aC(arrayList);
            }
            xa("deleteDirtyContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.maV.maH.size() > 0) {
                Iterator it = this.maV.maH.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    this.maV.maG.u(str, this.maV.lDR.wW(str));
                }
                this.maV.maH.clear();
            }
            xa("updateTimestampContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Cursor g = this.maV.lDR.g("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[]{Long.toString(this.maZ)});
            i = 50;
            while (g.moveToNext()) {
                if (Thread.interrupted()) {
                    g.close();
                    this.maV.maG.commit();
                    throw new InterruptedException();
                }
                int i2;
                j = g.getLong(0);
                this.maZ = j;
                af xVar = new x();
                xVar.gTQ = j;
                xVar.setUsername(g.getString(1));
                xVar.bO(g.getString(2));
                xVar.bP(g.getString(3));
                xVar.bR(g.getString(4));
                xVar.de(g.getInt(5));
                xVar.setType(g.getInt(6));
                xVar.u(g.getBlob(7));
                xVar.bY(g.getString(8));
                xVar.dg(0);
                this.maY.put(xVar.field_username, xVar);
                if (!(com.tencent.mm.u.o.dH(xVar.field_username) || !this.maV.D(xVar) || this.maX.remove(xVar.field_username))) {
                    if (i >= 50) {
                        this.maV.maG.commit();
                        this.maV.maG.beginTransaction();
                        i2 = 0;
                    } else {
                        i2 = i;
                    }
                    try {
                        if (!xVar.field_username.endsWith("@chatroom") && (xVar.field_verifyFlag & x.bLg()) == 0) {
                            this.maV.B(xVar);
                            xVar.bLj();
                        }
                        i = this.maV.F(xVar) + i2;
                        try {
                            this.mbc++;
                        } catch (Exception e3) {
                            e = e3;
                            w.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                            this.mbe++;
                        }
                    } catch (Throwable e22) {
                        Throwable th = e22;
                        i = i2;
                        e = th;
                        w.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Build contact index failed with exception.\n", new Object[0]);
                        this.mbe++;
                    }
                }
            }
            g.close();
            this.maV.maG.commit();
            xa("buildWXContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            Cursor g2 = this.maV.lDR.g("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[]{Long.toString(this.mba)});
            i = 50;
            while (g2.moveToNext()) {
                if (Thread.interrupted()) {
                    g2.close();
                    this.maV.maG.commit();
                    throw new InterruptedException();
                }
                this.mba = g2.getLong(0);
                String string2 = g2.getString(1);
                if (!this.maX.remove(string2)) {
                    CharSequence string3 = g2.getString(2);
                    byte[] blob = g2.getBlob(3);
                    try {
                        String[] split = com.tencent.mm.plugin.fts.a.c.a.lZx.split(string3);
                        Arrays.sort(split, new Comparator<String>(this) {
                            final /* synthetic */ b mbi;

                            {
                                this.mbi = r1;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                            }
                        });
                        i2 = this.maV.h(string2, split) + i;
                        try {
                            i2 += this.maV.a(string2, (x) this.maY.get(string2), split, blob, this.maY);
                            this.mbb++;
                            i = i2;
                        } catch (Exception e4) {
                            e22 = e4;
                            w.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e22, "Build contact index failed with exception.\n", new Object[0]);
                            this.mbe++;
                            i = i2;
                            if (i < 50) {
                                this.maV.maG.commit();
                                this.maV.maG.beginTransaction();
                                i = 0;
                            }
                        }
                    } catch (Throwable e5) {
                        th = e5;
                        i2 = i;
                        e22 = th;
                        w.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e22, "Build contact index failed with exception.\n", new Object[0]);
                        this.mbe++;
                        i = i2;
                        if (i < 50) {
                            this.maV.maG.commit();
                            this.maV.maG.beginTransaction();
                            i = 0;
                        }
                    }
                    if (i < 50) {
                        this.maV.maG.commit();
                        this.maV.maG.beginTransaction();
                        i = 0;
                    }
                }
            }
            g2.close();
            this.maV.maG.commit();
            xa("buildChatroomContact");
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            this.mbd = this.maX.size();
            Iterator it2 = this.maX.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                this.maV.maG.a(com.tencent.mm.plugin.fts.a.c.lZk, str2);
                ((PluginFTS) com.tencent.mm.kernel.h.j(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.lZk, str2);
            }
            this.maX.clear();
            this.maY.clear();
            xa("deleteUnusedContact");
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vI().vr().a(com.tencent.mm.storage.w.a.uIj, Integer.valueOf(1));
            return true;
        }

        public final String toString() {
            return String.format("%s [build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, fail: %d]", new Object[]{super.toString(), Integer.valueOf(this.mbh), Integer.valueOf(this.mbc), Integer.valueOf(this.mbb), Integer.valueOf(this.mbd), Integer.valueOf(this.mbf), Integer.valueOf(this.mbg), Integer.valueOf(this.mbe)});
        }

        public final String getName() {
            return "BuildContactIndexTask";
        }

        public final int getId() {
            return 1;
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a maV;

        public c(a aVar) {
            this.maV = aVar;
        }

        public final boolean execute() {
            this.maV.maG.i(com.tencent.mm.plugin.fts.a.c.lZi);
            return true;
        }
    }

    private class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String gLD;
        final /* synthetic */ a maV;
        private int mbj = 0;

        public d(a aVar, String str) {
            this.maV = aVar;
            this.gLD = str;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "Delete Contact %s", new Object[]{this.gLD});
            this.maV.maG.a(com.tencent.mm.plugin.fts.a.c.lZk, this.gLD);
            ((PluginFTS) com.tencent.mm.kernel.h.j(PluginFTS.class)).getTopHitsLogic().c(com.tencent.mm.plugin.fts.a.c.lZk, this.gLD);
            Cursor xh = this.maV.maG.xh(this.gLD);
            HashSet hashSet = new HashSet();
            while (xh.moveToNext()) {
                hashSet.add(xh.getString(0));
            }
            xh.close();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!this.maV.maI.containsKey(str)) {
                    this.maV.maI.put(str, this.maV.maG.b(com.tencent.mm.plugin.fts.a.c.lZk, str));
                    ((PluginFTS) com.tencent.mm.kernel.h.j(PluginFTS.class)).getTopHitsLogic().xf(str);
                    this.mbj++;
                }
            }
            return true;
        }

        public final String toString() {
            return "DeleteContact(\"" + this.gLD + "\")" + (this.mbj > 0 ? " [dirty: " + this.mbj + "]" : "");
        }
    }

    private class e extends com.tencent.mm.plugin.fts.a.a.a {
        private String gLD;
        private boolean gUm = false;
        final /* synthetic */ a maV;

        public e(a aVar, String str) {
            this.maV = aVar;
            this.gLD = str;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[]{this.gLD});
            af wU = this.maV.lDR.wU(this.gLD);
            if (wU == null || wU.field_username.length() <= 0 || !this.maV.D(wU)) {
                this.gUm = true;
            } else {
                this.maV.E(wU);
            }
            this.maV.maI.remove(this.gLD);
            this.maV.maH.remove(this.gLD);
            return true;
        }

        public final String toString() {
            return "InsertContact(\"" + this.gLD + "\")" + (this.gUm ? " [skipped]" : "");
        }
    }

    private class f extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a maV;
        private int mbk = 0;
        private int mbl = 0;

        public f(a aVar) {
            this.maV = aVar;
        }

        public final boolean execute() {
            Cursor rawQuery = this.maV.maG.lYU.rawQuery("SELECT user, label_id FROM FTS5ContactLabels;", null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(0);
                long j = rawQuery.getLong(1);
                List list = (List) this.maV.maK.get(string);
                if (list == null) {
                    list = new ArrayList(16);
                    this.maV.maK.put(string, list);
                    this.mbk++;
                }
                list.add(Long.valueOf(j));
                this.mbl++;
            }
            rawQuery.close();
            return true;
        }

        public final String toString() {
            return "LoadLabelCache [users: " + this.mbk + ", labels: " + this.mbl + "]";
        }
    }

    private class g extends com.tencent.mm.plugin.fts.a.a.a {
        private int kUZ = 0;
        final /* synthetic */ a maV;
        private int[] mbm;
        private int mbn = 0;

        public g(a aVar, int[] iArr) {
            this.maV = aVar;
            this.mbm = iArr;
        }

        public final boolean execute() {
            List<com.tencent.mm.plugin.fts.a.a.b> e = this.maV.maG.e(this.mbm, 1);
            this.kUZ = e.size();
            Object hashMap = new HashMap();
            for (com.tencent.mm.plugin.fts.a.a.b bVar : e) {
                String str = bVar.lZO;
                if (!this.maV.maI.containsKey(str)) {
                    List list = (List) hashMap.get(str);
                    if (list == null) {
                        list = new ArrayList(16);
                        hashMap.put(str, list);
                    }
                    list.add(Long.valueOf(bVar.lZN));
                }
            }
            this.maV.maI.putAll(hashMap);
            this.mbn = hashMap.size();
            return true;
        }

        public final String toString() {
            return String.format("%s [touched: " + this.kUZ + ", users: " + this.mbn + "]", new Object[]{super.toString()});
        }

        public final String getName() {
            return "MarkAllContactDirtyTask";
        }
    }

    private class h extends com.tencent.mm.plugin.fts.a.a.a {
        private String gLD;
        private boolean gUm = false;
        final /* synthetic */ a maV;
        private boolean mbo = false;

        public h(a aVar, String str) {
            this.maV = aVar;
            this.gLD = str;
        }

        public final boolean execute() {
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[]{this.gLD});
            if (this.maV.maI.containsKey(this.gLD)) {
                this.mbo = true;
            } else {
                List b = this.maV.maG.b(com.tencent.mm.plugin.fts.a.c.lZk, this.gLD);
                this.maV.maI.put(this.gLD, b);
                if (b.isEmpty()) {
                    this.gUm = true;
                    this.maV.gTU.a(65556, new e(this.maV, this.gLD));
                } else {
                    Cursor xh = this.maV.maG.xh(this.gLD);
                    HashSet hashSet = new HashSet();
                    while (xh.moveToNext()) {
                        hashSet.add(xh.getString(0));
                    }
                    xh.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!this.maV.maI.containsKey(str)) {
                            this.maV.maI.put(str, this.maV.maG.b(com.tencent.mm.plugin.fts.a.c.lZk, str));
                        }
                    }
                    this.maV.maH.remove(this.gLD);
                    ((PluginFTS) com.tencent.mm.kernel.h.j(PluginFTS.class)).getTopHitsLogic().xf(this.gLD);
                }
            }
            return true;
        }

        public final String toString() {
            return "MarkContactDirty(\"" + this.gLD + "\")" + (this.mbo ? " [cached]" : "") + (this.gUm ? " [skipped]" : "");
        }

        public final int getId() {
            return 17;
        }
    }

    private class i extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a maV;
        private boolean mbp;
        private String username;

        public i(a aVar, String str) {
            this.maV = aVar;
            this.username = str;
        }

        public final boolean execute() {
            if (this.maV.maI.containsKey(this.username)) {
                this.mbp = true;
            } else if (this.maV.maH.add(this.username)) {
                x wU = this.maV.lDR.wU(this.username);
                if (wU == null || this.maV.D(wU)) {
                    com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
                    String str = this.username;
                    aVar.lZa.bindLong(1, 2);
                    aVar.lZa.bindString(2, str);
                    aVar.lZa.bindLong(3, 0);
                    aVar.lZa.execute();
                } else {
                    this.mbp = true;
                }
            } else {
                this.mbp = true;
            }
            return true;
        }

        public final String toString() {
            return String.format("MarkContactTimestampTask %s isSkip %b", new Object[]{this.username, Boolean.valueOf(this.mbp)});
        }
    }

    private class j extends com.tencent.mm.plugin.fts.a.a.e {
        private int[] gUn;
        private int[] gUo;
        final /* synthetic */ a maV;

        public j(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
            this.gUn = fVar.maa;
            this.gUo = fVar.mab;
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            Cursor a = this.maV.maG.a(strArr, this.gUn, this.gUo);
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            while (a.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.j e = new com.tencent.mm.plugin.fts.a.a.j().e(a);
                if (!fVar.mae.contains(e.lZO)) {
                    com.tencent.mm.plugin.fts.a.a.i iVar;
                    if (com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.lZk, e.type)) {
                        iVar = (com.tencent.mm.plugin.fts.a.a.i) hashMap.get(e.lZO);
                        if (iVar == null || com.tencent.mm.plugin.fts.a.d.b(com.tencent.mm.plugin.fts.a.c.lZu, e.hPr, iVar.hPr) < 0) {
                            hashMap.put(e.lZO, e);
                        }
                    } else if (com.tencent.mm.plugin.fts.a.d.f(com.tencent.mm.plugin.fts.a.c.lZm, e.type)) {
                        iVar = (com.tencent.mm.plugin.fts.a.a.i) hashMap2.get(Long.valueOf(e.mam));
                        if (iVar == null || com.tencent.mm.plugin.fts.a.d.b(com.tencent.mm.plugin.fts.a.c.lZu, e.hPr, iVar.hPr) < 0) {
                            hashMap2.put(Long.valueOf(e.mam), e);
                        }
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        throw new InterruptedException();
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.j jVar : hashMap.values()) {
                jVar.axK();
                jVar.d(strArr, this.lZW.fRM);
                arrayList.add(jVar);
            }
            arrayList.addAll(hashMap2.values());
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (fVar.maf != null) {
                Collections.sort(arrayList, fVar.maf);
            }
            return arrayList;
        }

        public final String getName() {
            return "SearchContactLogic.SearchTask";
        }

        public final int getId() {
            return 11;
        }
    }

    private class k extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public k(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            String str = fVar.fRM;
            String format = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[]{aVar.axE()});
            Cursor rawQuery = aVar.lYU.rawQuery(format, new String[]{str});
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                iVar.lZO = rawQuery.getString(0);
                arrayList.add(iVar);
            }
            rawQuery.close();
            return arrayList;
        }

        public final String getName() {
            return "SearchChatroomByMemberTask";
        }
    }

    private class l extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public l(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            int i = 0;
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            String str = fVar.fRM;
            Cursor rawQuery = aVar.lYU.rawQuery("SELECT count(*) FROM FTS5ChatRoomMembers WHERE member=?", new String[]{str});
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
            iVar.userData = Integer.valueOf(i);
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList = new ArrayList();
            arrayList.add(iVar);
            return arrayList;
        }

        public final String getName() {
            return "SearchChatroomCountTask";
        }
    }

    private class m extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public m(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            String str = fVar.fJL;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT aux_index FROM %s NOT INDEXED JOIN (SELECT docid, aux_index, timestamp FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=?) as temp ON (%s.rowid = temp.docid) WHERE %s MATCH '%s' ORDER BY -timestamp;", new Object[]{aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s}), new String[]{str, s});
            HashSet hashSet = new HashSet();
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                iVar.lZO = rawQuery.getString(0);
                if (hashSet.add(iVar.lZO)) {
                    arrayList.add(iVar);
                }
            }
            rawQuery.close();
            return arrayList;
        }

        public final String getName() {
            return "SearchChatroomInMemberTask";
        }
    }

    private class n extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public n(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a.i iVar;
            Cursor a = this.maV.maG.a(strArr, new int[]{131075}, null);
            HashMap hashMap = new HashMap();
            while (a.moveToNext()) {
                String string = a.getString(4);
                if (!fVar.mae.contains(string)) {
                    int i = a.getInt(2);
                    iVar = (com.tencent.mm.plugin.fts.a.a.i) hashMap.get(string);
                    if (iVar == null || com.tencent.mm.plugin.fts.a.d.b(com.tencent.mm.plugin.fts.a.c.lZu, i, iVar.hPr) < 0) {
                        com.tencent.mm.plugin.fts.a.a.j e = new com.tencent.mm.plugin.fts.a.a.j().e(a);
                        hashMap.put(e.lZO, e);
                    }
                    if (Thread.interrupted()) {
                        a.close();
                        throw new InterruptedException();
                    }
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            ArrayList arrayList = new ArrayList(hashMap.size());
            for (com.tencent.mm.plugin.fts.a.a.j e2 : hashMap.values()) {
                e2.axK();
                e2.d(strArr, this.lZW.fRM);
                arrayList.add(e2);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (fVar.maf != null) {
                Collections.sort(arrayList, fVar.maf);
            }
            List arrayList2 = new ArrayList(hashMap.size());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iVar = (com.tencent.mm.plugin.fts.a.a.i) arrayList.get(i2);
                stringBuffer.append(iVar.lZT);
                stringBuffer.append("|");
                stringBuffer.append(iVar.timestamp);
                stringBuffer.append(" ");
                arrayList2.add(iVar);
                if (i2 >= fVar.mad) {
                    break;
                }
            }
            if (strArr.length > 1 && this.maV.maG.v(strArr)) {
                iVar = new com.tencent.mm.plugin.fts.a.a.i();
                iVar.lZO = "create_chatroom​";
                arrayList2.add(0, iVar);
                stringBuffer.append(" needCreateChatroom");
            }
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "rank score: %s", new Object[]{stringBuffer.toString()});
            return arrayList2;
        }

        public final String getName() {
            return "SearchChatroomTask";
        }

        public final int getId() {
            return 19;
        }
    }

    public class o extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public o(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            List f = bg.f(fVar.fRM.split(","));
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("member IN (");
            for (int i = 0; i < f.size(); i++) {
                stringBuffer.append("'");
                stringBuffer.append((String) f.get(i));
                stringBuffer.append("'");
                if (i != f.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            stringBuffer.append(")");
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT member, chatroom, entity_id FROM FTS5ChatRoomMembers, %s WHERE %s AND chatroom = aux_index", new Object[]{aVar.axE(), stringBuffer.toString()}), null);
            HashMap hashMap = new HashMap();
            while (rawQuery.moveToNext()) {
                List list;
                String string = rawQuery.getString(0);
                if (hashMap.containsKey(string)) {
                    list = (List) hashMap.get(string);
                } else {
                    list = new ArrayList();
                }
                com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                iVar.lZO = rawQuery.getString(1);
                iVar.mam = rawQuery.getLong(2);
                list.add(iVar);
                hashMap.put(string, list);
            }
            rawQuery.close();
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList = new ArrayList();
            com.tencent.mm.plugin.fts.a.a.i iVar2 = new com.tencent.mm.plugin.fts.a.a.i();
            iVar2.userData = hashMap;
            arrayList.add(iVar2);
            return arrayList;
        }

        public final String getName() {
            return "SearchCommonChatroomTask";
        }
    }

    public class p extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public p(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            long longValue = Long.valueOf(fVar.fRM).longValue();
            Cursor rawQuery = r2.lYU.rawQuery(String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[]{this.maV.maG.axE(), Long.valueOf(longValue), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)}), null);
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                iVar.lZO = rawQuery.getString(0);
                arrayList.add(iVar);
            }
            rawQuery.close();
            return arrayList;
        }

        public final String getName() {
            return "SearchContactSmallerTimestampTask";
        }
    }

    private class q extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public q(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            int[] iArr = fVar.maa;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            String str = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + com.tencent.mm.plugin.fts.a.d.k(iArr);
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, 1, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str + " AND status >= 0 ORDER BY subtype;", new Object[]{aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s}), null);
            List<com.tencent.mm.plugin.fts.a.a.j> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(fVar.mae);
            int i = 0;
            while (rawQuery.moveToNext()) {
                if (hashSet.add(rawQuery.getString(3))) {
                    com.tencent.mm.plugin.fts.a.a.j e = new com.tencent.mm.plugin.fts.a.a.j().e(rawQuery);
                    if (i < e.hPr) {
                        if (arrayList.size() > fVar.mad) {
                            break;
                        }
                        i = e.hPr;
                        arrayList.add(e);
                    } else {
                        arrayList.add(e);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.lZW.fRM);
                    }
                }
            }
            rawQuery.close();
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.j jVar : arrayList) {
                jVar.axK();
                jVar.d(strArr, this.lZW.fRM);
                arrayList2.add(jVar);
            }
            if (fVar.maf != null) {
                Collections.sort(arrayList2, fVar.maf);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException("Task is Cancel: " + this.lZW.fRM);
            }
            StringBuffer stringBuffer = new StringBuffer();
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) arrayList2.get(i2);
                stringBuffer.append(iVar.lZT);
                stringBuffer.append(" ");
                arrayList3.add(iVar);
                if (i2 >= fVar.mad) {
                    break;
                }
            }
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "getName() rank score: %s", new Object[]{stringBuffer.toString()});
            if (!Thread.interrupted()) {
                return arrayList3;
            }
            throw new InterruptedException("Task is Cancel: " + this.lZW.fRM);
        }

        public final String getName() {
            return "SearchContactTask";
        }

        public final int getId() {
            return 20;
        }
    }

    private class r extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public r(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            xa("start");
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            String str = fVar.fRM;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            long currentTimeMillis = System.currentTimeMillis() - 1209600000;
            s = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, -1, type, subtype) AS Offsets, MMChatroomRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, entity_id) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131075 ORDER BY Rank, timestamp desc ;", new Object[]{aVar.axE(), aVar.axF(), aVar.axF(), Long.valueOf(currentTimeMillis), aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s});
            Cursor rawQuery = aVar.lYU.rawQuery(s, new String[]{str});
            List<com.tencent.mm.plugin.fts.a.a.j> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(fVar.mae);
            while (rawQuery.moveToNext()) {
                if (hashSet.add(rawQuery.getString(4))) {
                    com.tencent.mm.plugin.fts.a.a.j jVar = new com.tencent.mm.plugin.fts.a.a.j();
                    jVar.mak = rawQuery.getLong(0);
                    jVar.type = rawQuery.getInt(1);
                    jVar.hPr = rawQuery.getInt(2);
                    jVar.mam = rawQuery.getLong(3);
                    jVar.lZO = rawQuery.getString(4);
                    jVar.timestamp = rawQuery.getLong(5);
                    jVar.content = rawQuery.getString(6);
                    jVar.mao = rawQuery.getString(7);
                    jVar.mav = rawQuery.getLong(8);
                    if (arrayList.size() > fVar.mad) {
                        break;
                    }
                    arrayList.add(jVar);
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.lZW.fRM);
                    }
                }
            }
            rawQuery.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            xa("orm");
            List arrayList2 = new ArrayList(arrayList.size());
            for (com.tencent.mm.plugin.fts.a.a.j jVar2 : arrayList) {
                jVar2.axK();
                jVar2.d(strArr, this.lZW.fRM);
                arrayList2.add(jVar2);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (fVar.maf != null) {
                Collections.sort(arrayList2, fVar.maf);
            }
            xa("calOffsets");
            if (strArr.length > 1 && this.maV.maG.v(strArr)) {
                com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                iVar.lZO = "create_chatroom​";
                if (arrayList2.size() > 3) {
                    arrayList2.add(3, iVar);
                } else {
                    arrayList2.add(iVar);
                }
            }
            xa("checkChatroom");
            return arrayList2;
        }

        public final String getName() {
            return "SearchTopChatroomInnerRankTask";
        }

        public final int getId() {
            return 25;
        }
    }

    private class s extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ a maV;

        public s(a aVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.maV = aVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            long currentTimeMillis = System.currentTimeMillis() - 1105032704;
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, 1, type, subtype), CASE WHEN timestamp - %d > 0 THEN 1 ELSE 0 END AS time_range FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY time_range desc, subtype ;", new Object[]{aVar.axE(), aVar.axF(), Long.valueOf(currentTimeMillis), aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s}), null);
            List<com.tencent.mm.plugin.fts.a.a.j> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            hashSet.addAll(fVar.mae);
            int i = 0;
            while (rawQuery.moveToNext()) {
                if (hashSet.add(rawQuery.getString(4))) {
                    com.tencent.mm.plugin.fts.a.a.j e = new com.tencent.mm.plugin.fts.a.a.j().e(rawQuery);
                    if (i < e.hPr) {
                        if (arrayList.size() > fVar.mad) {
                            break;
                        }
                        i = e.hPr;
                        arrayList.add(e);
                    } else {
                        arrayList.add(e);
                    }
                    if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException("Task is Cancel: " + this.lZW.fRM);
                    }
                }
            }
            rawQuery.close();
            ArrayList arrayList2 = new ArrayList();
            for (com.tencent.mm.plugin.fts.a.a.j jVar : arrayList) {
                jVar.axK();
                jVar.d(strArr, this.lZW.fRM);
                arrayList2.add(jVar);
            }
            if (fVar.maf != null) {
                Collections.sort(arrayList2, fVar.maf);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException("Task is Cancel: " + this.lZW.fRM);
            }
            StringBuffer stringBuffer = new StringBuffer();
            List<com.tencent.mm.plugin.fts.a.a.i> arrayList3 = new ArrayList();
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                com.tencent.mm.plugin.fts.a.a.i iVar = (com.tencent.mm.plugin.fts.a.a.i) arrayList2.get(i2);
                stringBuffer.append(iVar.lZT);
                stringBuffer.append("|");
                stringBuffer.append(iVar.mav);
                stringBuffer.append(" ");
                arrayList3.add(iVar);
                if (i2 >= fVar.mad) {
                    break;
                }
            }
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "getName() rank score: %s", new Object[]{stringBuffer.toString()});
            if (!Thread.interrupted()) {
                return arrayList3;
            }
            throw new InterruptedException("Task is Cancel: " + this.lZW.fRM);
        }

        public final String getName() {
            return "SearchTopContactTask";
        }

        public final int getId() {
            return 22;
        }
    }

    private class t extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a maV;
        private int mbq = 0;
        private int mbr = 0;
        private int mbs = 0;

        public t(a aVar) {
            this.maV = aVar;
        }

        public final boolean execute() {
            int i;
            xa("start");
            Iterator it = this.maV.maI.entrySet().iterator();
            int i2 = 50;
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.maV.maG.commit();
                    throw new InterruptedException();
                }
                int i3;
                if (i2 >= 50) {
                    this.maV.maG.commit();
                    this.maV.maG.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                Entry entry = (Entry) it.next();
                for (Long longValue : (List) entry.getValue()) {
                    this.maV.maG.h(Long.valueOf(longValue.longValue()));
                    i3++;
                }
                String str = (String) entry.getKey();
                af wU = this.maV.lDR.wU(str);
                if (wU == null || wU.field_username.length() <= 0 || !this.maV.D(wU)) {
                    i = i3;
                } else {
                    i = i3 + this.maV.E(wU);
                }
                it.remove();
                this.maV.maH.remove(str);
                this.mbq++;
                i2 = i;
            }
            xa("dirtyContact");
            Iterator it2 = this.maV.maH.iterator();
            while (it2.hasNext()) {
                if (Thread.interrupted()) {
                    this.maV.maG.commit();
                    throw new InterruptedException();
                }
                if (i2 >= 50) {
                    this.maV.maG.commit();
                    this.maV.maG.beginTransaction();
                    i = 0;
                } else {
                    i = i2;
                }
                str = (String) it2.next();
                long wW = this.maV.lDR.wW(str);
                af wU2 = this.maV.lDR.wU(str);
                if (wU2 == null || wU2.field_username.length() <= 0 || !this.maV.D(wU2)) {
                    i2 = i;
                } else {
                    this.maV.maG.u(str, wW);
                    i2 = i + 1;
                }
                it2.remove();
                this.mbr++;
            }
            this.maV.maG.commit();
            xa("timestampContact");
            e topHitsLogic = ((PluginFTS) com.tencent.mm.kernel.h.j(PluginFTS.class)).getTopHitsLogic();
            topHitsLogic.mbX.clear();
            this.mbs = topHitsLogic.mbW.axU();
            xa("topHits");
            return true;
        }

        public final String toString() {
            return String.format("%s [Dirty: %d Timestamp: %d tophitsCount: %d]", new Object[]{super.toString(), Integer.valueOf(this.mbq), Integer.valueOf(this.mbr), Integer.valueOf(this.mbs)});
        }

        public final String getName() {
            return "UpdateDirtyAndTimestampContactTask";
        }

        public final int getId() {
            return 16;
        }
    }

    private class u extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ a maV;
        private long mbt;
        private int mbu = 0;

        public u(a aVar, long j) {
            this.maV = aVar;
            this.mbt = j;
        }

        public final boolean execute() {
            ArrayList arrayList = new ArrayList(32);
            com.tencent.mm.plugin.fts.a.a aVar = this.maV.maG;
            long j = this.mbt;
            Cursor rawQuery = aVar.lYU.rawQuery("SELECT user FROM FTS5ContactLabels WHERE label_id=?;", new String[]{Long.toString(j)});
            while (rawQuery.moveToNext()) {
                arrayList.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!this.maV.maI.containsKey(str)) {
                    this.maV.maI.put(str, this.maV.maG.b(com.tencent.mm.plugin.fts.a.c.lZl, str));
                }
            }
            return true;
        }

        public final String toString() {
            return "UpdateLabel(" + this.mbt + ") [contacts: " + this.mbu + "]";
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.f fVar) {
        com.tencent.mm.plugin.fts.a.a.a lVar;
        switch (fVar.lZZ) {
            case 5:
                lVar = new l(this, fVar);
                break;
            case 6:
                lVar = new k(this, fVar);
                break;
            case 7:
                lVar = new m(this, fVar);
                break;
            case 8:
                lVar = new o(this, fVar);
                break;
            case 9:
                lVar = new p(this, fVar);
                break;
            case 16:
                lVar = new q(this, fVar);
                break;
            case 32:
                lVar = new n(this, fVar);
                break;
            case 48:
                lVar = new s(this, fVar);
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                lVar = new r(this, fVar);
                break;
            default:
                lVar = new j(this, fVar);
                break;
        }
        return this.gTU.a(-65536, lVar);
    }

    protected final boolean onCreate() {
        if (((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
            this.maG = (com.tencent.mm.plugin.fts.c.a) ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSIndexStorage(3);
            this.gTU = ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSTaskDaemon();
            this.lDR = ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSMainDB();
            this.maH = new HashSet();
            this.maI = new HashMap();
            this.maJ = new HashMap();
            this.maK = new HashMap();
            try {
                this.maL = af.class.getDeclaredMethod("pD", new Class[0]);
                this.maL.setAccessible(true);
                this.gTU.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new f(this));
                this.gTU.a(131082, new a(this));
                this.gTU.a(131092, new b(this));
                this.gTU.a(Integer.MAX_VALUE, new c(this));
                ((com.tencent.mm.plugin.chatroom.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().c(this.maO);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(this.maN);
                ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().a(this.maM);
                com.tencent.mm.sdk.e.j.a aVar = this.maP;
                if (com.tencent.mm.aj.b.hJG != null) {
                    com.tencent.mm.aj.b.hJG.a(aVar);
                }
                this.maS.v(600000, 600000);
                this.maQ.bIy();
                this.maR.bIy();
                return true;
            } catch (Throwable e) {
                AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
                assertionFailedError.initCause(e);
                throw assertionFailedError;
            }
        }
        w.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        this.maQ.dead();
        this.maR.dead();
        this.maT.KH();
        this.maS.KH();
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().b(this.maN);
        ((com.tencent.mm.plugin.chatroom.b.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.chatroom.b.a.class)).xa().f(this.maO);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().b(this.maM);
        com.tencent.mm.sdk.e.j.a aVar = this.maP;
        if (com.tencent.mm.aj.b.hJG != null) {
            com.tencent.mm.aj.b.hJG.b(aVar);
        }
        if (this.maI != null) {
            this.maI.clear();
        }
        if (this.maH != null) {
            this.maH.clear();
        }
        this.maG = null;
        this.gTU = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchContactLogic";
    }

    final int a(String str, x xVar, String[] strArr, byte[] bArr, HashMap<String, x> hashMap) {
        int i = 0;
        String str2 = xVar.field_nickname;
        String X = com.tencent.mm.plugin.fts.a.d.X(str2, false);
        String X2 = com.tencent.mm.plugin.fts.a.d.X(str2, true);
        long j = 0;
        long wW = this.lDR.wW(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            j = (long) strArr.length;
            HashMap hashMap2 = new HashMap();
            com.tencent.mm.g.a.a.a aVar = new com.tencent.mm.g.a.a.a();
            try {
                aVar.aD(bArr);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "parse chatroom data", new Object[0]);
            }
            Iterator it = aVar.gMT.iterator();
            while (it.hasNext()) {
                com.tencent.mm.g.a.a.b bVar = (com.tencent.mm.g.a.a.b) it.next();
                if (!bg.mA(bVar.gMX)) {
                    hashMap2.put(bVar.userName, bVar.gMX);
                }
            }
            for (String str3 : strArr) {
                x xVar2 = (x) hashMap.get(str3);
                if (xVar2 != null) {
                    String X3;
                    String str4 = xVar2.field_conRemark;
                    String str5 = xVar2.field_nickname;
                    if (bg.mA(str4)) {
                        stringBuffer.append("‌‌‌");
                    } else {
                        X3 = com.tencent.mm.plugin.fts.a.d.X(str4, false);
                        String X4 = com.tencent.mm.plugin.fts.a.d.X(str4, true);
                        stringBuffer.append(str4).append("‌");
                        stringBuffer.append(X3).append("‌");
                        stringBuffer.append(X4).append("‌");
                    }
                    if (bg.mA(str5)) {
                        stringBuffer.append("‌‌‌");
                    } else {
                        str4 = com.tencent.mm.plugin.fts.a.d.X(str5, false);
                        X3 = com.tencent.mm.plugin.fts.a.d.X(str5, true);
                        stringBuffer.append(str5).append("‌");
                        stringBuffer.append(str4).append("‌");
                        stringBuffer.append(X3).append("‌");
                    }
                    stringBuffer.append(bg.ap((String) hashMap2.get(str3), "")).append("‌");
                    B(xVar2);
                    stringBuffer.append(bg.ap(xVar2.gkK, "")).append("‌");
                    stringBuffer.append(bg.ap(com.tencent.mm.plugin.fts.a.d.ch(str3, xVar2.pA()), "")).append("‌");
                    stringBuffer.append("​");
                }
            }
        }
        if (!bg.mA(str2)) {
            this.maG.a(131075, 5, j, str, wW, str2);
            if (bg.mA(X)) {
                i = 1;
            } else {
                this.maG.a(131075, 6, j, str, wW, X);
                i = 2;
            }
            if (!bg.mA(X2)) {
                this.maG.a(131075, 7, j, str, wW, X2);
                i++;
            }
        }
        if (stringBuffer.length() <= 0) {
            return i;
        }
        stringBuffer.setLength(stringBuffer.length() - 1);
        this.maG.a(131075, 38, j, str, wW, stringBuffer.toString());
        return i + 1;
    }

    public final int h(String str, String[] strArr) {
        int i = 0;
        String[] strArr2 = (String[]) this.maJ.get(str);
        this.maG.beginTransaction();
        if (strArr2 == null) {
            this.maG.xi(str);
            i = ((int) this.maG.mcn.simpleQueryForLong()) + 0;
            if (strArr != null) {
                this.maG.i(str, strArr);
                this.maJ.put(str, strArr);
                i += strArr.length;
            }
        } else if (strArr == null) {
            this.maG.xi(str);
            i = ((int) this.maG.mcn.simpleQueryForLong()) + 0;
            this.maJ.remove(str);
        } else {
            HashSet hashSet = new HashSet(Arrays.asList(strArr2));
            int length = strArr.length;
            int i2 = 0;
            while (i < length) {
                String str2 = strArr[i];
                if (!hashSet.remove(str2)) {
                    com.tencent.mm.plugin.fts.c.a aVar = this.maG;
                    aVar.mch.bindString(1, str);
                    aVar.mch.bindString(2, str2);
                    aVar.mch.execute();
                    i2++;
                }
                i++;
            }
            Iterator it = hashSet.iterator();
            i = i2;
            while (it.hasNext()) {
                String str3 = (String) it.next();
                com.tencent.mm.plugin.fts.c.a aVar2 = this.maG;
                aVar2.mci.bindString(1, str);
                aVar2.mci.bindString(2, str3);
                aVar2.mci.execute();
                i++;
            }
            this.maJ.put(str, strArr);
        }
        this.maG.commit();
        return i;
    }

    final void B(x xVar) {
        try {
            this.maL.invoke(xVar, new Object[0]);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Failed parsing RContact LVBuffer.", new Object[0]);
        }
    }

    static boolean xc(String str) {
        if (bg.mA(str) || str.endsWith("@stranger") || str.endsWith("@qqim") || str.endsWith("@app") || str.startsWith("fake_")) {
            return false;
        }
        return true;
    }

    static boolean C(x xVar) {
        if (xVar.isHidden() || xVar.tA() || xVar.field_deleteFlag != 0) {
            return false;
        }
        if (com.tencent.mm.j.a.ez(xVar.field_type) || (!xVar.tz() && !xVar.bLe())) {
            return true;
        }
        return false;
    }

    final boolean D(x xVar) {
        String str = xVar.field_username;
        if (!C(xVar) || !xc(str)) {
            return false;
        }
        if (com.tencent.mm.j.a.ez(xVar.field_type)) {
            return true;
        }
        if (xVar.tz() || xVar.bLe() || !this.lDR.wV(str)) {
            return false;
        }
        return true;
    }

    final int E(x xVar) {
        if (!com.tencent.mm.u.o.dH(xVar.field_username)) {
            return F(xVar);
        }
        String format = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[]{"chatroom"});
        Cursor g = this.lDR.g(format, new String[]{xVar.field_username});
        try {
            CharSequence string;
            byte[] blob;
            if (g.moveToNext()) {
                string = g.getString(0);
                blob = g.getBlob(1);
            } else {
                blob = null;
                string = null;
            }
            if (g != null) {
                g.close();
            }
            if (bg.mA(string) || blob == null) {
                w.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[]{xVar.field_username});
                if (h(xVar.field_username, null) <= 0) {
                    return 0;
                }
                w.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[]{xVar.field_username, Integer.valueOf(h(xVar.field_username, null))});
                return 0;
            }
            String[] split = com.tencent.mm.plugin.fts.a.c.a.lZx.split(string);
            Arrays.sort(split, new Comparator<String>(this) {
                final /* synthetic */ a maV;

                {
                    this.maV = r1;
                }

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return FTSJNIUtils.stringCompareUtfBinary((String) obj, (String) obj2);
                }
            });
            if (h(xVar.field_username, split) > 0) {
                w.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[]{xVar.field_username, Integer.valueOf(h(xVar.field_username, split))});
            }
            HashMap hashMap = new HashMap();
            Cursor g2 = this.lDR.g("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + com.tencent.mm.plugin.fts.a.d.t(split) + ";", null);
            while (g2.moveToNext()) {
                try {
                    af xVar2 = new x();
                    xVar2.gTQ = g2.getLong(0);
                    xVar2.setUsername(g2.getString(1));
                    xVar2.bO(g2.getString(2));
                    xVar2.bP(g2.getString(3));
                    xVar2.bR(g2.getString(4));
                    xVar2.u(g2.getBlob(5));
                    hashMap.put(xVar2.field_username, xVar2);
                } finally {
                    if (g2 != null) {
                        g2.close();
                    }
                }
            }
            return a(xVar.field_username, xVar, split, blob, hashMap);
        } catch (Throwable th) {
            if (g != null) {
                g.close();
            }
        }
    }

    final int F(x xVar) {
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        String str2;
        String str3;
        long j = xVar.gTQ;
        String str4 = xVar.field_username;
        String pA = xVar.pA();
        String str5 = xVar.field_nickname;
        String X = com.tencent.mm.plugin.fts.a.d.X(str5, false);
        String X2 = com.tencent.mm.plugin.fts.a.d.X(str5, true);
        String str6 = xVar.field_conRemark;
        String X3 = com.tencent.mm.plugin.fts.a.d.X(str6, false);
        String X4 = com.tencent.mm.plugin.fts.a.d.X(str6, true);
        String str7 = xVar.gkK;
        CharSequence charSequence = xVar.field_contactLabelIds;
        String str8 = xVar.gkQ;
        int i5 = xVar.field_verifyFlag;
        long currentTimeMillis = System.currentTimeMillis();
        if ((i5 & x.bLg()) != 0) {
            i = 0;
            i2 = 131076;
        } else {
            currentTimeMillis = this.lDR.wW(str4);
            if (charSequence == null || charSequence.length() <= 0) {
                i2 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                i = 0;
            } else {
                List arrayList;
                List list = null;
                if (charSequence != null) {
                    if (charSequence.endsWith("\u0000")) {
                        charSequence = charSequence.substring(0, charSequence.length() - 1);
                    }
                    if (charSequence.length() != 0) {
                        String[] split = com.tencent.mm.plugin.fts.a.c.a.lZE.split(charSequence);
                        if (split.length != 0) {
                            arrayList = new ArrayList(split.length);
                            for (String str9 : split) {
                                arrayList.add(Long.valueOf(bg.getLong(str9, 0)));
                            }
                            list = arrayList;
                        }
                    }
                }
                arrayList = (List) this.maK.get(str4);
                if (arrayList == null) {
                    this.maG.xg(str4);
                    if (!(r5 == null || r5.isEmpty())) {
                        this.maG.g(str4, r5);
                        this.maK.put(str4, r5);
                    }
                } else if (r5 == null || r5.isEmpty()) {
                    this.maG.xg(str4);
                    this.maK.remove(str4);
                } else {
                    long longValue;
                    com.tencent.mm.plugin.fts.c.a aVar;
                    HashSet hashSet = new HashSet(arrayList);
                    for (Long longValue2 : r5) {
                        longValue = longValue2.longValue();
                        if (!hashSet.remove(Long.valueOf(longValue))) {
                            aVar = this.maG;
                            aVar.mck.bindString(1, str4);
                            aVar.mck.bindLong(2, longValue);
                            aVar.mck.execute();
                        }
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        longValue = ((Long) it.next()).longValue();
                        aVar = this.maG;
                        aVar.mcl.bindString(1, str4);
                        aVar.mcl.bindLong(2, longValue);
                        aVar.mcl.execute();
                    }
                    this.maK.put(str4, r5);
                }
                if (r5 == null || r5.isEmpty()) {
                    i3 = 0;
                } else {
                    StringBuilder stringBuilder = new StringBuilder(512);
                    str = "SELECT labelName FROM ContactLabel WHERE labelID=?;";
                    String[] strArr = new String[1];
                    for (Long longValue22 : r5) {
                        strArr[0] = Long.toString(longValue22.longValue());
                        Cursor g = this.lDR.g(str, strArr);
                        if (g.moveToFirst()) {
                            stringBuilder.append(g.getString(0)).append("​");
                        }
                        g.close();
                    }
                    if (stringBuilder.length() == 0) {
                        i3 = 0;
                    } else {
                        stringBuilder.setLength(stringBuilder.length() - 1);
                        this.maG.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 11, j, str4, currentTimeMillis, stringBuilder.toString());
                        i3 = 1;
                    }
                }
                i2 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                i = i3 + 0;
            }
        }
        String ch = com.tencent.mm.plugin.fts.a.d.ch(str4, pA);
        if (ch == null || ch.length() == 0) {
            i4 = i;
        } else {
            this.maG.a(i2, 15, j, str4, currentTimeMillis, ch);
            i4 = i + 1;
        }
        if (str6 == null || str6.length() == 0) {
            X4 = null;
            ch = str5;
            str5 = null;
            str = X;
            str2 = X2;
            X2 = null;
        } else {
            str2 = X4;
            str = X3;
            ch = str6;
            X4 = X2;
            X2 = X;
        }
        if (!(ch == null || ch.length() == 0)) {
            if (ch.equalsIgnoreCase(str)) {
                X3 = null;
            } else {
                X3 = str;
            }
            if (X3 == null || X3.length() == 0 || X3.equalsIgnoreCase(str2)) {
                str3 = null;
            } else {
                str3 = str2;
            }
            this.maG.a(i2, 1, j, str4, currentTimeMillis, ch);
            if (!(X3 == null || X3.length() == 0)) {
                this.maG.a(i2, 2, j, str4, currentTimeMillis, X3);
            }
            if (!(str3 == null || str3.length() == 0)) {
                this.maG.a(i2, 3, j, str4, currentTimeMillis, str3);
            }
            i4 += 3;
        }
        if (str5 == null || str5.length() == 0) {
            i = i4;
        } else {
            if (str5.equalsIgnoreCase(X2)) {
                X2 = null;
            }
            if (X2 == null || X2.length() == 0 || X2.equalsIgnoreCase(X4)) {
                str3 = null;
            } else {
                str3 = X4;
            }
            this.maG.a(i2, 5, j, str4, currentTimeMillis, str5);
            if (!(X2 == null || X2.length() == 0)) {
                this.maG.a(i2, 6, j, str4, currentTimeMillis, X2);
            }
            if (!(str3 == null || str3.length() == 0)) {
                this.maG.a(i2, 7, j, str4, currentTimeMillis, str3);
            }
            i = i4 + 3;
        }
        if (str7 != null && str7.length() > 0) {
            this.maG.a(i2, 4, j, str4, currentTimeMillis, str7);
            i++;
        }
        if (i2 == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (bg.mA(str8)) {
                Cursor g2 = this.lDR.g("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str4});
                if (g2.moveToFirst()) {
                    this.maG.a(i2, 16, j, str4, currentTimeMillis, g2.getString(0));
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                g2.close();
                i = i3;
            } else {
                this.maG.a(i2, 16, j, str4, currentTimeMillis, str8.replace(",", "​"));
                i++;
            }
            ch = xVar.getProvince();
            if (maU.contains(ch)) {
                ch = "";
            }
            if (!(ch == null || ch.length() == 0)) {
                this.maG.a(i2, 18, j, str4, currentTimeMillis, ch);
            }
            ch = xVar.getCity();
            if (!(ch == null || ch.length() == 0)) {
                this.maG.a(i2, 17, j, str4, currentTimeMillis, ch);
            }
        }
        return i;
    }

    static {
        String[] split = ab.getContext().getString(com.tencent.mm.plugin.fts.g.a.eaR).split(";");
        if (split != null) {
            for (Object add : split) {
                maU.add(add);
            }
        }
    }
}
