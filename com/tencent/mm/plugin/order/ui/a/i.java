package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class i extends Preference {
    private View mView = null;
    private int oiH = Integer.MAX_VALUE;
    String oiI;

    public i(Context context) {
        super(context);
        setLayoutResource(R.i.dhZ);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.chC);
        ((TextView) view.findViewById(R.h.chD)).setText(getTitle());
        textView.setText(this.oiI);
        if (this.oiH != Integer.MAX_VALUE) {
            textView.setTextColor(this.oiH);
        }
    }

    public final void Cu(String str) {
        try {
            this.oiH = Color.parseColor(str);
        } catch (Exception e) {
            this.oiH = -1;
        }
    }
}
