package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.y.k;

public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView rBm;
    private WalletFormView rJo;
    private String szX;

    static /* synthetic */ boolean a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        if (bg.mA(str)) {
            s.makeText(walletCheckIdentityUI, R.l.feV, 0).show();
            return false;
        } else if (!bg.mA(str2) && str2.length() >= 4 && (!bg.mA(walletCheckIdentityUI.szX) || walletCheckIdentityUI.rBm.Pb())) {
            return true;
        } else {
            s.makeText(walletCheckIdentityUI, R.l.cQb, 0).show();
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.drC;
    }

    public final void KC() {
        zi(R.l.feW);
        this.rJo = (WalletFormView) findViewById(R.h.cmm);
        a.e(this, this.rJo);
        this.rBm = (WalletFormView) findViewById(R.h.bWA);
        a.b(this.rBm);
        d(this.rBm, 1, false);
        CharSequence string = this.uT.getString("key_pre_name");
        this.szX = this.uT.getString("key_pre_indentity");
        if (!bg.mA(string)) {
            this.rJo.oNr.setText(string);
            this.rJo.setHint(getString(R.l.feP));
        }
        if (!bg.mA(this.szX)) {
            this.rBm.oNN = 4;
            this.rBm.oNr.setText(this.szX);
            this.rBm.setHint(getString(R.l.fey));
        }
        findViewById(R.h.cnY).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCheckIdentityUI szY;

            {
                this.szY = r1;
            }

            public final void onClick(View view) {
                if (WalletCheckIdentityUI.a(this.szY, this.szY.rJo.getText(), this.szY.rBm.getText())) {
                    this.szY.ccF().j(new Object[]{r0, r1});
                }
            }
        });
    }

    protected final int Ol() {
        return 1;
    }
}
