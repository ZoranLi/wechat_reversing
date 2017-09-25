package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;

public class AppbrandMapLocationPoint extends LinearLayout {
    ImageView iSO;
    double iSP = -1.0d;
    double iSQ = -1.0d;
    double iSR = -1.0d;
    double iSS = -1.0d;
    private Context mContext;

    public AppbrandMapLocationPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public AppbrandMapLocationPoint(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        this.iSO = (ImageView) View.inflate(this.mContext, R.i.cUc, this).findViewById(R.h.cJC);
        this.iSO.requestFocus();
    }
}
