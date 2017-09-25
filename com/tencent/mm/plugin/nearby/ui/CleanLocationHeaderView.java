package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class CleanLocationHeaderView extends LinearLayout {
    private ImageView jla;
    private TextView nVM;

    public CleanLocationHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bV(context);
    }

    public CleanLocationHeaderView(Context context) {
        super(context);
        bV(context);
    }

    private void bV(Context context) {
        View inflate = View.inflate(context, R.i.djU, this);
        this.nVM = (TextView) inflate.findViewById(R.h.cmR);
        this.nVM.setSingleLine(false);
        this.jla = (ImageView) inflate.findViewById(R.h.cmz);
        this.nVM.setText(R.l.dWh);
        this.jla.setImageResource(R.k.dyP);
    }
}
