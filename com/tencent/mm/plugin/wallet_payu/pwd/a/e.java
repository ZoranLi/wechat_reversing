package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public abstract class e extends b {
    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        if (this.lHw.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, R.l.fhm, 0).show();
        } else {
            s.makeText(activity, R.l.ffB, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ e rSE;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof d)) {
                    return false;
                }
                w.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.rSE.lHw.putInt("key_errcode_payu", 0);
                a.c(this.wEw, this.rSE.lHw, 0);
                return true;
            }

            public final boolean j(Object... objArr) {
                n nVar = (n) objArr[0];
                this.wEx.a(new d(this.rSE.lHw.getString("payu_reference"), nVar.rHx), true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }
}
