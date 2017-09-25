package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxcredit.a.a;
import com.tencent.mm.plugin.wxcredit.a.g;
import com.tencent.mm.plugin.wxcredit.a.h;
import com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletCheckIdentityUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class e extends b {
    public final b c(Activity activity, Bundle bundle) {
        if (!m.btS().bul()) {
            if (m.btS().bum()) {
                b(activity, WalletCheckPwdUI.class, bundle);
            } else {
                b(activity, WalletWXCreditOpenUI.class, bundle);
            }
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            J(activity);
            b(activity, WalletWXCreditOpenUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenUI) {
            b(activity, WalletCheckIdentityUI.class, bundle);
        } else if (activity instanceof WalletCheckIdentityUI) {
            if (bundle.getBoolean("key_need_bind_deposit", true)) {
                b(activity, WalletBindDepositUI.class, bundle);
            } else {
                b(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletBindDepositUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            if (m.btS().bum()) {
                b(activity, WalletWXCreditOpenResultUI.class, bundle);
            } else {
                b(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletWXCreditOpenResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditOpenResultUI) {
            d(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        J(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e szq;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.b) {
                        com.tencent.mm.plugin.wxcredit.a.b bVar = (com.tencent.mm.plugin.wxcredit.a.b) kVar;
                        this.szq.lHw.putString("KEY_SESSION_KEY", bVar.token);
                        this.szq.lHw.putString("key_pre_name", bVar.name);
                        this.szq.lHw.putString("key_pre_indentity", bVar.szt);
                        this.szq.lHw.putBoolean("key_has_indentity_info", bVar.szu);
                    }
                    this.szq.a(this.wEw, 0, this.szq.lHw);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    int i = 0;
                    this.szq.lHw.putString("key_pwd1", (String) objArr[0]);
                    f fVar = this.wEx;
                    String str = (String) objArr[0];
                    if (objArr[1] != null) {
                        i = bg.PY((String) objArr[1]);
                    }
                    fVar.a(new com.tencent.mm.plugin.wxcredit.a.b(str, i, this.szq.lHw.getString("key_bank_type")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCheckIdentityUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e szq;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof a) {
                        a aVar = (a) kVar;
                        this.szq.lHw.putString("KEY_SESSION_KEY", aVar.token);
                        this.szq.lHw.putString("key_mobile", aVar.fOI);
                        this.szq.lHw.putBoolean("key_need_bind_deposit", aVar.fYU);
                        this.szq.lHw.putBoolean("key_is_bank_user", aVar.szs);
                    }
                    this.szq.a(this.wEw, 0, this.szq.lHw);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    String str = (String) objArr[0];
                    String str2 = (String) objArr[1];
                    this.szq.lHw.putString("key_name", str);
                    this.szq.lHw.putString("key_indentity", str2);
                    this.wEx.a(new a(str, str2, this.szq.lHw.getString("KEY_SESSION_KEY"), this.szq.lHw.getString("key_bank_type")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e szq;

                public final /* synthetic */ CharSequence qK(int i) {
                    if (this.szq.lHw.getBoolean("key_is_bank_user", false)) {
                        Bankcard bankcard = (Bankcard) this.szq.lHw.getParcelable("key_bankcard");
                        return this.wEw.getString(R.l.fkM, new Object[]{bankcard.field_bankName, bankcard.field_bankName, this.szq.lHw.getString("key_mobile")});
                    }
                    return this.wEw.getString(R.l.fkN, new Object[]{this.szq.lHw.getString("key_mobile")});
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof g) {
                        String str2 = ((g) kVar).fRu;
                        if (!bg.mA(str2)) {
                            this.szq.lHw.putString("key_bank_username", str2);
                        }
                        this.szq.a(this.wEw, 0, this.szq.lHw);
                        return true;
                    } else if (kVar instanceof h) {
                        this.szq.a(this.wEw, 0, this.szq.lHw);
                        return true;
                    } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.h) {
                        if (m.btS().bum()) {
                            this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.m(null), true, true);
                            return true;
                        }
                        this.szq.a(this.wEw, 0, this.szq.lHw);
                        return true;
                    } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.b.m)) {
                        return false;
                    } else {
                        this.wEx.a(new g(this.szq.lHw.getString("key_verify_code"), this.szq.lHw.getString("KEY_SESSION_KEY"), this.szq.lHw.getString("key_pwd1"), m.btS().buz(), this.szq.lHw.getString("key_bank_type")), true, true);
                        return true;
                    }
                }

                public final boolean j(Object... objArr) {
                    String str = (String) objArr[0];
                    this.szq.lHw.putString("key_verify_code", str);
                    n nVar;
                    if (m.btS().bum()) {
                        if (!this.szq.lHw.getBoolean("key_need_bind_deposit", true) || this.szq.lHw.getBoolean("key_is_bank_user")) {
                            this.wEx.a(new g(str, this.szq.lHw.getString("KEY_SESSION_KEY"), this.szq.lHw.getString("key_pwd1"), this.szq.lHw.getString("key_bind_serial"), this.szq.lHw.getString("key_bank_type")), true, true);
                        } else {
                            nVar = (n) objArr[1];
                            nVar.flag = "2";
                            this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.h(nVar), true, true);
                        }
                    } else if (this.szq.lHw.getBoolean("key_is_bank_user", false)) {
                        this.szq.lHw.putString("key_verify_code", str);
                        this.wEx.a(new h(str, this.szq.lHw.getString("KEY_SESSION_KEY"), this.szq.lHw.getString("key_pwd1"), this.szq.lHw.getString("key_bind_serial"), this.szq.lHw.getString("key_bank_type")), true, true);
                    } else {
                        nVar = (n) objArr[1];
                        nVar.flag = "1";
                        this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.h(nVar), true, true);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBindDepositUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e szq;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet_core.a.a.a)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet_core.a.a.a aVar = (com.tencent.mm.plugin.wallet_core.a.a.a) kVar;
                    new StringBuilder("reqKey  ").append(aVar.ryT);
                    this.szq.lHw.putString("kreq_token", aVar.token);
                    this.szq.a(this.wEw, 0, this.szq.lHw);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    c.bvt();
                    Authen authen = new Authen();
                    authen.rDG = (String) objArr[0];
                    authen.ofd = (String) objArr[1];
                    authen.rBT = (String) objArr[2];
                    this.szq.lHw.putString("key_bank_phone", (String) objArr[3]);
                    authen.fRW = m.btS().bum() ? 2 : 1;
                    authen.rDF = 1;
                    authen.oLz = (PayInfo) this.szq.lHw.getParcelable("key_pay_info");
                    authen.rDC = this.szq.lHw.getString("key_pwd1");
                    if (!this.szq.lHw.getBoolean("key_has_indentity_info", false)) {
                        authen.rDD = this.szq.lHw.getString("key_name");
                        authen.rDE = this.szq.lHw.getString("key_indentity");
                    }
                    this.szq.lHw.putString("key_mobile", com.tencent.mm.wallet_core.ui.e.UK(authen.rBT));
                    this.szq.lHw.putBoolean("key_is_oversea", false);
                    this.wEx.a(new com.tencent.mm.plugin.wallet_core.a.a.a(authen), true, true);
                    return true;
                }

                public final boolean p(Object... objArr) {
                    this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.k("", (String) objArr[0], (PayInfo) this.szq.lHw.getParcelable("key_pay_info")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ e szq;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet_core.a.a.b) {
                        this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.m(null), true, true);
                        return true;
                    } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) {
                        this.wEx.a(new g(this.szq.lHw.getString("key_verify_code"), this.szq.lHw.getString("KEY_SESSION_KEY"), this.szq.lHw.getString("key_pwd1"), m.btS().buz(), this.szq.lHw.getString("key_bank_type")), true, true);
                        return true;
                    } else if (!(kVar instanceof g)) {
                        return false;
                    } else {
                        String str2 = ((g) kVar).fRu;
                        if (!bg.mA(str2)) {
                            this.szq.lHw.putString("key_bank_username", str2);
                        }
                        this.szq.a(this.wEw, 0, this.szq.lHw);
                        return true;
                    }
                }

                public final boolean j(Object... objArr) {
                    if (this.szq.lHw.getBoolean("key_is_bank_user", false)) {
                        this.wEx.a(new g(this.szq.lHw.getString("key_verify_code"), this.szq.lHw.getString("KEY_SESSION_KEY"), this.szq.lHw.getString("key_pwd1"), m.btS().buz(), this.szq.lHw.getString("key_bank_type")), true, true);
                    } else {
                        this.wEx.a(new com.tencent.mm.plugin.wallet_core.a.a.b((n) objArr[0]), true, true);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletWXCreditOpenResultUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ e szq;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.szq.a(this.wEw, 0, this.szq.lHw);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.szq.lHw.putBoolean("key_is_follow_bank_username", ((Boolean) objArr[0]).booleanValue());
                this.szq.cbU();
                this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.m(null), true, true);
                return true;
            }
        } : null;
    }

    public final String avB() {
        return "WXCreditOpenProcess";
    }
}
