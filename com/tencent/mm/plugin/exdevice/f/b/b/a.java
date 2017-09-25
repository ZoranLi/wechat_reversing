package com.tencent.mm.plugin.exdevice.f.b.b;

import android.database.Cursor;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.b;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class a extends i<c> {
    public static final String[] gUx = new String[]{i.a(c.gTP, "HardDeviceRankFollowInfo")};
    private e gUz;

    public a(e eVar) {
        super(eVar, c.gTP, "HardDeviceRankFollowInfo", null);
        this.gUz = eVar;
        eVar.eE("HardDeviceRankFollowInfo", "CREATE INDEX IF NOT EXISTS ExdeviceRankFollowRankIdAppNameIndex ON HardDeviceRankFollowInfo ( rankID, appusername )");
    }

    public final c a(b bVar) {
        c cVar = null;
        String format = String.format("select *, rowid from %s where %s = ? and %s = ? and %s = ? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "username", "appusername"});
        Cursor a = this.gUz.a(format, new String[]{bg.ap(bVar.lfJ, ""), bg.ap(bVar.username, ""), bg.ap(bVar.appName, "")}, 2);
        if (a == null) {
            w.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get no follow in DB");
        } else {
            if (a.moveToFirst()) {
                cVar = new c();
                cVar.b(a);
            } else {
                w.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            a.close();
        }
        return cVar;
    }

    public final boolean vd(String str) {
        String format = String.format("select * from %s where %s=? and %s=? and %s=? limit 1", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername", "username"});
        Cursor a = this.gUz.a(format, new String[]{bg.ap("hardcode_rank_id", ""), bg.ap("hardcode_app_name", ""), bg.ap(str, "")}, 2);
        if (a == null) {
            w.e("MicroMsg.ExdeviceFollowInfoStg", "ap: check follow not in DB");
            return false;
        }
        boolean moveToFirst = a.moveToFirst();
        a.close();
        w.d("MicroMsg.ExdeviceFollowInfoStg", "checkUserIsFollow %s", new Object[]{Boolean.valueOf(moveToFirst)});
        return moveToFirst;
    }

    public final ArrayList<c> apH() {
        ArrayList<c> arrayList = null;
        String format = String.format("select *, rowid from %s where %s= ? and %s = ? order by rowid asc", new Object[]{"HardDeviceRankFollowInfo", "rankID", "appusername"});
        Cursor a = this.gUz.a(format, new String[]{"hardcode_rank_id", "hardcode_app_name"}, 2);
        if (a == null) {
            w.e("MicroMsg.ExdeviceFollowInfoStg", "ap: Get follows not in DB");
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    c cVar = new c();
                    cVar.b(a);
                    w.d("MicroMsg.ExdeviceFollowInfoStg", "follow info: rowid: %s, info: %s", new Object[]{Integer.valueOf(a.getColumnIndex("rowid")), cVar.toString()});
                    arrayList.add(cVar);
                } while (a.moveToNext());
                w.d("MicroMsg.ExdeviceFollowInfoStg", "getAllFollowItem: %d, %s", new Object[]{Integer.valueOf(arrayList.size()), arrayList.toString()});
            } else {
                w.d("MicroMsg.ExdeviceFollowInfoStg", "ap: no record");
            }
            a.close();
        }
        return arrayList;
    }

    public final void a(ArrayList<sk> arrayList, String str, String str2) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sk skVar = (sk) it.next();
                c cVar = new c();
                cVar.field_rankID = str;
                cVar.field_step = skVar.kzY;
                cVar.field_username = skVar.username;
                cVar.field_appusername = str2;
                a(cVar);
            }
        }
    }

    public final void aq(List<c> list) {
        String str = "hardcode_app_name";
        if (bg.mA("hardcode_rank_id") || bg.mA(str)) {
            w.e("MicroMsg.ExdeviceFollowInfoStg", "ap: delete follows,params is null");
        } else {
            int delete = this.gUz.delete("HardDeviceRankFollowInfo", "rankID=? and appusername=?", new String[]{r0, str});
            w.d("MicroMsg.ExdeviceFollowInfoStg", "ap: delete rankId: %s %s count %d", new Object[]{r0, str, Integer.valueOf(delete)});
        }
        if (list != null) {
            for (c cVar : list) {
                cVar.field_rankID = "hardcode_rank_id";
                cVar.field_appusername = "hardcode_app_name";
                a(cVar);
            }
        }
    }

    private boolean a(c cVar) {
        boolean z;
        boolean z2 = false;
        if (cVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        com.tencent.mm.sdk.e.c a = a(new b(cVar.field_rankID, cVar.field_appusername, cVar.field_username));
        if (a != null) {
            a.field_step = cVar.field_step;
            c(a, new String[]{"rankID", "appusername", "username"});
            w.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (cVar != null) {
                z2 = true;
            }
            Assert.assertTrue(z2);
            b(cVar);
            w.d("MicroMsg.ExdeviceFollowInfoStg", "ap: insert success");
        }
        return true;
    }

    public final boolean ve(String str) {
        com.tencent.mm.sdk.e.c a = a(new b("hardcode_rank_id", "hardcode_app_name", str));
        if (a == null) {
            return false;
        }
        a(a, new String[]{"rankID", "appusername", "username"});
        w.d("MicroMsg.ExdeviceFollowInfoStg", "ap: update success");
        return true;
    }
}
