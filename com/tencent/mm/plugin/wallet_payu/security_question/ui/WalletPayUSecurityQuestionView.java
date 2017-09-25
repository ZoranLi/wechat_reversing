package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.s.a.d;
import com.tencent.mm.ui.tools.CustomFitTextView;

public class WalletPayUSecurityQuestionView extends LinearLayout {
    private Context mContext;
    private TextView rTj;
    private CustomFitTextView rTk;
    String rTl;

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        CharSequence charSequence;
        super(context, attributeSet);
        this.mContext = context;
        String str = "";
        String str2 = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.n.fpP, -1, 0);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.fqd, 0);
            if (resourceId != 0) {
                str = this.mContext.getString(resourceId);
            }
            resourceId = obtainStyledAttributes.getResourceId(R.n.fpY, 0);
            if (resourceId != 0) {
                str2 = this.mContext.getString(resourceId);
            }
            boolean z2 = obtainStyledAttributes.getBoolean(R.n.fpR, false);
            obtainStyledAttributes.recycle();
            z = z2;
            charSequence = str;
        } else {
            z = false;
            Object obj = str;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dkD, this, true);
        this.rTj = (TextView) inflate.findViewById(R.h.cIJ);
        this.rTk = (CustomFitTextView) inflate.findViewById(R.h.csl);
        this.rTj.setText(charSequence);
        CustomFitTextView customFitTextView = this.rTk;
        customFitTextView.b(str2, customFitTextView.maxLines, customFitTextView.wlX, customFitTextView.wlV, customFitTextView.getResources().getColor(d.aUo));
        if (z) {
            this.rTk.setEnabled(false);
            this.rTk.setTextColor(getResources().getColor(R.e.aWg));
            this.rTk.setFocusable(false);
            this.rTk.setClickable(false);
            this.rTk.setBackgroundResource(R.g.bkS);
            setBackgroundResource(R.g.beo);
            return;
        }
        this.rTk.setEnabled(false);
        this.rTk.setFocusable(false);
        this.rTk.setClickable(false);
        this.rTk.setBackgroundResource(R.g.bkS);
        setBackgroundResource(R.g.bgh);
    }

    public WalletPayUSecurityQuestionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void IA(String str) {
        this.rTl = str;
        KeyListener keyListener = this.rTk.getKeyListener();
        this.rTk.setInputType(1);
        this.rTk.setKeyListener(null);
        this.rTk.c(str, 3, false, -1);
        this.rTk.setKeyListener(keyListener);
    }
}
