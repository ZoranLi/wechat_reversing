package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.appbrand.appcache.c.a;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsApiFramework;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;

public final class d implements i {
    boolean iGW;

    public final void b(Context context, Bundle bundle) {
        Intent intent = new Intent(context, WxaWidgetDebugUI.class);
        String aP = MiniJsApiFramework.aP(bundle.getString("app_id"), bundle.getString("msg_id"));
        intent.putExtras(bundle);
        intent.putExtra(SlookAirButtonFrequentContactAdapter.ID, aP);
        context.startActivity(intent);
    }

    public final boolean fp(int i) {
        return a.fp(i);
    }

    public final boolean a(String str, i.a aVar) {
        return b.c(str, aVar);
    }

    public final boolean b(String str, i.a aVar) {
        return b.d(str, aVar);
    }

    public final void aU(boolean z) {
        this.iGW = z;
    }

    public final boolean AP() {
        return this.iGW;
    }

    public final boolean AQ() {
        return com.tencent.mm.sdk.a.b.bIu();
    }
}
