package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NetStatGroup extends LinearLayout {
    final TextView oKx;
    LinearLayout piD;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R.i.dkc, this);
        this.piD = (LinearLayout) findViewById(R.h.bVE);
        this.oKx = (TextView) findViewById(R.h.bHI);
        this.oKx.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.f.aXs));
    }
}
