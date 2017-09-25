package com.tencent.mm.plugin.wallet.balance;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.b.m;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b extends com.tencent.mm.wallet_core.b {
    public final com.tencent.mm.wallet_core.b c(Activity activity, Bundle bundle) {
        n.CH(14);
        if (activity instanceof WalletBalanceFetchUI) {
            o.bsC();
            if (!o.bsD().bum()) {
                this.lHw.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.lHw.getParcelable("key_bankcard")) != null) {
                this.lHw.putInt("key_pay_flag", 3);
                this.lHw.putString("key_pwd_cash_title", activity.getString(R.l.fds));
                Orders orders = (Orders) this.lHw.getParcelable("key_orders");
                if (orders != null) {
                    this.lHw.putString("key_pwd_cash_money", e.o(orders.rFM));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.lHw.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
            }
        } else {
            b(activity, WalletBalanceFetchUI.class, bundle);
        }
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBalanceFetchUI) {
            o.bsC();
            if (!o.bsD().bum()) {
                this.lHw.putInt("key_pay_flag", 1);
                b(activity, WalletBankcardIdUI.class, bundle);
            } else if (((Bankcard) this.lHw.getParcelable("key_bankcard")) != null) {
                this.lHw.putInt("key_pay_flag", 3);
                this.lHw.putString("key_pwd_cash_title", activity.getString(R.l.fds));
                Orders orders = (Orders) this.lHw.getParcelable("key_orders");
                if (orders != null) {
                    this.lHw.putString("key_pwd_cash_money", e.o(orders.rFM));
                }
                b(activity, WalletBalanceFetchPwdInputUI.class, bundle);
            } else {
                this.lHw.putInt("key_pay_flag", 2);
                b(activity, WalletCheckPwdUI.class, bundle);
            }
        } else if (activity instanceof WalletBalanceFetchPwdInputUI) {
            if (bundle.getBoolean("key_need_verify_sms", false)) {
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                b(activity, WalletBalanceResultUI.class, bundle);
            }
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, WalletBankcardIdUI.class, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            b(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletCardElementUI) {
            b(activity, WalletVerifyCodeUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            o.bsC();
            if (o.bsD().bum()) {
                b(activity, WalletBalanceResultUI.class, bundle);
            } else {
                b(activity, WalletSetPasswordUI.class, bundle);
            }
        } else if (activity instanceof WalletSetPasswordUI) {
            b(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, WalletBalanceResultUI.class, bundle);
        } else if (activity instanceof WalletBalanceResultUI) {
            d(activity, bundle);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else if (activity instanceof WalletBalanceResultUI) {
            n.ccf();
            d(activity, this.lHw);
        } else {
            n.ccf();
            J(activity);
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        a(activity, WalletBalanceManagerUI.class, -1, true);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final d a(MMActivity mMActivity, f fVar) {
        if (mMActivity instanceof WalletBalanceFetchUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rtx;

                public final boolean o(Object... objArr) {
                    o.bsC();
                    this.rtx.lHw.putParcelable("key_history_bankcard", o.bsD().rIl);
                    PayInfo payInfo = (PayInfo) this.rtx.lHw.get("key_pay_info");
                    this.wEx.a(new m(payInfo == null ? null : payInfo.fJH, 4), true);
                    return false;
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    this.rtx.a(this.wEw, 0, this.rtx.lHw);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBalanceFetchPwdInputUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rtx;

                public final boolean d(int i, int i2, String str, k kVar) {
                    boolean z = false;
                    if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b)) {
                        return false;
                    }
                    com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                    this.rtx.lHw.putString("kreq_token", bVar.token);
                    this.rtx.lHw.putParcelable("key_authen", bVar.ryN);
                    Bundle d = this.rtx.lHw;
                    String str2 = "key_need_verify_sms";
                    if (!bVar.ryL) {
                        z = true;
                    }
                    d.putBoolean(str2, z);
                    Parcelable parcelable = bVar.ocy;
                    if (parcelable != null) {
                        this.rtx.lHw.putParcelable("key_realname_guide_helper", parcelable);
                    }
                    a.k(this.wEw, this.rtx.lHw);
                    this.wEw.finish();
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Bankcard bankcard = (Bankcard) this.rtx.lHw.getParcelable("key_bankcard");
                    this.rtx.lHw.putString("key_pwd1", (String) objArr[0]);
                    this.rtx.lHw.putString("key_mobile", bankcard.field_mobile);
                    Authen authen = new Authen();
                    authen.fRW = 3;
                    authen.rDC = (String) objArr[0];
                    authen.ofe = bankcard.field_bindSerial;
                    authen.ofd = bankcard.field_bankcardType;
                    authen.oLz = (PayInfo) this.rtx.lHw.getParcelable("key_pay_info");
                    authen.rDK = bankcard.field_arrive_type;
                    this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) this.rtx.lHw.getParcelable("key_orders")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rtx;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                        com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                        this.rtx.lHw.putString("kreq_token", bVar.token);
                        if (bVar.rzL) {
                            this.rtx.lHw.putParcelable("key_orders", bVar.ryM);
                        }
                    }
                    if (this.rtx.e(this.wEw, null)) {
                        String str2;
                        f fVar = this.wEx;
                        b bVar2 = this.rtx;
                        if (bVar2.lHw != null) {
                            PayInfo payInfo = (PayInfo) bVar2.lHw.getParcelable("key_pay_info");
                            if (payInfo != null) {
                                str2 = payInfo.fJH;
                                fVar.a(new m(str2), true, true);
                                return true;
                            }
                        }
                        str2 = "";
                        fVar.a(new m(str2), true, true);
                        return true;
                    }
                    this.rtx.a(this.wEw, 0, this.rtx.lHw);
                    return true;
                }

                public final boolean j(Object... objArr) {
                    Authen authen = (Authen) objArr[0];
                    Orders orders = (Orders) objArr[1];
                    switch (this.rtx.lHw.getInt("key_pay_flag", 0)) {
                        case 1:
                            if (!this.rtx.cbQ()) {
                                authen.fRW = 1;
                                break;
                            }
                            authen.fRW = 4;
                            break;
                        case 2:
                            if (!this.rtx.cbQ()) {
                                authen.fRW = 2;
                                break;
                            }
                            authen.fRW = 5;
                            break;
                        case 3:
                            if (!this.rtx.cbQ()) {
                                authen.fRW = 3;
                                break;
                            }
                            authen.fRW = 6;
                            break;
                        default:
                            return false;
                    }
                    this.rtx.lHw.putParcelable("key_authen", authen);
                    this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, orders), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rtx;

                public final /* synthetic */ CharSequence qK(int i) {
                    String str;
                    String ap = bg.ap(this.rtx.lHw.getString("key_mobile"), "");
                    if (bg.mA(ap)) {
                        Bankcard bankcard = (Bankcard) this.rtx.lHw.getParcelable("key_bankcard");
                        if (bankcard != null) {
                            str = bankcard.field_mobile;
                            return this.wEw.getString(R.l.fkJ, new Object[]{str});
                        }
                    }
                    str = ap;
                    return this.wEw.getString(R.l.fkJ, new Object[]{str});
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i == 0 && i2 == 0) {
                        if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.c.e) {
                            com.tencent.mm.plugin.wallet.pay.a.c.e eVar = (com.tencent.mm.plugin.wallet.pay.a.c.e) kVar;
                            if (eVar.rzL) {
                                this.rtx.lHw.putParcelable("key_orders", eVar.ryM);
                            }
                            a.k(this.wEw, this.rtx.lHw);
                            return true;
                        } else if (kVar instanceof com.tencent.mm.plugin.wallet.pay.a.a.b) {
                            com.tencent.mm.plugin.wallet.pay.a.a.b bVar = (com.tencent.mm.plugin.wallet.pay.a.a.b) kVar;
                            Parcelable parcelable = bVar.ocy;
                            if (parcelable != null) {
                                this.rtx.lHw.putParcelable("key_realname_guide_helper", parcelable);
                            }
                            this.rtx.lHw.putString("kreq_token", bVar.token);
                            return true;
                        }
                    }
                    return false;
                }

                public final boolean j(Object... objArr) {
                    com.tencent.mm.plugin.wallet_core.model.n nVar = (com.tencent.mm.plugin.wallet_core.model.n) objArr[1];
                    if (!(nVar == null || nVar.oLz == null)) {
                        nVar.oLz.fRv = 21;
                    }
                    Orders orders = (Orders) this.rtx.lHw.getParcelable("key_orders");
                    switch (this.rtx.lHw.getInt("key_pay_flag", 0)) {
                        case 1:
                            nVar.flag = "1";
                            break;
                        case 2:
                            if (!this.rtx.cbQ()) {
                                nVar.flag = "2";
                                break;
                            }
                            nVar.flag = "5";
                            break;
                        case 3:
                            if (!this.rtx.cbQ()) {
                                nVar.flag = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                break;
                            }
                            nVar.flag = "6";
                            break;
                        default:
                            return false;
                    }
                    this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.c.e(nVar, orders), true, true);
                    return true;
                }

                public final boolean p(Object... objArr) {
                    Authen authen = (Authen) this.rtx.lHw.getParcelable("key_authen");
                    this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.a.b(authen, (Orders) this.rtx.lHw.getParcelable("key_orders")), true, true);
                    return true;
                }
            };
        }
        if (mMActivity instanceof WalletBalanceResultUI) {
            return new d(this, mMActivity, fVar) {
                final /* synthetic */ b rtx;

                public final boolean o(Object... objArr) {
                    Orders orders = (Orders) this.rtx.lHw.getParcelable("key_orders");
                    Bankcard bankcard = com.tencent.mm.plugin.wallet_core.model.m.btS().ruN;
                    bankcard.rEh -= orders.rFM;
                    this.rtx.lHw.putInt("key_balance_result_logo", R.k.dzm);
                    return super.o(objArr);
                }

                public final boolean d(int i, int i2, String str, k kVar) {
                    return false;
                }

                public final boolean j(Object... objArr) {
                    return false;
                }

                public final CharSequence qK(int i) {
                    Orders orders;
                    switch (i) {
                        case 0:
                            return this.wEw.getString(R.l.fdB);
                        case 1:
                            orders = (Orders) this.rtx.lHw.getParcelable("key_orders");
                            if (orders == null || bg.mA(orders.rFZ)) {
                                return this.wEw.getString(R.l.fdA);
                            }
                            return orders.rFZ;
                        case 2:
                            orders = (Orders) this.rtx.lHw.getParcelable("key_orders");
                            if (orders != null && orders.rFY > 0) {
                                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(orders.rFY));
                            }
                    }
                    return super.qK(i);
                }
            };
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ b rtx;

            public final /* synthetic */ CharSequence qK(int i) {
                return this.wEw.getString(R.l.fko);
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.pay.a.d.f)) {
                    return false;
                }
                com.tencent.mm.plugin.wallet.pay.a.d.f fVar = (com.tencent.mm.plugin.wallet.pay.a.d.f) kVar;
                if (fVar.rzL) {
                    this.rtx.lHw.putParcelable("key_orders", fVar.ryM);
                }
                this.rtx.a(this.wEw, 0, this.rtx.lHw);
                return true;
            }

            public final boolean j(Object... objArr) {
                this.wEx.a(new com.tencent.mm.plugin.wallet.pay.a.d.f((com.tencent.mm.plugin.wallet_core.model.n) objArr[0], (Orders) this.rtx.lHw.getParcelable("key_orders")), true, true);
                return true;
            }
        } : super.a(mMActivity, fVar);
    }

    public final int b(MMActivity mMActivity, int i) {
        return R.l.fdo;
    }

    public final String avB() {
        return "BalanceFetchProcess";
    }
}
