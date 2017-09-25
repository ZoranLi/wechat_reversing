package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mm.R;

public final class g {
    public View mParentView;
    public PopupWindow svO;
    public a svP;

    public interface a {
        void bBI();

        void bBJ();

        void bBK();

        void bBL();
    }

    public g(Context context, View view) {
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(R.i.drV, null);
        inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.svO = new PopupWindow(inflate, -2, -2, false);
        this.svO.setClippingEnabled(false);
        inflate.findViewById(R.h.cSU).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g svQ;

            {
                this.svQ = r1;
            }

            public final void onClick(View view) {
                this.svQ.svO.dismiss();
                this.svQ.mParentView.setVisibility(8);
                if (this.svQ.svP != null) {
                    this.svQ.svP.bBI();
                }
            }
        });
        inflate.findViewById(R.h.cSR).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g svQ;

            {
                this.svQ = r1;
            }

            public final void onClick(View view) {
                this.svQ.svO.dismiss();
                this.svQ.mParentView.setVisibility(8);
                if (this.svQ.svP != null) {
                    this.svQ.svP.bBJ();
                }
            }
        });
        inflate.findViewById(R.h.cST).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g svQ;

            {
                this.svQ = r1;
            }

            public final void onClick(View view) {
                this.svQ.svO.dismiss();
                this.svQ.mParentView.setVisibility(8);
                if (this.svQ.svP != null) {
                    this.svQ.svP.bBK();
                }
            }
        });
        inflate.findViewById(R.h.cTa).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g svQ;

            {
                this.svQ = r1;
            }

            public final void onClick(View view) {
                this.svQ.svO.dismiss();
                this.svQ.mParentView.setVisibility(8);
                if (this.svQ.svP != null) {
                    this.svQ.svP.bBL();
                }
            }
        });
    }
}
