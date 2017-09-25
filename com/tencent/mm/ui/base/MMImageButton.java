package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.d;

public class MMImageButton extends FrameLayout {
    private ImageView fMY;
    private TextView oqM;

    public MMImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.fMY = new ImageView(context);
        this.fMY.setLayoutParams(layoutParams);
        addView(this.fMY);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.oqM = new TextView(context);
        this.oqM.setLayoutParams(layoutParams);
        this.oqM.setClickable(false);
        this.oqM.setFocusable(false);
        this.oqM.setFocusableInTouchMode(false);
        this.oqM.setTextColor(a.S(context, d.hby));
        addView(this.oqM);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.oqM.setEnabled(z);
        this.fMY.setEnabled(z);
    }
}
