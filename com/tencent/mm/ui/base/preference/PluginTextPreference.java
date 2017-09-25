package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;

public final class PluginTextPreference extends Preference {
    private TextView kvp;
    private ImageView ouX;
    private String text;
    private int textColor;
    public int visibility;
    public int vrR;

    public PluginTextPreference(Context context) {
        this(context, null);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ouX = null;
        this.kvp = null;
        setLayoutResource(h.her);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.frw);
        this.vrR = obtainStyledAttributes.getResourceId(m.hfT, 0);
        this.text = obtainStyledAttributes.getString(m.hfU);
        this.textColor = obtainStyledAttributes.getColor(m.hfV, -7039852);
        obtainStyledAttributes.recycle();
    }

    public final void AC(int i) {
        this.text = this.mContext.getString(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ouX = (ImageView) view.findViewById(g.bWV);
        this.ouX.setImageResource(this.vrR);
        this.ouX.setVisibility(this.visibility);
        this.kvp = (TextView) view.findViewById(g.cHK);
        this.kvp.setText(this.text);
        this.kvp.setTextColor(this.textColor);
    }
}
