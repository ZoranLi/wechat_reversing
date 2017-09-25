package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.plugin.favorite.b.af;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.b.y;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements e {
    public static Map<Integer, a> fBk = new HashMap();
    public static Map<Integer, Integer> lGg = new HashMap();
    private Queue<j> fBi = new LinkedList();
    public boolean fBm = false;
    public boolean fBn = false;
    public int fBo = 0;
    public long fBp = 0;
    public aj fBt = new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
        final /* synthetic */ f lGh;

        {
            this.lGh = r1;
        }

        public final boolean oQ() {
            try {
                this.lGh.atX();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FavModService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);

    public f() {
        ap.vd().a(426, this);
    }

    public final void a(final int i, final int i2, String str, final k kVar) {
        if (kVar.getType() == 426 && (kVar instanceof af)) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ f lGh;

                public final void run() {
                    this.lGh.fBm = false;
                    int i = ((af) kVar).lFF;
                    f.fBk.remove(Integer.valueOf(i));
                    if (!(i2 == 3 && i2 == 0)) {
                        f fVar = this.lGh;
                        fVar.fBo--;
                    }
                    j bU = h.ata().bU((long) i);
                    if (bU != null && bU.field_itemStatus != 10) {
                        if (i != 0 || i2 != 0) {
                            Integer valueOf = Integer.valueOf(bg.a((Integer) f.lGg.get(Integer.valueOf(i)), 0));
                            if (!(i == 1 || i == 0)) {
                                valueOf = Integer.valueOf(valueOf.intValue() - 1);
                            }
                            if (valueOf.intValue() <= 0) {
                                int bW = x.bW(i, i2);
                                g.oUh.i(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(bU.field_type), Integer.valueOf(bW), Long.valueOf(x.k(bU)), Long.valueOf(x.bY(bU.field_localId))});
                                f.lGg.remove(Integer.valueOf(i));
                                w.e("MicroMsg.FavModService", "achieved retry limit, set error, favId:%d", new Object[]{Integer.valueOf(i)});
                                bU.field_itemStatus = 18;
                                h.ata().a(bU, "localId");
                            }
                        } else if (bU.field_itemStatus == 17) {
                            g.oUh.i(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(bU.field_type), Integer.valueOf(0), Long.valueOf(x.k(bU)), Long.valueOf(x.bY(bU.field_localId))});
                            w.v("MicroMsg.FavModService", "mod end set status done. favId:%d", new Object[]{Integer.valueOf(bU.field_id)});
                            bU.field_itemStatus = 10;
                            h.ata().a(bU, "localId");
                            h.asV().bR(bU.field_localId);
                        }
                        if (this.lGh.fBo <= 0) {
                            w.d("MicroMsg.FavModService", "klem stopFlag <= 0 , Stop Service");
                            this.lGh.pr();
                        } else if (!this.lGh.atX()) {
                            x.startSync();
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|onSceneEnd";
                }
            });
        }
    }

    public final void run() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ f lGh;

            {
                this.lGh = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.lGh.fBp;
                if (this.lGh.fBn) {
                    if (currentTimeMillis >= 60000) {
                        w.e("MicroMsg.FavModService", "klem ERR: Try Run service runningFlag:" + this.lGh.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.lGh.fBn);
                    } else {
                        return;
                    }
                }
                this.lGh.fBm = false;
                this.lGh.fBn = true;
                this.lGh.fBo = 3;
                this.lGh.fBt.v(10, 10);
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
            com.tencent.mm.plugin.favorite.b.k ata = h.ata();
            Cursor a = ata.gUz.a("select " + com.tencent.mm.plugin.favorite.b.k.lEl + " from FavItemInfo where itemStatus" + "=17", null, 2);
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
                    if (fBk.containsKey(Integer.valueOf(jVar3.field_id))) {
                        w.d("MicroMsg.FavModService", "File is Already running:" + jVar3.field_id);
                    } else {
                        if (!lGg.containsKey(Integer.valueOf(jVar3.field_id))) {
                            lGg.put(Integer.valueOf(jVar3.field_id), Integer.valueOf(3));
                        }
                        this.fBi.add(jVar3);
                        fBk.put(Integer.valueOf(jVar3.field_id), null);
                    }
                }
                w.d("MicroMsg.FavModService", "klem GetNeedRun procing:" + fBk.size() + ",send:" + this.fBi.size() + "]");
                this.fBi.size();
            }
        }
        if (this.fBm || this.fBi.size() > 0) {
            if (!this.fBm && this.fBi.size() > 0) {
                jVar3 = (j) this.fBi.poll();
                if (jVar3 != null && jVar3.field_id > 0) {
                    this.fBm = true;
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    if (jVar3.field_type != 18) {
                        y.a(jVar3.field_localId, linkedList, linkedList2);
                        ap.vd().a(new af(jVar3.field_id, linkedList, linkedList2), 0);
                    } else {
                        amj com_tencent_mm_protocal_c_amj = new amj();
                        com_tencent_mm_protocal_c_amj.tRc = 1;
                        com_tencent_mm_protocal_c_amj.tRd = (int) bg.Ny();
                        linkedList.add(com_tencent_mm_protocal_c_amj);
                        ap.vd().a(new af(jVar3.field_id, linkedList, linkedList2, j.b(jVar3)), 0);
                    }
                    return true;
                }
            }
            return false;
        }
        pr();
        w.d("MicroMsg.FavModService", "klem No Data Any More , Stop Service");
        return false;
    }

    public final void pr() {
        this.fBi.clear();
        fBk.clear();
        this.fBn = false;
        this.fBm = false;
        lGg.clear();
    }
}
