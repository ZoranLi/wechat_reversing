package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.r;

public class CollectRadioBtnView extends LinearLayout {
    private TextView jhl;
    private ImageView kDo;

    public CollectRadioBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CollectRadioBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = r.eC(context).inflate(R.i.cZe, this);
        this.kDo = (ImageView) inflate.findViewById(R.h.cve);
        this.jhl = (TextView) inflate.findViewById(R.h.cJh);
    }

    public final void tC(String str) {
        this.jhl.setText(str);
    }

    public final void kY(int i) {
        this.kDo.setImageResource(i);
    }
}
