package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;

public class PreferenceInfoCategory extends Preference {
    public int uTS;
    public OnClickListener vsi;
    public OnClickListener vsj;

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceInfoCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vsi = null;
        this.vsj = null;
        this.uTS = 0;
        setLayoutResource(h.hex);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(16908310);
        if (textView != null) {
            if (getTitle() == null || getTitle().length() <= 0) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(getTitle());
                textView.setOnClickListener(this.vsj);
            }
            ImageView imageView = (ImageView) view.findViewById(g.hcb);
            imageView.setOnClickListener(this.vsi);
            if (this.uTS > 0) {
                imageView.setImageResource(this.uTS);
                imageView.setVisibility(0);
                return;
            }
            imageView.setVisibility(8);
        }
    }
}
