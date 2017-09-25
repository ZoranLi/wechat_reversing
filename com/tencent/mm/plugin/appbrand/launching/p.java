package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.q.AnonymousClass2;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.a.a;
import java.util.Locale;

final class p extends k<AppBrandSysConfig> {
    private String appId;
    private final int iPk;
    private final int iZL;
    private String username;

    public final /* synthetic */ Object call() {
        return Vd();
    }

    p(String str, String str2, int i, int i2) {
        this.username = str;
        this.appId = str2;
        this.iPk = i;
        this.iZL = i2;
    }

    public final AppBrandSysConfig Vd() {
        boolean z;
        boolean z2;
        String str;
        int i;
        Pair H;
        if (bg.mA(this.username)) {
            z = false;
        } else {
            this.appId = com.tencent.mm.plugin.appbrand.config.p.on(this.username);
            z = bg.mA(this.appId);
        }
        if (z) {
            z2 = z;
        } else {
            str = this.appId;
            i = this.iPk;
            int i2 = this.iZL;
            if (i == 0) {
                if (bg.mA(str)) {
                    w.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "checkPkgVersionOk, get appId null, forceSync");
                    z = true;
                } else {
                    i a = c.PY().a(str, 0, "version", "pkgPath", "versionMd5");
                    if (a == null) {
                        w.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "checkPkgVersionOk, get null manifest record by appId %s, forceSync", new Object[]{str});
                        z = true;
                    } else if (i2 > 0 && i2 > a.field_version) {
                        w.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "checkPkgVersionOk, preferVersion %d, localVersion %d, forceSync", new Object[]{Integer.valueOf(i2), Integer.valueOf(a.field_version)});
                        z = true;
                    } else if (bg.mA(a.field_pkgPath) || !e.aO(a.field_pkgPath)) {
                        if (m.pL(str) != null) {
                            w.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "checkPkgVersionOk, appId %s, localAvailable version %d, no need force sync", new Object[]{str, Integer.valueOf(m.pL(str).izW)});
                        } else {
                            w.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "checkPkgVersionOk, appId %s, pkgPath [ %s ] invalid, forceSync", new Object[]{str, a.field_pkgPath});
                            z = true;
                        }
                    } else {
                        z = !bg.mz(g.aV(a.field_pkgPath)).equals(a.field_versionMd5);
                        if (z) {
                            b.deleteFile(a.field_pkgPath);
                        }
                        w.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "checkPkgVersionOk, realMd5 = %s , versionMd5 = %s , forceSync = %b", new Object[]{r4, a.field_versionMd5, Boolean.valueOf(z)});
                    }
                }
                z2 = z;
            }
            z = false;
            z2 = z;
        }
        if (bg.mA(this.appId)) {
            H = q.H(this.username, z2);
        } else {
            str = this.appId;
            H = q.a(str, z2, new AnonymousClass2(str));
        }
        if (H.first == null) {
            int i3 = R.l.dFG;
            Object[] objArr = new Object[1];
            if (H.second == null) {
                str = "";
            } else {
                str = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((a) H.second).errType), Integer.valueOf(((a) H.second).errCode)});
            }
            objArr[0] = str;
            l.pK(l.e(i3, objArr));
            com.tencent.mm.plugin.appbrand.report.a.w("", 7, this.iPk + 1);
        }
        if (!(z2 || H.first == null)) {
            if (bg.mA(this.username)) {
                this.username = ((AppBrandSysConfig) H.first).fCJ;
            }
            q.G(this.username, false);
        }
        if (!z2 || H.second == null || ((a) H.second).errType != 2) {
            return (AppBrandSysConfig) H.first;
        }
        i = R.l.dFG;
        Object[] objArr2 = new Object[1];
        objArr2[0] = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((a) H.second).errType), Integer.valueOf(((a) H.second).errCode)});
        l.pK(l.e(i, objArr2));
        return null;
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
    }
}
