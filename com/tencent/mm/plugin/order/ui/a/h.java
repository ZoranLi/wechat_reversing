package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class h extends Preference {
    boolean jzz = true;
    private View mView = null;
    boolean oiF = false;
    boolean oiG = false;

    public h(Context context) {
        super(context);
        setLayoutResource(R.i.dhY);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        int i;
        super.onBindView(view);
        View findViewById = view.findViewById(R.h.chB);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        int a = b.a(this.mContext, 10.0f);
        if (this.oiF) {
            i = a;
        } else {
            i = 0;
        }
        if (!this.oiG) {
            a = 0;
        }
        layoutParams.setMargins(0, i, 0, a);
        findViewById.setLayoutParams(layoutParams);
        if (this.jzz) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
    }
}
