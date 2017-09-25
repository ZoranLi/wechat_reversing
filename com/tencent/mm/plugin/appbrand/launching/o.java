package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.CountDownLatch;

public final class o extends k<WxaPkgWrappingInfo> {

    public static final class a implements com.tencent.mm.plugin.appbrand.appcache.n.a {
        private volatile int gaH = 0;
        private final CountDownLatch iZK = new CountDownLatch(1);

        public final WxaPkgWrappingInfo bY(boolean z) {
            while (true) {
                Pair bH = h.bH(z);
                if (bH.second == null) {
                    if (bH.first != com.tencent.mm.plugin.appbrand.appcache.h.a.izj) {
                        break;
                    }
                    i a = c.PY().a("@LibraryAppId", z ? 0 : 999, "downloadURL", "version");
                    if (a != null && !bg.mA(a.field_downloadURL)) {
                        int i = this.gaH;
                        this.gaH = i + 1;
                        if (i > 0) {
                            break;
                        }
                        if (z) {
                            n.a(a.field_downloadURL, a.field_version, this);
                        } else {
                            n.a(a.field_downloadURL, this);
                        }
                        try {
                            this.iZK.await();
                        } catch (Exception e) {
                            w.e("MicroMsg.AppBrand.PrepareStepCheckPublicLibrary", "downloadSemaphore await failed, release %b, e %s", new Object[]{Boolean.valueOf(z), e});
                            return null;
                        }
                    }
                    break;
                }
                return (WxaPkgWrappingInfo) bH.second;
            }
            return null;
        }

        public final void a(String str, b bVar, com.tencent.mm.plugin.appbrand.appcache.n.a.a aVar) {
            this.iZK.countDown();
        }
    }

    public final /* synthetic */ Object call() {
        return Sg();
    }

    public static WxaPkgWrappingInfo Sg() {
        ab.bIY();
        WxaPkgWrappingInfo bY = new a().bY(false);
        if (bY != null) {
            bY.izW = 0;
            return bY;
        }
        bY = new a().bY(true);
        if (bY != null) {
            return bY;
        }
        bY = m.pL("@LibraryAppId");
        return bY == null ? e.Qf() : bY;
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckPublicLibrary";
    }
}
