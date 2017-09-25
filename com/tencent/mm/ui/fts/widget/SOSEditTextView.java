package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.tencent.mm.R;

public class SOSEditTextView extends FTSEditTextView {
    public SOSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SOSEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void bYX() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.i.doP, this, true);
    }

    protected final void init() {
        super.init();
        this.vqz.setOnFocusChangeListener(null);
    }

    public final void bZi() {
        this.vqz.setOnFocusChangeListener(this.vjo);
    }

    public final void v(Drawable drawable) {
        this.jbU.setImageDrawable(drawable);
    }
}
