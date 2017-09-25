package com.tencent.mm.plugin.appbrand.appcache;

import android.util.Pair;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public enum h {
    ;

    public enum a {
        public static final a izf = null;
        public static final a izg = null;
        public static final a izh = null;
        public static final a izi = null;
        public static final a izj = null;
        public static final a izk = null;
        private static final /* synthetic */ a[] izl = null;

        private a(String str, int i) {
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) izl.clone();
        }

        static {
            izf = new a("APP_READY", 0);
            izg = new a("APP_MANIFEST_NULL", 1);
            izh = new a("PKG_EXPIRED", 2);
            izi = new a("APP_NOT_INSTALLED", 3);
            izj = new a("APP_BROKEN", 4);
            izk = new a("ENV_ERR", 5);
            izl = new a[]{izf, izg, izh, izi, izj, izk};
        }

        public final int Qw() {
            return super.ordinal();
        }
    }

    private static WxaPkgWrappingInfo o(String str, int i, int i2) {
        if (!"@LibraryAppId".equals(str) || i != 0 || (i2 >= 0 && 48 < i2)) {
            return null;
        }
        w.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "use local library version = %d | query appId = %s, debugType = %d, pkgVersion = %d", new Object[]{Integer.valueOf(48), str, Integer.valueOf(i), Integer.valueOf(i2)});
        return e.Qf();
    }

    public static Pair<a, WxaPkgWrappingInfo> bH(boolean z) {
        return p("@LibraryAppId", z ? 0 : 999, -1);
    }

    public static Pair<a, WxaPkgWrappingInfo> p(String str, int i, int i2) {
        if (c.PY() == null) {
            w.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null storage, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            return Pair.create(a.izk, null);
        }
        i a;
        String[] strArr = new String[]{"pkgPath", "versionMd5", "version", "createTime"};
        if (!com.tencent.mm.plugin.appbrand.appcache.c.a.hv(i) || i2 <= 0) {
            a = c.PY().a(str, i, strArr);
        } else {
            a = c.PY().a(str, i2, i, strArr);
        }
        if (a == null) {
            w.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "get null record, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            WxaPkgWrappingInfo o = o(str, i, -1);
            if (o != null) {
                return Pair.create(a.izf, o);
            }
            return Pair.create(a.izg, null);
        }
        int i3;
        String str2 = a.field_pkgPath;
        String str3 = a.field_versionMd5;
        if (i2 < 0) {
            i3 = a.field_version;
        } else {
            i3 = i2;
        }
        long j = a.field_createTime;
        WxaPkgWrappingInfo o2 = o(str, i, i3);
        if (o2 != null) {
            return Pair.create(a.izf, o2);
        }
        if (bg.mA(str2) || !e.aO(str2)) {
            w.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "file not exists, pkgPath = %s, appId = %s, debugType = %d, version = %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i3)});
            return Pair.create(a.izj, null);
        }
        String aV = g.aV(str2);
        if (bg.mA(str3) || str3.equals(aV)) {
            WxaPkgWrappingInfo nH = WxaPkgWrappingInfo.nH(str2);
            if (nH == null) {
                w.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "obtain wxPkg failed, appId = %s, debugType = %d, version = %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                return Pair.create(a.izj, null);
            }
            nH.izW = i3;
            nH.izX = j;
            nH.iAe = str2;
            nH.izY = false;
            nH.izV = i;
            w.i("MicroMsg.AppBrandWxaPkgIntegrityChecker", "check ok, params: appId = %s, debugType = %d, version = %d, pkgVersion = %d, startTime = %d, endTime = %d, return %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(a.field_startTime), Long.valueOf(a.field_endTime), nH});
            return Pair.create(a.izf, nH);
        }
        w.e("MicroMsg.AppBrandWxaPkgIntegrityChecker", "md5 mismatch | realMd5 = %s, manifestMd5 = %s, appId = %s, debugType = %d, version = %d", new Object[]{aV, str3, str, Integer.valueOf(i), Integer.valueOf(i2)});
        return Pair.create(a.izj, null);
    }
}
