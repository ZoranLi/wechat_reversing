package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.pwd.a.e;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public class c extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
        b(activity, WalletSetPasswordUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            d(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, WalletResetPwdAdapterUI.class);
        intent.putExtra("RESET_PWD_USER_ACTION", bundle.getInt("RESET_PWD_USER_ACTION", 0));
        a(activity, WalletResetPwdAdapterUI.class, -1, intent, false);
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c rAD;

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.wEx.a(new i((String) objArr[0], 3, (String) objArr[1]), true, true);
                    return true;
                }

                public final CharSequence qK(int i) {
                    switch (i) {
                        case 0:
                            return this.wEw.getString(R.l.feY);
                        case 1:
                            return this.wEw.getString(R.l.fhW);
                        default:
                            return super.qK(i);
                    }
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ c rAD;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (!(kVar instanceof e)) {
                        return true;
                    }
                    this.rAD.lHw.putInt("RESET_PWD_USER_ACTION", 1);
                    this.rAD.a(this.wEw, 0, this.rAD.lHw);
                    g.bl(this.wEw, this.wEw.getString(R.l.fhR));
                    return true;
                } else if (!(kVar instanceof e)) {
                    return false;
                } else {
                    g.a(this.wEw, str, "", false, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass2 rAE;

                        {
                            this.rAE = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rAE.rAD.lHw.putInt("RESET_PWD_USER_ACTION", 2);
                            this.rAE.rAD.a(this.rAE.wEw, 0, this.rAE.rAD.lHw);
                        }
                    });
                    return true;
                }
            }

            public final boolean j(Object... objArr) {
                n nVar = (n) objArr[0];
                this.rAD.lHw.getString("key_pwd1");
                this.wEx.a(new e(nVar.rHx, nVar.token), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(final WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                g.a(walletBaseUI, str, null, walletBaseUI.getString(R.l.fkj), false, new OnClickListener(this) {
                    final /* synthetic */ c rAD;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.rAD.d(walletBaseUI, this.rAD.lHw);
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
        return R.l.fkj;
    }

    public final String avB() {
        return "ResetPwdProcessByToken";
    }
}
