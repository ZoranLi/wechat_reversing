package com.tencent.mm.plugin.wallet_payu.create.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUStartOpenUI;
import com.tencent.mm.plugin.wallet_payu.create.ui.WalletPayUVerifyCodeUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionSettingUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class c extends b {
    public final b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.PayUOpenProcess", "hy: start process PayUOpenProcess");
        o.bsC();
        String Fw = o.Fw();
        o.bsC();
        String bsE = o.bsE();
        if (bundle != null) {
            bundle.putString("key_mobile", Fw);
            bundle.putString("dial_code", bsE);
        }
        b(activity, WalletPayUStartOpenUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUStartOpenUI) {
            b(activity, WalletPayUVerifyCodeUI.class, bundle);
        }
        if (activity instanceof WalletPayUVerifyCodeUI) {
            if (bundle.getBoolean("key_is_has_mobile")) {
                b(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
            } else {
                b(activity, WalletPayUSecurityQuestionSettingUI.class, bundle);
            }
        }
        if (activity instanceof WalletPayUSecurityQuestionSettingUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
        if (activity instanceof WalletPayUSetPasswordUI) {
            b(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            b(activity, WalletPayUSetPasswordUI.class, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        } else {
            d(activity, this.lHw);
        }
    }

    public final boolean i(Activity activity, Bundle bundle) {
        bundle.putInt("key_open_error_code", 1);
        s.makeText(activity, activity.getString(R.l.fiT), 0).show();
        d(activity, bundle);
        return true;
    }

    public final void d(Activity activity, Bundle bundle) {
        if (bundle.getInt("key_open_error_code", -1) == 0) {
            w.i("MicroMsg.PayUOpenProcess", "hy: user open success");
            d(activity, "mall", ".ui.MallIndexUI");
            return;
        }
        w.i("MicroMsg.PayUOpenProcess", "hy: user interrupted the process. go to preference");
        super.aj(activity);
        e.fn(activity);
    }

    public final int b(MMActivity mMActivity, int i) {
        if (i == 1) {
            return R.l.fiR;
        }
        return super.b(mMActivity, i);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUStartOpenUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c rRp;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (kVar instanceof com.tencent.mm.plugin.wallet_payu.a.b) {
                        w.d("MicroMsg.PayUOpenProcess", "hy: scene gen otp, errCode %d, errType %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.plugin.wallet_payu.a.b bVar = (com.tencent.mm.plugin.wallet_payu.a.b) kVar;
                            this.rRp.lHw.putString("payu_reference", bVar.fOv);
                            w.d("MicroMsg.PayUOpenProcess", "hy: session: %s", new Object[]{bVar.fOv});
                            this.rRp.lHw.putBoolean("key_is_has_mobile", bVar.rRJ);
                            a.k(this.wEw, this.rRp.lHw);
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.wEx.a(new com.tencent.mm.plugin.wallet_payu.a.b(this.rRp.lHw.getString("dial_code"), this.rRp.lHw.getString("key_mobile")), true);
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletPayUVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c rRp;

                public final boolean p(Object... objArr) {
                    this.wEx.a(new com.tencent.mm.plugin.wallet_payu.a.b(this.rRp.lHw.getString("dial_code"), this.rRp.lHw.getString("key_mobile")), true, true);
                    return true;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (kVar instanceof com.tencent.mm.plugin.wallet_payu.a.a) {
                        com.tencent.mm.plugin.wallet_payu.a.a aVar = (com.tencent.mm.plugin.wallet_payu.a.a) kVar;
                        if (i == 0 && i2 == 0 && aVar.rRH) {
                            this.rRp.lHw.putString("payu_reference", aVar.rRI);
                            a.k(this.wEw, this.rRp.lHw);
                            return true;
                        }
                    } else if ((kVar instanceof com.tencent.mm.plugin.wallet_payu.a.b) && i == 0 && i2 == 0) {
                        this.rRp.lHw.putString("payu_reference", ((com.tencent.mm.plugin.wallet_payu.a.b) kVar).fOv);
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.wEx.a(new com.tencent.mm.plugin.wallet_payu.a.a((String) objArr[0], this.rRp.lHw.getString("payu_reference")), true);
                    return true;
                }

                public final CharSequence qK(int i) {
                    if (i != 0) {
                        return super.qK(i);
                    }
                    return this.wEw.getString(R.l.fkD, new Object[]{e.UK("+" + this.rRp.lHw.getString("dial_code") + this.rRp.lHw.getString("key_mobile"))});
                }
            };
        }
        if (mMActivity instanceof WalletPayUSecurityQuestionSettingUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c rRp;

                public final boolean o(Object... objArr) {
                    this.wEx.a(new com.tencent.mm.plugin.wallet_payu.security_question.model.d(), true);
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.security_question.model.d) || i != 0 || i2 != 0) {
                        return false;
                    }
                    this.rRp.lHw.putParcelableArrayList("key_security_question_list", ((com.tencent.mm.plugin.wallet_payu.security_question.model.d) kVar).rSZ);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletPayUPwdConfirmUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ c rRp;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if ((kVar instanceof a) && i == 0 && i2 == 0) {
                        w.d("MicroMsg.PayUOpenProcess", "hy: create user success");
                        a.c(this.wEw, this.rRp.lHw, 0);
                        this.rRp.lHw.putInt("key_open_error_code", 0);
                        s.makeText(this.wEw, this.wEw.getString(R.l.fiY), 0).show();
                        return true;
                    } else if (!(kVar instanceof b) || i != 0 || i2 != 0) {
                        return false;
                    } else {
                        w.d("MicroMsg.PayUOpenProcess", "hy: link user success");
                        a.c(this.wEw, this.rRp.lHw, 0);
                        this.rRp.lHw.putInt("key_open_error_code", 0);
                        s.makeText(this.wEw, this.wEw.getString(R.l.fiY), 0).show();
                        return true;
                    }
                }

                public final boolean j(Object... objArr) {
                    n nVar = (n) objArr[0];
                    String string = this.rRp.lHw.getString("dial_code");
                    String string2 = this.rRp.lHw.getString("key_mobile");
                    String str = nVar.rHx;
                    String string3 = this.rRp.lHw.getString("key_question_id");
                    String string4 = this.rRp.lHw.getString("key_question_answer");
                    String string5 = this.rRp.lHw.getString("payu_reference");
                    if (this.rRp.lHw.getBoolean("key_is_has_mobile")) {
                        this.wEx.a(new b(string, string2, str, string5), true);
                    } else {
                        this.wEx.a(new a(string, string2, str, string3, string4, string5), true);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            return new com.tencent.mm.plugin.wallet_payu.security_question.model.a(mMActivity, fVar, this.lHw);
        }
        return super.a(mMActivity, fVar);
    }

    public final String avB() {
        return "PayUOpenProcess";
    }
}
