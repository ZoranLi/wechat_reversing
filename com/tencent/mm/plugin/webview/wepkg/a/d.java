package com.tencent.mm.plugin.webview.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.List;

public class d extends i<c> {
    public static final String[] gUx = new String[]{i.a(c.izp, "WepkgVersion")};
    private static volatile d spd = null;
    private final g hnH;
    public final boolean rXW;

    public static d bAp() {
        if (!ap.zb()) {
            return new d(null);
        }
        if (spd == null) {
            synchronized (d.class) {
                if (spd == null || !spd.rXW) {
                    ap.yY();
                    spd = new d(c.wO());
                }
            }
        }
        return spd;
    }

    private d(g gVar) {
        super(gVar, c.izp, "WepkgVersion", c.gaK);
        this.hnH = gVar;
        this.rXW = gVar != null;
        if (!this.rXW) {
            w.e("MicroMsg.Wepkg.WepkgVersionStorage", "storage can not work!!!");
        }
    }

    public final c Kr(String str) {
        if (!this.rXW || bg.mA(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgVersion", "pkgId"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            w.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid exist record in DB, pkgid:%s, version:%s", new Object[]{cVar.field_pkgId, cVar.field_version});
            return cVar;
        }
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgid pkgid:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final c Ks(String str) {
        if (!this.rXW || bg.mA(str)) {
            return null;
        }
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s=0", new Object[]{"WepkgVersion", "pkgId", "disable"}), new String[]{str});
        if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            w.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble exist record in DB, pkgid:%s, version:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, domain:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s, disable:%s", new Object[]{cVar.field_pkgId, cVar.field_version, Boolean.valueOf(cVar.field_disableWvCache), Long.valueOf(cVar.field_clearPkgTime), Long.valueOf(cVar.field_checkIntervalTime), cVar.field_domain, Boolean.valueOf(cVar.field_bigPackageReady), Boolean.valueOf(cVar.field_preloadFilesReady), Boolean.valueOf(cVar.field_preloadFilesAtomic), Boolean.valueOf(cVar.field_disable)});
            cVar.field_accessTime = com.tencent.mm.plugin.webview.wepkg.utils.d.XH();
            super.c(cVar, new String[0]);
            return cVar;
        }
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "getRecordByPkgidWithAble pkgid:%s, no record in DB", new Object[]{str});
        rawQuery.close();
        return null;
    }

    public final List<WepkgVersion> bAq() {
        List<WepkgVersion> list = null;
        if (this.rXW) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s < ? - %s", new Object[]{"WepkgVersion", "accessTime", "clearPkgTime"}), new String[]{String.valueOf(com.tencent.mm.plugin.webview.wepkg.utils.d.XH())});
            w.i("MicroMsg.Wepkg.WepkgVersionStorage", "getNeedCleanRecords queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                w.i("MicroMsg.Wepkg.WepkgVersionStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgVersion wepkgVersion = new WepkgVersion();
                    c cVar = new c();
                    cVar.b(rawQuery);
                    wepkgVersion.a(cVar);
                    list.add(wepkgVersion);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                w.i("MicroMsg.Wepkg.WepkgVersionStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                w.i("MicroMsg.Wepkg.WepkgVersionStorage", "no record");
            }
        }
        return list;
    }

    public final boolean Kq(String str) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c cVar = new c();
        cVar.field_pkgId = str;
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.a(cVar, new String[0]))});
        return super.a(cVar, new String[0]);
    }

    public final boolean Kt(String str) {
        if (!this.rXW) {
            return false;
        }
        com.tencent.mm.sdk.e.c Kr = Kr(str);
        if (Kr == null) {
            return false;
        }
        Kr.field_nextCheckTime = com.tencent.mm.plugin.webview.wepkg.utils.d.XH() + Kr.field_checkIntervalTime;
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCheckTime pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(Kr, new String[0]))});
        return super.c(Kr, new String[0]);
    }

    public final boolean a(String str, boolean z, long j, long j2) {
        if (!this.rXW) {
            return false;
        }
        com.tencent.mm.sdk.e.c Kr = Kr(str);
        if (Kr == null) {
            return false;
        }
        Kr.field_disableWvCache = z;
        Kr.field_clearPkgTime = j;
        Kr.field_nextCheckTime = (Kr.field_nextCheckTime - Kr.field_checkIntervalTime) + j2;
        Kr.field_checkIntervalTime = j2;
        Kr.field_disable = false;
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateConfigInfo pkgid:%s, disableWvCache:%s, clearPkgTime:%s, checkIntervalTime:%s, ret:%s", new Object[]{str, Boolean.valueOf(z), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(super.c(Kr, new String[0]))});
        return super.c(Kr, new String[0]);
    }

    public final boolean o(String str, String str2, boolean z) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Kr = Kr(str);
        if (Kr == null) {
            return false;
        }
        Kr.field_bigPackageReady = z;
        Kr.field_pkgPath = str2;
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateBigPackageReady pkgid:%s, pkgPath:%s, bigPackageReady:%b, ret:%s", new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(super.c(Kr, new String[0]))});
        return super.c(Kr, new String[0]);
    }

    public final boolean aC(String str, boolean z) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Kr = Kr(str);
        if (Kr == null) {
            return false;
        }
        Kr.field_preloadFilesReady = z;
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "updatePreloadFilesReady pkgid:%s, preloadFilesReady:%b, ret:%s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(super.c(Kr, new String[0]))});
        return super.c(Kr, new String[0]);
    }

    public final boolean Ku(String str) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        boolean eE = eE("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[]{"WepkgVersion", "autoDownloadCount", "autoDownloadCount", "pkgId", str}));
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addAutoDownloadCount ret:%s", new Object[]{Boolean.valueOf(eE)});
        return true;
    }

    public final boolean Kv(String str) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Kr = Kr(str);
        if (Kr == null) {
            return true;
        }
        Kr.field_disable = true;
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "setWepkgDisable pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(Kr, new String[0]))});
        return super.c(Kr, new String[0]);
    }

    public final boolean Kw(String str) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c Kr = Kr(str);
        if (Kr == null) {
            return false;
        }
        Kr.field_createTime = 0;
        w.i("MicroMsg.Wepkg.WepkgVersionStorage", "updateCreateTimeToZero pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.c(Kr, new String[0]))});
        return super.c(Kr, new String[0]);
    }
}
