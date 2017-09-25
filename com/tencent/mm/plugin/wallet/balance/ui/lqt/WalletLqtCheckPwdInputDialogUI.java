package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
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
public class WalletLqtCheckPwdInputDialogUI extends WalletBaseUI {
    private String mTitle = "";
    private String rug = "";
    private l ruh;

    public void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        re(4);
        this.mTitle = getIntent().getStringExtra("lqt_fetch_pwd_title");
        this.rug = getIntent().getStringExtra("lqt_fetch_pwd_money");
        w.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: money : %s, title : %s", new Object[]{bg.mz(this.rug), bg.mz(this.mTitle)});
        if (bg.mA(this.mTitle) || bg.mA(this.rug)) {
            i = 0;
        }
        if (i == 0) {
            g.a(this.uSU.uTo, R.l.fgY, 0, new OnClickListener(this) {
                final /* synthetic */ WalletLqtCheckPwdInputDialogUI rvd;

                {
                    this.rvd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rvd.finish();
                }
            });
            return;
        }
        getWindow().setBackgroundDrawableResource(R.e.transparent);
        showDialog();
    }

    private void showDialog() {
        if (this.ruh != null && this.ruh.isShowing()) {
            this.ruh.dismiss();
        }
        if (this.ruh == null) {
            this.rug = e.o(bg.getDouble(this.rug, 0.0d));
            this.ruh = l.a(this, this.mTitle, this.rug, "", new c(this) {
                final /* synthetic */ WalletLqtCheckPwdInputDialogUI rvd;

                {
                    this.rvd = r1;
                }

                public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
                    this.rvd.ruh.dismiss();
                    Intent intent = new Intent();
                    intent.putExtra("lqt_fetch_enc_pwd", str);
                    this.rvd.setResult(-1, intent);
                    this.rvd.finish();
                }
            }, new OnCancelListener(this) {
                final /* synthetic */ WalletLqtCheckPwdInputDialogUI rvd;

                {
                    this.rvd = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    w.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
                    this.rvd.ruh.dismiss();
                    this.rvd.finish();
                }
            }, new l.a(this) {
                final /* synthetic */ WalletLqtCheckPwdInputDialogUI rvd;

                {
                    this.rvd = r1;
                }

                public final void aQt() {
                    w.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: pwd cancel.finish");
                    this.rvd.ruh.dismiss();
                    this.rvd.finish();
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
