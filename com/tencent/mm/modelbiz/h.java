package com.tencent.mm.modelbiz;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends i<f> {
    public static final String[] gUx = new String[]{i.a(f.gTP, "BizKF")};
    public e gUz;

    public final /* synthetic */ boolean a(c cVar) {
        return b((f) cVar);
    }

    public h(e eVar) {
        super(eVar, f.gTP, "BizKF", null);
        this.gUz = eVar;
        eVar.eE("BizKF", "CREATE INDEX IF NOT EXISTS BizKFAppIdUsernameIndex ON BizKF ( brandUsername )");
        eVar.eE("BizKF", "CREATE INDEX IF NOT EXISTS BizKFOpenIdIndex ON BizKF ( openId )");
    }

    public final f ig(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gUz.a("BizKF", null, "openId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            f fVar = new f();
            fVar.b(a);
            a.close();
            return fVar;
        }
        w.w("MicroMsg.BizKFStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public static boolean a(f fVar) {
        if (fVar == null || System.currentTimeMillis() - fVar.field_updateTime < 86400000) {
            return false;
        }
        return true;
    }

    private boolean b(f fVar) {
        if (fVar == null || bg.mA(fVar.field_openId) || bg.mA(fVar.field_brandUsername)) {
            w.w("MicroMsg.BizKFStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.gUz.replace("BizKF", f.gTP.uxc, fVar.pv()) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.BizKFStorage", "replace: openId=%s, brandUsername=%s, ret=%s ", fVar.field_openId, fVar.field_brandUsername, Boolean.valueOf(z));
        return z;
    }

    public final f ih(String str) {
        if (bg.mA(str)) {
            return null;
        }
        Cursor a = this.gUz.a("BizKF", null, "brandUsername = ? order by kfType desc ", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            f fVar = new f();
            fVar.b(a);
            a.close();
            return fVar;
        }
        w.w("MicroMsg.BizKFStorage", "get null with brandUsername:" + str);
        a.close();
        return null;
    }

    public final int d(LinkedList<f> linkedList) {
        if (linkedList.size() <= 0) {
            w.e("MicroMsg.BizKFStorage", "null kfs");
            return 0;
        }
        long cs;
        if (this.gUz instanceof g) {
            cs = ((g) this.gUz).cs(Thread.currentThread().getId());
        } else {
            cs = 0;
        }
        Iterator it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            f fVar = (f) it.next();
            if (fVar == null || !b(fVar)) {
                i2 = i;
            } else {
                i2 = i + 1;
            }
            i = i2;
        }
        if (this.gUz instanceof g) {
            com.tencent.mm.kernel.h.vI().gYg.aD(cs);
        }
        w.i("MicroMsg.BizKFStorage", "insertOrUpdateBizKFs %d", Integer.valueOf(i));
        return i;
    }
}
