package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public final class h extends LinearLayout {
    private Context context;
    private int jUX = 0;
    public int qpW = 6;
    private LinearLayout qpX;

    public h(Context context) {
        super(context);
        this.context = context;
        setOrientation(1);
    }

    public final void addView(View view) {
        if (this.jUX % this.qpW == 0) {
            this.qpX = new LinearLayout(this.context);
            this.qpX.setOrientation(0);
            this.qpX.addView(view);
            super.addView(this.qpX);
        } else {
            this.qpX.addView(view);
        }
        this.jUX++;
    }
}
