package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.ui.base.l;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public final class g extends com.tencent.mm.plugin.appbrand.menu.a.a {

    public static final class a extends e {
        private static final int CTRL_INDEX = 76;
        public static final String NAME = "onMenuShareTimeline";
    }

    g() {
        super(k.jaz - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        boolean z = true;
        AppBrandSysConfig mY = b.mY(str);
        if (!(mY == null || context == null)) {
            if ((mY.RE() & 64) > 0) {
                com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.plugin.appbrand.ui.a(context);
                aVar.SX(context.getString(R.l.dDU));
                aVar.kK(false);
                aVar.zZ(R.l.dDK).a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                aVar.WJ().show();
            } else {
                z = false;
            }
        }
        if (!z) {
            a aVar2 = new a();
            Map hashMap = new HashMap();
            hashMap.put("title", b.mY(str).fGs);
            hashMap.put("desc", "");
            hashMap.put("path", mVar.jde.jdU);
            hashMap.put("imgUrl", b.mY(str).iEP);
            aVar2.a(mVar).q(hashMap).SR();
            d.TU();
        }
    }
}
