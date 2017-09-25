package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;

public class HelperHeaderPreference extends Preference {
    private a sSm = new a();

    public static class a {
        public String fSf;
        public String gMX;
        public String sSn;
        public int status;
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HelperHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onBindView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.h.bqM);
        TextView textView = (TextView) view.findViewById(R.h.cGB);
        TextView textView2 = (TextView) view.findViewById(R.h.cof);
        TextView textView3 = (TextView) view.findViewById(R.h.bWl);
        if (imageView != null) {
            b.a(imageView, this.sSm.fSf);
        }
        if (textView != null) {
            switch (this.sSm.status) {
                case 0:
                    textView.setVisibility(0);
                    textView.setTextColor(r.ff(this.mContext));
                    textView.setText(R.l.eTJ);
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.g.bkl, 0, 0, 0);
                    break;
                case 1:
                    textView.setVisibility(0);
                    textView.setTextColor(r.fe(this.mContext));
                    textView.setText(R.l.eTC);
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.g.bkm, 0, 0, 0);
                    break;
                case 2:
                    textView.setVisibility(8);
                    break;
            }
        }
        if (textView2 != null) {
            textView2.setText(this.sSm.gMX);
        }
        if (textView3 != null) {
            textView3.setText(this.sSm.sSn);
        }
        super.onBindView(view);
    }

    public final void Y(String str, String str2, String str3) {
        this.sSm.fSf = str;
        this.sSm.gMX = str2;
        this.sSm.sSn = str3;
        super.callChangeListener(null);
    }

    public final void kg(int i) {
        this.sSm.status = i;
        super.callChangeListener(null);
    }
}
