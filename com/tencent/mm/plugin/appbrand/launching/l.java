package com.tencent.mm.plugin.appbrand.launching;

import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;

enum l {
    ;

    static void hV(int i) {
        pK(ab.getResources().getString(i));
    }

    static void pK(final String str) {
        af.v(new Runnable() {
            public final void run() {
                Toast.makeText(ab.getContext(), str, 0).show();
            }
        });
    }

    static String e(int i, Object... objArr) {
        return d.e(i, objArr);
    }
}
