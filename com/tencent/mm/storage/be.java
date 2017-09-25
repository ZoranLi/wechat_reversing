package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class be extends i<bd> {
    public static final String[] gUx = new String[]{i.a(bd.gTP, "UserOpenIdInApp")};
    public e gUz;

    public be(e eVar) {
        super(eVar, bd.gTP, "UserOpenIdInApp", null);
        this.gUz = eVar;
        eVar.eE("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
        eVar.eE("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    }

    public final bd RZ(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Cursor a = this.gUz.a("UserOpenIdInApp", null, "openId=?", new String[]{bg.my(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            bd bdVar = new bd();
            bdVar.b(a);
            a.close();
            return bdVar;
        }
        w.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:" + str);
        a.close();
        return null;
    }

    public final boolean a(bd bdVar) {
        if (bdVar == null || bg.mA(bdVar.field_appId) || bg.mA(bdVar.field_openId) || bg.mA(bdVar.field_username)) {
            w.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
            return false;
        }
        boolean z;
        if (this.gUz.replace("UserOpenIdInApp", bd.gTP.uxc, bdVar.pv()) > 0) {
            z = true;
        } else {
            z = false;
        }
        w.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", bdVar.field_appId, bdVar.field_username, Boolean.valueOf(z));
        return z;
    }
}
