package com.tencent.mm.plugin.remittance.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.remittance.ui.RemittanceAdapterUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.b;

public class a extends b {
    public b c(Activity activity, Bundle bundle) {
        w.d("MicroMsg.RemittanceProcess", "start Process : RemittanceProcess");
        b(activity, RemittanceAdapterUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
    }

    public final void d(Activity activity, Bundle bundle) {
        super.aj(activity);
    }

    public final void c(Activity activity, int i) {
        J(activity);
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final String avB() {
        return "RemittanceProcess";
    }
}
