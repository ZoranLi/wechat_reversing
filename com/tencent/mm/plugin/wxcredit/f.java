package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.y.k;

public class f extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            a(activity, "wallet", ".bind.ui.WalletBankcardDetailUI", bundle);
        } else {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity.getClass().getSimpleName().equalsIgnoreCase("WalletBankcardDetailUI")) {
            b(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            d(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        J(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final d a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ f szr;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wxcredit.a.f)) {
                    return false;
                }
                this.szr.a(this.wEw, 0, this.szr.lHw);
                return true;
            }

            public final boolean j(Object... objArr) {
                if (this.szr.lHw.getBoolean("key_is_show_detail", true)) {
                    return false;
                }
                Bankcard bankcard = (Bankcard) this.szr.lHw.getParcelable("key_bankcard");
                this.wEx.a(new com.tencent.mm.plugin.wxcredit.a.f(bankcard.field_bankcardType, bankcard.field_bindSerial, this.szr.lHw.getString("key_pwd1")), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String avB() {
        return "WXCreditUnbindProcess";
    }
}
