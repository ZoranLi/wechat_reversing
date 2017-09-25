package com.tencent.mm.ui.account;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class MMKeyboardUperView extends ScrollView {
    private int defaultHeight = -1;
    private View uZp;
    private Runnable uZq = new Runnable(this) {
        final /* synthetic */ MMKeyboardUperView uZs;

        {
            this.uZs = r1;
        }

        public final void run() {
            this.uZs.fullScroll(130);
            this.uZs.uZp.setVisibility(4);
        }
    };
    private Runnable uZr = new Runnable(this) {
        final /* synthetic */ MMKeyboardUperView uZs;

        {
            this.uZs = r1;
        }

        public final void run() {
            this.uZs.uZp.setVisibility(0);
        }
    };

    public MMKeyboardUperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
