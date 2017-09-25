package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

public class WalletWXCreditOpenUI extends WalletBaseUI {
    private Button liz;
    private Bankcard rxA;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drI;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rxA = (Bankcard) this.uT.getParcelable("key_bankcard");
        KC();
    }

    protected final void KC() {
        zi(R.l.flA);
        ((CheckBox) findViewById(R.h.bob)).setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletWXCreditOpenUI sAJ;

            {
                this.sAJ = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.sAJ.liz.setEnabled(z);
            }
        });
        findViewById(R.h.bnV).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenUI sAJ;

            {
                this.sAJ = r1;
            }

            public final void onClick(View view) {
                e.a(this.sAJ, this.sAJ.rxA.field_bankcardType, this.sAJ.rxA.field_bankName, true, false);
            }
        });
        this.liz = (Button) findViewById(R.h.cnY);
        this.liz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenUI sAJ;

            {
                this.sAJ = r1;
            }

            public final void onClick(View view) {
                this.sAJ.bsp();
            }
        });
    }
}
