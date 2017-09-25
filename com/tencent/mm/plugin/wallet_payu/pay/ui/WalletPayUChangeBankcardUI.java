package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.e;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.k;

@a(3)
public class WalletPayUChangeBankcardUI extends WalletChangeBankcardUI {
    private String rSl = null;
    private c rSm = new c<kv>(this) {
        final /* synthetic */ WalletPayUChangeBankcardUI rSn;

        {
            this.rSn = r2;
            this.usg = kv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kv kvVar = (kv) bVar;
            w.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: on request proceed pay");
            d dVar = new d(kvVar);
            this.rSn.uT.putString("app_id", dVar.appId);
            this.rSn.uT.putString("package", dVar.packageExt);
            this.rSn.uT.putString("timestamp", dVar.timeStamp);
            this.rSn.uT.putString("noncestr", dVar.nonceStr);
            this.rSn.uT.putString("pay_sign", dVar.fRt);
            this.rSn.uT.putString("sign_type", dVar.signType);
            this.rSn.uT.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, dVar.url);
            this.rSn.uT.putBoolean("from_jsapi", true);
            this.rSn.uT.putString("key_trans_id", ((PayInfo) this.rSn.uT.getParcelable("key_pay_info")).fJH);
            this.rSn.uT.putBoolean("key_should_redirect", false);
            com.tencent.mm.wallet_core.a.k(this.rSn, this.rSn.uT);
            return true;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.urY.b(this.rSm);
    }

    public void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.urY.c(this.rSm);
    }

    protected final e bsN() {
        return new a(this, this.ruj, this.rzc, this.oSJ);
    }

    protected final void bsO() {
        w.d("MicroMsg.WalletPayUChangeBankcardUI", "pay with old bankcard!");
        String string = this.uT.getString("key_pwd1");
        if (bg.mA(string)) {
            re(4);
            this.ruh = b.a(this, this.oSJ, this.rzg, this.ruk, new b.b(this) {
                final /* synthetic */ WalletPayUChangeBankcardUI rSn;

                {
                    this.rSn = r1;
                }

                public final void a(String str, String str2, FavorPayInfo favorPayInfo) {
                    this.rSn.rzg = favorPayInfo;
                    this.rSn.uT.putParcelable("key_favor_pay_info", this.rSn.rzg);
                    this.rSn.lOK = str;
                    this.rSn.rSl = str2;
                    this.rSn.aHf();
                    this.rSn.HM(str);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WalletPayUChangeBankcardUI rSn;

                {
                    this.rSn = r1;
                }

                public final void onClick(View view) {
                    if (this.rSn.ruh != null) {
                        this.rSn.ruh.dismiss();
                    }
                    this.rSn.rzd.e(this.rSn.ruj, true);
                    this.rSn.rzg = (FavorPayInfo) view.getTag();
                    if (this.rSn.rzg != null) {
                        this.rSn.rzg.rFq = "";
                    }
                    this.rSn.uT.putParcelable("key_favor_pay_info", this.rSn.rzg);
                    this.rSn.ar();
                    this.rSn.re(0);
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletPayUChangeBankcardUI rSn;

                {
                    this.rSn = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.rSn.lOK = null;
                    if (this.rSn.uSU.ipu.getVisibility() != 0) {
                        this.rSn.bsQ();
                    }
                }
            }, "CREDITCARD_PAYU".equals(this.ruk.field_bankcardType));
            return;
        }
        HM(string);
    }

    protected final void HM(String str) {
        this.rxw.rDC = str;
        if (this.ruk != null) {
            this.uT.putString("key_mobile", this.ruk.field_mobile);
            this.uT.putParcelable("key_bankcard", this.ruk);
            this.rxw.ofe = this.ruk.field_bindSerial;
            this.rxw.ofd = this.ruk.field_bankcardType;
            if (this.rzg != null) {
                this.rxw.rDO = this.rzg.rFm;
            } else {
                this.rxw.rDO = null;
            }
            if (!(this.oSJ == null || this.oSJ.rGf == null)) {
                this.rxw.rDN = this.oSJ.rGf.rxP;
            }
            if (this.oSJ != null && this.oSJ.rBY == 3) {
                boolean z;
                if (this.ruk.btD()) {
                    this.rxw.fRW = 3;
                } else {
                    this.rxw.fRW = 6;
                }
                Bundle bundle = this.uT;
                String str2 = "key_is_oversea";
                if (this.ruk.btD()) {
                    z = false;
                } else {
                    z = true;
                }
                bundle.putBoolean(str2, z);
            }
        }
        this.uT.putParcelable("key_authen", this.rxw);
        if (this.rze.fRv == 32 || this.rze.fRv == 31) {
            int i;
            if (this.rze.fRv == 32) {
                w.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: transfer ftf");
                i = 1;
            } else {
                i = 0;
            }
            q(new com.tencent.mm.plugin.wallet_payu.remittance.a.a(this.rze.fJH, this.lOK, this.rze.sYe.getDouble("total_fee"), this.rze.sYe.getString("fee_type"), i, this.rze.sYe.getString("extinfo_key_1"), this.ruk.field_bindSerial, this.rze.sYe.getString("extinfo_key_4")));
        } else if (this.rze.fRv == 11) {
            String str3 = this.lOK;
            String str4 = this.rSl;
            String str5 = this.rze.fJH;
            double d = this.rze.sYe.getDouble("total_fee");
            String string = this.rze.sYe.getString("fee_type");
            String str6 = this.ruk.field_bindSerial;
            String str7 = this.ruk.field_bankcardType;
            o.bsC();
            q(new com.tencent.mm.plugin.wallet_payu.balance.a.b(str3, str4, str5, d, string, str6, str7, o.bsD().ruN.field_bindSerial));
        } else {
            k(new com.tencent.mm.plugin.wallet_payu.pay.a.b(this.rze.fJH, this.rze.sYe.getDouble("total_fee"), this.rze.sYe.getString("fee_type"), this.ruk.field_bankcardType, this.ruk.field_bindSerial, this.rSl, str));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (!(kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.a) && !(kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b)) {
            return false;
        }
        Bundle bundle = this.uT;
        if (!bg.mA(this.lOK)) {
            bundle.putString("key_pwd1", this.lOK);
        }
        bundle.putBoolean("key_need_verify_sms", false);
        bundle.putParcelable("key_pay_info", this.rze);
        bundle.putInt("key_pay_flag", 3);
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.pay.a.b) {
            com.tencent.mm.plugin.wallet_payu.pay.a.b bVar = (com.tencent.mm.plugin.wallet_payu.pay.a.b) kVar;
            bundle.putString("transid", bVar.kAj);
            bundle.putBoolean("key_should_redirect", bVar.rSf);
            bundle.putString("key_gateway_code", bVar.rQI);
            bundle.putString("key_gateway_reference", bVar.rQH);
            bundle.putString("key_force_adjust_code", bVar.rQK);
            bundle.putBoolean("key_should_force_adjust", bVar.rSg);
            if (bVar.isSuccess()) {
                bundle.putParcelable("key_orders", com.tencent.mm.plugin.wallet_payu.pay.a.d.a(this.oSJ, bVar.rSh, bVar.rSi, bVar.kBd, bVar.rJi));
            }
        }
        if (kVar instanceof com.tencent.mm.plugin.wallet_payu.balance.a.b) {
            com.tencent.mm.plugin.wallet_payu.balance.a.b bVar2 = (com.tencent.mm.plugin.wallet_payu.balance.a.b) kVar;
            bundle.putString("transid", bVar2.kAj);
            bundle.putBoolean("key_should_redirect", bVar2.rQG);
            bundle.putString("key_gateway_code", bVar2.rQI);
            bundle.putString("key_gateway_reference", bVar2.rQH);
            bundle.putString("key_force_adjust_code", bVar2.rQK);
            bundle.putBoolean("key_should_force_adjust", bVar2.rQJ);
        }
        com.tencent.mm.wallet_core.a.k(this, bundle);
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 23351) {
            w.d("MicroMsg.WalletPayUChangeBankcardUI", "hy: check otp done. resultcode: %d", new Object[]{Integer.valueOf(i2)});
            if (i2 == -1) {
                this.uT.putBoolean("key_should_redirect", false);
                com.tencent.mm.wallet_core.a.k(this, this.uT);
            }
            if (i2 == 0) {
                com.tencent.mm.wallet_core.a.c(this, this.uT, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
