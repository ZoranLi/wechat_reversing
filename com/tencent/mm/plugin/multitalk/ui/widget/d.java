package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d implements OnClickListener {
    private Context context;
    private View mdr;
    private int nQX = b.nQX;
    private int nRd = b.nRd;
    private LinearLayout nRp;
    public LinearLayout nRq;
    public LinearLayout nRr;
    private int nRs;
    private int nRt;
    private int nRu = (b.nQX + b.nQW);
    private int nRv = ((b.nQX * 2) + b.nQW);
    private int nRw = (b.nQX * 4);
    public int nRx;
    public int size = 0;

    public d(Activity activity) {
        this.context = activity.getBaseContext();
        int dO = a.dO(this.context) - (this.nRw * 2);
        this.nRs = (dO - (this.nRu * 10)) / 5;
        this.nRt = (dO - (this.nRv * 10)) / 5;
        dO = (this.nRt * 2) + (this.nQX * 12);
        this.mdr = activity.findViewById(R.h.cqD);
        this.mdr.getLayoutParams().height = dO;
        this.nRp = (LinearLayout) activity.findViewById(R.h.bqJ);
        LayoutParams layoutParams = (LayoutParams) this.nRp.getLayoutParams();
        layoutParams.topMargin = this.nQX * 2;
        layoutParams.bottomMargin = this.nQX * 2;
        layoutParams.leftMargin = this.nRw;
        layoutParams.rightMargin = this.nRw;
        this.nRp.setLayoutParams(layoutParams);
        this.nRq = new LinearLayout(this.context);
        this.nRr = new LinearLayout(this.context);
        this.nRq.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.nRr.setLayoutParams(layoutParams2);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        View relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.nRr);
        relativeLayout.setLayoutParams(layoutParams2);
        this.nRp.addView(this.nRq);
        this.nRp.addView(relativeLayout);
    }

    public final void setVisible(boolean z) {
        if (z) {
            this.mdr.setVisibility(0);
        } else {
            this.mdr.setVisibility(8);
        }
    }

    public final void Bn(String str) {
        this.size++;
        View imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        b.a(imageView, str, 0.1f, false);
        if (this.size <= 5) {
            this.nRq.addView(imageView);
        } else {
            this.nRr.addView(imageView);
        }
        pW(this.size);
        pX(this.size);
    }

    public final void pW(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.nRq.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.nRr.getLayoutParams();
        if (i <= 5) {
            layoutParams.height = this.nRs;
            this.nRr.setVisibility(8);
            return;
        }
        layoutParams.height = this.nRt;
        layoutParams.topMargin = this.nQX * 2;
        layoutParams.bottomMargin = this.nQX * 2;
        this.nRr.setVisibility(0);
        layoutParams2.height = this.nRt;
        layoutParams2.topMargin = this.nQX * 2;
        layoutParams2.bottomMargin = this.nQX * 2;
    }

    public final void pX(int i) {
        int i2 = 0;
        int i3;
        LinearLayout.LayoutParams layoutParams;
        if (i <= 5) {
            for (i3 = 0; i3 < this.nRq.getChildCount(); i3++) {
                layoutParams = (LinearLayout.LayoutParams) this.nRq.getChildAt(i3).getLayoutParams();
                layoutParams.width = this.nRs;
                layoutParams.height = this.nRs;
                layoutParams.rightMargin = this.nRu;
                layoutParams.leftMargin = this.nRu;
            }
            while (i2 < this.nRr.getChildCount()) {
                layoutParams = (LinearLayout.LayoutParams) this.nRr.getChildAt(i2).getLayoutParams();
                layoutParams.width = this.nRt;
                layoutParams.height = this.nRt;
                layoutParams.rightMargin = this.nRu;
                layoutParams.leftMargin = this.nRu;
                i2++;
            }
            return;
        }
        for (i3 = 0; i3 < this.nRq.getChildCount(); i3++) {
            layoutParams = (LinearLayout.LayoutParams) this.nRq.getChildAt(i3).getLayoutParams();
            layoutParams.width = this.nRt;
            layoutParams.height = this.nRt;
            layoutParams.rightMargin = this.nRv;
            layoutParams.leftMargin = this.nRv;
        }
        while (i2 < this.nRr.getChildCount()) {
            layoutParams = (LinearLayout.LayoutParams) this.nRr.getChildAt(i2).getLayoutParams();
            layoutParams.width = this.nRt;
            layoutParams.height = this.nRt;
            layoutParams.rightMargin = this.nRv;
            layoutParams.leftMargin = this.nRv;
            i2++;
        }
    }

    public final void onClick(View view) {
        this.nRx++;
    }
}
