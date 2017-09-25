package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class d implements OnClickListener {
    private long jgB = 0;
    private OnClickListener oPX;

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.jgB >= 500) {
            this.oPX.onClick(view);
            this.jgB = currentTimeMillis;
        }
    }
}
