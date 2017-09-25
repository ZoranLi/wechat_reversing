package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.dynamic.i.g;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.IOException;

public final class a {
    private static final i iCM = new c();

    public static Bitmap aK(String str, String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            return null;
        }
        Bitmap g = l.g(b.mW(str), str2);
        if (g != null) {
            return g;
        }
        String nz = com.tencent.mm.plugin.appbrand.appcache.a.nz(str2);
        if (bg.mA(nz)) {
            return null;
        }
        String str3 = str + '#' + nz;
        g = iCM.gS(str3);
        if (g != null && !g.isRecycled()) {
            return g;
        }
        WebResourceResponse aU = g.aU(str, nz);
        if (aU != null) {
            try {
                if (aU.getData() != null && aU.getData().available() > 0) {
                    g = d.decodeStream(aU.getData());
                    if (g == null || g.isRecycled()) {
                        if (aU != null) {
                            bg.g(aU.getData());
                        }
                        return null;
                    }
                    iCM.b(str3, g);
                    if (aU == null) {
                        return g;
                    }
                    bg.g(aU.getData());
                    return g;
                }
            } catch (IOException e) {
                w.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", new Object[]{e});
                if (aU != null) {
                    bg.g(aU.getData());
                }
            } catch (Throwable th) {
                if (aU != null) {
                    bg.g(aU.getData());
                }
            }
        }
        if (aU != null) {
            bg.g(aU.getData());
        }
        return null;
    }
}
