package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.w;

public class MMFormSelectorView extends LinearLayout {
    private TextView ipw;
    private int layout;
    private Context mContext;
    private EditText oBT;
    private String sSn;
    private String title;

    @TargetApi(11)
    public MMFormSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.layout = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fqh, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.hfJ, 0);
        if (resourceId != 0) {
            this.title = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(m.hfH, 0);
        if (resourceId != 0) {
            this.sSn = context.getString(resourceId);
        }
        this.layout = obtainStyledAttributes.getResourceId(m.hfI, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.ipw = (TextView) findViewById(g.title);
        this.oBT = (EditText) findViewById(g.bKP);
        if (this.ipw == null || this.oBT == null) {
            w.w("MicroMsg.MMFormSelectorView", "titleTV : %s, contentET : %s", new Object[]{this.ipw, this.oBT});
            return;
        }
        if (this.title != null) {
            this.ipw.setText(this.title);
        }
        if (this.sSn != null) {
            this.oBT.setHint(this.sSn);
        }
    }
}
