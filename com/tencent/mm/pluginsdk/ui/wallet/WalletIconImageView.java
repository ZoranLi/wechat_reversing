package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;

public class WalletIconImageView extends ImageView {
    private int lP;
    private int sXY;
    private OnClickListener sXZ;

    public WalletIconImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.sXY = -1;
        this.lP = 4;
        this.sXZ = null;
    }

    public WalletIconImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setImageResource(int i) {
        this.sXY = i;
        super.setImageResource(i);
    }

    public void setVisibility(int i) {
        this.lP = i;
        super.setVisibility(i);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.sXZ = onClickListener;
    }

    public final void g(OnClickListener onClickListener) {
        super.setVisibility(0);
        super.setImageResource(R.g.bgg);
        super.setContentDescription(getContext().getString(R.l.bCu));
        super.setOnClickListener(onClickListener);
    }

    public final void bGO() {
        super.setVisibility(this.lP);
        super.setImageResource(this.sXY);
        super.setOnClickListener(this.sXZ);
    }
}
