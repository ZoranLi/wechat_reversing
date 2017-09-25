package com.tencent.mm.plugin.favorite.c;

import android.os.SystemClock;
import com.tencent.mm.plugin.favorite.b.af;
import com.tencent.mm.plugin.favorite.b.g;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d implements e {
    public Map<String, a> lGd = new HashMap();

    private static class a {
        int lFF;
        g lFG;
        int retryCount;
        long time;
    }

    public d() {
        ap.vd().a(426, this);
        ap.vd().a(401, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar != null) {
            w.i("MicroMsg.FavEditService", "on edit service scene end, errType=%d errCode=%d, %s, scene type %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType())});
            if (kVar.getType() == 401) {
                w.d("MicroMsg.FavEditService", "on add fav item scene end, try mod item");
                run();
                return;
            }
            af afVar = (af) kVar;
            if (afVar.type == 0) {
                return;
            }
            long atS;
            int atT;
            if (i == 0 && i2 == 0) {
                w.d("MicroMsg.FavEditService", "clear job, key %s", new Object[]{r(afVar.atS(), afVar.atT())});
                this.lGd.remove(r0);
                h asW = com.tencent.mm.plugin.favorite.h.asW();
                atS = afVar.atS();
                atT = afVar.atT();
                asW.gUz.delete("FavEditInfo", "localId=? and type=?", new String[]{String.valueOf(atS), String.valueOf(atT)});
                j bT = com.tencent.mm.plugin.favorite.h.ata().bT(afVar.atS());
                if (bT != null) {
                    com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(bT.field_id);
                    objArr[1] = Integer.valueOf(bT.field_tagProto.tzx.size());
                    objArr[2] = Integer.valueOf(com.tencent.mm.plugin.favorite.h.asT().atr());
                    objArr[3] = Integer.valueOf(afVar.lFG == null ? 1 : afVar.lFG.field_scene);
                    gVar.i(11122, objArr);
                    return;
                }
                return;
            }
            w.d("MicroMsg.FavEditService", "retry job, key %s", new Object[]{r(afVar.atS(), afVar.atT())});
            final a aVar = (a) this.lGd.get(r0);
            if (aVar == null) {
                w.w("MicroMsg.FavEditService", "want to retry mod item, localid %d, type %d", new Object[]{Long.valueOf(atS), Integer.valueOf(atT)});
            } else {
                ap.vL().e(new Runnable(this) {
                    final /* synthetic */ d lGe;

                    public final void run() {
                        d.a(aVar, false);
                    }

                    public final String toString() {
                        return super.toString() + "|retryJob";
                    }
                }, 3000);
            }
        }
    }

    public final void run() {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ d lGe;

            {
                this.lGe = r1;
            }

            public final void run() {
                List<g> ate = com.tencent.mm.plugin.favorite.h.asW().ate();
                if (ate != null) {
                    w.d("MicroMsg.FavEditService", "infos size %d", new Object[]{Integer.valueOf(ate.size())});
                    for (g gVar : ate) {
                        String r = d.r(gVar.field_localId, gVar.field_type);
                        a aVar = (a) this.lGe.lGd.get(r);
                        if (aVar == null) {
                            w.d("MicroMsg.FavEditService", "not match key %s", new Object[]{r});
                            aVar = new a();
                            aVar.lFG = gVar;
                            aVar.retryCount = 3;
                            aVar.time = SystemClock.elapsedRealtime();
                            this.lGe.lGd.put(r, aVar);
                            d.a(aVar, true);
                        } else {
                            w.d("MicroMsg.FavEditService", "match key %s, check start", new Object[]{r});
                            d.a(aVar, false);
                        }
                    }
                }
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    public static void a(a aVar, boolean z) {
        aVar.retryCount--;
        if (aVar.retryCount < 0) {
            if (SystemClock.elapsedRealtime() - aVar.time < 7200000) {
                w.d("MicroMsg.FavEditService", "try mod item fail time limit, favid %d, localId %d, edit type %d", new Object[]{Integer.valueOf(aVar.lFF), Long.valueOf(aVar.lFG.field_localId), Integer.valueOf(aVar.lFG.field_type)});
                return;
            }
            aVar.time = SystemClock.elapsedRealtime();
            aVar.retryCount = 3;
        }
        if (aVar.lFF <= 0) {
            j bT = com.tencent.mm.plugin.favorite.h.ata().bT(aVar.lFG.field_localId);
            if (bT == null || bT.field_id <= 0) {
                w.w("MicroMsg.FavEditService", "want to start mod item, but favid is invalid, local id %d", new Object[]{Long.valueOf(aVar.lFG.field_localId)});
                return;
            }
            aVar.lFF = bT.field_id;
            w.d("MicroMsg.FavEditService", "want mod item, find id %d by local id %d", new Object[]{Integer.valueOf(aVar.lFF), Long.valueOf(aVar.lFG.field_localId)});
        } else if (!z) {
            w.w("MicroMsg.FavEditService", "want to mod item, favid %d, it is running, but not enforce, return", new Object[]{Integer.valueOf(aVar.lFF)});
            return;
        }
        w.d("MicroMsg.FavEditService", "try mod item, enforce %B, favid %d, edit type %d", new Object[]{Boolean.valueOf(z), Integer.valueOf(aVar.lFF), Integer.valueOf(aVar.lFG.field_type)});
        ap.vd().a(new af(aVar.lFF, aVar.lFG), 0);
    }

    public static String r(long j, int i) {
        return j + "&&" + i;
    }
}
