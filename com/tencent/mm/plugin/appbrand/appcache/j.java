package com.tencent.mm.plugin.appbrand.appcache;

import android.database.Cursor;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class j {
    public static final Runnable izq = new Runnable() {
        private static void Qy() {
            List list = null;
            m PY = c.PY();
            Cursor a = PY.izH.a(String.format("select distinct %s from %s ", new Object[]{"appId", "AppBrandWxaPkgManifestRecord"}), null, 2);
            List<String> arrayList = new ArrayList();
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            if (!bg.bV(arrayList)) {
                List linkedList = new LinkedList();
                for (String q : arrayList) {
                    Collection q2 = PY.q(q, 0, 2);
                    if (!bg.bV(q2)) {
                        linkedList.addAll(q2);
                    }
                }
                list = linkedList;
            }
            if (!bg.bV(r0)) {
                for (i iVar : r0) {
                    b.deleteFile(iVar.field_pkgPath);
                    c.PY().a(iVar);
                }
            }
        }

        private static void Qz() {
            File file = new File(g.Qj());
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    boolean z;
                    m PY = c.PY();
                    String absolutePath = file2.getAbsolutePath();
                    Cursor a = PY.izH.a("AppBrandWxaPkgManifestRecord", new String[]{"appId"}, String.format("%s=?", new Object[]{"pkgPath"}), new String[]{absolutePath}, null, null, null, 2);
                    if (a == null) {
                        z = false;
                    } else {
                        z = a.moveToFirst();
                        a.close();
                    }
                    if (!z) {
                        b.deleteFile(file2.getAbsolutePath());
                    }
                }
            }
        }

        public final void run() {
            try {
                m PY = c.PY();
                StringBuilder stringBuilder = new StringBuilder("debugType");
                stringBuilder.append(" in (");
                for (int append : c.iyC) {
                    stringBuilder.append(append).append(',');
                }
                stringBuilder.append(-1).append(')');
                Cursor a = PY.izH.a("AppBrandWxaPkgManifestRecord", null, stringBuilder.toString(), null, null, null, null, 2);
                List list;
                if (a == null) {
                    list = null;
                } else if (a.moveToFirst()) {
                    list = new ArrayList();
                    do {
                        i iVar = new i();
                        iVar.b(a);
                        list.add(iVar);
                    } while (a.moveToNext());
                    a.close();
                } else {
                    a.close();
                    list = null;
                }
                if (!bg.bV(r0)) {
                    long Ny = bg.Ny();
                    for (i iVar2 : r0) {
                        if (iVar2.field_endTime > 0 && iVar2.field_endTime <= Ny) {
                            b.deleteFile(iVar2.field_pkgPath);
                            c.PY().a(iVar2);
                            com.tencent.mm.plugin.appbrand.task.b.an(iVar2.field_appId, iVar2.field_debugType);
                        }
                    }
                }
                AnonymousClass1.Qy();
                AnonymousClass1.Qz();
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.WxaPkgPruner", "prune running, exp = %s", new Object[]{bg.g(e)});
            }
        }
    };

    public static void Qx() {
        d.vL().D(izq);
    }
}
