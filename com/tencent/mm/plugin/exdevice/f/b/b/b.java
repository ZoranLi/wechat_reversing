package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import junit.framework.Assert;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "HardDeviceChampionInfo")};
    private e gUz;

    public b(e eVar) {
        super(eVar, a.gTP, "HardDeviceChampionInfo", null);
        this.gUz = eVar;
        eVar.eE("HardDeviceChampionInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankChampionInfoRankIdAppNameIndex ON HardDeviceChampionInfo ( username )");
    }

    public final a vf(String str) {
        a aVar = null;
        String format = String.format("select *, rowid from %s where %s = ? limit 1", new Object[]{"HardDeviceChampionInfo", "username"});
        Cursor a = this.gUz.a(format, new String[]{bg.ap(str, "")}, 2);
        if (a == null) {
            w.e("MicroMsg.ExdeviceRankChampionStg", "Get no rank in DB");
        } else {
            if (a.moveToFirst()) {
                aVar = new a();
                aVar.b(a);
            } else {
                w.d("MicroMsg.ExdeviceRankChampionStg", "hy: no record");
            }
            a.close();
        }
        return aVar;
    }

    public final boolean a(a aVar, boolean z) {
        Assert.assertTrue(aVar != null);
        if (c(aVar, new String[]{"username"})) {
            w.d("MicroMsg.ExdeviceRankChampionStg", "hy: update success");
            ad.apC().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            return true;
        } else if (b(aVar)) {
            w.d("MicroMsg.ExdeviceRankChampionStg", "hy: insert success");
            ad.apC().a("HardDeviceChampionInfo", new d(null, null, aVar.field_username));
            return true;
        } else {
            w.w("MicroMsg.ExdeviceRankChampionStg", "hy: insert or update failed");
            return false;
        }
    }
}
