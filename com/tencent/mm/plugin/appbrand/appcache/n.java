package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class n {
    private static volatile n izJ = null;
    private final Map<String, Map<a, Boolean>> izK = new android.support.v4.e.a();
    private final g izL = new g();

    public interface a {

        public static final class a {
            public final String appId;
            public final String filePath;
            public final int izM;
            public final int version;

            public a(String str, String str2, int i, int i2) {
                this.appId = str;
                this.filePath = str2;
                this.version = i;
                this.izM = i2;
            }
        }

        public enum b {
            OK(0),
            FAILED(101),
            LOCAL_FILE_NOT_FOUND(102),
            PKG_INTEGRITY_FAILED(104),
            PKG_INVALID(MMGIFException.D_GIF_ERR_NO_IMAG_DSCR),
            SEVER_FILE_NOT_FOUND(MMGIFException.D_GIF_ERR_NO_COLOR_MAP),
            ENV_ERR(m.CTRL_INDEX);
            
            public final int code;

            private b(int i) {
                this.code = i;
            }
        }

        void a(String str, b bVar, a aVar);
    }

    private static n QA() {
        if (c.PY() == null) {
            izJ = null;
            return null;
        }
        if (izJ == null) {
            synchronized (n.class) {
                if (izJ == null) {
                    izJ = new n();
                }
            }
        }
        return izJ;
    }

    public static void shutdown() {
        synchronized (n.class) {
            n nVar = izJ;
            izJ = null;
        }
        if (nVar != null) {
            nVar.izL.iyR.shutdown();
        }
    }

    public static boolean a(String str, a aVar) {
        return a("@LibraryAppId", 999, str, aVar);
    }

    public static boolean a(String str, int i, a aVar) {
        return a("@LibraryAppId", 0, i, str, aVar);
    }

    private static Map<a, Boolean> nG(String str) {
        if (!bg.mA(str)) {
            n QA = QA();
            if (QA != null) {
                Map<a, Boolean> map;
                synchronized (n.class) {
                    map = (Map) QA.izK.remove(str);
                }
                return map;
            }
        }
        return null;
    }

    static void az(String str, String str2) {
        a(str, str2, b.ENV_ERR, null);
    }

    static void g(String str, String str2, int i) {
        if (c.PY() == null) {
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, version = %d, get null storage", new Object[]{Integer.valueOf(i)});
        } else if (QA() == null) {
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, version = %d, get null instance", new Object[]{Integer.valueOf(i)});
        } else {
            i a = c.PY().a("@LibraryAppId", i, 0, new String[0]);
            if (a == null) {
                w.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, get null record by version( %d )", new Object[]{Integer.valueOf(i)});
                return;
            }
            int i2 = a.field_version;
            if (bg.mA(str2)) {
                w.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, filePath is null or nil");
                a(str, "@LibraryAppId", b.LOCAL_FILE_NOT_FOUND, null);
                return;
            }
            File file = new File(str2);
            if (file.exists()) {
                if (bg.mz(a.field_versionMd5).equals(g.aV(str2))) {
                    R("@LibraryAppId", 0);
                    long Nz = bg.Nz();
                    boolean a2 = a(file, 0, i2, i);
                    a("@LibraryAppId", 0, a2, (int) (bg.Nz() - Nz));
                    if (a2) {
                        a.field_pkgPath = str2;
                        c.PY().c(a);
                        a(str, "@LibraryAppId", b.OK, null);
                        return;
                    }
                    a(str, "@LibraryAppId", b.PKG_INVALID, null);
                    return;
                }
                w.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[]{a.field_versionMd5, g.aV(str2)});
                b.deleteFile(str2);
                a(str, "@LibraryAppId", b.PKG_INTEGRITY_FAILED, null);
                return;
            }
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onLibraryDownloadComplete, pkg file not exists");
            a(str, "@LibraryAppId", b.LOCAL_FILE_NOT_FOUND, null);
        }
    }

    public static boolean a(String str, int i, int i2, String str2, a aVar) {
        if (QA() == null) {
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            return false;
        }
        k dVar;
        if (!bg.mA(str) && !bg.mA(str2)) {
            switch (i) {
                case 0:
                    dVar = new d(str, i, i2, str2);
                    break;
                case 1:
                case 2:
                case 999:
                    dVar = new b(str, str2, i);
                    break;
                case 10000:
                case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                case CdnLogic.MediaType_FAVORITE_VIDEO /*10002*/:
                case 10100:
                case 10101:
                case 10102:
                    dVar = new o(str2, str, i2, i);
                    break;
                default:
                    dVar = null;
                    break;
            }
        }
        dVar = null;
        if (dVar == null) {
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
            return false;
        }
        String str3 = dVar.sEX;
        if (!(bg.mA(str3) || aVar == null)) {
            n QA = QA();
            if (QA != null) {
                synchronized (n.class) {
                    Map map = (Map) QA.izK.get(str3);
                    if (map == null) {
                        map = new HashMap();
                        QA().izK.put(str3, map);
                    }
                    map.put(aVar, Boolean.valueOf(true));
                }
            }
        }
        int a = QA().izL.a(dVar);
        if (a == 0 || a == 2) {
            return true;
        }
        a(dVar.sEX, str, b.ENV_ERR, null);
        return false;
    }

    public static boolean a(String str, int i, String str2, a aVar) {
        return a(str, i, 1, str2, aVar);
    }

    private static void a(String str, String str2, b bVar, a aVar) {
        Map nG = nG(str);
        if (nG != null) {
            for (a aVar2 : nG.keySet()) {
                if (aVar2 != null) {
                    aVar2.a(str2, bVar, aVar);
                }
            }
            return;
        }
        w.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", new Object[]{str2});
    }

    static void a(d dVar, String str, String str2, b bVar) {
        if (QA() == null) {
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
            return;
        }
        int i = bVar == b.SEVER_FILE_NOT_FOUND ? 23 : 19;
        if (!("@LibraryAppId".equals(str2) || (dVar instanceof o))) {
            if (!(dVar instanceof b)) {
                com.tencent.mm.plugin.appbrand.report.a.w(str2, i, 1);
            } else if (999 != dVar.fKL) {
                com.tencent.mm.plugin.appbrand.report.a.w(str2, i, dVar.fKL + 1);
            }
        }
        a(str, str2, bVar, null);
    }

    static void a(String str, String str2, String str3, int i, int i2) {
        boolean fp = com.tencent.mm.plugin.appbrand.appcache.c.a.fp(i2);
        if (QA() == null) {
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
        } else if (bg.mA(str3)) {
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            a(str, str2, b.LOCAL_FILE_NOT_FOUND, null);
            com.tencent.mm.plugin.appbrand.report.a.w(str2, 20, i2 + 1);
        } else {
            File file = new File(str3);
            if (!file.exists()) {
                w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
                a(str, str2, b.LOCAL_FILE_NOT_FOUND, null);
                com.tencent.mm.plugin.appbrand.report.a.w(str2, 20, i2 + 1);
            } else if (c.PY() == null) {
                w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
            } else {
                int i3 = !fp ? i : 1;
                i a = c.PY().a(str2, i3, i2, new String[0]);
                if (a == null) {
                    w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2)});
                    a(str, str2, b.FAILED, null);
                    return;
                }
                if (!fp) {
                    if (!bg.mz(a.field_versionMd5).equals(g.aV(str3))) {
                        w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", new Object[]{a.field_versionMd5, g.aV(str3)});
                        b.deleteFile(str3);
                        a(str, str2, b.PKG_INTEGRITY_FAILED, null);
                        com.tencent.mm.plugin.appbrand.report.a.w(str2, 21, i2 + 1);
                        return;
                    }
                }
                R(str2, i2);
                long Nz = bg.Nz();
                fp = a(file, i2, i3, i);
                a(str2, i2, fp, (int) (bg.Nz() - Nz));
                if (fp) {
                    m PY = c.PY();
                    if (!bg.mA(str2)) {
                        int i4 = com.tencent.mm.plugin.appbrand.appcache.c.a.fp(i2) ? 1 : i3;
                        ContentValues contentValues = new ContentValues(1);
                        contentValues.put("pkgPath", str3);
                        if (PY.izH.update("AppBrandWxaPkgManifestRecord", contentValues, String.format("%s=? and %s=? and %s=?", new Object[]{"appId", "debugType", "version"}), new String[]{str2, String.valueOf(i2), String.valueOf(i4)}) > 0) {
                            fp = true;
                            w.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(fp), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
                            a(str, str2, b.OK, new a(str2, str3, i, i2));
                            return;
                        }
                    }
                    fp = false;
                    w.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", new Object[]{Boolean.valueOf(fp), str2, Integer.valueOf(i2), Integer.valueOf(i3), str3});
                    a(str, str2, b.OK, new a(str2, str3, i, i2));
                    return;
                }
                a(str, str2, b.PKG_INVALID, null);
                com.tencent.mm.plugin.appbrand.report.a.w(str2, 22, i2 + 1);
            }
        }
    }

    private static boolean a(File file, int i, int i2, int i3) {
        f fVar = new f(file);
        if (!fVar.iyK) {
            fVar.close();
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
            file.delete();
            return false;
        } else if (i2 != i3 && com.tencent.mm.plugin.appbrand.appcache.c.a.hv(i)) {
            fVar.close();
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, given version(%s) != pkg version(%s)", new Object[]{Integer.valueOf(i3), Integer.valueOf(i2)});
            file.delete();
            return false;
        } else if (fVar.Qg()) {
            fVar.close();
            return true;
        } else {
            fVar.close();
            w.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
            file.delete();
            return false;
        }
    }

    private static void R(String str, int i) {
        int i2;
        if ("@LibraryAppId".equals(str)) {
            i2 = 8;
        } else if (i == 0) {
            if (c.PY() == null) {
                i2 = 1;
            } else {
                i2 = c.PY().O(str, i);
            }
            i2 = i2 > 1 ? 5 : 2;
        } else {
            i2 = 2;
        }
        if (2 == i2) {
            com.tencent.mm.plugin.report.service.g.oUh.a(368, 5, 1, false);
        } else if (5 == i2) {
            com.tencent.mm.plugin.report.service.g.oUh.a(368, 14, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.a(368, 24, 1, false);
        }
    }

    private static void a(String str, int i, boolean z, int i2) {
        int i3;
        int i4 = z ? 1 : 2;
        if ("@LibraryAppId".equals(str)) {
            str = "";
            i3 = 8;
        } else if (i == 0) {
            int i5;
            int i6;
            if (c.PY() == null) {
                i5 = 1;
            } else {
                i5 = c.PY().O(str, i);
            }
            if (i5 > 1) {
                i6 = 5;
            } else {
                i6 = 2;
            }
            i3 = i6;
        } else {
            i3 = 2;
        }
        if (2 == i3) {
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.a(368, 6, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(368, 7, 1, false);
            }
        } else if (5 == i3) {
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.a(368, 15, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(368, 16, 1, false);
            }
        } else if (8 == i3) {
            if (z) {
                com.tencent.mm.plugin.report.service.g.oUh.a(368, 25, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(368, 26, 1, false);
            }
        }
        com.tencent.mm.plugin.appbrand.report.a.b(str, "", i3, i4, i2);
    }
}
