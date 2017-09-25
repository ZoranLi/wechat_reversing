package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    public OnClickListener lnJ;
    private View mView = null;
    private String mqI;
    private boolean mqM;
    private int ois = Integer.MAX_VALUE;
    private int oit = -1;
    private int oiu = -1;

    public f(Context context) {
        super(context);
        setLayoutResource(R.i.dhV);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.chv);
        ((TextView) view.findViewById(R.h.chw)).setText(getTitle());
        if (this.ois != Integer.MAX_VALUE) {
            textView.setTextColor(this.ois);
        }
        if (!this.mqM) {
            textView.setOnClickListener(null);
            textView.setText(h.b(this.mContext, this.mqI, textView.getTextSize()));
        } else if (this.oit < 0 || this.oiu <= 0) {
            textView.setTextColor(this.mContext.getResources().getColor(R.e.aUU));
            textView.setOnClickListener(this.lnJ);
            textView.setText(h.b(this.mContext, this.mqI, textView.getTextSize()));
        } else {
            a aVar = new a(this.mContext);
            CharSequence spannableString = new SpannableString(this.mqI);
            aVar.oiL = new a.a(this) {
                final /* synthetic */ f oiv;

                {
                    this.oiv = r1;
                }

                public final void onClick(View view) {
                    if (this.oiv.lnJ != null) {
                        this.oiv.lnJ.onClick(view);
                    }
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(aVar, this.oit, this.oiu, 33);
            textView.setText(spannableString);
        }
    }

    public final void Ct(String str) {
        try {
            this.ois = Color.parseColor(str);
        } catch (Exception e) {
            this.ois = Integer.MAX_VALUE;
        }
    }

    public final void setContent(String str) {
        this.mqI = str;
        this.mqM = false;
    }

    public final void a(String str, int i, int i2, OnClickListener onClickListener) {
        this.mqI = str;
        this.mqM = true;
        this.oit = i;
        this.oiu = i2;
        this.lnJ = onClickListener;
    }
}
