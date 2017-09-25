package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.favorite.b.ac;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.k;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b implements e {
    public static Map<Long, a> fBk = new HashMap();
    private Queue<j> fBi = new LinkedList();
    public boolean fBm = false;
    public boolean fBn = false;
    public long fBp = 0;
    public aj fBt = new aj(ap.vL().nJF.getLooper(), new aj.a(this) {
        final /* synthetic */ b lFT;

        {
            this.lFT = r1;
        }

        public final boolean oQ() {
            try {
                this.lFT.pq();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CheckFavCdnService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    public m hyk = new m.a(this) {
        final /* synthetic */ b lFT;

        {
            this.lFT = r1;
        }

        public final void cU(int i) {
            List list = null;
            try {
                boolean isWifi = am.isWifi(ab.getContext());
                if (i == 4 || i == 6) {
                    w.i("MicroMsg.CheckFavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(this.lFT.lFS)});
                    if (!this.lFT.lFS && isWifi) {
                        b bVar = this.lFT;
                        k ata = h.ata();
                        Cursor rawQuery = ata.gUz.rawQuery("select " + k.lEl + " from FavItemInfo where itemStatus" + "=3", null);
                        if (rawQuery != null) {
                            if (rawQuery.getCount() == 0) {
                                rawQuery.close();
                            } else {
                                list = new LinkedList();
                                while (rawQuery.moveToNext()) {
                                    j jVar = new j();
                                    jVar.b(rawQuery);
                                    list.add(jVar);
                                }
                                rawQuery.close();
                            }
                        }
                        if (list != null && list.size() > 0) {
                            w.i("MicroMsg.CheckFavCdnService", "startAll list.size:%d", new Object[]{Integer.valueOf(list.size())});
                            for (j jVar2 : list) {
                                if (jVar2.field_itemStatus == 3) {
                                    jVar2.field_itemStatus = 1;
                                    h.ata().a(jVar2, "localId");
                                }
                            }
                            bVar.run();
                        }
                    }
                    this.lFT.lFS = isWifi;
                    return;
                }
                this.lFT.lFS = isWifi;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.CheckFavCdnService", e, "", new Object[0]);
            }
        }
    };
    public boolean lFS = am.isWifi(ab.getContext());

    public b() {
        ap.a(this.hyk);
        ap.vd().a(TencentLocation.ERROR_UNKNOWN, this);
    }

    public final void a(final int i, int i2, String str, final com.tencent.mm.y.k kVar) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ b lFT;

            public final void run() {
                if (kVar.getType() == TencentLocation.ERROR_UNKNOWN && (kVar instanceof ac)) {
                    this.lFT.fBm = false;
                    long j = ((ac) kVar).lFt.field_localId;
                    j jVar = ((ac) kVar).lFt;
                    b.fBk.remove(Long.valueOf(j));
                    if (i != 0) {
                        w.e("MicroMsg.CheckFavCdnService", "achieved retry limit, set error, localId:%d", new Object[]{Long.valueOf(j)});
                        g.oUh.i(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(jVar.field_type), Integer.valueOf(-2), Long.valueOf(x.k(jVar)), Long.valueOf(x.bY(jVar.field_localId))});
                        h.ata().r(3, j);
                    }
                    this.lFT.pq();
                }
            }

            public final String toString() {
                return super.toString() + "|onSceneEnd";
            }
        });
    }

    public final void run() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ b lFT;

            {
                this.lFT = r1;
            }

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis() - this.lFT.fBp;
                if (this.lFT.fBn) {
                    if (currentTimeMillis >= 60000) {
                        w.e("MicroMsg.CheckFavCdnService", "klem ERR: Try Run service runningFlag:" + this.lFT.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.lFT.fBn);
                    } else {
                        return;
                    }
                }
                this.lFT.fBm = false;
                this.lFT.fBn = true;
                this.lFT.fBt.v(10, 10);
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public final void pq() {
        j jVar;
        this.fBp = System.currentTimeMillis();
        if (!this.fBm && this.fBi.size() == 0) {
            k ata = h.ata();
            Cursor a = ata.gUz.a("select " + k.lEl + " from FavItemInfo where itemStatus" + "=1", null, 2);
            List list;
            if (a == null) {
                list = null;
            } else {
                if (a.moveToFirst()) {
                    list = new LinkedList();
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
                    if (fBk.containsKey(Long.valueOf(jVar3.field_localId))) {
                        w.d("MicroMsg.CheckFavCdnService", "File is Already running:" + jVar3.field_localId);
                    } else {
                        this.fBi.add(jVar3);
                        fBk.put(Long.valueOf(jVar3.field_localId), null);
                    }
                }
                w.d("MicroMsg.CheckFavCdnService", "klem GetNeedRun procing:" + fBk.size() + ",send:" + this.fBi.size() + "]");
                this.fBi.size();
            }
        }
        if (!this.fBm && this.fBi.size() <= 0) {
            pr();
            w.d("MicroMsg.CheckFavCdnService", "klem No Data Any More , Stop Service");
        } else if (!this.fBm && this.fBi.size() > 0) {
            jVar3 = (j) this.fBi.poll();
            if (jVar3 != null && jVar3.field_localId > 0) {
                this.fBm = true;
                ap.vd().a(new ac(jVar3), 0);
            }
        }
    }

    public final void pr() {
        this.fBi.clear();
        fBk.clear();
        this.fBn = false;
        this.fBm = false;
    }
}
