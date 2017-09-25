package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;

public class CheckPreference extends Preference {
    private TextView rBG;
    private int rBH;
    private String rBI;
    private int rBJ;
    public boolean vqm;
    private CheckBox vqo;
    public int vqp;

    public CheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vqm = false;
        this.rBH = -1;
        this.rBI = "";
        this.rBJ = 8;
        this.vqp = -1;
        setLayoutResource(h.heA);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.vqo = (CheckBox) view.findViewById(g.checkbox);
        this.vqo.setChecked(this.vqm);
        this.rBG = (TextView) view.findViewById(g.cIM);
        String str = this.rBI;
        int i = this.rBH;
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
        this.rBJ = this.rBJ;
        if (this.rBG != null) {
            this.rBG.setVisibility(this.rBJ);
        }
        LayoutParams layoutParams = (LayoutParams) this.vqo.getLayoutParams();
        if (-1 != this.vqp) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, this.vqp, layoutParams.bottomMargin);
        }
    }
}
