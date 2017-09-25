package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class SnsNotifyBanner extends RelativeLayout {
    private LayoutInflater Du;
    private View Ih;
    private TextView qEo;
    private ImageView qEp;
    int qEq = 0;

    public SnsNotifyBanner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsNotifyBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.Du = (LayoutInflater) getContext().getSystemService("layout_inflater");
        this.Ih = this.Du.inflate(g.pHQ, this, true);
        this.qEo = (TextView) this.Ih.findViewById(f.pEx);
        this.qEp = (ImageView) this.Ih.findViewById(f.pEw);
        this.qEp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsNotifyBanner qEr;

            {
                this.qEr = r1;
            }

            public final void onClick(View view) {
                this.qEr.setVisibility(8);
            }
        });
    }
}
