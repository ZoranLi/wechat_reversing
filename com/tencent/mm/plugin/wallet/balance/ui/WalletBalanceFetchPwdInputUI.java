package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.plugin.wallet_core.ui.l.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;

@a(3)
public class WalletBalanceFetchPwdInputUI extends WalletBaseUI {
    private String mTitle = "";
    private String rug = "";
    private l ruh;

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        re(4);
        this.mTitle = this.uT.getString("key_pwd_cash_title");
        this.rug = this.uT.getString("key_pwd_cash_money");
        w.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", new Object[]{bg.mz(this.rug), bg.mz(this.mTitle)});
        if (bg.mA(this.mTitle) || bg.mA(this.rug)) {
            i = 0;
        }
        if (i == 0) {
            g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI rui;

                {
                    this.rui = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rui.finish();
                }
            });
        } else {
            showDialog();
        }
    }

    private void showDialog() {
        if (this.ruh != null && this.ruh.isShowing()) {
            this.ruh.dismiss();
        }
        String str = "";
        if (((Orders) this.uT.getParcelable("key_orders")).oQs > 0.0d) {
            str = getResources().getString(R.l.fdg, new Object[]{e.d(r0.oQs, r0.oga)});
        }
        if (this.ruh == null) {
            this.ruh = l.a(this, this.mTitle, this.rug, str, new c(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI rui;

                {
                    this.rui = r1;
                }

                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    this.rui.ruh.dismiss();
                    if (this.rui.ccE() != null) {
                        this.rui.ccF().j(str);
                    }
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI rui;

                {
                    this.rui = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    w.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: dialog cancel. finish");
                    this.rui.ruh.dismiss();
                    this.rui.finish();
                }
            }, new l.a(this) {
                final /* synthetic */ WalletBalanceFetchPwdInputUI rui;

                {
                    this.rui = r1;
                }

                public final void aQt() {
                    w.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: pwd cancel.finish");
                    this.rui.ruh.dismiss();
                    this.rui.finish();
                }
            });
            return;
        }
        this.ruh.aWw();
        this.ruh.show();
    }

    public final void qU(int i) {
        if (i == 0) {
            finish();
        } else if (i == 1) {
            showDialog();
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return -1;
    }
}
