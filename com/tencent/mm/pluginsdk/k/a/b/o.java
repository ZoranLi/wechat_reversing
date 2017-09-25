package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.kernel.h;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.q.b;
import com.tencent.mm.y.i;

public final class o extends n {

    private static class a extends i {
        final com.tencent.mm.protocal.q.a sGm = new com.tencent.mm.protocal.q.a();
        public final b sGn = new b();

        protected final d zf() {
            return this.sGm;
        }

        public final int getType() {
            return 722;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/encryptcheckresupdate";
        }

        public final e zg() {
            return this.sGn;
        }

        public final int BD() {
            return 1;
        }
    }

    public static void acH() {
        h.vH().gXC.a(new o(), 0);
    }

    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneEncryptCheckResUpdate";
    }

    protected final kx h(p pVar) {
        return ((a) pVar).sGn.sZT;
    }

    public final int getType() {
        return 722;
    }

    protected final p bDA() {
        p aVar = new a();
        com.tencent.mm.protocal.q.a aVar2 = aVar.sGm;
        aVar2.dj(0);
        aVar2.sZQ.tvJ.tvH.trl.addAll(this.sGi);
        return aVar;
    }
}
