package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;

public class WalletLqtSaveFetchFinishUI extends WalletBaseUI {
    private TextView rvF;
    private WalletTextView rvG;
    private Button rvH;
    private TextView rvI;
    private TextView rvJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.rvF = (TextView) findViewById(R.h.cGJ);
        this.rvG = (WalletTextView) findViewById(R.h.boE);
        this.rvH = (Button) findViewById(R.h.bQa);
        this.rvI = (TextView) findViewById(R.h.ctn);
        this.rvJ = (TextView) findViewById(R.h.cKR);
        int intExtra = getIntent().getIntExtra("key_mode", 1);
        double doubleExtra = getIntent().getDoubleExtra("key_amount", 0.0d);
        CharSequence stringExtra = getIntent().getStringExtra("profile_date_wording");
        CharSequence stringExtra2 = getIntent().getStringExtra("profile_upgrade_wording");
        if (intExtra == 1) {
            this.rvF.setText(getString(R.l.fgH));
            qP(getString(R.l.fgH));
        } else if (intExtra == 2) {
            this.rvF.setText(getString(R.l.fgy));
            qP(getString(R.l.fgy));
        }
        this.rvG.setText(e.n(doubleExtra));
        this.rvH.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletLqtSaveFetchFinishUI rvK;

            {
                this.rvK = r1;
            }

            public final void onClick(View view) {
                this.rvK.finish();
            }
        });
        if (!bg.mA(stringExtra)) {
            this.rvI.setText(stringExtra);
            this.rvI.setVisibility(0);
        }
        if (!bg.mA(stringExtra2)) {
            this.rvJ.setText(h.f(this, stringExtra2, (int) this.rvJ.getTextSize()));
            this.rvJ.setClickable(true);
            this.rvJ.setOnTouchListener(new k());
            this.rvJ.setVisibility(0);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dqK;
    }

    protected final int Ol() {
        return 1;
    }
}
