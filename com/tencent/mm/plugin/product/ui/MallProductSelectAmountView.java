package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class MallProductSelectAmountView extends LinearLayout {
    TextView ioZ = null;
    private ImageView oro = null;
    private ImageView orp = null;
    int orq = Integer.MAX_VALUE;
    int orr = 1;
    private int ors = 1;
    int ort = this.ors;
    a oru = null;

    public interface a {
        void cJ(int i, int i2);

        void cX(int i);
    }

    public MallProductSelectAmountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.i.dle, this, true);
        this.ioZ = (TextView) inflate.findViewById(R.h.chU);
        this.oro = (ImageView) inflate.findViewById(R.h.chT);
        this.orp = (ImageView) inflate.findViewById(R.h.chZ);
        this.ioZ.setText(this.ort);
        this.oro.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSelectAmountView orv;

            {
                this.orv = r1;
            }

            public final void onClick(View view) {
                if (this.orv.ort + 1 <= this.orv.orq) {
                    this.orv.ort = this.orv.ort + 1;
                    if (this.orv.aTs()) {
                        this.orv.ioZ.setText(this.orv.ort);
                    }
                    if (this.orv.oru != null) {
                        this.orv.oru.cX(this.orv.ort);
                    }
                } else if (this.orv.oru != null) {
                    this.orv.oru.cJ(this.orv.ort, this.orv.orr);
                }
            }
        });
        this.orp.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MallProductSelectAmountView orv;

            {
                this.orv = r1;
            }

            public final void onClick(View view) {
                if (this.orv.ort - 1 >= this.orv.ors) {
                    this.orv.ort = this.orv.ort - 1;
                    if (this.orv.aTs()) {
                        this.orv.ioZ.setText(this.orv.ort);
                    }
                    this.orv.aTs();
                    if (this.orv.oru != null) {
                        this.orv.oru.cX(this.orv.ort);
                    }
                } else if (this.orv.oru != null) {
                    this.orv.oru.cJ(this.orv.ort, 2);
                }
            }
        });
    }

    final boolean aTs() {
        if (this.ort > this.orq) {
            this.ort = this.orq;
            if (this.oru != null) {
                this.oru.cX(this.ort);
            }
            if (this.oru != null) {
                this.oru.cJ(this.ort, this.orr);
            }
            this.ioZ.setText(this.ort);
            return false;
        }
        if (this.ort > this.ors) {
            this.orp.setEnabled(true);
        } else if (this.ort == this.ors) {
            this.orp.setEnabled(false);
        } else {
            this.orp.setEnabled(false);
            this.ort = this.ors;
            if (this.oru != null) {
                this.oru.cX(this.ort);
            }
            if (this.oru != null) {
                this.oru.cJ(this.ort, 2);
            }
            this.ioZ.setText(this.ort);
            return false;
        }
        return true;
    }
}
