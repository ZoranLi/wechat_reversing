package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.ui.base.MMPullDownView;

public class CollectPullDownView extends MMPullDownView {
    public CollectPullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CollectPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void akF() {
        View inflate = inflate(this.context, R.i.cZc, null);
        View inflate2 = inflate(this.context, R.i.cZc, null);
        addView(inflate, 0, new LayoutParams(-1, a.fromDPToPix(this.context, 48)));
        addView(inflate2, new LayoutParams(-1, a.fromDPToPix(this.context, 48)));
    }
}
