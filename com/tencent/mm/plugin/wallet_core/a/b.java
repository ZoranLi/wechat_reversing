package com.tencent.mm.plugin.wallet_core.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.a.a.a;
import com.tencent.mm.plugin.wallet_core.b.h;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class b extends a {
    public com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        v("start", activity, bundle);
        w.d("MicroMsg.BindCardProcess", "start Process : BindCardProcess");
        if (bundle != null) {
            o.ev(6, bundle.getInt("key_bind_scene"));
            n.CH(bundle.getInt("key_bind_scene"));
        } else {
            o.ev(6, 0);
            n.CH(0);
        }
        if (m.btS().bum()) {
            b(activity, WalletCheckPwdUI.class, bundle);
            return this;
        }
        if (bundle != null) {
            c.du(bundle.getInt("key_bind_scene", 0), 1);
        }
        if (bundle == null || !bundle.getBoolean("key_is_import_bind", false)) {
            return super.c(activity, bundle);
        }
        b(activity, WalletCardImportUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        v("forward", activity, Integer.valueOf(i), bundle);
        w.i("MicroMsg.BindCardProcess", "forward Process : BindCardProcess");
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean("key_is_import_bind", false)) {
                b(activity, WalletCardImportUI.class, bundle);
            } else {
                b(activity, WalletBankcardIdUI.class, bundle);
            }
        } else if ((activity instanceof WalletCardElementUI) || (activity instanceof WalletCardImportUI)) {
            if (!cbQ()) {
                w.i("MicroMsg.BindCardProcess", "is domestic bankcard! need verify code!");
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else if (m.btS().bum()) {
                w.i("MicroMsg.BindCardProcess", "bind bank card success!!");
                bundle.putBoolean("intent_bind_end", true);
                g.bl(activity, activity.getString(R.l.fdO));
                d(activity, bundle);
            } else {
                w.i("MicroMsg.BindCardProcess", "wallet is not register, start WalletSetPasswordUI!");
                b(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if ((activity instanceof WalletVerifyCodeUI) && m.btS().bum()) {
            w.i("MicroMsg.BindCardProcess", "end process after verify!");
            d(activity, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            w.i("MicroMsg.BindCardProcess", "end process after confirm pwd!");
            c.du(this.lHw.getInt("key_bind_scene", 0), 7);
            bundle.putBoolean("intent_bind_end", true);
            g.bl(activity, activity.getString(R.l.fdO));
            d(activity, bundle);
        } else {
            w.i("MicroMsg.BindCardProcess", "super forward!");
            super.a(activity, 0, bundle);
        }
    }

    public d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rBL;

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final CharSequence qK(int i) {
                    switch (i) {
                        case 0:
                            return this.wEw.getString(R.l.ffb);
                        case 1:
                            return this.wEw.getString(R.l.ffR);
                        default:
                            return super.qK(i);
                    }
                }
            };
        }
        if ((mMActivity instanceof WalletCardElementUI) || (mMActivity instanceof WalletCardImportUI)) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rBL;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof a) {
                            this.rBL.lHw.putString("kreq_token", ((a) kVar).token);
                            if (this.rBL.e(this.wEw, this.rBL.lHw)) {
                                w.i("MicroMsg.BindCardProcess", "need update bankcardlist");
                                this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.m(null), false);
                                return true;
                            }
                            w.i("MicroMsg.BindCardProcess", "not need update bankcardlist");
                            this.rBL.a(this.wEw, 0, this.rBL.lHw);
                            return true;
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.m) {
                            w.i("MicroMsg.BindCardProcess", "update bankcardlist success!");
                            this.rBL.a(this.wEw, 0, this.rBL.lHw);
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    int i = 2;
                    this.rBL.v("onNext", objArr);
                    w.i("MicroMsg.BindCardProcess", "onNext, do bind bank card!");
                    Authen authen = (Authen) objArr[0];
                    if (this.rBL.cbQ()) {
                        i = m.btS().bum() ? 5 : 4;
                    } else if (!m.btS().bum()) {
                        i = 1;
                    }
                    authen.fRW = i;
                    this.wEx.a(new a(authen), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rBL;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof a) {
                            w.i("MicroMsg.BindCardProcess", "verify code success!");
                            this.rBL.lHw.putString("kreq_token", ((a) kVar).token);
                            return true;
                        } else if (kVar instanceof h) {
                            this.rBL.a(this.wEx);
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h) {
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.rBL.v("WalletVerifyCodeUI onNext", objArr);
                    w.i("MicroMsg.BindCardProcess", "onNext, do bind verify!");
                    com.tencent.mm.plugin.wallet_core.model.n nVar = (com.tencent.mm.plugin.wallet_core.model.n) objArr[1];
                    if (m.btS().bum()) {
                        nVar.flag = "2";
                    } else {
                        nVar.flag = "1";
                    }
                    if ("realname_verify_process".equals(this.rBL.avB())) {
                        this.wEx.a(new h(nVar, this.rBL.lHw.getInt("entry_scene", -1)), true, true);
                    } else {
                        this.wEx.a(new h(nVar), true, true);
                    }
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ b rBL;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (kVar instanceof com.tencent.mm.plugin.wallet_core.a.a.b) {
                    this.rBL.a(this.wEx);
                } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.h) {
                    return true;
                }
                return false;
            }

            public final boolean j(Object... objArr) {
                com.tencent.mm.plugin.wallet_core.model.n nVar = (com.tencent.mm.plugin.wallet_core.model.n) objArr[0];
                this.rBL.lHw.getString("verify_card_flag", "0");
                if ("realname_verify_process".equals(this.rBL.avB())) {
                    this.wEx.a(new com.tencent.mm.plugin.wallet_core.a.a.b(nVar, this.rBL.lHw.getInt("entry_scene", -1)), true);
                } else {
                    this.wEx.a(new com.tencent.mm.plugin.wallet_core.a.a.b(nVar), true);
                }
                return false;
            }
        } : super.a(mMActivity, fVar);
    }

    public final void a(f fVar) {
        w.d("MicroMsg.BindCardProcess", "do set user exinfo");
        fVar.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.h(this.lHw.getString("key_country_code", ""), this.lHw.getString("key_province_code", ""), this.lHw.getString("key_city_code", ""), (Profession) this.lHw.getParcelable("key_profession")), false, true);
    }

    public void d(Activity activity, Bundle bundle) {
        v("end", activity, bundle);
        w.i("MicroMsg.BindCardProcess", "end Process : BindCardProcess");
        n.ccf();
        cbU();
        if (bundle == null || !bundle.getBoolean("key_need_bind_response", false)) {
            d(activity, "mall", ".ui.MallIndexUI");
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        a(activity, "wallet", ".bind.ui.WalletBindUI", -1, intent, false);
    }

    public boolean e(Activity activity, Bundle bundle) {
        if (!m.btS().bum()) {
            return activity instanceof WalletPwdConfirmUI;
        }
        if (((activity instanceof WalletCardElementUI) && cbQ()) || (activity instanceof WalletVerifyCodeUI)) {
            return true;
        }
        return false;
    }

    public String avB() {
        return "BindCardProcess";
    }
}
