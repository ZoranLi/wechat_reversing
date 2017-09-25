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
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.WebView;
import com.tenpay.android.wechat.TenpaySecureEditText;

public class LuckyMoneyNumInputView extends LinearLayout implements b {
    private TextWatcher acO = new TextWatcher(this) {
        final /* synthetic */ LuckyMoneyNumInputView ntP;

        {
            this.ntP = r1;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.ntP.nsC != null) {
                f a = this.ntP.nsC;
                this.ntP.getId();
                a.aIh();
            }
        }
    };
    private TextView jhl;
    public f nsC;
    TenpaySecureEditText ntK;
    private TextView ntL;
    private int ntM = 1;
    private int ntN = Integer.MAX_VALUE;
    public int ntO = 1;

    public LuckyMoneyNumInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dhs, this, true);
        this.jhl = (TextView) inflate.findViewById(R.h.cfI);
        this.ntK = (TenpaySecureEditText) inflate.findViewById(R.h.cen);
        this.ntL = (TextView) inflate.findViewById(R.h.cfJ);
        this.ntK.setText(this.ntM);
        this.ntK.addTextChangedListener(this.acO);
    }

    public final void pa(int i) {
        int i2 = 3;
        this.ntN = i;
        int i3 = 0;
        while (i > 0) {
            i3++;
            i /= 10;
        }
        if (i3 > 3) {
            i2 = i3;
        }
        this.ntK.setFilters(new InputFilter[]{new LengthFilter(i2)});
    }

    public final int aIH() {
        return bg.getInt(this.ntK.getText().toString(), 0);
    }

    public final void zQ(String str) {
        this.ntK.setText(str);
        this.ntK.setSelection(this.ntK.getText().length());
        this.ntM = bg.getInt(str, 0);
    }

    public final int aIz() {
        if (bg.mA(this.ntK.getText().toString())) {
            return 0;
        }
        int i = bg.getInt(this.ntK.getText().toString(), -1);
        if (i < 0) {
            return 3;
        }
        if (i > this.ntN && this.ntN > 0) {
            return 1;
        }
        if (i >= this.ntO || this.ntO <= 0) {
            return 0;
        }
        return 2;
    }

    public final void restore() {
        this.jhl.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ntK.setTextColor(WebView.NIGHT_MODE_COLOR);
        this.ntL.setTextColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void onError() {
        this.jhl.setTextColor(n.cw(getContext()));
        this.ntK.setTextColor(n.cw(getContext()));
        this.ntL.setTextColor(n.cw(getContext()));
    }

    public final String oY(int i) {
        if (i == 1) {
            return getContext().getString(R.l.exY, new Object[]{Integer.valueOf(this.ntN)});
        } else if (i != 2) {
            return null;
        } else {
            return getContext().getString(R.l.exX, new Object[]{Integer.valueOf(this.ntO)});
        }
    }
}
