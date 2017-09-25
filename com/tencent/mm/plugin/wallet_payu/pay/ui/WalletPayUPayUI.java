package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ry;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_payu.pay.a.c;
import com.tencent.mm.plugin.wallet_payu.pay.a.d;
import com.tencent.mm.plugin.wallet_payu.pay.a.e;
import com.tencent.mm.plugin.wallet_payu.pay.ui.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.k;
import java.util.LinkedList;

@a(3)
public class WalletPayUPayUI extends WalletPayUI {
    private String rSl = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onNewIntent(Intent intent) {
        w.i("MicroMsg.WalletPayUPayUI", "hy: onNewIntent");
        super.onNewIntent(intent);
    }

    protected final void bsW() {
        b(new c(bth().fJH), bth().sYb);
        b(new com.tencent.mm.plugin.wallet_core.b.b.a(bth().fJH), bth().sYb);
    }

    protected final void bsO() {
        if (OX()) {
            w.d("MicroMsg.WalletPayUPayUI", "pay with old bankcard!");
            this.ruh = b.a(this, this.oSJ, this.rzg, this.ruk, new b(this) {
                final /* synthetic */ WalletPayUPayUI rSp;

                {
                    this.rSp = r1;
                }

                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    this.rSp.aHf();
                    this.rSp.lOK = str;
                    this.rSp.rSl = str2;
                    this.rSp.ix(false);
                    com.tencent.mm.plugin.wallet_core.d.c.bvt();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUPayUI rSp;

                {
                    this.rSp = r1;
                }

                public final void onClick(View view) {
                    this.rSp.rzg = (FavorPayInfo) view.getTag();
                    if (this.rSp.rzg != null) {
                        this.rSp.rzg.rFq = "";
                    }
                    this.rSp.c(false, 0, "");
                    this.rSp.ruh.dismiss();
                    this.rSp.lOK = null;
                    this.rSp.ruh = null;
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletPayUPayUI rSp;

                {
                    this.rSp = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.rSp.lOK = null;
                    this.rSp.ruh = null;
                    if (this.rSp.aIY()) {
                        this.rSp.finish();
                    }
                }
            }, "CREDITCARD_PAYU".equals(this.ruk.field_bankcardType));
        }
    }

    protected final void G(Bundle bundle) {
        boolean z = true;
        this.rzM = true;
        if (this.oSJ != null) {
            bundle.putInt("key_support_bankcard", this.oSJ.rBY);
        }
        String str = "key_is_oversea";
        if (btb()) {
            z = false;
        }
        bundle.putBoolean(str, z);
        com.tencent.mm.wallet_core.a.a(this, e.class, bundle);
    }

    protected final void ix(boolean z) {
        if (this.rze.fRv == 32 || this.rze.fRv == 31) {
            int i;
            if (this.rze.fRv == 32) {
                w.d("MicroMsg.WalletPayUPayUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            q(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.rze.fJH, this.lOK, this.rze.sYe.getDouble("total_fee"), this.rze.sYe.getString("fee_type"), i, this.rze.sYe.getString("extinfo_key_1"), this.ruk.field_bindSerial, this.rze.sYe.getString("extinfo_key_4")));
        } else if (this.rze.fRv == 11) {
            String str = this.lOK;
            String str2 = this.rSl;
            String str3 = this.rze.fJH;
            double d = this.rze.sYe.getDouble("total_fee");
            String string = this.rze.sYe.getString("fee_type");
            String str4 = this.ruk.field_bindSerial;
            String str5 = this.ruk.field_bankcardType;
            o.bsC();
            q(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str, str2, str3, d, string, str4, str5, o.bsD().ruN.field_bindSerial));
        } else {
            k(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.rze.fJH, this.rze.sYe.getDouble("total_fee"), this.rze.sYe.getString("fee_type"), this.ruk.field_bankcardType, this.ruk.field_bindSerial, this.rSl, this.lOK));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        com.tencent.mm.plugin.wallet_payu.pay.a.b bVar;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof c) {
                this.oSJ = ((c) kVar).oSJ;
                if (this.oSJ != null) {
                    i3 = this.oSJ.rGe.size();
                }
                this.mCount = i3;
                w.d("MicroMsg.WalletPayUPayUI", "get mOrders! bankcardTag : " + (this.oSJ != null ? Integer.valueOf(this.oSJ.rBY) : ""));
                OX();
                if (!(this.oSJ == null || this.oSJ.rGe == null)) {
                    LinkedList linkedList = new LinkedList();
                    for (Commodity commodity : this.oSJ.rGe) {
                        if (bg.mA(commodity.fTA)) {
                            commodity.fTA = this.rze.fJH;
                        }
                        linkedList.add(commodity.fTA);
                    }
                    if (linkedList.size() > 0) {
                        com.tencent.mm.sdk.b.b ryVar = new ry();
                        ryVar.fZs.fZu = linkedList;
                        com.tencent.mm.sdk.b.a.urY.m(ryVar);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putDouble("total_fee", this.oSJ.rFM);
                    bundle.putString("fee_type", "ZAR");
                    if (this.rze.sYe == null) {
                        this.rze.sYe = bundle;
                    } else {
                        this.rze.sYe.putAll(bundle);
                    }
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.b.a) {
                o.bsC();
                this.ruj = o.bsD().it(bsL());
                o.bsC();
                this.ruk = o.bsD().a(null, null, bsL(), false);
                this.rzb.setClickable(true);
                if (!(this.oSJ == null || this.ruj == null || this.rze == null)) {
                    com.tencent.mm.plugin.wallet_core.d.c.b(this.rze, this.oSJ);
                    g gVar = g.oUh;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(this.rze.fRv);
                    objArr[1] = Integer.valueOf(0);
                    o.bsC();
                    objArr[2] = Integer.valueOf(o.bsD().bum() ? 2 : 1);
                    objArr[3] = Integer.valueOf((int) (this.oSJ.rFM * 100.0d));
                    objArr[4] = this.oSJ.oga;
                    gVar.i(10690, objArr);
                }
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
                bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                r1 = this.uT;
                r1.putParcelable("key_pay_info", this.rze);
                r1.putParcelable("key_bankcard", this.ruk);
                r1.putString("key_bank_type", this.ruk.field_bankcardType);
                if (!bg.mA(this.lOK)) {
                    r1.putString("key_pwd1", this.lOK);
                }
                r1.putString("kreq_token", bVar.aQZ());
                r1.putParcelable("key_authen", bta());
                r1.putBoolean("key_need_verify_sms", false);
                r1.putString("key_mobile", this.ruk.field_mobile);
                if (bVar.isSuccess()) {
                    r1.putParcelable("key_orders", d.a(this.oSJ, bVar.rSh, bVar.rSi, bVar.kBd, bVar.rJi));
                }
                this.uT.putBoolean("key_should_redirect", bVar.rSf);
                this.uT.putString("key_gateway_code", bVar.rQI);
                this.uT.putString("key_gateway_reference", bVar.rQH);
                this.uT.putBoolean("key_should_force_adjust", bVar.rSg);
                this.uT.putString("key_force_adjust_code", bVar.rQK);
                r1.putInt("key_pay_flag", 3);
                G(r1);
                return true;
            } else if (kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) {
                com.tencent.mm.plugin.wallet_payu.remittance.a.a aVar = (com.tencent.mm.plugin.wallet_payu.remittance.a.a) kVar;
                r1 = this.uT;
                r1.putParcelable("key_pay_info", this.rze);
                r1.putParcelable("key_bankcard", this.ruk);
                r1.putString("key_bank_type", this.ruk.field_bankcardType);
                if (!bg.mA(this.lOK)) {
                    r1.putString("key_pwd1", this.lOK);
                }
                r1.putString("kreq_token", aVar.aQZ());
                r1.putParcelable("key_authen", bta());
                r1.putBoolean("key_need_verify_sms", false);
                r1.putString("key_mobile", this.ruk.field_mobile);
                r1.putParcelable("key_orders", this.oSJ);
                r1.putInt("key_pay_flag", 3);
                G(r1);
                return true;
            }
            ar();
            return true;
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            switch (i2) {
                case 402:
                case 403:
                case 408:
                    String string;
                    bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
                    this.rzQ = this.uT;
                    this.rzQ.putParcelable("key_pay_info", this.rze);
                    this.rzQ.putParcelable("key_bankcard", this.ruk);
                    if (!bg.mA(this.lOK)) {
                        this.rzQ.putString("key_pwd1", this.lOK);
                    }
                    this.rzQ.putString("kreq_token", bVar.aQZ());
                    this.rzQ.putString("key_mobile", this.ruk.field_mobile);
                    this.rzQ.putInt("key_err_code", i2);
                    this.rzQ.putParcelable("key_orders", this.oSJ);
                    if (bg.mA(str)) {
                        string = getString(R.l.fiM);
                    } else {
                        string = str;
                    }
                    com.tencent.mm.ui.base.g.a(this, string, "", getString(R.l.fiL), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletPayUPayUI rSp;

                        {
                            this.rSp = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.rSp.rzQ.putInt("key_pay_flag", 3);
                            this.rSp.G(this.rSp.rzQ);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ WalletPayUPayUI rSp;

                        {
                            this.rSp = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.rSp.aIY()) {
                                this.rSp.finish();
                            }
                        }
                    });
                    return true;
                case TencentLocation.ERROR_UNKNOWN /*404*/:
                    if (!(this.ruk == null || this.oSJ == null)) {
                        this.ruk.rEg = this.oSJ.fJH;
                        if (this.ruj == null || this.ruj.size() <= 1) {
                            b(true, 4, str);
                            return true;
                        }
                        c(true, 4, str);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }
}
