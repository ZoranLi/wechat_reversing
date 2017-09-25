package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

public class CheckBoxPreference extends Preference {
    private TextView rBG;
    private int rBH;
    private String rBI;
    private int rBJ;
    private MMSwitchBtn std;
    public boolean vqm;

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vqm = false;
        this.rBH = -1;
        this.rBI = "";
        this.rBJ = 8;
        setLayoutResource(h.heB);
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.std = (MMSwitchBtn) view.findViewById(g.checkbox);
        this.std.wwD = new a(this) {
            final /* synthetic */ CheckBoxPreference vqn;

            {
                this.vqn = r1;
            }

            public final void bK(boolean z) {
                this.vqn.callChangeListener(Boolean.valueOf(z));
            }
        };
        this.std.lS(this.vqm);
        if (!isEnabled()) {
            this.std.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(d.aSV));
        }
        this.rBG = (TextView) view.findViewById(g.cIM);
        bW(this.rBI, this.rBH);
        vv(this.rBJ);
    }

    public final boolean isChecked() {
        if (this.std != null) {
            return this.std.wwz;
        }
        return this.vqm;
    }

    public final void kX(boolean z) {
        if (this.std != null) {
            this.vqm = z;
            this.std.lS(z);
        }
    }

    public void bW(String str, int i) {
        this.rBH = i;
        this.rBI = str;
        if (this.rBG != null) {
            if (i > 0) {
                this.rBG.setBackgroundResource(this.rBH);
            }
            if (!TextUtils.isEmpty(this.rBI)) {
                this.rBG.setText(this.rBI);
            }
        }
    }

    public void vv(int i) {
        this.rBJ = i;
        if (this.rBG != null) {
            this.rBG.setVisibility(this.rBJ);
        }
    }
}
