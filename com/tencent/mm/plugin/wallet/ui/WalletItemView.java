package com.tencent.mm.plugin.wallet.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class WalletItemView extends LinearLayout {
    private TextView jhl;
    private Object mData;
    private String mTitle;
    private int mType;
    private String oiy;
    private TextView oqx;
    private int org;

    public WalletItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.org = 1;
        this.mType = 0;
        this.mData = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fsn, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.fsq, 0);
        if (resourceId != 0) {
            this.mTitle = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.fsp, 0);
        if (resourceId != 0) {
            this.oiy = context.getString(resourceId);
        }
        this.org = obtainStyledAttributes.getInt(R.n.fso, 1);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.dqG, this, true);
        this.jhl = (TextView) inflate.findViewById(R.h.cJh);
        this.oqx = (TextView) inflate.findViewById(R.h.cGP);
        if (this.jhl != null) {
            this.jhl.setText(this.mTitle);
        }
        if (this.oqx != null) {
            this.oqx.setText(this.oiy);
            this.oqx.setLines(this.org);
        }
    }

    public WalletItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
