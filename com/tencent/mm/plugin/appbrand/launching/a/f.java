package com.tencent.mm.plugin.appbrand.launching.a;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;

public final class f implements d {
    private static final int[] jae = new int[]{1025, 1031, 1032};
    private static final int[] jaf = new int[]{1011, 1012, 1013, 1047, 1049, 1048, 1050};
    private final d jag = new d();
    private final e jah = new e();
    private final c jai = new c();

    public final boolean pM(String str) {
        if (bg.mA(str)) {
            return false;
        }
        b bVar;
        w.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", new Object[]{str});
        for (b bVar2 : b.values()) {
            int i = (bg.mA(str) || !str.startsWith(bVar2.hRn)) ? 0 : 1;
            if (i != 0) {
                bVar = bVar2;
                break;
            }
        }
        bVar = null;
        if (bVar == null) {
            return false;
        }
        Uri parse;
        try {
            parse = Uri.parse(str);
        } catch (Exception e) {
            w.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", new Object[]{str, e});
            parse = null;
        }
        if (parse == null) {
            return false;
        }
        String queryParameter = parse.getQueryParameter("username");
        if (bg.mA(queryParameter) || !x.em(queryParameter)) {
            return false;
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = bVar.scene;
        appBrandStatObject.fCN = b.Vg();
        appBrandStatObject.fWL = b.Vh();
        appBrandStatObject.fWM = b.Vi();
        AppBrandLaunchProxyUI.a(null, queryParameter, null, 0, -1, appBrandStatObject, null);
        return true;
    }

    public final boolean b(Context context, String str, int i, Bundle bundle) {
        if (a.b(jae, i)) {
            if (a.iZV == this.jag.a(context, str, i, bundle)) {
                return true;
            }
            return false;
        } else if (a.b(jaf, i)) {
            if (a.iZV != this.jah.a(context, str, i, bundle)) {
                return false;
            }
            return true;
        } else if (1064 != i) {
            w.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", new Object[]{str, Integer.valueOf(i)});
            return false;
        } else if (a.iZV != this.jai.a(context, str, i, bundle)) {
            return false;
        } else {
            return true;
        }
    }
}
