package com.tencent.mm.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.w;

public class q extends ProgressDialog {
    public q(Context context, int i) {
        super(context, i);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.MMSafeProgressDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
