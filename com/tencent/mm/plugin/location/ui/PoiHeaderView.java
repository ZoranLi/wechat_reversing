package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView kvp;
    public String ndB = "";
    public String ndC = "";
    public SimpleImageView ndD;

    public PoiHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.dkI, this);
        this.kvp = (TextView) inflate.findViewById(R.h.bWf);
        this.ndD = (SimpleImageView) inflate.findViewById(R.h.bWb);
        this.kvp.setVisibility(8);
        this.ndD.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PoiHeaderView ndE;

            {
                this.ndE = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                w.d("MicroMsg.PoiHeaderView", "click url %s", new Object[]{bg.mA(this.ndE.ndC) ? this.ndE.ndB : this.ndE.ndC});
                intent.putExtra("rawUrl", r0);
                intent.putExtra("showShare", false);
                d.a(this.ndE.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        });
    }
}
