package com.tencent.mm.plugin.record.a;

import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.fs;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.w;

public final class d {
    public static String a(b bVar) {
        com.tencent.mm.sdk.b.b fpVar = new fp();
        fpVar.fKp.type = 2;
        fpVar.fKp.fKr = bVar.fKe;
        a.urY.m(fpVar);
        return fpVar.fKq.path;
    }

    public static String b(b bVar) {
        com.tencent.mm.sdk.b.b fpVar = new fp();
        fpVar.fKp.type = 2;
        fpVar.fKp.fKr = bVar.fKe;
        a.urY.m(fpVar);
        return fpVar.fKq.fKz;
    }

    public static boolean c(b bVar) {
        com.tencent.mm.sdk.b.b fpVar = new fp();
        fpVar.fKp.type = 14;
        fpVar.fKp.fKr = bVar.fKe;
        a.urY.m(fpVar);
        if (fpVar.fKq.ret == 1) {
            return true;
        }
        return false;
    }

    public static c cR(long j) {
        com.tencent.mm.sdk.b.b fsVar = new fs();
        fsVar.fKM.fFx = j;
        a.urY.m(fsVar);
        if (fsVar.fKN.ret == 0) {
            w.w("MicroMsg.RecordFavLogic", "can not fetch FavItem");
            return null;
        }
        w.d("MicroMsg.RecordFavLogic", "fetch favitem localId %s, itemStatus %d", new Object[]{Long.valueOf(fsVar.fKM.fFx), Integer.valueOf(fsVar.fKN.field_itemStatus)});
        c cVar = new c();
        cVar.field_localId = fsVar.fKM.fFx;
        cVar.field_id = fsVar.fKN.field_id;
        cVar.field_fromUser = fsVar.fKN.field_fromUser;
        cVar.field_toUser = fsVar.fKN.field_toUser;
        cVar.field_favProto = fsVar.fKN.field_favProto;
        cVar.field_realChatName = fsVar.fKN.field_realChatName;
        cVar.field_type = fsVar.fKN.field_type;
        cVar.field_itemStatus = fsVar.fKN.field_itemStatus;
        return cVar;
    }
}
