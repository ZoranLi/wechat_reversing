package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.b.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class h implements e {
    public static Map<Long, a> fBk = new HashMap();
    public static Map<Long, Integer> lGg = new HashMap();
    public static Set<Long> lGu = new HashSet();
    private Queue<j> fBi = new LinkedList();
    public boolean fBm = false;
    public boolean fBn = false;
    public int fBo = 0;
    public long fBp = 0;
    public aj fBt = new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
        final /* synthetic */ h lGv;

        {
            this.lGv = r1;
        }

        public final boolean oQ() {
            try {
                this.lGv.atX();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SendFavService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private int hZa = 0;

    public h() {
        ap.vd().a(401, this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ h lGv;

            public final void run() {
                if (kVar.getType() == 401 && (kVar instanceof z)) {
                    this.lGv.fBm = false;
                    j jVar = ((z) kVar).lFm;
                    long j = jVar.field_localId;
                    h.fBk.remove(Long.valueOf(j));
                    if ((i == 0 && i2 == 0) || i2 == -400) {
                        h.lGu.add(Long.valueOf(j));
                    }
                    if (!(i == 0 || i2 == -400)) {
                        h hVar = this.lGv;
                        hVar.fBo--;
                    }
                    Integer valueOf = Integer.valueOf(bg.a((Integer) h.lGg.get(Long.valueOf(j)), 0));
                    if (!(i == 1 || i == 0)) {
                        valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        h.lGg.put(Long.valueOf(jVar.field_localId), valueOf);
                    }
                    if (valueOf.intValue() <= 0) {
                        int bW = x.bW(i, i2);
                        g.oUh.i(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(jVar.field_type), Integer.valueOf(bW), Long.valueOf(x.k(jVar)), Long.valueOf(x.bY(jVar.field_localId))});
                        h.lGg.remove(Long.valueOf(j));
                        w.e("MicroMsg.SendFavService", "achieved retry limit, set error, localId:%d", new Object[]{Long.valueOf(j)});
                        if (jVar.field_itemStatus == 12) {
                            com.tencent.mm.plugin.favorite.h.ata().r(14, jVar.field_localId);
                        }
                        if (jVar.field_itemStatus == 9) {
                            com.tencent.mm.plugin.favorite.h.ata().r(11, jVar.field_localId);
                        }
                    }
                    if (this.lGv.fBo <= 0) {
                        w.d("MicroMsg.SendFavService", "klem stopFlag <= 0 , Stop Service");
                        this.lGv.pr();
                    } else if (!this.lGv.atX()) {
                        x.startSync();
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void run() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ h lGv;

            {
                this.lGv = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.lGv.fBp;
                if (this.lGv.fBn) {
                    if (currentTimeMillis >= 60000) {
                        w.e("MicroMsg.SendFavService", "klem ERR: Try Run service runningFlag:" + this.lGv.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.lGv.fBn);
                    } else {
                        return;
                    }
                }
                this.lGv.fBm = false;
                this.lGv.fBn = true;
                this.lGv.fBo = 3;
                this.lGv.fBt.v(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final boolean atX() {
        j jVar;
        this.fBp = System.currentTimeMillis();
        if (!this.fBm && this.fBi.size() == 0) {
            com.tencent.mm.plugin.favorite.b.k ata = com.tencent.mm.plugin.favorite.h.ata();
            Cursor a = ata.gUz.a("select " + com.tencent.mm.plugin.favorite.b.k.lEl + " from FavItemInfo where (itemStatus" + "=9 or itemStatus" + "=12)", null, 2);
            List list;
            if (a == null) {
                list = null;
            } else {
                if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        j jVar2 = new j();
                        jVar2.b(a);
                        list.add(jVar2);
                    } while (a.moveToNext());
                } else {
                    list = null;
                }
                a.close();
            }
            if (!(r0 == null || r0.size() == 0)) {
                for (j jVar3 : r0) {
                    if (lGu.contains(Long.valueOf(jVar3.field_localId))) {
                        w.d("MicroMsg.SendFavService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", new Object[]{Integer.valueOf(jVar3.field_id), Long.valueOf(jVar3.field_localId), Integer.valueOf(jVar3.field_sourceType), jVar3.field_sourceId});
                    } else if (fBk.containsKey(Long.valueOf(jVar3.field_localId))) {
                        w.d("MicroMsg.SendFavService", "File is Already running:" + jVar3.field_localId);
                    } else {
                        if (!lGg.containsKey(Long.valueOf(jVar3.field_localId))) {
                            lGg.put(Long.valueOf(jVar3.field_localId), Integer.valueOf(3));
                        }
                        this.fBi.add(jVar3);
                        fBk.put(Long.valueOf(jVar3.field_localId), null);
                    }
                }
                w.d("MicroMsg.SendFavService", "klem GetNeedRun procing:" + fBk.size() + ",send:" + this.fBi.size() + "]");
                this.fBi.size();
            }
        }
        if (this.fBm || this.fBi.size() > 0) {
            if (!this.fBm && this.fBi.size() > 0) {
                jVar3 = (j) this.fBi.poll();
                if (jVar3 != null && jVar3.field_localId > 0) {
                    this.fBm = true;
                    ap.vd().a(new z(jVar3), 0);
                    return true;
                }
            }
            return false;
        }
        pr();
        w.d("MicroMsg.SendFavService", "klem No Data Any More , Stop Service");
        return false;
    }

    public final void pr() {
        w.i("MicroMsg.SendFavService", "on finish");
        this.fBi.clear();
        fBk.clear();
        this.fBn = false;
        this.fBm = false;
        lGg.clear();
    }
}
