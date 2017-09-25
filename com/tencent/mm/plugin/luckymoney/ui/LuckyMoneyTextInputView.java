package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMEditText;

public class LuckyMoneyTextInputView extends LinearLayout implements b {
    private TextView jhl;
    public f nsC;
    private MMEditText nuF;

    public LuckyMoneyTextInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dhw, this, true);
        this.nuF = (MMEditText) inflate.findViewById(R.h.cgs);
        this.jhl = (TextView) inflate.findViewById(R.h.cgt);
        this.nuF.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ LuckyMoneyTextInputView nuG;

            {
                this.nuG = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (this.nuG.nsC != null) {
                    f a = this.nuG.nsC;
                    this.nuG.getId();
                    a.aIh();
                }
            }
        });
    }

    public final String getInput() {
        return this.nuF.getText().toString();
    }

    public final void zR(String str) {
        this.nuF.setHint(str);
    }

    public final int aIz() {
        return 0;
    }

    public final void restore() {
    }

    public final void onError() {
    }

    public final String oY(int i) {
        return null;
    }
}
