package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class WalletWXCreditErrDetailUI extends WalletBaseUI {
    private Bankcard ruU;
    private String sAC;
    private TextView sAD;
    private TextView sAE;

    protected final int getLayoutId() {
        return R.i.drF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.fdS);
        KC();
    }

    protected final void KC() {
        this.ruU = (Bankcard) this.uT.getParcelable("key_bankcard");
        this.sAC = this.uT.getString("key_repayment_url");
        if (this.ruU != null) {
            this.sAD = (TextView) findViewById(R.h.cPF);
            this.sAD.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletWXCreditErrDetailUI sAF;

                {
                    this.sAF = r1;
                }

                public final void onClick(View view) {
                    e.m(this.sAF, this.sAF.sAC, false);
                }
            });
            this.sAE = (TextView) findViewById(R.h.cPG);
            this.sAE.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletWXCreditErrDetailUI sAF;

                {
                    this.sAF = r1;
                }

                public final void onClick(View view) {
                    a.k(this.sAF, this.sAF.uT);
                }
            });
            this.sAE.setVisibility(this.uT.getBoolean("key_can_unbind", true) ? 0 : 8);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
