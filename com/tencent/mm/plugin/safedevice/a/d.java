package com.tencent.mm.plugin.safedevice.a;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public final class d extends i<c> {
    public static final String[] gUx = new String[]{i.a(c.gTP, "SafeDeviceInfo")};
    g oUA = null;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        return super.b((c) cVar);
    }

    public d(e eVar) {
        super(eVar, c.gTP, "SafeDeviceInfo", null);
        if (eVar instanceof g) {
            this.oUA = (g) eVar;
        }
    }

    public final boolean a(c cVar) {
        return super.b(cVar);
    }

    public final List<c> aXM() {
        List<c> linkedList = new LinkedList();
        if (getCount() > 0) {
            Cursor Kk = super.Kk();
            while (Kk.moveToNext()) {
                c cVar = new c();
                cVar.b(Kk);
                linkedList.add(cVar);
            }
            Kk.close();
        }
        return linkedList;
    }
}
