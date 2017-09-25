package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.e.a.kc;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.plugin.wallet_core.b.h;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public class d extends b {
    public final void d(Activity activity, Bundle bundle) {
        a.urY.m(new kc());
        c(activity, WalletOfflineEntranceUI.class);
        if (activity != null) {
            activity.finish();
        }
    }

    public final void c(Activity activity, int i) {
        super.c(activity, i);
    }

    public final com.tencent.mm.wallet_core.d.d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new com.tencent.mm.wallet_core.d.d(this, mMActivity, fVar) {
                final /* synthetic */ d obp;

                public final boolean j(Object... objArr) {
                    n nVar = (n) objArr[1];
                    nVar.flag = "1";
                    this.wEx.a(new h(nVar), true, true);
                    return true;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof m) {
                            if (!(((WalletBaseUI) this.wEw).uT == null || ((WalletBaseUI) this.wEw).uT.getInt("key_bind_scene", -1) != 5 || com.tencent.mm.plugin.offline.c.a.aQL())) {
                                d.d(this.wEw);
                                return true;
                            }
                        } else if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                            com.tencent.mm.wallet_core.a.k(this.wEw, ((WalletBaseUI) this.wEw).uT);
                            com.tencent.mm.plugin.offline.c.a.M(this.wEw);
                            return true;
                        }
                    }
                    return false;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new com.tencent.mm.wallet_core.d.d(this, mMActivity, fVar) {
            final /* synthetic */ d obp;

            public final boolean j(Object... objArr) {
                this.wEx.a(new com.tencent.mm.plugin.wallet_core.a.a.b((n) objArr[0]), true, true);
                return true;
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof m) {
                        if (!(((WalletBaseUI) this.wEw).uT == null || ((WalletBaseUI) this.wEw).uT.getInt("key_bind_scene", -1) != 5 || com.tencent.mm.plugin.offline.c.a.aQL())) {
                            d.d(this.wEw);
                        }
                        return true;
                    } else if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                        Bundle bundle = ((WalletBaseUI) this.wEw).uT;
                        bundle.putBoolean("intent_bind_end", true);
                        com.tencent.mm.wallet_core.a.k(this.wEw, bundle);
                        com.tencent.mm.plugin.offline.c.a.M(this.wEw);
                        return true;
                    }
                }
                return false;
            }
        } : super.a(mMActivity, fVar);
    }

    public static void d(MMActivity mMActivity) {
        String string = ((WalletBaseUI) mMActivity).uT.getString("key_pwd1");
        int i = ((WalletBaseUI) mMActivity).uT.getInt("offline_add_fee", 0);
        Bankcard aQO = com.tencent.mm.plugin.offline.c.a.aQO();
        if (aQO != null) {
            ((WalletBaseUI) mMActivity).q(new com.tencent.mm.plugin.offline.a.k(aQO, string, i));
        }
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return super.e(activity, bundle);
    }

    public final String avB() {
        return "OfflineBindCardRegProcess";
    }
}
