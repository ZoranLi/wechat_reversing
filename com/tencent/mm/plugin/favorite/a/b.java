package com.tencent.mm.plugin.favorite.a;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    public k gTU;
    private h lDR;
    public a lDS;
    public com.tencent.mm.sdk.e.e lDT;
    public com.tencent.mm.sdk.e.j.a lDU = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ b lDV;

        {
            this.lDV = r1;
        }

        public final void a(String str, l lVar) {
            if (lVar != null) {
                int i = lVar.uxq;
                if (lVar.obj != null) {
                    long longValue = ((Long) lVar.obj).longValue();
                    if (longValue >= 0) {
                        w.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "EventData: %s", new Object[]{lVar});
                        switch (i) {
                            case 2:
                            case 3:
                                this.lDV.gTU.a(65576, new e(this.lDV, longValue));
                                return;
                            case 5:
                                this.lDV.gTU.a(65576, new b(this.lDV, longValue));
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        }
    };

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b lDV;
        private HashSet<Long> lDW = null;
        private int lDX = 0;
        private int lDY = 0;
        private int lDZ = 0;
        private int mFailedCount = 0;

        public a(b bVar) {
            this.lDV = bVar;
        }

        public final boolean execute() {
            Exception e;
            Throwable th;
            int i;
            if (this.lDV.lDT == null) {
                w.w("MicroMsg.FTS.FTS5SearchFavoriteLogic", "favorite db is null, you need to wait the favorite db event!");
            } else {
                w.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to build favorite index!");
                if (this.lDW == null) {
                    this.lDW = new HashSet();
                    Cursor a;
                    try {
                        a = this.lDV.lDS.a(com.tencent.mm.plugin.fts.a.c.lZe, false, true, false, false, false);
                        while (a.moveToNext()) {
                            try {
                                this.lDW.add(Long.valueOf(a.getLong(0)));
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        if (a != null) {
                            a.close();
                        }
                        this.lDX = this.lDW.size();
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        try {
                            throw e;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        a = null;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                Cursor rawQuery = this.lDV.lDT.rawQuery("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE flag <> -1;", null);
                int i2 = 50;
                while (rawQuery.moveToNext()) {
                    if (Thread.interrupted()) {
                        this.lDV.lDS.commit();
                        throw new InterruptedException();
                    }
                    c cVar = new c(this.lDV);
                    cVar.b(rawQuery);
                    if (!this.lDW.remove(Long.valueOf(cVar.hEY))) {
                        if (i2 >= 50) {
                            this.lDV.lDS.commit();
                            this.lDV.lDS.beginTransaction();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        try {
                            i += this.lDV.a(cVar);
                            this.lDY++;
                            i2 = i;
                        } catch (Throwable th4) {
                            try {
                                w.printErrStackTrace("MicroMsg.FTS.FTS5SearchFavoriteLogic", th4, "Build favorite index failed with exception.\n", new Object[0]);
                                this.mFailedCount++;
                                i2 = i;
                            } catch (Exception e4) {
                                throw e4;
                            } catch (Throwable th5) {
                                if (rawQuery != null) {
                                    rawQuery.close();
                                }
                            }
                        }
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                this.lDV.lDS.commit();
                Iterator it = this.lDW.iterator();
                while (it.hasNext()) {
                    if (Thread.interrupted()) {
                        this.lDV.lDS.commit();
                        throw new InterruptedException();
                    }
                    if (i2 >= 50) {
                        this.lDV.lDS.commit();
                        this.lDV.lDS.beginTransaction();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    this.lDV.lDS.a(com.tencent.mm.plugin.fts.a.c.lZe, ((Long) it.next()).longValue());
                    i2 = i + 1;
                    this.lDZ++;
                    it.remove();
                }
                this.lDV.lDS.commit();
                w.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", toString());
            }
            return true;
        }

        public final String toString() {
            return "BuildFavoriteIndex [new: " + this.lDY + ", exist: " + this.lDX + ", removed: " + this.lDZ + ", failed: " + this.mFailedCount + "]";
        }

        public final int getId() {
            return 6;
        }
    }

    private class b extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b lDV;
        private long lEa;

        public b(b bVar, long j) {
            this.lDV = bVar;
            this.lEa = j;
        }

        public final boolean execute() {
            w.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to delete favorite item");
            this.lDV.lDS.a(com.tencent.mm.plugin.fts.a.c.lZe, this.lEa);
            w.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", toString());
            return true;
        }

        public final String toString() {
            return "DeleteFavItemTask id=" + this.lEa;
        }
    }

    private class c {
        String fOu;
        rv fTi;
        long hEY;
        long iCd;
        final /* synthetic */ b lDV;
        sd lEb;
        int type;

        public c(b bVar) {
            this.lDV = bVar;
        }

        public final void b(Cursor cursor) {
            this.hEY = cursor.getLong(0);
            this.type = cursor.getInt(1);
            this.iCd = cursor.getLong(2);
            this.fOu = cursor.getString(3);
            byte[] blob = cursor.getBlob(4);
            if (blob == null || blob.length == 0) {
                w.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "FavIndexItem protoData is null or data length is 0");
                this.fTi = new rv();
            } else {
                this.fTi = (rv) new rv().aD(blob);
            }
            blob = cursor.getBlob(5);
            if (blob == null || blob.length == 0) {
                this.lEb = null;
            } else {
                this.lEb = (sd) new sd().aD(blob);
            }
        }
    }

    private class d extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b lDV;

        public d(b bVar) {
            this.lDV = bVar;
        }

        public final boolean execute() {
            com.tencent.mm.plugin.favorite.h.ata().c(this.lDV.lDU);
            this.lDV.lDT = com.tencent.mm.plugin.favorite.h.ata().gUz;
            this.lDV.gTU.a(131122, new a(this.lDV));
            return true;
        }

        public final String getName() {
            return "InitFavoriteDBTask";
        }
    }

    private class e extends com.tencent.mm.plugin.fts.a.a.a {
        final /* synthetic */ b lDV;
        private long lEa;
        private int lEc;

        public e(b bVar, long j) {
            this.lDV = bVar;
            this.lEa = j;
        }

        public final boolean execute() {
            if (this.lDV.lDT == null) {
                w.e("MicroMsg.FTS.FTS5SearchFavoriteLogic", "InsertFavItemTask: fav db is null");
            } else {
                w.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "start to insert favorite item");
                Cursor a = this.lDV.lDT.a("SELECT localId, type, updateTime, fromUser, favProto, tagProto FROM FavItemInfo WHERE localId = ? AND flag <> -1;", new String[]{String.valueOf(this.lEa)}, 2);
                try {
                    if (a.moveToFirst()) {
                        c cVar = new c(this.lDV);
                        cVar.b(a);
                        a.close();
                        a = null;
                        this.lDV.lDS.beginTransaction();
                        this.lDV.lDS.a(com.tencent.mm.plugin.fts.a.c.lZe, this.lEa);
                        this.lEc = this.lDV.a(cVar);
                        this.lDV.lDS.commit();
                        w.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", toString());
                    }
                    if (a != null) {
                        a.close();
                    }
                } catch (Exception e) {
                    throw e;
                } catch (Throwable th) {
                    if (a != null) {
                        a.close();
                    }
                }
            }
            return true;
        }

        public final String toString() {
            return "InsertFavItemTask local id is " + this.lEa + " transactionCount: " + this.lEc;
        }
    }

    private class f extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ b lDV;

        f(b bVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.lDV = bVar;
            super(fVar);
        }

        protected final List<i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            HashMap hashMap = new HashMap();
            Cursor a = this.lDV.lDS.a(strArr, com.tencent.mm.plugin.fts.a.c.lZe, null, null, false, false);
            while (a.moveToNext()) {
                j e = new j().e(a);
                i iVar = (i) hashMap.get(Long.valueOf(e.mam));
                if (iVar == null || com.tencent.mm.plugin.fts.a.d.b(com.tencent.mm.plugin.fts.a.c.lZv, e.hPr, iVar.hPr) < 0) {
                    hashMap.put(Long.valueOf(e.mam), e);
                }
                if (Thread.interrupted()) {
                    a.close();
                    throw new InterruptedException();
                }
            }
            a.close();
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            List<i> arrayList = new ArrayList(hashMap.size());
            for (j add : hashMap.values()) {
                arrayList.add(add);
            }
            if (fVar.maf != null) {
                Collections.sort(arrayList, fVar.maf);
            }
            return arrayList;
        }

        public final String getName() {
            return "SearchFavoriteTask";
        }
    }

    private class g extends com.tencent.mm.plugin.fts.a.a.e {
        final /* synthetic */ b lDV;

        g(b bVar, com.tencent.mm.plugin.fts.a.a.f fVar) {
            this.lDV = bVar;
            super(fVar);
        }

        protected final List<i> a(String[] strArr, com.tencent.mm.plugin.fts.a.a.f fVar) {
            com.tencent.mm.plugin.fts.a.a aVar = this.lDV.lDS;
            int i = fVar.mad + 1;
            String s = com.tencent.mm.plugin.fts.a.d.s(strArr);
            Cursor rawQuery = aVar.lYU.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1) + ";", new Object[]{aVar.axE(), aVar.axE(), aVar.axF(), aVar.axE(), aVar.axF(), aVar.axF(), s}), null);
            List<i> arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            while (rawQuery.moveToNext()) {
                if (hashSet.add(String.valueOf(rawQuery.getLong(3)))) {
                    arrayList.add(new j().e(rawQuery));
                    if (arrayList.size() > fVar.mad) {
                        break;
                    } else if (Thread.interrupted()) {
                        rawQuery.close();
                        throw new InterruptedException();
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            if (!Thread.interrupted()) {
                return arrayList;
            }
            throw new InterruptedException();
        }

        public final String getName() {
            return "SearchTopFavoriteTask";
        }

        public final int getId() {
            return 9;
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(com.tencent.mm.plugin.fts.a.a.f fVar) {
        com.tencent.mm.plugin.fts.a.a.a gVar;
        if (fVar.lZZ == 1) {
            gVar = new g(this, fVar);
        } else {
            gVar = new f(this, fVar);
        }
        return this.gTU.a(-65536, gVar);
    }

    protected final boolean onCreate() {
        if (((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).isFTSContextReady()) {
            w.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Success!");
            this.gTU = ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSTaskDaemon();
            this.lDS = (a) ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSIndexStorage(256);
            this.lDR = ((com.tencent.mm.plugin.fts.a.l) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.fts.a.l.class)).getFTSMainDB();
            this.gTU.a(-65536, new d(this));
            return true;
        }
        w.i("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Create Fail!");
        return false;
    }

    protected final boolean tT() {
        com.tencent.mm.plugin.favorite.h.ata().f(this.lDU);
        this.lDS = null;
        this.gTU = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchFavoriteLogic";
    }

    private int a(String[] strArr, int[] iArr, long j, long j2, String str) {
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = strArr[2];
        if (str2 == null || str2.length() <= 0) {
            return 0;
        }
        String str5;
        String str6;
        String str7;
        if (str2.equalsIgnoreCase(str3)) {
            str5 = null;
            str6 = null;
        } else {
            str6 = str3;
            str5 = str4;
        }
        if (str6 == null || !str6.equalsIgnoreCase(str5)) {
            str7 = str5;
        } else {
            str7 = null;
        }
        this.lDS.a(196608, iArr[0], j, str, j2, str2);
        int i = 1;
        if (str6 != null && str6.length() > 0) {
            this.lDS.a(196608, iArr[1], j, str, j2, str6);
            i = 2;
        }
        if (str7 == null || str7.length() <= 0) {
            return i;
        }
        this.lDS.a(196608, iArr[2], j, str, j2, str7);
        return i + 1;
    }

    public final int a(c cVar) {
        long j = cVar.hEY;
        int i = cVar.type;
        long j2 = cVar.iCd;
        String str = cVar.fOu;
        rv rvVar = cVar.fTi;
        int i2 = 0;
        rr a = com.tencent.mm.pluginsdk.model.c.a(i, rvVar, cVar.lEb);
        if (a == null) {
            w.d("MicroMsg.FTS.FTS5SearchFavoriteLogic", "Fav info is null");
            return 0;
        }
        String pC;
        af wU;
        int a2;
        List<String> list;
        StringBuilder stringBuilder;
        String str2;
        int i3;
        Iterator it;
        String str3 = a.tzb;
        String str4 = a.fOu;
        if (str3 == null || str3.length() == 0 || str3.equals(str4)) {
            str3 = a.fOu;
            str4 = null;
        }
        String str5 = a.fCJ;
        String[] strArr = new String[3];
        int[] iArr = new int[3];
        if (str3 != null && str3.length() > 0) {
            af wU2 = this.lDR.wU(str3);
            if (wU2 != null) {
                String str6 = wU2.field_nickname;
                pC = wU2.pC();
                String pB = wU2.pB();
                String str7 = wU2.field_conRemark;
                str3 = wU2.field_conRemarkPYFull;
                String str8 = wU2.field_conRemarkPYShort;
                String str9;
                if (str7 == null || str7.length() == 0) {
                    str9 = pC;
                    pC = str6;
                    str6 = null;
                    str7 = null;
                    str3 = str9;
                    str8 = pB;
                    pB = null;
                } else {
                    str9 = str7;
                    str7 = pB;
                    pB = str6;
                    str6 = pC;
                    pC = str9;
                }
                strArr[0] = pC;
                strArr[1] = str3;
                strArr[2] = str8;
                iArr[0] = 9;
                iArr[1] = 10;
                iArr[2] = 11;
                int a3 = a(strArr, iArr, j, j2, str) + 0;
                strArr[0] = pB;
                strArr[1] = str6;
                strArr[2] = str7;
                iArr[0] = 12;
                iArr[1] = 13;
                iArr[2] = 14;
                i2 = a3 + a(strArr, iArr, j, j2, str);
            }
        }
        if (str4 != null && str4.length() > 0) {
            wU = this.lDR.wU(str4);
            if (wU != null) {
                pC = wU.field_conRemark;
                if (pC == null || pC.length() == 0) {
                    pC = wU.field_nickname;
                    str3 = wU.pC();
                    str4 = wU.pB();
                } else {
                    str3 = wU.field_conRemarkPYFull;
                    str4 = wU.field_conRemarkPYShort;
                }
                strArr[0] = pC;
                strArr[1] = str3;
                strArr[2] = str4;
                iArr[0] = 16;
                iArr[1] = 17;
                iArr[2] = 18;
                i2 += a(strArr, iArr, j, j2, str);
            }
        }
        if (str5 != null && str5.length() > 0) {
            wU = this.lDR.wU(str5);
            if (wU != null) {
                pC = wU.field_conRemark;
                if (pC == null || pC.length() == 0) {
                    pC = wU.field_nickname;
                    str3 = wU.pC();
                    str4 = wU.pB();
                } else {
                    str3 = wU.field_conRemarkPYFull;
                    str4 = wU.field_conRemarkPYShort;
                }
                strArr[0] = pC;
                strArr[1] = str3;
                strArr[2] = str4;
                iArr[0] = 20;
                iArr[1] = 21;
                iArr[2] = 22;
                a2 = a(strArr, iArr, j, j2, str) + i2;
                list = a.tzc;
                stringBuilder = new StringBuilder(256);
                for (String str42 : list) {
                    if (str42 != null && str42.length() > 0) {
                        stringBuilder.append(str42).append("​");
                    }
                }
                if (stringBuilder.length() > 0) {
                    this.lDS.a(196608, 7, j, str, j2, stringBuilder.toString());
                    a2++;
                }
                switch (i) {
                    case 2:
                        str2 = a.title;
                        if (!bg.mA(str2)) {
                            return a2;
                        }
                        this.lDS.a(196608, 23, j, str, j2, str2);
                        return a2 + 1;
                    case 5:
                        str2 = a.title;
                        if (!bg.mA(str2)) {
                            return a2;
                        }
                        this.lDS.a(196608, 1, j, str, j2, str2);
                        return a2 + 1;
                    case 6:
                        str2 = rvVar.iBi;
                        if (bg.mA(str2)) {
                            this.lDS.a(196608, 4, j, str, j2, str2);
                            i3 = a2 + 1;
                        } else {
                            i3 = a2;
                        }
                        str2 = rvVar.tyw.fRX;
                        if (!bg.mA(str2)) {
                            this.lDS.a(196608, 5, j, str, j2, str2);
                            i3++;
                        }
                        str2 = rvVar.tyw.label;
                        if (!bg.mA(str2)) {
                            return i3;
                        }
                        this.lDS.a(196608, 6, j, str, j2, str2);
                        return i3 + 1;
                    case 7:
                        str2 = a.title;
                        if (!bg.mA(str2)) {
                            this.lDS.a(196608, 1, j, str, j2, str2);
                            a2++;
                        }
                        str2 = a.desc;
                        if (!bg.mA(str2)) {
                            return a2;
                        }
                        this.lDS.a(196608, 3, j, str, j2, str2);
                        return a2 + 1;
                    case 14:
                        if (rvVar.tzn != null) {
                            return a2;
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        it = rvVar.tzn.iterator();
                        while (it.hasNext()) {
                            str42 = com.tencent.mm.pluginsdk.model.c.p((rm) it.next());
                            if (!bg.mA(str42)) {
                                stringBuilder.append(str42);
                                stringBuilder.append("​");
                            }
                        }
                        str2 = stringBuffer.toString();
                        if (!bg.mA(str2)) {
                            return a2;
                        }
                        this.lDS.a(196608, 1, j, str, j2, str2);
                        return a2 + 1;
                    default:
                        str2 = a.title;
                        if (!bg.mA(str2)) {
                            this.lDS.a(196608, 1, j, str, j2, str2);
                            a2++;
                        }
                        str2 = a.desc;
                        if (!bg.mA(str2)) {
                            return a2;
                        }
                        this.lDS.a(196608, 2, j, str, j2, str2);
                        return a2 + 1;
                }
            }
        }
        a2 = i2;
        list = a.tzc;
        stringBuilder = new StringBuilder(256);
        for (String str422 : list) {
            stringBuilder.append(str422).append("​");
        }
        if (stringBuilder.length() > 0) {
            this.lDS.a(196608, 7, j, str, j2, stringBuilder.toString());
            a2++;
        }
        switch (i) {
            case 2:
                str2 = a.title;
                if (!bg.mA(str2)) {
                    return a2;
                }
                this.lDS.a(196608, 23, j, str, j2, str2);
                return a2 + 1;
            case 5:
                str2 = a.title;
                if (!bg.mA(str2)) {
                    return a2;
                }
                this.lDS.a(196608, 1, j, str, j2, str2);
                return a2 + 1;
            case 6:
                str2 = rvVar.iBi;
                if (bg.mA(str2)) {
                    i3 = a2;
                } else {
                    this.lDS.a(196608, 4, j, str, j2, str2);
                    i3 = a2 + 1;
                }
                str2 = rvVar.tyw.fRX;
                if (bg.mA(str2)) {
                    this.lDS.a(196608, 5, j, str, j2, str2);
                    i3++;
                }
                str2 = rvVar.tyw.label;
                if (!bg.mA(str2)) {
                    return i3;
                }
                this.lDS.a(196608, 6, j, str, j2, str2);
                return i3 + 1;
            case 7:
                str2 = a.title;
                if (bg.mA(str2)) {
                    this.lDS.a(196608, 1, j, str, j2, str2);
                    a2++;
                }
                str2 = a.desc;
                if (!bg.mA(str2)) {
                    return a2;
                }
                this.lDS.a(196608, 3, j, str, j2, str2);
                return a2 + 1;
            case 14:
                if (rvVar.tzn != null) {
                    return a2;
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                it = rvVar.tzn.iterator();
                while (it.hasNext()) {
                    str422 = com.tencent.mm.pluginsdk.model.c.p((rm) it.next());
                    if (!bg.mA(str422)) {
                        stringBuilder.append(str422);
                        stringBuilder.append("​");
                    }
                }
                str2 = stringBuffer2.toString();
                if (!bg.mA(str2)) {
                    return a2;
                }
                this.lDS.a(196608, 1, j, str, j2, str2);
                return a2 + 1;
            default:
                str2 = a.title;
                if (bg.mA(str2)) {
                    this.lDS.a(196608, 1, j, str, j2, str2);
                    a2++;
                }
                str2 = a.desc;
                if (!bg.mA(str2)) {
                    return a2;
                }
                this.lDS.a(196608, 2, j, str, j2, str2);
                return a2 + 1;
        }
    }
}
