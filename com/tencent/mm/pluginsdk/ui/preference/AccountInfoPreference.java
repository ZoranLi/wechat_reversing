package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.s;

public class AccountInfoPreference extends Preference {
    public SpannableString sRN;
    public String sRO;
    private int sRP;
    public OnClickListener sRQ;
    public String userName;

    public AccountInfoPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccountInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sRQ = null;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.h.bqM);
        if (!(this.userName == null || imageView == null)) {
            b.a(imageView, this.userName);
        }
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) view.findViewById(R.h.cod);
        if (!(this.userName == null || noMeasuredTextView == null)) {
            noMeasuredTextView.voV = true;
            noMeasuredTextView.H((float) a.T(this.mContext, R.f.aXI));
            noMeasuredTextView.setTextColor(a.S(this.mContext, R.e.aVo));
            noMeasuredTextView.setText(this.sRN == null ? this.userName : this.sRN);
        }
        TextView textView = (TextView) view.findViewById(R.h.cLh);
        if (this.sRO != null && textView != null) {
            textView.setText(view.getResources().getString(R.l.dDi, new Object[]{this.sRO}));
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        textView = (TextView) view.findViewById(R.h.cyV);
        if (textView != null) {
            if (this.sRP > 99) {
                textView.setText(this.mContext.getString(R.l.fkz));
                textView.setBackgroundResource(s.fg(this.mContext));
                textView.setVisibility(0);
            } else if (this.sRP > 0) {
                textView.setText(this.sRP);
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        if (this.sRQ != null) {
            ((ImageView) view.findViewById(R.h.bmO)).setOnClickListener(this.sRQ);
        }
    }
}
