package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class az extends j implements a, f {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS role_info ( id TEXT PRIMARY KEY, name TEXT, status INT, text_reserved1 TEXT, text_reserved2 TEXT, text_reserved3 TEXT, text_reserved4 TEXT, int_reserved1 INT, int_reserved2 INT, int_reserved3 INT, int_reserved4 INT )"};
    private e gUz = null;

    public az(g gVar) {
        this.gUz = gVar;
    }

    public final int a(com.tencent.mm.bj.f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final String getTableName() {
        return "role_info";
    }

    public final ay AH(String str) {
        ay ayVar = null;
        if (str != null && str.length() > 0) {
            ay ayVar2 = new ay();
            Cursor a = this.gUz.a("role_info", null, "name LIKE ?", new String[]{"%" + str}, null, null, null, 2);
            if (a.moveToFirst()) {
                ayVar2.b(a);
                ayVar = ayVar2;
            }
            a.close();
        }
        return ayVar;
    }

    private ay RV(String str) {
        ay ayVar = null;
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        ay ayVar2 = new ay();
        Cursor a = this.gUz.a("role_info", null, "name= ?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            ayVar2.b(a);
            ayVar = ayVar2;
        }
        a.close();
        return ayVar;
    }

    public final List<ay> aKk() {
        List<ay> linkedList = new LinkedList();
        Cursor a = this.gUz.a("role_info", null, new StringBuilder("int_reserved1=1").toString(), null, null, null, null, 2);
        while (a.moveToNext()) {
            ay ayVar = new ay();
            ayVar.b(a);
            linkedList.add(ayVar);
        }
        a.close();
        return linkedList;
    }

    private void a(ay ayVar) {
        ayVar.fRW = b.CTRL_INDEX;
        ContentValues pv = ayVar.pv();
        if (pv.size() > 0 && this.gUz.insert("role_info", SlookAirButtonFrequentContactAdapter.ID, pv) != 0) {
            doNotify();
        }
    }

    public final boolean has(String str) {
        ay AH = AH(new ay.a(str).RU(""));
        return AH != null && str.equals(AH.name);
    }

    public final void bo(String str, int i) {
        if (bg.mA(str)) {
            w.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
        } else if (RV(str) == null) {
            a(new ay(str, true, i));
            w.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
        }
    }

    public final void ab(String str, boolean z) {
        if (bg.mA(str)) {
            w.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        ay RV = RV(str);
        if (RV == null) {
            a(new ay(str, z, 2));
            w.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        RV.fe(z);
        RV.fRW = 4;
        b(RV);
    }

    public final void c(String str, boolean z, boolean z2) {
        int i = 2;
        if (bg.mA(str)) {
            w.e("MicroMsg.RoleStorage", "insert role info failed: empty user");
            return;
        }
        ay RV = RV(str);
        if (RV == null) {
            a(new ay(str, z, 2));
            w.d("MicroMsg.RoleStorage", "insert new role, user=" + str);
            return;
        }
        RV.fe(z);
        if (z2) {
            int i2 = RV.status;
            if (!z2) {
                i = 0;
            }
            RV.status = i | i2;
        } else {
            RV.status &= -3;
        }
        RV.fRW = 4;
        b(RV);
    }

    private void b(ay ayVar) {
        ContentValues pv = ayVar.pv();
        if (pv.size() > 0) {
            int update = this.gUz.update("role_info", pv, "name like ?", new String[]{ayVar.name});
            w.d("MicroMsg.RoleStorage", "update role info, name=" + ayVar.name + ", res:" + update);
            if (update > 0) {
                doNotify();
            }
        }
    }

    public final void hP(String str) {
        Assert.assertTrue(str.length() > 0);
        int delete = this.gUz.delete("role_info", "name=?", new String[]{str});
        w.d("MicroMsg.RoleStorage", "delete name name :" + str + ", res:" + delete);
        if (delete > 0) {
            doNotify();
        }
    }
}
