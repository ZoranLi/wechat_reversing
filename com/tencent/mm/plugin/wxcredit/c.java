package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class c extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditCheckPwdProcess");
        b(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            e.m(activity, bundle.getString("key_url"), false);
        } else {
            d(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        J(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ c szo;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.szo.a(this.wEw, 0, this.szo.lHw);
                this.wEw.finish();
                return true;
            }

            public final boolean j(Object... objArr) {
                this.szo.lHw.putString("key_pwd1", (String) objArr[0]);
                this.wEx.a(new i((String) objArr[0], 5, ""), true, true);
                return true;
            }

            public final boolean o(Object... objArr) {
                return false;
            }
        } : super.a(mMActivity, fVar);
    }

    public final String avB() {
        return "WXCreditCheckPwdProcess";
    }
}
