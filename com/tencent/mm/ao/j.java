package com.tencent.mm.ao;

import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;

public final class j extends com.tencent.mm.sdk.e.j implements e {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS oplog2 ( id INTEGER PRIMARY KEY , inserTime long , cmdId int , buffer blob , reserved1 int , reserved2 long , reserved3 text , reserved4 text ) "};
    g hnH;

    public j(g gVar) {
        this.hnH = gVar;
    }

    public final boolean a(b bVar) {
        if (bVar == null) {
            return true;
        }
        if (this.hnH.delete("oplog2", "id= ? AND inserTime= ?", new String[]{bVar.id, bVar.hDC}) < 0) {
            return false;
        }
        return true;
    }
}
