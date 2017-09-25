package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pwd.a.c;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class a extends com.tencent.mm.plugin.wallet_core.a.a {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.lHw;
        String str = "key_is_oversea";
        o.bsC();
        bundle2.putBoolean(str, !o.bsD().bur());
        bundle2 = this.lHw;
        str = "key_support_bankcard";
        o.bsC();
        bundle2.putInt(str, o.bsD().bur() ? 1 : 2);
        this.lHw.putBoolean("key_is_forgot_process", true);
        b(activity, WalletForgotPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletForgotPwdUI) {
            if (bundle.containsKey("key_is_force_bind") && bundle.getBoolean("key_is_force_bind")) {
                b(activity, WalletForgotPwdBindNewUI.class, bundle);
            } else {
                b(activity, WalletCardElementUI.class, bundle);
            }
        } else if (activity instanceof WalletCardElementUI) {
            if (cbQ()) {
                b(activity, WalletSetPasswordUI.class, bundle);
            } else {
                b(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletVerifyCodeUI) {
            b(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            d(activity, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            v("startActivity2", activity, WalletCardElementUI.class, bundle, new StringBuilder("flag: 67108864").toString());
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            activity.startActivity(intent);
            if (bundle != null) {
                this.lHw.putAll(bundle);
            }
            w.d("MicroMsg.ProcessManager", "bankcard tag :" + cbP());
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        a(activity, WalletForgotPwdUI.class, -1, false);
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletForgotPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ a rAA;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0 && (kVar instanceof m)) {
                        w.i("MicroMsg.ProcessManager", "hy: reset_pwd_flag: %s, find_pwd_url: %s", new Object[]{com.tencent.mm.plugin.wallet_core.model.m.btO().buL().field_reset_passwd_flag, com.tencent.mm.plugin.wallet_core.model.m.btO().buL().field_find_passwd_url});
                        if ((com.tencent.mm.plugin.wallet_core.model.m.btS().buw() == null ? 0 : com.tencent.mm.plugin.wallet_core.model.m.btS().buw().size()) <= 0 && !bg.mA(r2.field_find_passwd_url)) {
                            w.i("MicroMsg.ProcessManager", "hy: no bankcard and do not support add bank card to forget");
                            Context context = this.wEw;
                            g.a(context, true, context.getString(R.l.fhC), "", context.getString(R.l.dHT), context.getString(R.l.dGs), new com.tencent.mm.plugin.wallet.pwd.a.g.AnonymousClass1(context), new com.tencent.mm.plugin.wallet.pwd.a.g.AnonymousClass2(true, context));
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ a rAA;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d)) {
                        return false;
                    }
                    this.rAA.lHw.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pwd.a.d) kVar).token);
                    this.rAA.a(this.wEw, 0, this.rAA.lHw);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    if (this.rAA.cbQ()) {
                        authen.fRW = 4;
                    } else {
                        authen.fRW = 1;
                    }
                    this.wEx.a(new com.tencent.mm.plugin.wallet.pwd.a.d(authen, this.rAA.lHw.getBoolean("key_is_reset_with_new_card", false)), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ a rAA;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.d)) {
                        return false;
                    }
                    this.rAA.lHw.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pwd.a.d) kVar).token);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    n nVar = (n) objArr[1];
                    nVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                    this.wEx.a(new com.tencent.mm.plugin.wallet.pwd.a.f(nVar), true, true);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ a rAA;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof c)) {
                    return false;
                }
                this.rAA.a(this.wEw, 0, this.rAA.lHw);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.wEx.a(new c((n) objArr[0]), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                g.a(walletBaseUI, str, null, walletBaseUI.getString(R.l.ffP), false, new OnClickListener(this) {
                    final /* synthetic */ a rAA;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rAA.d(walletBaseUI, this.rAA.lHw);
                        if (walletBaseUI.aIY()) {
                            walletBaseUI.finish();
                        }
                        WalletBaseUI.ccC();
                    }
                });
                return true;
            default:
                return false;
        }
    }

    public final int b(MMActivity mMActivity, int i) {
        return R.l.ffP;
    }

    public final String avB() {
        return "ForgotPwdProcess";
    }
}
