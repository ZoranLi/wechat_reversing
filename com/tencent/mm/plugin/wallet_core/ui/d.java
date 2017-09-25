package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.ui.f.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    public View kHP;
    public OnClickListener lnJ;
    private View mView = null;
    public String mqI;
    public boolean mqM;
    private int ois = Integer.MAX_VALUE;
    private int oit = -1;
    private int oiu = -1;

    public d(Context context) {
        super(context, null);
        setLayoutResource(R.i.dgz);
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
        TextView textView = (TextView) view.findViewById(R.h.cLo);
        ((TextView) view.findViewById(R.h.caa)).setText(getTitle());
        this.kHP = view;
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
            f fVar = new f(this.mContext);
            CharSequence spannableString = new SpannableString(this.mqI);
            fVar.rKS = new a(this) {
                final /* synthetic */ d rJm;

                {
                    this.rJm = r1;
                }

                public final void onClick(View view) {
                    if (this.rJm.lnJ != null) {
                        this.rJm.lnJ.onClick(view);
                    }
                }
            };
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(fVar, this.oit, this.oiu, 33);
            textView.setText(spannableString);
        }
    }
}
