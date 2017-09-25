package com.tencent.mm.plugin.favorite;

import com.tencent.mm.e.a.fs;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class g extends c<fs> {
    public g() {
        this.usg = fs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fs fsVar = (fs) bVar;
        j bT = h.ata().bT(fsVar.fKM.fFx);
        if (bT == null) {
            fsVar.fKN.ret = 0;
        } else {
            fsVar.fKN.field_id = bT.field_id;
            fsVar.fKN.field_toUser = bT.field_toUser;
            fsVar.fKN.field_fromUser = bT.field_fromUser;
            fsVar.fKN.field_realChatName = bT.field_realChatName;
            fsVar.fKN.field_itemStatus = bT.field_itemStatus;
            fsVar.fKN.field_favProto = bT.field_favProto;
            fsVar.fKN.field_type = bT.field_type;
        }
        return false;
    }
}
