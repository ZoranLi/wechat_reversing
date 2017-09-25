package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tencent.mm.y.k;

@a(3)
public class WalletIdCardCheckUI extends WalletBaseUI implements OnEditorActionListener, WalletFormView.a {
    private WalletFormView rBm;
    private TextView rBn;
    private TextView rBo;
    private Button rBp;
    private int rBq = 1;

    static /* synthetic */ boolean a(WalletIdCardCheckUI walletIdCardCheckUI) {
        boolean z = true;
        if (!walletIdCardCheckUI.rBm.dF(walletIdCardCheckUI.rBo)) {
            walletIdCardCheckUI.rBo.setText(R.l.cQb);
            walletIdCardCheckUI.rBo.setTextColor(walletIdCardCheckUI.getResources().getColor(R.e.aVD));
            z = false;
        }
        if (z) {
            walletIdCardCheckUI.rBo.setVisibility(4);
        } else {
            walletIdCardCheckUI.rBo.setVisibility(0);
        }
        return z;
    }

    protected final int getLayoutId() {
        return R.i.dqt;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.fhM);
        hn(1580);
        KC();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletIdCardCheckUI rBr;

            {
                this.rBr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
                this.rBr.finish();
                return false;
            }
        });
    }

    protected final void aHT() {
        w.d("Micromsg.WalletIdCardCheckUI", "check pwd ");
        this.wFr.aHT();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        ho(1580);
    }

    protected final void KC() {
        String I;
        this.rBm = (WalletFormView) findViewById(R.h.bWA);
        this.rBo = (TextView) findViewById(R.h.cQb);
        this.rBn = (TextView) findViewById(R.h.cQc);
        this.rBm.wFY = this;
        this.rBm.setOnEditorActionListener(this);
        this.rBo.setVisibility(4);
        this.rBp = (Button) findViewById(R.h.bXQ);
        com.tencent.mm.wallet_core.ui.formview.a.c(this.rBm);
        d(this.rBm, 1, false);
        this.rBp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletIdCardCheckUI rBr;

            {
                this.rBr = r1;
            }

            public final void onClick(View view) {
                if (WalletIdCardCheckUI.a(this.rBr)) {
                    g.oUh.i(13731, new Object[]{Integer.valueOf(2)});
                    this.rBr.k(new f(this.rBr.rBm.getText(), this.rBr.rBq, m.btS().akr()));
                }
            }
        });
        this.rBq = m.btS().bus();
        af btS = m.btS();
        String str = btS.rIk != null ? btS.rIk.field_cre_name : "";
        w.i("Micromsg.WalletIdCardCheckUI", "mIdentityType %d %s", new Object[]{Integer.valueOf(this.rBq), str});
        if (bg.mA(str)) {
            I = m.bua().I(this, this.rBq);
        } else {
            I = str;
        }
        WalletFormView walletFormView = this.rBm;
        int i = this.rBq;
        b bVar = walletFormView.wGa;
        if (bVar instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) bVar).CN(i);
        }
        this.rBm.tC(I);
        this.rBm.aWw();
        if (this.rBq == 1) {
            d(this.rBm, 1, false);
        } else {
            d(this.rBm, 1, true);
        }
        str = m.btS().akr();
        this.rBm.setHint(getString(R.l.fhK, new Object[]{e.UM(str)}));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.npM == null || !this.npM.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.npM.setVisibility(8);
        return true;
    }

    protected final int Ol() {
        return 1;
    }

    public final boolean i(int i, int i2, String str, k kVar) {
        w.d("Micromsg.WalletIdCardCheckUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0 && (kVar instanceof f)) {
            com.tencent.mm.ui.base.g.a(this, getString(R.l.fhL), "", getString(R.l.dAN), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletIdCardCheckUI rBr;

                {
                    this.rBr = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.rBr.setResult(-1);
                    this.rBr.finish();
                }
            });
        }
        return true;
    }

    public final void gA(boolean z) {
        this.rBo.setVisibility(4);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
