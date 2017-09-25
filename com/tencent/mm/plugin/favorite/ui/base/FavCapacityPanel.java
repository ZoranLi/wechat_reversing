package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.favorite.b.x;

public class FavCapacityPanel extends LinearLayout {
    private LinearLayout lJu = this;
    public long lJv;
    public TextView lJw;
    public int lJx = 0;
    public long lJy;
    private OnClickListener lJz = new OnClickListener(this) {
        final /* synthetic */ FavCapacityPanel lJA;

        {
            this.lJA = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            if (this.lJA.lJx == 0) {
                intent.putExtra("key_enter_fav_cleanui_from", 1);
            } else {
                intent.putExtra("key_enter_fav_cleanui_from", 2);
            }
            d.b(this.lJA.getContext(), "favorite", ".ui.FavCleanUI", intent);
        }
    };

    public FavCapacityPanel(Context context, AttributeSet attributeSet) {
        long j;
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), R.i.dcC, null);
        inflate.measure(-2, -2);
        View findViewById = inflate.findViewById(R.h.bOb);
        View findViewById2 = inflate.findViewById(R.h.bOc);
        this.lJw = (TextView) inflate.findViewById(R.h.bOa);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = inflate.getMeasuredWidth();
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setOnClickListener(this.lJz);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.lJu.addView(inflate, layoutParams2);
        this.lJv = x.atE() / 1048576;
        this.lJy = x.atF() / 1048576;
        TextView textView = this.lJw;
        Context context2 = this.lJw.getContext();
        int i = R.l.ehr;
        Object[] objArr = new Object[2];
        if (this.lJy - this.lJv > 0) {
            j = this.lJy - this.lJv;
        } else {
            j = 0;
        }
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(this.lJv);
        textView.setText(context2.getString(i, objArr));
    }
}
