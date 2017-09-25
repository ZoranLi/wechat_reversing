package com.tencent.mm.ui.chatting;

import com.tencent.mm.a.e;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.n;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.f.a;

public final class dr {
    public static String eL(long j) {
        String f = f(n.GS().aj(j));
        return f != null ? f : null;
    }

    public static String eM(long j) {
        String f = f(n.GS().ai(j));
        return f != null ? f : null;
    }

    private static String f(d dVar) {
        if (dVar != null) {
            String str;
            if (dVar.GB()) {
                str = dVar.hEZ;
                if (str != null && e.aO(str)) {
                    return str;
                }
            }
            str = n.GS().m(dVar.hEZ, null, null);
            if (str != null && e.aO(str)) {
                return str;
            }
            str = n.GS().m(dVar.hFb, null, null);
            if (str != null && e.aO(str)) {
                return str;
            }
        }
        return null;
    }

    public static String a(au auVar, a aVar) {
        String str = "";
        if (!(aVar == null || bg.mA(aVar.fCW))) {
            b LW = an.abL().LW(aVar.fCW);
            if (LW != null && LW.azf() && e.aO(LW.field_fileFullPath)) {
                str = LW.field_fileFullPath;
            }
        }
        if (bg.mA(str)) {
            if (auVar != null) {
                str = n.GS().v(auVar.field_imgPath, true);
            }
            w.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", str);
        } else {
            w.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", str);
        }
        return str;
    }
}
