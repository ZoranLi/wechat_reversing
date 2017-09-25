package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avo;
import com.tencent.mm.protocal.c.kw;
import com.tencent.mm.protocal.c.kx;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;

public final class m extends n {
    protected final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    protected final kx h(p pVar) {
        return (kx) ((b) pVar).hsk.hsr;
    }

    public m(int i) {
        avo com_tencent_mm_protocal_c_avo = new avo();
        com_tencent_mm_protocal_c_avo.jOc = i;
        this.sGi.clear();
        this.sGi.add(com_tencent_mm_protocal_c_avo);
    }

    protected final p bDA() {
        a aVar = new a();
        com.tencent.mm.bd.a kwVar = new kw();
        kwVar.trl.addAll(this.sGi);
        aVar.hsm = kwVar;
        aVar.hsn = new kx();
        aVar.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        aVar.hsl = 721;
        aVar.hso = 0;
        aVar.hsp = 0;
        return aVar.BE();
    }

    public final int getType() {
        return 721;
    }
}
