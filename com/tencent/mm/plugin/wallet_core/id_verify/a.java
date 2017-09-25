package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rv;
import com.tencent.mm.e.a.sf;
import com.tencent.mm.plugin.wallet_core.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.model.c;
import com.tencent.mm.plugin.wallet_core.id_verify.model.h;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.y.k;

public class a extends b {
    public int aMA = 0;
    public boolean kgf = false;
    private int mMode;
    public String rCq = null;
    public String rCr = null;
    private boolean rCs = false;
    private int rCt = -1;

    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        boolean z;
        v("start", activity, bundle);
        if (this.lHw == null) {
            this.lHw = new Bundle();
        }
        if (bundle == null) {
            bundle = this.lHw;
        }
        if (bundle != null) {
            this.mMode = bundle.getInt("real_name_verify_mode", 0);
        } else {
            this.mMode = 0;
        }
        this.rCt = this.mMode;
        bundle.putBoolean("key_is_realname_verify_process", true);
        this.rCq = bundle.getString("realname_verify_process_jump_plugin", "");
        this.rCr = bundle.getString("realname_verify_process_jump_activity", "");
        if (bundle.getInt("realname_verify_process_allow_idverify", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.rCs = z;
        w.i("MicroMsg.RealNameVerifyProcess", "mAllowIdVerify is  mAllowIdVerify: %s,mPluginName %s, mActivityName %s ", new Object[]{Boolean.valueOf(this.rCs), this.rCq, this.rCr});
        switch (this.mMode) {
            case 0:
                n.CH(10);
                b(activity, SwitchRealnameVerifyModeUI.class, bundle);
                break;
            case 1:
                bundle.putBoolean("key_need_bind_response", true);
                n.CH(10);
                super.c(activity, bundle);
                break;
            case 2:
                b(activity, WalletRealNameVerifyUI.class, bundle);
                break;
        }
        return this;
    }

    public final void c(Activity activity, int i) {
        v("back", activity, Integer.valueOf(i));
        n.ccf();
        if (activity instanceof SwitchRealnameVerifyModeUI) {
            if (i == 0) {
                d(activity, this.lHw);
            }
        } else if ((activity instanceof WalletRealNameVerifyUI) || (activity instanceof WalletBankcardIdUI)) {
            if (this.rCt != 0) {
                d(activity, this.lHw);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            d(activity, this.lHw);
        }
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        v("forward", activity, "actionCode:" + i, bundle);
        int i2 = this.lHw.getInt("real_name_verify_mode", this.mMode);
        if (this.mMode != i2) {
            this.mMode = i2;
        }
        if (this.mMode == 2) {
            if (activity instanceof WalletRealNameVerifyUI) {
                b(activity, WalletSetPasswordUI.class, bundle);
            } else if (activity instanceof WalletSetPasswordUI) {
                b(activity, WalletPwdConfirmUI.class, bundle);
            } else if (!(activity instanceof WalletPwdConfirmUI) && (activity instanceof SwitchRealnameVerifyModeUI)) {
                b(activity, WalletRealNameVerifyUI.class, bundle);
                this.mMode = 2;
            }
        } else if (this.mMode == 1) {
            if (activity instanceof SwitchRealnameVerifyModeUI) {
                if (m.btS().bum()) {
                    b(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    b(activity, WalletBankcardIdUI.class, bundle);
                }
            } else if (activity instanceof WalletCheckPwdUI) {
                b(activity, WalletBankcardIdUI.class, bundle);
            } else {
                super.a(activity, i, bundle);
            }
        } else if (activity instanceof WalletRealNameVerifyUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
            this.mMode = 1;
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final void d(final Activity activity, Bundle bundle) {
        Bundle bundle2;
        v("end", activity, bundle);
        n.ccf();
        if (bundle == null) {
            bundle2 = this.lHw;
        } else {
            bundle2 = bundle;
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if (this.mMode == 1) {
            cbU();
            if (bundle2.getBoolean("intent_bind_end", false)) {
                this.aMA = -1;
            } else {
                this.aMA = 0;
            }
        } else if (bundle2.containsKey("realname_verify_process_ret")) {
            this.aMA = bundle2.getInt("realname_verify_process_ret", -1);
        } else {
            this.aMA = 0;
        }
        if (bundle2.containsKey("intent_bind_end")) {
            bundle2.remove("intent_bind_end");
        }
        if (bundle2.containsKey("key_is_bind_reg_process")) {
            bundle2.remove("key_is_bind_reg_process");
        }
        bundle2.putInt("realname_verify_process_ret", this.aMA);
        final Intent intent = new Intent();
        intent.putExtras(bundle2);
        if (this.aMA == -1) {
            Toast.makeText(activity, activity.getString(R.l.eIv), 0).show();
        }
        final com.tencent.mm.sdk.b.b rvVar = new rv();
        rvVar.nFq = new Runnable(this) {
            final /* synthetic */ a rCv;

            public final void run() {
                if (!this.rCv.kgf) {
                    rvVar.nFq = null;
                    this.rCv.kgf = true;
                    if (bg.mA(this.rCv.rCq) || bg.mA(this.rCv.rCr)) {
                        this.rCv.aj(activity);
                        if (this.rCv.aMA == -1) {
                            com.tencent.mm.sdk.b.b sfVar = new sf();
                            sfVar.fZL.result = this.rCv.aMA;
                            com.tencent.mm.sdk.b.a.urY.m(sfVar);
                            return;
                        }
                        return;
                    }
                    w.i("MicroMsg.RealNameVerifyProcess", "real name verify process end,jump to " + this.rCv.rCq + this.rCv.rCr);
                    final boolean z = this.rCv.lHw.getBoolean("process_finish_stay_orgpage", true);
                    af.f(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 rCx;

                        public final void run() {
                            intent.putExtra("key_process_is_end", true);
                            intent.putExtra("key_process_is_stay", z);
                            this.rCx.rCv.a(activity, this.rCx.rCv.rCq, this.rCx.rCv.rCr, this.rCx.rCv.aMA, intent, z);
                            if (this.rCx.rCv.aMA == -1) {
                                com.tencent.mm.sdk.b.b sfVar = new sf();
                                sfVar.fZL.result = this.rCx.rCv.aMA;
                                com.tencent.mm.sdk.b.a.urY.m(sfVar);
                            }
                        }
                    }, 500);
                }
            }
        };
        com.tencent.mm.sdk.b.a.urY.m(rvVar);
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (!(mMActivity instanceof WalletPwdConfirmUI)) {
            return mMActivity instanceof WalletRealNameVerifyUI ? new d(this, mMActivity, fVar) {
                final /* synthetic */ a rCv;

                public final CharSequence qK(int i) {
                    if (i != 0) {
                        return null;
                    }
                    String string = this.wEw.getString(R.l.fjm);
                    String string2 = this.wEw.getString(R.l.fjl);
                    string = this.wEw.getString(R.l.fjo, new Object[]{string, string2});
                    com.tencent.mm.plugin.wallet_core.ui.f fVar = new com.tencent.mm.plugin.wallet_core.ui.f(this.wEw);
                    SpannableString spannableString = new SpannableString(string);
                    spannableString.setSpan(fVar, string.length() - string2.length(), string.length(), 33);
                    return spannableString.subSequence(0, spannableString.length());
                }

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }
            } : super.a(mMActivity, fVar);
        } else {
            if (this.mMode == 2) {
                return new d(this, mMActivity, fVar) {
                    final /* synthetic */ a rCv;

                    public final boolean j(Object... objArr) {
                        com.tencent.mm.plugin.wallet_core.model.n nVar = (com.tencent.mm.plugin.wallet_core.model.n) objArr[0];
                        String string = this.rCv.lHw.getString("key_real_name_token");
                        if (nVar == null || bg.mA(nVar.rHx)) {
                            w.e("MicroMsg.RealNameVerifyProcess", "get pwd error");
                        } else if (bg.mA(string)) {
                            w.e("MicroMsg.RealNameVerifyProcess", "get token error");
                        } else {
                            this.wEx.a(new c(nVar.rHx, string, this.rCv.lHw.getInt("entry_scene", -1)), true);
                        }
                        return true;
                    }

                    public final boolean d(int i, int i2, String str, k kVar) {
                        if (kVar instanceof c) {
                            if (i == 0 && i2 == 0) {
                                this.rCv.lHw.putInt("realname_verify_process_ret", -1);
                                w.i("MicroMsg.RealNameVerifyProcess", "real name reg succ ,update user info");
                                m.btS().aue();
                                com.tencent.mm.sdk.b.a.urY.m(new rv(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass2 rCy;

                                    {
                                        this.rCy = r1;
                                    }

                                    public final void run() {
                                        w.i("MicroMsg.RealNameVerifyProcess", "update user info succ,end process");
                                    }
                                }));
                                this.rCv.a(this.wEx);
                                this.rCv.d(this.wEw, this.rCv.lHw);
                                return true;
                            }
                        } else if (kVar instanceof h) {
                            return true;
                        }
                        return false;
                    }
                };
            }
            return super.a(mMActivity, fVar);
        }
    }

    public final String avB() {
        return "realname_verify_process";
    }

    public final int b(MMActivity mMActivity, int i) {
        return R.l.fgj;
    }
}
