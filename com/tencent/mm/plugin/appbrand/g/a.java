package com.tencent.mm.plugin.appbrand.g;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.appbrand.widget.AppBrandOptionButton;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.tools.h;

public final class a {

    public enum a {
        ;

        public static int[] Vv() {
            return (int[]) jbS.clone();
        }

        static {
            jbO = 1;
            jbP = 2;
            jbQ = 3;
            jbR = 4;
            jbS = new int[]{jbO, jbP, jbQ, jbR};
        }
    }

    private static final class b extends com.tencent.mm.plugin.appbrand.jsapi.b {
        static final int CTRL_INDEX = 237;
        static final String NAME = "config_navigationBarRightButton";
        static b jbT = new b();

        private b() {
        }
    }

    public static int a(final m mVar, final String str, String str2, final boolean z) {
        Bitmap bitmap = null;
        if (mVar == null) {
            return a.jbO;
        }
        if (!z) {
            if (!bg.mA(str2)) {
                bitmap = l.g(mVar.ixr, str2);
                if (bitmap == null) {
                    return a.jbP;
                }
            }
            int cY = h.cY(str, com.tencent.mm.ui.tools.h.a.wmG);
            if (cY <= 0 || cY > 8) {
                return a.jbQ;
            }
        }
        mVar.jbY.post(new Runnable() {
            public final void run() {
                mVar.jdb.cl(!z);
                if (!z) {
                    com.tencent.mm.plugin.appbrand.widget.a aVar;
                    AppBrandOptionButton appBrandOptionButton;
                    if (bitmap != null) {
                        aVar = mVar.jdb;
                        Bitmap bitmap = bitmap;
                        appBrandOptionButton = aVar.jqg;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            appBrandOptionButton.jqE = false;
                            appBrandOptionButton.jqI.setImageDrawable(new BitmapDrawable(appBrandOptionButton.getResources(), bitmap));
                            appBrandOptionButton.jqI.setVisibility(0);
                            appBrandOptionButton.jqF.setVisibility(8);
                        }
                    } else if (!bg.mA(str)) {
                        aVar = mVar.jdb;
                        CharSequence charSequence = str;
                        appBrandOptionButton = aVar.jqg;
                        appBrandOptionButton.jqE = false;
                        appBrandOptionButton.jqH.setText(charSequence);
                        appBrandOptionButton.jqF.setVisibility(0);
                        appBrandOptionButton.jqI.setVisibility(8);
                    }
                }
            }
        });
        return a.jbR;
    }
}
