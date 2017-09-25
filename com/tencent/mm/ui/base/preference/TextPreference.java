package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.s.a.h;

public class TextPreference extends Preference {
    private Context context;
    protected TextView kH;
    protected CharSequence mText;
    protected int tW;

    public TextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        setLayoutResource(h.djf);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.kH = (TextView) view.findViewById(16908310);
        ar();
    }

    private void ar() {
        if (this.kH != null) {
            this.kH.setText(this.mText);
            this.kH.setGravity(this.tW);
        }
    }

    public final void O(CharSequence charSequence) {
        this.mText = charSequence;
        this.tW = 17;
        ar();
    }
}
