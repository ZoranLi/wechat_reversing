package com.tencent.mm.ap;

import com.tencent.mm.e.a.bz;
import com.tencent.mm.e.a.rd;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    public Map<Integer, Object<?>> hOm = new ConcurrentHashMap();
    public c hOn = new c<rd>(this) {
        final /* synthetic */ l hOp;

        {
            this.hOp = r2;
            this.usg = rd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.hOp.hOm.get(Integer.valueOf(((rd) bVar).fYf.fFz));
            return false;
        }
    };
    public c hOo = new c<bz>(this) {
        final /* synthetic */ l hOp;

        {
            this.hOp = r2;
            this.usg = bz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.hOp.hOm.get(Integer.valueOf(((bz) bVar).fFy.fFz));
            return false;
        }
    };
}
