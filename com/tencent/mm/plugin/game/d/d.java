package com.tencent.mm.plugin.game.d;

import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    public static void a(f fVar) {
        if (fVar == null) {
            w.e("MicroMsg.GameDataUtil", "Null appInfo");
        } else if (bg.mA(fVar.field_appId)) {
            w.e("MicroMsg.GameDataUtil", "Invalid appId");
        } else {
            f fVar2;
            boolean z;
            boolean l;
            String str = fVar.field_appId;
            f aJ = g.aJ(str, true);
            if (aJ == null) {
                aJ = new f();
                aJ.field_appId = str;
                fVar2 = aJ;
                z = true;
            } else {
                fVar2 = aJ;
                z = false;
            }
            String bIN = v.bIN();
            if (bIN.equals("zh_CN")) {
                fVar2.field_appName = fVar.field_appName;
            } else if (bIN.equals("zh_TW") || bIN.equals("zh_HK")) {
                fVar2.field_appName_tw = fVar.field_appName;
            } else {
                fVar2.field_appName_en = fVar.field_appName;
            }
            fVar2.field_appType = fVar.field_appType;
            fVar2.field_packageName = fVar.field_packageName;
            fVar2.bD(fVar.gfc);
            fVar2.bG(fVar.gfh);
            fVar2.da(fVar.gfl);
            fVar2.bH(fVar.gfi);
            fVar2.bM(fVar.gfo);
            fVar2.bN(fVar.gfp);
            fVar2.bK(fVar.gfm);
            fVar2.bL(fVar.gfn);
            fVar2.db(fVar.gfr);
            if (!bg.mA(fVar.gff)) {
                fVar2.bE(fVar.gff);
            }
            if (z) {
                l = an.aRr().l(fVar2);
                a.aRv().Cm(str);
            } else if (fVar2.field_appVersion < fVar.field_appVersion) {
                w.i("MicroMsg.GameDataUtil", "oldVersion = %s, newVersion = %s", new Object[]{Integer.valueOf(fVar2.field_appVersion), Integer.valueOf(fVar.field_appVersion)});
                l = an.aRr().a(fVar2, new String[0]);
                a.aRv().Cm(str);
            } else {
                boolean z2 = (fVar2 == null || bg.mA(fVar2.field_appIconUrl)) ? true : (fVar == null || bg.mA(fVar.field_appIconUrl)) ? false : !fVar2.field_appIconUrl.equals(fVar.field_appIconUrl);
                if (z2) {
                    w.i("MicroMsg.GameDataUtil", "oldIcon = %s, newIcon = %s", new Object[]{fVar2.field_appIconUrl, fVar.field_appIconUrl});
                    fVar2.field_appIconUrl = fVar.field_appIconUrl;
                    l = an.aRr().a(fVar2, new String[0]);
                    an.aRp().cu(str, 1);
                    an.aRp().cu(str, 2);
                    an.aRp().cu(str, 3);
                    an.aRp().cu(str, 4);
                    an.aRp().cu(str, 5);
                } else {
                    l = an.aRr().a(fVar2, new String[0]);
                }
            }
            w.i("MicroMsg.GameDataUtil", "Saving AppInfo, appId: %s, insert?: %s, return: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(l)});
        }
    }

    public static void U(LinkedList<? extends f> linkedList) {
        if (linkedList == null) {
            w.e("MicroMsg.GameDataUtil", "Null appInfos");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a((f) it.next());
        }
    }
}
