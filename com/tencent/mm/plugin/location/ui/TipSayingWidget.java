package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class TipSayingWidget extends LinearLayout {
    private Context context;
    private TextView kvp;
    private ImageView nfg;
    private Chronometer nfh;
    private int nfi = 0;

    public TipSayingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.dpd, this);
        this.nfg = (ImageView) inflate.findViewById(R.h.czK);
        this.kvp = (TextView) inflate.findViewById(R.h.czM);
        this.nfh = (Chronometer) findViewById(R.h.bCn);
    }
}
