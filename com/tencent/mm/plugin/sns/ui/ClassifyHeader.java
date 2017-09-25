package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class ClassifyHeader extends LinearLayout {
    private Context mContext;
    private TextView mVG;
    private ImageView nvW;

    @TargetApi(11)
    public ClassifyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public ClassifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = View.inflate(this.mContext, g.pGF, this);
        this.nvW = (ImageView) inflate.findViewById(f.pCZ);
        this.mVG = (TextView) inflate.findViewById(f.pCI);
    }
}
