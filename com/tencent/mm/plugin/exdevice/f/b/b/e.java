package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class e extends i<com.tencent.mm.plugin.exdevice.f.b.a.e> {
    public static final String[] gUx = new String[]{i.a(com.tencent.mm.plugin.exdevice.f.b.a.e.gTP, "HardDeviceLikeUser")};
    private com.tencent.mm.sdk.e.e gUz;

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, com.tencent.mm.plugin.exdevice.f.b.a.e.gTP, "HardDeviceLikeUser", null);
        this.gUz = eVar;
        eVar.eE("HardDeviceLikeUser", "CREATE INDEX IF NOT EXISTS ExdeviceRankLikeInfoRankIdAppNameIndex ON HardDeviceLikeUser ( rankID, appusername )");
    }

    public final ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> vg(String str) {
        ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList = null;
        if (bg.mA(str)) {
            w.e("MicroMsg.ExdeviceRankLikeUserStg", "hy: param error");
        } else {
            String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceLikeUser", "rankID", "timestamp"});
            Cursor a = this.gUz.a(format, new String[]{bg.ap(str, "")}, 2);
            if (a == null) {
                w.e("MicroMsg.ExdeviceRankLikeUserStg", "Get no rank in DB");
            } else {
                if (a.moveToFirst()) {
                    arrayList = new ArrayList();
                    do {
                        com.tencent.mm.plugin.exdevice.f.b.a.e eVar = new com.tencent.mm.plugin.exdevice.f.b.a.e();
                        eVar.b(a);
                        arrayList.add(eVar);
                    } while (a.moveToNext());
                }
                a.close();
            }
        }
        return arrayList;
    }

    public final void a(String str, String str2, ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.e> arrayList) {
        Assert.assertTrue(!bg.mA(str));
        if (arrayList == null) {
            w.i("MicroMsg.ExdeviceRankLikeUserStg", "batchInsertOrUpdate failed, data is null.");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.f.b.a.e eVar = (com.tencent.mm.plugin.exdevice.f.b.a.e) it.next();
            Assert.assertTrue(eVar != null);
            if (c(eVar, new String[]{"rankID", "username"})) {
                w.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: update success");
            } else if (b(eVar)) {
                w.d("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert success");
            } else {
                w.w("MicroMsg.ExdeviceRankLikeUserStg", "hy: insert or update failed");
            }
        }
        ad.apC().a("HardDeviceLikeUser", new d(str, str2, null));
    }
}
