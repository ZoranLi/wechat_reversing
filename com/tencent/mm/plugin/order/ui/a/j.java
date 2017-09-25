package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public final class j extends Preference {
    OnClickListener mOnClickListener = null;
    private View mView = null;
    List<HelpCenter> ofA = new LinkedList();
    String oiJ;
    OnClickListener oiK = null;

    public j(Context context) {
        super(context);
        setLayoutResource(R.i.dic);
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
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.chF);
        linearLayout.removeAllViews();
        if (this.ofA != null) {
            int size;
            int i;
            View view2;
            if (bg.mA(this.oiJ) || this.oiK == null) {
                size = this.ofA.size() - 1;
            } else {
                size = this.ofA.size();
            }
            if (size == 0) {
                i = -1;
            } else {
                i = size;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.ofA.size(); i3++) {
                HelpCenter helpCenter = (HelpCenter) this.ofA.get(i3);
                View textView = new TextView(this.mContext);
                textView.setTextColor(this.mContext.getResources().getColor(R.e.black));
                textView.setTextSize(0, (float) a.T(this.mContext, R.f.aXI));
                textView.setIncludeFontPadding(false);
                textView.setText(helpCenter.name);
                textView.setTag(helpCenter);
                textView.setGravity(17);
                textView.setOnClickListener(this.mOnClickListener);
                if (i2 == i) {
                    textView.setTextColor(this.mContext.getResources().getColor(R.e.aUd));
                }
                linearLayout.addView(textView, new LayoutParams(0, -2, 1.0f));
                if (i2 < i) {
                    view2 = new View(this.mContext);
                    view2.setBackgroundColor(this.mContext.getResources().getColor(R.e.aVQ));
                    linearLayout.addView(view2, new LayoutParams(a.T(this.mContext, R.f.aWY), -1));
                }
                i2++;
            }
            if (!bg.mA(this.oiJ) && this.oiK != null) {
                view2 = new TextView(this.mContext);
                view2.setTextColor(this.mContext.getResources().getColor(R.e.black));
                view2.setTextSize(0, (float) a.T(this.mContext, R.f.aXI));
                view2.setIncludeFontPadding(false);
                view2.setText(this.oiJ);
                view2.setGravity(17);
                view2.setOnClickListener(this.oiK);
                if (i2 == i) {
                    view2.setTextColor(this.mContext.getResources().getColor(R.e.aUd));
                }
                linearLayout.addView(view2, new LayoutParams(0, -2, 1.0f));
            }
        }
    }
}
