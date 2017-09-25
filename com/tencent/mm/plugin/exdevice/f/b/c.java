package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.a.f;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.f.a.m;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c implements e {
    public f lgd;
    public f lge;

    public c() {
        w.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        ap.vd().a(1042, this);
        ap.vd().a(1041, this);
        ap.vd().a(1043, this);
        ap.vd().a(1040, this);
    }

    public static void b(String str, String str2, String str3, int i) {
        ap.vd().a(new l(str3, str2, i, str), 0);
    }

    public static ArrayList<d> vb(String str) {
        ArrayList<d> arrayList = null;
        w.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (bg.mA(str)) {
            w.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
        } else {
            com.tencent.mm.plugin.exdevice.f.b.b.d apu = ad.apu();
            if (bg.mA(str)) {
                w.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceRankInfo", "rankID", "score"});
                Cursor a = apu.gUz.a(format, new String[]{bg.ap(str, "")}, 2);
                if (a == null) {
                    w.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                } else {
                    if (a.moveToFirst()) {
                        arrayList = new ArrayList();
                        do {
                            d dVar = new d();
                            dVar.b(a);
                            arrayList.add(dVar);
                        } while (a.moveToNext());
                    } else {
                        w.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    }
                    a.close();
                }
            }
        }
        return arrayList;
    }

    public static void b(String str, ArrayList<d> arrayList) {
        com.tencent.mm.plugin.exdevice.f.b.b.d apu = ad.apu();
        Assert.assertTrue(!bg.mA(str));
        if (arrayList != null) {
            int i;
            Cursor a = apu.gUz.a(String.format("select COUNT(*) from %s where %s = ?", new Object[]{"HardDeviceRankInfo", "rankID"}), new String[]{bg.ap(str, "")}, 2);
            if (a == null) {
                w.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i = 0;
            } else {
                if (a.moveToFirst()) {
                    i = a.getInt(0);
                } else {
                    w.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    i = 0;
                }
                a.close();
            }
            Iterator it;
            if (i == 0) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    apu.a((d) it.next(), false);
                }
                return;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                apu.b((d) it.next(), false);
            }
            return;
        }
        w.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar instanceof j) {
            if (i != 0 || i2 != 0) {
                w.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
            }
        } else if (kVar instanceof l) {
            if (i != 0 || i2 != 0) {
                w.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        } else if (!(kVar instanceof m)) {
        } else {
            if (i != 0 || i2 != 0) {
                w.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        }
    }
}
