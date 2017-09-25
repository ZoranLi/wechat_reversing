package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;

public class PaddingImageView extends FrameLayout {
    ImageView kZA;
    private int kZB;
    ImageView kZz;

    public PaddingImageView(Context context) {
        super(context);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.kZB = a.T(getContext(), R.f.aXH);
        this.kZz = new ImageView(context);
        this.kZz.setPadding(this.kZB, this.kZB, this.kZB, this.kZB);
        this.kZA = new ImageView(context);
    }
}
