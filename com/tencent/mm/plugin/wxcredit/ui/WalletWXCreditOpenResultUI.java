package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

@a(19)
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox sAH;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drH;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        c.vr().set(196658, Boolean.valueOf(true));
        m.btS().rIr = bg.Ny();
        KC();
    }

    protected final void KC() {
        zi(R.l.flx);
        TextView textView = (TextView) findViewById(R.h.cRZ);
        this.sAH = (CheckBox) findViewById(R.h.bqw);
        if (((Bankcard) this.uT.getParcelable("key_bankcard")) != null) {
            this.sAH.setText(getString(R.l.fly, new Object[]{r1.field_bankName}));
            textView.setText(R.l.flz);
        }
        ((Button) findViewById(R.h.cnY)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletWXCreditOpenResultUI sAI;

            {
                this.sAI = r1;
            }

            public final void onClick(View view) {
                this.sAI.btn();
            }
        });
    }

    private void btn() {
        ccF().j(new Object[]{Boolean.valueOf(this.sAH.isChecked())});
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        btn();
        return true;
    }
}
