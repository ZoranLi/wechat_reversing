package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.b.k;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

@a(19)
public class WalletResetInfoUI extends WalletBaseUI implements WalletFormView.a {
    private TextView jbV;
    private Orders oSJ;
    private Bankcard ruU;
    private Button rxr;
    private WalletFormView rxs;
    private WalletFormView rxt;
    private WalletFormView rxu;
    private WalletFormView rxv;
    private Authen rxw;
    private ElementQuery rxx;

    protected final int getLayoutId() {
        return R.i.drn;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void KC() {
        this.jbV = (TextView) findViewById(R.h.cRE);
        Bankcard bankcard = (Bankcard) this.uT.getParcelable("key_switch_phone_reset_bank_card");
        if (bankcard == null) {
            bankcard = (Bankcard) this.uT.getParcelable("key_bankcard");
        }
        this.ruU = bankcard;
        this.oSJ = (Orders) this.uT.getParcelable("key_orders");
        this.rxw = (Authen) this.uT.getParcelable("key_authen");
        if (TextUtils.isEmpty(this.uT.getString("key_pwd1", ""))) {
            this.uT.putString("key_pwd1", this.rxw.rDC);
            w.e("Micromsg.WalletResetInfoUI", "pwd is empty, reset it to input");
        }
        this.rxx = (ElementQuery) this.uT.getParcelable("elemt_query");
        this.rxs = (WalletFormView) findViewById(R.h.bsf);
        this.rxt = (WalletFormView) findViewById(R.h.bHJ);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.rxt);
        this.rxu = (WalletFormView) findViewById(R.h.bHB);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.rxu);
        this.rxv = (WalletFormView) findViewById(R.h.ckq);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.rxv);
        this.rxt.wFY = this;
        this.rxu.wFY = this;
        this.rxv.wFY = this;
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.cRI);
        mMScrollView.a(mMScrollView, mMScrollView);
        if (this.ruU != null) {
            this.rxs.setText(this.ruU.field_desc);
        } else {
            this.rxs.setVisibility(8);
        }
        bsB();
        if (bsA()) {
            b(new k("", "", null), true);
        }
    }

    private boolean bsA() {
        return this.uT.getInt("key_err_code", 408) == 408 && this.rxx == null;
    }

    private void bsB() {
        switch (this.uT.getInt("key_err_code", 408)) {
            case 402:
                zi(R.l.fjN);
                this.rxu.setVisibility(0);
                this.jbV.setText(R.l.fjM);
                break;
            case 403:
                zi(R.l.fjS);
                this.rxt.setVisibility(0);
                this.jbV.setText(R.l.fjR);
                break;
            default:
                if (this.uT.getBoolean("key_balance_change_phone_need_confirm_phone", true)) {
                    zi(R.l.fjQ);
                    this.rxv.setVisibility(0);
                } else {
                    zi(R.l.fjO);
                }
                if (this.ruU != null) {
                    w.d("Micromsg.WalletResetInfoUI", "bankPhone: %s", new Object[]{this.ruU.field_bankPhone});
                    this.jbV.setText(String.format(getString(R.l.fjP), new Object[]{this.ruU.field_bankPhone}));
                }
                if (this.rxx == null && this.ruU != null) {
                    this.rxx = m.bua().HT(this.ruU.field_bankcardType);
                }
                if (this.rxx != null && this.rxx.rEN) {
                    this.rxu.setVisibility(0);
                }
                if (this.rxx != null && this.rxx.rEO) {
                    this.rxt.setVisibility(0);
                    break;
                }
        }
        this.rxr = (Button) findViewById(R.h.cnY);
        this.rxr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletResetInfoUI rxy;

            {
                this.rxy = r1;
            }

            public final void onClick(View view) {
                if (this.rxy.OX()) {
                    if (this.rxy.rxu.getVisibility() == 0) {
                        this.rxy.rxw.rDH = this.rxy.rxu.getText();
                    }
                    if (this.rxy.rxt.getVisibility() == 0) {
                        this.rxy.rxw.rDI = bg.ap(this.rxy.rxt.getText(), "");
                    }
                    if (this.rxy.rxv.getVisibility() == 0) {
                        this.rxy.rxw.rBT = bg.ap(this.rxy.rxv.getText(), "");
                        this.rxy.uT.putString("key_mobile", e.UK(this.rxy.rxw.rBT));
                    }
                    w.d("Micromsg.WalletResetInfoUI", "tft: bank_type: %s, bank_serial: %s", new Object[]{this.rxy.rxw.ofd, this.rxy.rxw.ofe});
                    this.rxy.rxw.rDB = 1;
                    if (this.rxy.uT.getBoolean("key_is_changing_balance_phone_num", false)) {
                        this.rxy.k(new c(this.rxy.rxw, this.rxy.oSJ, this.rxy.uT.getBoolean("key_isbalance", false)));
                        return;
                    }
                    com.tencent.mm.y.k a = com.tencent.mm.plugin.wallet.pay.a.a.a(this.rxy.rxw, this.rxy.oSJ, false);
                    if (a != null) {
                        this.rxy.k(a);
                        return;
                    }
                    return;
                }
                w.w("Micromsg.WalletResetInfoUI", "input format illegal!");
            }
        });
        OX();
        if (bsA()) {
            re(4);
        } else {
            re(0);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.d("Micromsg.WalletResetInfoUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.uT;
            if ((kVar instanceof b) || (kVar instanceof c)) {
                b bVar = (b) kVar;
                bundle.putBoolean("key_need_verify_sms", !bVar.ryL);
                bundle.putString("kreq_token", bVar.token);
                if (bVar.rzL) {
                    bundle.putParcelable("key_orders", bVar.ryM);
                }
                Parcelable parcelable = bVar.ocy;
                if (parcelable != null) {
                    bundle.putParcelable("key_realname_guide_helper", parcelable);
                }
                bundle.putInt("key_err_code", 0);
                com.tencent.mm.wallet_core.a.k(this, bundle);
                return true;
            } else if ((kVar instanceof k) && this.ruU != null) {
                this.rxx = m.bua().HU(this.ruU.field_bindSerial);
                bsB();
            }
        }
        return false;
    }

    private boolean OX() {
        boolean z;
        if (this.rxt.dF(null)) {
            z = true;
        } else {
            z = false;
        }
        if (!this.rxv.dF(null)) {
            z = false;
        }
        if (!this.rxu.dF(null)) {
            z = false;
        }
        if (this.oSJ == null || this.rxw == null) {
            z = false;
        }
        if (z) {
            this.rxr.setEnabled(true);
            this.rxr.setClickable(true);
        } else {
            this.rxr.setEnabled(false);
            this.rxr.setClickable(false);
        }
        return z;
    }

    public final void gA(boolean z) {
        OX();
    }
}
