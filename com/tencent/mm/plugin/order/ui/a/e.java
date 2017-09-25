package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    public OnClickListener mOnClickListener = null;
    private View mView = null;
    public String oir;

    public e(Context context) {
        super(context);
        setLayoutResource(R.i.dhU);
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
        TextView textView = (TextView) view.findViewById(R.h.chu);
        textView.setText(this.oir);
        textView.setOnClickListener(this.mOnClickListener);
    }
}
