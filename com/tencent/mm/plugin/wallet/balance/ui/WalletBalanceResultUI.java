package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

@a(19)
public class WalletBalanceResultUI extends WalletBaseUI {
    protected Button liz;
    protected TextView nsH;
    public Orders oSJ;
    protected TextView qQp;
    public TextView ruQ;
    public TextView ruR;
    protected TextView ruS;
    public CheckBox ruT;
    public Bankcard ruU;

    static /* synthetic */ void a(WalletBalanceResultUI walletBalanceResultUI) {
        if (walletBalanceResultUI.uT.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceResultUI.uT.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.a(walletBalanceResultUI, bundle, new OnClickListener(walletBalanceResultUI) {
                    final /* synthetic */ WalletBalanceResultUI ruV;

                    {
                        this.ruV = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.ruV.bso();
                    }
                });
                walletBalanceResultUI.uT.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        walletBalanceResultUI.bso();
    }

    protected final int getLayoutId() {
        return R.i.dpZ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oSJ = (Orders) this.uT.getParcelable("key_orders");
        KC();
        ar();
        x.a((PayInfo) this.uT.getParcelable("key_pay_info"), this.oSJ);
    }

    public void KC() {
        qP((String) ccF().qK(0));
        this.qQp = (TextView) findViewById(R.h.cPh);
        this.qQp.setText(ccF().qK(1));
        this.ruS = (TextView) findViewById(R.h.cPm);
        this.nsH = (TextView) findViewById(R.h.cPl);
        CharSequence qK = ccF().qK(2);
        if (bg.J(qK)) {
            this.ruS.setVisibility(8);
            this.nsH.setVisibility(8);
        } else {
            this.ruS.setVisibility(0);
            this.nsH.setVisibility(0);
            this.nsH.setText(qK);
        }
        ImageView imageView = (ImageView) findViewById(R.h.cPk);
        int i = this.uT.getInt("key_balance_result_logo", -1);
        if (i > 0) {
            imageView.setImageResource(i);
        } else {
            imageView.setImageResource(R.k.dzj);
        }
        this.ruR = (TextView) findViewById(R.h.cPg);
        this.ruQ = (TextView) findViewById(R.h.cPn);
        TextView textView = (TextView) findViewById(R.h.cPo);
        if (ccE() instanceof b) {
            textView.setText(getString(R.l.fdE));
        }
        this.ruT = (CheckBox) findViewById(R.h.bsP);
        this.ruU = (Bankcard) this.uT.getParcelable("key_bankcard");
        if (this.ruU != null) {
            this.ruT.setVisibility(8);
        } else {
            this.ruT.setVisibility(0);
        }
        this.liz = (Button) findViewById(R.h.cnY);
        this.liz.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WalletBalanceResultUI ruV;

            {
                this.ruV = r1;
            }

            public final void onClick(View view) {
                WalletBalanceResultUI.a(this.ruV);
            }
        });
        bPS();
        kq(false);
    }

    private void bso() {
        if (this.ruT.getVisibility() == 0 && this.ruT.isChecked()) {
            PayInfo payInfo = (PayInfo) this.uT.getParcelable("key_pay_info");
            k(new com.tencent.mm.plugin.wallet.balance.a.a(this.uT.getInt("key_pay_flag", 0), this.uT.getString("key_pwd1"), this.uT.getString("key_verify_code"), payInfo.fJH, payInfo.fRv));
            return;
        }
        bsp();
    }

    public void ar() {
        if (this.oSJ != null) {
            this.ruQ.setText(e.d(this.oSJ.rFM, this.oSJ.oga));
            if (this.oSJ.rGe != null && this.oSJ.rGe.size() > 0) {
                Commodity commodity = (Commodity) this.oSJ.rGe.get(0);
                if (bg.mA(commodity.rGu)) {
                    this.ruR.setText(commodity.ofY);
                } else {
                    this.ruR.setText(commodity.ofY + " " + getString(R.l.fiv) + commodity.rGu);
                }
            }
            if (!(ccE() instanceof b)) {
                return;
            }
            if (this.oSJ.oQs > 0.0d) {
                findViewById(R.h.cPj).setVisibility(0);
                TextView textView = (TextView) findViewById(R.h.cPi);
                textView.setText(e.d(this.oSJ.oQs, this.oSJ.oga));
                textView.setVisibility(0);
                return;
            }
            w.i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
        }
    }

    public final void bsp() {
        if (!ccF().j(this.oSJ)) {
            super.bsp();
        }
    }

    public void onBackPressed() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0 || !(kVar instanceof com.tencent.mm.plugin.wallet.balance.a.a)) {
            return false;
        }
        o.bsC();
        o.bsD().rIr = bg.Ny();
        bsp();
        return true;
    }
}
