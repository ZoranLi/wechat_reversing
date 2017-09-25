package com.tencent.mm.ui.base;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.w;

public class i extends Dialog {
    public i(Context context, int i) {
        super(context, i);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMDialog", e, "", new Object[0]);
        }
    }

    public void show() {
        try {
            super.show();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMDialog", e, "", new Object[0]);
        }
    }
}
