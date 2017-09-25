package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public final class g extends Preference {
    static int oiw;
    static float oix = 16.0f;
    public f jid;
    private View mView = null;
    TruncateAt oiA;
    boolean oiB = false;
    String oiy;
    public String[] oiz;

    public g(Context context) {
        super(context);
        setLayoutResource(R.i.dhW);
        oiw = context.getResources().getColor(R.e.aUX);
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
        final TextView textView = (TextView) view.findViewById(R.h.chz);
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.chy);
        ((TextView) view.findViewById(R.h.chA)).setText(getTitle());
        if (this.oiz == null || this.oiz.length <= 1) {
            textView.setTextColor(oiw);
        } else {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ g oiE;

                public final void onClick(View view) {
                    textView.setVisibility(8);
                    for (CharSequence charSequence : this.oiE.oiz) {
                        Preference preference = this.oiE;
                        View textView = new TextView(preference.mContext);
                        textView.setText(charSequence);
                        textView.setTextSize(g.oix);
                        textView.setTextColor(g.oiw);
                        if (preference.oiB) {
                            textView.setSingleLine(true);
                            textView.setEllipsize(preference.oiA);
                        } else {
                            textView.setSingleLine(false);
                        }
                        linearLayout.addView(textView, new LayoutParams(-2, -2));
                    }
                    textView.setOnClickListener(null);
                    if (this.oiE.jid != null) {
                        this.oiE.jid.notifyDataSetChanged();
                    }
                }
            });
        }
        textView.setText(this.oiy);
    }

    public final void a(String[] strArr, TruncateAt truncateAt) {
        this.oiz = strArr;
        this.oiA = truncateAt;
        this.oiB = true;
    }
}
