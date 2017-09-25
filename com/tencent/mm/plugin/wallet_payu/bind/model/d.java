package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class d extends a {
    protected final void f(Activity activity, Bundle bundle) {
        b(activity, WalletPayUBankcardDetailUI.class, bundle);
    }

    public final void d(Activity activity, Bundle bundle) {
        if (this.lHw.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, R.l.fhm, 0).show();
        } else {
            s.makeText(activity, R.l.ffB, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletPayUCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletPayUCheckPwdUI) {
            d(activity, bundle);
        }
    }

    public final com.tencent.mm.wallet_core.d.d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletPayUCheckPwdUI ? new com.tencent.mm.wallet_core.d.d(this, mMActivity, fVar) {
            final /* synthetic */ d rQT;

            public final CharSequence qK(int i) {
                if (i == 0) {
                    return this.wEw.getString(R.l.ffe);
                }
                return super.qK(i);
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (kVar instanceof c) {
                    if (i2 == 0 && i == 0) {
                        c cVar = (c) kVar;
                        this.rQT.lHw.putString("payu_reference", cVar.token);
                        if (bg.mA(cVar.token)) {
                            w.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
                        } else {
                            w.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
                            Bankcard bankcard = (Bankcard) this.rQT.lHw.getParcelable("key_bankcard");
                            if (bankcard != null) {
                                this.wEx.a(new b(bankcard.field_bindSerial, this.rQT.lHw.getString("payu_reference")), true);
                            }
                        }
                    }
                } else if ((kVar instanceof b) && i == 0 && i2 == 0) {
                    this.rQT.lHw.putInt("key_errcode_payu", 0);
                    this.rQT.d(this.wEw, this.rQT.lHw);
                }
                return false;
            }

            public final boolean j(Object... objArr) {
                this.rQT.lHw.putString("key_pwd1", (String) objArr[0]);
                this.wEx.a(new c(this.rQT.lHw.getString("key_pwd1")), true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }
}
