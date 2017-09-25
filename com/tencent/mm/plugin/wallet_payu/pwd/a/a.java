package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class a extends d {
    private Bundle lHw;

    public a(MMActivity mMActivity, f fVar, Bundle bundle) {
        super(mMActivity, fVar);
        this.lHw = bundle;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof c) {
            c cVar = (c) kVar;
            if (bg.mA(cVar.token)) {
                w.w("MicroMsg.CommonCheckPwdController", "hy: check pwd failed");
            } else {
                w.d("MicroMsg.CommonCheckPwdController", "hy: check pwd pass");
                this.lHw.putString("payu_reference", cVar.token);
                com.tencent.mm.wallet_core.a.k(this.wEw, this.lHw);
            }
        }
        return false;
    }

    public final boolean j(Object... objArr) {
        this.lHw.putString("key_pwd1", (String) objArr[0]);
        this.wEx.a(new c(this.lHw.getString("key_pwd1")), true);
        return true;
    }
}
