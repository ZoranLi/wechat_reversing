package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.MMFormMobileInputView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import java.util.ArrayList;

@a(3)
public class WalletPayUStartOpenUI extends WalletBaseUI {
    private String ota;
    private EditText rRA;
    private Button rRB;
    private TextView rRC;
    private TextView rRD;
    private String rRE;
    private WalletPayUOpenIntroView rRx;
    private MMFormMobileInputView rRy;
    private EditText rRz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ota = this.uT.getString("key_mobile");
        this.rRE = this.uT.getString("dial_code");
        if (bg.mA(this.rRE)) {
            this.rRE = "27";
        }
        this.rRx = (WalletPayUOpenIntroView) findViewById(R.h.bXT);
        WalletPayUOpenIntroView walletPayUOpenIntroView = this.rRx;
        walletPayUOpenIntroView.rRv = new d[]{new d(R.g.bim, R.l.fiZ, R.l.fiU), new d(R.g.bin, R.l.fja, R.l.fiV), new d(R.g.bio, R.l.fjb, R.l.fiW)};
        walletPayUOpenIntroView.adA = new ArrayList();
        if (walletPayUOpenIntroView.rRv != null) {
            for (int i = 0; i < walletPayUOpenIntroView.rRv.length; i++) {
                walletPayUOpenIntroView.adA.add(LayoutInflater.from(walletPayUOpenIntroView.mContext).inflate(R.i.dkC, null));
            }
        }
        walletPayUOpenIntroView.rRu = new a(walletPayUOpenIntroView);
        walletPayUOpenIntroView.rRs.a(walletPayUOpenIntroView.rRu);
        walletPayUOpenIntroView.rRt.dY(walletPayUOpenIntroView.rRv == null ? 0 : walletPayUOpenIntroView.rRv.length, 0);
        this.rRy = (MMFormMobileInputView) findViewById(R.h.cGl);
        this.rRB = (Button) findViewById(R.h.cGi);
        this.rRz = this.rRy.vjq;
        this.rRA = this.rRy.vjr;
        if (!bg.mA(this.ota)) {
            this.rRA.setText(this.ota);
        }
        if (!bg.mA(this.rRE)) {
            this.rRz.setText(this.rRE);
        }
        TextWatcher anonymousClass1 = new TextWatcher(this) {
            final /* synthetic */ WalletPayUStartOpenUI rRF;

            {
                this.rRF = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.rRF.bvB();
            }
        };
        this.rRA.addTextChangedListener(anonymousClass1);
        this.rRz.addTextChangedListener(anonymousClass1);
        this.rRB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletPayUStartOpenUI rRF;

            {
                this.rRF = r1;
            }

            public final void onClick(View view) {
                if (this.rRF.rRy.getVisibility() == 0) {
                    this.rRF.uT.putString("key_mobile", this.rRF.ota);
                    this.rRF.uT.putString("dial_code", this.rRF.rRE);
                }
                this.rRF.ccF().j(new Object[0]);
            }
        });
        this.rRC = (TextView) findViewById(R.h.cGk);
        c.a(this, this.rRC);
        this.rRD = (TextView) findViewById(R.h.cGm);
        this.rRD.setText(s.ccm());
    }

    public void onResume() {
        super.onResume();
        bvB();
    }

    private String bsE() {
        return this.rRy.getCountryCode().startsWith("+") ? this.rRy.getCountryCode().substring(1) : this.rRy.getCountryCode();
    }

    private void bvB() {
        if (this.rRy.getVisibility() == 0) {
            boolean z = (bg.mA(bsE()) || bg.mA(this.rRA.getText().toString())) ? false : true;
            if (z) {
                this.rRE = bsE();
                MMFormMobileInputView mMFormMobileInputView = this.rRy;
                this.ota = mMFormMobileInputView.vjr != null ? an.PB(mMFormMobileInputView.vjr.getText().toString()) : "";
                this.rRB.setEnabled(true);
                return;
            }
            this.rRB.setEnabled(false);
        }
    }

    protected final boolean bsP() {
        return true;
    }

    protected final int getLayoutId() {
        return R.i.dkA;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }
}
