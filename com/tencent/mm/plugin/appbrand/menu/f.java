package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;
import java.util.Map;

public final class f extends com.tencent.mm.plugin.appbrand.menu.a.a {

    public static final class a extends e {
        private static final int CTRL_INDEX = 75;
        public static final String NAME = "onShareAppMessage";
    }

    public f() {
        super(k.jay - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        AppBrandSysConfig mY = b.mY(str);
        if (mY == null || mY.iFk.izV != 0 || (mY.RE() & 32) <= 0) {
            lVar.e(this.jaM, context.getString(R.l.dGa));
        }
    }

    public final void a(Context context, final m mVar, final String str, final j jVar) {
        AppBrandSysConfig mY = b.mY(str);
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(context, "pref_appbrand_" + mY.uin, 4);
        if (mY.iFk.izV == 1 && !sharedPreferences.contains("has_share_dev_tips")) {
            sharedPreferences.edit().putLong("has_share_dev_tips", System.currentTimeMillis()).commit();
            g.a(context, R.l.dEe, R.l.dIO, false, new OnClickListener(this) {
                final /* synthetic */ f jaw;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    f.a(mVar, str, jVar);
                }
            });
        } else if (mY.iFk.izV != 2 || sharedPreferences.contains("has_share_beta_tips")) {
            a(mVar, str, jVar);
        } else {
            sharedPreferences.edit().putLong("has_share_beta_tips", System.currentTimeMillis()).commit();
            g.a(context, R.l.dEd, R.l.dIO, false, new OnClickListener(this) {
                final /* synthetic */ f jaw;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    f.a(mVar, str, jVar);
                }
            });
        }
    }

    public static void a(m mVar, String str, j jVar) {
        a aVar = new a();
        Map hashMap = new HashMap();
        hashMap.put("title", b.mY(str).fGs);
        hashMap.put("desc", "");
        hashMap.put("path", mVar.jde.jdV);
        String str2 = "webViewUrl";
        com.tencent.mm.plugin.appbrand.jsapi.l.a VT = mVar.VT();
        hashMap.put(str2, VT != null ? VT.iYA.getUrl() : null);
        hashMap.put("imgUrl", b.mY(str).iEP);
        hashMap.put("mode", jVar.iHR.fR("enable_share_with_share_ticket") ? "withShareTicket" : "common");
        hashMap.put("dynamic", Boolean.valueOf(jVar.iHR.fR("enable_share_dynamic")));
        mVar.ic(k.jay).iHR.o("user_clicked_share_btn", true);
        aVar.a(mVar).q(hashMap).SR();
    }
}
