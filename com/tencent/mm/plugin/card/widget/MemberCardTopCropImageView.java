package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MemberCardTopCropImageView extends ImageView {
    protected int itemPadding = -1;
    protected int kpi = -1;
    protected int ksj = -1;
    private float ksk;

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MemberCardTopCropImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setScaleType(ScaleType.MATRIX);
        this.kpi = a.T(ab.getContext(), R.f.aYH);
        this.itemPadding = a.T(ab.getContext(), R.f.aXz) * 2;
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        if (getDrawable() == null) {
            return super.setFrame(i, i2, i3, i4);
        }
        Matrix imageMatrix = getImageMatrix();
        int intrinsicWidth = getDrawable().getIntrinsicWidth();
        int intrinsicHeight = getDrawable().getIntrinsicHeight();
        this.ksj = getContext().getResources().getDisplayMetrics().widthPixels - this.itemPadding;
        int i5 = this.ksj;
        int i6 = this.kpi;
        if (intrinsicWidth * i6 > intrinsicHeight * i5) {
            this.ksk = ((float) i6) / ((float) intrinsicHeight);
        } else {
            this.ksk = ((float) i5) / ((float) intrinsicWidth);
        }
        imageMatrix.setScale(this.ksk, this.ksk);
        setImageMatrix(imageMatrix);
        return super.setFrame(i, i2, i3, i4);
    }
}
