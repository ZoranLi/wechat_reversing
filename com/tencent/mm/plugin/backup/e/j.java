package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.e.a.c;
import com.tencent.mm.plugin.backup.g.a;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.storage.au;
import java.util.HashMap;
import java.util.LinkedList;

public final class j implements e {
    public final int a(eh ehVar, boolean z, au auVar, String str, LinkedList<u> linkedList, HashMap<Long, c> hashMap, boolean z2, long j) {
        return auVar.field_content == null ? 0 : auVar.field_content.getBytes().length;
    }

    public final int a(String str, eh ehVar, au auVar) {
        String str2 = new String(ehVar.tff.tZr);
        com.tencent.mm.plugin.messenger.foundation.a.a.c wT = a.abC().abD().wT();
        auVar.setContent(str2);
        switch (ehVar.jOc) {
            case 50:
                auVar.dv(6);
                break;
        }
        if (auVar.field_msgId == 0) {
            d.i(auVar);
        } else {
            wT.b(ehVar.tfk, auVar);
        }
        return 0;
    }
}
