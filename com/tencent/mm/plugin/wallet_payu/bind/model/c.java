package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.a;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class c extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        b(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, WalletPayUCardElementUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        J(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        if (this.lHw.getInt("key_errcode_payu", -1) == 0) {
            s.makeText(activity, R.l.fhm, 0).show();
            a(activity, WalletPayUBankcardManageUI.class, -1, false);
            return;
        }
        s.makeText(activity, R.l.ffB, 0).show();
        a(activity, WalletPayUBankcardManageUI.class, 0, false);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new a(this, mMActivity, fVar, this.lHw) {
                final /* synthetic */ c rQS;

                public final CharSequence qK(int i) {
                    if (i == 0) {
                        return this.wEw.getString(R.l.feX);
                    }
                    return super.qK(i);
                }
            };
        }
        return mMActivity instanceof WalletPayUCardElementUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ c rQS;

            public final boolean d(int i, int i2, String str, k kVar) {
                if ((kVar instanceof a) && i == 0 && i2 == 0) {
                    this.rQS.lHw.putInt("key_errcode_payu", 0);
                    this.rQS.d(this.wEw, this.rQS.lHw);
                }
                if (kVar instanceof NetScenePayUElementQuery) {
                    if (i == 0 && i2 == 0) {
                        PayUBankcardElement payUBankcardElement = ((NetScenePayUElementQuery) kVar).rQO;
                        if (bg.mA(payUBankcardElement.rQP)) {
                            payUBankcardElement.rQQ = ab.getContext().getString(R.l.fiP);
                        }
                        this.rQS.lHw.putParcelable("key_card_element", ((NetScenePayUElementQuery) kVar).rQO);
                    } else {
                        Parcelable payUBankcardElement2 = new PayUBankcardElement();
                        if (bg.mA(str)) {
                            str = "err card element";
                        }
                        payUBankcardElement2.rQQ = str;
                        this.rQS.lHw.putParcelable("key_card_element", payUBankcardElement2);
                    }
                }
                return false;
            }

            public final boolean j(Object... objArr) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.rQS.lHw.getParcelable("key_card_element");
                this.wEx.a(new a(payUBankcardElement.ofY, payUBankcardElement.rQQ, this.rQS.lHw.getString("key_bank_username"), this.rQS.lHw.getString("key_card_id"), this.rQS.lHw.getString("key_expire_data"), payUBankcardElement.cardType, this.rQS.lHw.getString("key_cvv"), this.rQS.lHw.getString("key_pwd1")), true);
                return false;
            }
        } : super.a(mMActivity, fVar);
    }

    public final String avB() {
        return "PayUBindProcess";
    }
}
