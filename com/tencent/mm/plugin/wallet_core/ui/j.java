package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.b.p;
import com.tencent.mm.plugin.wallet_core.model.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class j extends b {
    public String lOq;
    public String rBU;
    private int scene;
    public String token;

    public final b c(Activity activity, Bundle bundle) {
        w.i("MicroMsg.WalletJSApiVerifyCodeProcess", "start WalletJSApiVerifyCodeProcess");
        this.rBU = bundle.getString("key_relation_key");
        this.lOq = bundle.getString("key_pwd1");
        this.token = bundle.getString("key_jsapi_token");
        this.scene = bundle.getInt("key_verify_scene");
        b(activity, WalletVerifyCodeUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void c(Activity activity, int i) {
    }

    public final void d(Activity activity, Bundle bundle) {
        w.i("MicroMsg.WalletJSApiVerifyCodeProcess", "end WalletJSApiVerifyCodeProcess");
        if (this.scene == 8) {
            a(activity, "wallet", ".pay.ui.WalletLoanRepaymentUI", -1, null, false);
            return;
        }
        a(activity, WalletCheckPwdUI.class, -1, null, false);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String avB() {
        return null;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        final f fVar2 = fVar;
        final MMActivity mMActivity2 = mMActivity;
        return new d(this, mMActivity, fVar) {
            final /* synthetic */ j rLo;

            public final boolean j(Object... objArr) {
                if (objArr.length == 2) {
                    n nVar = (n) objArr[1];
                    nVar.token = this.rLo.token;
                    w.i("MicroMsg.WalletJSApiVerifyCodeProcess", "do NetSceneTenpayVerifySmsByPasswd");
                    fVar2.a(new p(nVar, this.rLo.rBU), true, true);
                    return true;
                }
                w.e("MicroMsg.WalletJSApiVerifyCodeProcess", "arguments is error");
                return false;
            }

            public final boolean p(Object... objArr) {
                w.i("MicroMsg.WalletJSApiVerifyCodeProcess", "resend sms");
                fVar2.a(new com.tencent.mm.plugin.wallet_core.b.j(this.rLo.lOq, this.rLo.token, (byte) 0), true, true);
                return true;
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0) {
                    if (kVar instanceof p) {
                        w.e("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms fail,errType=" + i + ",errCode=" + i2 + ",errMsg=" + str);
                    }
                    return false;
                } else if (kVar instanceof p) {
                    w.i("MicroMsg.WalletJSApiVerifyCodeProcess", "send sms succ");
                    p pVar = (p) kVar;
                    Bundle bundle = this.rLo.lHw;
                    bundle.putString("key_jsapi_token", pVar.rCe);
                    this.rLo.d(mMActivity2, bundle);
                    return true;
                } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.j) {
                    return true;
                } else {
                    return false;
                }
            }

            public final CharSequence qK(int i) {
                return String.format(mMActivity2.getResources().getString(R.l.fkJ), new Object[]{this.rLo.lHw.getString("key_mobile")});
            }
        };
    }
}
