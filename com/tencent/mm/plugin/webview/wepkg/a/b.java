package com.tencent.mm.plugin.webview.wepkg.a;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.List;

public class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.izp, "WepkgPreloadFiles")};
    private static volatile b spc = null;
    private final g hnH;
    public final boolean rXW;

    public static b bAo() {
        if (!ap.zb()) {
            return new b(null);
        }
        if (spc == null) {
            synchronized (b.class) {
                if (spc == null || !spc.rXW) {
                    ap.yY();
                    spc = new b(c.wO());
                }
            }
        }
        return spc;
    }

    private b(g gVar) {
        super(gVar, a.izp, "WepkgPreloadFiles", a.gaK);
        this.hnH = gVar;
        this.rXW = gVar != null;
        if (!this.rXW) {
            w.e("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "storage can not work!!!");
        }
    }

    public final a dZ(String str, String str2) {
        if (!this.rXW || bg.mA(str) || bg.mA(str2)) {
            return null;
        }
        String ed = d.ed(str, str2);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "key"}), new String[]{ed});
        if (rawQuery.moveToFirst()) {
            a aVar = new a();
            aVar.b(rawQuery);
            rawQuery.close();
            w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid exist record in DB, pkgid:%s, rid:%s, version:%s", new Object[]{aVar.field_pkgId, aVar.field_rid, aVar.field_version});
            return aVar;
        }
        w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getRecordByRid pkgid:%s, rid:%s, no record in DB", new Object[]{str, str2});
        rawQuery.close();
        return null;
    }

    public final List<WepkgPreloadFile> Kp(String str) {
        List<WepkgPreloadFile> list = null;
        if (this.rXW && !bg.mA(str)) {
            Cursor rawQuery = rawQuery(String.format("select * from %s where %s=?", new Object[]{"WepkgPreloadFiles", "pkgId"}), new String[]{str});
            w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getPreLoadFileList queryStr:%s", new Object[]{r1});
            if (rawQuery == null) {
                w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
            } else if (rawQuery.moveToFirst()) {
                list = new ArrayList();
                do {
                    WepkgPreloadFile wepkgPreloadFile = new WepkgPreloadFile();
                    a aVar = new a();
                    aVar.b(rawQuery);
                    wepkgPreloadFile.a(aVar);
                    list.add(wepkgPreloadFile);
                } while (rawQuery.moveToNext());
                rawQuery.close();
                w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[]{Integer.valueOf(list.size())});
            } else {
                rawQuery.close();
                w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            }
        }
        return list;
    }

    public final boolean Kq(String str) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        com.tencent.mm.sdk.e.c aVar = new a();
        aVar.field_pkgId = str;
        w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "deleteRecordByPkgid pkgid:%s, ret:%s", new Object[]{str, Boolean.valueOf(super.a(aVar, new String[]{"pkgId"}))});
        return super.a(aVar, new String[]{"pkgId"});
    }

    public final boolean g(String str, String str2, String str3, boolean z) {
        if (!this.rXW || bg.mA(str) || bg.mA(str2)) {
            return false;
        }
        com.tencent.mm.sdk.e.c dZ = dZ(str, str2);
        if (dZ == null) {
            return false;
        }
        dZ.field_completeDownload = z;
        dZ.field_filePath = str3;
        w.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "updateDownloadCompleteState pkgid:%s, rid:%s, completeDownload:%s, filePath:%s, ret:%s", new Object[]{str, str2, Boolean.valueOf(z), str3, Boolean.valueOf(super.c(dZ, new String[0]))});
        return super.c(dZ, new String[0]);
    }
}
