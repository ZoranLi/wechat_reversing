package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import com.tencent.mm.R;

public final class e extends AutoFillListPopupWindowBase {
    private final Context mContext;

    e(Context context) {
        super(context, null, 0);
        this.mContext = context;
        this.iuS.setInputMethodMode(2);
        this.iuS.setBackgroundDrawable(context.getResources().getDrawable(R.g.Ju));
        this.iuS.setFocusable(false);
        this.Yb = false;
        this.Yc = true;
        this.iuS.setAnimationStyle(R.a.aRe);
    }

    public final void show() {
        super.show();
    }
}
