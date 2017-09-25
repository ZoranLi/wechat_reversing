package com.tencent.mm.plugin.appbrand.m;

import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.y;

public final class g {

    public interface a {
        void PK();

        void nu(String str);
    }

    public static void a(d dVar, String str, final a aVar) {
        if (bg.mA(str)) {
            aVar.nu("");
            return;
        }
        dVar.evaluateJavascript(str + String.format(";var ___result_return = function(){return %d;};___result_return();", new Object[]{Integer.valueOf(11111)}), new y<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                if (str == null || !str.contains("11111")) {
                    if (aVar != null) {
                        aVar.nu(str);
                    }
                } else if (aVar != null) {
                    aVar.PK();
                }
            }
        });
    }
}
