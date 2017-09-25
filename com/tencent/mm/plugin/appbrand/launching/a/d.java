package com.tencent.mm.plugin.appbrand.launching.a;

import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class d extends a {

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

    d() {
    }

    final void a(Uri uri, int i) {
        switch (AnonymousClass1.jad[i - 1]) {
            case 1:
                AppBrand404PageUI.show(R.l.dDI);
                return;
            case 2:
                AppBrand404PageUI.show(R.l.dDJ);
                return;
            case 3:
                AppBrand404PageUI.show(R.l.dFN);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(R.l.dDZ);
                return;
        }
    }
}
