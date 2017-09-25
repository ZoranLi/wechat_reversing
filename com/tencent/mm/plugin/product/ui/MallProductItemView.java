package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class MallProductItemView extends LinearLayout {
    private TextView jhl;
    private Object mData;
    private String mTitle;
    private int mType;
    private String oiy;
    private TextView oqx;
    private ImageView oqy;
    private int org;

    public MallProductItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.org = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.frp, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.frs, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.frr, 0);
        if (resourceId != 0) {
            this.oiy = context.getString(resourceId);
        }
        this.org = obtainStyledAttributes.getInt(R.n.frq, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.dlb, this, true);
        this.jhl = (TextView) inflate.findViewById(R.h.cJh);
        this.oqx = (TextView) inflate.findViewById(R.h.cGP);
        this.oqy = (ImageView) inflate.findViewById(R.h.bXw);
        this.jhl.setText(this.mTitle);
        this.oqx.setText(this.oiy);
        this.oqx.setLines(this.org);
    }

    public MallProductItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void CB(String str) {
        this.oiy = str;
        this.oqx.setText(this.oiy);
    }
}
