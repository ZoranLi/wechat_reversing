package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kiss.widget.textview.PLTextView;
import com.tencent.mm.kiss.widget.textview.a.a;

public class SnsCommentPreloadTextView extends PLTextView {
    private static a qPw = null;
    private static int qPx = 0;

    public SnsCommentPreloadTextView(Context context) {
        super(context);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SnsCommentPreloadTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final a vZ() {
        if (qPw == null) {
            qPw = a.blI().blJ();
        }
        return qPw;
    }

    protected final void p(CharSequence charSequence) {
        super.p(charSequence);
    }

    protected final void o(CharSequence charSequence) {
        super.o(charSequence);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
