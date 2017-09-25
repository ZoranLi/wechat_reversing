package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;

public class NearLifeErrorContent extends FrameLayout {
    private View ipu;
    ListView iuu;
    private Context mContext;
    private TextView nYM;
    private View nYN;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.ipu = View.inflate(this.mContext, R.i.djR, this);
        this.nYM = (TextView) this.ipu.findViewById(R.h.cmx);
        this.nYN = this.ipu.findViewById(R.h.cmT);
    }

    public final void qu(int i) {
        switch (i) {
            case 0:
                this.nYM.setVisibility(8);
                this.nYN.setVisibility(8);
                this.iuu.setVisibility(0);
                return;
            case 1:
                this.nYM.setVisibility(0);
                this.nYN.setVisibility(8);
                this.iuu.setVisibility(8);
                return;
            case 2:
                this.nYM.setVisibility(8);
                this.nYN.setVisibility(0);
                this.iuu.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
