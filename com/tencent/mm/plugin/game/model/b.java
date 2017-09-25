package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public LinkedList<String> mow = new LinkedList();
    public LinkedList<f> mox = new LinkedList();

    public final void init(Context context) {
        if (this.mox == null) {
            this.mox = new LinkedList();
        } else {
            this.mox.clear();
        }
        if (this.mow == null) {
            this.mow = new LinkedList();
        } else {
            this.mow.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        cf(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        aAx();
        long currentTimeMillis3 = System.currentTimeMillis();
        w.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis)});
    }

    private void cf(Context context) {
        Cursor bDb = an.aRr().bDb();
        LinkedList linkedList = new LinkedList();
        if (bDb == null) {
            w.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            return;
        }
        if (bDb.moveToFirst()) {
            do {
                f fVar = new f();
                fVar.b(bDb);
                if (g.a(context, fVar) && !this.mow.contains(fVar.field_appId)) {
                    w.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", new Object[]{fVar.field_appName, fVar.field_appId});
                    this.mox.add(fVar);
                    this.mow.add(fVar.field_appId);
                }
            } while (bDb.moveToNext());
        }
        bDb.close();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f fVar2 = (f) it.next();
            this.mox.add(fVar2);
            this.mow.add(fVar2.field_appId);
        }
    }

    private void aAx() {
        List<String> arrayList = new ArrayList();
        ap.yY();
        Cursor rawQuery = c.wX().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.b(rawQuery);
                if (!bg.mA(aVar.field_appId) && aVar.field_appId.startsWith("wx") && aVar.field_status == 3 && !aVar.field_autoDownload && e.aO(aVar.field_filePath) && !arrayList.contains(aVar.field_appId)) {
                    arrayList.add(aVar.field_appId);
                }
            }
            rawQuery.close();
        }
        if (!arrayList.isEmpty()) {
            for (String str : arrayList) {
                if (!(bg.mA(str) || this.mow.contains(str))) {
                    f aJ = g.aJ(str, false);
                    if (!(aJ == null || this.mox.contains(aJ))) {
                        this.mox.add(aJ);
                        this.mow.add(str);
                    }
                }
            }
        }
    }
}
