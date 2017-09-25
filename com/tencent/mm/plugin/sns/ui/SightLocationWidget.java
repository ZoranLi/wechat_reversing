package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;

public class SightLocationWidget extends LocationWidget {
    public SightLocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightLocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int bjb() {
        return i.pJg;
    }

    protected final int bjc() {
        return i.pJh;
    }

    protected final int getLayoutResource() {
        return g.pDi;
    }
}
