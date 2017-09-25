package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class g extends e {
    public final b c(Activity activity, Bundle bundle) {
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new a(this, mMActivity, fVar, this.lHw) {
                final /* synthetic */ g rSF;

                public final CharSequence qK(int i) {
                    if (i == 0) {
                        return this.wEw.getString(R.l.feZ);
                    }
                    return super.qK(i);
                }
            };
        }
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ g rSF;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof b)) {
                    return false;
                }
                w.d("MicroMsg.PayUModifyPasswordProcess", "hy: change pwd user success");
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.rSF.lHw.putInt("key_errcode_payu", 0);
                a.c(this.wEw, this.rSF.lHw, 0);
                return true;
            }

            public final boolean j(Object... objArr) {
                n nVar = (n) objArr[0];
                this.wEx.a(new b(this.rSF.lHw.getString("key_pwd1"), nVar.rHx), true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final String avB() {
        return "PayUModifyPasswordProcess";
    }
}
