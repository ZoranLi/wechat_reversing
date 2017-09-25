package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;

public class SightAtContactWidget extends AtContactWidget {
    @TargetApi(11)
    public SightAtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightAtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final int getLayoutResource() {
        return g.pGS;
    }

    protected final int bii() {
        return i.pJi;
    }

    protected final int bij() {
        return i.pJi;
    }
}
