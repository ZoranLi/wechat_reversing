package com.tencent.mm.plugin.appbrand.launching.a;

import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class e extends a {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] jad = new int[a.Vf().length];

        static {
            try {
                jad[a.iZW - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jad[a.iZY - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jad[a.iZX - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jad[a.iZV - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    e() {
    }

    final void a(Uri uri, int i) {
        int i2 = 1;
        String queryParameter = uri == null ? "" : uri.getQueryParameter("appid");
        switch (AnonymousClass1.jad[i - 1]) {
            case 1:
                int i3;
                if (uri == null || !uri.getBooleanQueryParameter("debug", false)) {
                    boolean z = false;
                } else {
                    i3 = 1;
                }
                AppBrand404PageUI.show(R.l.dFS);
                if (i3 == 0) {
                    i2 = 0;
                }
                a.w(queryParameter, 2, i2 + 1);
                return;
            case 2:
                AppBrand404PageUI.show(R.l.dFM);
                a.w("", 3, 2);
                return;
            case 3:
                AppBrand404PageUI.show(R.l.dFN);
                a.w("", 4, 2);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(R.l.dDZ);
                return;
        }
    }
}
