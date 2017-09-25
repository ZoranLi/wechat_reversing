package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public class a extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            f(activity, bundle);
        } else {
            b(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public void f(Activity activity, Bundle bundle) {
        b(activity, WalletBankcardDetailUI.class, bundle);
    }

    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            b(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            d(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        J(activity);
    }

    public void d(Activity activity, Bundle bundle) {
        if (this.lHw.getInt("scene", -1) == 1) {
            Activity activity2 = activity;
            a(activity2, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", bundle.getInt("key_process_result_code", 0), false);
            return;
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            private String fJH = null;
            final /* synthetic */ a rwl;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (kVar instanceof com.tencent.mm.plugin.wallet.bind.a.d) {
                    if (i == 0 && i2 == 0) {
                        this.rwl.lHw.putInt("key_process_result_code", -1);
                        if (this.rwl.e(this.wEw, null)) {
                            this.wEx.a(new m(this.fJH), true, true);
                        } else {
                            this.rwl.a(this.wEw, 0, null);
                            if (this.wEw instanceof WalletBaseUI) {
                                ((WalletBaseUI) this.wEw).qU(0);
                            }
                            this.wEw.finish();
                        }
                        return true;
                    }
                    this.rwl.lHw.putInt("key_process_result_code", 1);
                }
                return false;
            }

            public final boolean o(Object... objArr) {
                Bankcard bankcard = (Bankcard) this.rwl.lHw.getParcelable("key_bankcard");
                if (bankcard == null || bankcard.field_bankcardState != 1) {
                    this.rwl.lHw.putInt("key_process_result_code", 1);
                    return super.o(objArr);
                }
                this.wEx.a(new com.tencent.mm.plugin.wallet.bind.a.d(bankcard.field_bankcardType, bankcard.field_bindSerial), true, true);
                this.rwl.lHw.putBoolean("key_is_expired_bankcard", true);
                return true;
            }

            public final boolean j(Object... objArr) {
                Bankcard bankcard = (Bankcard) this.rwl.lHw.getParcelable("key_bankcard");
                String str = (String) objArr[0];
                this.fJH = (String) objArr[1];
                if (bankcard != null) {
                    this.wEx.a(new com.tencent.mm.plugin.wallet.bind.a.d(bankcard.field_bankcardType, bankcard.field_bindSerial, str), true, true);
                    return true;
                }
                this.rwl.lHw.putInt("key_process_result_code", 1);
                return false;
            }

            public final CharSequence qK(int i) {
                switch (i) {
                    case 1:
                        return this.wEw.getString(R.l.fgc);
                    default:
                        return super.qK(i);
                }
            }
        } : super.a(mMActivity, fVar);
    }

    public boolean e(Activity activity, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            return true;
        }
        return false;
    }

    public final String avB() {
        return "UnbindProcess";
    }
}
