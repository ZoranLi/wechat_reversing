package com.tencent.mm.plugin.mall.b;

import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import java.text.SimpleDateFormat;

public final class a {
    private static SimpleDateFormat krb = null;
    private static SimpleDateFormat krc = null;
    private static final String nwN = (e.hgu + "wallet/mall");

    public static void aJk() {
        b qfVar = new qf();
        qfVar.fXk.fXl = false;
        com.tencent.mm.sdk.b.a.urY.m(qfVar);
    }

    public static void i(ImageView imageView, String str) {
        f(imageView, str, 0);
    }

    public static void f(ImageView imageView, String str, int i) {
        String str2 = null;
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bg.mA(str)) {
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                if (!bg.mA(str)) {
                    str2 = String.format("%s/%s", new Object[]{nwN, g.n(str.getBytes())});
                }
                aVar.hIO = str2;
                aVar.hIL = true;
                aVar.hJh = true;
                aVar.hJi = false;
                if (i != 0) {
                    aVar.hJa = i;
                }
                n.GW().a(str, imageView, aVar.Hg());
            } else if (i != 0) {
                imageView.setImageResource(i);
            }
        }
    }
}
