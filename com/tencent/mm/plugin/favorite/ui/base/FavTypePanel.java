package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.List;

public class FavTypePanel extends LinearLayout {
    private LinearLayout lJu = this;
    private OnClickListener lJz = new OnClickListener(this) {
        final /* synthetic */ FavTypePanel lKm;

        {
            this.lKm = r1;
        }

        public final void onClick(View view) {
            ImageButton imageButton = (ImageButton) view.findViewById(R.h.bPb);
            int intValue = ((Integer) view.getTag(R.h.bOi)).intValue();
            int intValue2 = ((Integer) view.getTag(R.h.bOQ)).intValue();
            if (intValue2 == 0) {
                imageButton.setImageResource(FavTypePanel.mz(intValue));
                view.setTag(R.h.bOQ, Integer.valueOf(1));
            } else {
                imageButton.setImageResource(FavTypePanel.mA(intValue));
                view.setTag(R.h.bOQ, Integer.valueOf(0));
            }
            if (this.lKm.lKl != null) {
                boolean z;
                a a = this.lKm.lKl;
                if (1 == intValue2) {
                    z = true;
                } else {
                    z = false;
                }
                a.G(intValue, z);
            }
        }
    };
    public a lKl;

    public interface a {
        void G(int i, boolean z);
    }

    public FavTypePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(this.lJu, R.k.dxb, R.l.ejA, 5);
        a(this.lJu, R.k.dwZ, R.l.ejw, 2);
        a(this.lJu, R.k.dxf, R.l.ejC, 3);
        a(this.lJu, R.k.dwX, R.l.ejy, 7);
        a(this.lJu, R.k.dxd, R.l.ejB, 4);
    }

    private static int mz(int i) {
        switch (i) {
            case 2:
                return R.k.dwZ;
            case 3:
                return R.k.dxf;
            case 4:
                return R.k.dxd;
            case 5:
                return R.k.dxb;
            case 7:
                return R.k.dwX;
            default:
                return 0;
        }
    }

    private static int mA(int i) {
        switch (i) {
            case 2:
                return R.k.dxa;
            case 3:
                return R.k.dxg;
            case 4:
                return R.k.dxe;
            case 5:
                return R.k.dxc;
            case 7:
                return R.k.dwY;
            default:
                return 0;
        }
    }

    private void a(LinearLayout linearLayout, int i, int i2, int i3) {
        View inflate = View.inflate(getContext(), R.i.dcH, null);
        inflate.setTag(R.h.bOi, Integer.valueOf(i3));
        inflate.setTag(R.h.bOQ, Integer.valueOf(1));
        inflate.setOnClickListener(this.lJz);
        ((ImageButton) inflate.findViewById(R.h.bPb)).setImageResource(i);
        ((TextView) inflate.findViewById(R.h.bPc)).setText(i2);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(inflate, layoutParams);
    }

    public final void ay(List<Integer> list) {
        for (int i = 0; i < this.lJu.getChildCount(); i++) {
            View childAt = this.lJu.getChildAt(i);
            Integer num = (Integer) childAt.getTag(R.h.bOi);
            if (list == null || !list.contains(num)) {
                ((ImageButton) childAt.findViewById(R.h.bPb)).setImageResource(mz(num.intValue()));
                childAt.setTag(R.h.bOQ, Integer.valueOf(1));
            } else {
                ((ImageButton) childAt.findViewById(R.h.bPb)).setImageResource(mA(num.intValue()));
                childAt.setTag(R.h.bOQ, Integer.valueOf(0));
            }
        }
    }
}
