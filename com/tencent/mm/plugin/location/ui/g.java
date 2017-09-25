package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.d;

public final class g extends RelativeLayout {
    private Context mContext;
    private ImageView ndF;
    public d ndG;
    public boolean ndn = false;

    public g(Context context, d dVar) {
        super(context);
        this.ndG = dVar;
        this.mContext = context;
        this.ndF = (ImageView) View.inflate(this.mContext, R.i.dkK, this).findViewById(R.h.csa);
    }

    public final void remove() {
        this.ndG.removeView(this);
        this.ndn = false;
    }
}
