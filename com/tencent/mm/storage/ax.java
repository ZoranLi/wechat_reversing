package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class ax extends i<aw> {
    public static final String[] gUx = new String[]{i.a(aw.gTP, "OpenMsgListener")};
    public e gUz;

    public final /* synthetic */ boolean a(c cVar) {
        aw awVar = (aw) cVar;
        if (awVar == null || bg.mA(awVar.field_appId)) {
            w.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
            return false;
        }
        w.d("MicroMsg.OpenMsgListenerStorage", "replace: id=%s, ret=%s ", awVar.field_appId, Boolean.valueOf(this.gUz.replace("OpenMsgListener", aw.gTP.uxc, awVar.pv()) > 0));
        return this.gUz.replace("OpenMsgListener", aw.gTP.uxc, awVar.pv()) > 0;
    }

    public ax(e eVar) {
        super(eVar, aw.gTP, "OpenMsgListener", null);
        this.gUz = eVar;
        eVar.eE("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerAppIdIndex ON OpenMsgListener ( appId )");
        eVar.eE("OpenMsgListener", "CREATE INDEX IF NOT EXISTS openMsgListenerStatusIndex ON OpenMsgListener ( status )");
    }

    public final aw RP(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gUz.a("OpenMsgListener", null, "appId=?", new String[]{bg.my(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            aw awVar = new aw();
            awVar.b(a);
            a.close();
            return awVar;
        }
        w.w("MicroMsg.OpenMsgListenerStorage", "get null with appId:" + str);
        a.close();
        return null;
    }

    public final Cursor bMO() {
        return rawQuery("select * from OpenMsgListener where (status = ?) ", "1");
    }
}
