package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;

public final class b {
    public TextView ipw;
    private View shP;
    private ImageView uOa;
    public TextView uOb;
    private ImageView uOc;
    public ImageView uOd;
    private ImageView uOe;
    public ImageView uOf;
    private View uOg;

    public b(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.ipw = (TextView) view.findViewById(g.hdq);
        this.uOb = (TextView) view.findViewById(g.hdg);
        this.uOc = (ImageView) view.findViewById(g.hcL);
        this.uOd = (ImageView) view.findViewById(g.hcN);
        this.uOe = (ImageView) view.findViewById(g.hcT);
        this.shP = view.findViewById(g.hcc);
        this.uOa = (ImageView) view.findViewById(g.hcd);
        this.uOf = (ImageView) view.findViewById(g.hcV);
        this.uOg = view;
    }

    public final void setTitle(CharSequence charSequence) {
        this.ipw.setText(charSequence);
        if (a.dM(this.ipw.getContext())) {
            this.ipw.setTextSize(0, ((float) a.U(this.ipw.getContext(), e.aWy)) * a.dK(this.ipw.getContext()));
        }
    }

    public final void kc(boolean z) {
        this.uOc.setVisibility(z ? 0 : 8);
    }

    public final void kd(boolean z) {
        this.uOe.setVisibility(z ? 0 : 8);
    }

    public final void h(OnClickListener onClickListener) {
        this.shP.setOnClickListener(onClickListener);
    }
}
