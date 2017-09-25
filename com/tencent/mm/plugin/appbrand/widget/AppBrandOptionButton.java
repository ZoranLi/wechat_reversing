package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.support.v4.b.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;

public final class AppBrandOptionButton extends FrameLayout {
    public boolean jqE = true;
    public View jqF;
    private View jqG;
    public TextView jqH;
    public ImageButton jqI;

    public AppBrandOptionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandOptionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        setBackgroundResource(R.g.bbE);
        this.jqF = LayoutInflater.from(context).inflate(R.i.cTA, this, false);
        this.jqG = this.jqF.findViewById(R.h.divider);
        this.jqH = (TextView) this.jqF.findViewById(R.h.bmS);
        this.jqH.setMaxLines(1);
        this.jqH.setClickable(false);
        this.jqH.setBackground(null);
        View findViewById = this.jqF.findViewById(R.h.bmT);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        addView(this.jqF, new LayoutParams(-2, -1, 17));
        this.jqF.setVisibility(8);
        this.jqI = new ImageButton(context);
        this.jqI.setClickable(false);
        this.jqI.setBackground(null);
        addView(this.jqI, new LayoutParams(getResources().getDimensionPixelSize(R.f.bbw), -1, 17));
    }

    public final void setColor(int i) {
        this.jqH.setTextColor(i);
        this.jqG.setBackgroundColor(b.j(i, 77));
        if (this.jqI.getDrawable() == null || (this.jqI.getDrawable() instanceof com.tencent.mm.svg.a.b)) {
            this.jqI.setImageResource(R.k.dty);
            this.jqI.setColorFilter(i, Mode.SRC_ATOP);
        }
    }
}
