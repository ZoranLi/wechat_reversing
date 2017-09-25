package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.a.ne;
import com.tencent.mm.e.a.og;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.jni.FTSJNIUtils;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public final class c extends com.tencent.mm.plugin.fts.a.b implements com.tencent.mm.plugin.messenger.foundation.a.a.c.a, com.tencent.mm.sdk.e.j.a {
    public k gTU;
    public com.tencent.mm.plugin.fts.a.h lDR;
    private com.tencent.mm.sdk.b.c mbA = new com.tencent.mm.sdk.b.c<ne>(this) {
        final /* synthetic */ c mbF;

        {
            this.mbF = r2;
            this.usg = ne.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ne neVar = (ne) bVar;
            if (neVar instanceof ne) {
                this.mbF.gTU.a(65576, new c(this.mbF, neVar.fUq.fGM));
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mbB = new com.tencent.mm.sdk.b.c<nd>(this) {
        final /* synthetic */ c mbF;

        {
            this.mbF = r2;
            this.usg = nd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nd ndVar = (nd) bVar;
            if (ndVar instanceof nd) {
                this.mbF.gTU.a(65576, new c(this.mbF, ndVar.fUm.fGM));
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c mbC = new com.tencent.mm.sdk.b.c<og>(this) {
        final /* synthetic */ c mbF;

        {
            this.mbF = r2;
            this.usg = og.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.mbF.gTU.a(65574, new com.tencent.mm.plugin.fts.a.a.a(this) {
                final /* synthetic */ AnonymousClass3 mbG;

                {
                    this.mbG = r1;
                }

                public final boolean execute() {
                    this.mbG.mbF.mby.i(-200, Long.MAX_VALUE);
                    return true;
                }

                public final String toString() {
                    return "ResetMessageCreateTimeCursor";
                }
            });
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c mbD = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.e>(this) {
        final /* synthetic */ c mbF;

        {
            this.mbF = r2;
            this.usg = com.tencent.mm.e.a.e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((com.tencent.mm.e.a.e) bVar).fCm.fCn) {
                this.mbF.mbE.KH();
            } else {
                this.mbF.mbE.v(60000, 60000);
            }
            return false;
        }
    };
    aj mbE = new aj(com.tencent.mm.kernel.h.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c mbF;

        {
            this.mbF = r1;
        }

        public final boolean oQ() {
            if (!this.mbF.mbz) {
                this.mbF.mbz = true;
                this.mbF.gTU.a(131112, new a(this.mbF));
            }
            com.tencent.mm.sdk.b.a.urY.c(this.mbF.mbD);
            return false;
        }

        public final String toString() {
            return super.toString() + "|mBackgroundTimer";
        }
    }, false);
    public com.tencent.mm.plugin.fts.c.c mby;
    public boolean mbz = false;

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int lDY = 0;
        private int lDZ = 0;
        private int mFailedCount = 0;
        final /* synthetic */ c mbF;
        private HashSet<Pair<Long, Long>> mbH = null;
        private ArrayList<Long> mbI = null;
        private long mbJ = Long.MAX_VALUE;
        private int mbK = 0;

        public a(c cVar) {
            this.mbF = cVar;
        }

        public final boolean execute() {
            long j;
            this.mbJ = this.mbF.mby.lYU.h(-200, Long.MAX_VALUE);
            w.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Start building message index, last createTime: " + this.mbJ);
            if (this.mbH == null) {
                this.mbH = new HashSet();
                this.mbI = new ArrayList();
                Cursor a = this.mbF.mby.a(com.tencent.mm.plugin.fts.a.c.lZd, true, true, false, true, true);
                while (a.moveToNext()) {
                    j = a.getLong(0);
                    long j2 = a.getLong(1);
                    long j3 = a.getLong(2);
                    if (a.getInt(3) == -1) {
                        this.mbI.add(Long.valueOf(j));
                    } else if (j3 <= this.mbJ) {
                        this.mbH.add(new Pair(Long.valueOf(j2), Long.valueOf(j3)));
                    }
                }
                a.close();
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            int i = Integer.MAX_VALUE;
            String[] strArr = new String[2];
            List<f> arrayList = new ArrayList();
            while (i >= 50) {
                strArr[0] = Long.toString(this.mbJ);
                strArr[1] = Integer.toString(this.mbK);
                Cursor rawQuery = this.mbF.lDR.rawQuery("SELECT msgId, talker, createTime, content, type, isSend FROM message WHERE createTime<=? AND createTime!=0 AND type in (1, 49) ORDER BY createTime DESC, msgId DESC LIMIT 50 OFFSET ?;", strArr);
                i = 0;
                while (rawQuery.moveToNext()) {
                    f fVar = new f(this.mbF);
                    fVar.fGM = rawQuery.getLong(0);
                    fVar.fJL = rawQuery.getString(1);
                    fVar.iam = rawQuery.getLong(2);
                    fVar.content = rawQuery.getString(3);
                    fVar.msgType = rawQuery.getInt(4);
                    fVar.mbO = rawQuery.getInt(5);
                    fVar.mbN = 41;
                    if (c.a(fVar)) {
                        fVar.axQ();
                        if (fVar.isAvailable()) {
                            arrayList.add(fVar);
                        }
                    }
                    i++;
                }
                rawQuery.close();
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                int size = arrayList.size();
                if (size == 0) {
                    w.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d", new Object[]{Integer.valueOf(size)});
                } else {
                    w.i("MicroMsg.FTS.FTS5SearchMessageLogic", "build msgRecList size %d FROM %d to %d", new Object[]{Integer.valueOf(size), Long.valueOf(((f) arrayList.get(0)).fGM), Long.valueOf(((f) arrayList.get(size - 1)).fGM)});
                }
                if (size > 0) {
                    this.mbF.mby.beginTransaction();
                    for (f fVar2 : arrayList) {
                        j = fVar2.fGM;
                        long j4 = fVar2.iam;
                        if (j4 == this.mbJ) {
                            this.mbK++;
                        } else {
                            this.mbJ = j4;
                            this.mbK = 0;
                        }
                        if (!this.mbH.remove(new Pair(Long.valueOf(j), Long.valueOf(j4)))) {
                            try {
                                this.mbF.mby.a(fVar2.mbN, j, fVar2.fJL, j4, fVar2.mbP, fVar2.mbQ);
                                this.lDY++;
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.FTS.FTS5SearchMessageLogic", e, "Build message index failed with exception. \n%s", new Object[]{fVar2.mbP});
                                this.mFailedCount++;
                            }
                        }
                    }
                    this.mbF.mby.commit();
                    this.mbF.mby.i(-200, this.mbJ);
                }
                arrayList.clear();
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
            int i2 = 50;
            Iterator it = this.mbH.iterator();
            while (it.hasNext()) {
                if (Thread.interrupted()) {
                    this.mbF.mby.commit();
                    throw new InterruptedException();
                }
                int i3;
                if (i2 >= 50) {
                    this.mbF.mby.commit();
                    this.mbF.mby.beginTransaction();
                    i3 = 0;
                } else {
                    i3 = i2;
                }
                Pair pair = (Pair) it.next();
                this.mbF.mby.a(com.tencent.mm.plugin.fts.a.c.lZd, ((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                i2 = i3 + 1;
                this.lDZ++;
                it.remove();
            }
            this.mbF.mby.commit();
            i2 = 50;
            ListIterator listIterator = this.mbI.listIterator(this.mbI.size());
            while (listIterator.hasPrevious()) {
                if (Thread.interrupted()) {
                    this.mbF.mby.commit();
                    throw new InterruptedException();
                }
                if (i2 >= 50) {
                    this.mbF.mby.commit();
                    this.mbF.mby.beginTransaction();
                    size = 0;
                } else {
                    size = i2;
                }
                this.mbF.mby.h(Long.valueOf(((Long) listIterator.previous()).longValue()));
                i2 = size + 1;
                this.lDZ++;
                listIterator.remove();
            }
            this.mbF.mby.i(-200, this.mbJ - 1);
            this.mbF.mby.commit();
            this.mbF.mbz = false;
            return true;
        }

        public final String toString() {
            return "BuildMessageIndex [new: " + this.lDY + ", removed: " + this.lDZ + ", failed: " + this.mFailedCount + "]";
        }

        public final int getId() {
            return 4;
        }

        public final String getName() {
            return "BuildMessageIndexTask";
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        private int mCount = 0;
        final /* synthetic */ c mbF;

        public b(c cVar) {
            this.mbF = cVar;
        }

        public final boolean execute() {
            this.mCount = this.mbF.mby.e(com.tencent.mm.plugin.fts.a.c.lZd, -1).size();
            return true;
        }

        public final String toString() {
            return "DeleteAllMessages [" + this.mCount + "]";
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        private long gLE;
        final /* synthetic */ c mbF;

        public c(c cVar, long j) {
            this.mbF = cVar;
            this.gLE = j;
        }

        public final boolean execute() {
            this.mbF.mby.a(com.tencent.mm.plugin.fts.a.c.lZd, this.gLE);
            return true;
        }

        public final String toString() {
            return "DeleteMessage(" + this.gLE + ")";
        }
    }

    private class d extends com.tencent.mm.plugin.fts.a.a.a {
        private String kwJ;
        final /* synthetic */ c mbF;

        public d(c cVar, String str) {
            this.mbF = cVar;
            this.kwJ = str;
        }

        public final boolean execute() {
            com.tencent.mm.plugin.fts.c.c cVar = this.mbF.mby;
            String str = this.kwJ;
            cVar.mcq.bindLong(1, -1);
            cVar.mcq.bindString(2, str);
            cVar.mcq.bindLong(3, -1);
            cVar.mcq.execute();
            return true;
        }

        public final String toString() {
            return "DeleteMessageByTalker(\"" + this.kwJ + "\")";
        }
    }

    private class e extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ c mbF;
        private List<au> mbL = new ArrayList();
        private StringBuffer mbM;

        public e(c cVar, List<au> list) {
            this.mbF = cVar;
            this.mbL.addAll(list);
            this.mbM = new StringBuffer();
        }

        public final boolean execute() {
            List<f> arrayList = new ArrayList();
            for (au auVar : this.mbL) {
                f fVar = new f(this.mbF);
                fVar.fGM = auVar.field_msgId;
                fVar.fJL = auVar.field_talker;
                fVar.iam = auVar.field_createTime;
                fVar.content = auVar.field_content;
                fVar.msgType = auVar.field_type;
                fVar.mbO = auVar.field_isSend;
                if (c.a(fVar)) {
                    fVar.axQ();
                    if (fVar.isAvailable()) {
                        arrayList.add(fVar);
                    }
                }
            }
            this.mbM.append("InsertMessage: ");
            for (f fVar2 : arrayList) {
                this.mbM.append(fVar2.fGM);
                this.mbM.append(",");
                this.mbM.append(fVar2.iam);
                this.mbM.append(" ");
            }
            this.mbM.append("count: ");
            this.mbM.append(arrayList.size());
            if (arrayList.size() > 0) {
                this.mbF.mby.beginTransaction();
                for (f fVar3 : arrayList) {
                    this.mbF.mby.a(fVar3.mbN, fVar3.fGM, fVar3.fJL, fVar3.iam, fVar3.mbP, fVar3.mbQ);
                }
                this.mbF.mby.commit();
            }
            return true;
        }

        public final String toString() {
            return this.mbM.toString();
        }
    }

    private class f {
        String content;
        long fGM;
        String fJL;
        long iam;
        final /* synthetic */ c mbF;
        int mbN;
        int mbO;
        String mbP;
        String mbQ;
        int msgType;

        public f(c cVar) {
            this.mbF = cVar;
        }

        public final boolean axO() {
            return (this.msgType & 65535) == 49;
        }

        public final boolean axP() {
            return this.msgType == 1;
        }

        public final void axQ() {
            if (!axP()) {
                if (axO()) {
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.content);
                    if (ek != null) {
                        switch (ek.type) {
                            case 3:
                            case 4:
                            case 5:
                            case 8:
                            case 10:
                            case 13:
                            case 15:
                            case 16:
                            case 20:
                            case 25:
                                this.mbP = bg.ap(ek.getTitle(), "");
                                this.mbN = 43;
                                break;
                            case 6:
                                this.mbP = bg.ap(ek.getTitle(), "");
                                this.mbN = 42;
                                break;
                            case 19:
                                this.mbP = bg.ap(ek.getDescription(), "");
                                if (this.mbP != null) {
                                    this.mbP = this.mbP.replace(":", "​");
                                }
                                this.mbN = 44;
                                break;
                            case MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN /*2000*/:
                                this.mbP = bg.ap(ek.title, "") + "​" + bg.ap(ek.description, "");
                                this.mbN = 45;
                                break;
                            case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                                if (!"1001".equals(ek.hiV)) {
                                    if ("1002".equals(ek.hiV)) {
                                        this.mbN = 46;
                                        if (this.mbO != 1) {
                                            this.mbP = bg.ap(ek.hiT, "") + "​" + bg.ap(ek.hiP, "");
                                            break;
                                        } else {
                                            this.mbP = bg.ap(ek.hiT, "") + "​" + bg.ap(ek.hiQ, "");
                                            break;
                                        }
                                    }
                                }
                                this.mbN = 47;
                                if (this.mbO != 1) {
                                    this.mbP = bg.ap(ek.hiT, "") + "​" + bg.ap(ek.hiP, "");
                                    break;
                                } else {
                                    this.mbP = bg.ap(ek.hiT, "") + "​" + bg.ap(ek.hiQ, "");
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
            this.mbN = 41;
            if (o.dH(this.fJL)) {
                this.mbP = ay.gj(this.content);
            } else {
                this.mbP = this.content;
            }
            if (!bg.mA(this.mbP)) {
                this.mbP = com.tencent.mm.plugin.fts.a.d.wZ(this.mbP);
            }
            if (this.mbO == 1) {
                this.mbQ = m.xL();
            } else if (o.dH(this.fJL)) {
                this.mbQ = bg.ap(ay.gi(this.content), this.fJL);
            } else {
                this.mbQ = this.fJL;
            }
        }

        public final boolean isAvailable() {
            return !bg.mA(this.mbP);
        }
    }

    private class g extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ c mbF;

        private class a {
            int hPr;
            String lZO;
            long mam;
            final /* synthetic */ g mbR;
            long timestamp;
            int type;

            public a(g gVar) {
                this.mbR = gVar;
            }
        }

        public g(c cVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.mbF = cVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            xa("start");
            com.tencent.mm.plugin.fts.a.a aVar = this.mbF.mby;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 ORDER BY timestamp desc;", new Object[]{aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s}), null);
            List<a> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            List arrayList2 = new ArrayList();
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(3);
                if (hashSet.add(string)) {
                    a aVar2 = new a(this);
                    aVar2.type = rawQuery.getInt(0);
                    aVar2.hPr = rawQuery.getInt(1);
                    aVar2.mam = rawQuery.getLong(2);
                    aVar2.lZO = rawQuery.getString(3);
                    aVar2.timestamp = rawQuery.getLong(4);
                    arrayList.add(aVar2);
                    arrayList2.add(string);
                }
                if (arrayList.size() > fVar.mad) {
                    break;
                }
            }
            rawQuery.close();
            List linkedList = new LinkedList();
            xa("findUsername");
            if (arrayList2.size() > 0) {
                Cursor b = this.mbF.mby.b(strArr, arrayList2);
                HashMap hashMap = new HashMap();
                if (b.moveToNext()) {
                    String[] split = b.getString(0).split(" ");
                    for (int i = 0; i < split.length; i += 2) {
                        hashMap.put(split[i], Integer.valueOf(split[i + 1]));
                    }
                }
                b.close();
                for (a aVar3 : arrayList) {
                    com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                    iVar.type = aVar3.type;
                    iVar.hPr = aVar3.hPr;
                    iVar.mam = aVar3.mam;
                    iVar.lZO = aVar3.lZO;
                    iVar.timestamp = aVar3.timestamp;
                    if (hashMap.containsKey(iVar.lZO)) {
                        iVar.userData = hashMap.get(iVar.lZO);
                    } else {
                        iVar.userData = Integer.valueOf(1);
                    }
                    b.close();
                    linkedList.add(iVar);
                }
                xa("findCount");
            }
            return linkedList;
        }

        protected final String[] xb(String str) {
            return bg.bU(c.xe(str));
        }

        public final String getName() {
            return "SearchLimitGroupMessage";
        }

        public final int getId() {
            return 24;
        }
    }

    private class h extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ c mbF;

        h(c cVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.mbF = cVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a aVar = this.mbF.mby;
            String str = fVar.fJL;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            s = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[]{aVar.axE(), aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s});
            Cursor rawQuery = aVar.lYU.rawQuery(s, new String[]{str});
            List arrayList = new ArrayList();
            while (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.mak = rawQuery.getLong(0);
                jVar.type = rawQuery.getInt(1);
                jVar.hPr = rawQuery.getInt(2);
                jVar.mam = rawQuery.getLong(3);
                jVar.lZO = rawQuery.getString(4);
                jVar.timestamp = rawQuery.getLong(5);
                jVar.content = rawQuery.getString(6);
                jVar.fJL = rawQuery.getString(7);
                arrayList.add(jVar);
            }
            rawQuery.close();
            return arrayList;
        }

        protected final String[] xb(String str) {
            return bg.bU(c.xe(str));
        }

        public final String getName() {
            return "SearchTalkerMessageTask";
        }

        public final int getId() {
            return 14;
        }
    }

    private class i extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ c mbF;
        private int mbS = 0;

        public i(c cVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.mbF = cVar;
            super(fVar);
        }

        protected final List<com.tencent.mm.plugin.fts.a.a.i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a aVar = this.mbF.mby;
            int i = fVar.mad;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, content, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (i != Integer.MAX_VALUE ? " LIMIT " + (i + 1) : "") + ";", new Object[]{aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s}), null);
            List linkedList = new LinkedList();
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.fts.a.a.i iVar = new com.tencent.mm.plugin.fts.a.a.i();
                iVar.type = rawQuery.getInt(0);
                iVar.hPr = rawQuery.getInt(1);
                iVar.mam = rawQuery.getLong(2);
                iVar.lZO = rawQuery.getString(3);
                iVar.timestamp = rawQuery.getLong(4);
                iVar.content = rawQuery.getString(5);
                iVar.userData = Integer.valueOf(rawQuery.getInt(6));
                linkedList.add(iVar);
                this.mbS = ((Integer) iVar.userData).intValue() + this.mbS;
            }
            rawQuery.close();
            return linkedList;
        }

        protected final String[] xb(String str) {
            return bg.bU(c.xe(str));
        }

        public final String getName() {
            return "SearchTopGroupMessageTask";
        }

        public final String toString() {
            return String.format("%s[%s] ConvCount: %d MessageCount: %d", new Object[]{"SearchTopGroupMessageTask", this.lZW.fRM, Integer.valueOf(this.lZX), Integer.valueOf(this.mbS)});
        }

        public final int getId() {
            return 15;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.f fVar) {
        com.tencent.mm.plugin.fts.a.a.a gVar;
        switch (fVar.lZZ) {
            case 1:
                gVar = new g(this, fVar);
                break;
            case 3:
                gVar = new h(this, fVar);
                break;
            default:
                gVar = new i(this, fVar);
                break;
        }
        return this.gTU.a(-65536, gVar);
    }

    protected final boolean onCreate() {
        if (((l) com.tencent.mm.kernel.h.j(l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Success!");
            this.mby = (com.tencent.mm.plugin.fts.c.c) ((l) com.tencent.mm.kernel.h.j(l.class)).getFTSIndexStorage(4);
            this.gTU = ((l) com.tencent.mm.kernel.h.j(l.class)).getFTSTaskDaemon();
            this.lDR = ((l) com.tencent.mm.kernel.h.j(l.class)).getFTSMainDB();
            this.mbD.bIy();
            this.mbC.bIy();
            this.mbB.bIy();
            this.mbA.bIy();
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().c(this);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(this, null);
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchMessageLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().f(this);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().a(this);
        this.mbD.dead();
        this.mbC.dead();
        this.mbB.dead();
        this.mbA.dead();
        this.mby = null;
        this.gTU = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchMessageLogic";
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
        if (cVar2.nyO.equals("insert")) {
            List arrayList = new ArrayList();
            for (int i = 0; i < cVar2.nyP.size(); i++) {
                Object obj;
                au auVar = (au) cVar2.nyP.get(i);
                if (auVar == null || bg.mA(auVar.field_talker) || bg.mA(auVar.field_content)) {
                    obj = null;
                } else if (auVar.field_talker.endsWith("@app")) {
                    obj = null;
                } else if (auVar.field_type == 1 || auVar.axO()) {
                    int i2 = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(auVar);
                }
            }
            if (arrayList.size() > 0) {
                this.gTU.a(65576, new e(this, arrayList));
            }
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        String[] split = str.split(" ");
        if (split != null && split.length != 0) {
            if (split[0].equals("delete_id")) {
                this.gTU.a(65576, new c(this, bg.getLong(split[1], 0)));
            } else if (split[0].equals("delete_talker")) {
                this.gTU.a(65576, new d(this, split[1]));
            } else if (split[0].equals("delete_all") && split[1].equals("message")) {
                this.gTU.a(65576, new b(this));
            }
        }
    }

    public static boolean a(f fVar) {
        if (bg.mA(fVar.fJL) || bg.mA(fVar.content) || fVar.fJL.endsWith("@app")) {
            return false;
        }
        if (fVar.axP() || fVar.axO()) {
            return true;
        }
        return false;
    }

    public static List<String> xe(String str) {
        if (str.length() > 16) {
            str = str.substring(0, 16);
        }
        String mx = SpellMap.mx(str);
        List<String> arrayList = new ArrayList();
        String[] split = FTSJNIUtils.icuTokenizer(mx).split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (i < split.length) {
            try {
                int intValue = Integer.valueOf(split[i]).intValue();
                int intValue2 = Integer.valueOf(split[i + 1]).intValue();
                int i2 = intValue2 - intValue;
                int intValue3 = Integer.valueOf(split[i + 2]).intValue();
                String substring = mx.substring(intValue, intValue2);
                if (intValue3 < 400 || intValue3 >= 500) {
                    if (stringBuffer.length() > 0) {
                        arrayList.add(stringBuffer.toString());
                        stringBuffer = new StringBuffer();
                    }
                    if (!(substring.equals("*") || substring.equals(" "))) {
                        arrayList.add(substring);
                    }
                    i += 3;
                } else {
                    if (i2 == 1) {
                        stringBuffer.append(substring);
                    } else {
                        if (stringBuffer.length() > 0) {
                            arrayList.add(stringBuffer.toString());
                            stringBuffer = new StringBuffer();
                        }
                        arrayList.add(substring);
                    }
                    i += 3;
                }
            } catch (Exception e) {
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(stringBuffer.toString());
        }
        w.i("MicroMsg.FTS.FTS5SearchMessageLogic", "mmICUTokenize Query-tokenList: %s indexes: %s", new Object[]{arrayList, r6});
        return arrayList;
    }
}
