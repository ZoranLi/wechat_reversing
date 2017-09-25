package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.k;

public class MMCollapsibleTextView extends LinearLayout {
    private Context context;
    private boolean hasCheck = true;
    private TextView iuD;
    private Runnable lGL = new Runnable(this) {
        final /* synthetic */ MMCollapsibleTextView viT;

        {
            this.viT = r1;
        }

        public final void run() {
            this.viT.iuD.setMaxLines(10);
            this.viT.qqA.setVisibility(0);
            this.viT.qqA.setText(this.viT.qqB);
        }
    };
    private int pRa;
    private TextView qqA;
    private String qqB;
    private String qqC;
    private SparseIntArray viS = new SparseIntArray();

    static /* synthetic */ void c(MMCollapsibleTextView mMCollapsibleTextView) {
        mMCollapsibleTextView.hasCheck = true;
        switch (mMCollapsibleTextView.viS.get(mMCollapsibleTextView.pRa, -1)) {
            case 0:
                mMCollapsibleTextView.qqA.setVisibility(8);
                return;
            case 1:
                mMCollapsibleTextView.iuD.setMaxLines(10);
                mMCollapsibleTextView.qqA.setVisibility(0);
                mMCollapsibleTextView.qqA.setText(mMCollapsibleTextView.qqB);
                return;
            case 2:
                mMCollapsibleTextView.iuD.setMaxLines(Integer.MAX_VALUE);
                mMCollapsibleTextView.qqA.setVisibility(0);
                mMCollapsibleTextView.qqA.setText(mMCollapsibleTextView.qqC);
                return;
            default:
                mMCollapsibleTextView.hasCheck = false;
                mMCollapsibleTextView.qqA.setVisibility(8);
                mMCollapsibleTextView.iuD.setMaxLines(11);
                return;
        }
    }

    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.qqB = this.context.getString(k.hfp);
        this.qqC = this.context.getString(k.hfo);
        View inflate = inflate(this.context, h.hee, this);
        inflate.setPadding(0, -3, 0, 0);
        this.iuD = (TextView) inflate.findViewById(g.bIb);
        this.qqA = (TextView) inflate.findViewById(g.hck);
        this.qqA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MMCollapsibleTextView viT;

            {
                this.viT = r1;
            }

            public final void onClick(View view) {
                switch (this.viT.viS.get(this.viT.pRa, -1)) {
                    case 1:
                        this.viT.viS.put(this.viT.pRa, 2);
                        break;
                    case 2:
                        this.viT.viS.put(this.viT.pRa, 1);
                        break;
                    default:
                        return;
                }
                MMCollapsibleTextView.c(this.viT);
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.hasCheck) {
            this.hasCheck = true;
            if (this.iuD.getLineCount() <= 10) {
                this.viS.put(this.pRa, 0);
                return;
            }
            this.viS.put(this.pRa, 1);
            post(this.lGL);
        }
    }
}
