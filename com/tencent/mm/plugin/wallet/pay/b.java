package com.tencent.mm.plugin.wallet.pay;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet.bind.ui.WalletResetInfoUI;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.b.i;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;

public class b extends com.tencent.mm.plugin.wallet_core.a.a {

    private abstract class a extends c {
        final /* synthetic */ b ryE;

        public a(b bVar, WalletBaseUI walletBaseUI, f fVar) {
            this.ryE = bVar;
            super(walletBaseUI, fVar);
        }
    }

    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        PayInfo payInfo = (PayInfo) bundle.getParcelable("key_pay_info");
        bundle.putInt("key_pay_scene", payInfo.fRv);
        bundle.putInt("key_pay_channel", payInfo.fRr);
        if (!g(activity, bundle)) {
            int i = bundle.getInt("key_pay_flag", 0);
            if ((i == 2 || i == 1) && payInfo.fRv == 11) {
                n.CH(13);
            }
            w.i("MicroMsg.PayProcess", "start pay_flag : " + bundle.getInt("key_pay_flag", 0));
            switch (bundle.getInt("key_pay_flag", 0)) {
                case 1:
                    w.i("MicroMsg.PayProcess", "start Process : PayRegBindProcess");
                    b(activity, WalletBankcardIdUI.class, bundle);
                    break;
                case 2:
                    w.i("MicroMsg.PayProcess", "start Process : PayBindProcess");
                    b(activity, WalletCheckPwdUI.class, bundle);
                    break;
                case 3:
                    if (bundle.getBoolean("key_need_verify_sms", false) && !cbQ()) {
                        w.i("MicroMsg.PayProcess", "domestic and verify sms!");
                        b(activity, WalletVerifyCodeUI.class, bundle);
                        break;
                    }
                    w.i("MicroMsg.PayProcess", "jump to result ui!");
                    h(activity, bundle);
                    break;
                default:
                    break;
            }
        }
        w.w("MicroMsg.PayProcess", "hy: has err. return");
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (g(activity, bundle)) {
            w.i("MicroMsg.PayProcess", "deal with the err!");
            return;
        }
        int i2 = bundle.containsKey("key_pay_flag") ? bundle.getInt("key_pay_flag", 0) : this.lHw.getInt("key_pay_flag", 0);
        w.i("MicroMsg.PayProcess", "forward pay_flag : " + i2);
        switch (i2) {
            case 1:
                w.i("MicroMsg.PayProcess", "forwardUnreg()");
                if (activity instanceof WalletSetPasswordUI) {
                    b(activity, WalletPwdConfirmUI.class, bundle);
                    return;
                } else if (activity instanceof WalletPwdConfirmUI) {
                    h(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (cbQ()) {
                        w.i("MicroMsg.PayProcess", "oversea, set pwd");
                        b(activity, WalletSetPasswordUI.class, bundle);
                        return;
                    }
                    w.i("MicroMsg.PayProcess", "domestic, verify code");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 2:
                w.i("MicroMsg.PayProcess", "forwardBind()");
                if ((activity instanceof WalletCheckPwdUI) || (activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                    return;
                } else if (activity instanceof WalletVerifyCodeUI) {
                    h(activity, bundle);
                    return;
                } else if (activity instanceof WalletCardElementUI) {
                    if (cbQ()) {
                        w.i("MicroMsg.PayProcess", "oversea, jump to result ui!");
                        h(activity, bundle);
                        return;
                    }
                    w.i("MicroMsg.PayProcess", "domestic, verify code!");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            case 3:
                w.i("MicroMsg.PayProcess", "forwardBound()");
                if (activity instanceof WalletVerifyCodeUI) {
                    h(activity, bundle);
                    return;
                } else if ((activity instanceof WalletResetInfoUI) || (activity instanceof WalletChangeBankcardUI)) {
                    if ((!bundle.getBoolean("key_need_verify_sms", false) || cbQ()) && !bundle.getBoolean("key_is_changing_balance_phone_num")) {
                        w.i("MicroMsg.PayProcess", "jump to result ui!");
                        h(activity, bundle);
                        return;
                    }
                    w.i("MicroMsg.PayProcess", "need verify code after reset info or change bank card info!");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else if (activity instanceof WalletBalanceResultUI) {
                    a(activity, WalletBalanceManagerUI.class, -1, null, true);
                    return;
                } else if ((activity instanceof WalletSelectBankcardUI) || (activity instanceof WalletSwitchVerifyPhoneUI)) {
                    w.i("MicroMsg.PayProcess", "need verify code after select bank card!");
                    b(activity, WalletVerifyCodeUI.class, bundle);
                    return;
                } else {
                    super.a(activity, 0, bundle);
                    return;
                }
            default:
                return;
        }
    }

    public final void c(Activity activity, int i) {
        w.i("MicroMsg.PayProcess", "back pay_flag : " + this.lHw.getInt("key_pay_flag", 0));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
            return;
        }
        n.ccf();
        J(activity);
    }

    public final void d(Activity activity, Bundle bundle) {
        int i = -1;
        w.i("MicroMsg.PayProcess", "end pay_flag : " + this.lHw.getInt("key_pay_flag", 0));
        n.ccf();
        int i2 = this.lHw.getBoolean("intent_pay_end", false) ? -1 : 0;
        Intent intent = new Intent();
        if (bundle != null) {
            PayInfo payInfo = (PayInfo) this.lHw.getParcelable("key_pay_info");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("intent_pay_end_errcode", this.lHw.getInt("intent_pay_end_errcode"));
            bundle2.putString("intent_pay_app_url", this.lHw.getString("intent_pay_app_url"));
            bundle2.putBoolean("intent_pay_end", this.lHw.getBoolean("intent_pay_end"));
            bundle2.putString("intent_wap_pay_jump_url", this.lHw.getString("intent_wap_pay_jump_url"));
            bundle2.putParcelable("key_realname_guide_helper", this.lHw.getParcelable("key_realname_guide_helper"));
            if (payInfo != null) {
                bundle2.putInt("pay_channel", payInfo.fRr);
            }
            intent.putExtras(bundle2);
        }
        intent.putExtra("key_orders", this.lHw.getParcelable("key_orders"));
        com.tencent.mm.sdk.b.b rzVar = new rz();
        rzVar.fZv.context = activity;
        rzVar.fZv.intent = intent;
        rzVar.fZv.fJH = bsF();
        com.tencent.mm.e.a.rz.a aVar = rzVar.fZv;
        if (!this.lHw.getBoolean("intent_pay_end", false)) {
            i = 0;
        }
        aVar.result = i;
        com.tencent.mm.sdk.b.a.urY.m(rzVar);
        a(activity, "wallet", ".pay.ui.WalletPayUI", i2, intent, false);
    }

    private boolean g(Activity activity, Bundle bundle) {
        w.i("MicroMsg.PayProcess", "dealwithErr(), errCode %d", new Object[]{Integer.valueOf(bundle.getInt("key_err_code", 0))});
        switch (bundle.getInt("key_err_code", 0)) {
            case -1004:
                bundle.putInt("key_pay_flag", 3);
                bundle.putInt("key_err_code", 0);
                b(activity, WalletChangeBankcardUI.class, bundle);
                return true;
            case -1003:
                o.bsC();
                if (o.bsD().bum()) {
                    bundle.putInt("key_pay_flag", 2);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletCheckPwdUI.class, bundle);
                } else {
                    bundle.putInt("key_pay_flag", 1);
                    bundle.putInt("key_err_code", 0);
                    b(activity, WalletBankcardIdUI.class, bundle);
                }
                return true;
            case 402:
            case 403:
            case 408:
                Bankcard bankcard = (Bankcard) this.lHw.get("key_bankcard");
                if (bankcard == null || !bankcard.btA()) {
                    b(activity, WalletResetInfoUI.class, bundle);
                } else if (m.btS().buw() == null || m.btS().buw().size() <= 0) {
                    b(activity, WalletBankcardIdUI.class, bundle);
                } else {
                    w.i("MicroMsg.PayProcess", "hy: go to select bankcard ui");
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean("key_is_show_new_bankcard", true);
                    bundle2.putInt("key_scene", 0);
                    bundle2.putParcelableArrayList("key_showing_bankcards", m.btS().buw());
                    bundle2.putString("key_top_tips", activity.getString(R.l.fkb));
                    b(activity, WalletSelectBankcardUI.class, bundle2);
                }
                return true;
            case 417:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletSwitchVerifyPhoneUI.class, bundle);
                return true;
            case 418:
                bundle.putInt("key_err_code", 0);
                b(activity, WalletResetInfoUI.class, bundle);
                return true;
            default:
                return false;
        }
    }

    private void h(Activity activity, Bundle bundle) {
        if (this.lHw != null && this.lHw.containsKey("key_realname_guide_helper")) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putParcelable("key_realname_guide_helper", this.lHw.getParcelable("key_realname_guide_helper"));
        }
        int i = bundle.getInt("key_pay_scene", 6);
        w.i("MicroMsg.PayProcess", "jumpToResultUI() payScene:%d", new Object[]{Integer.valueOf(i)});
        if (i == 11 || i == 21) {
            b(activity, WalletBalanceResultUI.class, bundle);
        } else if (i == 5 || i == 31 || i == 32 || i == 33) {
            a(activity, "remittance", ".ui.RemittanceResultUI", bundle);
        } else if (i == 37 || i == 39 || i == 42 || i == 45) {
            d(activity, bundle);
            x.a((PayInfo) bundle.getParcelable("key_pay_info"), (Orders) bundle.getParcelable("key_orders"));
        } else {
            b(activity, WalletOrderInfoUI.class, bundle);
        }
    }

    public final boolean e(Activity activity, Bundle bundle) {
        w.d("MicroMsg.PayProcess", "pay_flag : " + this.lHw.getInt("key_pay_flag", 0));
        switch (this.lHw.getInt("key_pay_flag", 0)) {
            case 1:
                return activity instanceof WalletOrderInfoUI;
            case 2:
                return activity instanceof WalletOrderInfoUI;
            default:
                return false;
        }
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletPayUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean o(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.wEx.a(new i((String) objArr[0], 4, (String) objArr[1]), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBankcardIdUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean o(Object... objArr) {
                    if (this.ryE.lHw.getInt("key_pay_scene", 0) == 11) {
                        o.bsC();
                        this.ryE.lHw.putParcelable("key_history_bankcard", o.bsD().rIl);
                    }
                    return super.o(objArr);
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                        this.ryE.lHw.putString("kreq_token", bVar.token);
                        if (bVar.rzL) {
                            this.ryE.lHw.putParcelable("key_orders", bVar.ryM);
                        }
                        Parcelable parcelable = bVar.ocy;
                        if (parcelable != null) {
                            this.ryE.lHw.putParcelable("key_realname_guide_helper", parcelable);
                        }
                    } else if (kVar instanceof c) {
                        c cVar = (c) kVar;
                        this.ryE.lHw.putString("kreq_token", cVar.token);
                        if (cVar.rzL) {
                            this.ryE.lHw.putParcelable("key_orders", cVar.ryM);
                        }
                    }
                    if (this.ryE.e(this.wEw, null)) {
                        this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.m(this.ryE.bsF()), true, true);
                        return true;
                    }
                    this.ryE.a(this.wEw, 0, this.ryE.lHw);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    w.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + this.ryE.lHw.getInt("key_pay_flag", 0));
                    switch (this.ryE.lHw.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (this.ryE.cbQ()) {
                                authen.fRW = 4;
                            } else {
                                authen.fRW = 1;
                            }
                            this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                            return true;
                        case 2:
                            if (this.ryE.cbQ()) {
                                authen.fRW = 5;
                            } else {
                                authen.fRW = 2;
                            }
                            if (this.ryE.lHw.getBoolean("key_is_changing_balance_phone_num", false)) {
                                this.wEx.a(new c(authen, orders, this.ryE.lHw.getBoolean("key_isbalance", false)), true, true);
                            } else {
                                this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                            }
                            return true;
                        case 3:
                            if (this.ryE.cbQ()) {
                                authen.fRW = 6;
                            } else {
                                authen.fRW = 3;
                            }
                            this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                            return true;
                        default:
                            return false;
                    }
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final /* synthetic */ CharSequence qK(int i) {
                    boolean z = this.ryE.lHw.getBoolean("key_is_changing_balance_phone_num");
                    boolean z2 = this.ryE.lHw.getBoolean("key_is_return_from_switch_phone", false);
                    Authen authen = (Authen) this.ryE.lHw.getParcelable("key_authen");
                    String str = (authen == null || authen.rDP == null) ? "" : authen.rDP;
                    int i2 = this.ryE.lHw.getInt("key_pay_flag", 3);
                    Bankcard bankcard;
                    String mz;
                    MMActivity mMActivity;
                    int i3;
                    Object[] objArr;
                    if (!z2 || str.isEmpty()) {
                        if (!z || i2 == 2) {
                            str = bg.ap(this.ryE.lHw.getString("key_mobile"), "");
                            return String.format(this.wEw.getString(R.l.fkL), new Object[]{str});
                        }
                        bankcard = (Bankcard) this.ryE.lHw.getParcelable("key_bankcard");
                        mz = bg.mz(this.ryE.lHw.getString("key_mobile"));
                        mMActivity = this.wEw;
                        i3 = R.l.fkB;
                        objArr = new Object[2];
                        objArr[0] = bankcard.field_desc;
                        objArr[1] = e.UK(bg.mA(mz) ? bankcard.field_mobile : mz);
                        return mMActivity.getString(i3, objArr);
                    } else if (str.equals("cft")) {
                        bankcard = (Bankcard) this.ryE.lHw.getParcelable("key_bankcard");
                        mz = bg.mz(this.ryE.lHw.getString("key_mobile"));
                        mMActivity = this.wEw;
                        i3 = R.l.fkB;
                        objArr = new Object[2];
                        objArr[0] = bankcard.field_desc;
                        objArr[1] = e.UK(bg.mA(mz) ? bankcard.field_mobile : mz);
                        return mMActivity.getString(i3, objArr);
                    } else {
                        str = bg.ap(this.ryE.lHw.getString("key_mobile"), "");
                        return String.format(this.wEw.getString(R.l.fkL), new Object[]{str});
                    }
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (i == 0 && i2 == 0) {
                        if ((kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.e) || (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.b)) {
                            com.tencent.mm.plugin.wallet.pay.a.c.e eVar = (com.tencent.mm.plugin.wallet.pay.a.c.e) kVar;
                            if (eVar.rzL) {
                                this.ryE.lHw.putParcelable("key_orders", eVar.ryM);
                            }
                            Parcelable parcelable = eVar.ocy;
                            if (parcelable != null) {
                                this.ryE.lHw.putParcelable("key_realname_guide_helper", parcelable);
                            }
                            g.oUh.i(10707, new Object[]{Integer.valueOf(1), Integer.valueOf(com.tencent.mm.plugin.wallet_core.d.c.bvu())});
                            return false;
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            return true;
                        }
                    }
                    return false;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean j(java.lang.Object... r9) {
                    /*
                    r8 = this;
                    r3 = 0;
                    r2 = 1;
                    r0 = r9[r2];
                    r0 = (com.tencent.mm.plugin.wallet_core.model.n) r0;
                    r1 = r8.ryE;
                    r1 = r1.lHw;
                    r4 = "key_orders";
                    r1 = r1.getParcelable(r4);
                    r1 = (com.tencent.mm.plugin.wallet_core.model.Orders) r1;
                    r4 = "MicroMsg.PayProcess";
                    r5 = new java.lang.StringBuilder;
                    r6 = "WalletVerifyCodeUI onNext pay_flag : ";
                    r5.<init>(r6);
                    r6 = r8.ryE;
                    r6 = r6.lHw;
                    r7 = "key_pay_flag";
                    r6 = r6.getInt(r7, r3);
                    r5 = r5.append(r6);
                    r5 = r5.toString();
                    com.tencent.mm.sdk.platformtools.w.i(r4, r5);
                    r4 = r8.ryE;
                    r4 = r4.lHw;
                    r5 = "key_is_changing_balance_phone_num";
                    r4 = r4.getBoolean(r5);
                    r5 = r8.ryE;
                    r5 = r5.lHw;
                    r6 = "key_pay_flag";
                    r5 = r5.getInt(r6, r3);
                    switch(r5) {
                        case 1: goto L_0x0051;
                        case 2: goto L_0x0096;
                        case 3: goto L_0x00ea;
                        default: goto L_0x004f;
                    };
                L_0x004f:
                    r0 = r3;
                L_0x0050:
                    return r0;
                L_0x0051:
                    r3 = "1";
                    r0.flag = r3;
                    if (r4 != 0) goto L_0x007e;
                L_0x0058:
                    r3 = r0.ofd;
                    r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
                    if (r3 != 0) goto L_0x008a;
                L_0x0060:
                    com.tencent.mm.plugin.wallet.a.o.bsC();
                    r3 = com.tencent.mm.plugin.wallet.a.o.bsD();
                    r3 = r3.rIq;
                    if (r3 == 0) goto L_0x008a;
                L_0x006b:
                    r3 = r0.ofd;
                    com.tencent.mm.plugin.wallet.a.o.bsC();
                    r4 = com.tencent.mm.plugin.wallet.a.o.bsD();
                    r4 = r4.rIq;
                    r4 = r4.field_bankcardType;
                    r3 = r3.equals(r4);
                    if (r3 == 0) goto L_0x008a;
                L_0x007e:
                    r3 = r8.wEx;
                    r4 = new com.tencent.mm.plugin.wallet.pay.a.c.b;
                    r4.<init>(r0, r1);
                    r3.a(r4, r2, r2);
                L_0x0088:
                    r0 = r2;
                    goto L_0x0050;
                L_0x008a:
                    r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
                    if (r0 == 0) goto L_0x0088;
                L_0x0090:
                    r1 = r8.wEx;
                    r1.a(r0, r2, r2);
                    goto L_0x0088;
                L_0x0096:
                    r3 = r8.ryE;
                    r3 = r3.cbQ();
                    if (r3 != 0) goto L_0x00d8;
                L_0x009e:
                    r3 = "2";
                    r0.flag = r3;
                L_0x00a3:
                    if (r4 != 0) goto L_0x00cb;
                L_0x00a5:
                    r3 = r0.ofd;
                    r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
                    if (r3 != 0) goto L_0x00de;
                L_0x00ad:
                    com.tencent.mm.plugin.wallet.a.o.bsC();
                    r3 = com.tencent.mm.plugin.wallet.a.o.bsD();
                    r3 = r3.rIq;
                    if (r3 == 0) goto L_0x00de;
                L_0x00b8:
                    r3 = r0.ofd;
                    com.tencent.mm.plugin.wallet.a.o.bsC();
                    r4 = com.tencent.mm.plugin.wallet.a.o.bsD();
                    r4 = r4.rIq;
                    r4 = r4.field_bankcardType;
                    r3 = r3.equals(r4);
                    if (r3 == 0) goto L_0x00de;
                L_0x00cb:
                    r3 = r8.wEx;
                    r4 = new com.tencent.mm.plugin.wallet.pay.a.c.b;
                    r4.<init>(r0, r1);
                    r3.a(r4, r2, r2);
                L_0x00d5:
                    r0 = r2;
                    goto L_0x0050;
                L_0x00d8:
                    r3 = "5";
                    r0.flag = r3;
                    goto L_0x00a3;
                L_0x00de:
                    r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
                    if (r0 == 0) goto L_0x00d5;
                L_0x00e4:
                    r1 = r8.wEx;
                    r1.a(r0, r2, r2);
                    goto L_0x00d5;
                L_0x00ea:
                    r3 = r8.ryE;
                    r3 = r3.cbQ();
                    if (r3 != 0) goto L_0x012c;
                L_0x00f2:
                    r3 = "3";
                    r0.flag = r3;
                L_0x00f7:
                    if (r4 != 0) goto L_0x011f;
                L_0x00f9:
                    r3 = r0.ofd;
                    r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
                    if (r3 != 0) goto L_0x0132;
                L_0x0101:
                    com.tencent.mm.plugin.wallet.a.o.bsC();
                    r3 = com.tencent.mm.plugin.wallet.a.o.bsD();
                    r3 = r3.rIq;
                    if (r3 == 0) goto L_0x0132;
                L_0x010c:
                    r3 = r0.ofd;
                    com.tencent.mm.plugin.wallet.a.o.bsC();
                    r4 = com.tencent.mm.plugin.wallet.a.o.bsD();
                    r4 = r4.rIq;
                    r4 = r4.field_bankcardType;
                    r3 = r3.equals(r4);
                    if (r3 == 0) goto L_0x0132;
                L_0x011f:
                    r3 = r8.wEx;
                    r4 = new com.tencent.mm.plugin.wallet.pay.a.c.b;
                    r4.<init>(r0, r1);
                    r3.a(r4, r2, r2);
                L_0x0129:
                    r0 = r2;
                    goto L_0x0050;
                L_0x012c:
                    r3 = "6";
                    r0.flag = r3;
                    goto L_0x00f7;
                L_0x0132:
                    r0 = com.tencent.mm.plugin.wallet.pay.a.a.a(r0, r1);
                    if (r0 == 0) goto L_0x0129;
                L_0x0138:
                    r1 = r8.wEx;
                    r1.a(r0, r2, r2);
                    goto L_0x0129;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.pay.b.12.j(java.lang.Object[]):boolean");
                }
            };
        }
        if (mMActivity instanceof WalletBalanceResultUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    Orders orders = (Orders) objArr[0];
                    o.bsC();
                    Bankcard bankcard = o.bsD().ruN;
                    bankcard.rEh += orders.rFM;
                    return false;
                }

                public final CharSequence qK(int i) {
                    switch (i) {
                        case 0:
                            return this.wEw.getString(R.l.fdD);
                        case 1:
                            return this.wEw.getString(R.l.fdC);
                        default:
                            return super.qK(i);
                    }
                }
            };
        }
        if (mMActivity instanceof WalletPwdConfirmUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final /* synthetic */ CharSequence qK(int i) {
                    return this.wEw.getString(R.l.fko);
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    if (!(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.f) || i != 0 || i2 != 0) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet.pay.a.d.f fVar = (com.tencent.mm.plugin.wallet.pay.a.d.f) kVar;
                    if (fVar.rzL) {
                        this.ryE.lHw.putParcelable("key_orders", fVar.ryM);
                    }
                    Parcelable parcelable = fVar.ocy;
                    if (parcelable != null) {
                        this.ryE.lHw.putParcelable("key_realname_guide_helper", parcelable);
                    }
                    this.ryE.a(this.wEw, 0, this.ryE.lHw);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    k kVar;
                    com.tencent.mm.plugin.wallet_core.model.n nVar = (com.tencent.mm.plugin.wallet_core.model.n) objArr[0];
                    Orders orders = (Orders) this.ryE.lHw.getParcelable("key_orders");
                    if (nVar == null || orders == null) {
                        w.e("MicroMsg.CgiManager", "empty verify or orders");
                        kVar = null;
                    } else {
                        PayInfo payInfo = nVar.oLz;
                        String str = "";
                        if (payInfo != null) {
                            w.i("MicroMsg.CgiManager", "get reqKey from payInfo");
                            str = payInfo.fJH;
                        }
                        if (bg.mA(str)) {
                            w.i("MicroMsg.CgiManager", "get reqKey from orders");
                            str = orders.fJH;
                        }
                        if (bg.mA(str)) {
                            w.i("MicroMsg.CgiManager", "empty reqKey!");
                            kVar = new com.tencent.mm.plugin.wallet.pay.a.d.f(nVar, orders);
                        } else {
                            if (payInfo != null) {
                                w.d("MicroMsg.CgiManager", "reqKey: %s, %s", new Object[]{payInfo.fJH, orders.fJH});
                            }
                            w.i("MicroMsg.CgiManager", "verifyreg reqKey: %s", new Object[]{str});
                            w.i("MicroMsg.CgiManager", "verifyreg go new split cgi");
                            kVar = str.startsWith("sns_aa_") ? new com.tencent.mm.plugin.wallet.pay.a.d.a(nVar, orders) : str.startsWith("sns_tf_") ? new com.tencent.mm.plugin.wallet.pay.a.d.e(nVar, orders) : str.startsWith("sns_ff_") ? new com.tencent.mm.plugin.wallet.pay.a.d.b(nVar, orders) : str.startsWith("ts_") ? new com.tencent.mm.plugin.wallet.pay.a.d.c(nVar, orders) : str.startsWith("sns_") ? new com.tencent.mm.plugin.wallet.pay.a.d.d(nVar, orders) : new com.tencent.mm.plugin.wallet.pay.a.d.f(nVar, orders);
                        }
                    }
                    if (kVar != null) {
                        this.wEx.a(kVar, true, true);
                    }
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletChangeBankcardUI) {
            return new c(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }
            };
        }
        if (mMActivity instanceof WalletSelectBankcardUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0 && (kVar instanceof c)) {
                        w.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
                        this.ryE.a(this.wEw, 0, this.ryE.lHw);
                        return true;
                    } else if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet_core.b.k)) {
                        return false;
                    } else {
                        w.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
                        bsG();
                        return false;
                    }
                }

                public final boolean j(Object... objArr) {
                    w.i("MicroMsg.PayProcess", "onNext for select bank card");
                    this.ryE.lHw.putInt("key_err_code", 0);
                    Bankcard bankcard = (Bankcard) this.ryE.lHw.getParcelable("key_bankcard");
                    if (bankcard == null) {
                        w.i("MicroMsg.PayProcess", "directToBindNew()");
                        this.ryE.lHw.putInt("key_pay_flag", 2);
                        this.ryE.a(this.wEw, 0, this.ryE.lHw);
                    } else if (m.bua().HT(bankcard.field_bankcardType) != null) {
                        bsG();
                    } else {
                        this.wEx.a(new com.tencent.mm.plugin.wallet_core.b.k("", "", null), true, true);
                    }
                    return false;
                }

                private void bsG() {
                    w.i("MicroMsg.PayProcess", "directToNext()");
                    boolean z = this.ryE.lHw.getBoolean("key_balance_change_phone_need_confirm_phone", false);
                    Authen authen = (Authen) this.ryE.lHw.getParcelable("key_authen");
                    Orders orders = (Orders) this.ryE.lHw.getParcelable("key_orders");
                    Bankcard bankcard = (Bankcard) this.ryE.lHw.getParcelable("key_bankcard");
                    ElementQuery HT = m.bua().HT(bankcard.field_bankcardType);
                    this.ryE.lHw.putParcelable("elemt_query", HT);
                    if (z) {
                        authen.ofd = bankcard.field_bankcardType;
                        authen.ofe = bankcard.field_bindSerial;
                        this.ryE.a(this.wEw, 0, this.ryE.lHw);
                        return;
                    }
                    authen.rBT = "";
                    authen.ofd = bankcard.field_bankcardType;
                    authen.ofe = bankcard.field_bindSerial;
                    this.ryE.lHw.putString("key_mobile", bankcard.field_mobile);
                    if (HT == null || HT.rEN || HT.rEO) {
                        w.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
                        this.ryE.a(this.wEw, 0, this.ryE.lHw);
                        return;
                    }
                    this.wEx.a(new c(authen, orders, this.ryE.lHw.getBoolean("key_isbalance", false)), true);
                }
            };
        }
        if (mMActivity instanceof WalletResetInfoUI) {
            return new a(this, (WalletBaseUI) mMActivity, fVar) {
                final /* synthetic */ b ryE;

                public final boolean o(Object... objArr) {
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (super.d(i, i2, str, kVar)) {
                        return true;
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }
            };
        }
        return mMActivity instanceof WalletSwitchVerifyPhoneUI ? new a(this, (WalletBaseUI) mMActivity, fVar) {
            final /* synthetic */ b ryE;

            public final boolean j(Object... objArr) {
                w.i("MicroMsg.PayProcess", "start do authen");
                ej ejVar = (ej) objArr[0];
                Authen authen = (Authen) this.ryE.lHw.getParcelable("key_authen");
                Parcelable bankcard = new Bankcard();
                bankcard.field_bindSerial = ejVar.ofe;
                bankcard.field_mobile = ejVar.rBT;
                bankcard.field_desc = ejVar.mMa;
                bankcard.field_bankcardType = authen.ofd;
                w.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", new Object[]{authen.ofd, ejVar.ofe, authen.ofe});
                this.ryE.lHw.putString("key_mobile", bankcard.field_mobile);
                this.ryE.lHw.putParcelable("key_bankcard", bankcard);
                Orders orders = (Orders) this.ryE.lHw.getParcelable("key_orders");
                authen.rDP = ejVar.tip;
                authen.rDQ = ejVar.ofe;
                authen.rDR = ejVar.ofd;
                authen.rDS = "1";
                k a = com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, false);
                if (a != null) {
                    this.wEx.a(a, true, true);
                }
                return false;
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                    return false;
                }
                w.i("MicroMsg.PayProcess", "finish auth");
                Authen authen = ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).ryN;
                Parcelable parcelable = ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).ryM;
                this.ryE.lHw.putParcelable("key_authen", authen);
                this.ryE.lHw.putParcelable("key_orders", parcelable);
                this.ryE.lHw.putString("kreq_token", ((com.tencent.mm.plugin.wallet.pay.a.a.b) kVar).token);
                this.ryE.lHw.putBoolean("key_is_return_from_switch_phone", true);
                this.ryE.lHw.putInt("key_err_code", 0);
                Bankcard bankcard = (Bankcard) this.ryE.lHw.getParcelable("key_bankcard");
                bankcard.field_bankcardType = authen.ofd;
                bankcard.field_bindSerial = authen.ofe;
                this.ryE.a(this.wEw, 0, this.ryE.lHw);
                this.ryE.J(this.wEw);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final boolean a(final WalletBaseUI walletBaseUI, final int i, String str) {
        w.i("MicroMsg.PayProcess", "onReceiveErr(), errCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 402:
            case 403:
            case 408:
                if (cbT() && this.lHw.getParcelable("key_bankcard") != null) {
                    String string;
                    Bankcard bankcard = (Bankcard) this.lHw.getParcelable("key_bankcard");
                    if (bg.mA(str)) {
                        string = walletBaseUI.getString(R.l.fiM, new Object[]{bankcard.field_desc, bankcard.field_mobile});
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.g.a(walletBaseUI, string, "", walletBaseUI.getString(R.l.fiL), walletBaseUI.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ b ryE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ryE.lHw.putInt("key_pay_flag", 3);
                            this.ryE.lHw.putInt("key_err_code", i);
                            this.ryE.a(walletBaseUI, 0, this.ryE.lHw);
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, null);
                    return true;
                }
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                w.i("MicroMsg.PayProcess", "404 pay error, cancel pay or change!");
                o.bsC();
                ArrayList buw = o.bsD().buw();
                if (buw == null || buw.isEmpty()) {
                    com.tencent.mm.ui.base.g.a(walletBaseUI, str, "", walletBaseUI.getString(R.l.fie), walletBaseUI.getString(R.l.fed), new OnClickListener(this) {
                        final /* synthetic */ b ryE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ryE.lHw.putInt("key_err_code", -1003);
                            this.ryE.a(walletBaseUI, 0, this.ryE.lHw);
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ b ryE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ryE.d(walletBaseUI, this.ryE.lHw);
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                } else {
                    com.tencent.mm.ui.base.g.a(walletBaseUI, str, "", walletBaseUI.getString(R.l.fiu), walletBaseUI.getString(R.l.fed), new OnClickListener(this) {
                        final /* synthetic */ b ryE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Bankcard bankcard = (Bankcard) this.ryE.lHw.getParcelable("key_bankcard");
                            PayInfo payInfo = (PayInfo) this.ryE.lHw.getParcelable("key_pay_info");
                            if (!(bankcard == null || payInfo == null)) {
                                bankcard.rEg = payInfo.fJH;
                            }
                            this.ryE.lHw.putInt("key_err_code", -1004);
                            this.ryE.a(walletBaseUI, 0, this.ryE.lHw);
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ b ryE;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ryE.d(walletBaseUI, this.ryE.lHw);
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                }
                return true;
        }
        return false;
    }

    public final String bsF() {
        if (this.lHw == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.lHw.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.fJH;
        }
        return "";
    }

    public final int b(MMActivity mMActivity, int i) {
        return R.l.fiE;
    }

    public final String avB() {
        return "PayProcess";
    }
}
