package com.tencent.mm.v;

import android.os.Bundle;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class a implements com.tencent.mm.ui.account.h.a, e {
    public void m(Bundle bundle) {
        String string = bundle.getString("access_token");
        String string2 = bundle.getString("expires");
        w.i("MicroMsg.RefreshTokenListener", "onComplete : newToken = " + string + ", expires = " + string2);
        if (string2 != null) {
            ap.yY();
            c.vr().set(65832, string2);
        }
        ap.yY();
        c.vr().set(65830, string);
        ap.yY();
        c.vr().set(65831, Long.valueOf(System.currentTimeMillis()));
        ap.vd().a(183, (e) this);
        ap.vd().a(new g(2, string), 0);
    }

    public void onError(int i, String str) {
        w.e("MicroMsg.RefreshTokenListener", "onError : errType = " + i + ", errMsg = " + str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 183) {
            ap.vd().b(183, (e) this);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.RefreshTokenListener", "update token success");
            } else {
                w.e("MicroMsg.RefreshTokenListener", "update token fail");
            }
        }
    }
}
