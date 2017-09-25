package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.ui.base.MMAutoHeightViewPager;
import com.tencent.mm.ui.base.MMPageControlView;
import java.util.ArrayList;

public class WalletPayUOpenIntroView extends LinearLayout {
    ArrayList<View> adA;
    Context mContext;
    MMAutoHeightViewPager rRs;
    MMPageControlView rRt;
    a rRu;
    d[] rRv;

    private class a extends u {
        final /* synthetic */ WalletPayUOpenIntroView rRw;

        public a(WalletPayUOpenIntroView walletPayUOpenIntroView) {
            this.rRw = walletPayUOpenIntroView;
        }

        public final int getCount() {
            return this.rRw.rRv == null ? 0 : this.rRw.rRv.length;
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = (View) this.rRw.adA.get(i);
            viewGroup.addView(view);
            d dVar = this.rRw.rRv[i];
            TextView textView = (TextView) view.findViewById(R.h.cIA);
            TextView textView2 = (TextView) view.findViewById(R.h.hint);
            ((ImageView) view.findViewById(R.h.logo)).setImageResource(dVar.rRq);
            textView.setText(dVar.titleRes);
            textView2.setText(dVar.rRr);
            return view;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) this.rRw.adA.get(i));
        }
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dkB, this, true);
        this.rRs = (MMAutoHeightViewPager) inflate.findViewById(R.h.cqE);
        this.rRt = (MMPageControlView) inflate.findViewById(R.h.bGI);
        this.rRt.vlf = R.i.dkr;
        this.rRt.setVisibility(0);
        this.rRs.zb = new e(this) {
            final /* synthetic */ WalletPayUOpenIntroView rRw;

            {
                this.rRw = r1;
            }

            public final void a(int i, float f, int i2) {
            }

            public final void V(int i) {
                if (this.rRw.rRs.getParent() != null) {
                    this.rRw.rRs.getParent().requestDisallowInterceptTouchEvent(true);
                }
                this.rRw.rRt.tu(i);
            }

            public final void W(int i) {
            }
        };
    }

    public WalletPayUOpenIntroView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }
}
