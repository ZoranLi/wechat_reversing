package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.a.a;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyMoneyInputView extends LinearLayout implements b {
    private TextWatcher acO = new TextWatcher(this) {
        final /* synthetic */ LuckyMoneyMoneyInputView nsF;

        {
            this.nsF = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.nsF.nsC != null) {
                f a = this.nsF.nsC;
                this.nsF.getId();
                a.aIh();
            }
        }
    };
    private TextView jhl;
    public int mType;
    private c nmd;
    private TextView nsA;
    private TextView nsB;
    public f nsC;
    public double nsD;
    public double nsE;
    TenpaySecureEditText nsz;

    public LuckyMoneyMoneyInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a.aHG();
        this.nmd = a.aHH().aHS();
        View inflate = LayoutInflater.from(context).inflate(R.i.dhl, this, true);
        this.nsz = (TenpaySecureEditText) inflate.findViewById(R.h.cen);
        this.nsz.addTextChangedListener(this.acO);
        this.jhl = (TextView) inflate.findViewById(R.h.ceK);
        this.nsB = (TextView) inflate.findViewById(R.h.ceJ);
        this.nsA = (TextView) inflate.findViewById(R.h.cdq);
    }

    public final double aIA() {
        return bg.getDouble(this.nsz.getText().toString(), 0.0d);
    }

    public final void setTitle(String str) {
        this.jhl.setText(str);
    }

    public final void fx(boolean z) {
        if (z) {
            this.nsB.setVisibility(0);
        } else {
            this.nsB.setVisibility(8);
        }
    }

    public final void aIB() {
        this.nsz.setFilters(new InputFilter[]{new LengthFilter(12)});
    }

    public final void zP(String str) {
        this.nsz.setText(str);
    }

    public final int aIz() {
        if (bg.mA(this.nsz.getText().toString())) {
            return 0;
        }
        double d = bg.getDouble(this.nsz.getText().toString(), -1.0d);
        if (d < 0.0d) {
            return 3;
        }
        if (d > this.nsD && this.nsD > 0.0d) {
            return 1;
        }
        if (d >= this.nsE || d <= 0.0d) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.jhl.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nsz.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.nsA.setTextColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void onError() {
        this.jhl.setTextColor(n.cw(getContext()));
        this.nsz.setTextColor(n.cw(getContext()));
        this.nsA.setTextColor(n.cw(getContext()));
    }

    public final String oY(int i) {
        a.aHG();
        this.nmd = a.aHH().aHS();
        if (i == 1) {
            if (this.mType == 1) {
                return getContext().getString(R.l.eyz, new Object[]{Math.round(this.nsD), bg.ap(this.nmd.nmc, "")});
            }
            return getContext().getString(R.l.exf, new Object[]{Math.round(this.nsD), bg.ap(this.nmd.nmc, "")});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(R.l.exg, new Object[]{e.n(this.nsE), bg.ap(this.nmd.nmc, "")});
        }
    }
}
