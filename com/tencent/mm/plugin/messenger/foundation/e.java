package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.az;

public final class e implements i {
    public final ar d(g gVar) {
        return new ad(gVar);
    }

    public final as e(g gVar) {
        return new af(gVar);
    }

    public final c a(g gVar, ar arVar, as asVar) {
        return new av(gVar, arVar, asVar);
    }

    public final f f(g gVar) {
        return new az(gVar);
    }
}
