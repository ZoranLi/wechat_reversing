package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import junit.framework.Assert;

public final class d extends i<com.tencent.mm.plugin.exdevice.f.b.a.d> {
    public static final String[] gUx = new String[]{i.a(com.tencent.mm.plugin.exdevice.f.b.a.d.gTP, "HardDeviceRankInfo")};
    public e gUz;

    public d(e eVar) {
        super(eVar, com.tencent.mm.plugin.exdevice.f.b.a.d.gTP, "HardDeviceRankInfo", null);
        this.gUz = eVar;
        eVar.eE("HardDeviceRankInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankInfoRankIdAppNameIndex ON HardDeviceRankInfo ( rankID, appusername )");
    }

    public final com.tencent.mm.plugin.exdevice.f.b.a.d a(com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        com.tencent.mm.plugin.exdevice.f.b.a.d dVar2 = null;
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankInfo", "rankID", "username"});
        Cursor a = this.gUz.a(format, new String[]{bg.ap(dVar.lfJ, ""), bg.ap(dVar.username, "")}, 2);
        if (a == null) {
            w.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
        } else {
            if (a.moveToFirst()) {
                dVar2 = new com.tencent.mm.plugin.exdevice.f.b.a.d();
                dVar2.b(a);
            } else {
                w.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
            }
            a.close();
        }
        return dVar2;
    }

    public final void c(String str, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> arrayList) {
        if (bg.mA(str) || arrayList == null) {
            w.w("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo failed, rank id is null or nil or data is null.");
            return;
        }
        w.i("MicroMsg.ExdeviceRankInfoStg", "insertOrUpdateRankInfo, rankId(%s) , size(%d).", new Object[]{str, Integer.valueOf(arrayList.size())});
        for (int i = 0; i < arrayList.size(); i++) {
            a((com.tencent.mm.plugin.exdevice.f.b.a.d) arrayList.get(i), false);
        }
        ad.apC().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(str, null, null));
    }

    public final boolean a(com.tencent.mm.plugin.exdevice.f.b.a.d dVar, boolean z) {
        if (!b(dVar, z)) {
            Assert.assertTrue(dVar != null);
            b(dVar);
            w.d("MicroMsg.ExdeviceRankInfoStg", "hy: insert success");
            if (z) {
                ad.apC().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
            }
        }
        return true;
    }

    public final boolean b(com.tencent.mm.plugin.exdevice.f.b.a.d dVar, boolean z) {
        Assert.assertTrue(dVar != null);
        c a = a(new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        if (a == null) {
            return false;
        }
        a.field_likecount = dVar.field_likecount;
        a.field_selfLikeState = dVar.field_selfLikeState;
        c(a, new String[]{"rankID", "username"});
        w.d("MicroMsg.ExdeviceRankInfoStg", "hy: update success");
        if (!z) {
            return true;
        }
        ad.apC().a("HardDeviceRankInfo", new com.tencent.mm.plugin.exdevice.f.b.d(dVar.field_rankID, dVar.field_appusername, dVar.field_username));
        return true;
    }
}
