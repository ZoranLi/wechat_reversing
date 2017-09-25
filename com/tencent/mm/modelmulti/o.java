package com.tencent.mm.modelmulti;

import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.storage.au;

public final class o implements com.tencent.mm.plugin.messenger.foundation.a.o {
    private final a hLv = new a();
    private f hLw;

    private static final class a extends com.tencent.mm.bn.a<k> implements k {
        public final void a(final alq com_tencent_mm_protocal_c_alq, final au auVar) {
            a(new com.tencent.mm.bn.a.a<k>(this) {
                final /* synthetic */ a hLy;

                public final /* synthetic */ void ao(Object obj) {
                    ((k) obj).a(com_tencent_mm_protocal_c_alq, auVar);
                }
            });
        }
    }

    public final String s(au auVar) {
        if (this.hLw != null) {
            return this.hLw.s(auVar);
        }
        return null;
    }

    public final void a(k kVar) {
        this.hLv.bI(kVar);
    }

    public final void a(f fVar) {
        this.hLw = fVar;
    }

    public final k Hw() {
        return this.hLv;
    }
}
