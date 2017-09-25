package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import java.util.List;

public class BannerActView extends LinearLayout {
    private List<a> nvs;
    private TextView nvt = ((TextView) LayoutInflater.from(getContext()).inflate(R.i.cVt, this, true).findViewById(R.h.cha));

    public BannerActView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BannerActView nvu;

            {
                this.nvu = r1;
            }

            public final void onClick(View view) {
                this.nvu.setVisibility(8);
                b.bI(this.nvu.nvs);
                if (this.nvu.nvs != null && this.nvu.nvs.size() > 0) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", ((a) this.nvu.nvs.get(0)).rIA);
                    d.b(this.nvu.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }
}
