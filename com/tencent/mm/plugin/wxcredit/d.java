package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditDetailUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditErrDetailUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class d extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.WXCreditManagerProcess", "start Process : WXCreditManagerProcess");
        b(activity, WalletWXCreditDetailUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (i == 1) {
            b(activity, WalletWXCreditErrDetailUI.class, bundle);
            activity.finish();
        } else if (activity instanceof WalletWXCreditDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            d(activity, bundle);
        } else if (activity instanceof WalletWXCreditErrDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
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

    public final com.tencent.mm.wallet_core.d.d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletWXCreditDetailUI) {
            return new com.tencent.mm.wallet_core.d.d(this, mMActivity, fVar) {
                final /* synthetic */ d szp;

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final boolean o(Object... objArr) {
                    Bankcard bankcard = (Bankcard) objArr[0];
                    this.wEx.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, true);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletCheckPwdUI ? new com.tencent.mm.wallet_core.d.d(this, mMActivity, fVar) {
            final /* synthetic */ d szp;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.f) {
                    this.wEx.a(new m(null), true);
                    return true;
                } else if (!(kVar instanceof m)) {
                    return true;
                } else {
                    this.szp.d(this.wEw, this.szp.lHw);
                    return true;
                }
            }

            public final boolean j(Object... objArr) {
                Bankcard bankcard = (Bankcard) this.szp.lHw.getParcelable("key_bankcard");
                this.wEx.a(new com.tencent.mm.plugin.wxcredit.a.f(bankcard.field_bankcardType, bankcard.field_bindSerial, (String) objArr[0]), true, true);
                return true;
            }

            public final boolean o(Object... objArr) {
                Bankcard bankcard = (Bankcard) objArr[0];
                this.wEx.a(new com.tencent.mm.plugin.wxcredit.a.d(bankcard.field_bindSerial, bankcard.field_bankcardType), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final String avB() {
        return "WXCreditManagerProcess";
    }
}
