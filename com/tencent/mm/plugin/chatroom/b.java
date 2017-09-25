package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.bj.g;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.storage.r;
import com.tencent.mm.u.aa;
import java.util.HashMap;

public final class b implements a, d, com.tencent.mm.kernel.c.a, com.tencent.mm.plugin.chatroom.b.a {
    private r ksp;

    public final /* bridge */ /* synthetic */ aa xa() {
        return this.ksp;
    }

    public final aa c(g gVar) {
        return new r(gVar);
    }

    public final void onDataBaseOpened(g gVar, g gVar2) {
        this.ksp = new r(gVar);
    }

    public final void onDataBaseClosed(g gVar, g gVar2) {
    }

    public final HashMap<Integer, c> collectDatabaseFactory() {
        HashMap<Integer, c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("CHATROOM_MEMBERS_TABLE".hashCode()), new c(this) {
            final /* synthetic */ b ksq;

            {
                this.ksq = r1;
            }

            public final String[] pP() {
                return r.gUx;
            }
        });
        return hashMap;
    }
}
