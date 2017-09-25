package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location_soso.SoSoMapView;
import com.tencent.mm.plugin.location_soso.SoSoProxyUI;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.sdk.platformtools.w;

public final class d implements c {
    public static Intent D(Activity activity) {
        return new Intent(activity, SoSoProxyUI.class);
    }

    public static View cv(Context context) {
        View soSoMapView = new SoSoMapView(context);
        soSoMapView.setId(R.h.bSq);
        return soSoMapView;
    }

    public final a d(Activity activity, int i) {
        switch (i) {
            case 2:
                return new c(activity);
            case 4:
                return new h(activity);
            case 5:
                w.i("MicroMsg.MapFactoryImp", "share map");
                return new g(activity);
            default:
                return null;
        }
    }
}
