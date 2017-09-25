package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;

public class CheckBoxWithTipIconPreference extends CheckBoxPreference {
    private TextView rBG;
    private int rBH;
    private String rBI;
    private int rBJ;

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxWithTipIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rBH = -1;
        this.rBI = "";
        this.rBJ = 8;
        setLayoutResource(R.i.djo);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.rBG = (TextView) view.findViewById(R.h.cIM);
        bW(this.rBI, this.rBH);
        vv(this.rBJ);
    }

    public final void bW(String str, int i) {
        this.rBH = i;
        this.rBI = str;
        if (this.rBG != null) {
            if (this.rBH > 0) {
                this.rBG.setBackgroundResource(this.rBH);
            }
            if (!TextUtils.isEmpty(this.rBI)) {
                this.rBG.setText(this.rBI);
            }
        }
    }

    public final void vv(int i) {
        this.rBJ = i;
        if (this.rBG != null) {
            this.rBG.setVisibility(i);
        }
    }
}
